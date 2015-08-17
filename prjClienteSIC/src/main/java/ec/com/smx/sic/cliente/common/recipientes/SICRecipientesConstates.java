package ec.com.smx.sic.cliente.common.recipientes;

import ec.com.smx.sic.cliente.resources.recipientes.SICRecipientesMessages;

/**
 * 
 * @author cherrera
 *
 */
public class SICRecipientesConstates {
	
	private static final SICRecipientesConstates INSTANCIA = new SICRecipientesConstates();
	
	public static SICRecipientesConstates getInstancia(){
		return INSTANCIA;
	}
	
	/*CONFIGURACION RECIPIENTES*/
	
	//URLS
	public static final String URL_CREACION_CAJA_DEPARTAMENTAL=  SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.proceso.22");
	public static final String URL_CREACION_PALLET_AGRUPADO= SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.proceso.23");
	public static final String URL_CREACION_TRANSFERENCIA_RECIPIENTES=SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.proceso.24");
	public static final String URL_CREACION_TRANSFERENCIA_DEVOLUCION_PROVEEDOR=SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.proceso.29");
	
	public static final String URL_VISUALIZACION_DETALLE_TRANSFERENCIA=SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.visualizacion.detalle.transferencias.url");
	public static final String URL_VISUALIZACION_DETALLE_TRANSFERENCIA_RECIPIENTES=SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.visualizacion.detalle.transferenciasRecipientes.url");
	
	public static final String URL_BUSQUEDA_TRANSFERENCIA_SSALIQ=SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.admin.transferenciaSsaLiq.url");
	public static final String URL_BUSQUEDA_TRANSFERENCIA_DEVOLUCION_JABAS = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.admin.transferenciaDevolucionJabas.url");
	public static final String URL_BUSQUEDA_TRANSFERENCIA_DEVOLUCION_PROVEEDOR = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.admin.transferenciaDevolucionProveedor.url");
	public static final String URL_BUSQUEDA_TRANSFERENCIA_RESERVA_MERCANCIAS_TIENDA = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.admin.transferenciaReservaMercanciasTienda.url");
	public static final String URL_BUSQUEDA_TRANSFERENCIA_TEST_TIPO_TRANSACCION = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.admin.transferenciaTestTipoTransaccion.url");

	public static final String URL_BUSQUEDA_TRANSFERENCIA_SSALIQ_CENTER = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.busqueda.transferenciaSSaLiq.url");
	public static final String URL_BUSQUEDA_TRANSFERENCIA_DEVJAB_CENTER = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.busqueda.transferenciaDevJab.url");
	
	public static final String TIPO_CONTENEDOR = SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.articulo.codigo.clasificacion");
	public static final Integer CODIGO_TIPO_CAMBIO_ESTADO = SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.estados.acciones.cambioEstado");
	
	
}
