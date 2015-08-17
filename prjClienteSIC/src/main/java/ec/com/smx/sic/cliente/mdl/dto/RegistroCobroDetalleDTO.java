package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.RegistroCobroDetalleID;

/**
 * @author srodriguez 
 * 2014-11-29
 */

@Entity
@Table(name = "SCCEMTREGCOBDET")
public class RegistroCobroDetalleDTO {
	
	@EmbeddedId
	private RegistroCobroDetalleID id=new RegistroCobroDetalleID();
	
	/**
	 * Llave foranea del codigo de datos acumulados
	 */
	@Column(name="CODIGOREGISTROCOBRO")
	private Long codigoRegistroCobro;
	
	
	/**
	 * Valor acumulado
	 */
	@Column(name="VALORACUMULADO")
	private BigDecimal valorAcumulado;
	
	/**
	 * Valor a cobrar
	 */
	@Column(name="VALORACOBRAR")
	private BigDecimal valorACobrar;
	
	/**
	 * Valor cobrado
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
	 * Valor acumulado a cancelar como remuneracion por las ventas
	 */
	@Column(name="CODIGOLOCAL")
	private String codigoLocal;
	
	/**
	 * Valor acumulado a cancelar como remuneracion por las ventas
	 */
	@Column(name="CODIGOARTICULO")
	private String codigoArticulo	;
	
	/**
	 * Valor iva cobrado
	 */
	@Column(name="IVAVALORCOBRAR")
	private BigDecimal ivaValorCobrar;
	
	/**
	 * Porcentaje iva aplicado
	 */
	@Column(name="PORCENTAJEIVA")
	private Double porcentajeIva;
	
	/**
	 * Tipo de impuesto aplicado
	 */
	@Column(name = "CODIGOTIPOIMPUESTO")
	private Integer codigoTipoImpuesto;
	
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
	 * mapeo externo de datos acumulados
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
	@JoinColumn(name = "CODIGOREGISTROCOBRO", insertable = false, updatable = false, referencedColumnName = "CODIGOREGISTROCOBRO") })
	private RegistroCobroDTO registroCobroDTO;

	/* Metodo que retorna id del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return RegistroCobroDetalleID id 
	 */
	public RegistroCobroDetalleID getId() {
		return id;
	}

	/* Metodo que asigna el id del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param id parametro de tipo RegistroCobroDetalleID
	 */
	public void setId(RegistroCobroDetalleID id) {
		this.id = id;
	}

	/* Metodo que retorna codigoRegistroCobro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Long codigoRegistroCobro 
	 */
	public Long getCodigoRegistroCobro() {
		return codigoRegistroCobro;
	}

	/* Metodo que asigna el codigoRegistroCobro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param codigoRegistroCobro parametro de tipo Long
	 */
	public void setCodigoRegistroCobro(Long codigoRegistroCobro) {
		this.codigoRegistroCobro = codigoRegistroCobro;
	}

	/* Metodo que retorna valorCobrado del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return BigDecimal valorCobrado 
	 */
	public BigDecimal getValorCobradoAcumulado() {
		return valorCobradoAcumulado;
	}

	/* Metodo que asigna el valorCobrado del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param valorCobrado parametro de tipo BigDecimal
	 */
	public void setValorCobradoAcumulado(BigDecimal valorCobradoAcumulado) {
		this.valorCobradoAcumulado = valorCobradoAcumulado;
	}

	/* Metodo que retorna estado del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Boolean estado 
	 */
	public Boolean getEstado() {
		return estado;
	}

	/* Metodo que asigna el estado del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param estado parametro de tipo Boolean
	 */
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	/* Metodo que retorna idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.lang.String idUsuarioRegistro 
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/* Metodo que asigna el idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param idUsuarioRegistro parametro de tipo java.lang.String
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/* Metodo que retorna fechaRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.util.Date fechaRegistro 
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/* Metodo que asigna el fechaRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param fechaRegistro parametro de tipo java.util.Date
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/* Metodo que retorna idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.lang.String idUsuarioModificacion 
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/* Metodo que asigna el idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param idUsuarioModificacion parametro de tipo java.lang.String
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/* Metodo que retorna fechaModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.util.Date fechaModificacion 
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/* Metodo que asigna el fechaModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param fechaModificacion parametro de tipo java.util.Date
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/* Metodo que retorna registroCobroDTO del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return RegistroCobroDTO registroCobroDTO 
	 */
	public RegistroCobroDTO getRegistroCobroDTO() {
		return registroCobroDTO;
	}

	/* Metodo que asigna el registroCobroDTO del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param registroCobroDTO parametro de tipo RegistroCobroDTO
	 */
	public void setRegistroCobroDTO(RegistroCobroDTO registroCobroDTO) {
		this.registroCobroDTO = registroCobroDTO;
	}

	/** Metodo que retorna valorAcumulado del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return BigDecimal valorAcumulado 
	 */
	public BigDecimal getValorAcumulado() {
		return valorAcumulado;
	}

	/** Metodo que asigna el valor valorAcumulado en valorAcumulado del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param valorAcumulado
	 */
	
	public void setValorAcumulado(BigDecimal valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
	}

	/** Metodo que retorna valorACobrar del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return BigDecimal valorACobrar 
	 */
	public BigDecimal getValorACobrar() {
		return valorACobrar;
	}

	/** Metodo que asigna el valor valorACobrar en valorACobrar del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param valorACobrar
	 */
	
	public void setValorACobrar(BigDecimal valorACobrar) {
		this.valorACobrar = valorACobrar;
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

	/** Metodo que retorna codigoLocal del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return BigDecimal codigoLocal 
	 */
	public String getCodigoLocal() {
		return codigoLocal;
	}

	/** Metodo que asigna el valor codigoLocal en codigoLocal del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param codigoLocal
	 */
	
	public void setCodigoLocal(String codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	/** Metodo que retorna codigoArticulo del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return BigDecimal codigoArticulo 
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/** Metodo que asigna el valor codigoArticulo en codigoArticulo del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param codigoArticulo
	 */
	
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
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
}
