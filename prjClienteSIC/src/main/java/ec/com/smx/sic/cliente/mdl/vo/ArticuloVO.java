/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.sic.cliente.common.articulo.EnumPrototipoAlcance;
import ec.com.smx.sic.cliente.common.articulo.EnumSubProcesoGuardadoArticulo;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaFiltrosBusquedaArticulos;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaGrupoAlcanceLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceIntegracionTransient;
import ec.com.smx.sic.cliente.mdl.nopersistente.CantidadCuponLocal;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
public class ArticuloVO extends BaseVO<ArticuloDTO>{

	private Boolean forzarActualizacionCodBar=Boolean.FALSE;
	private Boolean esCabeceraValida=Boolean.FALSE;
	private Boolean estaActivoGuardar = Boolean.FALSE;
	
	private Boolean isConflictoArticuloALcance =Boolean.FALSE;
	private Boolean isReporteAlcance = Boolean.FALSE;
	/**
	 * indica si el articulo tiene un codigo de barras origen
	 */
	private Boolean tieneCBO;
	/**
	 * valor que indica el estado de validacion del codigo de barras
	 */
	private String estValCodBar;
	private IProveedor proveedor;
	private ArticuloLocalDTO articuloLocalDTO;
	private ArticuloProveedorDTO articuloProveedorDTO;
	private ArticuloRelacionDTO articuloRelacionDTO;
	private RelacionArticuloRegistroSanitarioDTO articuloRegSanDTO;
	private String codigoSistemaOrigen;
	private Boolean desactivarPreciosTodosLocales = Boolean.FALSE;
	private Set<EnumSubProcesoGuardadoArticulo> enumSubProcesoGuardadoArticulo;
	private Collection<CantidadCuponLocal> cantidadCuponLocalCol;
	private Boolean esCreacion = Boolean.FALSE;
	private Boolean joinProveedor = Boolean.TRUE;
	
	//Variables proceso batch articulo alcance
	private GrupoTrabajoDTO grupoTrabajoAlcance;
	private Collection<ArticuloLocalPrecioVO> locales;
	private String opcionAlcance;
	private String opcionTipoAsignacionAlcance;
	private boolean esFilterArchivo;
	private String usuarioAlcance;
	private Timestamp fechaAplicacion;
	private Date fechaInicioAlcance;
	private Date fechaFinAlcance;
	private String esApertura;
	private Collection<VistaGrupoAlcanceLocalDTO> vistaGrupoAlcanceLocalDTOs;
	private Collection<ArticuloDTO> articulosPorArchivo; 
	private Collection<ArticuloDTO>articulosValidosPorArchivo; 
	private Collection<ArticuloDTO>articulosNoValidosPorArchivo; 
	private Collection<String>codigosBarrasArchivo; 
	private Collection<AreaTrabajoDTO> bodegasSeleccionadas;
	private Collection<AreaTrabajoDTO> areasTrabajoCol;
	
	private String accessItemId;
	private String systemId;
	
	private Integer codigoLocalAsignar;
	private Integer codigoLocalBase;
	private String notificarLocal;
	private String reporteSeleccionado;
	private String tipResolucionConflicto;
	private boolean isRemplazarAlcances=Boolean.FALSE;
	
	//variables para el envio de mail
	private String tituloAreaTrabajo;
	private String tituloAreaTrabajoBase;
	private String tituloAreaTrabajoDestino;
	private Collection<AreaTrabajoDTO> areaTrabajoBase;
	private Collection<AreaTrabajoDTO> areaTrabajoDestino;
	private String opcionTipoAsignacion;
	private String opcionAlcanceTexto;
	private boolean isAsignacionPorArchivo = Boolean.FALSE;
	private boolean isMensajeError = Boolean.FALSE;
	private String codigofuncionario;
	private Integer codigoCompania;
	
	//Codigo del local al cual dar alcance
	private Integer codigoLocalAlcance;
	
	//Coleccion que contiene los codigos de los articulos a dar alcance
	private Collection<String> codigosArticulos;
	
