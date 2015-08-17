/**
 * 
 */
package ec.com.smx.sic.cliente.common.inventario;

import ec.com.smx.sic.cliente.resources.inventario.SICInventarioMessages;

/**
 * Constantes para el manejor del contexto de las transacciones
 * @author osaransig
 * Sep 16, 2014
 */
public enum EnumContextoTransaccion {

	/**
	 * Transaccion de recepcion: REC
	 */
	TRANSACCION_CONTEXTO_RECEPCION(SICInventarioMessages.getInstancia().getString("ec.com.smx.sic.inventario.contexto.transaccion.recepcion")),
	
	/**
	 * Transaccion de despacho: DES 
	 */
	TRANSACCION_CONTEXTO_DESPACHO(SICInventarioMessages.getInstancia().getString("ec.com.smx.sic.inventario.contexto.transaccion.despacho")),
	
	/**
	 * Transaccion de despacho: TRA 
	 */
	TRANSACCION_CONTEXTO_TRANSFERENCIAS(SICInventarioMessages.getInstancia().getString("ec.com.smx.sic.inventario.contexto.transaccion.transferencias")),
	
	/**
	 * Transaccion contexto tipo: 1303 
	 */
	TRANSACCION_CONTEXTO_TIPO(SICInventarioMessages.getInstancia().getString("ec.com.smx.sic.inventario.contexto.transaccion.tipo"));
	
	
	private String valor;
	
	private EnumContextoTransaccion(final String valor) {
		this.valor = valor;
	}
	
	/**
	 * Obtener valor del contexto de la transaccion
	 * @return
	 */
	public String getValor() {
		return valor;
	}
}
