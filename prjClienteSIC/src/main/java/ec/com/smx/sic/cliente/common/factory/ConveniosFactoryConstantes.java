package ec.com.smx.sic.cliente.common.factory;



/**
 * @author srodriguez
 * 2014-09-10
*/

public class ConveniosFactoryConstantes {
	/**
	 * Rutas de las configuraciones de Spring para el motor de inventarios
	 */
	public static final String[] CONTEXTO = new String[]{
			ConveniosFactoryConstantes.CONTEXT_CONVENIO_DAO_BEANS,
			ConveniosFactoryConstantes.CONTEXT_LOYALTY_WEBSERVICE_CONVENIOS_PROMOCION,
			ConveniosFactoryConstantes.CONTEXT_CONVENIO_GESTOR_BEANS,
			ConveniosFactoryConstantes.CONTEXT_CONVENIO_SERVICE_BEANS,
			ConveniosFactoryConstantes.CONTEXT_LOYALTY_CONVENIOS,
			ConveniosFactoryConstantes.CONTEXT_TAREA_PROGRAMADA_THREAD,
			ConveniosFactoryConstantes.CONTEXT_ORDEN_COMPRA_NEGOCIACION_SERVICE_BEANS,
			ConveniosFactoryConstantes.CONTEXT_FACTURACION_BEANS,
			ConveniosFactoryConstantes.CONTEXT_FACTURACION_PERSISTENCIA_BEANS,
			ConveniosFactoryConstantes.CONTEXT_FACTURACION_AUDITORIA_PERSISTENCIA_BEANS,
			ConveniosFactoryConstantes.CONTEXT_FACTURACION_AUDITORIA_BEANS,
			ConveniosFactoryConstantes.CONTEXT_FACTURACION_SPRING_BEANS,
			ConveniosFactoryConstantes.CONTEXT_FACTURACION_INMOVILIARIA_BEANS,
			ConveniosFactoryConstantes.CONTEXT_FACTURACION_FIRMADIGITAL_BEANS
//			ConveniosFactoryConstantes.CONTEXT_LOYALTY_WEBSERVICE_CONVENIOS_CAMPANIA,
//			ConveniosFactoryConstantes.CONTEXT_LOYALTY_WEBSERVICE_CONVENIOS_PROMOCION
	};
	
	
	//Rutas de contexto
	public static final String CONTEXT_CONVENIO_GESTOR_BEANS ="/ec/com/smx/sic/convenio/spring/config/ConvenioGestorBeans.xml";
	public static final String CONTEXT_CONVENIO_SERVICE_BEANS = "/ec/com/smx/sic/convenio/spring/config/ConvenioServiceBeans.xml";
	public static final String CONTEXT_CONVENIO_DAO_BEANS="/ec/com/smx/sic/convenio/spring/config/ConvenioDaoBeans.xml";
	public static final String CONTEXT_LOYALTY_CONVENIOS="/ec/com/smx/sic/administracion/spring/config/SICLoyaltyFactoryBeans.xml";
	public static final String CONTEXT_TAREA_PROGRAMADA_THREAD="/ec/com/smx/sic/convenio/spring/config/ConvenioThreadBeans.xml";
	public static final String CONTEXT_LOYALTY_WEBSERVICE_CONVENIOS_PROMOCION="/ec/com/smx/sic/cliente/loyalty/spring/config/soap/SICIntegracionLoyaltyWSActivaPromocionServicio.xml";
	public static final String CONTEXT_ORDEN_COMPRA_NEGOCIACION_SERVICE_BEANS = "/ec/com/smx/sic/convenio/spring/config/OrdenCompraNegociacionServiceBeans.xml";
	public static final String CONTEXT_FACTURACION_BEANS="/ec/com/smx/facturacion/spring/config/FacturacionDocFiscal.xml";
	public static final String CONTEXT_FACTURACION_PERSISTENCIA_BEANS="/ec/com/smx/facturacion/spring/config/FacturacionPersistenciaSpring.xml";
	public static final String CONTEXT_FACTURACION_AUDITORIA_BEANS="/ec/com/smx/auditoria/spring/config/AuditoriaFiscalSpring.xml";
	public static final String CONTEXT_FACTURACION_AUDITORIA_PERSISTENCIA_BEANS="/ec/com/smx/auditoria/spring/config/AuditoriaPersistenciaSpring.xml";
	public static final String CONTEXT_FACTURACION_SPRING_BEANS="/ec/com/smx/facturacion/spring/config/FacturacionSpring.xml";
	public static final String CONTEXT_FACTURACION_INMOVILIARIA_BEANS="/ec/com/smx/sim/spring/config/InmobiliarioIntegracionGestorBeans.xml";
	public static final String CONTEXT_FACTURACION_FIRMADIGITAL_BEANS="/ec/com/kruger/firma/digital/spring/config/FirmaDigitalSpring.xml";
//	static final String CONTEXT_LOYALTY_WEBSERVICE_CONVENIOS_PROMOCION="/ec/com/smx/sic/integracion/loyalty/spring/config/webservice/SICIntegracionLoyaltyWSActivaPromocionServicio.xml";
	
	//Id's de los servicios (Beans)
	public static final String SEGURIDAD_OPCIONES_PANEL = "cemSeguridadServicio";
	public static final String EMPRESA_PARTICIPANTE_SERVICIO="cemEmpresaParticipanteServicio";
	public static final String CONVENIO_PARTICIPANTE_SERVICIO="cemConvenioParticipanteServicio";
	public static final String CAMPANIA_PROMOCION_SERVICIO="cemCampaniaPromocionServicio";
	public static final String CATALOGO_CONVENIO_SERVICIO="cemCatalogoConvenioServicio";
	public static final String NEGOCIACION_SERVICIO="cemNegociacionServicio";
	public static final String RECUPERACION_VENTAS_SERVICIO="cemRecuperacionVentasServicio";
	public static final String PROCESAMIENTO_VENTAS_SERVICIO="cemProcesamientoVentasServicio";
//    static final String CONVENIO_WS_CLIENTE_CAMPANIA="sicLoyaltyCampaniasService";
//    static final String CONVENIO_WS_CLIENTE_PROMOCION = "sicLoyaltyPromocionService";
	public static final String CONFIGURACION_DATOS_PROCESADOS="cemConfiguracionDatosProcesadosServicio";
    public static final String DEFINICION_CONFIGURACION = "cemDefinicionConfiguracionServicio";
    public static final String NEGOCIACION_COBRO_SERVICIO ="cemNegociacionCobroServicio";
    public static final String REGISTRO_COBRO_SERVICIO ="cemRegistroCobroServicio";
    public static final String TAREA_PROGRAMADA_RECUPERACION_VENTAS="cemTareaProgramadaRecuperacionVentas";
    public static final String TAREA_PROGRAMADA_PROCESAMIENTO_VENTAS="cemTareaProgramadaProcesamientoVentas";
    public static final String ORDEN_COMPRA_NEGOCIACION_ARTICULO="cemOrdenCompraNegociacionArticuloServicio";
    public static final String PARAMETRO_CONVENIO_SERVICIO="cemParametroConvenioServicio";
}
