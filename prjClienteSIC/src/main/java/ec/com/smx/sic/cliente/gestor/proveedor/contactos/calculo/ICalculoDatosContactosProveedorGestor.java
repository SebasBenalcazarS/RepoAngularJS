/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.contactos.calculo;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.corpv2.common.enums.ContactEntityType;
import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author lyacchirema
 * @author Mario Braganza
 *
 */
public interface ICalculoDatosContactosProveedorGestor extends Serializable {

	/**
	 * @param codigoCompania
	 * @param codigoEntidad
	 * @param tipoEntidad
	 * @param contactoPersonal
	 * @param contactosRelacionados
	 * @return
	 * @throws SICException
	 */
	DatoContactoPersonaLocalizacionDTO obtenerContactoProveedor(Integer codigoCompania,
			Long codigoEntidad, ContactEntityType tipoEntidad,
			DatoContactoPersonaLocalizacionDTO contactoPersonal,
			Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados,
			String parametroTipoContacto,
			Boolean establecerContactoPorDefecto) throws SICException;
	
	
	/**
	 * 
	 * @param proveedorVO
	 * @param parametroTipoContactoProveedor
	 * @return
	 * @throws SICException
	 */
	public DatoContactoPersonaLocalizacionDTO obtenerContactoProveedor(ProveedorVO proveedorVO,
			String parametroTipoContactoProveedor,
			Boolean establecerContactoPorDefecto) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigoEntidad
	 * @param tipoEntidad
	 * @param contactoPersonal
	 * @param contactosRelacionados
	 * @return
	 * @throws SICException
	 */
	String obtenerEmailContactoProveedor(Integer codigoCompania,
			Long codigoEntidad, ContactEntityType tipoEntidad,
			DatoContactoPersonaLocalizacionDTO contactoPersonal,
			Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados,
			String parametroTipoContacto,
			Boolean establecerContactoPorDefecto) throws SICException;

	/**
	 * @param codigoCompania
	 * @param email
	 * @param codigoEntidad
	 * @param tipoEntidad
	 * @param contactoPersonal
	 * @param contactosRelacionados
	 * @return
	 * @throws SICException
	 */
	DatoContactoPersonaLocalizacionDTO establecerEmailContactoProveedor(Integer codigoCompania, String email,
			Long codigoEntidad, ContactEntityType tipoEntidad,
			DatoContactoPersonaLocalizacionDTO contactoPersonal,
			Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados,
			String parametroTipoContacto,
			Boolean establecerContactoPorDefecto,
			String idUsuario) throws SICException;

	/**
	 * @param codigoCompania
	 * @param proveedores
	 * @return
	 * @throws SICException
	 */
	Collection<DatoContactoPersonaLocalizacionDTO> obtenerContactosPrincipalesProveedoresPorEntidades(Integer codigoCompania,
			Collection<VistaProveedorDTO> proveedores) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param proveedores
	 * @throws SICException
	 */
	void establecerContactosPrincipalesProveedores(Integer codigoCompania, Collection<VistaProveedorDTO> proveedores) throws SICException;
}
