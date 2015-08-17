
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
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.EntregaPedidoEspecialID;


/**
 * @author esanchez
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.EntregaPedidoEspecialDTO")
@Table(name = "SCSPETENTPED")
public class EntregaPedidoEspecialDTO extends SimpleAuditDTO {

	@EmbeddedId
	private EntregaPedidoEspecialID id;


	/**
	 * codigo del area de trabajo donde se  realiza el pedido
	 *

	 */
	private Integer codigoAreaTrabajoEstadoPedido ;

	

	/**
	 * codigo del pedido
	 *

	 */
	private String codigoPedido ;

	

	/**
	 * codigo estado
	 *

	 */
	private String codigoEstado ;

	

//	/**
//	 * codigo local
//	 *
//
//	 */
//	private Integer codigoLocal ;

	

	/**
	 * secuencial estado pedido
	 *

	 */
	private String secuencialEstadoPedido ;

	

	/**
	 * codigo area de trabajo donde se realizara la entrega
	 *

	 */
	private Integer codigoAreaTrabajoEntrega ;

	

	/**
	 * codigoBodega
	 *

	 */
	private String codigoBodega ;

	

	/**
	 * codigo para identificar la localidad en caso de que la entrega sea a un domicilio
	 *

	 */
	private String codigoDivGeoPol ;

	

	/**
	 * direccion entrega
	 *

	 */
	private String direccionEntrega ;

	

	/**
	 * costa entrega
	 *

	 */
	private Double costoEntrega ;

	

	/**
	 * fecha entrega cliente
	 *

	 */
	private Timestamp fechaEntregaCliente ;

	

	/**
	 * fecha despacho bodega
	 *

	 */
	private Timestamp fechaDespachoBodega ;

	

	/**
	 * tipo entrega
	 *

	 */
	private String tipoEntrega ;

	

	/**
	 * codigo entrega pedido previo
	 *

	 */
	private java.lang.Long codigoEntregaPedidoPrevio ;

	
	/**
	 * Codigo del cliente beneficiario atado a la entrega
	 *

	 */
	private java.lang.Long codCliBenEntrega ;

	
	/**
	 * codigo del cliente beneficario a nombre de quien se realizaran los documentos de la venta
	 *

	 */
	private java.lang.Long codCliBenDocumento ;


	
	/**
	 * Almacena el c�digo del alcance de entrega, el alcance puede ser:
		- TOTAL
		- PARCIAL
	 *

	 */
	private Integer codigoAlcanceEntrega ;

	

	/**
	 * C�digo que almacena una referencia a la forma en que se obtinene la mercader�a para la entrega, por ejemplo:
		- OBTENER DEL LOCAL
		- OBTENER PARCIAL DE BODEGA
		- OBTENER TOTAL DE BODEGA
	 *

	 */
	private Integer codigoObtenerStock ;

	

	/**
	 * Almacena el c�digo que se refiere al contexto de la entrega, los contextos pueden ser:
		- MI LOCAL
		- OTRO LOCAL
		- DOMICILIO
	 *

	 */
	private Integer codigoContextoEntrega ;

	

//	/**
//	 * codigo configuracion responsable despacho
//	 *
//
//	 */
//	private Integer codConResDes ;

	

//	/**
//	 * codigo configuracion responsable produccion
//	 *
//
//	 */
//	private Integer codConResPro ;

	

	/**
	 * codigo configuracion responsable entrega
	 *

	 */
	private Integer codConResEnt ;

	

	/**
	 * codigo configuracion responsable pedido
	 *

	 */
	private Integer codConResPed ;

	

	/**
	 * Codigo ciudad sector entrega
	 *

	 */
	private String codigoCiudadSectorEntrega ;

	

	/**
	 * elabora canastos especiales
	 *

	 */
	private String elaCanEsp ;

	

	/**
	 * distanciaEntrega
	 *

	 */
	private Double distanciaEntrega ;

	

	/**
	 * codigo local sector
	 */
	private Integer codigoLocalSector;
	
	
	/**
	 * estado, posibles valores: 1(activo), 0(inactivo)
	 *

	 */
	private String estado ;

	/**
	 * usuario registro
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
	 * Quien recibira la entrega del convenio SICMER
	 *

	 */
	private String quienRecibira ;

	

	/**
	 * Codigo del vendedor del convenio SICMER
	 *

	 */
	private Long codigoVendedor ;
	
	
	/**
	 * horasEntrega
	 *
	 * campo para guardar hora desde y hora hasta en entregas a domicilio desde local
	 */
	
	private String horasEntrega ;

	
	/**
	 * observacionEntrega
	 *
	 */
	private String observacionEntrega ;

//	private EstadoPedidoDTO estadoPedidoDTO;

