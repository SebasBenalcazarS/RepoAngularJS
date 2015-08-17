
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.framework.common.util.ConverterUtil;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.EntregaPedidoEspecialConvenioID;


/**
 * Tabla de ruptura entre EntregaPedido del SISPE y ConvenioEntregaDomicilio del SICMER
 *
 * @author bgudino
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.EntregaPedidoEspecialConvenioDTO")
@Table(name = "SCSPETENTPEDCON")
public class EntregaPedidoEspecialConvenioDTO extends SimpleAuditDTO{



	/**
	 * Clave primaria
	 *
	 */
	@EmbeddedId
	private EntregaPedidoEspecialConvenioID id;


		
	/**
	 * codigoEntregaPedido
	 *

	 */
	private Long codigoEntregaPedido ;

	

	/**
	 * secuencialConvenio
	 *

	 */
	private Long secuencialConvenio ;
	
	
	/**
	 * estado, posibles valores: 1(activo), 0(inactivo)
	 *

	 */
	private String estado ;
	
	
	
	/**
	 * usuarioRegistro
	 *

	 */
	@RegisterUserIdField
	private String usuarioRegistro ;

	

	/**
	 * fechaRegistro
	 *

	 */
	@RegisterDateField
	private java.util.Date fechaRegistro ;

	

	/**
	 * usuarioModificacion
	 *

	 */
	@LastModifierUserIdField
	private String usuarioModificacion ;

	

	/**
	 * fechaModificacion
	 *

	 */
	@LastModificationDateField
	private java.util.Date fechaModificacion ;

	
	
	/**
	 * Estado del inventario, posibles valores: 1(activo), 0(inactivo)
	 *
	 */
	private String estadoInventario ;
	

	/**
	 * entregaPedidoDTO
	 *
	 */
//	private EntregaPedidoEspecialDTO entregaPedidoDTO;



	/**
	 * 
	 *
	 */
