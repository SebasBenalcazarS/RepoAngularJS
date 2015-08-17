
package ec.com.smx.sic.cliente.mdl.dto.b2b;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corporativo.admparamgeneral.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.PedidoDetalleRelacionadoID;



/**
 * En esta tabla se guardan las ordenes de compra relacionadas, esta tabla se va a usar en el workflow de importaciones cuando aumentan o remplazan una orden de compra por otra
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity(name = " ec.com.smx.sic.cliente.mdl.dto.b2b.PedidoDetalleRelacionadoDTO")
@Table(name = "SSB2BTPEDDETREL")
@Deprecated
public class PedidoDetalleRelacionadoDTO extends SimpleAuditDTO{

	/**
	 * Clave primaria de la tabla
	 *
	 */
	@EmbeddedId
	private PedidoDetalleRelacionadoID id = new PedidoDetalleRelacionadoID();

	/**
	 * En este campo se almacena el codigo del tipo catalogo para que el campo relacion se traiga desde los catálogos
	 *
	 */
	private Integer codigoRelacion ;
	
	/**
	 * Especifica si fue un remplazo o un aumento
	 *
	 */
	private String relacion ;
	
	@Column(name = "IDUSUARIOREGISTRO")
	private String registerUserId;
	
	@Column(name = "FECHAREGISTRO")
	private Timestamp registerDate;
	
	@Column(name = "IDUSUARIOACTUALIZACION")
	private String lastModifierUserId;
	
	@Column(name = "FECHAACTUALIZACION")
	private Timestamp lastModificationDate;
	

	/**
	 * Referencia a Pedido Detalle
	 *
	 */
	@Transient
	private PedidoDetalleDTO pedidoDetalle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "PEDIDOORIGINAL", referencedColumnName = "CODIGOPEDIDO", insertable = false, updatable = false),
		@JoinColumn(name = "ORDENCOMPRAORIGINAL", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false)
	})
	private PedidoDetalleDTO pedidoDetalleOriginal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "PEDIDORELACIONADO", referencedColumnName = "CODIGOPEDIDO", insertable = false, updatable = false),
		@JoinColumn(name = "ORDENCOMPRARELACIONADA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false)
	})
	private PedidoDetalleDTO pedidoDetalleRelacionado;
	

	/**
	 * Relación con ususario Registro
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioRegistroDTO;

	/**
	 * Relación con ususario Modificacion
	 *
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOACTUALIZACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioModificacionDTO;

	/**
	 * relacion catalogoValor para los tipos de relacines en las ordenes de compra
	 */
	@Transient
	private CatalogoValorDTO relacionDTO;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public PedidoDetalleRelacionadoID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( PedidoDetalleRelacionadoID id1 ){
		this.id=id1;
	}
	
	/**
	 * Retorna valor de propiedad <code>codigoRelacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoRelacion</code>
	 */
	public Integer getCodigoRelacion(){
		return this.codigoRelacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoRelacion</code>.
	 * @param codigoRelacion1 
	 *		El valor a establecer para la propiedad <code>codigoRelacion</code>.
	 */
	public void setCodigoRelacion( Integer codigoRelacion1 ){
		this.codigoRelacion=codigoRelacion1;
		
	}

	/**
	 * Retorna valor de propiedad <code>relacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>relacion</code>
	 */
	public String getRelacion(){
		return this.relacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>relacion</code>.
	 * @param relacion1 
	 *		El valor a establecer para la propiedad <code>relacion</code>.
	 */
	public void setRelacion( String relacion1 ){
		this.relacion=relacion1;
		
		if(relacion!=null && relacion.length()>256){
			relacion = relacion.substring(0,256);
		}
	}
	
	/**
	 * Retorna valor de propiedad <code>pedidoDetalle</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>pedidoDetalle</code>
	 */
	public PedidoDetalleDTO getPedidoDetalle(){
		return this.pedidoDetalle;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>pedidoDetalle</code>.
	 * @param pedidoDetalle1 
	 *		El valor a establecer para la propiedad <code>pedidoDetalle</code>.
	 */
	public void setPedidoDetalle( PedidoDetalleDTO pedidoDetalle1 ){
		this.pedidoDetalle=pedidoDetalle1;
	}
	/**
	 * Retorna valor de propiedad <code>usuarioRegistroDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioRegistroDTO</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioRegistroDTO(){
		return this.usuarioRegistroDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioRegistroDTO</code>.
	 * @param usuarioRegistroDTO1 
	 *		El valor a establecer para la propiedad <code>usuarioRegistroDTO</code>.
	 */
	public void setUsuarioRegistroDTO( ec.com.smx.framework.security.dto.UserDto usuarioRegistroDTO1 ){
		this.usuarioRegistroDTO=usuarioRegistroDTO1;
	}


	/**
	 * Retorna valor de propiedad <code>usuarioModificacionDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioModificacionDTO</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioModificacionDTO(){
		return this.usuarioModificacionDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioModificacionDTO</code>.
	 * @param usuarioModificacionDTO1 
	 *		El valor a establecer para la propiedad <code>usuarioModificacionDTO</code>.
	 */
	public void setUsuarioModificacionDTO( ec.com.smx.framework.security.dto.UserDto usuarioModificacionDTO1 ){
		this.usuarioModificacionDTO=usuarioModificacionDTO1;
	}

	/**
	 * @return el relacionDTO
	 */
	public CatalogoValorDTO getRelacionDTO() {
		return relacionDTO;
	}

	/**
	 * @param relacionDTO el relacionDTO a establecer
	 */
	public void setRelacionDTO(CatalogoValorDTO relacionDTO) {
		this.relacionDTO = relacionDTO;
	}

	/**
	 * @return the registerUserId
	 */
	public String getRegisterUserId() {
		return registerUserId;
	}

	/**
	 * @param registerUserId the registerUserId to set
	 */
	public void setRegisterUserId(String registerUserId) {
		this.registerUserId = registerUserId;
	}

	/**
	 * @return the registerDate
	 */
	public Timestamp getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the lastModifierUserId
	 */
	public String getLastModifierUserId() {
		return lastModifierUserId;
	}

	/**
	 * @param lastModifierUserId the lastModifierUserId to set
	 */
	public void setLastModifierUserId(String lastModifierUserId) {
		this.lastModifierUserId = lastModifierUserId;
	}

	/**
	 * @return the lastModificationDate
	 */
	public Timestamp getLastModificationDate() {
		return lastModificationDate;
	}

	/**
	 * @param lastModificationDate the lastModificationDate to set
	 */
	public void setLastModificationDate(Timestamp lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	/**
	 * @return the pedidoDetalleOriginal
	 */
	public PedidoDetalleDTO getPedidoDetalleOriginal() {
		return pedidoDetalleOriginal;
	}

	/**
	 * @param pedidoDetalleOriginal the pedidoDetalleOriginal to set
	 */
	public void setPedidoDetalleOriginal(
			PedidoDetalleDTO pedidoDetalleOriginal) {
		this.pedidoDetalleOriginal = pedidoDetalleOriginal;
	}

	/**
	 * @return the pedidoDetalleRelacionado
	 */
	public PedidoDetalleDTO getPedidoDetalleRelacionado() {
		return pedidoDetalleRelacionado;
	}

	/**
	 * @param pedidoDetalleRelacionado the pedidoDetalleRelacionado to set
	 */
	public void setPedidoDetalleRelacionado(
			PedidoDetalleDTO pedidoDetalleRelacionado) {
		this.pedidoDetalleRelacionado = pedidoDetalleRelacionado;
	}

}

