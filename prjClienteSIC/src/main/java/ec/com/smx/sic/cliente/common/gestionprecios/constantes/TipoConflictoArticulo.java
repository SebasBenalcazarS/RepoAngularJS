/**
 * 
 */
package ec.com.smx.sic.cliente.common.gestionprecios.constantes;

/**
 * @author Luis Yacchirema
 *
 */
public enum TipoConflictoArticulo {

	GENERALES(1, "CON_GEN", "Generales", "advertenciaCamPre.png"),
	CAMBIO_PRECIO(2, "CON_CAMPRE", "Cambio de precios", "advertenciaCamPre.png"),
	ORDEN_COMPRA(3, "CON_ORDCOM", "Orden de compra", "advertenciaCamPre.png");

	private Integer orden;
	private String codigo;
	private String etiqueta;
	private String nombreImagen;

	private TipoConflictoArticulo(Integer orden, String codigo, String etiqueta, String nombreImagen) {
		this.codigo = codigo;
		this.etiqueta = etiqueta;
		this.orden = orden;
		this.nombreImagen = nombreImagen;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @return the etiqueta
	 */
	public String getEtiqueta() {
		return etiqueta;
	}

	/**
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * @return the nombreImagen
	 */
	public String getNombreImagen() {
		return nombreImagen;
	}

}
