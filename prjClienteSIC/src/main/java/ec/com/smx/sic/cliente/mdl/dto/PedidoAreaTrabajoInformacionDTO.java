/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.PedidoAreaTrabajoInformacionID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SBPEATPEDARETRAINF")
public class PedidoAreaTrabajoInformacionDTO extends SimpleAuditDTO{

	@EmbeddedId
	private PedidoAreaTrabajoInformacionID id = new PedidoAreaTrabajoInformacionID();
	
	@Column(name = "CODIGOARETRAPED")
	private Integer codigoAreaTrabajoPedido;
	
	@Column(name = "CODIGOARETRACENDIS")
	private Integer codigoAreaTrabajoCentroDistribucion;
	
	@Column(name = "CODIGOARETRASUB")
	private Integer codigoAreaTrabajoSubbodega;
	
	@Column(name = "NUMEROPEDIDO")
	private String numeroPedido;
	
	@Column(name = "HORAMAXIMAPEDIDO")
	private Time horaMaximaPedido;
	
	@Column(name = "FECHAPEDIDO")
	private Date fechaPedido;
	
	@Column(name = "FECHADESPACHO")
	private Date fechaDespacho;
	
	@Column(name = "FECHARECEPCION")
	private Date fechaRecepcion;
	
	@Column(name = "CODIGOTIPOPEDIDOCATVAL")
	@ComparatorTypeField
	private String codigoTipoPedidoCatalogoValor;
	
	@Column(name = "CODIGOTIPOPEDIDOCATTIP")
	private Integer codigoTipoPedidoCatalogoTipo;
	
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
  	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARETRAPED", referencedColumnName="CODIGOAREATRABAJO", insertable=false, updatable=false)})
  	private AreaTrabajoDTO areaTrabajoPedido;
   
    @ManyToOne(fetch = LAZY)
  	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARETRACENDIS", referencedColumnName="CODIGOAREATRABAJO", insertable=false, updatable=false)})
  	private AreaTrabajoDTO areaTrabajoCentroDistribucion;
   
    @ManyToOne(fetch = LAZY)
  	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARETRASUB", referencedColumnName="CODIGOAREATRABAJO", insertable=false, updatable=false)})
  	private AreaTrabajoDTO areaTrabajoSubbodega;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;
   
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
    	@JoinColumn(name = "CODIGOTIPOPEDIDOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOTIPOPEDIDOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO tipoPedido;
    
    @ManyToOne(fetch = LAZY)
  	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOPEDARETRA", referencedColumnName="CODIGOPEDARETRA", insertable=false, updatable=false)})
  	private PedidoAreaTrabajoDTO pedido;
    
	/**
	 * @return the id
	 */
	public PedidoAreaTrabajoInformacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PedidoAreaTrabajoInformacionID id) {
		this.id = id;
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
	 * @return the codigoAreaTrabajoCentroDistribucion
	 */
	public Integer getCodigoAreaTrabajoCentroDistribucion() {
		return codigoAreaTrabajoCentroDistribucion;
	}

	/**
	 * @param codigoAreaTrabajoCentroDistribucion the codigoAreaTrabajoCentroDistribucion to set
	 */
	public void setCodigoAreaTrabajoCentroDistribucion(Integer codigoAreaTrabajoCentroDistribucion) {
		this.codigoAreaTrabajoCentroDistribucion = codigoAreaTrabajoCentroDistribucion;
	}

	/**
	 * @return the codigoAreaTrabajoSubbodega
	 */
	public Integer getCodigoAreaTrabajoSubbodega() {
		return codigoAreaTrabajoSubbodega;
	}

	/**
	 * @param codigoAreaTrabajoSubbodega the codigoAreaTrabajoSubbodega to set
	 */
	public void setCodigoAreaTrabajoSubbodega(Integer codigoAreaTrabajoSubbodega) {
		this.codigoAreaTrabajoSubbodega = codigoAreaTrabajoSubbodega;
	}

	/**
	 * @return the numeroPedido
	 */
	public String getNumeroPedido() {
		return numeroPedido;
	}

	/**
	 * @param numeroPedido the numeroPedido to set
	 */
	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	/**
	 * @return the horaMaximaPedido
	 */
	public Time getHoraMaximaPedido() {
		return horaMaximaPedido;
	}

	/**
	 * @param horaMaximaPedido the horaMaximaPedido to set
	 */
	public void setHoraMaximaPedido(Time horaMaximaPedido) {
		this.horaMaximaPedido = horaMaximaPedido;
	}

	/**
	 * @return the fechaPedido
	 */
	public Date getFechaPedido() {
		return fechaPedido;
	}

	/**
	 * @param fechaPedido the fechaPedido to set
	 */
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	/**
	 * @return the fechaDespacho
	 */
	public Date getFechaDespacho() {
		return fechaDespacho;
	}

	/**
	 * @param fechaDespacho the fechaDespacho to set
	 */
	public void setFechaDespacho(Date fechaDespacho) {
		this.fechaDespacho = fechaDespacho;
	}

	/**
	 * @return the fechaRecepcion
	 */
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	/**
	 * @param fechaRecepcion the fechaRecepcion to set
	 */
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	/**
	 * @return the codigoTipoPedidoCatalogoValor
	 */
	public String getCodigoTipoPedidoCatalogoValor() {
		return codigoTipoPedidoCatalogoValor;
	}

	/**
	 * @param codigoTipoPedidoCatalogoValor the codigoTipoPedidoCatalogoValor to set
	 */
	public void setCodigoTipoPedidoCatalogoValor(String codigoTipoPedidoCatalogoValor) {
		this.codigoTipoPedidoCatalogoValor = codigoTipoPedidoCatalogoValor;
	}

	/**
	 * @return the codigoTipoPedidoCatalogoTipo
	 */
	public Integer getCodigoTipoPedidoCatalogoTipo() {
		return codigoTipoPedidoCatalogoTipo;
	}

	/**
	 * @param codigoTipoPedidoCatalogoTipo the codigoTipoPedidoCatalogoTipo to set
	 */
	public void setCodigoTipoPedidoCatalogoTipo(Integer codigoTipoPedidoCatalogoTipo) {
		this.codigoTipoPedidoCatalogoTipo = codigoTipoPedidoCatalogoTipo;
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

	public AreaTrabajoDTO getAreaTrabajoPedido() {
		return areaTrabajoPedido;
	}

	public void setAreaTrabajoPedido(AreaTrabajoDTO areaTrabajoPedido) {
		this.areaTrabajoPedido = areaTrabajoPedido;
	}

	public AreaTrabajoDTO getAreaTrabajoCentroDistribucion() {
		return areaTrabajoCentroDistribucion;
	}

	public void setAreaTrabajoCentroDistribucion(AreaTrabajoDTO areaTrabajoCentroDistribucion) {
		this.areaTrabajoCentroDistribucion = areaTrabajoCentroDistribucion;
	}

	public AreaTrabajoDTO getAreaTrabajoSubbodega() {
		return areaTrabajoSubbodega;
	}

	public void setAreaTrabajoSubbodega(AreaTrabajoDTO areaTrabajoSubbodega) {
		this.areaTrabajoSubbodega = areaTrabajoSubbodega;
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

	public CatalogoValorDTO getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(CatalogoValorDTO tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public PedidoAreaTrabajoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoAreaTrabajoDTO pedido) {
		this.pedido = pedido;
	}
	
}
