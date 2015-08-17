package ec.com.smx.sic.cliente.gestor.bodega.factura.digital.calculo;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;


/**
 * 
 * @author acaiza
 * 
 */
public interface ICalculoTotalesFacturaDigitalGestor {
	
	/**
	 * Calcula los diferentes totales de un factura digital en base al costo neto del articulo o al costo proveedor
	 * 
	 * DynamicProperty's en facturaDigitalEST 
	 * 1. Para el costo neto del articulo y costo proveedor, para los calculos se toma el costo costoProveedor si tiene valor, caso contrario se toma el costo neto del articulo
	 * 2. cantidadIngresada: cantidad de items de un articulo de la factura digital
	 * 3. comparacion: Comparacion de los costos netos de la corporacion vs los costos netos del proveedor de cada uno de los articulos de la factura
	 * 
	 * @param facturaEstadoDTO Un FacturaEstadoDTO
	 * @return Un FacturaEstadoDTO con los totales de la factura digital calculados
	 * 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public FacturaEstadoDTO calcularTotalesFactura(FacturaEstadoDTO facturaEstadoDTO) throws SICException;

}
