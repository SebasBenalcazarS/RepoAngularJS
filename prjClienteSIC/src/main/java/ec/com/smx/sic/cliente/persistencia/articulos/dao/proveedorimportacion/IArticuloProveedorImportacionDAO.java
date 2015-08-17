package ec.com.smx.sic.cliente.persistencia.articulos.dao.proveedorimportacion;

import java.math.BigDecimal;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * Interfaz que define el comportamiento de registro y obtencion de informacion de importacion de un articulo por proveedor
 * @author mgranda
 *
 */
public interface IArticuloProveedorImportacionDAO {

	/**
	 * Metodo que permite actualizar la informacion (costoMonedaOrigen, PorcentajeComision) de Importacion de un articulo
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoProveedor
	 * @param costoMonedaOrigen
	 * @param porcentajeComision
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	Integer actualizarArticuloImportacion(Integer codigoCompania, String codigoArticulo, String codigoProveedor, BigDecimal costoMonedaOrigen, Double porcentajeComision, String userId) throws SICException;

	/**
	 * Metodo que obtiene el numero de registros ArticuloImportado
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Long contarArticuloImportado(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException;

}
