/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.BitacoraPrecioEstadoID;

/**
 * @author Victor Jaramillo
 *
 */
@Entity
@Table(name="SCPRETBITPREEST")
@SuppressWarnings("serial")
public class BitacoraPrecioEstadoDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private BitacoraPrecioEstadoID id = new BitacoraPrecioEstadoID();
	
	@ComparatorTypeField
	@Column(name = "ESTADO" , nullable = false)
	private String estado;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOBITACORAPRECIO", referencedColumnName = "CODIGOBITACORAPRECIO", insertable = false, updatable = false)
	})
	private BitacoraPrecioDTO bitacoraPrecio;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "VALORTIPOESTADO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOESTADO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO tipoEstadoBitacoraPrecio;

	/**
	 * @return the id
	 */
	public BitacoraPrecioEstadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BitacoraPrecioEstadoID id) {
		this.id = id;
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
	 * @return the tipoEstadoBitacoraPrecio
	 */
	public CatalogoValorDTO getTipoEstadoBitacoraPrecio() {
		return tipoEstadoBitacoraPrecio;
	}

	/**
	 * @param tipoEstadoBitacoraPrecio the tipoEstadoBitacoraPrecio to set
	 */
	public void setTipoEstadoBitacoraPrecio(CatalogoValorDTO tipoEstadoBitacoraPrecio) {
		this.tipoEstadoBitacoraPrecio = tipoEstadoBitacoraPrecio;
	}

}