//	private AreaTrabajoDTO areaTrabajoEntrega;
//
//	private BodegaDTO bodegaDTO;
//
//	private DivisionGeoPoliticaDTO divisionGeoPoliticaDTO;
//
//	private EntregaPedidoEspecialDTO entregaPedidoPrevioDTO;
	
	/**
	 * sector entrega 
	 */
//	private LocalDTO localSectorDTO;

	@Transient
	private UserDto usuarioRegistroDTO;

	@Transient
	private UserDto usuarioModificacionDTO;


	/**
	 * clienteBeneficiarioEntregaDTO
	 *
	 */
//	private ClienteBeneficiarioDTO clienteBeneficiarioEntregaDTO;



	/**
	 * clienteBeneficiarioDocumentoDTO
	 *
	 */
//	private ClienteBeneficiarioDTO clienteBeneficiarioDocumentoDTO;
	
	
//	/**
//	 * Coleccion entrega detalle pedido
//	 */
//	private Collection<EntregaDetallePedidoEspecialDTO> entregaDetallePedidoCol;
 
	
	
	/**
	 * configuracionContextoDTO
	 *
	 */
//	private ConfiguracionDTO configuracionContextoDTO;



	/**
	 * configuracionAlcanceDTO
	 *
	 */
//	private ConfiguracionDTO configuracionAlcanceDTO;



	/**
	 * configuracionStockDTO
	 *
	 */
//	private ConfiguracionDTO configuracionStockDTO;



//	/**
//	 * configuracionResDesDTO
//	 *
//	 */
//	private ConfiguracionDTO configuracionResDesDTO;



//	/**
//	 * configuracionResProDTO
//	 *
//	 */
//	private ConfiguracionDTO configuracionResProDTO;



	/**
	 * configuracionResEntDTO
	 *
	 */
//	private ConfiguracionDTO configuracionResEntDTO;



	/**
	 * configuracionResPedDTO
	 *
	 */
//	private ConfiguracionDTO configuracion7ResPedDTO;



	/**
	 * divisionGeoPolCiudadSectorDTO
	 *
	 */
//	private DivisionGeoPoliticaDTO divisionGeoPolCiudadSectorDTO;

	
	//se debe validar esta relacion
//	private CalendarioDiaLocalDTO calendarioDiaLocalDTO;
	
	//campo temporal para evaluar si se debe quedar
	//Costo de la entrega a domicilio, se calcula en funcion a los bultos que equivale la cantidad de articulos
	@Transient
	private Double costoParcialEntrega;
	
	// Campos no persistente en la base de datos
	@Transient
	private String npDireccionEntregaDomicilio;
	@Transient
	private Long npContadorBeneficiario;
	@Transient
	private String codigoAutorizacion;
	//filtro codigos CD
	@Transient
	private Boolean npFiltrarPorCodigosCD = Boolean.FALSE;
	@Transient
	private String npValidarCheckTransito;
	@Transient
	private String npValorCodigoTransito;
	
	//campo para saber si es obligatorio el paso por una bodega de transito
	@Transient
	private String npPasoObligatorioBodegaTransito;
	
	//campo usado en los responsables de la entregas del pedido
//	private Collection<DetallePedidoDTO> npDetallePedido;
	
	//campo para filtar por entregas Local o domicilio
	@Transient
	private Boolean npFiltarPorEntregasLocalOdomicilio = Boolean.FALSE;
	
	
	//se utiliza para la consulta por rango de fechas de despacho
	@Transient
	private Timestamp npFechaDespachoInicial;
	@Transient
	private Timestamp npFechaDespachoFinal;
	@Transient
	private Timestamp npFechaEntregaInicial;
	@Transient
	private Integer npCodigoAreaTrabajoEntrega;
	@Transient
	private Double npValorParcialEntrega;
	
//	//Se utiliza para almacenar las autorizaciones solicitadas en el calendario de los locales
//	private AutorizacionDTO autorizacionDTO;
	
	//para pintar las entregas seleccionadas
	@Transient
	private Integer seleccionMouse = 0;
	
		/**
	 * Coleccion entrega pedido convenio
	 */
