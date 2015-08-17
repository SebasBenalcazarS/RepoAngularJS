package ec.com.smx.sic.cliente.common.tablaslickgridutil.constantes;

/**
 * Diferentes tipos de formatos de visualizacion o edicion que tendran las columnas
 * 
 * @author ivasquez
 *
 */
public enum TipoFormatosTablaSlickGridUtil {

	FORMATO_NORMAL("formatoColumnaNormal"),
	FORMATO_RANGO_NORMAL("formatoColumnaRangoNormal"),
	FORMATO_RANGO_EDICION("formatoColumnaRangoEdicion"),
	FORMATO_ESPECIAL("formatoColumnaEspecial"),
	EDITOR_RANGO("editorColumnaRango"),
	EDITOR_ESPECIAL("editorColumnaEspecial");

	private final String value;

	
	/*
	 * GETTERS AND SETTERS 
	 */
	
	private TipoFormatosTablaSlickGridUtil(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
