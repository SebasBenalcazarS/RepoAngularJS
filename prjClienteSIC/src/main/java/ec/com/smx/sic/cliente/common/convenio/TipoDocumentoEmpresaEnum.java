package ec.com.smx.sic.cliente.common.convenio;

/**
 * @author srodriguez
 * 2015-01-10
 */
public enum TipoDocumentoEmpresaEnum {
	RUC,
	DOCUMENTO;
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		if(this.name().equals("DOCUMENTO")) {
			return "DOCUMENTO INTERNACIONAL";
		}
		return this.name();
	}
}
