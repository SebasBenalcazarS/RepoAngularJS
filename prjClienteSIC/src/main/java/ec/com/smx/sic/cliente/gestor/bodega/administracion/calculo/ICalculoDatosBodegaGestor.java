package ec.com.smx.sic.cliente.gestor.bodega.administracion.calculo;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.FuncionarioSublugarTrabajoRelacionadoDTO;
import ec.com.smx.sic.cliente.common.bodega.EnumCatalogoValorBodega;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAndenesPasillosDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaPerchasArticulosDTO;
import ec.com.smx.sic.cliente.mdl.vo.BodegaVO;

/**
 * 
 * @author fcollaguazo
 *
 */
public interface ICalculoDatosBodegaGestor {

	/**
	 * Obtiene la lista de bodegas por el valor tipo de bodega
	 * @param enumCatalogoValorBodega
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<BodegaDTO> obtenerBodegasPorValorTipoBodega(EnumCatalogoValorBodega enumCatalogoValorBodega)throws SICException;
	
	/**
	 * 
	 * @param enumCatalogoValorBodega
	 * @param codigoFuncionario
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<BodegaDTO> obtenerSubbodegasPorFuncionarioComprador(final String codigoFuncionario) throws SICException;
	
	
	/**
	 * Obtiene las bodegas en base a las propiedades ingresadas en la plantilla
	 * @param bodegaDTO
	 * @param enumCatalogoValorBodega
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<BodegaDTO> obtenerBodegas(BodegaVO bodegaVO) throws SICException;
	
	/**
	 * Permite obtener las subbodega apartir de un funcionario por medio de la linea comercial o usuario clasificacion
	 * @param bodegaVO
	 * @param funcionarioDTO
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<BodegaDTO> obtenerSubbodegasPorFuncionario(BodegaVO bodegaVO,FuncionarioDTO funcionarioDTO) throws SICException;
	
//	/**
//	 * Permite obtener las secciones a partir de una plantilla
//	 * @param seccionVO
//	 * @return Collection<SeccionDTO>
//	 * @throws SICException
//	 */
//	public abstract Collection<SeccionDTO> obtenerSecciones(SeccionVO seccionVO ) throws SICException;

	/**
	 * 
	 * @param codigosHijosLineaComercialPadre
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<BodegaDTO> obtenerSubbodegasPorLineaComercialComprador(HashSet<Long> codigosHijosLineaComercialPadre ) throws SICException;
	
	/**
	 * Consulta las bodegas en base a los ids de las areas de trabajo
	 * 
	 * @param codigosBodegaAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<BodegaDTO> obtenerBodegasPorAreaTrabajo(Collection<Integer> codigosBodegaAreaTrabajo) throws SICException;
	
	/**
	 * Consulta las bodegas en base a los ids de las bodegas
	 * 
	 * @param codigosBodega
	 * @return
	 * @throws SICException
	 */
	public Collection<BodegaDTO> obtenerBodegasPorBodega(Collection<String> codigosBodega) throws SICException;
	
	/**
	 * Arma las bodegas en una estructura map con el codigo del area de trabajo de la bodega y la bodega
	 * 
	 * @param bodegaDTOs
	 * @return
	 * @throws SICException
	 */
	public abstract Map<Integer, BodegaDTO> armarMapBodegaAreaTrabajo(Collection<BodegaDTO> bodegaDTOs) throws SICException;
	
	/**
	 * Arma las bodegas en una estructura map con el codigo y la bodega
	 * @param bodegaDTOs
	 * @return
	 * @throws SICException
	 */
	public abstract Map<String, BodegaDTO> armarMapBodega(Collection<BodegaDTO> bodegaDTOs) throws SICException;
	/**
	 * Obtine las perchas con el numero de articulos de una entrega de un proveedor que existe sobre la percha 
	 * @param codigoEntrega Codigo de la entrega de un proveedor
	 * @return Una Coleccion de VistaPerchasArticulosDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public abstract Collection<VistaPerchasArticulosDTO> obtenerPerchasArticulosPorEntregaProveedor(Long codigoEntrega) throws SICException;
	
	/**
	 * Busca la secciones relacionasa de una seccion de una area de trabajo
	 * 
	 * @param seccionDTO Una seccion de un area de trabajo
	 * @param tipoSeccionRelacion El tipo de relacion asociada a la seccion
	 * @return Un Collection de RelacionSeccionDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public abstract Collection<RelacionSeccionDTO> obtenerSeccionesRelacionadas(SeccionDTO seccionDTO, CatalogoValorDTO tipoSeccionRelacion) throws SICException;
	
//	/**
//	 * Obtiene el area de trabajo padre, de una bodega
//	 * 
//	 * @param codigoBodega Codigo bodega
//	 * @return Un AreaTrabajoDTO  
//	 * @throws SICException Excepcion en caso de producirse un error
//	 */
//	public abstract VistaBodegaCDAreaTrabajoDTO obtenerAreaTrabajoPadreBodega(String codigoBodega) throws SICException;
	/**
	 * Este metodo devuelve las bodegas dada el area de trabajo.
	 * @param codigoAreaTrabajo
	 * @return
	 */
	public Collection<AreaTrabajoDTO> obtenerBodegasPorCD(Integer codigoAreaTrabajo, CatalogoValorDTO caracteristica);
	
