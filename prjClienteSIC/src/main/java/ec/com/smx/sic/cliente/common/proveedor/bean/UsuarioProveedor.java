package ec.com.smx.sic.cliente.common.proveedor.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.corpv2.dto.VistaUsuariosFuncionarioPersonaLocalizacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;

/**
 * @author lyacchirema
 * @author vjaramillo
 *
 */
public class UsuarioProveedor extends SearchDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private VistaUsuariosFuncionarioPersonaLocalizacionDTO vistaUsuario;	
	private String emailInicial;
	private Boolean accesoReportes;
	private Boolean filtradoPorRol;
	private String estadoAccesoReportesInicial;
	private Timestamp fechaEnvioMail;
	private ProveedorDTO proveedor;
	
	public UsuarioProveedor() {
		// Inicializa variables
		this.accesoReportes = Boolean.FALSE;
		this.filtradoPorRol = Boolean.FALSE;
		this.fechaEnvioMail = null;
	}

	/**
	 * @return the vistaUsuario
	 */
	public VistaUsuariosFuncionarioPersonaLocalizacionDTO getVistaUsuario() {
		return vistaUsuario;
	}

	/**
	 * @param vistaUsuario the vistaUsuario to set
	 */
	public void setVistaUsuario(
			VistaUsuariosFuncionarioPersonaLocalizacionDTO vistaUsuario) {
		this.vistaUsuario = vistaUsuario;
	}

	/**
	 * @return the filtradoPorRol
	 */
	public Boolean getFiltradoPorRol() {
		return filtradoPorRol;
	}

	/**
	 * @param filtradoPorRol the filtradoPorRol to set
	 */
	public void setFiltradoPorRol(Boolean filtradoPorRol) {
		this.filtradoPorRol = filtradoPorRol;
	}

	/**
	 * @return the emailInicial
	 */
	public String getEmailInicial() {
		return emailInicial;
	}

	/**
	 * @param emailInicial the emailInicial to set
	 */
	public void setEmailInicial(String emailInicial) {
		this.emailInicial = emailInicial;
	}

	/**
	 * @return the accesoReportes
	 */
	public Boolean getAccesoReportes() {
		return accesoReportes;
	}

	/**
	 * @param accesoReportes the accesoReportes to set
	 */
	public void setAccesoReportes(Boolean accesoReportes) {
		this.accesoReportes = accesoReportes;
	}

	/**
	 * @return the estadoAccesoReportesInicial
	 */
	public String getEstadoAccesoReportesInicial() {
		return estadoAccesoReportesInicial;
	}

	/**
	 * @param estadoAccesoReportesInicial the estadoAccesoReportesInicial to set
	 */
	public void setEstadoAccesoReportesInicial(String estadoAccesoReportesInicial) {
		this.estadoAccesoReportesInicial = estadoAccesoReportesInicial;
	}

	/**
	 * @return the fechaEnvioMail
	 */
	public Timestamp getFechaEnvioMail() {
		return fechaEnvioMail;
	}

	/**
	 * @param fechaEnvioMail the fechaEnvioMail to set
	 */
	public void setFechaEnvioMail(Timestamp fechaEnvioMail) {
		this.fechaEnvioMail = fechaEnvioMail;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		id = this.vistaUsuario.getCodigoFuncionario();
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public ProveedorDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}
	
	
}
