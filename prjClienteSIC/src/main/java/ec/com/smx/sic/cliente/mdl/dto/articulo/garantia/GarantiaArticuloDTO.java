/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.articulo.garantia;

import static javax.persistence.FetchType.LAZY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.EmpresaDTO;
import ec.com.smx.corpv2.dto.LocalDTO;
import ec.com.smx.corpv2.dto.PersonaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.articulo.GarantiaArticuloID;

/**
 * Objeto en donde se registran las ventas de articulos con garantias
 * @author eharo
 *
 */

@Entity
@Table (name = "SCSMETGARART")
@SuppressWarnings("serial")
public class GarantiaArticuloDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private GarantiaArticuloID id = new GarantiaArticuloID();
	
	/**
	 * Numero asignado a la garantía generado unicamente por el POS
	 */
	@Column(name = "NUMEROGARANTIA", nullable = true)
	private String numeroGarantia ;

	/**
	 * Numero de transacción generada por el SICMER si viene del POS se graba con 0
	 */
	@Column(name = "ORIGENGARANTIA", nullable = false)
	private String origenGarantia ;

	/**
	 * Indica el tipo de transacción (Venta [V] o Devolución[D])
	 */
	@Column(name = "TIPOTRANSACCION", nullable = false)
	private String tipoTransaccion ;

	/**
	 * Tipo de la garantia (Normal[N] o Extendida[E])
	 */
	@Column(name = "TIPOGARANTIA", nullable = false)
	private String tipoGarantia ;
	
	/**
	 * Identifica el tipo de documento Fiscal [1-Factura,2-Nota de Venta]
	 */
	@Column(name = "TIPODOCUMENTOFISCAL", nullable = false)
	private Integer tipoDocumentoFiscal;
	
	/**
	 * Numero de la nota de venta o factura del cliente
	 */
	@Column(name = "NUMEROFACTURA", nullable = true)
	private String numeroFactura ;

	/**
	 * Fecha en la que se realizo la venta
	 */
	@Column(name = "FECHAVENTA", nullable = false)
	private Timestamp fechaVenta ;

	/**
	 * Numero de la cuenta generado por el POS
	 */
	@Column(name = "NUMEROCUENTA", nullable = true)
	private String numeroCuenta ;

	/**
	 * Codigo del Local que origina la transacción
	 */
	@Column(name = "CODIGOLOCAL", nullable = true)
	private Integer codigoLocal ;

	/**
	 * Numero de la caja donde se origina la transacción
	 */
	@Column(name = "NUMEROCAJA", nullable = true)
	private Integer numeroCaja ;

	/**
	 * Codigo del cajero que canaliza el pago
	 */
	@Column(name = "CODIGOCAJERO", nullable = true)
	private Integer codigoCajero ;

	/**
	 * Codigo del vendedor que realizo la venta
	 */
	@Column(name = "CODIGOVENDEDOR", nullable = true)
	private Integer codigoVendedor ;

	/**
	 * Codigo asignado a la persona
	 */
	@Column(name = "CODIGOPERSONA", nullable = true)
	private Long codigoPersona ;
	
	/**
	 * Codigo asignado a la empresa
	 */
	@Column(name = "CODIGOEMPRESA", nullable = true)
	private Long codigoEmpresa ;
	
	/**
	 * numero de documento qu eidentifica a la persona
	 */
	@Column(name = "NUMERODOCUMENTO", nullable = true)
	private String numeroDocumento ;
		
	/**
	 * Código del artículo
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo ;

	/**
	 * Dato de referencía del articulo
	 */
	@Column(name = "NUMEROREFERENCIA", nullable = true)
	private String numeroReferencia ;

	/**
	 * Tiempo que cubre esta garantía
	 */
	@Column(name = "TIEMPOGARANTIA", nullable = true)
	private Integer tiempoGarantia ;
	
	/**
	 * Valor que pago por concepto de extensión de garantía
	 */
	@Column(name = "COSTOGARANTIA", nullable = true)
	private Double costoGarantia ;

	/**
	 * Valor que pago el cliente por el articulo adquirido
	 */
	@Column(name = "VALORARTICULO", nullable = true)
	private Double valorArticulo ;
	
	/**
	 * Marca que indica si un producto fue entregado al cliente
	 */
	@Column(name = "ENTREGADO", nullable = true)
	private String entregado;

	/**
	 * Fecha desde donde corre la garantia
	 */
	@Column(name = "FECHAVIGENCIADESDE", nullable = true)
	private Timestamp fechaVigenciaDesde;

	/**
	 * Fecha de expiración de la garantia
	 */
	@Column(name = "FECHAVIGENCIAHASTA", nullable = true)
	private Timestamp fechaVigenciaHasta;
	
	/**
	 * Fecha de expiración de la garantia
	 */
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	/**
	 * Realacion con el estado
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)
	})
	private ArticuloDTO articuloDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOLOCAL", insertable=false, updatable=false, referencedColumnName="CODIGOLOCAL")
	})
	private LocalDTO localDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOPERSONA", insertable=false, updatable=false, referencedColumnName="CODIGOPERSONA")
	})
	private PersonaDTO personaDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOEMPRESA", insertable=false, updatable=false, referencedColumnName="CODIGOEMPRESA")
	})
	private EmpresaDTO empresaDTO;

	/**
	 * @return the id
	 */
	public GarantiaArticuloID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(GarantiaArticuloID id) {
		this.id = id;
	}

	/**
	 * @return the numeroGarantia
	 */
	public String getNumeroGarantia() {
		return numeroGarantia;
	}

	/**
	 * @param numeroGarantia the numeroGarantia to set
	 */
	public void setNumeroGarantia(String numeroGarantia) {
		this.numeroGarantia = numeroGarantia;
	}

	/**
	 * @return the origenGarantia
	 */
	public String getOrigenGarantia() {
		return origenGarantia;
	}

	/**
	 * @param origenGarantia the origenGarantia to set
	 */
	public void setOrigenGarantia(String origenGarantia) {
		this.origenGarantia = origenGarantia;
	}

	/**
	 * @return the tipoTransaccion
	 */
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	/**
	 * @param tipoTransaccion the tipoTransaccion to set
	 */
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	/**
	 * @return the tipoGarantia
	 */
	public String getTipoGarantia() {
		return tipoGarantia;
	}

	/**
	 * @param tipoGarantia the tipoGarantia to set
	 */
	public void setTipoGarantia(String tipoGarantia) {
		this.tipoGarantia = tipoGarantia;
	}

	/**
	 * @return the tipoDocumentoFiscal
	 */
	public Integer getTipoDocumentoFiscal() {
		return tipoDocumentoFiscal;
	}

	/**
	 * @param tipoDocumentoFiscal the tipoDocumentoFiscal to set
	 */
	public void setTipoDocumentoFiscal(Integer tipoDocumentoFiscal) {
		this.tipoDocumentoFiscal = tipoDocumentoFiscal;
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
	 * @return the fechaVenta
	 */
	public Timestamp getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * @param fechaVenta the fechaVenta to set
	 */
	public void setFechaVenta(Timestamp fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * @return the numeroCuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/**
	 * @return the codigoLocal
	 */
	public Integer getCodigoLocal() {
		return codigoLocal;
	}

	/**
	 * @param codigoLocal the codigoLocal to set
	 */
	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	/**
	 * @return the numeroCaja
	 */
	public Integer getNumeroCaja() {
		return numeroCaja;
	}

	/**
	 * @param numeroCaja the numeroCaja to set
	 */
	public void setNumeroCaja(Integer numeroCaja) {
		this.numeroCaja = numeroCaja;
	}

	/**
	 * @return the codigoCajero
	 */
	public Integer getCodigoCajero() {
		return codigoCajero;
	}

	/**
	 * @param codigoCajero the codigoCajero to set
	 */
	public void setCodigoCajero(Integer codigoCajero) {
		this.codigoCajero = codigoCajero;
	}

	/**
	 * @return the codigoVendedor
	 */
	public Integer getCodigoVendedor() {
		return codigoVendedor;
	}

	/**
	 * @param codigoVendedor the codigoVendedor to set
	 */
	public void setCodigoVendedor(Integer codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	/**
	 * @return the codigoPersona
	 */
	public Long getCodigoPersona() {
		return codigoPersona;
	}

	/**
	 * @param codigoPersona the codigoPersona to set
	 */
	public void setCodigoPersona(Long codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	/**
	 * @return the codigoEmpresa
	 */
	public Long getCodigoEmpresa() {
		return codigoEmpresa;
	}

	/**
	 * @param codigoEmpresa the codigoEmpresa to set
	 */
	public void setCodigoEmpresa(Long codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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
	 * @return the numeroReferencia
	 */
	public String getNumeroReferencia() {
		return numeroReferencia;
	}

	/**
	 * @param numeroReferencia the numeroReferencia to set
	 */
	public void setNumeroReferencia(String numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}

	/**
	 * @return the tiempoGarantia
	 */
	public Integer getTiempoGarantia() {
		return tiempoGarantia;
	}

	/**
	 * @param tiempoGarantia the tiempoGarantia to set
	 */
	public void setTiempoGarantia(Integer tiempoGarantia) {
		this.tiempoGarantia = tiempoGarantia;
	}

	/**
	 * @return the costoGarantia
	 */
	public Double getCostoGarantia() {
		return costoGarantia;
	}

	/**
	 * @param costoGarantia the costoGarantia to set
	 */
	public void setCostoGarantia(Double costoGarantia) {
		this.costoGarantia = costoGarantia;
	}

	/**
	 * @return the valorArticulo
	 */
	public Double getValorArticulo() {
		return valorArticulo;
	}

	/**
	 * @param valorArticulo the valorArticulo to set
	 */
	public void setValorArticulo(Double valorArticulo) {
		this.valorArticulo = valorArticulo;
	}

	/**
	 * @return the entregado
	 */
	public String getEntregado() {
		return entregado;
	}

	/**
	 * @param entregado the entregado to set
	 */
	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}

	/**
	 * @return the fechaVigenciaDesde
	 */
	public Timestamp getFechaVigenciaDesde() {
		return fechaVigenciaDesde;
	}

	/**
	 * @param fechaVigenciaDesde the fechaVigenciaDesde to set
	 */
	public void setFechaVigenciaDesde(Timestamp fechaVigenciaDesde) {
		this.fechaVigenciaDesde = fechaVigenciaDesde;
	}

	/**
	 * @return the fechaVigenciaHasta
	 */
	public Timestamp getFechaVigenciaHasta() {
		return fechaVigenciaHasta;
	}

	/**
	 * @param fechaVigenciaHasta the fechaVigenciaHasta to set
	 */
	public void setFechaVigenciaHasta(Timestamp fechaVigenciaHasta) {
		this.fechaVigenciaHasta = fechaVigenciaHasta;
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
	 * @return the articuloDTO
	 */
	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}

	/**
	 * @param articuloDTO the articuloDTO to set
	 */
	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}

	/**
	 * @return the localDTO
	 */
	public LocalDTO getLocalDTO() {
		return localDTO;
	}

	/**
	 * @param localDTO the localDTO to set
	 */
	public void setLocalDTO(LocalDTO localDTO) {
		this.localDTO = localDTO;
	}

	/**
	 * @return the personaDTO
	 */
	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	/**
	 * @param personaDTO the personaDTO to set
	 */
	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

	/**
	 * @return the empresaDTO
	 */
	public EmpresaDTO getEmpresaDTO() {
		return empresaDTO;
	}

	/**
	 * @param empresaDTO the empresaDTO to set
	 */
	public void setEmpresaDTO(EmpresaDTO empresaDTO) {
		this.empresaDTO = empresaDTO;
	}

}
