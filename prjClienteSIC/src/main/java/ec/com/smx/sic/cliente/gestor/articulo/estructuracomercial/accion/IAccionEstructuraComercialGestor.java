package ec.com.smx.sic.cliente.gestor.articulo.estructuracomercial.accion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;

public interface IAccionEstructuraComercialGestor {

	/**
	 * Env�a los datos de una colecci�n de art�culos al SIC
	 * @param articulos
	 * @throws SICException
	 */
	public abstract void transferirDatosClasificacionSIC(Collection<ClasificacionDTO> clasificaciones) throws SICException;

	/**
	 * Env�a los datos de un art�culo al SIC
	 * @param articulo
	 * @throws SICException
	 */
	public abstract void transferirDatosClasificacionSIC(ClasificacionDTO clasificacionDTO) throws SICException;

	/**
	 * Env�a los datos de una colecci�n de art�culos al SIC
	 * @param articulos
	 * @throws SICException
	 */
	public abstract void transferirDatosSubClasificacionSIC(Collection<SubClasificacionDTO> clasificaciones) throws SICException;

	/**
	 * Env�a los datos de un art�culo al SIC
	 * @param articulo
	 * @throws SICException
	 */
	public abstract void transferirDatosSubClasificacionSIC(SubClasificacionDTO clasificacionDTO) throws SICException;

}