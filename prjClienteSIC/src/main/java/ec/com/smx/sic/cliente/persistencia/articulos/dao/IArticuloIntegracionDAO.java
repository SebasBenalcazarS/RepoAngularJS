package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPendienteIntegracionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.integracion.dto.articulo.validar.ValidarArticuloIDTO;

public interface IArticuloIntegracionDAO {

	public abstract void eliminarArticulosIntegrados(Integer codigoCompania, Long secuencial)throws SICException;

	public abstract void actualizarArticuloIntegracion(Integer codigoCompania, Long secuencial, String observacion)throws SICException;
	
	public abstract Boolean consultarExistenciaArticulosIntegrados(Integer codigoCompania, String[] codigoArticulo)throws SICException;

	public void eliminarArticulosIntegrados(Integer codigoCompania, String codigoArticulo, String valorTipoProceso, Date fechaFinal) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param valorTipoProceso
	 * @throws SICException
	 */
	public Collection<ArticuloPendienteIntegracionDTO> obtenerArticulosPendientesIntegracionPorProceso(Integer codigoCompania,  String valorTipoProceso) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @throws SICException
	 */
	public Collection<ArticuloPendienteIntegracionDTO> obtenerArticulosErrorIntegracionSic(Integer codigoCompania) throws SICException;
	
	public ArticuloDTO obtenerArticuloResultadoIntegracionCondicionesComerciales(ArticuloDTO articuloDTO) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigosArticulos
	 * @param codigosProveedores
	 * @throws SICException
	 */
	public Collection<ArticuloProveedorDTO> obtenerArticulosProveedor(Integer codigoCompania, Set<String> codigosArticulos, Set<String> codigosProveedores) throws SICException;

	void registrarArticuloPendienteIntegracion(Integer codigoCompania, String codigoArticulo, String valorTipoProceso, String userId) throws SICException;

	/**
	 * Metodo que permite obtener los datos de los art\u00EDculos a validar
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigosArticulo 
	 * @return
	 * @throws SICException
	 */
	Collection<ValidarArticuloIDTO> obtenerDatosArticulosPorValidar(Integer codigoCompania, List<String> codigosArticulo) throws SICException;

	/**
	 * Metodo que permite consultar los art\u00EDculos a validar
	 * @author jgranda
	 * @param codigoCompania
	 * @param maxPageSize cantidad de paginacion de los articulos a obtener
	 * @return
	 * @throws SICException
	 */
	List<String> obtenerArticulosPorValidar(Integer codigoCompania, Integer maxPageSize) throws SICException;

}