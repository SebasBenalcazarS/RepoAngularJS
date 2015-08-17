package ec.com.smx.sic.cliente.persistencia.ordenCompra.dao;

import java.util.Collection;

import org.hibernate.criterion.ProjectionList;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminOrdenCompraVO;

public interface IOrdenCompraDetalleEstadoDAO {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraEstado
	 * @param userId
	 * @throws SICException
	 */
	public void inactivarOrdenCompraDetallesEstado(Integer codigoCompania, Long codigoOrdenCompraEstado, String userId) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraEstadoOriginal
	 * @param codigoOrdenCompraEstadoActual
	 * @param userId
	 * @throws SICException
	 */
	public void actualizarCantidadesParcialesOrdenCompraEstadoOriginal(Integer codigoCompania, Long codigoOrdenCompraEstadoOriginal,
			Long codigoOrdenCompraEstadoActual, String userId) throws SICException;
	
	/**
	 * 
	 * @param number
	 * @param userId
	 * @throws SICException
	 */
	public void inactivarDetallesWRT(String number, String userId) throws SICException;
	
	/**
	 * @param articuloUnidadManejoProveedorDTO
	 * @param suprimirRestriccionesOrdenCompra
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoProveedorDTO> obtenerArticulosUnidadManejoProveedor(ArticuloUnidadManejoProveedorDTO 
			  articuloUnidadManejoProveedorDTO, AdminOrdenCompraVO adminOrdenCompraVO, boolean consultarPrecodificados,
			  boolean suprimirRestriccionesOrdenCompra)throws SICException;
	
	/**
	 * @param articuloUnidadManejoProveedorDTO
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<ArticuloUnidadManejoProveedorDTO>  obtenerArticulosUnidadManejoProveedorPaginado(
			ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTO , AdminOrdenCompraVO adminOrdenCompraVO, 
			boolean consultarPrecodificados, boolean suprimirRestriccionesOrdenCompra)throws SICException;
	
	/**
	 * 
	 * @param plantilla
	 * @param projections
	 * @return
	 * @throws SICException
	 */
	public <T extends SearchDTO> Collection<T> obtenerDatosEspecificosRelaciones(T plantilla, ProjectionList projections)throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoOrdenCompraEstado
	 * @param userId
	 * @throws SICException
	 */
	public void actualizarCantidadesEntregadasOrdenCompraRecepcion(Integer codigoCompania, Long codigoOrdenCompraEstado, String userId) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoAreaTrabajoCD
	 * @param codigoAreaSubLugarTrabajoSubbodega
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerCodigoBodegaAreaSubLugarTrabajo(Integer codigoCompania, Integer codigoAreaTrabajoCD, Integer codigoAreaSubLugarTrabajoSubbodega) throws SICException;
	
	
	/**
	 * Metodo que consulta datos especificos en base a una coleccion que contiene codigos orden compra estado para validar las entregas en factura Digital.
	 * @param Collection<Long> codigoOrdenCompraEstadoCol
	 * @return
	 * @throws SICException
	 * */
	public Collection<Object[]> consultarOrdenCompraEstado(Collection<Long> codigoOrdenCompraDetalleEstadoCol)throws SICException;
	
		
	/**
	 * Metodo que busca descuentos
	 * @param ordenCompraDetalleEstadoDescuentoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<OrdenCompraDetalleEstadoDescuentoDTO> buscarOrdenCompraDetalleEstadoDescuento(OrdenCompraDetalleEstadoDescuentoDTO ordenCompraDetalleEstadoDescuentoDTO)throws SICException;

	/**
	 * Busca los detalle estado del estado que se pase. Filtrando por unidad de manejo y proveedor. Los detalles que se retorna son los enviados.
	 * 
	 * @param codigosUnidadManejo
	 * @param codigosProveedor
	 * @param codigoOrdenCompraEstado
	 * @param codigoCompania
	 * @return Lista de detalles.
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> consultarDetalleEstadoOriginal(Collection<Long> codigosUnidadManejo, Collection<String> codigosProveedor, Long codigoOrdenCompraEstado, Integer codigoCompania);
	
	/**
	 * Busca un articulo repetido en base a
	 * <p>1: codigo referencia, con replace de caracteres especiales</p>
	 * <p>1: codigo de proveedor</p>
	 *	 
	 * @param codigoCompania
	 * @param codigoReferenciaProveedor
	 * @param codigoProveedor
	 * @param restriccionReplace: Contiene la sentencia con el replace de caracteres especiales
	 * @return
	 * @throws SICException
	 */
	public ArticuloProveedorDTO buscarArticuloRepetido(Integer codigoCompania, String codigoReferenciaProveedor, String codigoProveedor, String restriccionReplace) throws SICException;

}