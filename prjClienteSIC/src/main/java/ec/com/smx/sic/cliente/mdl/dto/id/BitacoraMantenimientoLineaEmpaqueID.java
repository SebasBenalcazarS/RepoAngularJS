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
public class BitacoraMantenimientoLineaEmpaqueID implements Serializable {

	/**
	 * Código de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Especifica el código numérico del mantenimiento de una linea de empaque
	 * */
	@Column(name = "CODIGOMANTENIMIENTO", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECMANLINEMP", castTo = @Cast(sqlType = Types.NUMERIC, precision = 15, scale = 0))
	private Integer codigoMantenimiento;

	/**
	 * @return the codigoMantenimiento
	 */
	public Integer getCodigoMantenimiento() {
		return codigoMantenimiento;
	}

	/**
	 * @param codigoMantenimiento
	 */
	public void setCodigoMantenimiento(Integer codigoMantenimiento) {
		this.codigoMantenimiento = codigoMantenimiento;
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
}
