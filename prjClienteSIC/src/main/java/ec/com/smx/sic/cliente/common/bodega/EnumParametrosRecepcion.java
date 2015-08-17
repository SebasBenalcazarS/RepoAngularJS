
package ec.com.smx.sic.cliente.common.bodega;
import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores de los parametros para la creacion de la recepcion
 * 
 * @author lguaman
 *
 */
public enum EnumParametrosRecepcion {

	//VALORES DE LOS PARAMETROS DE LA RECEPCION
	MAX_BODEGA_RECEPCION_SELECCIONORENCOMPRA(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.parametro.seleccion.orden.compra")),
	MAX_BODEGA_RECEPCION_CREACIONIGUAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.parametro.crear.recepcion.igual")),
	MAX_BODEGA_RECEPCION_SELECCION_METODO_RECEPCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.parametro.seleccion.metodo.recepcion")),
	MAX_BODEGA_RECEPCION_ORDEN_HORARIO_RECEPCION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.parametro.orden.horario.recepcion")),
	MAX_BODEGA_RECEPCION_SELECCION_METODO_ASIGNACION_TAREAS(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.parametro.seleccion.metodo.asignacion.tareas")),
	MAX_BODEGA_RECEPCION_PERMITIR_CREAR_TAREA_ESTADO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.parametro.permitir.crear.factura.estado"))
	;
	
	private String codigoParametro;
	
	private EnumParametrosRecepcion(String codigoParametro){
		this.codigoParametro = codigoParametro;
	}

	/**
	 * @return the codigoParametro
	 */
	public String getCodigoParametro() {
		return codigoParametro;
	}

	/**
	 * @param codigoParametro the codigoParametro to set
	 */
	public void setCodigoParametro(String codigoParametro) {
		this.codigoParametro = codigoParametro;
	}
	
	/**
	 * Busca un enumerador en base al codigo de un parametro
	 * @param codigoParametro Codigo del parametro a buscar en las enumeradores
	 * @return Un EnumParametrosRecepcion
	 */
	public static EnumParametrosRecepcion getEnumParametrosRecepcion(String codigoParametro) {
		for (EnumParametrosRecepcion enumParametrosRecepcion : EnumParametrosRecepcion.values()) {
			if (enumParametrosRecepcion.getCodigoParametro().equals(codigoParametro))  {
				return enumParametrosRecepcion;
			}
		}
		return null;
	}
}
