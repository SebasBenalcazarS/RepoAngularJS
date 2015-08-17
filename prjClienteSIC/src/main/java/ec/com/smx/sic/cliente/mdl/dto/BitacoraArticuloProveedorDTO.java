package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.BitacoraArticuloProveedorID;

/**
 * @author Luis Yacchirema
 *
 */
@Entity
@Table(name="SCPRETBITARTPRO")
@SuppressWarnings("serial")
public class BitacoraArticuloProveedorDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private BitacoraArticuloProveedorID id = new BitacoraArticuloProveedorID();

	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;

	@Column(name = "CODIGOARTICULO", nullable = false)
	@ComparatorTypeField
	private String codigoArticulo;

	@Column(name = "CODIGOBITACORAPRECIO", nullable = false)
	private Long codigoBitacoraPrecio;

	@Column(name = "OBSERVACION")
	private String observacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOBITACORAPRECIO", referencedColumnName = "CODIGOBITACORAPRECIO", insertable = false, updatable = false)
	})
	private BitacoraPrecioDTO bitacoraPrecio;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
	})
	private ArticuloProveedorDTO articuloProveedor;

	@OneToMany(mappedBy = "bitacoraArticuloProveedor")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<BitacoraArticuloProveedorPrecioDTO> bitacorasArticuloProveedorPrecio;

	/**
	 * @return the id
	 */
	public BitacoraArticuloProveedorID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BitacoraArticuloProveedorID id) {
		this.id = id;
	}

	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
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
	 * @return the codigoBitacoraPrecio
	 */
	public Long getCodigoBitacoraPrecio() {
		return codigoBitacoraPrecio;
	}

	/**
	 * @param codigoBitacoraPrecio the codigoBitacoraPrecio to set
	 */
	public void setCodigoBitacoraPrecio(Long codigoBitacoraPrecio) {
		this.codigoBitacoraPrecio = codigoBitacoraPrecio;
	}

	/**
	 * @return the bitacoraPrecio
	 */
	public BitacoraPrecioDTO getBitacoraPrecio() {
		return bitacoraPrecio;
	}

	/**
	 * @param bitacoraPrecio the bitacoraPrecio to set
	 */
	public void setBitacoraPrecio(BitacoraPrecioDTO bitacoraPrecio) {
		this.bitacoraPrecio = bitacoraPrecio;
	}

	/**
	 * @return the articuloProveedor
	 */
	public ArticuloProveedorDTO getArticuloProveedor() {
		return articuloProveedor;
	}

	/**
	 * @param articuloProveedor the articuloProveedor to set
	 */
	public void setArticuloProveedor(ArticuloProveedorDTO articuloProveedor) {
		this.articuloProveedor = articuloProveedor;
	}

	/**
	 * @return the bitacorasArticuloProveedorPrecio
	 */
	public Collection<BitacoraArticuloProveedorPrecioDTO> getBitacorasArticuloProveedorPrecio() {
		return bitacorasArticuloProveedorPrecio;
	}

	/**
	 * @param bitacorasArticuloProveedorPrecio the bitacorasArticuloProveedorPrecio to set
	 */
	public void setBitacorasArticuloProveedorPrecio(Collection<BitacoraArticuloProveedorPrecioDTO> bitacorasArticuloProveedorPrecio) {
		this.bitacorasArticuloProveedorPrecio = bitacorasArticuloProveedorPrecio;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
