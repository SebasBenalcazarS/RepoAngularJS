package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.accion;

public interface IAccionIntegracionCambioPreciosGestor {

	/**
	 * Integrar los cambios de precios de los articulos de proveedor con el SIC
	 * 
	 * @param codigoCompania
	 * @throws Exception
	 */
	void integrarArticuloProveedorCambioPreciosSIC(Integer codigoCompania) throws Exception;
}
