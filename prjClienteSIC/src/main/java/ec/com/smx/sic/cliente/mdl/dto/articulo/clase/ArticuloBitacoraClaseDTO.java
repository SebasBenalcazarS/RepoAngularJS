package ec.com.smx.sic.cliente.mdl.dto.articulo.clase;

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
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.articulo.ArticuloBitacoraClaseID;

/**
 * 
 * @author mgranda
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTBITARTCLA")
public class ArticuloBitacoraClaseDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ArticuloBitacoraClaseID id = new ArticuloBitacoraClaseID();
	
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;
	
	@Column(name = "CLASEARTICULO", nullable = false)
	private String claseArticulo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHAINICIO",nullable=false)
	private Date fechaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHAFIN", nullable=false)
	private Date fechaFin; 
	
	@ComparatorTypeField
	@Column(name="CODIGOTIPOCAUSAL", nullable=true)
	private Integer codigoTipoCausal;

	@ComparatorTypeField
	@Column(name="VALORTIPOCAUSAL", nullable=true)
	private String valorTipoCausal;
	
	@Column(name="IDUSUARIOCAMBIOCLASE", nullable=false)
	private String idUsuarioCambioClase;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
	@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloDTO articulo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOCAUSAL", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
				  @JoinColumn(name="CODIGOTIPOCAUSAL", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoCausal;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name="IDUSUARIOCAMBIOCLASE", referencedColumnName="USERID", insertable=false, updatable=false)
	private UserDto usuarioCambioClase;

	public ArticuloBitacoraClaseID getId() {
		return id;
	}

	public void setId(ArticuloBitacoraClaseID id) {
		this.id = id;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getClaseArticulo() {
		return claseArticulo;
	}

	public void setClaseArticulo(String claseArticulo) {
		this.claseArticulo = claseArticulo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getCodigoTipoCausal() {
		return codigoTipoCausal;
	}

	public void setCodigoTipoCausal(Integer codigoTipoCausal) {
		this.codigoTipoCausal = codigoTipoCausal;
	}

	public String getValorTipoCausal() {
		return valorTipoCausal;
	}

	public void setValorTipoCausal(String valorTipoCausal) {
		this.valorTipoCausal = valorTipoCausal;
	}
	
	public String getIdUsuarioCambioClase() {
		return idUsuarioCambioClase;
	}

	public void setIdUsuarioCambioClase(String idUsuarioCambioClase) {
		this.idUsuarioCambioClase = idUsuarioCambioClase;
	}

	public ArticuloDTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	public CatalogoValorDTO getTipoCausal() {
		return tipoCausal;
	}

	public void setTipoCausal(CatalogoValorDTO tipoCausal) {
		this.tipoCausal = tipoCausal;
	}

	public UserDto getUsuarioCambioClase() {
		return usuarioCambioClase;
	}

	public void setUsuarioCambioClase(UserDto usuarioCambioClase) {
		this.usuarioCambioClase = usuarioCambioClase;
	}
}