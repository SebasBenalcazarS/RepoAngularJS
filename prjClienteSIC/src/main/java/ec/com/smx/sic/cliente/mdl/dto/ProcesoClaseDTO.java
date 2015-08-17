package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.ProcesoClaseID;

/**
 * Gestiona todos los procesos que puede tener una clase de articulo
 * @author fcollaguazo
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTPROCLA")
public class ProcesoClaseDTO extends AuditoriaBaseDTO{

	/**
	 * Clave primaria de la tabla proceso clase
	 */
	@EmbeddedId
	private ProcesoClaseID id;
	
	/**
	 * Especifica el estado del registro del proceso
	 */
	private String estado;
	
	/**
	 * Relacion con el proceso
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false)
	})
	private ec.com.smx.corpv2.dto.ProcesoDTO procesoDTO;
	
	
	/**
	 * Relacion con la clase del articulo
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLASEARTICULO", referencedColumnName = "CODIGOCLASEARTICULO", insertable = false, updatable = false)
	})
	private ClaseArticuloDTO claseArticuloDTO;
	
	
	public ProcesoClaseDTO(){
		id = new ProcesoClaseID();
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
	 * @return the id
	 */
	public ProcesoClaseID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ProcesoClaseID id) {
		this.id = id;
	}

	/**
	 * @return the procesoDTO
	 */
	public ec.com.smx.corpv2.dto.ProcesoDTO getProcesoDTO() {
		return procesoDTO;
	}

	/**
	 * @param procesoDTO the procesoDTO to set
	 */
	public void setProcesoDTO(ec.com.smx.corpv2.dto.ProcesoDTO procesoDTO) {
		this.procesoDTO = procesoDTO;
	}

	/**
	 * @return the claseArticuloDTO
	 */
	public ClaseArticuloDTO getClaseArticuloDTO() {
		return claseArticuloDTO;
	}

	/**
	 * @param claseArticuloDTO the claseArticuloDTO to set
	 */
	public void setClaseArticuloDTO(ClaseArticuloDTO claseArticuloDTO) {
		this.claseArticuloDTO = claseArticuloDTO;
	}
}
