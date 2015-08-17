package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.StringUtils;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloBitacoraCodigoBarras
 * 
 * @see ec.com.smx.sic.adm.dto.ArticuloBitacoraCodigoBarras
 * 
 * @author fmunoz
 */
@Embeddable
@SuppressWarnings("serial")
public class ArticuloBitacoraCodigoBarrasID implements Serializable, Cloneable{

	/**
	 * C&oacute;digo de la compa&ntilde;&iacute;a
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * C&oacute;digo de art&iacute;culo, almacena el c&oacute;digo secuencial de un art&iacute;culo
	 * 
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;
	/**
	 * Almacena el c&oacute;digo de barras del art&iacute;culo
	 * 
	 */
	@Column(name = "CODIGOBARRAS", nullable = false)
	private String codigoBarras;
	/**
	 * Fecha de inicio de activaci&oacute;n del art&iacute;culo
	 */
	@Column(name = "FECHAINICIALACTIVO", nullable = false)
	private Date fechaInicialActivo;
	
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
	 * Retorna valor de propiedad <code>codigoArticulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoArticulo</code>
	 */
	public String getCodigoArticulo() {
		return this.codigoArticulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoArticulo</code>.
	 * 
	 * @param codigoArticulo1
	 *            El valor a establecer para la propiedad <code>codigoArticulo</code>.
	 */
	public void setCodigoArticulo(String codigoArticulo1) {
		this.codigoArticulo = codigoArticulo1;

		if (codigoArticulo != null && codigoArticulo.length() > 20) {
			codigoArticulo = codigoArticulo.substring(0, 20);
		}
	}

	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}

	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = StringUtils.stripStart(codigoBarras,"0");
	}

	/**
	 * @return the fechaInicialActivo
	 */
	public Date getFechaInicialActivo() {
		return fechaInicialActivo;
	}

	/**
	 * @param fechaInicialActivo the fechaInicialActivo to set
	 */
	public void setFechaInicialActivo(Date fechaInicialActivo) {
		this.fechaInicialActivo = fechaInicialActivo;
	}

	public ArticuloBitacoraCodigoBarrasID clone() throws CloneNotSupportedException{
		return (ArticuloBitacoraCodigoBarrasID)super.clone();
	}
}
