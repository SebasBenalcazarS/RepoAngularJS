
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.util.Collection;

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
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.nopersistente.FacturaDigitalEST;


/**
 * Almacena todas las tareas de la estructura logistica
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCFDITFACEST")
public class FacturaEstadoDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.FacturaEstadoID id = new ec.com.smx.sic.cliente.mdl.dto.id.FacturaEstadoID();

	@Column(name = "CODIGOFACTURA")
	private Long codigoFactura ;

	@Column(name = "ESTADO")
	@ComparatorTypeField
	private String estado ;
	
	//Especifica el valor de la tarifa doce
	@Column(name = "VALOR")
    private BigDecimal valor;
	
	@Column(name = "VALORTOTALREFERENCIA")
	private BigDecimal valorTotalReferencia;
	
	@Column(name = "VALORPROVEEDOR")
    private BigDecimal valorProveedor;
	
	@Column(name = "VALORTOTAL")
    private BigDecimal valorTotal;
	
	@Column(name = "VALORTOTALPROVEEDOR")
    private BigDecimal valorTotalProveedor;
	
	@Column(name = "VALORTOTALBRUTO")
	private BigDecimal valorTotalBruto;
	
	@Deprecated
	@Column(name = "VALORTOTALBRUTOPROVEEDOR")
	private BigDecimal valorTotalBrutoProveedor;
	
	@Deprecated
	@Column(name = "VALORTARIFACERO")
	private BigDecimal valorTarifaCero;
	
	@Deprecated
	@Column(name = "VALORTARIFADOCE")
	private BigDecimal valorTarifaDoce;
	
	@Column(name = "VALORTOTALIVE")
	private BigDecimal valorTotalIve;
	
	@Column(name = "VALORTARIFACEROPROVEEDOR")
	private BigDecimal valorTarifaCeroProveedor;
	
	@Column(name = "CANTIDADTOTALPARCIAL")
	private Integer cantidadTotalParcial;
	
	@Column(name = "PUNTOEMISOR")
	private String puntoEmisor;
	
	@Column(name = "VALORDESCUENTO")
    private BigDecimal valorDescuento;
	
	@OneToMany(mappedBy = "facturaEstado")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<FacturaEstadoImpuestoDTO> facturaImpuestoCol;
	
	/**
	 * Nro de la factura para recepcion
	 */
	@Column
	@ComparatorTypeField
	
	private String numeroFacturaRecepcion;
	
	/**
	 * Nro de la factura original para hacer la compracion cuando se edite un numero de factura
	 */
	@Column
	@ComparatorTypeField
	private String numeroFactura;
	
	/**
	 * Nro de la nota de ingreso de la mercaderia
	 */
	@Column
	@ComparatorTypeField
	private String notaIngresoMercaderia;
	
	@Column
	@ComparatorTypeField
	private String codigoAgrupadorFactura;	
	
	@Column
	@ComparatorTypeField
	private String idUsuarioRecepcion;

	/**
	 * Campo para validar la facturas vs las facturas digitales
	 */
	@Column
	@ComparatorTypeField
	private String validacion;
	
	/**
	 * Columna para determinar el numero de ordenes de compra en la recepcion
	 */
	@Column(name = "TOTALORDENESCOMPRA")
	private Integer totalOrdenesCompra;
	
	/**
	 * Columna para determinar el valor total
	 * de la diferencia en la recepcion en el SIC
	 */
	@Column(name = "VALORTOTALDIFERENCIARECEPCION")
	private BigDecimal valorTotalDiferenciaRecepcion;
	
	
	/**
	 * Columna para determinar el estado de migracion de la RECEPCION del SIC al MAX:
	 * <p>0: Migracion FINALIZADA con EXITO</p>
	 * <p>1: Migracion PENDIENTE</p>
	 */
	@Column(name = "CODIGOMIGRACION")
    private Integer codigoMigracion;
	
	/**
	 * Columna que almacena el valor total de las ordenes de compra correspondientes a
	 * una nota de ingreso
	 * 
	 * <p>NOTA: Esta columna es temporal hasta que la recepcion se la realice en MAX</p>
	 */
	@Deprecated
	@Column(name = "VALORTOTALCALCULADO")
	private BigDecimal valorTotalCalculado;
	
	/**
	 * Campo no persitente
	 * Colecci&oacute;n para manejar detalles de factura iguales como unico registro. 
	 */
	@Transient
	private Collection<FacturaDigitalEST> facturaDigitalESTs; 
	
	@Transient
	private String directorioError;
	
	@ComparatorTypeField
	private String aplicarRangoTolerancia;
	
	/**
	 * Se almacena el valior de la diferencia entre la nota de ingreso vs las facturas del proveedor
	 */
	private BigDecimal valorDiferenciaAplicarAjuste;
	
	@ComparatorTypeField
	private String observacion;
	
	/**
	 * Almacena 1 / 0 trabajo pendiente realizado en el documento
	 */
	@ComparatorTypeField
	private String porRealizar;
	
	/**
	 * @return the valor
	 */
	
	public BigDecimal getValor() {
		return valor;
	}
	
	@Transient
	private BigDecimal totalImpuestoIva;

	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/**
	 * @return the puntoEmisor
	 */
	public String getPuntoEmisor() {
		return puntoEmisor;
	}

	/**
	 * @param puntoEmisor the puntoEmisor to set
	 */
	public void setPuntoEmisor(String puntoEmisor) {
		this.puntoEmisor = puntoEmisor;
	}
	
	/**
	 * Fecha de la factura
	 * 
	 */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaFactura;
	
	/**
	 * Fecha de la factura
	 * 
	 */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRecibo;

	/**
	 * Fecha inicio de la entrega
	 * 
	 */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaInicio;
	
	/**
	 * Fecha inicio de la entrega
	 * 
	 */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaFin;
	
	
	private Integer codigoCambioInformacion;
	
	/**
	 * Se especifica si se cambio valores
	 */
	@ComparatorTypeField
	private String valorCambioInformacion;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;
	
	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	@Column(name="FECHAACTUALIZACION")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaModificacion;
	
	/**
	 * 
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOFACTURA", insertable = false, updatable = false, referencedColumnName = "CODIGOFACTURA") })
	private FacturaDTO facturaDTO;
	
	/**
	 * 
	 * 
	 */
	@OneToMany(mappedBy = "facturaEstadoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<DetalleFacturaEstadoDTO> detalleFacturaEstadoDTOCol;
	
	
	@OneToMany(mappedBy = "facturaEstadoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<AjusteFacturaDTO> ajusteFacturaCol;
	
	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioRegistro;
	
	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioModificacion;
	
	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIORECEPCION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioRecepcion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "VALORCAMBIOINFORMACION", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCAMBIOINFORMACION", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO") })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO cambioInformacion;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.FacturaEstadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.FacturaEstadoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoFactura
	 */
	public Long getCodigoFactura() {
		return codigoFactura;
	}

	/**
	 * @param codigoFactura the codigoFactura to set
	 */
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
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
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the idUsuarioModificacion
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the fechaInicio
	 */
	public java.util.Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(java.util.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public java.util.Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(java.util.Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the facturaDTO
	 */
	public FacturaDTO getFacturaDTO() {
		return facturaDTO;
	}

	/**
	 * @param facturaDTO the facturaDTO to set
	 */
	public void setFacturaDTO(FacturaDTO facturaDTO) {
		this.facturaDTO = facturaDTO;
	}

	/**
	 * @return the detalleFacturaEstadoDTOCol
	 */
	public Collection<DetalleFacturaEstadoDTO> getDetalleFacturaEstadoDTOCol() {
		return detalleFacturaEstadoDTOCol;
	}

	/**
	 * @param detalleFacturaEstadoDTOCol the detalleFacturaEstadoDTOCol to set
	 */
	public void setDetalleFacturaEstadoDTOCol(Collection<DetalleFacturaEstadoDTO> detalleFacturaEstadoDTOCol) {
		this.detalleFacturaEstadoDTOCol = detalleFacturaEstadoDTOCol;
	}

	/**
	 * @return the valorTotalProveedor
	 */
	public BigDecimal getValorTotalProveedor() {
		return valorTotalProveedor;
	}

	/**
	 * @param valorTotalProveedor the valorTotalProveedor to set
	 */
	public void setValorTotalProveedor(BigDecimal valorTotalProveedor) {
		this.valorTotalProveedor = valorTotalProveedor;
	}

	/**
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
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
	 * @return the valorTotalBruto
	 */
	public BigDecimal getValorTotalBruto() {
		return valorTotalBruto;
	}

	/**
	 * @param valorTotalBruto the valorTotalBruto to set
	 */
	public void setValorTotalBruto(BigDecimal valorTotalBruto) {
		this.valorTotalBruto = valorTotalBruto;
	}

	/**
	 * @return the valorTarifaCero
	 */
	public BigDecimal getValorTarifaCero() {
		return valorTarifaCero;
	}

	/**
	 * @param valorTarifaCero the valorTarifaCero to set
	 */
	public void setValorTarifaCero(BigDecimal valorTarifaCero) {
		this.valorTarifaCero = valorTarifaCero;
	}

	/**
	 * @return the facturaImpuestoCol
	 */
	public Collection<FacturaEstadoImpuestoDTO> getFacturaImpuestoCol() {
		return facturaImpuestoCol;
	}

	/**
	 * @param facturaImpuestoCol the facturaImpuestoCol to set
	 */
	public void setFacturaImpuestoCol(Collection<FacturaEstadoImpuestoDTO> facturaImpuestoCol) {
		this.facturaImpuestoCol = facturaImpuestoCol;
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
	 * @return the validacion
	 */
	public String getValidacion() {
		return validacion;
	}

	/**
	 * @param validacion the validacion to set
	 */
	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	/**
	 * @return the valorDescuento
	 */
	public BigDecimal getValorDescuento() {
		return valorDescuento;
	}

	/**
	 * @param valorDescuento the valorDescuento to set
	 */
	public void setValorDescuento(BigDecimal valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	/**
	 * @return the fechaFactura
	 */
	public java.util.Date getFechaFactura() {
		return fechaFactura;
	}

	/**
	 * @param fechaFactura the fechaFactura to set
	 */
	public void setFechaFactura(java.util.Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	/**
	 * @return the fechaRecibo
	 */
	public java.util.Date getFechaRecibo() {
		return fechaRecibo;
	}

	/**
	 * @param fechaRecibo the fechaRecibo to set
	 */
	public void setFechaRecibo(java.util.Date fechaRecibo) {
		this.fechaRecibo = fechaRecibo;
	}

	/**
	 * @return the notaIngresoMercaderia
	 */
	public String getNotaIngresoMercaderia() {
		return notaIngresoMercaderia;
	}

	/**
	 * @param notaIngresoMercaderia the notaIngresoMercaderia to set
	 */
	public void setNotaIngresoMercaderia(String notaIngresoMercaderia) {
		this.notaIngresoMercaderia = notaIngresoMercaderia;
	}

	/**
	 * @return the idUsuarioRecepcion
	 */
	public String getIdUsuarioRecepcion() {
		return idUsuarioRecepcion;
	}

	/**
	 * @param idUsuarioRecepcion the idUsuarioRecepcion to set
	 */
	public void setIdUsuarioRecepcion(String idUsuarioRecepcion) {
		this.idUsuarioRecepcion = idUsuarioRecepcion;
	}

	/**
	 * @return the usuarioRegistro
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioRegistro() {
		return usuarioRegistro;
	}

	/**
	 * @param usuarioRegistro the usuarioRegistro to set
	 */
	public void setUsuarioRegistro(ec.com.smx.frameworkv2.security.dto.UserDto usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	/**
	 * @return the usuarioModificacion
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * @return the usuarioRecepcion
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioRecepcion() {
		return usuarioRecepcion;
	}

	/**
	 * @param usuarioRecepcion the usuarioRecepcion to set
	 */
	public void setUsuarioRecepcion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioRecepcion) {
		this.usuarioRecepcion = usuarioRecepcion;
	}
	
	/**
	 * @return the codigoAgrupadorFactura
	 */
	public String getCodigoAgrupadorFactura() {
		return codigoAgrupadorFactura;
	}

	/**
	 * @param codigoAgrupadorFactura the codigoAgrupadorFactura to set
	 */
	public void setCodigoAgrupadorFactura(String codigoAgrupadorFactura) {
		this.codigoAgrupadorFactura = codigoAgrupadorFactura;
	}

	/**
	 * @return the facturaDigitalESTs
	 */
	public Collection<FacturaDigitalEST> getFacturaDigitalESTs() {
		return facturaDigitalESTs;
	}

	/**
	 * @param facturaDigitalESTs the facturaDigitalESTs to set
	 */
	public void setFacturaDigitalESTs(Collection<FacturaDigitalEST> facturaDigitalESTs) {
		this.facturaDigitalESTs = facturaDigitalESTs;
	}

	/**
	 * @return the numeroFacturaRecepcion
	 */
	public String getNumeroFacturaRecepcion() {
		return numeroFacturaRecepcion;
	}

	/**
	 * @param numeroFacturaRecepcion the numeroFacturaRecepcion to set
	 */
	public void setNumeroFacturaRecepcion(String numeroFacturaRecepcion) {
		this.numeroFacturaRecepcion = numeroFacturaRecepcion;
	}

	public BigDecimal getValorProveedor() {
		return valorProveedor;
	}

	public void setValorProveedor(BigDecimal valorProveedor) {
		this.valorProveedor = valorProveedor;
	}
	@Deprecated
	public BigDecimal getValorTotalBrutoProveedor() {
		return valorTotalBrutoProveedor;
	}
	@Deprecated
	public void setValorTotalBrutoProveedor(BigDecimal valorTotalBrutoProveedor) {
		this.valorTotalBrutoProveedor = valorTotalBrutoProveedor;
	}

	public BigDecimal getValorTarifaCeroProveedor() {
		return valorTarifaCeroProveedor;
	}

	public void setValorTarifaCeroProveedor(BigDecimal valorTarifaCeroProveedor) {
		this.valorTarifaCeroProveedor = valorTarifaCeroProveedor;
	}

	public BigDecimal getValorTarifaDoce() {
		return valorTarifaDoce;
	}

	public void setValorTarifaDoce(BigDecimal valorTarifaDoce) {
		this.valorTarifaDoce = valorTarifaDoce;
	}

	public Collection<AjusteFacturaDTO> getAjusteFacturaCol() {
		return ajusteFacturaCol;
	}

	public void setAjusteFacturaCol(Collection<AjusteFacturaDTO> ajusteFacturaCol) {
		this.ajusteFacturaCol = ajusteFacturaCol;
	}

	public BigDecimal getTotalImpuestoIva() {
		return totalImpuestoIva;
	}

	public void setTotalImpuestoIva(BigDecimal totalImpuestoIva) {
		this.totalImpuestoIva = totalImpuestoIva;
	}

	/**
	 * @return the totalOrdenesCompra
	 */
	public Integer getTotalOrdenesCompra() {
		return totalOrdenesCompra;
	}

	/**
	 * @param totalOrdenesCompra the totalOrdenesCompra to set
	 */
	public void setTotalOrdenesCompra(Integer totalOrdenesCompra) {
		this.totalOrdenesCompra = totalOrdenesCompra;
	}

	/**
	 * @return the valorTotalDiferenciaRecepcion
	 */
	public BigDecimal getValorTotalDiferenciaRecepcion() {
		return valorTotalDiferenciaRecepcion;
	}

	/**
	 * @param valorTotalDiferenciaRecepcion the valorTotalDiferenciaRecepcion to set
	 */
	public void setValorTotalDiferenciaRecepcion(BigDecimal valorTotalDiferenciaRecepcion) {
		this.valorTotalDiferenciaRecepcion = valorTotalDiferenciaRecepcion;
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
	 * @return the valorTotalIve
	 */
	public BigDecimal getValorTotalIve() {
		return valorTotalIve;
	}

	/**
	 * @param valorTotalIve the valorTotalIve to set
	 */
	public void setValorTotalIve(BigDecimal valorTotalIve) {
		this.valorTotalIve = valorTotalIve;
	}

	/**
	 * @return the directorioError
	 */
	public String getDirectorioError() {
		return directorioError;
	}

	/**
	 * @param directorioError the directorioError to set
	 */
	public void setDirectorioError(String directorioError) {
		this.directorioError = directorioError;
	}

	public String getAplicarRangoTolerancia() {
		return aplicarRangoTolerancia;
	}

	public void setAplicarRangoTolerancia(String aplicarRangoTolerancia) {
		this.aplicarRangoTolerancia = aplicarRangoTolerancia;
	}

	public BigDecimal getValorDiferenciaAplicarAjuste() {
		return valorDiferenciaAplicarAjuste;
	}

	public void setValorDiferenciaAplicarAjuste(BigDecimal valorDiferenciaAplicarAjuste) {
		this.valorDiferenciaAplicarAjuste = valorDiferenciaAplicarAjuste;
	}

	/**
	 * @return the valorTotalReferencia
	 */
	public BigDecimal getValorTotalReferencia() {
		return valorTotalReferencia;
	}

	/**
	 * @param valorTotalReferencia the valorTotalReferencia to set
	 */
	public void setValorTotalReferencia(BigDecimal valorTotalReferencia) {
		this.valorTotalReferencia = valorTotalReferencia;
	}

	public Integer getCodigoCambioInformacion() {
		return codigoCambioInformacion;
	}

	public void setCodigoCambioInformacion(Integer codigoCambioInformacion) {
		this.codigoCambioInformacion = codigoCambioInformacion;
	}

	public String getValorCambioInformacion() {
		return valorCambioInformacion;
	}

	public void setValorCambioInformacion(String valorCambioInformacion) {
		this.valorCambioInformacion = valorCambioInformacion;
	}

	public ec.com.smx.corpv2.dto.CatalogoValorDTO getCambioInformacion() {
		return cambioInformacion;
	}

	public void setCambioInformacion(ec.com.smx.corpv2.dto.CatalogoValorDTO cambioInformacion) {
		this.cambioInformacion = cambioInformacion;
	}


	@Deprecated
	public BigDecimal getValorTotalCalculado() {
		return valorTotalCalculado;
	}

	@Deprecated
	public void setValorTotalCalculado(BigDecimal valorTotalCalculado) {
		this.valorTotalCalculado = valorTotalCalculado;
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
	 * @return the porRealizar
	 */
	public String getPorRealizar() {
		return porRealizar;
	}

	/**
	 * @param porRealizar the porRealizar to set
	 */
	public void setPorRealizar(String porRealizar) {
		this.porRealizar = porRealizar;
	}
}