package ec.com.smx.sic.cliente.mdl.dto.sispe;

import java.sql.Timestamp;

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
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.EntregaDetallePedidoEspecialID;

/**
 * author esanchez
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.EntregaDetallePedidoEspecialDTO")
@Table(name = "SCSPETENTDETPED")
public class EntregaDetallePedidoEspecialDTO extends SimpleAuditDTO{


	/**
	 * id
	 *
	 */
	@EmbeddedId
	private EntregaDetallePedidoEspecialID id;


	

	/**
	 * codigo pedido
	 *

	 */
	private String codigoPedido ;

	

	/**
	 * codigo estado
	 *

	 */
	private String codigoEstado ;

	

	/**
	 * codigo local
	 *

	 */
	private Integer codigoAreaTrabajo ;

	

	/**
	 * secuencial estado pedido
	 *

	 */
	private String secuencialEstadoPedido ;

	

	/**
	 * codigo articulo
	 *

	 */
	private String codigoArticulo ;

	

	/**
	 * codigo entrega pedido
	 *

	 */
	private java.lang.Long codigoEntregaPedido ;

	

	/**
	 * cantidad entrega
	 *

	 */
	private Long cantidadEntrega ;

	

	/**
	 * cantidad despacho
	 *

	 */
//	private Long cantidadDespacho ;

	

	/**
	 * fecha registro despacho
	 *

	 */
	private Timestamp fechaRegistroDespacho ;
	
	/**
	 * fecha de registro entrega al cliente
	 */
	private Timestamp fechaRegistroEntregaCliente;
	
	
	/**
	 * Contiene el codigo anterior del detalle entrega pedidos
	 */
	@Transient
	private Long codigoDetalleEntregaPedidoPrevio;


	/**
	 * cantidad parcial despacho
	 *

	 */
	private Double cantidadParcialDespacho ;

	
	/**
	 * valor unitario 
	 */
	private Double valorUnitario;
	
	
	/**
	 * valor total
	 */
	private Double valorTotal;
	
	/**
	 * aplica iva
	 */
	private String aplicaIva;
	
	
	/**
	 * estado registro
	 */
	private String estadoRegistro;
	

	/**
	 * numero detalle
	 */
	private Integer numeroDetalle;
	
	/**
	 * estado, posibles valores: 1(activo), 0(inactivo)
	 *

	 */
	private String estado ;
	
	
	/**
	 * codigo area trabajo responsable despacho
	 *

	 */
	private Integer codAreTraResDes;

	

	/**
	 * codigo area trabajo responsable produccion
	 *

	 */
	private Integer codAreTraResPro ;

	
	
	/**
	 * cantidadDespachoBodega
	 *

	 */
	private Double cantidadDespachoBodega ;

	

	/**
	 * estadoDespachoBodega
	 *

	 */
	private String estadoDespachoBodega ;
	
	

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

	

//	/**
//	 * estado detalle pedido
//	 */
//	private ec.com.smx.sic.sispe.dto.EstadoDetallePedidoDTO estadoDetallePedidoDTO;


//
//	/**
//	 * entregaPedidoDTO
//	 *
//	 */
//	private ec.com.smx.sic.sispe.dto.EntregaPedidoDTO entregaPedidoDTO;


//	
//	/**
//	 * entregaDetallePedidoCol
//	 */
//	private Collection<EntregaDetallePedidoEspecialDTO> entregaDetallePedidoCol;
//	
//	
//	/**
//	 * detallePedidoTarjetaCol
//	 */
//	private Collection<DetallePedidoTarjetaDTO> detallePedidoTarjetaCol;
//	
//	/**
//	 * estadoDetalleArticulo
//	 */
//	private Collection<EstadoDetalleArticuloDTO > estadoDetalleArticuloCol;
//	

	/**
	 * usuario registro
	 *
	 */
	@Transient
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioRegistroDTO;



	/**
	 * usuario modificacion
	 *
	 */
	@Transient
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioModificacionDTO;


	//campos no persitentes
	
