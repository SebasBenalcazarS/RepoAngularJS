package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.HashMap;

import ec.com.smx.sic.cliente.common.bodega.EnumValorFiltrosUbicacion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaUbicacionArticuloDTO;

public interface IVistaUbicacionArticuloDAO {

	
	/**
	 * 
	 * @param codigoSubBodegaCol
	 * @param codigoDetalleSeccion
	 * @param tamPag
	 * @return
	 * @throws SICException
	 */
	public Integer countBusquedaUbicaciones(Integer codigoAreaTrabajoBOD,Integer codigoAreaTrabajoSUB,Long codigoDetalleSeccion)throws SICException;
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaUbicacionArticuloDTO> buscarUbicaciones(Integer codigoAreaTrabajoBOD,Integer codigoAreaTrabajoSUB,Long codigoDetalleSeccion,Integer firstResult,Integer maxResults)throws SICException;
	
	/**
	 * Obtiene las ubicaciones por filtros
	 * @param codigoAreaTrabajoBOD
	 * @param codigoAreaTrabajoSUB
	 * @param firstResult
	 * @param maxResults
	 * @param filtros
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaUbicacionArticuloDTO> buscarUbicacionesFiltro(Integer codigoAreaTrabajoBOD,Integer codigoAreaTrabajoSUB,Integer firstResult,Integer maxResults,  HashMap<EnumValorFiltrosUbicacion, Object> filtros)throws SICException;
	
	/**
	 * Permite obtener una VistaUbicacionArticuloDTO de ubicaciones virtuales de una ubicacion fisica
	 * @param codigoDetalleSeccionPadre
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaUbicacionArticuloDTO> obtenerUbicacionesVirtualesUniMan(Long codigoDetalleSeccionPadre,Integer codigoCompania,Boolean verificarCantidad)throws SICException;
	
	/**
	 * 
	 * @param codigoDetalleSeccion
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaUbicacionArticuloDTO> consultarUbicaciones(Long codigoDetalleSeccion,Integer codigoAreaTrabajoBOD,Integer codigoAreaTrabajoSUB,Integer firstResult,Integer maxResults)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoBodega
	 * @param codigoSubBodega
	 * @param filterUbicacion
	 * @param enumValorFiltrosUbicacion
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaUbicacionArticuloDTO> buscarUbicacionesFiltradas(Integer codigoCompania,Integer codigoBodega,Integer codigoSubBodega,HashMap<EnumValorFiltrosUbicacion, Object> filterUbicacion,EnumValorFiltrosUbicacion enumValorFiltrosUbicacion)throws SICException;
	
}
