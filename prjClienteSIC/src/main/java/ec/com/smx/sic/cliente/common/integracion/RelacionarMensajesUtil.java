package ec.com.smx.sic.cliente.common.integracion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ec.com.integration.util.IntegrationUtil;
import ec.com.integration.util.XMLTransformer;
import ec.com.integration.util.XSLTransformer;
import ec.com.smx.framework.common.logging.LogFramework;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.integracion.dto.ordenCompra.ConsultarCabeceraFacturasProveedorDetalleIDTO;
import ec.com.smx.sic.integracion.dto.ordenCompra.ConsultarCabeceraFacturasProveedorIDTO;
import ec.com.smx.sic.integracion.dto.ordenCompra.ConsultarDetalleFacturasProveedorDetalleIDTO;
import ec.com.smx.sic.integracion.dto.ordenCompra.ConsultarDetalleFacturasProveedorIDTO;
import ec.com.smx.sic.integracion.resources.SICIntegracionMessages;
import ec.com.smx.sic.integracion.util.UtilIntegracion;

/**
 * @author osaransig
 * Dec 19, 2013
 */
public class RelacionarMensajesUtil {

	/**
	 * Mapa para asociar mensajes antes de ir a procesarce
	 */
	public static Map<String, Map<String, Collection<Object>>> mapMensajes = new HashMap<String, Map<String,Collection<Object>>>();

	
	/**
	 * Relacionar mensajes con el mismo identificador de transaccion
	 * @param proceso			nombre del proceso
	 * @param mensaje			Document del mensaje recibido
	 * @param id				Array de bytes del id del mensaje
	 * @author osaransig
	 * @throws Exception 
	 */
	public static void relacionarMensajes(String proceso, Document mensaje, byte[] id) throws Exception {
		
//		printMessage(mensaje.getFirstChild());
		
		// campo para relacionar mensajes
		String  identificadorTra = null;

		NodeList nodeList = mensaje.getFirstChild().getChildNodes().item(1).getChildNodes().item(0).getChildNodes();
		
		for (int j = 0; j < nodeList.getLength(); j++) {
			Node node4 = nodeList.item(j);
			if (node4.getNodeName().equalsIgnoreCase(UtilIntegracion.IDENTIFICADOR_TRANSACCION)) {
				identificadorTra = node4.getFirstChild().getNodeValue();
				break;
			}
		}
		
		LogFramework.getLogger().info( "Relacionado mensajes con el identificador: {}", identificadorTra);
		
		// buscamos si existe el identificador de la transaccion en el mapa de mensajes
		Map<String, Collection<Object>> mapProceso = mapMensajes.get(identificadorTra);
		
		// caracteristicas del proceso
		Collection<Object> colProc = new ArrayList<Object>();
		colProc.add(mensaje);
		colProc.add(id);

		// si no existe identificador de transaccion en el mapa de mensajes
		if (mapProceso == null) {
			mapProceso = new HashMap<String, Collection<Object>>();
			mapProceso.put(proceso, colProc); //agregar el proceso
			mapMensajes.put(identificadorTra, mapProceso);
			
		} else {// existe identificador
			
			mapProceso.put(proceso, colProc); // agregar el proceso
			if (mapMensajes.get(identificadorTra).size() == UtilIntegracion.NUMERO_MENSAJES_ESPERADOS) {
				
				// enviar a procesar mapa con los datos de la cabecera y el detalle
				try {
//					SICFactory.getInstancia().bodega.getFacturaDigitalServicio().transValidarDiferenciaArtFacturadosContraRecibidosDesdeIntegracion(mapProceso);
					SICFactory.getInstancia().bodega.getFacturaDigitalServicio().transValidarDiferenciaArtFacturadosContraRecibidosDesdeIntegracionSIC(mapProceso);
				} catch (Exception e) {
					LogFramework.getLogger().error("Error relacionando mensajes: {}", e);
					
					if (proceso.toUpperCase().startsWith(UtilIntegracion.PROCESO_CONSULTAR_DET_FAC_PRO_REC)) {
						SICListener.generarRespuesta(obtenerDetalleDesdeIntegracion(mensaje), id,
								UtilIntegracion.PLANTILLA_SALIDA_SERVICIOORDENCOMPRA, UtilIntegracion.COLASALIDA_SERORDCOM_OBTDETFACPROREC);
					}
					
//					throw new IntegrationException(e.getMessage());
				}
				
				// eliminar identificador de la lista de mensajes
				mapMensajes.remove(identificadorTra);
			}
		}
		
		// Enviar confirmacion de la cabecera para recibir el detalle
		if (proceso.toUpperCase().startsWith(UtilIntegracion.PROCESO_CONSULTAR_CAB_FAC_PRO_REC)) {
			

			try{
				SICFactory.getInstancia().bodega.getFacturaDigitalServicio().transAlmacenarCabecerasRecepcionProveedorArticulos(mapProceso);
				
			}
			catch(Exception e){
				SICListener.generarRespuesta(obtenerHeaderDesdeIntegracion(mensaje), id,
						UtilIntegracion.PLANTILLA_SALIDA_SERVICIOORDENCOMPRA, UtilIntegracion.COLASALIDA_SERORDCOM_OBTCABFACPROREC);
			}

			
		}
		
	}

