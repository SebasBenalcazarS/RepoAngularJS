package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.auditoria.common.annotation.Auditable;
import ec.com.smx.frameworkv2.auditoria.common.util.AuditLogConstant;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorB2BID;



/**
 * Entidad que almacena los datos para el portal B2B del proveedor
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTPROB2B")
public class ProveedorB2BDTO extends AuditoriaBaseDTO {


	/**
	 * 
	 *
	 */
	@EmbeddedId
	private ProveedorB2BID id = new ProveedorB2BID();


		
		

	/**
	 * Indica la cantidad máxima de usuarios por proveedor
	 *

	 */
	@Column(name="CANMAXUSUPRO")
	private Integer cantidadMaximaUsuariosProveedor ;

	

	/**
	 * Establece si registra o no participaciones de mercado.
Los valores permitidos son:
[0] Inactivo
[1] Activo
	 *

	 */
	private String registraParticipaciones ;
	
	/**
	 * Código de los valores de registro de participaciones por parte del proveedor
	 */
	private Integer codigoRegistraParticipaciones;

	

	/**
	 * Contiene el secuencial de la configuración para un nivel de pago para 
	 * acceder reportes del BI
	 *

	 */
	@Column(name = "SECCONNIVPAG")
	private String secuencialConfiguracionNivelPago ;
	
	
	/**
	 * Permite registrar una observacion que indique la razon del cambio del nivel 
	 * de reportes asignado al proveedor
	 */
	@Column(name = "OBSCAMSECCONNIVPAG")
	private String observacionCambioSecuencialConfiguracionNivelPago;
	
	

	/**
	 * Indica el proceso para enviar un email al provedor, sus valores pueden ser:
[0] Inactivo
[1] Activo
	 *

	 */
	private String procesoEnvioEmail ;
	
	/**
	 * Codigo de los valores para el proceso de envío de email
	 */
	private Integer codigoProcesoEnvioEmail;
	
	
	/**
	 * Indica si el proveedor tiene acceso a ver los pedidos y devoluciones de 
	 * mercaderia en el portal; los valores pueden ser:
	 * [0] No tiene acceso
	 * [1] Si tiene acceso
	 */
	private String accesoPedidosDevoluciones;
	
	
	/**
	 * Codigo del catalogo de los posibles valores para establecer el acceso para
	 * ver pedidos y devoluciones en el portal 
	 */
	private Integer codigoAccesoPedidosDevoluciones;

	

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "ACCESOPEDIDOSDEVOLUCIONES", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOACCESOPEDIDOSDEVOLUCIONES", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO caracteristicaAccesoPedidosDevoluciones;

	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private ProveedorDTO proveedor;



	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "SECCONNIVPAG", referencedColumnName = "SECCONNIVPAG", insertable = false, updatable = false)})
	private ec.com.smx.bi.dto.ConfiguracionNivelPagoDTO configuracionNivelPago;


	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "REGISTRAPARTICIPACIONES", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOREGISTRAPARTICIPACIONES", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO caracteristicaRegistraParticipaciones;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "PROCESOENVIOEMAIL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROCESOENVIOEMAIL", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO caracteristicaProcesoEnvioEmail;
	

	

 
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ProveedorB2BID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ProveedorB2BID id1 ){
		this.id=id1;
	}


		
		

	/**
	 * Retorna valor de propiedad <code>cantidadMaximaUsuariosProveedor</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>cantidadMaximaUsuariosProveedor</code>
	 */
	public Integer getCantidadMaximaUsuariosProveedor(){
		return this.cantidadMaximaUsuariosProveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cantidadMaximaUsuariosProveedor</code>.
	 * @param cantidadMaximaUsuariosProveedor1 
	 *		El valor a establecer para la propiedad <code>cantidadMaximaUsuariosProveedor</code>.
	 */
	public void setCantidadMaximaUsuariosProveedor( Integer cantidadMaximaUsuariosProveedor1 ){
		this.cantidadMaximaUsuariosProveedor=cantidadMaximaUsuariosProveedor1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>registraParticipaciones</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>registraParticipaciones</code>
	 */
	public String getRegistraParticipaciones(){
		return this.registraParticipaciones;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>registraParticipaciones</code>.
	 * @param registraParticipaciones1 
	 *		El valor a establecer para la propiedad <code>registraParticipaciones</code>.
	 */
	public void setRegistraParticipaciones( String registraParticipaciones1 ){
		this.registraParticipaciones=registraParticipaciones1;
		
		if(registraParticipaciones!=null && registraParticipaciones.length()>1){
			registraParticipaciones = registraParticipaciones.substring(0,1);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>secuencialConfiguracionNivelPago</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>secuencialConfiguracionNivelPago</code>
	 */
	public String getSecuencialConfiguracionNivelPago(){
		return this.secuencialConfiguracionNivelPago;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>secuencialConfiguracionNivelPago</code>.
	 * @param secuencialConfiguracionNivelPago1 
	 *		El valor a establecer para la propiedad <code>secuencialConfiguracionNivelPago</code>.
	 */
	public void setSecuencialConfiguracionNivelPago( String secuencialConfiguracionNivelPago1 ){
		this.secuencialConfiguracionNivelPago=secuencialConfiguracionNivelPago1;
		
		if(secuencialConfiguracionNivelPago!=null && secuencialConfiguracionNivelPago.length()>15){
			secuencialConfiguracionNivelPago = secuencialConfiguracionNivelPago.substring(0,15);
		}		
	}
		
	/**
	 * @return the procesoEnvioEmail
	 */
	public String getProcesoEnvioEmail() {
		return procesoEnvioEmail;
	}

	/**
	 * @param procesoEnvioEmail the procesoEnvioEmail to set
	 */
	public void setProcesoEnvioEmail(String procesoEnvioEmail) {
		this.procesoEnvioEmail = procesoEnvioEmail;
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
	 * Retorna valor de propiedad <code>configuracionNivelPago</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>configuracionNivelPago</code>
	 */
	@Auditable(id = AuditLogConstant.MAX_PROVEEDOR)
	public ec.com.smx.bi.dto.ConfiguracionNivelPagoDTO getConfiguracionNivelPago(){
		return this.configuracionNivelPago;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>configuracionNivelPago</code>.
	 * @param configuracionNivelPago1 
	 *		El valor a establecer para la propiedad <code>configuracionNivelPago</code>.
	 */
	public void setConfiguracionNivelPago( ec.com.smx.bi.dto.ConfiguracionNivelPagoDTO configuracionNivelPago1 ){
		this.configuracionNivelPago=configuracionNivelPago1;
	}



	/**
	 * @return the codigoRegistraParticipaciones
	 */
	public Integer getCodigoRegistraParticipaciones() {
		return codigoRegistraParticipaciones;
	}

	/**
	 * @param codigoRegistraParticipaciones the codigoRegistraParticipaciones to set
	 */
	public void setCodigoRegistraParticipaciones(
			Integer codigoRegistraParticipaciones) {
		this.codigoRegistraParticipaciones = codigoRegistraParticipaciones;
	}

	/**
	 * @return the codigoProcesoEnvioEmail
	 */
	public Integer getCodigoProcesoEnvioEmail() {
		return codigoProcesoEnvioEmail;
	}

	/**
	 * @param codigoProcesoEnvioEmail the codigoProcesoEnvioEmail to set
	 */
	public void setCodigoProcesoEnvioEmail(Integer codigoProcesoEnvioEmail) {
		this.codigoProcesoEnvioEmail = codigoProcesoEnvioEmail;
	}

	/**
	 * @return the caracteristicaRegistraParticipaciones
	 */
	public CatalogoValorDTO getCaracteristicaRegistraParticipaciones() {
		return caracteristicaRegistraParticipaciones;
	}

	/**
	 * @param caracteristicaRegistraParticipaciones the caracteristicaRegistraParticipaciones to set
	 */
	public void setCaracteristicaRegistraParticipaciones(
			CatalogoValorDTO caracteristicaRegistraParticipaciones) {
		this.caracteristicaRegistraParticipaciones = caracteristicaRegistraParticipaciones;
	}

	/**
	 * @return the caracteristicaProcesoEnvioEmail
	 */
	public CatalogoValorDTO getCaracteristicaProcesoEnvioEmail() {
		return caracteristicaProcesoEnvioEmail;
	}

	/**
	 * @param caracteristicaProcesoEnvioEmail the caracteristicaProcesoEnvioEmail to set
	 */
	public void setCaracteristicaProcesoEnvioEmail(
			CatalogoValorDTO caracteristicaProcesoEnvioEmail) {
		this.caracteristicaProcesoEnvioEmail = caracteristicaProcesoEnvioEmail;
	}

	/**
	 * @return the observacionCambioSecuencialConfiguracionNivelPago
	 */
	@Auditable(id = AuditLogConstant.MAX_PROVEEDOR, label = "Observaci\u00F3n del cambio de nivel de reportes")
	public String getObservacionCambioSecuencialConfiguracionNivelPago() {
		return observacionCambioSecuencialConfiguracionNivelPago;
	}

	/**
	 * @param observacionCambioSecuencialConfiguracionNivelPago the observacionCambioSecuencialConfiguracionNivelPago to set
	 */
	public void setObservacionCambioSecuencialConfiguracionNivelPago(
			String observacionCambioSecuencialConfiguracionNivelPago) {
		this.observacionCambioSecuencialConfiguracionNivelPago = StringUtils.substring(observacionCambioSecuencialConfiguracionNivelPago, 0, 1000);
	}

	/**
	 * @return the accesoPedidosDevoluciones
	 */
	public String getAccesoPedidosDevoluciones() {
		return accesoPedidosDevoluciones;
	}

	/**
	 * @param accesoPedidosDevoluciones the accesoPedidosDevoluciones to set
	 */
	public void setAccesoPedidosDevoluciones(String accesoPedidosDevoluciones) {
		this.accesoPedidosDevoluciones = accesoPedidosDevoluciones;
	}

	/**
	 * @return the codigoAccesoPedidosDevoluciones
	 */
	public Integer getCodigoAccesoPedidosDevoluciones() {
		return codigoAccesoPedidosDevoluciones;
	}

	/**
	 * @param codigoAccesoPedidosDevoluciones the codigoAccesoPedidosDevoluciones to set
	 */
	public void setCodigoAccesoPedidosDevoluciones(
			Integer codigoAccesoPedidosDevoluciones) {
		this.codigoAccesoPedidosDevoluciones = codigoAccesoPedidosDevoluciones;
	}

	/**
	 * @return the caracteristicaAccesoPedidosDevoluciones
	 */
	public CatalogoValorDTO getCaracteristicaAccesoPedidosDevoluciones() {
		return caracteristicaAccesoPedidosDevoluciones;
	}

	/**
	 * @param caracteristicaAccesoPedidosDevoluciones the caracteristicaAccesoPedidosDevoluciones to set
	 */
	public void setCaracteristicaAccesoPedidosDevoluciones(
			CatalogoValorDTO caracteristicaAccesoPedidosDevoluciones) {
		this.caracteristicaAccesoPedidosDevoluciones = caracteristicaAccesoPedidosDevoluciones;
	}
	
	
	
	
}