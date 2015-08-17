/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloUnidadManejoProveedorEquivalenciaID;

/**
 * @author guvidia
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTARTUNIMANPROEQU")
public class ArticuloUnidadManejoProveedorEquivalenciaDTO extends AuditoriaBaseDTO {
		
	@EmbeddedId
	private ArticuloUnidadManejoProveedorEquivalenciaID id = new ArticuloUnidadManejoProveedorEquivalenciaID();
	
	@Column(name="ESTADO")
	private String estado;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIAARTUNIMANPRO", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),		
		@JoinColumn(name="CODIGOUNIDADMANEJO", referencedColumnName="CODIGOUNIDADMANEJO", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedor;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIAEQUPORDES", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOEQUIVALENCIA", insertable=false, updatable=false, referencedColumnName="CODIGOEQUIVALENCIA")})
	private EquivalenciaPorcentajeDescuentoDTO equivalenciaPorcentajeDescuento;

	/**
	 * @return the articuloUnidadManejoProveedor
	 */
	public ArticuloUnidadManejoProveedorDTO getArticuloUnidadManejoProveedor() {
		return articuloUnidadManejoProveedor;
	}

	/**
	 * @param articuloUnidadManejoProveedor the articuloUnidadManejoProveedor to set
	 */
	public void setArticuloUnidadManejoProveedor(ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedor) {
		this.articuloUnidadManejoProveedor = articuloUnidadManejoProveedor;
	}

	/**
	 * @return the equivalenciaPorcentajeDescuento
	 */
	public EquivalenciaPorcentajeDescuentoDTO getEquivalenciaPorcentajeDescuento() {
		return equivalenciaPorcentajeDescuento;
	}

	/**
	 * @param equivalenciaPorcentajeDescuento the equivalenciaPorcentajeDescuento to set
	 */
	public void setEquivalenciaPorcentajeDescuento(EquivalenciaPorcentajeDescuentoDTO equivalenciaPorcentajeDescuento) {
		this.equivalenciaPorcentajeDescuento = equivalenciaPorcentajeDescuento;
	}

	/**
	 * @return the id
	 */
	public ArticuloUnidadManejoProveedorEquivalenciaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloUnidadManejoProveedorEquivalenciaID id) {
		this.id = id;
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

}
