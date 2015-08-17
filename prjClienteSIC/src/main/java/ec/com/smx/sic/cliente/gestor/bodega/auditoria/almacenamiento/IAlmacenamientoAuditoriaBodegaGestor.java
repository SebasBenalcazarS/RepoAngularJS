package ec.com.smx.sic.cliente.gestor.bodega.auditoria.almacenamiento;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecepcionCancelarPalletAuditEST;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecepcionEscaneoManualAuditEST;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecepcionIngresoCajaAuditEST;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecepcionModificarPalletAuditEST;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecepcionOrdenCompraDetalleEstadoAuditEST;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecepcionProveedorArticuloJustificacionAuditEST;

/**
 * @author cpescobar
 *
 */
public interface IAlmacenamientoAuditoriaBodegaGestor {
	
	public void registrarLogAuditoriaCambioPrecioRecepcion(RecepcionOrdenCompraDetalleEstadoAuditEST auditESTactual, RecepcionOrdenCompraDetalleEstadoAuditEST auditESTanterior, Long codigoAutorizacion) throws SICException ;

	public void registrarLogAuditoriaActivarEscaneoManual(RecepcionEscaneoManualAuditEST auditESTactual, RecepcionEscaneoManualAuditEST auditESTanterior, Long codigoAutorizacion) throws SICException;
	
	/**
	 * @author Yuniesky Armentero Moreno
	 * @param auditESTactual
	 * @param auditESTanterior
	 * @param codigoAutorizacion
	 */
	public void registrarLogAuditoriaActivarIngresoCaja(RecepcionIngresoCajaAuditEST auditESTactual, RecepcionIngresoCajaAuditEST auditESTanterior, Long codigoAutorizacion) throws SICException;
	
	/**
	 * @author Yuniesky Armentero Moreno
	 * @param auditESTactual
	 * @param auditESTanterior
	 * @param codigoAutorizacion
	 */
	public void registrarLogAuditoriaModificarPallet(RecepcionModificarPalletAuditEST auditESTactual, RecepcionModificarPalletAuditEST auditESTanterior, Long codigoAutorizacion) throws SICException;
	
	/**
	 * @author Yuniesky Armentero Moreno
	 * @param auditESTactual
	 * @param auditESTanterior
	 * @param codigoAutorizacion
	 */
	public void registrarLogAuditoriaCancelarPallet(RecepcionCancelarPalletAuditEST auditESTactual, RecepcionCancelarPalletAuditEST auditESTanterior, Long codigoAutorizacion) throws SICException;
	
	public void registrarLogAuditoriaConfigurarValidacionesEtiquetado(RecepcionProveedorArticuloJustificacionAuditEST auditESTactual, RecepcionProveedorArticuloJustificacionAuditEST auditESTanterior, Long codigoAutorizacion) throws SICException;
}
