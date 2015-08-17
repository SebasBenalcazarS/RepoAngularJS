package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.corpv2.dto.id.BaseID;
import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Parametro
 * 
 * @see ec.com.smx.sic.sispe.dto.Parametro
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class ParametroID extends BaseID {

	/**
	 * Codigo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Codigo del parametro
	 */
	@Column(name = "CODIGOPARAMETRO", nullable = false)
	private String codigoParametro;

	public ParametroID() {}
	public ParametroID(Boolean initID) {
		if(initID){
			codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			codigoParametro = SICConstantes.getInstancia().VALOR_INICIAL_ID;
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
	 * Retorna valor de propiedad <code>codigoParametro</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoParametro</code>
	 */
	public String getCodigoParametro() {
		return this.codigoParametro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoParametro</code>.
	 * 
	 * @param codigoParametro1
	 *            El valor a establecer para la propiedad <code>codigoParametro</code>.
	 */
	public void setCodigoParametro(String codigoParametro1) {
		this.codigoParametro = codigoParametro1;
	}

}
