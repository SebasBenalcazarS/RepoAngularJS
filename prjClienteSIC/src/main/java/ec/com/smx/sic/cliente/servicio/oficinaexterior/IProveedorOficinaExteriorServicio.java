package ec.com.smx.sic.cliente.servicio.oficinaexterior;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.common.util.ItemDataRegisteredContacts;
import ec.com.smx.corpv2.dto.ContactoPersonaLocalizacionRelacionadoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorOficinaExteriorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorID;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorOficinaExteriorID;
import ec.com.smx.sic.cliente.mdl.vo.DatosRegistroProveedorVO;

public interface IProveedorOficinaExteriorServicio {
	
	/**
	 * 
	 * @param paramProveedorID
	 * @return
	 */
	Collection<ItemDataRegisteredContacts> obtenerItemDataRegisteredContacts(ProveedorID paramProveedorID);
	
	/**
	 * 
	 * @param oficinasExterior
	 * @return
	 */
	ArrayList<String> obtenerColoresPorOficinaExterior(Collection<ProveedorOficinaExteriorDTO> oficinasExterior);
	

	/**
	 * 
	 * @param proveedorVO
	 * @param oficinasAsignadas
	 * @param oficinaExteriorProveedorVO
	 * @param contactosRelacionados
	 * @throws SICException
	 */
	void registrarProveedorOficinaExterior(DatosRegistroProveedorVO datosRegistroProveedorVO, Collection<ProveedorOficinaExteriorDTO> oficinasAsignadas, BaseVO<ProveedorOficinaExteriorDTO> oficinaExteriorProveedorVO, Collection<ContactoPersonaLocalizacionRelacionadoDTO> contactosRelacionados, Boolean desactivarTodas) throws SICException;
	
	
	/**
	 * 
	 * @param proveedorVO
	 * @param oficinasAsignadas
	 * @param oficinaExteriorProveedorVO
	 * @param contactosRelacionados
	 * @throws SICException
	 */
	void registrarProveedorOficinaExterior(DatosRegistroProveedorVO datosRegistroProveedorVO, ProveedorOficinaExteriorDTO oficinaExteriorProveedorDTO, Map<ProveedorOficinaExteriorID, Collection<ContactoPersonaLocalizacionRelacionadoDTO>> contactosProveedorOficinaExterior, Boolean desactivarTodas) throws SICException;
	
}
