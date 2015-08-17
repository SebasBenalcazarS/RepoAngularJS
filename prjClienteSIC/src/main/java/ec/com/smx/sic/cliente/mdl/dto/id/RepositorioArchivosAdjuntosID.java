package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@SuppressWarnings("serial")
@Embeddable
public class RepositorioArchivosAdjuntosID implements Serializable{
	
	@Column(name = "CODIGOFACARCHIVO", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class, name = "SCFDISECFACARC", castTo = @Cast(sqlType = Types.NUMERIC, precision = 15, scale = 0))
	private Long codigoFacturaArchivo;

	public Long getCodigoFacturaArchivo() {
		return codigoFacturaArchivo;
	}

	public void setCodigoFacturaArchivo(Long codigoFacturaArchivo) {
		this.codigoFacturaArchivo = codigoFacturaArchivo;
	}

}
