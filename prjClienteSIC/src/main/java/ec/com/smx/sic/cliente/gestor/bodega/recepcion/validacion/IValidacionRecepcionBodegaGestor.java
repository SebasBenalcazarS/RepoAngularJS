package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoPerfilDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoTareaPerfilDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;

public interface IValidacionRecepcionBodegaGestor {
	/**
	 * 
	 * @param detalleSeccionDTOs
	 * @param recepcionProveedorDTO
	 * @throws SICException
	 */
	public abstract void registrarTareaRecepcionProveedor(Collection<DetalleSeccionDTO> andenes, RecepcionProveedorDTO recepcionProveedor) throws SICException;
	/**
	 * 
	 * @param entregaDTO
	 * @param detalleSeccionDTOs
	 * @param pedidoDTOs
	 * @param recepcionProveedorDTO
	 * @throws SICException
	 */
	public abstract void completarTiposDeRecepcion(EntregaDTO entregaDTO, Collection<DetalleSeccionDTO> andenes,Collection<OrdenCompraEstadoDTO> listaOrdenCompraEstado , RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;

	/**
	 * 
	 * @param usuario
	 * @throws SICException
	 */
	public abstract void obtenerAreasTrabajoFuncionario(UserDto usuario) throws SICException;
	
	/**
	 * 
	 * @param entregaDTO
	 * @param detalleSeccionDTOs
	 * @throws SICException
	 */
	public abstract void registrarProveedorRecepcionBodega(EntregaDTO entregaDTO) throws SICException;
	
	/**
	 * 
	 * @param proveedorDTO
	 * @param entregaDTOs
	 * @param areaTrabajoDTO
	 * @param detalleSeccionDTOs
	 * @throws SICException
	 */
	public abstract void registrarProveedorRecepcionBodega(VistaProveedorDTO proveedorDTO, Collection<EntregaDTO> entregaDTOs, AreaTrabajoDTO areaTrabajoDTO, Collection<DetalleSeccionDTO> detalleSeccionDTOs) throws SICException;

	
	/**
	 * 
	 * @param entregaDTO
	 * @param detalleSeccionDTOs
	 * @throws SICException
	 */
	public abstract void modificarProveedorRecepcionBodega(Collection<EntregaDTO> entregasDTO, Collection<DetalleSeccionDTO> andenes) throws SICException;
	
	/**
	 * 
	 * @param entregasDTO
	 * @param detalleSeccionActual
	 * @param detalleSeccionAnterior
	 * @throws SICException
	 */
	public void modificarAndenRecepcionEntrega(Collection<EntregaDTO> entregasDTO, DetalleSeccionDTO detalleSeccionActual, DetalleSeccionDTO detalleSeccionAnterior) throws SICException;

	
	/**
	 * 
	 * @param tareaPerfilDTO
	 * @throws SICException
	 */
	public abstract void validarTareaPerfilParaRegistroProveedor(TipoTareaPerfilDTO tareaPerfilDTO) throws SICException;

	/**
	 * 
	 * @param tareaDTO
	 * @param historicoDTO
	 * @throws SICException
	 */
	public abstract void asignarFuncionarioRecibidorEntrega(EntregaDTO entregaDTO, FuncionarioAreaTrabajoPerfilDTO funcionarioHistorico) throws SICException;
	
	/**
	 * 
	 * @param tareaDTO
	 * @param historicoDTO
	 * @throws SICException
	 */
	public abstract void asignarFuncionarioTarea(TareaDTO tareaDTO, FuncionarioAreaTrabajoPerfilDTO historicoDTO) throws SICException;
	
	/**
	 * 
	 * @param tareaDTO
	 * @param funcionarioSublugarTrabajoRelacionadoDTO
	 * @param codigoPerfil
	 * @throws SICException
	 */
	public void asignarFuncionarioTareaRecepcion(TareaDTO tareaDTO, FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) throws SICException;

}