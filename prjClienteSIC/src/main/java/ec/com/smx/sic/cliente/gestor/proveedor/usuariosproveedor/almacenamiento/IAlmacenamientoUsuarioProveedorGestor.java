package ec.com.smx.sic.cliente.gestor.proveedor.usuariosproveedor.almacenamiento;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.corpv2.common.enums.ContactEntityType;
import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.sic.cliente.common.proveedor.bean.UsuarioProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.DatosRegistroProveedorVO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * 
 * @author Mario Braganza
 *
 */
public interface IAlmacenamientoUsuarioProveedorGestor extends Serializable {

	/**
	 * Regla de almacenamiento que guarda el usuario 
	 * @param baseVO
	 * @param emailsUsuariosModificados
	 * @param datosRegistroProveedorVO
	 * @throws SICException
	 */
	
	void registrarDatosUsuarioProveedor(ProveedorVO baseVO, Collection<String> emailsUsuariosModificados, DatosRegistroProveedorVO datosRegistroProveedorVO) throws SICException;

	/**
	 * 
	 * @param proveedorVO
	 * @param usuariosProveedor
	 * @param contactosRelacionados
	 * @param contactosRelacionadosInicial
	 * @throws SICException
	 */
	void guardarDatosUsuariosB2B(ProveedorVO proveedorVO, Collection<UsuarioProveedor> usuariosProveedor,  DatoContactoPersonaLocalizacionDTO contactoPersonal, Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados,  Long codigoEntidad, ContactEntityType tipoEntidad, Integer cantidadMaximaUsuarios, Integer codigoCompania, String idUser) throws SICException;
	
}