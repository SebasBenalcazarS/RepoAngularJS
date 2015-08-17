package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.mdl.dto.id.DetalleSeccionAreaTrabajoID;

@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTDETSECARETRA")
public class DetalleSeccionAreaTrabajoDTO extends AuditoriaBaseDTO{
	
	/**
	 * Clave primaria de la tabla
	 *
	 */
	@EmbeddedId
	private DetalleSeccionAreaTrabajoID id = new DetalleSeccionAreaTrabajoID();
	
	@ComparatorTypeField
	private String estado ;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGODETALLESECCION", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO detalleSeccionDTO;

	/**
	 * @return the id
	 */
	public DetalleSeccionAreaTrabajoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(DetalleSeccionAreaTrabajoID id) {
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
	 * @return the detalleSeccionDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO getDetalleSeccionDTO() {
		return detalleSeccionDTO;
	}

	/**
	 * @param detalleSeccionDTO the detalleSeccionDTO to set
	 */
	public void setDetalleSeccionDTO(ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO detalleSeccionDTO) {
		this.detalleSeccionDTO = detalleSeccionDTO;
	}
}
