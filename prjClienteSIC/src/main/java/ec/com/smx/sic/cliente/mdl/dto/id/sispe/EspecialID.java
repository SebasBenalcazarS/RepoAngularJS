package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@SuppressWarnings("serial")
@Embeddable
public class EspecialID extends BaseID {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;

	@Column(name = "CODIGOESPECIAL")
	@SequenceDataBaseValue(name="SCSPESECESP",descriptorClass=DescriptorSecuenciasSIC.class)
	private String codigoEspecial;

	
	
	public EspecialID() {
		super();
	}

	public EspecialID (Boolean initID) {
		if(initID){
			this.codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			this.codigoEspecial = SICConstantes.getInstancia().VALOR_INICIAL_ID;
		}
	}
	
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoEspecial() {
		return this.codigoEspecial;
	}

	public void setCodigoEspecial(String codigoEspecial) {
		this.codigoEspecial = codigoEspecial;
	}

	public int hashCode() {
		int result = 1;
		result = 31
				* result
				+ ((this.codigoCompania == null) ? 0 : this.codigoCompania
						.hashCode());
		result = 31
				* result
				+ ((this.codigoEspecial == null) ? 0 : this.codigoEspecial
						.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EspecialID other = (EspecialID) obj;
		if (this.codigoCompania == null) {
			if (other.codigoCompania == null)
				return false;
		}
		if (!(this.codigoCompania.equals(other.codigoCompania)))
			return false;
		if (this.codigoEspecial == null) {
			if (other.codigoEspecial == null)
				return false;
		}
		label95: return (this.codigoEspecial.equals(other.codigoEspecial));
	}
}