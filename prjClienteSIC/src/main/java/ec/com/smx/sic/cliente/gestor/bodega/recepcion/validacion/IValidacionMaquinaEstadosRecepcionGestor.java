package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;


public interface IValidacionMaquinaEstadosRecepcionGestor {

	/**
	 * 
	 * @param datosTareaDTO
	 * @throws SICException
	 */
	public void cambiarEstadoDatosTarea(DatosTareaDTO datosTareaDTO) throws SICException;	
	
	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	public void cambiarEstadoProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;
	
	/**
	 * 
	 * @param tareaDTO
	 * @throws SICException
	 */
	public void cambiarEstadoTarea(TareaDTO tareaDTO) throws SICException;
	
	/**
	 * 
	 * @param actualCatVal
	 * @param accionCatVal
	 * @throws SICException
	 */
	public void validarBuscarEstadoRelacionado(CatalogoValorDTO actualCatVal, CatalogoValorDTO accionCatVal) throws SICException;
	
}