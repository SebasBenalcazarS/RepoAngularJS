package ec.com.smx.sic.cliente.gestor.proveedor.administracion.almacenamiento;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.common.proveedor.TipoDatoProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.CertificadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorCertificadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorCertificadoDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorImportadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.DatosRegistroProveedorVO;

/**
 * 
 * @author Mario Braganza
 *
 */
public interface IAlmacenamientoProveedorGestor {

	
	/**
	 * 
	 * @param proveedorVO
	 * @param detalleProveedorOficinaExterior
	 * @param contactosProveedor
	 * @throws SICException
	 */
	void registrarProveedor(DatosRegistroProveedorVO datosRegistroProveedorVO) throws SICException;
	
	/**
	 * @param proveedorVO
	 * @param tiposDatosProveedor
	 * @throws SICException
	 */
	void registrarDatosAdicionalesProveedor(Boolean asignarPerfiles, DatosRegistroProveedorVO datosRegistroProveedorVO, TipoDatoProveedor... tiposDatosProveedor) throws SICException;
		
	/**
	 * 
	 * @param proveedorImp
	 * @param tipoProceso
	 * @return
	 * @throws SICException
	 */
	ProveedorImportadoDTO registrarProveedorImportado(ProveedorImportadoDTO proveedorImp,String tipoProceso) throws SICException;
	
	/**
	 * Actualiza la fechaInicioOperacion
	 * 
	 * @param codigoCompania
	 * @param fechaRegistro
	 * @param fechaCreacionOrden
	 * @param idUsuarioModificacion Id del Usuario que se encuentra en el sistema
	 * @throws SICException
	 */
	void actualizarFechaInicioOperacion(Integer codigoCompania, String codigoProveedor, Timestamp fechaRegistro, Date fechaOrdenCreacionCompra, String idUsuarioModificacion) throws SICException;
	
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
	 * 
	 * @param certificados
	 * @param codigoProveedor
	 * @param userId
	 * @param isUpdate
	 * @return
	 * @throws SICException
	 */
	public Collection<ProveedorCertificadoDTO> registrarCertificadosProveedor(Collection<CertificadoDTO> certificados, String codigoProveedor, String userId, Boolean isUpdate) throws SICException;
	
	/**
	 * @param proveedorCertificado
	 * @param userId
	 * @param nombreArchivo
	 * @param descripcionArchivo
	 * @param tamanioArchivo
	 * @param contenidoArchivo
	 * @param tipoContenidoArchivo
	 * @return
	 * @throws SICException
	 */
	public ProveedorCertificadoDefinicionArchivoDTO registrarProveedorCertificadoArchivo(ProveedorCertificadoDTO proveedorCertificado, String userId, String nombreArchivo, String descripcionArchivo, Double tamanioArchivo, byte[] contenidoArchivo, String tipoContenidoArchivo) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param secuencialCertificado
	 * @param codigoProveedor
	 * @param estado
	 * @param userId
	 * @throws SICException
	 */
	public void eliminarDefinicionProveedorArchivo(Integer codigoCompania, String secuencialCertificado, String codigoProveedor, String estado, String userId, String secuencialArchivo) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param secuencialArchivo
	 * @throws SICException
	 */
	byte[] cargarContenidoArchivoCertificadoProveedor(Integer codigoCompania, String secuencialArchivo) throws SICException;

}