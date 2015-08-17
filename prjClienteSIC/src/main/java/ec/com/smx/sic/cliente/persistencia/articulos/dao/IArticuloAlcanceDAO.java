package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.ScrollableResults;

import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.corpv2.vo.GrupoTrabajoVO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaGrupoAlcanceLocalDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceEST;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceIntegracionTransient;
import ec.com.smx.sic.cliente.mdl.nopersistente.PrototipoArticuloTrasient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface IArticuloAlcanceDAO {

	/**
	 * Obtiene una lista de areasTrabajo por asignar y una lista de areasTrabajo
	 * para desactivar
	 * @param grupoTrabajoDTO
	 * @param areasAsignar
	 * @param areasDesactivar
	 * @param areasActivar
	 * @param fechaAplicacion
	 * @throws SICException
	 */
	public abstract void actualizarGrupoAlcance(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, Collection<GrupoAreaTrabajoDTO> areasAsignar, Collection<GrupoAreaTrabajoDTO> areasDesactivar, Collection<GrupoAreaTrabajoDTO> areasActivar,Timestamp fechaAplicacion,String codigoFuncionario)throws SICException;

	//public abstract Collection<GrupoAreaTrabajoDTO> obtenerGrupoAreasTrabajoInactivas(GrupoTrabajoDTO grupoTrabajoDTO, Collection<GrupoAreaTrabajoDTO> grupoAreaTrabajoCol);

	/**
	 * Desactiva las areas de trabajo
	 * @param grupoTrabajoDTO
	 * @param areasDesactivar
	 * @param fechaAplicacion
	 */
	public abstract void desactivarGrupoAreasTrabajo(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, Collection<GrupoAreaTrabajoDTO> areasDesactivar, Timestamp fechaAplicacion,String codigoFuncionario);

	/**
	 * Permite direccionar si los articulos de la tabla SCSADTARTLOC, van a ser activados i inactivados
	 * @param grupoTrabajoDTO
	 * @param areaAsignar
	 * @param fechaAplicacion
	 */
	public abstract void activarInactivarArticulosEnLocal(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, GrupoAreaTrabajoDTO areaAsignar, Timestamp fechaAplicacion,String codigoFuncionario)throws SICException;

	/**
	 * Actualiza el estado del alcance de los articulos-local por local
	 * @param codigoAreaTrabajo
	 * @param estado
	 * @param userId
	 * @param fechaAplicacion
	 */
	public abstract void actualizarEstadoArticuloLocal(ArticuloVO articuloVO, String estado, Integer notificarLocal, Integer aperturaLocal,long codigoGrupoTrabajo)throws SICException;

	/**
	 * Inserta las areas de trabajo al prototipo
	 * @param grupoTrabajoDTO
	 * @param areasAsignar
	 * @param fechaAplicacion
	 */
	public abstract void insertarAreasTrabajoPrototipo(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, Collection<GrupoAreaTrabajoDTO> areasAsignar,Timestamp fechaAplicacion,String codigoFuncionario,Integer codigoCompania)throws SICException;

	/**
	 * Permite insertar los articulos que pertenecen al prototipo enviado a la tabla de relacion SCSADTARTLOC
	 * @param grupoTrabajoDTO
	 * @param areaAsignar
	 * @param fechaAplicacion
	 */
	public abstract void insertarArticulosEnLocal(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, GrupoAreaTrabajoDTO areaAsignar,Timestamp fechaAplicacion,String codigoFuncionario,Integer codigoCompania)throws SICException;

	/**
	 * Activa las areas de trabajo al prototipo
	 * @param grupoTrabajoDTO
	 * @param areasActivar
	 * @param fecha
	 */
	public abstract void activarAreasTrabajoPrototipo(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, Collection<GrupoAreaTrabajoDTO> areasActivar,Timestamp fecha,String codigoFuncionario,Integer codigoCompania);

	/**
	 * Permite copiar los articulos de un local base a otro local
	 * @param prototipoAlcanceVO
	 * @throws SICException
	 */
	public abstract void copiarLocal(ArticuloVO articuloVO) throws SICException;
	
	/**
	 * Permite direccionar si los articulos de la tabla SCSADTARTLOC, van a ser activados o inactivados de forma masiva
	 * @param grupoTrabajoDTO
	 * @param areaAsignar
	 * @param fechaAplicacion
	 */
	public abstract void activarInactivarArticulosEnLocalMasivo(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, GrupoAreaTrabajoDTO areaAsignar,Timestamp fechaAplicacion,String codigoFuncionario,Integer codigoCompania)throws SICException;
	
	
	/**
	 * Permite a\u00F1adir, quitar, remplazar articulos de los locales masivamente
	 * @param articuloCol
	 * @param articuloVO
	 */
	public abstract void asignarQuitarRemplazarMasivaArticulosLocales(List<? extends ArticuloDTO> articuloCol, ArticuloVO articuloVO)throws SICException;
	
	/**
	 * Permite cambiar el articulo al prototipo de coincidencia atravez de la combinacion de ariticuloLocal sea igual a la vista de grupoAlcance
	 * @param prototipoArticuloTrasients
	 * @param fechaAplicacion
	 * @throws SICException
	 */
	public void actualizarPrototipoArticulo(Collection<PrototipoArticuloTrasient> prototipoArticuloTrasients, Timestamp fechaAplicacion,String userId,String codigoFuncionario,String opcionAsignacionAlcance,Integer codigoCompania)throws SICException;
	
	/**
	 * Permite actualizar masivamente los articulo-local que se comunicaron con exito o error al SIC
	 * @param articuloLocalCol
	 * @param estado
	 * @param userId
	 */
	public void cambiarEstadoIntegracionArticuloLocal(Collection<ArticuloLocalDTO> articuloLocalCol,Integer codigoLocal, String estado, String userId,String opcionTipoAsignacionAlcance,Integer codigoCompania)throws SICException;
	
	/**
	 * Permite insertar la bitacora de activacion o desactivacion de alcances
	 * @param fechaAplicacion
	 */
	public void insertarBitacoraArticuloAreaTrabajo(Timestamp fechaAplicacion,String opcionTipoAsignacionAlcance,Integer codigoCompania, String codigoArticulo)throws SICException;
	
	/**
	 * Permite activar e inactivar alcances dependiendo de las fechas
	 * @param fechaActual
	 * @param fechaActualTime
	 * @param tipoAreaTrabajo
	 * @throws SICException
	 */
	public void activarDesactivarArticulosAlcance(String fechaActual, String fechaActualTime, String tipoAreaTrabajo, String estado,Integer codigoCompania)throws SICException;
	
	/**
	 *  Permite actualizar masivamente los articulo-bodega que se comunicaron con exito o error al SIC
	 * @param articuloBodegaCol
	 * @param estado
	 * @param userId
	 * @throws SICException
	 */
	public void cambiarEstadoIntegracionArticuloBodega(Collection<ArticuloLocalDTO> articuloBodegaCol, String estado, String userId,Integer codigoCompania)throws SICException;
	
	/**
	 * Permite asignar alcance del articulo a los locales
	 * @param articuloVO
	 * @param articuloLocalCol
	 * @throws SICException
	 */
	public void asignarArticuloAlcanceLocal(ArticuloVO articuloVO, Collection<ArticuloLocalDTO> articuloLocalCol)throws SICException; 
	
	/**
	 * Permite asignar alcance del articulo a las bodegas
	 * @param articuloVO
	 * @param articuloBodegaCol
	 * @throws SICException
	 */
	public void asignarArticuloAlcanceBodega(ArticuloVO articuloVO, Collection<ArticuloLocalDTO> articuloBodegaCol)throws SICException; 
	
	/**
	 * Permite actualizar el prototipo de los articulos que se dio alcance
	 * @param userId
	 * @param articuloLocalESTCol
	 * @param fechaAplicacion
	 */
	public void actualizarPrototipoAlcance(String userId, Collection<ArticuloAlcanceEST> articuloLocalESTCol, Timestamp fechaAplicacion,String codigoFuncionario,String opcionAsignacionAlcance,Integer codigoCompania)throws SICException;
	
	/**
	 * Permite incativar todos los articulos que pertenecen a un local o bodega
	 * @param articuloVO
	 * @param cadenaLocales
	 * @param cadenaArticuloAreatrabajo
	 * @throws SICException
	 */
	public void remplazarArticulosLocalesMasivo(ArticuloVO articuloVO,String cadenaLocales,String cadenaArticulos,String cadenaArticuloAreatrabajoNoQuit, Integer notificarLocal, Integer aperturaLocal,Long cadenaArticuloAreatrabajo) throws SICException;
	
	/**
	 * Permite actualizar la tabla sspcotaresublugtra
	 * dependiendo de los alcances
	 * @param userId
	 * @param codigosBodega
	 * @param estadoSet
	 * @param fechaAplicacion
	 * @param opcionTipoAsignacionAlcance
	 * @param codigoArticulo
	 * @throws SICException
	 */
	public void actualizacionSubbodegas(String userId, String codigosBodega, String estadoSet, Timestamp fechaAplicacion,String opcionTipoAsignacionAlcance,String codigoArticulo,Integer codigoCompania)throws SICException;
	
	public void insertarCodigoBarrasNoExistentesMigracion(String codigoBarras)throws SICException;
	/**
	 * pPermite registrar alcances temporales
	 * @param articuloVO
	 * @throws SICException
	 */
	public void registrarAlcanceTemporal(ArticuloVO articuloVO)throws SICException;
	/**
	 *  Permite registrar el alcance a las bodegas padres de una subbodega especifica
	 * @param articuloVO
	 * @param codigosCDPredeterminados
	 * @throws SICException
	 */
	public void registrarAlcanceBodegasSubbodega(ArticuloVO articuloVO,Collection<Integer> codigosAreaTrabajo) throws SICException;
	/**
	 * Retorna los codigos de los CD predeterminados para dar alcance a las bodegas
	 * @return
	 * @throws SICException
	 */
	public String obtenerCodigosCDSPredeterminadosAlcance(Integer codigoCompania)throws SICException;
	
	/**
	 * Retorna el codigo de sublugar de trabajo del articulo
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerCodigoAreaSublugarTrabajo(Integer codigoCompania, String codigoClasificacion)throws SICException;
	
	/**
	 * Permite actualizar el estado de los locales de un prototipo seleccionado
	 * @param estadoGrupoAreaTrabajo
	 * @param codigoGrupoTrabajo
	 * @param usuarioModificacion
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void actualizarRelacionGrupoTrabajoAreaTrabajo(String estadoGrupoAreaTrabajo,long codigoGrupoTrabajo,String usuarioModificacion,Integer codigoCompania)throws SICException;
	
	/**
	 * Permite cambiar el estado de integracion del alcance a travez de los estados de error que retorna el sic
	 * @param alcanceIntegracionTransients
	 * @param opcionTipoAsignacionAlcance
	 * @throws SICException
	 */
	public void cambiarEstadoIntegracionArticuloLocal(Collection<ArticuloAlcanceIntegracionTransient> alcanceIntegracionTransients, String opcionTipoAsignacionAlcance)throws SICException;

	/**
	 * Permite registrar alcance a los locales de un prototipo
	 * @param articuloVO
	 */
	public void insertarAlcancePorPrototipo(ArticuloVO articuloVO)throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoLocal
	 * @return
	 * @throws SICException
	 */
	public Boolean consultarExistenciaAlcanceArticulo(Integer codigoCompania, String codigoArticulo, Integer codigoLocal) throws SICException;
	
	/**
	 * 
	 * @param cadenaCodigosArticulos
	 * @param codigoLocal
	 * @param estado
	 * @param userId
	 * @param nombreTabla
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void cambiarEstadoIntegracionAlcances(StringBuilder cadenaCodigosArticulos, Integer codigoLocal, String estado, String userId,String nombreTabla,Integer codigoCompania)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param tipAreaTrab
	 * @param aperturaLocal
	 * @return
	 * @throws SICException
	 */
	public Integer countAlcancesSinIntegrar(Integer codigoCompania,String tipAreaTrab, String aperturaLocal) throws SICException;
	
	/**
	 * 
	 * @param refProt
	 * @param codLoc
	 * @return
	 * @throws SICException
	 */
	public Collection<Object[]> validarPrototiposLocales(Collection<String> refProt,Collection<Integer> codLoc) throws SICException;
	
	/**
	 * Activamos e inactivamos los establecimientos dependiendo de los alcances
	 * @param userId
	 * @param cadenasCodigosArticulos
	 * @param fechaAplicacion
	 * @throws SICException
	 */
	public void activarDesactivarArticulosMasivoEstablecimientos(String userId,String cadenasCodigosArticulos, Timestamp fechaAplicacion)throws SICException;
	
	/**
	 * Insertamos los establecimientos dependiendo de los alcances
	 * @param userId
	 * @param cadenasCodigosArticulos
	 * @param fechaAplicacion
	 * @throws SICException
	 */
	public void insertarArticulosMasivoEstablecimientos(String userId, String cadenasCodigosArticulos, Timestamp fechaAplicacion)throws SICException;
	
	/**
	 * Permite inactivar los alcances del prototipo anterior que no existen en el prototipo actual
	 * @param codigoCompania
	 * @param userId
	 * @param fechaAplicacion
	 * @param codigoSistema
	 * @param codigoOpcion
	 * @param codigoArticulo
	 * @param codigoGrupoAlcance
	 * @param areaTrabajoCol
	 * @throws SICException
	 */
	public void inactivarAlcancesCambioPrototipo(Integer codigoCompania, String userId, Timestamp fechaAplicacion, String codigoSistema, String codigoOpcion, String codigoArticulo, Long codigoGrupoAlcance, Collection<AreaTrabajoDTO> areaTrabajoCol)throws SICException;
	
	/**
	 * Permite activar los alcances del prototipo anterior que existen en el prototipo actual
	 * @param codigoCompania
	 * @param userId
	 * @param fechaAplicacion
	 * @param codigoSistema
	 * @param codigoOpcion
	 * @param codigoArticulo
	 * @param codigoGrupoAlcance
	 * @param areaTrabajoCol
	 * @throws SICException
	 */
	public void activarAlcancesCambioPrototipo(Integer codigoCompania, String userId, Timestamp fechaAplicacion, String codigoSistema, String codigoOpcion, String codigoArticulo, Long codigoGrupoAlcance, Collection<AreaTrabajoDTO> areaTrabajoCol)throws SICException;
	
	/**
	 * Permite insertar los alcances del prototipo actual que no existen en el prototipo anterior
	 * @param codigoCompania
	 * @param userId
	 * @param fechaAplicacion
	 * @param codigoSistema
	 * @param codigoOpcion
	 * @param codigoArticulo
	 * @param codigoGrupoAlcance
	 * @param areaTrabajoCol
	 * @throws SICException
	 */
	public void insertarAlcancesCambioPrototipo(Integer codigoCompania, String userId, Timestamp fechaAplicacion, String codigoSistema, String codigoOpcion, String codigoArticulo, Long codigoGrupoAlcance, Collection<AreaTrabajoDTO> areaTrabajoCol)throws SICException;

	/**
	 * Permite consultar oficinas para la asignacion de articulos
	 * @param tipoAreaTrabajo
	 * @param codigoCompania
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> consultarOficinas(String tipoAreaTrabajo, Integer codigoCompania)throws SICException;
	
	/**
	 * Permite consultar los CD y bodegas para la asignacion de articulos
	 * @param tipoAreaTrabajo
	 * @param codigoCompania
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> consultarBodegas(String tipoAreaTrabajo, Integer codigoCompania) throws SICException;

	/**
	 * @param articuloVO
	 * @return lista de areas de trabajo a las que el articulo tiene alcance
	 * @throws SICException
	 */
	public Collection<ArticuloLocalDTO> consultarAreasTrabajoAsignadas(ArticuloDTO articuloDto, String tipoAreaTrabajo, Boolean validarEstado)throws SICException;
	
	/**
	 * @param articuloVO
	 * @return lista de areas de trabajo
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerAreasTrabajo()throws SICException;

	/**
	 * @param articuloDto
	 * @param tipoAreaTrabajo
	 * @throws SICException
	 */
	public Collection<ArticuloLocalDTO> obtenerBodegasParaCentroDistribucion(ArticuloDTO articuloDto, String tipoAreaTrabajo)throws SICException;
	
	/**
	 * @param codigosBodegas
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> obtenerCentrosDeDistribucionConEstados(Set<Integer> codigosBodegas)throws SICException;
	
	/**
	 * Permite obtener los datos de Bodega
	 * @param codigoCompania Codigo de la compania
	 * @param codigoBodega Codigo de la bodega
	 * @return lista de Bodegas
	 * @throws SICException
	 */
	public Collection<BodegaDTO> obtenerBodegasPorCodigoBodega(Integer codigoCompania, String codigoBodega)throws SICException;
	
	public ScrollableResults scrollArticuloLocal(ArticuloLocalDTO articuloLocal, Integer maxResults);
	
	public ParametroDTO consultarPrototiposANoAsignar()throws SICException;
	
	public Collection<ArticuloLocalDTO> consultarLocalesArticulo(Integer codigoCompania, String codigoArticulo)throws SICException;
	
	public void modificarPrototipoAlcance(Integer codigoCompania,String codigoArticulo,String userID,Timestamp fechaAplicacion,Collection<VistaGrupoAlcanceLocalDTO> vistaGrupoAlcanceLocalDTOs)throws SICException;
	
	public Collection<ArticuloLocalDTO> consultarAlcancesPorLocal(Integer codigoCompania, Integer codigoLocal,String tipoAreaTrabajo,String codigoFuncionario)throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoSubBod
	 * @return Lista de bodegas padre dependiendo del codigo de subbodega
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> obtenerBodegaPorCodigoSubBodega(Integer codigoCompania, Integer codigoSubBod) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @return Lista de establecimientos
	 * @throws SICException
	 */
	public Collection<EstablecimientoDTO> obtenerEstablecimientos(Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param fechaAplicacion
	 * @return Articulos agrupados que cumplan con la restriccion de fechaAplicacion
	 * @throws SICException
	 */
	public Collection<ArticuloLocalDTO> consultarAlcancesModificados(Timestamp fechaAplicacion)throws SICException;
	
	/**
	 * Obtener los grupos de trabajo dados por los filtros en GrupoTrabajoVO
	 * @param grupoTrabajoVO
	 * @return Lista de Grupos de Trabajo
	 * @throws SICException
	 */
	public Collection<GrupoTrabajoDTO> obtenerGruposTrabajo(GrupoTrabajoVO grupoTrabajoVO) throws SICException;
	
	/**
	 * Permite insertar la bitacora de alcances correspondientes a aquellos donde se presento error en la asignacion
	 * @param articuloVO
	 * @param codigoArticulo
	 * @param errorMsg
	 * @throws SICException
	 */
	public void insertarBitacoraArticuloAreaTrabajoError(ArticuloVO articuloVO, String codigoArticulo, String errorMsg) throws SICException;
	
	/**
	 * Permite obtener los registros ArticuloAreaTrabajoBitacoraDTO que se generaron por error de asignacion de alcances
	 * @param articuloVO
	 * @param sufijoAreaTrabajo
	 * @return Lista de registros ArticuloAreaTrabajoBitacoraDTO
	 * @throws SICException
	 */
	public Collection<ArticuloAreaTrabajoBitacoraDTO> obtenerArticuloAreaTrabajoBitacoraError(ArticuloVO articuloVO, String sufijoAreaTrabajo) throws SICException;
	
	public void inactivarAlcancesPrototipo(Collection<Integer> codigoAreaTrabajoCol,String codigoArticulo,String sufAreaTrabajo,
			String estado,Integer codigoCompania, String userId, Timestamp fechaAplicacion, String codigoSistema, String codigoOpcion)throws SICException;
	
	
	public void quitarAlcancesAsignacionMasiva(String nameTable,String accessItemId,String systemId,String userId,Timestamp fechaAplicacion,String cadenaArticuloAreatrabajoNoQuit
			,String notificarLocal, String aperturaLocal,Long codigoArticuloAreatrabajo,Boolean isRemplazarAlcances,Date fechaFinAlcance)throws SICException;
	
	public void actulaizarArticuloEstablecimientoPrototipo(ArticuloVO articuloVO)throws SICException;
	
	/*
	 * Metodos que se utilizan en la base de datos no relacional orienDB
	 * */
	
	/**
	 * Obtiene una colecci&oacute;n con el ArticuloLocalDTO ordernado por el total de registros que tiene en la tabla {@link ArticuloLocalDTO}
	 * @param codigoCompania
	 * @param sufijoTabla
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloLocalDTO> obtenerColArticuloLocalDTO (Integer codigoCompania, String sufijoTabla) throws SICException;
	
	/**
	 * 
	 * @param sufijoTabla
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param colCodigoArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloAreaTrabajoBitacoraDTO> obtenerColArticuloAreaTrabajoBitacoraDTO (String sufijoTabla, Integer codigoCompania, Integer codigoLocal, String ... colCodigoArticulo) throws SICException;
	
	Collection<AreaTrabajoDTO> consultarDatosAreaTrabajo(Integer codigoCompania, Integer ... colCodigoAreaTrabajo) throws SICException;

	/**
	 * Busca el prototipo que coincida con una combinacion de locales en la vista de prototipos de alcances de locales (SCSADVPROALCLOC)
	 * @param codigoCompania
	 * @param combinacionLocales : Locales separados por coma en orden ascendente
	 * @return Object[] : [codigoGrupoTrabajo,areasTrabajo]
	 * @author bymontesdeoca
	 * @throws SICException
	 */
	Object[] searchLocalesInVistaPrototipoAlcanceLocal(Integer codigoCompania,String combinacionLocales) throws SICException;
	
	public abstract void updateGrupoAlcanceArticulo(Integer codigoCompania,Integer codigoGrupoAlcance,List<String> setCodArticulos,Timestamp fechaAplicacion,String userActualizacion) throws SICException;

	Set<String> getArticulosPruebaAlcance() throws SICException;
	
	Map<String,Integer> getMapVistaPrototipoAlcance(Integer codigoCompania) throws SICException; //clave: combinacion locales, valor:codigoGrupoAlcance
	
	Map<Integer,Integer> getMapLocalEstablecimiento(Integer codigoCompania) throws SICException; //clave: codigoLocal, valor: codigoEstablecimiento 
}