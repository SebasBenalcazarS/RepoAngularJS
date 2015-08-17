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
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.AreaTrabajoDetalleSeccionID;

/**
 * Relaciona los andenes con los locales
 * @author cortiz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTARETRADETSEC")
public class AreaTrabajoDetalleSeccionDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private AreaTrabajoDetalleSeccionID id= new AreaTrabajoDetalleSeccionID();
	
	@Column(name="CODIGOAREATRABAJO", nullable = false)
	@ComparatorTypeField
	private java.lang.Integer codigoAreaTrabajo ;
	
	@Column(name = "CODIGODETALLESECCION", nullable = false)
	private java.lang.Long codigoDetalleSeccion ;
	
	@Column
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Obtiene la relacion DetalleSeccionDTO
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODETALLESECCION", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false) })
	private DetalleSeccionDTO detalleSeccionDTO;
	
	/**
	 * Obtiene la relacion de proveedoresDTO
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOAREATRABAJO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)
	})
	private AreaTrabajoDTO areaTrabajoDTO;

	
	@Transient
	private Boolean selected = Boolean.FALSE;
	
	
	public AreaTrabajoDetalleSeccionID getId() {
		return id;
	}

	public void setId(AreaTrabajoDetalleSeccionID id) {
		this.id = id;
	}

	public java.lang.Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	public void setCodigoAreaTrabajo(java.lang.Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	public java.lang.Long getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}

	public void setCodigoDetalleSeccion(java.lang.Long codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public DetalleSeccionDTO getDetalleSeccionDTO() {
		return detalleSeccionDTO;
	}

	public void setDetalleSeccionDTO(DetalleSeccionDTO detalleSeccionDTO) {
		this.detalleSeccionDTO = detalleSeccionDTO;
	}

	public AreaTrabajoDTO getAreaTrabajoDTO() {
		return areaTrabajoDTO;
	}

	public void setAreaTrabajoDTO(AreaTrabajoDTO areaTrabajoDTO) {
		this.areaTrabajoDTO = areaTrabajoDTO;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
}
