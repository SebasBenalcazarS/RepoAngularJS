package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;


public class ClienteCuponCompartidoVO {

	private String numeroDocumento;
	private String redSocial;
	private Collection<String> cupones;
	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	/**
	 * @return the redSocial
	 */
	public String getRedSocial() {
		return redSocial;
	}
	/**
	 * @param redSocial the redSocial to set
	 */
	public void setRedSocial(String redSocial) {
		this.redSocial = redSocial;
	}
	/**
	 * @return the cupones
	 */
	public Collection<String> getCupones() {
		return cupones;
	}
	/**
	 * @param cupones the cupones to set
	 */
	public void setCupones(Collection<String> cupones) {
		this.cupones = cupones;
	}
}
