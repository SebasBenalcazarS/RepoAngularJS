package ec.com.smx.sic.cliente.gestor.ordenCompra.calculo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraVO;

public interface ICalculoAlmacenamientoOrdenCompraGestor extends Serializable{

	/**
	 * 
	 * @param ordenCompraDetalleEstadoDTO
	 * @param ordenCompraEstadoDTO
	 * @param cantidadAnterior
	 * @param pesoAnterior
	 * @param validarCantidades
	 * @param costoBrutoAnterior
	 * @param costoNetoAnterior
	 * @param valorUnidadManejoAnterior
	 * @throws SICException
	 */
	public void calculoValorTotalDetalle(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO, OrdenCompraEstadoDTO ordenCompraEstadoDTO,
			Integer cantidadAnterior, BigDecimal pesoAnterior, boolean validarCantidades, BigDecimal costoBrutoAnterior, BigDecimal costoNetoAnterior, BigDecimal valorUnidadManejoAnterior) throws SICException;

	/**
	 * Metodo que calcula por referencia
	 * los valores totales sin impuestos
	 * actuales y anteriores
	 * (VALOR TOTAL - COSTO BRUTO)
	 * del detalle de la orden de compra
	 * 
	 * @param validarCantidades
	 * @param ordenCompraDetalleEstadoDTO
	 * @param cantidadAnterior
	 * @param pesoAnterior
	 * @param valorUnidadManejoAcutal
	 * @param valorUnidadManejoAnterior
	 * @param costoBrutoAnterior
	 * @param costoNetoAnterior
	 * @return
	 * @throws SICException
	 */
	public BigDecimal[] calculoValorTotalDetalleSinImpuestos(boolean validarCantidades, OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO,
			BigDecimal cantidadAnterior, BigDecimal pesoAnterior, BigDecimal valorUnidadManejoAcutal, BigDecimal valorUnidadManejoAnterior, 
			BigDecimal costoBrutoAnterior, BigDecimal costoNetoAnterior) throws SICException;	
	
	/**
	 * 
	 * @param ordenCompraDetalleEstadoDTO
	 * @return
	 * @throws SICException
	 */
	public void calculoPesoPedidoPorCantidadPedida(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO) throws SICException;
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param ordenComptraDetalleEstadoList
	 * @param valorIngresado Corresponde a la clave identificadora en el mapa de propiedades dinamicas
	 * @throws SICException
	 */
	public void copiarValorSugeridoOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, List<OrdenCompraDetalleEstadoDTO> ordenComptraDetalleEstadoList, String valorIngresado) throws SICException;
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @param ordenComptraDetalleEstadoList
	 * @param valorIngresado Corresponde a la clave identificadora en el mapa de propiedades dinamicas
	 * @throws SICException
	 */
	public void limpiarValorSugeridoOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO, List<OrdenCompraDetalleEstadoDTO> ordenComptraDetalleEstadoList, String valorIngresado) throws SICException;
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void copiarValoresNuevaConsultaOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void inicializacionValoresTotalesOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;
	
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void calcularTotalesNoAlmacenadosOrdenCompra(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;
	/**
	 * 
	 * @param adminOrdenCompraVO
	 * @throws SICException
	 */
	public void cambioMonedaOrigenPedido(AdminOrdenCompraVO adminOrdenCompraVO) throws SICException;
	
	/**
	 * Metodo que calcula el valor total bruto
	 * de los detalle de la orden de compra
	 * @param ordenCompraDetalleEstadoDTOs
	 * @throws SICException
	 */
	public void calculoValorTotalBrutoDetalle(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs)throws SICException;
	
	/**
	 * Metodo que calcula el valor total bruto
	 * de los detalle de la orden de compra
	 * @param ordenCompraDetalleEstadoDTOs
	 * @throws SICException
	 */
	public void calculoValorTotalBrutoDetalle(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO)throws SICException;

	/**
	 * Metodo que calcula el peso recibido
	 * por cantidad recibida
	 * 
	 * @param ordenCompraDetalleEstadoDTOs
	 * @return Peso pedido
	 * @throws SICException
	 */
	public BigDecimal calculoPesoPedidoPorCantidadRecibida(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO, String valorTipoControlCosto, Double pesoAproximadoRecepcioc) throws SICException;
	
	/**
	 * @param ordenCompraDetalleEstadoDTO
	 * @param costoBrutoActualizado
	 */
	public void recalcularValoresOrdenCompraDetalleEstado(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO, BigDecimal costoBrutoActualizado);

}