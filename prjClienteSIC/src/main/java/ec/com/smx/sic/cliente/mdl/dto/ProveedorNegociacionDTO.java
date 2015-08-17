package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorNegociacionID;

/**
 * Entidad que almacena datos sobre la negociacion que tiene la Corporación con el proveedor
 *
 * @author kruger
 */
@Entity
@Table(name="SCSADTPRONEG")
public class ProveedorNegociacionDTO extends SimpleAuditDTO{



	/**
	 * 
	 *
	 */
	@EmbeddedId
	private ProveedorNegociacionID id = new ProveedorNegociacionID();


		
		

	/**
	 * Estado que indica si se debe cobrar un espacio en percha o no.
Los valores permitidos son:
[0] Inactivo
[1] Activo
	 *

	 */
	private String estadoCobroEspacioPercha ;

	

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
	 * Id del usuario que realizó la última actualización.
	 *

	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion ;

	

	/**
	 * Fecha en la que se realizó la última actualización.
	 *

	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion ;

	

	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private ProveedorDTO proveedor;



	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioCreacion;



	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioModificacion;



 
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ProveedorNegociacionID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ProveedorNegociacionID id1 ){
		this.id=id1;
	}


		
		

	/**
	 * Retorna valor de propiedad <code>estadoCobroEspacioPercha</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estadoCobroEspacioPercha</code>
	 */
	public String getEstadoCobroEspacioPercha(){
		return this.estadoCobroEspacioPercha;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoCobroEspacioPercha</code>.
	 * @param estadoCobroEspacioPercha1 
	 *		El valor a establecer para la propiedad <code>estadoCobroEspacioPercha</code>.
	 */
	public void setEstadoCobroEspacioPercha( String estadoCobroEspacioPercha1 ){
		this.estadoCobroEspacioPercha=estadoCobroEspacioPercha1;
		
		if(estadoCobroEspacioPercha!=null && estadoCobroEspacioPercha.length()>1){
			estadoCobroEspacioPercha = estadoCobroEspacioPercha.substring(0,1);
		}
				
				
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
	 * Retorna valor de propiedad <code>usuarioCreacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioCreacion</code>
	 */
	public UserDto getUsuarioCreacion(){
		return this.usuarioCreacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioCreacion</code>.
	 * @param usuarioCreacion1 
	 *		El valor a establecer para la propiedad <code>usuarioCreacion</code>.
	 */
	public void setUsuarioCreacion( UserDto usuarioCreacion1 ){
		this.usuarioCreacion=usuarioCreacion1;
	}


	/**
	 * Retorna valor de propiedad <code>usuarioModificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioModificacion</code>
	 */
	public UserDto getUsuarioModificacion(){
		return this.usuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioModificacion</code>.
	 * @param usuarioModificacion1 
	 *		El valor a establecer para la propiedad <code>usuarioModificacion</code>.
	 */
	public void setUsuarioModificacion(UserDto usuarioModificacion1 ){
		this.usuarioModificacion=usuarioModificacion1;
	}


}


