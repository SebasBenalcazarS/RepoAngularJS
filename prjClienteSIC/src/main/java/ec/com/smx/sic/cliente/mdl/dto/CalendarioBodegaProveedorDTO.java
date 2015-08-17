
package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Time;
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

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.framework.common.util.ConverterUtil;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.id.CalendarioBodegaProveedorID;

/**
 * 
 * @author kruger
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTCALBODPRO")
public class CalendarioBodegaProveedorDTO extends SimpleAuditDTO{


	/**
	 * Clave primaria de la tabla Entrega
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.CalendarioBodegaProveedorID id = new ec.com.smx.sic.cliente.mdl.dto.id.CalendarioBodegaProveedorID();
	
	/**
	 * codigo bodega
	 *

	 */
	@ComparatorTypeField
	@Column
	private String codigoBodega ;

	

	/**
	 * codigo proveedor
	 *

	 */
	@ComparatorTypeField
	@Column
	private String codigoProveedor ;

	

	/**
	 * hora inicio
	 *

	 */
	@Column
	private Time horaInicio ;

	

	/**
	 * hora fin
	 *

	 */
	@Column
	private Time horaFin ;

	

	/**
	 * cantidad anden
	 *

	 */
	@Column
	private Integer cantidadAnden ;

	

	/**
	 * dia semana
	 *

	 */
	@Column
	private Integer diaSemana ;

	

	/**
	 * estado, valores: 1(Activo), 0(Inactivo)
	 *

	 */
	@ComparatorTypeField
	@Column
	private String estado ;
	
	/**
	 * estado, valores: 1(Activo), 0(Inactivo)
	 *

	 */
	@OneToMany(mappedBy = "calendarioBodegaProveedorDTO")
	private Collection<EntregaCalendarioBodegaProveedorDTO> calendarioBodegaEntregaProveedorCol ;

	

	/**
	 * usuario registro
	 *

	 */
	@RegisterUserIdField
	private String usuarioRegistro ;

	

	/**
	 * fecha registro
	 *

	 */
	@RegisterDateField
	private java.util.Date fechaRegistro ;

	

	/**
	 * usuario modificacion
	 *

	 */
	@LastModifierUserIdField
	private String usuarioModificacion ;

	

	/**
	 * fecha modificacion 
	 *

	 */
	@LastModificationDateField
	private java.util.Date fechaModificacion ;

	
	/**
	 * usuarioRegistroDTO
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;

	
	/**
	 * usuarioModificacionDTO
	 *
	 */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioModificacionDTO;

	/**
	 * bodegaDTO
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOBODEGA", referencedColumnName = "CODIGOBODEGA", insertable = false, updatable = false) })
	private BodegaDTO bodegaDTO;
	


	/**
	 * proveedorDTO
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false) })
	private ProveedorDTO proveedorDTO;

	/**
	 * Retorna valor de propiedad <code>codigoBodega</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoBodega</code>
	 */
	public String getCodigoBodega(){
		return this.codigoBodega;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoBodega</code>.
	 * @param codigoBodega1 
	 *		El valor a establecer para la propiedad <code>codigoBodega</code>.
	 */
	public void setCodigoBodega( String codigoBodega1 ){
		this.codigoBodega=codigoBodega1;
		
		if(codigoBodega!=null && codigoBodega.length()>10){
			codigoBodega = codigoBodega.substring(0,10);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>codigoProveedor</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoProveedor</code>
	 */
	public String getCodigoProveedor(){
		return this.codigoProveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoProveedor</code>.
	 * @param codigoProveedor1 
	 *		El valor a establecer para la propiedad <code>codigoProveedor</code>.
	 */
	public void setCodigoProveedor( String codigoProveedor1 ){
		this.codigoProveedor=codigoProveedor1;
		
		if(codigoProveedor!=null && codigoProveedor.length()>10){
			codigoProveedor = codigoProveedor.substring(0,10);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>horaInicio</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>horaInicio</code>
	 */
	public Time getHoraInicio(){
		return this.horaInicio;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>horaInicio</code>.
	 * @param horaInicio1 
	 *		El valor a establecer para la propiedad <code>horaInicio</code>.
	 */
	public void setHoraInicio( Time horaInicio1 ){
		this.horaInicio=horaInicio1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>horaFin</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>horaFin</code>
	 */
	public Time getHoraFin(){
		return this.horaFin;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>horaFin</code>.
	 * @param horaFin1 
	 *		El valor a establecer para la propiedad <code>horaFin</code>.
	 */
	public void setHoraFin( Time horaFin1 ){
		this.horaFin=horaFin1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>cantidadAnden</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>cantidadAnden</code>
	 */
	public Integer getCantidadAnden(){
		return this.cantidadAnden;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cantidadAnden</code>.
	 * @param cantidadAnden1 
	 *		El valor a establecer para la propiedad <code>cantidadAnden</code>.
	 */
	public void setCantidadAnden( Integer cantidadAnden1 ){
		this.cantidadAnden=cantidadAnden1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>diaSemana</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>diaSemana</code>
	 */
	public Integer getDiaSemana(){
		return this.diaSemana;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>diaSemana</code>.
	 * @param diaSemana1 
	 *		El valor a establecer para la propiedad <code>diaSemana</code>.
	 */
	public void setDiaSemana( Integer diaSemana1 ){
		this.diaSemana=diaSemana1;
		
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
		return (this.fechaRegistro != null) ? ConverterUtil.getYMDDateFormat() .format(this.fechaRegistro) : null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>fechaRegistro</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>fechaRegistro</code>.
	 */
	public void setFechaRegistroS(String cadena) throws SICException{
		try {
			this.fechaRegistro = (cadena != null) ? ConverterUtil.getYMDDateFormat().parse(cadena) : null;
		} catch (Exception ex) {
			throw new SICException(ex);
		}
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
		return (this.fechaModificacion != null) ? ConverterUtil.getYMDDateFormat().format(this.fechaModificacion) : null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>fechaModificacion</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>fechaModificacion</code>.
	 */
	public void setFechaModificacionS(String cadena) throws SICException{
		try {
			this.fechaModificacion = (cadena != null) ? ConverterUtil.getYMDDateFormat().parse(cadena) : null;
		} catch (Exception ex) {
			throw new SICException(ex);
		}
	}		

	/**
	 * Retorna valor de propiedad <code>bodegaDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>bodegaDTO</code>
	 */
	public BodegaDTO getBodegaDTO(){
		return this.bodegaDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>bodegaDTO</code>.
	 * @param bodegaDTO1 
	 *		El valor a establecer para la propiedad <code>bodegaDTO</code>.
	 */
	public void setBodegaDTO( BodegaDTO bodegaDTO1 ){
		this.bodegaDTO=bodegaDTO1;
	}


	/**
	 * Retorna valor de propiedad <code>proveedorDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>proveedorDTO</code>
	 */
	public ProveedorDTO getProveedorDTO(){
		return this.proveedorDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>proveedorDTO</code>.
	 * @param proveedorDTO1 
	 *		El valor a establecer para la propiedad <code>proveedorDTO</code>.
	 */
	public void setProveedorDTO( ProveedorDTO proveedorDTO1 ){
		this.proveedorDTO=proveedorDTO1;
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

	public Collection<EntregaCalendarioBodegaProveedorDTO> getCalendarioBodegaEntregaProveedorCol() {
		return calendarioBodegaEntregaProveedorCol;
	}

	public void setCalendarioBodegaEntregaProveedorCol(Collection<EntregaCalendarioBodegaProveedorDTO> calendarioBodegaEntregaProveedorCol) {
		this.calendarioBodegaEntregaProveedorCol = calendarioBodegaEntregaProveedorCol;
	}

	/**
	 * @return the id
	 */
	public CalendarioBodegaProveedorID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(CalendarioBodegaProveedorID id) {
		this.id = id;
	}
	
	
}

