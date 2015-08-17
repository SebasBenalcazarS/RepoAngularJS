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
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.AsignacionTipoDescuentoID;

/**
 * @author Luis Yacchirema
 *
 */
@Entity
@Table(name="SCADMTASITIPDES")
@SuppressWarnings("serial")
public class AsignacionTipoDescuentoDTO extends AuditoriaBaseDTO {
	
	@EmbeddedId
	private AsignacionTipoDescuentoID id = new AsignacionTipoDescuentoID();

	@Column(name = "CODIGOASIGNACIONTIPODESCUENTO", nullable = false)
	private Integer codigoAsignacionTipoDescuento;

	@ComparatorTypeField
	@Column(name = "VALORASIGNACIONTIPODESCUENTO", nullable = false)
	private String valorAsignacionTipoDescuento;

	@Column(name = "PRIORIDAD", nullable = false)
	private Integer prioridad;

	@ComparatorTypeField
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@Column(name = "CODIGOTIPODESCUENTO", nullable = false)
	private String codigoTipoDescuento;

	@Column(name = "CODIGOAPLICACIONTIPODESCUENTO", nullable = false)
	private Integer codigoAplicacionTipoDescuento;

	@ComparatorTypeField
	@Column(name = "VALORAPLICACIONTIPODESCUENTO", nullable = false)
	private String valorAplicacionTipoDescuento;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPODESCUENTO", referencedColumnName = "CODIGOTIPODESCUENTO", insertable = false, updatable = false)
	})
	private TipoDescuentoDTO tipoDescuento;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOAPLICACIONTIPODESCUENTO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "VALORAPLICACIONTIPODESCUENTO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorDTO tipoAplicacionDescuento;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOASIGNACIONTIPODESCUENTO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "VALORASIGNACIONTIPODESCUENTO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorDTO tipoAsignacionDescuento;
	

	/**
	 * @return the id
	 */
	public AsignacionTipoDescuentoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(AsignacionTipoDescuentoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoAsignacionTipoDescuento
	 */
	public Integer getCodigoAsignacionTipoDescuento() {
		return codigoAsignacionTipoDescuento;
	}

	/**
	 * @param codigoAsignacionTipoDescuento the codigoAsignacionTipoDescuento to set
	 */
	public void setCodigoAsignacionTipoDescuento(Integer codigoAsignacionTipoDescuento) {
		this.codigoAsignacionTipoDescuento = codigoAsignacionTipoDescuento;
	}

	/**
	 * @return the valorAsignacionTipoDescuento
	 */
	public String getValorAsignacionTipoDescuento() {
		return valorAsignacionTipoDescuento;
	}

	/**
	 * @param valorAsignacionTipoDescuento the valorAsignacionTipoDescuento to set
	 */
	public void setValorAsignacionTipoDescuento(String valorAsignacionTipoDescuento) {
		this.valorAsignacionTipoDescuento = valorAsignacionTipoDescuento;
	}

	/**
	 * @return the prioridad
	 */
	public Integer getPrioridad() {
		return prioridad;
	}

	/**
	 * @param prioridad the prioridad to set
	 */
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the tipoDescuento
	 */
	public TipoDescuentoDTO getTipoDescuento() {
		return tipoDescuento;
	}

	/**
	 * @param tipoDescuento the tipoDescuento to set
	 */
	public void setTipoDescuento(TipoDescuentoDTO tipoDescuento) {
		this.tipoDescuento = tipoDescuento;
	}

	/**
	 * @return the tipoAplicacionDescuento
	 */
	public CatalogoValorDTO getTipoAplicacionDescuento() {
		return tipoAplicacionDescuento;
	}

	/**
	 * @param tipoAplicacionDescuento the tipoAplicacionDescuento to set
	 */
	public void setTipoAplicacionDescuento(CatalogoValorDTO tipoAplicacionDescuento) {
		this.tipoAplicacionDescuento = tipoAplicacionDescuento;
	}

	/**
	 * @return the tipoAsignacionDescuento
	 */
	public CatalogoValorDTO getTipoAsignacionDescuento() {
		return tipoAsignacionDescuento;
	}

	/**
	 * @param tipoAsignacionDescuento the tipoAsignacionDescuento to set
	 */
	public void setTipoAsignacionDescuento(CatalogoValorDTO tipoAsignacionDescuento) {
		this.tipoAsignacionDescuento = tipoAsignacionDescuento;
	}
	
	/**
	 * @return the codigoTipoDescuento
	 */
	public String getCodigoTipoDescuento() {
		return codigoTipoDescuento;
	}

	/**
	 * @param codigoTipoDescuento the codigoTipoDescuento to set
	 */
	public void setCodigoTipoDescuento(String codigoTipoDescuento) {
		this.codigoTipoDescuento = codigoTipoDescuento;
	}

	/**
	 * @return the codigoAplicacionTipoDescuento
	 */
	public Integer getCodigoAplicacionTipoDescuento() {
		return codigoAplicacionTipoDescuento;
	}

	/**
	 * @param codigoAplicacionTipoDescuento the codigoAplicacionTipoDescuento to set
	 */
	public void setCodigoAplicacionTipoDescuento(Integer codigoAplicacionTipoDescuento) {
		this.codigoAplicacionTipoDescuento = codigoAplicacionTipoDescuento;
	}

	/**
	 * @return the valorAplicacionTipoDescuento
	 */
	public String getValorAplicacionTipoDescuento() {
		return valorAplicacionTipoDescuento;
	}

	/**
	 * @param valorAplicacionTipoDescuento the valorAplicacionTipoDescuento to set
	 */
	public void setValorAplicacionTipoDescuento(String valorAplicacionTipoDescuento) {
		this.valorAplicacionTipoDescuento = valorAplicacionTipoDescuento;
	}

}
