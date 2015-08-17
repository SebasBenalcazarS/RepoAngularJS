package ec.com.smx.sic.articulo.servicio;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import ec.com.kruger.utilitario.dao.commons.annotations.NoTransaction;
import ec.com.kruger.utilitario.dao.commons.annotations.ReadOnlyTransaction;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoRelacionArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoBusquedaArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.articuloBitacora.IArticuloBitacoraGestor;
import ec.com.smx.sic.cliente.gestor.articulo.procesoLogistico.ICalculoArticuloProcesoLogisticoGestor;
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
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloCalculoServicio;

public class ArticuloCalculoServicio implements IArticuloCalculoServicio {
	
	private ICalculoArticuloGestor calculoArticuloGestor;
	private ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor;
	private IArticuloBitacoraGestor articuloBitacoraGestor;
	private ICalculoArticuloProcesoLogisticoGestor calculoArticuloProcesoLogisticoGestor;
	
	public void setCalculoArticuloGestor(ICalculoArticuloGestor calculoArticuloGestor) {
		this.calculoArticuloGestor = calculoArticuloGestor;
	}

	public void setCalculoBusquedaArticuloGestor(ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor) {
		this.calculoBusquedaArticuloGestor = calculoBusquedaArticuloGestor;
	}
	

	/**
	 * @param calculoArticuloProcesoLogisticoGestor the calculoArticuloProcesoLogisticoGestor to set
	 */
	public void setCalculoArticuloProcesoLogisticoGestor(ICalculoArticuloProcesoLogisticoGestor calculoArticuloProcesoLogisticoGestor) {
		this.calculoArticuloProcesoLogisticoGestor = calculoArticuloProcesoLogisticoGestor;
	}

	/**
	 * @param articuloBitacoraGestor the articuloBitacoraGestor to set
	 */
	public void setArticuloBitacoraGestor(IArticuloBitacoraGestor articuloBitacoraGestor) {
		this.articuloBitacoraGestor = articuloBitacoraGestor;
	}

	@NoTransaction
	public Double calcularCostoNeto(ArticuloProveedorDTO articuloProveedorDTO) throws SICException {
		return calculoArticuloGestor.calcularCostoNeto(articuloProveedorDTO);
	}
	
	@NoTransaction
	public Double calcularCostoNeto(ArticuloProveedorDTO articuloProveedorDTO,String codigoProyectado) throws SICException {
		return calculoArticuloGestor.calcularCostoNeto(articuloProveedorDTO,codigoProyectado);
	}
	
	@NoTransaction
	public Double calcularCostoNeto(Double costoBruto, final Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol, final Collection<ArticuloUnidadManejoProveedorDTO> unidadesManejo) throws SICException {
		return calculoArticuloGestor.calcularCostoNeto(costoBruto, descuentoProveedorArticuloCol, unidadesManejo);
	}

	@NoTransaction
	public Double calcularCostoNeto(ArticuloProveedorDTO articuloProveedorDTO, Boolean usarCostoMonedaOrigen, Boolean calcularConComisionImportacion) throws SICException {
		return calculoArticuloGestor.calcularCostoNeto(articuloProveedorDTO,usarCostoMonedaOrigen,calcularConComisionImportacion);
	}
	
	public Double calcularCostoNeto(ArticuloProveedorDTO articuloProveedorDTO, Boolean usarCostoMonedaOrigen) throws SICException {
		return calculoArticuloGestor.calcularCostoNeto(articuloProveedorDTO, usarCostoMonedaOrigen);
	}
	
	@NoTransaction
	public void calcularCostoNetoProyectado(ArticuloProveedorDTO articuloProveedorDTO) throws SICException {
			calculoArticuloGestor.calcularCostoNetoProyectado(articuloProveedorDTO);
	}
	
	@NoTransaction
	public Double calcularCostoNetoNotaCredito(ArticuloProveedorDTO articuloProveedorDTO) throws SICException {
		return calculoArticuloGestor.calcularCostoNetoNotaCredito(articuloProveedorDTO);
	}

