package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.MigracionArticuloGeneralID;

/**
 * Contiene información del proceso de migracion del artículo
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSPETMIGARTGEN")
public class MigracionArticuloGeneralDTO extends SimpleAuditDTO{

	@EmbeddedId
	private MigracionArticuloGeneralID id;
	
	/**
	 * Código del artículo
	 */
	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo;
	
	@ComparatorTypeField
	private String estadoProcesado;
	
	@Column
	private java.sql.Timestamp fechaProcesado;
	
	@Formula("VARCHAR(DECIMAL(CODIGOARTICULO))")
	private String codigoArticuloZeroLess;

	/**
	 * @return the id
	 */
	public MigracionArticuloGeneralID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(MigracionArticuloGeneralID id) {
		this.id = id;
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

	/**
	 * @return the estadoProcesado
	 */
	public String getEstadoProcesado() {
		return estadoProcesado;
	}

	/**
	 * @param estadoProcesado the estadoProcesado to set
	 */
	public void setEstadoProcesado(String estadoProcesado) {
		this.estadoProcesado = estadoProcesado;
	}

	/**
	 * @return the fechaProcesado
	 */
	public java.sql.Timestamp getFechaProcesado() {
		return fechaProcesado;
	}

	/**
	 * @param fechaProcesado the fechaProcesado to set
	 */
	public void setFechaProcesado(java.sql.Timestamp fechaProcesado) {
		this.fechaProcesado = fechaProcesado;
	}

	/**
	 * @return the codigoArticuloZeroLess
	 */
	public String getCodigoArticuloZeroLess() {
		return codigoArticuloZeroLess;
	}

	/**
	 * @param codigoArticuloZeroLess the codigoArticuloZeroLess to set
	 */
	public void setCodigoArticuloZeroLess(String codigoArticuloZeroLess) {
		this.codigoArticuloZeroLess = codigoArticuloZeroLess;
	}
}
