/**
 * 
 */
package ec.com.smx.sic.cliente.common.integracion;

import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ec.com.integration.dto.ConexionParametersDTO;
import ec.com.integration.exception.IntegrationException;
import ec.com.integration.service.IntegrationServiceI;
import ec.com.integration.service.IntegrationServiceImpl;
import ec.com.integration.util.IntegrationUtil;
import ec.com.integration.util.MessageTransformer;
import ec.com.smx.framework.common.logging.LogFramework;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.integracion.dto.CabeceraIDTO;
import ec.com.smx.sic.integracion.resources.SICIntegracionMessages;
import ec.com.smx.sic.integracion.util.SICIntegracion;
import ec.com.smx.sic.integracion.util.UtilIntegracion;


/**
 * @author fmunoz
 *
 */
public class SICListener
{
	//Permite invocar los metodos de integracion. 
	public static IntegrationServiceI integrationService;
	public static int intentosConexion = 0;
	
	/**
	 * Inicia la conexi&oacute;n con el gestor de colas.
	 * @throws IntegrationException
	 */
	public static IntegrationServiceI iniciarConexion() throws IntegrationException{

		if(integrationService == null){
			LogFramework.getLogger().info("------------------------------------------------------------------------");
			LogFramework.getLogger().info(":.Inicializando el listener del JSIC.");
			LogFramework.getLogger().info("------------------------------------------------------------------------");
			
			// Establecer los parametros de conexi�n. 
			ConexionParametersDTO conexionParametersDTO = UtilIntegracion.crearParametrosConexion();
			conexionParametersDTO.setListenerQueue(SICIntegracionMessages.getString("ec.com.smx.sic.integracion.conexion.colaEscucha"));
	
			// Inicializar los par�metros de conexi�n.
			integrationService = new IntegrationServiceImpl();
			try{
				//Iniciar la conexi�n.				
				if(UtilIntegracion.ESTADO_MODALIDAD_CCDT.equals(IntegrationUtil.CCDT_ACTIVA) && conexionParametersDTO.getUrlCCDT() != null){
					integrationService.connectQM_CCDT(conexionParametersDTO);
				}else{
					integrationService.connectQM(conexionParametersDTO);
				}							
				integrationService.startListener();
			}catch(IntegrationException e){
				integrationService = null;
				throw e;
			}finally{
				conexionParametersDTO = null;
			}
		}
		return integrationService;
	}

	/**
	 * Ejecuta el listener.
	 * @throws IntegrationException
	 */
	public static void start() throws IntegrationException{
		boolean escuchar = true;
	
		if(integrationService == null){
			//Iniciar la conexi�n.
			integrationService = iniciarConexion();
			
			HashMap<String,Object> mensaje = null;
			Document resXml = null;
			Element element = null;
			NodeList children = null;
			// Esperar por el mensaje.
			while(escuchar){
				try{
					LogFramework.getLogger().info(":.Ok.");
					LogFramework.getLogger().info("------------------------------------------------------------------------");
					LogFramework.getLogger().info(":.Esperando por el mensaje...");
					LogFramework.getLogger().info("------------------------------------------------------------------------");
					intentosConexion = 0;
					// Obtener el mensaje.
					mensaje = integrationService.getListenerMessage();
					byte[] id = (byte[]) mensaje.get(UtilIntegracion.ID_MESSAGE); // id.
					String contenido = (String) mensaje.get(UtilIntegracion.ID_MESSAGE_BODY); // body.
					resXml = MessageTransformer.toXML(contenido);
					
					LogFramework.getLogger().info(":.Mensaje Obtenido: " + id);
					LogFramework.getLogger().info("------------------------------------------------------------------------");

					// Determinar el tipo del proceso.
					element = resXml.getDocumentElement();
					children = element.getElementsByTagName(UtilIntegracion.TAGNAME_CONTROLPROCESO);
					String proceso = null;
					for(int i = 0; i < children.getLength(); i++){
						for(int j = 0; j < children.item(i).getChildNodes().getLength(); j++){							
							if(children.item(i).getChildNodes().item(j).getNodeName() != null && children.item(i).getChildNodes().item(j).getNodeName().equals(UtilIntegracion.TAGNAME_PROCESO))
								proceso = children.item(i).getChildNodes().item(j).getFirstChild().getNodeValue();
						}
					}

					LogFramework.getLogger().info(":.Tipo de Proceso: " + proceso);
					LogFramework.getLogger().info("------------------------------------------------------------------------");
					
					if(proceso != null){
						//TODO AQUI Determinar el tipo de solicitud.
						if(proceso.toUpperCase().startsWith(UtilIntegracion.PROCESO_CONSULTAR_CLIENTE_CUPON_DEVICE)){
							//Recibe solicitud de cliente cupon device
							SICFactory.getInstancia().recargaCupon.getClienteCuponService().findClienteCuponDevice(resXml, id);
							
						} else if (proceso.toUpperCase().startsWith(UtilIntegracion.PROCESO_CONSULTAR_CAB_FAC_PRO_REC) ||
								proceso.toUpperCase().startsWith(UtilIntegracion.PROCESO_CONSULTAR_DET_FAC_PRO_REC)) {
							
							RelacionarMensajesUtil.relacionarMensajes(proceso, resXml, id);
						}

					}
					
				}catch (Exception e) {
					intentosConexion += 1;
					controlarExcepcion(e, intentosConexion);
				}finally{
					mensaje = null; resXml = null; element = null; children = null;
				}
			}
		}else{
			LogFramework.getLogger().info(":.El listener ya fue iniciado anteriormente");
		}

	}
	
