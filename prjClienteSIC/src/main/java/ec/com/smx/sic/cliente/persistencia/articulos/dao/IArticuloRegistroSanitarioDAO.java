package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;

public interface IArticuloRegistroSanitarioDAO {

	/**
	 * Desactiva los archivos relacionados a un registro sanitario
	 * @throws SICException
	 */
	public abstract void desactivarArchivosRegistroSanitario(RelacionArticuloRegistroSanitarioDTO ars, String usuarioModificacion) throws SICException;

	/**
	 * Desactiva los registros sanitarios de un ar\u00EDtculo 
	 * @throws SICException
	 */
	public abstract void desactivarRegistroSanitarioArticulo(RelacionArticuloRegistroSanitarioDTO ars) throws SICException;
	
	
	/**
	 * Desactiva las etiquetas registro sanitario de un art\u00EDculo 
	 * @param ars
	 * @throws SICException
	 */
	void desactivarEtiquetasRegistroSanitario(ArticuloDTO articuloDTO) throws SICException;

	/**
	 * Actualiza los datos de auditor\u00EDa
	 * @throws SICException
	 */
	public abstract void actualizarDatosAuditoria(RelacionArticuloRegistroSanitarioDTO ars) throws SICException;
	
	/**
	 * 
	 * @param articuloRegistroSanitarioDTO
	 * @return
	 * @throws SICException
	 */
	SearchResultDTO<ArticuloRegistroSanitarioDTO> obtenerArticulosRegistroSanitarioPaginados(ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO) throws SICException;
	
	/**
	 * 
	 * @param articuloRegistroSanitarioDTO
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloRegistroSanitarioDTO> obtenerArticulosRegistroSanitario(ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO) throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloRegistroSanitarioDTO> buscarRegistrosSanitariosActivos(ArticuloDTO articuloDTO) throws SICException;
	
	
	/**
	 * METODO QUE PERMITE AGREGA EL VALOR DE TRUE EN EL CAMPO CONFIRMAREGISTROSANITARIO EN LA TABLA {@link ArticuloProveedorDTO}
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param idUsuarioModificacion
	 * @throws SICException
	 * @author eharo
	 */
	public void asignarConfirmaRegistroSanitarioArticuloProveedor(Integer codigoCompania, String codigoArticulo, String idUsuarioModificacion) throws SICException;
}