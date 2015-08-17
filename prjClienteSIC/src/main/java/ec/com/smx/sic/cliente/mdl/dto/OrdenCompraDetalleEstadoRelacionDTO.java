package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraDetalleEstadoRelacionID;

/**
 * 
 * @author acaiza
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCORCTORDCOMDETESTREL")
public class OrdenCompraDetalleEstadoRelacionDTO extends SimpleAuditDTO {
	
	@EmbeddedId
    private OrdenCompraDetalleEstadoRelacionID id = new OrdenCompraDetalleEstadoRelacionID();
	
	@Column(name = "CODIGOORDENCOMPRADETALLEESTADOPADRE", nullable = false)
	private Long codigoOrdenCompraDetalleEstadoPadre;
	
	@Column(name = "CODIGOORDENCOMPRADETALLEESTADO", nullable = false)
	private Long codigoOrdenCompraDetalleEstado;
	
	@Column(name="VALORTIPORELACION")
	@ComparatorTypeField
	private String valorTipoRelacion;

	@Column(name="CODIGOTIPORELACION")
	private Integer codigoTipoRelacion;
	
	@Column(name = "ESTADO", nullable = false)
    @ComparatorTypeField
    private String estado;
    
    @RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO",  nullable=false)
    @ComparatorTypeField
    private String idUsuarioRegistro;

    @RegisterDateField
    @Column(name = "FECHAREGISTRO",  nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @LastModifierUserIdField
    @Column(name = "IDUSUARIOMODIFICACION")
    private String idUsuarioModificacion;
    
    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOORDENCOMPRADETALLEESTADOPADRE", referencedColumnName = "CODIGOORDENCOMPRADETALLEESTADO", insertable = false, updatable = false) })
	private OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTOPadre;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOORDENCOMPRADETALLEESTADO", referencedColumnName = "CODIGOORDENCOMPRADETALLEESTADO", insertable = false, updatable = false) })
	private OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO;

	public OrdenCompraDetalleEstadoRelacionID getId() {
		return id;
	}

	public void setId(OrdenCompraDetalleEstadoRelacionID id) {
		this.id = id;
	}

	public String getValorTipoRelacion() {
		return valorTipoRelacion;
	}

	public void setValorTipoRelacion(String valorTipoRelacion) {
		this.valorTipoRelacion = valorTipoRelacion;
	}

	public Integer getCodigoTipoRelacion() {
		return codigoTipoRelacion;
	}

	public void setCodigoTipoRelacion(Integer codigoTipoRelacion) {
		this.codigoTipoRelacion = codigoTipoRelacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Long getCodigoOrdenCompraDetalleEstadoPadre() {
		return codigoOrdenCompraDetalleEstadoPadre;
	}

	public void setCodigoOrdenCompraDetalleEstadoPadre(Long codigoOrdenCompraDetalleEstadoPadre) {
		this.codigoOrdenCompraDetalleEstadoPadre = codigoOrdenCompraDetalleEstadoPadre;
	}

	public Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}

	public void setCodigoOrdenCompraDetalleEstado(Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
	}

	public OrdenCompraDetalleEstadoDTO getOrdenCompraDetalleEstadoDTOPadre() {
		return ordenCompraDetalleEstadoDTOPadre;
	}

	public void setOrdenCompraDetalleEstadoDTOPadre(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTOPadre) {
		this.ordenCompraDetalleEstadoDTOPadre = ordenCompraDetalleEstadoDTOPadre;
	}

	public OrdenCompraDetalleEstadoDTO getOrdenCompraDetalleEstadoDTO() {
		return ordenCompraDetalleEstadoDTO;
	}

	public void setOrdenCompraDetalleEstadoDTO(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO) {
		this.ordenCompraDetalleEstadoDTO = ordenCompraDetalleEstadoDTO;
	}
    	
}