	/**
	 * Busca la bodega padre de una bodega
	 * @param codigoBodega Un Integer
	 * @return Un BodegaDTO
	 */
	public BodegaDTO obtenerBodegaPadre(String codigoBodega);
	
	/**
	 * 
	 * @param codigoATCD
	 * @return
	 * @throws SICException
	 */
	//public abstract Collection<BodegaDTO> obtenerSubBodegasCD(Integer codigoATCD) throws SICException;
	
	/**
	 * Obtiene las subbodegas atravez de los codigos del area de trabajo de las bodegas
	 * @param codigoATBodega Codigos de las areas de trabajo de las bodegas
	 * @return Un Collection de BodegaDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public Collection<BodegaDTO> obtenerSubBodegas(Collection<Integer> codigosATBodega) throws SICException;
	
	/**
	 * 
	 * @param codigoATCD
	 * @return
	 * @throws SICException
	 */
	//public abstract Collection<BodegaDTO> obtenerBodegasCD(Integer codigoATCD) throws SICException;
	/**
	 * Este metodo devuelve una coleccion de areas de trabajo con su respectiva jerarquia de areas de trabajo hijas, estas areas de trabajo son las que estan configuradas
	 * en la tabla Funcionario Area de Trabajo, ademas se puede enviar como parametro cual es la jerarquia superior y/o inferior de la jerarquia que queremos obtener, tomando
	 * en cuenta que MACROBODEGA (MBO)1, CENTRO DISTRIBUCION (CDT) 2, BODEGA (BOD)3, SUBBODEGA (SBO)4
	 * @param usuarioId
	 * @param tipoAreaTrabajoMayorNivel
	 * @param tipoAreaTrabajoMenorNivel
	 * @return
	 */
	public Collection<AreaTrabajoDTO> obtenerAreasTrabajoPorUsuario(String usuarioId, String tipoAreaTrabajoMayorNivel, String tipoAreaTrabajoMenorNivel, Long codigoProcesoCaracteristicaAreaTrabajo)throws SICException;


	/**
	 * Permite obtener los andenes de las clasificaciones
	 * @param codigosClasificacion
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaAndenesPasillosDTO> obtenerAndenesPorClasificacion(List<String> codigosClasificacion, Integer codigoAreaTrabajo)throws SICException;
	
	/**
	 * Permite obtener (MBO, CD, BOD, SBO) con sus respectivos hijos 
	 * @param tipoAreaTrabajoValor
	 * @return
	 */
	public Collection<BodegaDTO> obtenerBodegasSubbodegas(String tipoAreaTrabajoValor) throws SICException;
	
	
	/** Metodo obtenerSubbodegasPorArticulo, utilizado para obtener subbodegas por articulo
	 * @author srodriguez
	 * 6/3/2015
	 * @param tipoAreaTrabajoValor
	 * @return
	 * @throws SICException
	 * @return Collection<BodegaDTO>
	 */
	Collection<BodegaDTO> obtenerSubbodegasPorProveedor(Integer codigoCompania, String codigoProveedor);
	
	
	/** Metodo obtenerSubbodegaPorBodegaProveedor, utilizado para obtener una subbodega especificamente por el tipo
	 * @author srodriguez
	 * 10/3/2015
	 * @param codigoCompania
	 * @param codigoBodega
	 * @param codigoProveedor
	 * @return
	 * @return BodegaDTO
	 */
	BodegaDTO obtenerSubbodegaPorBodegaProveedor(Integer codigoCompania,String codigoBodega, String codigoProveedor);
	
	/**
	 * @param codigoCompania
	 * @param codigoIdOrdenCompraDetalleEstado
	 * @return
	 * @throws SICException
	 */
	public String obtenerIdLogAuditoriaOrdenCompraDetalleEstado(Integer codigoCompania, String codigoIdOrdenCompraDetalleEstado) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigoRecepcionProveedor
	 * @return
	 * @throws SICException
	 */
	public String obtenerIdLogAuditoriaRecepcionProveedor(Integer codigoCompania, Long codigoRecepcionProveedor) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoRecepcionProveedorArticulo
	 * @return
	 * @throws SICException
	 */
	public String obtenerIdLogAuditoriaRecepcionProveedorArticulo(Integer codigoCompania, Long codigoRecepcionProveedorArticulo) throws SICException;
	
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public Collection<FuncionarioSublugarTrabajoRelacionadoDTO> obtenerSubLugarTrabajoPorFuncionario(String userId) throws SICException;
}
