package ec.com.smx.sic.cliente.common.convenio.enums;

public enum TipoCampaniaEnum {

	NORMAL(0),
	CUPON(1),
	MIXTA(2);
	
	private int tipoPromocion;
	
	private TipoCampaniaEnum(int tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}

	public int getTipoPromocion() {
		return tipoPromocion;
	}
	
}
