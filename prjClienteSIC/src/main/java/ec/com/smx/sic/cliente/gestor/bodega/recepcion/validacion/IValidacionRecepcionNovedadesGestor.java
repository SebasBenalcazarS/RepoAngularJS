package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;

/**
 * @author aecaiza
 *
 */
public interface IValidacionRecepcionNovedadesGestor {
	/**
	 * Valida los datos necesarios para guardar una novedad de un articulo no recibido
	 * 
	 * @param recepcionProveedorDTO
	 * @param articuloUnidadManejoDTO
	 * @param codigoJustificacion
	 * @param cantidad
	 * @throws SICException
	 */
	void guardarNovedadArticuloRecepcion(RecepcionProveedorDTO recepcionProveedorDTO, ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;
	
	/**
	 * Valida los datos necesarios crear la novedad en la recepcion
	 * 
	 * @param recepcionProveedorDTO
	 * @param articuloUnidadManejoDTO
	 * @param codigoJustificacion
	 * @param cantidad
	 * @param funcionarioPerfilDTO
	 * @throws SICException
	 */
	void crearNovedadRecepcionJustificacionArticulo(RecepcionProveedorDTO recepcionProveedorDTO, ArticuloUnidadManejoDTO articuloUnidadManejoDTO,
			FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) throws SICException;
}
