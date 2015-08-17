package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.MonedaDTO;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;

/**
 * Contiene datos del articulo importado
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTPROIMP")
public class ArticuloImportacionDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProveedorID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProveedorID();

	/**
	 * Indica la referencia al codigo de la moneda
	 */
	private Long codigoMonedaOrigen;

	/**
	 * Indica el valor del costo
	 * 
	 */
	private BigDecimal costoMonedaOrigen;
	/**
	 * descripcion del articulo en el sistema de importaciones
	 */
	private String descripcionArticulo;
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(insertable=true,updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column(insertable=true,updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	/**
	 * Procentaje de la comision de importacion que se aplica al costo moneda origen
	 */
	private Double porcentajeComision;
	
	@Column(name="VALORFACTOR",nullable=true)
	private Double valorFactor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHAAPLICACIONFACTOR",nullable=true)
	private Date fechaAplicacionFactor;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO articuloProveedor;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name="CODIGOMONEDAORIGEN", insertable=false, updatable=false, referencedColumnName="CODIGOMONEDA")
	private MonedaDTO monedaOrigen;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProveedorID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProveedorID id1) {
		this.id = id1;
	}


	/**
	 * Retorna valor de propiedad <code>costoMonedaOrigen</code>
	 * 
	 * @return Retorna valor de propiedad <code>costoMonedaOrigen</code>
	 */
	public BigDecimal getCostoMonedaOrigen() {
		return this.costoMonedaOrigen;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>costoMonedaOrigen</code>.
	 * 
	 * @param costoMonedaOrigen1
	 *            El valor a establecer para la propiedad <code>costoMonedaOrigen</code>.
	 */
	public void setCostoMonedaOrigen(BigDecimal costoMonedaOrigen1) {
		this.costoMonedaOrigen = costoMonedaOrigen1;

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion() {
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

	}

	/**
	 * @return the articuloProveedor
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO getArticuloProveedor() {
		return articuloProveedor;
	}

	/**
	 * @param articuloProveedor the articuloProveedor to set
	 */
	public void setArticuloProveedor(ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO articuloProveedor) {
		this.articuloProveedor = articuloProveedor;
	}

	/**
	 * @return the codigoMonedaOrigen
	 */
	public Long getCodigoMonedaOrigen() {
		return codigoMonedaOrigen;
	}

	/**
	 * @param codigoMonedaOrigen the codigoMonedaOrigen to set
	 */
	public void setCodigoMonedaOrigen(Long codigoMonedaOrigen) {
		this.codigoMonedaOrigen = codigoMonedaOrigen;
	}

	/**
	 * @return the monedaOrigen
	 */
	public MonedaDTO getMonedaOrigen() {
		return monedaOrigen;
	}

	/**
	 * @param monedaOrigen the monedaOrigen to set
	 */
	public void setMonedaOrigen(MonedaDTO monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	/**
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	/**
	 * @return the porcentajeComision
	 */
	public Double getPorcentajeComision() {
		return porcentajeComision;
	}

	/**
	 * @param porcentajeComision the porcentajeComision to set
	 */
	public void setPorcentajeComision(Double porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}

	public BigDecimal getCostoDerechoImportacion(){
		BigDecimal costoDerechoImportacion = this.porcentajeComision == null ? this.costoMonedaOrigen : this.costoMonedaOrigen.multiply(new BigDecimal(1 + this.porcentajeComision/100)).setScale(4, BigDecimal.ROUND_HALF_UP);
		return costoDerechoImportacion;
	}
	
	public BigDecimal getCostoDerechoImportacionImp(){
		BigDecimal costoDerechoImportacion = this.porcentajeComision == null ? this.costoMonedaOrigen : this.costoMonedaOrigen.multiply(new BigDecimal(1 + this.porcentajeComision/100)).setScale(4, BigDecimal.ROUND_HALF_UP);
		Map<String, Double> valoresImpuestos = this.getTieneArticuloProveedor() && this.articuloProveedor.getTieneArticuloProveedorImpuestos() ? SICArticuloCalculo.getInstancia().obtenerValoresImpuestoProveedor(this.articuloProveedor.getArticuloProveedorImpuestoCol(), Boolean.FALSE) : null;
		if(valoresImpuestos != null){
			costoDerechoImportacion = SICArticuloCalculo.getInstancia().calcularValorConImpuestos(costoDerechoImportacion, valoresImpuestos, Boolean.FALSE);
		}
		return costoDerechoImportacion;
	}

	public Double getValorFactor() {
		return valorFactor;
	}

	public void setValorFactor(Double valorFactor) {
		this.valorFactor = valorFactor;
	}

	public Date getFechaAplicacionFactor() {
		return fechaAplicacionFactor;
	}

	public void setFechaAplicacionFactor(Date fechaAplicacionFactor) {
		this.fechaAplicacionFactor = fechaAplicacionFactor;
	}
	
	public Boolean getTieneArticuloProveedor(){
		return isLoaded(articuloProveedor) ;
	}
	
	public BigDecimal getCostoMonedaOrigenImp() {
		Map<String, Double> valoresImpuestos = this.getTieneArticuloProveedor() && this.articuloProveedor.getTieneArticuloProveedorImpuestos() ? SICArticuloCalculo.getInstancia().obtenerValoresImpuestoProveedor(this.articuloProveedor.getArticuloProveedorImpuestoCol(), Boolean.FALSE) : null;
		if(valoresImpuestos !=null)
			return SICArticuloCalculo.getInstancia().calcularValorConImpuestos(costoMonedaOrigen, valoresImpuestos, Boolean.FALSE);
		return costoMonedaOrigen;
	}
}