	//Codigo de subbodega del articulo
	private String codigoSubbodega;
	
	//Codigo del prototipo anterior
	private Long codigoGrupoAlcanceAnterior;
	
	/**
	 * Permite establecer el local el cual va a hacer copiado
	 * en la copia de locales masivo 
	 */
	private GrupoAreaTrabajoDTO grupoAreaTrabajoDTO;
	/**
	 * Permite establecer la funcion a ejecutar dependiendo del tipo de enumerado que se inicialice
	 */
	private EnumPrototipoAlcance enumPrototipoAlcance;
	
	private IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaArticulos;
	
	private Collection<Long> codigosArticuloAreaTrabajo;
	
	private Collection<ArticuloAlcanceIntegracionTransient> articuloAlcanceIntegracionTransientsCol;
	
	private Boolean esCuponPrecioVariable = Boolean.FALSE;
	
	private Collection<ArticuloImportacionDTO> articuloImportacionCol;
	 
	private XSSFWorkbook contenidoExcelObservaciones;
	
	// valida el impuesto disney
	private Boolean tieneImpuestoDisney;
	
	private Collection<ArticuloLocalPedidoDTO> localesPedidoCol;
	
	/**
	 * Causal para el cambio de clase a tipo E, O
	 */
	private CatalogoValorDTO causalCambioClase;
	
	//bandera que determina si el codigo de barras ean se reutilizara
	private Boolean esReutilizacionCodigoBarras;
	
	public ArticuloVO() {
		// TODO Auto-generated constructor stub
	}
	public ArticuloVO(ArticuloDTO art) {
		super(art);
	}
	
	/**
	 * @return the forzarActualizacionCodBar
	 */
	public Boolean getForzarActualizacionCodBar() {
		return forzarActualizacionCodBar;
	}

	/**
	 * @param forzarActualizacionCodBar the forzarActualizacionCodBar to set
	 */
	public void setForzarActualizacionCodBar(Boolean forzarActualizacionCodBar) {
		this.forzarActualizacionCodBar = forzarActualizacionCodBar;
	}

	/**
	 * @return the articuloLocalDTO
	 */
	public ArticuloLocalDTO getArticuloLocalDTO() {
		return articuloLocalDTO;
	}

	/**
	 * @param articuloLocalDTO the articuloLocalDTO to set
	 */
	public void setArticuloLocalDTO(ArticuloLocalDTO articuloLocalDTO) {
		this.articuloLocalDTO = articuloLocalDTO;
	}

	/**
	 * @return the estValCodBar
	 */
	public String getEstValCodBar() {
		return estValCodBar;
	}

	/**
	 * @param estValCodBar the estValCodBar to set
	 */
	public void setEstValCodBar(String estValCodBar) {
		this.estValCodBar = estValCodBar;
	}

	/**
	 * @return the esCabeceraValida
	 */
	public Boolean getEsCabeceraValida() {
		return esCabeceraValida;
	}

	/**
	 * @param esCabeceraValida the esCabeceraValida to set
	 */
	public void setEsCabeceraValida(Boolean esCabeceraValida) {
		this.esCabeceraValida = esCabeceraValida;
	}

	/**
	 * @return the tieneCBO
	 */
	public Boolean getTieneCBO() {
		return tieneCBO;
	}

	/**
	 * @param tieneCBO the tieneCBO to set
	 */
	public void setTieneCBO(Boolean tieneCBO) {
		this.tieneCBO = tieneCBO;
	}

	/**
	 * @return the articuloProveedorDTO
	 */
	public ArticuloProveedorDTO getArticuloProveedorDTO() {
		return articuloProveedorDTO;
	}

	/**
	 * @param articuloProveedorDTO the articuloProveedorDTO to set
	 */
	public void setArticuloProveedorDTO(ArticuloProveedorDTO articuloProveedorDTO) {
		this.articuloProveedorDTO = articuloProveedorDTO;
	}

	/**
	 * @return the articuloRelacionDTO
	 */
	public ArticuloRelacionDTO getArticuloRelacionDTO() {
		return articuloRelacionDTO;
	}

