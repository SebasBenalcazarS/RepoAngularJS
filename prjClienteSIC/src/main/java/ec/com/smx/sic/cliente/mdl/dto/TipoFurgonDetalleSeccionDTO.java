
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

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.TipoFurgonDetalleSeccionID;

/**
 * Especifica las caractegorias del detalle de la seccion tipo anden
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTTIPFURDETSEC")
public class TipoFurgonDetalleSeccionDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla CategoriaDTO
	 *
	 */
	@EmbeddedId
	private TipoFurgonDetalleSeccionID id = new TipoFurgonDetalleSeccionID();
	
	/**
	 * Codigo del tipo de de furgon
	 *
	 */
	@Column
	private Integer codigoTipoFurgon ;

	/**
	 * Valor del tipo de furgon 
	 *
	 */
	@Column
	private String valorTipoFurgon;
	
	/**
	 * Especifica el codigo de la seccion
	 *
	 */
	@Column
	@ComparatorTypeField
	private java.lang.Long codigoDetalleSeccion ;

	
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
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioActualizacion;
	
	/**
	 * Obtiene la relacion con el catalogo del tipo de ubicaciones
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOFURGON", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOFURGON", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoCategoriaDTO;

	public TipoFurgonDetalleSeccionDTO() {
		
	}

	/**
	 * @return the id
	 */
	public TipoFurgonDetalleSeccionID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(TipoFurgonDetalleSeccionID id) {
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

	/**
	 * @return the codigoTipoFurgon
	 */
	public Integer getCodigoTipoFurgon() {
		return codigoTipoFurgon;
	}

	/**
	 * @param codigoTipoFurgon the codigoTipoFurgon to set
	 */
	public void setCodigoTipoFurgon(Integer codigoTipoFurgon) {
		this.codigoTipoFurgon = codigoTipoFurgon;
	}

	/**
	 * @return the valorTipoFurgon
	 */
	public String getValorTipoFurgon() {
		return valorTipoFurgon;
	}

	/**
	 * @param valorTipoFurgon the valorTipoFurgon to set
	 */
	public void setValorTipoFurgon(String valorTipoFurgon) {
		this.valorTipoFurgon = valorTipoFurgon;
	}

	/**
	 * @return the codigoDetalleSeccion
	 */
	public java.lang.Long getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}

	/**
	 * @param codigoDetalleSeccion the codigoDetalleSeccion to set
	 */
	public void setCodigoDetalleSeccion(java.lang.Long codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaActualizacion
	 */
	public java.util.Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(java.util.Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	/**
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the idUsuarioActualizacion
	 */
	public String getIdUsuarioActualizacion() {
		return idUsuarioActualizacion;
	}

	/**
	 * @param idUsuarioActualizacion the idUsuarioActualizacion to set
	 */
	public void setIdUsuarioActualizacion(String idUsuarioActualizacion) {
		this.idUsuarioActualizacion = idUsuarioActualizacion;
	}
	
}