//	private ConvenioEntregaDomicilioDTO convenioEntregaDomicilioDTO;


	/**
	 * usuarioRegistroDTO
	 *
	 */
	@Transient
	private UserDto usuarioRegistroDTO;



	/**
	 * usuarioModificacionDTO
	 *
	 */
	@Transient
	private UserDto usuarioModificacionDTO;

 
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public EntregaPedidoEspecialConvenioID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(EntregaPedidoEspecialConvenioID id1 ){
		this.id=id1;
	}


	/**
	 * Retorna valor de propiedad <code>codigoEntregaPedido</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoEntregaPedido</code>
	 */
	public Long getCodigoEntregaPedido(){
		return this.codigoEntregaPedido;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoEntregaPedido</code>.
	 * @param codigoEntregaPedido1 
	 *		El valor a establecer para la propiedad <code>codigoEntregaPedido</code>.
	 */
	public void setCodigoEntregaPedido( Long codigoEntregaPedido1 ){
		this.codigoEntregaPedido=codigoEntregaPedido1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>secuencialConvenio</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>secuencialConvenio</code>
	 */
	public Long getSecuencialConvenio(){
		return this.secuencialConvenio;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>secuencialConvenio</code>.
	 * @param secuencialConvenio1 
	 *		El valor a establecer para la propiedad <code>secuencialConvenio</code>.
	 */
	public void setSecuencialConvenio( Long secuencialConvenio1 ){
		this.secuencialConvenio=secuencialConvenio1;
		
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
	public Date getFechaRegistro(){
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * @param fechaRegistro1 
	 *		El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro( Date fechaRegistro1 ){
		this.fechaRegistro=fechaRegistro1;
		
	}

		
	/**
	 * Retorna propiedad <code>fechaRegistro</code> como String
	 * @return 
	 * 	Retorna propiedad <code>fechaRegistro</code> como String
	 */
	public String getFechaRegistroS() {
		return (this.fechaRegistro!=null)? ConverterUtil.getYMDDateFormat().format(this.fechaRegistro):null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>fechaRegistro</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>fechaRegistro</code>.
	 */
	public void setFechaRegistroS(String cadena) {
		try{
			this.fechaRegistro = (cadena!=null)? ConverterUtil.getYMDDateFormat().parse(cadena):null;
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
	public Date getFechaModificacion(){
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * @param fechaModificacion1 
	 *		El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion( Date fechaModificacion1 ){
		this.fechaModificacion=fechaModificacion1;
		
	}

		
	/**
	 * Retorna propiedad <code>fechaModificacion</code> como String
	 * @return 
	 * 	Retorna propiedad <code>fechaModificacion</code> como String
	 */
	public String getFechaModificacionS() {
		return (this.fechaModificacion!=null)? ConverterUtil.getYMDDateFormat().format(this.fechaModificacion):null;
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
	
	
	/**
	 * Retorna valor de propiedad <code>estadoInventario</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estadoInventario</code>
	 */
	public String getEstadoInventario(){
		return this.estadoInventario;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoInventario</code>.
	 * @param estadoInventario1 
	 *		El valor a establecer para la propiedad <code>estadoInventario</code>.
	 */
	public void setEstadoInventario( String estadoInventario1 ){
		this.estadoInventario=estadoInventario1;
		
		if(estadoInventario!=null && estadoInventario.length()>1){
			estadoInventario = estadoInventario.substring(0,1);
		}
	}
		

//	/**
//	 * Retorna valor de propiedad <code>entregaPedidoDTO</code>
//	 * @return 
//	 * 		Retorna valor de propiedad <code>entregaPedidoDTO</code>
//	 */
//	public EntregaPedidoEspecialDTO getEntregaPedidoDTO(){
//		return this.entregaPedidoDTO;
//	}
//
//	/**
//	 * Establece un nuevo valor para la propiedad <code>entregaPedidoDTO</code>.
//	 * @param entregaPedidoDTO1 
//	 *		El valor a establecer para la propiedad <code>entregaPedidoDTO</code>.
//	 */
//	public void setEntregaPedidoDTO( EntregaPedidoEspecialDTO entregaPedidoDTO1 ){
//		this.entregaPedidoDTO=entregaPedidoDTO1;
//	}


//	/**
//	 * Retorna valor de propiedad <code>convenioEntregaDomicilio</code>
//	 * @return 
//	 * 		Retorna valor de propiedad <code>ConvenioEntregaDomicilioDTO</code>
//	 */
//	public ConvenioEntregaDomicilioDTO getConvenioEntregaDomicilioDTO(){
//		return this.convenioEntregaDomicilioDTO;
//	}
//
//	/**
//	 * Establece un nuevo valor para la propiedad <code>ConvenioEntregaDomicilioDTO</code>.
//	 * @param convenioEntregaDomicilioDTO1 
//	 *		El valor a establecer para la propiedad <code>ConvenioEntregaDomicilioDTO</code>.
//	 */
//	public void setConvenioEntregaDomicilioDTO( ConvenioEntregaDomicilioDTO convenioEntregaDomicilioDTO1 ){
//		this.convenioEntregaDomicilioDTO=convenioEntregaDomicilioDTO1;
//	}

	/**
	 * Retorna valor de propiedad <code>usuarioRegistroDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioRegistroDTO</code>
	 */
	public UserDto getUsuarioRegistroDTO(){
		return this.usuarioRegistroDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioRegistroDTO</code>.
	 * @param usuarioRegistroDTO1 
	 *		El valor a establecer para la propiedad <code>usuarioRegistroDTO</code>.
	 */
	public void setUsuarioRegistroDTO( UserDto usuarioRegistroDTO1 ){
		this.usuarioRegistroDTO=usuarioRegistroDTO1;
	}


	/**
	 * Retorna valor de propiedad <code>usuarioModificacionDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioModificacionDTO</code>
	 */
	public UserDto getUsuarioModificacionDTO(){
		return this.usuarioModificacionDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioModificacionDTO</code>.
	 * @param usuarioModificacionDTO1 
	 *		El valor a establecer para la propiedad <code>usuarioModificacionDTO</code>.
	 */
	public void setUsuarioModificacionDTO( UserDto usuarioModificacionDTO1 ){
		this.usuarioModificacionDTO=usuarioModificacionDTO1;
	}
	public EntregaPedidoEspecialConvenioDTO(){
		this.id=new EntregaPedidoEspecialConvenioID();
	}
}