	/**
	 * @param articuloRelacionDTO the articuloRelacionDTO to set
	 */
	public void setArticuloRelacionDTO(ArticuloRelacionDTO articuloRelacionDTO) {
		this.articuloRelacionDTO = articuloRelacionDTO;
	}

	/**
	 * @return the estaActivoGuardar
	 */
	public Boolean getEstaActivoGuardar() {
		return estaActivoGuardar;
	}

	/**
	 * @param estaActivoGuardar the estaActivoGuardar to set
	 */
	public void setEstaActivoGuardar(Boolean estaActivoGuardar) {
		this.estaActivoGuardar = estaActivoGuardar;
	}

	/**
	 * @return the proveedor
	 */
	public IProveedor getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(IProveedor proveedor) {
		this.proveedor = proveedor;
	}


	public String getCodigoSistemaOrigen() {
		return codigoSistemaOrigen;
	}

	public void setCodigoSistemaOrigen(String codigoSistemaOrigen) {
		this.codigoSistemaOrigen = codigoSistemaOrigen;
	}

	/**
	 * @return the desactivarPreciosTodosLocales
	 */
	public Boolean getDesactivarPreciosTodosLocales() {
		return desactivarPreciosTodosLocales;
	}

	/**
	 * @param desactivarPreciosTodosLocales the desactivarPreciosTodosLocales to set
	 */
	public void setDesactivarPreciosTodosLocales(Boolean desactivarPreciosTodosLocales) {
		this.desactivarPreciosTodosLocales = desactivarPreciosTodosLocales;
	}

	/**
	 * @return the subProcesoGuardadoArticulo
	 */
	public Set<EnumSubProcesoGuardadoArticulo> getSubProcesoGuardadoArticulo() {
		return enumSubProcesoGuardadoArticulo;
	}

	/**
	 * @param enumSubProcesoGuardadoArticulo the subProcesoGuardadoArticulo to set
	 */
	public void setSubProcesoGuardadoArticulo(Set<EnumSubProcesoGuardadoArticulo> enumSubProcesoGuardadoArticulo) {
		this.enumSubProcesoGuardadoArticulo = enumSubProcesoGuardadoArticulo;
	}
	/**
	 * @return the cantidadCuponLocalCol
	 */
	public Collection<CantidadCuponLocal> getCantidadCuponLocalCol() {
		return cantidadCuponLocalCol;
	}
	/**
	 * @param cantidadCuponLocalCol the cantidadCuponLocalCol to set
	 */
	public void setCantidadCuponLocalCol(Collection<CantidadCuponLocal> cantidadCuponLocalCol) {
		this.cantidadCuponLocalCol = cantidadCuponLocalCol;
	}
	/**
	 * @return the esCreacion
	 */
	public Boolean getEsCreacion() {
		return esCreacion;
	}
	/**
	 * @param esCreacion the esCreacion to set
	 */
	public void setEsCreacion(Boolean esCreacion) {
		this.esCreacion = esCreacion;
	}
	/**
	 * @return the grupoTrabajoAlcance
	 */
	public GrupoTrabajoDTO getGrupoTrabajoAlcance() {
		return grupoTrabajoAlcance;
	}
	/**
	 * @param grupoTrabajoAlcance the grupoTrabajoAlcance to set
	 */
	public void setGrupoTrabajoAlcance(GrupoTrabajoDTO grupoTrabajoAlcance) {
		this.grupoTrabajoAlcance = grupoTrabajoAlcance;
	}
	/**
	 * @return the opcionAlcance
	 */
	public String getOpcionAlcance() {
		return opcionAlcance;
	}
	/**
	 * @param opcionAlcance the opcionAlcance to set
	 */
	public void setOpcionAlcance(String opcionAlcance) {
		this.opcionAlcance = opcionAlcance;
	}
	
