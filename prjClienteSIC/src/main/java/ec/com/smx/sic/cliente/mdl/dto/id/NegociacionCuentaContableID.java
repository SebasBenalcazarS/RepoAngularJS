package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@SuppressWarnings("serial")
@Embeddable
public class NegociacionCuentaContableID implements Serializable{
	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania;
	@Column(name="CODIGONEGOCIACIONCUENTACONTABLE")
	private Long codigoNegociacionCuentaContable;
	public static final String NOMBRE_SECUENCIA = "SCCEMSECNEGCUECON";
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoNegociacionCuentaContable() {
		return codigoNegociacionCuentaContable;
	}
	public void setCodigoNegociacionCuentaContable(Long codigoNegociacionCuentaContable) {
		this.codigoNegociacionCuentaContable = codigoNegociacionCuentaContable;
	}
}
