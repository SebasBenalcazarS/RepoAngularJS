package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.math.BigDecimal;
import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;

public interface IFacturaProveedorDAO {

	/**
	 * @param hibernateH the hibernateH to set
	 */
	public abstract void setHibernateH(IHibernateH<SearchDTO> hibernateH);

	/**
	 * @param facturaDTO
	 * @return total de las facturas proveedor
	 * asociadas a la entrega
	 */
	public abstract BigDecimal obtenerTotalFacturasProveedorEntrega(FacturaEstadoDTO facturaDTO) throws SICException;
	
	/**
	 * Elimina una factura cambiando el estado a inactivo
	 * @param codigoFactura Codigo factura
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public void eliminarFactura(Long codigoFactura) throws SICException;
	
	/**
	 * Obtiene los tipos de pedido a partir de los detalles orden compra estado
	 * @param codigosOrdenCompraDetalleEstado Codigos de los detalles orden compra estado
	 * @return Un Collection de CatalogoValorDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<CatalogoValorDTO> obtenerTiposPedidoPorOrdenCompraDetalleEstado(Collection<Long> codigosOrdenCompraDetalleEstado) throws SICException;
	
	/**
	 * Sumariza la cantidad total que se encuentra facturada de un articulo de un entrega a traves de los codigos codigosOrdenCompraDetalleEstado de la entrega
	 * 
	 * @param codigosOrdenCompraDetalleEstado Codigos de OrdenCompraDetalleEstado
	 * @return Un Object[] con: codigoOrdenCompraDetalleEstado y Sumatoria de la cantidad total facturada de ese articulo 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<Object[]> obtenerOrdenCompraDetalleEstadoFacturado(Collection<Long> codigosOrdenCompraDetalleEstado) throws SICException;
	
	/**
	 * Cambia el estado de las condiciones comerciales de los articulos OrdenCompraDetalleEstadoDTO de la entrega.
	 * Valores posibles: [ACE:ACEPTADO, REC:RECHAZADO]
	 * CatalogoTipo: 250
	 * Campos del CV: [CODIGOESTADOARTICULOCATTIP CODIGOESTADOARTICULOCATVAL]
	 * 
	 * 
	 * @param ordenCompraDetalleEstadoDTOs Una coleccion de OrdenCompraDetalleEstadoDTO
	 * @param estadoArticulo Un CatalogoValorDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public void cambiarEstadoArticuloOrdenCompraDetalleEstadoDTO(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs, CatalogoValorDTO estadoArticulo) throws SICException;

	public Collection<FacturaDTO> obtenerFacturas(Long codigoOrdenCompra, Integer codigoCompania, String valorTipoOrdenCompra);
	
	/**
	 * Modificar factura estado
	 * @param facturaEstadoDTO
	 * @return
	 * @throws SICException
	 */
	public FacturaEstadoDTO modificarFacturaEstado(FacturaEstadoDTO facturaEstadoDTO) throws SICException;
	
	/**
	 * Modificar facturaDTO
	 * @param facturaEstadoDTO
	 * @return
	 * @throws SICException
	 */
	public FacturaDTO modificarFacturaDTO(FacturaEstadoDTO facturaEstadoDTO) throws SICException;
}