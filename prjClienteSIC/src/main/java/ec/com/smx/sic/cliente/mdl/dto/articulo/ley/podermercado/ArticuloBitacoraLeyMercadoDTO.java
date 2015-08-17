package ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado;

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
import ec.com.smx.sic.cliente.mdl.dto.id.articulo.ArticuloBitacoraLeyMercadoID;

/**
 * Entidad que maneja la informacion de los estados del articulo segun Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
 * @author mgranda
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTBITARTLEYMER")
public class ArticuloBitacoraLeyMercadoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ArticuloBitacoraLeyMercadoID id = new ArticuloBitacoraLeyMercadoID();
	
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;
	
	@ComparatorTypeField
	@Column(name="CODIGOTIPOESTADO", nullable=true)
	private Integer codigoTipoEstado;

	@ComparatorTypeField
	@Column(name="VALORTIPOESTADO", nullable=true)
	private String valorTipoEstado;
	
	@Column(name="USUARIOCAMBIOESTADO", nullable=true)
	private String idUsuarioCambioEstado;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHACAMBIOESTADO", nullable=true)
	private Date fechaCambioEstado; 
	
	@ComparatorTypeField
	@Column(name="CODIGOTIPOCAUSAL", nullable=true)
	private Integer codigoTipoCausal;

	@ComparatorTypeField
	@Column(name="VALORTIPOCAUSAL", nullable=true)
	private String valorTipoCausal;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
	@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloDTO articulo;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOCAUSAL", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
				  @JoinColumn(name="CODIGOTIPOCAUSAL", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoCausal;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOESTADO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
				  @JoinColumn(name="CODIGOTIPOESTADO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoEstado;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name="USUARIOCAMBIOESTADO", referencedColumnName="USERID", insertable=false, updatable=false)
	private UserDto usuarioCambioEstado;
	
	//=============================================================================
	//		METODOS DE ACCESO - GETTERS Y SETTERS
	//=============================================================================
	
	public ArticuloBitacoraLeyMercadoID getId() {
		return id;
	}

	public void setId(ArticuloBitacoraLeyMercadoID id) {
		this.id = id;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public Integer getCodigoTipoEstado() {
		return codigoTipoEstado;
	}

	public void setCodigoTipoEstado(Integer codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
	}

	public String getValorTipoEstado() {
		return valorTipoEstado;
	}

	public void setValorTipoEstado(String valorTipoEstado) {
		this.valorTipoEstado = valorTipoEstado;
	}

	public String getIdUsuarioCambioEstado() {
		return idUsuarioCambioEstado;
	}

	public void setIdUsuarioCambioEstado(String idUsuarioCambioEstado) {
		this.idUsuarioCambioEstado = idUsuarioCambioEstado;
	}

	public Date getFechaCambioEstado() {
		return fechaCambioEstado;
	}

	public void setFechaCambioEstado(Date fechaCambioEstado) {
		this.fechaCambioEstado = fechaCambioEstado;
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

	public CatalogoValorDTO getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(CatalogoValorDTO tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	public UserDto getUsuarioCambioEstado() {
		return usuarioCambioEstado;
	}

	public void setUsuarioCambioEstado(UserDto usuarioCambioEstado) {
		this.usuarioCambioEstado = usuarioCambioEstado;
	}
}