/**
 * 
 */
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
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.common.annotation.Compare;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.mdl.dto.id.PrecioDiferenciadoArticuloGestionID;
import ec.com.smx.sic.cliente.mdl.nopersistente.PrecioDiferenciadoArticuloGestionTransient;

/**
 * @author Luis Yacchirema
 * 
 * @author Victor Jaramillo
 *
 */
@Entity
@Table(name="SCPRETPREDIFARTGES")
@SuppressWarnings("serial")
public class PrecioDiferenciadoArticuloGestionDTO extends PrecioDiferenciadoArticuloGestionTransient {

	@EmbeddedId
	private PrecioDiferenciadoArticuloGestionID id = new PrecioDiferenciadoArticuloGestionID();

	@ComparatorTypeField
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	@Column(name="PORCENTAJEANTERIOR", nullable=false)
	private Double porcentajeAnterior;

	@Compare
	@Column(name="PORCENTAJENUEVO", nullable=false)	
	private Double porcentajeNuevo;

	@Column(name="PRECIOSMXANTERIOR", nullable=false)
	private Double precioSmxAnterior;

	@Compare
	@Column(name="PRECIOSMXNUEVO", nullable=false)	
	private Double precioSmxNuevo;

	@ComparatorTypeField
	@Column(name="ESTADO", nullable=false)
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name = "CODIGOGESTIONPRECIO" , referencedColumnName="CODIGOGESTIONPRECIO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO" , referencedColumnName="CODIGOARTICULO", insertable = false, updatable = false)})
	private ArticuloGestionPrecioDTO articuloGestionPrecio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name = "CODARTICULOPRECIODIFERENCIADO" , referencedColumnName="SECUENCIAL", insertable = false, updatable = false)})
	private ArticuloPrecioDiferenciadoDTO articuloPrecioDiferenciado;

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

	/**
	 * @return the id
	 */
	public PrecioDiferenciadoArticuloGestionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PrecioDiferenciadoArticuloGestionID id) {
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

		if (super.precioSmxNoAfiliadoAnterior == null && SearchDTO.isLoaded(this.articuloGestionPrecio)) {
			super.precioSmxNoAfiliadoAnterior = SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularPrecioBaseNoAfiliado(this.precioSmxAnterior,
					this.articuloGestionPrecio.getArticulo().getArticuloComercialDTO());			
		}

		return super.precioSmxNoAfiliadoAnterior;
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

		if (super.precioSmxNoAfiliadoNuevo == null && SearchDTO.isLoaded(this.articuloGestionPrecio)) {
			super.precioSmxNoAfiliadoNuevo = SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularPrecioBaseNoAfiliado(this.precioSmxNuevo,
					this.articuloGestionPrecio.getArticulo().getArticuloComercialDTO());			
		}

		return super.precioSmxNoAfiliadoNuevo;
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
	 * @return the articuloGestionPrecio
	 */
	public ArticuloGestionPrecioDTO getArticuloGestionPrecio() {
		return articuloGestionPrecio;
	}

	/**
	 * @param articuloGestionPrecio the articuloGestionPrecio to set
	 */
	public void setArticuloGestionPrecio(ArticuloGestionPrecioDTO articuloGestionPrecio) {
		this.articuloGestionPrecio = articuloGestionPrecio;
	}

	public Double getMargenSmxAnteriorCalculado(Double costoNeto) {
		return SICArticuloCalculo.getInstancia().calcularMargenPrecio(this.precioSmxAnterior, costoNeto);
	}

	public Double getMargenSmxNuevoCalculado(Double costoNeto) {
		return SICArticuloCalculo.getInstancia().calcularMargenPrecio(this.precioSmxNuevo, costoNeto);
	}

}
