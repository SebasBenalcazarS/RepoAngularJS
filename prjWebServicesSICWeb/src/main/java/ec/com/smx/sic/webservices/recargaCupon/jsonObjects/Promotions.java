package ec.com.smx.sic.webservices.recargaCupon.jsonObjects;

import java.util.Collection;

/**
 * @author ediaz
 *
 */
public class Promotions {
	private Collection<Promotion> promotions;
	private String tipo;

	public Promotions() {

	}

	public Collection<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(Collection<Promotion> promotions) {
		this.promotions = promotions;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
