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
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class LineaComercialClasificacionID implements Serializable{
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;
	
	@Column(name = "CODIGOCLASIFICACION", nullable = false)
	private String codigoClasificacion;

	@Column(name = "CODLINCOMCLA", nullable = false)
    @SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCADMSECLINCOMCLA")
    private Long codigoLineaComercialClasificacion;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	
	/**
	 * @return the codigoClasificacion
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/**
	 * @param codigoClasificacion the codigoClasificacion to set
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	/**
	 * @return the codigoLineaComercialClasificacion
	 */
	public Long getCodigoLineaComercialClasificacion() {
		return codigoLineaComercialClasificacion;
	}

	/**
	 * @param codigoLineaComercialClasificacion the codigoLineaComercialClasificacion to set
	 */
	public void setCodigoLineaComercialClasificacion(Long codigoLineaComercialClasificacion) {
		this.codigoLineaComercialClasificacion = codigoLineaComercialClasificacion;
	}
}
