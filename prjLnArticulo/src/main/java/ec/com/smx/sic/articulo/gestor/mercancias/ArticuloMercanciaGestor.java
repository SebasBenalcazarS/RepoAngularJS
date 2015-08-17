/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.mercancias;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang.StringUtils;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.etiquetado.exception.EtiquetadoException;
import ec.com.smx.framework.common.util.Util;
import ec.com.smx.generadorexportacion.dto.RecepcionDTO;
import ec.com.smx.generadorexportacion.dto.id.FormatoID;
import ec.com.smx.generadorexportacion.estructura.InfoRecepcionEST;
import ec.com.smx.generadorexportacion.exception.GeneradorExportacionException;
import ec.com.smx.generadorexportacion.listener.ImportacionListener;
import ec.com.smx.generadorexportacion.util.GeneradorExportacionService;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.mercancias.IArticuloMercanciaGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoCaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.ArticuloRangoExtensionGarantiaDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.GarantiaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.EtiquetaMercanciaVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.mercancias.IArticuloMercanciaDAO;

/**
 * @author eharo
 *
 */
public class ArticuloMercanciaGestor implements IArticuloMercanciaGestor, Logeable {
	IArticuloMercanciaDAO articuloMercanciaDAO;

	/**
	 * @param articuloMercanciaDAO the articuloMercanciaDAO to set
	 */
	public void setArticuloMercanciaDAO(IArticuloMercanciaDAO articuloMercanciaDAO) {
		this.articuloMercanciaDAO = articuloMercanciaDAO;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.mercancias.IArticuloMercanciaGestor#obtenerListaTipoCaracteristicas(java.lang.Integer)
	 */
	@Override
	public List<TipoCaracteristicaDTO> obtenerListaTipoCaracteristicas(Integer codigoCompania) throws SICException {
		return this.articuloMercanciaDAO.obtenerListaTipoCaracteristicas(codigoCompania);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.mercancias.IArticuloMercanciaGestor#obtenerListaCaracteristicas(java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override
	public List<CaracteristicaDTO> obtenerListaCaracteristicas(Integer codigoCompania, Collection<Integer> tipoCaracteristicaId, String codigoArticulo) throws SICException {
		return this.articuloMercanciaDAO.obtenerListaCaracteristicas(codigoCompania, tipoCaracteristicaId, codigoArticulo);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.mercancias.IArticuloMercanciaGestor#transEliminarCaracteristica(ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDTO)
	 */
	@Override
	public void transEliminarCaracteristica(String usuario, Set<CaracteristicaDTO> caracteristicasEliminar) throws SICException {
		this.articuloMercanciaDAO.transEliminarCaracteristica(usuario, caracteristicasEliminar);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.mercancias.IArticuloMercanciaGestor#transGuardarCaracteristicas(java.lang.String, java.util.List)
	 */
	@Override
	public void transGuardarCaracteristicas(String usuario, Collection<CaracteristicaDTO> lstCaracteristicas) throws SICException {
		this.articuloMercanciaDAO.transGuardarCaracteristicas(usuario, lstCaracteristicas);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<EtiquetaMercanciaVO> obtenerEtiquetaMercanciaMasivaPaginada(Integer first, Integer pageSize, Integer codigoCompania,Integer areaTrabajo, String codigoClasificacion, String promocion) throws SICException{
		try {
			Collection<String> codigoArticuloCol = new ArrayList<String>();
			codigoArticuloCol = this.articuloMercanciaDAO.obtenerArticuloPaginado(first, pageSize,codigoCompania, areaTrabajo, codigoClasificacion, promocion);
			//solo continuar en el caso de tener articulos
			if(codigoArticuloCol !=null &&CollectionUtils.isNotEmpty(codigoArticuloCol)){
				return this.obtenerEtiquetaCaracteristicaMasivaCol(codigoCompania, codigoArticuloCol, Boolean.FALSE, areaTrabajo, codigoClasificacion);
			}else{
				return null;
			}
		} catch (Exception e) {
			LOG_SICV2.error("error en consulta de articulo",e);
			throw new SICException(e);
		}
		
	}
	
	public Collection<EtiquetaMercanciaVO> obtenerEtiquetaCaracteristicaMasivaCol(Integer codigoCompania,Collection<String> codigoArtBarCol, Boolean esCodigoBarra, Integer areaTrabajoFuncionario,String codigoClasificacion) throws SICException{
		//solo continuar en el caso de tener articulos
		if(codigoArtBarCol !=null &&CollectionUtils.isNotEmpty(codigoArtBarCol)){
			Collection<EtiquetaMercanciaVO> etiquetaMercanciaVOCol = new ArrayList<EtiquetaMercanciaVO>();
			Collection<ArticuloDTO> articulosEncontrados = this.articuloMercanciaDAO.obtenerArticulosParaCaracteristicasMercancia(codigoCompania, codigoArtBarCol,esCodigoBarra,areaTrabajoFuncionario, codigoClasificacion);
			for (ArticuloDTO articuloDTOIterator : articulosEncontrados) {
				LOG_SICV2.info("En obtenerEtiquetaMercanciaCol: {}", articulosEncontrados.size());
				if(articuloDTOIterator.getTieneArticuloPrecio()){
					ArticuloPrecioDTO articuloPrecioBase = (ArticuloPrecioDTO) CollectionUtils.find(articuloDTOIterator.getArticuloPrecioCol(), new BeanPredicate("id.codigoTipoPrecio", PredicateUtils.equalPredicate(SICArticuloConstantes.TIPO_PRECIO_BASE)));
					if(articuloPrecioBase.getTieneArticuloLocalPrecio()){
						ArticuloLocalPrecioDTO articuloLocalPrecioBase = (ArticuloLocalPrecioDTO) CollectionUtils.find(articuloPrecioBase.getArticuloLocalPrecioCol(), new BeanPredicate("id.codigoTipoPrecio", PredicateUtils.equalPredicate(SICArticuloConstantes.TIPO_PRECIO_BASE)));
						if(articuloLocalPrecioBase != null){
							articuloPrecioBase.setNpArticuloLocalPrecio(articuloLocalPrecioBase);
						}
					}
				}
				if (SearchDTO.isLoaded(articuloDTOIterator.getArticuloGarantiaDTO()) && StringUtils.equals(articuloDTOIterator.getArticuloGarantiaDTO().getEstadoExtensionGarantia(),SICConstantes.ESTADO_ACTIVO_NUMERICO)) {
					Collection<GarantiaArticuloDTO> garantiasCol = this.buscarPrecioExtension(articuloDTOIterator);
					if (garantiasCol != null && CollectionUtils.isNotEmpty(garantiasCol)) {
						GarantiaArticuloDTO garantiaArticuloDTO = garantiasCol.iterator().next();
						articuloDTOIterator.setNpPrecioExtGar(garantiaArticuloDTO.getCostoGarantia());
					}
				} else{
					articuloDTOIterator.setNpPrecioExtGar(null);
				}
				EtiquetaMercanciaVO articuloEtiqueta ;
				//obtengo la etiqueta
				articuloEtiqueta = getEtiquetaMercanciaDTO(articuloDTOIterator);
				articuloEtiqueta.setCantidadImpresion(1);
				articuloEtiqueta.setCodigoClasificacion(articuloDTOIterator.getCodigoClasificacion());
				//propiedad que debe ser colocada en el controlador
				etiquetaMercanciaVOCol.add(articuloEtiqueta);
			}
			return etiquetaMercanciaVOCol;
		}else{
			return null;
		}
	} 
	public  Collection<GarantiaArticuloDTO> buscarPrecioExtension(ArticuloDTO articuloDTO) throws SICException{
		LOG_SICV2.info("Buscando precio EXTENSION garantía");
		Collection<GarantiaArticuloDTO> garantiasCol = null;
		LOG_SICV2.info("Precio Base Imp {}",articuloDTO.getPrecioBaseImp());
		try {
			//TODO: Esta variable en sesion solo funciona porque existe una sola regla para rangos de precios 
			//si se aumentan reglas hay que consultar el rango por c/producto dependiendo del precio
			Collection<ArticuloRangoExtensionGarantiaDTO> rangos = this.articuloMercanciaDAO.obtenerRangosExtensionGarantia(articuloDTO.getId().getCodigoCompania(),articuloDTO.getPrecioBaseImp());
			if(rangos!=null && !rangos.isEmpty()){
				LOG_SICV2.info("Encontro rangos: {}", rangos.size());
				garantiasCol = new ArrayList<GarantiaArticuloDTO>();
				Long i = 0L;
				for(ArticuloRangoExtensionGarantiaDTO rango:rangos){					
					GarantiaArticuloDTO garantia = new GarantiaArticuloDTO();
					garantia.getId().setSecuencialGarantia(i);
					garantia.setTiempoGarantia(rango.getTiempo());
					//Si esta activo el porcentaje
					if(rango.getPorcentaje()!=0){						
						Double costo = (articuloDTO.getPrecioBaseImp() * rango.getPorcentaje()) / 100;
						if(costo <= rango.getValorMinimo()){
							costo = rango.getValorMinimo();// * SICConstantes.IVA;
							garantia.setCostoGarantia(Util.roundDoubleMath(costo, 2));							
						}else{							
							//costo = costo * SICConstantes.IVA;
							garantia.setCostoGarantia(Util.roundDoubleMath(costo, 2));
						}						
					}
					//Si esta activo un costo fijo
					else{
						Double costo = rango.getValor();// * SICConstantes.IVA;
						garantia.setCostoGarantia(Util.roundDoubleMath(costo, 2));
					}
					garantiasCol.add(garantia);
					i++;
				}				
			}					
			
		} catch (Exception e) {
			LOG_SICV2.error("Error: {}", e);
			throw new  EtiquetadoException(e);
		}
		return garantiasCol;
	}
	private EtiquetaMercanciaVO getEtiquetaMercanciaDTO(ArticuloDTO articuloEncontrado) {
		try {
			EtiquetaMercanciaVO articuloEtiqueta = new EtiquetaMercanciaVO();
			
			articuloEtiqueta.setCodigoClasificacion(articuloEncontrado.getCodigoClasificacion());
			if (SearchDTO.isLoaded(articuloEncontrado.getArtBitCodBarCol()) && CollectionUtils.isNotEmpty(articuloEncontrado.getArtBitCodBarCol())) {
				articuloEtiqueta.setCodigoBarra(articuloEncontrado.getCodigoBarrasActivo().getId().getCodigoBarras());
			}
			articuloEtiqueta.setCodigoArticulo(articuloEncontrado.getCodigoBarrasActivo().getId().getCodigoArticulo());
			articuloEtiqueta.setDescripcion(articuloEncontrado.getDescripcionArticulo());
			if(SearchDTO.isLoaded(articuloEncontrado.getArticuloComercialDTO()) && articuloEncontrado.getArticuloComercialDTO().getMarcaComercialArticulo() != null){
				articuloEtiqueta.setMarca(articuloEncontrado.getArticuloComercialDTO().getMarcaComercialArticulo().getNombre());
			}				
			articuloEtiqueta.setModelo(articuloEncontrado.getCodigoInternoProveedor());
			articuloEtiqueta.setPrecioAfiIVA(articuloEncontrado.getPrecioBaseImp());
			articuloEtiqueta.setPrecioNoAfiIVA(articuloEncontrado.getPrecioBaseNoAfiImp());
			articuloEtiqueta.setPrecioComercioIVA(articuloEncontrado.getPVPImp());
			if(articuloEncontrado.getNpPrecioExtGar()!=null && articuloEncontrado.getNpPrecioExtGar()>0){
				articuloEtiqueta.setPrecioExtGarIVA(articuloEncontrado.getNpPrecioExtGar());
			}
			if(articuloEncontrado.getPrecioBaseImp()!=null && articuloEncontrado.getPrecioBaseAnteriorImp() != null && articuloEncontrado.getPrecioBaseAnteriorImp() > 0) {
				if(articuloEncontrado.getPrecioBaseAnteriorImp() != null
						&& (articuloEncontrado.getPrecioBaseAnteriorImp() <= articuloEncontrado.getPrecioBaseImp())){
					articuloEtiqueta.setPrecioBaseAfiliadoIVA(null);
				} else {
					articuloEtiqueta.setPrecioBaseAfiliadoIVA(articuloEncontrado.getPrecioBaseAnteriorImp());
				}
			}
			else{
				articuloEtiqueta.setPrecioBaseAfiliadoIVA(null);
			}
				
			if(articuloEncontrado.getPrecioBaseNoAfiImp()!=null && articuloEncontrado.getPrecioBaseAnteriorNoAfiImp() != null && articuloEncontrado.getPrecioBaseAnteriorNoAfiImp()>0) {
				if(articuloEncontrado.getPrecioBaseAnteriorNoAfiImp() != null
						&& (articuloEncontrado.getPrecioBaseAnteriorNoAfiImp() <= articuloEncontrado.getPrecioBaseNoAfiImp())){
					articuloEtiqueta.setPrecioBaseNoAfiliadoIVA(null);
				} else {
					articuloEtiqueta.setPrecioBaseNoAfiliadoIVA(articuloEncontrado.getPrecioBaseAnteriorNoAfiImp());
				}
			}
			else {
				articuloEtiqueta.setPrecioBaseNoAfiliadoIVA(null);
			}
			
			articuloEtiqueta = obtenerCaracteristicasArticulo(articuloEtiqueta, articuloEncontrado.getCaracteristicaDTOSet());
			
			return articuloEtiqueta;
		} catch (Exception e) {
			LOG_SICV2.error("Error: {}", e);
			throw new EtiquetadoException();
		}
		
	}
	@SuppressWarnings("unchecked")
	private EtiquetaMercanciaVO obtenerCaracteristicasArticulo(EtiquetaMercanciaVO articuloEtiqueta, Collection<CaracteristicaDTO> caracteristicaCol) {
		Collection<CaracteristicaDTO> caracteristicaDTOCol = caracteristicaCol;
		articuloEtiqueta.setCaracteristica1("");articuloEtiqueta.setCaracteristica2("");articuloEtiqueta.setCaracteristica3("");
		articuloEtiqueta.setCaracteristica4("");articuloEtiqueta.setCaracteristica5("");articuloEtiqueta.setCaracteristica6("");
		articuloEtiqueta.setCaracteristica7("");
		// añadir solamente las caracteristicas técnicas y activas
		caracteristicaDTOCol = CollectionUtils.select(caracteristicaDTOCol, new BeanPredicate("codigoTipoCaracterstica", PredicateUtils.equalPredicate(new Integer(SICConstantes.CARACTERISTICA_TECNICA))));
		//Buscando Caracteristicas
		if (caracteristicaDTOCol != null && !caracteristicaDTOCol.isEmpty()) {
			int orden  = 1;
			for (CaracteristicaDTO caracteristica : caracteristicaDTOCol) {
				LOG_SICV2.info(caracteristica.getId().getSecuencialCaracteristica() + " - " + caracteristica.getDescription() + " - " + caracteristica.getStatus() + " - " + caracteristica.getOrden());
					if (orden == 1)
						articuloEtiqueta.setCaracteristica1(caracteristica.getDescription());
					else if (orden == 2)
						articuloEtiqueta.setCaracteristica2(caracteristica.getDescription());
					else if (orden == 3)
						articuloEtiqueta.setCaracteristica3(caracteristica.getDescription());
					else if (orden == 4)
						articuloEtiqueta.setCaracteristica4(caracteristica.getDescription());
					else if (orden == 5)
						articuloEtiqueta.setCaracteristica5(caracteristica.getDescription());
					else if (orden == 6)
						articuloEtiqueta.setCaracteristica6(caracteristica.getDescription());
					else if (orden == 7)
						articuloEtiqueta.setCaracteristica7(caracteristica.getDescription());
					else if (orden > 7)
						break;
					orden++;
			}
		}
		return articuloEtiqueta;
	}

	@Override
	public Integer totalRegistrosEtiquetaMercanciaMasiva(Integer codigoCompania, Integer areaTrabajo, String codigoClasificacion, String promocion) throws SICException {
		Integer totalRegistros = this.articuloMercanciaDAO.totalRegistrosEtiquetaMercanciaMasiva(codigoCompania, areaTrabajo, codigoClasificacion, promocion);
		return totalRegistros;
	}
	
	/**
	 * @author aquingaluisa
	 * Copia y modificacion del metodo original en el proyecto de mercancias
	 * Metodo que procesa un archivo inputstream con generación exportación al objeto deseado dado el codigo del formato
	 * @param usuario
	 * @param codigoFormato
	 * @param archivoImportacion
	 * @param archivoImportacionF
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public InfoRecepcionEST obtenerEstructuraDesdeArchivo(String usuario, String codigoFormato, InputStream archivoImportacion, File archivoImportacionF, String codigoCompania) throws SICException{
		InfoRecepcionEST estructuraArchivo = null;
		FormatoID formatoID = null;
		RecepcionDTO recepcionDTO = null;

		if (archivoImportacionF == null){
			throw new SICException("no existe un archivo para ser procesado");
		}

		formatoID = new FormatoID();
		formatoID.setCodigoCompania(Integer.valueOf(codigoCompania));
		formatoID.setCodigoSistema(SICConstantes.CODIGO_SISTEMA);
		formatoID.setCodigoFormato(codigoFormato);
		GeneradorExportacionService exportacionService = new GeneradorExportacionService();
		try {
			recepcionDTO = exportacionService.inicializarRecepcion(formatoID, usuario);
		}catch (GeneradorExportacionException e1) {
			throw new SICException("Ocurrio un error al obtener el formato");
		}catch (Exception e1) {
			throw new SICException("Ocurrio un error general al obtener el formato");
		}
		if(recepcionDTO==null){
			throw new SICException("No se encontro el formato solicitado");
		}		
		ImportacionListener importacionListener = null;
		try {
			estructuraArchivo = exportacionService.transImportarDatos(recepcionDTO.getId(), importacionListener, archivoImportacionF, usuario);
		} catch (Exception e) {
			LOG_SICV2.error("Error al importar los datos de la migracion de archivos",e);
			throw new SICException("Ocurrio un error en la conversion del archivo solicitado al formato enviado");
		}		
		return estructuraArchivo;
	}
	
	/**
	 * Metodo para obtener los codigos clasificacion de un funcionario
	 * @param funcionario
	 * @return
	 * @throws SICException
	 */
	@Override
	public Collection<String> obtenerCodigosClasificacionFuncionario(FuncionarioDTO funcionario,Boolean tieneLineaComercial) throws SICException{
		
		return this.articuloMercanciaDAO.obtenerCodigosClasificacionFuncionario(funcionario, tieneLineaComercial);
	}
}