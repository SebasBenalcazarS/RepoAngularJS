package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.EmbeddedId;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaAsignacionUsuariosBodegaID;

/**
 * @author cpescobar
 *
 */
@SuppressWarnings("serial")
public class VistaAsignacionUsuariosBodegaDTO extends SimpleAuditDTO {

	@EmbeddedId
	private VistaAsignacionUsuariosBodegaID id = new VistaAsignacionUsuariosBodegaID();
	
	private String idx;
	//campos de la tabla ProfileDto - KSSEGTPROFILE
	private String  nombrePerfil;
	private String codigoPerfil;
	
	//campos de la tabla UserDto - KSSEGTUSER
	private String usuario;
	private String nombreUsuario;

	//campos de la tabla ProcesoDTO - SSPCOTPROCESO
	private String nombreProceso;
	private Long codigoProceso;
	
	//campos de la tabla FuncionarioPerfilDTO - SSPCOTFUNPROPER
	private Collection<FuncionarioProcesoPerfilDTO> procesosPerfilCol;

	//campos de la tabla FuncionarioLogisticoDTO - SSPCOTFUNLOG
	private String estadoUsuario;
	private String estadoActualUsuario;
	private Long secuencialFuncionarioLogistico;
	private String codigoFuncionario;
	
	//campos de la tabla FuncionarioPosocesoPerfilAreaTrabajo
	private Integer codigoAreaTrabajo;
	private Integer codigoAreaSublugarTrabajo;
	
	private String nombreCD;
	private String nombreBodega;
	private String nombreSubBodega;
	
	private Integer codigoReferenciaCD;
	private Integer codigoReferenciaBodega;
	private Integer codigoReferenciaSubBodega;
	
	private Boolean seleccionado = Boolean.FALSE;
	
	public VistaAsignacionUsuariosBodegaDTO () {}

	/**
	 * @return the id
	 */
	public VistaAsignacionUsuariosBodegaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaAsignacionUsuariosBodegaID id) {
		this.id = id;
	}


	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the nombreProceso
	 */
	public String getNombreProceso() {
		return nombreProceso;
	}

	/**
	 * @param nombreProceso the nombreProceso to set
	 */
	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}

	/**
	 * @return the nombrePerfil
	 */
	public String getNombrePerfil() {
		return nombrePerfil;
	}

	/**
	 * @param nombrePerfil the nombrePerfil to set
	 */
	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	/**
	 * @return the codigoPerfil
	 */
	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	/**
	 * @param codigoPerfil the codigoPerfil to set
	 */
	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	/**
	 * @return the estadoUsuario
	 */
	public String getEstadoUsuario() {
		return estadoUsuario;
	}

	/**
	 * @param estadoUsuario the estadoUsuario to set
	 */
	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	/**
	 * @return the estadoActualUsuario
	 */
	public String getEstadoActualUsuario() {
		return estadoActualUsuario;
	}

	/**
	 * @param estadoActualUsuario the estadoActualUsuario to set
	 */
	public void setEstadoActualUsuario(String estadoActualUsuario) {
		this.estadoActualUsuario = estadoActualUsuario;
	}

	/**
	 * @return the secuencialFuncionarioLogistico
	 */
	public Long getSecuencialFuncionarioLogistico() {
		return secuencialFuncionarioLogistico;
	}

	/**
	 * @param secuencialFuncionarioLogistico the secuencialFuncionarioLogistico to set
	 */
	public void setSecuencialFuncionarioLogistico(Long secuencialFuncionarioLogistico) {
		this.secuencialFuncionarioLogistico = secuencialFuncionarioLogistico;
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

	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	/**
	 * @return the codigoAreaSublugarTrabajo
	 */
	public Integer getCodigoAreaSublugarTrabajo() {
		return codigoAreaSublugarTrabajo;
	}

	/**
	 * @param codigoAreaSublugarTrabajo the codigoAreaSublugarTrabajo to set
	 */
	public void setCodigoAreaSublugarTrabajo(Integer codigoAreaSublugarTrabajo) {
		this.codigoAreaSublugarTrabajo = codigoAreaSublugarTrabajo;
	}

	/**
	 * @return the procesosPerfilCol
	 */
	public Collection<FuncionarioProcesoPerfilDTO> getProcesosPerfilCol() {
		return procesosPerfilCol;
	}

	/**
	 * @param procesosPerfilCol the procesosPerfilCol to set
	 */
	public void setProcesosPerfilCol(Collection<FuncionarioProcesoPerfilDTO> procesosPerfilCol) {
		this.procesosPerfilCol = procesosPerfilCol;
	}

	/**
	 * @return the nombreCD
	 */
	public String getNombreCD() {
		return nombreCD;
	}

	/**
	 * @param nombreCD the nombreCD to set
	 */
	public void setNombreCD(String nombreCD) {
		this.nombreCD = nombreCD;
	}

	/**
	 * @return the nombreBodega
	 */
	public String getNombreBodega() {
		return nombreBodega;
	}

	/**
	 * @param nombreBodega the nombreBodega to set
	 */
	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}

	/**
	 * @return the nombreSubBodega
	 */
	public String getNombreSubBodega() {
		return nombreSubBodega;
	}

	/**
	 * @param nombreSubBodega tyhe nombreSubBodega to set
	 */
	public void setNombreSubBodega(String nombreSubBodega) {
		this.nombreSubBodega = nombreSubBodega;
	}

	/**
	 * @return the codigoReferenciaCD
	 */
	public Integer getCodigoReferenciaCD() {
		return codigoReferenciaCD;
	}

	/**
	 * @param codigoReferenciaCD the codigoReferenciaCD to set
	 */
	public void setCodigoReferenciaCD(Integer codigoReferenciaCD) {
		this.codigoReferenciaCD = codigoReferenciaCD;
	}

	/**
	 * @return the codigoReferenciaBodega
	 */
	public Integer getCodigoReferenciaBodega() {
		return codigoReferenciaBodega;
	}

	/**
	 * @param codigoReferenciaBodega the codigoReferenciaBodega to set
	 */
	public void setCodigoReferenciaBodega(Integer codigoReferenciaBodega) {
		this.codigoReferenciaBodega = codigoReferenciaBodega;
	}

	/**
	 * @return the codigoReferenciaSubBodega
	 */
	public Integer getCodigoReferenciaSubBodega() {
		return codigoReferenciaSubBodega;
	}

	/**
	 * @param codigoReferenciaSubBodega the codigoReferenciaSubBodega to set
	 */
	public void setCodigoReferenciaSubBodega(Integer codigoReferenciaSubBodega) {
		this.codigoReferenciaSubBodega = codigoReferenciaSubBodega;
	}	

	/**
	 * @return the codigoProceso
	 */
	public Long getCodigoProceso() {
		return codigoProceso;
	}

	/**
	 * @param codigoProceso the codigoProceso to set
	 */
	public void setCodigoProceso(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}

	/**
	 * @return the idx
	 */
	public String getIdx() {
		return idx;
	}

	/**
	 * @param idx the idx to set
	 */
	public void setIdx(String idx) {
		this.idx = idx;
	}

	/**
	 * @return the seleccionado
	 */
	public Boolean getSeleccionado() {
		return seleccionado;
	}

	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	
}
