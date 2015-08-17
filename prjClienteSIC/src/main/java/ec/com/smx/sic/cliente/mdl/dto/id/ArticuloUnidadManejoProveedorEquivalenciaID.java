/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author guvidia
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloUnidadManejoProveedorEquivalenciaID implements Serializable{

	/**
	 * C&oacute;digo de la compa&ntilde;&iacute;a
	 */
	@Column(name = "CODIGOCOMPANIAARTUNIMANPRO", nullable = false)
	private Integer codigoCompaniaArtUniManPro;
	
	@Column(name = "CODIGOCOMPANIAEQUPORDES", nullable = false)
	private Integer codigoCompaniaEquPorDes;
	
	@Column(name = "CODIGOUNIDADMANEJO", nullable = false)
	private Long codigoUnidadManejo;

	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;
	
	@Column(name = "CODIGOEQUIVALENCIA", nullable = false)
	private Integer codigoEquivalencia;

	/**
	 * @return the codigoCompaniaArtUniManPro
	 */
	public Integer getCodigoCompaniaArtUniManPro() {
		return codigoCompaniaArtUniManPro;
	}

	/**
	 * @param codigoCompaniaArtUniManPro the codigoCompaniaArtUniManPro to set
	 */
	public void setCodigoCompaniaArtUniManPro(Integer codigoCompaniaArtUniManPro) {
		this.codigoCompaniaArtUniManPro = codigoCompaniaArtUniManPro;
	}

	/**
	 * @return the codigoCompaniaEquPorDes
	 */
	public Integer getCodigoCompaniaEquPorDes() {
		return codigoCompaniaEquPorDes;
	}

	/**
	 * @param codigoCompaniaEquPorDes the codigoCompaniaEquPorDes to set
	 */
	public void setCodigoCompaniaEquPorDes(Integer codigoCompaniaEquPorDes) {
		this.codigoCompaniaEquPorDes = codigoCompaniaEquPorDes;
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
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	/**
	 * @return the codigoEquivalencia
	 */
	public Integer getCodigoEquivalencia() {
		return codigoEquivalencia;
	}

	/**
	 * @param codigoEquivalencia the codigoEquivalencia to set
	 */
	public void setCodigoEquivalencia(Integer codigoEquivalencia) {
		this.codigoEquivalencia = codigoEquivalencia;
	}

}
