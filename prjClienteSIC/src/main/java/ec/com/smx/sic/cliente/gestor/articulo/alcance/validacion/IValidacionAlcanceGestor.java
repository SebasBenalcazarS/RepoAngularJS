package ec.com.smx.sic.cliente.gestor.articulo.alcance.validacion;

import java.sql.Timestamp;
import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaFiltrosBusquedaArticulos;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface IValidacionAlcanceGestor {

	/**
	 * Método para validar los datos en la creación del grupo de alcance
	 * @param grupoTrabajoDTO
	 * @param areaTrabajoCol
	 * @throws SICException
	 */
	public abstract void crearGrupoAlcance(GrupoTrabajoDTO grupoTrabajoDTO, Collection<AreaTrabajoDTO> areaTrabajoCol) throws SICException;

	/**
	 * Método para validar los datos en la actualización del grupo de alcance
	 * @param grupoTrabajoDTO
	 * @param fechaAplicacion
	 * @param areasAsignar
	 * @param areasDesactivar
	 * @param areasActivar
	 * @throws SICException
	 */
	public abstract void actualizarGrupoAlcance(GrupoTrabajoDTO grupoTrabajoDTO,Timestamp fechaAplicacion, Collection<GrupoAreaTrabajoDTO> areasAsignar, Collection<GrupoAreaTrabajoDTO> areasDesactivar, Collection<GrupoAreaTrabajoDTO> areasActivar) throws SICException;

	/**
	 * Método para validar los datos en la copia de local
	 * @param prototipoAlcanceVO
	 * @throws SICException
	 */
	public abstract void copiarLocal(ArticuloVO articuloVO) throws SICException;
	
	/**
	 * Permite obtener el numero de articulos seleccionados por filtros de subbodega, proveedor, clasificación y articulos
	 * @param codigosSubbodega
	 * @param codigosProveedor
	 * @param codigosClasificacion
	 * @param codigosArticulos
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public abstract void contarArticulosPorFiltro(Collection<String> codigosSubbodega, Collection<String> codigosProveedor, 
			Collection<String> codigosClasificacion, Collection<String> codigosArticulos,String codigoCompania) throws SICException;
	
	/**
	 * Permite asignar masivamente articulos a los locales
	 * @param articuloFiltro
	 * @param plantillaFiltrosBusqueda
	 * @throws SICException
	 */
	public abstract void asignacionMasivaArticulos(ArticuloVO articuloFiltro, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusqueda) throws SICException;

	/**
	 * Permite asignar alcance del articulo a las areas de trabajo
	 * @param articuloVO
	 * @throws SICException
	 */
	public abstract void asignarArticuloAlcanceAreasTrabajo(ArticuloVO articuloVO)throws SICException;
	
	/**
	 * Valida los datos enviados previo al registro de alcances temporales
	 * @param articuloVO
	 * @throws SICException
	 */
	public abstract void validarRegistrarAlcanceTemporal(ArticuloVO articuloVO) throws SICException;
	/**
	 * Valida los datos enviados previo al registro de alcances a bodegas padres de subbodega
	 * @param articuloVO
	 * @throws SICException
	 */
	public abstract void validarRegistrarAlcanceBodegaSubbodega(ArticuloVO articuloVO) throws SICException;
	
	/**
	 * Permite registrar alcance a los locales de un prototipo
	 * @param articuloVO
	 */
	public abstract void insertarAlcancePorPrototipo(ArticuloVO articuloVO)throws SICException;
	
	/**
	 * Activamos e inactivamos los establecimientos dependiendo de los alcances
	 * @param articuloVO
	 * @throws SICException
	 */
	public abstract void activarDesactivarArticulosMasivoEstablecimientos(ArticuloVO articuloVO)throws SICException;
	
	/**
	 * Insertamos los establecimientos dependiendo de los alcances
	 * @param articuloVO
	 * @throws SICException
	 */
	public abstract void insertarArticulosMasivoEstablecimientos(ArticuloVO articuloVO)throws SICException;
	
	
	/**
	 * Permite activar, desactivar, insertar alcances cuando se ha realizado un cambio de prototipo
	 * @param articuloVO
	 * @throws SICException
	 */
	public abstract void insertarAlcancesCambioPrototipo(ArticuloVO articuloVO) throws SICException;
}