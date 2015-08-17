package ec.com.smx.sic.cliente.mdl.dto.id.b2b;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArchivoTipo
 * @see ec.com.smx.b2b.dto.ArchivoTipo
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
@Deprecated
public class ArchivoTipoID implements Serializable
{

	/**
	 * codigo asignado al tipo de archivo
	 *
	 */
	private String codigoArchivoTipo ;

	/**
	 * Retorna valor de propiedad <code>codigoArchivoTipo</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoArchivoTipo</code>
	 */
	public String getCodigoArchivoTipo()
	{
		return this.codigoArchivoTipo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoArchivoTipo</code>.
	 * @param codigoArchivoTipo1 
	 *		El valor a establecer para la propiedad <code>codigoArchivoTipo</code>.
	 */
	public void setCodigoArchivoTipo( String codigoArchivoTipo1 )
	{
		this.codigoArchivoTipo=codigoArchivoTipo1;
		
		if(codigoArchivoTipo!=null && codigoArchivoTipo.length()>3)
		{
			codigoArchivoTipo = codigoArchivoTipo.substring(0,3);
		}
			
	}

	/* (sin Javadoc)
	 * @see ec.com.smx.b2b.commons.dto.id.AbstractaID#configureColIds()
	 */
	/*public void configureColIds()
	{
		super.resetCollection();
	    
		super.addElement(this.codigoArchivoTipo);	    	
		    
		super.collectionToArray();
	}*/

}