//	private Collection<EntregaPedidoEspecialConvenioDTO> entregaPedidoConvenioCol;
	
	@Transient
	private String npResProduccion;
	@Transient
	private String npResDespacho;
	
	public Timestamp getNpFechaDespachoInicial() {
		return npFechaDespachoInicial;
	}

	public void setNpFechaDespachoInicial(Timestamp npFechaDespachoInicial) {
		this.npFechaDespachoInicial = npFechaDespachoInicial;
	}

	public Timestamp getNpFechaDespachoFinal() {
		return npFechaDespachoFinal;
	}

	public void setNpFechaDespachoFinal(Timestamp npFechaDespachoFinal) {
		this.npFechaDespachoFinal = npFechaDespachoFinal;
	}

	public Timestamp getNpFechaEntregaInicial() {
		return npFechaEntregaInicial;
	}

	public void setNpFechaEntregaInicial(Timestamp npFechaEntregaInicial) {
		this.npFechaEntregaInicial = npFechaEntregaInicial;
	}
	
	public Integer getNpCodigoAreaTrabajoEntrega() {
		return npCodigoAreaTrabajoEntrega;
	}

	public void setNpCodigoAreaTrabajoEntrega(Integer npCodigoAreaTrabajoEntrega) {
		this.npCodigoAreaTrabajoEntrega = npCodigoAreaTrabajoEntrega;
	}

	/**
	 * Retorna valor de propiedad <code>codigoAreaTrabajoEstadoPedido</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoAreaTrabajoEstadoPedido</code>
	 */
	public Integer getCodigoAreaTrabajoEstadoPedido(){
		return this.codigoAreaTrabajoEstadoPedido;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoAreaTrabajoEstadoPedido</code>.
	 * @param codigoAreaTrabajoEstadoPedido1 
	 *		El valor a establecer para la propiedad <code>codigoAreaTrabajoEstadoPedido</code>.
	 */
	public void setCodigoAreaTrabajoEstadoPedido( Integer codigoAreaTrabajoEstadoPedido1 ){
		this.codigoAreaTrabajoEstadoPedido=codigoAreaTrabajoEstadoPedido1;
		
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

		
//
//	/**
//	 * Retorna valor de propiedad <code>codigoLocal</code>
//	 * @return 
//	 * 		Retorna valor de propiedad <code>codigoLocal</code>
//	 */
//	public Integer getCodigoLocal(){
//		return this.codigoLocal;
//	}
//
//	/**
//	 * Establece un nuevo valor para la propiedad <code>codigoLocal</code>.
//	 * @param codigoLocal1 
//	 *		El valor a establecer para la propiedad <code>codigoLocal</code>.
//	 */
//	public void setCodigoLocal( Integer codigoLocal1 ){
//		this.codigoLocal=codigoLocal1;
//		
//	}

		

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
	 * Retorna valor de propiedad <code>codigoAreaTrabajoEntrega</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoAreaTrabajoEntrega</code>
	 */
	public Integer getCodigoAreaTrabajoEntrega(){
		return this.codigoAreaTrabajoEntrega;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoAreaTrabajoEntrega</code>.
	 * @param codigoAreaTrabajoEntrega1 
	 *		El valor a establecer para la propiedad <code>codigoAreaTrabajoEntrega</code>.
	 */
	public void setCodigoAreaTrabajoEntrega( Integer codigoAreaTrabajoEntrega1 ){
		this.codigoAreaTrabajoEntrega=codigoAreaTrabajoEntrega1;
		
	}

		

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
	 * Retorna valor de propiedad <code>codigoDivGeoPol</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoDivGeoPol</code>
	 */
	public String getCodigoDivGeoPol(){
		return this.codigoDivGeoPol;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoDivGeoPol</code>.
	 * @param codigoDivGeoPol1 
	 *		El valor a establecer para la propiedad <code>codigoDivGeoPol</code>.
	 */
	public void setCodigoDivGeoPol( String codigoDivGeoPol1 ){
		this.codigoDivGeoPol=codigoDivGeoPol1;
		
		if(codigoDivGeoPol!=null && codigoDivGeoPol.length()>10){
			codigoDivGeoPol = codigoDivGeoPol.substring(0,10);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>direccionEntrega</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>direccionEntrega</code>
	 */
	public String getDireccionEntrega(){
		return this.direccionEntrega;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>direccionEntrega</code>.
	 * @param direccionEntrega1 
	 *		El valor a establecer para la propiedad <code>direccionEntrega</code>.
	 */
	public void setDireccionEntrega( String direccionEntrega1 ){
		this.direccionEntrega=direccionEntrega1;
		
		if(direccionEntrega!=null && direccionEntrega.length()>1024){
			direccionEntrega = direccionEntrega.substring(0,1024);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>costoEntrega</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>costoEntrega</code>
	 */
	public Double getCostoEntrega(){
		return this.costoEntrega;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>costoEntrega</code>.
	 * @param costoEntrega1 
	 *		El valor a establecer para la propiedad <code>costoEntrega</code>.
	 */
	public void setCostoEntrega( Double costoEntrega1 ){
		this.costoEntrega=costoEntrega1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>fechaEntregaCliente</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaEntregaCliente</code>
	 */
	public Timestamp getFechaEntregaCliente(){
		return this.fechaEntregaCliente;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaEntregaCliente</code>.
	 * @param fechaEntregaCliente1 
	 *		El valor a establecer para la propiedad <code>fechaEntregaCliente</code>.
	 */
	public void setFechaEntregaCliente(Timestamp fechaEntregaCliente1 ){
		this.fechaEntregaCliente=fechaEntregaCliente1;
		
	}

		
	/**
	 * Retorna propiedad <code>fechaEntregaCliente</code> como String
	 * @return 
	 * 	Retorna propiedad <code>fechaEntregaCliente</code> como String
	 */
	public String getFechaEntregaClienteS() {
		return (this.fechaEntregaCliente!=null) ? ConverterUtil.getYMDDateFormat().format(this.fechaEntregaCliente):null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>fechaEntregaCliente</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>fechaEntregaCliente</code>.
	 */
	public void setFechaEntregaClienteS(String cadena) {
		try {
			this.fechaEntregaCliente = new Timestamp((cadena != null) ? ConverterUtil.getYMDDateFormat().parse(cadena).getTime() : null);
		} catch (Exception ex) {
			Logeable.LOG_SICV2.error(ex.getMessage());
		}
	}
			

	/**
	 * Retorna valor de propiedad <code>fechaDespachoBodega</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>fechaDespachoBodega</code>
	 */
	public Timestamp getFechaDespachoBodega(){
		return this.fechaDespachoBodega;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaDespachoBodega</code>.
	 * @param fechaDespachoBodega1 
	 *		El valor a establecer para la propiedad <code>fechaDespachoBodega</code>.
	 */
	public void setFechaDespachoBodega(Timestamp fechaDespachoBodega1 ){
		this.fechaDespachoBodega=fechaDespachoBodega1;
		
	}

		
	/**
	 * Retorna propiedad <code>fechaDespachoBodega</code> como String
	 * @return 
	 * 	Retorna propiedad <code>fechaDespachoBodega</code> como String
	 */
	public String getFechaDespachoBodegaS() {
		return (this.fechaDespachoBodega!=null) ? ConverterUtil.getYMDDateFormat().format(this.fechaDespachoBodega) : null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>fechaDespachoBodega</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>fechaDespachoBodega</code>.
	 */
	public void setFechaDespachoBodegaS(String cadena) {
		try{
			this.fechaDespachoBodega = new Timestamp((cadena!=null) ? ConverterUtil.getYMDDateFormat().parse(cadena).getTime():null);
		}catch(Exception ex){Logeable.LOG_SICV2.error(ex.getMessage());}
	}	
			

	/**
	 * Retorna valor de propiedad <code>tipoEntrega</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>tipoEntrega</code>
	 */
	public String getTipoEntrega(){
		return this.tipoEntrega;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tipoEntrega</code>.
	 * @param tipoEntrega1 
	 *		El valor a establecer para la propiedad <code>tipoEntrega</code>.
	 */
	public void setTipoEntrega( String tipoEntrega1 ){
		this.tipoEntrega=tipoEntrega1;
		
		if(tipoEntrega!=null && tipoEntrega.length()>3){
			tipoEntrega = tipoEntrega.substring(0,3);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>codigoEntregaPedidoPrevio</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoEntregaPedidoPrevio</code>
	 */
	public java.lang.Long getCodigoEntregaPedidoPrevio(){
		return this.codigoEntregaPedidoPrevio;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoEntregaPedidoPrevio</code>.
	 * @param codigoEntregaPedidoPrevio1 
	 *		El valor a establecer para la propiedad <code>codigoEntregaPedidoPrevio</code>.
	 */
	public void setCodigoEntregaPedidoPrevio( java.lang.Long codigoEntregaPedidoPrevio1 ){
		this.codigoEntregaPedidoPrevio=codigoEntregaPedidoPrevio1;
		
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
		return (this.fechaRegistro!=null) ? ConverterUtil.getYMDDateFormat().format(this.fechaRegistro) : null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>fechaRegistro</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>fechaRegistro</code>.
	 */
	public void setFechaRegistroS(String cadena) {
		try{
			this.fechaRegistro = (cadena!=null) ? ConverterUtil.getYMDDateFormat().parse(cadena) : null;
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
		return (this.fechaModificacion!=null) ? ConverterUtil.getYMDDateFormat().format(this.fechaModificacion) : null;
	}
	/**
	 * Permite establecer el valor de la propiedad <code>fechaModificacion</code> a partir de un String de fecha
	 * @param cadena 	String que representa el valor formateado para establecer <code>fechaModificacion</code>.
	 */
	public void setFechaModificacionS(String cadena) {
		try{
			this.fechaModificacion = (cadena!=null) ? ConverterUtil.getYMDDateFormat().parse(cadena) : null;
		}catch(Exception ex){Logeable.LOG_SICV2.error(ex.getMessage());}
	}	
	
	/**
	 * Retorna valor de propiedad <code>quienRecibira</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>quienRecibira</code>
	 */
	public String getQuienRecibira(){
		return this.quienRecibira;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>quienRecibira</code>.
	 * @param quienRecibira1 
	 *		El valor a establecer para la propiedad <code>quienRecibira</code>.
	 */
	public void setQuienRecibira( String quienRecibira1 ){
		this.quienRecibira=quienRecibira1;
		
		if(quienRecibira!=null && quienRecibira.length()>256){
			quienRecibira = quienRecibira.substring(0,256);
		}
	}

	/**
	 * Retorna valor de propiedad <code>codigoVendedor</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoVendedor</code>
	 */
	public Long getCodigoVendedor(){
		return this.codigoVendedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoVendedor</code>.
	 * @param codigoVendedor1 
	 *		El valor a establecer para la propiedad <code>codigoVendedor</code>.
	 */
	public void setCodigoVendedor( Long codigoVendedor1 ){
		this.codigoVendedor=codigoVendedor1;
	}
	
	/**
	 * Retorna valor de propiedad <code>horasEntrega</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>horasEntrega</code>
	 */
	public String getHorasEntrega(){
		return this.horasEntrega;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>horasEntrega</code>.
	 * @param horasEntrega1 
	 *		El valor a establecer para la propiedad <code>horasEntrega</code>.
	 */
	public void setHorasEntrega( String horasEntrega1 ){
		this.horasEntrega=horasEntrega1;
		
		if(horasEntrega!=null && horasEntrega.length()>16){
			horasEntrega = horasEntrega.substring(0,16);
		}
	}
	
	

	/**
	 * Retorna valor de propiedad <code>observacionEntrega</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>observacionEntrega</code>
	 */
	public String getObservacionEntrega(){
		return this.observacionEntrega;
	}
	

	/**
	 * Establece un nuevo valor para la propiedad <code>observacionEntrega</code>.
	 * @param observacionEntrega1 
	 *		El valor a establecer para la propiedad <code>observacionEntrega</code>.
	 */
	public void setObservacionEntrega( String observacionEntrega1 ){
		this.observacionEntrega=observacionEntrega1;
		
		if(observacionEntrega != null && observacionEntrega.length() > 512){
			observacionEntrega = observacionEntrega.substring(0,512);
		}
	}
	
			
	/**
	 * Retorna valor de propiedad <code>estadoPedidoDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estadoPedidoDTO</code>
	 */
//	public ec.com.smx.sic.sispe.dto.EstadoPedidoDTO getEstadoPedidoDTO(){
//		return this.estadoPedidoDTO;
//	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoPedidoDTO</code>.
	 * @param estadoPedidoDTO1 
	 *		El valor a establecer para la propiedad <code>estadoPedidoDTO</code>.
//	 */
//	public void setEstadoPedidoDTO( ec.com.smx.sic.sispe.dto.EstadoPedidoDTO estadoPedidoDTO1 ){
//		this.estadoPedidoDTO=estadoPedidoDTO1;
//	}


	/**
	 * Retorna valor de propiedad <code>areaTrabajoEntrega</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>areaTrabajoEntrega</code>
	 */
//	public AreaTrabajoDTO getAreaTrabajoEntrega(){
//		return this.areaTrabajoEntrega;
//	}
//
//	/**
//	 * Establece un nuevo valor para la propiedad <code>areaTrabajoEntrega</code>.
//	 * @param areaTrabajoEntrega1 
//	 *		El valor a establecer para la propiedad <code>areaTrabajoEntrega</code>.
//	 */
//	public void setAreaTrabajoEntrega( AreaTrabajoDTO areaTrabajoEntrega1 ){
//		this.areaTrabajoEntrega=areaTrabajoEntrega1;
//	}


	/**
	 * Retorna valor de propiedad <code>bodegaDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>bodegaDTO</code>
	 */
//	public BodegaDTO getBodegaDTO(){
//		return this.bodegaDTO;
//	}
//
//	/**
//	 * Establece un nuevo valor para la propiedad <code>bodegaDTO</code>.
//	 * @param bodegaDTO1 
//	 *		El valor a establecer para la propiedad <code>bodegaDTO</code>.
//	 */
//	public void setBodegaDTO( BodegaDTO bodegaDTO1 ){
//		this.bodegaDTO=bodegaDTO1;
//	}


	/**
	 * Retorna valor de propiedad <code>divisionGeoPoliticaDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>divisionGeoPoliticaDTO</code>
	 */
//	public DivisionGeoPoliticaDTO getDivisionGeoPoliticaDTO(){
//		return this.divisionGeoPoliticaDTO;
//	}
//
//	/**
//	 * Establece un nuevo valor para la propiedad <code>divisionGeoPoliticaDTO</code>.
//	 * @param divisionGeoPoliticaDTO1 
//	 *		El valor a establecer para la propiedad <code>divisionGeoPoliticaDTO</code>.
//	 */
//	public void setDivisionGeoPoliticaDTO(DivisionGeoPoliticaDTO divisionGeoPoliticaDTO1 ){
//		this.divisionGeoPoliticaDTO=divisionGeoPoliticaDTO1;
//	}


	/**
	 * Retorna valor de propiedad <code>entregaPedidoPrevioDTO</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>entregaPedidoPrevioDTO</code>
	 */
//	public ec.com.smx.sic.sispe.dto.EntregaPedidoDTO getEntregaPedidoPrevioDTO(){
//		return this.entregaPedidoPrevioDTO;
//	}
//
//	/**
//	 * Establece un nuevo valor para la propiedad <code>entregaPedidoPrevioDTO</code>.
//	 * @param entregaPedidoPrevioDTO1 
//	 *		El valor a establecer para la propiedad <code>entregaPedidoPrevioDTO</code>.
//	 */
//	public void setEntregaPedidoPrevioDTO( ec.com.smx.sic.sispe.dto.EntregaPedidoDTO entregaPedidoPrevioDTO1 ){
//		this.entregaPedidoPrevioDTO=entregaPedidoPrevioDTO1;
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


//	public ClienteBeneficiarioDTO getClienteBeneficiarioEntregaDTO() {
//		return clienteBeneficiarioEntregaDTO;
//	}
//
//	public void setClienteBeneficiarioEntregaDTO(
//			ClienteBeneficiarioDTO clienteBeneficiarioEntregaDTO) {
//		this.clienteBeneficiarioEntregaDTO = clienteBeneficiarioEntregaDTO;
//	}
//
//	public ClienteBeneficiarioDTO getClienteBeneficiarioDocumentoDTO() {
//		return clienteBeneficiarioDocumentoDTO;
//	}
//
//	public void setClienteBeneficiarioDocumentoDTO(
//			ClienteBeneficiarioDTO clienteBeneficiarioDocumentoDTO) {
//		this.clienteBeneficiarioDocumentoDTO = clienteBeneficiarioDocumentoDTO;
//	}

	public java.lang.Long getCodCliBenEntrega() {
		return codCliBenEntrega;
	}

	public void setCodCliBenEntrega(java.lang.Long codCliBenEntrega) {
		this.codCliBenEntrega = codCliBenEntrega;
	}

	public java.lang.Long getCodCliBenDocumento() {
		return codCliBenDocumento;
	}

	public void setCodCliBenDocumento(java.lang.Long codCliBenDocumento) {
		this.codCliBenDocumento = codCliBenDocumento;
	}

	/**
	 * Coleccion entrega detalle pedido
	 * @return
	 */
//	public Collection<EntregaDetallePedidoEspecialDTO> getEntregaDetallePedidoCol() {
//		return entregaDetallePedidoCol;
//	}
//
//	/**
//	 * @param entregaDetallePedidoCol
//	 */
//	public void setEntregaDetallePedidoCol(
//			Collection<EntregaDetallePedidoEspecialDTO> entregaDetallePedidoCol) {
//		this.entregaDetallePedidoCol = entregaDetallePedidoCol;
//	}

	public Integer getCodigoAlcanceEntrega() {
		return codigoAlcanceEntrega;
	}

	public void setCodigoAlcanceEntrega(Integer codigoAlcanceEntrega) {
		this.codigoAlcanceEntrega = codigoAlcanceEntrega;
	}

	public Integer getCodigoObtenerStock() {
		return codigoObtenerStock;
	}

	public void setCodigoObtenerStock(Integer codigoObtenerStock) {
		this.codigoObtenerStock = codigoObtenerStock;
	}

	public Integer getCodigoContextoEntrega() {
		return codigoContextoEntrega;
	}

	public void setCodigoContextoEntrega(Integer codigoContextoEntrega) {
		this.codigoContextoEntrega = codigoContextoEntrega;
	}

//	public Integer getCodConResDes() {
//		return codConResDes;
//	}
//
//	public void setCodConResDes(Integer codConResDes) {
//		this.codConResDes = codConResDes;
//	}
//
//	public Integer getCodConResPro() {
//		return codConResPro;
//	}
//
//	public void setCodConResPro(Integer codConResPro) {
//		this.codConResPro = codConResPro;
//	}

	public Integer getCodConResEnt() {
		return codConResEnt;
	}

	public void setCodConResEnt(Integer codConResEnt) {
		this.codConResEnt = codConResEnt;
	}

	public Integer getCodConResPed() {
		return codConResPed;
	}

	public void setCodConResPed(Integer codConResPed) {
		this.codConResPed = codConResPed;
	}

	public String getCodigoCiudadSectorEntrega() {
		return codigoCiudadSectorEntrega;
	}

	public void setCodigoCiudadSectorEntrega(String codigoCiudadSectorEntrega) {
		this.codigoCiudadSectorEntrega = codigoCiudadSectorEntrega;
	}

	public String getElaCanEsp() {
		return elaCanEsp;
	}

	public void setElaCanEsp(String elaCanEsp) {
		this.elaCanEsp = elaCanEsp;
	}

	public Double getDistanciaEntrega() {
		return distanciaEntrega;
	}

	public void setDistanciaEntrega(Double distanciaEntrega) {
		this.distanciaEntrega = distanciaEntrega;
	}

//	public ConfiguracionDTO getConfiguracionContextoDTO() {
//		return configuracionContextoDTO;
//	}
//
//	public void setConfiguracionContextoDTO(
//			ConfiguracionDTO configuracionContextoDTO) {
//		this.configuracionContextoDTO = configuracionContextoDTO;
//	}
//
//	public ConfiguracionDTO getConfiguracionAlcanceDTO() {
//		return configuracionAlcanceDTO;
//	}
//
//	public void setConfiguracionAlcanceDTO(ConfiguracionDTO configuracionAlcanceDTO) {
//		this.configuracionAlcanceDTO = configuracionAlcanceDTO;
//	}
//
//	public ConfiguracionDTO getConfiguracionStockDTO() {
//		return configuracionStockDTO;
//	}
//
//	public void setConfiguracionStockDTO(ConfiguracionDTO configuracionStockDTO) {
//		this.configuracionStockDTO = configuracionStockDTO;
//	}

//	public ConfiguracionDTO getConfiguracionResDesDTO() {
//		return configuracionResDesDTO;
//	}
//
//	public void setConfiguracionResDesDTO(ConfiguracionDTO configuracionResDesDTO) {
//		this.configuracionResDesDTO = configuracionResDesDTO;
//	}
//
//	public ConfiguracionDTO getConfiguracionResProDTO() {
//		return configuracionResProDTO;
//	}
//
//	public void setConfiguracionResProDTO(ConfiguracionDTO configuracionResProDTO) {
//		this.configuracionResProDTO = configuracionResProDTO;
//	}

//	public ConfiguracionDTO getConfiguracionResEntDTO() {
//		return configuracionResEntDTO;
//	}
//
//	public void setConfiguracionResEntDTO(ConfiguracionDTO configuracionResEntDTO) {
//		this.configuracionResEntDTO = configuracionResEntDTO;
//	}
//
//	public ConfiguracionDTO getConfiguracionResPedDTO() {
//		return configuracionResPedDTO;
//	}
//
//	public void setConfiguracionResPedDTO(ConfiguracionDTO configuracionResPedDTO) {
//		this.configuracionResPedDTO = configuracionResPedDTO;
//	}
//
//	public DivisionGeoPoliticaDTO getDivisionGeoPolCiudadSectorDTO() {
//		return divisionGeoPolCiudadSectorDTO;
//	}
//
//	public void setDivisionGeoPolCiudadSectorDTO(
//			DivisionGeoPoliticaDTO divisionGeoPolCiudadSectorDTO) {
//		this.divisionGeoPolCiudadSectorDTO = divisionGeoPolCiudadSectorDTO;
//	}

	/**
	 * @return the npDireccionEntregaDomicilio
	 */
	public String getNpDireccionEntregaDomicilio() {
		return npDireccionEntregaDomicilio;
	}

	/**
	 * @param npDireccionEntregaDomicilio the npDireccionEntregaDomicilio to set
	 */
	public void setNpDireccionEntregaDomicilio(String npDireccionEntregaDomicilio) {
		this.npDireccionEntregaDomicilio = npDireccionEntregaDomicilio;
	}

	/**
	 * @return the npValidarCheckTransito
	 */
	public String getNpValidarCheckTransito() {
		return npValidarCheckTransito;
	}

	/**
	 * @param npValidarCheckTransito the npValidarCheckTransito to set
	 */
	public void setNpValidarCheckTransito(String npValidarCheckTransito) {
		this.npValidarCheckTransito = npValidarCheckTransito;
	}

	/**
	 * @return the npPasoObligatorioBodegaTransito
	 */
	public String getNpPasoObligatorioBodegaTransito() {
		return npPasoObligatorioBodegaTransito;
	}

	/**
	 * @param npPasoObligatorioBodegaTransito the npPasoObligatorioBodegaTransito to set
	 */
	public void setNpPasoObligatorioBodegaTransito(
			String npPasoObligatorioBodegaTransito) {
		this.npPasoObligatorioBodegaTransito = npPasoObligatorioBodegaTransito;
	}

	/**
	 * @return the npValorCodigoTransito
	 */
	public String getNpValorCodigoTransito() {
		return npValorCodigoTransito;
	}

	/**
	 * @param npValorCodigoTransito the npValorCodigoTransito to set
	 */
	public void setNpValorCodigoTransito(String npValorCodigoTransito) {
		this.npValorCodigoTransito = npValorCodigoTransito;
	}

	/**
	 * @return the calendarioDiaLocalDTO
	 */
//	public CalendarioDiaLocalDTO getCalendarioDiaLocalDTO() {
//		return calendarioDiaLocalDTO;
//	}
//
//	/**
//	 * @param calendarioDiaLocalDTO the calendarioDiaLocalDTO to set
//	 */
//	public void setCalendarioDiaLocalDTO(CalendarioDiaLocalDTO calendarioDiaLocalDTO) {
//		this.calendarioDiaLocalDTO = calendarioDiaLocalDTO;
//	}

	/**
	 * @return the costoParcialEntrega
	 */
	public Double getCostoParcialEntrega() {
		return costoParcialEntrega;
	}

	/**
	 * @param costoParcialEntrega the costoParcialEntrega to set
	 */
	public void setCostoParcialEntrega(Double costoParcialEntrega) {
		this.costoParcialEntrega = costoParcialEntrega;
	}

	/**
	 * @return the npDetallePedido
	 */
//	public Collection<DetallePedidoDTO> getNpDetallePedido() {
//		return npDetallePedido;
//	}
//
//	/**
//	 * @param npDetallePedido the npDetallePedido to set
//	 */
//	public void setNpDetallePedido(Collection<DetallePedidoDTO> npDetallePedido) {
//		this.npDetallePedido = npDetallePedido;
//	}

	/**
	 * @return the npFiltarPorEntregasLocalOdomicilio
	 */
	public Boolean getNpFiltarPorEntregasLocalOdomicilio() {
		return npFiltarPorEntregasLocalOdomicilio;
	}

	/**
	 * @param npFiltarPorEntregasLocalOdomicilio the npFiltarPorEntregasLocalOdomicilio to set
	 */
	public void setNpFiltarPorEntregasLocalOdomicilio(
			Boolean npFiltarPorEntregasLocalOdomicilio) {
		this.npFiltarPorEntregasLocalOdomicilio = npFiltarPorEntregasLocalOdomicilio;
	}
	
	/**
	 * @return the npFiltrarPorCodigosCD
	 */
	public Boolean getNpFiltrarPorCodigosCD() {
		return npFiltrarPorCodigosCD;
	}

	/**
	 * @param npFiltrarPorCodigosCD the npFiltrarPorCodigosCD to set
	 */
	public void setNpFiltrarPorCodigosCD(Boolean npFiltrarPorCodigosCD) {
		this.npFiltrarPorCodigosCD = npFiltrarPorCodigosCD;
	}
	
	/**
	 * Si se cargo los detalles de cada entrega.
	 * @return
	 */
//	public Boolean getDetalleEntregasPedido() {
//		return isLoaded(this.entregaDetallePedidoCol) && !this.entregaDetallePedidoCol.isEmpty();
//	}

//	public AutorizacionDTO getAutorizacionDTO() {
//		return autorizacionDTO;
//	}
//
//	public void setAutorizacionDTO(AutorizacionDTO autorizacionDTO) {
//		this.autorizacionDTO = autorizacionDTO;
//	}

	public Long getNpContadorBeneficiario() {
		return npContadorBeneficiario;
	}

	public void setNpContadorBeneficiario(Long npContadorBeneficiario) {
		this.npContadorBeneficiario = npContadorBeneficiario;
	}

	public String getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	public void setCodigoAutorizacion(String codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}

	public Integer getCodigoLocalSector() {
		return codigoLocalSector;
	}

	public void setCodigoLocalSector(Integer codigoLocalSector) {
		this.codigoLocalSector = codigoLocalSector;
	}

//	public LocalDTO getLocalSectorDTO() {
//		return localSectorDTO;
//	}
//
//	public void setLocalSectorDTO(LocalDTO localSectorDTO) {
//		this.localSectorDTO = localSectorDTO;
//	}

	/**
	 * @return the entregaPedidoConvenioCol
	 */
//	public Collection<EntregaPedidoEspecialConvenioDTO> getEntregaPedidoConvenioCol() {
//		return entregaPedidoConvenioCol;
//	}
//
//	/**
//	 * @param entregaPedidoConvenioCol the entregaPedidoConvenioCol to set
//	 */
//	public void setEntregaPedidoConvenioCol(Collection<EntregaPedidoEspecialConvenioDTO> entregaPedidoConvenioCol) {
//		this.entregaPedidoConvenioCol = entregaPedidoConvenioCol;
//	}

	public Integer getSeleccionMouse() {
		return seleccionMouse;
	}

	public void setSeleccionMouse(Integer seleccionMouse) {
		this.seleccionMouse = seleccionMouse;
	}

	public Double getNpValorParcialEntrega() {
		return npValorParcialEntrega;
	}

	public void setNpValorParcialEntrega(Double npValorParcialEntrega) {
		this.npValorParcialEntrega = npValorParcialEntrega;
	}

	public String getNpResProduccion() {
		return npResProduccion;
	}

	public void setNpResProduccion(String npResProduccion) {
		this.npResProduccion = npResProduccion;
	}

	public String getNpResDespacho() {
		return npResDespacho;
	}

	public void setNpResDespacho(String npResDespacho) {
		this.npResDespacho = npResDespacho;
	}

	public EntregaPedidoEspecialID getId() {
		return id;
	}

	public void setId(EntregaPedidoEspecialID id1) {
		this.id = id1;
	}
	
	public EntregaPedidoEspecialDTO(){
		this.id=new EntregaPedidoEspecialID();
	}
	
}

