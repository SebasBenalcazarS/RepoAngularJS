package ec.com.smx.sic.cliente.servicio.bodega;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.DivisionGeoPoliticaDTO;
import ec.com.smx.corpv2.vo.AreaTrabajoVO;
import ec.com.smx.sic.cliente.common.bodega.EnumValorFiltrosUbicacion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoDetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BalanzaDetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.MigracionEstructuraLogisticaUbicacionesDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAndenesPasillosDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaUbicacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.CreacionUbicacionTrasient;
import ec.com.smx.sic.cliente.mdl.vo.SeccionVO;

public interface IEstructuraLogisticaServicio {
	/**
	 *  Metodo para crear ubicaciones fisicas masivamente
	 * @param detalleNaveDTO
	 * @param detalleSubnaveDTO
	 * @param subbodegaDTO
	 * @param pasilloHasta
	 * @param pasilloDesde
	 * @param valorTipoLado
	 * @param rackDesde
	 * @param rackHasta
	 * @param nivel
	 * @param bodega
	 * @param userId
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void crearUbicaciones(Map<EnumValorFiltrosUbicacion, Object> datos)throws SICException;
	/**
	 * Metodo para almacenar la nave con sus pasillos
	 * @param detalleNaveDTO
	 * @param codigoCompania
	 * @param userId
	 * @param pasilloDesde
	 * @param pasilloHasta
	 * @param bodega
	 * @throws SICException
	 */
	public void crearNave(DetalleSeccionDTO detalleNaveDTO,Integer codigoCompania,String userId,Integer pasilloDesde,Integer pasilloHasta, AreaTrabajoDTO bodega )throws SICException;
	/**
	 * Metodo para almacenar una subnave seccion y detalleSeccion
	 * @param userId
	 * @param codigoCompania
	 * @param detalleNaveDTO
	 * @param detalleSubnaveDTO
	 * @param subbodegaDTO
	 * @throws SICException
	 */
	public void crearSubnave(String userId,Integer codigoCompania, DetalleSeccionDTO detalleNaveDTO, DetalleSeccionDTO detalleSubnaveDTO, AreaTrabajoDTO subbodegaDTO)throws SICException;
	/**
	 * Metodo para crear una coleccion de detalles secciones relacionadas unidades de manejo y en caso que no este vacios la unidad de manejo y el codigo de la ubicacion fisica los relaciona.
	 * @param ubicaciones
	 * @throws SICException
	 */
	public void crearUbicacionesVirtuales(Collection<DetalleSeccionDTO> ubicaciones,Collection<ArticuloUnidadManejoDTO> articuloUnidadManVirtuales,String userId,Integer codigoCompania, ArticuloUnidadManejoDTO articuloUnidadManejo,Long codigodetalleSeccionFisica, AreaTrabajoDTO bodega, Integer subbodega) throws SICException;
	/**
	 * 
	 * @param seccionDTO
	 * @throws SICException
	 */
	public void registrarSeccion(SeccionDTO seccionDTO) throws SICException;
	
