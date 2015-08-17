package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.RangoAccionPeriodoID;

/**
 * Permite almacenar el rango de accion permitido para el periodo de trabajo
 * @author fcollaguazo
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "SCSADTRANACCPER")
public class RangoAccionPeriodoDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	RangoAccionPeriodoID id = new RangoAccionPeriodoID();
	
	private Integer codigoPeriodoTrabajo;
	
	@ComparatorTypeField
	private String valorTipoAccion;
	
	private Integer codigoTipoAccion;
	
	private Date fechaInicioAccion;
	
	private Date fechaFinAccion;
	
	@ComparatorTypeField
	private String estado;
	
	@RegisterUserIdField
	private java.lang.String idUsuarioRegistro;

	@RegisterDateField
	private java.util.Date fechaRegistro;

	@LastModifierUserIdField
	private java.lang.String idUsuarioModificacion;

	@LastModificationDateField
	private java.util.Date fechaModificacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOPERIODOTRABAJO", insertable = false, updatable = false, referencedColumnName = "CODIGOPERIODOTRABAJO") })
	private PeriodoTrabajoDTO periodoTrabajoDTO;

	public RangoAccionPeriodoID getId() {
		return id;
	}

	public void setId(RangoAccionPeriodoID id) {
		this.id = id;
	}

	public Integer getCodigoPeriodoTrabajo() {
		return codigoPeriodoTrabajo;
	}

	public void setCodigoPeriodoTrabajo(Integer codigoPeriodoTrabajo) {
		this.codigoPeriodoTrabajo = codigoPeriodoTrabajo;
	}

	public String getValorTipoAccion() {
		return valorTipoAccion;
	}

	public void setValorTipoAccion(String valorTipoAccion) {
		this.valorTipoAccion = valorTipoAccion;
	}

	public Integer getCodigoTipoAccion() {
		return codigoTipoAccion;
	}

	public void setCodigoTipoAccion(Integer codigoTipoAccion) {
		this.codigoTipoAccion = codigoTipoAccion;
	}

	public Date getFechaInicioAccion() {
		return fechaInicioAccion;
	}

	public void setFechaInicioAccion(Date fechaInicioAccion) {
		this.fechaInicioAccion = fechaInicioAccion;
	}

	public Date getFechaFinAccion() {
		return fechaFinAccion;
	}

	public void setFechaFinAccion(Date fechaFinAccion) {
		this.fechaFinAccion = fechaFinAccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public PeriodoTrabajoDTO getPeriodoTrabajoDTO() {
		return periodoTrabajoDTO;
	}

	public void setPeriodoTrabajoDTO(PeriodoTrabajoDTO periodoTrabajoDTO) {
		this.periodoTrabajoDTO = periodoTrabajoDTO;
	}
}