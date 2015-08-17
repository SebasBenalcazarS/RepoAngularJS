package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.calculo;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosCalculoCambioPrecio;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.PrecioDiferenciadoArticuloGestionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ValorAfectacionPrecioDTO;

/**
 * @author Luis Yacchirema
 *
 */
public interface ICalculoPreciosArticuloGestor extends Serializable{


	/**
	 * 
	 * @param codigoTipoAfectacionPrecio
	 * @param articulosPrecios
	 * @param valoresAfectacionPrecios
	 * @param datosCalculoCambioPrecio
	 * @throws SICException
	 */
	void calcularPreciosArticulosPorTipoAfectacion(Integer codigoTipoAfectacionPrecio, Collection<ArticuloGestionPrecioDTO> articulosPrecios,
			Collection<ValorAfectacionPrecioDTO> valoresAfectacionPrecios, DatosCalculoCambioPrecio datosCalculoCambioPrecio) throws SICException;

	/**
	 * @param articuloGestionPrecio
	 * @param columnaModificada
	 * @param columnaNula
	 * @throws SICException
	 */
	void calcularPreciosArticuloPorNuevaCondicion(ArticuloGestionPrecioDTO articuloGestionPrecio, String columnaModificada, String columnaNula) throws SICException;


	/**
	 * @param precioDiferenciadoArticulo
	 * @param articuloGestionPrecio
	 * @param columnaModificada
	 * @throws SICException
	 */
	void calcularPreciosPorPrecioDiferenciadoArticulo(PrecioDiferenciadoArticuloGestionDTO precioDiferenciadoArticulo, ArticuloGestionPrecioDTO articuloGestionPrecio, String columnaModificada) throws SICException;


	/**
	 * @param preciosDiferenciadosArticulo
	 * @param articuloGestionPrecio
	 * @throws SICException
	 */
	void calcularPreciosPorPreciosDiferenciadosArticulo(Collection<PrecioDiferenciadoArticuloGestionDTO> preciosDiferenciadosArticulo, ArticuloGestionPrecioDTO articuloGestionPrecio) throws SICException;


	/**
	 * 
	 * @param articuloGestionPrecio
	 * @param costoBruto
	 * @param codigoProveedorRelacionado
	 * @param unificarCostosProveedores
	 * @throws SICException
	 */
	void calcularPreciosPorProveedorRelacionado(ArticuloGestionPrecioDTO articuloGestionPrecio, Double costoBruto, String codigoProveedorRelacionado, Boolean unificarCostosProveedores) throws SICException;


	/**
	 * Funcion que calcula los precios en los articulos relacionados recibidos.
	 * @param gestionesPreciosRelacioandas
	 * @param nuevoPrecio
	 * @param columnaModificada
	 * @throws SICException
	 */
	void calcularGestionesPreciosRelacionados(Collection<ArticuloGestionPrecioDTO> gestionesPreciosRelacioandas, Double nuevoPrecio, String columnaModificada) throws SICException;

	/**
	 * Funcion que busca y calcula los precios de los proveedores relacionados de un articuloGestionPrecio.
	 * @param articuloGestionPrecio
	 * @throws SICException
	 */
	void calcularPreciosProveedoresRelacionadosPorArticulo(ArticuloGestionPrecioDTO articuloGestionPrecio) throws SICException;
	
	/**
	 * @param precioBase
	 * @param articuloComercial
	 * @return
	 */
	Double calcularPrecioBaseNoAfiliado(Double precioBase, ArticuloComercialDTO articuloComercial);
	
}