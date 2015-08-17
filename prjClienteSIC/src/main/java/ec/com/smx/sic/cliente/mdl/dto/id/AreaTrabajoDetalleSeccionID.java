package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author cortiz
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class AreaTrabajoDetalleSeccionID implements Serializable{

	/**
	 * Codigo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	
	/**
	 * Especifica el codigo 
	 *
	 */
	@Column(name = "CODIGOAREATRABAJODETALLESECCION", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECARETRADETSEC")
	private java.lang.Long codigoAreaTrabajoDetalleSeccion ;


	public Integer getCodigoCompania() {
		return codigoCompania;
	}


	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}


	public java.lang.Long getCodigoAreaTrabajoDetalleSeccion() {
		return codigoAreaTrabajoDetalleSeccion;
	}


	public void setCodigoAreaTrabajoDetalleSeccion(java.lang.Long codigoAreaTrabajoDetalleSeccion) {
		this.codigoAreaTrabajoDetalleSeccion = codigoAreaTrabajoDetalleSeccion;
	}
	
	
}
