package ec.com.smx.sic.cliente.persistencia.articulos.dao.clase;

import java.util.List;
import java.util.Map;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloBitacoraClaseDTO;

public interface IArticuloBitacoraClaseDAO {

	void crearArticuloBitacoraClase(ArticuloBitacoraClaseDTO articuloBitacoraClaseDTO) throws SICException;
	
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
