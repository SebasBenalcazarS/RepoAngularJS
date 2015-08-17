
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoTipoDTO;
import ec.com.smx.frameworkv2.security.dto.ProfileDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.TipoTareaPerfilID;


/**
 * Almacena todas las tareas de la estructura logistica
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBTARTTIPTARPER")
public class TipoTareaPerfilDTO extends SimpleAuditDTO {
	
	/**
	 * Clave primaria de la tabla TareaDTO
	 * 
	 */
	@EmbeddedId
	private TipoTareaPerfilID id = new TipoTareaPerfilID();


	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 *
	 */
	@Column
	@ComparatorTypeField
	private String estado ;
	
	/**
	 * codigo asignado a un perfil
	 *
	 */
	@Column
	@ComparatorTypeField
	private String codigoPerfil ;
	

	/**
	 * Representa el codigo tipo del CatalogoTipo que ata con la colecci�n de posibles estados para esta tarea 
	 * 
	 */
	@Column(name="CODIGOTIPOESTADOSTAREA")
	private Integer codigoTipoEstadoTarea;
	
	/**
	 * relacion con la tabla {@link TipoTareaDTO}
	 */
	@Column(name="CODIGOTIPOTAREA")
	private Long codigoTipoTarea;
	
	/**
	 * Obtiene la relacion con la tarea
	 */
	@OneToMany(mappedBy = "tipoTareaPerfilDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<TareaDTO> tareaCol;
	
	/**
	 * Relacion con el Perfil
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOPERFIL", insertable=false, updatable=false, referencedColumnName="PROFILEID")})
	private ProfileDto perfilDTO;
	
	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOTIPOESTADOSTAREA", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoTipoDTO catalogoTipoEstadosTarea;
	
	/**
	 * Relacion con {@link TipoTareaDTO}
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOTIPOTAREA", insertable=false, updatable=false, referencedColumnName="CODIGOTIPOTAREA"),
			@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA")})
	private TipoTareaDTO tipoTareaDTO;
	
	/**
	 * @return the id
	 */
	public TipoTareaPerfilID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(TipoTareaPerfilID id) {
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
	 * @return the tareaCol
	 */
	public Collection<TareaDTO> getTareaCol() {
		return tareaCol;
	}

	/**
	 * @param tareaCol the tareaCol to set
	 */
	public void setTareaCol(Collection<TareaDTO> tareaCol) {
		this.tareaCol = tareaCol;
	}

	/**
	 * @return the perfilDTO
	 */
	public ProfileDto getPerfilDTO() {
		return perfilDTO;
	}

	/**
	 * @param perfilDTO the perfilDTO to set
	 */
	public void setPerfilDTO(ProfileDto perfilDTO) {
		this.perfilDTO = perfilDTO;
	}


	public CatalogoTipoDTO getCatalogoTipoEstadosTarea() {
		return catalogoTipoEstadosTarea;
	}

	public void setCatalogoTipoEstadosTarea(CatalogoTipoDTO catalogoTipoEstadosTarea) {
		this.catalogoTipoEstadosTarea = catalogoTipoEstadosTarea;
	}

	/**
	 * @return the codigoTipoEstadoTarea
	 */
	public Integer getCodigoTipoEstadoTarea() {
		return codigoTipoEstadoTarea;
	}

	/**
	 * @param codigoTipoEstadoTarea the codigoTipoEstadoTarea to set
	 */
	public void setCodigoTipoEstadoTarea(Integer codigoTipoEstadoTarea) {
		this.codigoTipoEstadoTarea = codigoTipoEstadoTarea;
	}

	/**
	 * @return the codigoTipoTarea
	 */
	public Long getCodigoTipoTarea() {
		return codigoTipoTarea;
	}

	/**
	 * @param codigoTipoTarea the codigoTipoTarea to set
	 */
	public void setCodigoTipoTarea(Long codigoTipoTarea) {
		this.codigoTipoTarea = codigoTipoTarea;
	}

	/**
	 * @return the tipoTareaDTO
	 */
	public TipoTareaDTO getTipoTareaDTO() {
		return tipoTareaDTO;
	}

	/**
	 * @param tipoTareaDTO the tipoTareaDTO to set
	 */
	public void setTipoTareaDTO(TipoTareaDTO tipoTareaDTO) {
		this.tipoTareaDTO = tipoTareaDTO;
	}
}