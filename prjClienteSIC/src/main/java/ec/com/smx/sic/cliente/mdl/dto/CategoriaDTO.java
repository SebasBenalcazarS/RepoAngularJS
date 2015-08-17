
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.CategoriaID;

/**
 * Especifica las caractegorias del detalle de la seccion tipo anden
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTCATEGORIA")
public class CategoriaDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla CategoriaDTO
	 *
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.CategoriaID id = new ec.com.smx.sic.cliente.mdl.dto.id.CategoriaID();
	
	/**
	 * Código del tipo de ubicación de la estructura logística en el catálogo
	 *
	 */
	@Transient
	@Column
	private Integer codigoTipoCategoria ;

	/**
	 * Valor del tipo de ubicación de la estructura logística en el catálogo (Valores R-> Real - V -> Virtual)
	 *
	 */
	@Transient
	@Column
	private String valorTipoCategoria ;

	
	/**
	 * Indica el estado del registro:[1] activo [0] inactivo
	 *
	 */
	@Column
	private String estado ;
	
	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;
	
	/**
	 * Fecha en la que se realiza la actualizacion del registro
	 * 
	 */
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaActualizacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro;

	
	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioActualizacion;
	
	/**
	 * Obtiene la relacion con el catálogo del tipo de ubicaciones
	 *
	 */
	@Transient
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOCATEGORIA", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOCATEGORIA", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoCategoriaDTO;

	
	public CategoriaDTO() {
		
	}


	/**
	 * @return the id
	 */
	public CategoriaID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(CategoriaID id) {
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
	 * @return the codigoTipoCategoria
	 */
	public Integer getCodigoTipoCategoria() {
		return codigoTipoCategoria;
	}


	/**
	 * @param codigoTipoCategoria the codigoTipoCategoria to set
	 */
	public void setCodigoTipoCategoria(Integer codigoTipoCategoria) {
		this.codigoTipoCategoria = codigoTipoCategoria;
	}


	/**
	 * @return the valorTipoCategoria
	 */
	public String getValorTipoCategoria() {
		return valorTipoCategoria;
	}

	/**
	 * @param valorTipoCategoria the valorTipoCategoria to set
	 */
	public void setValorTipoCategoria(String valorTipoCategoria) {
		this.valorTipoCategoria = valorTipoCategoria;
	}


	/**
	 * @return the tipoCategoriaDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoCategoriaDTO() {
		return tipoCategoriaDTO;
	}


	/**
	 * @param tipoCategoriaDTO the tipoCategoriaDTO to set
	 */
	public void setTipoCategoriaDTO(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoCategoriaDTO) {
		this.tipoCategoriaDTO = tipoCategoriaDTO;
	}


	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public java.util.Date getFechaActualizacion() {
		return fechaActualizacion;
	}


	public void setFechaActualizacion(java.util.Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}


	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}


	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}


	public String getIdUsuarioActualizacion() {
		return idUsuarioActualizacion;
	}


	public void setIdUsuarioActualizacion(String idUsuarioActualizacion) {
		this.idUsuarioActualizacion = idUsuarioActualizacion;
	}
}