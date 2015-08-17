package ec.com.smx.sic.cliente.servicio.bodega;

import java.sql.Timestamp;
import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoInformacionRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaTareaDatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaUbicacionPalletMontacarguistaDTO;

/**
 * 
 * Fecha 07-02-2013
 * 
 * @author acaiza
 * 
 */
public interface IRecepcionProveedorServicioScanner {
	
	/************************************************************METODOS TRANSACCIONALES **************************************/
	/**
	 * Finalizar la tarea de recepcion del proveedor
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	void transTerminarProveedor(TareaDTO tareaDTO) throws SICException;
	
	/**
	 * Suspender la tarea de recepcion del proveedor
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	void transSuspenderProveedor(TareaDTO tareaDTO) throws SICException;
	
	/**
	 * Asignar la tarea al recolector cuando se recibio un pallet
	 * @param listaDatosTareaRecolector
	 * @param funcionarioSublugarTrabajoRelacionadoDTO
	 * @param codigoPerfil
	 * @throws SICException
	 */
	void transAsignarTareaRecolector(Collection<DatosTareaDTO> listaDatosTareaRecolector ,
			FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) throws SICException;
	
	/**
	 * Finaliza la tarea del recolector, manda a crear la tarea del montacarguista y a actualizar
	 *  la cantidad en asignaci&oacute;n art&iacute;culo unidad manejo
	 * @param datosTareaDTO Pallet actual
	 * @param actualizarAsignacionArtUniMan TRUE: D&eacute;je en ubicaci&oacute;n FALSE: D&eacute;je en pasillo 
	 * @param funcionarioProcesoPerfilAreaTrabajoDTO
	 * @throws SICException
	 */
	void transFinalizarTareaRecolector(DatosTareaDTO datosTareaDTO, Boolean actualizarAsignacionArtUniMan,
			FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) throws SICException;
	
	/**
	 * Asigna el funcionario y cambia los estados de la tarea
	 * @param vistaUbicacionPalletMontacarguistaDTO
	 * @param funcionarioProcesoPerfilAreaTrabajoDTO
	 * @throws SICException
	 */
	void transAsignarTareaMontacarguista(VistaUbicacionPalletMontacarguistaDTO vistaUbicacionPalletMontacarguistaDTO,
			FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO)throws SICException;
	
	/**
	 * Finaliza la tarea del montacarguista, finaliza el estado del pallet y actualiza los valores de la ubicacion
	 * 
	 * @param vistaUbicacionPalletMontacarguistaDTO
	 * @param vistaInformacionArticulo
	 * @param detalleSeccionDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void transFinalizarTareaMontacarguista(VistaUbicacionPalletMontacarguistaDTO vistaUbicacionPalletMontacarguistaDTO,
			VistaArticuloUnidadManejoInformacionRecepcionDTO vistaInformacionArticulo, DetalleSeccionDTO detalleSeccionDTO) throws SICException;
	
	/**
	 * Cambiar en estado del pallet de En proceso a balanza
	 * @param pallet
	 */
	void transCambiarEstadoPalletEnBalanza(DatosTareaDTO pallet) throws SICException;
	

	/**
	 * Cambia el estado del pallet que este en AND o PES
	 * @param listaPallets
	 * @param userId
	 * @throws SICException
	 */
	void transCambiarEstadoPalletEnProceso(Collection<DatosTareaDTO> listaPallets, String userId) throws SICException;
	
	/**
	 * Registra el pallet incompleto con el codigo de barras = -1
	 * @param usuarioFuncionario
	 * @param tareaSeleccionada
	 * @return
	 * @throws SICException
	 */
	Long transRegistrarPalletIncompleto(String usuarioFuncionario, TareaDTO tareaSeleccionada) throws SICException;
	/**
	 * 
	 * @param datosTareaDTO
	 * @param catalogoEstadoTarea
	 * @throws SICException
	 */
	TareaDTO transCambiarEstadoTarea(DatosTareaDTO datosTareaDTO, CatalogoValorDTO catalogoEstadoTarea) throws SICException;
	
	/**
	 * Cambiar el estado de la tarea si el estado de la misma es igual a asignada
	 * @param vistaDatosTareaDTO
	 * @param datosTarea
	 * @param catalogoEstadoTarea nuevo estado de la tarea
	 * @return
	 * @throws SICException
	 */
	DatosTareaDTO transCambiarEstadoTareaAsignada(VistaTareaDatosTareaDTO vistaDatosTareaDTO, DatosTareaDTO datosTarea,
			CatalogoValorDTO catalogoEstadoTarea) throws SICException;
	
	/**
	 * <b> Recolector libere un anden<b>
	 * <p>
	 * [Author: Yuniesky Armentero Moreno, Date: 18/06/2015]
	 * @param funcionario
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	int liberarAndenRecolector(FuncionarioProcesoPerfilAreaTrabajoDTO funcionario, String anden) throws SICException;

	/**
	 * <b> Liberar anden cuando se termine la recepcion<b>
	 * <p>
	 * [Author: Yuniesky Armentero Moreno, Date: 18/06/2015]
	 * @param recepcionProveedor
	 * @return
	 * @throws SICException
	 */
	int liberarAndenRecepcion(RecepcionProveedorDTO recepcionProveedor) throws SICException;
	
	
	/***************************************************METODOS NO TRANSACCIONALES*********************************************/
	
