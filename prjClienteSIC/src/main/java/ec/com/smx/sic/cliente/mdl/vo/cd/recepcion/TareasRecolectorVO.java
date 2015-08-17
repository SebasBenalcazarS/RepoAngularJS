/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo.cd.recepcion;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.VistaTareaDatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.VistaTareaRecolectorTransient;

/**
 * @author wcaiza
 *
 */
@SuppressWarnings("serial")
public class TareasRecolectorVO implements Serializable {
	
	private Collection<VistaTareaRecolectorTransient> colVistaTareaRecolectorTransients;
//	private Collection<TareaDatosTareaDTO> colTareaDatosTareaAsignados;
	private Boolean tienePalletsAsignados = Boolean.FALSE;
	
	/**
	 * Pallets que no se ingresan a balanzar EN_PROCESO y PESAR_PALLET
	 */
	private Collection<VistaTareaDatosTareaDTO> listaPalletsIngresoBalanza;
	
	/**
	 * Pallets que ya estan en balanza esperando a ser pesados
	 * se debe retirar luego que se pesado
	 */
	private Collection<VistaTareaDatosTareaDTO> listaPalletsRetirarBalanza;
	
	private Collection<VistaTareaDatosTareaDTO> listaPalletsPesado;
	private Collection<VistaTareaDatosTareaDTO> listaPalletsUbicacion;
	
	/**
	 * @return the colVistaTareaRecolectorTransients
	 */
	public Collection<VistaTareaRecolectorTransient> getColVistaTareaRecolectorTransients() {
		return colVistaTareaRecolectorTransients;
	}
	/**
	 * @param colVistaTareaRecolectorTransients the colVistaTareaRecolectorTransients to set
	 */
	public void setColVistaTareaRecolectorTransients(Collection<VistaTareaRecolectorTransient> colVistaTareaRecolectorTransients) {
		this.colVistaTareaRecolectorTransients = colVistaTareaRecolectorTransients;
	}
//	/**
//	 * @return the listaPalletsEnBalanza
//	 */
//	public Collection<VistaTareaDatosTareaDTO> getListaPalletsEnBalanza() {
//		return listaPalletsEnBalanza;
//	}
//	/**
//	 * @param listaPalletsEnBalanza the listaPalletsEnBalanza to set
//	 */
//	public void setListaPalletsEnBalanza(Collection<VistaTareaDatosTareaDTO> listaPalletsEnBalanza) {
//		this.listaPalletsEnBalanza = listaPalletsEnBalanza;
//	}
	/**
	 * @return the listaPalletsPesado
	 */
	public Collection<VistaTareaDatosTareaDTO> getListaPalletsPesado() {
		return listaPalletsPesado;
	}
	/**
	 * @param listaPalletsPesado the listaPalletsPesado to set
	 */
	public void setListaPalletsPesado(Collection<VistaTareaDatosTareaDTO> listaPalletsPesado) {
		this.listaPalletsPesado = listaPalletsPesado;
	}
	/**
	 * @return the listaPalletsUbicacion
	 */
	public Collection<VistaTareaDatosTareaDTO> getListaPalletsUbicacion() {
		return listaPalletsUbicacion;
	}
	/**
	 * @param listaPalletsUbicacion the listaPalletsUbicacion to set
	 */
	public void setListaPalletsUbicacion(Collection<VistaTareaDatosTareaDTO> listaPalletsUbicacion) {
		this.listaPalletsUbicacion = listaPalletsUbicacion;
	}
//	/**
//	 * @return the colTareaDatosTareaAsignados
//	 */
//	public Collection<TareaDatosTareaDTO> getColTareaDatosTareaAsignados() {
//		return colTareaDatosTareaAsignados;
//	}
//	/**
//	 * @param colTareaDatosTareaAsignados the colTareaDatosTareaAsignados to set
//	 */
//	public void setColTareaDatosTareaAsignados(Collection<TareaDatosTareaDTO> colTareaDatosTareaAsignados) {
//		this.colTareaDatosTareaAsignados = colTareaDatosTareaAsignados;
//	}
	/**
	 * @return the listaPalletsRetirarBalanza
	 */
	public Collection<VistaTareaDatosTareaDTO> getListaPalletsRetirarBalanza() {
		return listaPalletsRetirarBalanza;
	}
	/**
	 * @param listaPalletsRetirarBalanza the listaPalletsRetirarBalanza to set
	 */
	public void setListaPalletsRetirarBalanza(Collection<VistaTareaDatosTareaDTO> listaPalletsRetirarBalanza) {
		this.listaPalletsRetirarBalanza = listaPalletsRetirarBalanza;
	}
	/**
	 * @return the listaPalletsIngresoBalanza
	 */
	public Collection<VistaTareaDatosTareaDTO> getListaPalletsIngresoBalanza() {
		return listaPalletsIngresoBalanza;
	}
	/**
	 * @param listaPalletsIngresoBalanza the listaPalletsIngresoBalanza to set
	 */
	public void setListaPalletsIngresoBalanza(Collection<VistaTareaDatosTareaDTO> listaPalletsIngresoBalanza) {
		this.listaPalletsIngresoBalanza = listaPalletsIngresoBalanza;
	}
	/**
	 * @return the tienePalletsAsignados
	 */
	public Boolean getTienePalletsAsignados() {
		return tienePalletsAsignados;
	}
	/**
	 * @param tienePalletsAsignados the tienePalletsAsignados to set
	 */
	public void setTienePalletsAsignados(Boolean tienePalletsAsignados) {
		this.tienePalletsAsignados = tienePalletsAsignados;
	}
	
}
