/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.pedidoAsistido.SICPedidoAsistidoConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.id.PedidoAreaTrabajoID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SBPEATPEDARETRA")
public class PedidoAreaTrabajoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private PedidoAreaTrabajoID id = new PedidoAreaTrabajoID();
	
	@Column(name = "CODIGOPEDARETRAPAD")
	private Long codigoPedidoAreaTrabajoPadre;
	
	@Column(name = "CANTIDADTOTALPEDIDA")
	private Integer cantidadTotalPedida;
	
	@Column(name = "CANTIDADTOTALRESERVADA")
	private Integer cantidadTotalReservada;
	
	@Column(name = "CANTIDADTOTALDESPACHADA")
	private Integer cantidadTotalDespachada;
	
	@Column(name = "CANTIDADTOTALITEMS")
	private Integer cantidadTotalItems;
	
	@Column(name = "CANTIDADTOTALVOLUMEN")
	private BigDecimal cantidadTotalVolumen;
	
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

    @OneToMany(mappedBy = "pedido")
    @CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<PedidoAreaTrabajoAutorizacionDTO> pedidoAreaTrabajoAutorizacionCol ;
    
    @OneToMany(mappedBy = "pedido")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<PedidoAreaTrabajoClasificacionDTO> pedidoAreaTrabajoClasificacionCol;
    
	@OneToMany(mappedBy = "pedido")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<PedidoAreaTrabajoDetalleDTO> pedidoAreaTrabajoDetalleCol;
	
	@OneToMany(mappedBy = "pedido")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<PedidoAreaTrabajoEstadoDTO> pedidoAreaTrabajoEstadoCol;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOPEDARETRA", referencedColumnName="CODIGOPEDARETRA", insertable=false, updatable=false)})
	private PedidoAreaTrabajoInformacionDTO pedidoInformacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOPEDARETRAPAD", referencedColumnName = "CODIGOPEDARETRA", insertable = false, updatable = false)})
	private PedidoAreaTrabajoDTO pedidoPadre;
	
	@OneToMany(mappedBy = "pedidoPadre")
	private Collection<PedidoAreaTrabajoDTO> pedidosHijos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;
	
	@Transient
	private PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstado;
	
	@Transient
	private boolean pedidoSeleccionado;

	/**
	 * @return the id
	 */
	public PedidoAreaTrabajoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PedidoAreaTrabajoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoPedidoAreaTrabajoPadre
	 */
	public Long getCodigoPedidoAreaTrabajoPadre() {
		return codigoPedidoAreaTrabajoPadre;
	}

	/**
	 * @param codigoPedidoAreaTrabajoPadre the codigoPedidoAreaTrabajoPadre to set
	 */
	public void setCodigoPedidoAreaTrabajoPadre(Long codigoPedidoAreaTrabajoPadre) {
		this.codigoPedidoAreaTrabajoPadre = codigoPedidoAreaTrabajoPadre;
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
	 * @return the cantidadTotalReservada
	 */
	public Integer getCantidadTotalReservada() {
		return cantidadTotalReservada;
	}

	/**
	 * @param cantidadTotalReservada the cantidadTotalReservada to set
	 */
	public void setCantidadTotalReservada(Integer cantidadTotalReservada) {
		this.cantidadTotalReservada = cantidadTotalReservada;
	}

	/**
	 * @return the cantidadTotalDespachada
	 */
	public Integer getCantidadTotalDespachada() {
		return cantidadTotalDespachada;
	}

	/**
	 * @param cantidadTotalDespachada the cantidadTotalDespachada to set
	 */
	public void setCantidadTotalDespachada(Integer cantidadTotalDespachada) {
		this.cantidadTotalDespachada = cantidadTotalDespachada;
	}

	/**
	 * @return the cantidadTotalItems
	 */
	public Integer getCantidadTotalItems() {
		return cantidadTotalItems;
	}

	/**
	 * @param cantidadTotalItems the cantidadTotalItems to set
	 */
	public void setCantidadTotalItems(Integer cantidadTotalItems) {
		this.cantidadTotalItems = cantidadTotalItems;
	}

	/**
	 * @return the cantidadTotalVolumen
	 */
	public BigDecimal getCantidadTotalVolumen() {
		return cantidadTotalVolumen;
	}

	/**
	 * @param cantidadTotalVolumen the cantidadTotalVolumen to set
	 */
	public void setCantidadTotalVolumen(BigDecimal cantidadTotalVolumen) {
		this.cantidadTotalVolumen = cantidadTotalVolumen;
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

	public PedidoAreaTrabajoInformacionDTO getPedidoInformacion() {
		return pedidoInformacion;
	}

	public void setPedidoInformacion(PedidoAreaTrabajoInformacionDTO pedidoInformacion) {
		this.pedidoInformacion = pedidoInformacion;
	}

	public Collection<PedidoAreaTrabajoDetalleDTO> getPedidoAreaTrabajoDetalleCol() {
		return pedidoAreaTrabajoDetalleCol;
	}

	public void setPedidoAreaTrabajoDetalleCol(Collection<PedidoAreaTrabajoDetalleDTO> pedidoAreaTrabajoDetalleCol) {
		this.pedidoAreaTrabajoDetalleCol = pedidoAreaTrabajoDetalleCol;
	}

	public PedidoAreaTrabajoDTO getPedidoPadre() {
		return pedidoPadre;
	}

	public void setPedidoPadre(PedidoAreaTrabajoDTO pedidoPadre) {
		this.pedidoPadre = pedidoPadre;
	}

	public Collection<PedidoAreaTrabajoEstadoDTO> getPedidoAreaTrabajoEstadoCol() {
		return pedidoAreaTrabajoEstadoCol;
	}

	public void setPedidoAreaTrabajoEstadoCol(Collection<PedidoAreaTrabajoEstadoDTO> pedidoAreaTrabajoEstadoCol) {
		this.pedidoAreaTrabajoEstadoCol = pedidoAreaTrabajoEstadoCol;
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

	/**
	 * @return the pedidosHijos
	 */
	public Collection<PedidoAreaTrabajoDTO> getPedidosHijos() {
		return pedidosHijos;
	}

	/**
	 * @param pedidosHijos the pedidosHijos to set
	 */
	public void setPedidosHijos(Collection<PedidoAreaTrabajoDTO> pedidosHijos) {
		this.pedidosHijos = pedidosHijos;
	}

	/**
	 * @return the pedidoSeleccionado
	 */
	public boolean isPedidoSeleccionado() {
		return pedidoSeleccionado;
	}

	/**
	 * @param pedidoSeleccionado the pedidoSeleccionado to set
	 */
	public void setPedidoSeleccionado(boolean pedidoSeleccionado) {
		this.pedidoSeleccionado = pedidoSeleccionado;
	}
	
	
	
	public String getColor() throws ParseException{

		Date fechaActual = null;
		String numeroPedido="";
		String auxi= "";
		try {

			fechaActual = new Date(System.currentTimeMillis());

			if(pedidoInformacion.getNumeroPedido()!=null){
				numeroPedido=this.pedidoInformacion.getNumeroPedido();
				auxi=numeroPedido.substring(0, 2);
			}

			long tiempoFinal=0;
			long tiempoInicial=fechaActual.getTime(); 
			if(getPedidoInformacion().getHoraMaximaPedido()==null||pedidoInformacion.getFechaPedido()==null){
				tiempoFinal=0;
			}
			else{

				String fecha[] =this.pedidoInformacion.getFechaPedido().toString().split(" ");
				String fecha2=fecha[0];
				if(fecha2.length()==10){
					String fechaFinal = fecha2+" "+getPedidoInformacion().getHoraMaximaPedido();
					SimpleDateFormat formatoHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date horaActualDate = formatoHora.parse(fechaFinal);

					tiempoFinal=horaActualDate.getTime();
				}else{
					tiempoFinal=0;
				}

			}

			long resta= tiempoFinal- tiempoInicial  ;

			resta=resta /(60*1000);

			if(auxi.equalsIgnoreCase("SP")){
				return "celeste";
			}

			if(this.getPedidoAreaTrabajoEstado().getCodigoEstadoCatalogoValor()!= null &&
					(this.getPedidoAreaTrabajoEstado().getCodigoEstadoCatalogoValor().equalsIgnoreCase(SICPedidoAsistidoConstantes.CODIGO_VALOR_ESTADO_PEDIDO_INGRESADO)
							||this.getPedidoAreaTrabajoEstado().getCodigoEstadoCatalogoValor().equalsIgnoreCase(SICPedidoAsistidoConstantes.CODIGO_VALOR_ESTADO_PEDIDO_CONFIRMADO_EL_INGRESO)
							||this.getPedidoAreaTrabajoEstado().getCodigoEstadoCatalogoValor().equalsIgnoreCase(SICPedidoAsistidoConstantes.CODIGO_VALOR_ESTADO_PEDIDO_CORREGIDO))){


				if(resta>=6&&resta<16 ){
					return "amarrillo";
				}

				else if(resta>=16&&resta<=30){
					return "azul";
				}

				else if((resta>=0&&resta<=5)||(resta<0)){
					return "rojo";
				}
				else if(resta>30||resta<0){
					return	"verde";
				}

			}else if(this.getPedidoAreaTrabajoEstado().getCodigoEstadoCatalogoValor()== null ){

				SimpleDateFormat formatoHora = new SimpleDateFormat("yyyy-MM-dd");
				String formato= formatoHora.format(this.pedidoInformacion.getFechaDespacho());
				String fechaFinal = formato+" "+getPedidoInformacion().getHoraMaximaPedido();
				SimpleDateFormat formatoHora2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date horaActualDate = formatoHora2.parse(fechaFinal);

				tiempoFinal=horaActualDate.getTime();

				long resta2= tiempoFinal- tiempoInicial  ;

				resta2=resta2 /(60*1000);

				if(resta2>=6&&resta2<16 ){
					return "amarrillo";
				}

				else if(resta2>=16&&resta2<=30){
					return "azul";
				}

				else if((resta2>=0&&resta2<=0)){
					return "rojo";
				}else {
					return "plomo";
				}

			}else{
				return	"verde";
			}

			return null;

		}
		catch (Exception e) {
			throw new SICException(e);
		}
	}


	/**
	 * @return the pedidoAreaTrabajoEstado
	 */
	public PedidoAreaTrabajoEstadoDTO getPedidoAreaTrabajoEstado() {
		if(this.pedidoAreaTrabajoEstado == null && 
				SearchDTO.isLoaded(this.pedidoAreaTrabajoEstadoCol) && 
				CollectionUtils.isNotEmpty(this.pedidoAreaTrabajoEstadoCol)){
			this.pedidoAreaTrabajoEstado = (PedidoAreaTrabajoEstadoDTO)CollectionUtils.get(this.pedidoAreaTrabajoEstadoCol, 0);
		}	
		return pedidoAreaTrabajoEstado;
	}

	/**
	 * @param pedidoAreaTrabajoEstado the pedidoAreaTrabajoEstado to set
	 */
	public void setPedidoAreaTrabajoEstado(PedidoAreaTrabajoEstadoDTO pedidoAreaTrabajoEstado) {
		this.pedidoAreaTrabajoEstado = pedidoAreaTrabajoEstado;
	}

	/**
	 * @return the pedidoAreaTrabajoClasificacionCol
	 */
	public Collection<PedidoAreaTrabajoClasificacionDTO> getPedidoAreaTrabajoClasificacionCol() {
		return pedidoAreaTrabajoClasificacionCol;
	}

	/**
	 * @param pedidoAreaTrabajoClasificacionCol the pedidoAreaTrabajoClasificacionCol to set
	 */
	public void setPedidoAreaTrabajoClasificacionCol(Collection<PedidoAreaTrabajoClasificacionDTO> pedidoAreaTrabajoClasificacionCol) {
		this.pedidoAreaTrabajoClasificacionCol = pedidoAreaTrabajoClasificacionCol;
	}

	public Collection<PedidoAreaTrabajoAutorizacionDTO> getPedidoAreaTrabajoAutorizacionCol() {
		return pedidoAreaTrabajoAutorizacionCol;
	}

	public void setPedidoAreaTrabajoAutorizacionCol(Collection<PedidoAreaTrabajoAutorizacionDTO> pedidoAreaTrabajoAutorizacionCol) {
		this.pedidoAreaTrabajoAutorizacionCol = pedidoAreaTrabajoAutorizacionCol;
	}

}
