package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraGestionID;

/**
 * @author Marcelo Hidalgo
 * 
 */
@Entity
@Table(name = "SCPRETORDCOMGES")
@SuppressWarnings("serial")
public class OrdenCompraGestionDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private OrdenCompraGestionID id = new OrdenCompraGestionID();
	
	@Column(name = "CODIGOORDENCOMPRA", nullable = false)
	private Long codigoOrdenCompra;
	
	@Column(name = "VALORESTADOORDENCOMPRA", nullable = false)
    @ComparatorTypeField
    private String valorEstadoOrdenCompra;

    @Column(name = "CODIGOESTADOORDENCOMPRA", nullable = false)
    private Integer codigoEstadoOrdenCompra;
    
    @ComparatorTypeField
	@Column (name = "ESTADO", nullable = false)
	private String estado;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
	@JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false) })
	private OrdenCompraDTO ordenCompra;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "VALORESTADOORDENCOMPRA", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
	@JoinColumn(name = "CODIGOESTADOORDENCOMPRA", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false) })
	private CatalogoValorDTO valorEstado;
	
	@OneToMany(mappedBy = "ordenCompraGestion")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<ArticuloOrdenCompraGestionDTO> articulosOrdenCompraGestionCol;

	public OrdenCompraGestionID getId() {
		return id;
	}

	public void setId(OrdenCompraGestionID id) {
		this.id = id;
	}

	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}

	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}

	public String getValorEstadoOrdenCompra() {
		return valorEstadoOrdenCompra;
	}

	public void setValorEstadoOrdenCompra(String valorEstadoOrdenCompra) {
		this.valorEstadoOrdenCompra = valorEstadoOrdenCompra;
	}

	public Integer getCodigoEstadoOrdenCompra() {
		return codigoEstadoOrdenCompra;
	}

	public void setCodigoEstadoOrdenCompra(Integer codigoEstadoOrdenCompra) {
		this.codigoEstadoOrdenCompra = codigoEstadoOrdenCompra;
	}

	public OrdenCompraDTO getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompraDTO ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public CatalogoValorDTO getValorEstado() {
		return valorEstado;
	}

	public void setValorEstado(CatalogoValorDTO valorEstado) {
		this.valorEstado = valorEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the articulosOrdenCompraGestionCol
	 */
	public Collection<ArticuloOrdenCompraGestionDTO> getArticulosOrdenCompraGestionCol() {
		return articulosOrdenCompraGestionCol;
	}

	/**
	 * @param articulosOrdenCompraGestionCol the articulosOrdenCompraGestionCol to set
	 */
	public void setArticulosOrdenCompraGestionCol(Collection<ArticuloOrdenCompraGestionDTO> articulosOrdenCompraGestionCol) {
		this.articulosOrdenCompraGestionCol = articulosOrdenCompraGestionCol;
	}

}
