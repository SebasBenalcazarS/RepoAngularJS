package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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

/**
 * Contiene los tipos de descuento aplicados al costo de un artículo
 * 
 * @author kruger
 */
@Entity
@Table(name="SCSADTTIPDES")
@SuppressWarnings("serial")
public class TipoDescuentoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.TipoDescuentoID id = new ec.com.smx.sic.cliente.mdl.dto.id.TipoDescuentoID();

	/**
	 * Descripción corta del registro
	 * 
	 */
	private String nombre;

	/**
	 * Descripción larga del registro
	 * 
	 */
	private String descripcion;

	/**
	 * Estado del registro, sus valores pueden ser: [1] activo [0] inactivo
	 * 
	 */
	@ComparatorTypeField
	private String estado;

	/**
	 * Indica la prioridad del descuento en el momento que se aplica en cascada
	 * 
	 */
	//private Double prioridad;

	/**
	 * Código del tipo de uso del descuento
	 * 
	 */
	private Integer codigoTipoUso;

	/**
	 * Valor del tipo de uso del descuento
	 * 
	 */
	@ComparatorTypeField
	private String valorTipoUso;
	/**
	 * Código del tipo de alcance del descuento
	 * 
	 */
	private Integer codigoTipoAlcance;

	/**
	 * Valor del tipo de alcance del descuento
	 * 
	 */
	@ComparatorTypeField
	private String valorTipoAlcance;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizó la última actualización.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOALCANCE", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOALCANCE", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoAlcanceDescuento;
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOUSO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOUSO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoUsoDescuento;
	
	@OneToMany(mappedBy = "tipoDescuento")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private List<AsignacionTipoDescuentoDTO> asignacionTipoDescuento;
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.TipoDescuentoID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.TipoDescuentoID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>nombre</code>
	 * 
	 * @return Retorna valor de propiedad <code>nombre</code>
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>nombre</code>.
	 * 
	 * @param nombre1
	 *            El valor a establecer para la propiedad <code>nombre</code>.
	 */
	public void setNombre(String nombre1) {
		this.nombre = nombre1 != null ? nombre1.toUpperCase() : null;

		if (nombre != null && nombre.length() > 50) {
			nombre = nombre.substring(0, 50);
		}

	}

	/**
	 * Retorna valor de propiedad <code>descripcion</code>
	 * 
	 * @return Retorna valor de propiedad <code>descripcion</code>
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descripcion</code>.
	 * 
	 * @param descripcion1
	 *            El valor a establecer para la propiedad <code>descripcion</code>.
	 */
	public void setDescripcion(String descripcion1) {
		this.descripcion = descripcion1 != null ? descripcion1.toUpperCase() : null;

		if (descripcion != null && descripcion.length() > 512) {
			descripcion = descripcion.substring(0, 512);
		}

	}

	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * 
	 * @return Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * 
	 * @param estado1
	 *            El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado(String estado1) {
		this.estado = estado1;

		if (estado != null && estado.length() > 1) {
			estado = estado.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>prioridad</code>
	 * 
	 * @return Retorna valor de propiedad <code>prioridad</code>
	 */
//	public Double getPrioridad() {
//		return this.prioridad;
//	}

	/**
	 * Establece un nuevo valor para la propiedad <code>prioridad</code>.
	 * 
	 * @param prioridad1
	 *            El valor a establecer para la propiedad <code>prioridad</code>.
	 */
//	public void setPrioridad(Double prioridad1) {
//		this.prioridad = prioridad1;
//
//	}

	/**
	 * Retorna valor de propiedad <code>codigoTipoUso</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoTipoUso</code>
	 */
	public Integer getCodigoTipoUso() {
		return this.codigoTipoUso;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoUso</code>.
	 * 
	 * @param codigoTipoUso1
	 *            El valor a establecer para la propiedad <code>codigoTipoUso</code>.
	 */
	public void setCodigoTipoUso(Integer codigoTipoUso1) {
		this.codigoTipoUso = codigoTipoUso1;

	}

	/**
	 * Retorna valor de propiedad <code>valorTipoUso</code>
	 * 
	 * @return Retorna valor de propiedad <code>valorTipoUso</code>
	 */
	public String getValorTipoUso() {
		return this.valorTipoUso;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>valorTipoUso</code>.
	 * 
	 * @param valorTipoUso1
	 *            El valor a establecer para la propiedad <code>valorTipoUso</code>.
	 */
	public void setValorTipoUso(String valorTipoUso1) {
		this.valorTipoUso = valorTipoUso1;

		if (valorTipoUso != null && valorTipoUso.length() > 3) {
			valorTipoUso = valorTipoUso.substring(0, 3);
		}

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
	 * Retorna valor de propiedad <code>tipoUsoDescuento</code>
	 * 
	 * @return Retorna valor de propiedad <code>tipoUsoDescuento</code>
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoUsoDescuento() {
		return this.tipoUsoDescuento;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tipoUsoDescuento</code>.
	 * 
	 * @param tipoUsoDescuento1
	 *            El valor a establecer para la propiedad <code>tipoUsoDescuento</code>.
	 */
	public void setTipoUsoDescuento(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoUsoDescuento1) {
		this.tipoUsoDescuento = tipoUsoDescuento1;
	}

	/**
	 * @return the codigoTipoAlcance
	 */
	public Integer getCodigoTipoAlcance() {
		return codigoTipoAlcance;
	}

	/**
	 * @param codigoTipoAlcance the codigoTipoAlcance to set
	 */
	public void setCodigoTipoAlcance(Integer codigoTipoAlcance) {
		this.codigoTipoAlcance = codigoTipoAlcance;
	}

	/**
	 * @return the valorTipoAlcance
	 */
	public String getValorTipoAlcance() {
		return valorTipoAlcance;
	}

	/**
	 * @param valorTipoAlcance the valorTipoAlcance to set
	 */
	public void setValorTipoAlcance(String valorTipoAlcance) {
		this.valorTipoAlcance = valorTipoAlcance;
	}

	/**
	 * @return the tipoAlcanceDescuento
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoAlcanceDescuento() {
		return tipoAlcanceDescuento;
	}

	/**
	 * @param tipoAlcanceDescuento the tipoAlcanceDescuento to set
	 */
	public void setTipoAlcanceDescuento(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoAlcanceDescuento) {
		this.tipoAlcanceDescuento = tipoAlcanceDescuento;
	}

	/**
	 * @return the asignacionTipoDescuento
	 */
	public List<AsignacionTipoDescuentoDTO> getAsignacionTipoDescuento() {
		return asignacionTipoDescuento;
	}

	/**
	 * @param asignacionTipoDescuento the asignacionTipoDescuento to set
	 */
	public void setAsignacionTipoDescuento(
			List<AsignacionTipoDescuentoDTO> asignacionTipoDescuento) {
		this.asignacionTipoDescuento = asignacionTipoDescuento;
	}
}
