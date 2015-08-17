/**
 * 
 */
package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.servicio.procesamientoventas.IProcesamientoVentasArticulosServicio;
import ec.com.smx.sic.cliente.servicio.procesamientoventas.IProcesamientoVentasDescuentosServicio;
import ec.com.smx.sic.cliente.servicio.procesamientoventas.IProcesamientoVentasRecuperacionesServicio;
import ec.com.smx.sic.cliente.servicio.procesamientoventas.IProcesamientoVentasServicio;

/**
 * 
 * @author Luis Yacchirema
 *  
 * @author vjaramillo
 *
 */
public class ProcesamientoVentasFactory extends SICSpringContextFactory {

	public IProcesamientoVentasServicio getIProcesamientoVentasServicio() throws SICException {
		return (IProcesamientoVentasServicio) getBean(SICFactoryConstantes.PROCESAMIENTOVENTAS_VENTAS_SERVICIO);
	}
	
	public IProcesamientoVentasDescuentosServicio getIProcesamientoVentasDescuentosServicio() throws SICException {
		return (IProcesamientoVentasDescuentosServicio) getBean(SICFactoryConstantes.PROCESAMIENTOVENTAS_DESCUENTOS_SERVICIO);
	}
	
	public IProcesamientoVentasRecuperacionesServicio getIProcesamientoVentasRecuperacionesServicio() throws SICException {
		return (IProcesamientoVentasRecuperacionesServicio) getBean(SICFactoryConstantes.PROCESAMIENTOVENTAS_RECUPERACIONES_SERVICIO);
	}	

	public IProcesamientoVentasArticulosServicio getIProcesamientoVentasArticulosServicio() throws SICException{
		return (IProcesamientoVentasArticulosServicio) getBean(SICFactoryConstantes.PROCESAMIENTOVENTAS_ARTICULOS_SERVICIO);
	}
	
}
