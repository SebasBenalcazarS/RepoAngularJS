package ec.com.smx.sic.cliente.gestor.proveedor.proveedoroficinaexterior.almacenamiento;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import ec.com.smx.corpv2.dto.ContactoPersonaLocalizacionRelacionadoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorOficinaExteriorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorOficinaExteriorID;
import ec.com.smx.sic.cliente.mdl.vo.DatosRegistroProveedorVO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

public interface IAlmacenamientoProveedorOficinaExteriorGestor extends Serializable {

	/**
	 * Regla de almacenamiento que guarda la coleccion de proveedor oficina exterior
	 * @param baseVO
	 * @throws SICException
	 */
	void registrarProveedorOficinaExterior(ProveedorVO proveedorVO,
			Collection<ProveedorOficinaExteriorDTO> oficinasExteriorProveedor)
			throws SICException;


	/**
	 * @param proveedorVO
	 * @param oficinasAsignadas
	 * @param oficinaExteriorProveedor
	 * @param contactosRelacionados
	 * @throws SICException
	 */
	void registrarProveedorOficinaExterior(DatosRegistroProveedorVO datosRegistroProveedorVO, Collection<ProveedorOficinaExteriorDTO> oficinasAsignadas, ProveedorOficinaExteriorDTO oficinaExteriorProveedor, Collection<ContactoPersonaLocalizacionRelacionadoDTO> contactosRelacionados, Boolean desactivarTodas) throws SICException;


	/**
	 * @param proveedorVO
	 * @param oficinasAsignadas
	 * @param oficinaExteriorProveedor
	 * @param contactosRelacionados
	 * @throws SICException
	 */
	public void registrarProveedorOficinaExterior( DatosRegistroProveedorVO datosRegistroProveedorVO, ProveedorOficinaExteriorDTO oficinaExteriorDTO,
			Map<ProveedorOficinaExteriorID, Collection<ContactoPersonaLocalizacionRelacionadoDTO>> contactosProveedorOficinaExterior,
			Boolean desactivarTodas) throws SICException;
}