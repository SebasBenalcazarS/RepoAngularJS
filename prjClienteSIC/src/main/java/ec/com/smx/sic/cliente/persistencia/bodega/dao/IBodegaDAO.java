package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.map.MultiKeyMap;

import ec.com.kruger.utilitario.dao.commons.dao.BaseDAO;
import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DiferenciaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaBodegaCDAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.vo.BodegaVO;
import ec.com.smx.sic.cliente.mdl.vo.EntregaVO;

public interface IBodegaDAO {

	/**
	 * Metodo que retorna la lista de bodegas raices unicas
	 * @param lstBodegasDtos
	 * 			Lista de bodegas raices que pueden ser repetibles
	 * @return Collection<BodegaDTO>
	 * 			Lista de bodegas raices 
	 */
	public abstract Collection<BodegaDTO> obtenerRaices(Collection<BodegaDTO> lstBodegasDtos);

	/**
	 * Permite crear la Jerarquia de bodegas
	 * @param lstBodegasDtos
	 * 			lista de bodegas consultadas
	 * @return Collection<BodegaDTO>
	 * 			lista de bodegas raiz
	 */
	public abstract Collection<BodegaDTO> crearJerarquiaBodega(Collection<BodegaDTO> lstBodegasDtos);

	/**
	 * Permite la busqueda de bodegas
	 * @param bodegaDTO
	 * 			Plantilla para la busqueda de bodegas
	 */
	public abstract Collection<BodegaDTO> obtenerBodegas(BodegaVO bodegaVO);

	/**
	 * @return the baseDAO
	 */
	public abstract BaseDAO getBaseDAO();

	/**
	 * @param baseDAO the baseDAO to set
	 */
	public abstract void setBaseDAO(BaseDAO baseDAO);

	/**
	 * @return the hibernateHBodega
	 */
	public abstract IHibernateH<BodegaDTO> getHibernateHBodega();

	/**
	 * @param hibernateHBodega the hibernateHBodega to set
	 */
	public abstract void setHibernateHBodega(IHibernateH<BodegaDTO> hibernateHBodega);

	/**
	 * Obtiene la bodega padre en base al id de una bodega
	 * @param codigosBodega
	 * @return
	 * @throws SICException
	 */
	public abstract BodegaDTO obtenerBodegaPadre(String codigoBodega) throws SICException;
	
	/**
	 * Obtiene las subbodegas a partir de un area de trabajo de una bodega padre
	 */
	public abstract Collection<BodegaDTO> obtenerSubBodegas(Collection<Integer> codigoBodegaAT) throws SICException;
	
	/**
	 * Obtiene el area de trabajo padre, de una bodega
	 * 
	 * @param codigoBodega Codigo bodega
	 * @return Un AreaTrabajoDTO  
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public abstract VistaBodegaCDAreaTrabajoDTO obtenerAreaTrabajoPadreBodega(String codigoBodega) throws SICException;
	
	/**
	 * Este metodo devuelve las bodegas dada el area de trabajo.
	 * @param codigoAreaTrabajo
	 * @return
	 */
	public abstract Collection<AreaTrabajoDTO> obtenerBodegasPorCD(Integer codigoAreaTrabajo, CatalogoValorDTO caracteristica) throws SICException;
	
	/**
	 * 
	 * @param codigoATCD
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<BodegaDTO> obtenerBodegasCD(Integer codigoATCD) throws SICException;
	
	/**
	 * Metodo para consultar una lista de proveedores de acuerdo a las entregas
	 * @param entregaVO 		plantilla con los filtros para la busqueda
	 * @return	Collection<EntregaVO>
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<EntregaVO> obtenerProveedoresPorEntrega(EntregaVO entregaVO)  throws SICException;
	
	/**
	 * Metodo para consultar articulos agrupados por orden compra y factura
	 * @param numeroFacturaList 		array de los numeros de factura obtenidos de la integracion con el sic
	 * @param numeroOrdenCompraList 	array de numerosOrdenCompra tomados de la integracion con el sic
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<OrdenCompraDetalleEstadoDTO> obtenerArticulosPorOrdenCompraFactura(List<String> numeroFacturaList, List<String> numeroOrdenCompraList) throws SICException;
	
	/**
	 * Obtener articulos por entrega
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<OrdenCompraDetalleEstadoDTO> obtenerArticulosPorEntrega(EntregaVO entregaVO) throws SICException;
	
	/**
	 * Consultar nombre articulos
	 * @param colIdArticulos
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	List<ArticuloDTO> consultarNombreArticulos(Collection<String> colIdArticulos) throws SICException;
	
	/**
	 * Consultar facturas por numero de factura
	 * @param numeroFacturas			collection de lista de facturas
	 * @return	collection<FacturaEstadoDTO>
	 * @throws SICException
	 * @author osaransig
	 */
	List<FacturaEstadoDTO> consultarFacturas(Collection<String> numeroFacturas) throws SICException;
	
