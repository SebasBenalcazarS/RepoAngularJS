package ec.com.smx.sic.cliente.common.convenio.enums;

/**
 * Identifica el tipo de forma de cobro para la negociacion
 * @author aquingaluisa
 */
public enum CorteConveniosEnum {
	
	SEMANAL("SEM"), QUINCENAL("QUI"), MENSUAL("MEN");
	
	private String convenioFormaCobroOrdinal;
	
	private CorteConveniosEnum(String ordinal) {
		convenioFormaCobroOrdinal = ordinal;
	}

	public String getConvenioFormaCobroOrdinal() {
		return convenioFormaCobroOrdinal;
	}

	public void setConvenioFormaCobroOrdinal(String convenioFormaCobroOrdinal) {
		this.convenioFormaCobroOrdinal = convenioFormaCobroOrdinal;
	}
}