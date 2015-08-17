package ec.com.smx.sic.cliente.common.recibidonocontabilizado;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.cliente.sri.comprobantes.electronicos.jaxb.factura.version110.Factura;
import ec.com.kruger.cliente.sri.comprobantes.electronicos.jaxb.notacredito.version110.NotaCredito;
import ec.com.kruger.cliente.sri.consumo.ws.ConsumoWsSRIUtil;
import ec.com.kruger.cliente.sri.consumo.ws.RespuestaWsSRI;
import ec.com.kruger.cliente.sri.respuesta.ws.jaxb.Autorizacion;
import ec.com.kruger.cliente.sri.respuesta.ws.jaxb.Autorizacion.FechaAutorizacion;
import ec.com.smx.framework.gestor.util.DateManager;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.bodega.SICBodegaConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.DocumentoAutorizacionSRI;
import ec.com.smx.sic.cliente.mdl.nopersistente.DocumentoElectronicoSRI;
import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.recibidoNoContabilizado.SICRecibidoNoContabilizadoMessages;



public final class RecibidoNoContabilizadoUtil {

	/**
	 * Constructor
	 */
	private RecibidoNoContabilizadoUtil() {

	}

	private static final RecibidoNoContabilizadoUtil INSTANCIA = new RecibidoNoContabilizadoUtil();
	
	/**
	 * @return the instancia
	 */
	public static RecibidoNoContabilizadoUtil getInstancia() {
		return INSTANCIA;
	}
	
	public DocumentoElectronicoSRI obtenerWSAutorizacionFacturaSRI(String claveAcceso, RespuestaWsSRI respuestaWsSRI) throws SICException{
		try{	
			DocumentoAutorizacionSRI documentoAutorizacionSRI = obtenerXmlAutorizacionSRI(claveAcceso, respuestaWsSRI);
			
			DocumentoElectronicoSRI documentoElectronicoSRI = new DocumentoElectronicoSRI();
			documentoElectronicoSRI.setAutorizacion(documentoAutorizacionSRI.getAutorizacion());
			documentoElectronicoSRI.setFactura(RecibidoNoContabilizadoUtil.getInstancia().xmlAObjectFactura(documentoAutorizacionSRI.getContenidoXML()));
			documentoElectronicoSRI.setComprobanteXml(documentoAutorizacionSRI.getContenidoXML());
			documentoElectronicoSRI.setFechaAutorizacion(documentoAutorizacionSRI.getFechaAutorizacion());
			documentoElectronicoSRI.setNumeroComprobantes(documentoAutorizacionSRI.getNumeroComprobantes());
			return documentoElectronicoSRI;
		} catch (Exception e) {
			throw new SICException("Error al momento de consultar el invocar el WS_SRI, " , e);
		}
	}
	
	public DocumentoElectronicoSRI obtenerWSAutorizacionNotaCreditoSRI(String claveAcceso, RespuestaWsSRI respuestaWsSRI) throws SICException{
		try{	
			DocumentoAutorizacionSRI documentoAutorizacionSRI = obtenerXmlAutorizacionSRI(claveAcceso, respuestaWsSRI);
			
			DocumentoElectronicoSRI documentoElectronicoSRI = new DocumentoElectronicoSRI();
			documentoElectronicoSRI.setAutorizacion(documentoAutorizacionSRI.getAutorizacion());
			documentoElectronicoSRI.setNotaCredito(RecibidoNoContabilizadoUtil.getInstancia().xmlAObjectNotaCredito(documentoAutorizacionSRI.getContenidoXML()));
			documentoElectronicoSRI.setComprobanteXml(documentoAutorizacionSRI.getContenidoXML());
			documentoElectronicoSRI.setFechaAutorizacion(documentoAutorizacionSRI.getFechaAutorizacion());
			documentoElectronicoSRI.setNumeroComprobantes(documentoAutorizacionSRI.getNumeroComprobantes());
			return documentoElectronicoSRI;
		} catch (Exception e) {
			throw new SICException("Error al momento de consultar el invocar el WS_SRI, " , e);
		}
	}
	
