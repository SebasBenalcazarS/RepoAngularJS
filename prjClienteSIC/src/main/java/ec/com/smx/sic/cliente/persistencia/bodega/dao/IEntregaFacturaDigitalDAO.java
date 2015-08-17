package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import ec.com.smx.framework.common.util.dto.RangeValue;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.DiferenciaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaDiferenciaFacturasRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaEntregaFacturaDigitalDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecepcionCantidadesRecibidasDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ProcesoLogisticoEntregaB2BEST;

public interface IEntregaFacturaDigitalDAO {

	/**
	 * 
	 * @param fecha
	 * @param hora
	 * @param codigoNombreProveedor
	 * @param codigoCD
	 * @param codigosBodega
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaEntregaFacturaDigitalDTO> obtenerEntregasProveedor(EntregaDTO entregaDTO, Collection<String> estadosEntrega) throws SICException;
	
	/**
	 * Obtiene las entregas dentro de un rango de fechaEntrega y su estado.
	 * @param rangoFechas, Collection<String> estadosEntrega
	 * @return
	 * @throws SICException Excepcion
	 * */
	public Collection<EntregaDTO> obtenerEntregasProveedorPlanificadas(RangeValue<Date> rangoFechas, Collection<String> estadosEntrega, Boolean condicionIntegrado) throws SICException;
	
	/**
	 * Obtiene especificamente datos de una entrega que son necesarios para generar el archivo de planificacion de entregas.
	 * @param codigoEntrega
	 * @return
	 * @throws SICException Excepcion
	 */
	public Collection<Object[]> obtenerDatosParaGenerarArchivoEntregaPlanificada(Long codigoEntrega) throws SICException;
	
	/**
	 * 
	 * @param codigosOrdenCompraDetalleEstado
	 * @return
	 */
	public Collection<DiferenciaProcesoLogisticoDTO> buscarArticulosFacturadosConDiferenciasProcesoLogistico(Collection<String> codigosOrdenCompraDetalleEstado, RangeValue<Date> rangoFechas);
	
	/**
	 * 
	 * @param ordenCompraDetalleEstadoDTO
	 * @return
	 */
	public Collection<Object []> consultarOrdenCompraDetalleEstado(Collection<Long> codigosOrdenCompraDetalleEstadoDTOS, Long codigoCompania)throws SICException;
	
	public Collection<OrdenCompraEstadoDTO> buscarOrdenesCompraEstado(Collection<Long> ordenCompraEstadoDTOs, Long codigoCompania, String valorEstadoOCE)throws SICException;
	
	/**
	 * 
	 * @param ordenCompraDetalleEstadoDTO
	 * @throws SICException
	 */
	public void actualizarParcialesOrdenCompraDetalleEstado(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO)throws SICException;
	
	/**
	 * @param colCodigosEntregas
	 * @return
	 * @throws SICException
	 */
	public Collection<RecepcionProveedorDTO> obtenerRecepcionPorCodigoEntregas(Collection<Long> colCodigosEntregas)throws SICException;
	
	/**
	 * 
	 * @param codigoBarrasArticulo
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> buscarArticuloRecepcion(Collection<String> codigoBarrasArticuloCOL)throws SICException;
	
	/**
	 * @see ec.com.smx.sic.cliente.persistencia.bodega.dao.IDiferenciasFacturasDAO#obtenerDiferenciasRecepcion(java.util.Collection)
	 */	
	public Collection<VistaDiferenciaFacturasRecepcionDTO> obtenerDiferenciasRecepcion(Long codigoRecepcion, Integer codigoCompania) throws SICException;
	
	/**
	 * Metodo que consulta los codigos de area de trabajo en base sus codigos de bodega
	 * @param codigosBodega
	 * @return
	 * @throws SICException
	 */
	public Collection<Object []> obtenerAreasTrabajoPorCodigosBodega(Collection<String> codigosBodega)throws SICException;
	
	/**
	 * 
	 * @param numeroFacturas
	 * @param codigosEntregaCOL
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaRecepcionCantidadesRecibidasDTO> obtenerArticulosFacturados(Collection<String> numeroFacturas, Collection<Long> codigosEntregaCOL)
			throws SICException;
	/**
	 * 
	 * @param codigoOrdComDetEstCOL
	 * @return
	 * @throws SICException
	 */
	public Collection<Object[]> buscarArticuloCodigoBarras(Collection<Long> codigoOrdComDetEstCOL)throws SICException;
	/**
	 * 
	 * @param ordenCompraPlantilla
	 * @param colCodigosOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDTO> obtenerOrdenComprasParaRecepcionBodega(
			OrdenCompraDTO ordenCompraPlantilla, Collection<String> colCodigosOrdenCompra) throws SICException;
	
	
	/**
	 * Metodo que obtiene articulos en base a su codigo de barras
	 * @param codigoBarrasArticuloCOL
	 * @return
	 * @throws SICException
	 */
	public Collection<ProcesoLogisticoEntregaB2BEST> buscarArticuloRecepcionPorCodigoBarras(Collection<String> codigoBarrasArticuloCOL)throws SICException;
	
	/**
	 * Obtiene las horas de la configuracion de las entregas 
	 * @param vistaEntregaFacturaDigitalDTO entrega a consultar
	 * @return
	 * @throws SICException
	 * @author derazo
	 */
	Collection<Time> obtenerHorasFechaEntrega(VistaEntregaFacturaDigitalDTO vistaEntregaFacturaDigitalDTO)  throws SICException;
	
	
}