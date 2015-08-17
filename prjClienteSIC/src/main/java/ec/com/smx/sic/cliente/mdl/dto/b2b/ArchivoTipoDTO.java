
package ec.com.smx.sic.cliente.mdl.dto.b2b;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.ArchivoTipoID;

/**
 * Tipos de archivo
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.b2b.ArchivoTipoDTO")
@Table(name = "SSB2BTARCHIVOTIPO")
@Deprecated
public class ArchivoTipoDTO extends SimpleAuditDTO
{

	/**
	 * Propiedad identificador 
	 * de tipo de archivo
	 *
	 */
	@EmbeddedId
	private ArchivoTipoID id = new ArchivoTipoID();

	/**
	 * Nombre del tipo de archivo
	 */
	private String nombreArchivoTipo ;

	/**
	 * Descripcion del tipo de archivo
	 */
	private String descripcionArchivoTipo ;

	/**
	 * Estado del tipo de archivo
	 *	1: esta Activo
	 *  0: esta Inactivo
	 *
	 */
	private String estadoArchivoTipo ;


	/**
	 * Extencion del tipo de archivo
	 *
	 */
	private String extencionArchivoTipo ;

	/**
	 * Determina un orden de precedencia de los tipos de archivos
	 *
	 */
	private Integer ordenArchivoTipo ;
	

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ArchivoTipoID getId()
	{
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ArchivoTipoID id1 )
	{
		this.id=id1;
	}


	/**
	 * Retorna valor de propiedad <code>nombreArchivoTipo</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>nombreArchivoTipo</code>
	 */
	public String getNombreArchivoTipo()
	{
		return this.nombreArchivoTipo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>nombreArchivoTipo</code>.
	 * @param nombreArchivoTipo1 
	 *		El valor a establecer para la propiedad <code>nombreArchivoTipo</code>.
	 */
	public void setNombreArchivoTipo( String nombreArchivoTipo1 )
	{
		this.nombreArchivoTipo=nombreArchivoTipo1;
		
		if(nombreArchivoTipo!=null && nombreArchivoTipo.length()>32){
			nombreArchivoTipo = nombreArchivoTipo.substring(0,32);
		}
			
	}

	/**
	 * Retorna valor de propiedad <code>descripcionArchivoTipo</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>descripcionArchivoTipo</code>
	 */
	public String getDescripcionArchivoTipo()
	{
		return this.descripcionArchivoTipo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descripcionArchivoTipo</code>.
	 * @param descripcionArchivoTipo1 
	 *		El valor a establecer para la propiedad <code>descripcionArchivoTipo</code>.
	 */
	public void setDescripcionArchivoTipo( String descripcionArchivoTipo1 )
	{
		this.descripcionArchivoTipo=descripcionArchivoTipo1;
		
		if(descripcionArchivoTipo!=null && descripcionArchivoTipo.length()>400)
		{
			descripcionArchivoTipo = descripcionArchivoTipo.substring(0,400);
		}
			
	}

	/**
	 * Retorna valor de propiedad <code>estadoArchivoTipo</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estadoArchivoTipo</code>
	 */
	public String getEstadoArchivoTipo()
	{
		return this.estadoArchivoTipo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoArchivoTipo</code>.
	 * @param estadoArchivoTipo1 
	 *		El valor a establecer para la propiedad <code>estadoArchivoTipo</code>.
	 */
	public void setEstadoArchivoTipo( String estadoArchivoTipo1 )
	{
		this.estadoArchivoTipo=estadoArchivoTipo1;
		
		if(estadoArchivoTipo!=null && estadoArchivoTipo.length()>1)
		{
			estadoArchivoTipo = estadoArchivoTipo.substring(0,1);
		}
			
	}

	/**
	 * Retorna valor de propiedad <code>extencionArchivoTipo</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>extencionArchivoTipo</code>
	 */
	public String getExtencionArchivoTipo()
	{
		return this.extencionArchivoTipo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>extencionArchivoTipo</code>.
	 * @param extencionArchivoTipo1 
	 *		El valor a establecer para la propiedad <code>extencionArchivoTipo</code>.
	 */
	public void setExtencionArchivoTipo( String extencionArchivoTipo1 )
	{
		this.extencionArchivoTipo=extencionArchivoTipo1;
		
		if(extencionArchivoTipo!=null && extencionArchivoTipo.length()>3)
		{
			extencionArchivoTipo = extencionArchivoTipo.substring(0,3);
		}
			
	}

	/**
	 * Retorna valor de propiedad <code>ordenArchivoTipo</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>ordenArchivoTipo</code>
	 */
	public Integer getOrdenArchivoTipo()
	{
		return this.ordenArchivoTipo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>ordenArchivoTipo</code>.
	 * @param ordenArchivoTipo1 
	 *		El valor a establecer para la propiedad <code>ordenArchivoTipo</code>.
	 */
	public void setOrdenArchivoTipo( Integer ordenArchivoTipo1 )
	{
		this.ordenArchivoTipo=ordenArchivoTipo1;
		
	}

}
