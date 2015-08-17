/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.edicion;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.keyvalue.MultiKey;
import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.lang3.StringUtils;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.framework.common.util.ManejoFechas;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.mensajeria.commons.resources.MensajeriaMessages;
import ec.com.smx.mensajeria.commons.util.ConstantesSMS;
import ec.com.smx.mensajeria.dto.EventoDTO;
import ec.com.smx.mensajeria.dto.id.EventoID;
import ec.com.smx.mensajeria.estructura.MailMensajeEST;
import ec.com.smx.mensajeria.gestor.MensajeriaG;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.EnumCreacionPorArchivoCabecera;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloEdicionMasivaGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IArticuloEdicionArchivoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloEdicionArchivoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.clase.IArticuloClaseGestor;
import ec.com.smx.sic.cliente.gestor.articulo.ley.podermercado.IArticuloLeyMercadoGestor;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloClaseDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloRegistroMasivoDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloEdicionArchivoDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * @author eharo
 *
 */
public class ArticuloEdicionArchivoGestor implements IArticuloEdicionArchivoGestor, Logeable{

	IValidacionArticuloEdicionArchivoGestor validacionArticuloEdicionArchivoGestor;
	IArticuloEdicionArchivoDAO articuloEdicionArchivoDAO;
	IArticuloRegistroMasivoDAO articuloRegistroMasivoDAO;
	IArticuloClaseGestor articuloClaseGestor;
	MensajeriaG mensajeriaG;
	private IArticuloLeyMercadoGestor articuloLeyMercadoGestor;
	private IArticuloEdicionMasivaGestor articuloEdicionMasivaGestor;
	

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IArticuloEdicionArchivoGestor#procesarArchivoEdicionArticulo(ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO, java.io.InputStream, java.lang.Integer)
	 */
	@Override
	public Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> procesarArchivoEdicionArticulo(ArticuloVO articuloVO, ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, InputStream inputStreamArchivo, Integer tipoCabeceras) throws SICException {
		Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidos = null;
		try{
			
			datosValidos = this.validacionArticuloEdicionArchivoGestor.procesarArchivoEdicionArticulo(articuloVO, articuloEdicionMasivaArchivoVO, inputStreamArchivo, tipoCabeceras);
			
		}catch(Exception e){
			LOG_SICV2.error(e.getMessage());
			throw new SICException(e.getMessage());
		}
		return datosValidos;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IArticuloEdicionArchivoGestor#realizarEdicionArticuloPorArchivo(ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO, ec.com.smx.framework.common.util.dto.Duplex, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void realizarEdicionArticuloPorArchivo(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidos, String nombreArchivo) throws SICException {
		ArticuloEdicionMasivaArchivoVO articuloParaEdicion = null;
		Set<MultiKey> keys = null;
		Set<Integer> keyListas = null;
		Collection<Integer> keyLista = null;
		Set<Integer> keyListaNoValidos = null;
		Set<Integer> keyListaValidos = null;
		String fechaCreacion = ManejoFechas.convertDateAsString("yyyy-MM-dd HH:mm:ss", new Date());
		Integer editado = 0;
		try{
			if(MapUtils.isNotEmpty(datosValidos.getSecondObject())){
				LOG_SICV2.info("==> Inicio Registro Articulo Por Archivo");
				keys = new HashSet<MultiKey>();
				keyListas = new HashSet<Integer>();
				keyLista = new ArrayList<Integer>();
				keyListaNoValidos = new HashSet<Integer>();
				keyListaValidos = new HashSet<Integer>();
				keys = datosValidos.getSecondObject().keySet();
				for(MultiKey key : keys){
					keyListas.add((Integer) key.getKey(0));
				}
				for(Integer valor: keyListas){
					keyLista.add(valor);
				}
				keyLista = ColeccionesUtil.sort(keyListas, ColeccionesUtil.ORDEN_ASC);
				for(Integer key : keyLista){
					try{
						LOG_SICV2.info("Numero de articulo: " + key);
//						articuloParaEdicion = SICFactory.getInstancia().articulo.getArticuloService().obtnerArticuloEdicionMasivaVO(articuloEdicionMasivaArchivoVO, key, datosValidos.getSecondObject());
						articuloParaEdicion = SICFactory.getInstancia().articulo.getArticuloMasivoServicio().obtnerArticuloEdicionMasivaVO(articuloEdicionMasivaArchivoVO, key, datosValidos.getSecondObject());
						if(articuloParaEdicion != null){
//							SICFactory.getInstancia().articulo.getArticuloService().editarArticuloArchivo(articuloParaEdicion);
							SICFactory.getInstancia().articulo.getArticuloMasivoServicio().editarArticuloArchivo(articuloParaEdicion);
//							Logeable.LOG_SICV2.info(articuloParaEdicion.getCodigoArticulo());
						}
						if(editado == 1){
							LOG_SICV2.info("El articulo " + articuloEdicionMasivaArchivoVO.getCodigoArticulo() + " se ha editado con exito.");
						}
						keyListaValidos.add(Integer.valueOf(String.valueOf(key)));
					}catch(Exception e){
						LOG_SICV2.error(">>>>>>>> Error al crear articulo {}", e.getMessage());
						keyListaNoValidos.add(Integer.valueOf(String.valueOf(key)));
					}
				}
				LOG_SICV2.info("Numero de articulos con errores: "+keyListaNoValidos.size());
			}
		}catch(SICException e){
			throw e;
		}catch (Exception e) {
			throw new SICException(e.getMessage());
		}finally{
//			SICFactory.getInstancia().articulo.getArticuloService().envioMailEdicionArticuloPorArchivo(articuloEdicionMasivaArchivoVO.getCodigoCompania(), articuloEdicionMasivaArchivoVO.getUsuarioModificacion(), keyListaNoValidos, keyListaValidos.size(), fechaCreacion, nombreArchivo);
			SICFactory.getInstancia().articulo.getArticuloMasivoServicio().envioMailEdicionArticuloPorArchivo(articuloEdicionMasivaArchivoVO.getCodigoCompania(), articuloEdicionMasivaArchivoVO.getUsuarioModificacion(), keyListaNoValidos, keyListaValidos.size(), fechaCreacion, nombreArchivo);
			keys = null;
			keyLista = null;
			keyListaNoValidos = null;
			keyListaValidos = null;
		}
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IArticuloEdicionArchivoGestor#editarArticuloArchivo(ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO)
	 */
	@Override
	public Integer editarArticuloArchivo(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO) throws SICException {
		Integer editado = 0;
		try{
			this.articuloEdicionArchivoDAO.editarClaseArticulo(articuloEdicionMasivaArchivoVO);
			this.registrarEstadoArticuloLeyMercado(articuloEdicionMasivaArchivoVO);
			this.registrarArticuloClase(articuloEdicionMasivaArchivoVO);
			this.articuloRegistroMasivoDAO.registrarArticuloPendienteIntegracion(articuloEdicionMasivaArchivoVO.getCodigoCompania(), articuloEdicionMasivaArchivoVO.getCodigoArticulo(), articuloEdicionMasivaArchivoVO.getUsuarioModificacion(), TipoCatalogoArticulo.PROCESO_INTEGRACION_ACTUALIZACIONARTICULOSPORARCHIVO);
			this.articuloEdicionMasivaGestor.registrarAuditoriaExtendida(articuloEdicionMasivaArchivoVO.getCodigoCompania(), articuloEdicionMasivaArchivoVO.getCodigoArticulo(), SICConstantes.getInstancia().CODIGO_SISTEMA_MAX, SICArticuloConstantes.getInstancia().CODIGO_OPCION_ACTUALIZACION_ARCHIVO);
		}catch(Exception e){
			LOG_SICV2.error(e.getMessage());
			throw new SICException("Ha ocurrido un error al editar la clase del articulo: ", e);			
		}
		return editado;
	}
	
	public void registrarEstadoArticuloLeyMercado(ArticuloEdicionMasivaArchivoVO articulo) throws SICException{
		try{
			if(articulo != null && (StringUtils.equals(articulo.getClase(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O))){
				Integer codigoTipoCausal = null;
				if (StringUtils.equals(articulo.getClase(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_E)) {
					codigoTipoCausal = TipoCatalogoArticulo.TIPO_CAUSALES_ARTICULO_CLASE_E;
				} else if (StringUtils.equals(articulo.getClase(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O)) {
					codigoTipoCausal = TipoCatalogoArticulo.TIPO_CAUSALES_ARTICULO_CLASE_O;
				} else if (StringUtils.equals(articulo.getClase(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_I)) {
					codigoTipoCausal = TipoCatalogoArticulo.TIPO_CAUSALES_ARTICULO_CLASE_I;
				}
				this.articuloLeyMercadoGestor.descodificarArticuloLeyMercado(articulo.getCodigoCompania(), articulo.getCodigoArticulo(), articulo.getUsuarioModificacion(), codigoTipoCausal, articulo.getCausalCambioClase());				
			}
			//Esto e debe implemetar cuando se den de baja a productos
			if(articulo != null && StringUtils.equals(articulo.getClaseAnterior(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O)	&& !StringUtils.equals(articulo.getClase(), SICArticuloConstantes.CODIGO_CLASE_ARTICULO_O)){
				this.articuloLeyMercadoGestor.reactivarArticuloLeyMercado(articulo.getCodigoCompania(), articulo.getCodigoArticulo(), articulo.getUsuarioModificacion());
			}
		}catch(SICException e){
			throw new SICException("Ha ocurrido un error al registrar EstadoArticuloLeyMercado", e);
		}
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IArticuloEdicionArchivoGestor#obtnerArticuloEdicionMasivaVO(ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO, java.lang.Integer, org.apache.commons.collections.map.MultiKeyMap)
	 */
	@Override
	public ArticuloEdicionMasivaArchivoVO obtnerArticuloEdicionMasivaVO(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, Integer key, MultiKeyMap datosListaValidos) throws SICException {
		ArticuloEdicionMasivaArchivoVO articuloEdicion = null;
		try{
			LOG_SICV2.info(">>>>>>>>>>>>>>>ASIGNAR LOS VALORES DEL MAPA AL ARTICULO EDICION VO<<<<<<<<<<<<<<<<<");
			if(key != null && datosListaValidos != null){
				Integer codigoCompania = articuloEdicionMasivaArchivoVO.getCodigoCompania();
				String codigoBarras = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_CODIGO_BARRAS.getNombreFormato());
				String clase = (String) datosListaValidos.get(key, EnumCreacionPorArchivoCabecera.CABECERA_CLASE.getNombreFormato());
				String fechaInicioTemporada = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_FECHA_INICIO_TEMPORADA.getNombreFormato());
				String fechaFinTemporada = (String) datosListaValidos.get(key,EnumCreacionPorArchivoCabecera.CABECERA_FECHA_FIN_TEMPORADA.getNombreFormato());
				String usuarioModificacion = articuloEdicionMasivaArchivoVO.getUsuarioModificacion();
				String codigoArticulo = this.validacionArticuloEdicionArchivoGestor.obtenerCodigoArticuloDesdeCodigoBarras(codigoCompania, codigoBarras);
				String claseAnterior = this.articuloEdicionArchivoDAO.obtenerClaseAnteriorArticulo(codigoCompania, codigoArticulo);
				String causalCambioClase = (String) datosListaValidos.get(key, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CAUSAL);
				Timestamp fechaActual = new Timestamp(Calendar.getInstance().getTimeInMillis());
				
				articuloEdicion = new ArticuloEdicionMasivaArchivoVO();
				
				articuloEdicion.setCodigoCompania(codigoCompania);
				articuloEdicion.setClase(clase);
				articuloEdicion.setClaseAnterior(claseAnterior);
				articuloEdicion.setCodigoArticulo(codigoArticulo);
				if(StringUtils.equals(clase, SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.temporada"))){
					articuloEdicion.setFechaInicioTemporada(fechaInicioTemporada);
					articuloEdicion.setFechaFinTemporada(fechaFinTemporada);
				}
				articuloEdicion.setUsuarioModificacion(usuarioModificacion);
				articuloEdicion.setFechaModificacion(fechaActual);
				articuloEdicion.setCausalCambioClase(causalCambioClase);
			}
		}catch(SICException e){
			throw e;
		}catch (Exception e) {
			LOG_SICV2.error("Error al obtener los datos del articulo para edicion. {}",e.getMessage());
			throw new SICException(e.getMessage());
		}
		return articuloEdicion;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IArticuloEdicionArchivoGestor#envioMailCreacionArticuloPorArchivo(java.lang.Integer, java.lang.String, java.util.Set, java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public void envioMailEdicionArticuloPorArchivo(Integer codigoCompania, String userId, Set<Integer> articulosNoRegistrados, Integer totalArticulosRegistrados, String fechaCreacion, String nombreArchivo) throws SICException {
		UserDto userDto = null;
		try{
			if(StringUtils.isNotEmpty(StringUtils.trim(userId))){
				userDto = this.articuloEdicionArchivoDAO.obtenerUsuario(userId); 
				//Validar el usuario
				if(userDto == null || StringUtils.isBlank(userDto.getUserEmail())){
					throw new SICException("El usuario no posee mail, verifique por favor. ");
				}
				
				EventoID eventoID = new EventoID();
				eventoID.setCodigoEvento(SICConstantes.CODIGO_EVENTOID_MAIL_EDICION_ARTICULOS_POR_ARCHIVO);
				eventoID.setSystemId(SICConstantes.CODIGO_SISTEMA_MAX);
				eventoID.setCompanyId(codigoCompania);		
				enviarMail(eventoID, new String[]{userDto.getUserEmail()},userDto.getUserCompleteName(),null, "Edici\u00F3n de art\u00EDculos por archivo excel", articulosNoRegistrados, totalArticulosRegistrados, fechaCreacion, nombreArchivo);
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al enviar el email, con los datos de edicion. {}", e.getMessage());
		}
		
	}
	
	
	/**
	 * METODO PARA ENVIAR EL MENSAJE AL FINALIZAR LA ACTUALIZACION
	 * @param eventoID
	 * @param para
	 * @param userRecipient
	 * @param cc
	 * @param asunto
	 * @param articulosNoRegistrados
	 * @param totalArticulosRegistrados
	 * @param fechaCreacion
	 * @param nombreArchivo
	 * @throws SICException
	 */
	private void enviarMail(EventoID eventoID, String para[],String userRecipient, String[] cc, String asunto, Set<Integer> articulosNoRegistrados, Integer totalArticulosRegistrados, String fechaCreacion, String nombreArchivo) throws SICException {
		try {			
			EventoDTO eventoDTO = mensajeriaG.obtenerEventoPorID(eventoID);
			LOG_SICV2.info("El evento es: {}",eventoDTO.getAsuntoEvento());			
			MailMensajeEST mailMensajeEST = new MailMensajeEST();
			mailMensajeEST.setPara(para);
			mailMensajeEST.setCc(cc);
			mailMensajeEST.setCco(cc);
			mailMensajeEST.setAsunto(asunto);
			mailMensajeEST.setMensajeXML(obtenerXMLMensaje(userRecipient, articulosNoRegistrados, totalArticulosRegistrados, fechaCreacion, nombreArchivo));
			mailMensajeEST.setEventoDTO(eventoDTO);
			mailMensajeEST.setHost(MensajeriaMessages.getString("mail.serverHost"));
			mailMensajeEST.setPuerto(MensajeriaMessages.getString("mail.puerto"));
			mailMensajeEST.setFormatoHTML(true);

			mensajeriaG.envioMail(mailMensajeEST, ConstantesSMS.BORRAR_ARCHIVOS_NO);
		} catch (Exception e) {
			LOG_SICV2.error("Error en el metodo enviarMail",e);
			throw new SICException("Error al enviar mail {}",e);
		}
	}
	
	
	/**
	 * METODO PARA OBTENER EL XML QUE SE VA A ENVIAR COMO PLANTILLA PARA EL MENSAJE
	 * @param para
	 * @param articulosNoRegistrados
	 * @param totalArticulosRegistrados
	 * @param fechaCreacion
	 * @param nombreArchivo
	 * @return
	 */
	private String obtenerXMLMensaje(String para, Set<Integer> articulosNoRegistrados, Integer totalArticulosRegistrados, String fechaCreacion, String nombreArchivo){
		StringBuilder mensajeXML = new StringBuilder();
		mensajeXML.append("<?xml version='1.0' encoding='UTF-8'?>");
		mensajeXML.append("<mensaje>");
		mensajeXML.append("<para>"+para+"</para>");
		if(articulosNoRegistrados.size() > 0 && totalArticulosRegistrados == 0){
			mensajeXML.append("<mensajeTexto>no se actualizaron correctamente. A continuaci\u00F3n puede observar los detalles del proceso de actualizaci\u00F3n por archivo excel.</mensajeTexto>");
		}else if(articulosNoRegistrados.size() == 0 && totalArticulosRegistrados > 0){
			mensajeXML.append("<mensajeTexto>se actualizaron correctamente. A continuaci\u00F3n puede observar los detalles del proceso de actualizaci\u00F3n por archivo excel. </mensajeTexto>");
		}else if(articulosNoRegistrados.size() > 0 && totalArticulosRegistrados > 0){
			mensajeXML.append("<mensajeTexto> no fueron actualizados en su totalidad. A continuaci\u00F3n puede observar los detalles del proceso de actualizaci\u00F3n por archivo excel.</mensajeTexto>");
		}
		mensajeXML.append("<fechaCreacion> Fecha actualizaci\u00F3n: "+fechaCreacion+"</fechaCreacion>");
		mensajeXML.append("<nombreArchivo> Nombre archivo: "+nombreArchivo+"</nombreArchivo>");
		if(totalArticulosRegistrados > 0){
			mensajeXML.append("<textoFilaCorrecto>Total de art\u00EDculos actualizados: " + totalArticulosRegistrados + " </textoFilaCorrecto>");
		}
		if(CollectionUtils.isNotEmpty(articulosNoRegistrados)){
			mensajeXML.append("<textoFilaIncorrecto>Filas del archivo no actualizadas</textoFilaIncorrecto>");
			for(Integer fila:articulosNoRegistrados){
				mensajeXML.append("<articulosInc>");
				mensajeXML.append("<tituloFilaIncorrecto>No. Fila</tituloFilaIncorrecto>");
				mensajeXML.append("<articuloInc>");
				mensajeXML.append("<fila>"+fila+"</fila>");
				mensajeXML.append("</articuloInc>");
				mensajeXML.append("</articulosInc>");
			}
		}
		mensajeXML.append("</mensaje>");
		return mensajeXML.toString();
	}
	
	/**
	 * METODO QUE REGISTRA LA CLASE DE LOS ARTICULO VALIDOS
	 * @param articuloEdicionMasivaArchivoVO
	 * @throws SICException
	 */
	private void registrarArticuloClase(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO) throws SICException {
		ArticuloClaseDTO articuloClaseDTO = null;
		try {
			if(articuloEdicionMasivaArchivoVO != null){
				
				articuloClaseDTO = this.articuloClaseGestor.obtenerArticuloClase(articuloEdicionMasivaArchivoVO.getCodigoCompania(), articuloEdicionMasivaArchivoVO.getCodigoArticulo());
				
				if(articuloClaseDTO != null){
					
					agregarCamposArticuloClase(articuloClaseDTO, articuloEdicionMasivaArchivoVO);
					this.articuloClaseGestor.registrarArticuloClase(articuloClaseDTO);
					
				}else{
					
					articuloClaseDTO = new ArticuloClaseDTO();
					articuloClaseDTO.getId().setCodigoCompania(articuloEdicionMasivaArchivoVO.getCodigoCompania());
					articuloClaseDTO.getId().setCodigoArticulo(articuloEdicionMasivaArchivoVO.getCodigoArticulo());
					
					agregarCamposArticuloClase(articuloClaseDTO, articuloEdicionMasivaArchivoVO);
					
					this.articuloClaseGestor.registrarArticuloClase(articuloClaseDTO);
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error(e.getMessage());
		}finally{
			articuloClaseDTO = null;
		}
	}
	
	/**
	 * @param articuloClaseDTO
	 * @param articuloEdicionMasivaArchivoVO
	 */
	private void agregarCamposArticuloClase(ArticuloClaseDTO articuloClaseDTO, ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO){
		Timestamp timestamp = null;
		timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
		if(articuloClaseDTO != null && articuloEdicionMasivaArchivoVO != null){
			
			articuloClaseDTO.setClaseArticulo(articuloEdicionMasivaArchivoVO.getClase());
			articuloClaseDTO.setClaseArticuloAnterior(articuloEdicionMasivaArchivoVO.getClaseAnterior());
			articuloClaseDTO.setValorTipoCausal(articuloEdicionMasivaArchivoVO.getCausalCambioClase());
			if (StringUtils.equals(articuloEdicionMasivaArchivoVO.getClase(), SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_E)) {
				articuloClaseDTO.setCodigoTipoCausal(TipoCatalogoArticulo.TIPO_CAUSALES_ARTICULO_CLASE_E);
			} else if (StringUtils.equals(articuloEdicionMasivaArchivoVO.getClase(), SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_O)) {
				articuloClaseDTO.setCodigoTipoCausal(TipoCatalogoArticulo.TIPO_CAUSALES_ARTICULO_CLASE_O);
			} else if (StringUtils.equals(articuloEdicionMasivaArchivoVO.getClase(), SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_I)) {
				articuloClaseDTO.setCodigoTipoCausal(TipoCatalogoArticulo.TIPO_CAUSALES_ARTICULO_CLASE_I);
			}else{
				articuloClaseDTO.setCodigoTipoCausal(null);
			}
			articuloClaseDTO.setIdUsuarioCambioClase(articuloEdicionMasivaArchivoVO.getUsuarioModificacion());
			articuloClaseDTO.setFechaModificacion(timestamp);
			articuloClaseDTO.setUserId(articuloEdicionMasivaArchivoVO.getUsuarioModificacion());
			
		}
	}
	
	
	
	/******************************************************************************/
	/*********************SETTERS**************************************************/
	/******************************************************************************/
	
	
	/**
	 * @param articuloRegistroMasivoDAO the articuloRegistroMasivoDAO to set
	 */
	public void setArticuloRegistroMasivoDAO(IArticuloRegistroMasivoDAO articuloRegistroMasivoDAO) {
		this.articuloRegistroMasivoDAO = articuloRegistroMasivoDAO;
	}

	/**
	 * @param articuloEdicionArchivoDAO the articuloEdicionArchivoDAO to set
	 */
	public void setArticuloEdicionArchivoDAO(IArticuloEdicionArchivoDAO articuloEdicionArchivoDAO) {
		this.articuloEdicionArchivoDAO = articuloEdicionArchivoDAO;
	}

	/**
	 * @param mensajeriaG the mensajeriaG to set
	 */
	public void setMensajeriaG(MensajeriaG mensajeriaG) {
		this.mensajeriaG = mensajeriaG;
	}

	/**
	 * @param validacionArticuloEdicionArchivoGestor the validacionArticuloEdicionArchivoGestor to set
	 */
	public void setValidacionArticuloEdicionArchivoGestor(IValidacionArticuloEdicionArchivoGestor validacionArticuloEdicionArchivoGestor) {
		this.validacionArticuloEdicionArchivoGestor = validacionArticuloEdicionArchivoGestor;
	}
	
	/**
	 * @param articuloClaseGestor the articuloClaseGestor to set
	 */
	public void setArticuloClaseGestor(IArticuloClaseGestor articuloClaseGestor) {
		this.articuloClaseGestor = articuloClaseGestor;
	}

	public void setArticuloLeyMercadoGestor(IArticuloLeyMercadoGestor articuloLeyMercadoGestor) {
		this.articuloLeyMercadoGestor = articuloLeyMercadoGestor;
	}

	public void setArticuloEdicionMasivaGestor(IArticuloEdicionMasivaGestor articuloEdicionMasivaGestor) {
		this.articuloEdicionMasivaGestor = articuloEdicionMasivaGestor;
	}
}