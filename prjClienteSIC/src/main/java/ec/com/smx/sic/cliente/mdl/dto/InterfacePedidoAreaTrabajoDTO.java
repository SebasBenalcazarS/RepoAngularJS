/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
import ec.com.smx.sic.cliente.mdl.dto.id.InterfacePedidoAreaTrabajoID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SBPEATINTPEDARETRA")
public class InterfacePedidoAreaTrabajoDTO extends SimpleAuditDTO {
	@EmbeddedId
	private InterfacePedidoAreaTrabajoID id = new InterfacePedidoAreaTrabajoID();
	

	@Column(name = "CODIGOARETRACENDIS")
	private Integer codigoAreaTrabajoCentroDistribucion;
	
	@Column(name = "CODIGOARETRASUB")
	private Integer codigoAreaTrabajoSubbodega;
	
	@Column(name = "CODIGOARETRAPED")
	private Integer codigoAreaTrabajoPedido;
	
	@Column(name = "FECHAPEDIDO")
	private Date fechaPedido;
	
	@Column(name = "FECHADESPACHO")
	private Date fechaDespacho;
	
	@Column(name = "CODIGOTIPOPEDIDOCATVAL")
	@ComparatorTypeField
	private String codigoTipoPedidoCatalogoValor;
	
	@Column(name = "CODIGOTIPOPEDIDOCATTIP")
	private Integer codigoTipoPedidoCatalogoTipo;

	@Column(name = "SUBBODEGAGENERAORDENCOMPRA")
	private Boolean subbogedaGeneraOrdenCompra;
	
	@Column(name = "INTERFACEGENERAORDENCOMPRA")
	private Boolean interfaceGeneraOrdenCompra;
	
	@Column(name = "PROCESADO")
	@ComparatorTypeField
	private Character procesado;

	@Column(name = "PASILLO")
	private Integer pasillo;
	
	@Column(name = "LADO")
	@ComparatorTypeField
	private Character lado;
	
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

    @ManyToOne
    @JoinColumns({
    	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOARETRACENDIS", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)
    })
    private AreaTrabajoDTO areaTrabajoCentroDistribucion;
    
    @ManyToOne
    @JoinColumns({
    	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOARETRASUB", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)
    })
    private AreaTrabajoDTO areaTrabajoSubbodega;
    
	/**
	 * @return the id
	 */
	public InterfacePedidoAreaTrabajoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(InterfacePedidoAreaTrabajoID id) {
		this.id = id;
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
	 * @return the pasillo
	 */
	public Integer getPasillo() {
		return pasillo;
	}

	/**
	 * @param pasillo the pasillo to set
	 */
	public void setPasillo(Integer pasillo) {
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

	/**
	 * @return the subbogedaGeneraOrdenCompra
	 */
	public Boolean getSubbogedaGeneraOrdenCompra() {
		return subbogedaGeneraOrdenCompra;
	}

	/**
	 * @param subbogedaGeneraOrdenCompra the subbogedaGeneraOrdenCompra to set
	 */
	public void setSubbogedaGeneraOrdenCompra(Boolean subbogedaGeneraOrdenCompra) {
		this.subbogedaGeneraOrdenCompra = subbogedaGeneraOrdenCompra;
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
	 * @return the procesado
	 */
	public Character getProcesado() {
		return procesado;
	}

	/**
	 * @param procesado the procesado to set
	 */
	public void setProcesado(Character procesado) {
		this.procesado = procesado;
	}

	/**
	 * @return the areaTrabajoCentroDistribucion
	 */
	public AreaTrabajoDTO getAreaTrabajoCentroDistribucion() {
		return areaTrabajoCentroDistribucion;
	}

	/**
	 * @param areaTrabajoCentroDistribucion the areaTrabajoCentroDistribucion to set
	 */
	public void setAreaTrabajoCentroDistribucion(AreaTrabajoDTO areaTrabajoCentroDistribucion) {
		this.areaTrabajoCentroDistribucion = areaTrabajoCentroDistribucion;
	}

	/**
	 * @return the areaTrabajoSubbodega
	 */
	public AreaTrabajoDTO getAreaTrabajoSubbodega() {
		return areaTrabajoSubbodega;
	}

	/**
	 * @param areaTrabajoSubbodega the areaTrabajoSubbodega to set
	 */
	public void setAreaTrabajoSubbodega(AreaTrabajoDTO areaTrabajoSubbodega) {
		this.areaTrabajoSubbodega = areaTrabajoSubbodega;
	}
	
}
