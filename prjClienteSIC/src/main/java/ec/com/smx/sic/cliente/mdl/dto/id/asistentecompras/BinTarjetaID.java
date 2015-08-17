package ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras;

import java.io.Serializable;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@SuppressWarnings("serial")
public class BinTarjetaID implements Serializable {
	
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCSACSECBINTARJETA")
	@Column(name = "CODIGOBINTARJETA")
	private Long codigoBinTarjeta;

	public Long getCodigoBinTarjeta() {
		return codigoBinTarjeta;
	}

	public void setCodigoBinTarjeta(Long codigoBinTarjeta) {
		this.codigoBinTarjeta = codigoBinTarjeta;
	}

}
