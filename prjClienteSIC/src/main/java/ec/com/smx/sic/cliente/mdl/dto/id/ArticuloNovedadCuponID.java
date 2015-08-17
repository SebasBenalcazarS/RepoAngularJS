package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@SuppressWarnings("serial")
@Embeddable
@MappedSuperclass
public class ArticuloNovedadCuponID implements Serializable {
	
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCARTSARTNOVCUP")
	@Column(name="SECUENCIAL", nullable=false)
	private String secuencial;
	
	@Column(name="CODIGOCOMPANIA", nullable=false)
	private Integer codigoCompania;
	
	@Column(name="CODIGOARTICULO", nullable=false)
	private String codigoArticulo;
	
	/**
	 * @return the secuencial
	 */
	public String getSecuencial() {
		return secuencial;
	}
	
	/**
	 * @param secuencial the secuencial to set
	 */
	public void setSecuencial(String secuencial) {
		this.secuencial = secuencial;
	}
	
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
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	
	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
}
