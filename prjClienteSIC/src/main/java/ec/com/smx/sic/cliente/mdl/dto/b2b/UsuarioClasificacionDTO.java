
package ec.com.smx.sic.cliente.mdl.dto.b2b;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.UsuarioClasificacionID;

/**
 * Contiene los registros de las clasificaciones asignadas a los usuarios
 *
 * @author Luis Yacchirema
 */
@SuppressWarnings({ "serial", "deprecation" })
@Entity(name="ec.com.smx.sic.cliente.mdl.dto.b2b.UsuarioClasificacionDTO")
@Table(name="SSB2BTUSUARIOCLASIFICACION")
@Deprecated
public class UsuarioClasificacionDTO extends SearchDTO implements java.io.Serializable
{

	/**
	 * Propiedad identificador 
	 */
	@EmbeddedId
	private UsuarioClasificacionID id = new UsuarioClasificacionID();

	/**
	 * Referencia a usuario 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name="USERID", insertable=false, updatable=false, referencedColumnName="USERID")
	private ec.com.smx.framework.security.dto.UserDto usuario;


	/**
	 * Referencia a la clasificacion
	 */
	@Transient
	private ClasificacionDTO clasificacion;

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public UsuarioClasificacionID getId()
	{
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(UsuarioClasificacionID id1 )
	{
		this.id=id1;
	}


	/**
	 * Retorna valor de propiedad <code>usuario</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>usuario</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuario()
	{
		return this.usuario;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuario</code>.
	 * @param usuario1 
	 *		El valor a establecer para la propiedad <code>usuario</code>.
	 */
	public void setUsuario( ec.com.smx.framework.security.dto.UserDto usuario1 )
	{
		this.usuario=usuario1;
	}


	/**
	 * Retorna valor de propiedad <code>clasificacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>clasificacion</code>
	 */
	public ClasificacionDTO getClasificacion()
	{
		return this.clasificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>clasificacion</code>.
	 * @param clasificacion1 
	 *		El valor a establecer para la propiedad <code>clasificacion</code>.
	 */
	public void setClasificacion( ClasificacionDTO clasificacion1 ){
		this.clasificacion=clasificacion1;
	}

}
