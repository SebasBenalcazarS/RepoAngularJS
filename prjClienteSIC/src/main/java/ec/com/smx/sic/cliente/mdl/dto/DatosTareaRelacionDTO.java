
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
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;

/**
 * Almacena informacion referente a los datos de la tarea relacion 
 *
 * @author lguaman
 */
@SuppressWarnings({ "serial" })
@Entity
@Table(name="SBLOGTDATTARREL")
public class DatosTareaRelacionDTO extends SimpleAuditDTO {
	
	/**
	 * Clave primaria de la tabla DatosTareaRelacionDTO
	 *
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DatosTareaRelacionID id = new ec.com.smx.sic.cliente.mdl.dto.id.DatosTareaRelacionID();	

	/**
	 * Codigo datos tarea padre
	 * 
	 */
	@Column(name = "CODIGODATOSTAREA", nullable = false)	
	private java.lang.Long codigoDatosTarea;
	
	/**
	 * Codigo datos tarea relacionado
	 * 
	 */
	@Column(name = "CODIGODATOSTAREARELACIONADO", nullable = false)	
	private java.lang.Long codigoDatosTareaRelacionado;
	
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
	@Column
	@RegisterUserIdField
	private String idUsuarioRegistro ;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 *
	 */
	@Column
	@LastModificationDateField
	private java.util.Date fechaModificacion ;
	
	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 *
	 */
	@Column
	@LastModifierUserIdField
	private String idUsuarioModificacion ;
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 *
	 */
	@Column
	@ComparatorTypeField
	private String estado ;		
	
	/**
	 * Codigo del tipo de relacion
	 * 
	 */
	@Column
	private Integer codigoCatalogoRelacion;
	
	/**
	 * Valor del tipo relacion (Pallets Pesados Recepcion-PPR)
	 * 
	 */	
	@Column
	private String valorCatalogoRelacion;
			

	/**
	 * Referencia con la tabla datos tarea Padre
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGODATOSTAREA", referencedColumnName = "CODIGODATOSTAREA", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO datosTareaPadreDTO;
	
	/**
	 * Referencia con la tabla datos tarea Relacion
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGODATOSTAREARELACIONADO", referencedColumnName = "CODIGODATOSTAREA", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO datosTareaRelacionDTO;
	
	/**
	 * Referencia hacia el catalogo valor
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORCATALOGORELACION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOCATALOGORELACION", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO catalogoDatosTareaRelacion;		

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
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.DatosTareaRelacionID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ec.com.smx.sic.cliente.mdl.dto.id.DatosTareaRelacionID id1 ){
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
	 * @return the codigoCatalogoRelacion
	 */
	public Integer getCodigoCatalogoRelacion() {
		return codigoCatalogoRelacion;
	}

	/**
	 * @param codigoCatalogoRelacion the codigoCatalogoRelacion to set
	 */
	public void setCodigoCatalogoRelacion(Integer codigoCatalogoRelacion) {
		this.codigoCatalogoRelacion = codigoCatalogoRelacion;
	}

	/**
	 * @return the valorCatalogoRelacion
	 */
	public String getValorCatalogoRelacion() {
		return valorCatalogoRelacion;
	}

	/**
	 * @param valorCatalogoRelacion the valorCatalogoRelacion to set
	 */
	public void setValorCatalogoRelacion(String valorCatalogoRelacion) {
		this.valorCatalogoRelacion = valorCatalogoRelacion;
	}

	/**
	 * @return the datosTareaPadreDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO getDatosTareaPadreDTO() {
		return datosTareaPadreDTO;
	}

	/**
	 * @param datosTareaPadreDTO the datosTareaPadreDTO to set
	 */
	public void setDatosTareaPadreDTO(ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO datosTareaPadreDTO) {
		this.datosTareaPadreDTO = datosTareaPadreDTO;
	}

	/**
	 * @return the datosTareaRelacionDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO getDatosTareaRelacionDTO() {
		return datosTareaRelacionDTO;
	}

	/**
	 * @param datosTareaRelacionDTO the datosTareaRelacionDTO to set
	 */
	public void setDatosTareaRelacionDTO(ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO datosTareaRelacionDTO) {
		this.datosTareaRelacionDTO = datosTareaRelacionDTO;
	}

	/**
	 * @return the catalogoDatosTareaRelacion
	 */
	public CatalogoValorDTO getCatalogoDatosTareaRelacion() {
		return catalogoDatosTareaRelacion;
	}

	/**
	 * @param catalogoDatosTareaRelacion the catalogoDatosTareaRelacion to set
	 */
	public void setCatalogoDatosTareaRelacion(CatalogoValorDTO catalogoDatosTareaRelacion) {
		this.catalogoDatosTareaRelacion = catalogoDatosTareaRelacion;
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
	 * @return the codigoDatosTareaRelacionado
	 */
	public java.lang.Long getCodigoDatosTareaRelacionado() {
		return codigoDatosTareaRelacionado;
	}

	/**
	 * @param codigoDatosTareaRelacionado the codigoDatosTareaRelacionado to set
	 */
	public void setCodigoDatosTareaRelacionado(java.lang.Long codigoDatosTareaRelacionado) {
		this.codigoDatosTareaRelacionado = codigoDatosTareaRelacionado;
	}
	
		
}