	/**
	 * Consultar facturas por entrega
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	List<FacturaEstadoDTO> consultarFacturasPorEntrega(EntregaVO entregaVO) throws SICException;
	
	/**
	 * Consultar ordenes compra estado por codigo orden de compra y entrega 
	 * @param multiKeyMapOrdenEntrega		multiKeyMap, primera clave codigoOrdenCompra, segunda clave codigoEntrega 
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	List<OrdenCompraEstadoDTO> consultarOrdenCompraEstadoPorCodOrdComCodEnt(MultiKeyMap multiKeyMapOrdenEntrega) throws SICException;
	
	/**
	 * Consultar agrupamiento de articulos por orden de compra estado para validacion
	 * @param multiKeyMapOrdenEntrega		multiKeyMap, primera clave codigoOrdenCompra, segunda clave codigoEntrega
	 * @param codigoEstadoCatVal			codigo estado catalogo valor
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	List<OrdenCompraDetalleEstadoDTO> consultarTotalArticulosPorOrdenCompraEstado(MultiKeyMap multiKeyMapOrdenEntrega, 
			String codigoEstadoCatVal) throws SICException;
	
	/**
	 * Consultar total de articulos facturados por entrega
	 * @param detalleFacturaEstadoDTO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	Collection<DetalleFacturaEstadoDTO> consultarTotalArticulosPorEntregas(DetalleFacturaEstadoDTO detalleFacturaEstadoDTO) throws SICException;
	
	/**
	 * Consultar ordenes de compra por numero orden compra y codigo de entrega
	 * @param ordenCompraEstadoDTO				plantilla de busqueda
	 * @param multiKeyMapOrdenEntrega			multiKeyMap, primera clave codigoOrdenCompra, segunda clave codigoEntrega
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	List<OrdenCompraEstadoDTO> consultarOrdenCompraEstadoPorCodOrdComCodEnt(OrdenCompraEstadoDTO ordenCompraEstadoDTO, MultiKeyMap multiKeyMapOrdenEntrega) throws SICException;
	
	/**
	 * Actualizar numero de factura recepcion
	 * @param numeroFactura
	 * @param numeroFacturaRecepcion
	 * @throws SICException
	 * @author osaransig
	 */
	void actualizarNumeroFacturaRecepcion(String numeroFactura, String numeroFacturaRecepcion) throws SICException;
	
	
	/**
	 * Consultar detalle factura estado
	 * @param colCodEnt
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	public List<Object[]> consultarDetalleFacturaEstado(Collection<Long> colCodEnt, Collection<String> facturas) throws SICException;
	
	/**
	 * Consultar orden de compra detalle estado
	 * @param numOrdenCompraCol
	 * @param codigoEstadoCatVal
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	public List<OrdenCompraDetalleEstadoDTO> consultarOrdenCompraDetalleEstado(Collection<String> numOrdenCompraCol, String codigoEstadoCatVal) throws SICException;
	
	/**
	 * Obtener proveedores por detalle factura estado de la tabla de justificaciones
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	public Collection<EntregaVO> obtenerProveedoresPorDetalleFacturaEstado(EntregaVO entregaVO) throws SICException;
	
	/**
	 * Obtener proveedores por orden de compra detalle estado de la tabla de justificaciones
	 * @param entregaVO
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	public Collection<EntregaVO> obtenerProveedoresPorOrdenCompraDetalleEstado(EntregaVO entregaVO) throws SICException;
	
	
	/**
	 * Actualizar diferencias proceso logistico
	 * @param colDiferenciaProcesoLogistico
	 * @throws SICException
	 * @author osaransig
	 */
	public void actualizarJustificacion(Collection<DiferenciaProcesoLogisticoDTO> colDiferenciaProcesoLogistico) throws SICException;

	
	/**
	 * Consultar total articulos por orden compra estado
	 * @param multiKeyMapOrdenEntrega
	 * @param codigoEstadoCatVal
	 * @param codFacturas
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	List<OrdenCompraDetalleEstadoDTO> consultarTotalArticulosPorOrdenCompraEstado(MultiKeyMap multiKeyMapOrdenEntrega, String codigoEstadoCatVal,
			Collection<String> codFacturas) throws SICException;
	
	/**
	 * @param codFacturas
	 * @return
	 * @throws SICException
	 * @author osaransig
	 */
	public List<OrdenCompraDetalleEstadoDTO> obtenerArticulosFacturados(
			Collection<String> codFacturas) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigosAreaTrabajo
	 * @param areaTrabajoValor
	 * @return
	 * @throws SICException
	 */
	public Collection<BodegaDTO> obtenerBodegaSubbodegaPorAreaTrabajo(Integer codigoCompania, Collection<Integer> codigosAreaTrabajo, CatalogoValorDTO areaTrabajoValor) throws SICException;
	
	
	/**
	 * Metodo que obtiene el codigo del 
	 * area de trabajo del cd asciado a
	 * la bodega referencial
	 * 
	 * @param codigoAreaTrabajoBodega
	 * @return
	 */
	public Integer obtenerCdRelacionadoBodegaReferencial (Integer codigoCompania, Integer codigoAreaTrabajoBodega);
	