	@NoTransaction
	public Double calcularCostoNetoNotaCredito(Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol, Double costoNeto) throws SICException {
		return calculoArticuloGestor.calcularCostoNetoNotaCredito(descuentoProveedorArticuloCol, costoNeto);
	}

	@NoTransaction
	public Double calcularDistanciamiento(ArticuloPrecioDTO precioBase,ArticuloPrecioDTO pvp) throws SICException {
		return calculoArticuloGestor.calcularDistanciamiento(precioBase, pvp);
	}

	@NoTransaction
	public Double calcularMargenPrecio(ArticuloPrecioDTO precio, Double costoNeto) throws SICException {
		return calculoArticuloGestor.calcularMargenPrecio(precio, costoNeto);
	}

	@NoTransaction
	public Double calcularPVP(ArticuloPrecioDTO pvp, Double costoNeto)
			throws SICException {
		return calculoArticuloGestor.calcularPVP(pvp, costoNeto);
	}

	@NoTransaction
	public Double calcularPrecioBase(ArticuloPrecioDTO precioBase, Double costoNeto)
			throws SICException {
		return calculoArticuloGestor.calcularPrecioBase(precioBase, costoNeto);
	}
	
	@NoTransaction
	public Double calcularPrecioBaseNoAfiliado(Double precioBase, ArticuloComercialDTO articuloComercial) throws SICException {
		return calculoArticuloGestor.calcularPrecioBaseNoAfiliado(precioBase, articuloComercial);
	}
	
	@NoTransaction
	public Double calcularPrecioCaja(ArticuloUnidadManejoDTO aum, Double precioBase, Double precioBaseImp)throws SICException {
		return calculoArticuloGestor.calcularPrecioCaja(aum, precioBase, precioBaseImp);
	}
	
	/**
	 * Retorna la unidad de manejo prorrateada para la venta
	 * @param aum
	 * @param precioBase
	 * @return
	 */
	@NoTransaction
	public Integer calcularUnidadManejoVenta(ArticuloUnidadManejoDTO aum, Double precioBase){
		return calculoArticuloGestor.calcularUnidadManejoVenta(aum, precioBase);
	}
	
	/**
	 * Retorna el precio de caja usando el precio unitario base y la unidad de manejo 
	 */
	@NoTransaction
	public Double calcularPrecioMayorista(ArticuloUnidadManejoDTO aum, Double precioBase)throws SICException {
		return calculoArticuloGestor.calcularPrecioMayorista(aum, precioBase);
	}
	
	@NoTransaction
	public void calcularPrecios(ArticuloDTO articuloDTO, Boolean calcularMargenPVP, Boolean calcularMargenPBase)
			throws SICException {
		calculoArticuloGestor.calcularPrecios(articuloDTO, calcularMargenPVP, calcularMargenPBase);		
	}
	
	@NoTransaction
	public Double calcularPrecioBaseSinDescuento(ArticuloPrecioDTO precioBase){
		return calculoArticuloGestor.calcularPrecioBaseSinDescuento(precioBase);
	}
	@NoTransaction
	public Boolean esPosibleIncluirArticuloEnReceta(ArticuloDTO articuloDTO)
			throws SICException {
		return calculoArticuloGestor.esPosibleIncluirArticuloEnReceta(articuloDTO);
	}

	@NoTransaction
	public String obtenerTipoCalculoPrecio(ArticuloDTO articuloDTO)
			throws SICException {
		return calculoArticuloGestor.obtenerTipoCalculoPrecio(articuloDTO);
	}

	@Override
	public ArticuloDTO completarDatosArticulo(ArticuloDTO articuloDTO, EnumTipoRelacionArticulo... tiposRelacion) 
			throws SICException {
		return this.calculoBusquedaArticuloGestor.completarDatosArticulo(articuloDTO, tiposRelacion);
	}

	@Override
	public ArticuloVO completarDatosCreacionArticuloVO(ArticuloVO articuloVO, EnumTipoRelacionArticulo... tiposRelacion) throws SICException {
		return this.calculoBusquedaArticuloGestor.completarDatosCreacionArticuloVO(articuloVO, tiposRelacion);
	}
	
