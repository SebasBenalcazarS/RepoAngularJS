package ec.com.smx.sic.cliente.gestor.ordenCompra.calculo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.vo.OrdenCompraContingenciaPedidoAsistidoVO;
import ec.com.smx.sic.cliente.mdl.vo.SumatoriaUnidadManejoOrdenCompraVO;

public interface IObtencionDatosContingeciaPedidoAsistidoGestor {

	/**
	 * Obtiene todas las subbodegas que tenga el centro de distribucion determinado.
	 * @param codigoCompania 
	 * @param centroDistribucion
	 * @return Lista con las subbodegas que contenga el centro de distribuccion
	 */
	public Collection<AreaTrabajoDTO> obtenerAreaSublugarTrabajo(Integer codigoCompania, Integer centroDistribucion);

	/**
	 * Busca los centros de distribuciones que tenga permitido el funcionario,
	 * si el tipoBusqueda es true busca todos los centros de distribucion, de
	 * caso contrario busca el centro de distribucion 100
	 * 
	 * @param codigoCompania
	 *            Codigo de la compania
	 * @param codigoFuncionario
	 *            Codigo del funcionario.
	 * @param tipoBusqueda
	 *            <b>TRUE:</b> busca en todos los centro. <b>FALSE:</b> busca el
	 *            centro numero 100
	 * @return Coleccion con los centros de distribucion
	 */
	public Collection<AreaTrabajoDTO> buscarAreaTrabajoCentroDistribucion(int codigoCompania, String codigoFuncionario, boolean tipoBusqueda);

	
	/**
	 * Busca la lista de proveedores dado los datos. Si <b>firstResult</b> y <b>maxResult</b> son nulos
	 * el metodo retorna una lista con todos los proveedores que cumplan con los otros parametros.
	 * 
	 * @param parametrosBusqueda Parametros de busqueda.
	 * @param firstResult Registro desde el cual se realizara la busqueda. 
	 * @param maxResult Cantidad de registros a buscar.
	 * @return Collecion de proveedores.
	 */
	public Collection<VistaProveedorDTO> buscarProveedorPorSubbodega(OrdenCompraContingenciaPedidoAsistidoVO parametrosBusqueda, Integer firstResult, Integer maxResult) ;

	public Collection<SumatoriaUnidadManejoOrdenCompraVO> buscarSumatoriasParaOrdenCompra(OrdenCompraContingenciaPedidoAsistidoVO parametros);

}
