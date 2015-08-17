/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.administracion.calculo;

import java.util.Collection;
import java.util.HashMap;

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
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaUbicacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.SeccionVO;

/**
 * @author jdvasquez
 *
 */
public interface ICalculoAlmacenamientoEstructuraLogisticaGestor {
	/**
	 * Permite obtener una coleccion de areas de trabajo en base a los parametros ingresados en la plantilla
	 * @param areaTrabajoVO
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<AreaTrabajoDTO> obtenerAreasTrabajo(AreaTrabajoVO areaTrabajoVO) throws SICException;
	/**
	 * Metodo para obtener las areas de trabajo para la estructura logistica
	 * @param areaTrabajoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> buscarAreasTrabajo(AreaTrabajoVO areaTrabajoVO)throws SICException;
	/**
	 * Retorna una coleccion de areas sublugar de trabajo que esten relacionadas con una area de trabajo especifica 
	 * @param codigoAreaTrabajo
	 * @param tipoRelacion puede ser JER(Jerarquica) o (SBL) Sublugar Trabajo
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<AreaSublugarTrabajoDTO> obtenerAreasSublugarTrabajo(Integer codigoAreaTrabajo, String tipoRelacion)throws SICException;
	
	/**
	 * Retorna una coleccion de areas sublugar de trabajo que esten relacionadas con una area de trabajo especifica 
	 * @param codigoAreaTrabajo
	 * @param tipoRelacion puede ser JER(Jerarquica) o (SBL) Sublugar Trabajo
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<AreaSublugarTrabajoDTO> buscarAreasSublugarTrabajo(AreaSublugarTrabajoDTO areaSublugarTrabajoDTO,String tipoAreaTrabajoContar)throws SICException;
	
	/**
	 * retorna una coleccion de areas sublugar de trabajo de las bodegas que estan relacionadas con la subbodega ingresada
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> buscarBodegasSubbodega(AreaTrabajoDTO areaTrabajoDTO)throws SICException;
	/**
	 * Retorna una seccion con su respectiva coleccion de detalle de secciones filtradas en base a una plantilla pasada como parametro
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
	 * Obtiene el catalogo valor de tipo bodega en areas de trabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<CatalogoValorDTO> obtenerCatalogoValorTipoBodega() throws SICException;
	/**
	 * Permite obtener una coleccion de relaciones de areas de trabajo
	 * @param areaSubLugarTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> obtenerAreasSublugarTrabajo(AreaSublugarTrabajoDTO areaSubLugarTrabajoDTO) throws SICException;
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
	 *  Devuelve una coleccion de articulos en base a una plantilla
	 * @param articuloDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> buscarArticulos(ArticuloDTO articuloDTO, String codigoFuncionario)throws SICException;
	/**
	 * devuelve una coleccion de unidades de manejo en base a un articulo
	 * @param articuloDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloUnidadManejoDTO> buscarUnidadesManejo(ArticuloDTO articuloDTO)throws SICException;
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
	 * Permite buscar las ubciaciones virtuales de una ubicacion
	 * @param detalleSeccionDTO
	 * @return
	 */
	public Collection<DetalleSeccionDTO> obtenerUbicacionesVirtuales(DetalleSeccionDTO detalleSeccionDTO)throws SICException;
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
	 * valida que el pasillo existe en una subnave
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
	 * Busca los locales relacionados a un anden
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDetalleSeccionDTO> busquedaAndenLocal(DetalleSeccionDTO anden)throws SICException;
	
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
	 * Busqueda de proveedores relacionados a un detaleSeccion anden 
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	public Collection<ProveedorDetalleSeccionDTO> busquedaAndenProveedor(DetalleSeccionDTO anden)throws SICException;
	
