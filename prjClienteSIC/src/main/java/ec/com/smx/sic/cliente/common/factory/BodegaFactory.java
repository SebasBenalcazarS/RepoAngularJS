package ec.com.smx.sic.cliente.common.factory;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.servicio.bodega.IAsignacionAutomaticaFuncionarioTareaServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IAsignacionUsuariosBodegaServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IAutorizacionesClaveServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IBodegaArticuloCalculoServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IBodegaServicio;
import ec.com.smx.sic.cliente.servicio.bodega.ICalendarioPlanificacionBodegaServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IConfiguracionesRecepcionServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IDespachoBodegaServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IEdicionDatosExtraServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IEntregasProveedorServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IEstructuraLogisticaServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IFacturaDigitalServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IFacturasProveedorServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IIntegracionBodegaRecepcionServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IModificarPalletsRecepcionServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IMontacargaCorredorServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IPalletJackRecepcionServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IProgramasMontacarguistaServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IRecepcionBodegaServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IRecepcionFacturaInternaServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IRecepcionFuncionarioServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IRecepcionNovedadesServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IRecepcionOrdenCompraServicio;
import ec.com.smx.sic.cliente.servicio.bodega.IRecepcionProveedorServicioScanner;
import ec.com.smx.sic.cliente.servicio.bodega.IRecepcionProveedoresServicio;
import ec.com.smx.sic.cliente.servicio.tareas.ITareasBodegaServicio;

public class BodegaFactory extends SICSpringContextFactory{
	
