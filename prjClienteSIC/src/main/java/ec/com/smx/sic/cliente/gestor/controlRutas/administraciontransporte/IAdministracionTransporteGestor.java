package ec.com.smx.sic.cliente.gestor.controlRutas.administraciontransporte;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.VehiculoDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VehiculoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VehiculoChoferDTO;

/**
 * @author egudino
 *
 */

public interface IAdministracionTransporteGestor {
	
	
	/**
	 * Interface del gestor para obtener la lista de transportes
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @param datosPaginados
	 * @param firstResult
	 * @param maxResults
	 * @param paginadoManual
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	public <T extends SearchDTO> Duplex<T, SearchResultDTO<T>> obtenerTransportePorPlantillas(Integer codigoCompania,	Collection<ISearchTemplate> plantillasBusqueda,	Boolean datosPaginados, Integer firstResult, Integer maxResults, Boolean paginadoManual, String codigoFuncionario) throws SICException;

	/**
	 * Metodo para exportar datos a excel
	 * @param codigoCompania
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Collection<T> obtenerTransportes(Integer codigoCompania, Collection<ISearchTemplate> plantillasBusqueda) throws SICException;
	
	/**
	 * Metodo que sirve para guardar los datos del cabezales
	 * @param plantillaVehiculo
	 * @param plantillaVehiculoChoferCols
	 * @throws SICException
	 */
	public void guardarCabezal(VehiculoDTO plantillaVehiculo, Collection<VehiculoChoferDTO> plantillaVehiculoChoferCols, VehiculoAreaTrabajoDTO plantillaVehicloAreaTrabajo) throws SICException;
	
	/**
	 * Metodo que sirve para actualizar los datos del cabezal
	 * @param plantillaVehiculo
	 * @param plantillaVehiculoChoferCols
	 * @throws SICException
	 */
	public void actualizarCabezal(VehiculoDTO plantillaVehiculo, Collection<VehiculoChoferDTO> plantillaVehiculoChoferCols, VehiculoAreaTrabajoDTO plantillaVehicloAreaTrabajo) throws SICException;
}
