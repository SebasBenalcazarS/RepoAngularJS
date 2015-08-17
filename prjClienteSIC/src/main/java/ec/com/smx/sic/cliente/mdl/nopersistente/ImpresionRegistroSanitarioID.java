
package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.io.Serializable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ImpresionRegistroSanitario
 * @see ec.com.smx.sic.sispe.dto.ImpresionRegistroSanitario
 *
 * @author kruger
 */
@SuppressWarnings("serial")
public class ImpresionRegistroSanitarioID implements Serializable {

	/**
	 * Codigo del articulo
	 *
	 */
	private String codigoArticulo ;
		
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

}