	/**
	 * @return the usuarioAlcance
	 */
	public String getUsuarioAlcance() {
		return usuarioAlcance;
	}
	/**
	 * @param usuarioAlcance the usuarioAlcance to set
	 */
	public void setUsuarioAlcance(String usuarioAlcance) {
		this.usuarioAlcance = usuarioAlcance;
	}
	/**
	 * @return the fechaAlcance
	 */
	public Timestamp getFechaAplicacion() {
		return fechaAplicacion;
	}
	/**
	 * @param fechaAplicacion the fechaAplicacion to set
	 */
	public void setFechaAplicacion(Timestamp fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}
	/**
	 * @return the fechaInicioAlcance
	 */
	public Date getFechaInicioAlcance() {
		return fechaInicioAlcance;
	}
	/**
	 * @param fechaInicioAlcance the fechaInicioAlcance to set
	 */
	public void setFechaInicioAlcance(Date fechaInicioAlcance) {
		this.fechaInicioAlcance = fechaInicioAlcance;
	}
	/**
	 * @return the fechaFinAlcance
	 */
	public Date getFechaFinAlcance() {
		return fechaFinAlcance;
	}
	/**
	 * @param fechaFinAlcance the fechaFinAlcance to set
	 */
	public void setFechaFinAlcance(Date fechaFinAlcance) {
		this.fechaFinAlcance = fechaFinAlcance;
	}
	/**
	 * @return the locales
	 */
	public Collection<ArticuloLocalPrecioVO> getLocales() {
		return locales;
	}
	/**
	 * @param locales the locales to set
	 */
	public void setLocales(Collection<ArticuloLocalPrecioVO> locales) {
		this.locales = locales;
	}
	
