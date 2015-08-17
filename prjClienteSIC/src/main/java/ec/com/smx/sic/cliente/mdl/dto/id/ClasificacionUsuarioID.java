package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ClasificacionUsuario
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.ClasificacionUsuario
 * 
 * @author kruger
 */
@Embeddable
public class ClasificacionUsuarioID implements Serializable {

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
	@Column(name = "USERID", nullable = false)
	private String userId;

	public ClasificacionUsuarioID() {}
	
	public ClasificacionUsuarioID(Boolean initID) {
		if(initID){
			codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			codigoClasificacion = SICConstantes.getInstancia().VALOR_INICIAL_ID;
			userId = SICConstantes.getInstancia().VALOR_INICIAL_ID;
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

	/**
	 * Retorna valor de propiedad <code>userId</code>
	 * 
	 * @return Retorna valor de propiedad <code>userId</code>
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>userId</code>.
	 * 
	 * @param userId1
	 *            El valor a establecer para la propiedad <code>userId</code>.
	 */
	public void setUserId(String userId1) {
		this.userId = userId1;

		if (userId != null && userId.length() > 32) {
			userId = userId.substring(0, 32);
		}

	}

}
