package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase BitacoraRevisionRegistroSanitario
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Embeddable
public class BitacoraRevisionRegistroSanitarioID implements Serializable {

	/**
	 * Codigo de la companía
	 * 
	 */
	@Column(name="CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Secuencial del registro
	 * 
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSBITREVREGSAN")
	@Column(name="CODIGOBITREVREGSAN", nullable = false)
	private Integer codigoBitRevRegSan;

	/**
	 * Retorna valor de propiedad <code>codigoBitRevRegSan</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoBitRevRegSan</code>
	 */
	public Integer getCodigoBitRevRegSan() {
		return this.codigoBitRevRegSan;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoBitRevRegSan</code>.
	 * 
	 * @param codigoBitRevRegSan1
	 *            El valor a establecer para la propiedad <code>codigoBitRevRegSan</code>.
	 */
	public void setCodigoBitRevRegSan(Integer codigoBitRevRegSan1) {
		this.codigoBitRevRegSan = codigoBitRevRegSan1;

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

}
