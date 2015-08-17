package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorClasificacionID;
import ec.com.smx.sic.cliente.mdl.nopersistente.ProveedorClasificacionTransient;

/**
 * Entidad que almecena los datos de la relacion de los proveedores vs. clasificaciones
 * 
 * @author kruger
 */
@Entity
@Table(name="SCSPETPROCLA")
@SuppressWarnings("serial")
public class ProveedorClasificacionDTO extends ProveedorClasificacionTransient {

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ProveedorClasificacionID id;

	/**
	 * Estado de la relacion proveedor vs. clasificacion, los valores pueden ser: [1] Activo, [0] Inactivo
	 * 
	 */
	@ComparatorTypeField
	private String estadoProveedorClasificacion;

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
	 * Dias del plazo de pago que la Corporacion tiene negociado con el proveedor en esa clasificacion
	 */
	@ComparatorTypeField
	@Column(name = "VALORTIPOPLAZOPAGO", nullable = false)
	private String valorTipoPlazoPago;

	
	/**
	 * Establece el codigo del plazo de pago
	 */
	@Column(name = "CODIGOTIPOPLAZOPAGO", nullable = false)
	private Integer codigoTipoPlazoPago;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	@Column(name = "FECHAULTIMAACTUALIZACION", nullable = false)
	private java.sql.Timestamp fechaModificacion;

	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;
	
	/**
	 * Valor que indica si el objeto ha sido seleccionado.
	 */
	@Transient
	private Boolean selected = Boolean.FALSE;
	
	/**
	 * Campo mapeado que contiene el codigo y la descripcion para la auditoria
	 */
	@Transient
	private String tipoPlazoPagoCodigoDescripcion;
	/**
	 * Campo para validacion de afectacion en base de datos para la actualizacion de los descuentos en Articulos.
	 */
	@Transient
	private Boolean actualizarDescuentosArticulos;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO clasificacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO proveedor;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO vistaProveedor;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioCreacion;
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioModificacion;
	
	@OneToMany(fetch = LAZY, mappedBy="proveedorClasificacion")
	private List<DescuentoProveedorClasificacionDTO> descuentosProveedorClasificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "VALORTIPOPLAZOPAGO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOPLAZOPAGO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO tipoPlazoPago;
	
