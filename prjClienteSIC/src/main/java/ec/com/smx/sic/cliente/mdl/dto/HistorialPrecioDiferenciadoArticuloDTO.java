package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.mdl.dto.id.HistorialPrecioDiferenciadoArticuloID;

/**
 * @author Luis Yacchirema
 *
 */
@Entity
@Table(name="SCPRETHISPREDIFART")
@SuppressWarnings("serial")
public class HistorialPrecioDiferenciadoArticuloDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private HistorialPrecioDiferenciadoArticuloID id = new HistorialPrecioDiferenciadoArticuloID();
	
	@ComparatorTypeField
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;
	
	@Column(name="PORCENTAJEANTERIOR", nullable=false)
	private Double porcentajeAnterior;
	
	@Column(name="PORCENTAJENUEVO", nullable=false)	
	private Double porcentajeNuevo;
	
	@Column(name="PRECIOSMXANTERIOR", nullable=false)
	private Double precioSmxAnterior;
	
	@Column(name="PRECIOSMXNUEVO", nullable=false)	
	private Double precioSmxNuevo;
	
	@Column(name="PRECIOSMXNOAFILIADOANTERIOR", nullable=false)
	private Double precioSmxNoAfiliadoAnterior;
	
	@Column(name="PRECIOSMXNOAFILIADONUEVO", nullable=false)
	private Double precioSmxNoAfiliadoNuevo;
	
	@ComparatorTypeField
	@Column(name="ESTADO", nullable=false)
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name = "CODIGOHISTORIALPRECIO" , referencedColumnName="CODIGOHISTORIALPRECIO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO" , referencedColumnName="CODIGOARTICULO", insertable = false, updatable = false)})
	private HistorialArticuloPrecioDTO historialArticuloPrecio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name = "CODARTICULOPRECIODIFERENCIADO" , referencedColumnName="SECUENCIAL", insertable = false, updatable = false)})
	private ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciado;
	
	
	/**
	 * @return the id
	 */
	public HistorialPrecioDiferenciadoArticuloID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(HistorialPrecioDiferenciadoArticuloID id) {
		this.id = id;
	}

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return the porcentajeAnterior
	 */
	public Double getPorcentajeAnterior() {
		return porcentajeAnterior;
	}

	/**
	 * @param porcentajeAnterior the porcentajeAnterior to set
	 */
	public void setPorcentajeAnterior(Double porcentajeAnterior) {
		this.porcentajeAnterior = porcentajeAnterior;
	}

	/**
	 * @return the porcentajeNuevo
	 */
	public Double getPorcentajeNuevo() {
		return porcentajeNuevo;
	}

	/**
	 * @param porcentajeNuevo the porcentajeNuevo to set
	 */
	public void setPorcentajeNuevo(Double porcentajeNuevo) {
		this.porcentajeNuevo = porcentajeNuevo;
	}

	/**
	 * @return the precioSmxAnterior
	 */
	public Double getPrecioSmxAnterior() {
		return precioSmxAnterior;
	}

	/**
	 * @param precioSmxAnterior the precioSmxAnterior to set
	 */
	public void setPrecioSmxAnterior(Double precioSmxAnterior) {
		this.precioSmxAnterior = precioSmxAnterior;
	}

	/**
	 * @return the precioSmxNuevo
	 */
	public Double getPrecioSmxNuevo() {
		return precioSmxNuevo;
	}

	/**
	 * @param precioSmxNuevo the precioSmxNuevo to set
	 */
	public void setPrecioSmxNuevo(Double precioSmxNuevo) {
		this.precioSmxNuevo = precioSmxNuevo;
	}

	/**
	 * @return the precioSmxNoAfiliadoAnterior
	 */
	public Double getPrecioSmxNoAfiliadoAnterior() {
		return precioSmxNoAfiliadoAnterior;
	}

	/**
	 * @param precioSmxNoAfiliadoAnterior the precioSmxNoAfiliadoAnterior to set
	 */
	public void setPrecioSmxNoAfiliadoAnterior(Double precioSmxNoAfiliadoAnterior) {
		this.precioSmxNoAfiliadoAnterior = precioSmxNoAfiliadoAnterior;
	}

	/**
	 * @return the precioSmxNoAfiliadoNuevo
	 */
	public Double getPrecioSmxNoAfiliadoNuevo() {
		return precioSmxNoAfiliadoNuevo;
	}

	/**
	 * @param precioSmxNoAfiliadoNuevo the precioSmxNoAfiliadoNuevo to set
	 */
	public void setPrecioSmxNoAfiliadoNuevo(Double precioSmxNoAfiliadoNuevo) {
		this.precioSmxNoAfiliadoNuevo = precioSmxNoAfiliadoNuevo;
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
	 * @return the historialArticuloPrecio
	 */
	public HistorialArticuloPrecioDTO getHistorialArticuloPrecio() {
		return historialArticuloPrecio;
	}

	/**
	 * @param historialArticuloPrecio the historialArticuloPrecio to set
	 */
	public void setHistorialArticuloPrecio(HistorialArticuloPrecioDTO historialArticuloPrecio) {
		this.historialArticuloPrecio = historialArticuloPrecio;
	}

	/**
	 * @return the articuloPrecioDiferenciado
	 */
	public ArticuloPrecioDiferenciadoDTO getArticuloPrecioDiferenciado() {
		return articuloPrecioDiferenciado;
	}

	/**
	 * @param articuloPrecioDiferenciado the articuloPrecioDiferenciado to set
	 */
	public void setArticuloPrecioDiferenciado(ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciado) {
		this.articuloPrecioDiferenciado = articuloPrecioDiferenciado;
	}
	
	public Double getMargenSmxAnteriorCalculado(Double costoNeto) {
		return SICArticuloCalculo.getInstancia().calcularMargenPrecio(this.precioSmxAnterior, costoNeto);
	}
	
	public Double getMargenSmxNuevoCalculado(Double costoNeto) {
		return SICArticuloCalculo.getInstancia().calcularMargenPrecio(this.precioSmxNuevo, costoNeto);
	}

}
