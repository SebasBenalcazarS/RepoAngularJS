package ec.com.smx.sic.cliente.servicio.bodega;

import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;

public interface IRecepcionFuncionarioServicio {

	Collection<FuncionarioDTO> obtenerFuncionarioConOSinAndenesDetalleSeccion(Integer codigoCompania, Integer codigoAreaTrabajo, Integer codigoSubAreaTrabajo, Collection<Long> colDetalleSeccionMemoria) throws SICException;

	Collection<FuncionarioDTO> obtenerFuncionarioAndenesFiltrados(Integer codigoCompania, Integer codigoAreaTrabajoBodega, Integer codigoAreaTrabajoSubBodega, Integer codigoAreaTrabajo, Collection<DetalleSeccionDTO> colDetalleSeccionDto) throws SICException;

	Collection<FuncionarioDTO> obtenerFuncionarioAndenesTodos(Integer codigoCompania, Integer codigoAreaTrabajoBodega, Integer codigoAreaTrabajoSubBodega, Integer codigoAreaTrabajo) throws SICException;

	Collection<Object[]> obtenerCantidadProcesoLogistico(String codigoReferencia, Collection<String> estadosProcesoLogistico, Integer codigoEstadoProcesoLogistico, String tipoConsulta) throws SICException;
	
}
