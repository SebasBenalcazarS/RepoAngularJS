package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.almacenamiento;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosOrdenCompra;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoGestionPrecio;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoConflictoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;

/**
 * @author Luis Yacchirema
 *
 */
public interface IAlmacenamientoDatosCambioPreciosGestor extends Serializable {


	/**
	 * @param gestionPrecioRegistro
	 * @param ordenesAGestionar
	 * @throws SICException
	 */
	void registrarDatosGestionCambioPrecio(GestionPrecioDTO gestionPrecioRegistro, Collection<DatosOrdenCompra> ordenesAGestionar) throws SICException;
	
	/**
	 * 
	 * @param ordenesAGestionar
	 * @param codigoCompania
	 * @param userId
	 * @throws SICException
	 */
	void registrarDatosOrdenCompraGestion(Collection<DatosOrdenCompra> ordenesAGestionar , Integer codigoCompania , String userId) throws SICException;


	/**
	 * @param articulosGestionPrecioActuales
	 * @param estadoCambioPrecioNuevo
	 * @param userId
	 * @param fechaVigenciaCosto
	 * @param fechaRetornoCosto
	 * @param fechaVigenciaVenta
	 * @param fechaRetornoVenta
	 * @param codigoCompania
	 * @param ordenesAGestionar
	 * @throws SICException
	 */
	void actualizarArticulosCambioPrecios(Collection<ArticuloGestionPrecioDTO> articulosGestionPrecioActuales,
			EstadoGestionPrecio estadoCambioPrecioNuevo, String userId,
			Date fechaVigenciaCosto, Date fechaRetornoCosto, Date fechaVigenciaVenta, Date fechaRetornoVenta,
			Integer codigoCompania, Collection<DatosOrdenCompra> ordenesAGestionar) throws SICException;


	/**
	 * @param articuloGestionPrecio
	 * @throws SICException
	 */
	public void sincronizarPreciosDiferenciados(ArticuloGestionPrecioDTO articuloGestionPrecio) throws SICException;
	
	/**
	 * @param ordenesAGestionar
	 * @param userId
	 * @param codigoCompania
	 * @param tipoConflicto
	 */
	public void registrarOrdenesCompraGestion(Collection<DatosOrdenCompra> ordenesAGestionar, String userId, Integer codigoCompania,TipoConflictoArticulo tipoConflicto) throws SICException;
}
