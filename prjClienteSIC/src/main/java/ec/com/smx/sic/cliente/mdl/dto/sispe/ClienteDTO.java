
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import java.util.Collection;
import java.util.Date;

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
import ec.com.smx.framework.common.util.ConverterUtil;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ClienteRelacionadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ListaClientePedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.RecetaClientePedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.ClienteID;



/**
 * Entidad cliente, que representa los clientes tipo persona o empresa que est�n registrados en la base de datos corporativo.
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.ClienteDTO")
@Table(name = "SCSPETCLIPED")
public class ClienteDTO  extends SimpleAuditDTO {

	/**
	 * 
	 *
	 */
	@EmbeddedId
	private ClienteID id;

	/**
	 * codigoLocalizacion
	 *

	 */
	private java.lang.Long codigoLocalizacion ;

	/**
	 * C�digo de la persona cuanco un cliente es una persona
	 *

	 */
	private java.lang.Long codigoPersona ;
	
	/**
	 * campo usado en mi compra favorita
	 *

	 */
	private String usuarioId ;

	/**
	 * estadoClientePedido
	 *

	 */
	@ComparatorTypeField
	private String estadoClientePedido ;


	/**
	 * Usuario que realiz� el registro
	 *

	 */
	@RegisterUserIdField
	private String usuarioRegistro ;
	

	/**
	 * Fecha en la cual se realiza el registro
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
	 * Campo no persitenente 
	  
	 */
	@Transient
	private Double npTotalConsumo;
	
	@Transient
	private Date npFechaMaxima;
	@Transient
	private String vectorCupones;
	

	public Date getNpFechaMaxima() {
		return npFechaMaxima;
	}

	public void setNpFechaMaxima(Date npFechaMaxima) {
		this.npFechaMaxima = npFechaMaxima;
	}

	public Double getNpTotalConsumo() {
		return npTotalConsumo;
	}

	public void setNpTotalConsumo(Double npTotalConsumo) {
		this.npTotalConsumo = npTotalConsumo;
	}

	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOPERSONA", referencedColumnName = "CODIGOPERSONA", insertable = false, updatable = false)})
	private ec.com.smx.corpv2.dto.PersonaDTO personaDTO;


	/**
	 * usuario utilizado en mi compra favorita, relacionado con usuarioId
	 *
	 */
	@Transient
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioDTO;

	/**
	 * 
	 *
	 */
	@Transient
	private UserDto usuarioRegistroDTO;
	
	//////////////////////////////////////////////////////////////
	////	RELACIONS OBJETOS SIC (asistente de compras)    //////
	//////////////////////////////////////////////////////////////
