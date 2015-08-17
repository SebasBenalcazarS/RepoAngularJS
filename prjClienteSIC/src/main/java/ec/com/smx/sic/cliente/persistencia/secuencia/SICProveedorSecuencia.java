/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.secuencia;

import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;

/**
 * @author Mario Braganza
 *
 */
public final class SICProveedorSecuencia {
	public static final String NOMBRE_SECUENCIA_CODIGO_PROVEEDOR = SICProveedorMessages.getInstancia().getString("ec.com.smx.sic.secuencial.codigoProveedor");
	private static final SICProveedorSecuencia INSTANCIA = new SICProveedorSecuencia();
	
	private SICProveedorSecuencia(){
		//
	}
	
	public static SICProveedorSecuencia getInstancia(){
		return INSTANCIA;
	}

}
