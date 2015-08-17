package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFuncionarioAndenesDTO;

public interface IFuncionarioDetallesSeccionDAO {

	/**
	 * @author Yuniesky Armentero Moreno
	 * @param funcionario
	 * @return
	 * @throws SICException
	 */
	Collection<FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionDTO> obtenerDetallesFuncionario(FuncionarioProcesoPerfilAreaTrabajoDTO funcionario) throws SICException;
	
	/**
	 * 
	 * @param funcionarioProcesoPerfilAreaTrabajoDetalleSeccionDTO
	 * @param esRango
	 * @throws SICException
	 */
	void actualizarDetalleSeccionFuncionario(FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionDTO funcionarioProcesoPerfilAreaTrabajoDetalleSeccionDTO, Boolean esRango) throws SICException;
	
	/**
	 * @param funcionario
	 * @return
	 * @throws SICException
	 */
	Collection<FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionDTO> obtenerDetallesFuncionarioPorId(FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionDTO funcionario) throws SICException;
	
	/**
	 * 
	 * @param funcionario
	 * @return
	 * @throws SICException
	 */
	Collection<FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionDTO> obtenerDetallesFuncionarioPorAT(FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionDTO funcionario) throws SICException;
	
	/**
	 * @author bcholca
	 */
	Collection<FuncionarioDTO> obtenerFuncionarioConOSinAndenesDetalleSeccion(Integer codigoCompania, String codigoPerfil, Integer codigoAreaTrabajo, Integer codigoSubAreaTrabajo, Long codigoDetalleSeccionMen ) throws SICException;

	/**
	 * @author bcholca
	 * @param codigoCompania
	 * @param codigoPerfil
	 * @param codigoAreaTrabajo
	 * @param codigoAreaSublugarTrabajo
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	Collection<VistaFuncionarioAndenesDTO> obtenerFuncionarioAndenesDetalleSeccion(Integer codigoCompania, String codigoPerfil, Integer codigoAreaTrabajo, Integer codigoAreaSublugarTrabajo) throws SICException;

	/**
	 * @author bcholca
	 * @param codigoReferencia
	 * @param estadosProcesoLogistico
	 * @param codigoEstadoProcesoLogistico
	 * @param tipoConsulta
	 * @return
	 * @throws SICException
	 */
	Collection<Object[]> obtenerCantidadProcesoLogistico(String codigoReferencia, Collection<String> estadosProcesoLogistico, Integer codigoEstadoProcesoLogistico, String tipoConsulta) throws SICException;

	/**
	 * @author bcholca
	 * @param codigoCompania
	 * @param codigoAreaTrabajoBodega
	 * @param codigoAreaTrabajo
	 * @param codigoAreaTrabajoSubBodega
	 * @param estadosProcesoLogistico
	 * @param codigoEstadoProcesoLogistico
	 * @return
	 */
	Collection<Object[]> obtenerTotalRecibidosc1c2(Integer codigoCompania, String codigoReferencia, Integer codigoAreaTrabajoBodega, Integer codigoAreaTrabajoSubBodega, Integer codigoAreaTrabajo, Integer codigoEstadoTarea, Collection<String> valorEstadoTarea, String tipoConsulta) throws SICException;

}
