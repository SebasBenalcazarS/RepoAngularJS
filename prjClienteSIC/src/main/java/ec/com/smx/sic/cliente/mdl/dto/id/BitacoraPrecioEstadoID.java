/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Victor Jaramillo
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class BitacoraPrecioEstadoID implements Serializable {

	@Column(name = "CODIGOCOMPANIA" , nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOPROVEEDOR" , nullable = false)
	private String codigoProveedor;
	
	@Column(name = "CODIGOBITACORAPRECIO" , nullable = false)
	private Long codigoBitacoraPrecio;
	
	@Column(name = "VALORTIPOESTADO" , nullable = false)
	private String valorTipoEstado;
	
	@Column(name = "CODIGOTIPOESTADO" , nullable = false)
	private Integer codigoTipoEstado;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
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
	 * @return the codigoBitacoraPrecio
	 */
	public Long getCodigoBitacoraPrecio() {
		return codigoBitacoraPrecio;
	}

	/**
	 * @param codigoBitacoraPrecio the codigoBitacoraPrecio to set
	 */
	public void setCodigoBitacoraPrecio(Long codigoBitacoraPrecio) {
		this.codigoBitacoraPrecio = codigoBitacoraPrecio;
	}

	/**
	 * @return the valorTipoEstado
	 */
	public String getValorTipoEstado() {
		return valorTipoEstado;
	}

	/**
	 * @param valorTipoEstado the valorTipoEstado to set
	 */
	public void setValorTipoEstado(String valorTipoEstado) {
		this.valorTipoEstado = valorTipoEstado;
	}

	/**
	 * @return the codigoTipoEstado
	 */
	public Integer getCodigoTipoEstado() {
		return codigoTipoEstado;
	}

	/**
	 * @param codigoTipoEstado the codigoTipoEstado to set
	 */
	public void setCodigoTipoEstado(Integer codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
	}
	
	
}
