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

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.MonedaDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.PedidoID;
/**
 * 
 * @author amunoz
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCORCTPEDIDO")
public class PedidoDTO extends SimpleAuditDTO{

	@EmbeddedId
	private PedidoID id = new PedidoID();
	
   
    @Column(name = "NUMEROPEDIDO", nullable = false)
    private Long numeroPedido;
    
    @Column(name = "CODIGOFUNCIONARIOCOMPRADOR", nullable = false)
    @ComparatorTypeField
    private String codigoFuncionarioComprador;
   
    @Column(name = "CODIGOSUBBODEGA", nullable = false)
    private String codigoSubbodega;
    
    @Column(name = "CODIGOAREATRABAJOPEDIDO", nullable = false)
    private Integer codigoAreaTrabajoPedido;
    
    @Column(name = "CODIGOPROVEEDOR", nullable = false)
    @ComparatorTypeField
    private String codigoProveedor;
    
    @Column(name = "CODIGOOFICINAEXTERIOR")
    private Integer codigoOficinaExterior;
   
    @Column(name = "CODIGOTIPOCATVAL", nullable = false)
    @ComparatorTypeField
    private String codigoTipoCatVal;
    
    @Column(name = "CODIGOTIPOCATTIP", nullable = false)
    private Integer codigoTipoCatTip;
    
    @Column(name = "NUMEROENTREGASPERMITIDAS", nullable = false)
    private Integer numeroEntregasPermitidas;
   
    @Column(name = "TIEMPOESPERA")
    private Long tiempoEspera;
    
    @Column(name = "TIEMPOSTOCK")
    private Long tiempoStock;
    
    @Column(name = "PLAZOPAGO")
    private Integer plazoPago;
    
    @Column(name = "CODIGOMONEDA")
    private Long codigoMoneda;
    
    @Column(name = "TASACAMBIO")
    private BigDecimal tasaCambio;
    
    @Column(name = "CODIGOORIGENCATVAL", nullable = false)
    private String codigoOrigenCatVal;
   
    @Column(name = "CODIGOORIGENCATTIP", nullable = false)
    private Integer codigoOrigenCatTip;
    
    @Column(name = "CODIGOPLANTILLA")
    private Long codigoPlantilla;
    
    @Column(name = "OBSERVACION")
    private String observacion;
    
    @Column(name = "REEMPLAZO")
    private Boolean reemplazo;
    
    @Column(name = "ESTADO", nullable = false)
    @ComparatorTypeField
    private String estado;
    
   
    @Column(name = "CODIGODESTINOCATVAL", nullable = true)
    private String codigoDestinoCatVal;
   
   
    @Column(name = "CODIGODESTINOCATTIP", nullable = true)
    private Integer codigoDestinoCatTip;
    
    @RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO", nullable = false)
    private String idUsuarioRegistro;
    
    //@RegisterDateField
    @Column(name = "FECHAREGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
  
    @LastModifierUserIdField	
    @Column(name = "IDUSUARIOMODIFICACION")
    private String idUsarioModificacion;
    
    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @Column(name = "CODIGOMIGRACION")
    private Integer codigoMigracion;
    
    @Column(name = "ENVIAREMAIL")
    private Integer enviarEmail;
    
    @Column(name="NOB2B")
    private String noB2B;
    
    
    @Column(name = "CODIGOPLAZOPAGOCATVAL", nullable = false)
    @ComparatorTypeField
    private String codigoPlazoPagoCatVal;
    
    @Column(name = "CODIGOPLAZOPAGOCATTIP", nullable = false)
    private Integer codigoPlazoPagoCatTip;

    @Column(name = "FECHAENTREGA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
   
    @Column(name = "FECHACADUCIDAD", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaducidad;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOAREATRABAJOPEDIDO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)
    })
    private AreaTrabajoDTO areaTrabajoPedido;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOFUNCIONARIOCOMPRADOR", referencedColumnName = "CODIGOFUNCIONARIO", insertable = false, updatable = false)
    })
    private FuncionarioDTO funcionarioComprador;

    @OneToMany(mappedBy = "pedido")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<OrdenCompraDTO> ordenCompraCol;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOORIGENCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOORIGENCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO origen;
    
    @OneToMany(mappedBy = "pedido")
    @CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<PedidoArchivoInformacionDTO> pedidoArchivoInformacionCol;
    
    @OneToMany(mappedBy = "pedido")
   	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<PedidoEstadoDTO> pedidoEstadoCol;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
    })
    private VistaProveedorDTO proveedor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOOFICINAEXTERIOR", referencedColumnName = "CODIGOOFICINAEXTERIOR", insertable = false, updatable = false)
    })
    private ProveedorOficinaExteriorDTO proveedorOficinaExterior;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOSUBBODEGA", referencedColumnName = "CODIGOBODEGA", insertable = false, updatable = false)
    })
    private BodegaDTO subbodega;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOTIPOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOTIPOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO tipo;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;
    
  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGOMONEDA", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false)
    private MonedaDTO moneda;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGODESTINOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGODESTINOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO destino;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOPLAZOPAGOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOPLAZOPAGOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO plazoPagoCatalogo;

    
    @Transient
    private Boolean selectPlanContingencia;

    @Transient
    private Boolean esPedidoFijo;
    
    
    public PedidoID getId() {
		return id;
	}

	public void setId(PedidoID id) {
		this.id = id;
	}

	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Integer getCodigoOficinaExterior() {
		return codigoOficinaExterior;
	}

	public void setCodigoOficinaExterior(Integer codigoOficinaExterior) {
		this.codigoOficinaExterior = codigoOficinaExterior;
	}

	public String getCodigoTipoCatVal() {
		return codigoTipoCatVal;
	}

	public void setCodigoTipoCatVal(String codigoTipoCatVal) {
		this.codigoTipoCatVal = codigoTipoCatVal;
	}

	public Integer getCodigoTipoCatTip() {
		return codigoTipoCatTip;
	}

	public void setCodigoTipoCatTip(Integer codigoTipoCatTip) {
		this.codigoTipoCatTip = codigoTipoCatTip;
	}

	public Integer getNumeroEntregasPermitidas() {
		return numeroEntregasPermitidas;
	}

	public void setNumeroEntregasPermitidas(Integer numeroEntregasPermitidas) {
		this.numeroEntregasPermitidas = numeroEntregasPermitidas;
	}

	public Long getTiempoEspera() {
		return tiempoEspera;
	}

	public void setTiempoEspera(Long tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}

	public Long getTiempoStock() {
		return tiempoStock;
	}

	public void setTiempoStock(Long tiempoStock) {
		this.tiempoStock = tiempoStock;
	}

	public Integer getPlazoPago() {
		return plazoPago;
	}

	public void setPlazoPago(Integer plazoPago) {
		this.plazoPago = plazoPago;
	}

	public String getCodigoOrigenCatVal() {
		return codigoOrigenCatVal;
	}

	public void setCodigoOrigenCatVal(String codigoOrigenCatVal) {
		this.codigoOrigenCatVal = codigoOrigenCatVal;
	}

	public Integer getCodigoOrigenCatTip() {
		return codigoOrigenCatTip;
	}

	public void setCodigoOrigenCatTip(Integer codigoOrigenCatTip) {
		this.codigoOrigenCatTip = codigoOrigenCatTip;
	}

	public Long getCodigoPlantilla() {
		return codigoPlantilla;
	}

	public void setCodigoPlantilla(Long codigoPlantilla) {
		this.codigoPlantilla = codigoPlantilla;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getIdUsarioModificacion() {
		return idUsarioModificacion;
	}

	public void setIdUsarioModificacion(String idUsarioModificacion) {
		this.idUsarioModificacion = idUsarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public ProveedorOficinaExteriorDTO getProveedorOficinaExterior() {
		return proveedorOficinaExterior;
	}

	public void setProveedorOficinaExterior(
			ProveedorOficinaExteriorDTO proveedorOficinaExterior) {
		this.proveedorOficinaExterior = proveedorOficinaExterior;
	}

	/**
	 * @return the ordenCompraCol
	 */
	public Collection<OrdenCompraDTO> getOrdenCompraCol() {
		return ordenCompraCol;
	}

	/**
	 * @param ordenCompraCol the ordenCompraCol to set
	 */
	public void setOrdenCompraCol(Collection<OrdenCompraDTO> ordenCompraCol) {
		this.ordenCompraCol = ordenCompraCol;
	}

	/**
	 * @return the pedidoEstadoCol
	 */
	public Collection<PedidoEstadoDTO> getPedidoEstadoCol() {
		return pedidoEstadoCol;
	}

	/**
	 * @param pedidoEstadoCol the pedidoEstadoCol to set
	 */
	public void setPedidoEstadoCol(Collection<PedidoEstadoDTO> pedidoEstadoCol) {
		this.pedidoEstadoCol = pedidoEstadoCol;
	}

	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}

	public VistaProveedorDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(VistaProveedorDTO proveedor) {
		this.proveedor = proveedor;
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
	 * @return the tipo
	 */
	public CatalogoValorDTO getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(CatalogoValorDTO tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the origen
	 */
	public CatalogoValorDTO getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(CatalogoValorDTO origen) {
		this.origen = origen;
	}

	/**
	 * @return the pedidoArchivoInformacionCol
	 */
	public Collection<PedidoArchivoInformacionDTO> getPedidoArchivoInformacionCol() {
		return pedidoArchivoInformacionCol;
	}

	/**
	 * @param pedidoArchivoInformacionCol the pedidoArchivoInformacionCol to set
	 */
	public void setPedidoArchivoInformacionCol(
			Collection<PedidoArchivoInformacionDTO> pedidoArchivoInformacionCol) {
		this.pedidoArchivoInformacionCol = pedidoArchivoInformacionCol;
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

	/**
	 * @return the codigoFuncionarioComprador
	 */
	public String getCodigoFuncionarioComprador() {
		return codigoFuncionarioComprador;
	}

	/**
	 * @param codigoFuncionarioComprador the codigoFuncionarioComprador to set
	 */
	public void setCodigoFuncionarioComprador(String codigoFuncionarioComprador) {
		this.codigoFuncionarioComprador = codigoFuncionarioComprador;
	}

	/**
	 * @return the funcionarioComprador
	 */
	public FuncionarioDTO getFuncionarioComprador() {
		return funcionarioComprador;
	}

	/**
	 * @param funcionarioComprador the funcionarioComprador to set
	 */
	public void setFuncionarioComprador(FuncionarioDTO funcionarioComprador) {
		this.funcionarioComprador = funcionarioComprador;
	}

	/**
	 * @return the codigoAreaTrabajoPedido
	 */
	public Integer getCodigoAreaTrabajoPedido() {
		return codigoAreaTrabajoPedido;
	}

	/**
	 * @param codigoAreaTrabajoPedido the codigoAreaTrabajoPedido to set
	 */
	public void setCodigoAreaTrabajoPedido(Integer codigoAreaTrabajoPedido) {
		this.codigoAreaTrabajoPedido = codigoAreaTrabajoPedido;
	}

	/**
	 * @return the areaTrabajoPedido
	 */
	public AreaTrabajoDTO getAreaTrabajoPedido() {
		return areaTrabajoPedido;
	}

	/**
	 * @param areaTrabajoPedido the areaTrabajoPedido to set
	 */
	public void setAreaTrabajoPedido(AreaTrabajoDTO areaTrabajoPedido) {
		this.areaTrabajoPedido = areaTrabajoPedido;
	}

	/**
	 * @return the codigoSubbodega
	 */
	public String getCodigoSubbodega() {
		return codigoSubbodega;
	}

	/**
	 * @param codigoSubbodega the codigoSubbodega to set
	 */
	public void setCodigoSubbodega(String codigoSubbodega) {
		this.codigoSubbodega = codigoSubbodega;
	}

	/**
	 * @return the subbodega
	 */
	public BodegaDTO getSubbodega() {
		return subbodega;
	}

	/**
	 * @param subbodega the subbodega to set
	 */
	public void setSubbodega(BodegaDTO subbodega) {
		this.subbodega = subbodega;
	}

	/**
	 * @return the reemplazo
	 */
	public Boolean getReemplazo() {
		return reemplazo;
	}

	/**
	 * @param reemplazo the reemplazo to set
	 */
	public void setReemplazo(Boolean reemplazo) {
		this.reemplazo = reemplazo;
	}
	
	/**
	 * 
	 * @return pedido estado actual
	 */
	public PedidoEstadoDTO getPedidoEstadoDTOActual(){
		if(this.pedidoEstadoCol != null && SearchDTO.isLoaded(this.pedidoEstadoCol) && !this.pedidoEstadoCol.isEmpty()){
			return (PedidoEstadoDTO)CollectionUtils.get(this.pedidoEstadoCol, 0);
		}
		return null;
	}

	/**
	 * @return the selectPlanContingencia
	 */
	public Boolean getSelectPlanContingencia() {
		return selectPlanContingencia;
	}

	/**
	 * @param selectPlanContingencia the selectPlanContingencia to set
	 */
	public void setSelectPlanContingencia(Boolean selectPlanContingencia) {
		this.selectPlanContingencia = selectPlanContingencia;
	}

	/**
	 * @return the codigoMoneda
	 */
	public Long getCodigoMoneda() {
		return codigoMoneda;
	}

	/**
	 * @param codigoMoneda the codigoMoneda to set
	 */
	public void setCodigoMoneda(Long codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	/**
	 * @return the tasaCambio
	 */
	public BigDecimal getTasaCambio() {
		return tasaCambio;
	}

	/**
	 * @param tasaCambio the tasaCambio to set
	 */
	public void setTasaCambio(BigDecimal tasaCambio) {
		this.tasaCambio = tasaCambio;
	}

	/**
	 * @return the moneda
	 */
	public MonedaDTO getMoneda() {
		return moneda;
	}

	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(MonedaDTO moneda) {
		this.moneda = moneda;
	}

	public String getCodigoDestinoCatVal() {
		return codigoDestinoCatVal;
	}

	public void setCodigoDestinoCatVal(String codigoDestinoCatVal) {
		this.codigoDestinoCatVal = codigoDestinoCatVal;
	}

	public Integer getCodigoDestinoCatTip() {
		return codigoDestinoCatTip;
	}

	public void setCodigoDestinoCatTip(Integer codigoDestinoCatTip) {
		this.codigoDestinoCatTip = codigoDestinoCatTip;
	}

	public CatalogoValorDTO getDestino() {
		return destino;
	}

	public void setDestino(CatalogoValorDTO destino) {
		this.destino = destino;
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
	 * @return the enviarEmail
	 */
	public Integer getEnviarEmail() {
		return enviarEmail;
	}

	/**
	 * @param enviarEmail the enviarEmail to set
	 */
	public void setEnviarEmail(Integer enviarEmail) {
		this.enviarEmail = enviarEmail;
	}

	/**
	 * @return
	 */
	public Boolean getEsPedidoFijo() {
		if(this.esPedidoFijo == null){
			if(this.codigoPlantilla != null){
				this.esPedidoFijo = Boolean.TRUE;
			}else{
				this.esPedidoFijo = Boolean.FALSE;
			}
		}
		return this.esPedidoFijo;
	}

	/**
	 * @param esPedidoFijo
	 */
	public void setEsPedidoFijo(Boolean esPedidoFijo) {
		this.esPedidoFijo = esPedidoFijo;
	}

	public String getNoB2B() {
		return noB2B;
	}

	public void setNoB2B(String noB2B) {
		this.noB2B = noB2B;
	}

	/**
	 * @return the codigoPlazoPagoCatVal
	 */
	public String getCodigoPlazoPagoCatVal() {
		return codigoPlazoPagoCatVal;
	}

	/**
	 * @param codigoPlazoPagoCatVal the codigoPlazoPagoCatVal to set
	 */
	public void setCodigoPlazoPagoCatVal(String codigoPlazoPagoCatVal) {
		this.codigoPlazoPagoCatVal = codigoPlazoPagoCatVal;
	}

	/**
	 * @return the codigoPlazoPagoCatTip
	 */
	public Integer getCodigoPlazoPagoCatTip() {
		return codigoPlazoPagoCatTip;
	}

	/**
	 * @param codigoPlazoPagoCatTip the codigoPlazoPagoCatTip to set
	 */
	public void setCodigoPlazoPagoCatTip(Integer codigoPlazoPagoCatTip) {
		this.codigoPlazoPagoCatTip = codigoPlazoPagoCatTip;
	}

	/**
	 * @return the plazoPagoCatalogo
	 */
	public CatalogoValorDTO getPlazoPagoCatalogo() {
		return plazoPagoCatalogo;
	}

	/**
	 * @param plazoPagoCatalogo the plazoPagoCatalogo to set
	 */
	public void setPlazoPagoCatalogo(CatalogoValorDTO plazoPagoCatalogo) {
		this.plazoPagoCatalogo = plazoPagoCatalogo;
	}
	
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
}
