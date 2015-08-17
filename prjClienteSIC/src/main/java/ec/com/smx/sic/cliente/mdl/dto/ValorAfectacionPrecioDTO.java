/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.mdl.dto.id.ValorAfectacionPrecionID;

/**
 * @author cjara
 *
 */
@Entity
@Table(name="SCPRETVALAFEPRE")
@SuppressWarnings("serial")
public class ValorAfectacionPrecioDTO extends AuditoriaBaseDTO{
	
	@EmbeddedId
	private ValorAfectacionPrecionID id = new ValorAfectacionPrecionID();
	
	@Column(name = "CODIGOGRUPOAFECTACION", nullable = false)
	private Long codigoGrupoAfectacion;
	
	@Column(name = "CODIGOTIPOAFECTACION", nullable = false)
	private Integer codigoTipoAfectacion;

	@Column(name = "CODIGOTIPOVARIACION", nullable = false)
	private Integer codigoTipoVariacion;
	
	@ComparatorTypeField
	@Column(name = "VALORTIPOVARIACION", nullable = false)	
	private String valorTipoVariacion;
	
	@Column(name = "VALORVARIACION", nullable = false)
	private Double valorVariacion;
	
	@ComparatorTypeField
	@Column(name = "VALORUNIDADVARIACION")	
	private String valorUnidadVariacion;
	
	@ComparatorTypeField
	@Column(name = "VALOROPERADORVARIACION")	
	private String valorOperadorVariacion;
	
	@ComparatorTypeField
	@Column(name = "ESTADO")	
	private String estado;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOTIPOAFECTACION", referencedColumnName="CODIGOTIPOAFECTACION", insertable=false, updatable=false), 
		@JoinColumn(name="VALORTIPOVARIACION", referencedColumnName="VALORTIPOVARIACION", insertable=false, updatable=false), 
		@JoinColumn(name="CODIGOTIPOVARIACION", referencedColumnName="CODIGOTIPOVARIACION", insertable = false, updatable = false)})
	private ConfiguracionAfectacionPrecioDTO configuracionAfectacionPrecio;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable=false, updatable= false),
		@JoinColumn(name = "CODIGOGRUPOAFECTACION", referencedColumnName = "CODIGOGRUPOAFECTACION", insertable=false, updatable= false) 
	})
	private GrupoAfectacionPrecioDTO grupoAfectacionPrecio;

	/**
	 * @return the codigoGrupoAfectacion
	 */
	public Long getCodigoGrupoAfectacion() {
		return codigoGrupoAfectacion;
	}

	/**
	 * @return the codigoTipoAfectacion
	 */
	public Integer getCodigoTipoAfectacion() {
		return codigoTipoAfectacion;
	}

	/**
	 * @return the codigoTipoVariacion
	 */
	public Integer getCodigoTipoVariacion() {
		return codigoTipoVariacion;
	}

	/**
	 * @return the configuracionAfectacionPrecio
	 */
	public ConfiguracionAfectacionPrecioDTO getConfiguracionAfectacionPrecio() {
		return configuracionAfectacionPrecio;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @return the grupoAfectacionPrecio
	 */
	public GrupoAfectacionPrecioDTO getGrupoAfectacionPrecio() {
		return grupoAfectacionPrecio;
	}

	/**
	 * @return the id
	 */
	public ValorAfectacionPrecionID getId() {
		return id;
	}

	/**
	 * @return the valorOperadorVariacion
	 */
	public String getValorOperadorVariacion() {
		return valorOperadorVariacion;
	}

	/**
	 * @return the valorTipoVariacion
	 */
	public String getValorTipoVariacion() {
		return valorTipoVariacion;
	}

	/**
	 * @return the valorUnidadVariacion
	 */
	public String getValorUnidadVariacion() {
		return valorUnidadVariacion;
	}

	/**
	 * @return the valorVariacion
	 */
	public Double getValorVariacion() {
		return valorVariacion;
	}

	/**
	 * @param codigoGrupoAfectacion the codigoGrupoAfectacion to set
	 */
	public void setCodigoGrupoAfectacion(Long codigoGrupoAfectacion) {
		this.codigoGrupoAfectacion = codigoGrupoAfectacion;
	}

	/**
	 * @param codigoTipoAfectacion the codigoTipoAfectacion to set
	 */
	public void setCodigoTipoAfectacion(Integer codigoTipoAfectacion) {
		this.codigoTipoAfectacion = codigoTipoAfectacion;
	}

	/**
	 * @param codigoTipoVariacion the codigoTipoVariacion to set
	 */
	public void setCodigoTipoVariacion(Integer codigoTipoVariacion) {
		this.codigoTipoVariacion = codigoTipoVariacion;
	}

	/**
	 * @param configuracionAfectacionPrecio the configuracionAfectacionPrecio to set
	 */
	public void setConfiguracionAfectacionPrecio(ConfiguracionAfectacionPrecioDTO configuracionAfectacionPrecio) {
		this.configuracionAfectacionPrecio = configuracionAfectacionPrecio;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @param grupoAfectacionPrecio the grupoAfectacionPrecio to set
	 */
	public void setGrupoAfectacionPrecio(GrupoAfectacionPrecioDTO grupoAfectacionPrecio) {
		this.grupoAfectacionPrecio = grupoAfectacionPrecio;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ValorAfectacionPrecionID id) {
		this.id = id;
	}

	/**
	 * @param valorOperadorVariacion the valorOperadorVariacion to set
	 */
	public void setValorOperadorVariacion(String valorOperadorVariacion) {
		this.valorOperadorVariacion = valorOperadorVariacion;
	}

	/**
	 * @param valorTipoVariacion the valorTipoVariacion to set
	 */
	public void setValorTipoVariacion(String valorTipoVariacion) {
		this.valorTipoVariacion = valorTipoVariacion;
	}

	/**
	 * @param valorUnidadVariacion the valorUnidadVariacion to set
	 */
	public void setValorUnidadVariacion(String valorUnidadVariacion) {
		this.valorUnidadVariacion = valorUnidadVariacion;
	}

	/**
	 * @param valorVariacion the valorVariacion to set
	 */
	public void setValorVariacion(Double valorVariacion) {
		this.valorVariacion = valorVariacion;
	}
}
