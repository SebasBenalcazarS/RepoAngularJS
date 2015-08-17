/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

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
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.PedidoAreaTrabajoDetalleID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SBPEATPEDARETRADET")
public class PedidoAreaTrabajoDetalleDTO extends SimpleAuditDTO {

	@EmbeddedId
	private PedidoAreaTrabajoDetalleID id = new PedidoAreaTrabajoDetalleID();
	
	@Column(name = "CODIGOPEDARETRA")
	private Long codigoPedidoAreaTrabajo;
	
	@Column(name = "CODIGOUNIDADMANEJO")
	private Long codigoUnidadManejo;
	
	@ComparatorTypeField
	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo;
	
	@Column(name = "CODIGOPEDARETRADETPAD")
	private Long codigoPedidoAreaTrabajoDetallePadre;
	
	@Column(name = "CANTIDADPEDIDA")
	private Integer cantidadPedida;
	
	@Column(name = "CANTIDADRESERVADA")
	private Integer cantidadReservada;
	
	@Column(name = "CANTIDADDESPACHADA")
	private Integer cantidadDespachada;
	
	@Column(name = "CANTIDADVOLUMEN")
	private BigDecimal cantidadVolumen;
	
	@Column(name = "ARTICULOMARCADO")
	private String articuloMarcado;
	
	@Column(name = "ESTADO")
    @ComparatorTypeField
    private String estado;

    @RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO")
    private String idUsuarioRegistro;
    
