
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * Almacena informacion referente a la justificacion de comparacion de articulos
 *
 * @author lguaman
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTJUSTIFICACION")
public class JustificacionDTO extends SimpleAuditDTO {
	
	/**
	 * Clave primaria de la tabla Justificacion
	 *
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.JustificacionID id = new ec.com.smx.sic.cliente.mdl.dto.id.JustificacionID();

	/**
	 * Indica el nombre de la justificacion
	 *
	 */
	@Column
	private String nombre;	
	
	/**
	 * Indica la descripcion de la justicifacion
	 *
	 */
	@Column
	private String descripcion;
	
	@Column
	private String abreviatura;
	
	@Column(name = "CODIGOTIPOOPERACION", nullable = false)
	@ComparatorTypeField
	private Integer codigoTipoOperacion;

	@Column(name = "VALORTIPOOPERACION", nullable = false)
	private String valorTipoOperacion;
	
	@Transient
	private Integer cantidad;
	
	@Transient
	private Integer cantidadTotal;
	
	@Transient
	private Boolean asignado = Boolean.FALSE;
	
	@Transient
	private Long codigoNovedadArticuloJustificacion;
	
	@Column(name="CODIGOREFERENCIA")
	private String codigoReferencia;
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
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
	private java.util.Date fechaRegistro ;

	/**
	 * Especifica el usuario que realiza el registro.
	 *
	 */
	@Column(name="IDUSUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro ;

	/**
	 * Fecha en la que se realiz\u00F3 la ultima actualizaci\u00F3n.
	 *
	 */
	@Column
	@LastModificationDateField
	private java.util.Date fechaModificacion ;
		

	/**
	 * Id del usuario que realiz\u00F3 la  ultima actualizaci\u00F3n.
	 *
	*/
	@Column(name="IDUSUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioModificacion ;

	
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
	
	
	@OneToMany(mappedBy = "justificacionDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<JustificacionAreaTrabajoPerfilDTO> justificacionAreaTrabajoPerfilDTOCol;
	
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.JustificacionID getId(){
		return this.id;
	}
	
	
	/**
	 * Valor del tipo de novedad
	 * 
	 */	
	@Transient
	@Column(name="VALORTIPONOVEDAD")
	private String valorTipoNovedad;

	/**
	 * Codigo del tipo de novedad
	 * 
	 */
	@Transient
	@Column(name="CODIGOTIPONOVEDAD")
	private Integer codigoTipoNovedad;
	
	/**
	 * Referencia para el tipo de novedad
	 *
	 */
	@Transient
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPONOVEDAD", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPONOVEDAD", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoNovedadDTO;

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ec.com.smx.sic.cliente.mdl.dto.id.JustificacionID id1 ){
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the abreviatura
	 */
	public String getAbreviatura() {
		return abreviatura;
	}

	/**
	 * @param abreviatura the abreviatura to set
	 */
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	/**
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * @return the asignado
	 */
	public Boolean getAsignado() {
		return asignado;
	}

	/**
	 * @param asignado the asignado to set
	 */
	public void setAsignado(Boolean asignado) {
		this.asignado = asignado;
	}

	/**
	 * @return the cantidadTotal
	 */
	public Integer getCantidadTotal() {
		return cantidadTotal;
	}

	/**
	 * @param cantidadTotal the cantidadTotal to set
	 */
	public void setCantidadTotal(Integer cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	/**
	 * @return the codigoNovedadArticuloJustificacion
	 */
	public Long getCodigoNovedadArticuloJustificacion() {
		return codigoNovedadArticuloJustificacion;
	}

	/**
	 * @param codigoNovedadArticuloJustificacion the codigoNovedadArticuloJustificacion to set
	 */
	public void setCodigoNovedadArticuloJustificacion(Long codigoNovedadArticuloJustificacion) {
		this.codigoNovedadArticuloJustificacion = codigoNovedadArticuloJustificacion;
	}

	/**
	 * @return the valorTipoOperacion
	 */
	public String getValorTipoOperacion() {
		return valorTipoOperacion;
	}

	/**
	 * @param valorTipoOperacion the valorTipoOperacion to set
	 */
	public void setValorTipoOperacion(String valorTipoOperacion) {
		this.valorTipoOperacion = valorTipoOperacion;
	}

	/**
	 * @return the codigoTipoOperacion
	 */
	public Integer getCodigoTipoOperacion() {
		return codigoTipoOperacion;
	}

	/**
	 * @param codigoTipoOperacion the codigoTipoOperacion to set
	 */
	public void setCodigoTipoOperacion(Integer codigoTipoOperacion) {
		this.codigoTipoOperacion = codigoTipoOperacion;
	}

	/**
	 * @return the valorTipoNovedad
	 */
	public String getValorTipoNovedad() {
		return valorTipoNovedad;
	}

	/**
	 * @param valorTipoNovedad the valorTipoNovedad to set
	 */
	public void setValorTipoNovedad(String valorTipoNovedad) {
		this.valorTipoNovedad = valorTipoNovedad;
	}

	/**
	 * @return the codigoTipoNovedad
	 */
	public Integer getCodigoTipoNovedad() {
		return codigoTipoNovedad;
	}

	/**
	 * @param codigoTipoNovedad the codigoTipoNovedad to set
	 */
	public void setCodigoTipoNovedad(Integer codigoTipoNovedad) {
		this.codigoTipoNovedad = codigoTipoNovedad;
	}

	/**
	 * @return the tipoNovedadDTO
	 */
	public CatalogoValorDTO getTipoNovedadDTO() {
		return tipoNovedadDTO;
	}

	/**
	 * @param tipoNovedadDTO the tipoNovedadDTO to set
	 */
	public void setTipoNovedadDTO(CatalogoValorDTO tipoNovedadDTO) {
		this.tipoNovedadDTO = tipoNovedadDTO;
	}

	/**
	 * @return the justificacionAreaTrabajoPerfilDTOCol
	 */
	public Collection<JustificacionAreaTrabajoPerfilDTO> getJustificacionAreaTrabajoPerfilDTOCol() {
		return justificacionAreaTrabajoPerfilDTOCol;
	}

	/**
	 * @param justificacionAreaTrabajoPerfilDTOCol the justificacionAreaTrabajoPerfilDTOCol to set
	 */
	public void setJustificacionAreaTrabajoPerfilDTOCol(Collection<JustificacionAreaTrabajoPerfilDTO> justificacionAreaTrabajoPerfilDTOCol) {
		this.justificacionAreaTrabajoPerfilDTOCol = justificacionAreaTrabajoPerfilDTOCol;
	}
	
}