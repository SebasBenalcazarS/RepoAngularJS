/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author eharo
 *
 */
public interface IArticuloCreacionPorArchivoDAO {

	
	/**
	 * Metodo que permite verificar si existe el proveedor ingresado
	 * @param codigoJDEProveedor
	 * @param codigoCompania
	 * @param condicionesProveedor [0] : IndicadorI, [1] : codigoProveedor, [2] : origen, [3] : esImportador
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public String validarExisteProveedor(String codigoJDEProveedor, Integer codigoCompania, String[] condicionesProveedor) throws SICException;
	
	public boolean validarExisteClasificacion(String codigoClasificacion, Integer codigoCompania, List<HashMap<String, LinkedList<String>>> listaClasificaciones, Criterion usuarioClasificacion, String [] condicionesClasificacion)throws SICException;
	
	/**
	 * Metodo que valida si existe la subclasificacion con el codigo de la
	 * subclasificacion y la clasificacion
	 * @param codigoClasificacion
	 * @param codigoSubClasificacion
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
//	public boolean validarExisteSubClasifiacion(String codigoClasificacion, String codigoSubClasificacion, Integer codigoCompania, Set<String> listaSubClasificaciones)throws SICException;
	
	public boolean validarExisteSubClasifiacion(String codigoClasificacion, String codigoSubClasificacion, Integer codigoCompania) throws SICException;
	
	
	public boolean validarCodigoBarras(Integer codigoCompania, String codigoBarras)throws SICException;
		
	
	/**
	 * Metodo que verifica si existe la clase articulo ingresada
	 * @param codigoClaseArticulo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public boolean validarExisteClaseArticulo(String codigoClaseArticulo, Integer codigoCompania, Set<String> listaClaseArticulos, Boolean esCreacion)throws SICException;
	
	public boolean validarEAN14(String codigoEan14, Integer codigoCompania)throws SICException;
	
	public String validarExisteMarca(Integer codigoCompania, String nombreMarca, String codigoProveedor)throws SICException;
	
	public String validarExisteAlcancePrototipo(Integer codigoCompania, String nombreGrupoTrabajo, String tipoGrupoTrabajo)throws SICException;
	
	public String validarExisteAgrupador(String nombreAgrupador)throws SICException;
	
	public String validarExisteEmpaque(String empaque) throws SICException;
	
	public String validarExisteImportancia(Integer codigoCompania, String importancia) throws SICException;
	
	public String validarExistePlazoPago(String plazoPago) throws SICException;
	
	public String validarExisteUnidadMedida(String unidadMedida, String [] condicionesUnidadMedida) throws SICException;
	
	public String validarExisteControlPrecios(String controlPrecio) throws SICException;
	
	public String validarExisteTransgenico(String transgenico) throws SICException;
	
	public String validarExisteUso(String uso) throws SICException;
	
	public String validarExistePaisOrigen(String nombrePais) throws SICException;
	
	/**
	 * Permite verificar si en la base de datos existe un lugar de compra
	 * @param lugarCompra Nombre del lugar de compra
	 * @param codigoCompania C\u00F3digo de la compan\u00EDa
	 * @return
	 * @throws SICException
	 */
	String validarExisteLugarCompra(String lugarCompra, Integer codigoCompania) throws SICException;
	
	public String validarExisteTipoSecuencia(String nombreSecuencia) throws SICException;
	
	/**
	 * Metodo que permite verificar los descuentos por proveedor
	 * @return
	 * @throws SICException
	 */
	public Double obtenerPorcentajeDescuento(Integer codigoCompania, String codigoJDEProveedor, String codigoClasificacion, String codigoTipoDescuento, String valorAplicacionTipoDescuento) throws SICException;
	
	public String obtenerParametroRequerido(Integer codigoCompania, String parametroId) throws SICException;

	
	/**
	 * @param codigoCatalogoTipo
	 * @param nombreCatalogoValor
	 * @param esCodigoCatalogo
	 * @return
	 * @throws SICException
	 */
	public String obtenerCatalogoValor(Integer codigoCatalogoTipo, String nombreCatalogoValor, Boolean esCodigoCatalogo) throws SICException;

}