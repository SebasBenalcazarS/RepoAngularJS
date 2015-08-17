package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.PeriodoTrabajoID;

/**
 * Permite almacenar los periodos de trabajo
 * @author fcollaguazo
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "SCSADTPERTRA")
public class PeriodoTrabajoDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	PeriodoTrabajoID id = new PeriodoTrabajoID();
	
	private Date fechaInicioPeriodo;
	
	private Date fechaFinPeriodo;
	
	private Integer codigoEstadoPeriodo;
	
	@ComparatorTypeField
	private String valorEstadoPeriodo;
	
	@ComparatorTypeField
	private String codigoReferencia;
	
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
	
	@OneToMany(mappedBy = "periodoTrabajoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<RangoAccionPeriodoDTO> rangoAccionPeriodoCol;

	public PeriodoTrabajoID getId() {
		return id;
	}

	public void setId(PeriodoTrabajoID id) {
		this.id = id;
	}

	public Date getFechaInicioPeriodo() {
		return fechaInicioPeriodo;
	}

	public void setFechaInicioPeriodo(Date fechaInicioPeriodo) {
		this.fechaInicioPeriodo = fechaInicioPeriodo;
	}

	public Date getFechaFinPeriodo() {
		return fechaFinPeriodo;
	}

	public void setFechaFinPeriodo(Date fechaFinPeriodo) {
		this.fechaFinPeriodo = fechaFinPeriodo;
	}

	public Integer getCodigoEstadoPeriodo() {
		return codigoEstadoPeriodo;
	}

	public void setCodigoEstadoPeriodo(Integer codigoEstadoPeriodo) {
		this.codigoEstadoPeriodo = codigoEstadoPeriodo;
	}

	public String getValorEstadoPeriodo() {
		return valorEstadoPeriodo;
	}

	public void setValorEstadoPeriodo(String valorEstadoPeriodo) {
		this.valorEstadoPeriodo = valorEstadoPeriodo;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
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

	public Collection<RangoAccionPeriodoDTO> getRangoAccionPeriodoCol() {
		return rangoAccionPeriodoCol;
	}

	public void setRangoAccionPeriodoCol(Collection<RangoAccionPeriodoDTO> rangoAccionPeriodoCol) {
		this.rangoAccionPeriodoCol = rangoAccionPeriodoCol;
	}
}