/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;
import java.util.Date;

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
import ec.com.smx.sic.cliente.mdl.dto.id.FechaOfertaProveedorID;

/**
 * @author gnolivos
 *
 */
@Entity
@Table(name="SCFRUTFECOFEPRO")
@SuppressWarnings("serial")
public class FechaOfertaProveedorDTO extends AuditoriaBaseDTO{
	
	@EmbeddedId
	private FechaOfertaProveedorID id = new FechaOfertaProveedorID();
	
	@ComparatorTypeField
	@Column(name = "CODIGOOFERTA", nullable = false)
	private Long codigoOferta;
	
	@ComparatorTypeField
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;
	
	@ComparatorTypeField
	@Column (name = "FECHA", nullable = false)
	private Date fecha;
	
	@ComparatorTypeField
	@Column (name = "ESTADO", nullable = false)
	private String estado;
	
	@ComparatorTypeField
	@Column(name = "VALORTIPOESTADO", nullable = false)
	private String valorTipoEstado;

	@Column(name = "CODIGOTIPOESTADO", nullable = false)
	private Integer codigoTipoEstado;
	
	@ComparatorTypeField
	@Column(name = "VALORTIPOOFERTA", nullable = false)
	private String valorTipoOferta;

	@Column(name = "CODIGOTIPOOFERTA", nullable = false)
	private Integer codigoTipoOferta;
	
	@OneToMany(mappedBy = "fechaOfertaProveedor")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloOfertaProveedorDTO> articuloOfertaProveedor;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOOFERTA", referencedColumnName="CODIGOOFERTA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private OfertaProveedorDTO ofertaProveedor;

	/**
	 * @return the id
	 */
	public FechaOfertaProveedorID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(FechaOfertaProveedorID id) {
		this.id = id;
	}

	/**
	 * @return the codigoOferta
	 */
	public Long getCodigoOferta() {
		return codigoOferta;
	}

	/**
	 * @param codigoOferta the codigoOferta to set
	 */
	public void setCodigoOferta(Long codigoOferta) {
		this.codigoOferta = codigoOferta;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	 * @return the valorTipoEstado
	 */
	public String getValorTipoEstado() {
		return valorTipoEstado;
	}

	/**
	 * @param valorTipoEstado the valorTipoEstado to set
	 */
	public void setValorTipoEstado(String valorTipoEstado) {
		this.valorTipoEstado = valorTipoEstado;
	}

	/**
	 * @return the codigoTipoEstado
	 */
	public Integer getCodigoTipoEstado() {
		return codigoTipoEstado;
	}

	/**
	 * @param codigoTipoEstado the codigoTipoEstado to set
	 */
	public void setCodigoTipoEstado(Integer codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
	}

	/**
	 * @return the valorTipoOferta
	 */
	public String getValorTipoOferta() {
		return valorTipoOferta;
	}

	/**
	 * @param valorTipoOferta the valorTipoOferta to set
	 */
	public void setValorTipoOferta(String valorTipoOferta) {
		this.valorTipoOferta = valorTipoOferta;
	}

	/**
	 * @return the codigoTipoOferta
	 */
	public Integer getCodigoTipoOferta() {
		return codigoTipoOferta;
	}

	/**
	 * @param codigoTipoOferta the codigoTipoOferta to set
	 */
	public void setCodigoTipoOferta(Integer codigoTipoOferta) {
		this.codigoTipoOferta = codigoTipoOferta;
	}

	/**
	 * @return the articuloOfertaProveedor
	 */
	public Collection<ArticuloOfertaProveedorDTO> getArticuloOfertaProveedor() {
		return articuloOfertaProveedor;
	}

	/**
	 * @param articuloOfertaProveedor the articuloOfertaProveedor to set
	 */
	public void setArticuloOfertaProveedor(Collection<ArticuloOfertaProveedorDTO> articuloOfertaProveedor) {
		this.articuloOfertaProveedor = articuloOfertaProveedor;
	}

	/**
	 * @return the ofertaProveedor
	 */
	public OfertaProveedorDTO getOfertaProveedor() {
		return ofertaProveedor;
	}

	/**
	 * @param ofertaProveedor the ofertaProveedor to set
	 */
	public void setOfertaProveedor(OfertaProveedorDTO ofertaProveedor) {
		this.ofertaProveedor = ofertaProveedor;
	}

	public Boolean getTieneArticuloOfertaProveedor() {
		return isLoaded(this.articuloOfertaProveedor) && !this.articuloOfertaProveedor.isEmpty();
	}
}
