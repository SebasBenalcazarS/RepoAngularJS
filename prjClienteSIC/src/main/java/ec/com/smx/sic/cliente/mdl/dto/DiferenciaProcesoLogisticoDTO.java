
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

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * Almacena informacion referente a la diferencia de cantidades recibidas de los articulos
 * 
 * 1.- Verifica la diferencia de cantidades que existe entre las cantidades recibidas vs las cantidades facturadas o  las cantidades recibidas vs las cantidades planificadas
 *
 * @author lguaman
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTDIFPROLOG")
public class DiferenciaProcesoLogisticoDTO extends SimpleAuditDTO {
	
	/**
	 * Clave primaria de la tabla DiferenciaProcesoLogistico
	 *
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DiferenciaProcesoLogisticoID id = new ec.com.smx.sic.cliente.mdl.dto.id.DiferenciaProcesoLogisticoID();

	/**
	 * clave foranea hacia la tabla justificacion.
	 *
	 */
	@Column
	private java.lang.Long codigoJustificacion ;
	
	/**
	 * Codigo de OrdenCompraDetalleEstadoDTO
	 */
	@Column (name = "CODIGOORDENCOMPRADETALLEESTADO", nullable = false)
	private java.lang.Long codigoOrdenCompraDetalleEstado;
	
	/**
	 * Codigo de OrdenCompraDetalleEstadoDTO para la diferencia
	 */
	@Column (name = "CODIGOORDENCOMPRADETALLEESTADODIFERENCIA", nullable = false)
	private java.lang.Long codigoOrdenCompraDetalleEstadoDiferencia;
	
	/**
	 * clave foranea hacia la tabla detalle factura estado.
	 *
	 */
	@Column
	private Long codigoDetalleFacturaEstado ;
	
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
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 *
	 */
	@Column
	@LastModificationDateField
	private java.util.Date fechaModificacion ;
		

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 *
	*/
	@Column(name="IDUSUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioModificacion ;

	
	/**
	 * Variable para identificar si la diferencia es editable, 
	 * valores: 0 (editable), 1 (no editable)
	 */
	@Column(name = "EDITABLE")
	private String editable ;
	
	
	/**
	 * Atributo donde se guardan las entregas del proceso de validacion
	 */
	@Column(name = "ENTREGAS")
	private String entregas;
	
	/**
	 * Referencia con la tabla Justificacion
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOJUSTIFICACION", referencedColumnName = "CODIGOJUSTIFICACION", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.JustificacionDTO justificacion;
	
	/**
	 * Especifica el detalle del articulo recibido
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGODETALLEFACTURAESTADO", referencedColumnName = "CODIGODETALLEFACTURAESTADO", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO detalleFacturaEstado;


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
	 * Especifica el detalle del articulo esperado
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOORDENCOMPRADETALLEESTADO", referencedColumnName = "CODIGOORDENCOMPRADETALLEESTADO", insertable = false, updatable = false)})
	private OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstado;

	/**
	 * Especifica el detalle del articulo recibido
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOORDENCOMPRADETALLEESTADODIFERENCIA", referencedColumnName = "CODIGOORDENCOMPRADETALLEESTADO", insertable = false, updatable = false)})
	private OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDiferencia;
	
	/**
	 * @return the ordenCompraDetalleEstadoDTO
	 */
	public OrdenCompraDetalleEstadoDTO getOrdenCompraDetalleEstado() {
		return ordenCompraDetalleEstado;
	}

	/**
	 * @param ordenCompraDetalleEstadoDTO the ordenCompraDetalleEstadoDTO to set
	 */
	public void setOrdenCompraDetalleEstadoDTO(
			OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO) {
		this.ordenCompraDetalleEstado = ordenCompraDetalleEstadoDTO;
	}

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.DiferenciaProcesoLogisticoID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ec.com.smx.sic.cliente.mdl.dto.id.DiferenciaProcesoLogisticoID id1 ){
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

	/**
	 * @return the codigoJustificacion
	 */
	public java.lang.Long getCodigoJustificacion() {
		return codigoJustificacion;
	}

	/**
	 * @param codigoJustificacion the codigoJustificacion to set
	 */
	public void setCodigoJustificacion(java.lang.Long codigoJustificacion) {
		this.codigoJustificacion = codigoJustificacion;
	}

	/**
	 * @return the codigoDetalleFacturaEstado
	 */
	public Long getCodigoDetalleFacturaEstado() {
		return codigoDetalleFacturaEstado;
	}

	/**
	 * @param codigoDetalleFacturaEstado the codigoDetalleFacturaEstado to set
	 */
	public void setCodigoDetalleFacturaEstado(Long codigoDetalleFacturaEstado) {
		this.codigoDetalleFacturaEstado = codigoDetalleFacturaEstado;
	}

	/**
	 * @return the justificacion
	 */
	public ec.com.smx.sic.cliente.mdl.dto.JustificacionDTO getJustificacion() {
		return justificacion;
	}

	/**
	 * @param justificacion the justificacion to set
	 */
	public void setJustificacion(ec.com.smx.sic.cliente.mdl.dto.JustificacionDTO justificacion) {
		this.justificacion = justificacion;
	}

	/**
	 * @return the detalleFacturaEstado
	 */
	public ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO getDetalleFacturaEstado() {
		return detalleFacturaEstado;
	}

	/**
	 * @param detalleFacturaEstado the detalleFacturaEstado to set
	 */
	public void setDetalleFacturaEstado(ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO detalleFacturaEstado) {
		this.detalleFacturaEstado = detalleFacturaEstado;
	}

	/**
	 * @return the ordenCompraDetalleEstadoDiferencia
	 */
	public OrdenCompraDetalleEstadoDTO getOrdenCompraDetalleEstadoDiferencia() {
		return ordenCompraDetalleEstadoDiferencia;
	}

	/**
	 * @param ordenCompraDetalleEstadoDiferencia the ordenCompraDetalleEstadoDiferencia to set
	 */
	public void setOrdenCompraDetalleEstadoDiferencia(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDiferencia) {
		this.ordenCompraDetalleEstadoDiferencia = ordenCompraDetalleEstadoDiferencia;
	}

	/**
	 * @return the codigoOrdenCompraDetalleEstadoDiferencia
	 */
	public java.lang.Long getCodigoOrdenCompraDetalleEstadoDiferencia() {
		return codigoOrdenCompraDetalleEstadoDiferencia;
	}

	/**
	 * @param codigoOrdenCompraDetalleEstadoDiferencia the codigoOrdenCompraDetalleEstadoDiferencia to set
	 */
	public void setCodigoOrdenCompraDetalleEstadoDiferencia(java.lang.Long codigoOrdenCompraDetalleEstadoDiferencia) {
		this.codigoOrdenCompraDetalleEstadoDiferencia = codigoOrdenCompraDetalleEstadoDiferencia;
	}

	/**
	 * Variable para identificar si la diferencia es editable, 
	 * valores: 0 (editable), 1 (no editable)
	 */
	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}


	public String getEntregas() {
		return entregas;
	}

	public void setEntregas(String entregas) {
		this.entregas = entregas;
	}
	
}