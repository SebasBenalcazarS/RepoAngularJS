package ec.com.smx.sic.cliente.gestor.bodega.administracion.almacenamiento;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.bodega.EnumValorFiltrosUbicacion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoDetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.MigracionEstructuraLogisticaUbicacionesDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaUbicacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.CreacionUbicacionTrasient;

public interface IAlmacenamientoEstructuraLogisticaGestor {
	
	/**
	 * Metodo para crear ubicaciones fisicas masivamente
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
	 * Metodo para registrar una nueva seccion (Andenes, Naves, Areas, Ubicaciones, Pasillos)
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
	 * Metodo para inactivar una seccion (Andenes, Naves, Areas, Ubicaciones, Pasillos)
	 * @param seccionDTO
	 * @throws SICException
	 */
	public void eliminarSeccion(SeccionDTO seccionDTO) throws SICException;
	/**
	 * Metodo para inactivar el pasillo con sus padres nave, subnave y anden
	 * @param detalleSeccionDTO
	 * @param relacionSeccionDTO
	 * @throws SICException
	 */
	public void eliminarDetalleSeccionRelacionSeccion(DetalleSeccionDTO detalleSeccionDTO) throws SICException;
	/**
	 * Metodo para inactivar un detalle de una seccion especifica
	 * @param seccionDTO
	 * @throws SICException
	 */
	public void actualizarDetalleSeccion(DetalleSeccionDTO detalleSeccionDTO) throws SICException;
	/**
	 * Metodo para inactivar la relacion de detalleSeccion con seccion
	 * @param relacionSeccionDTO
	 * @throws SICException
	 */
	public void eliminarRelacionSeccion(RelacionSeccionDTO relacionSeccionDTO) throws SICException;
	/**
	 * Metodo que permite registrar la relacion DetalleSeccion con Seccion 
	 * @param detalleSeccionHijosDTOs
	 * @param codigoDetalleSeccionPadre
	 * @throws SICException
	 */
	public void registrarRelacionDetalleSeccion(Collection<DetalleSeccionDTO> detalleSeccionHijosDTOs, Long codigoDetalleSeccionPadre) throws SICException;
	/**
	 * Metodo que permite guardar una nueva area de trabajo y su relacion con subarea
	 * @param areaTrabajoDTO
	 * @param codigoAreaTrabajoPadre
	 * @return
	 * @throws SICException
	 */
	public AreaSublugarTrabajoDTO guardarAreaTrabajo(AreaTrabajoDTO areaTrabajoDTO, Integer codigoAreaTrabajoPadre, Collection<SeccionDTO> secciones)throws SICException;
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
	 * Permite buscar ubicaciones virtuales
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
	 * permite actualizar la cantidad de articulo en una ubicacion
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
	 * @param subBodegaDTOCol
	 * @param areaTrabajoDTO
	 * @param codigoCompania
	 * @param userID
	 * @throws SICException
	 */
	public void agregarSubBodegas(Collection<BodegaDTO> subBodegaDTOCol,AreaTrabajoDTO areaTrabajoDTO,Integer codigoCompania,String userID)throws SICException;
	/**
	 * Insercion o actualizacion de la relacion entre el proveedor y el anden
	 * @param provDetSec
	 * @throws SICException
	 */
	public void asignacionAndenesProveedor(Collection<ProveedorDetalleSeccionDTO> provDetSecCol)throws SICException;
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
	 * Inactivacion de una balanza
	 * @param detalleSeccionBalanza
	 * @throws SICException
	 */
	public void eliminarDetalleSeccionBalanza(DetalleSeccionDTO detalleSeccionBalanza)throws SICException;
	
	/**
	 * Metodo para crear una seccion balanza un detalle seccion balanza y una balanza detalle seccion
	 * @param seccionBalanzaDTO
	 * @param balDetSec
	 * @throws SICException
	 */
	public void creacionBalanza(DetalleSeccionDTO detalleSeccionBalanza, AreaTrabajoDTO areaTrabajoDTO)throws SICException;
	/**
	 * 
	 * @param codigoCatalogoTipo
	 * @return
	 * @throws SICException
	 */
	public Collection<CatalogoValorDTO> buscarCatalogoValor(Integer codigoCatalogoTipo)throws SICException;
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
	
//	/**
//	 * Migracion estructura logistica
//	 * @param url
//	 * @throws SICException
//	 */
//	public void migracionEstructuraLogistica(String url)throws SICException;
	
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
	public void registrarSeccionThread(Collection<SeccionDTO> seccionDTOCol,
			CreacionUbicacionTrasient creacionUbicacionUtil)throws SICException;
	/**
	 * 
	 * @param relacionSeccionDto
	 * @param estado
	 * @throws SICException
	 */
	public void registrarRelacionDetalleSeccionThread(Collection<RelacionSeccionDTO> relacionSeccionDTOCol,
			CreacionUbicacionTrasient creacionUbicacionUtil) throws SICException;
	
	/**
	 * Registra la relacion detalle seccion para los andenes compartidos
	 * @param relacionSeccionDto
	 * @param estado
	 * @throws SICException
	 */
	public void registrarRelacionDetalleSeccion(RelacionSeccionDTO relacionSeccionDto, String estado) throws SICException;
	
	
	/**
	 * Migracion de las ubicaciones
	 * @param url
	 * @throws SICException
	 */
	public void migracionEstructuraLogisticaUbicaciones(String url)throws SICException;
	/**
	 * Creacion de la unidad de manejo
	 * @param userId
	 * @param cantidad
	 * @param codigoArticulo
	 * @param codigoCompania
	 * @param codigoDetalleSeccion
	 * @param codigoUnidadManejo
	 */
	public void crearRelacionUnidadManejo(String userId, Integer cantidad, String codigoArticulo, Integer codigoCompania, Long codigoDetalleSeccion, Long codigoUnidadManejo, Timestamp fechaCaducidad, Date fechaRecepcion);
	/**
	 * Metodo para actualizar la relacion de local con anden
	 * @param localDet
	 * @throws SICException
	 */
	public void actualizarRelacionLocalDetalle(AreaTrabajoDetalleSeccionDTO localDet) throws SICException;
	/**
	 * actualizacion de la relacion con el local y el anden
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
	 * Metodo para crear o actualizar la relacion con el anden y local
	 * @param localDetSec
	 * @throws SICException
	 */
	public void asignacionAndenLocal(AreaTrabajoDetalleSeccionDTO localDetSec)throws SICException;
	
	/**
	 * Metodo para migrar andenes con locales relacionados
	 * @param url
	 * @throws SICException
	 */
	public void migracionEstructuraLogisticaAndenes(String url)throws SICException;
	
	/**
	 * metodo para registrar un detalle seccion.
	 * NO USAR SI EL DETALLE NO TIENE REGISTRADA LA SECCION ANTERIORMENTE
	 * @param detalleSeccionDTO
	 * @throws SICException
	 */
	public void registrarDetalleSeccion(DetalleSeccionDTO detalleSeccionDTO) throws SICException ;
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
	 *  Integra las ubicaciones pendientes
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void integrarUbicacionesPendientes(Integer codigoCompania) throws SICException;
}
