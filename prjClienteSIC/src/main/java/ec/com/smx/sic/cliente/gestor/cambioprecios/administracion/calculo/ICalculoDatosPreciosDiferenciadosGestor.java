package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.calculo;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PrecioDiferenciadoArticuloGestionDTO;

/**
 * @author Marcelo Hidalgo
 *
 */
public interface ICalculoDatosPreciosDiferenciadosGestor extends Serializable {


	/**
	 * @param costoNeto
	 * @param articuloPrecioDiferenciado
	 * @param articuloComercial
	 * @return
	 * @throws SICException
	 */
	PrecioDiferenciadoArticuloGestionDTO generarPrecioDiferenciadoCambioPrecio(Double costoNeto, ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciado, ArticuloComercialDTO articuloComercial) throws SICException;


	/**
	 * Asigna TRUE a los articulos que tienen precios diferenciados
	 * @param codigoCompania
	 * @param articulosGestionPrecios
	 * @throws SICException
	 */
	void validarPreciosDiferenciados(Integer codigoCompania, Collection<ArticuloGestionPrecioDTO> articulosGestionPrecios) throws SICException;


	/**
	 * Funcion para devolver los articulos gestion precio con sus respectivos precios diferenciados
	 * @param codigoCompania
	 * @param articulosGestionPrecios
	 * @throws SICException
	 */
	void obtenerPreciosDiferenciadosPorArticulosGestion(Integer codigoCompania, Collection<ArticuloGestionPrecioDTO> articulosGestionPrecios) throws SICException;
	
	/**
	 * 
	 * @param articuloGestionPrecio
	 * @param preciosDiferenciados
	 * @param preciosDiferenciadosActuales
	 * @throws SICException
	 */
	void generarPreciosDiferenciadosPorSincronizar(ArticuloGestionPrecioDTO articuloGestionPrecio, Collection<ArticuloPrecioDiferenciadoDTO> preciosDiferenciados, Collection<PrecioDiferenciadoArticuloGestionDTO> preciosDiferenciadosActuales) throws SICException;
	
}
