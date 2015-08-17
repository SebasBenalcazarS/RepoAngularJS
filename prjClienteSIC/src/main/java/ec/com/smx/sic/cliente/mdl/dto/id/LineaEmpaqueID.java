package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase
 * LineaEmpaqueDTO
 * 
 * @see ec.com.smx.corpv2.dto.LineaEmpaqueDTO
 * 
 * @author srodriguez
 */
@SuppressWarnings("serial")
@Embeddable
public class LineaEmpaqueID implements Serializable {

	/**
	 * C�digo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Especifica el c�digo num�rico de una l�nea de empaque, este c�digo ser�
	 * auto-generado, mientras que el c�digo ha desplegarse para el negocio ser�
	 * c�digo de referencia
	 */
	@Column(name = "CODIGOLINEAEMPAQUE", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = NOMBRE_SECUENCIA, castTo = @Cast(sqlType = Types.NUMERIC, precision = 15, scale = 0))
	private Integer codigoLineaEmpaque;
	
	public static final String NOMBRE_SECUENCIA = "SBLOGSECLINEMP";

	
	
	/**
	 * @return the codigoLineaEmpaque
	 */
	public Integer getCodigoLineaEmpaque() {
		return codigoLineaEmpaque;
	}

	/**
	 * @param codigoLineaEmpaque
	 */
	public void setCodigoLineaEmpaque(Integer codigoLineaEmpaque) {
		this.codigoLineaEmpaque = codigoLineaEmpaque;
	}

	/**
	 * @return codigoCompania
	 */
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	/**
	 * @param codigoCompania
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;

	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return formatString();
	}
	
	
	private String formatString(){
		return String.valueOf(getCodigoCompania()) + "-" +String.valueOf(getCodigoLineaEmpaque());
	}
}

