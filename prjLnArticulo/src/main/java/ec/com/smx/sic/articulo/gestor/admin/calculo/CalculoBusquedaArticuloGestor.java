/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.calculo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.BeanUtils;

import ec.com.kruger.utilitario.dao.commons.annotations.RelationField.JoinType;
import ec.com.kruger.utilitario.dao.commons.constants.BooleanClauseEnum;
import ec.com.kruger.utilitario.dao.commons.dto.OrderBy;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearch;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.CriteriaRestriction;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.corpv2.common.seguridades.autorizacion.IAuthorizationComponent;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.EstablecimientoCiudadDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.corpv2.etiquetado.modelo.dto.TagDTO;
import ec.com.smx.framework.common.validator.Validator;
import ec.com.smx.framework.common.validator.ValidatorImpl;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICCodigosError;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICUtil;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoRelacionArticulo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAplicacionDescuento;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAsignacionDescuento;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaBusquedaEdicionMasivaArticulos;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaFiltrosBusquedaArticulos;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoGestionPrecio;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoBusquedaArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.IValidacionArticuloGestor;
import ec.com.smx.sic.cliente.gestor.proveedor.administracion.calculo.ICalculoDatosProveedorGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDuracionConservacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEstructuraComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaMercanciaCatalogoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGarantiaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloInformacionNutricionalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLeyendaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalMargenDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMaterialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMedidaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorCostoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorNovedadDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorNovedadReferenciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloTemporadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionTipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoVentaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.EquivalenciaPorcentajeDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EstadoCodificacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.EstadoTipoArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.GrupoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorImportadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.SegmentoCreacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoCodigoArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoPrecioArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloClaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloAsignacionLocalVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloImportadoVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.BusquedaSimpleArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.IdentificadorJDEProveedorVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloBitacoraCodigoBarrasDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloProveedorDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IBusquedaArticuloLocalPedidoDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.restricciones.ArticuloRegistroSanitarioPlantillaRestriction;
import ec.com.smx.sic.cliente.persistencia.articulos.restricciones.ArticuloRestriccionesPedidosEspeciales;
import ec.com.smx.sic.cliente.persistencia.beans.BasePlantillaCriteriaRestriction;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.dao.IArticuloNuevoImportadoDAO;
import ec.com.smx.sic.cliente.persistencia.proveedor.restricciones.ProveedorFiltroRestriction;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;
import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;

/**
 * @author fmunoz
 * 
 */
public class CalculoBusquedaArticuloGestor implements ICalculoBusquedaArticuloGestor, Logeable{

	private IArticuloDAO articuloDAO;

	private DataGestor dataGestor;

	private ICalculoDatosProveedorGestor calculoDatosProveedorGestor;

	private IArticuloProveedorDAO articuloProveedorDAO;

	private IValidacionArticuloGestor validacionArticuloGestor;

	private ICalculoArticuloGestor calculoArticuloGestor;
	
	private IBusquedaArticuloLocalPedidoDAO busquedaArticuloLocalPedidoDAO;
	
	private IArticuloNuevoImportadoDAO articuloNuevoImportadoDAO;
	
	private IArticuloBitacoraCodigoBarrasDAO articuloBitacoraDAO;

	/**
	 * 
	 * @param codigoArticulo
	 * @param codigoCompania
	 * @param tiposRelacion
	 * @return
	 */
	public final ArticuloDTO findByIdArticulo(final String codigoArticulo, Integer codigoCompania, EnumTipoRelacionArticulo... tiposRelacion) throws SICException {

		ArticuloDTO articuloTemplateDTO = null;

		if (StringUtils.isEmpty(codigoArticulo)) {
			throw new IllegalArgumentException("El codigoArticulo no puede ser null");
		}

		if (null == codigoCompania) {
			throw new IllegalArgumentException("El codigoCompania no puede ser null");
		}

		Logeable.LOG_SICV2.info(">> Completar las siguientes relaciones del articulo");

		articuloTemplateDTO = new ArticuloDTO();
		articuloTemplateDTO.getId().setCodigoArticulo(codigoArticulo);
		articuloTemplateDTO.getId().setCodigoCompania(codigoCompania);
		//articuloTemplateDTO.setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		
		// itera toda la colleccion de tipos de relaciones
		this.cargarRelacion(articuloTemplateDTO, tiposRelacion);
	
		// si el articulo tiene codigoArticulo
		articuloTemplateDTO = dataGestor.findUnique(articuloTemplateDTO);

		Logeable.LOG_SICV2.info(">> Se han completado las relaciones del articulo");

		return articuloTemplateDTO;
	}

	/**
	 * 
	 * @param id
	 * @param tiposRelacion
	 * @return
	 * @throws SICException
	 */
	public final ArticuloDTO findByIdArticulo(final ArticuloID id, EnumTipoRelacionArticulo... tiposRelacion) throws SICException {
		if (id != null) {
			return this.findByIdArticulo(id.getCodigoArticulo(), id.getCodigoCompania(), tiposRelacion);
		}
		return null;
	}