	/**
	 * Obtiene una referencia del servicio IBodegaServicio
	 * @return Un IBodegaServicio
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public IBodegaServicio getBodegaServicio() throws SICException{
		return (IBodegaServicio) getBean(SICFactoryConstantes.BODEGA_ADMINISTRACION_SERVICIOS);
	}
	
	public IDespachoBodegaServicio getDespachoBodegaServicio() throws SICException{
		return (IDespachoBodegaServicio) getBean(SICFactoryConstantes.BODEGA_DESPACHO_BODEGA_SERVICIOS);
	}
	/**
	 * Obtiene una referencia del servicio IEstructuraLogisticaServicio
	 * @return Un IEstructuraLogisticaServicio
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public IEstructuraLogisticaServicio getEstructuraLogisticaServicio() throws SICException{
		return (IEstructuraLogisticaServicio) getBean(SICFactoryConstantes.BODEGA_ESTRUCTURA_LOGISTICA_SERVICIOS);
	}
	
	/**
	 * Obtiene una referencia del servicio IRecepcionBodegaServicio
	 * @return Un IRecepcionBodegaServicio
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public IRecepcionBodegaServicio getRecepcionBodegaServicio() throws SICException{
		return (IRecepcionBodegaServicio) getBean(SICFactoryConstantes.BODEGA_RECEPCION_SERVICIOS);
	}
	
	/**
	 * Obtiene una referencia del servicio IRecepcionFacturaInternaServicio
	 * @return Un IRecepcionFacturaInternaServicio
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public IRecepcionFacturaInternaServicio getRecepcionFacturaInternaServicio() throws SICException {
		return (IRecepcionFacturaInternaServicio) getBean(SICFactoryConstantes.BODEGA_RECEPCION_FACTURA_INTERNA_SERVICIO);
	}
	
	/**
	 * Obtiene una referencia del servicio IRecepcionOrdenCompraServicio
	 * @return Un IRecepcionOrdenCompraServicio
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public IRecepcionOrdenCompraServicio getRecepcionOrdenCompraServicio() throws SICException{
		return (IRecepcionOrdenCompraServicio) getBean(SICFactoryConstantes.BODEGA_RECEPCION_ORDEN_COMPRA_SERVICIOS);
	}
	
	/**
	 * Obtiene una referencia del servicio IRecepcionBodegaServicio
	 * @return Un IFacturaDigitalServicio
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public IFacturaDigitalServicio getFacturaDigitalServicio() throws SICException{
		return (IFacturaDigitalServicio) getBean(SICFactoryConstantes.BODEGA_FACTURA_DIGITAL_SERVICIO);
	}
	
	/**
	 * Obtiene una referencia del servicio IEntregasProveedorServicio
	 * @return Un IEntregasProveedorServicio
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public IEntregasProveedorServicio getEntregasProveedorServicio() throws SICException{
		return (IEntregasProveedorServicio) getBean(SICFactoryConstantes.BODEGA_ENTREGAS_PROVEEDOR_SERVICIO);
	}
	
	/**
	 * Obtiene una referencia del servicio IEntregasProveedorServicio
	 * @return Un IEntregasProveedorServicio
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public IFacturasProveedorServicio getFacturasProveedorServicio() throws SICException{
		return (IFacturasProveedorServicio) getBean(SICFactoryConstantes.BODEGA_FACTURAS_PROVEEDOR_SERVICIO);
	}
	
	/**
	 * Obtiene una referencia del servicio de configuraci&oacute;n del calendario de planificaci&oacute;n de las bodegas para la recepci&oacute;n de &oacute;rdenes
	 * de compra
	 * @return Servicio de calendario de planificaci&oacute;n de bodegas
	 * @throws SICException Cuando no se puede instanciar el servicio correctamente
	 */
	public ICalendarioPlanificacionBodegaServicio getCalendarioPlanificacionBodegaServicio() throws SICException{
		return (ICalendarioPlanificacionBodegaServicio) getBean(SICFactoryConstantes.BODEGA_RECEPCION_CALENDARIO_PLANIFICACION_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IRecepcionProveedoresServicio getRecepcionProveedoresServicio() throws SICException{
		return (IRecepcionProveedoresServicio) getBean(SICFactoryConstantes.BODEGA_RECEPCION_PROVEEDORES_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IRecepcionNovedadesServicio getRecepcionNovedadesServicio() throws SICException{
		return (IRecepcionNovedadesServicio) getBean(SICFactoryConstantes.BODEGA_RECEPCION_NOVEDADES_SERVICIO);
	}
	
	public IBodegaArticuloCalculoServicio getBodegaArticuloCalculoServicio() throws SICException{
		return (IBodegaArticuloCalculoServicio) getBean(SICFactoryConstantes.BODEGA_ARTICULO_SERVICIO);
	}
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public IRecepcionProveedorServicioScanner getRecepcionProveedorServicioScanner() throws SICException{
		return (IRecepcionProveedorServicioScanner) getBean(SICFactoryConstantes.BODEGA_RECEPCION_PROVEEDORES_SERVICIO_SCANNER);
	}
	
	/**
	 * Obtiene una referencia del servicio para la asignaci&oacute;n autom&aacute;tica de funcionarios a tareas del recibidor
	 * @return
	 * @throws SICException
	 */
	public IAsignacionAutomaticaFuncionarioTareaServicio getAsignacionAutomaticaFuncionarioTareaServicio()throws SICException{
		return (IAsignacionAutomaticaFuncionarioTareaServicio) getBean(SICFactoryConstantes.BODEGA_RECEPCION_ASIGNACION_AUTOMATICA_FUNCIONARIO_TAREA);
	}
	
	/**
	 * Obtiene una referencia del servicio para el monitor de montacarga corredor
	 * @return
	 * @throws SICException
	 */
	public IMontacargaCorredorServicio getMontacargaCorredorServicio() throws SICException {
		return (IMontacargaCorredorServicio) getBean(SICFactoryConstantes.BODEGA_MONTACARGA_CORREDOR_SERVICIOS);
	}
	/**
	 * Obtiene una referencia del servicio para la administracion de autorizaciones por clave
	 * @return
	 * @throws SICException
	 */
	public IAutorizacionesClaveServicio getAutotizacionesClaveServicio() throws SICException{
		return (IAutorizacionesClaveServicio) getBean(SICFactoryConstantes.BODEGA_AUTORIZACIONES_CLAVE_SERVICIO);
	}
	
	/**
	 * Obtiene una referencia del servicio para el registro de peso de pallets jacks
	 * @return
	 * @throws SICException
	 */
	public IPalletJackRecepcionServicio getPalletJackRecepcionServicio() throws SICException{
		return (IPalletJackRecepcionServicio) getBean(SICFactoryConstantes.BODEGA_RECEPCION_PALLET_JACK_SERVICIO);
	}
	/**
	 * Obtiene una referencia del servicio de configuraciones de recepcion
	 * @return
	 * @throws SICException
	 */
	public IConfiguracionesRecepcionServicio getConfiguracionesRecepcionServicio() throws SICException{
		return (IConfiguracionesRecepcionServicio) getBean(SICFactoryConstantes.BODEGA_RECEPCION_CONFIGURACIONES_SERVICIO);
	}
	
	/**
	 * Obtiene una referencia del servicio de programas para el montacarguista
	 * @return
	 * @throws SICException
	 */
	public IProgramasMontacarguistaServicio getProgramasMontacarguistaServicio() throws SICException{
		return (IProgramasMontacarguistaServicio) getBean(SICFactoryConstantes.BODEGA_RECEPCION_PROGRAMAS_MONTACARGUISTA_SERVICIO);
	}
	
	/**
	 * Obtiene una referencia del servicio de modificacion de datos de pallets de recepcion
	 * @return
	 * @throws SICException
	 */
	public IModificarPalletsRecepcionServicio getModificarPalletsRecepcionServicio() throws SICException{
		return (IModificarPalletsRecepcionServicio) getBean(SICFactoryConstantes.BODEGA_RECEPCION_MODIFICAR_PALLETS_SERVICIO);
	}
	
	/**
	 * Obtiene una referencia del servicio de edicion de datos extra de articulos de recepcion
	 * @return
	 * @throws SICException
	 */
	public IEdicionDatosExtraServicio getEdicionDatosExtraServicio() throws SICException{
		return (IEdicionDatosExtraServicio) getBean(SICFactoryConstantes.BODEGA_RECEPCION_EDICION_DATOS_EXTRA_SERVICIO);
	}
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public ITareasBodegaServicio getTareasBodegaServicio() throws SICException {
		return (ITareasBodegaServicio) getBean(SICFactoryConstantes.BODEGA_TAREAS_SERVICIO);
	}
	/**
	 * Obtiene una referencia del servicio de integracion de la recepcion de bodega con el SIC
	 * @return
	 * @throws SICException
	 */
	public IIntegracionBodegaRecepcionServicio getIntegracionBodegaRecepcionServicio() throws SICException{
		return (IIntegracionBodegaRecepcionServicio) getBean(SICFactoryConstantes.BODEGA_INTEGRACION_BODEGA_SERVICIO);
	}
	
	/**
	 * Obtiene una referencia del servicio de asignacion de usuarios
	 * @return
	 * @throws SICException
	 */
	public IAsignacionUsuariosBodegaServicio getAsignacionUsuariosBodegaServicio() throws SICException{
		return (IAsignacionUsuariosBodegaServicio) getBean(SICFactoryConstantes.BODEGA_ASIGNACION_USUARIOS_SERVICIO);
	}
	
	/**
	 * Obtiene una referencia del servicio de funcionario recepcion
	 * @return
	 * @throws SICException
	 * @Autor Gcholca
	 */
	public IRecepcionFuncionarioServicio getIRecepcionFuncionarioServicio()  throws SICException{
		return (IRecepcionFuncionarioServicio) getBean(SICFactoryConstantes.BODEGA_RECEPCION_FUNCIONARIO_SERVICIO);
	}
}
