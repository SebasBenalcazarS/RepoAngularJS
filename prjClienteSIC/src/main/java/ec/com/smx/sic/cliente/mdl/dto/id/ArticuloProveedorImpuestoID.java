package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ArticuloProveedorImpuestoID implements Serializable {
	/**
	 * Codigo de la companía
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Código de artículo
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	/**
	 * Código del proveedor
	 */
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;
	
	/**
	 * Secuencial del tipo de impuesto
	 */
	@Column(name = "CODIGOTIPOIMPUESTO", nullable = false)
	private Integer codigoTipoImpuesto;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}	

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return the codigoTipoImpuesto
	 */
	public Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}

	/**
	 * @param codigoTipoImpuesto the codigoTipoImpuesto to set
	 */
	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
	}
}
