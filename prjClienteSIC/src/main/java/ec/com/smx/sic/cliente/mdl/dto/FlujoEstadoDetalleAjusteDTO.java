package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.FlujoEstadoDetalleAjusteID;

/**
 * Especifica los diferentes estados por donde va pasando los ajustes
 * @author fcollaguazo
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTFLUESTDETAJU")
public class FlujoEstadoDetalleAjusteDTO extends SimpleAuditDTO{

	@EmbeddedId
	private FlujoEstadoDetalleAjusteID id = new FlujoEstadoDetalleAjusteID();
	
	private Long codigoDetalleAjusteFacturaEstado ;
	
	private Integer codigoEstadoInicial;
	
	@ComparatorTypeField
	private String valorEstadoInicial;
	
	private Integer codigoEstadoFinal;
	
	@ComparatorTypeField
	private String valorEstadoFinal;
	
	/**
	 * Representa la fecha en la que se inicia el proceso.
	 * 
	 */
	@Column(name="FECHAINICIO")
	private Date fechaInicio;

	/**
	 * Representa la fecha en la que se finaliza el proceso.
	 * 
	 */
	@Column(name="FECHAFIN")
	private Date fechaFin;
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 *
	 */
	@Column
	@ComparatorTypeField
	private String estado ;
	
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
	@Column(name="FECHAMODIFICACION")
	private java.util.Date fechaModificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOESTADOINICIAL", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPOPADRE"),
		@JoinColumn(name="VALORESTADOINICIAL", referencedColumnName="CODIGOCATALOGOVALORPADRE", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOESTADOFINAL", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPORELACIONADO"),
		@JoinColumn(name="VALORESTADOFINAL", referencedColumnName="CODIGOCATALOGOVALORRELACIONADO", insertable=false, updatable=false)
		})
	private CatalogoValorRelacionadoDTO catalogoValorRelacionado;

	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODETALLEAJUSTEFACTURAESTADO", insertable = false, updatable = false, referencedColumnName = "CODIGODETALLEAJUSTEFACTURAESTADO") })
	private DetalleAjusteFacturaEstadoDTO detalleAjusteFacturaEstadoDTO;


	public Integer getCodigoEstadoInicial() {
		return codigoEstadoInicial;
	}


	public void setCodigoEstadoInicial(Integer codigoEstadoInicial) {
		this.codigoEstadoInicial = codigoEstadoInicial;
	}


	public String getValorEstadoInicial() {
		return valorEstadoInicial;
	}


	public void setValorEstadoInicial(String valorEstadoInicial) {
		this.valorEstadoInicial = valorEstadoInicial;
	}


	public Integer getCodigoEstadoFinal() {
		return codigoEstadoFinal;
	}


	public void setCodigoEstadoFinal(Integer codigoEstadoFinal) {
		this.codigoEstadoFinal = codigoEstadoFinal;
	}


	public String getValorEstadoFinal() {
		return valorEstadoFinal;
	}


	public void setValorEstadoFinal(String valorEstadoFinal) {
		this.valorEstadoFinal = valorEstadoFinal;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}


	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}


	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}


	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}


	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	public CatalogoValorRelacionadoDTO getCatalogoValorRelacionado() {
		return catalogoValorRelacionado;
	}


	public void setCatalogoValorRelacionado(CatalogoValorRelacionadoDTO catalogoValorRelacionado) {
		this.catalogoValorRelacionado = catalogoValorRelacionado;
	}

	public DetalleAjusteFacturaEstadoDTO getDetalleAjusteFacturaEstadoDTO() {
		return detalleAjusteFacturaEstadoDTO;
	}

	public void setDetalleAjusteFacturaEstadoDTO(DetalleAjusteFacturaEstadoDTO detalleAjusteFacturaEstadoDTO) {
		this.detalleAjusteFacturaEstadoDTO = detalleAjusteFacturaEstadoDTO;
	}


	public FlujoEstadoDetalleAjusteID getId() {
		return id;
	}


	public void setId(FlujoEstadoDetalleAjusteID id) {
		this.id = id;
	}


	public Long getCodigoDetalleAjusteFacturaEstado() {
		return codigoDetalleAjusteFacturaEstado;
	}


	public void setCodigoDetalleAjusteFacturaEstado(Long codigoDetalleAjusteFacturaEstado) {
		this.codigoDetalleAjusteFacturaEstado = codigoDetalleAjusteFacturaEstado;
	}
}
