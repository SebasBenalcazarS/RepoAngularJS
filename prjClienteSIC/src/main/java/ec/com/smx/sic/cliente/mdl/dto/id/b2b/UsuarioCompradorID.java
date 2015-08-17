
package ec.com.smx.sic.cliente.mdl.dto.id.b2b;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase UsuarioComprador
 * @see ec.com.smx.b2b.dto.UsuarioComprador
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
@Deprecated
public class UsuarioCompradorID  implements Serializable {


	/**
	 * identificador del usuario
	 */
	@Column(name="userId")
	private String userId ;

	/**
	 * codigo del comprador
	 *
	 */
	@Column(name="codigoComprador")
	private String codigoComprador ;
		
	

	/**
	 * codigo de la compania
	 *
	 */
	@Column(name="codigoCompania")
	private Integer codigoCompania ;
		
	

	/**
	 * Retorna valor de propiedad <code>userId</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>userId</code>
	 */
	public String getUserId()
	{
		return this.userId;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>userId</code>.
	 * @param userId1 
	 *		El valor a establecer para la propiedad <code>userId</code>.
	 */
	public void setUserId( String userId1 )
	{
		this.userId=userId1;
		
		if(userId!=null && userId.length()>32){
			userId = userId.substring(0,32);
		}
			
	}

		

	/**
	 * Retorna valor de propiedad <code>codigoComprador</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoComprador</code>
	 */
	public String getCodigoComprador()
	{
		return this.codigoComprador;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoComprador</code>.
	 * @param codigoComprador1 
	 *		El valor a establecer para la propiedad <code>codigoComprador</code>.
	 */
	public void setCodigoComprador( String codigoComprador1 )
	{
		this.codigoComprador=codigoComprador1;
		
		if(codigoComprador!=null && codigoComprador.length()>10)
		{
			codigoComprador = codigoComprador.substring(0,10);
		}
			
	}

		

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania()
	{
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * @param codigoCompania1 
	 *		El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania( Integer codigoCompania1 )
	{
		this.codigoCompania=codigoCompania1;
		
	}

}