	private DocumentoAutorizacionSRI obtenerXmlAutorizacionSRI(String claveAcceso, RespuestaWsSRI respuestaWsSRI)throws SICException{
		try{	
			obtenerInformacionWSAutorizacionSRI(claveAcceso, respuestaWsSRI);
			if(respuestaWsSRI == null
					|| respuestaWsSRI.getRespuestaComprobante()==null
					|| respuestaWsSRI.getRespuestaComprobante().getAutorizaciones()==null
					|| CollectionUtils.isEmpty(respuestaWsSRI.getRespuestaComprobante().getAutorizaciones().getAutorizacion())
					|| respuestaWsSRI.getRespuestaComprobante().getAutorizaciones().getAutorizacion().get(0)== null
					|| respuestaWsSRI.getRespuestaComprobante().getAutorizaciones().getAutorizacion().get(0).getComprobante()==null){
				throw new SICException("No se encuentra la informacion en el servicio del SRI");
			}
			
			//Valido si existen comprobantes asociados a la clave de acceso
			if(Integer.valueOf(respuestaWsSRI.getRespuestaComprobante().getNumeroComprobantes()) == null
					|| Integer.valueOf(respuestaWsSRI.getRespuestaComprobante().getNumeroComprobantes()) == 0){
				throw new SICException("No existen documentos atados con la clave ingresada: "+claveAcceso);
			}
			
			String xml = respuestaWsSRI.getRespuestaComprobante().getAutorizaciones().getAutorizacion().get(0).getComprobante();
			
			//Se llena los datos de la autorizacion
			Autorizacion autorizacion = new Autorizacion();
			autorizacion.setEstado(respuestaWsSRI.getRespuestaComprobante().getAutorizaciones().getAutorizacion().get(0).getEstado());
			autorizacion.setNumeroAutorizacion(respuestaWsSRI.getRespuestaComprobante().getAutorizaciones().getAutorizacion().get(0).getNumeroAutorizacion());
			//Se obtiene la fecha
			GregorianCalendar calendar = respuestaWsSRI.getRespuestaComprobante().getAutorizaciones().getAutorizacion().get(0).getFechaAutorizacion();
			DateManager dateManager = new DateManager();
			String dia = dateManager.dateTransformFormat(calendar.getTime(), "dd");
			String mes = dateManager.dateTransformFormat(calendar.getTime(), "MM");
			String anio = dateManager.dateTransformFormat(calendar.getTime(), "yyyy");
			String hora = dateManager.dateTransformFormat(calendar.getTime(), "H");
			String minuto = dateManager.dateTransformFormat(calendar.getTime(), "m");
			String segundo = dateManager.dateTransformFormat(calendar.getTime(), "s");
			FechaAutorizacion fechaAutorizacion = new FechaAutorizacion();
			fechaAutorizacion.setValue(dia+"/"+mes+"/"+anio+" "+hora+":"+minuto+":"+segundo);
			autorizacion.setFechaAutorizacion(fechaAutorizacion);
			
			DocumentoAutorizacionSRI documentoAutorizacionSRI = new DocumentoAutorizacionSRI();
			documentoAutorizacionSRI.setContenidoXML(xml);
			documentoAutorizacionSRI.setAutorizacion(autorizacion);
			documentoAutorizacionSRI.setFechaAutorizacion(calendar);
			documentoAutorizacionSRI.setNumeroComprobantes(respuestaWsSRI.getRespuestaComprobante().getNumeroComprobantes());
			return documentoAutorizacionSRI;
		} catch (Exception e) {
			throw new SICException("Error al momento de consultar el invocar el WS_SRI, " , e);
		}
	}
	