	public ProveedorClasificacionDTO() {
		this.id = new ProveedorClasificacionID();
	}
	public ProveedorClasificacionDTO(Boolean initID) {
		this.id = new ProveedorClasificacionID(initID);
	}
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ProveedorClasificacionID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ProveedorClasificacionID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>estadoProveedorClasificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoProveedorClasificacion</code>
	 */
	public String getEstadoProveedorClasificacion() {
		return this.estadoProveedorClasificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoProveedorClasificacion</code>.
	 * 
	 * @param estadoProveedorClasificacion1
	 *            El valor a establecer para la propiedad <code>estadoProveedorClasificacion</code>.
	 */
	public void setEstadoProveedorClasificacion(String estadoProveedorClasificacion1) {
		this.estadoProveedorClasificacion = estadoProveedorClasificacion1;

		if (estadoProveedorClasificacion != null && estadoProveedorClasificacion.length() > 1) {
			estadoProveedorClasificacion = estadoProveedorClasificacion.substring(0, 1);
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
	 * Retorna valor de propiedad <code>proveedor</code>
	 * 
	 * @return Retorna valor de propiedad <code>proveedor</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO getProveedor() {
		return this.proveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>proveedor</code>.
	 * 
	 * @param proveedor1
	 *            El valor a establecer para la propiedad <code>proveedor</code>.
	 */
	public void setProveedor(ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO proveedor1) {
		this.proveedor = proveedor1;
	}

	/**
	 * @return the clasificacion
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO getClasificacion() {
		return clasificacion;
	}

	/**
	 * @param clasificacion
	 *            the clasificacion to set
	 */
	public void setClasificacion(ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO clasificacion) {
		this.clasificacion = clasificacion;
	}

	/**
	 * Retorna valor de propiedad <code>usuarioCreacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioCreacion</code>
	 */
	public UserDto getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioCreacion</code>.
	 * 
	 * @param usuarioCreacion1
	 *            El valor a establecer para la propiedad <code>usuarioCreacion</code>.
	 */
	public void setUsuarioCreacion(UserDto usuarioCreacion1) {
		this.usuarioCreacion = usuarioCreacion1;
	}

	/**
	 * Retorna valor de propiedad <code>usuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioModificacion</code>
	 */
	public UserDto getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioModificacion</code>.
	 * 
	 * @param usuarioModificacion1
	 *            El valor a establecer para la propiedad <code>usuarioModificacion</code>.
	 */
	public void setUsuarioModificacion(UserDto usuarioModificacion1) {
		this.usuarioModificacion = usuarioModificacion1;
	}
	public ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO getVistaProveedor() {
		return vistaProveedor;
	}
	public void setVistaProveedor(
			ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO vistaProveedor) {
		this.vistaProveedor = vistaProveedor;
	}
	/**
	 * @return the actualizarDescuentosArticulos
	 */
	public Boolean getActualizarDescuentosArticulos() {
		return (actualizarDescuentosArticulos != null ? actualizarDescuentosArticulos : Boolean.FALSE);
	}
	/**
	 * @param actualizarDescuentosArticulos the actualizarDescuentosArticulos to set
	 */
	public void setActualizarDescuentosArticulos(
			Boolean actualizarDescuentosArticulos) {
		this.actualizarDescuentosArticulos = actualizarDescuentosArticulos;
	}
	/**
	 * @return the descuentosProveedorClasificacion
	 */
	public List<DescuentoProveedorClasificacionDTO> getDescuentosProveedorClasificacion() {
		return descuentosProveedorClasificacion;
	}
	/**
	 * @param descuentosProveedorClasificacion the descuentosProveedorClasificacion to set
	 */
	public void setDescuentosProveedorClasificacion(
			List<DescuentoProveedorClasificacionDTO> descuentosProveedorClasificacion) {
		this.descuentosProveedorClasificacion = descuentosProveedorClasificacion;
	}
	
	public Boolean getTieneDescuentoProveedorClasificacion(){
		return isLoaded(this.descuentosProveedorClasificacion) && !this.descuentosProveedorClasificacion.isEmpty();
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
	/**
	 * @return the valorTipoPlazoPago
	 */
	public String getValorTipoPlazoPago() {
		return valorTipoPlazoPago;
	}
	/**
	 * @param valorTipoPlazoPago the valorTipoPlazoPago to set
	 */
	public void setValorTipoPlazoPago(String valorTipoPlazoPago) {
		this.valorTipoPlazoPago = valorTipoPlazoPago;
	}
	/**
	 * @return the codigoTipoPlazoPago
	 */
	public Integer getCodigoTipoPlazoPago() {
		return codigoTipoPlazoPago;
	}
	/**
	 * @param codigoTipoPlazoPago the codigoTipoPlazoPago to set
	 */
	public void setCodigoTipoPlazoPago(Integer codigoTipoPlazoPago) {
		this.codigoTipoPlazoPago = codigoTipoPlazoPago;
	}
	/**
	 * @return the tipoPlazoPago
	 */
	public CatalogoValorDTO getTipoPlazoPago() {
		return tipoPlazoPago;
	}
	/**
	 * @param tipoPlazoPago the tipoPlazoPago to set
	 */
	public void setTipoPlazoPago(CatalogoValorDTO tipoPlazoPago) {
		this.tipoPlazoPago = tipoPlazoPago;
	}
	/**
	 * @return the tipoPlazoPagoCodigoDescripcion
	 */
	public String getTipoPlazoPagoCodigoDescripcion() {
		if ( SearchDTO.isLoaded(this.tipoPlazoPago) )
			this.tipoPlazoPagoCodigoDescripcion = this.tipoPlazoPago.getValorNumerico().toString().concat(" - ").concat(this.tipoPlazoPago.getNombreCatalogoValor());
		return this.tipoPlazoPagoCodigoDescripcion;
	}
	/**
	 * @param tipoPlazoPagoCodigoDescripcion the tipoPlazoPagoCodigoDescripcion to set
	 */
	public void setTipoPlazoPagoCodigoDescripcion(String tipoPlazoPagoCodigoDescripcion) {
		if ( SearchDTO.isLoaded(this.tipoPlazoPago) )
			this.tipoPlazoPagoCodigoDescripcion = this.tipoPlazoPago.getValorNumerico().toString().concat(" - ").concat(this.tipoPlazoPago.getNombreCatalogoValor());
		else
			this.tipoPlazoPagoCodigoDescripcion = tipoPlazoPagoCodigoDescripcion;
			
	}

}
