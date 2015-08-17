package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloCodBarrasEtiquetaMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCampoMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRazonSocialProveedorDTO;
/**
 * 
 * @author aquingaluisa
 *
 */
public interface IVistaCampoMercanciaDAO {
	
	VistaCampoMercanciaDTO obtenerCamposMercancia(String codigoArticulo, Integer codigoCompania) throws SICException;
	VistaRazonSocialProveedorDTO obtenerRazonSocialProveedor(String codigoArticulo, String codigoProveedor, Integer codigoCompania) throws SICException;
	Date obtenerFechaLote(String codigoArticulo, Integer codigoCompania) throws SICException;
	String obtenerCodigoClasificacionParaValidacionImportado(String codigoArticulo, Integer codigoCompania) throws SICException;
	VistaArticuloCodBarrasEtiquetaMercanciaDTO obtenerMercanciaporCodigoBarras(String codigoBarras, Integer codigoCompania)throws SICException;
	
}