	/**
	 * Metodo para registrar varios detalles secciones
	 * @param detalleSeccionDTO
	 * @throws SICException
	 */
	//public void registrarDetalleSeccionCol(Collection<DetalleSeccionDTO> detalleSeccionCol, HashMap<String, Boolean> hashMapThread,String keyThread, HashMap<String, Boolean> hashMapThreadIniRel) throws SICException;
	/**
	 * 
	 * @param seccionDTO
	 * @throws SICException
	 */
	public void eliminarSeccion(SeccionDTO seccionDTO) throws SICException;
	/**
	 * 
	 * @param detalleSeccionHijosDTOs
	 * @param codigoDetalleSeccionPadre
	 * @throws SICException
	 */
	public void registrarRelacionDetalleSeccion(Collection<DetalleSeccionDTO> detalleSeccionHijosDTOs, Long codigoDetalleSeccionPadre) throws SICException;
	/**
	 * Metodo para inactivar el pasillo con sus padres nave, subnave y anden
	 * @param detalleSeccionDTO
	 * @param relacionSeccionDTO
	 * @throws SICException
	 */
	public void eliminarDetalleSeccionRelacionSeccion(DetalleSeccionDTO detalleSeccionDTO) throws SICException;
	/**
	 * 
	 * @param seccionDTO
	 * @throws SICException
	 */
	public void actualizarDetalleSeccion(DetalleSeccionDTO detalleSeccionDTO) throws SICException;
	/**
	 * 
	 * @param relacionSeccionDTO
	 * @throws SICException
	 */
	public void eliminarRelacionSeccion(RelacionSeccionDTO relacionSeccionDTO) throws SICException;
	/**
	 * 
	 * @param areaTrabajoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> buscarAreaTrabajo(AreaTrabajoVO areaTrabajoVO) throws SICException;
	/**
	 * Metodo para obtener las areas de trabajo para la estructura logistica
	 * @param areaTrabajoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> buscarAreasTrabajo(AreaTrabajoVO areaTrabajoVO)throws SICException;
	/**
	 * 
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> obtenerAreasSublugarTrabajo(Integer codigoAreaTrabajo, String tipoRelacion)throws SICException;
	
	/**
	 * 
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> buscarAreasSublugarTrabajo(AreaSublugarTrabajoDTO areaSublugarTrabajoDTO,String tipoAreaTrabajoContar)throws SICException;
	
	/**
	 * retorna una coleccion de areas sublugar de trabajo de las bodegas que estan relacionadas con la subbodega ingresada
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> buscarBodegasSubbodega(AreaTrabajoDTO areaTrabajoDTO)throws SICException;
	
	/**
	 * 
	 * @param areaTrabajoDTO
	 * @param codigoAreaTrabajoPadre
	 * @return
	 * @throws SICException
	 */
	public AreaSublugarTrabajoDTO guardarAreaTrabajo(AreaTrabajoDTO areaTrabajoDTO, Integer codigoAreaTrabajoPadre, Collection<SeccionDTO> secciones)throws SICException;
	/**
	 * Retorna una coleccion de secciones filtradas en base a una plantilla pasada como parametro
	 * @param seccionVO
	 * @return
	 * @throws SICException
	 */
	public SeccionDTO obtenerSecciones(SeccionVO seccionVO ) throws SICException;
	/**
	 * Retorna una coleccion con las ubicaciones que pertenezcan a un determinado pasillo
	 * @param seccionVO
	 * @param codigoPasillo
	 * @return
	 * @throws SICException
	 */
//	public Collection<DetalleSeccionDTO> obtenerUbicacionesPasillo(SeccionVO seccionVO, String codigoPasillo)throws SICException;
	/**
	 * devuelve la coleccion de detalles de las areas de la bodega
	 * @param codigoAreaTrabajo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> obtenerAreasBodega(Integer codigoAreaTrabajo, Integer codigoCompania)throws SICException ;
	
	/**
	 * Permite obtener los andenes de las clasificaciones
	 * @param codigosClasificacion
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaAndenesPasillosDTO> obtenerAndenesPorClasificacion(List<String> codigosClasificacion, Integer codigoAreaTrabajo)throws SICException;
	/**
	 * Obtiene el catalogo valor tipo bodega en areas de trabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<CatalogoValorDTO> obtenerCatalogoValorTipoBodega() throws SICException;
	
	/**
	 * Permite obtener (MBO, CD, BOD, SBO) con sus respectivos hijos 
	 * @param tipoAreaTrabajoValor
	 * @return
	 */
	public Collection<BodegaDTO> obtenerBodegasSubbodegas(String tipoAreaTrabajoValor) throws SICException;
	/**
	 * Permite obtener una coleccion de relaciones de areas de trabajo
	 * @param areaSubLugarTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> obtenerAreasSublugarTrabajo(AreaSublugarTrabajoDTO areaSubLugarTrabajoDTO) throws SICException;
	/**
	 * Permite almacenar el area de trabajo editada
	 * @param areaTrabajoDTO
	 * @throws SICException
	 */
	public void almacenarEdicionAreaTrabajo(AreaTrabajoDTO areaTrabajoDTO) throws SICException;
	
	/**
	 * Permite contar las naves que tiene la bodega
	 * @param areaTrabajoDTO
	 * @return
	 */
	public Integer cuentaNaves(Integer codaAeaTrabajoDTO);
	
	/**
	 * Permite la validacion en base para que no exista una area trabajo que tenga el codigo referencia
	 * @param codigoReferencia
	 * @param tipoAreaTrabajoValor
	 * @return
	 * @throws SICException
	 */
	public AreaTrabajoDTO validarExisteAreaTrabajo(Integer codigoReferencia,String tipoAreaTrabajoValor) throws SICException;
	
	/**
	 * Permite la busqueda de la ubicacion de los articulos en las areas de trabajo
	 * @param artUMDTO
	 * @param areaSublugarTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	DetalleSeccionDTO buscaUbicacion(ArticuloUnidadManejoDTO artUMDTO, AreaSublugarTrabajoDTO areaSublugarTrabajoDTO)throws SICException;
	
	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @param codigoAreaTrabajo
	 * @param detalleSeccionDTO
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO buscarUbicacionDisponible(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, Integer codigoAreaTrabajo,Integer codigoAreaSubbodega,String identificador)throws SICException;
	
	/**
	 * Permite obtener las ubicaciones de la bodega
	 * @param bodega
	 * @throws SICException
	 */
	public Collection<VistaUbicacionArticuloDTO> buscarUbicacionesBodega(Integer codigoAreaTrabajoBOD,Integer codigoAreaTrabajoSUB,Integer firstResult,Integer maxResults,Integer valMaxReg)throws SICException;
	
