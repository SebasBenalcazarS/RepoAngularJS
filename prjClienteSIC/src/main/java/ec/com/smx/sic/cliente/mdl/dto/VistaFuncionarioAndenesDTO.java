package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaFuncionarioAndenesID;

@SuppressWarnings("serial")
public class VistaFuncionarioAndenesDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private VistaFuncionarioAndenesID id = new VistaFuncionarioAndenesID();
	
	private String codigoFuncionario;
	private String userId;
	private String nombreUsuario;
	private String nombreCompleto;
	private Integer andenInicio;
	private Integer andenFin;
	private Long codigoDetalleSeccionInicio;
	private Long codigoDetalleSeccionFin;
	
	
	public VistaFuncionarioAndenesID getId() {
		return id;
	}

	public void setId(VistaFuncionarioAndenesID id) {
		this.id = id;
	}

	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Integer getAndenInicio() {
		return andenInicio;
	}

	public void setAndenInicio(Integer andenInicio) {
		this.andenInicio = andenInicio;
	}

	public Integer getAndenFin() {
		return andenFin;
	}

	public void setAndenFin(Integer andenFin) {
		this.andenFin = andenFin;
	}

	public Long getCodigoDetalleSeccionInicio() {
		return codigoDetalleSeccionInicio;
	}

	public void setCodigoDetalleSeccionInicio(Long codigoDetalleSeccionInicio) {
		this.codigoDetalleSeccionInicio = codigoDetalleSeccionInicio;
	}

	public Long getCodigoDetalleSeccionFin() {
		return codigoDetalleSeccionFin;
	}

	public void setCodigoDetalleSeccionFin(Long codigoDetalleSeccionFin) {
		this.codigoDetalleSeccionFin = codigoDetalleSeccionFin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
