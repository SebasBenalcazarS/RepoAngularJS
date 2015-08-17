package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author fcollaguazo
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class LineaComercialFuncionarioClasificacionID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;

	@Column(name = "CODLINCOMFUNCLA", nullable = false)
    @SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCADMSECLINCOMFUNCLA")
    private Long codigoLineaComercialFuncionarioClasificacion;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoLineaComercialFuncionarioClasificacion() {
		return codigoLineaComercialFuncionarioClasificacion;
	}

	public void setCodigoLineaComercialFuncionarioClasificacion(Long codigoLineaComercialFuncionarioClasificacion) {
		this.codigoLineaComercialFuncionarioClasificacion = codigoLineaComercialFuncionarioClasificacion;
	}
}
