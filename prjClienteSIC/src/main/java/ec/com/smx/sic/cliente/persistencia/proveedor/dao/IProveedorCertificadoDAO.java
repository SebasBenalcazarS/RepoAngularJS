package ec.com.smx.sic.cliente.persistencia.proveedor.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.CertificadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorCertificadoArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorCertificadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorCertificadoDefinicionArchivoDTO;

/**
 * @author Marcelo Hidalgo
 *
 */
public interface IProveedorCertificadoDAO {
	
	/**
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<CertificadoDTO> obtenerCertificadosDisponibles(Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<ProveedorCertificadoDTO> obtenerCertificadosProveedor(Integer codigoCompania, String codigoProveedor) throws SICException;
	
	/**
	 * @param proveedorCertificado
	 * @throws SICException
	 */
	void registrarProveedorCertificado(ProveedorCertificadoDTO proveedorCertificado) throws SICException;
	
	/**
	 * @param proveedorCertificadoArchivo
	 * @return
	 * @throws SICException
	 */
	ProveedorCertificadoDefinicionArchivoDTO registrarProveedorCertificadoArchivo(ProveedorCertificadoArchivoDTO proveedorCertificadoArchivo) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param secuencialCertificado
	 * @param codigoProveedor
	 * @param estado
	 * @param userId
	 * @param secuencialArchivo
	 * @throws SICException
	 */
	void actualizarEstadoDefinicionProveedorArchivo(Integer codigoCompania, String secuencialCertificado, String codigoProveedor, String estado, String userId, String secuencialArchivo) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param secuencialArchivo
	 * @throws SICException
	 */
	byte[] cargarContenidoArchivoCertificadoProveedor(Integer codigoCompania, String secuencialArchivo) throws SICException;

}
