package ec.com.smx.sic.cliente.persistencia.recibidonofacturado.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.Criterion;

import ec.com.smx.corpv2.dto.TipoDocumentoFinancieroDTO;
import ec.com.smx.corpv2.exception.CorporativoException;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaFacturaRelacionadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFlujoEstadoFacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecibidoNoFacturadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ComprobanteVO;

public interface IVistaRecibidoNoFacturadoDAO {
	public List<VistaRecibidoNoFacturadoDTO> obtenerFacturasInternasPendientes(Criterion filtrosBusqueda, VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoPlantilla, Boolean equalMode) throws SICException;
	public List<VistaFacturaRelacionadaDTO> obtenerFacturasRelacionadas(VistaRecibidoNoFacturadoDTO vistaRecibidoNoFacturadoDTO) throws SICException;	
	/**
	 * Permite obtener los valores de la factura rechazada
	 * @param codigoFactura
	 * @return
	 */
	public VistaRecibidoNoFacturadoDTO obtenerValoresFacturaRechazada(Long codigoFactura)throws SICException;
	
	/**
	 * Permite obtener el departamento de mayor valor de una factura
	 * @param recibidoNoFacturadoDTO
	 * @return
	 * @throws SICException
	 */
	public VistaRecibidoNoFacturadoDTO obtenerDepartamentoMayorValorFactura(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO)throws SICException;
	
	/**
	 * Permite obtener el departamento de ajuste con su valor
	 * @param codigoFacturaEstado
	 * @param contabilizado
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaRecibidoNoFacturadoDTO> obtenerAjustesDepartamento(Long codigoFacturaEstado, Boolean contabilizado)throws SICException;
	
	/**
	 * Permite obtener la informacion de las facturas del proveedor
	 * @param codigoFactura
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaRecibidoNoFacturadoDTO> obtenerInformacionFacturasProveedorF0411(Long codigoFacturaNotaIngreso)throws SICException;
	
	/**
	 * Obtiene el valor total de la factura del proveedor
	 * @param recibidoNoFacturadoDTO
	 * @param vistaFacturaRelacionadaCol
	 */
	public void calcularValorTotalFacturaProveedor(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, Collection<VistaFacturaRelacionadaDTO> vistaFacturaRelacionadaCol);
	
	/**
	 * Permite obtener los ajustes en mas y menos de la factura
	 * @param codigoFacturaEstado
	 */
	public VistaRecibidoNoFacturadoDTO obtenerTotalAjustes(Long codigoFacturaEstado)throws SICException;
	
	/**
	 * Permite obtener la primera factura del proveedor por medio del codigoFactura de la nota de ingreso
	 * @param codigoFacturaNotaIngreso
	 * @return
	 */
	public VistaRecibidoNoFacturadoDTO obtenerPrimerFacturaProveedor(Long codigoFacturaNotaIngreso)throws SICException;
	
	/**
	 * Permite obtener el numero de cuenta contable(contracuenta) de por transaccion y proceso
	 * @param codigoProceso
	 * @param tipoTransaccion
	 * @return
	 */
	public String obtenerCuentaContableNoCotejado(Long codigoProceso, Integer tipoTransaccion)throws SICException;
	
	/**
	 * Permite obtener el tipo de documento a travez del tipo de transaccion
	 * @param tipoTransaccion
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws CorporativoException
	 */
	public TipoDocumentoFinancieroDTO obtenerTipoDocumentoFinanciero(Integer tipoTransaccion, Integer codigoAreaTrabajo, Long codigoProceso)throws SICException;
	
	/**
	 * Permite obtener las suma de la tarifa cero y doce de las facturas del proveedor de la nota de ingreso
	 * @param codigoFacturaNotaIngreso
	 * @return
	 */
	public VistaRecibidoNoFacturadoDTO obtenerValoresTarifasProveedor(Long codigoFacturaNotaIngreso)throws SICException;
	
	/**
	 * Permite codigos notas de ingreso consolidadas
	 * @param codigoFactura
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaRecibidoNoFacturadoDTO> obtenerNotasIngresoConsolidados(Long codigoFactura)throws SICException;
	/**
	 * Este metodo obtiene todos los estados por los que paso la nota de ingreso, los estados estan ordenados cronologicamente
	 * @param vistaRecibidoNoFacturadoPlantilla
	 * @return
	 * @throws SICException
	 */
	public List<VistaFlujoEstadoFacturaDTO> obtenerFlujoEstadosFactura(Long codigoNotaIngreso)throws SICException;
	/**
	 * Este metodo devuelve una coleccion de las notas de ingreso hijas o relacionadas a la factura interna que recibe como parametro
	 * @param codigoFacturaNI
	 * @return
	 * @throws SICException
	 */
	public List<VistaRecibidoNoFacturadoDTO> obtenerNotasIngresoConsolidadas(Long codigoFacturaNI) throws SICException;
	
	/** Este metodo devuelve el codigo de la nota de ingreso que contiene a la nota de ingreso consolidada
	 * @param filtrosBusqueda
	 * @return
	 * @throws SICException
	 */
	public List<VistaRecibidoNoFacturadoDTO> obtenerNotaIngresoConsolidada(Criterion filtrosBusqueda) throws SICException;

	/**
	 * Metodo para obtener todas las notas de ingreso que posean facturas electronicas autorizadas
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaRecibidoNoFacturadoDTO> obtenerNotasIngresoConFacturasElectronicas() throws SICException;

	/**
	 * Metodo para obtener el comprobante incial guardado en la BDD
	 * @param codigoCompania
	 * @param codigoFactura
	 * @return
	 * @throws SICException
	 */
	ComprobanteVO obtenerComprobanteVOPorCodigoFactura(Integer codigoCompania, Long codigoFactura) throws SICException;
}
