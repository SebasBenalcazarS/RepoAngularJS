package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.ComponenteNutricionalID;

@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTCOMNUT")
public class ComponenteNutricionalDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private ComponenteNutricionalID id = new ComponenteNutricionalID();

	/**
	 * nombre del componente nutricional
	 */
	private String nombre;
	
	/**
	 * descripcion del componente nutricional
	 */
	private String descripcion;
	
	/**
	 * estado del componente nutricional, los valores permitidos son: [0] INACTIVO, [1] ACTIVO
	 */
	@ComparatorTypeField
	private String estado;
	
	/**
	 * orden del componente nutricional
	 */
	private Integer orden;
	
	/**
	 * Indica si el componente nutricional tiene activado o no el ingreso de porcentajes (1/0)
	 */
	private Integer aplicaPorcentaje;
	
	/**
	 * Indica si el componente nutricional tiene activado o no el ingreso de cantidad (1/0)
	 */
	private Integer aplicaCantidad;
	
	/**
	 * Valor del catalogo tipo de estudio nutricional
	 */
	private String valorTipoEstudioNutricional;
	
	/**
	 * Codigo del catalogo tipo de estudio nutricional
	 */
	private Integer codigoTipoEstudioNutricional;
	
	/**
	 * Usuario que creó el registro
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la cual se creó el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Usuario que realiza la última actualización del registro
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la cual se realizó la ultima actualización del registro
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	@OneToMany(mappedBy = "componenteNutricionalDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloInformacionNutricionalDTO> artInfNutCol;
	
	/**
	 * @return the id
	 */
	public ComponenteNutricionalID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ComponenteNutricionalID id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion() {
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

	}

	/**
	 * @return the artInfNutCol
	 */
	public Collection<ArticuloInformacionNutricionalDTO> getArtInfNutCol() {
		return artInfNutCol;
	}

	/**
	 * @param artInfNutCol the artInfNutCol to set
	 */
	public void setArtInfNutCol(Collection<ArticuloInformacionNutricionalDTO> artInfNutCol) {
		this.artInfNutCol = artInfNutCol;
	}

	public Integer getAplicaPorcentaje() {
		return aplicaPorcentaje;
	}

	public void setAplicaPorcentaje(Integer aplicaPorcentaje) {
		this.aplicaPorcentaje = aplicaPorcentaje;
	}

	public Integer getAplicaCantidad() {
		return aplicaCantidad;
	}

	public void setAplicaCantidad(Integer aplicaCantidad) {
		this.aplicaCantidad = aplicaCantidad;
	}

	/**
	 * @return the valorTipoEstudioNutricional
	 */
	public String getValorTipoEstudioNutricional() {
		return valorTipoEstudioNutricional;
	}

	/**
	 * @param valorTipoEstudioNutricional the valorTipoEstudioNutricional to set
	 */
	public void setValorTipoEstudioNutricional(String valorTipoEstudioNutricional) {
		this.valorTipoEstudioNutricional = valorTipoEstudioNutricional;
	}

	/**
	 * @return the codigoTipoEstudioNutricional
	 */
	public Integer getCodigoTipoEstudioNutricional() {
		return codigoTipoEstudioNutricional;
	}

	/**
	 * @param codigoTipoEstudioNutricional the codigoTipoEstudioNutricional to set
	 */
	public void setCodigoTipoEstudioNutricional(Integer codigoTipoEstudioNutricional) {
		this.codigoTipoEstudioNutricional = codigoTipoEstudioNutricional;
	}
	
	
	
	
}
