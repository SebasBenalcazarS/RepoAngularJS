package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ProveedorFinanciero
 * @see ec.com.smx.sic.adm.dto.ProveedorFinanciero
 *
 * @author kruger
 */
@Embeddable
@SuppressWarnings("serial")
public class ProveedorMarcaID implements Serializable {

	/**
	 * Código de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;

	/**
	 * Código del proveedor
	 *
	 */
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor ;
	
	/**
	 * Codigo de la Marca
	 *
	 */
	@Column(name = "SECUENCIALMARCA", nullable = false)
	private java.lang.Long secuencialMarca;
		
	

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
	 * Retorna valor de propiedad <code>codigoProveedor</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoProveedor</code>
	 */
	public String getCodigoProveedor(){
		return this.codigoProveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoProveedor</code>.
	 * @param codigoProveedor1 
	 *		El valor a establecer para la propiedad <code>codigoProveedor</code>.
	 */
	public void setCodigoProveedor( String codigoProveedor1 ){
		this.codigoProveedor=codigoProveedor1;
		
		if(codigoProveedor!=null && codigoProveedor.length()>10){
			codigoProveedor = codigoProveedor.substring(0,10);
		}
	}
	

	/**
	 * Retorna valor de propiedad <code>secuencialMarca</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>secuencialMarca</code>
	 */
	public Long getSecuencialMarca(){
		return this.secuencialMarca;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>secuencialMarca</code>.
	 * @param codigoMarca1 
	 *		El valor a establecer para la propiedad <code>secuencialMarca</code>.
	 */
	public void setSecuencialMarca( Long secuencialMarca ){
		this.secuencialMarca=secuencialMarca;
		
	}
	
}


