package ec.com.smx.sic.cliente.gestor.proveedor.contactos.almacenamiento;

import java.util.Collection;

import ec.com.smx.corpv2.common.enums.ContactEntityType;
import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 *
 */
public interface IAlmacenamientoDatosContactosProveedorGestor {

	/**
	 * @param codigoCompania
	 * @param email
	 * @param codigoEntidad
	 * @param tipoEntidad
	 * @param contactoPersonal
	 * @param contactosRelacionados
	 * @throws SICException
	 */
	void registrarEmailContactoProveedor(Integer codigoCompania, 
			String email, 
			Long codigoEntidad, ContactEntityType tipoEntidad,
			DatoContactoPersonaLocalizacionDTO contactoPersonal,
			Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados,
			String parametroTipoContactoProveedor,
			Boolean establecerContactoPorDefecto,
			String idUsuario) throws SICException;

}
