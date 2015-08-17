/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.proveedoroficinaexterior.calculo;

import java.util.ArrayList;
import java.util.Collection;

import ec.com.smx.corpv2.common.util.ItemDataRegisteredContacts;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorOficinaExteriorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorID;

/**
 * @author gaortiz
 *
 */
public interface ICalculoProveedorOficinaExteriorGestor {
	
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

}