	@NoTransaction
	@Override
	public Double calcularPrecioBaseConDescuento(ArticuloPrecioDTO precioBase) throws SICException {
		return this.calculoArticuloGestor.calcularPrecioBaseConDescuento(precioBase);
	}
	
	/**
	 * Obtiene el c&oacute;digo de barras EAN13 desde un c&oacute;digo interno
	 * @param codigoBarras
	 */
	@Override
	@ReadOnlyTransaction
	public String calcularEAN13DesdeCodigoInterno(String codigoInterno){
		return this.calculoArticuloGestor.calcularEAN13DesdeCodigoInterno(codigoInterno);
	}
	
	/**
	 * Obtiene el c&oacute;digo de barras EAN13 desde un c&oacute;digo interno
	 * @param codigoBarras
	 */
	@Override
	@Deprecated
	public String obtenerCodigoBarrasDesdeEAN(String codigoBarras){
		return this.calculoArticuloGestor.calcularEAN13DesdeCodigoInterno(codigoBarras);
	}

	@Override
	@NoTransaction
	public Double calcularCadenaDescuentos(Double costoNeto, Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol, Collection<ArticuloUnidadManejoProveedorDTO> unidadesManejo) throws SICException {
		return this.calculoArticuloGestor.calcularCadenaDescuentos(costoNeto, descuentoProveedorArticuloCol, unidadesManejo);
	}

	@Override
	public ArticuloDTO findByIdArticulo(ArticuloID id, EnumTipoRelacionArticulo... tiposRelacion) throws SICException {
		return this.calculoBusquedaArticuloGestor.findByIdArticulo(id, tiposRelacion);
	}

	@Override
	public ArticuloDTO findByIdArticulo(String codigoArticulo, Integer codigoCompania, EnumTipoRelacionArticulo... tiposRelacion) throws SICException {
		return this.calculoBusquedaArticuloGestor.findByIdArticulo(codigoArticulo, codigoCompania, tiposRelacion);
	}

	@Override
	public ArticuloVO findByIdArticuloVO(ArticuloVO articuloVO, EnumTipoRelacionArticulo... tiposRelacion) throws SICException {
		return this.calculoBusquedaArticuloGestor.findByIdArticuloVO(articuloVO, tiposRelacion);
	}

	@Override
	public Collection<ArticuloDTO> buscarArticulosPorCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException {
		return this.calculoBusquedaArticuloGestor.buscarArticulosPorCodigoBarras(codigoCompania, codigoBarras);
	}
	
	@Override
	public Collection<ArticuloUnidadManejoDTO> buscarArticuloUnidadManejoPorCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException {
		return this.calculoBusquedaArticuloGestor.buscarArticuloUnidadManejoPorCodigoBarras(codigoCompania, codigoBarras);
	}
	
	@Override
	public Collection<ArticuloDTO> buscarArticulosPorCodigoBarrasUso(Integer codigoCompania, String codigoBarras, CatalogoValorDTO usoCV, 
			String codigoProveedor) throws SICException {
		return this.calculoBusquedaArticuloGestor.buscarArticulosPorCodigoBarrasUso(codigoCompania, codigoBarras, usoCV, codigoProveedor);
	}
	
	@Override
	@NoTransaction
	public String transformarCodigoBarras(String codigoBarras){
		return this.articuloBitacoraGestor.transformarCodigoBarras(codigoBarras);
	}
	
	@Override
	public ArticuloProcesoLogisticoDTO obtenerInformacionDespachoArticulo(Integer codigoCompania, String codigoArticulo) throws SICException{
		return calculoArticuloProcesoLogisticoGestor.obtenerInformacionDespachoArticulo(codigoCompania, codigoArticulo);
	}
	
	public void completarDatosUnidadManejoProveedor(ArticuloVO articuloVO) throws SICException{
		if(CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getArticuloProveedorCol())){
			for(ArticuloProveedorDTO articuloProveedorDTO : articuloVO.getBaseDTO().getArticuloProveedorCol()){
				this.calculoBusquedaArticuloGestor.completarDatosUnidadManejoProveedor(articuloProveedorDTO);
			}
		}
	}
}
