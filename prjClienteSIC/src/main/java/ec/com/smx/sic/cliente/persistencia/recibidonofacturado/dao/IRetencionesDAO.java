package ec.com.smx.sic.cliente.persistencia.recibidonofacturado.dao;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArchivoDocumentoXmlDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaInformacionFacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecibidoNoFacturadoRetencionesDTO;


public interface IRetencionesDAO {
	
	public Collection<VistaRecibidoNoFacturadoRetencionesDTO> obtenerRetenciones(String codigoProveedor, Date fechaDesde, Date fechaHasta, String numeroRetencion, String numeroFactura)	throws SICException;
	
	public VistaInformacionFacturaDTO obtenerCodigoFactura(String rucProveedor, String fechaFactura, String numeroFactura) throws SICException;
	
	public Boolean guardarXML(ArchivoDocumentoXmlDTO retencionXmlDTO, String numeroRetencion, Long codigoFacturaPadre) throws SICException;
	
	public void crearActualizarXML(Integer codigoCompania, Long codigoDocumento, String contenidoXML, String idUsuario)throws SICException;	
	
	public void crearXML(Integer codigoCompania, Long codigoDocumento, String contenidoXML, String idUsuario)throws SICException;
	
	public void actualizarXML(Integer codigoCompania, Integer codigoArchivoDocumentoXml, String contenidoXml, String estado, String codigoUsuario)throws SICException;
	
	public void activarDesactivarXML(Long codigoDocumento, String estado, String codigoUsuario)throws SICException;
	
	/**
	 * Obtiene todos los documentosXml de la factura dada
	 * @param numeroFactura
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<ArchivoDocumentoXmlDTO> obtenerDocumentoXml(final Long codigoFactura, final Integer codigoCompania) throws SICException;
}
