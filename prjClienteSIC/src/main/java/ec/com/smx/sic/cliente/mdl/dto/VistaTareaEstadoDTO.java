package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.EmbeddedId;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaTareaEstadoID;

/**
 * @author wcaiza
 *
 */
@SuppressWarnings("serial")
public class VistaTareaEstadoDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private VistaTareaEstadoID id = new VistaTareaEstadoID();
	
	//campos de la tabla TareaDTO - SBTARTTAREA
	private Long codigoTareaPadre;
	private Date fechaRegistro;
	private Long codigoTipoTareaPerfil;
	
	//campos de la tabla BaseProfileDto - KSSEGTPROFILE
	private String profileId;
	private String profileName;
	private String referenceCode;
	
	//campos de la tabla UserDto - KSSEGTUSER
	private String userId;
	private String userName;
	private String userCompleteName;
	
	//campos de la tabla TareaEstadoDTO - SBTARTTAREST
	private Long codigoEstadoTarea;
	private String codCatValPadreTareaEstado;
	private Integer codCatValTipoPadreTareaEstado;
	private String codCatValRelacionadoTareaEstado;
	private Integer codCatValTipoRelacionadoTareaEstado;
	private Date fechaInicio;
	private Date fechaFin;
	
	//campos de la tabla CatalogoValorDTO - SSPCOTCATALOGOVALOR para el estado de la tarea
	private String nomCatValEstTarRel;
	
	//campos de funciones para administrar las fecha asignacion, terminado y cancelado
	private Date fechaInicioProceso;
	private Date fechaFinProceso;
	private Date fechaCanceladoProceso;
	
	public VistaTareaEstadoDTO () {}

	/**
	 * @return the id
	 */
	public VistaTareaEstadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaTareaEstadoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoTareaPadre
	 */
	public Long getCodigoTareaPadre() {
		return codigoTareaPadre;
	}

	/**
	 * @param codigoTareaPadre the codigoTareaPadre to set
	 */
	public void setCodigoTareaPadre(Long codigoTareaPadre) {
		this.codigoTareaPadre = codigoTareaPadre;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the codigoEstadoTarea
	 */
	public Long getCodigoEstadoTarea() {
		return codigoEstadoTarea;
	}

	/**
	 * @param codigoEstadoTarea the codigoEstadoTarea to set
	 */
	public void setCodigoEstadoTarea(Long codigoEstadoTarea) {
		this.codigoEstadoTarea = codigoEstadoTarea;
	}

	/**
	 * @return the codCatValPadreTareaEstado
	 */
	public String getCodCatValPadreTareaEstado() {
		return codCatValPadreTareaEstado;
	}

	/**
	 * @param codCatValPadreTareaEstado the codCatValPadreTareaEstado to set
	 */
	public void setCodCatValPadreTareaEstado(String codCatValPadreTareaEstado) {
		this.codCatValPadreTareaEstado = codCatValPadreTareaEstado;
	}

	/**
	 * @return the codCatValTipoPadreTareaEstado
	 */
	public Integer getCodCatValTipoPadreTareaEstado() {
		return codCatValTipoPadreTareaEstado;
	}

	/**
	 * @param codCatValTipoPadreTareaEstado the codCatValTipoPadreTareaEstado to set
	 */
	public void setCodCatValTipoPadreTareaEstado(Integer codCatValTipoPadreTareaEstado) {
		this.codCatValTipoPadreTareaEstado = codCatValTipoPadreTareaEstado;
	}

	/**
	 * @return the codCatValRelacionadoTareaEstado
	 */
	public String getCodCatValRelacionadoTareaEstado() {
		return codCatValRelacionadoTareaEstado;
	}

	/**
	 * @param codCatValRelacionadoTareaEstado the codCatValRelacionadoTareaEstado to set
	 */
	public void setCodCatValRelacionadoTareaEstado(String codCatValRelacionadoTareaEstado) {
		this.codCatValRelacionadoTareaEstado = codCatValRelacionadoTareaEstado;
	}

	/**
	 * @return the codCatValTipoRelacionadoTareaEstado
	 */
	public Integer getCodCatValTipoRelacionadoTareaEstado() {
		return codCatValTipoRelacionadoTareaEstado;
	}


	/**
	 * @param codCatValTipoRelacionadoTareaEstado the codCatValTipoRelacionadoTareaEstado to set
	 */
	public void setCodCatValTipoRelacionadoTareaEstado(Integer codCatValTipoRelacionadoTareaEstado) {
		this.codCatValTipoRelacionadoTareaEstado = codCatValTipoRelacionadoTareaEstado;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	/**
	 * @return the nomCatValEstTarRel
	 */
	public String getNomCatValEstTarRel() {
		return nomCatValEstTarRel;
	}

	/**
	 * @param nomCatValEstTarRel the nomCatValEstTarRel to set
	 */
	public void setNomCatValEstTarRel(String nomCatValEstTarRel) {
		this.nomCatValEstTarRel = nomCatValEstTarRel;
	}

	/**
	 * @return the fechaInicioProceso
	 */
	public Date getFechaInicioProceso() {
		return fechaInicioProceso;
	}

	/**
	 * @param fechaInicioProceso the fechaInicioProceso to set
	 */
	public void setFechaInicioProceso(Date fechaInicioProceso) {
		this.fechaInicioProceso = fechaInicioProceso;
	}

	/**
	 * @return the fechaFinProceso
	 */
	public Date getFechaFinProceso() {
		return fechaFinProceso;
	}

	/**
	 * @param fechaFinProceso the fechaFinProceso to set
	 */
	public void setFechaFinProceso(Date fechaFinProceso) {
		this.fechaFinProceso = fechaFinProceso;
	}

	/**
	 * @return the fechaCanceladoProceso
	 */
	public Date getFechaCanceladoProceso() {
		return fechaCanceladoProceso;
	}

	/**
	 * @param fechaCanceladoProceso the fechaCanceladoProceso to set
	 */
	public void setFechaCanceladoProceso(Date fechaCanceladoProceso) {
		this.fechaCanceladoProceso = fechaCanceladoProceso;
	}

	/**
	 * @return the profileId
	 */
	public String getProfileId() {
		return profileId;
	}

	/**
	 * @param profileId the profileId to set
	 */
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	/**
	 * @return the profileName
	 */
	public String getProfileName() {
		return profileName;
	}

	/**
	 * @param profileName the profileName to set
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	/**
	 * @return the referenceCode
	 */
	public String getReferenceCode() {
		return referenceCode;
	}

	/**
	 * @param referenceCode the referenceCode to set
	 */
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userCompleteName
	 */
	public String getUserCompleteName() {
		return userCompleteName;
	}

	/**
	 * @param userCompleteName the userCompleteName to set
	 */
	public void setUserCompleteName(String userCompleteName) {
		this.userCompleteName = userCompleteName;
	}

	/**
	 * @return the fechaFinTarea
	 */
	public Date getFechaFinTarea() {
		
		if (fechaCanceladoProceso != null) {
			return fechaCanceladoProceso;
		} else if (fechaFinProceso != null) {
			return fechaFinProceso;
		}
		return null;
	}

	/**
	 * @return the duracion
	 */
	public String getDuracion() {
		
		if (fechaInicioProceso != null && this.getFechaFinTarea()!=null) {
			
			Long diff = this.getFechaFinTarea().getTime() - fechaInicioProceso.getTime();
			
			Long modSeconds = (diff / 1000) % 60;
			Long modMinutes = (diff / (60 * 1000)) % 60;
			Long modHours = (diff / (60 * 60 * 1000)) % 24;
			
			return new StringBuilder().append(concatenarHora(modHours)).append(":").append(concatenarHora(modMinutes)).append(":").append(concatenarHora(modSeconds)).toString();
			
		}
		
		return null;
	}
	
	private StringBuilder concatenarHora(Long modulo) {
		
		StringBuilder time = new StringBuilder(modulo.toString());
		if (time.length()==1) {
			return new StringBuilder().append("0").append(time);
		}
		
		return time;
	}

	/**
	 * @return the codigoTipoTareaPerfil
	 */
	public Long getCodigoTipoTareaPerfil() {
		return codigoTipoTareaPerfil;
	}

	/**
	 * @param codigoTipoTareaPerfil the codigoTipoTareaPerfil to set
	 */
	public void setCodigoTipoTareaPerfil(Long codigoTipoTareaPerfil) {
		this.codigoTipoTareaPerfil = codigoTipoTareaPerfil;
	}

}
