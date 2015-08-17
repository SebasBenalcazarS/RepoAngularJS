/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.articuloPrecioDiferenciado;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoEjecucionGestionPrecio;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.articuloPrecioDiferenciado.IArticuloPrecioDiferenciadoGestor;
import ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.almacenamiento.IAlmacenamientoDatosCambioPreciosGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.preciodiferenciado.IArticuloLocalGestionPrecioDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.preciodiferenciado.IArticuloPrecioDiferenciadoDAO;

/**
 * @author guvidia
 *
 */
public class ArticuloPrecioDiferenciadoGestor implements IArticuloPrecioDiferenciadoGestor{
		
	private IArticuloPrecioDiferenciadoDAO articuloPrecioDiferenciadoDAO;
	private IArticuloLocalGestionPrecioDAO articuloLocalGestionPrecioDAO;
//	private IArticuloPrecioDiferenciadoMasivoDAO articuloPrecioDiferenciadoMasivoDAO;
	private IAlmacenamientoDatosCambioPreciosGestor almacenamientoDatosCambioPreciosGestor;
	

	public void setArticuloPrecioDiferenciadoDAO(IArticuloPrecioDiferenciadoDAO articuloPrecioDiferenciadoDAO) {
		this.articuloPrecioDiferenciadoDAO = articuloPrecioDiferenciadoDAO;
	}

//	public void setArticuloPrecioDiferenciadoMasivoDAO(IArticuloPrecioDiferenciadoMasivoDAO articuloPrecioDiferenciadoMasivoDAO) {
//		this.articuloPrecioDiferenciadoMasivoDAO = articuloPrecioDiferenciadoMasivoDAO;
//	}

	public void setAlmacenamientoDatosCambioPreciosGestor(IAlmacenamientoDatosCambioPreciosGestor almacenamientoDatosCambioPreciosGestor) {
		this.almacenamientoDatosCambioPreciosGestor = almacenamientoDatosCambioPreciosGestor;
	}

