package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

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
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.FacturaRelacionadaID;

/**
 * Permite relacionar facturas, una factura padre con  varias facturas hijas
 * @author fcollaguazo
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SCFDITFACREL")
public class FacturaRelacionadaDTO extends SimpleAuditDTO{

	@EmbeddedId
	private FacturaRelacionadaID id = new FacturaRelacionadaID();
	
	private Integer codigoTipoAsignacion;
	
	@ComparatorTypeField
	private String valorTipoAsignacion;
	
	private Integer codigoEstadoConsolidado;
	

	
	@ComparatorTypeField
	private String valorEstadoConsolidado;
	
	@ComparatorTypeField
	@Column(nullable = false)
	private String estado;
	
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
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOFACTURA", insertable = false, updatable = false, referencedColumnName = "CODIGOFACTURA") })
	private FacturaDTO factura;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOFACTURARELACIONADA", insertable = false, updatable = false, referencedColumnName = "CODIGOFACTURA") })
	private FacturaDTO facturaRelacionadaProveedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOTIPOASIGNACION", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO"),
		@JoinColumn(name="VALORTIPOASIGNACION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false)
		})
	private CatalogoValorDTO tipoAsignacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOESTADOCONSOLIDADO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO"),
		@JoinColumn(name="VALORESTADOCONSOLIDADO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false)
		})
	private CatalogoValorDTO estadoConsolidado;

	/**
	 * @return the id
	 */
	public FacturaRelacionadaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(FacturaRelacionadaID id) {
		this.id = id;
	}

	/**
	 * @return the codigoTipoAsignacion
	 */
	public Integer getCodigoTipoAsignacion() {
		return codigoTipoAsignacion;
	}

	/**
	 * @param codigoTipoAsignacion the codigoTipoAsignacion to set
	 */
	public void setCodigoTipoAsignacion(Integer codigoTipoAsignacion) {
		this.codigoTipoAsignacion = codigoTipoAsignacion;
	}

	/**
	 * @return the valorTipoAsignacion
	 */
	public String getValorTipoAsignacion() {
		return valorTipoAsignacion;
	}

	/**
	 * @param valorTipoAsignacion the valorTipoAsignacion to set
	 */
	public void setValorTipoAsignacion(String valorTipoAsignacion) {
		this.valorTipoAsignacion = valorTipoAsignacion;
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
	 * @return the factura
	 */
	public FacturaDTO getFactura() {
		return factura;
	}

	/**
	 * @param factura the factura to set
	 */
	public void setFactura(FacturaDTO factura) {
		this.factura = factura;
	}

	public FacturaDTO getFacturaRelacionadaProveedor() {
		return facturaRelacionadaProveedor;
	}

	public void setFacturaRelacionadaProveedor(FacturaDTO facturaRelacionadaProveedor) {
		this.facturaRelacionadaProveedor = facturaRelacionadaProveedor;
	}

	/**
	 * @return the codigoEstadoConsolidado
	 */
	public Integer getCodigoEstadoConsolidado() {
		return codigoEstadoConsolidado;
	}

	/**
	 * @param codigoEstadoConsolidado the codigoEstadoConsolidado to set
	 */
	public void setCodigoEstadoConsolidado(Integer codigoEstadoConsolidado) {
		this.codigoEstadoConsolidado = codigoEstadoConsolidado;
	}

	/**
	 * @return the valorEstadoConsolidado
	 */
	public String getValorEstadoConsolidado() {
		return valorEstadoConsolidado;
	}

	/**
	 * @param valorEstadoConsolidado the valorEstadoConsolidado to set
	 */
	public void setValorEstadoConsolidado(String valorEstadoConsolidado) {
		this.valorEstadoConsolidado = valorEstadoConsolidado;
	}

	/**
	 * @return the tipoAsignacion
	 */
	public CatalogoValorDTO getTipoAsignacion() {
		return tipoAsignacion;
	}

	/**
	 * @param tipoAsignacion the tipoAsignacion to set
	 */
	public void setTipoAsignacion(CatalogoValorDTO tipoAsignacion) {
		this.tipoAsignacion = tipoAsignacion;
	}

	/**
	 * @return the estadoConsolidado
	 */
	public CatalogoValorDTO getEstadoConsolidado() {
		return estadoConsolidado;
	}

	/**
	 * @param estadoConsolidado the estadoConsolidado to set
	 */
	public void setEstadoConsolidado(CatalogoValorDTO estadoConsolidado) {
		this.estadoConsolidado = estadoConsolidado;
	}


}