	/**
	 * @return the vistaGrupoAlcanceLocalDTOs
	 */
	public Collection<VistaGrupoAlcanceLocalDTO> getVistaGrupoAlcanceLocalDTOs() {
		return vistaGrupoAlcanceLocalDTOs;
	}
	/**
	 * @param vistaGrupoAlcanceLocalDTOs the vistaGrupoAlcanceLocalDTOs to set
	 */
	public void setVistaGrupoAlcanceLocalDTOs(Collection<VistaGrupoAlcanceLocalDTO> vistaGrupoAlcanceLocalDTOs) {
		this.vistaGrupoAlcanceLocalDTOs = vistaGrupoAlcanceLocalDTOs;
	}
	/**
	 * @return the codigosBarrasArchivo
	 */
	public Collection<String> getCodigosBarrasArchivo() {
		return codigosBarrasArchivo;
	}
	/**
	 * @param codigosBarrasArchivo the codigosBarrasArchivo to set
	 */
	public void setCodigosBarrasArchivo(Collection<String> codigosBarrasArchivo) {
		this.codigosBarrasArchivo = codigosBarrasArchivo;
	}
	/**
	 * @return the articulosValidosPorArchivo
	 */
	public Collection<ArticuloDTO> getArticulosValidosPorArchivo() {
		return articulosValidosPorArchivo;
	}
	/**
	 * @param articulosValidosPorArchivo the articulosValidosPorArchivo to set
	 */
	public void setArticulosValidosPorArchivo(Collection<ArticuloDTO> articulosValidosPorArchivo) {
		this.articulosValidosPorArchivo = articulosValidosPorArchivo;
	}
	/**
	 * @return the articulosNoValidosPorArchivo
	 */
	public Collection<ArticuloDTO> getArticulosNoValidosPorArchivo() {
		return articulosNoValidosPorArchivo;
	}
	/**
	 * @param articulosNoValidosPorArchivo the articulosNoValidosPorArchivo to set
	 */
	public void setArticulosNoValidosPorArchivo(Collection<ArticuloDTO> articulosNoValidosPorArchivo) {
		this.articulosNoValidosPorArchivo = articulosNoValidosPorArchivo;
	}
	/**
	 * @return the articulosPorArchivo
	 */
	public Collection<ArticuloDTO> getArticulosPorArchivo() {
		return articulosPorArchivo;
	}
	/**
	 * @param articulosPorArchivo the articulosPorArchivo to set
	 */
	public void setArticulosPorArchivo(Collection<ArticuloDTO> articulosPorArchivo) {
		this.articulosPorArchivo = articulosPorArchivo;
	}
	/**
	 * @return the esApertura
	 */
	public String getEsApertura() {
		return esApertura;
	}
	/**
	 * @param esApertura the esApertura to set
	 */
	public void setEsApertura(String esApertura) {
		this.esApertura = esApertura;
	}
	/**
	 * @return the plantillaFiltrosBusquedaArticulos
	 */
	public IPlantillaFiltrosBusquedaArticulos getPlantillaFiltrosBusquedaArticulos() {
		return plantillaFiltrosBusquedaArticulos;
	}
	/**
	 * @param plantillaFiltrosBusquedaArticulos the plantillaFiltrosBusquedaArticulos to set
	 */
	public void setPlantillaFiltrosBusquedaArticulos(IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaArticulos) {
		this.plantillaFiltrosBusquedaArticulos = plantillaFiltrosBusquedaArticulos;
	}
	/**
	 * @return the opcionTipoAsignacionAlcance
	 */
	public String getOpcionTipoAsignacionAlcance() {
		return opcionTipoAsignacionAlcance;
	}
	/**
	 * @param opcionTipoAsignacionAlcance the opcionTipoAsignacionAlcance to set
	 */
	public void setOpcionTipoAsignacionAlcance(String opcionTipoAsignacionAlcance) {
		this.opcionTipoAsignacionAlcance = opcionTipoAsignacionAlcance;
	}
	/**
	 * @return the enumPrototipoAlcance
	 */
	public EnumPrototipoAlcance getEnumPrototipoAlcance() {
		return enumPrototipoAlcance;
	}
	/**
	 * @param enumPrototipoAlcance the enumPrototipoAlcance to set
	 */
	public void setEnumPrototipoAlcance(EnumPrototipoAlcance enumPrototipoAlcance) {
		this.enumPrototipoAlcance = enumPrototipoAlcance;
	}
	/**
	 * @return the grupoAreaTrabajoDTO
	 */
	public GrupoAreaTrabajoDTO getGrupoAreaTrabajoDTO() {
		return grupoAreaTrabajoDTO;
	}
	/**
	 * @param grupoAreaTrabajoDTO the grupoAreaTrabajoDTO to set
	 */
	public void setGrupoAreaTrabajoDTO(GrupoAreaTrabajoDTO grupoAreaTrabajoDTO) {
		this.grupoAreaTrabajoDTO = grupoAreaTrabajoDTO;
	}
	/**
	 * @return the accessItemId
	 */
	public String getAccessItemId() {
		return accessItemId;
	}
	/**
	 * @param accessItemId the accessItemId to set
	 */
	public void setAccessItemId(String accessItemId) {
		this.accessItemId = accessItemId;
	}
	/**
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}
	/**
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	/**
	 * @return the esFilterArchivo
	 */
	public boolean isEsFilterArchivo() {
		return esFilterArchivo;
	}
	/**
	 * @param esFilterArchivo the esFilterArchivo to set
	 */
	public void setEsFilterArchivo(boolean esFilterArchivo) {
		this.esFilterArchivo = esFilterArchivo;
	}
	/**
	 * @return the codigoLocalAsignar
	 */
	public Integer getCodigoLocalAsignar() {
		return codigoLocalAsignar;
	}
	/**
	 * @param codigoLocalAsignar the codigoLocalAsignar to set
	 */
	public void setCodigoLocalAsignar(Integer codigoLocalAsignar) {
		this.codigoLocalAsignar = codigoLocalAsignar;
	}
	/**
	 * @return the codigoLocalBase
	 */
	public Integer getCodigoLocalBase() {
		return codigoLocalBase;
	}
	/**
	 * @param codigoLocalBase the codigoLocalBase to set
	 */
	public void setCodigoLocalBase(Integer codigoLocalBase) {
		this.codigoLocalBase = codigoLocalBase;
	}
	/**
	 * @return the notificarLocal
	 */
	public String getNotificarLocal() {
		return notificarLocal;
	}
	/**
	 * @param notificarLocal the notificarLocal to set
	 */
	public void setNotificarLocal(String notificarLocal) {
		this.notificarLocal = notificarLocal;
	}
	/**
	 * @return the isConflictoArticuloALcance
	 */
	public Boolean getIsConflictoArticuloALcance() {
		return isConflictoArticuloALcance;
	}
	/**
	 * @param isConflictoArticuloALcance the isConflictoArticuloALcance to set
	 */
	public void setIsConflictoArticuloALcance(Boolean isConflictoArticuloALcance) {
		this.isConflictoArticuloALcance = isConflictoArticuloALcance;
	}
	
