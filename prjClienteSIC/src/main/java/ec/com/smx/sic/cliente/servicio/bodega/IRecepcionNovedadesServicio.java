package ec.com.smx.sic.cliente.servicio.bodega;

import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.common.busqueda.bean.bodega.recepcion.IPlantillaBusquedaNovedadRecepcion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.JustificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaNovedadArticuloRecepcionDTO;

/**
 * @author aecaiza
 *
 */
public interface IRecepcionNovedadesServicio {
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
	void transGuardarNovedadArticuloRecepcion(RecepcionProveedorDTO recepcionProveedorDTO, ArticuloUnidadManejoDTO articuloUnidadManejoDTO,
			Collection<JustificacionDTO> listaJustificaciones, FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, Collection<ControlRecipienteTaraDetalleDTO> listaJabas) throws SICException;
	/**
	 * Busca los datos correspondientes a las justificaciones para la recepcion
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoPerfil
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerJustificacionesRecepcion(Integer codigoCompania, Integer codigoAreaTrabajo, String codigoPerfil) throws SICException;
	
	/**
	 *<b> Obtiene las justificaciones con cantidad por articulo y unidad de manejo<b>
	 * <p>
	 * [Author: aecaiza, Date: 04/03/2015]
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @param codigoAreaTrabajo
	 * @param codigoProcesoLogistico
	 * @param codigoPerfil
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenertCantidadJustificaciones(Integer codigoCompania, String codigoArticulo, Long codigoUnidadManejo, Integer codigoAreaTrabajo,
			Long codigoProcesoLogistico, String codigoPerfil) throws SICException;
	
	
	/**
	 *<b> Actualiza las justificaciones con cantidad por articulo y unidad de manejo<b>
	 * <p>
	 * [Author: aecaiza, Date: 05/03/2015]
	 * @param listaJustificaciones
	 * @param codigoCompania
	 * @param usuarioModificacion
	 * @throws SICException
	 */
	void transActualizarCantidadJustificaciones(Collection<JustificacionDTO> listaJustificaciones, Integer codigoCompania, String usuarioModificacion)throws SICException;
	
	/**
	 * <b> Obtiene las justificaciones filtradas por tipo de novedad<b>
	 * <p>
	 * [Author: jvasquez, Date: 28/07/2015]
	 * @param codigoCompania
	 * @param valorTipoNovedad
	 * @param codigoTipoNovedad
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerJustificacionTipo(Integer codigoCompania, String valorTipoNovedad, Integer codigoTipoNovedad) throws SICException;
	/**
	 * <b> Obtiene las justificaciones filtradas area de trabajo y perfil<b>
	 * <p>
	 * [Author: jvasquez, Date: 28/07/2015]
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoPerfil
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerJustificacionAreaTrabajoPerfil(Integer codigoCompania, Integer codigoAreaTrabajo, String codigoPerfil) throws SICException;
	
	/**
	 * <b> Obtiene las novedades en articulos de recepcion filtradas por una plantilla de busqueda<b>
	 * <p>
	 * [Author: jvasquez, Date: 31/07/2015]
	 * @param plantilla
	 * @return
	 * @throws SICException
	 */
	Collection<VistaNovedadArticuloRecepcionDTO> obtenerNovedadArticuloPaginado(IPlantillaBusquedaNovedadRecepcion plantilla) throws SICException;
}
