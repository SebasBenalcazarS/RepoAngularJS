/**
 * 
 */
package ec.com.smx.sic.cliente.common.inventario;

/**
 * Constantes con las transacciones de inventario
 * @author osaransig
 * Dec 9, 2014
 */
public enum EnumTransaccionInventario { 

	RECEPCION_ORDEN_COMPRA(12),
	INICIALIZACION_INVENTARIO_FISICO(551),
	MOVIMIENTOS_ENVASES_EGRESOS(25),
	VENTAS(201),
	DEVOLUCION_VENTAS(211),
	DESCUENTOS_PROMOCION(2000),
	RECUPERACIONES_DESCUENTOS_PROMOCION(2001),
	RECUPERACIONES_DIARIAS_DESCUENTOS_PROMOCION(2002);

	private Integer codigoInterno;
	
	private EnumTransaccionInventario(Integer codigoInterno) {
		this.codigoInterno = codigoInterno;
	}
	
	/**
	 * Obtener codigo interno de la transaccion de inventario
	 * @return
	 */
	public Integer getCodigoInterno() {
		return this.codigoInterno;
	}
}