	/**
	 * @return the isReporteAlcance
	 */
	public Boolean getIsReporteAlcance() {
		return isReporteAlcance;
	}
	/**
	 * @param isReporteAlcance the isReporteAlcance to set
	 */
	public void setIsReporteAlcance(Boolean isReporteAlcance) {
		this.isReporteAlcance = isReporteAlcance;
	}
	/**
	 * @return the tipResolucionConflicto
	 */
	public String getTipResolucionConflicto() {
		return tipResolucionConflicto;
	}
	/**
	 * @param tipResolucionConflicto the tipResolucionConflicto to set
	 */
	public void setTipResolucionConflicto(String tipResolucionConflicto) {
		this.tipResolucionConflicto = tipResolucionConflicto;
	}
	/**
	 * @return the codigosArticuloAreaTrabajo
	 */
	public Collection<Long> getCodigosArticuloAreaTrabajo() {
		return codigosArticuloAreaTrabajo;
	}
	/**
	 * @param codigosArticuloAreaTrabajo the codigosArticuloAreaTrabajo to set
	 */
	public void setCodigosArticuloAreaTrabajo(Collection<Long> codigosArticuloAreaTrabajo) {
		this.codigosArticuloAreaTrabajo = codigosArticuloAreaTrabajo;
	}
	
	/**
	 * @return the reporteSeleccionado
	 */
	public String getReporteSeleccionado() {
		return reporteSeleccionado;
	}
	/**
	 * @param reporteSeleccionado the reporteSeleccionado to set
	 */
	public void setReporteSeleccionado(String reporteSeleccionado) {
		this.reporteSeleccionado = reporteSeleccionado;
	}
	/**
	 * @return the joinProveedor
	 */
	public Boolean getJoinProveedor() {
		return joinProveedor;
	}
	/**
	 * @param joinProveedor the joinProveedor to set
	 */
	public void setJoinProveedor(Boolean joinProveedor) {
		this.joinProveedor = joinProveedor;
	}
	public RelacionArticuloRegistroSanitarioDTO getArticuloRegSanDTO() {
		return articuloRegSanDTO;
	}
	public void setArticuloRegSanDTO(RelacionArticuloRegistroSanitarioDTO articuloRegSanDTO) {
		this.articuloRegSanDTO = articuloRegSanDTO;
	}
	
	/**
	 * @return the bodegasSeleccionadas
	 */
	public Collection<AreaTrabajoDTO> getBodegasSeleccionadas() {
		return bodegasSeleccionadas;
	}
	/**
	 * @param bodegasSeleccionadas the bodegasSeleccionadas to set
	 */
	public void setBodegasSeleccionadas(Collection<AreaTrabajoDTO> bodegasSeleccionadas) {
		this.bodegasSeleccionadas = bodegasSeleccionadas;
	}

