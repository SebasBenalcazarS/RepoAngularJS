package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author Marcelo Hidalgo
 * 
 */
@SuppressWarnings("serial")
@Embeddable
public class DescuentoArticuloOrdenCompraGestionID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGODESCUENTOORDENCOMPRAGESTION", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = NOMBRE_SECUENCIA, castTo=@Cast(sqlType=Types.BIGINT))
	private Long codigoDescuentoOrdenCompraGestion;
	
	public static final String NOMBRE_SECUENCIA = "SCPRESECDESARTORDCOMGES";
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoDescuentoOrdenCompraGestion() {
		return codigoDescuentoOrdenCompraGestion;
	}

	public void setCodigoDescuentoOrdenCompraGestion(Long codigoDescuentoOrdenCompraGestion) {
		this.codigoDescuentoOrdenCompraGestion = codigoDescuentoOrdenCompraGestion;
	}

}
