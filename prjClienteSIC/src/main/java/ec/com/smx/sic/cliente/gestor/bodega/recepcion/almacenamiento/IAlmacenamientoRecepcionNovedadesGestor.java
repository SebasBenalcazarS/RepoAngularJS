package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.JustificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;

/**
 * @author aecaiza
 *
 */
public interface IAlmacenamientoRecepcionNovedadesGestor {
	
	/**
	 * Guarda una novedad de un articulo que no se pudo recibir, con la respectiva justificacion.
	 * 
	 * @param recepcionProveedorDTO
	 * @param articuloUnidadManejoDTO
	 * @param listaJustificaciones
	 * @param funcionarioProcesoPerfilAreaTrabajoDTO
	 * @param listaJabas
	 * @throws SICException
	 */
	void guardarNovedadArticuloRecepcion(RecepcionProveedorDTO recepcionProveedorDTO, ArticuloUnidadManejoDTO 
			articuloUnidadManejoDTO, Collection<JustificacionDTO> listaJustificaciones,FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO,
			Collection<ControlRecipienteTaraDetalleDTO> listaJabas) throws SICException;
	
	/**
	 *<b> Actualiza las cantidades de justificaciones por articulo y unidad de manejo<b>
	 * <p>
	 * [Author: aecaiza, Date: 05/03/2015]
	 * @param listaJustificacionesActualizadas
	 * @param codigoCompania
	 * @param usuarioModificacion
	 * @throws SICException
	 */
	void actualizarCantidadJustificacion(Collection<JustificacionDTO> listaJustificaciones, Integer codigoCompania, String usuarioModificacion) throws SICException;
//	/**
//	 * Guarda un rechazo de un articulo que no se pudo recibir, con la respectiva justificacion y jaba.
//	 * @param recepcionProveedorDTO
//	 * @param articuloUnidadManejoDTO
//	 * @param listaJustificaciones
//	 * @param funcionarioPerfilDTO
//	 * @param listaJabas
//	 * @throws SICException
//	 */
//	void guardarNovedadArticuloJustificacionDetatalleRecipiente(RecepcionProveedorDTO recepcionProveedorDTO, ArticuloUnidadManejoDTO 
//			articuloUnidadManejoDTO, Collection<JustificacionDTO> listaJustificaciones, FuncionarioPerfilDTO 
//			funcionarioPerfilDTO, Collection<ControlRecipienteTaraDetalleDTO> listaJabas)throws SICException;
	
}
