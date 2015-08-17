package ec.com.smx.sic.cliente.gestor.articulo.admin.calculo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDuracionConservacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGarantiaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloInternetDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMaterialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMedidaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface ICalculoArticuloGestor {

	/**
	 * 
	 * @param articuloDTO
	 * @throws SICRuleException
	 */
	void asignarCamposArticulo(ArticuloVO articuloVO) throws SICRuleException;

	/**
	 * 
	 * @param articuloVO
	 * @param bitacoraActual
	 * @throws SICRuleException
	 */
	void asignarCamposCodigoBarras(ArticuloVO articuloVO, ArticuloBitacoraCodigoBarrasDTO bitacoraActual) throws SICRuleException;

	/**
	 * 
	 * @param articuloVO
	 * @param abcb
	 * @throws SICRuleException
	 */
	void asignarBitacoraCodigoBarras(ArticuloVO articuloVO, ArticuloBitacoraCodigoBarrasDTO abcb) throws SICRuleException;

	/**
	 * 
	 * @param articuloDTO
	 */
	String calcularCodigoBarrasInterno(ArticuloDTO articuloDTO) throws SICException;

	/**
	 * 
	 * @param artmat
	 * @throws SICRuleException
	 */
	void asignarCamposArticuloMaterial(ArticuloMaterialDTO artmat);

	/**
	 * 
	 * @param artgat
	 */
	void asignarCamposArticuloGarantia(ArticuloGarantiaDTO artgat);

	/**
	 * 
	 * @param dto
	 */
	void asignarCamposArticuloInternet(ArticuloInternetDTO dto);

	/**
	 * 
	 * @param aum
	 * @throws SICRuleException
	 */
	void asignarCamposArticuloComercial(ArticuloDTO ac);

	/**
	 * 
	 * @param articuloUsoDTO
	 * @throws SICException
	 */
	void asignarCamposArticuloUso(ArticuloUsoDTO articuloUsoDTO) throws SICException;

	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULOPROCESOLOGISTICO
	 * @param articuloVO
	 * @param esCreacion
	 */
	public void registrarArticuloProcesoLogistico(ArticuloVO articuloVO,Boolean esCreacion);
	
	/**
	 * 
	 * @param articuloEtiquetaDTO
	 * @throws SICRuleException
	 */
	void asignarCamposArticuloDespacho(ArticuloProcesoLogisticoDTO articuloProcesoLogisticoDTO);

	/**
	 * 
	 * @param articuloMedidaDTO
	 * @throws SICRuleException
	 */
	void asignarCamposArticuloMedida(ArticuloMedidaDTO articuloMedidaDTO);

	/**
	 * 
	 * @param articuloVO
	 * @param unidadesManejo
	 */
	void refrescarUnidadesManejo(ArticuloVO articuloVO, Collection<ArticuloUnidadManejoDTO> unidadesManejo);

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	String obtenerTipoCalculoPrecio(ArticuloDTO articuloDTO);

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	Boolean esPosibleIncluirArticuloEnReceta(ArticuloDTO articuloDTO);

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	void calcularPrecios(ArticuloDTO articuloDTO, Boolean calcularMargenPVP, Boolean calcularMargenPBase);

	/**
	 * 
	 * @param artPros
	 * @return
	 */
	Double calcularCostoNeto(Collection<ArticuloProveedorDTO> artPros) throws SICException;

	/**
	 * 
	 * @param ap
	 * @return
	 */
	Double calcularCostoNeto(ArticuloProveedorDTO ap) throws SICException;
	
	/**
	 * 
	 * @param ap
	 * @return
	 */
	Double calcularCostoNeto(ArticuloProveedorDTO ap, String codigoProyectado) throws SICException;
	
	/**
	 * 
	 * @param ap
	 * @return
	 */
	void calcularCostoNetoProyectado(ArticuloProveedorDTO ap) throws SICException;

	/**
	 * 
	 * @param ap
	 * @return
	 */
	Double calcularCostoNeto(ArticuloProveedorDTO ap, Boolean usarCostoMonedaOrigen, Boolean calcularConComisionImportacion) throws SICException;
	
	/**
	 * @param costoBruto
	 * @param descuentoProveedorArticuloCol
	 * @param unidadesManejo
	 * @return
	 * @throws SICException
	 */
	Double calcularCostoNeto(Double costoBruto, final Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol, final Collection<ArticuloUnidadManejoProveedorDTO> unidadesManejo) throws SICException;
	
	
	/**
	 * 
	 * @param costoNeto
	 * @param descuentoProveedorArticuloCol
	 * @param unidadesManejo
	 * @return
	 * @throws SICException
	 */
	Double calcularCadenaDescuentos( Double costoNeto , final Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol, final Collection<ArticuloUnidadManejoProveedorDTO> unidadesManejo) throws SICException;
	
	
	/**
	 * 
	 * Permite obtener el costo bruto a partir del costo neto, quitando al costo neto los descuentos
	 * por unidades de manejo y la cadena de descuentos. Es obligatorio que el parametro
	 * <code>articuloProveedorCostoNeto<code> tenga fijado el costo neto, y todas las relaciones de descuentos
	 * 
	 * @param articuloProveedorCostoNeto      Datos articulo proveedor y sus descuentos
	 * @return Double                         Costo bruto
	 */
	Double calcularCostoBrutoInversoCostoNeto(ArticuloProveedorDTO articuloProveedorCostoNeto) throws SICException;
	
	
	/**
	 * 
	 * @param ap
	 * @return
	 */
	Double calcularCostoNeto(ArticuloProveedorDTO ap, Boolean usarCostoMonedaOrigen) throws SICException;
	
	
	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	Double calcularCostoNetoNotaCredito(ArticuloProveedorDTO ap);
	
	/**
	 * 
	 * @param descuentoProveedorArticuloCol
	 * @param costoNeto
	 * @return
	 */
	Double calcularCostoNetoNotaCredito(Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol, Double costoNeto);

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	Double calcularPVP(ArticuloPrecioDTO pvp, Double costoNeto);

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	Double calcularPrecioBase(ArticuloPrecioDTO precioBase, Double costoNeto);
	
	/**
	 * @param precioBase
	 * @param articuloComercial
	 * @return
	 */
	Double calcularPrecioBaseNoAfiliado(Double precioBase, ArticuloComercialDTO articuloComercial);
	
	/**
	 * 
	 * @param precioBase
	 * @return
	 */
	Double calcularPrecioBaseSinDescuento(ArticuloPrecioDTO precioBase);

	/**
	 * 
	 * @param precioBase
	 * @return
	 */
	Double calcularPrecioBaseConDescuento(ArticuloPrecioDTO precioBase);

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	Double calcularMargenPrecio(ArticuloPrecioDTO precio, Double costoNeto);

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 */
	Double calcularDistanciamiento(ArticuloPrecioDTO precioBase, ArticuloPrecioDTO pvp);

	void asignarPrototipoAlcance(ArticuloDTO articuloDTO) throws SICRuleException;

	/**
	 * Retorna el precio de caja usando el precio unitario base y la unidad de manejo 
	 */
	Double calcularPrecioCaja(ArticuloUnidadManejoDTO aum, Double precioBase, Double precioBaseImp)throws SICException;

	/**
	 * Retorna la unidad de manejo prorrateada para la venta
	 * @param aum
	 * @param precioBase
	 * @return
	 */
	Integer calcularUnidadManejoVenta(ArticuloUnidadManejoDTO aum, Double precioBase);
	
	/**
	 * Retorna el precio de caja usando el precio unitario base y la unidad de manejo 
	 */
	Double calcularPrecioMayorista(ArticuloUnidadManejoDTO aum, Double precioBase)throws SICException;

	/**
	 * Obtiene el art&iacute;culo activo en base al c&oacute;digo de barras, si no encuentra uno activo devuelve nulo
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	ArticuloDTO obtenerArticuloCodigoBarrasActivo(Integer codigoCompania, String codigoBarras) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 */
	void asignarRelacionRegistroSanitario(ArticuloDTO articuloDTO);

	void asignarCamposArticuloDuracionConservacion(ArticuloDuracionConservacionDTO dto);

	/**
	 * @param tipoCodigo	- Indica si el codigo es interno o de origen del proveedor
	 * @param codigoBarras
	 */
	String calcularCodigoBarrasPOS(String tipoCodigo, String codigoBarras);
	/**
	 * Obtiene el c&oacute;digo de barras EAN13 desde un c&oacute;digo interno
	 * @param codigoBarras
	 */
	String calcularEAN13DesdeCodigoInterno(String codigoInterno);
	/**
	 * Obtiene el c&oacute;digo de barras EAN13 desde un c&oacute;digo interno
	 * @param codigoBarras
	 */
	String obtenerCodigoBarrasDesdeEAN(String codigoBarras);
	
	/**
	 * Construye el c&oacute;digo de barras como si viniera desde el archivo de ventas del POS
	 * @param tipoCodigo
	 * @param codigoBarras
	 * @return
	 */
	String calcularCodigoBarrasVentaPOS(String tipoCodigo, String codigoBarras);

	ArticuloDTO asignarRelacionesArticuloCodigoBarrasActivo(Integer codigoCompania, String codigoBarras) throws SICException;
	
	ClasificacionDTO asignarRelacionesEstructuraComercialCliente() throws SICException;
	
	ArticuloDTO respaldarDatosArticulo(ArticuloVO vo, Boolean registrarSubProceso);
	
	void restablecerArticuloVO(ArticuloVO vo, ArticuloDTO respaldo, Boolean registrarSubProceso, Boolean hayError);
	
	void registrarArticuloPendienteIntegracion(ArticuloVO vo)throws SICException;
	
	
	String obtenerOrigenArticulo(ArticuloDTO art);
	
	//void asignarPrototipoCoincidente(ArticuloDTO articuloDTO, String areasTrabajo) throws SICRuleException;
	
	String obtenerIdLogAuditoriaArticulo (Integer codigoCompania, String codigoArticulo) throws SICException;
	
	/**
	 * Construye un identificador para registro que mediante los cambios realizados envia una notificacion
	 * @param codigoCompania Codigo de la compania
	 * @param codigoArticulo Codigo del articulo
	 * @return identificador
	 * @throws SICException
	 */
	String obtenerIdLogAuditoriaNotificacionArticulo (Integer codigoCompania, String codigoArticulo) throws SICException;
	
	public ArticuloVO crearArticuloEAN(String codigoBarras , Integer codigoCompania);
	
	public void asignarValoresArticuloEAN(ArticuloVO articuloVO , Integer codigoCompania , String idUsuario);

	void registrarSecuenciaDisponible(Integer codigoCompania, String codigoArticulo, String userId) throws SICException;
}