
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.SICConstantes;
/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloRelacion
 * @see ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacion
 *
 * @author kruger
 */
@Embeddable
@SuppressWarnings("serial")
public class ArticuloRelacionID implements Serializable {


	public ArticuloRelacionID() {}
	
	public ArticuloRelacionID(Boolean initID) {
		if(initID){
			codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			codigoArticulo = SICConstantes.getInstancia().VALOR_INICIAL_ID;
			codigoArticuloRelacionado= SICConstantes.getInstancia().VALOR_INICIAL_ID;
		}
	}


	/**
	 * Codigo de la companía
	 *

	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	

	/**
	 * Código de artículo, almacena el código secuencial de un artículo
	 *

	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo ;
		
	

	/**
	 * Código de artículo, almacena el código secuencial de un artículo
	 *

	 */
		
	@Column(name = "CODIGOARTICULORELACIONADO", nullable = false)
	private String codigoArticuloRelacionado ;
		
	

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
	 * Retorna valor de propiedad <code>codigoArticulo</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoArticulo</code>
	 */
	public String getCodigoArticulo(){
		return this.codigoArticulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoArticulo</code>.
	 * @param codigoArticulo1 
	 *		El valor a establecer para la propiedad <code>codigoArticulo</code>.
	 */
	public void setCodigoArticulo( String codigoArticulo1 ){
		this.codigoArticulo=codigoArticulo1;
		
		if(codigoArticulo!=null && codigoArticulo.length()>20){
			codigoArticulo = codigoArticulo.substring(0,20);
		}
				
				
	}

		

	/**
	 * Retorna valor de propiedad <code>codigoArticuloRelacionado</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoArticuloRelacionado</code>
	 */
	public String getCodigoArticuloRelacionado(){
		return this.codigoArticuloRelacionado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoArticuloRelacionado</code>.
	 * @param codigoArticuloRelacionado1 
	 *		El valor a establecer para la propiedad <code>codigoArticuloRelacionado</code>.
	 */
	public void setCodigoArticuloRelacionado( String codigoArticuloRelacionado1 ){
		this.codigoArticuloRelacionado=codigoArticuloRelacionado1;
		
		if(codigoArticuloRelacionado!=null && codigoArticuloRelacionado.length()>20){
			codigoArticuloRelacionado = codigoArticuloRelacionado.substring(0,20);
		}
				
				
	}

		


}

