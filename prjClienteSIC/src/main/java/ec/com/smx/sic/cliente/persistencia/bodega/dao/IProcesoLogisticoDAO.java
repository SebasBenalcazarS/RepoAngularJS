package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoEstadoDTO;

public interface IProcesoLogisticoDAO {
	
	/**
	 * Obtiene el porcentaje de recepcion por porceso Logistico
	 * 
	 * @param Collection de los Procesos Log�sticos que requieren obtener el porcentaje de recepci�n
	 * @return Collection<Object[]> con dos columnas: codigo del Proceso logistico, porcentaje de avance  
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public abstract Collection<Object[]> obtenerPorcentajeRecepcionPorProcesoLogistico(Collection<ProcesoLogisticoDTO> listaProcesoLogistico) throws SICException;
	
	/**
	 * Finaliza el estado de un proceso logistico
	 * 
	 * @param procesoLogisticoEstadoDTO
	 * @param usuario
	 * @throws SICException epcion en caso de producirse un error
	 */
	public abstract void finalizarProcesoLogisticoEstado(ProcesoLogisticoEstadoDTO procesoLogisticoEstadoDTO, String usuario) throws SICException;
	
	/**
	 * Actualiza el estado actual en el que se encuetra el proceso logistico
	 * 
	 * @param secuencialProcesoLogistico Secuencial del proceso logistico
	 * @param estado Estado actual del proceso logistico
	 * @throws SICException epcion en caso de producirse un error
	 */
	public abstract void actualizarEstadoActualProcesoLogistico(Long secuencialProcesoLogistico, CatalogoValorDTO estado) throws SICException;

	/**
	 * Obtiene el valor del estado actual del proceso logistico
	 * 
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @throws SICException en caso de producirse un error
	 */
	ProcesoLogisticoDTO obtenerEstadoActualProcesoLogistico(Integer codigoCompania, Long codigoProcesoLogistico) throws SICException;
}
