package ec.com.smx.sic.cliente.servicio.articulo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoRelacionArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface IArticuloCalculoServicio {

	public Double calcularCostoNeto(ArticuloProveedorDTO articuloProveedorDTO) throws SICException;
	
	public Double calcularCostoNeto(ArticuloProveedorDTO articuloProveedorDTO, String codigoProyectado) throws SICException;

	public Double calcularCostoNeto(Double costoBruto, final Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol, final Collection<ArticuloUnidadManejoProveedorDTO> unidadesManejo) throws SICException;
	
	public Double calcularCostoNeto(ArticuloProveedorDTO articuloProveedorDTO, Boolean usarCostoMonedaOrigen, Boolean calcularConComisionImportacion) throws SICException;
	
	public Double calcularCostoNeto(ArticuloProveedorDTO articuloProveedorDTO, Boolean usarCostoMonedaOrigen) throws SICException;

	public void calcularCostoNetoProyectado(ArticuloProveedorDTO articuloProveedorDTO) throws SICException;
	
	Double calcularCadenaDescuentos( Double costoNeto , final Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol, final Collection<ArticuloUnidadManejoProveedorDTO> unidadesManejo) throws SICException;
	
	public Double calcularCostoNetoNotaCredito(ArticuloProveedorDTO articuloProveedorDTO) throws SICException;
	
	public Double calcularCostoNetoNotaCredito(Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol, Double costoNeto) throws SICException;
	
	public Double calcularDistanciamiento(ArticuloPrecioDTO precioBase,ArticuloPrecioDTO pvp) throws SICException;

	public Double calcularMargenPrecio(ArticuloPrecioDTO precio, Double costoNeto) throws SICException;
	
	public Double calcularPVP(ArticuloPrecioDTO pvp, Double costoNeto) throws SICException;

	public Double calcularPrecioBase(ArticuloPrecioDTO precioBase, Double costoNeto) throws SICException;
	
	Double calcularPrecioBaseNoAfiliado(Double precioBase, ArticuloComercialDTO articuloComercial) throws SICException;
	
	public Double calcularPrecioCaja(ArticuloUnidadManejoDTO aum, Double precioBase, Double precioBaseImp)throws SICException;

	public Integer calcularUnidadManejoVenta(ArticuloUnidadManejoDTO aum, Double precioBase);
	
	public Double calcularPrecioMayorista(ArticuloUnidadManejoDTO aum, Double precioBase)throws SICException;
	
	public Double calcularPrecioBaseConDescuento(ArticuloPrecioDTO precioBase)throws SICException;

	public void calcularPrecios(ArticuloDTO articuloDTO, Boolean calcularMargenPVP, Boolean calcularMargenPBase) throws SICException ;

	public Double calcularPrecioBaseSinDescuento(ArticuloPrecioDTO precioBase);
	
	public Boolean esPosibleIncluirArticuloEnReceta(ArticuloDTO articuloDTO) throws SICException ;

	public String obtenerTipoCalculoPrecio(ArticuloDTO articuloDTO)	throws SICException;
	
	ArticuloDTO findByIdArticulo( ArticuloID id, EnumTipoRelacionArticulo... tiposRelacion  ) throws SICException;
	
	ArticuloDTO findByIdArticulo( String codigoArticulo, Integer codigoCompania, EnumTipoRelacionArticulo... tiposRelacion  ) throws SICException ;
	
	ArticuloVO findByIdArticuloVO( final ArticuloVO articuloVO, EnumTipoRelacionArticulo... tiposRelacion  ) throws SICException;
	
	ArticuloDTO completarDatosArticulo(final ArticuloDTO articuloDTO, EnumTipoRelacionArticulo... tiposRelacion) throws SICException;
	
	ArticuloVO completarDatosCreacionArticuloVO(final ArticuloVO articuloVO, EnumTipoRelacionArticulo... tiposRelacion) throws SICException;
	
	Collection<ArticuloDTO> buscarArticulosPorCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException;
	
	public Collection<ArticuloUnidadManejoDTO> buscarArticuloUnidadManejoPorCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException;
	
	public Collection<ArticuloDTO> buscarArticulosPorCodigoBarrasUso(Integer codigoCompania, String codigoBarras, 
			CatalogoValorDTO usoCV, String codigoProveedor) throws SICException;

	/**
	 * Obtiene el c&oacute;digo de barras EAN13 desde un c&oacute;digo interno
	 * @param codigoBarras
	 */
	public String calcularEAN13DesdeCodigoInterno(String codigoInterno);
	/**
	 * Obtiene el c&oacute;digo de barras EAN13 desde un c&oacute;digo interno
	 * @param codigoBarras
	 */
	@Deprecated
	public String obtenerCodigoBarrasDesdeEAN(String codigoBarras);
	/**
	 * Obtiene el codigo de barras interno o de proveedor a partir de un codigo de barras ingresado
	 * @param codigoBarras
	 * @return
	 */
	public String transformarCodigoBarras(String codigoBarras);
	/**
	 * Obtiene informacion de despacho de un articulo determinado
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public ArticuloProcesoLogisticoDTO obtenerInformacionDespachoArticulo(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	/**
	 * permite obtener las unidades de manejo de cada proveedor
	 * @param articuloVO
	 * @throws SICException
	 */
	public void completarDatosUnidadManejoProveedor(ArticuloVO articuloVO) throws SICException;
}
