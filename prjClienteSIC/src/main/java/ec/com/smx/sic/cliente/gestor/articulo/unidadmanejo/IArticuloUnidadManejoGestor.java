package ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface IArticuloUnidadManejoGestor {

	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @throws SICRuleException
	 */
	ArticuloUnidadManejoDTO registrarArticuloUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloUnidadManejoDTO> obtenerUnidadesManejoActivasPorArticulo(ArticuloDTO articuloDTO) throws SICException;

	/**
	 * 
	 * @param articuloDTO
	 * @return
	 * @throws SICException
	 */
	Integer obtenerNumeroUnidadesManejoActivasPorArticulo(ArticuloDTO articuloDTO) throws SICException;

	/**
	 * 
	 * SubProcesoGuardadoArticulo.ARTICULOUNIDADMANEJO
	 * @param articuloVO
	 * @param esCreacion
	 * @param campoCodigoArticulo
	 */
	void registrarArticuloUnidadManejo(ArticuloVO articuloVO) throws SICException;

	/**
	 *
	 * @param articuloUnidadManejoDTO
	 * @throws SICException
	 */
	public void actualizarUnidadManejoRecepcion(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;

	/**
	 *
	 * @param articuloUnidadManejoDTO
	 * @param tipoEmpaque
	 * @param valorUnidadManejo
	 * @throws SICException
	 */
	public ArticuloUnidadManejoDTO actualizarCantidadMaximaUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, CatalogoValorDTO tipoEmpaque, Integer valorUnidadManejo) throws SICException;
	
	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @param codigoBarras
	 * @throws SICException
	 */
	public void actualizarCodigoBarrasArticuloUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, String codigoBarrasUnidadManejo) throws SICException;
	
	public void aumentarPrioridadUnidadManejo(Integer prioridad , Integer codigoCompania , String codigoArticulo) throws SICException;

	/**
	 * Metodo que inactiva las unidades de manejo por una prioridad especifica y puede omitir una unidad de manejo especifica.
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param prioridad
	 * @param codigoUnidadManejo codigo de unidad de manejo que se omite puede anularse este parametro
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	Integer inactivarUnidadManejoPorPrioridad(Integer codigoCompania, String codigoArticulo, Integer prioridad, String userId, Long... codigoUnidadManejo) throws SICException;

	/**
	 * Metodo que permite asignar la máxima prioridad al codigo de unidad de manejo de prioridad 1000
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param userId
	 * @param codigoUnidadManejo
	 * @return
	 * @throws SICException
	 */
	Integer asignarMaximaPrioridadUnidadManejo(Integer codigoCompania, String codigoArticulo, String userId, Long codigoUnidadManejo) throws SICException;

	/**
	 * Metodo para obtener la prioridad disponible de las unidades de manejo de compra de un articulo
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Integer obtenerPrioridadDisponible(Integer codigoCompania, String codigoArticulo) throws SICException;

	
}