	/**
	 * @param articuloLocalGestionPrecioDAO the articuloLocalGestionPrecioDAO to set
	 */
	public void setArticuloLocalGestionPrecioDAO(IArticuloLocalGestionPrecioDAO articuloLocalGestionPrecioDAO) {
		this.articuloLocalGestionPrecioDAO = articuloLocalGestionPrecioDAO;
	}

	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.articuloPrecioDiferenciado.IArticuloPrecioDiferenciadoGestor#obtenerArticuloPrecioDiferenciado(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Collection<ArticuloPrecioDiferenciadoDTO> obtenerArticulosPrecioDiferenciado(Integer codigoCompania, String codigoArticulo, String estado) throws SICException {
		Collection<ArticuloPrecioDiferenciadoDTO> collPreDif = this.articuloPrecioDiferenciadoDAO.obtenerArticulosPrecioDiferenciado(codigoCompania, codigoArticulo, estado);
		if( CollectionUtils.isNotEmpty(collPreDif) ){
			for (ArticuloPrecioDiferenciadoDTO artPreDif : collPreDif) {
				Collection<ArticuloLocalGestionPrecioDTO> collLocalPre = this.articuloLocalGestionPrecioDAO.obtenerArticulosLocalPrecio(codigoCompania, codigoArticulo, artPreDif.getId().getSecuencial(), estado);
				if( CollectionUtils.isNotEmpty(collLocalPre) ){
					artPreDif.setArticuloLocalGestionPrecioCol(collLocalPre);
				}
			}
		}
		return collPreDif;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.articuloPrecioDiferenciado.IArticuloPrecioDiferenciadoGestor#guardarCollArticuloPrecioDiferenciado(java.util.Collection)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void registrarCollArticuloPrecioDiferenciado(Collection<ArticuloPrecioDiferenciadoDTO> articuloPrecioDiferenciadoDTOCol, ArticuloGestionPrecioDTO articuloGestionPrecioConflictos) throws SICException{		
		try{
			if( CollectionUtils.isNotEmpty(articuloPrecioDiferenciadoDTOCol) ){
				articuloPrecioDiferenciadoDTOCol = ColeccionesUtil.sort(articuloPrecioDiferenciadoDTOCol, ColeccionesUtil.ORDEN_ASC, "estado");
				for (ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciadoDTO : articuloPrecioDiferenciadoDTOCol) {
					//debe tener local gestion precio
					if( articuloPrecioDiferenciadoDTO.getId().getSecuencial() == null ){
						Collection<ArticuloPrecioDiferenciadoDTO> articuloPreCol = this.articuloPrecioDiferenciadoDAO.buscarArticuloPrecioDiferenciadoPorValor(articuloPrecioDiferenciadoDTO);
						if( CollectionUtils.isNotEmpty(articuloPreCol) ){
							ArticuloPrecioDiferenciadoDTO articuloPre = articuloPreCol.iterator().next();
							articuloPre.setEstado(articuloPrecioDiferenciadoDTO.getEstado());
							articuloPre.setValor(articuloPrecioDiferenciadoDTO.getValor());
							articuloPre.setValorAnterior(articuloPrecioDiferenciadoDTO.getValorAnterior());
							articuloPre.setPorcentajeMargen(articuloPrecioDiferenciadoDTO.getPorcentajeMargen());
							articuloPre.setPorcentajeMargenAnterior(articuloPrecioDiferenciadoDTO.getPorcentajeMargenAnterior());
							articuloPre.setIdUsuarioModificacion(articuloPrecioDiferenciadoDTO.getIdUsuarioRegistro());
							articuloPre.setFechaModificacion(articuloPrecioDiferenciadoDTO.getFechaRegistro());
							articuloPre.setCodigoTipoPrecio(articuloPrecioDiferenciadoDTO.getCodigoTipoPrecio());
							this.articuloPrecioDiferenciadoDAO.actualizarArticuloPrecioDiferenciado(articuloPre);
							// Asignamos el valor de la nueva secuencia
							articuloPrecioDiferenciadoDTO.getId().setSecuencial(articuloPre.getId().getSecuencial());
						}else{
							this.articuloPrecioDiferenciadoDAO.guardarArticuloPrecioDiferenciado(articuloPrecioDiferenciadoDTO);
						}
						
					}else{					
						this.articuloPrecioDiferenciadoDAO.actualizarArticuloPrecioDiferenciado(articuloPrecioDiferenciadoDTO);
					}
					// actualizar locales que tienen el precio diferenciado
					if( CollectionUtils.isNotEmpty(articuloPrecioDiferenciadoDTO.getArticuloLocalGestionPrecioCol())){
						for(ArticuloLocalGestionPrecioDTO localPrecio : articuloPrecioDiferenciadoDTO.getArticuloLocalGestionPrecioCol()){
							localPrecio.setSecuencialPreDif(articuloPrecioDiferenciadoDTO.getId().getSecuencial());
							if( localPrecio.getId().getSecuencialArtLocGesPre() == null ){
								localPrecio.setCodigoEstadoEjecucion(EstadoEjecucionGestionPrecio.CODIGO_ESTADO_EJECUCION_GESTION_PRECIO);
								localPrecio.setValorEstadoEjecucion(EstadoEjecucionGestionPrecio.PENDIENTE.getValorEstadoEjecucionGestionPrecio());
								this.articuloLocalGestionPrecioDAO.guardarArticuloLocalGestionPrecio(localPrecio);
							}else{
								this.articuloLocalGestionPrecioDAO.actualizarArticuloLocalGestionPrecio(localPrecio);
							}
						}
					}
				}
				// guarda los conflictos de los precios difereciados
				if( articuloGestionPrecioConflictos != null ){
					this.almacenamientoDatosCambioPreciosGestor.sincronizarPreciosDiferenciados(articuloGestionPrecioConflictos);
				}
			}
		}catch(SICException e){
			Logeable.LOG_SICV2.error("Error al guardar el precio diferenciado", e.getMessage());
			throw new SICException("Error al guardar el precio diferenciado.", e);
		}		
	}
	
	@Override
	public void guardarPrecioDiferenciado(ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciadoDTO) throws SICException{		
		this.articuloPrecioDiferenciadoDAO.guardarArticuloPrecioDiferenciado(articuloPrecioDiferenciadoDTO);			
	}
	
//	@Override
//	public List<String> buscarCodigosArticulos(ArticuloVO articuloVO, IPlantillaBusquedaArticuloPrecioDiferenciado plantillaBusquedaArticulos){
//		Criterion criterion = incluirRestriccionesBusquedaArticuloEdicion(articuloVO, plantillaBusquedaArticulos);
//		return this.articuloPrecioDiferenciadoMasivoDAO.buscarCodigosArticulos(articuloVO, criterion);		
//	}
	