//	@OneToMany(fetch=FetchType.LAZY,mappedBy="clienteDto")
//	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
//	private Collection<InscripcionNotificacionDTO> inscripcionNotificacionDtoCol;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="clienteDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ClienteRelacionadoDTO> clienteRelacionadoDtoCol;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="clienteInvitadoDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ClienteRelacionadoDTO> clienteListaRelacionadaInvitadoDtoCol;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="clienteDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ListaClientePedidoDTO> listaClientePedidoDtoCol;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="clienteDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<RecetaClientePedidoDTO> recetaClientePedidoDtoCol;

	//////////////////////////////////////////////////////////////
	//// FIN RELACIONS OBJETOS SIC (asistente de compras)    /////
	//////////////////////////////////////////////////////////////
	
	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOLOCALIZACION", referencedColumnName = "CODIGOLOCALIZACION", insertable = false, updatable = false) })
	private ec.com.smx.corpv2.dto.LocalizacionDTO localizacionDTO;

	
	//campos no persistentes
	@Transient
	private Boolean npCheckIndividual;

	/**
	 * 
	 *
	 */
	@Transient
	private UserDto usuarioModificacionDTO;



 
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ClienteID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ClienteID id1 ){
		this.id=id1;
	}


		
		

	/**
	 * Retorna valor de propiedad <code>codigoLocalizacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoLocalizacion</code>
	 */
	public java.lang.Long getCodigoLocalizacion(){
		return this.codigoLocalizacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoLocalizacion</code>.
	 * @param codigoLocalizacion1 
	 *		El valor a establecer para la propiedad <code>codigoLocalizacion</code>.
	 */
	public void setCodigoLocalizacion( java.lang.Long codigoLocalizacion1 ){
		this.codigoLocalizacion=codigoLocalizacion1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>codigoPersona</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoPersona</code>
	 */
	public java.lang.Long getCodigoPersona(){
		return this.codigoPersona;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoPersona</code>.
	 * @param codigoPersona1 
	 *		El valor a establecer para la propiedad <code>codigoPersona</code>.
	 */
	public void setCodigoPersona( java.lang.Long codigoPersona1 ){
		this.codigoPersona=codigoPersona1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>estadoClientePedido</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estadoClientePedido</code>
	 */
	public String getEstadoClientePedido(){
		return this.estadoClientePedido;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoClientePedido</code>.
	 * @param estadoClientePedido1 
	 *		El valor a establecer para la propiedad <code>estadoClientePedido</code>.
	 */
	public void setEstadoClientePedido( String estadoClientePedido1 ){
		this.estadoClientePedido=estadoClientePedido1;
		
		if(estadoClientePedido!=null && estadoClientePedido.length()>3){
			estadoClientePedido = estadoClientePedido.substring(0,3);
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
	 * @return Retorna propiedad fechaRegistro como String
	 */
	public String getFechaRegistroS() {
		return (this.fechaRegistro!=null)? ConverterUtil.getYMDDateFormat().format(this.fechaRegistro):null;
	}
	
	/**
	 * Permite establecer el valor de la propiedad fechaRegistro a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer fechaRegistro
	 */
	public void setFechaRegistroS(String cadena) {
		try{
			this.fechaRegistro = (cadena!=null)? ConverterUtil.getYMDDateFormat().parse(cadena):null;
		}catch(Exception ex){
			throw new SICException("No se puede convertir la fecha a cadena", ex);
		}
	}	
	

	/**
	 * @return Retorna valor de propiedad <code>usuarioModificacion</code>
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
		return (this.fechaModificacion!=null)? ConverterUtil.getYMDDateFormat().format(this.fechaModificacion):null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>fechaModificacion</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>fechaModificacion</code>.
	 */
	public void setFechaModificacionS(String cadena) {
		try{
			this.fechaModificacion = (cadena!=null)? ConverterUtil.getYMDDateFormat().parse(cadena):null;
		}catch(Exception ex){
			throw new SICException("No se puede cambiar la fecha de modificacion a cadena",ex);
		}
	}	
	
	
	/**
	 * Retorna valor de propiedad <code>persona</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>persona</code>
	 */
	public ec.com.smx.corpv2.dto.PersonaDTO getPersonaDTO(){
		return this.personaDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>persona</code>.
	 * @param persona1 
	 *		El valor a establecer para la propiedad <code>persona</code>.
	 */
	public void setPersonaDTO( ec.com.smx.corpv2.dto.PersonaDTO persona1 ){
		this.personaDTO=persona1;
	}


	/**
	 * Retorna valor de propiedad <code>usuario</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuario</code>
	 */
	public UserDto getUsuarioRegistroDTO(){
		return this.usuarioRegistroDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuario</code>.
	 * @param usuario1 
	 *		El valor a establecer para la propiedad <code>usuario</code>.
	 */
	public void setUsuarioRegistroDTO( UserDto usuario1 ){
		this.usuarioRegistroDTO = usuario1;
	}


	/**
	 * Retorna valor de propiedad <code>localizacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>localizacion</code>
	 */
	public ec.com.smx.corpv2.dto.LocalizacionDTO getLocalizacionDTO(){
		return this.localizacionDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>localizacion</code>.
	 * @param localizacion1 
	 *		El valor a establecer para la propiedad <code>localizacion</code>.
	 */
	public void setLocalizacionDTO( ec.com.smx.corpv2.dto.LocalizacionDTO localizacion1 ){
		this.localizacionDTO=localizacion1;
	}


	/**
	 * Retorna valor de propiedad <code>usuarioModificacionDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioModificacionDTO</code>
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioModificacionDTO(){
		return this.usuarioModificacionDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioModificacionDTO</code>.
	 * @param usuarioModificacionDTO1 
	 *		El valor a establecer para la propiedad <code>usuarioModificacionDTO</code>.
	 */
	public void setUsuarioModificacionDTO( ec.com.smx.frameworkv2.security.dto.UserDto usuarioModificacionDTO1 ){
		this.usuarioModificacionDTO=usuarioModificacionDTO1;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(ec.com.smx.frameworkv2.security.dto.UserDto usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public Boolean getNpCheckIndividual() {
		return npCheckIndividual;
	}

	public void setNpCheckIndividual(Boolean npCheckIndividual) {
		this.npCheckIndividual = npCheckIndividual;
	}

	public ClienteDTO() {
		this.id = new ClienteID();
	}

	public String getVectorCupones() {
		return vectorCupones;
	}

	public void setVectorCupones(String vectorCupones) {
		this.vectorCupones = vectorCupones;
	}

//	public Collection<InscripcionNotificacionDTO> getInscripcionNotificacionDtoCol() {
//		return inscripcionNotificacionDtoCol;
//	}
//
//	public void setInscripcionNotificacionDtoCol(Collection<InscripcionNotificacionDTO> inscripcionNotificacionDtoCol) {
//		this.inscripcionNotificacionDtoCol = inscripcionNotificacionDtoCol;
//	}

	public Collection<ClienteRelacionadoDTO> getClienteListaRelacionadaInvitadoDtoCol() {
		return clienteListaRelacionadaInvitadoDtoCol;
	}

	public void setClienteListaRelacionadaInvitadoDtoCol(Collection<ClienteRelacionadoDTO> clienteListaRelacionadaInvitadoDtoCol) {
		this.clienteListaRelacionadaInvitadoDtoCol = clienteListaRelacionadaInvitadoDtoCol;
	}


	public Collection<ListaClientePedidoDTO> getListaClientePedidoDtoCol() {
		return listaClientePedidoDtoCol;
	}

	public void setListaClientePedidoDtoCol(Collection<ListaClientePedidoDTO> listaClientePedidoDtoCol) {
		this.listaClientePedidoDtoCol = listaClientePedidoDtoCol;
	}

	public Collection<ClienteRelacionadoDTO> getClienteRelacionadoDtoCol() {
		return clienteRelacionadoDtoCol;
	}

	public void setClienteRelacionadoDtoCol(Collection<ClienteRelacionadoDTO> clienteRelacionadoDtoCol) {
		this.clienteRelacionadoDtoCol = clienteRelacionadoDtoCol;
	}

	/**
	 * @return the recetaClientePedidoDtoCol
	 */
	public Collection<RecetaClientePedidoDTO> getRecetaClientePedidoDtoCol() {
		return recetaClientePedidoDtoCol;
	}

	/**
	 * @param recetaClientePedidoDtoCol the recetaClientePedidoDtoCol to set
	 */
	public void setRecetaClientePedidoDtoCol(Collection<RecetaClientePedidoDTO> recetaClientePedidoDtoCol) {
		this.recetaClientePedidoDtoCol = recetaClientePedidoDtoCol;
	}
}
