package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.DetalleAjusteFacturaEstadoID;
@Entity
@Table(name="SCSADTDETAJUFACEST")
@SuppressWarnings("serial")
public class DetalleAjusteFacturaEstadoDTO extends SimpleAuditDTO{
	
	@EmbeddedId 
	DetalleAjusteFacturaEstadoID id = new DetalleAjusteFacturaEstadoID();
	
	@Column(name = "CODIGOAJUSTEFACTURAESTADO", nullable = false)
	private Long codigoAjusteFacturaEstado;
	
	@ComparatorTypeField
	@Column(name = "CODIGOCLASIFICACION", nullable = false)
	private String codigoClasificacion;
	
	@Column(name= "VALORAJUSTE", nullable = false)
	private BigDecimal valorAjuste;
	
	@ComparatorTypeField
	@Column(name= "CONTABILIZADO", nullable = false)
	private String contabilizado;
	
	@ComparatorTypeField
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@Column
	@RegisterDateField
	private Date fechaRegistro;
	
	@Column(nullable = false)
	@RegisterUserIdField
	private String usuarioRegistro;
	
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	private Date fechaModificacion;
	
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String usuarioModificacion;
	
	@ComparatorTypeField
	@Column(name="OBSERVACION")
	private String observacion;
	
	@ComparatorTypeField
	@Column(name="AUTORIZADOPOR")
	private String autorizadoPor;
	
	@Transient
	private String departamentoSeleccionado;
	
	@Transient
	private Boolean edicion = Boolean.FALSE;
	
	@Transient
	private Integer orden;
	
	@Transient
	private Boolean signoMas;
	
	@Transient
	private Boolean agregado;
	
	/**
	 * Referencia con la tabla AjuteFactura
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"), 
		@JoinColumn(name = "CODIGOAJUSTEFACTURAESTADO", referencedColumnName = "CODIGOAJUSTEFACTURAESTADO", insertable = false, updatable = false) })
	private AjusteFacturaEstadoDTO ajusteFacturaEstadoDTO;
	
	/**
	 * Referencia con la tabla Clasificacion
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"), 
		@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false) })
	private ClasificacionDTO clasificacionDTO;
	
	@OneToMany(mappedBy = "detalleAjusteFacturaEstadoDTO", fetch = FetchType.LAZY)
    private Collection<FlujoEstadoDetalleAjusteDTO> flujoEstadoDetalleAjusteCol;
	
	public DetalleAjusteFacturaEstadoID getId() {
		return id;
	}

	public void setId(DetalleAjusteFacturaEstadoID id) {
		this.id = id;
	}

	public Long getCodigoAjusteFacturaEstado() {
		return codigoAjusteFacturaEstado;
	}

	public void setCodigoAjusteFacturaEstado(Long codigoAjusteFacturaEstado) {
		this.codigoAjusteFacturaEstado = codigoAjusteFacturaEstado;
	}

	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	public BigDecimal getValorAjuste() {
		return valorAjuste;
	}

	public void setValorAjuste(BigDecimal valorAjuste) {
		this.valorAjuste = valorAjuste;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public AjusteFacturaEstadoDTO getAjusteFacturaEstadoDTO() {
		return ajusteFacturaEstadoDTO;
	}

	public void setAjusteFacturaEstadoDTO(AjusteFacturaEstadoDTO ajusteFacturaEstadoDTO) {
		this.ajusteFacturaEstadoDTO = ajusteFacturaEstadoDTO;
	}

	public ClasificacionDTO getClasificacionDTO() {
		return clasificacionDTO;
	}

	public void setClasificacionDTO(ClasificacionDTO clasificacionDTO) {
		this.clasificacionDTO = clasificacionDTO;
	}

	public String getDepartamentoSeleccionado() {
		if(this.codigoClasificacion != null && this.clasificacionDTO != null && this.clasificacionDTO.getDescripcionClasificacion() != null){
			this.departamentoSeleccionado = this.codigoClasificacion+" - "+ this.clasificacionDTO.getDescripcionClasificacion();
		}
		return this.departamentoSeleccionado;
	}

	public void setDepartamentoSeleccionado(String departamentoSeleccionado) {
		this.departamentoSeleccionado = departamentoSeleccionado;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		if (observacion != null)
			this.observacion = observacion.toUpperCase();
	}

	/**
	 * @return the autorizadoPor
	 */
	public String getAutorizadoPor() {
		return autorizadoPor;
	}

	/**
	 * @param autorizadoPor the autorizadoPor to set
	 */
	public void setAutorizadoPor(String autorizadoPor) {
		if(autorizadoPor != null)
			this.autorizadoPor = autorizadoPor.toUpperCase();
	}

	public String getContabilizado() {
		return contabilizado;
	}

	public void setContabilizado(String contabilizado) {
		this.contabilizado = contabilizado;
	}

	public Collection<FlujoEstadoDetalleAjusteDTO> getFlujoEstadoDetalleAjusteCol() {
		return flujoEstadoDetalleAjusteCol;
	}

	public void setFlujoEstadoDetalleAjusteCol(Collection<FlujoEstadoDetalleAjusteDTO> flujoEstadoDetalleAjusteCol) {
		this.flujoEstadoDetalleAjusteCol = flujoEstadoDetalleAjusteCol;
	}

	public Boolean getEdicion() {
		return edicion;
	}

	public void setEdicion(Boolean edicion) {
		this.edicion = edicion;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Boolean getSignoMas() {
		return signoMas;
	}

	public void setSignoMas(Boolean signoMas) {
		this.signoMas = signoMas;
	}

	public Boolean getAgregado() {
		return agregado;
	}

	public void setAgregado(Boolean agregado) {
		this.agregado = agregado;
	}
}