	private void obtenerInformacionWSAutorizacionSRI(String claveAcceso, RespuestaWsSRI respuestaWsSRI)throws SICException{
		System.setProperty("https.proxyHost", SICRecibidoNoContabilizadoMessages.getInstancia().getString("ec.com.smx.sic.comprobantes.electronicos.sri.proxy.servidor"));
		System.setProperty("https.proxyPort", SICRecibidoNoContabilizadoMessages.getInstancia().getString("ec.com.smx.sic.comprobantes.electronicos.sri.proxy.puerto"));
		try {
			ConsumoWsSRIUtil.invocacionWSAutorizacionSRI(claveAcceso, SICRecibidoNoContabilizadoMessages.getInstancia().getString("ec.com.smx.sic.electronicos.sri.url.ws.autorizacion"), respuestaWsSRI);
		} catch (Exception e) {
			throw new SICException("Error al momento de consultar el invocar el WS_SRI, " , e);
		}
	}
	
	public Factura xmlAObjectFactura(String valor){
		try {
			JAXBContext context = JAXBContext.newInstance(Factura.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Factura factura = (Factura)unmarshaller.unmarshal(new StringReader(valor));
			return factura;	
		} catch (JAXBException e) {
			Logeable.LOG_SICV2.error(e.getMessage());
		}
		return null;
	}
	
	public NotaCredito xmlAObjectNotaCredito(String valor){
		try {
			JAXBContext context = JAXBContext.newInstance(NotaCredito.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			NotaCredito notaCredito = (NotaCredito)unmarshaller.unmarshal(new StringReader(valor));
			return notaCredito;	
		} catch (JAXBException e) {
			Logeable.LOG_SICV2.error(e.getMessage());
		}
		return null;
	}
	
	public String obtenerCodigoTipoDocumento( String valorTipoDocumentoComprobante, String valorTipoDocumentoComprobanteElec ) throws SICException{
		String valorTipoDocumentoFactura = "SICBodegaConstantes.CODIGO_VALOR_FACTURA_FISICA;";
		try {
			if(StringUtils.equals(valorTipoDocumentoComprobante, SICMessages.getInstancia().getString("ec.com.smx.sic.tipo.comprobante.factura.id"))){
				valorTipoDocumentoFactura = SICBodegaConstantes.CODIGO_VALOR_FACTURA_FISICA;
			}else if(StringUtils.equals(valorTipoDocumentoComprobante, SICMessages.getInstancia().getString("ec.com.smx.sic.tipo.comprobante.nota.credito.id"))){
				valorTipoDocumentoFactura = SICBodegaConstantes.CODIGO_VALOR_NOTA_CREDITO;
			}else if(StringUtils.equals(valorTipoDocumentoComprobante, SICMessages.getInstancia().getString("ec.com.smx.sic.tipo.comprobante.nota.debito.id"))){
				valorTipoDocumentoFactura = SICBodegaConstantes.CODIGO_VALOR_NOTA_DEBITO;
			}else if(StringUtils.equals(valorTipoDocumentoComprobanteElec, SICMessages.getInstancia().getString("ec.com.smx.sic.tipo.comprobante.electronico.factura.id"))){
				valorTipoDocumentoFactura = SICBodegaConstantes.CODIGO_VALOR_FACTURA_ELECTRONICA;
			}else if(StringUtils.equals(valorTipoDocumentoComprobanteElec, SICMessages.getInstancia().getString("ec.com.smx.sic.tipo.comprobante.electronico.nota.credito.id"))){
				valorTipoDocumentoFactura = SICBodegaConstantes.CODIGO_VALOR_NOTA_CREDITO_ELECTRONICA;
			}else if(StringUtils.equals(valorTipoDocumentoComprobanteElec, SICMessages.getInstancia().getString("ec.com.smx.sic.tipo.comprobante.electronico.nota.debito.id"))){
				valorTipoDocumentoFactura = SICBodegaConstantes.CODIGO_VALOR_NOTA_DEBITO_ELECTRONICA;
			}
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("No se pudo obtener el tipo de documento {0}" , e);
			throw new SICException("No se pudo obtener el tipo de documento " , e);
		}	
		return valorTipoDocumentoFactura;
	}
	
	/**
	 * Retorna los estados de documentos electronicos que no son validos
	 * @return
	 */
	public List<String> estadosDocumentoElectronicoNovalido(){
		List<String> valoresTipoValidacion = new ArrayList<String>();
		valoresTipoValidacion.add(SICRecibidoNoContabilizadoConstantes.CODIGO_CATALOGO_VALOR_VALIDACION_FACTURAELECTRONICA_RECHAZADO);
		valoresTipoValidacion.add(SICRecibidoNoContabilizadoConstantes.CODIGO_CATALOGO_VALOR_VALIDACION_FACTURAELECTRONICA_ANULADO);
		valoresTipoValidacion.add(SICRecibidoNoContabilizadoConstantes.CODIGO_CATALOGO_VALOR_VALIDACION_FACTURAELECTRONICA_NO_AUTORIZADO);
		return valoresTipoValidacion;
	}
	
	/**
	 * Permite convertir el estado catalogo valor del documento electronico a los estados que maneja el SRI
	 * @param valorTipoValidacion
	 * @return
	 */
	public String conversionEstadoDocumentoElectronico(String valorTipoValidacion){
		String estadoFacturaElectronica = SICRecibidoNoContabilizadoConstantes.DOCUMENTO_ELECTRONICO_ESTADO_AUTORIZADO;
		//Rechazado
		if(StringUtils.equals(valorTipoValidacion, SICRecibidoNoContabilizadoConstantes.CODIGO_CATALOGO_VALOR_VALIDACION_FACTURAELECTRONICA_RECHAZADO)){
			estadoFacturaElectronica = SICRecibidoNoContabilizadoConstantes.DOCUMENTO_ELECTRONICO_ESTADO_RECHAZADO;
		}
		//Anulado
		else if(StringUtils.equals(valorTipoValidacion, SICRecibidoNoContabilizadoConstantes.CODIGO_CATALOGO_VALOR_VALIDACION_FACTURAELECTRONICA_ANULADO)){
			estadoFacturaElectronica = SICRecibidoNoContabilizadoConstantes.DOCUMENTO_ELECTRONICO_ESTADO_ANULADO;
		}
		//No autorizado
		else if(StringUtils.equals(valorTipoValidacion, SICRecibidoNoContabilizadoConstantes.CODIGO_CATALOGO_VALOR_VALIDACION_FACTURAELECTRONICA_NO_AUTORIZADO)){
			estadoFacturaElectronica = SICRecibidoNoContabilizadoConstantes.DOCUMENTO_ELECTRONICO_ESTADO_NO_AUTORIZADO;
		}
		return estadoFacturaElectronica;
	}
	
	/**
	 * Permite convertir el estado del documento electronico del SRI a los estados del catalogo valor
	 * @param valorTipoValidacion
	 * @return
	 */
	public String conversionEstadoDocumentoElectronicoWS(String estadoFacturaElectronica){
		String valorTipoValidacion = null;
		//Estado rechazado
		if(StringUtils.equals(estadoFacturaElectronica, SICRecibidoNoContabilizadoConstantes.DOCUMENTO_ELECTRONICO_ESTADO_RECHAZADO)){
			valorTipoValidacion = SICRecibidoNoContabilizadoConstantes.CODIGO_CATALOGO_VALOR_VALIDACION_FACTURAELECTRONICA_RECHAZADO;
		}
		//Estado anulado
		else if(StringUtils.equals(estadoFacturaElectronica, SICRecibidoNoContabilizadoConstantes.DOCUMENTO_ELECTRONICO_ESTADO_ANULADO)){
			valorTipoValidacion = SICRecibidoNoContabilizadoConstantes.CODIGO_CATALOGO_VALOR_VALIDACION_FACTURAELECTRONICA_ANULADO;
		}
		//Estado no autorizado
		else if(StringUtils.equals(estadoFacturaElectronica, SICRecibidoNoContabilizadoConstantes.DOCUMENTO_ELECTRONICO_ESTADO_NO_AUTORIZADO)){
			valorTipoValidacion = SICRecibidoNoContabilizadoConstantes.CODIGO_CATALOGO_VALOR_VALIDACION_FACTURAELECTRONICA_NO_AUTORIZADO;
		}
		return valorTipoValidacion;
	}
}