    @RegisterDateField
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @LastModifierUserIdField
    @Column(name = "IDUSUARIOMODIFICACION")
    private String idUsuarioModificacion;
    
    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name = "CODIGOUNIDADMANEJO", referencedColumnName = "CODIGOUNIDADMANEJO", insertable = false, updatable = false)})
	private ArticuloUnidadManejoDTO articuloUnidadManejoDTO;

    @ManyToOne(fetch = LAZY)
  	@JoinColumns({
  		@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
  		@JoinColumn(name="CODIGOPEDARETRA", referencedColumnName="CODIGOPEDARETRA", insertable=false, updatable=false)})
  	private PedidoAreaTrabajoDTO pedido;
    
    @OneToMany(mappedBy = "pedidoDetallePadre")
   	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
   	private Collection<PedidoAreaTrabajoDetalleDTO> pedidoAreaTrabajoDetalleHijosCol;
    
    
    @ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOPEDARETRADETPAD", referencedColumnName = "CODIGOPEDARETRADET", insertable = false, updatable = false)})
	private PedidoAreaTrabajoDetalleDTO pedidoDetallePadre;
    
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
   	private UserDto usuarioModificacionDTO;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;
    
   
    
   @Transient
   private Double promedioRotacion;
   
   @Transient
   private Integer cantidadPorDespachar;
   
   @Transient
   private Integer cantidadDespacho;
   
   @Transient
   private Integer cantidadTransito;
   
   @Transient
   private Integer cantidadPorUsuario;
   
   
    
	/**
	 * @return the id
	 */
	public PedidoAreaTrabajoDetalleID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PedidoAreaTrabajoDetalleID id) {
		this.id = id;
	}

	/**
	 * @return the codigoPedidoAreaTrabajo
	 */
	public Long getCodigoPedidoAreaTrabajo() {
		return codigoPedidoAreaTrabajo;
	}

	/**
	 * @param codigoPedidoAreaTrabajo the codigoPedidoAreaTrabajo to set
	 */
	public void setCodigoPedidoAreaTrabajo(Long codigoPedidoAreaTrabajo) {
		this.codigoPedidoAreaTrabajo = codigoPedidoAreaTrabajo;
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
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	
	/**
	 * @return the codigoPedidoAreaTrabajoDetallePadre
	 */
	public Long getCodigoPedidoAreaTrabajoDetallePadre() {
		return codigoPedidoAreaTrabajoDetallePadre;
	}

	/**
	 * @param codigoPedidoAreaTrabajoDetallePadre the codigoPedidoAreaTrabajoDetallePadre to set
	 */
	public void setCodigoPedidoAreaTrabajoDetallePadre(Long codigoPedidoAreaTrabajoDetallePadre) {
		this.codigoPedidoAreaTrabajoDetallePadre = codigoPedidoAreaTrabajoDetallePadre;
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
	 * @return the cantidadReservada
	 */
	public Integer getCantidadReservada() {
		return cantidadReservada;
	}

	/**
	 * @param cantidadReservada the cantidadReservada to set
	 */
	public void setCantidadReservada(Integer cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}

	/**
	 * @return the cantidadDespachada
	 */
	public Integer getCantidadDespachada() {
		return cantidadDespachada;
	}

	/**
	 * @param cantidadDespachada the cantidadDespachada to set
	 */
	public void setCantidadDespachada(Integer cantidadDespachada) {
		this.cantidadDespachada = cantidadDespachada;
	}

	/**
	 * @return the cantidadVolumen
	 */
	public BigDecimal getCantidadVolumen() {
		return cantidadVolumen;
	}

	/**
	 * @param cantidadVolumen the cantidadVolumen to set
	 */
	public void setCantidadVolumen(BigDecimal cantidadVolumen) {
		this.cantidadVolumen = cantidadVolumen;
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
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public PedidoAreaTrabajoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoAreaTrabajoDTO pedido) {
		this.pedido = pedido;
	}

	public PedidoAreaTrabajoDetalleDTO getPedidoDetallePadre() {
		return pedidoDetallePadre;
	}

	public void setPedidoDetallePadre(PedidoAreaTrabajoDetalleDTO pedidoDetallePadre) {
		this.pedidoDetallePadre = pedidoDetallePadre;
	}

	public ArticuloUnidadManejoDTO getArticuloUnidadManejoDTO() {
		return articuloUnidadManejoDTO;
	}

	public void setArticuloUnidadManejoDTO(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) {
		this.articuloUnidadManejoDTO = articuloUnidadManejoDTO;
	}
	public String getDescripcionArticulo(){
		String descripcion = null;
		String descripcionAux = null;
		if (isLoaded(this.getArticuloUnidadManejoDTO()) && 
				isLoaded(this.getArticuloUnidadManejoDTO().getArticulo()) &&
				this.getArticuloUnidadManejoDTO().getArticulo().getDescripcionArticulo() != null){
			descripcionAux = this.getArticuloUnidadManejoDTO().getArticulo().getDescripcionArticulo();
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
	        	if(descripcion != null){
	        		descripcion = descripcion.concat(" ").concat(palabra);
	        	}else{
	        		descripcion = palabra;
	        	}
	        }
			if(descripcion.length() > 30){
				descripcion = descripcion.substring(0, 27);
				descripcion.concat("...");
				
			}
			if(this.getArticuloUnidadManejoDTO().getArticulo().getArticuloMedidaDTO() != null &&
					isLoaded(this.getArticuloUnidadManejoDTO().getArticulo().getArticuloMedidaDTO())){
				if(this.getArticuloUnidadManejoDTO().getArticulo().getArticuloMedidaDTO().getReferenciaMedida().length() > 10){
					descripcion=descripcion.concat(" ").concat(this.getArticuloUnidadManejoDTO().getArticulo().getArticuloMedidaDTO().getReferenciaMedida().substring(0,9));
				}else{
				
					descripcion=descripcion.concat(" ").concat(this.getArticuloUnidadManejoDTO().getArticulo().getArticuloMedidaDTO().getReferenciaMedida());
				}
			}
		}
		return descripcion;
	}

	public Double getPromedioRotacion() {
		return promedioRotacion;
	}

	public void setPromedioRotacion(Double promedioRotacion) {
		this.promedioRotacion = promedioRotacion;
	}

	public Integer getCantidadPorDespachar() {
		return cantidadPorDespachar;
	}

	public void setCantidadPorDespachar(Integer cantidadPorDespachar) {
		this.cantidadPorDespachar = cantidadPorDespachar;
	}

	/**
	 * @return the cantidadDespacho
	 */
	public Integer getCantidadDespacho() {
		return cantidadDespacho;
	}

	/**
	 * @param cantidadDespacho the cantidadDespacho to set
	 */
	public void setCantidadDespacho(Integer cantidadDespacho) {
		this.cantidadDespacho = cantidadDespacho;
	}

	public Integer getCantidadTransito() {
		return cantidadTransito;
	}

	public void setCantidadTransito(Integer cantidadTransito) {
		this.cantidadTransito = cantidadTransito;
	}

	public Integer getCantidadPorUsuario() {
		return cantidadPorUsuario;
	}

	public void setCantidadPorUsuario(Integer cantidadPorUsuario) {
		this.cantidadPorUsuario = cantidadPorUsuario;
	}

	/**
	 * @return the usuarioRegistroDTO
	 */
	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	/**
	 * @param usuarioRegistroDTO the usuarioRegistroDTO to set
	 */
	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}

	public Collection<PedidoAreaTrabajoDetalleDTO> getPedidoAreaTrabajoDetalleHijosCol() {
		return pedidoAreaTrabajoDetalleHijosCol;
	}

	public void setPedidoAreaTrabajoDetalleHijosCol(Collection<PedidoAreaTrabajoDetalleDTO> pedidoAreaTrabajoDetalleHijosCol) {
		this.pedidoAreaTrabajoDetalleHijosCol = pedidoAreaTrabajoDetalleHijosCol;
	}

	/**
	 * @return the articuloMarcado
	 */
	public String getArticuloMarcado() {
		return articuloMarcado;
	}

	/**
	 * @param articuloMarcado the articuloMarcado to set
	 */
	public void setArticuloMarcado(String articuloMarcado) {
		this.articuloMarcado = articuloMarcado;
	}

	/**
	 * @return the usuarioModificacionDTO
	 */
	public UserDto getUsuarioModificacionDTO() {
		return usuarioModificacionDTO;
	}

	/**
	 * @param usuarioModificacionDTO the usuarioModificacionDTO to set
	 */
	public void setUsuarioModificacionDTO(UserDto usuarioModificacionDTO) {
		this.usuarioModificacionDTO = usuarioModificacionDTO;
	}
	
}