	/**
	 * @return the codigoLocalAlcance
	 */
	public Integer getCodigoLocalAlcance() {
		return codigoLocalAlcance;
	}
	/**
	 * @param codigoLocalAlcance the codigoLocalAlcance to set
	 */
	public void setCodigoLocalAlcance(Integer codigoLocalAlcance) {
		this.codigoLocalAlcance = codigoLocalAlcance;
	}
	/**
	 * @return the codigosArticulos
	 */
	public Collection<String> getCodigosArticulos() {
		return codigosArticulos;
	}
	/**
	 * @param codigosArticulos the codigosArticulos to set
	 */
	public void setCodigosArticulos(Collection<String> codigosArticulos) {
		this.codigosArticulos = codigosArticulos;
	}
	/**
	 * @return the isRemplazarAlcances
	 */
	public boolean isRemplazarAlcances() {
		return isRemplazarAlcances;
	}
	/**
	 * @param isRemplazarAlcances the isRemplazarAlcances to set
	 */
	public void setRemplazarAlcances(boolean isRemplazarAlcances) {
		this.isRemplazarAlcances = isRemplazarAlcances;
	}
	/**
	 * @return the isMensajeError
	 */
	public boolean isMensajeError() {
		return isMensajeError;
	}
	/**
	 * @param isMensajeError the isMensajeError to set
	 */
	public void setMensajeError(boolean isMensajeError) { 
		this.isMensajeError = isMensajeError;
	}
	
	/**
	 * @return the isAsignacionPorArchivo
	 */
	public boolean isAsignacionPorArchivo() {
		return isAsignacionPorArchivo;
	}
	/**
	 * @param isAsignacionPorArchivo the isAsignacionPorArchivo to set
	 */
	public void setAsignacionPorArchivo(boolean isAsignacionPorArchivo) { 
		this.isAsignacionPorArchivo = isAsignacionPorArchivo;
	}
	/**
	 * @return the codigoSubbodega
	 */
	
