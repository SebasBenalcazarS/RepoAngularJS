package ec.com.smx.sic.cliente.mdl.dto.sispe;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RelationField;
import ec.com.kruger.utilitario.dao.commons.annotations.RelationField.JoinType;
import ec.com.smx.framework.common.util.ConverterUtil;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.BaseID;

@SuppressWarnings("serial")
@MappedSuperclass
public class AuditoriaBaseDTO<T extends BaseID> extends BaseDTO<T>{
	
	/**
	 * usuario que realizo el registro del area de trabajo
	 *

	 */
	@RegisterUserIdField
	@Column(name="USUARIOREGISTRO")
	private String usuarioRegistro ;

	

	/**
	 * fecha en la que se creo el registro del area de trabajo
	 *

	 */
	@RegisterDateField
	private java.util.Date fechaRegistro ;

	

	/**
	 * usuario que realizo la ultima modificacion
	 *

	 */
	@LastModifierUserIdField
	@Column(name="USUARIOMODIFICACION")
	private String usuarioModificacion ;

	

	/**
	 * fecha de la ultima modificacion
	 *

	 */
	@LastModificationDateField
	private java.util.Date fechaModificacion ;
	
	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;



	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	@RelationField(joinType=JoinType.LEFT)
	private UserDto usuarioModificacionDTO;


	@Transient
	private Boolean selected = Boolean.FALSE;
	/**
	 * Retorna valor de propiedad <code>usuarioRegistro</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioRegistro</code>
	 */
	public String getUsuarioRegistro(){
		return this.usuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioRegistro</code>.
	 * @param usuarioRegistro1 
	 *		El valor a establecer para la propiedad <code>usuarioRegistro</code>.
	 */
	public void setUsuarioRegistro( String usuarioRegistro1 ){
		this.usuarioRegistro=usuarioRegistro1;
		
		if(usuarioRegistro!=null && usuarioRegistro.length()>32){
			usuarioRegistro = usuarioRegistro.substring(0,32);
		}
				
				
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
	 * Retorna propiedad <code>fechaRegistro</code> como String
	 * @return 
	 * 	Retorna propiedad <code>fechaRegistro</code> como String
	 */	
	public String getFechaRegistroS() {
		return (this.fechaRegistro!=null)?ConverterUtil.getYMDDateFormat().format(this.fechaRegistro):null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>fechaRegistro</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>fechaRegistro</code>.
	 */
	public void setFechaRegistroS(String cadena) {
		try{
			this.fechaRegistro = (cadena!=null)?ConverterUtil.getYMDDateFormat().parse(cadena):null;
		}catch(Exception ex){Logeable.LOG_SICV2.error(ex.getMessage());}
	}	
			

	/**
	 * Retorna valor de propiedad <code>usuarioModificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioModificacion</code>
	 */
	public String getUsuarioModificacion(){
		return this.usuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioModificacion</code>.
	 * @param usuarioModificacion1 
	 *		El valor a establecer para la propiedad <code>usuarioModificacion</code>.
	 */
	public void setUsuarioModificacion( String usuarioModificacion1 ){
		this.usuarioModificacion=usuarioModificacion1;
		
		if(usuarioModificacion!=null && usuarioModificacion.length()>32){
			usuarioModificacion = usuarioModificacion.substring(0,32);
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
	 * Retorna propiedad <code>fechaModificacion</code> como String
	 * @return 
	 * 	Retorna propiedad <code>fechaModificacion</code> como String
	 */	
	public String getFechaModificacionS() {
		return (this.fechaModificacion!=null)?ConverterUtil.getYMDDateFormat().format(this.fechaModificacion):null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>fechaModificacion</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>fechaModificacion</code>.
	 */
	public void setFechaModificacionS(String cadena) {
		try{
			this.fechaModificacion = (cadena!=null)?ConverterUtil.getYMDDateFormat().parse(cadena):null;
		}catch(Exception ex){Logeable.LOG_SICV2.error(ex.getMessage());}
	}

	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}

	public UserDto getUsuarioModificacionDTO() {
		return usuarioModificacionDTO;
	}

	public void setUsuarioModificacionDTO(UserDto usuarioModificacionDTO) {
		this.usuarioModificacionDTO = usuarioModificacionDTO;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}	
		
}
