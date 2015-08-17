package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.math.BigDecimal;
import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaPaletOrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaTareaDatosTareaDTO;



public interface IRecepcionPalletDAO {

	/**
	 * <b>  Obtener la lista de pallets asignados a un recolector<b>
	 * <p>
	 * [Author: lguaman, Date: 17/11/2014]
	 * @param funcionarioSubTraRel
	 * @param codigoTipoTareaPerfilDTO
	 * @return
	 */
	Collection<DatosTareaDTO> obtenerPalletsAsignadosRecolector(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, Long codigoTipoTareaPerfilDTO);
	
	/**
	 * Obtener los pallets asignados a un recolector, por valorEstadoDatosTarea y codigoReferenciaTipoTarea
	 * @param funcSubTraRel
	 * @param codigoTipoTareaPerfilDTO
	 * @param valorEstadoDatosTarea
	 * @param codigoReferenciaTipoTarea
	 * @return
	 * @throws SICException
	 */
	Collection<TareaDatosTareaDTO> obtenerPalletsAsignadosRecolectorPerecibles(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, Long codigoTipoTareaPerfilDTO, String valorEstadoDatosTarea, String codigoReferenciaTipoTarea) throws SICException;
	
	/**
	 * 
	 * @param funSubTarRel
	 * @param codigoTipoTareaPerfil
	 * @param codigoBarrasPallet
	 * @return
	 */
	Collection<VistaTareaDatosTareaDTO> obtenerDatosTareaRecolector(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, Long codigoTipoTareaPerfil, Collection<String> codigoBarrasPallet) throws SICException;
	
	/**
	 * Obtiene el pallet que se encuentra registrado en una recepcion
	 *
	 * @param codigoBarrasPallet
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<DatosTareaDTO> buscarPalletRecepcion(String codigoBarrasPallet) throws SICException;
	
	/**
	 * Retorna un pallet existente con su respectivo estado.
	 * @param codigoBarrasPallets
	 * @param codigoCompania
	 * @return
	 * 
	 */
	Collection<DatosTareaEstadoDTO> obtenerPaletExistenteEstado(Integer codigoCompania, Collection<String> codigoBarrasPallets) throws SICException;
	

	/**
	 * Retorna la unidad de manejo del pallet con las cantidades que se ha recibido
	 * @param codigoDatosTarea
	 * @param codigoCompania
	 * @return
	 * 
	 */
	Collection<ArticuloUnidadManejoProveedorDTO> obtenerUnidadManejoArticuloDesdePalet(Long codigoDatosTarea, Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param datosTareaDTO
	 * @return
	 * @throws SICException
	 */
	Collection<VistaPaletOrdenCompraDetalleEstadoDTO> obtenerCantidadRecibidaEnPalet(DatosTareaDTO datosTareaDTO)  throws SICException;
	
	/**
	 * Actualiza la cantidad y el peso de un pallet
	 * 
	 * @param secuencialDatosTarea
	 * @param cantidadPallet
	 * @param pesoPallet
	 * @throws SICException
	 */
	void actualizarCantidadEntregadaDatosTarea(Long secuencialDatosTarea, Integer cantidad, BigDecimal peso, BigDecimal pesoAproximado, String userId) throws SICException;
	
	/**
	 * Permite registrar un pallet incompleto para la recepcion
	 * @param funcionarioAreaTrabajo
	 * @param tareaSeleccionada
	 * @param articuloPallet
	 * @return
	 * @throws SICException
	 */
	Long registrarPalletIncompleto(String usuarioFuncionario, TareaDTO tareaSeleccionada) throws SICException;
	
	/**
	 * <b> Actualiza los datos del pallet despues de que termina de recibir el mismo<b>
	 * <p>
	 * [Author: aecaiza, Date: 19/02/2015]
	 * @param datosTareaDTO
	 * @throws SICException
	 */
	void actualizarDatosTarea(DatosTareaDTO datosTareaDTO)throws SICException;
	
	/**
	 * <b> Actualiza la ubicacion del palet<b>
	 * <p>
	 * [Author: aecaiza, Date: 11/11/2014]
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param secuencialDatosTarea
	 * @return
	 */
	void actualizarUbicacion(Integer codigoCompania, Long codigoActualUbicacion, Long secuencialDatosTarea);
	
	/**
	 * Obtiene la ubicaci&oacute;n de un art&iacute;culo
	 * @return
	 * @throws SICException
	 */
	Collection<CatalogoValorDTO> obtenerUbicacionArticulo() throws SICException;
	
}