/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;


/**
 * Actualizaci�n de datos de garantia cuando es cambiado desde el SICMER
 * @author xmino
 *
 */
@SuppressWarnings("serial")
public class ImpresionMasivaCaracteristicasMercanciaGetFtpVO implements Serializable {
	
	private String marcaDefault;
	
	private Integer tipoEtiqueta;	
	
	private Integer cantidadEtiquetas;
	
	private String codigoArticulo;
	
	private Integer complemento;

	public Integer getComplemento() {
		return complemento;
	}

	public void setComplemento(Integer complemento) {
		this.complemento = complemento;
	}

	public String getMarcaDefault() {
		return marcaDefault;
	}

	public void setMarcaDefault(String marcaDefault) {
		this.marcaDefault = marcaDefault;
	}

	public Integer getTipoEtiqueta() {
		return tipoEtiqueta;
	}

	public void setTipoEtiqueta(Integer tipoEtiqueta) {
		this.tipoEtiqueta = tipoEtiqueta;
	}

	public Integer getCantidadEtiquetas() {
		return cantidadEtiquetas;
	}

	public void setCantidadEtiquetas(Integer cantidadEtiquetas) {
		this.cantidadEtiquetas = cantidadEtiquetas;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	
}
