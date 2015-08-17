package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * Entidad que almacena datos de la marca del proveedor
 *
 * @author acaiza
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTPROMAR")
public class ProveedorMarcaDTO extends SimpleAuditDTO{

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ProveedorMarcaID id = new ec.com.smx.sic.cliente.mdl.dto.id.ProveedorMarcaID();

	/**
	 * Estado
	 *
	 */
	@ComparatorTypeField
	private String estado ;
	

	/**
	 * Especifica el usuario que realiza el registro.
	 *
	 */
	@RegisterUserIdField
	private String idUsuarioRegistro ;
	

	/**
	 * Fecha en la que se realiza el registro
	 *
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro ;

	
	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 *
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion ;

	
	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 *
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion ;

	
	@Transient
	private Boolean selected;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="SECUENCIALMARCA", referencedColumnName="SECUENCIALMARCA", insertable=false, updatable=false)})
	private MarcaArticuloDTO marcaArticuloDTO;
	/**
	 * Proveedor de la Marca
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private ProveedorDTO proveedor;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private VistaProveedorDTO vistaProveedorDTO;
	
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ProveedorMarcaID getId(){
		return this.id;
	}

	
	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ec.com.smx.sic.cliente.mdl.dto.id.ProveedorMarcaID id1 ){
		this.id=id1;
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
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro(){
		return this.fechaRegistro;
	}

	
	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * @param fechaRegistro1 
	 *		El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro( java.sql.Timestamp fechaRegistro1 ){
		this.fechaRegistro=fechaRegistro1;
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
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion(){
		return this.fechaModificacion;
	}

	
	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * @param fechaModificacion1 
	 *		El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion( java.sql.Timestamp fechaModificacion1 ){
		this.fechaModificacion=fechaModificacion1;
	}

	
	/**
	 * Retorna valor de propiedad <code>proveedor</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>proveedor</code>
	 */
	public ProveedorDTO getProveedor(){
		return this.proveedor;
	}

	
	/**
	 * Establece un nuevo valor para la propiedad <code>proveedor</code>.
	 * @param proveedor1 
	 *		El valor a establecer para la propiedad <code>proveedor</code>.
	 */
	public void setProveedor( ProveedorDTO proveedor1 ){
		this.proveedor=proveedor1;
	}

	
	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado(){
		return this.estado;
	}

	
	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * @param estado1 
	 *		El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado( String estado1 ){
		this.estado=estado1;
		
		if(estado!=null && estado.length()>1){
			estado = estado.substring(0,1);
		}
	}

	
	public MarcaArticuloDTO getMarcaArticuloDTO() {
		return marcaArticuloDTO;
	}

	
	public void setMarcaArticuloDTO(MarcaArticuloDTO marcaArticuloDTO) {
		this.marcaArticuloDTO = marcaArticuloDTO;
	}

	
	public VistaProveedorDTO getVistaProveedorDTO() {
		return vistaProveedorDTO;
	}

	
	public void setVistaProveedorDTO(VistaProveedorDTO vistaProveedorDTO) {
		this.vistaProveedorDTO = vistaProveedorDTO;
	}


	public Boolean getSelected() {
		return selected;
	}


	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
}

