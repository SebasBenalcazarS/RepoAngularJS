package ec.com.smx.sic.cliente.gestor.articulo.clase;

import java.util.List;
import java.util.Map;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloBitacoraClaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloClaseDTO;

public interface IArticuloClaseGestor {

	void registrarArticuloClase(ArticuloClaseDTO articuloClaseDTO) throws SICException;
	
	/**
	 * Metodo que obtine el articulo clase para la modificacion
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public ArticuloClaseDTO obtenerArticuloClase(Integer codigoCompania, String codigoArticulo) throws SICException;

	/**
	 * Permite obtener el total de registros en Historico de clase para el articulo
	 * @param codigoCompania Codigo de la compania
	 * @param codigoArticulo Codigo del articulo
	 * @return Total de registros encontrados
	 * @throws SICException
	 */
	public Long obtenerTotalHistoricoClase(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	/**
	 * Permite obtener el listado de Historico de Clase
	 * @param firts pagina
	 * @param pageSize Valores por pagina
	 * @param sortField Campo por el que se ordena
	 * @param sortOrder Tipo de orden
	 * @param filters Filtros a usar
	 * @return Lista de valores con historico de clase
	 * @throws SICException
	 */
	public List<ArticuloBitacoraClaseDTO> obtenerHistoricoClase(int firts, int pageSize, String sortField, Map<String, String> filters) throws SICException;
}
