package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.VistaDetalleListaProductoID;

@Entity
@Table(name = "SCSACVDETLISPRO")
public class VistaDetalleListaProductoDTO extends BaseDto<VistaDetalleListaProductoID>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5531103718947741594L;

	private String descripcionArticulo;
	
	@ComparatorTypeField
	private String codigoBarras;
	
	@ComparatorTypeField
	@Column(name = "codigoClasificacionRelacionada")
	private String codigoCategoria;

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

}
