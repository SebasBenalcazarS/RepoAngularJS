package ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@SuppressWarnings("serial")
@Embeddable
public class VistaColaboracionID extends BaseID {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;

	@Column(name = "CODIGOLISTACLIENTEPEDIDO")
	private String codigoListaClientePedido;

	/**
	 * 
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * 
	 * @param codigoCompania
	 *            the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoListaClientePedido() {
		return codigoListaClientePedido;
	}

	public void setCodigoListaClientePedido(String codigoListaClientePedido) {
		this.codigoListaClientePedido = codigoListaClientePedido;
	}

}