	/**
	 * Detiene el listener.
	 * 
	 * @throws IntegrationException - en caso de que existan problemas al realizar el proceso
	 */
	public static void stop() throws IntegrationException{
		try{
    		LogFramework.getLogger().info(":.Ok.");
    		LogFramework.getLogger().info("------------------------------------------------------------------------");
    		LogFramework.getLogger().info(":...Apagando el listener...");
    		LogFramework.getLogger().info("------------------------------------------------------------------------");
    		
    		if(integrationService != null)
    			integrationService.stopListener();
    		
    		LogFramework.getLogger().info(":.Ok.");
    		LogFramework.getLogger().info("------------------------------------------------------------------------");
    		LogFramework.getLogger().info(":...Listener Apagado...");
    		LogFramework.getLogger().info("------------------------------------------------------------------------");
		}catch (IntegrationException e) {
			throw e;
		}finally{
			integrationService = null;
		}
	}
	
	/**
	 * 
	 * @param e
	 * @param intentosConexion2 
	 * @throws IntegrationException
	 */
	public static void controlarExcepcion(Exception e, int intentosConexion2)throws IntegrationException{
		//Controlar el tipo de error.
		String causa = "Error";
		Logeable.LOG_SICV2.error(e.getMessage());
		if(integrationService == null)
			throw new IntegrationException(e.getMessage());
		else if(e.getMessage().endsWith("2059")){
			integrationService = null;
			LogFramework.getLogger().info( ":.El gestor de colas no se encuentra Activo - MQRC_Q_MGR_NOT_AVAILABLE");
			causa.concat(":.El gestor de colas no se encuentra Activo - MQRC_Q_MGR_NOT_AVAILABLE");
			reintentarConexion();
			throw new IntegrationException(causa);
		}else if (e.getMessage().endsWith("2162")){
			integrationService = null;
			LogFramework.getLogger().info( ":.El gestor de colas se ha detenido - MQRC_Q_MGR_STOPPING");
			causa.concat(":.El gestor de colas se ha detenido - MQRC_Q_MGR_STOPPING");
			throw new IntegrationException(causa);
		}else if (e.getMessage().endsWith("2009")){
			integrationService = null;
			LogFramework.getLogger().info( ":.Se perdi� la conexi�n con el Gestor de Colas - MQRC_CONNECTION_BROKEN");
			causa.concat(":.Se perdi� la conexi�n con el Gestor de Colas - MQRC_CONNECTION_BROKEN");
			reintentarConexion();
			throw new IntegrationException(causa);
		}else if (e.getMessage().endsWith("2019")){
			integrationService = null;
			LogFramework.getLogger().info( ":.La cola del Listener se ha detenido - MQRC_HOBJ_ERROR");
			causa.concat(":.La cola del Listener se ha detenido - MQRC_HOBJ_ERROR");
			throw new IntegrationException(causa);
		}
	}
	/**
	 * 
	 * @throws IntegrationException
	 */
	private static void reintentarConexion() throws IntegrationException {
		LogFramework.getLogger().info(":.Se esta volviendo a conectar, intentos:{}", Integer.valueOf(intentosConexion));
		if (intentosConexion <= Integer.parseInt(SICIntegracionMessages.getString("ec.com.smx.sic.integracion.conexion.intentos"))) {
			try {
				LogFramework.getLogger().info(":.Se esta volviendo a conectar, intentos:{}", Integer.valueOf(intentosConexion));
				Thread.sleep(Long.parseLong(SICIntegracionMessages.getString("ec.com.smx.sic.integracion.conexion.tiempoReconexion")));
				start();
			} catch (Exception ex) {
				throw new IntegrationException(ex.getMessage());
			}
		}
	}
	
	/**
	 * Env�a la respuesta a una solicitud
	 * 
	 * @param objetoOUT				- la informaci&oacute;n del objeto que se desea responder
	 * @param idMensaje 			- el identificador del mensaje
	 * @param plantillaOUT 			- identifica el formato de salida xsl que se va a generar
	 * @param colaSalida 			- identifica la cola por la que se enviar� el mensaje
	 * @throws IntegrationException
	 */
	public static Boolean generarRespuesta(CabeceraIDTO<?> objetoOUT, byte[] idMensaje, String plantillaOUT, String colaSalida)throws IntegrationException{
		//Determinan el resultado del proceso.
		Boolean resultado = Boolean.FALSE;
		IntegrationServiceI integrationService = null;
		try{

			LogFramework.getLogger().info("Conexi�n de respuesta iniciada");
			//inicia la conexi�n de respuesta
			integrationService = SICIntegracion.iniciarConexion(null, colaSalida);
			
			SICIntegracion.enviarMensaje(objetoOUT, plantillaOUT, idMensaje, integrationService, IntegrationUtil.TIPO_MSG_REPLY);
			
			//Establecer el resultado del proceso.
			resultado = Boolean.TRUE;
		}catch(IntegrationException e){
			LogFramework.getLogger().error("Error al generar la respuesta", e);
			throw e;
		}finally{
			try{integrationService.stop();}catch(IntegrationException e){LogFramework.getLogger().error("Error al detener la conexi�n de respuesta", e);}
			LogFramework.getLogger().info("Conexi�n de respuesta cerrada");
			integrationService = null;
		}
		
		//Retorna el resultado del proceso.
		return resultado;
	}

}
