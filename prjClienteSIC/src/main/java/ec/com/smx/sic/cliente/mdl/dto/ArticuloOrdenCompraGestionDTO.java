package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;
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
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloOrdenCompraGestionID;

/**
 * @author Marcelo Hidalgo
 * 
 */
@Entity
@Table(name = "SCPRETARTORDCOMGES")
@SuppressWarnings("serial")
public class ArticuloOrdenCompraGestionDTO extends AuditoriaBaseDTO{
	
	@EmbeddedId
	private ArticuloOrdenCompraGestionID id = new ArticuloOrdenCompraGestionID();
	
	@Column(name = "COSTOBRUTO", nullable = false)
	private BigDecimal costoBruto;
	
	@Column(name = "COSTONETO", nullable = false)
	private BigDecimal costoNeto;
	
	@ComparatorTypeField
	@Column (name = "ESTADO", nullable = false)
	private String estado;
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
	@JoinColumn(name = "CODIGOORDENCOMPRAGESTION", referencedColumnName = "CODIGOORDENCOMPRAGESTION", insertable = false, updatable = false) })
	private OrdenCompraGestionDTO ordenCompraGestion;
    
    @OneToMany(mappedBy = "articuloOrdenCompraGestion")
   	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
   	private Collection<DescuentoArticuloOrdenCompraGestionDTO> descuentosArticulosOrdenCompraGestionCol;
    
	public ArticuloOrdenCompraGestionID getId() {
		return id;
	}

	public void setId(ArticuloOrdenCompraGestionID id) {
		this.id = id;
	}

	public BigDecimal getCostoBruto() {
		return costoBruto;
	}

	public void setCostoBruto(BigDecimal costoBruto) {
		this.costoBruto = costoBruto;
	}

	public BigDecimal getCostoNeto() {
		return costoNeto;
	}

	public void setCostoNeto(BigDecimal costoNeto) {
		this.costoNeto = costoNeto;
	}

	public OrdenCompraGestionDTO getOrdenCompraGestion() {
		return ordenCompraGestion;
	}

	public void setOrdenCompraGestion(OrdenCompraGestionDTO ordenCompraGestion) {
		this.ordenCompraGestion = ordenCompraGestion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Collection<DescuentoArticuloOrdenCompraGestionDTO> getDescuentosArticulosOrdenCompraGestionCol() {
		return descuentosArticulosOrdenCompraGestionCol;
	}

	public void setDescuentosArticulosOrdenCompraGestionCol(Collection<DescuentoArticuloOrdenCompraGestionDTO> descuentosArticulosOrdenCompraGestionCol) {
		this.descuentosArticulosOrdenCompraGestionCol = descuentosArticulosOrdenCompraGestionCol;
	}

}