//	public Criterion incluirRestriccionesBusquedaArticuloEdicion(ArticuloVO articuloFiltro, IPlantillaBusquedaArticuloPrecioDiferenciado plantillaBusquedaArticulos) throws SICException {
//		
//		DynamicCriteriaRestriction dynamicCriteriaRestriction = new DynamicCriteriaRestriction();
//
//		//se agregar la restriccion por defecto de linea comercial
//		Criterion restriccionLineaComercial = plantillaBusquedaArticulos.getRestriccionPorComprador().getCriteriaRestriction();
//		
//		/**
//		 * ASIGNACION DE VALORES DESDE EL OBJETO PLANTILLA
//		 */
//		articuloFiltro.getBaseDTO().getId().setCodigoCompania(plantillaBusquedaArticulos.getCompaniaId());
//		// CODIGO BARRAS DEL ARTICULO
//		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaCriteriaSearch()) && plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codigoBarras") != null) {
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codigoBarras"));
//		}
//		
//		// DESCRIPCION DE ARTICULOS
//		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaCriteriaSearch()) && plantillaBusquedaArticulos.getMapaCriteriaSearch().get("descArticulo") != null) {
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("descArticulo"));
//		}
//		
//		// CODIGO CLASIFICACION
//		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction()) && plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("codClasificacion") != null) {
//			articuloFiltro.addDynamicProperty("filtroClasificacion", Boolean.TRUE);
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("codClasificacion"));
//		}
//		// CODIGO SUBCLASIFICACION
//		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaCriteriaSearch()) && plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codSubClasificacion") != null) {
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codSubClasificacion"));
//		}
//		
//		// CLASE ARTICULO
//		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction()) && plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("claseArticulo") != null) {
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("claseArticulo"));
//		}
//		
//		// CODIGO MARCA COMERCIAL
//		if (plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codigoMarca") != null) {
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codigoMarca"));
//			articuloFiltro.addDynamicProperty("filtroMarcaComercial", Boolean.TRUE);
//		}
//		// NOMBRE MARCA COMERCIAL
//		if (plantillaBusquedaArticulos.getMapaCriteriaSearch().get("nombreMarca") != null) {
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("nombreMarca"));
//			articuloFiltro.addDynamicProperty("filtroMarcaComercial", Boolean.TRUE);
//		}
//		// TIPO MARCA COMERCIAL
//		if (plantillaBusquedaArticulos.getMapaCriteriaSearch().get("valorTipoMarca") != null) {
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("valorTipoMarca"));
//			articuloFiltro.addDynamicProperty("filtroMarcaComercial", Boolean.TRUE);
//		}
//		
//		// MARCA PARTICIPACION
//		if (plantillaBusquedaArticulos.getMapaCriteriaSearch().get("descMarcaParticipacion") != null) {
//			articuloFiltro.addDynamicProperty("filtroArticuloComercial",Boolean.TRUE);
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("descMarcaParticipacion"));
//		}
//		
//		//CREADOS POR USUARIO
//		if(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("creadosPorUsuario") != null){
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("creadosPorUsuario"));
//		}
//		
//		//FECHA CREACION
//		if(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("fechaCreacion") != null){
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("fechaCreacion"));
//		}
//		
//		//PAIS ORIGEN
//		if(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("paisOrigen") != null){
//			articuloFiltro.addDynamicProperty("filtroPaisOrigen",Boolean.TRUE);
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("paisOrigen"));
//		}
//		
//		// CODIGO PROVEEDOR
//		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaCriteriaSearch()) && plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codigoProvedor") != null) {
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codigoProvedor"));
//			articuloFiltro.addDynamicProperty("filtroProveedor", Boolean.TRUE);
//		}
//		
//		// NOMBRE PROVEEDOR
//		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction()) && plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("nombreComercialProv") != null) {
//			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("nombreComercialProv"));
//			articuloFiltro.addDynamicProperty("filtroProveedor", Boolean.TRUE);
//		}
//		
//		return Restrictions.and(restriccionLineaComercial, dynamicCriteriaRestriction.getCriteriaRestriction()) ;
//		
//	}
}
