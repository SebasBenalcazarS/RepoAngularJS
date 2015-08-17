package ec.com.smx.sic.cliente.servicio.bodega;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.FuncionarioSublugarTrabajoRelacionadoDTO;
import ec.com.smx.sic.cliente.common.bodega.EnumCatalogoValorBodega;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.vo.BodegaVO;

/**
 * 
 * @author fcollaguazo
 *
 */
public interface IBodegaServicio {

	/**
	 * Obtiene la lista de bodegas por el valor tipo de bodega
	 * @param enumCatalogoValorBodega
	 * @return
	 * @throws SICException
	 */
	Collection<BodegaDTO> obtenerBodegasPorValorTipoBodega(EnumCatalogoValorBodega enumCatalogoValorBodega)throws SICException;
	
	/**
	 * Obtiene las bodegas en base a las propiedades ingresadas en la plantilla
	 * @param bodegaVO
	 * @return Collection<BodegaDTO>
	 * @throws SICException
	 */
	Collection<BodegaDTO> obtenerBodegas(BodegaVO bodegaVO) throws SICException;
	
	/**
	 * Permite obtener las subbodega apartir de un funcionario por medio de la linea comercial o usuario clasificacion
	 * @param bodegaVO
	 * @param funcionarioDTO
	 * @return
	 * @throws SICException
	 */
	Collection<BodegaDTO> obtenerSubbodegasPorFuncionario(BodegaVO bodegaVO,FuncionarioDTO funcionarioDTO) throws SICException;
	
	/**
	 * Obtiene las subbodegas atravez de los codigos del area de trabajo de las bodegas
	 * @param codigosBodega Un Collection de Integer
	 * @return Un Collection de BodegaDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<BodegaDTO> obtenerSubbodegas(Collection<Integer> codigosATBodega) throws SICException;
	
	/**
	 * Este m�todo devuelve las bodegas dada el area de trabajo.
	 * @param codigoAreaTrabajo
	 * @return
	 */
	public Collection<AreaTrabajoDTO> transObtenerBodegasPorCD(Integer codigoAreaTrabajo, CatalogoValorDTO caracteristica);
	
	/**
	 * Este m�todo devuelve una colecci�n de areas de trabajo con su respectiva jerarquia de areas de trabajo hijas, estas areas de trabajo son las que est�n configuradas
	 * en la tabla Funcionario Area de Trabajo, adem�s se puede enviar como parametro cual es la jerarquia superior y/o inferior de la jerarquia que queremos obtener, tomando
	 * en cuenta que MACROBODEGA (MBO)1, CENTRO DISTRIBUCION (CDT) 2, BODEGA (BOD)3, SUBBODEGA (SBO)4
	 * @param usuarioId
	 * @param tipoAreaTrabajoMayorNivel
	 * @param tipoAreaTrabajoMenorNivel
	 * @return
	 */
	public Collection<AreaTrabajoDTO> obtenerAreasTrabajoPorUsuario(String usuarioId, String tipoAreaTrabajoMayorNivel, String tipoAreaTrabajoMenorNivel, Long codigoProcesoCaracteristicaAreaTrabajo)throws SICException;
	
	
	/** Metodo obtenerSubbodegasPorProveedor, utilizado para obtener las subbodegas a las que abastece un proveedor
	 * @author srodriguez
	 * 6/3/2015
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @return Collection<BodegaDTO>
	 */
	Collection<BodegaDTO> obtenerSubbodegasPorProveedor(Integer codigoCompania, String codigoProveedor);
	
	
	/** Metodo obtenerSubbodegaPorBodegaProveedor, utilizado para obtener una bodega especifica por el proveedor y el codigo de la subbodega
	 * @author srodriguez
	 * 10/3/2015
	 * @param codigoCompania
	 * @param codigoBodega
	 * @param codigoProveedor
	 * @return
	 * @return BodegaDTO
	 */
	BodegaDTO obtenerSubbodegaPorBodegaProveedor(Integer codigoCompania, String codigoBodega,String codigoProveedor);
	
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public Collection<FuncionarioSublugarTrabajoRelacionadoDTO> obtenerSubLugarTrabajoPorFuncionario(String userId) throws SICException;
}
