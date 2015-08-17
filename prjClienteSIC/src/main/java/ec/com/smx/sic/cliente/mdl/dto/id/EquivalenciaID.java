/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author srivera
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class EquivalenciaID implements Serializable{

	/**
	 * Codigo de la compañía
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	

	/**
	 * Codigo del tipo de equivalencia
	 *
	 */
	@Column(name = "CODTIPEQU", nullable = false)
	private Integer codigoTipoEquivalencia ;
		
	

	/**
	 * Código equivalente en el MAX para un valor dado en el SIC

	 */
	@Column(name = "CODEQUMAX", nullable = false)
	private String codigoEquivalenciaMax ;
		
	
	/**
	 * Código equivalente en el SIC para un valor dado en el MAX
	 * 
	 */
	@Column(name="CODEQUSIC")
	private String codigoEquivalenciaSic;
	
	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania(){
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * @param codigoCompania1 
	 *		El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania( Integer codigoCompania1 ){
		this.codigoCompania=codigoCompania1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>codigoTipoEquivalencia</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoTipoEquivalencia</code>
	 */
	public Integer getCodigoTipoEquivalencia(){
		return this.codigoTipoEquivalencia;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoEquivalencia</code>.
	 * @param codigoTipoEquivalencia1 
	 *		El valor a establecer para la propiedad <code>codigoTipoEquivalencia</code>.
	 */
	public void setCodigoTipoEquivalencia( Integer codigoTipoEquivalencia1 ){
		this.codigoTipoEquivalencia=codigoTipoEquivalencia1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>codigoEquivalenciaMax</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoEquivalenciaMax</code>
	 */
	public String getCodigoEquivalenciaMax(){
		return this.codigoEquivalenciaMax;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoEquivalenciaMax</code>.
	 * @param codigoEquivalenciaMax1 
	 *		El valor a establecer para la propiedad <code>codigoEquivalenciaMax</code>.
	 */
	public void setCodigoEquivalenciaMax( String codigoEquivalenciaMax1 ){
		this.codigoEquivalenciaMax=codigoEquivalenciaMax1;	
				
	}

	/**
	 * @return the codigoEquivalenciaSic
	 */
	public String getCodigoEquivalenciaSic() {
		return codigoEquivalenciaSic;
	}

	/**
	 * @param codigoEquivalenciaSic the codigoEquivalenciaSic to set
	 */
	public void setCodigoEquivalenciaSic(String codigoEquivalenciaSic) {
		this.codigoEquivalenciaSic = codigoEquivalenciaSic;
	}

}
