package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.Criterion;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorEquivalenciaDTO;

public interface IArticuloUnidadManejoDAO {

	/**
	 * 
	 * @return
	 */
	public abstract Collection<ArticuloUnidadManejoDTO> obtenerUnidadesManejoActivasPorArticulo(String codigoArticulo);

	public abstract Collection<ArticuloUnidadManejoDTO> obtenerUnidadesManejoEnOtrosArticulosPorEAN(ArticuloDTO articulo, Collection<ArticuloUnidadManejoDTO> unidadesManejo) throws SICException;

	public void eliminarEANs(Collection<ArticuloUnidadManejoDTO> unidadesManejo, String userID, Integer codigoCompania)throws SICException;
	
	public void cambiarEstadoUso(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, String uso, String estado)throws SICException;
	
	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @return
	 * @throws SICException
	 */
	public Boolean tieneAsignadoProveedores(ArticuloUnidadManejoDTO articuloUnidadManejoDTO)throws SICException;

	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @throws SICException
	 */
	public void actualizarUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;
	
	/**
	 * <b> Busca una unidad o unidades de manejo en funcion de un codigo EAN. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 20/10/2014]
	 * </p>
	 * 
	 * @param codigoEAN
	 *            codigo EAN por el cual se filtrara la consulta
	 * @param codigoCompania
	 *            es el codigo de la compania
	 * @param estado
	 *            representa el estado de la unidad de manejo (activo/inactivo)
	 * @return
	 */
	List<ArticuloUnidadManejoDTO> obtenerUMporCodigoEAN(String codigoEAN, Integer codigoCompania, String estado);
	
	/**
	 * Metodo para añadir la restriccion de funcionario a la clasificacion
	 * @param codigoFuncionario
	 * @param propertyIn
	 * @return
	 * @throws Exception
	 */
	public Criterion addRestriccionClasificacionFuncionarioLineaComercial(String codigoFuncionario,String propertyIn)throws SICException;
	
	/**
	 * Permite buscar los articulos para relacionar con una ubicacion 
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoDTO> buscarArticuloUnidadManejo(String codigoBarras,Integer codigoAreaTrabajo,String codigoFuncionario)throws SICException;
	
	/**
	 * devuelve una unidad de manejo en base a un articulo
	 * @param articuloDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoDTO> buscarUnidadesManejo(ArticuloDTO articuloDTO)throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoDTO> obtenerArticuloUnidadManejoCodigoBarrasArticulo(Integer codigoCompania, String codigoBarras) throws SICException;
	
	/**
	 * Metodo para obtener un numero definido de unidades de manejo
	 * @param articuloDTO
	 * @param maxResult
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoDTO> obtenerUnidadManejoPorArticulo(ArticuloDTO articuloDTO, Integer maxResult)throws SICException;
	
	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @param codigoBarras
	 * @throws SICException
	 */
	public void actualizarCodigoBarrasArticuloUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, String codigoBarrasUnidadManejo) throws SICException;
	
	/**
	 * Metodo para actualizar la equivalencia de la unidad de manejo proveedor
	 * @param articuloEquivalencia
	 * @throws SICException
	 */
	void actualizarArticuloUnidadManejoProveedorEquivalecia(ArticuloUnidadManejoProveedorEquivalenciaDTO articuloEquivalencia) throws SICException;
	
	/**
	 * Metodo para buscar la equivalencia del articulo unidad manejo proveedor
	 * @param articuloEquivalencia
	 * @return
	 * @throws SICException
	 */
	ArticuloUnidadManejoProveedorEquivalenciaDTO buscarArticuloUnidadManejoProveedorEquivalecia(ArticuloUnidadManejoProveedorEquivalenciaDTO articuloEquivalencia) throws SICException;

	void removerUnidadManejoProveedorEquivalecia(ArticuloUnidadManejoProveedorEquivalenciaDTO articuloEquivalencia) throws SICException;
	
	public void crearUnidadManejoProveedor(ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTO) throws SICException;

	/**
	 * Retorna una unidad de manejo hija relacionada con una unidad manejo padre
	 * @param codigoCompania
	 * @param codigoUnidadManejoPadre
	 * @param valorTipoUnidadEmpaque
	 * @return
	 * @throws SICException
	 */
	ArticuloUnidadManejoDTO obtenerUnidadManejoHija(Integer codigoCompania, Long codigoUnidadManejoPadre, String valorTipoUnidadEmpaque) throws SICException;
	
	public void aumentarPrioridadUnidadManejo(Integer prioridad , Integer codigoCompania , String codigoArticulo) throws SICException;
	
	/**
	 * Metodo para obtener una unidad de manejo segun su id
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoUniMan
	 * @return
	 * @throws SICException
	 */
	public ArticuloUnidadManejoDTO buscarUnidadManejo(Integer codigoCompania, String codigoArticulo, Long codigoUniMan )throws SICException;
	
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
	 * Metodo para obtener las prioridades de las unidades de manejo de compra de un articulo
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<Integer> obtenerPrioridadesUnidadManejo(Integer codigoCompania, String codigoArticulo) throws SICException;
}