	/**
	 * Metodo que obtiene la bodega
	 * asociada a una subbodega en un
	 * CD relacionado 
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoSubbodega
	 * @param codigoAreaTrabajoCdRelacionado
	 * @return
	 */
	public BodegaDTO obtenerBodegaPorSubbodegaYCdRelacionado(Integer codigoCompania, Integer codigoAreaTrabajoSubbodega, Integer codigoAreaTrabajoCdRelacionado);
	
	/**
	 * Metodo que obtiene codigo de transaccion
	 * en MAX en base a codigo de transaccion del
	 * SIC, en tabla TRANSACCION del Corporativo 
	 * 
	 * @param codigoCompania
	 * @param codigoTipoTransaccionSIC
	 * @return
	 */
	public Integer obtenerCodigoTipoTransaccion(Integer codigoCompania, Integer codigoTipoTransaccionSIC);
	
	/**
	 * Metodo que obtiene el valor del tipo 
	 * factura en sitio de una factura del proveedor
	 * asociado a una entrega
	 * 
	 * @param codigoCompania
	 * @param codigoEntrega : codigo de entrega creada en B2B
	 * @param numeroFacturaProveedor : numero de la factura del proveedor asociada al codigo de entrega
	 * @return
	 */
	public String obtenerValorTipoFacturaEnSitioEntrega(Integer codigoCompania, Long codigoEntrega, String numeroFacturaProveedor);
	
	/** Metodo obtenerSubbodegasPorProveedor, utilizado para
	 * @author srodriguez
	 * 6/3/2015
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @return Collection<BodegaDTO>
	 */
	Collection<BodegaDTO> obtenerSubbodegasPorProveedor(Integer codigoCompania, String codigoProveedor);
	
	
	/** Metodo obtenerSubbodegaPorBodegaProveedor, utilizado para obtener la bodega de un proveedor aplicando un codigo 
	 * @author srodriguez
	 * 10/3/2015
	 * @param codigoCompania
	 * @param codigoBodega
	 * @param codigoProveedor
	 * @return
	 * @return BodegaDTO
	 */
	BodegaDTO obtenerSubbodegaPorBodegaProveedor(Integer codigoCompania, String codigoBodega,String codigoProveedor);
}