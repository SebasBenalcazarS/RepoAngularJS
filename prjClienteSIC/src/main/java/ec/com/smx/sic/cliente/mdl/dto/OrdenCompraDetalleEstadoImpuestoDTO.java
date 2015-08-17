/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraDetalleEstadoImpuestoID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCORCTORDCOMDETESTIMP")
public class OrdenCompraDetalleEstadoImpuestoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private OrdenCompraDetalleEstadoImpuestoID id = new OrdenCompraDetalleEstadoImpuestoID();
	
	
	@Column(name = "CODIGOORDENCOMPRADETALLEESTADO", nullable=false)
	private Long codigoOrdenCompraDetalleEstado;
	
	@Column(name = "CODIGOTIPOIMPUESTO")
	private Integer codigoTipoImpuesto;
	
	@Column(name = "PORCENTAJEIMPUESTO")
	private BigDecimal porcentajeImpuesto;
	
	@Column(name = "VALORADICIONAL")
	private BigDecimal valorAdicional;
	
	@Column(name = "VALORTOTALIMPUESTO")
	private BigDecimal valorTotalImpuesto;
	
	@Column(name = "ESTADO", nullable = false)
	@ComparatorTypeField
	private String estado;
	
	@RegisterUserIdField
	@Column(name = "IDUSUARIOREGISTRO", nullable=false)
    @ComparatorTypeField
    private String idUsuarioRegistro;
   
    @RegisterDateField
    @Column(name = "FECHAREGISTRO", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@LastModifierUserIdField
	@Column(name = "IDUSUARIOMODIFICACION")
	@ComparatorTypeField
	private String idUsuarioModificacion;
	
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;
	
	@Transient
	private Integer codigoOrdenacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
	    @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
	    @JoinColumn(name = "CODIGOORDENCOMPRADETALLEESTADO", referencedColumnName = "CODIGOORDENCOMPRADETALLEESTADO", insertable = false, updatable = false)
	})
	private OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOIMPUESTO", referencedColumnName = "CODIGOTIPOIMPUESTO", insertable = false, updatable = false)
	})
	private TipoImpuestoDTO tipoImpuesto;
	
	/**
	 * @return the id
	 */
	public OrdenCompraDetalleEstadoImpuestoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(OrdenCompraDetalleEstadoImpuestoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoOrdenCompraDetalleEstado
	 */
	public Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}

	/**
	 * @param codigoOrdenCompraDetalleEstado the codigoOrdenCompraDetalleEstado to set
	 */
	public void setCodigoOrdenCompraDetalleEstado(Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
	}

	/**
	 * @return the codigoTipoImpuesto
	 */
	public Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}

	/**
	 * @param codigoTipoImpuesto the codigoTipoImpuesto to set
	 */
	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
	}

	/**
	 * @return the porcentajeImpuesto
	 */
	public BigDecimal getPorcentajeImpuesto() {
		return porcentajeImpuesto;
	}

	/**
	 * @param porcentajeImpuesto the porcentajeImpuesto to set
	 */
	public void setPorcentajeImpuesto(BigDecimal porcentajeImpuesto) {
		this.porcentajeImpuesto = porcentajeImpuesto;
	}

	/**
	 * @return the valorAdicional
	 */
	public BigDecimal getValorAdicional() {
		return valorAdicional;
	}

	/**
	 * @param valorAdicional the valorAdicional to set
	 */
	public void setValorAdicional(BigDecimal valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	/**
	 * @return the valorTotalImpuesto
	 */
	public BigDecimal getValorTotalImpuesto() {
		return valorTotalImpuesto;
	}

	/**
	 * @param valorTotalImpuesto the valorTotalImpuesto to set
	 */
	public void setValorTotalImpuesto(BigDecimal valorTotalImpuesto) {
		this.valorTotalImpuesto = valorTotalImpuesto;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
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
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the ordenCompraDetalleEstado
	 */
	public OrdenCompraDetalleEstadoDTO getOrdenCompraDetalleEstado() {
		return ordenCompraDetalleEstado;
	}

	/**
	 * @param ordenCompraDetalleEstado the ordenCompraDetalleEstado to set
	 */
	public void setOrdenCompraDetalleEstado(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstado) {
		this.ordenCompraDetalleEstado = ordenCompraDetalleEstado;
	}

	/**
	 * @return the tipoImpuesto
	 */
	public TipoImpuestoDTO getTipoImpuesto() {
		return tipoImpuesto;
	}

	/**
	 * @param tipoImpuesto the tipoImpuesto to set
	 */
	public void setTipoImpuesto(TipoImpuestoDTO tipoImpuesto) {
		this.tipoImpuesto = tipoImpuesto;
	}

	/**
	 * @return the codigoOrdenacion
	 */
	public Integer getCodigoOrdenacion() {
		//Ordenacion
		if (codigoOrdenacion == null && tipoImpuesto != null && SearchDTO.isLoaded(tipoImpuesto)){
			if (tipoImpuesto.getCodigoGrupoImpuesto().equals(SICArticuloConstantes.getInstancia().GRUPOIMPUESTO_IVA)) {
				this.codigoOrdenacion = Integer.valueOf(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO);
			} else if (tipoImpuesto.getCodigoGrupoImpuesto().equals(SICArticuloConstantes.getInstancia().GRUPOIMPUESTO_VERDE)) {
				this.codigoOrdenacion = Integer.valueOf(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO + 1);
			} else if (tipoImpuesto.getCodigoGrupoImpuesto().equals(SICArticuloConstantes.getInstancia().GRUPOIMPUESTO_DISNEY)) {
				this.codigoOrdenacion = Integer.valueOf(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO + 2);;
			}
		}
		return codigoOrdenacion;
	}

	/**
	 * @param codigoOrdenacion the codigoOrdenacion to set
	 */
	public void setCodigoOrdenacion(Integer codigoOrdenacion) {
		this.codigoOrdenacion = codigoOrdenacion;
	}
}
