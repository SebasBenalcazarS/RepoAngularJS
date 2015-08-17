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

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraEstadoImpuestoID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCORCTORDCOMESTIMP")
public class OrdenCompraEstadoImpuestoDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private OrdenCompraEstadoImpuestoID id = new OrdenCompraEstadoImpuestoID();
	
	
	@Column(name = "CODIGOORDENCOMPRAESTADO", nullable=false)
	private Long codigoOrdenCompraEstado;
	
	@Column(name = "CODIGOGRUPOIMPUESTO")
	private String codigoGrupoImpuesto;
	
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
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOGRUPOIMPUESTO", referencedColumnName = "CODIGOGRUPOIMPUESTO", insertable = false, updatable = false)
	})
	private GrupoImpuestoDTO grupoImpuesto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
	    @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
	    @JoinColumn(name = "CODIGOORDENCOMPRAESTADO", referencedColumnName = "CODIGOORDENCOMPRAESTADO", insertable = false, updatable = false)
	})
	private OrdenCompraEstadoDTO ordenCompraEstado;
	
	
	
	/**
	 * @return the id
	 */
	public OrdenCompraEstadoImpuestoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(OrdenCompraEstadoImpuestoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoOrdenCompraEstado
	 */
	public Long getCodigoOrdenCompraEstado() {
		return codigoOrdenCompraEstado;
	}

	/**
	 * @param codigoOrdenCompraEstado the codigoOrdenCompraEstado to set
	 */
	public void setCodigoOrdenCompraEstado(Long codigoOrdenCompraEstado) {
		this.codigoOrdenCompraEstado = codigoOrdenCompraEstado;
	}

	/**
	 * @return the codigoGrupoImpuesto
	 */
	public String getCodigoGrupoImpuesto() {
		return codigoGrupoImpuesto;
	}

	/**
	 * @param codigoGrupoImpuesto the codigoGrupoImpuesto to set
	 */
	public void setCodigoGrupoImpuesto(String codigoGrupoImpuesto) {
		this.codigoGrupoImpuesto = codigoGrupoImpuesto;
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
	 * @return the ordenCompraEstado
	 */
	public OrdenCompraEstadoDTO getOrdenCompraEstado() {
		return ordenCompraEstado;
	}

	/**
	 * @param ordenCompraEstado the ordenCompraEstado to set
	 */
	public void setOrdenCompraEstado(OrdenCompraEstadoDTO ordenCompraEstado) {
		this.ordenCompraEstado = ordenCompraEstado;
	}

	/**
	 * @return the grupoImpuesto
	 */
	public GrupoImpuestoDTO getGrupoImpuesto() {
		return grupoImpuesto;
	}

	/**
	 * @param grupoImpuesto the grupoImpuesto to set
	 */
	public void setGrupoImpuesto(GrupoImpuestoDTO grupoImpuesto) {
		this.grupoImpuesto = grupoImpuesto;
	}

}
