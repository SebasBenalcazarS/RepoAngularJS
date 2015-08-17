package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

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
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.constants.CollectionType;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.MonedaDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.ordenCompra.SICOrdenCompraConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraDetalleEstadoID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;
/**
 * 
 * @author amunoz
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCORCTORDCOMDETEST")
public class OrdenCompraDetalleEstadoDTO extends SimpleAuditDTO {
	
	@EmbeddedId
    private OrdenCompraDetalleEstadoID id = new OrdenCompraDetalleEstadoID();
	
	@Column(name = "SECUENCIALORDENCOMPRADETALLEESTADO", nullable=false)
    @SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCORCSECORDCOMDETESTSEC")
    private Long secuencialOrdenCompraDetalleEstado;
    
	@Column(name = "CODIGOORDENCOMPRAESTADO", nullable = false)
	private Long codigoOrdenCompraEstado;
	
	//@Column(name = "CODIGOARTICULO", nullable = false)
	@Transient
	@Deprecated
	private String codigoArticulo;
	
	@Column(name = "CODIGOUNIDADMANEJO", nullable = false)
	private Long codigoUnidadManejo;
	
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;
	
    @Column(name = "NUMEROLINEA",  nullable=false)
    private Integer numeroLinea;
    
    @Column(name = "CANTIDADPEDIDA",  nullable=false)
    private Integer cantidadPedida;
   
    @Column(name = "CANTIDADPARCIAL", nullable = false)
    private Integer cantidadParcial;
    
    @Column(name = "CANTIDADENTREGADA")
    private Integer cantidadEntregada;
    
    @Column(name = "PESOPEDIDO")
    private BigDecimal pesoPedido;

    @Column(name = "PESOPARCIAL")
    private BigDecimal pesoParcial;
    
    @Column(name = "PESOENTREGADO")
    private BigDecimal pesoEntregado;
    
    @Column(name = "COSTONETO",  nullable=false)
    private BigDecimal costoNeto;
   
    @Column(name = "COSTOBRUTO",  nullable=false)
    private BigDecimal costoBruto;
 
    @Column(name = "VALORTOTAL",  nullable=false)
    private BigDecimal valorTotal;
    
    @Column(name = "CODIGOESTADOARTICULOCATVAL")
    @ComparatorTypeField
    private String codigoEstadoArticuloCatVal;
    
    @Column(name = "CODIGOESTADOARTICULOCATTIP")
    private Integer codigoEstadoArticuloCatTip;
    
    @Column(name = "CANTIDADPEDIDARECEPCION",  nullable=false)
    private Integer cantidadPedidaRecepcion;
   
    @Column(name = "CANTIDADENTREGADARECEPCION")
    private Integer cantidadEntregadaRecepcion;
    
    @Column(name = "PESOPEDIDORECEPCION")
    private BigDecimal pesoPedidoRecepcion;
    
    @Column(name = "PESOENTREGADORECEPCION")
    private BigDecimal pesoEntregadoRecepcion;
    
    @Column(name = "CODIGOMONEDA")
    @Transient
    private Long codigoMonedaOrigen;
    
    @Column(name = "TASACAMBIO")
    @Transient
    private BigDecimal tasaCambio;
    
    @Column(name = "ESTADO", nullable = false)
    @ComparatorTypeField
    private String estado;
    
    @RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO",  nullable=false)
    @ComparatorTypeField
    private String idUsuarioRegistro;

    @RegisterDateField
    @Column(name = "FECHAREGISTRO",  nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @LastModifierUserIdField
    @Column(name = "IDUSUARIOMODIFICACION")
    private String idUsuarioModificacion;
    
    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Transient
    private Integer alturaWarning;
    
    @Transient
    private String materialArticulo;
    
    @Transient
    private String nombreArticulo;
    
    @Transient
    private BigDecimal costoBrutoSinTasa;
    
    @Transient 
    private boolean mostrarCodigoBarras;
    
    @Transient
    private Integer valorUnidadManejo;
    
    @Transient
    private BigDecimal valorTotalCostoBruto;
    
    @Transient
    private BigDecimal valorTotalCostoNeto;
    
    @Transient
    private Double porcentajeCobroNegociacion;
    
    @Transient
    private Map<Long,Double> negociacionesProveedorMap;
    
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOUNIDADMANEJO", referencedColumnName = "CODIGOUNIDADMANEJO", insertable = false, updatable = false)
    })*/
    @Transient
    @Deprecated
    private ArticuloUnidadManejoDTO articuloUnidadManejo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOUNIDADMANEJO", referencedColumnName = "CODIGOUNIDADMANEJO", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
    })
    private ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedor;
    
    @OneToMany(mappedBy = "ordenCompraDetalleEstadoDTO")
   	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<DetalleFacturaEstadoDTO> detalleFacturaEstadoCols;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOESTADOARTICULOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOESTADOARTICULOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO estadoArticulo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODIGOMONEDAORIGEN", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false)
    @Transient
    private MonedaDTO moneda;
    
    @OneToMany(mappedBy = "ordenCompraDetalleEstado")
   	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<OrdenCompraDetalleEstadoDescuentoDTO> ordenCompraDetalleEstadoDescuentoCol;
    
    @OneToMany(mappedBy = "ordenCompraDetalleEstado")
   	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<OrdenCompraDetalleEstadoImpuestoDTO> ordenCompraDetalleEstadoImpuestoCol;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOORDENCOMPRAESTADO", referencedColumnName = "CODIGOORDENCOMPRAESTADO", insertable = false, updatable = false)
    })
    private OrdenCompraEstadoDTO ordenCompraEstado;
    
    @ManyToOne(fetch = LAZY)
  	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
  	private UserDto usuarioRegistroDTO;
    
    @OneToMany(mappedBy = "ordenCompraDetalleEstadoDTOPadre")
	@CollectionTypeInfo(name = CollectionType.LIST_COLLECTION_TYPE)
	private Collection<OrdenCompraDetalleEstadoRelacionDTO> ordenCompraDetalleEstadoRelacionDTOCol;
    
	public OrdenCompraDetalleEstadoID getId() {
		return id;
	}

	public void setId(OrdenCompraDetalleEstadoID id) {
		this.id = id;
	}

	public Integer getNumeroLinea() {
		return numeroLinea;
	}

	public void setNumeroLinea(Integer numeroLinea) {
		this.numeroLinea = numeroLinea;
	}

	public BigDecimal getCostoNeto() {
		return costoNeto;
	}

	public void setCostoNeto(BigDecimal costoNeto) {
		this.costoNeto = costoNeto;
	}

	public BigDecimal getCostoBruto() {
		return costoBruto;
	}

	public void setCostoBruto(BigDecimal costoBruto) {
		this.costoBruto = costoBruto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
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
	 * @return the ordenCompraEstado
	 */
	public OrdenCompraEstadoDTO getOrdenCompraEstado() {
		return ordenCompraEstado;
	}

	/**
	 * @param ordenCompraEstado the ordenCompraEstado to set
	 */
	public void setOrdenCompraEstado(OrdenCompraEstadoDTO ordenCompraEstado) {
		this.ordenCompraEstado = ordenCompraEstado;
	}

	/**
	 * @return the articuloUnidadManejo
	 */
	@Deprecated
	public ArticuloUnidadManejoDTO getArticuloUnidadManejo() {
		return articuloUnidadManejo;
	}

	/**
	 * @param articuloUnidadManejo the articuloUnidadManejo to set
	 */
	@Deprecated
	public void setArticuloUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejo) {
		this.articuloUnidadManejo = articuloUnidadManejo;
	}

	/**
	 * @return the ordenCompraDetalleEstadoDescuentoCol
	 */
	public Collection<OrdenCompraDetalleEstadoDescuentoDTO> getOrdenCompraDetalleEstadoDescuentoCol() {
		return ordenCompraDetalleEstadoDescuentoCol;
	}

	/**
	 * @param ordenCompraDetalleEstadoDescuentoCol the ordenCompraDetalleEstadoDescuentoCol to set
	 */
	public void setOrdenCompraDetalleEstadoDescuentoCol(
			Collection<OrdenCompraDetalleEstadoDescuentoDTO> ordenCompraDetalleEstadoDescuentoCol) {
		this.ordenCompraDetalleEstadoDescuentoCol = ordenCompraDetalleEstadoDescuentoCol;
	}

	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}

	/**
	 * @return the codigoOrdenCompraEstado
	 */
	public Long getCodigoOrdenCompraEstado() {
		return codigoOrdenCompraEstado;
	}

	/**
	 * @param codigoOrdenCompraEstado the codigoOrdenCompraEstado to set
	 */
	public void setCodigoOrdenCompraEstado(Long codigoOrdenCompraEstado) {
		this.codigoOrdenCompraEstado = codigoOrdenCompraEstado;
	}

	/**
	 * @return the codigoArticulo
	 */
	@Deprecated
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	@Deprecated
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	/**
	 * @return the cantidadPedida
	 */
	public Integer getCantidadPedida() {
		return cantidadPedida;
	}

	/**
	 * @param cantidadPedida the cantidadPedida to set
	 */
	public void setCantidadPedida(Integer cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	/**
	 * @return the cantidadParcial
	 */
	public Integer getCantidadParcial() {
		return cantidadParcial;
	}

	/**
	 * @param cantidadParcial the cantidadParcial to set
	 */
	public void setCantidadParcial(Integer cantidadParcial) {
		this.cantidadParcial = cantidadParcial;
	}

	/**
	 * @return the pesoPedido
	 */
	public BigDecimal getPesoPedido() {
		return pesoPedido;
	}

	/**
	 * @param pesoPedido the pesoPedido to set
	 */
	public void setPesoPedido(BigDecimal pesoPedido) {
		this.pesoPedido = pesoPedido;
	}

	/**
	 * @return the pesoParcial
	 */
	public BigDecimal getPesoParcial() {
		return pesoParcial;
	}

	/**
	 * @param pesoParcial the pesoParcial to set
	 */
	public void setPesoParcial(BigDecimal pesoParcial) {
		this.pesoParcial = pesoParcial;
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
	 * M�todo que verifica si el art�culo tiene alg�n conflicto de registro sanitario en el caso de aplicarlo
	 * @return
	 */
	/*public boolean getTieneConflictoRegistroSanitario(){
		//verifica si el art�culo aplica registro sanitario
		if(this.articuloUnidadManejo != null && this.articuloUnidadManejo.getArticulo() != null 
				&& this.articuloUnidadManejo.getArticulo().getAplicaRegistroSanitario() != null && this.articuloUnidadManejo.getArticulo().getAplicaRegistroSanitario()){
			//verifica si tiene un registro sanitario activo y vigente
			if(!SearchDTO.isLoaded(this.articuloUnidadManejo.getArticulo().getRegistroSanitarioCol()) 
					|| (SearchDTO.isLoaded(this.articuloUnidadManejo.getArticulo().getRegistroSanitarioCol()) 
							&& this.articuloUnidadManejo.getArticulo().getRegistroSanitarioCol() == null) 
					|| (SearchDTO.isLoaded(this.articuloUnidadManejo.getArticulo().getRegistroSanitarioCol()) 
							&& this.articuloUnidadManejo.getArticulo().getRegistroSanitarioCol() != null 
							&& this.articuloUnidadManejo.getArticulo().getRegistroSanitarioCol().isEmpty())){
				return true;
			}
		}
		return false;
	}*/
	
	/**
	 * M�todo que verifica si el art�culo es paletizado
	 * @return
	 */
	/*public boolean getEsPaletizado(){
		//verifica si el art�culo es paletizado
		if(this.articuloUnidadManejo != null && this.articuloUnidadManejo.getArticulo() != null 
				&& SearchDTO.isLoaded(this.articuloUnidadManejo.getArticulo().getArticuloProcesoLogisticoDTO()) 
				&& this.articuloUnidadManejo.getArticulo().getArticuloProcesoLogisticoDTO() != null 
				&& this.articuloUnidadManejo.getArticulo().getArticuloProcesoLogisticoDTO().getValorContenedorDistribucion() != null){
			return true;
		}
		return false;
	}*/
	
	/**
	 * M�todo que obtiene la cantidad de unidades de manejor necesarias para completar un palet
	 * @return
	 */
	public Integer getCantidadUnidadManejoPorPalet(){
		//verifica si el art�culo es paletizado
		//if(this.getEsPaletizado()){
			//verifica si tiene unidad de manejo padre de tipo palet
			if(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticuloUnidadManejoContenedoraCol() != null
					&& SearchDTO.isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticuloUnidadManejoContenedoraCol())
					&& !this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticuloUnidadManejoContenedoraCol().isEmpty()){
				//obtiene el valor de la unidad de manejo contenedora
				return this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticuloUnidadManejoContenedoraCol().iterator().next().getValorUnidadManejo();
			}
		//}
		return null;
	}

	/**
	 * @return the detalleFacturaEstadoCols
	 */
	public Collection<DetalleFacturaEstadoDTO> getDetalleFacturaEstadoCols() {
		return detalleFacturaEstadoCols;
	}

	/**
	 * @param detalleFacturaEstadoCols the detalleFacturaEstadoCols to set
	 */
	public void setDetalleFacturaEstadoCols(
			Collection<DetalleFacturaEstadoDTO> detalleFacturaEstadoCols) {
		this.detalleFacturaEstadoCols = detalleFacturaEstadoCols;
	}
	
	/**
	 * Valida si tiene unidad de medida el articulo del detalle de la orden de compra estado
	 * @return
	 */
	public Boolean getTieneArticuloMedida() {
		if (isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO()) == false) {
			return false;
		}
		if (isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo()) == false) {
			return false;
		}
		if (isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloMedidaDTO()) == false) {
			return false;
		}
		return true;
	}
	
	public String getDescripcionArticuloCompleta(){
		String descripcion = null;
		if (isLoaded(this.articuloUnidadManejoProveedor)){
			
			/*Para todos los tipos de proveedores importados/nacionales se presenta la descripcion de la tabla articulo*/
			if (isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO()) 
					&& isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo()) 
					&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getDescripcionArticulo() != null) {
				descripcion = this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getDescripcionArticulo();
			}
			
			/*
			 * Para articulo importados la descripcion se la toma de la tabla articulo importado y para nacionales de la tabla
			 * ARTICULO 
			 * 
			if(isLoaded(this.articuloUnidadManejoProveedor.getArticuloProveedor()) 
					&& isLoaded(this.articuloUnidadManejoProveedor.getArticuloProveedor().getArticuloImportacion())
					&& this.articuloUnidadManejoProveedor.getArticuloProveedor().getArticuloImportacion().getDescripcionArticulo() != null){
				descripcion = this.articuloUnidadManejoProveedor.getArticuloProveedor().getArticuloImportacion().getDescripcionArticulo();
			}else if(isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO()) 
					&& isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo()) 
					&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getDescripcionArticulo() != null){
				descripcion = this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getDescripcionArticulo();
			}
			*/
		}
		return descripcion;
	}
	
	public String getDescripcionArticulo(){
		String descripcion = null;
		String descripcionAux = this.getDescripcionArticuloCompleta();
		
		if (StringUtils.isNotBlank(descripcionAux)) {
		
			String[] result = descripcionAux.split(" ");
	        for(String palabra : result){
	        	if(palabra.contains("+") && palabra.indexOf("+") != (palabra.length() -1)){
	        		palabra = palabra.replace("+", "+ ");
	        	}
	        	if(palabra.contains("-") && palabra.indexOf("-") != (palabra.length() -1)){
	        		palabra = palabra.replace("-", "- ");
	        	}
	        	if(palabra.contains(".") && palabra.indexOf(".") != (palabra.length() -1)){
	        		palabra = palabra.replace(".", ". ");
	        	}
	        	if(palabra.contains("/") && palabra.indexOf("/") != (palabra.length() -1)){
	        		palabra = palabra.replace("/", "/ ");
	        	}
	        	if(palabra.contains("%") && palabra.indexOf("%") != (palabra.length() -1)){
	        		palabra = palabra.replace("%", "% ");
	        	}
	        	if(descripcion != null){
	        		descripcion = descripcion.concat(" ").concat(palabra);
	        	}else{
	        		descripcion = palabra;
	        	}
	        }
			if(descripcion.length() > SICOrdenCompraConstantes.getInstancia().VALOR_TRUNCAMIENTO_DESCRIPCION){
				descripcion = descripcion.substring(0, SICOrdenCompraConstantes.getInstancia().VALOR_TRUNCAMIENTO_DESCRIPCION-3);
				descripcion = descripcion.concat("...");
				
			}
			if(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloMedidaDTO() != null &&
					isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloMedidaDTO())){
				if(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloMedidaDTO().getReferenciaMedida().length() > 10){
					descripcion=descripcion.concat(" ").concat(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloMedidaDTO().getReferenciaMedida().substring(0,9));
				}else{
				
					descripcion=descripcion.concat(" ").concat(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloMedidaDTO().getReferenciaMedida());
				}
			}
		}
		return descripcion;
	}

	/**
	 * @return the cantidadEntregada
	 */
	public Integer getCantidadEntregada() {
		return cantidadEntregada;
	}

	/**
	 * @param cantidadEntregada the cantidadEntregada to set
	 */
	public void setCantidadEntregada(Integer cantidadEntregada) {
		this.cantidadEntregada = cantidadEntregada;
	}

	/**
	 * @return the pesoEntregado
	 */
	public BigDecimal getPesoEntregado() {
		return pesoEntregado;
	}

	/**
	 * @param pesoEntregado the pesoEntregado to set
	 */
	public void setPesoEntregado(BigDecimal pesoEntregado) {
		this.pesoEntregado = pesoEntregado;
	}

	/**
	 * @return the ordenCompraDetalleEstadoImpuestoCol
	 */
	public Collection<OrdenCompraDetalleEstadoImpuestoDTO> getOrdenCompraDetalleEstadoImpuestoCol() {
		return ordenCompraDetalleEstadoImpuestoCol;
	}

	/**
	 * @param ordenCompraDetalleEstadoImpuestoCol the ordenCompraDetalleEstadoImpuestoCol to set
	 */
	public void setOrdenCompraDetalleEstadoImpuestoCol(Collection<OrdenCompraDetalleEstadoImpuestoDTO> ordenCompraDetalleEstadoImpuestoCol) {
		this.ordenCompraDetalleEstadoImpuestoCol = ordenCompraDetalleEstadoImpuestoCol;
	}

	/**
	 * @return the codigoEstadoArticuloCatVal
	 */
	public String getCodigoEstadoArticuloCatVal() {
		return codigoEstadoArticuloCatVal;
	}

	/**
	 * @param codigoEstadoArticuloCatVal the codigoEstadoArticuloCatVal to set
	 */
	public void setCodigoEstadoArticuloCatVal(String codigoEstadoArticuloCatVal) {
		this.codigoEstadoArticuloCatVal = codigoEstadoArticuloCatVal;
	}

	/**
	 * @return the codigoEstadoArticuloCatTip
	 */
	public Integer getCodigoEstadoArticuloCatTip() {
		return codigoEstadoArticuloCatTip;
	}

	/**
	 * @param codigoEstadoArticuloCatTip the codigoEstadoArticuloCatTip to set
	 */
	public void setCodigoEstadoArticuloCatTip(Integer codigoEstadoArticuloCatTip) {
		this.codigoEstadoArticuloCatTip = codigoEstadoArticuloCatTip;
	}

	/**
	 * @return the estadoArticulo
	 */
	public CatalogoValorDTO getEstadoArticulo() {
		return estadoArticulo;
	}

	/**
	 * @param estadoArticulo the estadoArticulo to set
	 */
	public void setEstadoArticulo(CatalogoValorDTO estadoArticulo) {
		this.estadoArticulo = estadoArticulo;
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getPorcentajeCumplimiento(){
		
		if(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO() != null && isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO()) 
				&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo() != null && isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo())
				&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO() != null && isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO())){
			if(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO().getValorTipoControlCosto().equals(SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPES)
					|| this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO().getValorTipoControlCosto().equals(SICArticuloConstantes.getInstancia().TIPCONCOS_PESPES)
					|| this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO().getValorTipoControlCosto().equals(SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPESUM)){
				return this.pesoEntregado.divide(this.pesoPedido).multiply(BigDecimal.valueOf(100)).intValue();
			}else if(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO().getValorTipoControlCosto().equals(SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPIE)){
				return(this.cantidadEntregada / this.cantidadPedida) * 100;
			}
		}
		
		return null;
	}


	
	public Integer getAlturaWarning() {
		return alturaWarning;
	}

	public void setAlturaWarning(Integer alturaWarning) {
		this.alturaWarning = alturaWarning;
	}

	public String getMaterialArticuloCompleto(){
		String materialArticulo = null;
		if(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO() != null && isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO()) 
				&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo() != null && isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo())
				&& CollectionUtils.isNotEmpty(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloMaterialDTOs())){
			for(ArticuloMaterialDTO articuloMaterialDTO : this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloMaterialDTOs()){
				if(articuloMaterialDTO.getId() != null && articuloMaterialDTO.getId().getCodigoTipoMaterial() != null 
						&& articuloMaterialDTO.getId().getCodigoTipoMaterial().equals(SICArticuloConstantes.getInstancia().CODIGOTIPOMATERIAL)
						&& articuloMaterialDTO.getId().getValorTipoMaterial().equals(SICArticuloConstantes.getInstancia().VALOR_TIPOMATERIAL_OTRO)
						&& articuloMaterialDTO.getEstado().equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)
						&& !articuloMaterialDTO.getEsPrincipal()){
					materialArticulo = articuloMaterialDTO.getObservacion();
					break;
				}
			}
		}
		return materialArticulo;
	}
	
	public String getMaterialArticulo() {
		if(this.materialArticulo == null){

			this.materialArticulo = this.getMaterialArticuloCompleto();
			
			if(this.materialArticulo != null){
				String material = null;
				String materialArticuloAux = this.materialArticulo;
				String[] result = materialArticuloAux.split(" ");
				
		        for(String palabra : result){
		        	if(palabra.contains("+") && palabra.indexOf("+") != (palabra.length() -1)){
		        		palabra = palabra.replace("+", "+ ");
		        	}
		        	if(palabra.contains("-") && palabra.indexOf("-") != (palabra.length() -1)){
		        		palabra = palabra.replace("-", "- ");
		        	}
		        	if(palabra.contains(".") && palabra.indexOf(".") != (palabra.length() -1)){
		        		palabra = palabra.replace(".", ". ");
		        	}
		        	if(palabra.contains("/") && palabra.indexOf("/") != (palabra.length() -1)){
		        		palabra = palabra.replace("/", "/ ");
		        	}
		        	if(palabra.contains("%") && palabra.indexOf("%") != (palabra.length() -1)){
		        		palabra = palabra.replace("%", "% ");
		        	}
		        	if(material != null){
		        		material = material.concat(" ").concat(palabra);
		        	}else{
		        		material = palabra;
		        	}
		        }
				if(material != null && material.length() > SICOrdenCompraConstantes.getInstancia().VALOR_TRUNCAMIENTO_MATERIAL){
					material = material.substring(0,  SICOrdenCompraConstantes.getInstancia().VALOR_TRUNCAMIENTO_MATERIAL-3);
					material = material.concat("...");
				}
				
				this.materialArticulo = material;
			}
		
		}

		return this.materialArticulo;
	}
	public String getMarcaArticulo() {
		
		String marca = null;
		if(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO() != null && isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO()) 
				&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo() != null && isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo())
				&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO() != null 
				&& isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO())
				&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO().getMarcaComercialArticulo() != null
				&& isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO().getMarcaComercialArticulo())){
			
			marca = this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO().getMarcaComercialArticulo().getId().getSecuencialMarca().toString();
			marca =  marca.concat("-").concat(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloComercialDTO().getMarcaComercialArticulo().getNombre());
		}
		return marca;
	}
	
	
	
	public void setMaterialArticulo(String materialArticulo) {
		this.materialArticulo = materialArticulo;
	}

	/**
	 * Calcula la diferencia de la cantidad pedida y la cantidad parcial planificada
	 * @return
	 */
	public Integer getCantidadDisponiblePlanificada() {
		Integer cantidadDisponiblePlanificada = 0;
		if (this.cantidadPedida != null) {
			cantidadDisponiblePlanificada = this.cantidadPedida;
		}
		if (this.cantidadParcial != null) {
			cantidadDisponiblePlanificada -=  cantidadParcial;
		}
		return cantidadDisponiblePlanificada;
	}

	/**
	 * Calcula la diferencia del peso pedido y el peso planificado
	 * @return
	 */
	public BigDecimal getPesoDisponiblePlanificado() {
		BigDecimal pesoDisponiblePlanificado = new BigDecimal(0);
		if (this.pesoPedido != null) {
			pesoDisponiblePlanificado = this.pesoPedido;
		}
		if (this.pesoParcial != null) {
			pesoDisponiblePlanificado = pesoDisponiblePlanificado.subtract(pesoParcial);
		}
		return pesoDisponiblePlanificado;
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
	 * @return the articuloUnidadManejoProveedor
	 */
	public ArticuloUnidadManejoProveedorDTO getArticuloUnidadManejoProveedor() {
		return articuloUnidadManejoProveedor;
	}

	/**
	 * @param articuloUnidadManejoProveedor the articuloUnidadManejoProveedor to set
	 */
	public void setArticuloUnidadManejoProveedor(ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedor) {
		this.articuloUnidadManejoProveedor = articuloUnidadManejoProveedor;
	}

	/**
	 * @return the codigoMonedaOrigen
	 */
	public Long getCodigoMonedaOrigen() {
		return codigoMonedaOrigen;
	}

	/**
	 * @param codigoMonedaOrigen the codigoMonedaOrigen to set
	 */
	public void setCodigoMonedaOrigen(Long codigoMonedaOrigen) {
		this.codigoMonedaOrigen = codigoMonedaOrigen;
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
	
	public ArticuloLocalDTO getArticuloBodega(){
		if(this.articuloUnidadManejoProveedor != null && SearchDTO.isLoaded(this.articuloUnidadManejoProveedor)
				&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO() != null && SearchDTO.isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO())
				&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo() != null && SearchDTO.isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo())
				&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloLocalCol() != null 
				&& SearchDTO.isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloLocalCol())
				&& !this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloLocalCol().isEmpty()){
			return this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getArticuloLocalCol().iterator().next();
		}
		return null;
	}
	
	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public BigDecimal getCostoBrutoSinTasa() {
		return costoBrutoSinTasa;
	}

	public void setCostoBrutoSinTasa(BigDecimal costoBrutoSinTasa) {
		this.costoBrutoSinTasa = costoBrutoSinTasa;
	}

	public Boolean getMostrarCodigoBarras() {
		this.mostrarCodigoBarras = Boolean.FALSE;
		if(this.articuloUnidadManejoProveedor != null && SearchDTO.isLoaded(this.articuloUnidadManejoProveedor)
				&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO() != null && SearchDTO.isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO())
				&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo() != null && SearchDTO.isLoaded(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo())
				&& this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getCodigoBarras()!= null){
			if(!this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getCodigoEstado().equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO) ||
					(this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getCodigoEstado().equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO) &&
						(StringUtils.equals(SICArticuloConstantes.getInstancia().TIPO_CODBAR_EAN, this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getCodigoTipoCodigoArticulo()) 
								|| StringUtils.equals(SICArticuloConstantes.getInstancia().TIPO_CODBAR_EAN128, this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getCodigoTipoCodigoArticulo())
								|| StringUtils.equals(SICArticuloConstantes.getInstancia().TIPO_CODBAR_EAN14, this.articuloUnidadManejoProveedor.getArticuloUnidadManejoDTO().getArticulo().getCodigoTipoCodigoArticulo())))){
				
				this.mostrarCodigoBarras = Boolean.TRUE;
			}
		}
			
		return this.mostrarCodigoBarras;
	}

	/**
	 * @param mostrarCodigoBarras the mostrarCodigoBarras to set
	 */
	public void setMostrarCodigoBarras(boolean mostrarCodigoBarras) {
		this.mostrarCodigoBarras = mostrarCodigoBarras;
	}

	public Integer getCantidadPedidaRecepcion() {
		return cantidadPedidaRecepcion;
	}

	public void setCantidadPedidaRecepcion(Integer cantidadPedidaRecepcion) {
		this.cantidadPedidaRecepcion = cantidadPedidaRecepcion;
	}

	public Integer getCantidadEntregadaRecepcion() {
		return cantidadEntregadaRecepcion;
	}

	public void setCantidadEntregadaRecepcion(Integer cantidadEntregadaRecepcion) {
		this.cantidadEntregadaRecepcion = cantidadEntregadaRecepcion;
	}

	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}

	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}
	
	public Collection<OrdenCompraDetalleEstadoRelacionDTO> getOrdenCompraDetalleEstadoRelacionDTOCol() {
		return ordenCompraDetalleEstadoRelacionDTOCol;
	}

	public void setOrdenCompraDetalleEstadoRelacionDTOCol(Collection<OrdenCompraDetalleEstadoRelacionDTO> ordenCompraDetalleEstadoRelacionDTOCol) {
		this.ordenCompraDetalleEstadoRelacionDTOCol = ordenCompraDetalleEstadoRelacionDTOCol;
	}

	/**
	 * @return the pesoPedidoRecepcion
	 */
	public BigDecimal getPesoPedidoRecepcion() {
		return pesoPedidoRecepcion;
	}

	/**
	 * @param pesoPedidoRecepcion the pesoPedidoRecepcion to set
	 */
	public void setPesoPedidoRecepcion(BigDecimal pesoPedidoRecepcion) {
		this.pesoPedidoRecepcion = pesoPedidoRecepcion;
	}

	/**
	 * @return the pesoEntregadoRecepcion
	 */
	public BigDecimal getPesoEntregadoRecepcion() {
		return pesoEntregadoRecepcion;
	}

	/**
	 * @param pesoEntregadoRecepcion the pesoEntregadoRecepcion to set
	 */
	public void setPesoEntregadoRecepcion(BigDecimal pesoEntregadoRecepcion) {
		this.pesoEntregadoRecepcion = pesoEntregadoRecepcion;
	}

	/**
	 * @return the secuencialOrdenCompraDetalleEstado
	 */
	public Long getSecuencialOrdenCompraDetalleEstado() {
		return secuencialOrdenCompraDetalleEstado;
	}

	/**
	 * @param secuencialOrdenCompraDetalleEstado the secuencialOrdenCompraDetalleEstado to set
	 */
	public void setSecuencialOrdenCompraDetalleEstado(Long secuencialOrdenCompraDetalleEstado) {
		this.secuencialOrdenCompraDetalleEstado = secuencialOrdenCompraDetalleEstado;
	}

	/**
	 * @return the valorTotalCostoBruto
	 */
	public BigDecimal getValorTotalCostoBruto() {
		return valorTotalCostoBruto;
	}

	/**
	 * @param valorTotalCostoBruto the valorTotalCostoBruto to set
	 */
	public void setValorTotalCostoBruto(BigDecimal valorTotalCostoBruto) {
		this.valorTotalCostoBruto = valorTotalCostoBruto;
	}

	/**
	 * @return the valorTotalCostoNeto
	 */
	public BigDecimal getValorTotalCostoNeto() {
		return valorTotalCostoNeto;
	}

	/**
	 * @param valorTotalCostoNeto the valorTotalCostoNeto to set
	 */
	public void setValorTotalCostoNeto(BigDecimal valorTotalCostoNeto) {
		this.valorTotalCostoNeto = valorTotalCostoNeto;
	}
	
	public Double getPorcentajeCobroNegociacion() {
		return porcentajeCobroNegociacion;
	}

	public void setPorcentajeCobroNegociacion(Double porcentajeCobroNegociacion) {
		this.porcentajeCobroNegociacion = porcentajeCobroNegociacion;
	}

	public Map<Long, Double> getNegociacionesProveedorMap() {
		return negociacionesProveedorMap;
	}

	public void setNegociacionesProveedorMap(Map<Long, Double> negociacionesProveedorMap) {
		this.negociacionesProveedorMap = negociacionesProveedorMap;
	}
}
