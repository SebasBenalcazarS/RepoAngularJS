/**
 * 
 */
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
import ec.com.smx.sic.cliente.mdl.dto.id.OfertaProveedorID;

/**
 * @author gnolivos
 *
 */
@Entity
@Table(name="SCFRUTOFEPRO")
@SuppressWarnings("serial")
public class OfertaProveedorDTO extends AuditoriaBaseDTO{
	
	@EmbeddedId
	private OfertaProveedorID id = new OfertaProveedorID();
	
	@ComparatorTypeField
	@Column(name = "NUMEROOFERTA", nullable = false)
	private String numeroOferta;
	
	@ComparatorTypeField
	@Column (name = "ESTADO", nullable = false)
	private String estado;
	
	@OneToMany(mappedBy = "ofertaProveedor")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<FechaOfertaProveedorDTO> fechaOfertaProveedor;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ProveedorDTO proveedor;

	/**
	 * @return the id
	 */
	public OfertaProveedorID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(OfertaProveedorID id) {
		this.id = id;
	}

	/**
	 * @return the numeroOferta
	 */
	public String getNumeroOferta() {
		return numeroOferta;
	}

	/**
	 * @param numeroOferta the numeroOferta to set
	 */
	public void setNumeroOferta(String numeroOferta) {
		this.numeroOferta = numeroOferta;
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
	 * @return the fechaOfertaProveedor
	 */
	public Collection<FechaOfertaProveedorDTO> getFechaOfertaProveedor() {
		return fechaOfertaProveedor;
	}

	/**
	 * @param fechaOfertaProveedor the fechaOfertaProveedor to set
	 */
	public void setFechaOfertaProveedor(Collection<FechaOfertaProveedorDTO> fechaOfertaProveedor) {
		this.fechaOfertaProveedor = fechaOfertaProveedor;
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
	
	public Boolean getTieneFechaOfertaProveedor() {
		return isLoaded(this.fechaOfertaProveedor) && !this.fechaOfertaProveedor.isEmpty();
	}
	
}
