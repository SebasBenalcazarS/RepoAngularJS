/*
 * Creado el 2013-04-18
 */
package ec.com.smx.sic.cliente.servicio.recargacupon;

import java.io.IOException;

import ec.com.smx.framework.common.anotaciones.InformacionMetodo;
import ec.com.smx.framework.common.anotaciones.InformacionParametro;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * Interfaz que expone los servicios de tareas programadas de recarga de cupones
 * 
 * @author mrivera
 */
public interface ITareaProgramadaServicio {
	/**
	 * Proceso para la asignacion de codigos internos a los cupones.
	 * 
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion="Ejecuta el proceso de asignaci�n de c&oacute;digos internos a los cupones vigentes.")
	public void asignarCodigoInternoCupones(
			@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer codigoCompania, 
			@InformacionParametro(nombre="Usuario", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso
			) throws SICException;

	/**
	 * Genera los archivos por local con la informacion requerida de los cupones para el POS
	 * @param codigoCompania
	 * @param codigoLocal
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion = "Genera el archivo de cupones para el  local especificado en la fecha actual")
	public void generarArchivosCuponesByLocal(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania, 
			@InformacionParametro(nombre="C&oacute;digo local", descripcion="C&oacute;digo local", ejemplosValores={"101"})Integer codigoLocal) throws SICException;

	/**
	 * Genera los archivos por local con la informacion requerida de los cupones para el POS
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param fechaProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion="Genera el archivo de cupones para el  local especificado en la fecha establecida.")
	public void generarArchivosCuponesByLocal(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer codigoCompania,
			@InformacionParametro(nombre="C&oacute;digo local", descripcion="C&oacute;digo local", ejemplosValores={"101"}) Integer codigoLocal, 
			@InformacionParametro(nombre="Fecha", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-05-30"}) String fechaProceso) throws SICException;

	/**
	 * Proceso que genera archivos con cupones para el POS y envia los archivos a los locales.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion = "Genera los archivos de cupones y los envia a los locales correspondientes")
	public void generarArchivosCuponesAndEnviarALocales(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania, 
			@InformacionParametro(nombre="usuarioProceso", descripcion="Usuario que interviene en el proceso", ejemplosValores={"FRM0"})String usuarioProceso) throws SICException;

	/**
	 * Proceso que genera archivos con cupones para el POS y envia los archivos a los locales.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion = "Genera los archivos de cupones y los envia a los locales correspondientes")
	public void generarArchivosCuponesAndEnviarALocales(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania, 
			@InformacionParametro(nombre="usuarioProceso", descripcion="Usuario que interviene en el proceso", ejemplosValores={"FRM0"})String usuarioProceso, 
			@InformacionParametro(nombre="Fecha", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-05-30"})String fechaProceso) throws SICException;

	/**
	 * Actualiza los cupones codificados a vigentes y los vigentes (caducados) a no vigentes a la fecha que se ejecuta.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion="Actualiza los estados de los cupones codificados a vigentes y los vigentes (caducados) a no vigentes a la fecha que se ejecuta.")
	public void actualizarCupones(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer codigoCompania, 
			@InformacionParametro(nombre="Usuario", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso) throws SICException ;

	/**
	 * Actualiza los cupones codificados a vigentes y los vigentes (caducados) a no vigentes a una fecha dada.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion="Actualiza los estados de los cupones codificados a vigentes y los vigentes (caducados) a no vigentes a una fecha dada.")
	public void actualizarCupones(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer codigoCompania, 
			@InformacionParametro(nombre="Usuario", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso,
			@InformacionParametro(nombre="Fecha", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-01-01"}) String fechaProceso) throws SICException ;

	/**
	 * Actualiza los cupones con estado codificado a vigentes a la fecha que se ejecuta.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion="Actualiza los cupones con estado codificado a vigentes a la fecha que se ejecuta.")
	public void transActualizarACuponesVigentes(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer codigoCompania, 
			@InformacionParametro(nombre="Usuario", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso) throws SICException;

	/**
	 * Actualiza los cupones con estado codificado a vigentes a una fecha dada.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion="Actualiza los cupones con estado codificado a vigentes a una fecha dada.")
	public void transActualizarACuponesVigentes(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer codigoCompania, 
			@InformacionParametro(nombre="Usuario", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso,
			@InformacionParametro(nombre="Fecha", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-01-01"}) String fechaProceso) throws SICException;

	/**
	 * Actualiza los cupones con estado vigente (caducados) a no vigente a la fecha que se ejecuta.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion="Actualiza los cupones con estado vigente (caducados) a no vigente a la fecha que se ejecuta.")
	public void actualizarACuponesNoVigentes(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer codigoCompania, 
			@InformacionParametro(nombre="Usuario", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso) throws SICException;

	/**
	 * Actualiza los cupones con estado vigente (caducados) a no vigente a una fecha dada.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion="Actualiza los cupones con estado vigente (caducados) a no vigente a una fecha dada.")
	public void actualizarACuponesNoVigentes(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer codigoCompania, 
			@InformacionParametro(nombre="Usuario", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso,
			@InformacionParametro(nombre="Fecha", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-01-01"}) String fechaProceso) throws SICException;

	/**
	 * Actualiza los cupones codificados a vigentes,los vigentes (caducados) a no vigentes y procesa la asignacion de codigos internos a los cupones.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion="Actualiza los cupones codificados a vigentes,los vigentes (caducados) a no vigentes y procesa la asignaci�n de c�digos internos a los cupones.")
	public void actualizarCuponesYAsignarCodigoInterno(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer codigoCompania, 
			@InformacionParametro(nombre="Usuario", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso) throws SICException;

	/**
	 * Actualiza los cupones codificados a vigentes,los vigentes (caducados) a no vigentes y procesa la asignacion de codigos internos a los cupones.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion="Actualiza los cupones codificados a vigentes,los vigentes (caducados) a no vigentes y procesa la asignaci�n de c�digos internos a los cupones.")
	public void actualizarCuponesYAsignarCodigoInterno(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer codigoCompania, 
			@InformacionParametro(nombre="Usuario", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso,
			@InformacionParametro(nombre="Fecha", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-01-01"}) String fechaProceso) throws SICException;

	/**
	 * Proceso que reenvia los archivos que estan con error a los locales
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion = " Proceso que reenv�a los archivos que est�n con error a los locales.")
	public void reenvioArchivoCuponesALocales(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania, 
			@InformacionParametro(nombre="UsuarioProceso", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso) throws SICException;

	/**
	 * Proceso que reenvia los archivos que estan con error a los locales
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion = " Proceso que reenv�a los archivos que est�n con error a los locales.")
	public void reenvioArchivoCuponesALocales(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania, 
			@InformacionParametro(nombre="UsuarioProceso", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso, 
			@InformacionParametro(nombre="FechaProceso", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-01-01"})String fechaProceso) throws SICException;

	/**
	 * Proceso que actualiza los cupones y genera el archivo para enviarlo a los locales
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param horaFinDia
	 * @param diasInactivarCuponesCliente
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion = "Proceso que actualiza los cupones y genera el archivo para enviarlo a los locales")
	public void actualizarCuponesYGenerarArchivosTotal(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania,
			@InformacionParametro(nombre="UsuarioProceso", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso,
			@InformacionParametro(nombre="HoraFinDia", descripcion="Hora que indica el fin del dia en formato HH:mm", ejemplosValores={"21:00"}) String horaFinDia,
			@InformacionParametro(nombre="dias inactivar cupones cliente", descripcion="Indica en numero de dias para tomar en cuenta a los cupones caducados que seran inactivados a los clientes.", ejemplosValores={"5"}) Integer diasInactivarCuponesCliente) throws SICException;

	/**
	 * Proceso que actualiza los cupones y genera el archivo para enviarlo a los locales
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @param horaFinDia
	 * @param diasInactivarCuponesCliente
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion = "Proceso que actualiza los cupones y genera el archivo para enviarlo a los locales")
	public void actualizarCuponesYGenerarArchivosTotal(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania,
			@InformacionParametro(nombre="UsuarioProceso", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso,
			@InformacionParametro(nombre="Fecha", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-01-01"}) String fechaProceso,
			@InformacionParametro(nombre="HoraFinDia", descripcion="Hora que indica el fin del dia en formato HH:mm", ejemplosValores={"21:00"}) String horaFinDia,
			@InformacionParametro(nombre="dias inactivar cupones cliente", descripcion="Indica en numero de dias para tomar en cuenta a los cupones caducados que seran inactivados a los clientes.", ejemplosValores={"5"}) Integer diasInactivarCuponesCliente) throws SICException;

	/**
	 * Metodo para probar el listener.
	 * @param numeroHilos
	 * @param numeroTransacciones
	 * @param tipoProceso
	 */
	@InformacionMetodo(descripcion = "Metodo para probar el listener.")
	public void transProcesarTramas(@InformacionParametro(nombre="numeroHilos", descripcion="N�mero de hilos", ejemplosValores={"1"})Integer numeroHilos, 
			@InformacionParametro(nombre="numeroTransacciones", descripcion="N�mero de transacciones", ejemplosValores={"1"})Integer numeroTransacciones, 
			@InformacionParametro(nombre="tipoProceso", descripcion="Tipo de proceso, los valores permitidos son 1 consulta y 2 actualizaci�n", ejemplosValores={"1"})Integer tipoProceso)throws SICException;