	/**
	 * Obtener registros sanitarios del articulo 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloRegistroSanitarioDTO> obtenerArticuloRegistroSanitario(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	
	/**
	 * Obtener las unidades de manejo de por codigo de articulo o codigo de barras de la unidad de manejo
	 * @param codigoBarras
	 * @param codigoProveedor
	 * @param esCaja
	 * @param codigoCompania
	 * @throws SICException
	 */
	Collection<ArticuloUnidadManejoDTO> encuentraArticuloUnidadManejoPorCodigoCajaOArticulo(String codigoBarras, String codigoProveedor,
			Boolean esCaja, Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoBarrasPallet
	 * @param funcionarioAreaTrabajoDTO
	 * @param funSubTraRel
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> obtenerPalletsRecolectar(Integer codigoCompania, String codigoBarrasPallet, String codigoFuncionario,
			Collection<DetalleSeccionDTO> andenesAsignados) throws SICException;
		
	/**
	 * 
	 * @param funcionarioAreaTrabajoDTO
	 * @param funcionarioPerfilDTO
	 * @param fechaTarea
	 * @return
	 * @throws SICException
	 */
	Collection<TareaDTO> obtenerTareasPendienteRecibidor(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO,
			Timestamp fechaTarea) throws SICException;

	/**
	 * Retorna TRUE si es un palet de recepcion
	 * @param palet Sin el identificador: A
	 * @param codigoBodega
	 * @return
	 * @throws SICException
	 */
	Boolean validarPalletRecepcion(String palet, Integer codigoBodega)throws SICException;

	
	/**
	 * Consulta todos los datos de la tarea 
	 * @param codigoCompania
	 * @param codigoTarea
	 */
	TareaDTO consultarTarea(Integer codigoCompania, Long codigoTarea) throws SICException;

	/**
	 * <b> Obtiene el tipo de control de costos por el catalogo valor relacionado</b>
	 * <p>
	 * [Author: aecaiza, Date: 12/02/2015]
	 * </p>
	 * @param codigoCompania
	 * @param codigoTipoControlCosto
	 * @return
	 * @throws SICException
	 */
	CatalogoValorRelacionadoDTO obtenerCatalogoValorTipoControlCostos(Integer codigoCompania, String codigoTipoControlCosto) throws SICException;

	

	/**
	 *Metodo para consultar los andenes que se asigmnaron a la recepcion
	 * @param codigoCompania
	 * @param codigoBodega
	 * @param valorTipoSeccion
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerListaCodigoDetalleSeccionIdentificador(Integer codigoCompania,Long codigoProcesoLogistico) throws SICException;
	
	/**
	 * Metodo para verificar si el anden existe en la bodega
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param Identificador
	 * @return
	 */
	DetalleSeccionDTO obtenerAndenPorBodega(Integer codigoCompania, Integer codigoAreaTrabajo, String identificador) throws SICException;
	 
	
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
	
	/**
	 * Sirve para consultar todos los andenes asignados al funcionario.
	 * @author Yuniesky Armentero Moreno
	 * @param funcionario
	 * @return
	 */
	Collection<DetalleSeccionDTO> obtenerAndenesAsignadosFuncionario(FuncionarioProcesoPerfilAreaTrabajoDTO funcionario) throws SICException;
	
	/**
	 * <b>Obtener los datos resumidos de la orden de compra de la tabla(RecepionProveedorArticuloDTO) segun las unidades de manejo</b>
	 *<p>
	 * [Author: aecaiza, Date: 13/07/2015]
	 * </p>
	 * @param listaArtUniMan
	 * @param tareaRecepcion
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorArticuloDTO> obtenerDatosRecepionProveedorArticulo(Collection<ArticuloUnidadManejoDTO> listaArtUniMan,
			TareaDTO tareaRecepcion) throws SICException;
	
	/**
	 * <b>Obtener la cantida maxima por articulo de un pallet</b>
	 * *<p>
	 * [Author: aecaiza, Date: 15/07/2015]
	 * </p>
	 * @param recepcionProveedorArticuloDTO
	 * @return
	 */
	Integer obtenerCantidadMaximaPallet(RecepcionProveedorArticuloDTO recepcionProveedorArticuloDTO) throws SICException;
	
	/**
	 * <b>Obtener la informaci\u00F3n de los articulos de las ordenes de conpra
	 * de la recepci\u00F3n
	 * </b>
	 * <p>
	 * [Author: aecaiza, Date: 16/07/2015]
	 * </p>
	 * @param cantidaArticulosPedidos
	 * @param tareaSeleccionada
	 * @param listaRecepcionProveedorArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorArticuloDTO> obtenerDatosArticulos(TareaDTO tareaSeleccionada,
			Collection<RecepcionProveedorArticuloDTO> listaRecepcionProveedorArticulo) throws SICException;

	/**
	 * Liberar Anden.
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param vistasProcesoLogistico
	 */
	int liberarAnden(Integer codigoCompania, Collection<VistaProcesoLogisticoDTO> vistasProcesoLogistico) throws SICException;
}
