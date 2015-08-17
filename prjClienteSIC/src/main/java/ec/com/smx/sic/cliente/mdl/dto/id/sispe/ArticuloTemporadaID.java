
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloTemporada
 * @see ec.com.smx.sic.sispe.dto.ArticuloTemporada
 * @author osaransig
 * 21/06/2012
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloTemporadaID extends BaseID implements Serializable, Cloneable {




	/**
	 * codigoCompania
	 *

	 */
	@Column(name = "CODIGOCOMPANIA") 
	private Integer codigoCompania ;
		
	

	/**
	 * codigoTemporada
	 *

	 */
	@Column(name = "CODIGOTEMPORADA")
	private java.lang.Long codigoTemporada ;
		
	

	/**
	 * codigoArticulo
	 *

	 */
	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo ;
		
	
	/**
	 * codigoProveedor
	 *

	 */
	@Column(name = "CODIGOPROVEEDOR")
	private String codigoProveedor;

	
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
	 * Retorna valor de propiedad <code>codigoTemporada</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoTemporada</code>
	 */
	public java.lang.Long getCodigoTemporada(){
		return this.codigoTemporada;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTemporada</code>.
	 * @param codigoTemporada1 
	 *		El valor a establecer para la propiedad <code>codigoTemporada</code>.
	 */
	public void setCodigoTemporada( java.lang.Long codigoTemporada1 ){
		this.codigoTemporada=codigoTemporada1;
		
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

	@Override
	public Object clone() throws CloneNotSupportedException {
		
		ArticuloTemporadaID clon = null;
		try{
			clon = (ArticuloTemporadaID)super.clone();
		}catch(CloneNotSupportedException ex){
			throw new SICException("Clase no soportada",ex);
		}
		return clon;
		
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}


}