	/**
	 * @return the codigoSubbodega
	 */
	public String getCodigoSubbodega() {
		return codigoSubbodega;
	}
	/**
	 * @param codigoSubbodega the codigoSubbodega to set
	 */
	public void setCodigoSubbodega(String codigoSubbodega) {
		this.codigoSubbodega = codigoSubbodega;
	}
	public String getTituloAreaTrabajo() {
		return tituloAreaTrabajo;
	}
	public void setTituloAreaTrabajo(String tituloAreaTrabajo) {
		this.tituloAreaTrabajo = tituloAreaTrabajo;
	}
	public Collection<AreaTrabajoDTO> getAreaTrabajoDestino() {
		return areaTrabajoDestino;
	}
	public void setAreaTrabajoDestino(Collection<AreaTrabajoDTO> areaTrabajoDestino) {
		this.areaTrabajoDestino = areaTrabajoDestino;
	}
	public Collection<AreaTrabajoDTO> getAreaTrabajoBase() {
		return areaTrabajoBase;
	}
	public void setAreaTrabajoBase(Collection<AreaTrabajoDTO> areaTrabajoBase) {
		this.areaTrabajoBase = areaTrabajoBase;
	}
	public String getTituloAreaTrabajoDestino() {
		return tituloAreaTrabajoDestino;
	}
	public void setTituloAreaTrabajoDestino(String tituloAreaTrabajoDestino) {
		this.tituloAreaTrabajoDestino = tituloAreaTrabajoDestino;
	}
	public String getTituloAreaTrabajoBase() {
		return tituloAreaTrabajoBase;
	}
	public void setTituloAreaTrabajoBase(String tituloAreaTrabajoBase) {
		this.tituloAreaTrabajoBase = tituloAreaTrabajoBase;
	}
	public String getOpcionTipoAsignacion() {
		return opcionTipoAsignacion;
	}
	public void setOpcionTipoAsignacion(String opcionTipoAsignacion) {
		this.opcionTipoAsignacion = opcionTipoAsignacion;
	}
	public String getOpcionAlcanceTexto() {
		return opcionAlcanceTexto;
	}
	public void setOpcionAlcanceTexto(String opcionAlcanceTexto) {
		this.opcionAlcanceTexto = opcionAlcanceTexto;
	}
	/**
	 * @return the articuloAlcanceIntegracionTransientsCol
	 */
	public Collection<ArticuloAlcanceIntegracionTransient> getArticuloAlcanceIntegracionTransientsCol() {
		return articuloAlcanceIntegracionTransientsCol;
	}
	/**
	 * @param articuloAlcanceIntegracionTransientsCol the articuloAlcanceIntegracionTransientsCol to set
	 */
	public void setArticuloAlcanceIntegracionTransientsCol(Collection<ArticuloAlcanceIntegracionTransient> articuloAlcanceIntegracionTransientsCol) {
		this.articuloAlcanceIntegracionTransientsCol = articuloAlcanceIntegracionTransientsCol;
	}
	public String getCodigofuncionario() {
		return codigofuncionario;
	}
	public void setCodigofuncionario(String codigofuncionario) {
		this.codigofuncionario = codigofuncionario;
	}
	public Boolean getEsCuponPrecioVariable() {
		return esCuponPrecioVariable;
	}
	public void setEsCuponPrecioVariable(Boolean esCuponPrecioVariable) {
		this.esCuponPrecioVariable = esCuponPrecioVariable;
	}
	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	/**
	 * @return the codigoGrupoAlcanceAnterior
	 */
	public Long getCodigoGrupoAlcanceAnterior() {
		return codigoGrupoAlcanceAnterior;
	}
	/**
	 * @param codigoGrupoAlcanceAnterior the codigoGrupoAlcanceAnterior to set
	 */
	public void setCodigoGrupoAlcanceAnterior(Long codigoGrupoAlcanceAnterior) {
		this.codigoGrupoAlcanceAnterior = codigoGrupoAlcanceAnterior;
	}
	/**
	 * @return the areasTrabajoCol
	 */
	public Collection<AreaTrabajoDTO> getAreasTrabajoCol() {
		return areasTrabajoCol;
	}
	/**
	 * @param areasTrabajoCol the areasTrabajoCol to set
	 */
	public void setAreasTrabajoCol(Collection<AreaTrabajoDTO> areasTrabajoCol) {
		this.areasTrabajoCol = areasTrabajoCol;
	}
	/**
	 * @return the contenidoExcelObservaciones
	 */
	public XSSFWorkbook getContenidoExcelObservaciones() {
		return contenidoExcelObservaciones;
	}
	/**
	 * @param contenidoExcelObservaciones the contenidoExcelObservaciones to set
	 */
	public void setContenidoExcelObservaciones(XSSFWorkbook contenidoExcelObservaciones) {
		this.contenidoExcelObservaciones = contenidoExcelObservaciones;
	}
	/**
	 * @return the articuloImportacionCol
	 */
	public Collection<ArticuloImportacionDTO> getArticuloImportacionCol() {
		return articuloImportacionCol;
	}
	/**
	 * @param articuloImportacionCol the articuloImportacionCol to set
	 */
	public void setArticuloImportacionCol(Collection<ArticuloImportacionDTO> articuloImportacionCol) {
		this.articuloImportacionCol = articuloImportacionCol;
	}
	public Boolean getTieneImpuestoDisney() {
		return tieneImpuestoDisney;
	}
	public void setTieneImpuestoDisney(Boolean tieneImpuestoDisney) {
		this.tieneImpuestoDisney = tieneImpuestoDisney;
	}
	/**
	 * @return the localesPedidoCol
	 */
	public Collection<ArticuloLocalPedidoDTO> getLocalesPedidoCol() {
		return localesPedidoCol;
	}
	/**
	 * @param localesPedidoCol the localesPedidoCol to set
	 */
	public void setLocalesPedidoCol(Collection<ArticuloLocalPedidoDTO> localesPedidoCol) {
		this.localesPedidoCol = localesPedidoCol;
	}
	/**
	 * @return the causalCambioClase
	 */
	public CatalogoValorDTO getCausalCambioClase() {
		return causalCambioClase;
	}
	/**
	 * @param causalCambioClase the causalCambioClase to set
	 */
	public void setCausalCambioClase(CatalogoValorDTO causalCambioClase) {
		this.causalCambioClase = causalCambioClase;
	}
	public Boolean getEsReutilizacionCodigoBarras() {
		return esReutilizacionCodigoBarras;
	}
	public void setEsReutilizacionCodigoBarras(Boolean esReutilizacionCodigoBarras) {
		this.esReutilizacionCodigoBarras = esReutilizacionCodigoBarras;
	}
}