package ec.com.smx.sic.cliente.persistencia.ordenCompra.dao;

import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloImportadoVO;

/**
 * 
 * @author amunoz
 *
 */
public interface IArticuloNuevoImportadoDAO {
	
	/**
	 * 
	 * @param codigoProveedor
	 * @param codigosLineaComercialClienteImportacion
	 * @return
	 */
	boolean esClasificacionValida(ArticuloImportadoVO articuloImportadoVO);

	ClasificacionDTO obtenerClasificacionPorCliente(Integer codigoCompania, Long codigoClienteImportacion);
	
	
	
}
