package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.RegistroCobroDiarioID;

/**
 * @author egudino 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCCEMTREGCOBDIA")
public class RegistroCobroDiarioDTO implements Serializable{

	@EmbeddedId
	private RegistroCobroDiarioID id=new RegistroCobroDiarioID();
	
	/**
	 * Valor acumulado del procesamiento de las ventas
	 */
	@Column(name="CODIGODETNEGGESPRECONPAR")
	private Long codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	
	/**
	 * Valor acumulado del procesamiento de las ventas
	 */
	@Column(name="VALORACUMULADO")
	private BigDecimal valorAcumulado;
	
	
	/**
	 * Valor acumulado a cancelar como remuneracion por las ventas
	 */
	@Column(name="VALORACOBRAR")
	private BigDecimal valorACobrar;

	/**
	 * Valor acumulado a cancelar como remuneracion por las ventas
	 */
	@Column(name="VALORCOBRADOACUMULADO")
	private BigDecimal valorCobradoAcumulado;
	
	/**
	 * Valor acumulado a cancelar como remuneracion por las ventas
	 */
	@Column(name="SALDOACUMULADO")
	private BigDecimal saldoAcumulado;
	
	/**
	 * Valor acumulado a cancelar como remuneracion por las ventas
	 */
	@Column(name="SALDOPORCOBRAR")
	private BigDecimal saldoPorCobrar;
	
	/**
	 * Valor acumulado iva cobrado
	 */
	@Column(name="IVAVALORCOBRAR")
	private BigDecimal ivaValorCobrar;
	
	/**
	 * Porcentaje del tipo de impuesto
	 * 
	 */
	@Column(name = "PORCENTAJEIVA")
	private Double porcentajeIva;
	
	/**
	 * Tipo de impuesto aplicado
	 */
	@Column(name = "CODIGOTIPOIMPUESTO")
	private Integer codigoTipoImpuesto;
	
	/**
	 * Valor numero de cuotas
	 */
	@Column(name="NUMEROCUOTA")
	private Integer numeroCuota;
	
	@Column(name="NUMDOC")
	private String numeroDocumento;
	
	
	@Column(name="CODCATVALDOCERROR")
	private String valorDocumentoError;
	
	@Column(name="CODCATTIPDOCERROR")
	private Integer tipoDocumentoError;
	
	
	@Column(name="CODCATVALESTADOCOBRO")
	private String codigoValorEstadoCobro;
	
	@Column(name="CODCATTIPESTADOCOBRO")
	private Integer codigoTipoEstodoCobro;
	
	@Column(name = "FECHACOBRO")
	private java.util.Date fechaCobro;
	
	/**
	 * Estado del registro
	 * 
	 */
	@Column(name = "ESTADO")
	private Boolean estado;
	
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name = "IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column(name = "FECHAREGISTRO")
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@Column(name = "IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@Column(name = "FECHAMODIFICACION")
	private java.util.Date fechaModificacion;
	
	/**
	 * Mapeo de los detalles de un registro de cobro 
	 * 
	 */
	@OneToMany(mappedBy = "registroCobroDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<RegistroCobroDetalleDiarioDTO> registroCobroDetalleCol;

	/**
	 * Referencia CatalogoValorDTO ESTADOS
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODCATVALESTADOCOBRO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODCATTIPESTADOCOBRO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO estadoCobroDTO;
	
	
	/* Metodo que asigna el id del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param id parametro de tipo RegistroCobroID
	 */
	public void setId(RegistroCobroDiarioID id) {
		this.id = id;
	}

	/* Metodo que asigna el valorAcumulado del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param valorAcumulado parametro de tipo BigDecimal
	 */
	public void setValorAcumulado(BigDecimal valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
	}

	/* Metodo que asigna el valorACobrar del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param valorACobrar parametro de tipo BigDecimal
	 */
	public void setValorACobrar(BigDecimal valorACobrar) {
		this.valorACobrar = valorACobrar;
	}

	/* Metodo que asigna el valorCobrado del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param valorCobrado parametro de tipo BigDecimal
	 */
	public void setValorCobradoAcumulado(BigDecimal valorCobradoAcumulado) {
		this.valorCobradoAcumulado = valorCobradoAcumulado;
	}

	/* Metodo que asigna el estado del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param estado parametro de tipo Boolean
	 */
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	/* Metodo que asigna el idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param idUsuarioRegistro parametro de tipo java.lang.String
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/* Metodo que asigna el fechaRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param fechaRegistro parametro de tipo java.util.Date
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/* Metodo que asigna el idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param idUsuarioModificacion parametro de tipo java.lang.String
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/* Metodo que asigna el fechaModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param fechaModificacion parametro de tipo java.util.Date
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/* Metodo que retorna registroCobroDetalleCol del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Collection<RegistroCobroDetalleDTO> registroCobroDetalleCol 
	 */
	public Collection<RegistroCobroDetalleDiarioDTO> getRegistroCobroDetalleCol() {
		return registroCobroDetalleCol;
	}

	/* Metodo que asigna el registroCobroDetalleCol del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param registroCobroDetalleCol parametro de tipo Collection<RegistroCobroDetalleDTO>
	 */
	public void setRegistroCobroDetalleCol(Collection<RegistroCobroDetalleDiarioDTO> registroCobroDetalleCol) {
		this.registroCobroDetalleCol = registroCobroDetalleCol;
	}

	/* Metodo que retorna id del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return RegistroCobroID id 
	 */
	public RegistroCobroDiarioID getId() {
		return id;
	}

	/* Metodo que retorna valorAcumulado del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return BigDecimal valorAcumulado 
	 */
	public BigDecimal getValorAcumulado() {
		return valorAcumulado;
	}

	/* Metodo que retorna valorACobrar del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return BigDecimal valorACobrar 
	 */
	public BigDecimal getValorACobrar() {
		return valorACobrar;
	}

	/* Metodo que retorna valorCobrado del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return BigDecimal valorCobrado 
	 */
	public BigDecimal getValorCobradoAcumulado() {
		return valorCobradoAcumulado;
	}

	/* Metodo que retorna estado del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Boolean estado 
	 */
	public Boolean getEstado() {
		return estado;
	}

	/* Metodo que retorna idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.lang.String idUsuarioRegistro 
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/* Metodo que retorna fechaRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.util.Date fechaRegistro 
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/* Metodo que retorna idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.lang.String idUsuarioModificacion 
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/* Metodo que retorna fechaModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.util.Date fechaModificacion 
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/** Metodo que retorna saldoAcumulado del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return BigDecimal saldoAcumulado 
	 */
	public BigDecimal getSaldoAcumulado() {
		return saldoAcumulado;
	}

	/** Metodo que asigna el valor saldoAcumulado en saldoAcumulado del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param saldoAcumulado
	 */
	
	public void setSaldoAcumulado(BigDecimal saldoAcumulado) {
		this.saldoAcumulado = saldoAcumulado;
	}

	/** Metodo que retorna saldoPorCobrar del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return BigDecimal saldoPorCobrar 
	 */
	public BigDecimal getSaldoPorCobrar() {
		return saldoPorCobrar;
	}

	/** Metodo que asigna el valor saldoPorCobrar en saldoPorCobrar del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param saldoPorCobrar
	 */
	
	public void setSaldoPorCobrar(BigDecimal saldoPorCobrar) {
		this.saldoPorCobrar = saldoPorCobrar;
	}

	/**
	 * @return the numeroCuota
	 */
	public Integer getNumeroCuota() {
		return numeroCuota;
	}

	/**
	 * @param numeroCuota the numeroCuota to set
	 */
	public void setNumeroCuota(Integer numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public String getCodigoValorEstadoCobro() {
		return codigoValorEstadoCobro;
	}

	public void setCodigoValorEstadoCobro(String codigoValorEstadoCobro) {
		this.codigoValorEstadoCobro = codigoValorEstadoCobro;
	}

	public Integer getCodigoTipoEstodoCobro() {
		return codigoTipoEstodoCobro;
	}

	public void setCodigoTipoEstodoCobro(Integer codigoTipoEstodoCobro) {
		this.codigoTipoEstodoCobro = codigoTipoEstodoCobro;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getValorDocumentoError() {
		return valorDocumentoError;
	}

	public void setValorDocumentoError(String valorDocumentoError) {
		this.valorDocumentoError = valorDocumentoError;
	}

	public Integer getTipoDocumentoError() {
		return tipoDocumentoError;
	}

	public void setTipoDocumentoError(Integer tipoDocumentoError) {
		this.tipoDocumentoError = tipoDocumentoError;
	}

	public BigDecimal getIvaValorCobrar() {
		return ivaValorCobrar;
	}

	public void setIvaValorCobrar(BigDecimal ivaValorCobrar) {
		this.ivaValorCobrar = ivaValorCobrar;
	}
	public Double getPorcentajeIva() {
		return porcentajeIva;
	}

	public void setPorcentajeIva(Double porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}

	public Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}

	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
	}

	public CatalogoValorDTO getEstadoCobroDTO() {
		return estadoCobroDTO;
	}

	public void setEstadoCobroDTO(CatalogoValorDTO estadoCobroDTO) {
		this.estadoCobroDTO = estadoCobroDTO;
	}

	/**
	 * @return the fechaCobro
	 */
	public java.util.Date getFechaCobro() {
		return fechaCobro;
	}

	/**
	 * @param fechaCobro the fechaCobro to set
	 */
	public void setFechaCobro(java.util.Date fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

	public Long getCodigoDetalleNegociacionGestionPrecioConvenioParticipante() {
		return codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	}

	public void setCodigoDetalleNegociacionGestionPrecioConvenioParticipante(Long codigoDetalleNegociacionGestionPrecioConvenioParticipante) {
		this.codigoDetalleNegociacionGestionPrecioConvenioParticipante = codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	}
}
