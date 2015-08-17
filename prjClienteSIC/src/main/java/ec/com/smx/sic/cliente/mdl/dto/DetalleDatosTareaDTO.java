
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * Almacena informacion referente al detalle de los datos de la tarea 
 *
 * @author lguaman
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTDETDATTAR")
public class DetalleDatosTareaDTO extends SimpleAuditDTO {
	
	/**
	 * Clave primaria de la tabla DetalleDatosTarea
	 *
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DetalleDatosTareaID id = new ec.com.smx.sic.cliente.mdl.dto.id.DetalleDatosTareaID();

	/**
	 * clave foranea hacia la tabla datos tarea.
	 *
	 */
	@Column
	private java.lang.Long codigoDatosTarea ;
	
	/**
	 * Codigo de OrdenTrabajoDetalleEstadoDTO
	 */
	@Column 
	private java.lang.Long codigoOrdenCompraDetalleEstado;
	
	/**
	 * Cantidad de articulos que estan en el contenedor
	 */
	@Column 
	private Integer cantidad;
	
	/**
	 * Peso total que se recibio en el pallet
	 */
	@Column 
	private BigDecimal peso;
	
	/**
	 * Peso aproximado con el que se recibio el pallet
	 */
	@Column 
	private BigDecimal pesoAproximado;
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 *
	 */
	@Column
	@ComparatorTypeField
	private String estado ;
	
	/**
	 * Fecha en la que se realiza el registro
	 *
	 */
	@Column
	@RegisterDateField
	private java.util.Date fechaRegistro ;

	/**
	 * Especifica el usuario que realiza el registro.
	 *
	 */
	@Column(name="IDUSUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro ;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 *
	 */
	@Column
	@LastModificationDateField
	private java.util.Date fechaModificacion ;
		

	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 *
	*/
	@Column(name="IDUSUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioModificacion ;

	/**
	 * Referencia con la tabla DatosTarea
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGODATOSTAREA", referencedColumnName = "CODIGODATOSTAREA", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO datosTarea;


	/**
	 * Referencia con la tabla User
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla User
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioModificacion;

	/**
	 * Referencia con la tabla OrdenCompraDetalleEstado
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOORDENCOMPRADETALLEESTADO", referencedColumnName = "CODIGOORDENCOMPRADETALLEESTADO", insertable = false, updatable = false)})
	private OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO;

 
	/**
	 * @return the ordenCompraDetalleEstadoDTO
	 */
	public OrdenCompraDetalleEstadoDTO getOrdenCompraDetalleEstadoDTO() {
		return ordenCompraDetalleEstadoDTO;
	}

	/**
	 * @param ordenCompraDetalleEstadoDTO the ordenCompraDetalleEstadoDTO to set
	 */
	public void setOrdenCompraDetalleEstadoDTO(
			OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO) {
		this.ordenCompraDetalleEstadoDTO = ordenCompraDetalleEstadoDTO;
	}

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.DetalleDatosTareaID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ec.com.smx.sic.cliente.mdl.dto.id.DetalleDatosTareaID id1 ){
		this.id=id1;
	}
		
	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.util.Date getFechaRegistro(){
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * @param fechaRegistro1 
	 *		El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro( java.util.Date fechaRegistro1 ){
		this.fechaRegistro=fechaRegistro1;
		
	}	

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro(){
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * @param idUsuarioRegistro1 
	 *		El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro( String idUsuarioRegistro1 ){
		this.idUsuarioRegistro=idUsuarioRegistro1;
		
		if(idUsuarioRegistro!=null && idUsuarioRegistro.length()>32){
			idUsuarioRegistro = idUsuarioRegistro.substring(0,32);
		}		
	}


	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.util.Date getFechaModificacion(){
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * @param fechaModificacion1 
	 *		El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion( java.util.Date fechaModificacion1 ){
		this.fechaModificacion=fechaModificacion1;
		
	}


	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion(){
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * @param idUsuarioModificacion1 
	 *		El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion( String idUsuarioModificacion1 ){
		this.idUsuarioModificacion=idUsuarioModificacion1;
		
		if(idUsuarioModificacion!=null && idUsuarioModificacion.length()>32){
			idUsuarioModificacion = idUsuarioModificacion.substring(0,32);
		}
					
	}		

	/**
	 * Retorna valor de propiedad <code>usuarioCreacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioCreacion</code>
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion(){
		return this.usuarioCreacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioCreacion</code>.
	 * @param usuarioCreacion1 
	 *		El valor a establecer para la propiedad <code>usuarioCreacion</code>.
	 */
	public void setUsuarioCreacion( ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion1 ){
		this.usuarioCreacion=usuarioCreacion1;
	}


	/**
	 * Retorna valor de propiedad <code>usuarioModificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioModificacion</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioModificacion(){
		return this.usuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioModificacion</code>.
	 * @param usuarioModificacion1 
	 *		El valor a establecer para la propiedad <code>usuarioModificacion</code>.
	 */
	public void setUsuarioModificacion( ec.com.smx.framework.security.dto.UserDto usuarioModificacion1 ){
		this.usuarioModificacion=usuarioModificacion1;
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
	 * @return the codigoDatosTarea
	 */
	public java.lang.Long getCodigoDatosTarea() {
		return codigoDatosTarea;
	}

	/**
	 * @param codigoDatosTarea the codigoDatosTarea to set
	 */
	public void setCodigoDatosTarea(java.lang.Long codigoDatosTarea) {
		this.codigoDatosTarea = codigoDatosTarea;
	}

	/**
	 * @return the codigoOrdenCompraDetalleEstado
	 */
	public java.lang.Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}

	/**
	 * @param codigoOrdenCompraDetalleEstado the codigoOrdenCompraDetalleEstado to set
	 */
	public void setCodigoOrdenCompraDetalleEstado(java.lang.Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the datosTarea
	 */
	public ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO getDatosTarea() {
		return datosTarea;
	}

	/**
	 * @param datosTarea the datosTarea to set
	 */
	public void setDatosTarea(ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO datosTarea) {
		this.datosTarea = datosTarea;
	}

	/**
	 * @return the peso
	 */
	public BigDecimal getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	/**
	 * @return the pesoAproximado
	 */
	public BigDecimal getPesoAproximado() {
		return pesoAproximado;
	}

	/**
	 * @param pesoAproximado the pesoAproximado to set
	 */
	public void setPesoAproximado(BigDecimal pesoAproximado) {
		this.pesoAproximado = pesoAproximado;
	}
	
}