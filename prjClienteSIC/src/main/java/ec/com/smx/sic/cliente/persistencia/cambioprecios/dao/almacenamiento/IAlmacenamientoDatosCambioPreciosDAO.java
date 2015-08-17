package ec.com.smx.sic.cliente.persistencia.cambioprecios.dao.almacenamiento;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosArticuloOrdenCompra;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosOrdenCompra;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PrecioDiferenciadoArticuloGestionDTO;

public interface IAlmacenamientoDatosCambioPreciosDAO extends Serializable {


	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoGestionPrecio
	 * @return
	 * @throws SICException
	 */
	void eliminarArticulosPlantilla(Integer codigoCompania, String codigoArticulo, Long codigoGestionPrecio) throws SICException;


	/**
	 * actualiza la fecha de vigencia de un cambio de precios
	 */
	void actualizarFechaVigenciaCambioDePrecios(String userId,Date fechaInicio,Set<String> codigosClasificaciones,Integer codigoCompania,String valorTipoEstadoActual,String codigoProveedor,String codigoFuncionario,String codigoBodega)throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigoGestionPrecio
	 * @throws SICException
	 */
	void anularGestionPrecio(Integer codigoCompania, Long codigoGestionPrecio) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoGestionPrecio
	 * @param usuarioModificacion
	 * @throws SICException
	 */
	void anularArticuloCambioPrecio(Integer codigoCompania, String codigoArticulo, Long codigoGestionPrecio, String usuarioModificacion) throws SICException;


	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoGestionPrecio
	 * @param usuarioModificacion
	 * @param codigoArticuloPrecioDiferenciado
	 * @throws SICException
	 */
	void anularPreciosDiferenciadosArticuloCambioPrecio(Integer codigoCompania, String codigoArticulo, Long codigoGestionPrecio, String usuarioModificacion, Long codigoArticuloPrecioDiferenciado) throws SICException;


	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoGestionPrecio
	 * @param usuarioModificacion
	 * @param codigosValorCostoGestion
	 * @param codigosProveedores
	 * @throws SICException
	 */
	void anularProveedoresConValorCostoPorArticuloGestionPrecio(Integer codigoCompania, String codigoArticulo, Long codigoGestionPrecio, String usuarioModificacion, Set<Long> codigosValorCostoGestion, Set<String> codigosProveedores) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	void anularCambioPrecioValidandoArticulos(Integer codigoCompania) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoGestionPrecio
	 * @throws SICException
	 */
	void anularBitacoraArticuloGestionPrecio(Integer codigoCompania, Long codigoGestionPrecio, String codigoArticulo) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoValorCostoGestion
	 * @throws SICException
	 */
	void anularBitacoraValorCosto(Integer codigoCompania, Long codigoValorCostoGestion) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<DatosOrdenCompra> obtenerDatosOrdenesCompraGestion(Integer codigoCompania) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoOrdenCompra
	 * @param valorEstadoOrdenCompra
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	void actualizarOrdenCompraGestion(Integer codigoCompania, Long codigoOrdenCompra, String valorEstadoOrdenCompra, String userId) throws SICException;
	
	 /**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoGestionPrecio
	 * @param codigosArticuloPrecioDiferenciado
	 * @throws SICException
	 */
	void eliminarPreciosDiferenciadosEnCambioPrecio(Integer codigoCompania, String codigoArticulo, Long codigoGestionPrecio,Collection<Long> codigosArticuloPrecioDiferenciado) throws SICException;
	
	/**
	  * @param codigoCompania
	  * @param codigoOrdenCompra
	  * @return
	  * @throws SICException
	  */
	 void eliminarArticulosEnOrdenCompraGestion(Integer codigoCompania, Long codigoOrdenCompra) throws SICException;
	 
	/**
	 * @param precioDiferenciado
	 * @throws SICException
	 */
	void actualizarPrecioYPorcentajeAnterioresPrecioDiferenciado(PrecioDiferenciadoArticuloGestionDTO precioDiferenciado) throws SICException;
	
	/**
	 * @param userId
	 * @param codigoCompania
	 * @param codigoOrdenCompraGestion
	 * @param datosArticulo
	 * @throws SICException
	 */
	void registrarDescuentosArticuloOrdenCompra(String userId, Integer codigoCompania, Long codigoOrdenCompraGestion, DatosArticuloOrdenCompra datosArticulo) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoOrdenCompraGestion
	 * @param codigoArticulo
	 * @throws SICException
	 */
	public void eliminarDescuentosArticulosEnOrdenCompraGestion(Integer codigoCompania, Long codigoOrdenCompraGestion, String codigoArticulo) throws SICException;
}