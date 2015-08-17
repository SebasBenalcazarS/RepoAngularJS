/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.BitacoraArticuloProveedorPrecioID;

/**
 * @author Luis Yacchirema
 *
 */
@Entity
@Table(name="SCPRETBITARTPROPRE")
@SuppressWarnings("serial")
public class BitacoraArticuloProveedorPrecioDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private BitacoraArticuloProveedorPrecioID id = new BitacoraArticuloProveedorPrecioID();

	@Column(name = "VALORPRECIONEGOCIACION", nullable = false)
	private BigDecimal valorPrecioNegociacion;

	@Column(name = "VALORPRECIOPROVEEDOR", nullable = false)
	private BigDecimal valorPrecioProveedor;

	@Column(name = "CODIGOTIPOPRECIO", nullable = false)
	private String codigoTipoPrecio;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOBITARTPRO", referencedColumnName = "CODIGOBITARTPRO", insertable = false, updatable = false)
	})
	private BitacoraArticuloProveedorDTO bitacoraArticuloProveedor;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOPRECIO", referencedColumnName = "CODIGOTIPOPRECIO", insertable = false, updatable = false)
	})
	private TipoPrecioArticuloDTO tipoPrecioArticulo;

	/**
	 * @return the id
	 */
	public BitacoraArticuloProveedorPrecioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BitacoraArticuloProveedorPrecioID id) {
		this.id = id;
	}

	/**
	 * @return the valorPrecioNegociacion
	 */
	public BigDecimal getValorPrecioNegociacion() {
		return valorPrecioNegociacion;
	}

	/**
	 * @param valorPrecioNegociacion the valorPrecioNegociacion to set
	 */
	public void setValorPrecioNegociacion(BigDecimal valorPrecioNegociacion) {
		this.valorPrecioNegociacion = valorPrecioNegociacion;
	}

	/**
	 * @return the valorPrecioProveedor
	 */
	public BigDecimal getValorPrecioProveedor() {
		return valorPrecioProveedor;
	}

	/**
	 * @param valorPrecioProveedor the valorPrecioProveedor to set
	 */
	public void setValorPrecioProveedor(BigDecimal valorPrecioProveedor) {
		this.valorPrecioProveedor = valorPrecioProveedor;
	}

	/**
	 * @return the codigoTipoPrecio
	 */
	public String getCodigoTipoPrecio() {
		return codigoTipoPrecio;
	}

	/**
	 * @param codigoTipoPrecio the codigoTipoPrecio to set
	 */
	public void setCodigoTipoPrecio(String codigoTipoPrecio) {
		this.codigoTipoPrecio = codigoTipoPrecio;
	}

	/**
	 * @return the bitacoraArticuloProveedor
	 */
	public BitacoraArticuloProveedorDTO getBitacoraArticuloProveedor() {
		return bitacoraArticuloProveedor;
	}

	/**
	 * @param bitacoraArticuloProveedor the bitacoraArticuloProveedor to set
	 */
	public void setBitacoraArticuloProveedor(BitacoraArticuloProveedorDTO bitacoraArticuloProveedor) {
		this.bitacoraArticuloProveedor = bitacoraArticuloProveedor;
	}

	/**
	 * @return the tipoPrecioArticulo
	 */
	public TipoPrecioArticuloDTO getTipoPrecioArticulo() {
		return tipoPrecioArticulo;
	}

	/**
	 * @param tipoPrecioArticulo the tipoPrecioArticulo to set
	 */
	public void setTipoPrecioArticulo(TipoPrecioArticuloDTO tipoPrecioArticulo) {
		this.tipoPrecioArticulo = tipoPrecioArticulo;
	}
	
}
