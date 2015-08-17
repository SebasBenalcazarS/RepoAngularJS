/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo;

/**
 * @author fmunoz
 *
 */
public enum EnumMensajePasosCreacionArticulo {
	CODIGOBARRASPENDIENTE("Debe asignar un c\u00F3digo de barras al art\u00EDculo"),
	EAN14DUPLICADO("Existen c\u00F3digos EAN en las unidades de manejo que est\u00E1n asignados a otros art\u00EDculos"),
	MARCACOMERCIAL("El proveedor fue cambiado, por favor verifique que la marca comercial corresponda al nuevo proveedor"),
	PRECIO("El proveedor fue cambiado, por favor verifique que los precios correspondan al nuevo proveedor"),
	ARTICULOSRELACIONADOS_CUPON("El proveedor fue cambiado, es posible que algunos art\u00EDculos relacionados al cup\u00F3n hayan sido borrados por favor verifique"),
	CONTROLPRECIO("El tipo de c\u00F3digo fue modificado, por favor verifique el control de precio"),
	CAMBIO_REG_SAN("La clasificaci\u00F3n fue cambiada, por favor verifique que los datos del registro sanitario correspondan a la nueva clasificaci\u00F3n"),
	MARGENINCORRECTO("El valor del margen debe ser m\u00EDnimo "+SICArticuloConstantes.getInstancia().VALOR_MINIMO_MARGEN.toString()+" % para la divisi\u00F3n actual"),
	CAMBIO_ETIQUETAS_CLASIFICACION("La clasificaci\u00F3n fue cambiada, por favor verifique que los datos de Etiquetas correspondan a la nueva clasificaci\u00F3n"),
	CAMBIO_ETIQUETAS_MARCA("La Marca de Art\u00EDculo fue cambiada, por favor verifique los datos de Etiquetas"),
	CAMBIO_ETIQUETAS_MARCA_CLASIF("La Marca de Art\u00EDculo o La clasificaci\u00F3n fue cambiada, por favor verifique los datos de Etiquetas"),
	ALCANCES_CAMBIO_CLASIFICACION("La clasificaci\u00F3n fue cambiada, por favor verifique los datos de Prototipo de alcance");
	private String mensaje;
	
	private EnumMensajePasosCreacionArticulo(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	
}
