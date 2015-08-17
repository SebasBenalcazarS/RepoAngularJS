package ec.com.smx.sic.cliente.gestor.articulo.admin.calculo;

import java.util.Collection;
import java.util.Set;

import org.hibernate.criterion.Criterion;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.common.seguridades.autorizacion.IAuthorizationComponent;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoRelacionArticulo;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaBusquedaEdicionMasivaArticulos;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaFiltrosBusquedaArticulos;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorNovedadDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloAsignacionLocalVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloImportadoVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.BusquedaSimpleArticuloVO;

public interface ICalculoBusquedaArticuloGestor {

	public abstract ArticuloDTO completarDatosArticulo(final ArticuloDTO articuloDTO, EnumTipoRelacionArticulo... tiposRelacion) throws SICException;
	
	ArticuloDTO findByIdArticulo( ArticuloID id, EnumTipoRelacionArticulo... tiposRelacion  ) throws SICException;
	
	ArticuloDTO findByIdArticulo( String codigoArticulo, Integer codigoCompania, EnumTipoRelacionArticulo... tiposRelacion  ) throws SICException ;
	
	ArticuloVO findByIdArticuloVO( final ArticuloVO articuloVO, EnumTipoRelacionArticulo... tiposRelacion  ) throws SICException;
	
	Collection<ArticuloDTO> buscarArticulosPorCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException;
	
	public Collection<ArticuloUnidadManejoDTO> buscarArticuloUnidadManejoPorCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException;
	
	public Collection<ArticuloDTO> buscarArticulosPorCodigoBarrasUso(Integer codigoCompania, String codigoBarras, 
			CatalogoValorDTO usoCV, String codigoProveedor) throws SICException;

	public abstract ArticuloVO completarDatosCreacionArticuloVO(final ArticuloVO articuloVO, EnumTipoRelacionArticulo... tiposRelacion) throws SICException;

	public abstract IProveedor obtenerVistaProveedor(Integer codigoCompania, String codigoJDE);

	public abstract SearchResultDTO<ArticuloDTO> buscarArticulos(ArticuloVO articuloVO, IAuthorizationComponent authorizationComponent) throws SICException;

	public abstract Collection<ArticuloDTO> asignarEstructuraArbol(Collection<ArticuloDTO> articuloCol) throws SICException;

	public abstract Collection<ArticuloDTO> buscarTodoArticulos(ArticuloVO articuloVO, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX, IAuthorizationComponent authorizationComponent) throws SICException;
	
	public abstract Collection<ArticuloDTO> buscarTodoArticulosCupon(ArticuloVO articuloVO, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX) throws SICException;
	
	public abstract void asignarRelacionesArticuloCosto(ArticuloDTO articuloDTO) throws SICException;

	public abstract void asignarRelacionesArticuloCosto(ArticuloProveedorDTO ap) throws SICException;
	
	public abstract void asignarRelacionesPrecio(final ArticuloDTO articuloDTO) throws SICException;

	public abstract void asignarRelacionesArticuloImpuesto(final ArticuloDTO articuloDTO) throws SICException;

	public abstract void asignarRelacionesArticuloPrecio(ArticuloDTO articuloDTO) throws SICException;

	public abstract void asignarRelacionesArticuloAlcance(ArticuloDTO articuloDTO) throws SICException;

	public abstract void asignarRelacionesArticuloPrecio(ArticuloPrecioDTO ap) throws SICException;

	public abstract Double calculoDescuentoParcial(Double costoBrutoParcial, Double porcentajeDescuento) throws SICException;

	public abstract void asignarRelacionesArticuloLocalPrecio(ArticuloLocalPrecioDTO alp) throws SICException;

	public abstract ArticuloDTO asignarRestricionesDevolucionArticulo(ArticuloDTO articuloDTO) throws SICException;

	public abstract void incluirRestriccionesBusquedaArticulo(ArticuloVO articuloFiltro, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusqueda) throws SICException;
	
	public abstract ArticuloDTO incluirRestricionesEspecialesArticulo(ArticuloDTO articuloDTO) throws SICException;
	
	public void cargarCadenaDescuentos(ArticuloProveedorDTO articuloProveedorDTO) throws SICException;
	
	public SearchResultDTO<ArticuloDTO> buscarArticulosSimple(ArticuloVO articuloVO,Set<EnumTipoRelacionArticulo> relacionArticulos,Integer maximoArticulos) throws SICException;
	
	public void cargarRelacion(ArticuloDTO articuloDTO,  EnumTipoRelacionArticulo... tiposRelacion) throws SICException;
	
	public void incluirDescuentos(Collection<ArticuloDTO> articuloDTOCol, Integer codigoCompania) throws SICException;
	
	public Collection<ArticuloProveedorDTO> buscarArticuloProveedor(Integer codigoCompania, final String codigoBarras, final String codigoReferenciaExterna, final String codigoProveedor) throws SICException;
	
	public ArticuloProveedorNovedadDTO buscarArticuloProveedorNovedadImportacion(ArticuloImportadoVO articuloImportadoVO) throws SICException;
	
	public Integer buscarCantidadArticulosEdicionInterna(String sqlQuery)throws SICException;
	
	public Long buscarCantidadArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException;
	
	public Collection<ArticuloEdicionMasivaVO> buscarArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException;
	
	public Collection<ArticuloAsignacionLocalVO> obtenerArticuloLocal(ArticuloID articuloId , Integer tipoAreaTrabajoTic , String tipoAreaTrabajoValor, Boolean consultarCamposAsignacion)throws SICException;

	public SearchResultDTO<ArticuloDTO> buscarArticuloBasico(Criterion criterioBusqueda , Integer firstResult ,Integer maxResults , Boolean findNum , BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException;
	
	public void completarDatosUnidadManejoProveedor(final ArticuloProveedorDTO articuloProveedorDTO) throws SICException;
	
	public ArticuloDTO busquedaArticuloSimple(String codigoBarras , Integer codigoCompania)throws SICException;

}