//	private ArticuloDatoImagenDTO npArticuloDatoImagenDTO;
	@Transient
	private Long npCantidadDespacho;
	@Transient
	private Long npCantidadEntrega;
	@Transient
	private Integer npCantidadBultos;
	
	//campo para filtrar la subBodega a la que pertenece la clasificaci�n de un art�culo
	@Transient
	private String npTipoBodega;
	
//	private Boolean npFiltrarPorCodigosCD;
	@Transient
	private Boolean npFiltroFechaRegDes;
//	private Boolean npFiltarPorEntregasLocalOdomicilio;
	@Transient
	private String npOrderBy;
	@Transient
	private String npDescripcionArticulo;
	
	//Almacenar el codigo de barras
	@Transient
	private String npCodigoBarras;
	@Transient
	private String npCantidadEntregaFueModificada;
	//para saber que campo sumar
	@Transient
	private String npCampoSuma;
	@Transient
	private Boolean npEsDespachoPendiente = Boolean.FALSE;
	//campo para verificar si ya fue entregado
	@Transient
	private Boolean npEntregado;
	//campo para saber si es un despacho a local o entrega a domicilio
	@Transient
	private Boolean npEsDespachoLocal;
	//para obtener la produccion/despacho pendiente
	@Transient
	private Boolean npPendiente;
	//se utiliza para la consulta por rango de fechas de despacho
	@Transient
	private Timestamp npFechaDespachoInicial;
	@Transient
	private Timestamp npFechaDespachoFinal;
	//tipo de articulo para despacho
	@Transient
	private String npCodigoTipoArticulo;
//	private String npIdUsuarioFiltrar;
	
	//filtro de roles
	@Transient
	private String npUserRolFiltrar;
	@Transient
	private String npCantDespachoMayorCantParcial;
	
	//bultos calculados
