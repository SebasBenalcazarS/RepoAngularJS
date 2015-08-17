/**
 * 
 */
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

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloOfertaProveedorID;

/**
 * @author gnolivos
 *
 */
@Entity
@Table(name="SCFRUTARTOFEPRO")
@SuppressWarnings("serial")
public class ArticuloOfertaProveedorDTO extends AuditoriaBaseDTO{
	
	@EmbeddedId
	private ArticuloOfertaProveedorID id = new ArticuloOfertaProveedorID();
	
	@Column(name = "CODIGOFECHAOFERTA", nullable = false)
	private Long codigoFechaOferta;
	
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;
	
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;
	
	@Column(name = "CODIGOUNIDADMANEJO", nullable = false)
	private Long codigoUnidadManejo;
	
	
	@Column(name = "CANTIDAD")
	private Integer cantidad;
	
	@Column(name = "PESO")
	private BigDecimal peso;
	
	@ComparatorTypeField
	@Column (name = "ESTADO", nullable = false)
	private String estado;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloProveedorDTO articuloProveedor;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOFECHAOFERTA", referencedColumnName="CODIGOFECHAOFERTA", insertable=false, updatable=false)})
	private FechaOfertaProveedorDTO fechaOfertaProveedor;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOUNIDADMANEJO", referencedColumnName="CODIGOUNIDADMANEJO", insertable=false, updatable=false)})
	private ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTO;
	
	/**
	 * @return the id
	 */
	public ArticuloOfertaProveedorID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloOfertaProveedorID id) {
		this.id = id;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the peso
	 */
	public BigDecimal getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
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
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return the codigoFechaOferta
	 */
	public Long getCodigoFechaOferta() {
		return codigoFechaOferta;
	}

	/**
	 * @param codigoFechaOferta the codigoFechaOferta to set
	 */
	public void setCodigoFechaOferta(Long codigoFechaOferta) {
		this.codigoFechaOferta = codigoFechaOferta;
	}

	/**
	 * @return the articuloProveedor
	 */
	public ArticuloProveedorDTO getArticuloProveedor() {
		return articuloProveedor;
	}

	/**
	 * @param articuloProveedor the articuloProveedor to set
	 */
	public void setArticuloProveedor(ArticuloProveedorDTO articuloProveedor) {
		this.articuloProveedor = articuloProveedor;
	}

	public FechaOfertaProveedorDTO getFechaOfertaProveedor() {
		return fechaOfertaProveedor;
	}

	public void setFechaOfertaProveedor(FechaOfertaProveedorDTO fechaOfertaProveedor) {
		this.fechaOfertaProveedor = fechaOfertaProveedor;
	}

	public ArticuloUnidadManejoProveedorDTO getArticuloUnidadManejoProveedorDTO() {
		return articuloUnidadManejoProveedorDTO;
	}

	public void setArticuloUnidadManejoProveedorDTO(ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTO) {
		this.articuloUnidadManejoProveedorDTO = articuloUnidadManejoProveedorDTO;
	}

	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}
	
	
	
}
