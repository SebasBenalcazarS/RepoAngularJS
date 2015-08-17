/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class LogProcesosMigracionID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania;
	
	@Column(name = "CODIGOLOGPROMIG", nullable = false)
    @SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCADMSECLOGPROMIG")
    private Long codigoLogProcesosMigracion;
	
	public LogProcesosMigracionID() {
	}
	
	public LogProcesosMigracionID(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoLogProcesosMigracion() {
		return codigoLogProcesosMigracion;
	}

	public void setCodigoLogProcesosMigracion(Long codigoLogProcesosMigracion) {
		this.codigoLogProcesosMigracion = codigoLogProcesosMigracion;
	}
}
