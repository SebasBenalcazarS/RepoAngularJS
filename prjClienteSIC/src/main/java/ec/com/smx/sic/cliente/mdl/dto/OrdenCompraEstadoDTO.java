package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraEstadoID;
/**
 * 
 * @author amunoz
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCORCTORDCOMEST")
public class OrdenCompraEstadoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private OrdenCompraEstadoID id= new OrdenCompraEstadoID();
	
	
	@Column(name = "CODIGOORDENCOMPRA", nullable = false)
	private Long codigoOrdenCompra;
	
	@Column(name = "CODIGOORDENCOMPRAESTADOPADRE")
	private Long codigoOrdenCompraEstadoPadre;
	 
    @Column(name = "CODIGOESTADOCATVAL", nullable = false)
    @ComparatorTypeField
    private String codigoEstadoCatVal;

    @Column(name = "CODIGOESTADOCATTIP", nullable = false)
    private Integer codigoEstadoCatTip;
   
    @Column(name = "FECHAINICIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
   
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    @Column(name = "CANTIDADITEMS", nullable = false)
    private Integer cantidadItems;
    
    @Column(name = "CANTIDADTOTALPEDIDA", nullable = false)
    private Integer cantidadTotalPedida;
    
    @Column(name = "CANTIDADTOTALPARCIAL")
    private Integer cantidadTotalParcial;
    
    @Column(name = "CANTIDADTOTALENTREGADA")
    private Integer cantidadTotalEntregada;
    
    @Column(name = "PESOTOTALPEDIDO")
    private BigDecimal pesoTotalPedido;
    
    @Column(name = "PESOTOTALPARCIAL")
    private BigDecimal pesoTotalParcial;
    
    @Column(name = "PESOTOTALENTREGADO")
    private BigDecimal pesoTotalEntregado;
    
    @Column(name = "COSTOTOTALNETO")
    private BigDecimal costoTotalNeto;
    
    @Column(name = "COSTOTOTALBRUTO")
    private BigDecimal costoTotalBruto;
    
    @Column(name = "VALORTOTAL", nullable = false)
    private BigDecimal valorTotal;
   
    @Column(name = "DESCUENTOUNICO")
    private BigDecimal descuentoUnico;
    
    @Column(name = "ESTADO", nullable = false)
    @ComparatorTypeField
    private String estado;
    
    @RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO", nullable=false)
    private String idUsuarioRegistro;
    
    @RegisterDateField
    @Column(name = "FECHAREGISTRO", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @LastModifierUserIdField
    @Column(name = "IDUSUARIOMODIFICACION")
    private String idUsuarioModificacion;
    
    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @Column(name = "CODIGOMIGRACION")
    private Integer codigoMigracion;
   
	@Transient
    private Double totalPesoContenedor;
    
    @Transient
    private Double totalVolumenContenedor;
	
    @Transient
    private Integer cantidadPendientePorEntregar;
    
    @Column(name = "PORCENTAJECOMISIONIMPORTACION")
    private BigDecimal porcentajeComisionImportacion;
    
    @Transient
    private Boolean seleccionado;
    
    @Column(name = "PRIORIDAD")
    private Integer prioridad;
    
    @OneToMany(mappedBy = "ordenCompraEstado")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<EntregaOrdenCompraEstadoDTO> entregaOrdenCompraEstadoDTOCol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
    	@JoinColumn(name = "CODIGOESTADOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOESTADOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO estadoOrdenCompra;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false)
    })
    private OrdenCompraDTO ordenCompra;
    
	@OneToMany(mappedBy = "ordenCompraEstado")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoCol;
	
	@OneToMany(mappedBy = "ordenCompraEstado")
   	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<OrdenCompraEstadoImpuestoDTO> ordenCompraEstadoImpuestoCol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOORDENCOMPRAESTADOPADRE", referencedColumnName = "CODIGOORDENCOMPRAESTADO", insertable = false, updatable = false)
	})
	
	private OrdenCompraEstadoDTO ordenCompraEstadoPadre;
	
	@OneToMany(mappedBy = "ordenCompraEstadoPadre")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<OrdenCompraEstadoDTO> ordenesCompraEstadoHijas;
	
	public OrdenCompraEstadoID getId() {
		return id;
	}

	public void setId(OrdenCompraEstadoID id) {
		this.id = id;
	}

	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}

	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}

	public String getCodigoEstadoCatVal() {
		return codigoEstadoCatVal;
	}

	public void setCodigoEstadoCatVal(String codigoEstadoCatVal) {
		this.codigoEstadoCatVal = codigoEstadoCatVal;
	}

	public Integer getCodigoEstadoCatTip() {
		return codigoEstadoCatTip;
	}

	public void setCodigoEstadoCatTip(Integer codigoEstadoCatTip) {
		this.codigoEstadoCatTip = codigoEstadoCatTip;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getCantidadItems() {
		return cantidadItems;
	}

	public void setCantidadItems(Integer cantidadItems) {
		this.cantidadItems = cantidadItems;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the descuentoUnico
	 */
	public BigDecimal getDescuentoUnico() {
		return descuentoUnico;
	}

	/**
	 * @param descuentoUnico the descuentoUnico to set
	 */
	public void setDescuentoUnico(BigDecimal descuentoUnico) {
		this.descuentoUnico = descuentoUnico;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the ordenCompraDetalleEstadoCol
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> getOrdenCompraDetalleEstadoCol() {
		return ordenCompraDetalleEstadoCol;
	}

	/**
	 * @param ordenCompraDetalleEstadoCol the ordenCompraDetalleEstadoCol to set
	 */
	public void setOrdenCompraDetalleEstadoCol(
			Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoCol) {
		this.ordenCompraDetalleEstadoCol = ordenCompraDetalleEstadoCol;
	}

	public OrdenCompraDTO getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompraDTO ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
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
	 * @return the estadoOrdenCompra
	 */
	public CatalogoValorDTO getEstadoOrdenCompra() {
		return estadoOrdenCompra;
	}

	/**
	 * @param estadoOrdenCompra the estadoOrdenCompra to set
	 */
	public void setEstadoOrdenCompra(CatalogoValorDTO estadoOrdenCompra) {
		this.estadoOrdenCompra = estadoOrdenCompra;
	}

	/**
	 * @return the cantidadTotalPedida
	 */
	public Integer getCantidadTotalPedida() {
		return cantidadTotalPedida;
	}

	/**
	 * @param cantidadTotalPedida the cantidadTotalPedida to set
	 */
	public void setCantidadTotalPedida(Integer cantidadTotalPedida) {
		this.cantidadTotalPedida = cantidadTotalPedida;
	}

	/**
	 * @return the cantidadTotalParcial
	 */
	public Integer getCantidadTotalParcial() {
		return cantidadTotalParcial;
	}

	/**
	 * @param cantidadTotalParcial the cantidadTotalParcial to set
	 */
	public void setCantidadTotalParcial(Integer cantidadTotalParcial) {
		this.cantidadTotalParcial = cantidadTotalParcial;
	}

	/**
	 * @return the pesoTotalPedido
	 */
	public BigDecimal getPesoTotalPedido() {
		return pesoTotalPedido;
	}

	/**
	 * @param pesoTotalPedido the pesoTotalPedido to set
	 */
	public void setPesoTotalPedido(BigDecimal pesoTotalPedido) {
		this.pesoTotalPedido = pesoTotalPedido;
	}

	/**
	 * @return the pesoTotalParcial
	 */
	public BigDecimal getPesoTotalParcial() {
		return pesoTotalParcial;
	}

	/**
	 * @param pesoTotalParcial the pesoTotalParcial to set
	 */
	public void setPesoTotalParcial(BigDecimal pesoTotalParcial) {
		this.pesoTotalParcial = pesoTotalParcial;
	}
	
	/**
	 * @return the cantidadTotalEntregada
	 */
	public Integer getCantidadTotalEntregada() {
		return cantidadTotalEntregada;
	}

	/**
	 * @param cantidadTotalEntregada the cantidadTotalEntregada to set
	 */
	public void setCantidadTotalEntregada(Integer cantidadTotalEntregada) {
		this.cantidadTotalEntregada = cantidadTotalEntregada;
	}

	/**
	 * @return the pesoTotalEntregado
	 */
	public BigDecimal getPesoTotalEntregado() {
		return pesoTotalEntregado;
	}

	/**
	 * @param pesoTotalEntregado the pesoTotalEntregado to set
	 */
	public void setPesoTotalEntregado(BigDecimal pesoTotalEntregado) {
		this.pesoTotalEntregado = pesoTotalEntregado;
	}

	/**
	 * @return the entregaOrdenCompraEstadoDTOCol
	 */
	public Collection<EntregaOrdenCompraEstadoDTO> getEntregaOrdenCompraEstadoDTOCol() {
		return entregaOrdenCompraEstadoDTOCol;
	}

	/**
	 * @param entregaOrdenCompraEstadoDTOCol the entregaOrdenCompraEstadoDTOCol to set
	 */
	public void setEntregaOrdenCompraEstadoDTOCol(Collection<EntregaOrdenCompraEstadoDTO> entregaOrdenCompraEstadoDTOCol) {
		this.entregaOrdenCompraEstadoDTOCol = entregaOrdenCompraEstadoDTOCol;
	}

	/**
	 * @return the costoTotalNeto
	 */
	public BigDecimal getCostoTotalNeto() {
		return costoTotalNeto;
	}

	/**
	 * @param costoTotalNeto the costoTotalNeto to set
	 */
	public void setCostoTotalNeto(BigDecimal costoTotalNeto) {
		this.costoTotalNeto = costoTotalNeto;
	}

	/**
	 * @return the costoTotalBruto
	 */
	public BigDecimal getCostoTotalBruto() {
		return costoTotalBruto;
	}

	/**
	 * @param costoTotalBruto the costoTotalBruto to set
	 */
	public void setCostoTotalBruto(BigDecimal costoTotalBruto) {
		this.costoTotalBruto = costoTotalBruto;
	}

	/**
	 * @return the ordenCompraEstadoImpuestoCol
	 */
	public Collection<OrdenCompraEstadoImpuestoDTO> getOrdenCompraEstadoImpuestoCol() {
		return ordenCompraEstadoImpuestoCol;
	}

	/**
	 * @param ordenCompraEstadoImpuestoCol the ordenCompraEstadoImpuestoCol to set
	 */
	public void setOrdenCompraEstadoImpuestoCol(Collection<OrdenCompraEstadoImpuestoDTO> ordenCompraEstadoImpuestoCol) {
		this.ordenCompraEstadoImpuestoCol = ordenCompraEstadoImpuestoCol;
	}

	/**
	 * @return the codigoOrdenCompraEstadoPadre
	 */
	public Long getCodigoOrdenCompraEstadoPadre() {
		return codigoOrdenCompraEstadoPadre;
	}

	/**
	 * @param codigoOrdenCompraEstadoPadre the codigoOrdenCompraEstadoPadre to set
	 */
	public void setCodigoOrdenCompraEstadoPadre(Long codigoOrdenCompraEstadoPadre) {
		this.codigoOrdenCompraEstadoPadre = codigoOrdenCompraEstadoPadre;
	}

	public Double getTotalPesoContenedor() {
		return totalPesoContenedor;
	}

	public void setTotalPesoContenedor(Double totalPesoContenedor) {
		this.totalPesoContenedor = totalPesoContenedor;
	}

	public Double getTotalVolumenContenedor() {
		return totalVolumenContenedor;
	}

	public void setTotalVolumenContenedor(Double totalVolumenContenedor) {
		this.totalVolumenContenedor = totalVolumenContenedor;
	}
	
	public Integer getCantidadPendientePorEntregar() {
		return cantidadPendientePorEntregar;
	}

	public void setCantidadPendientePorEntregar(Integer cantidadPendientePorEntregar) {
		this.cantidadPendientePorEntregar = cantidadPendientePorEntregar;
	}

	public boolean getTieneOrdenCompraDetalleEstadoCol() {
		return isLoaded(this.ordenCompraDetalleEstadoCol) && !this.ordenCompraDetalleEstadoCol.isEmpty();
	}

	public OrdenCompraEstadoDTO getOrdenCompraEstadoPadre() {
		return ordenCompraEstadoPadre;
	}

	public void setOrdenCompraEstadoPadre(OrdenCompraEstadoDTO ordenCompraEstadoPadre) {
		this.ordenCompraEstadoPadre = ordenCompraEstadoPadre;
	}

	public Collection<OrdenCompraEstadoDTO> getOrdenesCompraEstadoHijas() {
		return ordenesCompraEstadoHijas;
	}

	public void setOrdenesCompraEstadoHijas(Collection<OrdenCompraEstadoDTO> ordenesCompraEstadoHijas) {
		this.ordenesCompraEstadoHijas = ordenesCompraEstadoHijas;
	}

	/**
	 * @return the codigoMigracion
	 */
	public Integer getCodigoMigracion() {
		return codigoMigracion;
	}

	/**
	 * @param codigoMigracion the codigoMigracion to set
	 */
	public void setCodigoMigracion(Integer codigoMigracion) {
		this.codigoMigracion = codigoMigracion;
	}

	/**
	 * 
	 * @return prioridad
	 */
	public Integer getPrioridad() {
		return prioridad;
	}

	/**
	 * 
	 * @param prioridad
	 */
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	/**
	 * @return the porcentajeComisionImportacion
	 */
	public BigDecimal getPorcentajeComisionImportacion() {
		return porcentajeComisionImportacion;
	}

	/**
	 * @param porcentajeComisionImportacion the porcentajeComisionImportacion to set
	 */
	public void setPorcentajeComisionImportacion(BigDecimal porcentajeComisionImportacion) {
		this.porcentajeComisionImportacion = porcentajeComisionImportacion;
	}

	/**
	 * @return the seleccionado
	 */
	public Boolean getSeleccionado() {
		return seleccionado;
	}

	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	
}