	/**
	 * Busqueda de carcteristicas
	 * @param caracteristicaProcesoAreaTrabajoDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<CaracteristicaProcesoAreaTrabajoDTO> buscarCaracteristicas(CaracteristicaProcesoAreaTrabajoDTO caracteristicaProcesoAreaTrabajoDTOs)throws SICException;
	
	/**
	 * Devuelve true si encuentra una balanza que este activa y tenga la direccion ip de la plantilla
	 * @param balDetSecDTO
	 * @return
	 */
	public Boolean existeDetalleBalanza(BalanzaDetalleSeccionDTO balDetSecDTO)throws SICException;
	
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
	 * Vefifica la existencia de pasillos entre la bodega y la subbodega
	 * @param areaPadre
	 * @param areaHijo
	 * @return
	 * @throws SICException
	 */
	public Boolean existeRelacionesNaveSubnave(AreaTrabajoDTO areaPadre, AreaTrabajoDTO areaHijo) throws SICException;
	
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
	/**
	 * Metodo para buscar un articulo con su unidad de mandejo 
	 * @param valorUniMan
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> buscarArticulo(Integer valorUniMan, String codigoBarras)throws SICException;
	
	/**
	 * Metodo para verificar que existe locales asignados al anden
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	public Boolean existeLocalesAsignados(DetalleSeccionDTO anden)throws SICException;
	/**
	 * Metodo para obtener un detalle seccion por identificador
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param identificador
	 * @param valorTipoSeccion
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO obtenerDetalleSeccionPorIdentificador(Integer codigoCompania, Integer codigoAreaTrabajo, String identificador, String valorTipoSeccion)throws SICException;
	
	/**
	 * Metodo para obtener el area de una ubicacion
	 * @param seccionDTO
	 * @param codigoDetalleHijo
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO obtenerAreaUbicacion(SeccionDTO seccionDTO, Long codigoDetalleHijo)throws SICException;
	
	/**
	 * Metodo que obtiene un area de trabajo por medio del codigo de referencia y el tipo de area
	 * @param areaTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	public AreaTrabajoDTO obtenerAreaTrabajo(AreaTrabajoDTO areaTrabajoDTO)throws SICException;
	
	/**
	 * Metodo que obtiene una nave a partir de la ubicacion
	 * @param codigoCompania
	 * @param codigoUbicacion
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO obtenerNaveUbicacion(Integer codigoCompania, Long codigoDetalleSeccionUbicacion,Integer codigoAreaTrabajoPadre,Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 * Metodo que retorna una subnave a partir de una ubicacion
	 * @param codigoCompania
	 * @param codigoDetalleSeccionUbicacion
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO obtenerSubNaveUbicacion(Integer codigoCompania, Long codigoDetalleSeccionUbicacion,Integer codigoAreaTrabajoPadre,Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 * Metodo que obtiene los andenes compartidos de la ciudad de la boeda seleccionada 
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
	DetalleSeccionDTO registrarAndenCompartido(DetalleSeccionDTO detalleSeccionDTOCom, AreaTrabajoVO areaTrabajoVO, String userId)throws SICException;

	/**
	 * busqueda de ubicaciones por filtros 
	 * @param datosGsonSlickGridReg
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaUbicacionArticuloDTO> busquedaUbicacionesFiltros(Integer codigoAreaTrabajoBOD, Integer codigoAreaTrabajoSUB, Integer firstResult, Integer maxResults, HashMap<EnumValorFiltrosUbicacion, Object> filtros)throws SICException;
	/**
	 * Permite buscar las ubicaciones con filtros de pantalla
	 * @param codigoCompania
	 * @param codigoBodega
	 * @param codigoSubBodega
	 * @param filterUbicacion
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaUbicacionArticuloDTO> buscarUbicacionesFiltradas(Integer codigoCompania,Integer codigoBodega,Integer codigoSubBodega,HashMap<EnumValorFiltrosUbicacion, Object> filterUbicacion,EnumValorFiltrosUbicacion enumValorFiltrosUbicacion)throws SICException;
}