	public final ArticuloVO findByIdArticuloVO(final ArticuloVO articuloVO, EnumTipoRelacionArticulo... tiposRelacion) throws SICException {

		ArticuloVO articuloVOTemp = null;
		ArticuloDTO articuloTemplateDTO = null;

		articuloVOTemp = articuloVO;
		if (articuloVOTemp != null && articuloVOTemp.getBaseDTO() != null && ArrayUtils.isNotEmpty(tiposRelacion)) {
//			EnumTipoRelacionArticulo[] tiposRelacionArticulo =  new EnumTipoRelacionArticulo[tiposRelacion.length];
			Set<EnumTipoRelacionArticulo> tiposRelacionArticulo = new HashSet<EnumTipoRelacionArticulo>(Arrays.asList(tiposRelacion)); 
			if(articuloVO.getBaseDTO().getCodigoClienteImportacion() != null){
				tiposRelacionArticulo.remove(EnumTipoRelacionArticulo.CLASIFICACION);
				tiposRelacionArticulo.remove(EnumTipoRelacionArticulo.BODEGA);
			}
			articuloTemplateDTO = findByIdArticulo(articuloVO.getBaseDTO().getId(), tiposRelacionArticulo.toArray(new EnumTipoRelacionArticulo[0]));
			articuloVO.setBaseDTO(articuloTemplateDTO);

			if(articuloVO.getBaseDTO() != null && !articuloVO.getBaseDTO().getTieneClasificacion()){
				ClasificacionDTO clasificacionDTO = this.articuloNuevoImportadoDAO.obtenerClasificacionPorCliente(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getCodigoClienteImportacion());
				articuloVO.getBaseDTO().setClasificacionDTO(clasificacionDTO);
			}
			
			// si continen la relacion articulo proveedor para armar el
			// articuloVO
			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_PROVEEDOR) || ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.DESCUENTO_COMPRA) || ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_IMPORTACION)) {

				if (articuloVO.getBaseDTO() != null && CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getArticuloProveedorCol())) {

					Collection<ArticuloProveedorDTO> proveedoresActivos = CollectionUtils.select(articuloVO.getBaseDTO().getArticuloProveedorCol(), new BeanPredicate("estadoArticuloProveedor", PredicateUtils.equalPredicate(SICConstantes.ESTADO_ACTIVO_NUMERICO)));
					if (CollectionUtils.isNotEmpty(proveedoresActivos)) {
						ArticuloProveedorDTO articuloProveedorDTO = proveedoresActivos.iterator().next();
						articuloProveedorDTO.setArticulo(articuloVO.getBaseDTO());
						articuloVO.setArticuloProveedorDTO(articuloProveedorDTO);
						articuloVO.setProveedor(articuloVO.getArticuloProveedorDTO().getVistaProveedor());
					}

				}

			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.CLASIFICACION)) {
				if (articuloVO.getBaseDTO() != null && articuloVO.getBaseDTO().getTieneClasificacion() && articuloVO.getBaseDTO().getTieneArticuloComercial()) {

					articuloVO.getBaseDTO().getArticuloComercialDTO().setPorcentajeNoAfiliado(articuloVO.getBaseDTO().getClasificacionDTO().getPorcentajeNoAfiliado());
				}
			}

			if (articuloVO.getBaseDTO() != null && CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getSegmentoCreacionArticulos())) {

				for (SegmentoCreacionArticuloDTO segmentoCreacionArticuloDTO : articuloVO.getBaseDTO().getSegmentoCreacionArticulos()) {

					this.validacionArticuloGestor.validarPasoCreacion(segmentoCreacionArticuloDTO, articuloVO);
				}

			}

		}

		return articuloVOTemp;
	}

	/**
	 * Metodo que permite completar las relaciones del aritculo, se asume que el
	 * articulo ya fue consultado
	 * 
	 * @param articuloDTO
	 * @param tiposRelacion
	 */
	@Override
	public final ArticuloDTO completarDatosArticulo(final ArticuloDTO articuloDTO, EnumTipoRelacionArticulo... tiposRelacion) throws SICException {
		Map<String, Object> relations = null;
		ArticuloDTO articuloTemplateDTO = null;
		if (articuloDTO != null && ArrayUtils.isNotEmpty(tiposRelacion)) {

			Logeable.LOG_SICV2.info(">> Completar las siguientes relaciones del articulo");

			articuloTemplateDTO = this.findByIdArticulo(articuloDTO.getId(), tiposRelacion);

			relations = SICUtil.getInstance().getRelations(articuloTemplateDTO);

			// Restaura las anteriores relaciones
			SICUtil.getInstance().restoreRelations(articuloDTO, relations);
			articuloTemplateDTO = null;

			Logeable.LOG_SICV2.info(">> Se han completado las relaciones del articulo");
		}
		return articuloDTO;
	}

	/**
	 * 
	 * @param articuloVO
	 * @param tiposRelacion
	 * @return
	 * @throws SICException
	 */
	@Override
	public final ArticuloVO completarDatosCreacionArticuloVO(final ArticuloVO articuloVO, EnumTipoRelacionArticulo... tiposRelacion) throws SICException {
		ArticuloDTO articuloDTO = null;

		if (articuloVO != null && articuloVO.getBaseDTO() != null && ArrayUtils.isNotEmpty(tiposRelacion)) {

			articuloDTO = this.completarDatosArticulo(articuloVO.getBaseDTO(), tiposRelacion);

			articuloVO.setBaseDTO(articuloDTO);
			articuloDTO = null;

			// si continen la relacion articulo proveedor para armar el
			// articuloVO
			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_PROVEEDOR) || ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.DESCUENTO_COMPRA) || ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_IMPORTACION)) {

				if (CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getArticuloProveedorCol())) {

					Collection<ArticuloProveedorDTO> proveedoresActivos = CollectionUtils.select(articuloVO.getBaseDTO().getArticuloProveedorCol(), new BeanPredicate("estadoArticuloProveedor", PredicateUtils.equalPredicate(SICConstantes.ESTADO_ACTIVO_NUMERICO)));
					if (CollectionUtils.isNotEmpty(proveedoresActivos)) {
						ArticuloProveedorDTO articuloProveedorDTO = proveedoresActivos.iterator().next();
						articuloProveedorDTO.setArticulo(articuloVO.getBaseDTO());
						articuloVO.setArticuloProveedorDTO(articuloProveedorDTO);
						articuloVO.setProveedor(articuloVO.getArticuloProveedorDTO().getVistaProveedor());
					}

				}

			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.CLASIFICACION)) {
				if (articuloVO.getBaseDTO().getTieneClasificacion() && articuloVO.getBaseDTO().getTieneArticuloComercial()) {

					articuloVO.getBaseDTO().getArticuloComercialDTO().setPorcentajeNoAfiliado(articuloVO.getBaseDTO().getClasificacionDTO().getPorcentajeNoAfiliado());
				}
			}

			if (CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getSegmentoCreacionArticulos())) {

				for (SegmentoCreacionArticuloDTO segmentoCreacionArticuloDTO : articuloVO.getBaseDTO().getSegmentoCreacionArticulos()) {

					this.validacionArticuloGestor.validarPasoCreacion(segmentoCreacionArticuloDTO, articuloVO);
				}

			}

		}
		return articuloVO;
	}

	/**
	 * Metodo que permite obtener la vista de provedor
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public IProveedor obtenerVistaProveedor(Integer codigoCompania, String codigoJDE) {
		IdentificadorJDEProveedorVO pFiltro = null;
		VistaProveedorDTO vFiltro = null;
		// se verifica si el proveedor ingresado es correcto
		if (codigoJDE != null) {
			// se busca el proveedor
			pFiltro = new IdentificadorJDEProveedorVO(codigoCompania, codigoJDE);
			vFiltro = new VistaProveedorDTO();
			vFiltro.setEstadoProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			// pFiltro.setEstado
			return calculoDatosProveedorGestor.obtenerProveedorPorJDE(pFiltro, vFiltro);
		}
		return null;
	}

	/**
	 * Metodo que permite decidir que relacion cargar del articulo
	 * 
	 * @param articuloDTO
	 * @param tiposRelacion
	 */
	public void cargarRelacion(final ArticuloDTO articuloDTO, EnumTipoRelacionArticulo... tiposRelacion) throws SICException {
		if (ArrayUtils.isNotEmpty(tiposRelacion)) {
			if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_AUDITORIA)){
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_AUDITORIA");
				this.asignarRelacionArticuloAuditoria(articuloDTO);
			}
			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_PROVEEDOR)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_PROVEEDOR");
				this.asignarRelacionArticuloProveedor(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_COSTO)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_COSTO");
				this.asignarRelacionesArticuloCosto(articuloDTO);
			}
			
			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_DESCUENTO_PROVEEDOR)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_DESCUENTO_PROVEEDOR");
				this.asignarRelacionesArticuloDescuento(articuloDTO); 
			}
			
			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.DESCUENTO_COMPRA)) {
				Logeable.LOG_SICV2.info("+ asignando DESCUENTO_COMPRA");
				this.asignarRelacionArticuloDescuento(articuloDTO);
			}

			if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.COSTOS_PROYECTADOS)){
				Logeable.LOG_SICV2.info("+ asignando COSTOS PROYECTADOS");
				this.asignarRelacionArticuloCostosProyectados(articuloDTO);
			}
			
			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_IMPORTACION)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_IMPORTACION");
				this.asignarRelacionArticuloImportacion(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_MEDIDA)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_MEDIDA");
				this.asignarRelacionArticuloMedidaDTO(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_BITACORA)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_BITACORA");
				this.asignarRelacionArticuloBitacoraCodigoBarras(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ESTADO_CODIFICACION_ARTICULO)) {
				Logeable.LOG_SICV2.info("+ asignando ESTADO_CODIFICACION_ARTICULO");
				this.asignarRelacionesEstadoCodificacionArticulo(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.CLASE)) {
				Logeable.LOG_SICV2.info("+ asignando CLASE");
				this.asignarRelacionesClaseArticulo(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.CLASIFICACION)) {
				Logeable.LOG_SICV2.info("+ asignando CLASIFICACION");
				this.asignarRelacionesClasificacion(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.DEPARTAMENTO)) {
				Logeable.LOG_SICV2.info("+ asignando DEPARTAMENTO");
				this.asignarRelacionesDepartamento(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.BODEGA)) {
				Logeable.LOG_SICV2.info("+ asignando BODEGA");
				this.asignarRelacionesBodega(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.SUBCLASIFICACION)) {
				Logeable.LOG_SICV2.info("+ asignando SUBCLASIFICACION");
				this.asignarRelacionesSubClasificacion(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.SEGMENTO_CREACION)) {
				Logeable.LOG_SICV2.info("+ asignando SEGMENTO_CREACION");
				this.asignarRelacionesSegmentoCreacion(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_UNIDAD_MANEJO)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_UNIDAD_MANEJO");
				this.asignarRelacionesArticuloUnidadManejo(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_UNIDAD_MANEJO_VENTA)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_UNIDAD_MANEJO_VENTA");
				this.asignarRelacionesArticuloUnidadManejoVenta(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_UNIDAD_MANEJO_RECEPCION)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_UNIDAD_MANEJO_RECEPCION");
				this.asignarRelacionesArticuloUnidadManejoRecepcion(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_COMERCIAL)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_COMERCIAL");
				this.asignarRelacionesArticuloComercial(articuloDTO);
			}
			
			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_CLASE)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_CLASE");
				this.asignarRelacionesArticuloClase(articuloDTO);
			}
			
			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_PRECIO)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_PRECIO");
				this.asignarRelacionesPrecio(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.DESCUENTO_VENTA)) {
				Logeable.LOG_SICV2.info("+ asignando DESCUENTO_VENTA");
				this.asignarRelacionesDescuentoVenta(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_PRECIO_COMPLETO)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_PRECIO_COMPLETO");
				this.asignarRelacionesArticuloPrecio(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_ETIQUETAS)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_ETIQUETAS");
				this.asignarRelacionArticuloEtiquetas(articuloDTO);
				/**
				 * TODO: validar  los permisos para las etiquetas  de mercancias
				 * 
				 */
				this.asignarRelacionArticuloEtiquetaMercancia(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_USOS)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_USOS");
				this.asignarRelacionArticuloUsos(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_CONSERVACION)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_CONSERVACION");
				this.asignarRelacionArticuloConservacion(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_TEMPORADA)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_TEMPORADA");
				this.asignarRelacionArticuloTemporada(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_GARANTIA)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_GARANTIA");
				this.asignarRelacionArticuloGarantia(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_PROCESO_LOGISTICO)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_PROCESO_LOGISTICO");
				this.asignarRelacionArticuloProcesoLogistico(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_IMPUESTO)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_IMPUESTO");
				this.asignarRelacionesArticuloImpuesto(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_RELACIONADO)) {
				Logeable.LOG_SICV2.info("--> asignando ARTICULO_RELACIONADO");
				this.asignarRelacionesArticuloRelacion(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_AGRUPADOR)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_AGRUPADOR");
				this.asignarRelacionesArticuloAgrupador(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_REGISTRO_SANITARIO_ESTUDIO_NUTRICIONAL)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_REGISTRO_SANITARIO");
				this.asignarRelacionRelacionRegistroSanitario(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_ARCHIVOS_ADJUNTOS_REGISTRO_SANITARIO)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_ARCHIVOS_ADJUNTOS_REGISTRO_SANITARIO");
				this.asignarRelacionArticuloDefinicionArchivoRegSan(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ESTRUCTURA_COMERCIAL_CLIENTE)) {
				Logeable.LOG_SICV2.info("+ asignando ESTRUCTURA_COMERCIAL_CLIENTE");
				this.asignarRelacionEstructuraComercialCliente(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_LEYENDA)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_LEYENDA");
				this.asignarRelacionArticuloLeyenda(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_DEFINICION_ARCHIVO)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_DEFINICION_ARCHIVO");
				this.asignarRelacionArticuloDefinicionArchivo(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_MARCA)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_COMERCIAL");
				this.asignarRelacionesArticuloMarca(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_LOCAL)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_LOCAL");
				this.asignarRelacionArticuloLocal(articuloDTO);
			}

			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_LOCAL_PRECIO)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_LOCAL_PRECIO");
				this.asignarRelacionArticuloLocalPrecio(articuloDTO);
			}
			
			if (ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_MATERIAL)) {
				Logeable.LOG_SICV2.info("+ asignando ARTICULO_MATERIAL");
				this.asignarRelacionArticuloMaterial(articuloDTO);
			}
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionesArticuloCupon(final ArticuloDTO articuloDTO) {
		
		//restriccion articulo codificado
		articuloDTO.setCodigoEstado(SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO);
		
		// asignar bitacora codigo de barras
		ArticuloBitacoraCodigoBarrasDTO abcb = articuloDTO.getArtBitCodBarCol().iterator().next();
		abcb.setCodigoTipoSecuencia(SICArticuloConstantes.getInstancia().TIPOCATALOGO_SECUENCIAINTERNA);
		abcb.setValorTipoSecuencia(SICArticuloConstantes.getInstancia().TIPSECART_CUPONESPECIAL);

		//articulo temporada
		if (!articuloDTO.getTieneArticuloTemporada()) {
			articuloDTO.setArticuloTemporadaDTO(new ArticuloTemporadaDTO());
		}
		// asignar articulo Relacionado
		ArticuloRelacionDTO articuloRelacionDTO = null;
		if (!articuloDTO.getTieneArticuloRelacionado()) {
			articuloRelacionDTO = new ArticuloRelacionDTO();
			articuloRelacionDTO.setArticuloRelacion(new ArticuloDTO());
			articuloRelacionDTO.getArticuloRelacion().setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
			articuloRelacionDTO.getArticuloRelacion().getArtBitCodBarCol().add(new ArticuloBitacoraCodigoBarrasDTO());
			articuloDTO.setArticuloRelacionCol(new ArrayList<ArticuloRelacionDTO>());
			articuloDTO.getArticuloRelacionCol().add(articuloRelacionDTO);
		} else {
			articuloRelacionDTO = articuloDTO.getArticuloRelacionCol().iterator().next();
		}
		articuloRelacionDTO.setValorTipoRelacion(SICArticuloConstantes.getInstancia().VALORARTICULORELACIONCUPON);
		articuloRelacionDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);

		// asignar de gestion precio
		GestionPrecioDTO gestionPrecioDTO=new GestionPrecioDTO();
		gestionPrecioDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoTipoGestionPrecio", ComparatorTypeEnum.EQUAL_COMPARATOR, TipoGestionPrecio.CODIGO_TIPO_GESTION_PRECIO));
		gestionPrecioDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorTipoGestionPrecio", ComparatorTypeEnum.EQUAL_COMPARATOR, TipoGestionPrecio.PROMOCION.getValorTipoGestionPrecio()));
		ArticuloGestionPrecioDTO gestionPrecioArticuloDTO = new ArticuloGestionPrecioDTO();
		gestionPrecioArticuloDTO.setGestionPrecio(gestionPrecioDTO);
		articuloDTO.setCampanias(new ArrayList<ArticuloGestionPrecioDTO>());
		articuloDTO.getCampanias().add(gestionPrecioArticuloDTO);

		// asignar locales
		if (!articuloDTO.getTieneArticuloLocal()) {
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
			articuloLocalDTO.setLocal(new AreaTrabajoDTO());
			articuloLocalDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloLocal", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			articuloDTO.setArticuloLocalCol(new ArrayList<ArticuloLocalDTO>());
			articuloDTO.getArticuloLocalCol().add(articuloLocalDTO);
		}
	}

	/**
	 * TODO
	 */
	@Override
	public SearchResultDTO<ArticuloDTO> buscarArticulos(ArticuloVO articuloVO, IAuthorizationComponent authorizationComponent) throws SICException {

		// 1.- obtiene solo la consulta sobre articuloDTO
		SearchResultDTO<ArticuloDTO> resultDTO = this.obtenerArticulosAgrupadosSecuenceOrderClause(articuloVO);

		// 2.- obtiene los codigos de articulo del comentario 1
		Collection<String> codigosArticulos = this.obtenerCodigosArticulos(resultDTO.getResults());

		if (CollectionUtils.isNotEmpty(codigosArticulos)) {

			// 3.- busca las relaciones de todos los articulos consultados en el comentatio 1
			Collection<ArticuloDTO> articulos = this.buscarRelacionesArticulo(articuloVO, authorizationComponent, codigosArticulos.toArray(new String[] {}));

			//  4 Restriccion para busqueda de codigobarras 
			this.construirEstructuraArticulos(resultDTO, articulos, articuloVO, authorizationComponent);
		}

		return resultDTO;
	}

	/**
	 * 
	 * @param articulos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Collection<String> obtenerCodigosArticulos(Collection<ArticuloDTO> articulos) {

		Collection<String> ids = CollectionUtils.collect(articulos, new Transformer() {

			@Override
			public Object transform(Object input) {
				ArticuloDTO articuloDTO = (ArticuloDTO) input;
				return articuloDTO.getId().getCodigoArticulo();
			}
		});

		return ids;
	}

	/**
	 * 
	 * @param articuloVO
	 * @return
	 */
	private SearchResultDTO<ArticuloDTO> obtenerArticulosAgrupadosSecuenceOrderClause(ArticuloVO articuloVO) {
		if (articuloVO.getOrderByField() != null) {
			if (StringUtils.contains(articuloVO.getOrderByField().getSecuenceOrderClause(), "clasificacionDTO.descripcionClasificacion")) {
				if (articuloVO.getBaseDTO().getClasificacionDTO() == null) {
					articuloVO.getBaseDTO().setClasificacionDTO(new ClasificacionDTO());
				}
			}
			if (StringUtils.contains(articuloVO.getOrderByField().getSecuenceOrderClause(), "subClasificacionDTO.descripcionSubClasificacion")) {
				articuloVO.getBaseDTO().setSubClasificacionDTO(new SubClasificacionDTO());
			}
			if (StringUtils.contains(articuloVO.getOrderByField().getSecuenceOrderClause(), "articuloMedidaDTO.referenciaMedida")) {
				articuloVO.getBaseDTO().setArticuloMedidaDTO(new ArticuloMedidaDTO());
			}
		}

		// obtiene solo la consulta sobre articuloDTO y sus relaciones uno a uno
		return articuloDAO.obtenerArticulosAgrupados(articuloVO);
	}

	/**
	 * 
	 * @return
	 */
	private void construirEstructuraArticulos(final SearchResultDTO<ArticuloDTO> resultDTO, final Collection<ArticuloDTO> articulos, final ArticuloVO articuloVO, IAuthorizationComponent authorizationComponent) {
		for (ArticuloDTO articuloDTO : resultDTO.getResults()) {
			
			articuloDTO.addDynamicProperty("relacionados", Boolean.FALSE);	
			ArticuloDTO articuloDTOInfo = this.buscarArticuloPorPredicateID(articulos, articuloDTO.getId());
			if(articuloVO.hasDynamicProperty("codbarExacto") && articuloVO.getDynamicProperty("codbarExacto").equals(Boolean.TRUE) ){
				
					if(articuloDTOInfo.getCodigoBarras() != null){
						String codbar = articuloDTOInfo.getCodigoBarras();
						
	                    if(articuloBitacoraDAO.cantidadArticulosRelacionados(codbar, articuloVO.getBaseDTO().getId().getCodigoCompania()) > 1){
	                    	articuloDTO.addDynamicProperty("relacionados", Boolean.TRUE);
						}else{
							articuloDTO.addDynamicProperty("relacionados", Boolean.FALSE);	
						}
					}
				
			}

			

			if (articuloDTOInfo != null) {
				List<String> propiedadesPorOmitir = new ArrayList<String>(Arrays.asList("estadoPerecibleReceta", "npImplemento"));
				BeanUtils.copyProperties(articuloDTOInfo, articuloDTO, propiedadesPorOmitir.toArray(new String[0]) );
				if (articuloDTO.getTieneArticuloImpuestoCol() && CollectionUtils.isNotEmpty(articuloDTO.getArticuloImpuestoCol())) {
					for (ArticuloImpuestoDTO articuloImpuesto : articuloDTO.getArticuloImpuestoCol()) {
						if (articuloImpuesto.getEsParaVenta()) {
							articuloDTO.addImpVen(articuloImpuesto.getTipoImpuestoArticulo().getId().getCodigoTipoImpuesto(),
									StringUtils.equals(articuloImpuesto.getTipoImpuestoArticulo().getCodigoGrupoImpuesto(), SICArticuloConstantes.getInstancia().GRUPOIMPUESTO_VERDE) ? (articuloImpuesto.getTipoImpuestoArticulo().getValorImpuesto() != null ? String.valueOf(articuloImpuesto.getTipoImpuestoArticulo().getValorImpuesto()) : null) : articuloImpuesto.getTipoImpuestoArticulo()
											.getPorcentajeImpuesto() + "%");
						}
						if (articuloImpuesto.getEsParaCompra()) {
							articuloDTO.addImpCom(articuloImpuesto.getTipoImpuestoArticulo().getId().getCodigoTipoImpuesto(),
									StringUtils.equals(articuloImpuesto.getTipoImpuestoArticulo().getCodigoGrupoImpuesto(), SICArticuloConstantes.getInstancia().GRUPOIMPUESTO_VERDE) ? (articuloImpuesto.getTipoImpuestoArticulo().getValorImpuesto() != null ? String.valueOf(articuloImpuesto.getTipoImpuestoArticulo().getValorImpuesto()) : null) : articuloImpuesto.getTipoImpuestoArticulo()
											.getPorcentajeImpuesto() + "%");
						}
					}
				}
				if (articuloDTO.getTieneArticuloProveedor() && CollectionUtils.isNotEmpty(articuloDTO.getArticuloProveedorCol())) {
					ArticuloProveedorDTO articuloProveedorDTOFirst = articuloDTO.getArticuloProveedorCol().iterator().next();
					articuloDTO.addDynamicProperty("referencia", articuloProveedorDTOFirst);
					articuloDTO.getArticuloProveedorCol().remove(articuloProveedorDTOFirst);
					articuloDTO.addDynamicProperty("referenciaCol", articuloDTO.getArticuloProveedorCol());
					articuloDTO.addDynamicProperty("detalle", Boolean.FALSE);
				}
				if (articuloDTOInfo.getTieneArticuloPrecio() && CollectionUtils.isNotEmpty(articuloDTOInfo.getArticuloPrecioCol())) {
					for (ArticuloPrecioDTO articuloPrecioDTO : articuloDTOInfo.getArticuloPrecioCol()) {
						if (articuloPrecioDTO.getEstadoPrecio().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO) && articuloPrecioDTO.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_PVP)) {
							articuloDTO.addDynamicProperty("articuloPrecioPVP", articuloPrecioDTO);
						}
						if (articuloPrecioDTO.getEstadoPrecio().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO) && articuloPrecioDTO.getId().getCodigoTipoPrecio().equals(SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE)) {
							articuloDTO.addDynamicProperty("articuloPrecioPBASE", articuloPrecioDTO);
						}
					}
				}
				if (BooleanUtils.isTrue((Boolean) articuloVO.getDynamicProperty("tieneRegistroSanitario"))) {
					if (CollectionUtils.isNotEmpty(articuloDTOInfo.getRegistroSanitarioCol())) {
						RelacionArticuloRegistroSanitarioDTO registroSanitarioDTO = asignarRegistroSanitarioenBusqueda(articuloDTOInfo.getRegistroSanitarioCol());
						if (registroSanitarioDTO != null) {
							articuloDTO.addDynamicProperty("registroSanitario", registroSanitarioDTO);
						}
					}
				}
			}
		}
		// construye la estructura del arbol de proveedor para visualizar
		resultDTO.setResults(asignarEstructuraArbol(resultDTO.getResults()));
		if (authorizationComponent != null && authorizationComponent.getIsAuthorizedComponent(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.visualizarCostos"))) {
			incluirDescuentos(resultDTO.getResults(), articuloVO.getBaseDTO().getId().getCodigoCompania());
		}
	}

	/**
	 * @author corbe busca el registro sanitario activo
	 * @param registrosSanitariosCol
	 * @return
	 */
	private RelacionArticuloRegistroSanitarioDTO asignarRegistroSanitarioenBusqueda(Collection<RelacionArticuloRegistroSanitarioDTO> registrosSanitariosCol) {
		for (RelacionArticuloRegistroSanitarioDTO relacionRegistroSanitario : registrosSanitariosCol) {
			if (relacionRegistroSanitario.getTieneRegistroSanitario() && StringUtils.equals(relacionRegistroSanitario.getEstado(), SICConstantes.ESTADO_ACTIVO_NUMERICO) && StringUtils.equals(relacionRegistroSanitario.getRegistroSanitario().getValorTipoEstudioNutricional(), TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO)
					&& relacionRegistroSanitario.getRegistroSanitario().getRegistroSanitario() != null) {
				return relacionRegistroSanitario;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	private Collection<ArticuloDTO> buscarRelacionesArticulo(final ArticuloVO articuloVO, IAuthorizationComponent authorizationComponent, final String... ids) {

		ArticuloDTO articuloDTOExt = new ArticuloDTO();

		articuloDTOExt.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());//TODO no esta bien esto corregir
		// restricciones por id

		// obtiene todas las restrucciones de los filtros
		CriteriaSearch criteriaSearchClone = SerializationUtils.clone(articuloVO.getCriteriaSearch());
		articuloDTOExt.setCriteriaSearch(criteriaSearchClone);

		if (articuloDTOExt.getCriteriaSearch() == null) {
			articuloDTOExt.setCriteriaSearch(new CriteriaSearch());
		}

		articuloDTOExt.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("id.codigoArticulo", ComparatorTypeEnum.IN_COMPARATOR, ids));

		ArticuloProveedorDTO apFiltro = new ArticuloProveedorDTO();
		apFiltro.setVistaProveedor(new VistaProveedorDTO());

		articuloDTOExt.setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
		articuloDTOExt.getArticuloProveedorCol().add(apFiltro);
		if (authorizationComponent != null && authorizationComponent.getIsAuthorizedComponent(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.visualizarCostos"))) {
			//TODO analizar por condicion And OR
			/*DynamicCriteriaRestriction dynamicCriteriaRestriction = new DynamicCriteriaRestriction();
			articuloDTOExt.setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());

			// CODIGO PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("codigoProveedor") != null) {
				dynamicCriteriaRestriction.add((CriteriaSearchParameter<String>) articuloVO.getBaseDTO().getDynamicProperty("codigoProveedor"));
			}
			// DOCUMENTO PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("numeroDocumento") != null) {
				dynamicCriteriaRestriction.add((CriteriaSearchParameter<String>) articuloVO.getBaseDTO().getDynamicProperty("numeroDocumento"));
			}
			// ORIGEN PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("origenProveedor") != null) {
				dynamicCriteriaRestriction.add((BaseCriteriaRestriction) articuloVO.getBaseDTO().getDynamicProperty("origenProveedor"));
			}
			// INDICADOR I PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("indicadorI") != null) {
				dynamicCriteriaRestriction.add((BaseCriteriaRestriction) articuloVO.getBaseDTO().getDynamicProperty("indicadorI"));
			}

			// NOMBRE PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("nombreComercialProv") != null) {
				dynamicCriteriaRestriction.add((BaseCriteriaRestriction) articuloVO.getBaseDTO().getDynamicProperty("nombreComercialProv"));
			}
			// ESTADO ARTICULO-PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("estadoProveedor") != null) {
				dynamicCriteriaRestriction.add((CriteriaSearchParameter<String>) articuloVO.getBaseDTO().getDynamicProperty("estadoProveedor"));
			}

			// ESTADO ARTICULO-PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("estadoArticuloProveedor") != null) {
				dynamicCriteriaRestriction.add((CriteriaSearchParameter<String>) articuloVO.getBaseDTO().getDynamicProperty("estadoArticuloProveedor"));
			}

			if (dynamicCriteriaRestriction.isNotEmptyCriteriaRestriction()) {
				articuloDTOExt.getCriteriaRestrictions().add(dynamicCriteriaRestriction);
			}*/

			asignarRelacionesArticuloPrecio(articuloDTOExt);
			// apFiltro.setProveedor(new ProveedorDTO());
		}

		if (articuloVO.getCriteriaSearch() != null && articuloVO.getCriteriaSearch().getCriteriaSearchParameter("articuloProveedorCol.vistaProveedor.codigoJDEProveedor") != null && apFiltro.getVistaProveedor() != null) {
			if (apFiltro.getVistaProveedor().getCriteriaSearch() == null) {
				apFiltro.getVistaProveedor().setCriteriaSearch(new CriteriaSearch());
			}
			if (articuloVO.getCriteriaSearch().getCriteriaSearchParameter("articuloProveedorCol.vistaProveedor.codigoJDEProveedor").getParameterValues() instanceof String[]) {
				apFiltro.getVistaProveedor().getCriteriaSearch().setCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoJDEProveedor", ComparatorTypeEnum.IN_COMPARATOR, (String[]) articuloVO.getCriteriaSearch().getCriteriaSearchParameter("articuloProveedorCol.vistaProveedor.codigoJDEProveedor").getParameterValues()));
			} else if (articuloVO.getCriteriaSearch().getCriteriaSearchParameter("articuloProveedorCol.vistaProveedor.codigoJDEProveedor").getParameterValues() instanceof String) {
				apFiltro.getVistaProveedor().getCriteriaSearch().setCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoJDEProveedor", ComparatorTypeEnum.IN_COMPARATOR, (String) articuloVO.getCriteriaSearch().getCriteriaSearchParameter("articuloProveedorCol.vistaProveedor.codigoJDEProveedor").getParameterValues()));
			}

		}
		if (!articuloDTOExt.getTieneArticuloComercial()) {
			articuloDTOExt.setArticuloComercialDTO(new ArticuloComercialDTO()); // relacion para obtener los porcentajes para los calculos
		}
		articuloDTOExt.getArticuloComercialDTO().setMarcaComercialArticulo(new MarcaArticuloDTO());
		articuloDTOExt.setArticuloMedidaDTO(new ArticuloMedidaDTO());		
		
		articuloDTOExt.setClasificacionDTO(new ClasificacionDTO());
		articuloDTOExt.getClasificacionDTO().setValorTipoEstructura(null);
		articuloDTOExt.getClasificacionDTO().setCodigoTipoEstructura(null);
		articuloDTOExt.getClasificacionDTO().setBodegaDTO(new BodegaDTO());
		
		articuloDTOExt.setSubClasificacionDTO(new SubClasificacionDTO());
		
		if (authorizationComponent != null && authorizationComponent.getIsAuthorizedComponent(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.visualizarMarcaParticipacion"))) {
			articuloDTOExt.setGrupoAlcanceDTO(new GrupoTrabajoDTO());
		}

		if (BooleanUtils.isTrue((Boolean) articuloVO.getDynamicProperty("tieneRegistroSanitario"))) {
			RelacionArticuloRegistroSanitarioDTO relacionArticuloRegistroSanitarioDTO = new RelacionArticuloRegistroSanitarioDTO();
			relacionArticuloRegistroSanitarioDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			relacionArticuloRegistroSanitarioDTO.setRegistroSanitario(new ArticuloRegistroSanitarioDTO());
			relacionArticuloRegistroSanitarioDTO.getRegistroSanitario().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoRegistroSanitario", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			articuloDTOExt.setRegistroSanitarioCol(new ArrayList<RelacionArticuloRegistroSanitarioDTO>());
			articuloDTOExt.getRegistroSanitarioCol().add(relacionArticuloRegistroSanitarioDTO);
		}
		
		//AGREGAMOS LA RELACION CON ARTICULO AGRUPADOR
		if(!articuloDTOExt.getTieneArticuloAgrupador()){
			ArticuloAgrupadorDTO agrupadorDTO = new ArticuloAgrupadorDTO();
			agrupadorDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			agrupadorDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("id.codigoTipoAgrupador", ComparatorTypeEnum.EQUAL_COMPARATOR, TipoCatalogoArticulo.TIPO_MARCAS_ESPECIALES));
			articuloDTOExt.setArticuloAgrupadorCol(new ArrayList<ArticuloAgrupadorDTO>());
			articuloDTOExt.getArticuloAgrupadorCol().add(agrupadorDTO);
		}
		return dataGestor.findObjects(articuloDTOExt);
	}

	/**
	 * 
	 * @param articulos
	 * @param id
	 * @return
	 */
	private ArticuloDTO buscarArticuloPorPredicateID(final Collection<ArticuloDTO> articulos, ArticuloID id) {

		Predicate predicateCodigoCompania = new BeanPredicate("id.codigoCompania", PredicateUtils.equalPredicate(id.getCodigoCompania()));
		Predicate predicateCodigoArticulo = new BeanPredicate("id.codigoArticulo", PredicateUtils.equalPredicate(id.getCodigoArticulo()));

		Predicate predicateAND = PredicateUtils.andPredicate(predicateCodigoCompania, predicateCodigoArticulo);

		return (ArticuloDTO) CollectionUtils.find(articulos, predicateAND);

	}
	
	@Override
	public Collection<ArticuloDTO> asignarEstructuraArbol(Collection<ArticuloDTO> articuloCol) throws SICException {

		Collection<ArticuloDTO> articuloEstructuraCol = new ArrayList<ArticuloDTO>();
		
		for (ArticuloDTO articuloDTO : articuloCol) {
			ArticuloDTO articulo;
			Collection<ArticuloDTO> articulosHijosCol = new ArrayList<ArticuloDTO>();
			articuloDTO.addDynamicProperty("articulosHijos", articulosHijosCol);
			articuloDTO.addDynamicProperty("detalle", Boolean.FALSE);
			if (CollectionUtils.isNotEmpty(articuloDTO.getArticuloProveedorCol())) {
			
				articulo = articuloDTO;
				articuloEstructuraCol.add(articulo);
				int i = 0;
				for (ArticuloProveedorDTO artProveedorDTO : articuloDTO.getArticuloProveedorCol()) {		
					articulo = new ArticuloDTO();
					articulo.addDynamicProperty("referencia", artProveedorDTO);
					articulo.addDynamicProperty("rendered", Boolean.FALSE);
					articulosHijosCol.add(articulo);
					articuloEstructuraCol.add(articulo);
					i++;
					if(i==SICArticuloConstantes.LIMITE_PROVEEDORES_PAGINATE){
						articuloDTO.addDynamicProperty("tomanyprov", Boolean.TRUE);
						break;
					}
					
				}
			} else {
				articuloEstructuraCol.add(articuloDTO);
			}
		}
		return articuloEstructuraCol;
	}

	/**
	 * 
	 */
	public void incluirDescuentos(Collection<ArticuloDTO> articuloDTOCol, Integer codigoCompania) throws SICException {
		DecimalFormat formatter = new DecimalFormat("0.0000");
		formatter.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
		Collection<String> codArtProCol = new ArrayList<String>();
		Collection<ArticuloProveedorDTO> articuloProveedorDTOs = new ArrayList<ArticuloProveedorDTO>();
		Collection<DescuentoProveedorArticuloDTO> desArticuloProveedorCol = new ArrayList<DescuentoProveedorArticuloDTO>();
		Collection<ArticuloUnidadManejoProveedorDTO> articuloUniManCol = new ArrayList<ArticuloUnidadManejoProveedorDTO>();

		for (ArticuloDTO articuloDTO : articuloDTOCol) {
			if ((ArticuloProveedorDTO) articuloDTO.getDynamicProperty("referencia") != null) {
				articuloProveedorDTOs.add((ArticuloProveedorDTO) articuloDTO.getDynamicProperty("referencia"));
			}
			if (articuloDTO.getArticuloProveedorCol() != null && !CollectionUtils.isEmpty(articuloDTO.getArticuloProveedorCol())) {
				articuloProveedorDTOs.addAll(articuloDTO.getArticuloProveedorCol());
			}
		}
		if (!CollectionUtils.isEmpty(articuloProveedorDTOs)) {
			for (ArticuloProveedorDTO articuloProveedorDTO : articuloProveedorDTOs) {
				if (articuloProveedorDTO != null && articuloProveedorDTO.getId().getCodigoArticulo() != null && articuloProveedorDTO.getId().getCodigoProveedor() != null) {
					codArtProCol.add(articuloProveedorDTO.getId().getCodigoArticulo().concat(articuloProveedorDTO.getId().getCodigoProveedor()));
				}
			}
		}
		if (!CollectionUtils.isEmpty(codArtProCol)) {
			desArticuloProveedorCol = articuloProveedorDAO.obtenerDescuentosArticuloProv(codArtProCol, codigoCompania);
			articuloUniManCol = articuloProveedorDAO.obtenerDescuentosUnidadManejo(codArtProCol, codigoCompania);
		}

		// ============== POBLAR LOS DESCUENTOS DEL
		// PROVEEDOR=====================

		for (ArticuloProveedorDTO articuloProveedorDTO : articuloProveedorDTOs) {

			articuloProveedorDTO.setDescuentoProveedorArticuloCol(new ArrayList<DescuentoProveedorArticuloDTO>());
			for (DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO : desArticuloProveedorCol) {
				if (StringUtils.equals(articuloProveedorDTO.getId().getCodigoArticulo(), descuentoProveedorArticuloDTO.getCodigoArticulo()) && StringUtils.equals(articuloProveedorDTO.getId().getCodigoProveedor(), descuentoProveedorArticuloDTO.getCodigoProveedor())
						&& ObjectUtils.equals(articuloProveedorDTO.getId().getCodigoCompania(), descuentoProveedorArticuloDTO.getId().getCodigoCompania())) {
					articuloProveedorDTO.getDescuentoProveedorArticuloCol().add(descuentoProveedorArticuloDTO);
				}
			}

			// ============== POBLAR LOS DESCUENTOS DEL
			// PROVEEDOR=====================

			articuloProveedorDTO.setUnidadesManejo(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
			for (ArticuloUnidadManejoProveedorDTO articuloUnidadManejoDTO : articuloUniManCol) {
				if (StringUtils.equals(articuloProveedorDTO.getId().getCodigoArticulo(), articuloUnidadManejoDTO.getCodigoArticulo()) && StringUtils.equals(articuloProveedorDTO.getId().getCodigoProveedor(), articuloUnidadManejoDTO.getId().getCodigoProveedor()) && ObjectUtils.equals(articuloProveedorDTO.getId().getCodigoCompania(), articuloUnidadManejoDTO.getId().getCodigoCompania())) {
					articuloProveedorDTO.getUnidadesManejo().add(articuloUnidadManejoDTO);
				}
			}

			Double costoNeto = this.calculoArticuloGestor.calcularCostoNeto(articuloProveedorDTO);
			LOG_SICV2.info("El costo neto: " + costoNeto);
			for (DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO : articuloProveedorDTO.getDescuentoProveedorArticuloCol()) {
				if (!StringUtils.equals(descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().getTipoDescuento().getNombre(), "NC")) {
					if (descuentoProveedorArticuloDTO.getEquivalenciaPorcentajeDescuento() == null) {
						articuloProveedorDTO.addDynamicProperty(StringUtils.deleteWhitespace(descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().getTipoDescuento().getNombre()), descuentoProveedorArticuloDTO.getPorcentajeDescuento() + "%");
						articuloProveedorDTO.addDynamicProperty(StringUtils.deleteWhitespace(descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().getTipoDescuento().getNombre() + "Parcial"), formatter.format((Double) descuentoProveedorArticuloDTO.getDynamicProperty(DescuentoProveedorArticuloDTO.COSTO_NETO_PARCIAL)) + "");
					} else {// <>TIPODESCUENTO
						String val = descuentoProveedorArticuloDTO.getEquivalenciaPorcentajeDescuento().getValorPorcentaje() + "(" + descuentoProveedorArticuloDTO.getEquivalenciaPorcentajeDescuento().getDescuento() + "%)";
						articuloProveedorDTO.addDynamicProperty(StringUtils.deleteWhitespace(descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().getTipoDescuento().getNombre()), val);
						articuloProveedorDTO.addDynamicProperty(StringUtils.deleteWhitespace(descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().getTipoDescuento().getNombre() + "Parcial"), formatter.format((Double) descuentoProveedorArticuloDTO.getDynamicProperty(DescuentoProveedorArticuloDTO.COSTO_NETO_PARCIAL)));
					}
				}
			}

			StringBuilder descuentosUnidadManejo = new StringBuilder();
			for (ArticuloUnidadManejoProveedorDTO articuloProveedorUnidadManejoDTO : articuloProveedorDTO.getUnidadesManejo()) {
				if (articuloProveedorUnidadManejoDTO.getEquivalenciaPorcentajeDescuentoDTO() != null && articuloProveedorUnidadManejoDTO.getEquivalenciaPorcentajeDescuentoDTO().getAsignacionTipoDescuento().getTipoDescuento() != null) {
					descuentosUnidadManejo.append("(" + articuloProveedorUnidadManejoDTO.getEquivalenciaPorcentajeDescuentoDTO().getValorCantidad() + ")").append(articuloProveedorUnidadManejoDTO.getEquivalenciaPorcentajeDescuentoDTO().getDescuento() + "%, ");

				}
			}
			if (!StringUtils.isEmpty(descuentosUnidadManejo.toString())) {
				articuloProveedorDTO.addDynamicProperty("DOCDE", descuentosUnidadManejo.toString());
				articuloProveedorDTO.addDynamicProperty(StringUtils.deleteWhitespace("DOCDE" + "Parcial"), formatter.format(costoNeto));
			}
			for (DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO : articuloProveedorDTO.getDescuentoProveedorArticuloCol()) {
				if (StringUtils.equals(descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().getTipoDescuento().getNombre(), "NC")) {// <>TIPODESCUENTO
					if (descuentoProveedorArticuloDTO.getEquivalenciaPorcentajeDescuento() == null) {
						articuloProveedorDTO.addDynamicProperty(StringUtils.deleteWhitespace(descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().getTipoDescuento().getNombre()), descuentoProveedorArticuloDTO.getPorcentajeDescuento() + "%");
						articuloProveedorDTO.addDynamicProperty(StringUtils.deleteWhitespace(descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().getTipoDescuento().getNombre() + "Parcial"), formatter.format(articuloProveedorDTO.getCostoNetoNC()));
					}
				}
			}
		}
	}

	@Override
	public Collection<ArticuloDTO> buscarTodoArticulos(ArticuloVO articuloVO, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX, IAuthorizationComponent authorizationComponent) throws SICException {
		Collection<ArticuloDTO> articuloDTOs = new ArrayList<ArticuloDTO>();
		Double totalPaginas = 1D;
		Integer inicialPage = 0;
		articuloVO.setCountAgain(Boolean.TRUE);
		for (int i = 1; i <= totalPaginas; i++) {
			articuloVO.setFirstResult(inicialPage);
			articuloVO.setMaxResults(23);
			incluirRestriccionesBusquedaArticulo(articuloVO, plantillaFiltrosBusquedaMAX);
			SearchResultDTO<ArticuloDTO> searchResultDTO = buscarArticulos(articuloVO, authorizationComponent);
			totalPaginas = Math.ceil((Double) (searchResultDTO.getCountResults() / 23D));
			articuloDTOs.addAll(searchResultDTO.getResults());
			inicialPage = articuloVO.getMaxResults() * i;
		}
		//agregamos las caracteristicas especiales
		this.agregarValoresCaracteristicaEspecial(articuloDTOs);
		return articuloDTOs;
	}

	/**
	 * TODO
	 */
	public SearchResultDTO<ArticuloDTO> buscarArticulosSimple(ArticuloVO articuloVO, Set<EnumTipoRelacionArticulo> relacionArticulos, Integer maximoArticulos) throws SICException {
		try{		
			SearchResultDTO<ArticuloDTO> resultDTO = articuloDAO.obtenerArticulosAgrupados(articuloVO, maximoArticulos);
	
			Collection<String> codigosArticulos = this.obtenerCodigosArticulos(resultDTO.getResults());
	
			if (CollectionUtils.isNotEmpty(codigosArticulos)) {
	
				ArticuloDTO articuloTemplateDTO = new ArticuloDTO();
				
				if(articuloVO.hasDynamicProperty("estadoProveedor")){
					articuloTemplateDTO.setDynamicProperties(articuloVO.getDynamicProperties());
				}
	
				articuloTemplateDTO.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
				this.cargarRelacion(articuloTemplateDTO, relacionArticulos.toArray(new EnumTipoRelacionArticulo[] {}));
	
				articuloTemplateDTO.setCriteriaSearch(new CriteriaSearch());
				articuloTemplateDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("id.codigoArticulo", ComparatorTypeEnum.IN_COMPARATOR, codigosArticulos.toArray(new String[] {})));
	
				Collection<ArticuloDTO> articuloDTOCols = dataGestor.findObjects(articuloTemplateDTO);
	
				for (final ArticuloDTO articuloResultDTO : resultDTO.getResults()) {
	
					final ArticuloDTO articuloDTOExt = this.buscarArticuloPorPredicateID(articuloDTOCols, articuloResultDTO.getId());
					if (articuloDTOExt != null) {
						BeanUtils.copyProperties(articuloDTOExt, articuloResultDTO, new String[] { "estadoPerecibleReceta", "npImplemento"});
					}
				}
			}
	
			return resultDTO;
			
		} catch (SICException sicException){
			throw sicException;
		}
	}
	
	public SearchResultDTO<ArticuloDTO> buscarArticuloBasico(Criterion criterioBusqueda , Integer firstResult ,Integer maxResults , Boolean findNum , BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException{
		try{
			return articuloDAO.buscarArticuloBasico(criterioBusqueda , firstResult , maxResults , findNum , busquedaSimpleArticuloVO);
		}catch(Exception e){
			LOG_SICV2.error("ocurrio un error en la busqueda de articulos: "+e.getMessage());
			throw new SICException("ocurrio un error en la busqueda de articulos");
		}
	}

	/*
	 * public SearchResultDTO<ArticuloDTO> buscarArticulosSimpleCupon(ArticuloVO
	 * articuloVO,Set<TipoRelacionArticulo> relacionArticulos) throws
	 * SICException { for(ArticuloDTO articuloResultDTO :
	 * resultDTO.getResults()){ ArticuloDTO articuloDTOExt = new ArticuloDTO();
	 * articuloDTOExt.setId(articuloResultDTO.getId()); for(TipoRelacionArticulo
	 * tipoRelacionArticulo : relacionArticulos){
	 * this.cargarRelacion(articuloDTOExt, tipoRelacionArticulo); }
	 * Collection<ArticuloDTO> articuloDTOCols =
	 * dataGestor.findObjects(articuloDTOExt); if(!articuloDTOCols.isEmpty()){
	 * ArticuloDTO articuloDTOInfo = articuloDTOCols.iterator().next();
	 * BeanUtils.copyProperties(articuloDTOInfo, articuloResultDTO,new
	 * String[]{"estadoPerecibleReceta","npImplemento","codigoBarrasActivo"}); }
	 * }
	 * 
	 * return resultDTO; }
	 */

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionesSegmentoCreacion(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneSegmentoCreacionArticulo()) {
			SegmentoCreacionArticuloDTO segmentoCreacionArticuloDTO = new SegmentoCreacionArticuloDTO();
			articuloDTO.setSegmentoCreacionArticulos(new ArrayList<SegmentoCreacionArticuloDTO>());
			articuloDTO.getSegmentoCreacionArticulos().add(segmentoCreacionArticuloDTO);
			articuloDTO.getSegmentoCreacionArticulos().iterator().next().setPasoCreacion(new CatalogoValorDTO());
			articuloDTO.setOrderByField(OrderBy.orderAsc(new String[] { "segmentoCreacionArticulos.id.valorPasoCreacion" }));
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionesEstadoCodificacionArticulo(final ArticuloDTO articuloDTO) {
		// articuloDTO.setEstadoCodificacionArticuloDTO(new
		// EstadoCodificacionArticuloDTO());

		articuloDTO.setEstadoTipoArticulo(new EstadoTipoArticuloDTO());
		articuloDTO.getEstadoTipoArticulo().setEstadoCodificacionArticuloDTO(new EstadoCodificacionArticuloDTO());
		articuloDTO.getEstadoTipoArticulo().setTipoArticuloDTO(new TipoArticuloDTO());
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionesClasificacion(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneClasificacion()) {
			// carga la clasficacion
			articuloDTO.setClasificacionDTO(new ClasificacionDTO());
			// articuloDTO.getClasificacionDTO().addJoinCriteriaSearchParameter(new
			// CriteriaSearchParameter<String>("estadoClasificacion",
			// ComparatorTypeEnum.EQUAL_COMPARATOR,
			// SICConstantes.ESTADO_ACTIVO_NUMERICO));
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionesDepartamento(final ArticuloDTO articuloDTO) {
		if (articuloDTO.getTieneClasificacion()) {
			// carga el departamento
			if (!articuloDTO.getClasificacionDTO().getTieneClasificacionPadre()) {
				articuloDTO.getClasificacionDTO().setClasificacionPadre(new ClasificacionDTO());
				articuloDTO.getClasificacionDTO().getClasificacionPadre().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoClasificacion", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			}
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionesClaseArticulo(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneClaseArticulo()) {
			articuloDTO.setClaseArticuloDTO(new ClaseArticuloDTO());
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionesBodega(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneClasificacion()) {
			this.asignarRelacionesClasificacion(articuloDTO);
		}
		// carga bodega
		articuloDTO.getClasificacionDTO().setBodegaDTO(new BodegaDTO());
		// articuloDTO.getClasificacionDTO().getBodegaDTO().addJoinCriteriaSearchParameter(new
		// CriteriaSearchParameter<String>("estadoBodega",
		// ComparatorTypeEnum.EQUAL_COMPARATOR,
		// SICConstantes.ESTADO_ACTIVO_NUMERICO));
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionesSubClasificacion(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneSubClasificacion()) {
			// carga la subclasificacion
			articuloDTO.setSubClasificacionDTO(new SubClasificacionDTO());
			// articuloDTO.getSubClasificacionDTO().addJoinCriteriaSearchParameter(new
			// CriteriaSearchParameter<String>("estadoSubClasificacion",
			// ComparatorTypeEnum.EQUAL_COMPARATOR,
			// SICConstantes.ESTADO_ACTIVO_NUMERICO));
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionesArticuloUnidadManejo(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneUnidadManejoCol()) {
			ArticuloUnidadManejoDTO unidadManejoDTO = new ArticuloUnidadManejoDTO();

			// carga la relacion ArticuloUnidadManejoUsoDTO
			ArticuloUnidadManejoUsoDTO usoDTO = new ArticuloUnidadManejoUsoDTO();
			unidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
			unidadManejoDTO.getArticuloUnidadManejoUsoCol().add(usoDTO);
			// carga la relacion tipo empaque
			unidadManejoDTO.setTipoUnidadEmpaque(new CatalogoValorDTO());
			// filtra las unidades de manejo no sean contenedoras
			unidadManejoDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoUnidadManejoContenida", ComparatorTypeEnum.IS_NULL));

			
			
			// CAMBIAR NUEVO MODELO
			// se carga la relacion para articuloUnidadManejoProveedorDTO
			unidadManejoDTO.setArticuloUnidadManejoProveedorCol(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
			ArticuloUnidadManejoProveedorDTO ump = new ArticuloUnidadManejoProveedorDTO();			
			ump.setEquivalenciaPorcentajeDescuentoCol(new ArrayList<EquivalenciaPorcentajeDescuentoDTO>());
			
			EquivalenciaPorcentajeDescuentoDTO equivalencia = new EquivalenciaPorcentajeDescuentoDTO();
			equivalencia.setJoinType(JoinType.LEFT);
			// <>TIPODESCUENTO
			equivalencia.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
			equivalencia.getAsignacionTipoDescuento().setTipoDescuento(new TipoDescuentoDTO());
			equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento()));
			equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO));
			equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento()));
			equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO));
			ump.getEquivalenciaPorcentajeDescuentoCol().add(equivalencia);
			
			//ump.setEquivalenciaPorcentajeDescuentoDTO(new EquivalenciaPorcentajeDescuentoDTO());
			//ump.getEquivalenciaPorcentajeDescuentoDTO().setJoinType(JoinType.LEFT);
			//ump.getEquivalenciaPorcentajeDescuentoDTO().setTipoDescuento(new TipoDescuentoDTO());
			ump.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			unidadManejoDTO.getArticuloUnidadManejoProveedorCol().add(ump);

			// se carga las relaciones para unidad de manejo contenedor
			ArticuloUnidadManejoDTO unidadManejoContenedor = new ArticuloUnidadManejoDTO();
			unidadManejoContenedor.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoUnidadManejo", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));

			unidadManejoDTO.setArticuloUnidadManejoContenedoraCol(new ArrayList<ArticuloUnidadManejoDTO>());
			unidadManejoDTO.getArticuloUnidadManejoContenedoraCol().add(unidadManejoContenedor);

			// ordenar prioridad
			unidadManejoDTO.setOrderByField(OrderBy.orderAsc("prioridad"));

			articuloDTO.setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
			articuloDTO.getArticuloUnidadManejoCol().add(unidadManejoDTO);
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionesArticuloUnidadManejoVenta(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneUnidadManejoCol()) {
			// Uso
			ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTO = new ArticuloUnidadManejoUsoDTO();
			//articuloUnidadManejoUsoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			articuloUnidadManejoUsoDTO.setCriteriaSearch(new CriteriaSearch());
			articuloUnidadManejoUsoDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("id.valorTipoUso", ComparatorTypeEnum.IN_COMPARATOR, new String[] { SICArticuloConstantes.getInstancia().VALORUSOUNIMANDESPACHO, SICArticuloConstantes.getInstancia().VALORUSOUNIMANVENTA }));
			Collection<ArticuloUnidadManejoUsoDTO> articuloUnidadManejoUsoCol = new ArrayList<ArticuloUnidadManejoUsoDTO>();
			articuloUnidadManejoUsoDTO.setTipoUso(new CatalogoValorDTO());
			articuloUnidadManejoUsoCol.add(articuloUnidadManejoUsoDTO);
			// Unindad de manejo
			ArticuloUnidadManejoDTO articuloUnidadManejoDTO = new ArticuloUnidadManejoDTO();
			articuloUnidadManejoDTO.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
			articuloUnidadManejoDTO.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
			//articuloUnidadManejoDTO.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			articuloUnidadManejoDTO.setTipoUnidadEmpaque(new CatalogoValorDTO());
			articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(articuloUnidadManejoUsoCol);

			articuloDTO.setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
			articuloDTO.getArticuloUnidadManejoCol().add(articuloUnidadManejoDTO);
		}

		if (!articuloDTO.getTieneArticuloPrecio()) {
			ArticuloPrecioDTO apFiltro = new ArticuloPrecioDTO();
			apFiltro.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoPrecio", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			// relacion con los precios generales
			articuloDTO.setArticuloPrecioCol(new ArrayList<ArticuloPrecioDTO>());
			articuloDTO.getArticuloPrecioCol().add(apFiltro);
		}
	}

	private void asignarRelacionesArticuloUnidadManejoRecepcion(final ArticuloDTO articuloDTO) {
		// unidad manejo
		ArticuloUnidadManejoDTO unidadManejoDTO = new ArticuloUnidadManejoDTO();
		unidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
		unidadManejoDTO.getArticuloUnidadManejoUsoCol().add(new ArticuloUnidadManejoUsoDTO());
		// carga la relacion tipo empaque
		unidadManejoDTO.setTipoUnidadEmpaque(new CatalogoValorDTO());
		// filtra las unidades de manejo no sean contenedoras
		unidadManejoDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoUnidadManejoContenida", ComparatorTypeEnum.IS_NULL));
		// se carga las relaciones para unidad de manejo contenedor
		ArticuloUnidadManejoDTO unidadManejoContenedor = new ArticuloUnidadManejoDTO();
		unidadManejoContenedor.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoUnidadManejo", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		unidadManejoDTO.setArticuloUnidadManejoContenedoraCol(new ArrayList<ArticuloUnidadManejoDTO>());
		unidadManejoDTO.getArticuloUnidadManejoContenedoraCol().add(unidadManejoContenedor);

		// unidad manejo proveedor
		ArticuloUnidadManejoProveedorDTO ump = new ArticuloUnidadManejoProveedorDTO();
		ump.setEquivalenciaPorcentajeDescuentoCol(new ArrayList<EquivalenciaPorcentajeDescuentoDTO>());
		EquivalenciaPorcentajeDescuentoDTO equivalencia = new EquivalenciaPorcentajeDescuentoDTO();
		// <>TIPODESCUENTO
		equivalencia.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
		equivalencia.getAsignacionTipoDescuento().setTipoDescuento(new TipoDescuentoDTO());
		equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento()));
		equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO));
		equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento()));
		equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO));
		ump.getEquivalenciaPorcentajeDescuentoCol().add(equivalencia);
		
		//ump.setEquivalenciaPorcentajeDescuentoDTO(new EquivalenciaPorcentajeDescuentoDTO());
		//ump.getEquivalenciaPorcentajeDescuentoDTO().setTipoDescuento(new TipoDescuentoDTO());
		ump.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		ump.setArticuloUnidadManejoDTO(unidadManejoDTO);

		// se unen las relaciones principales y se asignan al articulo
		if (!articuloDTO.getTieneArticuloProveedor()) {
			this.asignarRelacionArticuloProveedor(articuloDTO);
		}
		ArticuloProveedorDTO articuloProveedorDTO = articuloDTO.getArticuloProveedorCol().iterator().next();
		articuloProveedorDTO.setUnidadesManejo(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
		articuloProveedorDTO.getUnidadesManejo().add(ump);
		articuloDTO.setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
		articuloDTO.getArticuloProveedorCol().add(articuloProveedorDTO);
		articuloDTO.setArticuloPrecioCol(new ArrayList<ArticuloPrecioDTO>());
		articuloDTO.getArticuloPrecioCol().add(new ArticuloPrecioDTO());
	}
	
	public void completarDatosUnidadManejoProveedor(final ArticuloProveedorDTO articuloProveedorDTO) throws SICException{
		try{
		// unidad manejo
			ArticuloUnidadManejoDTO unidadManejoDTO = new ArticuloUnidadManejoDTO();
			unidadManejoDTO.getId().setCodigoArticulo(articuloProveedorDTO.getId().getCodigoArticulo());
			unidadManejoDTO.getId().setCodigoCompania(articuloProveedorDTO.getId().getCodigoCompania());
			unidadManejoDTO.setEstadoUnidadManejo(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO);
			unidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
			//unidad manejo uso
			ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTO = new ArticuloUnidadManejoUsoDTO();
			articuloUnidadManejoUsoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			articuloUnidadManejoUsoDTO.getId().setValorTipoUso(SICArticuloConstantes.getInstancia().VALORUSOUNIMANCOMPRA);
			
			unidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
			unidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTO);
			// carga la relacion tipo empaque
			unidadManejoDTO.setTipoUnidadEmpaque(new CatalogoValorDTO());
			// filtra las unidades de manejo no sean contenedoras
			unidadManejoDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoUnidadManejoContenida", ComparatorTypeEnum.IS_NULL));
			// se carga las relaciones para unidad de manejo contenedor
			ArticuloUnidadManejoDTO unidadManejoContenedor = new ArticuloUnidadManejoDTO();
			unidadManejoContenedor.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoUnidadManejo", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			unidadManejoDTO.setArticuloUnidadManejoContenedoraCol(new ArrayList<ArticuloUnidadManejoDTO>());
			unidadManejoDTO.getArticuloUnidadManejoContenedoraCol().add(unidadManejoContenedor);

			// unidad manejo proveedor
			ArticuloUnidadManejoProveedorDTO ump = new ArticuloUnidadManejoProveedorDTO();
			ump.getId().setCodigoCompania(articuloProveedorDTO.getId().getCodigoCompania());
			ump.getId().setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
			ump.setEstado(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO);
			ump.setArticuloUnidadManejoDTO(unidadManejoDTO);
			
			//equivalencia
			EquivalenciaPorcentajeDescuentoDTO equivalenciaPorcentajeDescuentoDTO = new EquivalenciaPorcentajeDescuentoDTO();
			// <>TIPODESCUENTO
			equivalenciaPorcentajeDescuentoDTO.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
			equivalenciaPorcentajeDescuentoDTO.getAsignacionTipoDescuento().setTipoDescuento(new TipoDescuentoDTO());
			equivalenciaPorcentajeDescuentoDTO.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento()));
			equivalenciaPorcentajeDescuentoDTO.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO));
			equivalenciaPorcentajeDescuentoDTO.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento()));
			equivalenciaPorcentajeDescuentoDTO.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO));
			ump.setEquivalenciaPorcentajeDescuentoCol(new ArrayList<EquivalenciaPorcentajeDescuentoDTO>());
			ump.getEquivalenciaPorcentajeDescuentoCol().add(equivalenciaPorcentajeDescuentoDTO);
			
			Collection<ArticuloUnidadManejoProveedorDTO> articuloUnidadManejoProveedorCol = dataGestor.findObjects(ump);
			articuloProveedorDTO.setUnidadesManejo(articuloUnidadManejoProveedorCol);
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Ha ocurrido un error al consultar las unidades de manejo del proveedor: "+e.getMessage());
			throw new SICException("Ha ocurrido un error al consultar las unidades de manejo del proveedor");
		}
	}

	private void asignarRelacionesArticuloRelacion(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloRelacionado()) {

			ArticuloRelacionDTO articuloRelacionDTO = new ArticuloRelacionDTO();
			articuloRelacionDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));

			articuloDTO.setArticuloRelacionCol(new ArrayList<ArticuloRelacionDTO>());
			articuloDTO.getArticuloRelacionCol().add(articuloRelacionDTO);

		}
	}

	private void asignarRelacionesArticuloAgrupador(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloAgrupador()) {

			ArticuloAgrupadorDTO agrupadorDTO = new ArticuloAgrupadorDTO();
			agrupadorDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));

			agrupadorDTO.setTipoAgrupador(new CatalogoValorDTO());

			articuloDTO.setArticuloAgrupadorCol(new ArrayList<ArticuloAgrupadorDTO>());
			articuloDTO.getArticuloAgrupadorCol().add(agrupadorDTO);

		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionesArticuloComercial(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloComercial()) {
			ArticuloComercialDTO articuloComercialDTO = new ArticuloComercialDTO();
			articuloComercialDTO.setMarcaComercialArticulo(new MarcaArticuloDTO());
			articuloDTO.setArticuloComercialDTO(articuloComercialDTO);
		}
	}
	
	/**
	 * Agrega la relacion para el cambio de clase
	 * @param articuloDTO
	 * @author eharo
	 */
	private void asignarRelacionesArticuloClase(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloClase()) {
			ArticuloClaseDTO articuloClaseDTO = new ArticuloClaseDTO();
			articuloDTO.setArticuloClaseDTO(articuloClaseDTO);
		}
	}
	private void asignarRelacionesArticuloMarca(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloComercial()) {
			this.asignarRelacionesArticuloComercial(articuloDTO);
		}
		articuloDTO.getArticuloComercialDTO().setMarcaComercialArticulo(new MarcaArticuloDTO());
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionesDescuentoVenta(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneDescuentoVentaArticulo()) {
			DescuentoVentaArticuloDTO descuentoVentaArticuloDTO = new DescuentoVentaArticuloDTO();
			descuentoVentaArticuloDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			descuentoVentaArticuloDTO.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
			descuentoVentaArticuloDTO.getAsignacionTipoDescuento();
			descuentoVentaArticuloDTO.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			descuentoVentaArticuloDTO.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, SICArticuloConstantes.getInstancia().TIPODESCUENTO_CUPON));
			descuentoVentaArticuloDTO.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento()));
			descuentoVentaArticuloDTO.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.VENTA.getValorTipoAplicacionDescuento()));
			
