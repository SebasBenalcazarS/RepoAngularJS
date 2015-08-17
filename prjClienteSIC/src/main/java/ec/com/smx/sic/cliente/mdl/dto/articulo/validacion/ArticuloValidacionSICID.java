package ec.com.smx.sic.cliente.mdl.dto.articulo.validacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@SuppressWarnings("serial")
@Embeddable
public class ArticuloValidacionSICID implements Serializable{
	
	@Column(insertable = true, nullable = false)
	private Integer codigoCompania;
	
	@Column(insertable = false, nullable = false)
	@GeneratedValue(generator = "secvaldatart", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "secvaldatart", sequenceName = "SCARTSECVALDATART", initialValue = 1, allocationSize = 1)
	private String secuencial;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getSecuencial() {
		return secuencial;
	}

	public void setSecuencial(String secuencial) {
		this.secuencial = secuencial;
	}
}
