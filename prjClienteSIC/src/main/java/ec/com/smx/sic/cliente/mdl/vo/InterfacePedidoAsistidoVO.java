/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Date;

import org.quartz.Scheduler;


/**
 * @author atorrealba
 *
 */
public class InterfacePedidoAsistidoVO {

	private Integer codigoCompania;
	private Integer codigoCentroDistribucion;
	private Integer codigoBodega;
	private Integer codigoSubbodega;
	private String tipoPedido;
	private Date fechaPedido;
	private Date fechaDespacho;
	private Integer codigoAreaTrabajoPedido;
	private Boolean subbodegaGeneraOrdenCompra;
	private Boolean interfaceGeneraOrdenCompra;
	private String userId;
	private String pasillo;
	private Character lado;

	private Scheduler scheduler;
	
	
	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	/**
	 * @return the codigoCentroDistribucion
	 */
	public Integer getCodigoCentroDistribucion() {
		return codigoCentroDistribucion;
	}
	/**
	 * @param codigoCentroDistribucion the codigoCentroDistribucion to set
	 */
	public void setCodigoCentroDistribucion(Integer codigoCentroDistribucion) {
		this.codigoCentroDistribucion = codigoCentroDistribucion;
	}
	/**
	 * @return the codigoSubbodega
	 */
	public Integer getCodigoSubbodega() {
		return codigoSubbodega;
	}
	/**
	 * @param codigoSubbodega the codigoSubbodega to set
	 */
	public void setCodigoSubbodega(Integer codigoSubbodega) {
		this.codigoSubbodega = codigoSubbodega;
	}
	/**
	 * @return the tipoPedido
	 */
	public String getTipoPedido() {
		return tipoPedido;
	}
	/**
	 * @param tipoPedido the tipoPedido to set
	 */
	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the subbodegaGeneraOrdenCompra
	 */
	public Boolean getSubbodegaGeneraOrdenCompra() {
		return subbodegaGeneraOrdenCompra;
	}
	/**
	 * @param subbodegaGeneraOrdenCompra the subbodegaGeneraOrdenCompra to set
	 */
	public void setSubbodegaGeneraOrdenCompra(Boolean subbodegaGeneraOrdenCompra) {
		this.subbodegaGeneraOrdenCompra = subbodegaGeneraOrdenCompra;
	}
	/**
	 * @return the interfaceGeneraOrdenCompra
	 */
	public Boolean getInterfaceGeneraOrdenCompra() {
		return interfaceGeneraOrdenCompra;
	}
	/**
	 * @param interfaceGeneraOrdenCompra the interfaceGeneraOrdenCompra to set
	 */
	public void setInterfaceGeneraOrdenCompra(Boolean interfaceGeneraOrdenCompra) {
		this.interfaceGeneraOrdenCompra = interfaceGeneraOrdenCompra;
	}
	/**
	 * @return the pasillo
	 */
	public String getPasillo() {
		return pasillo;
	}
	/**
	 * @param pasillo the pasillo to set
	 */
	public void setPasillo(String pasillo) {
		this.pasillo = pasillo;
	}
	/**
	 * @return the lado
	 */
	public Character getLado() {
		return lado;
	}
	/**
	 * @param lado the lado to set
	 */
	public void setLado(Character lado) {
		this.lado = lado;
	}
	/**
	 * @return the codigoBodega
	 */
	public Integer getCodigoBodega() {
		return codigoBodega;
	}
	/**
	 * @param codigoBodega the codigoBodega to set
	 */
	public void setCodigoBodega(Integer codigoBodega) {
		this.codigoBodega = codigoBodega;
	}
	/**
	 * @return the scheduler
	 */
	public Scheduler getScheduler() {
		return scheduler;
	}
	/**
	 * @param scheduler the scheduler to set
	 */
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
}