//	private Integer npCantidadBultosDespachoCalculados;
	
	public String getNpDescripcionArticulo() {
		return npDescripcionArticulo;
	}

	public void setNpDescripcionArticulo(String npDescripcionArticulo) {
		this.npDescripcionArticulo = npDescripcionArticulo;
	}

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public EntregaDetallePedidoEspecialID getId(){
		return this.id;
	}
	
	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( EntregaDetallePedidoEspecialID id1 ){
		this.id=id1;
	}


	/**
	 * Retorna valor de propiedad <code>codigoPedido</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoPedido</code>
	 */
	public String getCodigoPedido(){
		return this.codigoPedido;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoPedido</code>.
	 * @param codigoPedido1 
	 *		El valor a establecer para la propiedad <code>codigoPedido</code>.
	 */
	public void setCodigoPedido( String codigoPedido1 ){
		this.codigoPedido=codigoPedido1;
		
		if(codigoPedido!=null && codigoPedido.length()>20){
			codigoPedido = codigoPedido.substring(0,20);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>codigoEstado</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoEstado</code>
	 */
	public String getCodigoEstado(){
		return this.codigoEstado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoEstado</code>.
	 * @param codigoEstado1 
	 *		El valor a establecer para la propiedad <code>codigoEstado</code>.
	 */
	public void setCodigoEstado( String codigoEstado1 ){
		this.codigoEstado=codigoEstado1;
		
		if(codigoEstado!=null && codigoEstado.length()>3){
			codigoEstado = codigoEstado.substring(0,3);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>secuencialEstadoPedido</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>secuencialEstadoPedido</code>
	 */
	public String getSecuencialEstadoPedido(){
		return this.secuencialEstadoPedido;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>secuencialEstadoPedido</code>.
	 * @param secuencialEstadoPedido1 
	 *		El valor a establecer para la propiedad <code>secuencialEstadoPedido</code>.
	 */
	public void setSecuencialEstadoPedido( String secuencialEstadoPedido1 ){
		this.secuencialEstadoPedido=secuencialEstadoPedido1;
		
		if(secuencialEstadoPedido!=null && secuencialEstadoPedido.length()>20){
			secuencialEstadoPedido = secuencialEstadoPedido.substring(0,20);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>codigoArticulo</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoArticulo</code>
	 */
	public String getCodigoArticulo(){
		return this.codigoArticulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoArticulo</code>.
	 * @param codigoArticulo1 
	 *		El valor a establecer para la propiedad <code>codigoArticulo</code>.
	 */
	public void setCodigoArticulo( String codigoArticulo1 ){
		this.codigoArticulo=codigoArticulo1;
		
		if(codigoArticulo!=null && codigoArticulo.length()>20){
			codigoArticulo = codigoArticulo.substring(0,20);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>codigoEntregaPedido</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoEntregaPedido</code>
	 */
	public java.lang.Long getCodigoEntregaPedido(){
		return this.codigoEntregaPedido;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoEntregaPedido</code>.
	 * @param codigoEntregaPedido1 
	 *		El valor a establecer para la propiedad <code>codigoEntregaPedido</code>.
	 */
	public void setCodigoEntregaPedido( java.lang.Long codigoEntregaPedido1 ){
		this.codigoEntregaPedido=codigoEntregaPedido1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>cantidadEntrega</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>cantidadEntrega</code>
	 */
	public Long getCantidadEntrega(){
		return this.cantidadEntrega;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cantidadEntrega</code>.
	 * @param cantidadEntrega1 
	 *		El valor a establecer para la propiedad <code>cantidadEntrega</code>.
	 */
	public void setCantidadEntrega( Long cantidadEntrega1 ){
		this.cantidadEntrega=cantidadEntrega1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>cantidadDespacho</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>cantidadDespacho</code>
	 */
//	public Long getCantidadDespacho(){
//		return this.cantidadDespacho;
//	}
//
//	/**
//	 * Establece un nuevo valor para la propiedad <code>cantidadDespacho</code>.
//	 * @param cantidadDespacho1 
//	 *		El valor a establecer para la propiedad <code>cantidadDespacho</code>.
//	 */
//	public void setCantidadDespacho( Long cantidadDespacho1 ){
//		this.cantidadDespacho=cantidadDespacho1;
//		
//	}

		

	/**
	 * Retorna valor de propiedad <code>fechaRegistroDespacho</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaRegistroDespacho</code>
	 */
	public Timestamp getFechaRegistroDespacho(){
		return this.fechaRegistroDespacho;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistroDespacho</code>.
	 * @param fechaRegistroDespacho1 
	 *		El valor a establecer para la propiedad <code>fechaRegistroDespacho</code>.
	 */
	public void setFechaRegistroDespacho(Timestamp fechaRegistroDespacho1 ){
		this.fechaRegistroDespacho=fechaRegistroDespacho1;
		
	}

		
	/**
	 * Retorna propiedad <code>fechaRegistroDespacho</code> como String
	 * @return 
	 * 	Retorna propiedad <code>fechaRegistroDespacho</code> como String
	 */
	public String getFechaRegistroDespachoS() {
		return (this.fechaRegistroDespacho!=null)?ConverterUtil.getYMDDateFormat().format(this.fechaRegistroDespacho):null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>fechaRegistroDespacho</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>fechaRegistroDespacho</code>.
	 */
	public void setFechaRegistroDespachoS(String cadena) {
		try{
			this.fechaRegistroDespacho = new Timestamp((cadena!=null)? ConverterUtil.getYMDDateFormat().parse(cadena).getTime():null);
		}catch(Exception ex){Logeable.LOG_SICV2.error(ex.getMessage());}
	}	
			

	/**
	 * Retorna valor de propiedad <code>cantidadParcialDespacho</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>cantidadParcialDespacho</code>
	 */
	public Double getCantidadParcialDespacho(){
		return this.cantidadParcialDespacho;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cantidadParcialDespacho</code>.
	 * @param cantidadParcialDespacho1 
	 *		El valor a establecer para la propiedad <code>cantidadParcialDespacho</code>.
	 */
	public void setCantidadParcialDespacho( Double cantidadParcialDespacho1 ){
		this.cantidadParcialDespacho=cantidadParcialDespacho1;
		
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
		
		if(estado!=null && estado.length()>3){
			estado = estado.substring(0,3);
		}
				
				
	}
	
	
	public Integer getCodAreTraResDes() {
		return codAreTraResDes;
	}

	public void setCodAreTraResDes(Integer codAreTraResDes) {
		this.codAreTraResDes = codAreTraResDes;
	}

	public Integer getCodAreTraResPro() {
		return codAreTraResPro;
	}

	public void setCodAreTraResPro(Integer codAreTraResPro) {
		this.codAreTraResPro = codAreTraResPro;
	}

		
	/**
	 * Retorna valor de propiedad <code>cantidadDespachoBodega</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>cantidadDespachoBodega</code>
	 */
	public Double getCantidadDespachoBodega(){
		return this.cantidadDespachoBodega;
	}

	
	/**
	 * Establece un nuevo valor para la propiedad <code>cantidadDespachoBodega</code>.
	 * @param cantidadDespachoBodega1 
	 *		El valor a establecer para la propiedad <code>cantidadDespachoBodega</code>.
	 */
	public void setCantidadDespachoBodega( Double cantidadDespachoBodega1 ){
		this.cantidadDespachoBodega=cantidadDespachoBodega1;
		
	}


	/**
	 * Retorna valor de propiedad <code>estadoDespachoBodega</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estadoDespachoBodega</code>
	 */
	public String getEstadoDespachoBodega(){
		return this.estadoDespachoBodega;
	}

	
	/**
	 * Establece un nuevo valor para la propiedad <code>estadoDespachoBodega</code>.
	 * @param estadoDespachoBodega1 
	 *		El valor a establecer para la propiedad <code>estadoDespachoBodega</code>.
	 */
	public void setEstadoDespachoBodega( String estadoDespachoBodega1 ){
		this.estadoDespachoBodega=estadoDespachoBodega1;
		
		if(estadoDespachoBodega!=null && estadoDespachoBodega.length()>1){
			estadoDespachoBodega = estadoDespachoBodega.substring(0,1);
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
			



//	/**
//	 * Retorna valor de propiedad <code>estadoDetallePedidoDTO</code>
//	 * @return 
//	 * 		Retorna valor de propiedad <code>estadoDetallePedidoDTO</code>
//	 */
//	public ec.com.smx.sic.sispe.dto.EstadoDetallePedidoDTO getEstadoDetallePedidoDTO(){
//		return this.estadoDetallePedidoDTO;
//	}
//
//	/**
//	 * Establece un nuevo valor para la propiedad <code>estadoDetallePedidoDTO</code>.
//	 * @param estadoDetallePedidoDTO1 
//	 *		El valor a establecer para la propiedad <code>estadoDetallePedidoDTO</code>.
//	 */
//	public void setEstadoDetallePedidoDTO( ec.com.smx.sic.sispe.dto.EstadoDetallePedidoDTO estadoDetallePedidoDTO1 ){
//		this.estadoDetallePedidoDTO=estadoDetallePedidoDTO1;
//	}


//	/**
//	 * Retorna valor de propiedad <code>entregaPedidoDTO</code>
//	 * @return 
//	 * 		Retorna valor de propiedad <code>entregaPedidoDTO</code>
//	 */
//	public ec.com.smx.sic.sispe.dto.EntregaPedidoDTO getEntregaPedidoDTO(){
//		return this.entregaPedidoDTO;
//	}
//
//	/**
//	 * Establece un nuevo valor para la propiedad <code>entregaPedidoDTO</code>.
//	 * @param entregaPedidoDTO1 
//	 *		El valor a establecer para la propiedad <code>entregaPedidoDTO</code>.
//	 */
//	public void setEntregaPedidoDTO( ec.com.smx.sic.sispe.dto.EntregaPedidoDTO entregaPedidoDTO1 ){
//		this.entregaPedidoDTO=entregaPedidoDTO1;
//	}


	/**
	 * Retorna valor de propiedad <code>usuarioRegistroDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioRegistroDTO</code>
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioRegistroDTO(){
		return this.usuarioRegistroDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioRegistroDTO</code>.
	 * @param usuarioRegistroDTO1 
	 *		El valor a establecer para la propiedad <code>usuarioRegistroDTO</code>.
	 */
	public void setUsuarioRegistroDTO( ec.com.smx.frameworkv2.security.dto.UserDto usuarioRegistroDTO1 ){
		this.usuarioRegistroDTO=usuarioRegistroDTO1;
	}


	/**
	 * Retorna valor de propiedad <code>usuarioModificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuarioModificacion</code>
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioModificacionDTO(){
		return this.usuarioModificacionDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioModificacion</code>.
	 * @param usuarioModificacion1 
	 *		El valor a establecer para la propiedad <code>usuarioModificacion</code>.
	 */
	public void setUsuarioModificacionDTO( ec.com.smx.frameworkv2.security.dto.UserDto usuarioModificacion1 ){
		this.usuarioModificacionDTO=usuarioModificacion1;
	}

	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

//	public Collection<EntregaDetallePedidoEspecialDTO> getEntregaDetallePedidoCol() {
//		return entregaDetallePedidoCol;
//	}
//
//	public void setEntregaDetallePedidoCol( Collection<EntregaDetallePedidoEspecialDTO> entregaDetallePedidoCol) {
//		this.entregaDetallePedidoCol = entregaDetallePedidoCol;
//	}
//
//	public Collection<DetallePedidoTarjetaDTO> getDetallePedidoTarjetaCol() {
//		return detallePedidoTarjetaCol;
//	}
//
//	public void setDetallePedidoTarjetaCol( Collection<DetallePedidoTarjetaDTO> detallePedidoTarjetaCol) {
//		this.detallePedidoTarjetaCol = detallePedidoTarjetaCol;
//	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getAplicaIva() {
		return aplicaIva;
	}

	public void setAplicaIva(String aplicaIva) {
		this.aplicaIva = aplicaIva;
	}

//	public ArticuloDatoImagenDTO getNpArticuloDatoImagenDTO() {
//		return npArticuloDatoImagenDTO;
//	}
//
//	public void setNpArticuloDatoImagenDTO( ArticuloDatoImagenDTO npArticuloDatoImagenDTO) {
//		this.npArticuloDatoImagenDTO = npArticuloDatoImagenDTO;
//	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Integer getNumeroDetalle() {
		return numeroDetalle;
	}

	public void setNumeroDetalle(Integer numeroDetalle) {
		this.numeroDetalle = numeroDetalle;
	}

	/**
	 * @return the npCantidadDespacho
	 */
	public Long getNpCantidadDespacho() {
		return npCantidadDespacho;
	}

	/**
	 * @param npCantidadDespacho the npCantidadDespacho to set
	 */
	public void setNpCantidadDespacho(Long npCantidadDespacho) {
		this.npCantidadDespacho = npCantidadDespacho;
	}

	/**
	 * @return the npCantidadEntrega
	 */
	public Long getNpCantidadEntrega() {
		return npCantidadEntrega;
	}

	/**
	 * @param npCantidadEntrega the npCantidadEntrega to set
	 */
	public void setNpCantidadEntrega(Long npCantidadEntrega) {
		this.npCantidadEntrega = npCantidadEntrega;
	}

	/**
	 * @return the npCantidadBultos
	 */
	public Integer getNpCantidadBultos() {
		return npCantidadBultos;
	}

	/**
	 * @param npCantidadBultos the npCantidadBultos to set
	 */
	public void setNpCantidadBultos(Integer npCantidadBultos) {
		this.npCantidadBultos = npCantidadBultos;
	}

	/**
	 * @return the npTipoBodega
	 */
	public String getNpTipoBodega() {
		return npTipoBodega;
	}

	/**
	 * @param npTipoBodega the npTipoBodega to set
	 */
	public void setNpTipoBodega(String npTipoBodega) {
		this.npTipoBodega = npTipoBodega;
	}

//	/**
//	 * @return the npFiltarPorEntregasLocalOdomicilio
//	 */
//	public Boolean getNpFiltarPorEntregasLocalOdomicilio() {
//		return npFiltarPorEntregasLocalOdomicilio;
//	}
//
//	/**
//	 * @param npFiltarPorEntregasLocalOdomicilio the npFiltarPorEntregasLocalOdomicilio to set
//	 */
//	public void setNpFiltarPorEntregasLocalOdomicilio(
//			Boolean npFiltarPorEntregasLocalOdomicilio) {
//		this.npFiltarPorEntregasLocalOdomicilio = npFiltarPorEntregasLocalOdomicilio;
//	}

	/**
	 * @return the npOrderBy
	 */
	public String getNpOrderBy() {
		return npOrderBy;
	}

	/**
	 * @param npOrderBy the npOrderBy to set
	 */
	public void setNpOrderBy(String npOrderBy) {
		this.npOrderBy = npOrderBy;
	}
	
	/**
	 * @return el npCampoSuma
	 */
	public String getNpCampoSuma() {
		return npCampoSuma;
	}

	/**
	 * @param npCampoSuma el npCampoSuma a establecer
	 */
	public void setNpCampoSuma(String npCampoSuma) {
		this.npCampoSuma = npCampoSuma;
	}

	/**
	 * @return el npEsDespachoPendiente
	 */
	public Boolean getNpEsDespachoPendiente() {
		return npEsDespachoPendiente;
	}

	/**
	 * @param npEsDespachoPendiente el npEsDespachoPendiente a establecer
	 */
	public void setNpEsDespachoPendiente(Boolean npEsDespachoPendiente) {
		this.npEsDespachoPendiente = npEsDespachoPendiente;
	}
	
	/**
	 * @return el npEntregado
	 */
	public Boolean getNpEntregado() {
		return npEntregado;
	}

	/**
	 * @param npEntregado el npEntregado a establecer
	 */
	public void setNpEntregado(Boolean npEntregado) {
		this.npEntregado = npEntregado;
	}
	
	/**
	 * @return el npEsDespachoLocal
	 */
	public Boolean getNpEsDespachoLocal() {
		return npEsDespachoLocal;
	}

	/**
	 * @param npEsDespachoLocal el npEsDespachoLocal a establecer
	 */
	public void setNpEsDespachoLocal(Boolean npEsDespachoLocal) {
		this.npEsDespachoLocal = npEsDespachoLocal;
	}
	
	/**
	 * @return el npPendiente
	 */
	public Boolean getNpPendiente() {
		return npPendiente;
	}

	/**
	 * @param npPendiente el npPendiente a establecer
	 */
	public void setNpPendiente(Boolean npPendiente) {
		this.npPendiente = npPendiente;
	}
	
	/**
	 * @return el npFechaDespachoFinal
	 */
	public Timestamp getNpFechaDespachoFinal() {
		return npFechaDespachoFinal;
	}

	/**
	 * @param npFechaDespachoFinal el npFechaDespachoFinal a establecer
	 */
	public void setNpFechaDespachoFinal(Timestamp npFechaDespachoFinal) {
		this.npFechaDespachoFinal = npFechaDespachoFinal;
	}

	/**
	 * @return el npFechaDespachoInicial
	 */
	public Timestamp getNpFechaDespachoInicial() {
		return npFechaDespachoInicial;
	}

	/**
	 * @param npFechaDespachoInicial el npFechaDespachoInicial a establecer
	 */
	public void setNpFechaDespachoInicial(Timestamp npFechaDespachoInicial) {
		this.npFechaDespachoInicial = npFechaDespachoInicial;
	}
	
	/**
	 * @return el npCodigoTipoArticulo
	 */
	public String getNpCodigoTipoArticulo() {
		return npCodigoTipoArticulo;
	}

	/**
	 * @param npCodigoTipoArticulo el npCodigoTipoArticulo a establecer
	 */
	public void setNpCodigoTipoArticulo(String npCodigoTipoArticulo) {
		this.npCodigoTipoArticulo = npCodigoTipoArticulo;
	}
	
//	/**
//	 * @return el npIdUsuarioFiltrar
//	 */
//	public String getNpIdUsuarioFiltrar() {
//		return npIdUsuarioFiltrar;
//	}

//	/**
//	 * @param npIdUsuarioFiltrar el npIdUsuarioFiltrar a establecer
//	 */
//	public void setNpIdUsuarioFiltrar(String npIdUsuarioFiltrar) {
//		this.npIdUsuarioFiltrar = npIdUsuarioFiltrar;
//		//se asigna la relaci�n porque el usuario se filtra por clasificaci�n de art�culo
//		//la cual no est� en la tabla de entregas
////		if(this.getEstadoDetallePedidoDTO() == null){
////			this.setEstadoDetallePedidoDTO(new EstadoDetallePedidoDTO());
////		}
//	}
	
//	/**
//	 * @return the npFiltrarPorCodigosCD
//	 */
//	public Boolean getNpFiltrarPorCodigosCD() {
//		return npFiltrarPorCodigosCD;
//	}
//
//	/**
//	 * @param npFiltrarPorCodigosCD the npFiltrarPorCodigosCD to set
//	 */
//	public void setNpFiltrarPorCodigosCD(Boolean npFiltrarPorCodigosCD) {
//		this.npFiltrarPorCodigosCD = npFiltrarPorCodigosCD;
//	}	

	/**
	 * @return the npFiltroFechaRegDes
	 */
	public Boolean getNpFiltroFechaRegDes() {
		return npFiltroFechaRegDes;
	}

	/**
	 * @param npFiltroFechaRegDes the npFiltroFechaRegDes to set
	 */
	public void setNpFiltroFechaRegDes(Boolean npFiltroFechaRegDes) {
		this.npFiltroFechaRegDes = npFiltroFechaRegDes;
	}

	public String getNpCodigoBarras() {
		return npCodigoBarras;
	}

	public void setNpCodigoBarras(String npCodigoBarras) {
		this.npCodigoBarras = npCodigoBarras;
	}

	public String getNpCantidadEntregaFueModificada() {
		return npCantidadEntregaFueModificada;
	}

	public void setNpCantidadEntregaFueModificada(
			String npCantidadEntregaFueModificada) {
		this.npCantidadEntregaFueModificada = npCantidadEntregaFueModificada;
	}

	public String getNpUserRolFiltrar() {
		return npUserRolFiltrar;
	}

	public void setNpUserRolFiltrar(String npUserRolFiltrar) {
		this.npUserRolFiltrar = npUserRolFiltrar;
	}

	public String getNpCantDespachoMayorCantParcial() {
		return npCantDespachoMayorCantParcial;
	}

	public void setNpCantDespachoMayorCantParcial(
			String npCantDespachoMayorCantParcial) {
		this.npCantDespachoMayorCantParcial = npCantDespachoMayorCantParcial;
	}

//	public Collection<EstadoDetalleArticuloDTO> getEstadoDetalleArticuloCol() {
//		return estadoDetalleArticuloCol;
//	}
//
//	public void setEstadoDetalleArticuloCol(
//			Collection<EstadoDetalleArticuloDTO> estadoDetalleArticuloCol) {
//		this.estadoDetalleArticuloCol = estadoDetalleArticuloCol;
//	}

	public Timestamp getFechaRegistroEntregaCliente() {
		return fechaRegistroEntregaCliente;
	}

	public void setFechaRegistroEntregaCliente(Timestamp fechaRegistroEntregaCliente) {
		this.fechaRegistroEntregaCliente = fechaRegistroEntregaCliente;
	}

	public Long getCodigoDetalleEntregaPedidoPrevio() {
		return codigoDetalleEntregaPedidoPrevio;
	}

	public void setCodigoDetalleEntregaPedidoPrevio(
			Long codigoDetalleEntregaPedidoPrevio) {
		this.codigoDetalleEntregaPedidoPrevio = codigoDetalleEntregaPedidoPrevio;
	}

//	public Integer getNpCantidadBultosDespachoCalculados() throws SISPEException {
//		 this.npCantidadBultosDespachoCalculados = Integer.valueOf(UtilesSISPE.calcularCantidadBultos(this.cantidadDespacho, this.estadoDetallePedidoDTO.getDetallePedidoDTO().getArticuloDTO()));
//		 return this.npCantidadBultosDespachoCalculados;
//	}

//	public void setNpCantidadBultosDespachoCalculados(
//			Integer npCantidadBultosDespachoCalculados) {
//		this.npCantidadBultosDespachoCalculados = npCantidadBultosDespachoCalculados;
//	}

	public EntregaDetallePedidoEspecialDTO() {
		this.id = new EntregaDetallePedidoEspecialID();
	}
}

