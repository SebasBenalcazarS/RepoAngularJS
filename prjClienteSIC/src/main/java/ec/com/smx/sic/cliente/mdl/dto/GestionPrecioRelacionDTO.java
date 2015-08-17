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
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.mdl.dto.id.GestionPrecioRelacionID;

/**
 * @author gnolivos
 *
 */
@Entity
@Table(name="SCPRETGESPREREL")
@SuppressWarnings("serial")
public class GestionPrecioRelacionDTO  extends AuditoriaBaseDTO{

	@EmbeddedId
	private GestionPrecioRelacionID id = new GestionPrecioRelacionID();

	@Column(name = "CODIGOGESTIONPRECIO", nullable = false)
	private Long codigoGestionPrecio;

	@Column(name = "CODIGOGESTIONPRECIORELACIONADO", nullable = false)
	private Long codigoGestionPrecioRelacionado;

	@ComparatorTypeField
	@Column(name = "ESTADO", nullable = false)
	private String estado;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOGESTIONPRECIO", referencedColumnName = "CODIGOGESTIONPRECIO", insertable = false, updatable = false)
	})
	private GestionPrecioDTO gestionPrecio;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOGESTIONPRECIORELACIONADO", referencedColumnName = "CODIGOGESTIONPRECIO", insertable = false, updatable = false)
	})
	private GestionPrecioDTO gestionPrecioRelacionado;

    @Transient
    private Boolean tieneConvenioParticipantes;

    /**
	 * @return the id
	 */
	public GestionPrecioRelacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(GestionPrecioRelacionID id) {
		this.id = id;
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
	 * @return the gestionPrecio
	 */
	public GestionPrecioDTO getGestionPrecio() {
		return gestionPrecio;
	}

	/**
	 * @param gestionPrecio the gestionPrecio to set
	 */
	public void setGestionPrecio(GestionPrecioDTO gestionPrecio) {
		this.gestionPrecio = gestionPrecio;
	}

	/**
	 * @return the gestionPrecioRelacionado
	 */
	public GestionPrecioDTO getGestionPrecioRelacionado() {
		return gestionPrecioRelacionado;
	}

	/**
	 * @param gestionPrecioRelacionado the gestionPrecioRelacionado to set
	 */
	public void setGestionPrecioRelacionado(GestionPrecioDTO gestionPrecioRelacionado) {
		this.gestionPrecioRelacionado = gestionPrecioRelacionado;
	}

	/**
	 * @return the codigoGestionPrecio
	 */
	public Long getCodigoGestionPrecio() {
		return codigoGestionPrecio;
	}

	/**
	 * @param codigoGestionPrecio the codigoGestionPrecio to set
	 */
	public void setCodigoGestionPrecio(Long codigoGestionPrecio) {
		this.codigoGestionPrecio = codigoGestionPrecio;
	}

	/**
	 * @return the codigoGestionPrecioRelacionado
	 */
	public Long getCodigoGestionPrecioRelacionado() {
		return codigoGestionPrecioRelacionado;
	}

	/**
	 * @param codigoGestionPrecioRelacionado the codigoGestionPrecioRelacionado to set
	 */
	public void setCodigoGestionPrecioRelacionado(Long codigoGestionPrecioRelacionado) {
		this.codigoGestionPrecioRelacionado = codigoGestionPrecioRelacionado;
	}

    public Boolean getTieneConvenioParticipantes() {
        return tieneConvenioParticipantes;
    }

    public void setTieneConvenioParticipantes(Boolean tieneConvenioParticipantes) {
        this.tieneConvenioParticipantes = tieneConvenioParticipantes;
    }
}
