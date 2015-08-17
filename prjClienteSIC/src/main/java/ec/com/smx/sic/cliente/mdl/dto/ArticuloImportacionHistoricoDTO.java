package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
import ec.com.smx.corpv2.dto.MonedaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloImportacionHistoricoID;

@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTARTPROIMPHIS")
public class ArticuloImportacionHistoricoDTO extends SimpleAuditDTO {
	@EmbeddedId
	private ArticuloImportacionHistoricoID id;
	
	@Column(name = "CODIGOARTICULO", nullable = false)
	@ComparatorTypeField
	private String codigoArticulo;

	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;
	
	@Column(name = "CODIGOMONEDAORIGEN")
	private Long codigoMonedaOrigen;

	@Column(name = "COSTOMONEDAORIGEN")
	private BigDecimal costoMonedaOrigen;
	
	@Column(name = "DESCRIPCIONARTICULO")
	private String descripcionArticulo;
	
	@Column(name = "PORCENTAJECOMISION")
	private Double porcentajeComision;
	
	@Column(name="VALORFACTOR",nullable=true)
	private Double valorFactor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHAAPLICACIONFACTOR",nullable=true)
	private Date fechaAplicacionFactor;
	
	@RegisterUserIdField
	private String idUsuarioRegistro;

	@RegisterDateField
	private Timestamp fechaRegistro;

	@LastModifierUserIdField
	private String idUsuarioModificacion;

	@LastModificationDateField
	private Timestamp fechaModificacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHAREVISION",nullable=false)
	private Date fechaRevision;

	public ArticuloImportacionHistoricoDTO(){
		super();
		this.id = new ArticuloImportacionHistoricoID();
	}
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ArticuloImportacionDTO articuloImportacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name="CODIGOMONEDAORIGEN", insertable=false, updatable=false, referencedColumnName="CODIGOMONEDA")
	private MonedaDTO monedaOrigen;

	public ArticuloImportacionHistoricoID getId() {
		return id;
	}

	public void setId(ArticuloImportacionHistoricoID id) {
		this.id = id;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public Long getCodigoMonedaOrigen() {
		return codigoMonedaOrigen;
	}

	public void setCodigoMonedaOrigen(Long codigoMonedaOrigen) {
		this.codigoMonedaOrigen = codigoMonedaOrigen;
	}

	public BigDecimal getCostoMonedaOrigen() {
		return costoMonedaOrigen;
	}

	public void setCostoMonedaOrigen(BigDecimal costoMonedaOrigen) {
		this.costoMonedaOrigen = costoMonedaOrigen;
	}

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public Double getPorcentajeComision() {
		return porcentajeComision;
	}

	public void setPorcentajeComision(Double porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}

	public Double getValorFactor() {
		return valorFactor;
	}

	public void setValorFactor(Double valorFactor) {
		this.valorFactor = valorFactor;
	}

	/**
	 * @return the fechaAplicacionFactor
	 */
	public Date getFechaAplicacionFactor() {
		return fechaAplicacionFactor;
	}

	/**
	 * @param fechaAplicacionFactor the fechaAplicacionFactor to set
	 */
	public void setFechaAplicacionFactor(Date fechaAplicacionFactor) {
		this.fechaAplicacionFactor = fechaAplicacionFactor;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the fechaRevision
	 */
	public Date getFechaRevision() {
		return fechaRevision;
	}

	/**
	 * @param fechaRevision the fechaRevision to set
	 */
	public void setFechaRevision(Date fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	public ArticuloImportacionDTO getArticuloImportacion() {
		return articuloImportacion;
	}

	public void setArticuloImportacion(ArticuloImportacionDTO articuloImportacion) {
		this.articuloImportacion = articuloImportacion;
	}

	public MonedaDTO getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(MonedaDTO monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
}
