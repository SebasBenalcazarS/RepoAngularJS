
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloTemporadaDetalle
 * @see ec.com.smx.sic.sispe.dto.ArticuloTemporadaDetalle
 * @author osaransig
 * 21/06/2012
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloTemporadaDetalleID extends BaseID implements Serializable {




	/**
	 * codigoCompania
	 *

	 */
	@Column (name = "CODIGOCOMPANIA")
	private Integer codigoCompania ;
		
	

	/**
	 * codigoTemporada
	 *

	 */
	@Column (name = "CODIGOTEMPORADA")
	private java.lang.Long codigoTemporada ;
		
	

	/**
	 * codigoArticulo
	 *

	 */
	@Column (name = "CODIGOARTICULO")
	private String codigoArticulo ;
		
	
	/**
	 * codigoProveedor
	 *

	 */
	@Column (name = "CODIGOPROVEEDOR")
	private String codigoProveedor;

	/**
	 * codigoTipoStock
	 *

	 */
	@Column (name = "CODIGOTIPOSTOCK")
	private java.lang.Long codigoTipoStock ;
		
	

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

		

	/**
	 * Retorna valor de propiedad <code>codigoTipoStock</code>
	 * @return 	Retorna valor de propiedad <code>codigoTipoStock</code>
	 */
	public java.lang.Long getCodigoTipoStock(){
		return this.codigoTipoStock;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoStock</code>.
	 * @param codigoTipoStock1 
	 *		El valor a establecer para la propiedad <code>codigoTipoStock</code>.
	 */
	public void setCodigoTipoStock( java.lang.Long codigoTipoStock1 ){
		this.codigoTipoStock=codigoTipoStock1;
		
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

		

}

