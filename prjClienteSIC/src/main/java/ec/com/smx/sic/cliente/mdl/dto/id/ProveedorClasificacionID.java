package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.SICConstantes;

@SuppressWarnings("serial")
@Embeddable
public class ProveedorClasificacionID implements Serializable {

	/**
	 * Código de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Código del proveedor
	 * 
	 */
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;

	/**
	 * Código de clasificación
	 * 
	 */
	@Column(name = "CODIGOCLASIFICACION", nullable = false)
	private String codigoClasificacion;

	public ProveedorClasificacionID() {}
	public ProveedorClasificacionID(Boolean initID) {
		if(initID){
			codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			codigoProveedor = SICConstantes.getInstancia().VALOR_INICIAL_ID;
			codigoClasificacion = SICConstantes.getInstancia().VALOR_INICIAL_ID;
		}
	}
	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * 
	 * @param codigoCompania1
	 *            El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}

	/**
	 * Retorna valor de propiedad <code>codigoProveedor</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoProveedor</code>
	 */
	public String getCodigoProveedor() {
		return this.codigoProveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoProveedor</code>.
	 * 
	 * @param codigoProveedor1
	 *            El valor a establecer para la propiedad <code>codigoProveedor</code>.
	 */
	public void setCodigoProveedor(String codigoProveedor1) {
		this.codigoProveedor = codigoProveedor1;

		if (codigoProveedor != null && codigoProveedor.length() > 10) {
			codigoProveedor = codigoProveedor.substring(0, 10);
		}

	}

	/**
	 * Retorna valor de propiedad <code>codigoClasificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoClasificacion</code>
	 */
	public String getCodigoClasificacion() {
		return this.codigoClasificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoClasificacion</code>.
	 * 
	 * @param codigoClasificacion1
	 *            El valor a establecer para la propiedad <code>codigoClasificacion</code>.
	 */
	public void setCodigoClasificacion(String codigoClasificacion1) {
		this.codigoClasificacion = codigoClasificacion1;

		if (codigoClasificacion != null && codigoClasificacion.length() > 10) {
			codigoClasificacion = codigoClasificacion.substring(0, 10);
		}

	}

}
