package ec.com.smx.sic.cliente.mdl.dto;

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

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.ordenCompra.SICOrdenCompraConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraID;

/**
 * 
 * @author amunoz
 * @author jvillacis
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SCORCTORDCOM")
public class OrdenCompraDTO extends SimpleAuditDTO {

	@EmbeddedId
	private OrdenCompraID id = new OrdenCompraID();
	
	
	@Column(name = "CODIGOPEDIDO", nullable = false)
	private Long codigoPedido;

	@Column(name = "NUMEROORDENCOMPRA", nullable = false)
    private String numeroOrdenCompra;
   
    @Column(name = "CODIGOCLASIFICACION", nullable = false)
    @ComparatorTypeField
    private String codigoClasificacion;
    
    @Column(name = "CODIGOLINEACOMERCIAL")
    private Long codigoLineaComercial;
    
    @Column(name = "CODIGOAREATRABAJODESTINO", nullable = false)
    private Integer codigoAreaTrabajoDestino;
    
    @Column(name = "ESTADO", nullable = false)
    @ComparatorTypeField
    private String estado;

    @RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO",  nullable = false)
    private String idUsuarioRegistro;
    
    @RegisterDateField
    @Column(name = "FECHAREGISTRO",  nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @LastModifierUserIdField
    @Column(name = "IDUSUARIOMODIFICACION")
    private String idUsuarioModificacion;
    
    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOAREATRABAJODESTINO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)
    })
    private AreaTrabajoDTO areaTrabajoDestino;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false)
    })
    private ClasificacionDTO clasificacion;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOLINEACOMERCIAL", referencedColumnName = "CODIGOLINEACOMERCIAL", insertable = false, updatable = false)
    })
    private LineaComercialDTO lineaComercial;
    
    @Column(name = "FECHAENTREGA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
   
    @Column(name = "FECHACADUCIDAD", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaducidad;

    @Column(name = "FECHAPUBLICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;
    
    @Column(name = "FECHASUGERIDO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSugerido;
    
    @OneToMany(mappedBy = "ordenCompra")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<OrdenCompraEstadoDTO> ordenCompraEstadoCol;
    
    @OneToMany(mappedBy = "ordenCompra")
    @CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<OrdenCompraHistoricoEstadoDTO> ordenCompraHistoricoEstadoCol;
    
    @OneToMany(mappedBy = "ordenCompra")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<OrdenCompraRelacionadaDTO> ordenCompraRelacionadaCol;
    
    @OneToMany(mappedBy = "ordenCompra")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<OrdenCompraFacturaImportacionDTO> ordenCompraFacturaImportacionCol;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOPEDIDO", referencedColumnName = "CODIGOPEDIDO", insertable = false, updatable = false)
    })
    private PedidoDTO pedido;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;
    
    
	public OrdenCompraID getId() {
		return id;
	}

	public void setId(OrdenCompraID id) {
		this.id = id;
	}

	public String getNumeroOrdenCompra() {
		return numeroOrdenCompra;
	}

	public void setNumeroOrdenCompra(String numeroOrdenCompra) {
		this.numeroOrdenCompra = numeroOrdenCompra;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
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

	public ClasificacionDTO getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(ClasificacionDTO clasificacion) {
		this.clasificacion = clasificacion;
	}

	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}

	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}

	/**
	 * @return the ordenCompraEstadoCol
	 */
	public Collection<OrdenCompraEstadoDTO> getOrdenCompraEstadoCol() {
		return ordenCompraEstadoCol;
	}

	/**
	 * @param ordenCompraEstadoCol the ordenCompraEstadoCol to set
	 */
	public void setOrdenCompraEstadoCol(
			Collection<OrdenCompraEstadoDTO> ordenCompraEstadoCol) {
		this.ordenCompraEstadoCol = ordenCompraEstadoCol;
	}

	/**
	 * @return the ordenCompraRelacionadaCol
	 */
	public Collection<OrdenCompraRelacionadaDTO> getOrdenCompraRelacionadaCol() {
		return ordenCompraRelacionadaCol;
	}

	/**
	 * @param ordenCompraRelacionadaCol the ordenCompraRelacionadaCol to set
	 */
	public void setOrdenCompraRelacionadaCol(
			Collection<OrdenCompraRelacionadaDTO> ordenCompraRelacionadaCol) {
		this.ordenCompraRelacionadaCol = ordenCompraRelacionadaCol;
	}

	public Collection<OrdenCompraHistoricoEstadoDTO> getOrdenCompraHistoricoEstadoCol() {
		return ordenCompraHistoricoEstadoCol;
	}

	public void setOrdenCompraHistoricoEstadoCol(
			Collection<OrdenCompraHistoricoEstadoDTO> ordenCompraHistoricoEstadoCol) {
		this.ordenCompraHistoricoEstadoCol = ordenCompraHistoricoEstadoCol;
	}
	
	/**
	 * 
	 * @return orden compra estado actual
	 */
	public OrdenCompraEstadoDTO getOrdenCompraEstadoDTOActual(){
		if(this.ordenCompraEstadoCol != null && SearchDTO.isLoaded(this.ordenCompraEstadoCol) && !this.ordenCompraEstadoCol.isEmpty()){
			return this.ordenCompraEstadoCol.iterator().next();
		}
		return null;
	}
	
	/**
	 * 
	 * @return n�mero de entregas recibas de esa orden de compra
	 */
	public Integer getNumeroEntregasRecibidas(){
		if(this.ordenCompraHistoricoEstadoCol != null && SearchDTO.isLoaded(this.ordenCompraHistoricoEstadoCol) && !this.ordenCompraHistoricoEstadoCol.isEmpty()){
			for(OrdenCompraHistoricoEstadoDTO ordenCompraHistoricoEstadoDTO : this.ordenCompraHistoricoEstadoCol){
				if(ordenCompraHistoricoEstadoDTO
						.getId()
						.getCodigoEstadoCatVal()
						.equals(SICOrdenCompraConstantes.getInstancia().CODIGO_VALOR_ESTADO_ORDENCOMPRA_ENTREGADA)){
					return ordenCompraHistoricoEstadoDTO.getCantidadEstado();
				}
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * @return n�mero de entregas recibas de esa orden de compra
	 */
	public boolean getOrdenCompraCancelada(){
		if(this.ordenCompraHistoricoEstadoCol != null && SearchDTO.isLoaded(this.ordenCompraHistoricoEstadoCol) && !this.ordenCompraHistoricoEstadoCol.isEmpty()){
			for(OrdenCompraHistoricoEstadoDTO ordenCompraHistoricoEstadoDTO : this.ordenCompraHistoricoEstadoCol){
				if(ordenCompraHistoricoEstadoDTO
						.getId()
						.getCodigoEstadoCatVal()
						.equals(SICOrdenCompraConstantes.getInstancia().CODIGO_VALOR_ESTADO_ORDENCOMPRA_CANCELADA)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return nombre del estado actual de la orden de compra
	 */
	public String getNombreEstadoActual(){
		if(this.ordenCompraHistoricoEstadoCol != null && SearchDTO.isLoaded(this.ordenCompraHistoricoEstadoCol) && !this.ordenCompraHistoricoEstadoCol.isEmpty()){
			this.ordenCompraHistoricoEstadoCol = ColeccionesUtil.sort(this.ordenCompraHistoricoEstadoCol, ColeccionesUtil.ORDEN_DESC, "estado.orden");
			OrdenCompraHistoricoEstadoDTO ordenCompraHistoricoEstadoDTO = this.ordenCompraHistoricoEstadoCol.iterator().next();
			if(ordenCompraHistoricoEstadoDTO.getId().getCodigoEstadoCatVal()
					.equals(SICOrdenCompraConstantes.getInstancia().CODIGO_VALOR_ESTADO_ORDENCOMPRA_CANCELADA)){
				return "CANCELADA";
			}else if(ordenCompraHistoricoEstadoDTO.getId().getCodigoEstadoCatVal()
					.equals(SICOrdenCompraConstantes.getInstancia().CODIGO_VALOR_ESTADO_ORDENCOMPRA_CERRADA)){
				return "CERRADA";
			}else if (ordenCompraHistoricoEstadoDTO.getId().getCodigoEstadoCatVal()
					.equals(SICOrdenCompraConstantes.getInstancia().CODIGO_VALOR_ESTADO_ORDENCOMPRA_ENTREGADA)){
				return "ENTREGA ".concat(Integer.toString(ordenCompraHistoricoEstadoDTO.getCantidadEstado()));
			}
		}
		return "ENVIADA";
	}

	/**
	 * @return the codigoLineaComercial
	 */
	public Long getCodigoLineaComercial() {
		return codigoLineaComercial;
	}

	/**
	 * @param codigoLineaComercial the codigoLineaComercial to set
	 */
	public void setCodigoLineaComercial(Long codigoLineaComercial) {
		this.codigoLineaComercial = codigoLineaComercial;
	}

	/**
	 * @return the lineaComercial
	 */
	public LineaComercialDTO getLineaComercial() {
		return lineaComercial;
	}

	/**
	 * @param lineaComercial the lineaComercial to set
	 */
	public void setLineaComercial(LineaComercialDTO lineaComercial) {
		this.lineaComercial = lineaComercial;
	}

	/**
	 * @return the ordenCompraFacturaImportacionCol
	 */
	public Collection<OrdenCompraFacturaImportacionDTO> getOrdenCompraFacturaImportacionCol() {
		return ordenCompraFacturaImportacionCol;
	}

	/**
	 * @param ordenCompraFacturaImportacionCol the ordenCompraFacturaImportacionCol to set
	 */
	public void setOrdenCompraFacturaImportacionCol(Collection<OrdenCompraFacturaImportacionDTO> ordenCompraFacturaImportacionCol) {
		this.ordenCompraFacturaImportacionCol = ordenCompraFacturaImportacionCol;
	}

	/**
	 * @return the codigoAreaTrabajoDestino
	 */
	public Integer getCodigoAreaTrabajoDestino() {
		return codigoAreaTrabajoDestino;
	}

	/**
	 * @param codigoAreaTrabajoDestino the codigoAreaTrabajoDestino to set
	 */
	public void setCodigoAreaTrabajoDestino(Integer codigoAreaTrabajoDestino) {
		this.codigoAreaTrabajoDestino = codigoAreaTrabajoDestino;
	}

	/**
	 * @return the areaTrabajoDestino
	 */
	public AreaTrabajoDTO getAreaTrabajoDestino() {
		return areaTrabajoDestino;
	}

	/**
	 * @param areaTrabajoDestino the areaTrabajoDestino to set
	 */
	public void setAreaTrabajoDestino(AreaTrabajoDTO areaTrabajoDestino) {
		this.areaTrabajoDestino = areaTrabajoDestino;
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

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Date getFechaSugerido() {
		return fechaSugerido;
	}

	public void setFechaSugerido(Date fechaSugerido) {
		this.fechaSugerido = fechaSugerido;
	}
}
