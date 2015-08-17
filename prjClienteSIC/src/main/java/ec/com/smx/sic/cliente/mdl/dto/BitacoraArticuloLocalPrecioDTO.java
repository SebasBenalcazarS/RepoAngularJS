
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.BitacoraArticuloLocalPrecioID;

/**
 * 
 * @author guvidia
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTBITARTLOCPRE")
public class BitacoraArticuloLocalPrecioDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private BitacoraArticuloLocalPrecioID id = new BitacoraArticuloLocalPrecioID();

	/**
	 * Identificador &uacute;nico del art&iacute;culo
	 */
	@ComparatorTypeField
	private String codigoArticulo;
	
	/**
	 * C&oacute;digo del tipo de precio
	 */
	@ComparatorTypeField
	@Column( name = "CODIGOAREATRABAJO")
	private Integer codigoLocal;
	
	@ComparatorTypeField
	private String codigoTipoPrecio;

	private Double valor;

	private java.util.Date fechaInicioActivo;
	
	private java.util.Date fechaFinActivo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOAREATRABAJO", referencedColumnName="CODIGOAREATRABAJO", insertable=false, updatable=false)})
	private AreaTrabajoDTO local;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOTIPOPRECIO", referencedColumnName="CODIGOTIPOPRECIO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.TipoPrecioArticuloDTO tipoPrecioArticulo;


	public BitacoraArticuloLocalPrecioID getId() {
		return id;
	}

	public void setId(BitacoraArticuloLocalPrecioID id) {
		this.id = id;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public Integer getCodigoLocal() {
		return codigoLocal;
	}

	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	public AreaTrabajoDTO getLocal() {
		return local;
	}

	public void setLocal(AreaTrabajoDTO local) {
		this.local = local;
	}

	public String getCodigoTipoPrecio() {
		return codigoTipoPrecio;
	}

	public void setCodigoTipoPrecio(String codigoTipoPrecio) {
		this.codigoTipoPrecio = codigoTipoPrecio;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public java.util.Date getFechaInicioActivo() {
		return fechaInicioActivo;
	}

	public void setFechaInicioActivo(java.util.Date fechaInicioActivo) {
		this.fechaInicioActivo = fechaInicioActivo;
	}

	public java.util.Date getFechaFinActivo() {
		return fechaFinActivo;
	}

	public void setFechaFinActivo(java.util.Date fechaFinActivo) {
		this.fechaFinActivo = fechaFinActivo;
	}

	public ec.com.smx.sic.cliente.mdl.dto.TipoPrecioArticuloDTO getTipoPrecioArticulo() {
		return tipoPrecioArticulo;
	}

	public void setTipoPrecioArticulo(ec.com.smx.sic.cliente.mdl.dto.TipoPrecioArticuloDTO tipoPrecioArticulo) {
		this.tipoPrecioArticulo = tipoPrecioArticulo;
	}

	

}
