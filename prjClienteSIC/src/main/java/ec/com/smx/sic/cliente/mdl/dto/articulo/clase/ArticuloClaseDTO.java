package ec.com.smx.sic.cliente.mdl.dto.articulo.clase;

import static javax.persistence.FetchType.LAZY;

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
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author mgranda
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTARTCLA")
public class ArticuloClaseDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private ArticuloID id = new ArticuloID();
	
	@ComparatorTypeField
	@Column(name="CODIGOTIPOCAUSAL", nullable=true)
	private Integer codigoTipoCausal;

	@ComparatorTypeField
	@Column(name="VALORTIPOCAUSAL", nullable=true)
	private String valorTipoCausal;
	
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = "SCARTSECARTCLA")
	@Column(name="CODIGOARTCLA", nullable=true, unique=true, updatable=false)
	private Long secuencialArtCla;
	
	@Column(name="IDUSUARIOCAMBIOCLASE", nullable=true)
	private String idUsuarioCambioClase;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHACAMBIOCLASE", nullable=true)
	private Date fechaCambioClase; 
	
	@Column(name="IDUSUARIOMODIFICACION", nullable=true, insertable=false)
	private String idUsuarioModificacion;

	@Column(name="FECHAMODIFICACION", nullable=true, insertable=false)
	private Timestamp fechaModificacion;
	
	@Transient
	private String claseArticulo;
	
	@Transient
	private String claseArticuloAnterior;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
	@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloDTO articulo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOCAUSAL", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
				  @JoinColumn(name="CODIGOTIPOCAUSAL", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoCausal;

	public ArticuloID getId() {
		return id;
	}

	public void setId(ArticuloID id) {
		this.id = id;
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

	public Long getSecuencialArtCla() {
		return secuencialArtCla;
	}

	public void setSecuencialArtCla(Long secuencialArtCla) {
		this.secuencialArtCla = secuencialArtCla;
	}

	public String getIdUsuarioCambioClase() {
		return idUsuarioCambioClase;
	}

	public void setIdUsuarioCambioClase(String idUsuarioCambioClase) {
		this.idUsuarioCambioClase = idUsuarioCambioClase;
	}

	public Date getFechaCambioClase() {
		return fechaCambioClase;
	}

	public void setFechaCambioClase(Date fechaCambioClase) {
		this.fechaCambioClase = fechaCambioClase;
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

	public String getClaseArticulo() {
		return claseArticulo;
	}

	public void setClaseArticulo(String claseArticulo) {
		this.claseArticulo = claseArticulo;
	}

	public String getClaseArticuloAnterior() {
		return claseArticuloAnterior;
	}

	public void setClaseArticuloAnterior(String claseArticuloAnterior) {
		this.claseArticuloAnterior = claseArticuloAnterior;
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
}
