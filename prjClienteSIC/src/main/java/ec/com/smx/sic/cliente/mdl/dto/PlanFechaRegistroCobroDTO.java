/** ec.com.smx.sic.cliente.mdl.dto
 * PlanFechaRegistroCobro.java
 * @author srodriguez
 * 20/3/2015
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.PlanFechaRegistroCobroID;

/**
 * @author srodriguez
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCCEMTPLAFECREGCOB")
public class PlanFechaRegistroCobroDTO implements Serializable{

	
	@EmbeddedId
	private PlanFechaRegistroCobroID id=new PlanFechaRegistroCobroID();

	
	/** Variable del tipo Long PlanFechaRegistroCobroDTO.java
	 * @author srodriguez
	 * 23/3/2015
	 */
	@Column(name = "CODIGODETNEGGESPRECONPAR")
	private Long codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	
	/**
	 * Especifica el codigo numerico del registro de cobro+
	 */
	@Column(name = "FECHACOBRO", nullable = false)
	private Date fechaCobro;
	
	/**
	 * Especifica el codigo numerico del registro de cobro+
	 */
	@Column(name = "COBRADO", nullable = false)
	private Boolean cobrado;
	
	@Column(name="CODCATVALESTADOCOBRO")
	private String codigoValorEstadoCobro;
	
	@Column(name="CODCATTIPESTADOCOBRO")
	private Integer codigoTipoEstodoCobro;
	
	
	/**
	 * Especifica el codigo numerico del registro de cobro+
	 */
	@Column(name = "ESTADO", nullable = false)
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
	private Timestamp fechaRegistro;

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
	private Timestamp fechaModificacion;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
	@JoinColumn(name = "CODIGODETNEGGESPRECONPAR", insertable = false, updatable = false, referencedColumnName = "CODIGODETNEGGESPRECONPAR") })
	private DetalleNegociacionGestionPrecioCovenioParticipanteDTO detalleNegociacionGestionPrecioCovenioParticipanteDTO;
	
	@OneToMany(mappedBy = "planFechaRegistroCobroDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<RegistroCobroDTO> registroCobroCol;
	
	@Transient
	private BigDecimal valorACobrar;
	@Transient
	private BigDecimal saldoPorCobrar;
	@Transient
	private BigDecimal valorAcumulado;
	@Transient
	private String estadoCatalogo;
	@Transient
	private String documento;
	@Transient
	private Integer	numeroCuota;
	@Transient
	private Boolean esDetalle;
	@Transient
	private Boolean desplegado;
	@Transient
	private Double porcentajeIva;
	/**
	 * Valores de error documento
	 */
	@Transient
	private String valorDocumentoError;
	@Transient
	private Integer tipoDocumentoError;
	@Transient
	private String descripcionDocumentoError;
	
	/** Metodo que retorna id del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return PlanFechaRegistroCobroID id 
	 */
	public PlanFechaRegistroCobroID getId() {
		return id;
	}

	/** Metodo que asigna el valor id en id del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param id
	 */
	
	public void setId(PlanFechaRegistroCobroID id) {
		this.id = id;
	}


	/** Metodo que retorna fechaCobro del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return Date fechaCobro 
	 */
	public Date getFechaCobro() {
		return fechaCobro;
	}

	/** Metodo que asigna el valor fechaCobro en fechaCobro del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param fechaCobro
	 */
	
	public void setFechaCobro(Date fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

	/** Metodo que retorna cobrado del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return Boolean cobrado 
	 */
	public Boolean getCobrado() {
		return cobrado;
	}

	/** Metodo que asigna el valor cobrado en cobrado del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param cobrado
	 */
	
	public void setCobrado(Boolean cobrado) {
		this.cobrado = cobrado;
	}

	/** Metodo que retorna estado del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return Boolean estado 
	 */
	public Boolean getEstado() {
		return estado;
	}

	/** Metodo que asigna el valor estado en estado del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param estado
	 */
	
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	/** Metodo que retorna idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return java.lang.String idUsuarioRegistro 
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/** Metodo que asigna el valor idUsuarioRegistro en idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param idUsuarioRegistro
	 */
	
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}


	/** Metodo que retorna idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return java.lang.String idUsuarioModificacion 
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/** Metodo que asigna el valor idUsuarioModificacion en idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param idUsuarioModificacion
	 */
	
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	
	public Long getCodigoDetalleNegociacionGestionPrecioConvenioParticipante() {
		return codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	}

	public void setCodigoDetalleNegociacionGestionPrecioConvenioParticipante(Long codigoDetalleNegociacionGestionPrecioConvenioParticipante) {
		this.codigoDetalleNegociacionGestionPrecioConvenioParticipante = codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	}

	/** Metodo que retorna detalleNegociacionGestionPrecioCovenioParticipanteDTO del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @return DetalleNegociacionGestionPrecioCovenioParticipanteDTO detalleNegociacionGestionPrecioCovenioParticipanteDTO 
	 */
	public DetalleNegociacionGestionPrecioCovenioParticipanteDTO getDetalleNegociacionGestionPrecioCovenioParticipanteDTO() {
		return detalleNegociacionGestionPrecioCovenioParticipanteDTO;
	}

	/** Metodo que asigna el valor detalleNegociacionGestionPrecioCovenioParticipanteDTO en detalleNegociacionGestionPrecioCovenioParticipanteDTO del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @param detalleNegociacionGestionPrecioCovenioParticipanteDTO
	 */
	
	public void setDetalleNegociacionGestionPrecioCovenioParticipanteDTO(DetalleNegociacionGestionPrecioCovenioParticipanteDTO detalleNegociacionGestionPrecioCovenioParticipanteDTO) {
		this.detalleNegociacionGestionPrecioCovenioParticipanteDTO = detalleNegociacionGestionPrecioCovenioParticipanteDTO;
	}

	/** Metodo que retorna fechaRegistro del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @return Timestamp fechaRegistro 
	 */
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/** Metodo que asigna el valor fechaRegistro en fechaRegistro del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @param fechaRegistro
	 */
	
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/** Metodo que retorna fechaModificacion del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @return Timestamp fechaModificacion 
	 */
	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/** Metodo que asigna el valor fechaModificacion en fechaModificacion del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @param fechaModificacion
	 */
	
	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Collection<RegistroCobroDTO> getRegistroCobroCol() {
		return registroCobroCol;
	}

	public void setRegistroCobroCol(Collection<RegistroCobroDTO> registroCobroCol) {
		this.registroCobroCol = registroCobroCol;
	}

	public BigDecimal getValorACobrar() {
		return valorACobrar;
	}

	public void setValorACobrar(BigDecimal valorACobrar) {
		this.valorACobrar = valorACobrar;
	}

	public BigDecimal getSaldoPorCobrar() {
		return saldoPorCobrar;
	}

	public void setSaldoPorCobrar(BigDecimal saldoPorCobrar) {
		this.saldoPorCobrar = saldoPorCobrar;
	}

	public BigDecimal getValorAcumulado() {
		return valorAcumulado;
	}

	public void setValorAcumulado(BigDecimal valorAcumulado) {
		this.valorAcumulado = valorAcumulado;
	}

	public String getEstadoCatalogo() {
		return estadoCatalogo;
	}

	public void setEstadoCatalogo(String estadoCatalogo) {
		this.estadoCatalogo = estadoCatalogo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public Integer getNumeroCuota() {
		return numeroCuota;
	}

	public void setNumeroCuota(Integer numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public Boolean getEsDetalle() {
		return esDetalle;
	}

	public void setEsDetalle(Boolean esDetalle) {
		this.esDetalle = esDetalle;
	}

	public Boolean getDesplegado() {
		return desplegado;
	}

	public void setDesplegado(Boolean desplegado) {
		this.desplegado = desplegado;
	}

	public Double getPorcentajeIva() {
		return porcentajeIva;
	}

	public void setPorcentajeIva(Double porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}

	/**
	 * @return the valorDocumentoError
	 */
	public String getValorDocumentoError() {
		return valorDocumentoError;
	}

	/**
	 * @param valorDocumentoError the valorDocumentoError to set
	 */
	public void setValorDocumentoError(String valorDocumentoError) {
		this.valorDocumentoError = valorDocumentoError;
	}

	/**
	 * @return the tipoDocumentoError
	 */
	public Integer getTipoDocumentoError() {
		return tipoDocumentoError;
	}

	/**
	 * @param tipoDocumentoError the tipoDocumentoError to set
	 */
	public void setTipoDocumentoError(Integer tipoDocumentoError) {
		this.tipoDocumentoError = tipoDocumentoError;
	}

	/**
	 * @return the descripcionDocumentoError
	 */
	public String getDescripcionDocumentoError() {
		return descripcionDocumentoError;
	}

	/**
	 * @param descripcionDocumentoError the descripcionDocumentoError to set
	 */
	public void setDescripcionDocumentoError(String descripcionDocumentoError) {
		this.descripcionDocumentoError = descripcionDocumentoError;
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

}
