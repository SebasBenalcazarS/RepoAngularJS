/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.BitacoraPrecioID;

/**
 * @author Luis Yacchirema
 *
 */
@Entity
@Table(name="SCPRETBITPRE")
@SuppressWarnings("serial")
public class BitacoraPrecioDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private BitacoraPrecioID id = new BitacoraPrecioID();

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
	})
	private ProveedorDTO proveedor;
	
	@OneToMany(mappedBy = "bitacoraPrecio")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<BitacoraArticuloProveedorDTO> bitacorasArticuloProveedor;
	
	@OneToMany(mappedBy = "bitacoraPrecio")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<BitacoraPrecioEstadoDTO> estadosBitacoraPrecio;

	/**
	 * @return the estadosBitacoraPrecio
	 */
	public Collection<BitacoraPrecioEstadoDTO> getEstadosBitacoraPrecio() {
		return estadosBitacoraPrecio;
	}

	/**
	 * @param estadosBitacoraPrecio the estadosBitacoraPrecio to set
	 */
	public void setEstadosBitacoraPrecio(Collection<BitacoraPrecioEstadoDTO> estadosBitacoraPrecio) {
		this.estadosBitacoraPrecio = estadosBitacoraPrecio;
	}

	/**
	 * @return the id
	 */
	public BitacoraPrecioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BitacoraPrecioID id) {
		this.id = id;
	}

	/**
	 * @return the proveedor
	 */
	public ProveedorDTO getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the bitacorasArticuloProveedor
	 */
	public Collection<BitacoraArticuloProveedorDTO> getBitacorasArticuloProveedor() {
		return bitacorasArticuloProveedor;
	}

	/**
	 * @param bitacorasArticuloProveedor the bitacorasArticuloProveedor to set
	 */
	public void setBitacorasArticuloProveedor(Collection<BitacoraArticuloProveedorDTO> bitacorasArticuloProveedor) {
		this.bitacorasArticuloProveedor = bitacorasArticuloProveedor;
	}

}