	private static ConsultarDetalleFacturasProveedorIDTO  obtenerDetalleDesdeIntegracion(Document mensaje) throws Exception {
		
		ConsultarDetalleFacturasProveedorIDTO cabeceraDetallesFacInt = new ConsultarDetalleFacturasProveedorIDTO();
		ConsultarDetalleFacturasProveedorDetalleIDTO detalleFacturasProveedorDetalleIDTO = new ConsultarDetalleFacturasProveedorDetalleIDTO();
		
		cabeceraDetallesFacInt = obtenerObjetoDesdeIntegracion(mensaje, cabeceraDetallesFacInt, detalleFacturasProveedorDetalleIDTO);
		
		cabeceraDetallesFacInt.getControlProceso().setCodigoCompania(UtilIntegracion.VALOR_OMISION_CODIGOCOMPANIA);
		cabeceraDetallesFacInt.getControlProceso().setCodigoSistema(SICIntegracionMessages.CODIGO_SISTEMA);
		cabeceraDetallesFacInt.getControlProceso().setCodigoServicio(UtilIntegracion.CODIGOSERVICIO_GESTIONARORDENCOMPRA);
		
		cabeceraDetallesFacInt.getControlProceso().setResultado(UtilIntegracion.NO_PROCESADO+"ERROR VALIDAR DETALLE"); // devolver el mensaje exitoso
		
		return cabeceraDetallesFacInt;
		
	}
	
	private static ConsultarCabeceraFacturasProveedorIDTO  obtenerHeaderDesdeIntegracion(Document mensaje) throws Exception {
		
		ConsultarCabeceraFacturasProveedorIDTO headerInt = new ConsultarCabeceraFacturasProveedorIDTO();
		ConsultarCabeceraFacturasProveedorDetalleIDTO detalleIDTO = new ConsultarCabeceraFacturasProveedorDetalleIDTO();
		
		headerInt = obtenerObjetoDesdeIntegracion(mensaje, headerInt, detalleIDTO);
		
		headerInt.getControlProceso().setCodigoCompania(UtilIntegracion.VALOR_OMISION_CODIGOCOMPANIA);
		headerInt.getControlProceso().setCodigoSistema(SICIntegracionMessages.CODIGO_SISTEMA);
		headerInt.getControlProceso().setCodigoServicio(UtilIntegracion.CODIGOSERVICIO_GESTIONARORDENCOMPRA);
//		headerInt.getControlProceso().setFechaHora("20131221");
		
		headerInt.getControlProceso().setResultado(UtilIntegracion.NO_PROCESADO+"ERROR VALIDAR CABECERA"); // devolver el mensaje exitoso
		
		return headerInt;
		
	}
	
	/**
	 * Obtener objeto a partir del document obtenido desde la integracion
	 * @param mensaje
	 * @param t				instancia del objeto que representa el header de la integracion
	 * @param z				instancia del objeto que representa el detalle de la integracion
	 * @return	t 			cabecera con sus respectivos detalles
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	public static <T, Z> T  obtenerObjetoDesdeIntegracion(Document mensaje, T tAux, Z z) {
		T t = tAux;
		try {
			Document resultTemplate = XSLTransformer.transformDocument(mensaje, UtilIntegracion.PLANTILLA_ENTRADA_SERVICIOORDENCOMPRA, 
					IntegrationUtil.ORIGEN_PLANTILLA_FILE_SYSTEM);
			
			HashMap<String, Object> mapHeaderFactOrd = new HashMap<String, Object>();
			mapHeaderFactOrd.put("GestionarOrden", t);
			mapHeaderFactOrd.put("item", z); // para el casting del detalle del objeto t
			
			LogFramework.getLogger().info(".: Mensaje con el formato de la plantilla: {}", t.getClass().getName());
//			printMessage(mensaje.getFirstChild());
			
			t = (T) XMLTransformer.XMLtoObject(mapHeaderFactOrd, resultTemplate);
			
		} catch (Exception ex) {
			LogFramework.getLogger().error("Error obtener objeto de tipo header: {}", ex);
			throw new SICException(ex);
		}
		
		return t;
	}
	
	
	public static void printMessage(Node node) {
		
		NodeList nodeList = node.getChildNodes();
		
		if (nodeList.getLength() == 1 && nodeList.item(0).getChildNodes().getLength() == 0) { // no tiene hijos
			LogFramework.getLogger().info(node.getNodeName() + " " + node.getFirstChild().getNodeValue()) ;
		}  else {
			
			LogFramework.getLogger().info(node.getNodeName());
			for (int i = 0; i < nodeList.getLength(); i++) {
				printMessage(nodeList.item(i));
			}
		}
	}
	
}
