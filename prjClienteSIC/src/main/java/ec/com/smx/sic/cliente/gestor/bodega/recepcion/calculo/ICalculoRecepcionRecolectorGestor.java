package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDetalleSeccionDTO;

/**
 * 
 * Fecha 07-02-2013
 * 
 * @author acaiza
 * 
 */
public interface ICalculoRecepcionRecolectorGestor {
	
	
//	/**
//	 * Obtiene las tareas pendientes de un recolector
//	 * @param codigoBarrasPalet
//	 * @param funcionarioAreaTrabajoDTO
//	 * @param funSubTraRel
//	 * @return Collection<DatosTareaDTO>
//	 * @throws SICException
//	 */
//	@Deprecated
//	Collection<DatosTareaDTO> obtenerTareasDeRecolector(String codigoBarrasPalet, FuncionarioAreaTrabajoDTO funcionarioAreaTrabajoDTO, FuncionarioSublugarTrabajoRelacionadoDTO funSubTraRel) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoBarrasPallet
	 * @param funcionarioAreaTrabajoDTO
	 * @param funSubTraRel
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> obtenerPalletsRecolectar(Integer codigoCompania, String codigoBarrasPallet, String codigoFuncionario,Collection<DetalleSeccionDTO> andenesAsignados) throws SICException;

//	/**
//	 * Obtiene la ubicacion asignada de un articulo
//	 * @param listOrdenCompraDetalleEstadoDTOs
//	 * @return Collection<AsignacionArticuloUnidadManejoDTO>
//	 * @throws SICException
//	 */
//	Collection<AsignacionArticuloUnidadManejoDTO> obtenerAsignacionUnidadManejo(Collection<OrdenCompraDetalleEstadoDTO> listOrdenCompraDetalleEstadoDTOs) throws SICException;
	
	/**
	 * Obtiene de una lista de andenes los que estan asignados a un funcionario.
	 * @author Yuniesky Armentero Moreno
	 * @param Funcionario
	 * @return Collection<DetalleSeccionID>
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> andenAsignadoFuncionario(FuncionarioProcesoPerfilAreaTrabajoDTO funcionario) throws SICException;
	
	/**
	 * Obtiene de una lista de andenes los que estan asignados a un funcionario.
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @return Collection<DetalleSeccionID>
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerAndenPorAreaTrabajo(Integer codigoCompania, Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 * Obtiene de una lista de anden de un area de trabajo y un nombre.
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param anden
	 * @return Collection<DetalleSeccionID>
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerAndenPorAreaTrabajoPorNombre(Integer codigoCompania, Integer codigoAreaTrabajo, String anden) throws SICException;
	
	/**
	 * Obtiene detalle de seccion por el nombre
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param nombre
	 * @return Collection<DetalleSeccionDTO>
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerDetalleSeccionPorNombre(Integer codigoCompania, String nombre)throws SICException;
	
	/**
	 * Obtiene pallet en andenes determinados.
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param anden
	 * @return Collection<DatosTareaDTO>
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> palletInAnden(Integer codigoCompania, Collection<DetalleSeccionDTO> anden)throws SICException;
	
	/**
	 * Obtiene pallet en andenes determinados.
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param anden
	 * @return Collection<DatosTareaDTO>
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> palletInAndenPorCodigoAnden(Integer codigoCompania, Collection<Long> anden)throws SICException;
	
	/**
	 * Obtiene pallet en andenes determinados.
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param anden
	 * @return Collection<RecepcionProveedorDetalleSeccionDTO>
	 * @throws SICException
	 */
	Collection<RecepcionProveedorDetalleSeccionDTO> andenConTiempoDeRecepcionAcabado(Integer codigoCompania, Collection<DetalleSeccionDTO> anden);
	
	/**
	 * Obtiene pallet en andenes determinados donde no se ha acabado el tiempo de recepcion.
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param anden
	 * @return Collection<RecepcionProveedorDetalleSeccionDTO>
	 * @throws SICException
	 */
	Collection<RecepcionProveedorDetalleSeccionDTO> recepcionProveedorDetalleSeccionDeAndenesEspecificos(Integer codigoCompania, Collection<DetalleSeccionDTO> anden);

	/**
	 * Obtiene pallet en andenes determinados donde no se ha acabado el tiempo de recepcion.
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param anden
	 * @return Collection<RecepcionProveedorDetalleSeccionDTO>
	 * @throws SICException
	 */
	Collection<RecepcionProveedorDetalleSeccionDTO> andenConTiempoDeRecepcionNoAcabado(Integer codigoCompania, Collection<DetalleSeccionDTO> anden);
	
	/**
	 * Metodo para buscar los otros registros de detalle seccion de los andenes compartidos.
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param anden
	 * @return Collection<DetalleSeccionDTO>
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> buscarDetalleSeccionDeAndenesCompartidos(Integer codigoCompania, Collection<DetalleSeccionDTO> lista) throws SICException;
	
	/**
	 * Obtener datos tarea, donde hay pallets, de acuerdo a la compania y los andenes a los que esta asignado, limitado por maxResults.
	 * @param codigoCompania
	 * @param anden
	 * @param maxResults si es diferente de null y mayor a cero limita los resultados caso contrario no.
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> obtenerPalletRangoAndenes(Integer codigoCompania, Collection<DetalleSeccionDTO> anden,Integer maxResults) throws SICException;
	
	/**
	 * Obtiene el registro de datosTareaDTO de acuerdo a la compania, los andenes a los que esta asignado y el
	 * pallet. Retorna null si el pallet no esta en los andenes asignados.
	 * @param codigoCompania
	 * @param anden
	 * @param codigoBarrasPallet
	 * @return
	 * @throws SICException
	 */
	DatosTareaDTO obtenerPalletPerteneceRangoAndenes(Integer codigoCompania, Collection<DetalleSeccionDTO> anden,String codigoBarrasPallet) throws SICException;
}