//			descuentoVentaArticuloDTO.setTipoDescuento(new TipoDescuentoDTO());
//			descuentoVentaArticuloDTO.getTipoDescuento();
//			descuentoVentaArticuloDTO.getTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			articuloDTO.setDescuentoVentaArticuloCol(new LinkedHashSet<DescuentoVentaArticuloDTO>());
			articuloDTO.getDescuentoVentaArticuloCol().add(descuentoVentaArticuloDTO);
		}
	}

	private void asignarRelacionArticuloGarantia(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloGarantia()) {
			articuloDTO.setArticuloGarantiaDTO(new ArticuloGarantiaDTO());
		}
	}

	private void asignarRelacionArticuloProcesoLogistico(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloProcesoLogistico()) {
			articuloDTO.setArticuloProcesoLogisticoDTO(new ArticuloProcesoLogisticoDTO());
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 * @throws SICException
	 */
	@Override
	public void asignarRelacionesArticuloCosto(ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloProveedor()) {
			this.asignarRelacionArticuloProveedor(articuloDTO);
		}
		ArticuloProveedorDTO apFiltro = articuloDTO.getArticuloProveedorCol().iterator().next();
		asignarRelacionesArticuloCosto(apFiltro);
	}
	
	/**
	 * 
	 * @param articuloDTO
	 * @throws SICException
	 */
	public void asignarRelacionesArticuloDescuento(ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloProveedor()) {
			this.asignarRelacionArticuloProveedor(articuloDTO);
		}
		ArticuloProveedorDTO apFiltro = articuloDTO.getArticuloProveedorCol().iterator().next();
		asignarRelacionesDecuentoArticuloProveedor(apFiltro);
	}

	/**
	 * Llena las relaciones para un correcto c&aacute;lculo del costo neto
	 * 
	 * @param articuloProveedorDTO
	 * @throws SICException
	 */
	@Override
	public void asignarRelacionesArticuloCosto(ArticuloProveedorDTO articuloProveedorDTO) {
		ArticuloUnidadManejoProveedorDTO ump = new ArticuloUnidadManejoProveedorDTO();
		ump.setEquivalenciaPorcentajeDescuentoCol(new ArrayList<EquivalenciaPorcentajeDescuentoDTO>());
		EquivalenciaPorcentajeDescuentoDTO equivalencia = new EquivalenciaPorcentajeDescuentoDTO();
		// <>TIPODESCUENTO
		equivalencia.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
		equivalencia.getAsignacionTipoDescuento().setTipoDescuento(new TipoDescuentoDTO());
		equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento()));
		equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO));
		equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento()));
		equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO));
		ump.getEquivalenciaPorcentajeDescuentoCol().add(equivalencia);
		
		//ump.setEquivalenciaPorcentajeDescuentoDTO(new EquivalenciaPorcentajeDescuentoDTO());
		//ump.getEquivalenciaPorcentajeDescuentoDTO().setTipoDescuento(new TipoDescuentoDTO());

		ump.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		ump.setArticuloUnidadManejoDTO(new ArticuloUnidadManejoDTO());
		ump.getArticuloUnidadManejoDTO().setTipoUnidadEmpaque(new CatalogoValorDTO());

		ump.getArticuloUnidadManejoDTO().setArticuloUnidadManejoContenedoraCol(new ArrayList<ArticuloUnidadManejoDTO>());
		ump.getArticuloUnidadManejoDTO().getArticuloUnidadManejoContenedoraCol().add(new ArticuloUnidadManejoDTO());
		ump.getArticuloUnidadManejoDTO().setCriteriaSearch(new CriteriaSearch());
		ump.getArticuloUnidadManejoDTO().getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Long>("codigoUnidadManejoContenida", ComparatorTypeEnum.IS_NULL));

		articuloProveedorDTO.setUnidadesManejo(new ArrayList<ArticuloUnidadManejoProveedorDTO>());
		articuloProveedorDTO.getUnidadesManejo().add(ump);
		
		// <>TIPODESCUENTO
		DescuentoProveedorArticuloDTO dpa = new DescuentoProveedorArticuloDTO();
		dpa.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
		dpa.getAsignacionTipoDescuento().setTipoDescuento(new TipoDescuentoDTO());