	/**
	 * 
	 * @param codigoAreaTrabajoBOD
	 * @param codigoAreaTrabajoSUB
	 * @param firstResult
	 * @param maxResults
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaUbicacionArticuloDTO> buscarUbicacionesRealesThreads(Integer codigoAreaTrabajoBOD,Integer codigoAreaTrabajoSUB,Integer firstResult,Integer maxResults)throws SICException;
	
	/**
	 * Permite consultar los articulos de una ubicacion
	 * @param codigoDetSecc
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoDTO> buscarArticuloUnidadManejo(String codigoBarras,Integer codigoAreaTrabajo,String codigoFuncionario)throws SICException;
	
	/**
	 *Permite actualizar los datos de ubicacion de articulo  
	 * @param articuloUnidadManejoDTO
	 * @param detalleSeccionDTO
	 * @param fechaCaducidad
	 * @param cantidad
	 * @param userID
	 * @param codigoBarras
	 * @param lote
	 * @param fechaElaboracion
	 * @throws SICException
	 */
	public void actualizarDatosUbicacionArticulo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO,DetalleSeccionDTO detalleSeccionDTO,Timestamp fechaCaducidad,Integer cantidad,String userID,String codigoBarras, String lote, Timestamp fechaElaboracion)throws SICException;
	/**
	 * Permite saber si tiene relaciones activas en base a la plantilla
	 * @param relacionDTO
	 * @return Boolean
	 * @throws SICException
	 */
	public Boolean tieneRelaciones(RelacionSeccionDTO relacionDTO)throws SICException;
	
	/**
	 * Metodo que verifica si el pasillo tiene ubicaciones en una subbodega
	 * @param codigoPasillo
	 * @param codigoCompania
	 * @param codigoSubbodega
	 * @return
	 * @throws SICException
	 */
	public Boolean pasilloTieneUbicaciones(Long codigoPasillo, Integer codigoCompania, Integer codigoSubbodega)throws SICException;
	
	/**
	 *Busca una ubicacion en la bodega si se encuentra registrada(existe) con el identificador especificado    
	 * @param codigoAreaTrabajo
	 * @param codigoBarrasUbicacion
	 * @param codigoCompania
	 * @throws SICException
	 */
	public DetalleSeccionDTO buscarUbicacionExistenteParaArticulo(Integer codigoAreaTrabajo, String codigoBarrasUbicacion, Integer codigoCompania,Integer codigoAreaTrabajoSubbodega) throws SICException;
	
	/**
	  * Devuelve una lista de ubicaciones que se encuentran ocupados
	 * @param asignacionArticuloUnidadManejoDTO
	 * @param tipoAlmacenamiento
	 * @throws SICException
	 */
	public Collection<AsignacionArticuloUnidadManejoDTO> transObtenerUbicacionesOcupadas(AsignacionArticuloUnidadManejoDTO asignacionArticuloUnidadManejoDTO, CatalogoValorDTO tipoAlmacenamiento) throws SICException;
	
	/**
	 * Devuelve una colecciond de articulos en base a una plantilla
	 * @param articuloDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> buscarArticulos(ArticuloDTO articuloDTO, String codigoFuncionario)throws SICException;
	
	/**
	 * Permite buscar ubicaciones visrtuales
	 * @param codigoSubBodegaCol
	 * @param codigoDetalleSeccion
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaUbicacionArticuloDTO> buscarUbicacionesVirtuales(Integer codigoAreaTrabajoBOD,Integer codigoAreaTrabajoSUB,Long codigoDetalleSeccion)throws SICException;
	
	/**
	 * Permite buscar los catalogos de estructura logistica
	 * @param codigoCatalogoTipo
	 * @return
	 * @throws SICException
	 */
	public Collection<CatalogoValorDTO> buscarCatalogoEstructuraLogistica(Integer codigoCatalogoTipo)throws SICException;
	
	/**
	 * Permite buscar subBodegas
	 * @param bodega
	 * @return
	 * @throws SICException
	 */
	public Collection<BodegaDTO> buscarSubBodegas(AreaTrabajoDTO bodega)throws SICException;
	/**
	 * devuelve una coleccion de unidades de manejo en base a un articulo
	 * @param articuloDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoDTO> buscarUnidadesManejo(ArticuloDTO articuloDTO)throws SICException;
	
	/**
	 * Permite la asignacion de un articulo a una ubicacion
	 * @param userId
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoDetalleSeccion
	 * @param codigoUnidadManejo
	 * @throws SICException
	 */
	public void crearRelacionUbicacionUnidadManejo(VistaUbicacionArticuloDTO vistaUbicacionArticuloDTO, String userId, Integer cantidad, Integer codigoCompania,String codigoArticulo,Long codigoDetalleSeccion,Long codigoUnidadManejo, Timestamp fechaCaducidad, Date fechaRecepcion, AreaTrabajoDTO bodega, Integer subbodega) throws SICException;
	
	/**
	 * Permite actualizar de la ubicacion tipo surtido o reserva
	 * @param codigoDetalleSeccion
	 * @param codigoValorTipoAlmacenamiento
	 * @param userID
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void actualizarUbicacionTipoAlmacenamiento(Collection<VistaUbicacionArticuloDTO> vistaUbicacionArticuloDTOCol, String codigoValorTipoAlmacenamiento,String userID,Integer codigoCompania, AreaTrabajoDTO bodega, Integer subbodega)throws SICException;
	
	/**
	 *Permite actualizar la cantidad de articulos en una ubicacion
	 * @param codigoUnidadManejo
	 * @param codigoArticulo
	 * @param codigoDetalleSeccion
	 * @param cantidadUbicacion
	 * @param codigoCompania
	 * @param userID
	 * @throws SICException
	 */
	public void actualizarCantidadArticuloUbicacion(VistaUbicacionArticuloDTO vistaUbicacionArticulo, Long codigoUnidadManejo,String codigoArticulo,Long codigoDetalleSeccion,Integer cantidadUbicacion,Integer codigoCompania,String userID, AreaTrabajoDTO bodega, Integer subbodega)throws SICException;
	
	/**
	 * Permite actualizar la relacion que existe con la ubicacion
	 * @param codigoUnidadManejo
	 * @param codigoArticulo
	 * @param codigoDetalleSeccion
	 * @param codigoCompania
	 * @param userID
	 * @throws SICException
	 */
	public void actualizarRelacionUbicacionUnidadManejo(VistaUbicacionArticuloDTO vistaUbicacionArticulo, Long codigoUnidadManejo,String codigoArticulo,Long codigoDetalleSeccion,Integer codigoCompania,String userID, AreaTrabajoDTO bodega, Integer subbodega)throws SICException;
	/**
	 * 
	 * @param relacionSeccionDTOCol
	 * @param codigoCompania
	 * @param userID
	 * @throws SICException
	 */
	public void actualizarRelacionUbicacionUnidadManejo(Collection<VistaUbicacionArticuloDTO> vistaUbicacionArticuloDTOCol,Integer codigoCompania,String userID, AreaTrabajoDTO bodega, Integer subbodega)throws SICException;
	/**
	 * Permite buscar el detalle seccion segun el area de trabajo e identificador
	 * @param detalleSeccionDTO
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO obtenerDetalleSeccion(DetalleSeccionDTO detalleSeccionDTO)throws SICException;

	/**
	 *  Permite buscar el detalle seccion segun el area de trabajo
	 * @param detalleSeccionDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> obtenerDetalleSeccionCol(DetalleSeccionDTO detalleSeccionDTO)throws SICException;
	
	/**
	 * Permite actualizar la fecha de caducidad de un articulo en la ubicacion asignada
	 * @param codigoUnidadManejo
	 * @param codigoArticulo
	 * @param codigoDetalleSeccion
	 * @param fechaCaducidad
	 * @param codigoCompania
	 * @param userID
	 * @throws SICException
	 */
	public void actualizarFechaCaducidadArticuloUbicacion(VistaUbicacionArticuloDTO vistaUbicacionArticuloDTO, Long codigoUnidadManejo,String codigoArticulo,Long codigoDetalleSeccion,Timestamp fechaCaducidad,Integer codigoCompania,String userID, AreaTrabajoDTO bodega, Integer subbodega)throws SICException;

	//----------------------------------------------------------------------------------------------------------------------
	// INICIO METODOS DE ASIGNACION DE ANDENES A LOCAL
	//----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Permite obtener la lista de andenes de la bodega
	 * @param codigoBodega
	 * @param disponible(True -> andenes que no estan asignados a ningun local)
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> obtenerListaAndenes(Integer codigoBodega, Boolean disponible)throws SICException;
	
	/**
	 * Permite obtener la lista de locales para asignar los andenes correspondientes
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerLocalesAsignacionAndenes()throws SICException;
	
	/**
	 * Permite registrar los andenes al local
	 * @param andenesCol
	 * @param codigoAreaTrabajo
	 * @param userId
	 * @throws SICException
	 */
	public void asignarAndenesLocal(Collection<DetalleSeccionDTO> andenesCol, Integer codigoAreaTrabajo, String userId)throws SICException;
	
	/**
	 * Permite obtener la lista de andenes de la bodega asignados de un local
	 * @param codigoBodega
	 * @param codigoLocal
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionAreaTrabajoDTO> obtenerListaAndenesLocal(Integer codigoBodega, Integer codigoLocal)throws SICException;
	
	/**
	 * Permite reasignar los andenes al local
	 * @param andenesCol
	 * @param codigoAreaTrabajoRemover
	 * @param codigoAreaTrabajoAsignar
	 * @param userId
	 * @throws SICException
	 */
	public void reasignarAndenesLocal(Collection<DetalleSeccionAreaTrabajoDTO> andenesCol, Integer codigoAreaTrabajoRemover, Integer codigoAreaTrabajoAsignar, String userId)throws SICException;
	
	/**
	 * Permite remover los andenes al local
	 * @param andenesCol
	 * @param codigoAreaTrabajoRemover
	 * @param userId
	 * @throws SICException
	 */
	public void removerAndenesLocal(Collection<DetalleSeccionAreaTrabajoDTO> andenesCol, Integer codigoAreaTrabajoRemover, String userId)throws SICException;	
	//----------------------------------------------------------------------------------------------------------------------
	// FIN METODOS DE ANDENES A LOCAL
	//----------------------------------------------------------------------------------------------------------------------
	/**
	 * Permite buscar las ubciaciones virtuales de una ubicacion
	 * @param detalleSeccionDTO
	 * @return
	 */
	public Collection<DetalleSeccionDTO> obtenerUbicacionesVirtuales(DetalleSeccionDTO detalleSeccionDTO)throws SICException;
	/**
	 * permite inactivar las ubicaciones fisicas con sus unidades de manejo
	 * @param vistaUbicacionArticuloCol
	 * @param codigoCompania
	 * @param userID
	 * @throws SICException
	 */
	public void eliminarUbicacionesUnidadesManejo(Collection<VistaUbicacionArticuloDTO> vistaUbicacionArticuloCol,Integer codigoCompania,String userID, AreaTrabajoDTO bodega, Integer subbodega)throws SICException;
	/**
	 * permite actualizar una ubicacion virtual
	 * @param relacionSeccionDTO
	 * @param asignacionArticuloUnidadManejoDTO
	 * @throws SICException
	 */
	public void eliminarUbicacionUnidadManejo(VistaUbicacionArticuloDTO vistaUbicacionArticuloDTO, Long codigoUnidadManejo,String codigoArticulo,Long codigoDetalleSeccion,Long codigoDetalleSeccionPadre,Integer codigoCompania,String userID, AreaTrabajoDTO bodega, Integer subbodega)throws SICException;
	
	/**
	 * Permite relacionar varias unidades de manejo con varias ubicaciones virtuales
	 * @param userId
	 * @param codigoCompania
	 * @param codigosDetSecCol
	 * @param artUniManCol
	 * @throws SICException
	 */
	public  void crearRelacionUniManUbicVirt(String userId,Integer codigoCompania,Collection<Long> codigosDetSecCol,Collection<ArticuloUnidadManejoDTO> artUniManCol)throws SICException;
	/**
	 * Permite obtener las unidades de manejo atadas a las ubicaciones virtuales de una ubicacion fisica
	 * @param codigoDetalleSeccionPadre
	 * @param codigoCompania
	 * @param codigosUnidadesM
	 * @param codigosArticulos
	 * @return
	 * @throws SICException
	 */
	public Collection<AsignacionArticuloUnidadManejoDTO> obtenerAsignacionesUbicacionUnidadManejo(Long codigoDetalleSeccionPadre,Integer codigoCompania,Collection<Long> codigosUnidadesM, Collection<String> codigosArticulos)throws SICException;
	
	/**
	 * Permite obtener una VistaUbicacionArticuloDTO de ubicaciones virtuales de una ubicacion fisica
	 * @param codigoDetalleSeccionPadre
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaUbicacionArticuloDTO> obtenerUbicacionesVirtualesUniMan(Long codigoDetalleSeccionPadre,Integer codigoCompania,Boolean verificarCantidad)throws SICException;
	/**
	 * valida que el pasillo exista solo en una subnave, que el pasillo exista solo en una nave, que una subnave exista solo en una nave
	 * @param subnave
	 * @param codigosDetalles
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Boolean validarPadreHijoUnico(String identificador, Collection<String> codigosDetalles,Integer codigoCompania,Integer codigoBodega,String valorTipoSeccionPadre, String valorTipoSeccionHijo, Long codigoDetalleSeccionHijo, Integer codigoSubbodega)throws SICException;
	/**
	 * Metodo para obtener el rango de pasillos de la nave
	 * @param nave
	 * @return
	 * @throws SICException
	 */
	public String rangoPasillosPadre(DetalleSeccionDTO detalleSeccion,String valorTipoSeccion)throws SICException;
	/**
	 * Metodo para actualizar el detalle secion de un anden
	 * @param detalleSeccionDTO
	 * @throws SICException
	 */
	public void actualizarDetalleSeccionAnden(DetalleSeccionDTO detalleSeccionDTO)throws SICException;
	/**
	 * Metodo para inactivar una coleccion de detalles seccion
	 * @param detallesSecciones
	 * @throws SICException
	 */
	public void eliminarDestallesSecciones(Collection<DetalleSeccionDTO> detallesSecciones)throws SICException;
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajoPadre
	 * @param codigoAreaTrabajoHijo
	 * @param valorTipoSeccionPadre
	 * @param valorTipoSeccionHijo
	 * @param valorTipoSeccionHijoContar
	 * @return
	 * @throws SICException
	 */
	public Collection<RelacionSeccionDTO> buscarDetalleSeccion(Integer codigoCompania , Integer codigoAreaTrabajoPadre,
			Integer codigoAreaTrabajoHijo,String valorTipoSeccionPadre,String valorTipoSeccionHijo,
			String valorTipoSeccionHijoContar,Long codigoDetSeccPadre,Long codigoDetSeccHijo)throws SICException;
	
	/**
	 * 
	 * @param relSeccCol
	 * @param codigoCompania
	 * @param userID
	 * @throws SICException
	 */
	public void actualizarDetalleRelacionesSeccion(Collection<RelacionSeccionDTO> relSeccCol,Integer codigoCompania,String userID)throws SICException;
	
	/**
	 * 
	 * @param detseccPadre
	 * @param detseccHijo
	 * @return
	 * @throws SICException
	 */
	public Collection<RelacionSeccionDTO> buscarDetalleSeccionPasillosDisponibles(DetalleSeccionDTO detseccPadre, DetalleSeccionDTO detseccHijo)throws SICException;
	
	/**
	 * Metodo para obtener el maximo del orden de los andenes
	 * @param codigoCompania
	 * @param codigoBodega
	 * @return
	 * @throws SICException
	 */
	public Integer maxOrdenAndenes(Integer codigoCompania,Integer codigoBodega)throws SICException;
	/**
	 * Metodo para obtener los proveedores
	 * @param proveedor
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<ProveedorDTO> busquedaProveedores(ProveedorDTO proveedor, Criterion criterion)throws SICException;
	/**
	 * Metodo para contar la busqueda de proveedores
	 * @param proveedor
	 * @return
	 * @throws SICException
	 */
	public Long contarBusquedaProveedores(ProveedorDTO proveedor, Criterion criterion)throws SICException;
	/**
	 * Metodo que busca un rango de pasillos con su nave y subnave
	 * @param pasilloDesde
	 * @param pasilloHasta
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<RelacionSeccionDTO> busquedaPasillos(Integer pasilloDesde, Integer pasilloHasta, Integer codigoAreaTrabajo, Integer codigoCompania, Integer firstResult, Integer maxResult)throws SICException;
	/**
	 * Metdodo para contar la busquedaPasillos
	 * @param pasilloDesde
	 * @param pasilloHasta
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public Long contarBusquedaPasillos(Integer pasilloDesde, Integer pasilloHasta, Integer codigoAreaTrabajo, Integer codigoCompania)throws SICException;
	/**
	 * Metodo para consultar los pasillos que pertenecen a un anden
	 * @param codigoAreaTrabajo
	 * @param codigoCompania
	 * @param codigoAnden
	 * @return
	 * @throws SICException
	 */
	public Collection<RelacionSeccionDTO> busquedaPasillosAnden(Integer codigoAreaTrabajo, Integer codigoCompania, Long codigoAnden)throws SICException;
	/**
	 * Metodo para contar la busqueda de locales
	 * @param codigoLocal
	 * @return
	 * @throws SICException
	 */
	public Long contarBusquedaLocal(Integer codigoLocal, Integer codigoCompania, String descripcion)throws SICException;
	/**
	 * Metodo para busqueda de locales
	 * @param codigoLocal
	 * @param codigoCompania
	 * @param firstResult
	 * @param maxResult
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<AreaTrabajoDTO> busquedaLocales(Integer codigoLocal, Integer codigoCompania, String descripcion, Integer firstResult, Integer maxResult)throws SICException;
	
	/**
	 * 
	 * @param codigoSubBodegaCol
	 * @param codigoDetalleSeccion
	 * @param tamPag
	 * @return
	 * @throws SICException
	 */
	public Integer countBusquedaUbicaciones(Integer codigoAreaTrabajoBOD,Integer codigoAreaTrabajoSUB,Long codigoDetalleSeccion)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param tipoAreaTrabajo
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<BodegaDTO> buscarBodegasDisponibles(Integer codigoCompania,String tipoAreaTrabajo,AreaTrabajoDTO areaTrabajoDTO)throws SICException;
	
	/**
	 * 
	 * @param subBodegaDTOCol
	 * @param areaTrabajoDTO
	 * @param codigoCompania
	 * @param userID
	 * @throws SICException
	 */
	public void agregarSubBodegas(Collection<BodegaDTO> subBodegaDTOCol,AreaTrabajoDTO areaTrabajoDTO,Integer codigoCompania,String userID)throws SICException;
	
	/**
	 * 
	 * @param areaSublugarTrabajoDTO
	 * @throws SICException
	 */
	public void actualizarAreaSublugarTrabajo(AreaSublugarTrabajoDTO areaSublugarTrabajoDTO)throws SICException;
	
	/**
	 * 
	 * @param seccionDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<SeccionDTO> consultarSeccion(SeccionDTO seccionDTO)throws SICException;
	/**
	 * Busqueda de proveedores relacionados a un detaleSeccion anden 
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	public Collection<ProveedorDetalleSeccionDTO> busquedaAndenProveedor(DetalleSeccionDTO anden)throws SICException;
	/**
	 * Insercion o actualizacion de la relacion entre el proveedor y el anden
	 * @param provDetSec
	 * @throws SICException
	 */
	public void asignacionAndenesProveedor(Collection<ProveedorDetalleSeccionDTO> provDetSecCol)throws SICException;

	/**
	 * Metodo actualiza el estado de la relacion entre andenes y proveedores
	 * @param provDet
	 * @throws SICException
	 */
	public void actualizacionRelacionProveedorDetalle(ProveedorDetalleSeccionDTO provDet) throws SICException;
	/**
	 * Metodo actualiza el estado de las relaciones entre andenes y proveedores
	 * @param proveedoresDetalle
	 * @throws SICException
	 */
	public void actualizacionRelacionesProveedorDetalle(Collection<ProveedorDetalleSeccionDTO> proveedoresDetalle)throws SICException;
	/**
	 * Busqueda de carcteristicas
	 * @param caracteristicaProcesoAreaTrabajoDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<CaracteristicaProcesoAreaTrabajoDTO> buscarCaracteristicas(CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTOs)throws SICException;

	/**
	 * Devuelve una lista de ubicaciones para la balanza a nivel de area de trabajo
	 * @param tipoControlCostos
	 * @param artUMDTO
	 * @param aresAreaSublugarTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	DetalleSeccionDTO buscarUbicacionPorTipoControlCostos(String tipoControlCostos, ArticuloUnidadManejoDTO artUMDTO, AreaSublugarTrabajoDTO aresAreaSublugarTrabajoDTO) throws SICException;
	/**
	 * 
	 * @param areaTrabajoDTOHija
	 * @param tipoAreaTrabajoValorPadre
	 * @return
	 * @throws SICException
	 */
	public AreaTrabajoDTO consultarAreaTrabajoPadre(AreaTrabajoDTO areaTrabajoDTOHija,String tipoAreaTrabajoValorPadre)throws SICException;

	/**
	 * Metodo para actualizar el detalle balanza
	 * @param detalleSeccionBalanza
	 * @throws SICException
	 */
	public void actualizacionDetalleSeccionBalanza(DetalleSeccionDTO detalleSeccionBalanza)throws SICException;
	/**
	 * 
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public boolean validarAreaTrabajoInactivar(AreaTrabajoDTO areaTrabajoDTO,boolean isRelacion)throws SICException;
	
	/**
	 * 
	 * @param areaTrabajoDTO
	 * @param isRelacion
	 * @return Collection<String>
	 * @throws SICException
	 */
	public Collection<String> obtenerDescAreaTrabajoRelacinoadas(AreaTrabajoDTO areaTrabajoDTO,boolean isRelacion)throws SICException;
	/**
	 * 
	 * @param areaTrabajoDTO
	 * @throws SICException
	 */
	public void actualizarAreaTrabajo(AreaTrabajoDTO areaTrabajoDTO, Collection<SeccionDTO> seccionesCrear, Collection<DetalleSeccionDTO> detsecActu)throws SICException;
	
	/**
	 * Metodo para crear una seccion balanza un detalle seccion balanza y una balanza detalle seccion
	 * @param seccionBalanzaDTO
	 * @param balDetSec
	 * @throws SICException
	 */
	public void creacionBalanza(DetalleSeccionDTO detalleSeccionBalanza, AreaTrabajoDTO areaTrabajoDTO)throws SICException;
	
	/**
	 * Devuelve true si encuentra una balanza que este activa y tenga la direccion ip de la plantilla
	 * @param balDetSecDTO
	 * @return
	 */
	public Boolean existeDetalleBalanza(BalanzaDetalleSeccionDTO balDetSecDTO)throws SICException;
	
	/**
	 * Inactivacion de una balanza
	 * @param detalleSeccionBalanza
	 * @throws SICException
	 */
	public void eliminarDetalleSeccionBalanza(DetalleSeccionDTO detalleSeccionBalanza)throws SICException;
	
	/**
	 * devuelve un detalle del detalle seccion de la balanza si el id conincide con la plantilla
	 * @param balDetSecDTO
	 * @return
	 */
	public BalanzaDetalleSeccionDTO obtenerDetalleBalanza(BalanzaDetalleSeccionDTO balDetSecDTO)throws SICException;
	/**
	 * devuelve un area de trabajo con su codigo establecimiento a partir del id del area de trabajo
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public AreaTrabajoDTO obtenerCodigoEstablecimiento(AreaTrabajoDTO areaTrabajoDTO)throws SICException;
	
	/**
	 * Busca las ubicaciones de balanza por area de trabajo, se puede especificar su codigo de barras para una ubicacion especifica
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoBarrasBalanza
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> buscarUbicacionBalanza(Integer codigoCompania, Integer codigoAreaTrabajo, String codigoBarrasBalanza) throws SICException;
	/**
	 * Metodo para obtener una coleccion de ciudades de ecuador
	 * @param tipoDivisionGeopol
	 * @return
	 * @throws SICException
	 */
	public Collection<DivisionGeoPoliticaDTO> obtenerDivisionesGeopol(String tipoDivisionGeopol)throws SICException;
	
	/**
	 * Devuelve true si el anden ingresado tiene hijos proveedores.
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	public Boolean existeProveedoresAsignados(DetalleSeccionDTO anden)throws SICException;
	/**
	 * 
	 * @param codigoCatalogoTipo
	 * @return
	 * @throws SICException
	 */
	public Collection<CatalogoValorDTO> buscarCatalogoValor(Integer codigoCatalogoTipo)throws SICException;
	
	/**
	 * Perimte alimentar la ubicacion de surtido desde una ubicacion de reserva
	 * @param ubicacionReserva
	 * @param ubicacionSurtido
	 * @throws SICException
	 */
	public void alimentarUbicacionSurtido(AsignacionArticuloUnidadManejoDTO ubicacionReserva, AsignacionArticuloUnidadManejoDTO ubicacionSurtido) throws SICException;
	/**
	 * Vefifica la existencia de pasillos entre la bodega y la subbodega
	 * @param areaPadre
	 * @param areaHijo
	 * @return
	 * @throws SICException
	 */
	public Boolean existeRelacionesNaveSubnave(AreaTrabajoDTO areaPadre, AreaTrabajoDTO areaHijo) throws SICException;
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoBodega
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> consultarDetalleSeccionAreasAreaTrabajo(Integer codigoCompania, Integer codigoBodega)throws SICException;

	/**
	 * Metodo para actualizar la relacion de las ubicaciones y el area a la que pertenecen las areas
	 * @param codigoCompania
	 * @param ususario
	 * @param codigoDetalleArea
	 * @param ubicacionesAreas
	 * @throws SICException
	 */
	public void actualizarUbicacionesAreas(Integer codigoCompania, String ususario, Long codigoDetalleArea, Collection<VistaUbicacionArticuloDTO> ubicacionesAreas, AreaTrabajoDTO bodega, Integer subbodega)throws SICException;
	
	/**
	 *  Valida si la ubicacion rac o pasillo existe con su respectiva jerarquia
	 * @param codigoCompania
	 * @param codigoBodega
	 * @param codigoSubbodega
	 * @param pasillo
	 * @param rack
	 * @param nivel
	 * @return
	 * @throws SICException
	 */
	public Boolean validarUbicacion(Integer codigoCompania, Integer codigoBodega, Integer codigoSubbodega, String pasillo, String rack, String nivel)throws SICException;
	
	/**
	 * Permite consultar ubicaciones con rango de pasillos, rack, o ubicaciones
	 * @param codigoCompania
	 * @param codigoSUbBodega
	 * @param codigoBodega
	 * @param valorRangos
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> consultarUbicacionesPorRango(Integer codigoCompania,Integer codigoBodega,Integer codigoSubBodega 
			,String pasIni,String pasFin,String racIni,String racFin,String nivIni,String nivFin)throws SICException;
//	/**
//	 * Trabajo para migrar la estructura logistica
//	 * @param url
//	 * @throws SICException
//	 */
//	public void migracionEstructuraLogistica(String url)throws SICException;
	/**
	 * 
	 * @param detalleSeccionDTO
	 * @throws SICException
	 */
	public void registrarDetalleSeccion(DetalleSeccionDTO detalleSeccionDTO) throws SICException;
	/**
	 * 
	 * @param detalleSeccionCol
	 * @throws SICException
	 */
	public void registrarDetalleSeccionThread(Collection<DetalleSeccionDTO> detalleSeccionDTOCol,
			CreacionUbicacionTrasient creacionUbicacionUtil) throws SICException;
	
	/**
	 * 
	 * @param seccionDTO
	 * @throws SICException
	 */
	public void registrarSeccionThread(Collection<SeccionDTO> seccionDTOCol,CreacionUbicacionTrasient creacionUbicacionUtil)throws SICException;
	/**
	 * 
	 * @param relacionSeccionDto
	 * @param estado
	 * @throws SICException
	 */
	public void registrarRelacionDetalleSeccionThread(Collection<RelacionSeccionDTO> relacionSeccionDTOCol,
			CreacionUbicacionTrasient creacionUbicacionUtil) throws SICException;
	
	/**
	 * 
	 * @param relacionSeccionDto
	 * @param estado
	 * @throws SICException
	 */
	public void registrarRelacionDetalleSeccion(RelacionSeccionDTO relacionSeccionDto, String estado) throws SICException;
	
	/**
	 * Migracion de ubicaciones
	 * @param url
	 * @throws SICException
	 */
	public void migracionEstructuraLogisticaUbicaciones(String url)throws SICException;
	
	/**
	 * Busca los locales relacionados a un anden
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDetalleSeccionDTO> busquedaAndenLocal(DetalleSeccionDTO anden)throws SICException;
	
	/**
	 * Metodo para verificar que existe locales asignados al anden
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	public Boolean existeLocalesAsignados(DetalleSeccionDTO anden)throws SICException;
	
	/**
	 * Metodo para actualizar la relacion de local con anden
	 * @param localDet
	 * @throws SICException
	 */
	public void actualizarRelacionLocalDetalle(AreaTrabajoDetalleSeccionDTO localDet) throws SICException;
	/**
	 * metodo para actualizar varias relaciones de locales
	 * @param localDetCol
	 * @throws SICException
	 */
	public void actualizarRelacionesLocalDetalle(Collection<AreaTrabajoDetalleSeccionDTO> localDetCol) throws SICException;
	
	/**
	 * 
	 * @param localDetSecCol
	 * @throws SICException
	 */
	public void asignacionAndenesLocal(Collection<AreaTrabajoDetalleSeccionDTO> localDetSecCol)throws SICException;
	
	/**
	 * Metodo para la migracion de los andenes con locales relacionados
	 * @param url
	 * @throws SICException
	 */
	public void migracionEstructuraLogisticaAndenes(String url)throws SICException;
	
	/**
	 * Metodo para obtener la nave de una ubicacion en especifico
	 * @param codigoCompania
	 * @param codigoDetalleSeccionUbicacion
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO obtenerNaveUbicacion(Integer codigoCompania, Long codigoDetalleSeccionUbicacion,Integer codigoAreaTrabajoPadre,Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 * Metodo para obtener la subnave de una ubicacion en especifico
	 * @param codigoCompania
	 * @param codigoDetalleSeccionUbicacion
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO obtenerSubNaveUbicacion(Integer codigoCompania, Long codigoDetalleSeccionUbicacion,Integer codigoAreaTrabajoPadre,Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 * Metodo para obtener los adenes compartidos de la misma ciudad para la bodega seleccionada 
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> obtenerAndenesCompartidos(AreaTrabajoDTO areaTrabajoDTO, Integer cdtFiltro, Integer bodegaFiltro, String andenFiltro)throws SICException;
	
	/**
	 * @param detalleSeccionDTOCom
	 * @param areaTrabajoVO
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	DetalleSeccionDTO registrarAndenCompartido(DetalleSeccionDTO detalleSeccionDTOCom, AreaTrabajoVO areaTrabajoVO, String userId) throws SICException;
	/**
	 * 	
	 * @param codigoCompania
	 * @param codigoBodega
	 * @param codigoSubBodega
	 * @param filterUbicacion
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaUbicacionArticuloDTO> buscarUbicacionesFiltradas(Integer codigoCompania,Integer codigoBodega,Integer codigoSubBodega,HashMap<EnumValorFiltrosUbicacion, Object> filterUbicacion,EnumValorFiltrosUbicacion enumValorFiltrosUbicacion)throws SICException;

	/**
	 * busqueda de ubicaciones por filtros 
	 * @param datosGsonSlickGridReg
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaUbicacionArticuloDTO> busquedaUbicacionesFiltros(Integer codigoAreaTrabajoBOD, Integer codigoAreaTrabajoSUB, Integer firstResult, Integer maxResults, HashMap<EnumValorFiltrosUbicacion, Object> filtros)throws SICException;
	
	/**
	 * 
	 * @param caracteristicaProcesoAreaTrabajoDTO
	 * @throws SICException
	 */
	public void modificarCaracteristicasAreatrabajo(CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTO)throws SICException;
	/**
	 * 
	 * @param caracteristicaProcesoAreaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public CaracteristicaProcesoAreaTrabajoDTO buscarCaracteristica(CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTO)throws SICException;
	
	/**
	 * migracion de la estructura logistica
	 * @param mAEL
	 * @throws SICException
	 */
	public void migracionUbicaciones(MigracionEstructuraLogisticaUbicacionesDTO mAEL, Boolean bandera)throws SICException;
	
	/**
	 * Integra las ubicaciones pendientes
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void integrarUbicacionesPendientes(Integer codigoCompania)throws SICException;
	
}