	/**
	 * Inicia el Listener de integracion Mediante MQ
	 * @throws SICException
	 */
	public void levantarListenerMAX() throws SICException;

	/**
	 * Detiene el Listener de integracion Mediante MQ
	 * @throws SICException
	 */
	public void apagarListenerMAX() throws SICException;
	
	/**
	 * Inicia el Listener de integracion punto de venta
	 * @throws SICException
	 */
	public void levantarListenerPOS() throws SICException;

	/**
	 * Detiene el Listener de integracion con  punto de venta
	 * @throws SICException
	 */
	public void apagarListenerPOS() throws SICException;

	/**
	 * Proceso global para redimensionar las imagenes de los cupones
	 * @param fechaProceso
	 * @throws IOException
	 */
	@InformacionMetodo(descripcion = "Metodo para redimensionar imagenes y enviarlas por ftp")
	public void procesoRedimensionarImagenesAndEnvioFTP(@InformacionParametro(nombre="FechaProceso", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-01-01"})String fechaProceso) throws IOException;

	/**
	 * Proceso global para redimensionar las imagenes de los cupones
	 * @param fechaProceso
	 * @throws IOException
	 */
	@InformacionMetodo(descripcion = "Metodo para redimensionar imagenes y enviarlas por ftp")
	public void procesoRedimensionarImagenesAndEnvioFTP(@InformacionParametro(nombre="FechaProceso", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-01-01"})String fechaProceso, @InformacionParametro(nombre="Tama�oImagenProducto", descripcion="Valores 1 o 0", ejemplosValores={"1-0"})Integer tipoTamanoImagenProducto) throws IOException;

	/**
	 * Envia un mail con cupones sin imagen.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param numeroDias numeroDias = null, envia cupones vigents sin imagen, caso contrario cupones sin imagen proximos a actualizarse.
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion = "Envia un mail con cupones sin imagen.")
	public void enviarMailCuponesSinImagen(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer codigoCompania, 
			@InformacionParametro(nombre="UsuarioProceso", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso, 
			@InformacionParametro(nombre="N&uacute;meroDias", descripcion="N&uacute;mero de dias de anticipaci&oacute;n", ejemplosValores={"1"}) Integer numeroDias)throws SICException;

	/**
	 * Metodo para enviar el archivo de cupones a un local especifico
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @param codigoLocal
	 */
	@InformacionMetodo(descripcion = "Envia el archivo de cupones a un local definido")
	public void enviarArchivoALocal(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer codigoCompania, 
			@InformacionParametro(nombre="UsuarioProceso", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso,
			@InformacionParametro(nombre="FechaProceso", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-01-01"})String fechaProceso,
			@InformacionParametro(nombre="C&oacute;digo local", descripcion="C&oacute;digo local", ejemplosValores={"101"})Integer codigoLocal);

	/**
	 * Elimina registros inactivos en la tabla cliente articulo.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 */
	@InformacionMetodo(descripcion = "Elimina registros inactivos en la tabla cliente articulo.")
	public void borrarCuponesInactivosCliente(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"}) Integer codigoCompania, 
			@InformacionParametro(nombre="UsuarioProceso", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso,
			@InformacionParametro(nombre="FechaProceso", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-01-01"})String fechaProceso);

	/**
	 * Metodo para enviar una notificacion push a todos los usuarios activos de la aplicacion asistente de compras
	 * @param mensajeNotificacion
	 */
	@InformacionMetodo(descripcion = "Enviar notificacion push a todos los usuarios activos de asistente de compras.")
	public void enviarNotificacionAUsuariosActivos(@InformacionParametro(nombre = "Mensaje", descripcion = "Mensaje que se enviar� a los usuarios activos" , ejemplosValores={"Mensaje 1"} ) String mensajeNotificacion);

	/**
	 * Metodo que envia notificaciones push a partir de un archivo excel con los numeros de documento
	 * @param mensajeNotificacion
	 */
	@InformacionMetodo(descripcion = "Enviar notificacion push a partir de un archivo excel con los numeros de documento.")
	public void enviarNotificacionesPushExcel(@InformacionParametro(nombre = "pathArchivo", descripcion = "path del archivo excel que contiene los numeros de docuemnto" , ejemplosValores={"C:\file.xlsx"} ) String pathArchivo,
			@InformacionParametro(nombre="mensaje", descripcion="mensaje a mostrar en el dispositivo", ejemplosValores={"hola"}) String mensaje,
			@InformacionParametro(nombre="sysId", descripcion="id del sistema ", ejemplosValores={"SACM"}) String sysId,
			@InformacionParametro(nombre="broadcast", descripcion="Indica si el valor es true el mensaje se debe enviar a todos los dispositivos sin tomar encuenta a el archivo, caso contrario envia el mensjase a los dispositivos del archivo", ejemplosValores={"true","false"}) Boolean broadcast,
			@InformacionParametro(nombre="tipo tecnologia", descripcion="Sistema operativo de los dispositivos", ejemplosValores={"ios","android","bb"}) String tipoTecnologia,
			@InformacionParametro(nombre="version app", descripcion="version de la app instalada en el dispositivo, especificar como se debe validar", ejemplosValores={"2.1.9"}) String systemVersion,
			@InformacionParametro(nombre="validar", descripcion="valida se la version valores; 0 = no validar, 1 = igual, 2 = distinto, 3 = mayor, 4 = menor, 5 = mayor o igual, 6 = menor o igual", ejemplosValores={"0","1","2","3","4","5","6"}) Integer validarVersionSistema);

	/**
	 * Genera archivos con cupones para kioskos.
	 */
	@InformacionMetodo(descripcion = "Genera archivos con cupones para kioskos")
	public void generarArchivosKioskos();
	
	/**
	 * Genera archivos con cupones para kioskos y los envia por FTP
	 */
	@InformacionMetodo(descripcion = "Genera archivos con cupones para kioskos y los envia por ftp")
	public void generarArchivosKioskosAndEnviarPorFTP();
	
	/**
	 * Proceso genera archivos de cupones para locales.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion = "Proceso genera archivos de cupones para locales.")
	public void generarArchivosCupones(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania,
			@InformacionParametro(nombre="UsuarioProceso", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso,
			@InformacionParametro(nombre="FechaProceso", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-01-01"}) String fechaProceso) throws SICException;
	
	/**
	 * Proceso que envia los archivos de cupones generados al local correspondiente.
	 * @param codigoCompania
	 * @param usuarioProceso
	 * @param fechaProceso
	 * @throws SICException
	 */
	@InformacionMetodo(descripcion = "Proceso que envia los archivos de cupones generados al local correspondiente.")
	public void enviarArchivosALocales(@InformacionParametro(nombre="C&oacute;digo compa&ntilde;&iacute;a", descripcion="Compa&ntilde;&iacute;a a la que pertenecen los datos", ejemplosValores={"1"})Integer codigoCompania,
			@InformacionParametro(nombre="UsuarioProceso", descripcion="Usuario que ejecuta la tarea", ejemplosValores={"FRM0"}) String usuarioProceso,
			@InformacionParametro(nombre="FechaProceso", descripcion="Fecha en formato yyyy-MM-dd.", ejemplosValores={"2013-01-01"}) String fechaProceso) throws SICException;
}
