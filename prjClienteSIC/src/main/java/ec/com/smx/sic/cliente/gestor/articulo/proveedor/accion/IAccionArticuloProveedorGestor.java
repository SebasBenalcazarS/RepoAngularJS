package ec.com.smx.sic.cliente.gestor.articulo.proveedor.accion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;

public interface IAccionArticuloProveedorGestor {

	/**
	 * Env�a los datos de una colecci�n de articuloProveedor al SIC
	 * @param artProCol
	 */
	public abstract void transferirDatosArticuloProveedorSIC(Collection<ArticuloProveedorDTO> artProCol, Boolean esAsincrono, Object servicioIntegracion) throws SICException;

	/**
	 * Env�a los datos de un art�culoProveedor al SIC
	 * @param ap
	 */
	public abstract void transferirDatosArticuloProveedorSIC(ArticuloProveedorDTO ap, Boolean esAsincrono, Object servicioIntegracion)throws SICException;

	public abstract void construirRelacionesArticuloProveedor(ArticuloProveedorDTO filtro);
}