
package ec.com.smx.sic.cliente.mdl.dto.b2b;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.CompradorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.UsuarioCompradorID;

/**
 * Registros de compradores asignados a los usuarios
 *
 * @author Luis Yacchirema
 */
@SuppressWarnings({ "serial", "deprecation" })
@Entity(name="ec.com.smx.sic.cliente.mdl.dto.b2b.UsuarioCompradorDTO")
@Table(name="SSB2BTUSUARIOCOMPRADOR")
@Deprecated
public class UsuarioCompradorDTO extends SearchDTO implements java.io.Serializable
{

	/**
	 * Propiedad identificador 
	 */
	@EmbeddedId
	private UsuarioCompradorID id = new UsuarioCompradorID();

	/**
	 * Referencia a usuario 
	 * de framework 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name="USERID", insertable=false, updatable=false, referencedColumnName="USERID")
	private ec.com.smx.framework.security.dto.UserDto usuario;

	/**
	 * Referencia a entidad comprador 
	 */
	@Transient
	private CompradorDTO comprador;
	/**
	 * Campo para buscar los usuario de un comprador pero con un rol especifico
	 */
	private String npRolId;

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public UsuarioCompradorID getId()
	{
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(UsuarioCompradorID id1 )
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
	 * Retorna valor de propiedad <code>comprador</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>comprador</code>
	 */
	public CompradorDTO getComprador(){
		return this.comprador;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>comprador</code>.
	 * @param comprador1 
	 *		El valor a establecer para la propiedad <code>comprador</code>.
	 */
	public void setComprador( CompradorDTO comprador1 )
	{
		this.comprador=comprador1;
	}

	public String getNpRolId() {
		return npRolId;
	}

	public void setNpRolId(String npRolId) {
		this.npRolId = npRolId;
	}
	
}
