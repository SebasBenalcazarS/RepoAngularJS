/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.mdl.dto.id.FuncionarioPerfilDetalleSeccionID;

/**
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTFUNPERDETSEC")
public class FuncionarioPerfilDetalleSeccionDTO extends AuditoriaBaseDTO  {
	/**
	 * Clave primaria de la tabla Seccion
	 *
	 */
	@EmbeddedId
	private FuncionarioPerfilDetalleSeccionID id = new FuncionarioPerfilDetalleSeccionID();
	
	@ComparatorTypeField
	@Column(name = "ESTADO")
	private String estado;
	
	/**
	 * Permite identificar si el objeto esta seleccionado o no
	 */
	@Transient
	private Boolean selected = Boolean.FALSE;

	/**
	 * Relacion con FUNCIONARIO PERFIL 
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA",referencedColumnName="CODIGOCOMPANIA",insertable=false,updatable=false),
		@JoinColumn(name="CODIGOFUNCIONARIO",referencedColumnName="CODIGOFUNCIONARIO",insertable=false,updatable=false),
		@JoinColumn(name = "CODIGOPERFIL", referencedColumnName = "CODIGOPERFIL", insertable = false, updatable = false)})
	private ec.com.smx.corpv2.dto.FuncionarioPerfilDTO funcionarioPerfilDTO;
	
	/**
	 * Relacion con DETALLE SECCION
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA",referencedColumnName="CODIGOCOMPANIA",insertable=false,updatable=false),
		@JoinColumn(name="CODIGODETALLESECCION",referencedColumnName="CODIGODETALLESECCION",insertable=false,updatable=false)})
	private DetalleSeccionDTO detalleSeccionDTO;
	
	/****************************
	 * SETTERS & GETTERS
	 ***************************/
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
	 * @return the funcionarioPerfilDTO
	 */
	public ec.com.smx.corpv2.dto.FuncionarioPerfilDTO getFuncionarioPerfilDTO() {
		return funcionarioPerfilDTO;
	}

	/**
	 * @param funcionarioPerfilDTO the funcionarioPerfilDTO to set
	 */
	public void setFuncionarioPerfilDTO(ec.com.smx.corpv2.dto.FuncionarioPerfilDTO funcionarioPerfilDTO) {
		this.funcionarioPerfilDTO = funcionarioPerfilDTO;
	}

	/**
	 * @return the detalleSeccionDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionDTO() {
		return detalleSeccionDTO;
	}

	/**
	 * @param detalleSeccionDTO the detalleSeccionDTO to set
	 */
	public void setDetalleSeccionDTO(DetalleSeccionDTO detalleSeccionDTO) {
		this.detalleSeccionDTO = detalleSeccionDTO;
	}

	/**
	 * @return the id
	 */
	public FuncionarioPerfilDetalleSeccionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(FuncionarioPerfilDetalleSeccionID id) {
		this.id = id;
	}

	/**
	 * @return the selected
	 */
	public Boolean getSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
}
