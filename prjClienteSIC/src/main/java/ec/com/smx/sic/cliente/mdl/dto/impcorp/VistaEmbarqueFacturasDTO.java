package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.VistaEmbarqueFacturasID;

/**
 * 
 * @author rhidalgo
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMVEMBARQUEFACTURAS")
public class VistaEmbarqueFacturasDTO extends SimpleAuditDTO implements Serializable {
	

	
	
	@EmbeddedId
	private VistaEmbarqueFacturasID  id = new VistaEmbarqueFacturasID();
	
	@Column(name = "CODIGOORDENCOMPRA")
	private Long codigoOrdenCompra;
	
	@Column(name = "CODIGOCLIENTEIMPORTACION")	
	private Long codigoClienteImportacion;
	
	@Column(name = "SIGLAS")
	private String siglas;
	
	
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;
	
	@Column(name = "CODIGOPROVEEDOR")
	private String codigoProveedor;
	
	@Column(name = "FECHAORDEN")
	private Date fechaOrden;
	
	@Column(name = "NUMEROCASO")
	private String numeroCaso;
	
	@Column(name = "NUMEROFACTURA")
	private String numeroFactura;
	
	@Column(name = "CODIGOJDEPROVEEDOR")
	private String codigoJDEProveedor;
	
	@Column(name = "RAZONSOCIALPROVEEDOR")
	private String razonSocialProveedor;
	
	@Column(name = "FOBFACTURA")
	private Double fobFactura;

	@Column(name = "INCOTERMFACTURA")
	private Double incotermFactura;

	@Column(name = "VALORFLETEFACTURA")
	private Double valorFleteFactura;

	
	@Column(name = "VALORSEGNACFAC")
	private Double valorSeguroNacionalFactura;

	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name="CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE",  insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUEESTADO", referencedColumnName = "CODIGOEMBARQUEESTADO", insertable = false, updatable = false)
	})
	private VistaEmbarqueDTO reporteEmbarque;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "embarqueFacturas"   )
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	//@Fetch(FetchMode.JOIN)
	private Collection<VistaDetalleFacturaDTO> detallesFactura;
	
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "embarqueFacturas" )
//	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
//	private Collection<OrdenCompraWorkItemDTO> ordenCompraWorkItemDTOs;
	
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumns({
//		@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
//		@JoinColumn(name="NUMEROCASO", referencedColumnName = "NUMEROCASO", insertable = false, updatable = false)		
//	})
//	private OrdenCompraWorkItemDTO ordenCompraWorkItemDTO;
//	
		
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
	 * @return the fechaOrden
	 */
	public Date getFechaOrden() {
		return fechaOrden;
	}


	/**
	 * @param fechaOrden the fechaOrden to set
	 */
	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}


	/**
	 * @return the numeroFactura
	 */
	public String getNumeroFactura() {
		return numeroFactura;
	}


	/**
	 * @param numeroFactura the numeroFactura to set
	 */
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}


	/**
	 * @return the razonSocialProveedor
	 */
	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
	}


	/**
	 * @param razonSocialProveedor the razonSocialProveedor to set
	 */
	public void setRazonSocialProveedor(String razonSocialProveedor) {
		this.razonSocialProveedor = razonSocialProveedor;
	}


	/**
	 * @return the fobFactura
	 */
	public Double getFobFactura() {
		return fobFactura;
	}


	/**
	 * @param fobFactura the fobFactura to set
	 */
	public void setFobFactura(Double fobFactura) {
		this.fobFactura = fobFactura;
	}


	/**
	 * @return the incotermFactura
	 */
	public Double getIncotermFactura() {
		return incotermFactura;
	}


	/**
	 * @param incotermFactura the incotermFactura to set
	 */
	public void setIncotermFactura(Double incotermFactura) {
		this.incotermFactura = incotermFactura;
	}


	/**
	 * @return the valorFleteFactura
	 */
	public Double getValorFleteFactura() {
		return valorFleteFactura;
	}


	/**
	 * @param valorFleteFactura the valorFleteFactura to set
	 */
	public void setValorFleteFactura(Double valorFleteFactura) {
		this.valorFleteFactura = valorFleteFactura;
	}


	/**
	 * @return the valorSeguroNacionalFactura
	 */
	public Double getValorSeguroNacionalFactura() {
		return valorSeguroNacionalFactura;
	}


	/**
	 * @param valorSeguroNacionalFactura the valorSeguroNacionalFactura to set
	 */
	public void setValorSeguroNacionalFactura(Double valorSeguroNacionalFactura) {
		this.valorSeguroNacionalFactura = valorSeguroNacionalFactura;
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




	public VistaEmbarqueDTO getReporteEmbarque() {
		return reporteEmbarque;
	}


	public void setReporteEmbarque(VistaEmbarqueDTO reporteEmbarque) {
		this.reporteEmbarque = reporteEmbarque;
	}


	/**
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}


	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}


	/**
	 * @return the id
	 */
	public VistaEmbarqueFacturasID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(VistaEmbarqueFacturasID id) {
		this.id = id;
	}



	

	public Collection<VistaDetalleFacturaDTO> getDetallesFactura() {
		return detallesFactura;
	}


	public void setDetallesFactura(Collection<VistaDetalleFacturaDTO> detallesFactura) {
		this.detallesFactura = detallesFactura;
	}


	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}


	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}


	public Long getCodigoClienteImportacion() {
		return codigoClienteImportacion;
	}


	public void setCodigoClienteImportacion(Long codigoClienteImportacion) {
		this.codigoClienteImportacion = codigoClienteImportacion;
	}


	public String getSiglas() {
		return siglas;
	}


	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}


	public String getCodigoJDEProveedor() {
		return codigoJDEProveedor;
	}


	public void setCodigoJDEProveedor(String codigoJDEProveedor) {
		this.codigoJDEProveedor = codigoJDEProveedor;
	}


	public String getNumeroCaso() {
		return numeroCaso;
	}


	public void setNumeroCaso(String numeroCaso) {
		this.numeroCaso = numeroCaso;
	}

//
//	public OrdenCompraWorkItemDTO getOrdenCompraWorkItemDTO() {
//		return ordenCompraWorkItemDTO;
//	}
//
//
//	public void setOrdenCompraWorkItemDTO(OrdenCompraWorkItemDTO ordenCompraWorkItemDTO) {
//		this.ordenCompraWorkItemDTO = ordenCompraWorkItemDTO;
//	}




	



	
	
	
	
	
	
	
	
	
}
