package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;
/**
 * 
 * @author aquingaluisa
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloEtiquetaMercanciaID implements Serializable{
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;
	
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSARTETIMER")
	@Column(name = "CODIGOARTETIMERCANCIA", nullable = false)
	private Long codigoArticuloEtiquetaMercancia;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoArticuloEtiquetaMercancia() {
		return codigoArticuloEtiquetaMercancia;
	}

	public void setCodigoArticuloEtiquetaMercancia(Long codigoArticuloEtiquetaMercancia) {
		this.codigoArticuloEtiquetaMercancia = codigoArticuloEtiquetaMercancia;
	}
}