//		dpa.getAsignacionTipoDescuento().getTipoDescuento().setTipoUsoDescuento(new CatalogoValorDTO());
		dpa.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento()));
		dpa.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO));
		dpa.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAplicacionTipoDescuento", ComparatorTypeEnum.IN_COMPARATOR, new String[]{EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento(), EnumTipoAplicacionDescuento.COSTO_CONVENIO.getValorTipoAplicacionDescuento()}));
		dpa.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO));
		dpa.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));

		dpa.setOrderByField(OrderBy.orderAsc("asignacionTipoDescuento.prioridad"));

		dpa.setEquivalenciaPorcentajeDescuento(new EquivalenciaPorcentajeDescuentoDTO());

		articuloProveedorDTO.setDescuentoProveedorArticuloCol(new ArrayList<DescuentoProveedorArticuloDTO>());
		articuloProveedorDTO.getDescuentoProveedorArticuloCol().add(dpa);
		articuloProveedorDTO.setArticuloImportacion(new ArticuloImportacionDTO());
	}
	
	public void asignarRelacionesDecuentoArticuloProveedor(ArticuloProveedorDTO articuloProveedorDTO){
		DescuentoProveedorArticuloDTO dpa = new DescuentoProveedorArticuloDTO();
		dpa.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
		dpa.getAsignacionTipoDescuento().setTipoDescuento(new TipoDescuentoDTO());
//		dpa.getAsignacionTipoDescuento().getTipoDescuento().setTipoUsoDescuento(new CatalogoValorDTO());
		dpa.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));

		dpa.setOrderByField(OrderBy.orderAsc("asignacionTipoDescuento.prioridad"));

		dpa.setEquivalenciaPorcentajeDescuento(new EquivalenciaPorcentajeDescuentoDTO());

		articuloProveedorDTO.setDescuentoProveedorArticuloCol(new ArrayList<DescuentoProveedorArticuloDTO>());
		articuloProveedorDTO.getDescuentoProveedorArticuloCol().add(dpa);
		articuloProveedorDTO.setArticuloImportacion(new ArticuloImportacionDTO());
	}
	

	@Override
	public void asignarRelacionesPrecio(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloPrecio()) {
			ArticuloPrecioDTO apFiltro = new ArticuloPrecioDTO();
			apFiltro.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoPrecio", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			// relacion con los precios por local
			if (articuloDTO.getNpCodigoLocal() != null) {
				ArticuloLocalPrecioDTO alp = new ArticuloLocalPrecioDTO();
				alp.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoPrecio", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
				alp.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("id.codigoLocal", ComparatorTypeEnum.EQUAL_COMPARATOR, articuloDTO.getNpCodigoLocal()));
				apFiltro.setArticuloLocalPrecioCol(new ArrayList<ArticuloLocalPrecioDTO>());
				apFiltro.getArticuloLocalPrecioCol().add(alp);
			}

			ArticuloUnidadManejoDTO aum = new ArticuloUnidadManejoDTO();
			aum.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
			aum.getArticuloUnidadManejoUsoCol().add(new ArticuloUnidadManejoUsoDTO());
			apFiltro.setArticuloUnidadManejo(aum);

			// relacion con los precios generales
			articuloDTO.setArticuloPrecioCol(new ArrayList<ArticuloPrecioDTO>());
			articuloDTO.getArticuloPrecioCol().add(apFiltro);
		}
	}

	@Override
	public void asignarRelacionesArticuloImpuesto(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloImpuestoCol()) {
			ArticuloImpuestoDTO ai = new ArticuloImpuestoDTO();
			ai.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloImpuesto", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			ai.setTipoImpuestoArticulo(new TipoImpuestoDTO());
			ai.getTipoImpuestoArticulo().setGrupoImpuesto(new GrupoImpuestoDTO());
			ai.getTipoImpuestoArticulo().getGrupoImpuesto().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			articuloDTO.setArticuloImpuestoCol(new ArrayList<ArticuloImpuestoDTO>());
			articuloDTO.getArticuloImpuestoCol().add(ai);
		}
	}

	/**
	 * Asigna las relaciones para obtener un c&aacute;lculo correcto de los
	 * precios del art&iacute;culo
	 * 
	 * @param articuloDTO
	 * @throws SICException
	 */
	@Override
	public void asignarRelacionesArticuloPrecio(ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloPrecio()) {
			ArticuloPrecioDTO apFiltro = new ArticuloPrecioDTO();
			apFiltro.setTipoPrecioArticulo(new TipoPrecioArticuloDTO());
			apFiltro.setOrderByField(OrderBy.orderDesc("tipoPrecioArticulo.orden"));
			apFiltro.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoPrecio", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			// relacion con la unidad de manejo
			ArticuloUnidadManejoDTO aum = new ArticuloUnidadManejoDTO();
			// aum.addJoinCriteriaSearchParameter(new
			// CriteriaSearchParameter<String>("estadoUnidadManejo",
			// ComparatorTypeEnum.EQUAL_COMPARATOR,
			// SICConstantes.ESTADO_ACTIVO_NUMERICO));
			aum.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
			aum.getArticuloUnidadManejoUsoCol().add(new ArticuloUnidadManejoUsoDTO());
			apFiltro.setArticuloUnidadManejo(aum);
			// relacion con los precios por local
			if (articuloDTO.getNpCodigoLocal() != null) {
				ArticuloLocalPrecioDTO alp = new ArticuloLocalPrecioDTO();
				alp.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoPrecio", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
				alp.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("id.codigoLocal", ComparatorTypeEnum.EQUAL_COMPARATOR, articuloDTO.getNpCodigoLocal()));
				apFiltro.setArticuloLocalPrecioCol(new ArrayList<ArticuloLocalPrecioDTO>());
				apFiltro.getArticuloLocalPrecioCol().add(alp);
			}
			// relacion con los precios generales
			articuloDTO.setArticuloPrecioCol(new ArrayList<ArticuloPrecioDTO>());
			articuloDTO.getArticuloPrecioCol().add(apFiltro);
		}
		if (!articuloDTO.getTieneDescuentoVentaArticulo()) {
			articuloDTO.addJoin("descuentoVentaArticuloCol", JoinType.LEFT, new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		}
		asignarRelacionesArticuloImpuesto(articuloDTO);
		asignarRelacionArticuloMedidaDTO(articuloDTO);
		if (!articuloDTO.getTieneArticuloComercial()) {
			articuloDTO.setArticuloComercialDTO(new ArticuloComercialDTO()); // relacion para obtener los porcentajes para los calculos
		}
	}

	/**
	 * Asigna las relaciones para obtener los locales donde tiene alcance un
	 * art&iacute;culo
	 * 
	 * @param articuloDTO
	 */
	@Override
	public void asignarRelacionesArticuloAlcance(ArticuloDTO articuloDTO) {
		Date currentDate = new Date();
		ArticuloLocalDTO al = new ArticuloLocalDTO();
		al.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloLocal", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		al.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Date>("fechaInicialAlcance", ComparatorTypeEnum.LESS_THAN_OR_EQUAL_COMPARATOR, currentDate));
		al.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Date>("fechaFinalAlcance", ComparatorTypeEnum.GREATER_THAN_OR_EQUAL_COMPARATOR, currentDate));

		if (articuloDTO.getNpCodigoLocal() != null) {
			al.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("id.codigoLocal", ComparatorTypeEnum.EQUAL_COMPARATOR, articuloDTO.getNpCodigoLocal()));
		}
		articuloDTO.setArticuloLocalCol(new ArrayList<ArticuloLocalDTO>());
		articuloDTO.getArticuloLocalCol().add(al);
	}

	/**
	 * 
	 * @param ap
	 * @throws SICException
	 */
	@Override
	public void asignarRelacionesArticuloPrecio(ArticuloPrecioDTO ap) {
		if (!SearchDTO.isLoaded(ap.getArticulo())) {
			ap.setArticulo(new ArticuloDTO()); // relacion con articulo
		}
		if (!ap.getArticulo().getTieneArticuloPrecio()) {
			ap.getArticulo().addJoin("articuloPrecioCol", JoinType.LEFT, new CriteriaSearchParameter<String>("estadoPrecio", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		}
		if (!ap.getArticulo().getTieneArticuloImpuestoCol()) {
			ArticuloImpuestoDTO ai = new ArticuloImpuestoDTO();
			ai.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloImpuesto", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			ai.setTipoImpuestoArticulo(new TipoImpuestoDTO());
			ap.getArticulo().setArticuloImpuestoCol(new ArrayList<ArticuloImpuestoDTO>());
			ap.getArticulo().getArticuloImpuestoCol().add(ai);
		}
		if (!SearchDTO.isLoaded(ap.getArticulo().getArticuloComercialDTO()))
			ap.getArticulo().setArticuloComercialDTO(new ArticuloComercialDTO()); // relacion para obtener los porcentajes para los calculos
		if (!SearchDTO.isLoaded(ap.getTipoPrecioArticulo()))
			ap.setTipoPrecioArticulo(new TipoPrecioArticuloDTO());
		if (!SearchDTO.isLoaded(ap.getArticuloUnidadManejo())) {
			ap.setArticuloUnidadManejo(new ArticuloUnidadManejoDTO()); // relacion con la unidad de manejo y con el uso
			ap.getArticuloUnidadManejo().setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
			ap.getArticuloUnidadManejo().getArticuloUnidadManejoUsoCol().add(new ArticuloUnidadManejoUsoDTO());
		}
		if (!ap.getArticulo().getTieneDescuentoVentaArticulo())
			ap.getArticulo().addJoin("descuentoVentaArticuloCol", JoinType.LEFT, new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
	}

	// /**
	// *
	// * @param articuloDTO
	// */
	// @Override
	// public void asignarRegistroSanitario(ArticuloDTO articuloDTO){
	// ArticuloRegistroSanitarioDTO registroSanitarioDTO = new
	// ArticuloRegistroSanitarioDTO();
	// registroSanitarioDTO.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
	// registroSanitarioDTO.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
	// registroSanitarioDTO.setTipoMedida(new CatalogoValorDTO());
	// registroSanitarioDTO.setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
	// registroSanitarioDTO.setArtDefArcCol(new
	// ArrayList<ArticuloDefinicionArchivoDTO>());
	// registroSanitarioDTO.getArtDefArcCol().add(new
	// ArticuloDefinicionArchivoDTO());
	// ArticuloRegistroSanitarioDTO registroSanitarioActivoDTO =
	// dataGestor.findUnique(registroSanitarioDTO);
	// if(registroSanitarioActivoDTO == null){
	// registroSanitarioActivoDTO = new ArticuloRegistroSanitarioDTO();
	// registroSanitarioActivoDTO.setArticuloDTO(articuloDTO);
	// registroSanitarioActivoDTO.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
	// registroSanitarioActivoDTO.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
	// registroSanitarioActivoDTO.setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
	// articuloDTO.addDynamicProperty("RegSan",registroSanitarioActivoDTO);
	//
	// }
	// registroSanitarioActivoDTO.setArticuloDTO(articuloDTO);
	// articuloDTO.addDynamicProperty("RegSan",registroSanitarioActivoDTO);
	// articuloDTO.addDynamicProperty("DatosConsRegSan", Boolean.TRUE);
	// if(articuloDTO.getTieneArticuloComercial()){
	// articuloDTO.addDynamicProperty("codigoPais",
	// (articuloDTO.getArticuloComercialDTO().getTienePaisOrigen() &&
	// articuloDTO.getArticuloComercialDTO().getCodigoPaisOrigen() != null) ?
	// articuloDTO.getArticuloComercialDTO().getPaisOrigen().getCodigoDivGeoPolRoot()
	// : "");
	// }else{
	// ArticuloComercialDTO articuloComercialDTO = new ArticuloComercialDTO();
	// articuloComercialDTO.getId().setCodigoArticulo(articuloDTO.getId().getCodigoArticulo());
	// articuloComercialDTO.getId().setCodigoCompania(articuloDTO.getId().getCodigoCompania());
	// articuloDTO.setArticuloComercialDTO(articuloComercialDTO);
	// articuloDTO.addDynamicProperty("codigoPais","");
	// }
	// articuloDTO.addDynamicProperty("listaCiudades", new
	// ArrayList<DivisionGeoPoliticaDTO>());
	//
	//
	// //IMPLEMENTACION DE ARTICULO TRANSGENICO
	//
	// if(!CollectionUtils.isEmpty(articuloDTO.getArticuloDefinicionArchivoCol())){
	// articuloDTO.addDynamicProperty("ArchivoRegSan",
	// articuloDTO.getArticuloDefinicionArchivoCol().iterator().next());
	// }
	// }

	@Override
	public Double calculoDescuentoParcial(Double costoBrutoParcial, Double porcentajeDescuento) {
		Double costoParcial;
		costoParcial = costoBrutoParcial * (1 - porcentajeDescuento / 100);
		return costoParcial;
	}

	/**
	 * 
	 * @param ap
	 * @throws SICException
	 */
	@Override
	public void asignarRelacionesArticuloLocalPrecio(ArticuloLocalPrecioDTO alp) {
		if (alp.getArticuloLocal() == null)
			alp.setArticuloLocal(new ArticuloLocalDTO());
		if (!alp.getArticuloLocal().getTieneArticuloLocalMargenCol()) {
			ArticuloLocalMargenDTO alm = new ArticuloLocalMargenDTO();
			alm.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			alm.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Date>("fechaInicial", ComparatorTypeEnum.LESS_THAN_OR_EQUAL_COMPARATOR, new Date()));
			alm.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Date>("fechaFinal", ComparatorTypeEnum.GREATER_THAN_OR_EQUAL_COMPARATOR, new Date()));
			alp.getArticuloLocal().setArticuloLocalMargenCol(new HashSet<ArticuloLocalMargenDTO>());
			alp.getArticuloLocal().getArticuloLocalMargenCol().add(alm);
		}
	}
	
	private void asignarRelacionArticuloAuditoria(ArticuloDTO articuloDTO){
		if(!SearchDTO.isLoaded(articuloDTO.getUsuarioCreacionDTO())){
			articuloDTO.setUsuarioCreacionDTO(new UserDto());
		}
		if(!SearchDTO.isLoaded(articuloDTO.getUsuarioActualizacionDTO())){
			articuloDTO.setUsuarioActualizacionDTO(new UserDto());
		}
	}

	/**
	 * 
	 * @param articuloVO
	 */
	private void asignarRelacionArticuloProveedor(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloProveedor()) {
			ArticuloProveedorDTO articuloProveedorDTO = new ArticuloProveedorDTO();
			if(articuloDTO.hasDynamicProperty("estadoProveedor")){
				articuloProveedorDTO.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			}
			
			// articuloProveedorDTO.addJoinCriteriaSearchParameter(new
			// CriteriaSearchParameter<String>("estadoArticuloProveedor",ComparatorTypeEnum.EQUAL_COMPARATOR,
			// SICConstantes.ESTADO_ACTIVO_NUMERICO));
			articuloProveedorDTO.setVistaProveedor(new VistaProveedorDTO());
			articuloProveedorDTO.setTipoPlazoPago(new CatalogoValorDTO());
			articuloProveedorDTO.getVistaProveedor().setProveedorImportado(new ProveedorImportadoDTO());
			articuloProveedorDTO.getVistaProveedor().setProveedorComercial(new ProveedorComercialDTO());
			articuloProveedorDTO.setArticuloImportacion(new ArticuloImportacionDTO());
			articuloProveedorDTO.setArticuloProveedorImpuestoCol(new ArrayList<ArticuloProveedorImpuestoDTO>());
			ArticuloProveedorImpuestoDTO articuloProveedorImpuestoDTO = new ArticuloProveedorImpuestoDTO();
			articuloProveedorImpuestoDTO.setTipoImpuestoDTO(new TipoImpuestoDTO());
			articuloProveedorDTO.getArticuloProveedorImpuestoCol().add(articuloProveedorImpuestoDTO);
//			articuloProveedorDTO.setProveedor(new ProveedorDTO());
			articuloDTO.setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
			articuloDTO.getArticuloProveedorCol().add(articuloProveedorDTO);
		}
	}

	/**
	 * 
	 * @param articuloVO
	 */
	private void asignarRelacionArticuloDescuento(final ArticuloDTO articuloDTO) {

		if (!articuloDTO.getTieneArticuloProveedor()) {
			this.asignarRelacionArticuloProveedor(articuloDTO);
		}

		ArticuloProveedorDTO articuloProveedorDTO = articuloDTO.getArticuloProveedorCol().iterator().next();
		DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO = new DescuentoProveedorArticuloDTO();
		descuentoProveedorArticuloDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		// <>TIPODESCUENTO
		descuentoProveedorArticuloDTO.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
		descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().setTipoDescuento(new TipoDescuentoDTO());
//		descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().getTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento()));
		descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO));
		descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAplicacionTipoDescuento", ComparatorTypeEnum.IN_COMPARATOR, new String[]{EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento(), EnumTipoAplicacionDescuento.COSTO_CONVENIO.getValorTipoAplicacionDescuento()}));
		descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO));
		descuentoProveedorArticuloDTO.setEquivalenciaPorcentajeDescuento(new EquivalenciaPorcentajeDescuentoDTO());
		descuentoProveedorArticuloDTO.getEquivalenciaPorcentajeDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		articuloProveedorDTO.setDescuentoProveedorArticuloCol(new ArrayList<DescuentoProveedorArticuloDTO>());
		articuloProveedorDTO.getDescuentoProveedorArticuloCol().add(descuentoProveedorArticuloDTO);

	}

	/**
	 * @author cbastidas
	 * @param articuloDTO
	 */
	private void asignarRelacionArticuloCostosProyectados(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloProveedor()) {
			this.asignarRelacionArticuloProveedor(articuloDTO);
		}
		ArticuloProveedorDTO articuloProveedorDTO = articuloDTO.getArticuloProveedorCol().iterator().next();		
		if(!articuloProveedorDTO.getTieneArticuloProveedorCosto()){
			articuloProveedorDTO.setArticuloProveedorCostoCol(new ArrayList<ArticuloProveedorCostoDTO>());
			articuloProveedorDTO.getArticuloProveedorCostoCol().add(new ArticuloProveedorCostoDTO());
		}		
	}
	
	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionArticuloImportacion(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloProveedor()) {
			this.asignarRelacionArticuloProveedor(articuloDTO);
		}
		ArticuloProveedorDTO articuloProveedorDTO = articuloDTO.getArticuloProveedorCol().iterator().next();
		if(!articuloProveedorDTO.getTieneArticuloImportacion()){
			articuloProveedorDTO.setArticuloImportacion(new ArticuloImportacionDTO());
		}
		if(!articuloProveedorDTO.getTieneArticuloProveedorImpuestos()){
			articuloProveedorDTO.setArticuloProveedorImpuestoCol(new ArrayList<ArticuloProveedorImpuestoDTO>());
			articuloProveedorDTO.getArticuloProveedorImpuestoCol().add(new ArticuloProveedorImpuestoDTO());
		}
	}

	/**
	 * 
	 * @param articuloVO
	 */
	private void asignarRelacionArticuloMedidaDTO(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloMedida()) {
			articuloDTO.setArticuloMedidaDTO(new ArticuloMedidaDTO());
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionArticuloBitacoraCodigoBarras(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArtBitCodBar()) {
			ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO = new ArticuloBitacoraCodigoBarrasDTO();
			articuloBitacoraCodigoBarrasDTO.setTipoCodigoArticulo(new TipoCodigoArticuloDTO());
			articuloBitacoraCodigoBarrasDTO.setTipoSecuenciaArticulo(new CatalogoValorDTO());
			articuloBitacoraCodigoBarrasDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloBitacora", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			articuloDTO.setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
			articuloDTO.getArtBitCodBarCol().add(articuloBitacoraCodigoBarrasDTO);
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionRelacionRegistroSanitario(final ArticuloDTO articuloDTO) {
		RelacionArticuloRegistroSanitarioDTO estudioBromatologicoPlantilla = new RelacionArticuloRegistroSanitarioDTO();
		ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO = new ArticuloRegistroSanitarioDTO();

		articuloRegistroSanitarioDTO.setInformacionNutricionalCol(new ArrayList<ArticuloInformacionNutricionalDTO>());
		articuloRegistroSanitarioDTO.getInformacionNutricionalCol().add(new ArticuloInformacionNutricionalDTO());
		// articuloRegistroSanitarioDTO.setCodigoTipoEstudioNutricional(TipoCatalogoArticulo.TIPO_ESTUDIO_NUTRICIONAL);
		// articuloRegistroSanitarioDTO.setValorTipoEstudioNutricional(TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_ANALISIS_BROMATOLOGICO);

		estudioBromatologicoPlantilla.setRegistroSanitario(articuloRegistroSanitarioDTO);

		estudioBromatologicoPlantilla.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));

		// estudioBromatologicoPlantilla.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);

		articuloDTO.setRegistroSanitarioCol(new ArrayList<RelacionArticuloRegistroSanitarioDTO>());
		articuloDTO.getRegistroSanitarioCol().add(estudioBromatologicoPlantilla);
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionArticuloDefinicionArchivoRegSan(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloDefinicionArchivo()) {
			articuloDTO.setArticuloDefinicionArchivoCol(new ArrayList<ArticuloDefinicionArchivoDTO>());
			ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO = new ArticuloDefinicionArchivoDTO();
			articuloDefinicionArchivoDTO.setArticuloArchivo(new ArticuloArchivoDTO());
			articuloDefinicionArchivoDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArchivo", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			// String[] valorTipoArchivoCol =
			// {SICArticuloConstantes.getInstancia().TIPOARCHIVO_DOCREGSAN,SICArticuloConstantes.getInstancia().TIPOARCHIVO_IMGREGSAN};
			// articuloDefinicionArchivoDTO.addJoinCriteriaSearchParameter(new
			// CriteriaSearchParameter<String>("valorTipoArchivo",ComparatorTypeEnum.IN_COMPARATOR,
			// valorTipoArchivoCol));
			articuloDTO.getArticuloDefinicionArchivoCol().add(articuloDefinicionArchivoDTO);
		}
	}

	private void asignarRelacionArticuloLeyenda(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloLeyenda()) {
			articuloDTO.setArticuloLeyendaCol(new ArrayList<ArticuloLeyendaDTO>());

			ArticuloLeyendaDTO articuloLeyendaDTO = new ArticuloLeyendaDTO();
			articuloLeyendaDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));

			articuloDTO.getArticuloLeyendaCol().add(articuloLeyendaDTO);
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionEstructuraComercialCliente(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneEstructuraComercialCliente()) {

			articuloDTO.setEstructuraComercialClienteCol(new ArrayList<ArticuloEstructuraComercialDTO>());

			ArticuloEstructuraComercialDTO articuloEstructuraComercialDTO = new ArticuloEstructuraComercialDTO();
			articuloEstructuraComercialDTO.setClasificacionDTO(new ClasificacionDTO());
			articuloEstructuraComercialDTO.getClasificacionDTO().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoClasificacion", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			articuloEstructuraComercialDTO.getClasificacionDTO().setValorTipoEstructura(null);
			articuloEstructuraComercialDTO.getClasificacionDTO().setCodigoTipoEstructura(null);
			articuloEstructuraComercialDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));

			articuloDTO.getEstructuraComercialClienteCol().add(articuloEstructuraComercialDTO);
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionArticuloEtiquetas(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloEtiqueta()) {
			ArticuloEtiquetaDTO articuloEtiquetaDTO = new ArticuloEtiquetaDTO();
			articuloEtiquetaDTO.setTagDTO(new TagDTO());
			articuloDTO.setArticuloEtiquetaCol(new ArrayList<ArticuloEtiquetaDTO>());
			articuloDTO.getArticuloEtiquetaCol().add(articuloEtiquetaDTO);

		}
	}
	
	private void asignarRelacionArticuloMaterial(final ArticuloDTO articuloDTO){
		if(!articuloDTO.getTieneArticuloMaterial()){
			ArticuloMaterialDTO articuloMaterialDTO = new ArticuloMaterialDTO();
			articuloMaterialDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			articuloMaterialDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("id.codigoTipoMaterial", ComparatorTypeEnum.EQUAL_COMPARATOR, SICArticuloConstantes.getInstancia().CODIGOTIPOMATERIAL));
			articuloMaterialDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("id.valorTipoMaterial", ComparatorTypeEnum.EQUAL_COMPARATOR, SICArticuloConstantes.getInstancia().VALOR_TIPOMATERIAL_OTRO));
			articuloDTO.setArticuloMaterialDTOs(new ArrayList<ArticuloMaterialDTO>());
			articuloDTO.getArticuloMaterialDTOs().add(articuloMaterialDTO);
		}
		
	}
	
	private void asignarRelacionArticuloEtiquetaMercancia(final ArticuloDTO articuloDTO){
		if(!articuloDTO.getTieneArticuloEtiquetaMercnacia()){
			ArticuloEtiquetaMercanciaDTO articuloEtiquetaMercanciaDTO= new ArticuloEtiquetaMercanciaDTO();
			ArticuloEtiquetaMercanciaCatalogoDTO articuloEtiquetaMercanciaCatalogoDTO = new ArticuloEtiquetaMercanciaCatalogoDTO();
			articuloEtiquetaMercanciaDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			articuloEtiquetaMercanciaCatalogoDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			articuloEtiquetaMercanciaDTO.setArticuloEtiquetaMercanciaCatalogoCol(new ArrayList<ArticuloEtiquetaMercanciaCatalogoDTO>());
			articuloEtiquetaMercanciaDTO.getArticuloEtiquetaMercanciaCatalogoCol().add(articuloEtiquetaMercanciaCatalogoDTO);
			//articuloEtiquetaMercanciaDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			articuloDTO.setArticuloEtiquetaMercanciaCol(new ArrayList<ArticuloEtiquetaMercanciaDTO>());
			articuloDTO.getArticuloEtiquetaMercanciaCol().add(articuloEtiquetaMercanciaDTO);
		}
	}
	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionArticuloUsos(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloUso()) {
			ArticuloUsoDTO articuloUsoDTO = new ArticuloUsoDTO();
			// articuloUsoDTO.addJoinCriteriaSearchParameter(new
			// CriteriaSearchParameter<String>("estado",ComparatorTypeEnum.EQUAL_COMPARATOR,
			// SICConstantes.ESTADO_ACTIVO_NUMERICO));

			articuloDTO.setArticuloUsoCol(new ArrayList<ArticuloUsoDTO>());
			articuloDTO.getArticuloUsoCol().add(articuloUsoDTO);

		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionArticuloConservacion(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloDuracionConservacion()) {
			ArticuloDuracionConservacionDTO articuloDuracionConservacionDTO = new ArticuloDuracionConservacionDTO();
			articuloDuracionConservacionDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));

			articuloDTO.setArticuloDuracionConservacionCol(new ArrayList<ArticuloDuracionConservacionDTO>());
			articuloDTO.getArticuloDuracionConservacionCol().add(articuloDuracionConservacionDTO);

		}
	}

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	@Override
	public ArticuloDTO asignarRestricionesDevolucionArticulo(ArticuloDTO articuloDTO) {
		if (articuloDTO.getNpFechaFactura() != null) {
			if (articuloDTO.getTieneArtBitCodBar() && articuloDTO.getCodigoBarrasHistorico() != null) {
				articuloDTO.getCodigoBarrasHistorico().setOrderByField(OrderBy.orderDesc("fechaInicialActivo"));
				articuloDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Date>("artBitCodBarCol.id.fechaInicialActivo", ComparatorTypeEnum.LESS_THAN_OR_EQUAL_COMPARATOR, articuloDTO.getNpFechaFactura()));
			}
		}

		if (!ArrayUtils.isEmpty(articuloDTO.getNpCodigoBarrasCol())) {
			if (articuloDTO.getTieneArtBitCodBar() && articuloDTO.getCodigoBarrasHistorico() != null) {
				articuloDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("artBitCodBarCol.id.codigoBarras", ComparatorTypeEnum.IN_COMPARATOR, articuloDTO.getNpCodigoBarrasCol()));
			}
		}
		return articuloDTO;
	}
	
	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionArticuloTemporada(ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloTemporada()) {
			articuloDTO.setArticuloTemporadaDTO(new ArticuloTemporadaDTO());
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionArticuloDefinicionArchivo(final ArticuloDTO articuloDTO) {
		if (!articuloDTO.getTieneArticuloDefinicionArchivo()) {
			ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO = new ArticuloDefinicionArchivoDTO();
			// articuloDefinicionArchivoDTO.setArticuloArchivo(new
			// ArticuloArchivoDTO());
			articuloDTO.setArticuloDefinicionArchivoCol(new ArrayList<ArticuloDefinicionArchivoDTO>());
			articuloDTO.getArticuloDefinicionArchivoCol().add(articuloDefinicionArchivoDTO);
		}
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionArticuloLocal(final ArticuloDTO articuloDTO) {
		ArticuloLocalDTO articuloLocalFiltro = new ArticuloLocalDTO();
		articuloLocalFiltro.setLocal(new AreaTrabajoDTO());
		articuloLocalFiltro.getLocal().setTipoAreaTrabajoTIC(TiposCatalogoConstantes.TIPO_AREA_TRABAJO);
		articuloLocalFiltro.getLocal().setCriteriaSearch(new CriteriaSearch());
		articuloLocalFiltro.getLocal().getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("tipoAreaTrabajoValor", ComparatorTypeEnum.EQUAL_COMPARATOR));
		articuloLocalFiltro.getLocal().setTipoAreaTrabajoValor(CorporativoConstantes.TIPO_AREATRABAJO_LOCAL);
		articuloLocalFiltro.getLocal().setEstadoAreaTrabajo(SICConstantes.ESTADO_ACTIVO_LITERAL);
		articuloLocalFiltro.getLocal().setEstablecimientoCiudadDTO(new EstablecimientoCiudadDTO());
		articuloLocalFiltro.getLocal().getEstablecimientoCiudadDTO().setEstablecimientoDTO(new EstablecimientoDTO());
		articuloLocalFiltro.setOrderByField(OrderBy.orderAsc(new String[] { "local.codigoEstablecimiento", "id.codigoLocal" }));
		articuloDTO.setArticuloLocalCol(new ArrayList<ArticuloLocalDTO>());
		articuloDTO.getArticuloLocalCol().add(articuloLocalFiltro);
	}

	/**
	 * 
	 * @param articuloDTO
	 */
	private void asignarRelacionArticuloLocalPrecio(final ArticuloDTO articuloDTO) {
		ArticuloLocalDTO articuloLocalFiltro = new ArticuloLocalDTO();
		articuloLocalFiltro.setArticuloLocalPrecioCol(new ArrayList<ArticuloLocalPrecioDTO>());
		articuloLocalFiltro.getArticuloLocalPrecioCol().add(new ArticuloLocalPrecioDTO());
		articuloLocalFiltro.setLocal(new AreaTrabajoDTO());
		articuloLocalFiltro.getLocal().setTipoAreaTrabajoTIC(TiposCatalogoConstantes.TIPO_AREA_TRABAJO);
		articuloLocalFiltro.getLocal().setCriteriaSearch(new CriteriaSearch());
		articuloLocalFiltro.getLocal().getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("tipoAreaTrabajoValor", ComparatorTypeEnum.EQUAL_COMPARATOR));
		articuloLocalFiltro.getLocal().setTipoAreaTrabajoValor(CorporativoConstantes.TIPO_AREATRABAJO_LOCAL);
		articuloLocalFiltro.getLocal().setEstadoAreaTrabajo(SICConstantes.ESTADO_ACTIVO_LITERAL);
		articuloLocalFiltro.getLocal().setEstablecimientoCiudadDTO(new EstablecimientoCiudadDTO());
		articuloLocalFiltro.getLocal().getEstablecimientoCiudadDTO().setEstablecimientoDTO(new EstablecimientoDTO());
		articuloLocalFiltro.setOrderByField(OrderBy.orderAsc(new String[] { "local.codigoEstablecimiento", "id.codigoLocal" }));
		articuloDTO.setArticuloLocalCol(new ArrayList<ArticuloLocalDTO>());
		articuloDTO.getArticuloLocalCol().add(articuloLocalFiltro);
	}

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> buscarArticulosPorCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException {

		if (codigoCompania == null) {
			throw new IllegalArgumentException("El codigoCompania no puede ser null");
		}

		if (codigoBarras == null) {
			throw new IllegalArgumentException("El codigoBarras no puede ser null");
		}

		ArticuloDTO articuloTemplateDTO = new ArticuloDTO();

		articuloTemplateDTO.getId().setCodigoCompania(codigoCompania);
		articuloTemplateDTO.setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);

		ArticuloProveedorDTO articuloProveedorDTO = new ArticuloProveedorDTO();
		articuloProveedorDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloProveedor", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		articuloProveedorDTO.setProveedor(new ProveedorDTO());
		articuloTemplateDTO.setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
		articuloTemplateDTO.getArticuloProveedorCol().add(articuloProveedorDTO);
		articuloTemplateDTO.setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
		articuloTemplateDTO.getArticuloUnidadManejoCol().add(new ArticuloUnidadManejoDTO());

		ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO = new ArticuloBitacoraCodigoBarrasDTO();
		articuloBitacoraCodigoBarrasDTO.getId().setCodigoBarras(codigoBarras);
		articuloBitacoraCodigoBarrasDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloBitacora", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		articuloTemplateDTO.setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
		articuloTemplateDTO.getArtBitCodBarCol().add(articuloBitacoraCodigoBarrasDTO);

		return dataGestor.findObjects(articuloTemplateDTO);
	}

	@Override
	public Collection<ArticuloDTO> buscarArticulosPorCodigoBarrasUso(Integer codigoCompania, String codigoBarras, CatalogoValorDTO usoCV, 
			String codigoProveedor) throws SICException {
		if (codigoCompania == null) {
			throw new IllegalArgumentException("El codigoCompania no puede ser null");
		}

		if (codigoBarras == null) {
			throw new IllegalArgumentException("El codigoBarras no puede ser null");
		}

		if (usoCV == null || usoCV.getId().getCodigoCatalogoTipo() == null || StringUtils.isBlank(usoCV.getId().getCodigoCatalogoValor())) {
			throw new IllegalArgumentException("El uso no puede ser null");
		}

		ArticuloDTO articulo = new ArticuloDTO();

		articulo.getId().setCodigoCompania(codigoCompania);
		//Para obtener los articulos INACTIVOS con el codigo de barras asociado
//		articulo.setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);

		ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO = new ArticuloBitacoraCodigoBarrasDTO();
		articuloBitacoraCodigoBarrasDTO.getId().setCodigoBarras(codigoBarras);
		// articuloBitacoraCodigoBarrasDTO.addJoinCriteriaSearchParameter(new
		// CriteriaSearchParameter<String>("estadoArticuloBitacora",ComparatorTypeEnum.EQUAL_COMPARATOR,
		// SICConstantes.ESTADO_ACTIVO_NUMERICO));
		articuloBitacoraCodigoBarrasDTO.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		articulo.setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
		articulo.getArtBitCodBarCol().add(articuloBitacoraCodigoBarrasDTO);

		ClasificacionDTO clasificacionDTO = new ClasificacionDTO();
		clasificacionDTO.setEstadoClasificacion(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		articulo.setClasificacionDTO(clasificacionDTO);
		ArticuloProveedorDTO proveedor = new ArticuloProveedorDTO();
		proveedor.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("id.codigoProveedor", ComparatorTypeEnum.EQUAL_COMPARATOR,
				codigoProveedor));
		articulo.setArticuloProveedorCol(Collections.singletonList(proveedor));
		Collection<ArticuloDTO> articuloDTOs = dataGestor.findObjects(articulo);
		if (CollectionUtils.isNotEmpty(articuloDTOs)) {
			if (articuloDTOs.size() > 1) {
				throw new SICException("Existe mas de articulo con el codigo de barras.");
			} else {
				articulo = articuloDTOs.iterator().next();
				// Realiza la busqueda de las unidades de manejo uso
				ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTO = new ArticuloUnidadManejoUsoDTO();
				articuloUnidadManejoUsoDTO.getId().setValorTipoUso(usoCV.getId().getCodigoCatalogoValor());
				articuloUnidadManejoUsoDTO.getId().setCodigoCompania(codigoCompania);
				articuloUnidadManejoUsoDTO.setCodigoTipoUso(usoCV.getId().getCodigoCatalogoTipo());
				articuloUnidadManejoUsoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);

				ArticuloUnidadManejoDTO articuloUnidadManejoDTO = new ArticuloUnidadManejoDTO();
				articuloUnidadManejoDTO.getId().setCodigoArticulo(articulo.getId().getCodigoArticulo());
				articuloUnidadManejoDTO.getId().setCodigoCompania(codigoCompania);
				articuloUnidadManejoDTO.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
				articuloUnidadManejoDTO.getArticuloUnidadManejoUsoCol().add(articuloUnidadManejoUsoDTO);

				Collection<ArticuloUnidadManejoDTO> articuloUnidadManejoDTOs = dataGestor.findObjects(articuloUnidadManejoDTO);
				articulo.setArticuloUnidadManejoCol(articuloUnidadManejoDTOs);
			}
		}

		return articuloDTOs;
	}

	@Override
	public Collection<ArticuloUnidadManejoDTO> buscarArticuloUnidadManejoPorCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException {

		if (codigoCompania == null) {
			throw new IllegalArgumentException("El codigoCompania no puede ser null");
		}

		if (codigoBarras == null) {
			throw new IllegalArgumentException("El codigoBarras no puede ser null");
		}

		ArticuloDTO articulo = new ArticuloDTO();

		articulo.getId().setCodigoCompania(codigoCompania);
		articulo.setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);

		ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO = new ArticuloBitacoraCodigoBarrasDTO();
		articuloBitacoraCodigoBarrasDTO.getId().setCodigoBarras(codigoBarras);
		articuloBitacoraCodigoBarrasDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloBitacora", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		articulo.setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
		articulo.getArtBitCodBarCol().add(articuloBitacoraCodigoBarrasDTO);

		ArticuloUnidadManejoDTO articuloUnidadManejoDTO = new ArticuloUnidadManejoDTO();
		articuloUnidadManejoDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoUnidadManejo", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
		articuloUnidadManejoDTO.setArticulo(articulo);

		return dataGestor.findObjects(articuloUnidadManejoDTO);
	}
	
	public Criterion incluirRestriccionesBusquedaArticuloEdicion(ArticuloVO articuloFiltro, IPlantillaBusquedaEdicionMasivaArticulos plantillaBusquedaArticulos ) throws SICException {
		
		DynamicCriteriaRestriction dynamicCriteriaRestriction = new DynamicCriteriaRestriction();
		Boolean existeFiltroBusqueda = Boolean.FALSE;
		Integer contadorRestricciones = 0;

		//se agregar la restriccion por defecto de linea comercial
		Criterion restriccionLineaComercial = plantillaBusquedaArticulos.getRestriccionPorComprador().getCriteriaRestriction();
		ProveedorFiltroRestriction proveedorFiltroRestriction = new ProveedorFiltroRestriction("articuloProveedorColproveedor");
		
		Conjunction conjunction = Restrictions.conjunction();
		conjunction.add(restriccionLineaComercial);
		conjunction.add(proveedorFiltroRestriction.getCriteriaRestriction());
		
		/**
		 * ASIGNACION DE VALORES DESDE EL OBJETO PLANTILLA
		 */
		articuloFiltro.getBaseDTO().getId().setCodigoCompania(plantillaBusquedaArticulos.getCompaniaId());
		// CODIGO BARRAS DEL ARTICULO
		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaCriteriaSearch()) && plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codigoBarras") != null) {
			CriteriaSearchParameter<String> criteriaSearchParameter = plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codigoBarras");
			
			if(criteriaSearchParameter.getParameterValues() != null && criteriaSearchParameter.getParameterValues() instanceof String[]){
				String[] parameterValues = (String[]) criteriaSearchParameter.getParameterValues();
				List<String> codigoBarrasCol = new ArrayList<String>();
				for(String codigoBarras : parameterValues){
					codigoBarrasCol.add(SICArticuloCalculo.getInstancia().obtenerCodigoBarrasParaBusqueda(codigoBarras)) ;
				}
				criteriaSearchParameter.setParameterValues(codigoBarrasCol.toArray(new String[0]));
			}else{
				criteriaSearchParameter.setParameterValues(new String[]{SICArticuloCalculo.getInstancia().obtenerCodigoBarrasParaBusqueda(criteriaSearchParameter.getParameterValue())});
			}
			
			dynamicCriteriaRestriction.add(criteriaSearchParameter);
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		
		// DESCRIPCION DE ARTICULOS
		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaCriteriaSearch()) && plantillaBusquedaArticulos.getMapaCriteriaSearch().get("descArticulo") != null) {
			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("descArticulo"));
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		
		// CODIGO CLASIFICACION
		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction()) && plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("codClasificacion") != null) {
			articuloFiltro.addDynamicProperty("filtroClasificacion", Boolean.TRUE);
			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("codClasificacion"));
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		// CODIGO SUBCLASIFICACION
		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaCriteriaSearch()) && plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codSubClasificacion") != null) {
			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codSubClasificacion"));
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		
		// CLASE ARTICULO
		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction()) && plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("claseArticulo") != null) {
			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("claseArticulo"));
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		
		//CARACTERISTICA ESPECIAL
		if(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("caracteristicaEspecial") != null){
			articuloFiltro.addDynamicProperty("filtroCaracteristicaEspecial", Boolean.TRUE);
			articuloFiltro.addDynamicProperty("restriccionCaracteristicaEspecial", plantillaBusquedaArticulos.getMapaCriteriaSearch().get("caracteristicaEspecial"));
			contadorRestricciones ++;
		}
		
		// CODIGO MARCA COMERCIAL
		if (plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codigoMarca") != null) {
			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codigoMarca"));
			articuloFiltro.addDynamicProperty("filtroMarcaComercial", Boolean.TRUE);
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		// NOMBRE MARCA COMERCIAL
		if (plantillaBusquedaArticulos.getMapaCriteriaSearch().get("nombreMarca") != null) {
			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("nombreMarca"));
			articuloFiltro.addDynamicProperty("filtroMarcaComercial", Boolean.TRUE);
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		// TIPO MARCA COMERCIAL
		if (plantillaBusquedaArticulos.getMapaCriteriaSearch().get("valorTipoMarca") != null) {
			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("valorTipoMarca"));
			articuloFiltro.addDynamicProperty("filtroMarcaComercial", Boolean.TRUE);
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		
		// MARCA PARTICIPACION
		if (plantillaBusquedaArticulos.getMapaCriteriaSearch().get("descMarcaParticipacion") != null) {
			articuloFiltro.addDynamicProperty("filtroArticuloComercial",Boolean.TRUE);
			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("descMarcaParticipacion"));
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		
		//CREADOS POR USUARIO
		if(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("creadosPorUsuario") != null){
			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("creadosPorUsuario"));
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		
		//FECHA CREACION
		if(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("fechaCreacion") != null){
			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("fechaCreacion"));
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		
		//PAIS ORIGEN
		if(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("paisOrigen") != null){
			articuloFiltro.addDynamicProperty("filtroPaisOrigen",Boolean.TRUE);
			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("paisOrigen"));
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		
		// CODIGO PROVEEDOR
		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaCriteriaSearch()) && plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codigoProvedor") != null) {
			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaCriteriaSearch().get("codigoProvedor"));
			articuloFiltro.addDynamicProperty("filtroProveedor", Boolean.TRUE);
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		
		// NOMBRE PROVEEDOR
		if (MapUtils.isNotEmpty(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction()) && plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("nombreComercialProv") != null) {
			dynamicCriteriaRestriction.add(plantillaBusquedaArticulos.getMapaBaseCriteriaRestriction().get("nombreComercialProv"));
			articuloFiltro.addDynamicProperty("filtroProveedor", Boolean.TRUE);
			existeFiltroBusqueda = Boolean.TRUE;
			contadorRestricciones ++;
		}
		
		articuloFiltro.addDynamicProperty("contadorRestricciones", contadorRestricciones);
		
		if(existeFiltroBusqueda){
			return Restrictions.and(conjunction, dynamicCriteriaRestriction.getCriteriaRestriction()) ;
		}
		
		return conjunction;
		
	}

	/**
	 * 
	 * @param articuloFiltro
	 * @param plantillaFiltrosBusqueda
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void incluirRestriccionesBusquedaArticulo(ArticuloVO articuloFiltro, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusqueda) throws SICException {
		DynamicCriteriaRestriction dynamicCriteriaRestriction = new DynamicCriteriaRestriction();

		//inicializando la bandera de busqueda por codigo de barras exacto
		articuloFiltro.addDynamicProperty("codbarExacto", Boolean.FALSE);
		// se inicializa para que siempre haga una nueva busqueda
		articuloFiltro.setBaseDTO(new ArticuloDTO());

		// se inicializa las restricciones
		if (articuloFiltro.getBaseDTO().getCriteriaRestrictions() == null) {
			articuloFiltro.getBaseDTO().setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
		}

		// 1.- se agregar la restriccion por defecto de linea comercial
		articuloFiltro.getBaseDTO().getCriteriaRestrictions().add(plantillaFiltrosBusqueda.getRestriccionPorComprador());

		// Se valida si desea realizar join con el proveedor
		if (articuloFiltro.getJoinProveedor()) {
			// Agregar la restriccion obligatoria por proveedor valido
			ArticuloProveedorDTO articuloProveedorDTO = new ArticuloProveedorDTO();
			articuloProveedorDTO.setVistaProveedor(new VistaProveedorDTO());
			articuloProveedorDTO.getVistaProveedor().setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
			articuloProveedorDTO.getVistaProveedor().getCriteriaRestrictions().add(new ProveedorFiltroRestriction());
			articuloFiltro.setArticuloProveedorDTO(articuloProveedorDTO);

			// Relacion con Proveedor
			Collection<ArticuloProveedorDTO> articuloProveedorCol = new ArrayList<ArticuloProveedorDTO>();
			articuloProveedorCol.add(articuloFiltro.getArticuloProveedorDTO());
			articuloFiltro.getBaseDTO().setArticuloProveedorCol(articuloProveedorCol);
		}

		/**
		 * ASIGNACION DE VALORES DESDE EL OBJETO PLANTILLA
		 */
		articuloFiltro.getBaseDTO().getId().setCodigoCompania(plantillaFiltrosBusqueda.getCompaniaId());
		articuloFiltro.setCodigoSistemaOrigen(plantillaFiltrosBusqueda.getSistemaOrigen());

		// Agregando restriccion de componentes de busqueda
		// CODIGO DE ARTICULO
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoArticulo") != null) {
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoArticulo"));
		}
		// CODIGO DE BARRAS
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoBarras") != null) {
			CriteriaSearchParameter<String> criteriaSearchParameter = plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoBarras");
			
			//Para que detecte si se esta filtrando por codigo de barras exacto
			if(criteriaSearchParameter.getComparator().equals(ComparatorTypeEnum.EQUAL_COMPARATOR)){
				articuloFiltro.addDynamicProperty("codbarExacto", Boolean.TRUE);
			}else{
				articuloFiltro.addDynamicProperty("codbarExacto", Boolean.FALSE);
			}
			
			if(criteriaSearchParameter.getParameterValues() != null && criteriaSearchParameter.getParameterValues() instanceof String[]){
				String[] parameterValues = (String[]) criteriaSearchParameter.getParameterValues();
				List<String> codigoBarrasCol = new ArrayList<String>();
				for(String codigoBarras : parameterValues){
					codigoBarrasCol.add(SICArticuloCalculo.getInstancia().obtenerCodigoBarrasParaBusqueda(codigoBarras)) ;
				}
				criteriaSearchParameter.setParameterValues(codigoBarrasCol.toArray(new String[0]));
			}else{
				criteriaSearchParameter.setParameterValues(new String[]{SICArticuloCalculo.getInstancia().obtenerCodigoBarrasParaBusqueda(criteriaSearchParameter.getParameterValue())});
			}
			
			dynamicCriteriaRestriction.add(criteriaSearchParameter);
		}
		// DESCRIPCION DE ARTICULOS
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("descArticulo") != null) {
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("descArticulo"));
		}
		// ESTADO ARTICULO
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estArticulo") != null) {
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estArticulo"));
		}
		// articuloFiltro.getBaseDTO().setEstadoArticulo(plantillaFiltrosBusqueda.getEstadoArticulo());
		// TIPO ARTICULO
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("tipoArticulo") != null) {
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("tipoArticulo"));
		}
		// SECUENCIA INTERNA CODIGO BARRAS
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("secInternaCodBar") != null) {
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("secInternaCodBar"));
			
			ArticuloBitacoraCodigoBarrasDTO abcb = new ArticuloBitacoraCodigoBarrasDTO();
			abcb.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloBitacora", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));

			articuloFiltro.getBaseDTO().setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
			articuloFiltro.getBaseDTO().getArtBitCodBarCol().add(abcb);
		}

		// Se valida si desea realizar join con el proveedor
		if (articuloFiltro.getJoinProveedor()) {
			// REFERENCIA INTERNA
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoReferenciaIntProv") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoReferenciaIntProv"));
			}
			// REFERENCIA PROVEEDOR
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoReferenciaExtProv") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoReferenciaExtProv"));
			}
		}

		// CODIGO DE MARCA
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch())
				&& (plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoMarca") != null || plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("nombreMarca") != null || plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("valorTipoMarca") != null || plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("abreviaturaMarca") != null || plantillaFiltrosBusqueda.getMapaCriteriaSearch().get(
						"descMarcaParticipacion") != null)) {
			// Relacion con Marca Comercial
			if (!articuloFiltro.getBaseDTO().getTieneArticuloComercial()) {
				articuloFiltro.getBaseDTO().setArticuloComercialDTO(new ArticuloComercialDTO());
			}
			articuloFiltro.getBaseDTO().getArticuloComercialDTO().setMarcaComercialArticulo(new MarcaArticuloDTO());
			// CODIGO MARCA COMERCIAL
			if (plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoMarca") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoMarca"));
			}
			// NOMBRE MARCA COMERCIAL
			if (plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("nombreMarca") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("nombreMarca"));
			}
			// TIPO MARCA COMERCIAL
			if (plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("valorTipoMarca") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("valorTipoMarca"));
			}
			// ABREVITURA MARCA COMERCIAL
			if (plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("abreviaturaMarca") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("abreviaturaMarca"));
			}
			// MARCA PARTICIPACION
			if (plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("descMarcaParticipacion") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("descMarcaParticipacion"));
			}
		}
		// GRUPO DE TRABAJO
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction()) && plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("codigoGrupoTrabajo") != null) {
			if (articuloFiltro.getBaseDTO().getGrupoAlcanceDTO() == null) {
				articuloFiltro.getBaseDTO().setGrupoAlcanceDTO(new GrupoTrabajoDTO());
			}
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("codigoGrupoTrabajo"));
		}
		// CLASE ARTICULO
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction()) && plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("claseArticulo") != null) {
			if (articuloFiltro.getBaseDTO().getArticuloTemporadaDTO() == null) {
				articuloFiltro.getBaseDTO().setArticuloTemporadaDTO(new ArticuloTemporadaDTO());
			}
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("claseArticulo"));
		}
		// CANTIDAD MEDIDA
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("cantidadMedida") != null) {

			if (!articuloFiltro.getBaseDTO().getTieneArticuloMedida()) {
				articuloFiltro.getBaseDTO().setArticuloMedidaDTO(new ArticuloMedidaDTO());
			}

			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("cantidadMedida"));
		}
		// VALOR TIPO MEDIDA
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("valorTipoMedida") != null) {

			if (!articuloFiltro.getBaseDTO().getTieneArticuloMedida()) {
				articuloFiltro.getBaseDTO().setArticuloMedidaDTO(new ArticuloMedidaDTO());
			}

			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("valorTipoMedida"));
		}
		// ESTADO CODIFICACION
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estadoArtCod") != null) {
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estadoArtCod"));
		}
		// USUARIO CREACION LOGEADO
		if (plantillaFiltrosBusqueda.getUserId() != null && plantillaFiltrosBusqueda.getCreadosPorUsuario()) {
			articuloFiltro.getBaseDTO().setUsuarioCreacion(plantillaFiltrosBusqueda.getUserId());
		}

		// REGISTRO SANITARIO
		if (plantillaFiltrosBusqueda.getArticuloRegistroSanitarioPlantillaRestriction() != null) {
			RegistroSanitaroRestriction registroSanitaroRestriction = new RegistroSanitaroRestriction(plantillaFiltrosBusqueda.getArticuloRegistroSanitarioPlantillaRestriction());
			dynamicCriteriaRestriction.add(registroSanitaroRestriction);
		}

		// CODIGO CLASIFICACION
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction()) && plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("codClasificacion") != null) {

			if (articuloFiltro.getBaseDTO().getCriteriaRestrictions() == null) {
				articuloFiltro.getBaseDTO().setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
			}
			//TODO analizar para optimizar la relacion
			if (articuloFiltro.getBaseDTO().getClasificacionDTO() == null) {
				articuloFiltro.getBaseDTO().setClasificacionDTO(new ClasificacionDTO());
			}

			articuloFiltro.getBaseDTO().getClasificacionDTO().setClasificacionPadre(new ClasificacionDTO());

			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("codClasificacion"));
		}
		// DESCRIPCION CLASIFICACION
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction()) && plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("descClasificacion") != null) {

			if (articuloFiltro.getBaseDTO().getClasificacionDTO() == null) {
				articuloFiltro.getBaseDTO().setClasificacionDTO(new ClasificacionDTO());
			}

			if (articuloFiltro.getBaseDTO().getClasificacionDTO().getClasificacionPadre() == null) {
				articuloFiltro.getBaseDTO().getClasificacionDTO().setClasificacionPadre(new ClasificacionDTO());
			}
			articuloFiltro.getBaseDTO().getClasificacionDTO().getClasificacionPadre().setClasificacionPadre(new ClasificacionDTO());
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("descClasificacion"));
		}
		// CODIGO SUBCLASIFICACION
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codSubClasificacion") != null) {
			articuloFiltro.getBaseDTO().setSubClasificacionDTO(new SubClasificacionDTO());
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codSubClasificacion"));
		}
		// DESCRIPCION SUBCLASIFICACION
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("descSubClasificacion") != null) {
			if (articuloFiltro.getBaseDTO().getSubClasificacionDTO() == null) {
				articuloFiltro.getBaseDTO().setSubClasificacionDTO(new SubClasificacionDTO());
			}
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("descSubClasificacion"));
		}
		
		//FECHA CREACION
		if(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("fechaCreacion") != null){
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("fechaCreacion"));
		}
		
		//CARACTERISTICA ESPECIAL
		//agregamos la restriccion del agrupador tipo caracteristica especial 
		if(!articuloFiltro.getBaseDTO().getTieneArticuloAgrupador()){
			ArticuloAgrupadorDTO agrupadorDTO = new ArticuloAgrupadorDTO();
			agrupadorDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			agrupadorDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("id.codigoTipoAgrupador", ComparatorTypeEnum.EQUAL_COMPARATOR, TipoCatalogoArticulo.TIPO_MARCAS_ESPECIALES));
			articuloFiltro.getBaseDTO().setArticuloAgrupadorCol(new ArrayList<ArticuloAgrupadorDTO>());
			articuloFiltro.getBaseDTO().getArticuloAgrupadorCol().add(agrupadorDTO);
		}
		if(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("caracteristicaEspecial") != null){
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("caracteristicaEspecial"));
		}
		
		// CODIGO DE BODEGA
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction()) && plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction() != null && plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("codBodega") != null) {
			if (articuloFiltro.getBaseDTO().getClasificacionDTO() == null) {
				articuloFiltro.getBaseDTO().setClasificacionDTO(new ClasificacionDTO());
			}
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("codBodega"));
		}
		// DESCRIPCION DE BODEGA
		if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction()) && plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction() != null && plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("descBodega") != null) {
			if (articuloFiltro.getBaseDTO().getClasificacionDTO() == null) {
				articuloFiltro.getBaseDTO().setClasificacionDTO(new ClasificacionDTO());
			}
			articuloFiltro.getBaseDTO().getClasificacionDTO().setBodegaDTO(new BodegaDTO());
			dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("descBodega"));
		}

		// FITROS DEL PROVEEDOR se valida si desea realizar join con el
		// proveedor
		if (articuloFiltro.getJoinProveedor()) {
			// CODIGO PROVEEDOR
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoProvedor") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoProvedor"));
				articuloFiltro.getBaseDTO().addDynamicProperty("codigoProveedor", plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoProvedor"));
			}
			// DOCUMENTO PROVEEDOR
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("numeroDocumento") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("numeroDocumento"));
				articuloFiltro.getBaseDTO().addDynamicProperty("numeroDocumento", plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("numeroDocumento"));
			}
			// ORIGEN PROVEEDOR
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction()) && plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("origenProveedor") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("origenProveedor"));
				articuloFiltro.getBaseDTO().addDynamicProperty("origenProveedor", plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("origenProveedor"));
			}
			// INDICADOR I PROVEEDOR
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction()) && plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("indicadorI") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("indicadorI"));
				articuloFiltro.getBaseDTO().addDynamicProperty("indicadorI", plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("indicadorI"));
			}

			// NOMBRE PROVEEDOR
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction()) && plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("nombreComercialProv") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("nombreComercialProv"));
				articuloFiltro.getBaseDTO().addDynamicProperty("nombreComercialProv", plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("nombreComercialProv"));
			}
			// ESTADO PROVEEDOR
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estadoProveedor") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estadoProveedor"));
				articuloFiltro.getBaseDTO().addDynamicProperty("estadoProveedor", plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estadoProveedor"));
			}

			// ESTADO ARTICULO-PROVEEDOR
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estadoArticuloProveedor") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estadoArticuloProveedor"));
				articuloFiltro.getBaseDTO().addDynamicProperty("estadoArticuloProveedor", plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estadoArticuloProveedor"));
			}
		} else {
			// Se valida almenos un filtro de proveedor posee datos
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch())) {
				if (plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoProvedor") != null || plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("numeroDocumento") != null || plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("origenProveedor") != null || plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("indicadorI") != null
						|| plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("nombreComercialProv") != null || plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estadoProveedor") != null || plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estadoArticuloProveedor") != null || plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoReferenciaIntProv") != null
						|| plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoReferenciaExtProv") != null) {

					dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getRestriccionPorArticuloProveedor().getCriteriaRestriction(), BooleanClauseEnum.AND);
				}

			}
		}

		// CODIGO O NOMBRE LOCAL
		if (articuloFiltro.getDynamicProperties() != null && articuloFiltro.getDynamicProperty("articuloLocalCol") != null) {
			articuloFiltro.getBaseDTO().setArticuloLocalCol((Collection<ArticuloLocalDTO>) articuloFiltro.getDynamicProperty("articuloLocalCol"));
			// Si posee codigo local
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoAreaTrabajo") != null) {
				// se establece una restriccion extra en caso de ser oficina
				if (articuloFiltro.getBaseDTO().getArticuloLocalCol().iterator().next().getTipoAreaTrabajo().equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA)) {
					if (plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoAreaTrabajo").getParameterValues() instanceof Integer) {

						Integer paramValue = (Integer) plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoAreaTrabajo").getParameterValues();
						Integer paramValues[] = { (paramValue > 0) ? paramValue * -1 : paramValue };
						plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoAreaTrabajo").setParameterValues(paramValues);

					} else if (plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoAreaTrabajo").getParameterValues() instanceof Integer[]) {

						Integer paramValues[] = (Integer[]) plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoAreaTrabajo").getParameterValues();
						Integer paramValuesAux[] = new Integer[paramValues.length];
						Integer count = 0;

						for (Integer valor : paramValues) {
							paramValuesAux[count] =  (valor > 0) ? valor * -1 : valor ;
							count++;
						}

						plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoAreaTrabajo").setParameterValues(paramValuesAux);
					}
				}

				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("codigoAreaTrabajo"));
			}
			// Si posee nombre del local
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("nombreAreaTrabajo") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("nombreAreaTrabajo"));
			}

			// Si posee tipo asignacion
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("valorTipoAsignacion") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("valorTipoAsignacion"));
			}

			// Si posee estado articulo local
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaCriteriaSearch()) && plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estadoArticuloLocal") != null) {
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaCriteriaSearch().get("estadoArticuloLocal"));
			}
			
			//Si posee formato local
			if (MapUtils.isNotEmpty(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction()) && plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("formatoLocal") != null) {				
				EstablecimientoCiudadDTO establecimientoCiudadDTO = new EstablecimientoCiudadDTO();
				establecimientoCiudadDTO.setEstado(SICConstantes.ESTADO_ACTIVO_LITERAL);
				establecimientoCiudadDTO.setEstablecimientoDTO(new EstablecimientoDTO());
				establecimientoCiudadDTO.getEstablecimientoDTO().setEstado(SICConstantes.ESTADO_ACTIVO_LITERAL);
				establecimientoCiudadDTO.getEstablecimientoDTO().addCriteriaSearchParameter("abreviaturaEstablecimiento", ComparatorTypeEnum.IS_NOT_NULL);
				articuloFiltro.getBaseDTO().getArticuloLocalCol().iterator().next().getLocal().setEstablecimientoCiudadDTO(establecimientoCiudadDTO);
				dynamicCriteriaRestriction.add(plantillaFiltrosBusqueda.getMapaBaseCriteriaRestriction().get("formatoLocal"));
			}
		}

		if (dynamicCriteriaRestriction.isNotEmptyCriteriaRestriction()) {
			articuloFiltro.getBaseDTO().getCriteriaRestrictions().add(dynamicCriteriaRestriction);
		}
	}

	@SuppressWarnings("serial")
	private class RegistroSanitaroRestriction extends BasePlantillaCriteriaRestriction<ArticuloRegistroSanitarioPlantillaRestriction> {

		public RegistroSanitaroRestriction(ArticuloRegistroSanitarioPlantillaRestriction articuloRegistroSanitarioPlantillaRestriction) {
			super(articuloRegistroSanitarioPlantillaRestriction);
		}

		@Override
		protected Criterion construirCriteriaRestriction() {
			Criterion criterion = null;
			try {
				DetachedCriteria subSelectRegSan = DetachedCriteria.forClass(RelacionArticuloRegistroSanitarioDTO.class, "relacionArticuloRegistroSanitarioDTO");
				subSelectRegSan.setProjection(Projections.property("id.codigoArticulo"));
				subSelectRegSan.createAlias("relacionArticuloRegistroSanitarioDTO.registroSanitario", "registroSanitario");
				DynamicCriteriaRestriction dynamicParametersFiltersRegSan = new DynamicCriteriaRestriction();
				if (super.getPlantillaBusqueda().getCompRegistroSanitario() != null) {
					dynamicParametersFiltersRegSan.add(super.getPlantillaBusqueda().getCompRegistroSanitario().addExpression(), super.getPlantillaBusqueda().getCompRegistroSanitario().getBooleanClauseEnum());
				}
				if (super.getPlantillaBusqueda().getCompPermiteImpEti() != null) {
					dynamicParametersFiltersRegSan.add(super.getPlantillaBusqueda().getCompPermiteImpEti().addExpression(), super.getPlantillaBusqueda().getCompPermiteImpEti().getBooleanClauseEnum());
				}
				if (dynamicParametersFiltersRegSan.isNotEmptyCriteriaRestriction()) {
					subSelectRegSan.add(dynamicParametersFiltersRegSan.getCriteriaRestriction());
				}
				criterion = Subqueries.propertyIn("id.codigoArticulo", subSelectRegSan);
			} catch (Exception e) {
				throw new SICException("Se produjo un error al momento de armar la restricci\u00F3n por usuario-clasificaci\u00F3n");
			}
			return criterion;
		}

	}

	// private String completarCodigosEstructuraComercial(String codigo){
	// StringBuilder codigoCompleto = new StringBuilder();
	// codigoCompleto.append(codigo);
	// while(codigoCompleto.length() < 4){
	// codigoCompleto = codigoCompleto.insert(0, "0");
	// }
	// return codigoCompleto.toString();
	// }

	// /**
	// * Verifica los codigos de la estructura comercial ingresados en una sola
	// cadena y los separa dependiendo de su longitud, para luego ser aplicados
	// correctamente como filtros
	// * @param codigosEstructuraComercial
	// * @return
	// */
	// @SuppressWarnings("unused")
	// private HashMap<String, Set<String>>
	// separarCodigosEstructuraComercial(String codigosEstructuraComercial){
	// String[] codigos = codigosEstructuraComercial.split(",");
	// HashMap<String, Set<String>> mapEC = new HashMap<String, Set<String>>();
	// final String DIVISION = "division";
	// final String DEPARTAMENTO = "departamento";
	// final String CLASIFICACION = "clasificacion";
	//
	// for(String codigo:codigos){
	// Integer tempInteger = Integer.valueOf(codigo);
	// String tempString = String.valueOf(tempInteger);
	// Set<String> temporal = new HashSet<String>();
	// Integer size = tempString.length();
	// switch(size){
	// case 1:
	// if(mapEC.containsKey(DIVISION)){
	// temporal = mapEC.get(DIVISION);
	// temporal.add(completarCodigosEstructuraComercial(tempString));
	// mapEC.put(DIVISION, temporal);
	// }else{
	// temporal.add(completarCodigosEstructuraComercial(tempString));
	// mapEC.put(DIVISION, temporal);
	// }
	// break;
	// case 2:
	// if(mapEC.containsKey(DEPARTAMENTO)){
	// temporal = mapEC.get(DEPARTAMENTO);
	// temporal.add(completarCodigosEstructuraComercial(tempString));
	// mapEC.put(DEPARTAMENTO, temporal);
	// }else{
	// temporal.add(completarCodigosEstructuraComercial(tempString));
	// mapEC.put(DEPARTAMENTO, temporal);
	// }
	// break;
	//
	// case 3:
	// if(mapEC.containsKey(CLASIFICACION)){
	// temporal = mapEC.get(CLASIFICACION);
	// temporal.add(completarCodigosEstructuraComercial(tempString));
	// mapEC.put(CLASIFICACION, temporal);
	// }else{
	// temporal.add(completarCodigosEstructuraComercial(tempString));
	// mapEC.put(CLASIFICACION, temporal);
	// }
	// break;
	// case 4:
	// if(mapEC.containsKey(CLASIFICACION)){
	// temporal = mapEC.get(CLASIFICACION);
	// temporal.add(completarCodigosEstructuraComercial(tempString));
	// mapEC.put(CLASIFICACION, temporal);
	// }else{
	// temporal.add(completarCodigosEstructuraComercial(tempString));
	// mapEC.put(CLASIFICACION, temporal);
	// }
	// break;
	// }
	// }
	// return mapEC;
	// }

	// @Override
	// @SuppressWarnings("rawtypes")
	// public void incluirRestriccionesBusquedaArticuloB2B(ArticuloVO
	// articuloFiltro,PlantillaFiltrosBusquedaB2B plantillaFiltrosBusqueda)
	// throws SICException{
	//
	// articuloFiltro.setBaseDTO(new ArticuloDTO());
	// ArticuloProveedorDTO articuloProveedorDTO = new ArticuloProveedorDTO();
	// articuloFiltro.setArticuloProveedorDTO(articuloProveedorDTO);
	// ArticuloBitacoraCodigoBarrasDTO abcb = new
	// ArticuloBitacoraCodigoBarrasDTO();
	// abcb.addJoinCriteriaSearchParameter(new
	// CriteriaSearchParameter<String>("estadoArticuloBitacora",ComparatorTypeEnum.EQUAL_COMPARATOR,
	// SICConstantes.ESTADO_ACTIVO_NUMERICO));
	//
	// articuloFiltro.getBaseDTO().setArtBitCodBarCol(new
	// ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
	// articuloFiltro.getBaseDTO().getArtBitCodBarCol().add(abcb);
	//
	// articuloFiltro.getBaseDTO().setArticuloMedidaDTO(new
	// ArticuloMedidaDTO());
	// articuloFiltro.setCriteriaSearch(new CriteriaSearch());
	// RelacionArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO = new
	// RelacionArticuloRegistroSanitarioDTO();
	// articuloRegistroSanitarioDTO.setRegistroSanitario(new
	// ArticuloRegistroSanitarioDTO());
	// articuloFiltro.setArticuloRegSanDTO(articuloRegistroSanitarioDTO);
	//
	// /**
	// * ASIGNACION DE VALORES DESDE EL OBJETO PLANTILLA
	// */
	// articuloFiltro.getBaseDTO().getId().setCodigoCompania(plantillaFiltrosBusqueda.getCompaniaId());
	// articuloFiltro.setCodigoSistemaOrigen(plantillaFiltrosBusqueda.getSistemaOrigen());
	// articuloFiltro.getArticuloProveedorDTO().setEstadoArticuloProveedor(plantillaFiltrosBusqueda.getEstadoArticuloProveedor());
	// articuloFiltro.getArticuloProveedorDTO().setCodigoReferenciaProveedor(plantillaFiltrosBusqueda.getCodigoReferenciaProveedor());
	// abcb.getId().setCodigoBarras(plantillaFiltrosBusqueda.getCodigoBarras());
	// articuloFiltro.getBaseDTO().setDescripcionArticulo(plantillaFiltrosBusqueda.getDescripcionArticulo());
	// articuloFiltro.getBaseDTO().setEstadoArticulo(plantillaFiltrosBusqueda.getEstadoArticulo());
	// articuloFiltro.getBaseDTO().setAplicaRegistroSanitario(plantillaFiltrosBusqueda.getAplicaRegistroSanitario());
	// articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setRegistroSanitario(plantillaFiltrosBusqueda.getRegistroSanitario());
	//
	//
	// if(plantillaFiltrosBusqueda.getRegSanCaducados()){
	// plantillaFiltrosBusqueda.setRegSanCaducados(Boolean.TRUE);
	// Date actualDate = new Date();
	// actualDate = DateUtils.addDays(actualDate, -1);
	// articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setCriteriaSearch(new
	// CriteriaSearch());
	// articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().getCriteriaSearch().addCriteriaSearchParameter(new
	// CriteriaSearchParameter<Date>("fechaCaducidadRegistroSanitario",
	// ComparatorTypeEnum.LESS_THAN_COMPARATOR, actualDate));
	// }else{
	// articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setCriteriaSearch(null);
	// }
	//
	//
	// //FILTROS DE BUSQUEDA SEGUN EL SISTEMA B2B REGISTRO SANITARIO ARTICULO
	// //Filtro Proveedor B2B
	// articuloFiltro.getArticuloProveedorDTO().getId().setCodigoProveedor(plantillaFiltrosBusqueda.getCodigoProveedor());
	//
	// //filtro reg Sanitario
	// if(plantillaFiltrosBusqueda.getVisualizarFiltros()){
	// Collection<RelacionArticuloRegistroSanitarioDTO> registroSanitarioCol =
	// new ArrayList<RelacionArticuloRegistroSanitarioDTO>();
	// articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
	//
	// //SECCION DE FILTROS POR FECHAS
	// RangeValue<Date> rangeValue = new RangeValue<Date>();
	// if(plantillaFiltrosBusqueda.getRegSanCaducados() &&
	// plantillaFiltrosBusqueda.getfCadRegSfin() != null &&
	// plantillaFiltrosBusqueda.getfCadRegSinicio() != null){
	// Date actualDate = new Date();
	// if(plantillaFiltrosBusqueda.getfCadRegSfin().compareTo(actualDate) > 0)
	// plantillaFiltrosBusqueda.setfCadRegSfin(DateUtils.addDays(actualDate,
	// -1));
	// }
	// if(plantillaFiltrosBusqueda.getRegSanCaducados() &&
	// plantillaFiltrosBusqueda.getfCadRegSfin() != null &&
	// plantillaFiltrosBusqueda.getfCadRegSinicio() == null){
	// Date actualDate = new Date();
	// if(plantillaFiltrosBusqueda.getfCadRegSfin().compareTo(actualDate) > 0)
	// plantillaFiltrosBusqueda.setfCadRegSfin(DateUtils.addDays(actualDate,
	// -1));
	// }
	// if(plantillaFiltrosBusqueda.getRegSanCaducados() &&
	// plantillaFiltrosBusqueda.getfCadRegSfin() == null &&
	// plantillaFiltrosBusqueda.getfCadRegSinicio() != null){
	// Date actualDate = new Date();
	// if(plantillaFiltrosBusqueda.getfCadRegSinicio().compareTo(actualDate) <
	// 0)
	// plantillaFiltrosBusqueda.setfCadRegSfin(DateUtils.addDays(actualDate,
	// -1));
	// }
	//
	// if(plantillaFiltrosBusqueda.getfCadRegSfin() == null &&
	// plantillaFiltrosBusqueda.getfCadRegSinicio() == null &&
	// !plantillaFiltrosBusqueda.getRegSanCaducados()){
	// articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setCriteriaSearch(null);
	// }
	//
	// if(plantillaFiltrosBusqueda.getfCadRegSfin() ==null &&
	// plantillaFiltrosBusqueda.getfCadRegSinicio() == null &&
	// plantillaFiltrosBusqueda.getRegSanCaducados()){
	// Date actualDate = new Date();
	// actualDate = DateUtils.addDays(actualDate, -1);
	// articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setCriteriaSearch(new
	// CriteriaSearch());
	// articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().getCriteriaSearch().addCriteriaSearchParameter(new
	// CriteriaSearchParameter<Date>("fechaCaducidadRegistroSanitario",
	// ComparatorTypeEnum.LESS_THAN_COMPARATOR, actualDate));
	// }
	//
	// if(plantillaFiltrosBusqueda.getfCadRegSfin() !=null ||
	// plantillaFiltrosBusqueda.getfCadRegSinicio() != null){
	// rangeValue.setBottomValue(plantillaFiltrosBusqueda.getfCadRegSinicio());
	// rangeValue.setTopValue(plantillaFiltrosBusqueda.getfCadRegSfin());
	// articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().setCriteriaSearch(new
	// CriteriaSearch());
	// articuloFiltro.getArticuloRegSanDTO().getRegistroSanitario().getCriteriaSearch().addCriteriaSearchParameter(new
	// CriteriaSearchParameter<RangeValue>("fechaCaducidadRegistroSanitario",
	// ComparatorTypeEnum.BETWEEN_INCLUDE_COMPARATOR, rangeValue));
	//
	// }
	//
	// registroSanitarioCol.add(articuloFiltro.getArticuloRegSanDTO());
	// articuloFiltro.getBaseDTO().setRegistroSanitarioCol(registroSanitarioCol);
	// }else{
	// articuloFiltro.getBaseDTO().setRegistroSanitarioCol(null);
	// }
	//
	// //filtros de articulos B2B si aplican o no registro sanitario
	// if(articuloFiltro.getBaseDTO().getAplicaRegistroSanitario() == null){
	// Boolean[] estados = new Boolean[]{Boolean.FALSE,Boolean.TRUE};
	// articuloFiltro.getCriteriaSearch().addCriteriaSearchParameter(new
	// CriteriaSearchParameter<Boolean>("aplicaRegistroSanitario",
	// ComparatorTypeEnum.IN_COMPARATOR,estados));
	// }else{
	// if(articuloFiltro.getBaseDTO().getAplicaRegistroSanitario().equals(Boolean.TRUE)){
	// Boolean[] estados = new Boolean[]{Boolean.TRUE};
	// articuloFiltro.getCriteriaSearch().addCriteriaSearchParameter(new
	// CriteriaSearchParameter<Boolean>("aplicaRegistroSanitario",
	// ComparatorTypeEnum.EQUAL_COMPARATOR,estados));
	// }else{
	// Boolean[] estados = new Boolean[]{Boolean.FALSE};
	// articuloFiltro.getCriteriaSearch().addCriteriaSearchParameter(new
	// CriteriaSearchParameter<Boolean>("aplicaRegistroSanitario",
	// ComparatorTypeEnum.EQUAL_COMPARATOR,estados));
	// }
	// }
	//
	// //Restricciones para B2B Reg San exclusion Clase Obsoletos
	// String[] retricClasificacion = new String[]{"9___"};
	// articuloFiltro.getCriteriaSearch().addCriteriaSearchParameter(new
	// CriteriaSearchParameter<String>("codigoClasificacion",
	// ComparatorTypeEnum.LIKE_EXACT_COMPARATOR,Boolean.TRUE,
	// retricClasificacion));
	//
	// //filtro proveedor
	// Collection<ArticuloProveedorDTO> articuloProveedorCol = new
	// ArrayList<ArticuloProveedorDTO>();
	// articuloProveedorCol.add(articuloFiltro.getArticuloProveedorDTO());
	// articuloFiltro.getBaseDTO().setArticuloProveedorCol(articuloProveedorCol);
	// }

	/**
	 * Metodo que incluye las restricciones necesarias para la busqueda de
	 * Articulos desde Sispe y B2B
	 * 
	 * @param articuloDTO
	 * @return
	 */
	@Override
	public ArticuloDTO incluirRestricionesEspecialesArticulo(ArticuloDTO articuloDTO) throws SICException {
		// creacion de las Restricciones especificas a nivel de las Clase
		// ArticuloRestriccionesPedidosEspeciales
		if(CollectionUtils.isEmpty(articuloDTO.getCriteriaRestrictions())){
			articuloDTO.setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());
		}
		
		ArticuloRestriccionesPedidosEspeciales articuloRestriccionesPedidosEspeciales = new ArticuloRestriccionesPedidosEspeciales(articuloDTO);
		articuloDTO.getCriteriaRestrictions().add(articuloRestriccionesPedidosEspeciales);

		// instancia de criteria si no ha sido creada anterioremente
		if (articuloDTO.getCriteriaSearch() == null) {
			articuloDTO.setCriteriaSearch(new CriteriaSearch());
		}
		// condicion de busqueda a nivel de descripcion para busquedas avanzadas
		// mediante '+'
		if (!StringUtils.isEmpty(articuloDTO.getDescripcionArticulo())) {
			String descripcionAvanzada = StringUtils.replace(articuloDTO.getDescripcionArticulo(), SICConstantes.SEPARADOR_PALABRAS, SICConstantes.PREFIJO_CONSULTA);
			articuloDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("descripcionArticulo", ComparatorTypeEnum.LIKE_ANYWHERE_COMPARATOR, descripcionAvanzada));
			articuloDTO.setDescripcionArticulo(null);
		}
		// condicion de busqueda a nivel de codigo articulo para que se realice
		// un IN de un grupo de codigos de articulo separadas por ','
		if (articuloDTO.getCodigoTipoArticulo() != null) {
			articuloDTO.setCodigoTipoArticulo(null);
		}
		// condicion de busqueda a nivel de codigo de clasificacion para que se
		// realice un IN de un grupo de clasificaciones separadas por ','
		if (articuloDTO.getCodigoClasificacion() != null) {
			String codigosClasificacion[] = articuloDTO.getCodigoClasificacion().split(",");
			if (codigosClasificacion.length > 1) {
				articuloDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("codigoClasificacion", ComparatorTypeEnum.IN_COMPARATOR, codigosClasificacion));
				articuloDTO.setCodigoClasificacion(null);
			}
		}
		// condicion de busqueda a nivel de codigo de subclasificacion para que
		// se realice un IN de un grupo de subclasificaciones separadas por ','
		if (articuloDTO.getTieneClasificacion() && !StringUtils.isEmpty(articuloDTO.getClasificacionDTO().getDescripcionClasificacion())) {
			String descripcionAvanzada = StringUtils.replace(articuloDTO.getClasificacionDTO().getDescripcionClasificacion(), SICConstantes.SEPARADOR_PALABRAS, SICConstantes.PREFIJO_CONSULTA);
			articuloDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("clasificacionDTO.descripcionClasificacion", ComparatorTypeEnum.LIKE_ANYWHERE_COMPARATOR, descripcionAvanzada));
			articuloDTO.getClasificacionDTO().setDescripcionClasificacion(null);
		}
		return articuloDTO;
	}

	public void cargarCadenaDescuentos(ArticuloProveedorDTO articuloProveedorDTO) throws SICException {
		if (!articuloProveedorDTO.getTieneDescuentoProveedorArticuloCol()) {
			// criterios de busqueda segun estado, prioridad y tipo de descuento
//			TipoDescuentoDTO tipoDescuentoDTO = new TipoDescuentoDTO();
//			tipoDescuentoDTO.setCriteriaSearch(new CriteriaSearch());
			String[] valoresTipoUso = new String[] { EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento(), EnumTipoAplicacionDescuento.COSTO_CONVENIO.getValorTipoAplicacionDescuento() };
//
//			tipoDescuentoDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorTipoUso", ComparatorTypeEnum.IN_COMPARATOR, valoresTipoUso));
//			tipoDescuentoDTO.getCriteriaSearch().addCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoTipoUso", ComparatorTypeEnum.EQUAL_COMPARATOR, SICMessages.getInstancia().getInteger("ec.com.smx.sic.catalogo.tipoUsoDescuentoArticulo")));
//			tipoDescuentoDTO.setOrderByField(OrderBy.orderAsc(new String[] { "prioridad" }));

			DescuentoProveedorArticuloDTO descProveArt = new DescuentoProveedorArticuloDTO();
			// <>TIPODESCUENTO
			descProveArt.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
			descProveArt.getAsignacionTipoDescuento().setOrderByField(OrderBy.orderAsc(new String[] { "prioridad" }));
//			descProveArt.getAsignacionTipoDescuento().setTipoDescuento(tipoDescuentoDTO);
			descProveArt.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento()));
			descProveArt.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO));
			descProveArt.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAplicacionTipoDescuento", ComparatorTypeEnum.IN_COMPARATOR, valoresTipoUso));
			descProveArt.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO));
			descProveArt.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			descProveArt.setCodigoArticulo(articuloProveedorDTO.getId().getCodigoArticulo());
			descProveArt.setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
			descProveArt.getId().setCodigoCompania(articuloProveedorDTO.getId().getCodigoCompania());
			descProveArt.setEquivalenciaPorcentajeDescuento(new EquivalenciaPorcentajeDescuentoDTO());

			articuloProveedorDTO.setDescuentoProveedorArticuloCol(dataGestor.findObjects(descProveArt));
		}
		if (!articuloProveedorDTO.getTieneUnidadesManejo()) {
			// busqueda de los descuentos por unidades de manejo
			// EquivalenciaPorcentajeDescuentoDTO
			// equivalenciaPorcentajeDescuentoDTO = new
			// EquivalenciaPorcentajeDescuentoDTO();
			// equivalenciaPorcentajeDescuentoDTO.setTipoDescuento(new
			// TipoDescuentoDTO());

			// ArticuloUnidadManejoDTO articuloProveedorUnidadManejoDTO = new
			// ArticuloUnidadManejoDTO();
			// articuloProveedorUnidadManejoDTO.getId().setCodigoCompania(articuloProveedorDTO.getId().getCodigoCompania());
			// articuloProveedorUnidadManejoDTO.getId().setCodigoArticulo(articuloProveedorDTO.getId().getCodigoArticulo());
			// articuloProveedorUnidadManejoDTO.setEstadoUnidadManejo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			// articuloProveedorUnidadManejoDTO.setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
			// articuloProveedorUnidadManejoDTO.setEquivalenciaPorcentajeDescuentoDTO(equivalenciaPorcentajeDescuentoDTO);

			ArticuloUnidadManejoProveedorDTO ump = new ArticuloUnidadManejoProveedorDTO();
			ump.getId().setCodigoCompania(articuloProveedorDTO.getId().getCodigoCompania());
			ump.getId().setCodigoProveedor(articuloProveedorDTO.getId().getCodigoProveedor());
			ump.setCodigoArticulo(articuloProveedorDTO.getId().getCodigoArticulo());
			ump.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			
			ump.setEquivalenciaPorcentajeDescuentoCol(new ArrayList<EquivalenciaPorcentajeDescuentoDTO>());
			EquivalenciaPorcentajeDescuentoDTO equivalencia = new EquivalenciaPorcentajeDescuentoDTO();
			// <>TIPODESCUENTO
			equivalencia.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
			equivalencia.getAsignacionTipoDescuento().setTipoDescuento(new TipoDescuentoDTO());
			equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento()));
			equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAsignacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO));
			equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento()));
			equivalencia.getAsignacionTipoDescuento().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("codigoAplicacionTipoDescuento", ComparatorTypeEnum.EQUAL_COMPARATOR, EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO));
			ump.getEquivalenciaPorcentajeDescuentoCol().add(equivalencia);
			
			//ump.setEquivalenciaPorcentajeDescuentoDTO(new EquivalenciaPorcentajeDescuentoDTO());
			//ump.getEquivalenciaPorcentajeDescuentoDTO().setTipoDescuento(new TipoDescuentoDTO());

			articuloProveedorDTO.setUnidadesManejo(dataGestor.findObjects(ump));
		}
	}
	
	private ArticuloVO iniciarPlantillaEdicionMasiva(){
		ArticuloVO articuloVO = new ArticuloVO();
		articuloVO.setBaseDTO(new ArticuloDTO());
		articuloVO.getBaseDTO().setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		articuloVO.getBaseDTO().setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
		articuloVO.getBaseDTO().getArticuloProveedorCol().add(new ArticuloProveedorDTO());
		articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		articuloVO.getBaseDTO().setCodigoEstado(SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO);
		articuloVO.getBaseDTO().setCodigoTipoArticulo(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON);
		
		articuloVO.addDynamicProperty("filtroFechaCaducidad", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroArticuloTemporada", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroMarcaComercial", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroMarcaParticipacion", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroPaisOrigen", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroLugarCompra", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroArticuloTamanio", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroArticuloAgrupador", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroArticuloVidaUtil", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroArticuloTiempoRefrigeracion", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroArticuloTiempoCongelacion", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroArticuloMaterial", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroArticuloMonedaOrigen", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroArticuloPorcentajeComision", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroArticuloTemporada", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroArticuloControlPrecio", Boolean.TRUE);
		articuloVO.addDynamicProperty("filtroPrototipo", Boolean.TRUE);
		
		return articuloVO;
	}
	
	public Integer buscarCantidadArticulosEdicionInterna(String sqlQuery)throws SICException{
		return articuloDAO.buscarCantidadArticulosEdicionInterna(sqlQuery);
	}
	
	/**
	 * metodo que busca la cantidad de articulos en la edicion masiva
	 */
	public Long buscarCantidadArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException{
		
		ArticuloVO articuloVO = iniciarPlantillaEdicionMasiva();
		Criterion criterion = incluirRestriccionesBusquedaArticuloEdicion(articuloVO, plantillaFiltrosBusquedaMAX);
		
		Long numeroArticulos;
		//busca la cantidad de articulos encontrados
		try{
			numeroArticulos = articuloDAO.obtenerCantidadArticulosEdicion(articuloVO, criterion);
		}catch(SICException e){
			Logeable.LOG_SICV2.info(e.getMessage());
			throw new SICException(SICCodigosError.CODIGO_ERROR_BUSQUEDA,"Ha ocurrido un error al consultar art\u00EDculos.");
		}
		
		return numeroArticulos;
	}
	
	/**
	 * metodo que busca los articulos en la edicion masiva
	 */
	public Collection<ArticuloEdicionMasivaVO> buscarArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException{
		Collection<ArticuloEdicionMasivaVO> articulosCol = null;
		
		ArticuloVO articuloVO = iniciarPlantillaEdicionMasiva();
		
		Criterion criterion = incluirRestriccionesBusquedaArticuloEdicion(articuloVO, plantillaFiltrosBusquedaMAX);
		//busca los articulos con el criterio de busqueda
		Collection<ArticuloEdicionMasivaVO> articulosBusqueda;
		try{
			articulosBusqueda= articuloDAO.obtenerArticulosEdicion(articuloVO , criterion);
		}catch(SICException e){
			Logeable.LOG_SICV2.info(e.getMessage());
			throw new SICException(SICCodigosError.CODIGO_ERROR_BUSQUEDA,"Ha ocurrido un error al consultar art\u00EDculos.");
		}
		//arma la estructura de la edicion(proveedor, duracion conservacion)
		articulosCol = this.armarEstructuraResultadoEdicion(articulosBusqueda);
		
		return articulosCol;
	}
	
	/**
	 * asignamos los articulo proveedor que tengan el mismo articulo y a\u00F1adimos en la coleccion del articulo padre
	 * @param articuloEdicionMasivaParam
	 * @param artCol
	 * @param origenProveedor
	 */
	private void armarEstructuraArticuloProveedor(ArticuloEdicionMasivaVO articuloEdicionMasivaParam, Collection<ArticuloEdicionMasivaVO> artCol){
		ArticuloEdicionMasivaVO articuloEdicionMasivaHijo;
		for(ArticuloEdicionMasivaVO articuloEdicionMasivaVO : artCol){
				
				if(!StringUtils.equals(articuloEdicionMasivaVO.getCodigoProveedor(), articuloEdicionMasivaParam.getCodigoProveedor())
						&& StringUtils.equals(articuloEdicionMasivaVO.getCodigoArticulo(), articuloEdicionMasivaParam.getCodigoArticulo())){
					articuloEdicionMasivaHijo = new ArticuloEdicionMasivaVO();
					articuloEdicionMasivaHijo.setCodigoProveedor(articuloEdicionMasivaVO.getCodigoProveedor());
					articuloEdicionMasivaHijo.setReferenciaExterna(articuloEdicionMasivaVO.getReferenciaExterna());
					articuloEdicionMasivaHijo.setReferenciaInterna(articuloEdicionMasivaVO.getReferenciaInterna());
					articuloEdicionMasivaHijo.setCodigoArticulo(articuloEdicionMasivaVO.getCodigoArticulo());
					articuloEdicionMasivaHijo.setCodigoCompania(articuloEdicionMasivaVO.getCodigoCompania());
					articuloEdicionMasivaHijo.setEsArticuloImportado(articuloEdicionMasivaVO.getEsArticuloImportado());
					articuloEdicionMasivaHijo.setCostoMonedaOrigen(articuloEdicionMasivaVO.getCostoMonedaOrigen());
					articuloEdicionMasivaHijo.setPorcentajeComision(articuloEdicionMasivaVO.getPorcentajeComision());
					
					if(CollectionUtils.isEmpty(articuloEdicionMasivaParam.getProveedorCol())){
						articuloEdicionMasivaParam.setProveedorCol(new ArrayList<ArticuloEdicionMasivaVO>());
					}
					
					Boolean existe = Boolean.FALSE;
					
					if(CollectionUtils.isNotEmpty(articuloEdicionMasivaParam.getProveedorCol())){
						for (ArticuloEdicionMasivaVO edicionMasivaVO : articuloEdicionMasivaParam.getProveedorCol()){
							if(StringUtils.equals(articuloEdicionMasivaHijo.getCodigoProveedor() , edicionMasivaVO.getCodigoProveedor())){
								existe = Boolean.TRUE;
							}
						}
					}
					if(!existe){
						articuloEdicionMasivaParam.getProveedorCol().add(articuloEdicionMasivaHijo);
					}
				}
				
		}
	}
	
	private void armarEstructuraCaracteristicaEspecial(ArticuloEdicionMasivaVO articuloEdicionMasivaParam, Collection<ArticuloEdicionMasivaVO> artCol){
		ArticuloEdicionMasivaVO articuloEdicionMasivaHijo;
		for(ArticuloEdicionMasivaVO articuloEdicionMasivaVO : artCol){
				
			if( StringUtils.equals(articuloEdicionMasivaVO.getCodigoArticulo(), articuloEdicionMasivaParam.getCodigoArticulo())){
				
				if(articuloEdicionMasivaVO.getCodigoTipoAgrupador() != null
						&& articuloEdicionMasivaVO.getCodigoTipoAgrupador().compareTo(TipoCatalogoArticulo.TIPO_MARCAS_ESPECIALES) == 0){
					articuloEdicionMasivaHijo = new ArticuloEdicionMasivaVO();
					articuloEdicionMasivaHijo.setCodigoTipoAgrupador(articuloEdicionMasivaVO.getCodigoTipoAgrupador());
					articuloEdicionMasivaHijo.setValorTipoAgrupador(articuloEdicionMasivaVO.getValorTipoAgrupador());
					articuloEdicionMasivaHijo.setAgrupador(articuloEdicionMasivaVO.getAgrupador());
					articuloEdicionMasivaHijo.setCodigoArticulo(articuloEdicionMasivaVO.getCodigoArticulo());
					articuloEdicionMasivaHijo.setCodigoCompania(articuloEdicionMasivaVO.getCodigoCompania());
					articuloEdicionMasivaHijo.setEvent("1");
					
					if(CollectionUtils.isEmpty(articuloEdicionMasivaParam.getCaracteristicasEspeciales())){
						articuloEdicionMasivaParam.setCaracteristicasEspeciales(new ArrayList<ArticuloEdicionMasivaVO>());
					}
					
					Boolean existe = Boolean.FALSE;
					
					if(CollectionUtils.isNotEmpty(articuloEdicionMasivaParam.getCaracteristicasEspeciales())){
						for (ArticuloEdicionMasivaVO edicionMasivaVO : articuloEdicionMasivaParam.getCaracteristicasEspeciales()){
							if(articuloEdicionMasivaHijo.getValorTipoAgrupador().equals(edicionMasivaVO.getValorTipoAgrupador())){
								existe = Boolean.TRUE;
							}
						}
					}
					if(!existe){
						articuloEdicionMasivaParam.getCaracteristicasEspeciales().add(articuloEdicionMasivaHijo);
					}
				}
				if(articuloEdicionMasivaVO.getCodigoTipoAgrupador() != null
						&& articuloEdicionMasivaVO.getCodigoTipoAgrupador().compareTo(SICArticuloConstantes.getInstancia().CATALOGOTIPO_AGRUPADOR) == 0){
					articuloEdicionMasivaParam.setCodigoTipoAgrupador(articuloEdicionMasivaVO.getCodigoTipoAgrupador());
					articuloEdicionMasivaParam.setValorTipoAgrupador(articuloEdicionMasivaVO.getValorTipoAgrupador());
					articuloEdicionMasivaParam.setAgrupador(articuloEdicionMasivaVO.getAgrupador());
				}
			}
		}
		//nulificamos los valores de caracteristica especial en los campos del agrupador padre(240)
		if(articuloEdicionMasivaParam.getCodigoTipoAgrupador() != null 
				&& articuloEdicionMasivaParam.getCodigoTipoAgrupador().compareTo(TipoCatalogoArticulo.TIPO_MARCAS_ESPECIALES) == 0){
			articuloEdicionMasivaParam.setCodigoTipoAgrupador(null);
			articuloEdicionMasivaParam.setValorTipoAgrupador(null);
			articuloEdicionMasivaParam.setAgrupador(null);
		}
	}
	
	/**
	 * Contruye la estructura de articulo impuesto en el ArticuloEdicionMasivaVO
	 * @param articuloEdicionMasivaParam
	 * @param artCol
	 */
	private void armarEstructuraArticuloImpuesto(ArticuloEdicionMasivaVO articuloEdicionMasivaParam, Collection<ArticuloEdicionMasivaVO> artCol){
		ArticuloEdicionMasivaVO articuloEdicionMasivaHijo;
		for(ArticuloEdicionMasivaVO articuloEdicionMasivaVO : artCol){
				
				if( StringUtils.equals(articuloEdicionMasivaVO.getCodigoArticulo(), articuloEdicionMasivaParam.getCodigoArticulo())){
					articuloEdicionMasivaHijo = new ArticuloEdicionMasivaVO();
					articuloEdicionMasivaHijo.setCodigoTipoImpuesto(articuloEdicionMasivaVO.getCodigoTipoImpuesto());
					articuloEdicionMasivaHijo.setEsParaCompra(articuloEdicionMasivaVO.getEsParaCompra());
					articuloEdicionMasivaHijo.setEsParaVenta(articuloEdicionMasivaVO.getEsParaVenta());
					
					
					if(CollectionUtils.isEmpty(articuloEdicionMasivaParam.getArticuloImpuestoCol())){
						articuloEdicionMasivaParam.setArticuloImpuestoCol(new HashSet<ArticuloEdicionMasivaVO>());
					}
					
					Boolean existe = Boolean.FALSE;
					
					if(CollectionUtils.isNotEmpty(articuloEdicionMasivaParam.getArticuloImpuestoCol())){
						for (ArticuloEdicionMasivaVO edicionMasivaVO : articuloEdicionMasivaParam.getArticuloImpuestoCol()){
							if(articuloEdicionMasivaHijo.getCodigoTipoImpuesto() == edicionMasivaVO.getCodigoTipoImpuesto()){
								existe = Boolean.TRUE;
							}
						}
					}
					if(!existe){
						articuloEdicionMasivaParam.getArticuloImpuestoCol().add(articuloEdicionMasivaHijo);
					}
				}
				
		}
	}
	
	/**
	 * arma la estructura de varios datos del articulo
	 * @param articuloEdicionMasivaParam
	 * @param articulosCol
	 */
	private void armarEstructuraDatosArticulo(ArticuloEdicionMasivaVO articuloEdicionMasivaParam, Collection<ArticuloEdicionMasivaVO> articulosCol){
		
		//asigna los valores de fecha temporada
		if(articuloEdicionMasivaParam.getFechaInicialTemporada() != null){
			articuloEdicionMasivaParam.setFechaInicioTemporada(new SimpleDateFormat("yyyy-MM-dd").format(articuloEdicionMasivaParam.getFechaInicialTemporada()));
		}
		if(articuloEdicionMasivaParam.getFechaFinalTemporada() != null){
			articuloEdicionMasivaParam.setFechaFinTemporada(new SimpleDateFormat("yyyy-MM-dd").format(articuloEdicionMasivaParam.getFechaFinalTemporada()));
		}
		
		//asigna el valor de la clase del articulo
		articuloEdicionMasivaParam.setClase(articuloEdicionMasivaParam.getCodigoClase() +" - "+articuloEdicionMasivaParam.getClase());
		
		//arma la estructura de duracion conservacion
		for(ArticuloEdicionMasivaVO articuloEdicionMasivaVO : articulosCol){
			if(StringUtils.equals(articuloEdicionMasivaVO.getCodigoArticulo() , articuloEdicionMasivaParam.getCodigoArticulo())){
				if(articuloEdicionMasivaVO.getCodigoTipoConservacion() != null && articuloEdicionMasivaVO.getCodigoTipoConservacion().compareTo(SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION) == 0
						&& StringUtils.equals(articuloEdicionMasivaVO.getValorTipoConservacion(), SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONLOCAL)){
					articuloEdicionMasivaParam.setTiempoVidaUtil(articuloEdicionMasivaVO.getTiempoDuracionConservacion());
				}
				if(articuloEdicionMasivaVO.getCodigoTipoConservacion() != null && articuloEdicionMasivaVO.getCodigoTipoConservacion().compareTo(SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION) == 0
						&& StringUtils.equals(articuloEdicionMasivaVO.getValorTipoConservacion(), SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONREFRIGERADO)){
					articuloEdicionMasivaParam.setTiempoRefrigeracion(articuloEdicionMasivaVO.getTiempoDuracionConservacion());
				}
				if(articuloEdicionMasivaVO.getCodigoTipoConservacion() != null && articuloEdicionMasivaVO.getCodigoTipoConservacion().compareTo(SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION) == 0
						&& StringUtils.equals(articuloEdicionMasivaVO.getValorTipoConservacion(), SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONCONGELADO)){
					articuloEdicionMasivaParam.setTiempoCongelacion(articuloEdicionMasivaVO.getTiempoDuracionConservacion());
				}
			}
		}
	}
	
	private Boolean verificarExistenciaArticulo(ArticuloEdicionMasivaVO articuloEdicionMasivaVO , Collection<ArticuloEdicionMasivaVO> artCol){
		for(ArticuloEdicionMasivaVO articuloEdicionMasivaVO2 : artCol){
			if(StringUtils.equals(articuloEdicionMasivaVO2.getCodigoArticulo(),articuloEdicionMasivaVO.getCodigoArticulo())){
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
		
	public Collection<ArticuloEdicionMasivaVO> armarEstructuraResultadoEdicion(Collection<ArticuloEdicionMasivaVO> articulosCol) {
		String origenImportado = SICProveedorMessages.getInstancia().getString("ec.com.smx.max.proveedor.importado");
		Collection<ArticuloEdicionMasivaVO> articuloEdicionMasivaCol = new ArrayList<ArticuloEdicionMasivaVO>();
		//arma una coleccion de articulos con codigoArticulo unico
		for(ArticuloEdicionMasivaVO articuloEdicionMasivaVO : articulosCol){
			//verifica si los articulos proveedores son importados o importadores
			articuloEdicionMasivaVO.setEsArticuloImportado(Boolean.FALSE);
			if(StringUtils.equals(articuloEdicionMasivaVO.getOrigenProveedor(),origenImportado )
					|| StringUtils.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO, articuloEdicionMasivaVO.getEsImportador())){
				articuloEdicionMasivaVO.setEsArticuloImportado(Boolean.TRUE);
			}
			if(articuloEdicionMasivaVO.getCodigoProveedor() != null && StringUtils.isNotEmpty(articuloEdicionMasivaVO.getCodigoProveedor() )){
				if(!verificarExistenciaArticulo(articuloEdicionMasivaVO, articuloEdicionMasivaCol)){
					articuloEdicionMasivaCol.add(articuloEdicionMasivaVO);
				}
			}
		}
		//recoremos la coleccion final
		for(ArticuloEdicionMasivaVO articuloEdicionMasivaVO : articuloEdicionMasivaCol){
			//asignamos los articulo proveedor que tengan el mismo articulo
			this.armarEstructuraArticuloProveedor(articuloEdicionMasivaVO , articulosCol);
			//asignamos los valores de varios datos del articulo(clase, duracion conservacion, temporada)
			this.armarEstructuraDatosArticulo(articuloEdicionMasivaVO , articulosCol);
			//creamos la estructura de agrupadores tipo caracteristica comercial
			this.armarEstructuraCaracteristicaEspecial(articuloEdicionMasivaVO , articulosCol);
			//crea la estructura de articulo impuesto
			this.armarEstructuraArticuloImpuesto(articuloEdicionMasivaVO, articulosCol);
			// construye el valor del causal para mostrar en el select
			if( articuloEdicionMasivaVO.getCausal() != null ){
				articuloEdicionMasivaVO.setCausal(articuloEdicionMasivaVO.getValorTipoCausal() + " - " + articuloEdicionMasivaVO.getCausal());
			}
		}
		
		return articuloEdicionMasivaCol;
	}

	public Collection<ArticuloDTO> buscarTodoArticulosCupon(ArticuloVO articuloVO, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX) throws SICException {
		Collection<ArticuloDTO> articulosCol = new ArrayList<ArticuloDTO>();
		try{
			ArticuloVO articuloFiltroCupon = new ArticuloVO();
			
			incluirRestriccionesBusquedaArticulo(articuloFiltroCupon, plantillaFiltrosBusquedaMAX);
			this.asignarRelacionesArticuloCupon(articuloFiltroCupon.getBaseDTO());
			articulosCol = dataGestor.findObjects(articuloFiltroCupon.getBaseDTO());
		}catch(Exception e){
			Logeable.LOG_SICV2.error(e.getMessage());
		}
		
		return articulosCol;
	}

	/**
	 * Metodo que obtiene una coleccion de articulos del proveedor por codigo de
	 * barras o codigo de referencia externa
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoBarras
	 * @param codigoReferenciaExterna
	 * @return
	 * @throws SICException
	 */
	@Override
	public Collection<ArticuloProveedorDTO> buscarArticuloProveedor(Integer codigoCompania, final String codigoBarras, final String codigoReferenciaExterna, final String codigoProveedor) throws SICException {
		Collection<ArticuloProveedorDTO> articulorProveedorDTOCol = null;
		Collection<ArticuloMaterialDTO> articuloMaterialDTOCol = null;
		Collection<ArticuloBitacoraCodigoBarrasDTO> articuloBitacoraCodigoBarrasDTOCol = null;
		ArticuloProveedorDTO articuloProveedorDTO = new ArticuloProveedorDTO();
		ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO = null;
		ArticuloMaterialDTO articuloMaterialDTO = null;
		ArticuloProveedorDTO artPro = null;
		try {
			if (codigoBarras == null && codigoReferenciaExterna == null) {
				throw new SICException("Debe enviar el c\u00F3digo de barras o el c\u00F3digo de referencia externa del proveedor");
			}
			//El ordenamiento es por precodificado ya que si solamente se envia el codigo de referencia este se interpreta como un nuevo articulo ya que el articulo existente codificado posee codigo de barras
			artPro = articuloProveedorDAO.obtenerArticuloProveedor(codigoCompania, codigoBarras, codigoReferenciaExterna, codigoProveedor, SICArticuloConstantes.ESTADOARTICULO_PRECODIFICADO);
			
			if(artPro != null){
				// articulo proveedor
				articuloProveedorDTO = new ArticuloProveedorDTO();
				articuloProveedorDTO.getId().setCodigoCompania(codigoCompania);
				articuloProveedorDTO.getId().setCodigoArticulo(artPro.getId().getCodigoArticulo());
				articuloProveedorDTO.getId().setCodigoProveedor(artPro.getId().getCodigoProveedor());								
				articuloProveedorDTO.setEstadoArticuloProveedor(SICConstantes.ESTADO_ACTIVO_NUMERICO);				
				
				// articulo
				articuloProveedorDTO.setArticulo(new ArticuloDTO());
				articuloProveedorDTO.getArticulo().getId().setCodigoCompania(codigoCompania);
				articuloProveedorDTO.getArticulo().setEstadoArticulo(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				
				// articulo comercial
				articuloProveedorDTO.getArticulo().setArticuloComercialDTO(new ArticuloComercialDTO());
				articuloProveedorDTO.getArticulo().getArticuloComercialDTO().setMarcaComercialArticulo(new MarcaArticuloDTO());
				
				// articulo codigo de barras
				articuloBitacoraCodigoBarrasDTOCol = new ArrayList<ArticuloBitacoraCodigoBarrasDTO>();
				articuloBitacoraCodigoBarrasDTO = new ArticuloBitacoraCodigoBarrasDTO();
				articuloBitacoraCodigoBarrasDTO.getId().setCodigoCompania(codigoCompania);
				articuloBitacoraCodigoBarrasDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloBitacora", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
				articuloBitacoraCodigoBarrasDTOCol.add(articuloBitacoraCodigoBarrasDTO);
				articuloProveedorDTO.getArticulo().setArtBitCodBarCol(articuloBitacoraCodigoBarrasDTOCol);
				
				// articulo material
				articuloMaterialDTOCol = new ArrayList<ArticuloMaterialDTO>();
				articuloMaterialDTO = new ArticuloMaterialDTO();
				articuloMaterialDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
				articuloMaterialDTOCol.add(articuloMaterialDTO);
				articuloProveedorDTO.getArticulo().setArticuloMaterialDTOs(articuloMaterialDTOCol);
				
				// articulo importacion
				articuloProveedorDTO.setArticuloImportacion(new ArticuloImportacionDTO());
				
				articulorProveedorDTOCol = this.dataGestor.findObjects(articuloProveedorDTO);
			}
		} catch (SICException e) {
			Logeable.LOG_SICV2.error("Error al buscar art\u00EDculos proveedor {}", e);
			throw e;
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al buscar art\u00EDculos proveedor {}", e);
			throw new SICException(e);
		}
		return articulorProveedorDTOCol;
	}

	/**
	 * 
	 * @param articuloImportadoVO
	 * @return
	 * @throws SICException
	 */
	public ArticuloProveedorNovedadDTO buscarArticuloProveedorNovedadImportacion(ArticuloImportadoVO articuloImportadoVO) throws SICException {
		ArticuloProveedorNovedadDTO articuloProveedorNovedadDTO = null;
		Collection<ArticuloProveedorDTO> articuloProveedorDTOCol = null;
		String codigoBarras = null;
		String codigoReferenciaExterna = null;
		Validator validator = null;
		try {
			// validaciones iniciales
			if (articuloImportadoVO == null) {
				throw new SICException("El art\u00EDculo importaci\u00F3n se encuentra vac\u00EDo");
			}
			if (articuloImportadoVO.getCodigoCompania() == null) {
				throw new SICException("El c\u00F3digo de la compan\u00EDa se encuentra vac\u00EDo");
			}
			if (articuloImportadoVO.getCodigoProveedor() == null) {
				throw new SICException("El c\u00F3digo del proveedor se encuentra vac\u00EDo");
			}
			if (articuloImportadoVO.getCodigoBarras() == null && articuloImportadoVO.getCodigoReferenciaExterna() == null) {
				throw new SICException("Debe existir un c\u00F3digo de barras o una referencia externa");
			}
			// obtiene los articulos que tengan el codigo de barras o referencia
			// externa enviada
			validator = new ValidatorImpl();
			if (articuloImportadoVO.getCodigoBarras() != null && !articuloImportadoVO.getCodigoBarras().isEmpty() && validator.validateEAN(articuloImportadoVO.getCodigoBarras())) {
				codigoBarras = articuloImportadoVO.getCodigoBarras();
			}
			if (articuloImportadoVO.getCodigoReferenciaExterna() != null && !articuloImportadoVO.getCodigoReferenciaExterna().isEmpty()) {
				codigoReferenciaExterna = articuloImportadoVO.getCodigoReferenciaExterna();
			}
			if (!CollectionUtils.isEmpty(articuloImportadoVO.getCodigosLineasComerciales()) || articuloImportadoVO.getCodigoClienteCompra() != null) {
				articuloProveedorDTOCol = this.buscarArticuloProveedor(articuloImportadoVO.getCodigoCompania(), codigoBarras, codigoReferenciaExterna, !articuloImportadoVO.getValidarCodigoBarras() ? articuloImportadoVO.getCodigoProveedor() : null);
			} else {
				throw new SICException("Debe enviar la linea comercial o el cliente de importaci\u00F3n");
			}
			// verifica si los articulos encontrados son una novedad
			if (articuloProveedorDTOCol != null && !articuloProveedorDTOCol.isEmpty()) {
				for (ArticuloProveedorDTO articuloProveedorDTOIte : articuloProveedorDTOCol) {
					// articulo existente
					if (codigoBarras != null && articuloProveedorDTOIte.getArticulo().getCodigoBarrasActivo() != null && codigoBarras.equals(articuloProveedorDTOIte.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras()) && codigoReferenciaExterna != null && codigoReferenciaExterna.equals(articuloProveedorDTOIte.getCodigoReferenciaProveedor())
							&& articuloProveedorDTOIte.getId().getCodigoProveedor().equals(articuloImportadoVO.getCodigoProveedor())) {
						// se envia el articulo existente en la novedad y sin
						// referencias
						articuloProveedorNovedadDTO = new ArticuloProveedorNovedadDTO();
						if (articuloImportadoVO.getNoResolverCaso4()) {
							articuloProveedorNovedadDTO.setValorTipoNovedad(TipoCatalogoArticulo.VALOR_NOVEDAD_EXISTENTE_DIFERENCIAS_PROFORMA);
							articuloProveedorNovedadDTO.setArticuloProveedor(null);
							// anade la referencia
							ArticuloProveedorNovedadReferenciaDTO articuloNovedadReferenciaDTO = new ArticuloProveedorNovedadReferenciaDTO();
							articuloNovedadReferenciaDTO.getId().setCodigoCompania(articuloImportadoVO.getCodigoCompania());
							articuloNovedadReferenciaDTO.getId().setCodigoArticulo(articuloProveedorDTOIte.getId().getCodigoArticulo());
							articuloNovedadReferenciaDTO.getId().setCodigoProveedor(articuloProveedorDTOIte.getId().getCodigoProveedor());
							articuloNovedadReferenciaDTO.setArticuloProveedor(articuloProveedorDTOIte);
							articuloNovedadReferenciaDTO.setCodigoBarras(articuloProveedorDTOIte.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras());
							articuloNovedadReferenciaDTO.setReferenciaProveedor(articuloProveedorDTOIte.getCodigoReferenciaProveedor());
							articuloProveedorNovedadDTO.setReferencias(new ArrayList<ArticuloProveedorNovedadReferenciaDTO>());
							articuloProveedorNovedadDTO.getReferencias().add(articuloNovedadReferenciaDTO);
						} else {
							articuloProveedorNovedadDTO.setValorTipoNovedad(null);
							articuloProveedorNovedadDTO.setArticuloProveedor(articuloProveedorDTOIte);
							articuloProveedorNovedadDTO.setReferencias(null);
						}
						break;
					}
					// nuevo con novedad en referencia externa
					else if (codigoBarras != null && articuloProveedorDTOIte.getArticulo().getCodigoBarrasActivo() != null && codigoBarras.equals(articuloProveedorDTOIte.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras())) {
						if (articuloProveedorNovedadDTO == null) {
							articuloProveedorNovedadDTO = new ArticuloProveedorNovedadDTO();
						}
						if (articuloProveedorNovedadDTO.getValorTipoNovedad() == null) {
							articuloProveedorNovedadDTO.setValorTipoNovedad(TipoCatalogoArticulo.VALOR_NOVEDAD_REFERENCIAPROVEEDOR);
						} else if (articuloProveedorNovedadDTO.getValorTipoNovedad().equals(TipoCatalogoArticulo.VALOR_NOVEDAD_CODIGOBARRAS)) {
							articuloProveedorNovedadDTO.setValorTipoNovedad(TipoCatalogoArticulo.VALOR_NOVEDAD_CODIGOBARRAS_REFERENCIAPROVEEDOR);
						}
						articuloProveedorNovedadDTO.setArticuloProveedor(null);
						// anade la referencia
						ArticuloProveedorNovedadReferenciaDTO articuloNovedadReferenciaDTO = new ArticuloProveedorNovedadReferenciaDTO();
						articuloNovedadReferenciaDTO.getId().setCodigoCompania(articuloImportadoVO.getCodigoCompania());
						articuloNovedadReferenciaDTO.getId().setCodigoArticulo(articuloProveedorDTOIte.getId().getCodigoArticulo());
						articuloNovedadReferenciaDTO.getId().setCodigoProveedor(articuloProveedorDTOIte.getId().getCodigoProveedor());
						articuloNovedadReferenciaDTO.setArticuloProveedor(articuloProveedorDTOIte);
						articuloNovedadReferenciaDTO.setReferenciaProveedor(articuloProveedorDTOIte.getCodigoReferenciaProveedor());
						if (articuloProveedorNovedadDTO.getReferencias() == null) {
							articuloProveedorNovedadDTO.setReferencias(new ArrayList<ArticuloProveedorNovedadReferenciaDTO>());
						}
						articuloProveedorNovedadDTO.getReferencias().add(articuloNovedadReferenciaDTO);
					}
					// nuevo con novedad en codigo de barras
					else if (codigoReferenciaExterna != null && codigoReferenciaExterna.equals(articuloProveedorDTOIte.getCodigoReferenciaProveedor()) && articuloImportadoVO.getCodigoProveedor().equals(articuloProveedorDTOIte.getId().getCodigoProveedor())) {
						if (articuloProveedorNovedadDTO == null) {
							articuloProveedorNovedadDTO = new ArticuloProveedorNovedadDTO();
						}
						if (!articuloImportadoVO.getValidarCodigoBarras() && articuloProveedorNovedadDTO.getArticuloProveedor() == null) {
							articuloProveedorNovedadDTO = new ArticuloProveedorNovedadDTO();
							articuloProveedorNovedadDTO.setValorTipoNovedad(null);
							articuloProveedorNovedadDTO.setArticuloProveedor(articuloProveedorDTOIte);
							articuloProveedorNovedadDTO.setReferencias(null);
							break;
						} else {
							if (articuloProveedorNovedadDTO.getValorTipoNovedad() == null) {
								articuloProveedorNovedadDTO.setValorTipoNovedad(TipoCatalogoArticulo.VALOR_NOVEDAD_CODIGOBARRAS);
							} else if (articuloProveedorNovedadDTO.getValorTipoNovedad().equals(TipoCatalogoArticulo.VALOR_NOVEDAD_REFERENCIAPROVEEDOR)) {
								articuloProveedorNovedadDTO.setValorTipoNovedad(TipoCatalogoArticulo.VALOR_NOVEDAD_CODIGOBARRAS_REFERENCIAPROVEEDOR);
							}
							articuloProveedorNovedadDTO.setArticuloProveedor(null);
							// anade la referencia
							ArticuloProveedorNovedadReferenciaDTO articuloNovedadReferenciaDTO = new ArticuloProveedorNovedadReferenciaDTO();
							articuloNovedadReferenciaDTO.getId().setCodigoCompania(articuloImportadoVO.getCodigoCompania());
							articuloNovedadReferenciaDTO.getId().setCodigoArticulo(articuloProveedorDTOIte.getId().getCodigoArticulo());
							articuloNovedadReferenciaDTO.getId().setCodigoProveedor(articuloProveedorDTOIte.getId().getCodigoProveedor());
							articuloNovedadReferenciaDTO.setArticuloProveedor(articuloProveedorDTOIte);
							if (articuloProveedorDTOIte.getArticulo().getCodigoBarrasActivo() != null) {
								articuloNovedadReferenciaDTO.setCodigoBarras(articuloProveedorDTOIte.getArticulo().getCodigoBarrasActivo().getId().getCodigoBarras());
							}
							if (articuloProveedorNovedadDTO.getReferencias() == null) {
								articuloProveedorNovedadDTO.setReferencias(new ArrayList<ArticuloProveedorNovedadReferenciaDTO>());
							}
							articuloProveedorNovedadDTO.getReferencias().add(articuloNovedadReferenciaDTO);
						}
					}
				}
			}
		} catch (SICException e) {
			Logeable.LOG_SICV2.error("Error al buscar art\u00EDculos proveedor {}", e);
			throw e;
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al buscar art\u00EDculos proveedor {}", e);
			throw new SICException(e);
		}
		return articuloProveedorNovedadDTO;
	}

	/**
	 * @param articuloDAO
	 *            the articuloDAO to set
	 */
	public void setArticuloDAO(IArticuloDAO articuloDAO) {
		this.articuloDAO = articuloDAO;
	}

	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	public void setCalculoDatosProveedorGestor(ICalculoDatosProveedorGestor calculoDatosProveedorGestor) {
		this.calculoDatosProveedorGestor = calculoDatosProveedorGestor;
	}

	public void setArticuloProveedorDAO(IArticuloProveedorDAO articuloProveedorDAO) {
		this.articuloProveedorDAO = articuloProveedorDAO;
	}

	/**
	 * @param validacionArticuloGestor
	 *            the validacionArticuloGestor to set
	 */
	public final void setValidacionArticuloGestor(IValidacionArticuloGestor validacionArticuloGestor) {
		this.validacionArticuloGestor = validacionArticuloGestor;
	}

	public void setCalculoArticuloGestor(ICalculoArticuloGestor calculoArticuloGestor) {
		this.calculoArticuloGestor = calculoArticuloGestor;
	}

	public Collection<ArticuloDTO> busquedaArticuloFiltro(ArticuloVO articuloVO, Set<String> authorizedComponentsSet, Collection<String> ids) {
		ArticuloDTO articuloDTO = articuloVO.getBaseDTO();
		articuloDTO.addCriteriaSearchParameter(new CriteriaSearchParameter<String>("id.codigoArticulo", ComparatorTypeEnum.IN_COMPARATOR, ids.toArray(new String[] {})));
		articuloDTO.setArtBitCodBarCol(new ArrayList<ArticuloBitacoraCodigoBarrasDTO>());
		ArticuloBitacoraCodigoBarrasDTO bitacora = new ArticuloBitacoraCodigoBarrasDTO();
		bitacora.setEstadoArticuloBitacora(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		articuloDTO.getArtBitCodBarCol().add(bitacora);
		articuloDTO.setArticuloMedidaDTO(new ArticuloMedidaDTO());
		// articuloDTO.setUsuarioCreacionDTO(new UserDto());
		articuloDTO.setArticuloComercialDTO(new ArticuloComercialDTO());
		articuloDTO.getArticuloComercialDTO().setMarcaComercialArticulo(new MarcaArticuloDTO());

		articuloDTO.setClasificacionDTO(new ClasificacionDTO());
		articuloDTO.getClasificacionDTO().setClasificacionPadre(new ClasificacionDTO());
		articuloDTO.getClasificacionDTO().setValorTipoEstructura(null);
		articuloDTO.getClasificacionDTO().setCodigoTipoEstructura(null);
		articuloDTO.getClasificacionDTO().setBodegaDTO(new BodegaDTO());
		articuloDTO.setSubClasificacionDTO(new SubClasificacionDTO());
		articuloDTO.setGrupoAlcanceDTO(new GrupoTrabajoDTO());

		Collection<ArticuloDTO> articuloDTOs = this.articuloDAO.buscarArticulosPersonalizado(articuloDTO);

		this.busquedaRelacionArticulo(articuloVO, articuloDTOs, ids, authorizedComponentsSet);

		return articuloDTOs;
	}

	public void busquedaRelacionArticulo(ArticuloVO articuloVO, Collection<ArticuloDTO> articuloDTOs, Collection<String> ids, Set<String> authorizedComponentsSet) {
		// ArticuloFiltroDTO art = new ArticuloFiltroDTO();
		ArticuloDTO art = new ArticuloDTO();
		art.addCriteriaSearchParameter(new CriteriaSearchParameter<String>("id.codigoArticulo", ComparatorTypeEnum.IN_COMPARATOR, ids.toArray(new String[] {})));

		this.addRelaciones(articuloVO, art, authorizedComponentsSet);

		// Collection<ArticuloFiltroDTO> collFiltro =
		// dataGestor.findObjects(art);
		Collection<ArticuloDTO> collFiltro = dataGestor.findObjects(art);

		for (final ArticuloDTO articuloDTO : articuloDTOs) {
			// ArticuloFiltroDTO nuevoDTO = (ArticuloFiltroDTO)
			// CollectionUtils.find(collFiltro, new
			// BeanPredicate("id.codigoArticulo",
			// PredicateUtils.equalPredicate(articuloDTO.getId().getCodigoArticulo())));
			final ArticuloDTO nuevoDTO = (ArticuloDTO) CollectionUtils.find(collFiltro, new BeanPredicate("id.codigoArticulo", PredicateUtils.equalPredicate(articuloDTO.getId().getCodigoArticulo())));
			if (nuevoDTO != null) {
				articuloDTO.setArticuloProveedorCol(nuevoDTO.getArticuloProveedorCol());
				articuloDTO.setArticuloPrecioCol(nuevoDTO.getArticuloPrecioCol());
				articuloDTO.setArticuloImpuestoCol(nuevoDTO.getArticuloImpuestoCol());
				if (BooleanUtils.isTrue((Boolean) articuloVO.getDynamicProperty("tieneRegistroSanitario"))) {
					articuloDTO.setRegistroSanitarioCol(nuevoDTO.getRegistroSanitarioCol());
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void addRelaciones(ArticuloVO articuloVO, ArticuloDTO art, Set<String> authorizedComponentsSet) {

		art.getId().setCodigoCompania(1);

		// obtiene todas las restricciones de los filtros
		// CriteriaSearch criteriaSearchClone =
		// SerializationUtils.clone(articuloVO.getCriteriaSearch());
		// art.setCriteriaSearch(criteriaSearchClone);
		//
		// if( art.getCriteriaSearch() == null ){
		// art.setCriteriaSearch(new CriteriaSearch());
		// }

		ArticuloProveedorDTO apFiltro = new ArticuloProveedorDTO();
		apFiltro.setVistaProveedor(new VistaProveedorDTO());

		art.setArticuloProveedorCol(new ArrayList<ArticuloProveedorDTO>());
		art.getArticuloProveedorCol().add(apFiltro);
		if (authorizedComponentsSet != null && authorizedComponentsSet.contains(SICArticuloMessages.getInstancia().getString("identificador.componente.articulos.busqueda.visualizarCostos"))) {
			DynamicCriteriaRestriction dynamicCriteriaRestriction = new DynamicCriteriaRestriction();
			art.setCriteriaRestrictions(new ArrayList<CriteriaRestriction>());

			// CODIGO PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("codigoProveedor") != null) {
				dynamicCriteriaRestriction.add((CriteriaSearchParameter<String>) articuloVO.getBaseDTO().getDynamicProperty("codigoProveedor"));
			}
			// DOCUMENTO PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("numeroDocumento") != null) {
				dynamicCriteriaRestriction.add((CriteriaSearchParameter<String>) articuloVO.getBaseDTO().getDynamicProperty("numeroDocumento"));
			}
			// ORIGEN PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("origenProveedor") != null) {
				dynamicCriteriaRestriction.add((BaseCriteriaRestriction) articuloVO.getBaseDTO().getDynamicProperty("origenProveedor"));
			}
			// INDICADOR I PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("indicadorI") != null) {
				dynamicCriteriaRestriction.add((BaseCriteriaRestriction) articuloVO.getBaseDTO().getDynamicProperty("indicadorI"));
			}

			// NOMBRE PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("nombreComercialProv") != null) {
				dynamicCriteriaRestriction.add((BaseCriteriaRestriction) articuloVO.getBaseDTO().getDynamicProperty("nombreComercialProv"));
			}
			// ESTADO ARTICULO-PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("estadoProveedor") != null) {
				dynamicCriteriaRestriction.add((CriteriaSearchParameter<String>) articuloVO.getBaseDTO().getDynamicProperty("estadoProveedor"));
			}

			// ESTADO ARTICULO-PROVEEDOR
			if (articuloVO.getBaseDTO().getDynamicProperty("estadoArticuloProveedor") != null) {
				dynamicCriteriaRestriction.add((CriteriaSearchParameter<String>) articuloVO.getBaseDTO().getDynamicProperty("estadoArticuloProveedor"));
			}

			if (dynamicCriteriaRestriction.isNotEmptyCriteriaRestriction()) {
				art.getCriteriaRestrictions().add(dynamicCriteriaRestriction);
			}

			// asignarRelacionesArticuloPrecio(art);
			ArticuloPrecioDTO aprecioFiltro = new ArticuloPrecioDTO();
			// Realacion articulo precio
			if (!art.getTieneArticuloPrecio()) {
				aprecioFiltro.setTipoPrecioArticulo(new TipoPrecioArticuloDTO());
				aprecioFiltro.setOrderByField(OrderBy.orderDesc("tipoPrecioArticulo.orden"));
				aprecioFiltro.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoPrecio", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
				// relacion con la unidad de manejo
				ArticuloUnidadManejoDTO aum = new ArticuloUnidadManejoDTO();
				aum.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoUnidadManejo", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
				aum.setArticuloUnidadManejoUsoCol(new ArrayList<ArticuloUnidadManejoUsoDTO>());
				aum.getArticuloUnidadManejoUsoCol().add(new ArticuloUnidadManejoUsoDTO());
				aprecioFiltro.setArticuloUnidadManejo(aum);
				// relacion con los precios por local
				if (art.getNpCodigoLocal() != null) {
					ArticuloLocalPrecioDTO alp = new ArticuloLocalPrecioDTO();
					alp.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoPrecio", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
					alp.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("id.codigoLocal", ComparatorTypeEnum.EQUAL_COMPARATOR, art.getNpCodigoLocal()));
					aprecioFiltro.setArticuloLocalPrecioCol(new ArrayList<ArticuloLocalPrecioDTO>());
					aprecioFiltro.getArticuloLocalPrecioCol().add(alp);
				}
				// relacion con los precios generales
				art.setArticuloPrecioCol(new ArrayList<ArticuloPrecioDTO>());
				art.getArticuloPrecioCol().add(aprecioFiltro);
			}
			art.addJoin("descuentoVentaArticuloCol", JoinType.LEFT, new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));

			// relacion articulo impuestos
			if (!art.getTieneArticuloImpuestoCol()) {
				ArticuloImpuestoDTO ai = new ArticuloImpuestoDTO();
				ai.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoArticuloImpuesto", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
				ai.setTipoImpuestoArticulo(new TipoImpuestoDTO());
				ai.getTipoImpuestoArticulo().setGrupoImpuesto(new GrupoImpuestoDTO());
				ai.getTipoImpuestoArticulo().getGrupoImpuesto().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
				art.setArticuloImpuestoCol(new ArrayList<ArticuloImpuestoDTO>());
				art.getArticuloImpuestoCol().add(ai);
			}
			// apFiltro.setProveedor(new ProveedorDTO());
		}
		if (BooleanUtils.isTrue((Boolean) articuloVO.getDynamicProperty("tieneRegistroSanitario"))) {
			RelacionArticuloRegistroSanitarioDTO relacionArticuloRegistroSanitarioDTO = new RelacionArticuloRegistroSanitarioDTO();
			relacionArticuloRegistroSanitarioDTO.addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estado", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			relacionArticuloRegistroSanitarioDTO.setRegistroSanitario(new ArticuloRegistroSanitarioDTO());
			relacionArticuloRegistroSanitarioDTO.getRegistroSanitario().addJoinCriteriaSearchParameter(new CriteriaSearchParameter<String>("estadoRegistroSanitario", ComparatorTypeEnum.EQUAL_COMPARATOR, SICConstantes.ESTADO_ACTIVO_NUMERICO));
			art.setRegistroSanitarioCol(new ArrayList<RelacionArticuloRegistroSanitarioDTO>());
			art.getRegistroSanitarioCol().add(relacionArticuloRegistroSanitarioDTO);
		}

	}
	
	
	public Collection<ArticuloAsignacionLocalVO> obtenerArticuloLocal(ArticuloID articuloId , Integer tipoAreaTrabajoTic , String tipoAreaTrabajoValor , Boolean consultarCamposAsignacion)throws SICException{
		try{
			
			Collection<ArticuloAsignacionLocalVO> localesActivosCol = this.busquedaArticuloLocalPedidoDAO.obtenerArticuloLocal(articuloId , tipoAreaTrabajoTic , tipoAreaTrabajoValor);
			if(consultarCamposAsignacion){
				
				Collection<ArticuloLocalPedidoDTO> pedidoLocalesCol = this.busquedaArticuloLocalPedidoDAO.obtenerArticuloLocalPedido(articuloId);
				
				if(CollectionUtils.isNotEmpty(pedidoLocalesCol)){
					for(ArticuloLocalPedidoDTO articuloLocalPedidoDTO : pedidoLocalesCol){
						asignarValorPedidoLocal(localesActivosCol , articuloLocalPedidoDTO);
					}
				}
			}
			
			return localesActivosCol;
		}catch(Exception e){
			Logeable.LOG_SICV2.info("ha ocurrido un error al consultar los locales del articulo "+e.getMessage());
			throw new SICException("ha ocurrido un error al cargar el articulo");
		}
	}
	
	private void asignarValorPedidoLocal(Collection<ArticuloAsignacionLocalVO> asignacionArticuloCol , ArticuloLocalPedidoDTO articuloLocalPedidoDTO){
		if(CollectionUtils.isNotEmpty(asignacionArticuloCol)){
			for(ArticuloAsignacionLocalVO articuloAsignacionLocalVO : asignacionArticuloCol){
				if(articuloAsignacionLocalVO.getCodigoLocal().equals(articuloLocalPedidoDTO.getId().getCodigoLocal())){
					articuloAsignacionLocalVO.setCantidad(articuloLocalPedidoDTO.getCantidadMaxima());
					articuloAsignacionLocalVO.setFechaInicio(articuloLocalPedidoDTO.getFechaInicio());
					articuloAsignacionLocalVO.setFechaFin(articuloLocalPedidoDTO.getFechaFin());
					articuloAsignacionLocalVO.setEsCreacion(Boolean.FALSE);
				}
			}
		}
	}
	
	/**
	 * agrega caracteristicas especiales, para la exportacion en excel
	 * @param articulosCol
	 */
	private void agregarValoresCaracteristicaEspecial(Collection<ArticuloDTO> articulosCol){
		Collection<CatalogoValorDTO> caracteristicasEspeciales = obtenerCaracteristicasEspecialesActivas();
		if(CollectionUtils.isNotEmpty(articulosCol)){
			for(ArticuloDTO articuloDTO : articulosCol){
				Map<String, Object> caracteristicaEspecial = new HashMap<String, Object>();
				if(articuloDTO.getTieneArticuloAgrupador()){
					for(ArticuloAgrupadorDTO agrupadorDTO : articuloDTO.getArticuloAgrupadorCol()){
						if(CollectionUtils.isNotEmpty(caracteristicasEspeciales)){
							for(CatalogoValorDTO catalogoValorDTO : caracteristicasEspeciales){
								if(agrupadorDTO.getId().getValorTipoAgrupador().equals(catalogoValorDTO.getId().getCodigoCatalogoValor())){
									caracteristicaEspecial.put(catalogoValorDTO.getId().getCodigoCatalogoValor(), true);
								}
							}
						}
					}
				}
				articuloDTO.setCaracteristicaEspecial(caracteristicaEspecial);
			}
		}
	}
	
	private Collection<CatalogoValorDTO> obtenerCaracteristicasEspecialesActivas(){
		CatalogoValorDTO catalogoValorDTO = new CatalogoValorDTO();
		catalogoValorDTO.getId().setCodigoCatalogoTipo(TipoCatalogoArticulo.TIPO_MARCAS_ESPECIALES);
		catalogoValorDTO.setEstado(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO);
		Collection<CatalogoValorDTO> catalogoValorCol = dataGestor.findObjects(catalogoValorDTO);
		return catalogoValorCol;
	}
	
	/**
	 * @param busquedaArticuloLocalPedidoDAO the busquedaArticuloLocalPedidoDAO to set
	 */
	public void setBusquedaArticuloLocalPedidoDAO(IBusquedaArticuloLocalPedidoDAO busquedaArticuloLocalPedidoDAO) {
		this.busquedaArticuloLocalPedidoDAO = busquedaArticuloLocalPedidoDAO;
	}

	public void setArticuloNuevoImportadoDAO(IArticuloNuevoImportadoDAO articuloNuevoImportadoDAO) {
		this.articuloNuevoImportadoDAO = articuloNuevoImportadoDAO;
	}

	public void setArticuloBitacoraDAO(IArticuloBitacoraCodigoBarrasDAO articuloBitacoraDAO) {
		this.articuloBitacoraDAO = articuloBitacoraDAO;
	}
	
	public ArticuloDTO busquedaArticuloSimple(String codigoBarras, Integer codigoCompania) throws SICException {
		ArticuloDTO articuloPlantilla = new ArticuloDTO();
		articuloPlantilla.setCodigoBarras(codigoBarras);
		articuloPlantilla.getId().setCodigoCompania(codigoCompania);
		articuloPlantilla.setArticuloPrecioCol(new ArrayList<ArticuloPrecioDTO>());
		articuloPlantilla.getArticuloPrecioCol().add(new ArticuloPrecioDTO());
		return dataGestor.findUnique(articuloPlantilla);
	}
}
