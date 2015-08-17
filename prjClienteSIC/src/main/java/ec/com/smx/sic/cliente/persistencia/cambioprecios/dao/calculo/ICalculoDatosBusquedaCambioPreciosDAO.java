/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.cambioprecios.dao.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.hibernate.criterion.Criterion;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.HistorialPrecioDiferenciadoArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.PrecioDiferenciadoArticuloGestionDTO;

/**
 * @author gnolivos
 *
 */
public interface ICalculoDatosBusquedaCambioPreciosDAO extends Serializable{
	
	/**
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param restriccionesFiltros
	 * @param firstResult
	 * @param maxResult
	 * @param countAgain
	 * @param esPaginado
	 * @param mostrarProcesados
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Duplex<Collection<T>, Long> obtenerDatosGeneralesCambioPrecios(Integer codigoCompania, String codigoFuncionario, Criterion restriccionesFiltros, Integer firstResult,Integer maxResult, Boolean countAgain, Boolean esPaginado, Boolean mostrarProcesados) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param restriccionesFiltros
	 * @param firstResult
	 * @param maxResult
	 * @param countAgain
	 * @param esPaginado
	 * @param mostrarProcesados
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Duplex<Collection<T>, Long> obtenerHistorialCambioPrecios(Integer codigoCompania, String codigoFuncionario, Criterion restriccionesFiltros, Integer firstResult,Integer maxResult, Boolean countAgain, Boolean esPaginado) throws SICException;
	
	
	/**
	 * @param codigoCompania
	 * @param codigosGestionPrecio
	 * @param codigosArticulos
	 * @return
	 * @throws SICException
	 */
	Collection<PrecioDiferenciadoArticuloGestionDTO> obtenerArticulosPreciosDiferenciados(Integer codigoCompania, Set<Long> codigosGestionPrecio, Set<String> codigosArticulos) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigosGestionPrecio
	 * @param codigosArticulos
	 * @return
	 * @throws SICException
	 */
	Collection<HistorialPrecioDiferenciadoArticuloDTO> obtenerPreciosDiferenciadosHistorial(Integer codigoCompania, Set<Long> codigosHistorialPrecio, Set<String> codigosArticulos) throws SICException;
	
}
