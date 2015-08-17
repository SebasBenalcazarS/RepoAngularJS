/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.archivo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.collections.CollectionUtils;

import com.enterprisedt.net.ftp.FTPException;

import ec.com.kruger.utilitario.dao.commons.annotations.RelationField.JoinType;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utils.ftp.FtpManager;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.ProcesoConfiguracionDTO;
import ec.com.smx.corpv2.dto.ProcesoServidorDTO;
import ec.com.smx.corpv2.dto.ServidorAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.ServidorDTO;
import ec.com.smx.framework.common.util.ConverterUtil;
import ec.com.smx.sic.articulo.util.ResizeUtil;
import ec.com.smx.sic.articulo.util.ResizeUtil.Method;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICUtil;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloValidacion;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.archivo.IArticuloArchivoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.archivo.calculo.ICalculoArchivoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;
import ec.com.smx.sic.cliente.resources.recargacupon.RecargaCuponMessages;
/**
 * @author fmunoz
 *
 */

public class ArticuloArchivoGestor implements IArticuloArchivoGestor{


	private DataGestor dataGestor;

	private ICalculoArchivoGestor calculoArchivoGestor;
	/**
	 * 
	 * @param articuloDefinicionArchivoDTO
	 * @throws SICException
	 */
	public void registrarArticuloArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO)throws SICException{
		Map<String, Object> relations = null;
		ArticuloArchivoDTO aa;
		try{
			Boolean crearArchivo = articuloDefinicionArchivoDTO.getId().getCodigoArchivo() == null;
			calculoArchivoGestor.asignarCamposArticuloArchivo(articuloDefinicionArchivoDTO);
			if(crearArchivo && !articuloDefinicionArchivoDTO.getTieneArticuloArchivo() || ( articuloDefinicionArchivoDTO.getTieneArticuloArchivo() && articuloDefinicionArchivoDTO.getArticuloArchivo().getContenidoArchivo() == null)){
				throw new SICException("Debe especificar el contenido del archivo para el art\u00EDculo");
			}
			//se borran las relaciones
			relations = SICUtil.getInstance().clearRelations(articuloDefinicionArchivoDTO);

			if(crearArchivo){
				articuloDefinicionArchivoDTO.addDynamicProperty(SICConstantes.EVENTO_INSERTAR, Boolean.TRUE);
				dataGestor.create(articuloDefinicionArchivoDTO);
			}else{
				dataGestor.update(articuloDefinicionArchivoDTO);
			}

			aa = (ArticuloArchivoDTO)relations.get("articuloArchivo");

			if(aa != null && SearchDTO.isLoaded(aa)){
				dataGestor.detach(aa);
				aa.setId(articuloDefinicionArchivoDTO.getId());
				if(crearArchivo){
					dataGestor.create(aa);
				}else{
					dataGestor.update(aa);
				}
			}

		}catch (SICException e) {
			throw e;
		}catch (Exception e) {
			throw new SICException(SICArticuloValidacion.getInstancia().MENSAJE_ERROR_REGISTRAR_ARTICULO_ARCHIVO, e);
		}finally{
			SICUtil.getInstance().restoreRelations(articuloDefinicionArchivoDTO, relations);
			relations = null;
		}

	}

	public Collection<ArticuloDefinicionArchivoDTO> obtenerArticuloDefinicionArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO){
		if( articuloDefinicionArchivoDTO != null )
			return this.dataGestor.findObjects(articuloDefinicionArchivoDTO);

		return null;
	}

	/**
	 * Metodo que consulta los parametros con los tamanos de las imagenes
	 * @param codigoParametros
	 * @return
	 * @throws SICException
	 */
	private Collection<ParametroDTO> consultaParametrosImagenes(String[] codigoParametros)throws SICException{
		if(codigoParametros== null){
			throw new SICException("se requiere codigoParametros");
		}
		ParametroDTO parametroDTO = new ParametroDTO();
		parametroDTO.addCriteriaSearchParameter("id.codigoParametro",ComparatorTypeEnum.IN_COMPARATOR, codigoParametros);
		Collection<ParametroDTO> parametroDTOs = new ArrayList<ParametroDTO>();
		parametroDTOs = dataGestor.findObjects(parametroDTO);
		return parametroDTOs;
	}
	/**
	 * Envia las imagenes de los cupones por FTP
	 * @param imagenes
	 * @param parametrosImagenes
	 */
	private void enviarPorFTPImagenesCupones(Collection<String> imagenes, Collection<ParametroDTO> parametrosImagenes, String directorioImagenes)throws SICException{
		Logeable.LOG_SICV2.info(":...Inicio metodo enviar imagenes por FTP...:");
		try {
			ProcesoConfiguracionDTO procesoConfiguracionDTO = this.obtenerProcesoConfiguracionImagenes();
			String pathLocal = directorioImagenes;
			FtpManager ftpManager = new FtpManager();
			for (String imagenCupon : imagenes) {
				for (ParametroDTO parametroDTO : parametrosImagenes) {
					String rutaImagenLocal = pathLocal + File.separator + parametroDTO.getValorParametro();
					String rutaImagenRemota = "/" + parametroDTO.getValorParametro();
					ftpManager.sendFile(procesoConfiguracionDTO, rutaImagenLocal, imagenCupon, rutaImagenRemota, imagenCupon);
				}
			}
			Logeable.LOG_SICV2.info(":...Fin metodo enviar imagenes por FTP...:");
		} catch (IOException e) {
			Logeable.LOG_SICV2.error("Error al enviar imagenes por ftp",e);
			throw new SICException("Error al enviar imagenes por ftp");
		} catch (FTPException e) {
			Logeable.LOG_SICV2.error("Error al enviar imagenes por ftp",e);
			throw new SICException("Error al enviar imagenes por ftp");
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al enviar imagenes por ftp",e);
			throw new SICException("Error al enviar imagenes por ftp");
		}
	}
	/**
	 * Obtiene el procesoConfiguracion para el env�o por FTP de imagenes de cupones
	 */
	private ProcesoConfiguracionDTO obtenerProcesoConfiguracionImagenes()throws SICException{
		AreaTrabajoDTO areaTrabajoDTO = new AreaTrabajoDTO();
		areaTrabajoDTO.setJoinType(JoinType.INNER);
		areaTrabajoDTO.setEstadoAreaTrabajo(SICConstantes.ESTADO_ACTIVO_LITERAL);
		ServidorAreaTrabajoDTO servidorAreaTrabajoDTO = new ServidorAreaTrabajoDTO();
		servidorAreaTrabajoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		servidorAreaTrabajoDTO.setAreaTrabajoDTO(areaTrabajoDTO);
		ServidorDTO servidorDTODestino = new ServidorDTO();
		servidorDTODestino.setJoinType(JoinType.INNER);
		servidorDTODestino.setLstServidorAreaTrabajoDTOs(new HashSet<ServidorAreaTrabajoDTO>());
		servidorDTODestino.getLstServidorAreaTrabajoDTOs().add(servidorAreaTrabajoDTO);		
		ProcesoServidorDTO procesoServidorOrigen = new ProcesoServidorDTO();
		procesoServidorOrigen.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		procesoServidorOrigen.setCodigoProceso(Long.valueOf(RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.imagenes.cupones.codigo.proceso.envio")));
		procesoServidorOrigen.setJoinType(JoinType.INNER);
		ProcesoServidorDTO procesoServidorDestino = new ProcesoServidorDTO();
		procesoServidorDestino.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		procesoServidorDestino.setServidorDTO(servidorDTODestino);
		procesoServidorDestino.setJoinType(JoinType.INNER);
		ProcesoConfiguracionDTO procesoConfiguracionBusqueda = new ProcesoConfiguracionDTO();
		procesoConfiguracionBusqueda.getId().setCodigoCompania(1);
		procesoConfiguracionBusqueda.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		procesoConfiguracionBusqueda.setProcesoServidorOrigenDTO(procesoServidorOrigen);
		procesoConfiguracionBusqueda.setProcesoServidorDestinoDTO(procesoServidorDestino);
		ProcesoConfiguracionDTO procesoConfiguracionDTOBusqueda = SICFactory.getInstancia().administracion.getDataService().findUnique(procesoConfiguracionBusqueda);
		procesoConfiguracionBusqueda = null;
		servidorDTODestino = null;
		servidorAreaTrabajoDTO =null;
		procesoServidorOrigen=null;
		procesoServidorDestino=null;
		return procesoConfiguracionDTOBusqueda;
	}
	/**
	 * M�todo que redimensiona imagenes con la altura y ancho que se definan
	 * @param datoImagen
	 * @param width
	 * @param heigth
	 * @param sizeVal
	 * @param imageName
	 * @throws IOException
	 */
	public String redimensionaImagen(byte[] datoImagen,int width, int heigth, String sizeVal, String imageName, String directorio) throws IOException{
		InputStream imagenIn = new ByteArrayInputStream(datoImagen);
		BufferedImage imagenOriginal = ImageIO.read(imagenIn);
		BufferedImage imageResize = ResizeUtil.resize(imagenOriginal,Method.QUALITY,width,heigth,null);
		File rutaImagen = new File(directorio + File.separator + sizeVal);
		String[] nombreImagen = imageName.split("\\.");
		String nombreImagenFinal = nombreImagen[0]+"."+"png"; 
		if(!rutaImagen.exists()){
			rutaImagen.mkdirs();
		}
		ImageIO.write(imageResize, "png", new File(rutaImagen + File.separator +nombreImagenFinal));
		return nombreImagenFinal;
	}
	/**
	 * Redimenciona imagenes y las envia por FTP
	 */
	@Override
	public void procesoRedimensionarImagenFTP(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO) throws SICException {
		if(articuloDefinicionArchivoDTO!=null && articuloDefinicionArchivoDTO.getArticuloArchivo()!=null){
			String directorioBase = RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.imagenes.resize.path");
			Date fecha = ConverterUtil.getCurrentTruncDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat(RecargaCuponMessages.getInstancia().getString("ec.com.smx.recargacupones.fecha.formato.anioMesDia"));
			String directorioArchivoImagen = directorioBase + File.separator + dateFormat.format(fecha);
			String [] codigoParametros=	new String[]{
					SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.cupon.imagen.tamanio.small"),
					SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.cupon.imagen.tamanio.normal"),
					SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.cupon.imagen.tamanio.large"),
					SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.cupon.imagen.tamanio.xlarge"),
					SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.cupon.imagen.tamanio.xxlarge")};
			//Llama al metodo que consulta los parametros con el tamano de las imagenes
			Collection<ParametroDTO> parametrosImagenes =  consultaParametrosImagenes(codigoParametros);
			Collection<String> nombresImagenes = new ArrayList<String>();
			for (ParametroDTO parametroDTO : parametrosImagenes) {
				String[] tamanoImagenes = parametroDTO.getDescripcionParametro().split("-");
				String parametroImagen = tamanoImagenes[1];
				String[] tamanoImagenFinal = parametroImagen.split("x");
				int width = Integer.parseInt(tamanoImagenFinal[0]);
				int height = Integer.parseInt(tamanoImagenFinal[1]);
				String sizeVal = parametroDTO.getValorParametro();
				String imageName= articuloDefinicionArchivoDTO.getNombreArchivo().replace("\\s","").replace(" ", "");
				//Elimina acentos 
				imageName = Normalizer.normalize(imageName, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
				try {
					String nombreImagenFinal=redimensionaImagen(articuloDefinicionArchivoDTO.getArticuloArchivo().getContenidoArchivo(), width,height,sizeVal, imageName, directorioArchivoImagen);
					nombresImagenes.add(nombreImagenFinal);
				} catch (IOException e) {
					Logeable.LOG_SICV2.error(e.getMessage());
				}
			}
			if(CollectionUtils.isNotEmpty(nombresImagenes) || CollectionUtils.isNotEmpty(parametrosImagenes)){
				enviarPorFTPImagenesCupones(nombresImagenes, parametrosImagenes, directorioArchivoImagen);	
			}
		}
	}
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	public void setCalculoArchivoGestor(ICalculoArchivoGestor calculoArchivoGestor) {
		this.calculoArchivoGestor = calculoArchivoGestor;
	}
}
