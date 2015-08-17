package ec.com.smx.sic.cliente.servicio.recibidonocontabilizado;

import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;

public interface IRecibidoNoContabilizadoTareasProgramadasServicio {
	/**
	 * Este metodo realiza el proceso de comparacion entre las notas de ingreso (recepciones) existentes en SIC vs las notas de ingreso existentes en MAX
	 * Para esto:
	 *  1.- Obtenemos por medio de integracion las notas de ingreso existentes en SIC
	 *  2.- Consultamos las notas de ingreso existentes en MAX si en el campo totalOrdenesCompra de la tabla FacturaEstado esta en 0 es que la Nota de ingreso esta completa
	 *  si el campo totalOrdenesCompra  es diferente de cero es que faltan procesar ese numero de ordenes de compra
	 *  3.- Si no esta en la base de datos voy a buscar en el directorio de no procesados,
	 * @param fechaNotasIngreso
	 */
	public void transConciliacionNotasIngreso(Date fechaNotasIngreso) throws SICException;
}
