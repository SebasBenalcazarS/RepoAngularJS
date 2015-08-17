package ec.com.smx.sic.cliente.servicio.recipientes;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDetalleRecipienteDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecipienteCabeceraProveedorDocumentoTrasient;
import ec.com.smx.sic.cliente.mdl.vo.ControlRecipienteVO;
/**
 * Servicios de canje de recipientes a proveedor
 * @author amunoz
 *
 */
public interface ICanjeRecipientesServicio extends Serializable {
	
	/**
	 * Busqueda de recipientes a mostrar cuando se realiza la recepción 
	 * @param articulo
	 * @param codigoTipoControlCosto
	 * @return
	 */
	public Collection<ControlRecipienteTaraDetalleDTO> findControlRecipienteTaraPorArticulo (ArticuloDTO articulo,Integer codigoTipoControlCosto) ;
	/**
	 * Crea control recipientes 
	 * @param controlRecipienteDetalle
	 */
	void crearControlRecipienteTaraDetalle(ControlRecipienteTaraDetalleDTO controlRecipienteTaraDetalle) ;
	/**
     * Crea una coleccion de control recipiente que pertenecen a los articulos que se recibieron en la bodega
     * @param controlRecipienteTaraDetallesCol
     */
    void crearControlRecipienteTaraDetalles(Collection<ControlRecipienteTaraDetalleDTO> controlRecipienteTaraDetallesCol, Long codigoDatosTarea);
    
    /**
     * Devuelve la coleccion de detalles de tarea mediante un codigo de datos tarea
     * @param codigoDatosTarea
     * @return
     */
    public Collection<ControlRecipienteDetalleDTO> findControlRecipienteDetalle (Long codigoDatosTarea);
    /**
     * Crea en tablas de Control recipiente sincronizadamente cuando se crea en la tabla de Control Recipiente Tara Detalle
     * @param controlRecipienteTaraDetallesCol
     * @param codigoRecepcionProveedor
     */
    void crearControlRecipienteDetalleSincronizado (Collection<ControlRecipienteTaraDetalleDTO> controlRecipienteTaraDetallesCol, 
    												Long codigoDatosTarea,
    												String usuario);
    
    /**
     * Busqueda por filtros de las cabeceras en el canje de recipientes por proveedor
     * @param componentesMap
     * @return
     */
    public Collection<RecipienteCabeceraProveedorDocumentoTrasient> obtenerCabecerasControlRecipiente(Map<String, Object> componentesMap);
    
    /**
     * @author yarmentero
     * Busqueda por recepcionesProveedorDTO de las cabeceras en el canje de recipientes por proveedor
     * @param recepcionesProveedorDTO
     * @return
     */
    public Collection<RecipienteCabeceraProveedorDocumentoTrasient> obtenerCabecerasControlRecipiente(Collection<RecepcionProveedorDTO> recepcionesProveedorDTO);
    
    /**
     * Retorna una coleccion  catalogo valor de todos los causales
     * @return
     */
    public Collection<CatalogoValorDTO> obtenerCausalesAjuste();
    /**
     * Actualiza los cambios en el canje de recipientes 
     * @param controlRecipienteVO
     */
    public void guardarCambioRecipienteRecepcionProveedor(ControlRecipienteVO controlRecipienteVO);
	
    /**
     * Obtiene una coleccion de jabas por tipo de control de costo
     * @param articulo
     * @param codigoTipoControlCosto
     * @return
     * @throws SICException
     */
    public Collection<ControlRecipienteTaraDetalleDTO> obtenerJabasTipoControlCosto(ArticuloDTO articulo, String codigoTipoControlCosto) throws SICException;
	/***
	 * Obtiene una coleccion de jabas de rechazo por articulo
	 * @param articulo
	 * @param codigoProcesoRechazo
	 * @return
	 * @throws SICException
	 */
    public Collection<ControlRecipienteTaraDetalleDTO> obtenerJabasRechazoArticulo(ArticuloDTO articulo, Long codigoProcesoRechazo) throws SICException;
    
    /**
     * Devuelve todos los recipientes recibidos en la recepcion
     * @return
     */
    public Collection<ControlRecipienteTaraDetalleDTO> findControlRecipienteTaraDetalleAll() ;
    /**
     * 
     * @return
     */
    public Collection<DatosTareaDetalleRecipienteDTO> findControlRecipienteDatosTaraDetalleAll();
    
}
