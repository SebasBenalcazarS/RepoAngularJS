package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ValidacionDocumentoDTO;

/**
 * Permite gestionar las diferentes validaciones de los documentos/facturas/notas crédito, débito
 * @author fcollaguazo
 *
 */
public interface IValidacionDocumentoDAO {

	/**
	 * Permite crear un registro en la validacion del documento
	 * @param validacionDocumentoDTO
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void crearValidacionDocumento(ValidacionDocumentoDTO validacionDocumentoDTO, String codigoUsuario)throws SICException;
	
	/**
	 * Permite crear un registro en la validacion del documento
	 * @param codigoCompania
	 * @param codigoFactura
	 * @param valorTipoValidacion
	 * @param valorTipoResultado
	 * @param resultadoValidacion
	 * @param codigoUsuario
	 * @throws SICException
	 */
	public void crearValidacionDocumento(Integer codigoCompania, Long codigoFactura, String valorTipoValidacion, String valorTipoResultado, String resultadoValidacion, String codigoUsuario)throws SICException;
	
	/**
	 * Permite obtener las validaciones del documento de un tipo de resultado especifico
	 * @param codigoFactura
	 * @param valoresTipoValidacion
	 * @param valorTipoResultado
	 * @return
	 * @throws SICException
	 */
	Collection<ValidacionDocumentoDTO> obtenerValidacionDocumento(Long codigoFactura, List<String> valoresTipoValidacion, String valorTipoResultado)throws SICException;
	
	/**
	 * Permite obtener las validaciones de los documentos relacionados
	 * @param codigoFacturaPadre
	 * @param valoresTipoValidacion
	 * @param valorTipoResultado
	 * @return
	 * @throws SICException
	 */
	public Collection<ValidacionDocumentoDTO> obtenerValidacionesDocumentoRelacionados(Long codigoFacturaPadre, List<String> valoresTipoValidacion, String valorTipoResultado)throws SICException;
	
	/**
	 * Permite inactivar las validaciones del documento electronico
	 * @param codigoFactura
	 * @param valoresTipoValidacion
	 * @param valorTipoResultado
	 */
	public void inactivarValidacionesDocumento(Long codigoFactura, List<String> valoresTipoValidacion, String valorTipoResultado, String codigoUsuario)throws SICException;
	
	/**
	 * Permite eliminar las validaciones del documento electronico
	 * @param codigoCompania
	 * @param valoresTipoValidacion
	 * @param codigoFactura
	 * @throws SICException
	 */
	public void eliminarValidacionesDocumento(Integer codigoCompania, List<String> valoresTipoValidacion, Long codigoFactura) throws SICException;
	
	/**
	 * <b> Actualiza es estado del documento asociados a una o mas facturas. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 19/6/2015]
	 * </p>
	 *
	 * @param codigoCompania
	 *            codigo de la compania
	 * @param userId
	 *            identificacdor del usuario que realiza la transaccion
	 * @param nuevoEstado
	 *            estado para actualizar la factura
	 * @param codigosFactura
	 *            codigos de facturas en las cuales se cambia el estado del documento
	 */
	void actualizarEstadoValidacionesDocumento(Integer codigoCompania, String userId, String nuevoEstado,
			Long... codigosFactura);
}
