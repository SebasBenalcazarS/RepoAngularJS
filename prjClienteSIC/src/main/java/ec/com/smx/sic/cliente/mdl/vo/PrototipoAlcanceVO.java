package ec.com.smx.sic.cliente.mdl.vo;

import java.sql.Timestamp;
import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceIntegracionTransient;

/**
 * @author dalmeida
 *
 */
public class PrototipoAlcanceVO {
	private Integer codigoLocalAsignar;
	private Integer codigoLocalBase;
	private String usuarioId;
	private Integer codigoCompania;
	private Collection<AreaTrabajoDTO> areaTrabajoDTOs;
	private Collection<GrupoTrabajoDTO> grupoTrabajoDTOs;
	private Boolean asignacion;
	private Timestamp fechaAplicacion;
	private String esApertura;
	private String notificarLocal;
	private Collection<GrupoAreaTrabajoDTO> areasAsignar;
	private Collection<GrupoAreaTrabajoDTO> areasDesactivar;
	private Collection<GrupoAreaTrabajoDTO> areasActivar;
	private UserDto userDto;
	private boolean isMensajeError=false;
	private Collection<ArticuloAlcanceIntegracionTransient> articuloAlcanceIntegracionTransientCol;
	/**
	 * Guarda las opciones que se pueden elegir a partir de la seleccionada 
	 */
	private Collection<PrototipoAlcanceVO> prototipoAlcanceCol;
	private String nombreOpcion;
	private PrototipoAlcanceVO  prototipoAlcanceVOPadre;
	private Integer nivel;
	private String styleClass;
	
	//Variables para la asignaciónMasiva
	private ArticuloDTO filtroArticuloDTO;
	private Collection<String> codigosBarras;
	
	private ArticuloVO articuloVO;
	
	private String accessItemId;
	private String systemId;
	
	private String codigoFuncionario;
	
	public Integer getCodigoLocalAsignar() {
		return codigoLocalAsignar;
	}
	public void setCodigoLocalAsignar(Integer codigoLocalAsignar) {
		this.codigoLocalAsignar = codigoLocalAsignar;
	}
	public Integer getCodigoLocalBase() {
		return codigoLocalBase;
	}
	public void setCodigoLocalBase(Integer codigoLocalBase) {
		this.codigoLocalBase = codigoLocalBase;
	}
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Collection<PrototipoAlcanceVO> getPrototipoAlcanceCol() {
		return prototipoAlcanceCol;
	}
	public void setPrototipoAlcanceCol(Collection<PrototipoAlcanceVO> prototipoAlcanceCol) {
		this.prototipoAlcanceCol = prototipoAlcanceCol;
	}
	public String getNombreOpcion() {
		return nombreOpcion;
	}
	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}
	public PrototipoAlcanceVO getPrototipoAlcanceVOPadre() {
		return prototipoAlcanceVOPadre;
	}
	public void setPrototipoAlcanceVOPadre(PrototipoAlcanceVO prototipoAlcanceVOPadre) {
		this.prototipoAlcanceVOPadre = prototipoAlcanceVOPadre;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public String getStyleClass() {
		return styleClass;
	}
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	public Collection<AreaTrabajoDTO> getAreaTrabajoDTOs() {
		return areaTrabajoDTOs;
	}
	public void setAreaTrabajoDTOs(Collection<AreaTrabajoDTO> areaTrabajoDTOs) {
		this.areaTrabajoDTOs = areaTrabajoDTOs;
	}
	public Collection<GrupoTrabajoDTO> getGrupoTrabajoDTOs() {
		return grupoTrabajoDTOs;
	}
	public void setGrupoTrabajoDTOs(Collection<GrupoTrabajoDTO> grupoTrabajoDTOs) {
		this.grupoTrabajoDTOs = grupoTrabajoDTOs;
	}
	public Boolean getAsignacion() {
		return asignacion;
	}
	public void setAsignacion(Boolean asignacion) {
		this.asignacion = asignacion;
	}
	public Timestamp getFechaAplicacion() {
		return fechaAplicacion;
	}
	
	public void setFechaAplicacion(Timestamp fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}
	
	public ArticuloDTO getFiltroArticuloDTO() {
		return filtroArticuloDTO;
	}
	
	public void setFiltroArticuloDTO(ArticuloDTO filtroArticuloDTO) {
		this.filtroArticuloDTO = filtroArticuloDTO;
	}
	public Collection<String> getCodigosBarras() {
		return codigosBarras;
	}
	public void setCodigosBarras(Collection<String> codigosBarras) {
		this.codigosBarras = codigosBarras;
	}
	public ArticuloVO getArticuloVO() {
		return articuloVO;
	}
	public void setArticuloVO(ArticuloVO articuloVO) {
		this.articuloVO = articuloVO;
	}
	public String getEsApertura() {
		return esApertura;
	}
	public void setEsApertura(String esApertura) {
		this.esApertura = esApertura;
	}
	public String getNotificarLocal() {
		return notificarLocal;
	}
	public void setNotificarLocal(String notificarLocal) {
		this.notificarLocal = notificarLocal;
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
	 * @return the areasAsignar
	 */
	public Collection<GrupoAreaTrabajoDTO> getAreasAsignar() {
		return areasAsignar;
	}
	/**
	 * @param areasAsignar the areasAsignar to set
	 */
	public void setAreasAsignar(Collection<GrupoAreaTrabajoDTO> areasAsignar) {
		this.areasAsignar = areasAsignar;
	}
	/**
	 * @return the areasDesactivar
	 */
	public Collection<GrupoAreaTrabajoDTO> getAreasDesactivar() {
		return areasDesactivar;
	}
	/**
	 * @param areasDesactivar the areasDesactivar to set
	 */
	public void setAreasDesactivar(Collection<GrupoAreaTrabajoDTO> areasDesactivar) {
		this.areasDesactivar = areasDesactivar;
	}
	/**
	 * @return the areasActivar
	 */
	public Collection<GrupoAreaTrabajoDTO> getAreasActivar() {
		return areasActivar;
	}
	/**
	 * @param areasActivar the areasActivar to set
	 */
	public void setAreasActivar(Collection<GrupoAreaTrabajoDTO> areasActivar) {
		this.areasActivar = areasActivar;
	}
	/**
	 * @return the userDto
	 */
	public UserDto getUserDto() {
		return userDto;
	}
	/**
	 * @param userDto the userDto to set
	 */
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
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
	 * @return the articuloAlcanceIntegracionTransientCol
	 */
	public Collection<ArticuloAlcanceIntegracionTransient> getArticuloAlcanceIntegracionTransientCol() {
		return articuloAlcanceIntegracionTransientCol;
	}
	/**
	 * @param articuloAlcanceIntegracionTransientCol the articuloAlcanceIntegracionTransientCol to set
	 */
	public void setArticuloAlcanceIntegracionTransientCol(Collection<ArticuloAlcanceIntegracionTransient> articuloAlcanceIntegracionTransientCol) {
		this.articuloAlcanceIntegracionTransientCol = articuloAlcanceIntegracionTransientCol;
	}
	/**
	 * @return the codigoFuncionario
	 */
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}
	/**
	 * @param codigoFuncionario the codigoFuncionario to set
	 */
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	
	
	
}
