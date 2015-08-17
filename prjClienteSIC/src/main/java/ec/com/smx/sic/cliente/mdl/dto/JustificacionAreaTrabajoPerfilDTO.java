package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corporativo.admparamgeneral.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.PerfilDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.JustificacionAreaTrabajoPerfilID;

/**
 * @author aecaiza
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTJUSARETRAPER")
public class JustificacionAreaTrabajoPerfilDTO extends AuditoriaBaseDTO{
	
	@EmbeddedId
	private JustificacionAreaTrabajoPerfilID id = new JustificacionAreaTrabajoPerfilID();
	
	@ComparatorTypeField
	private String codigoPerfil ;
	
	/**
	 * Codigo de la Justificacion
	 * 
	 */
	@Column
	private java.lang.Long codigoJustificacion;
	
	/**
	 * Codigo del Area de Trabajo
	 * 
	 */
	@Column
	private Integer codigoAreaTrabajo;
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 *
	 */
	@Column
	private String estado ;
	
	
	/**
	 * Relacion con la justificacion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOJUSTIFICACION", insertable = false, updatable = false, referencedColumnName = "CODIGOJUSTIFICACION") })
	private JustificacionDTO justificacionDTO;
	
	/**
	 * Relacion con la justificacion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOAREATRABAJO", insertable = false, updatable = false, referencedColumnName = "CODIGOAREATRABAJO") })
	private AreaTrabajoDTO areaTrabajoDTO;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOPERFIL", referencedColumnName = "PROFILEID", insertable = false, updatable = false)
        })
	private PerfilDTO perfilDTO;

	/**
	 * @return the id
	 */
	public JustificacionAreaTrabajoPerfilID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(JustificacionAreaTrabajoPerfilID id) {
		this.id = id;
	}

	/**
	 * @return the codigoJustificacion
	 */
	public java.lang.Long getCodigoJustificacion() {
		return codigoJustificacion;
	}

	/**
	 * @param codigoJustificacion the codigoJustificacion to set
	 */
	public void setCodigoJustificacion(java.lang.Long codigoJustificacion) {
		this.codigoJustificacion = codigoJustificacion;
	}

	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
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
	 * @return the justificacionDTO
	 */
	public JustificacionDTO getJustificacionDTO() {
		return justificacionDTO;
	}

	/**
	 * @param justificacionDTO the justificacionDTO to set
	 */
	public void setJustificacionDTO(JustificacionDTO justificacionDTO) {
		this.justificacionDTO = justificacionDTO;
	}

	/**
	 * @return the areaTrabajoDTO
	 */
	public AreaTrabajoDTO getAreaTrabajoDTO() {
		return areaTrabajoDTO;
	}

	/**
	 * @param areaTrabajoDTO the areaTrabajoDTO to set
	 */
	public void setAreaTrabajoDTO(AreaTrabajoDTO areaTrabajoDTO) {
		this.areaTrabajoDTO = areaTrabajoDTO;
	}
	
	/**
	 * @return the codigoPerfil
	 */
	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	/**
	 * @param codigoPerfil the codigoPerfil to set
	 */
	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	/**
	 * @return the perfilDTO
	 */
	public PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	/**
	 * @param perfilDTO the perfilDTO to set
	 */
	public void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}
}
