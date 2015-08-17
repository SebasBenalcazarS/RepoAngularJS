package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;


/**
 * 
 * @author guvidia
 *
 */
public interface IAlmacenamientoProcesoLogisticoGestor {

	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	public void asignarProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	public void recibirProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	public void cancelarProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;
	
	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	public void liberarProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	public void suspenderProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	public void terminarProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	public void modificarCantidadProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	public void facturarProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	public void reanudarProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	/**
	 * 
	 * @param procesoLogisticoDTO
	 * @throws SICException
	 */
	void recibidoJabasProcesoLogistico(ProcesoLogisticoDTO procesoLogisticoDTO) throws SICException;

	
}
