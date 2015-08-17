package ec.com.smx.sic.cliente.common.convenio.enums;

/**
 * Identifica el tipo de forma de cobro para la negociacion
 * @author lchasipanta
 */
public enum ConvenioFormaCobroEnum {
	
	FACTURA(0), ORDEN_COMPRA(1), COSTO(2);
	
	private int convenioFormaCobroOrdinal;
	
	/**
	 * @author lchasipanta
	 * @param ordinal
	 */
	private ConvenioFormaCobroEnum(int ordinal) {
		convenioFormaCobroOrdinal = ordinal;
	}

	/**
	 * @author lchasipanta
	 * @return int
	 */
	public int getConvenioFormaCobroOrdinal() {
		return convenioFormaCobroOrdinal;
	}

	/**
	 * @author lchasipanta
	 * @param convenioFormaCobroOrdinal
	 */
	public void setConvenioFormaCobroOrdinal(int convenioFormaCobroOrdinal) {
		this.convenioFormaCobroOrdinal = convenioFormaCobroOrdinal;
	}
}