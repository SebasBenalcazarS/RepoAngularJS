package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;


public interface IValidacionProcesoLogisticoGestor {
	//TODO	
	/**
	 * 
	 * @param actualCatVal
	 * @param accionEntregaCatVal
	 * @throws SICException
	 */
	public void buscarEstadoRelacionado(CatalogoValorDTO actualCatVal, CatalogoValorDTO accionEntregaCatVal) throws SICException;

	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	public void cambiarEstadoProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;
}