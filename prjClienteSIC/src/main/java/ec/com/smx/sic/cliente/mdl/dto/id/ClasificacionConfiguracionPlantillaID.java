package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ClasificacionUsuario
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.ClasificacionUsuario
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class ClasificacionConfiguracionPlantillaID implements Serializable {

	/**
	 * El código de la compañía
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Código de la clasificación
	 * 
	 */
	@Column(name = "CODIGOCLASIFICACION", nullable = false)
	private String codigoClasificacion;

	/**
	 * Id. del usuario
	 * 
	 */
	@Column(name = "CODIGOCONFIGURACIONPLANTILLA", nullable = false)
	private Integer codigoConfiguracionPlantilla;

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
	}

	/**
	 * @return the codigoConfiguracionPlantilla
	 */
	public Integer getCodigoConfiguracionPlantilla() {
		return codigoConfiguracionPlantilla;
	}

	/**
	 * @param codigoConfiguracionPlantilla the codigoConfiguracionPlantilla to set
	 */
	public void setCodigoConfiguracionPlantilla(Integer codigoConfiguracionPlantilla) {
		this.codigoConfiguracionPlantilla = codigoConfiguracionPlantilla;
	}



}
