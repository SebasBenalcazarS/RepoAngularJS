
package ec.com.smx.sic.cliente.mdl.dto.b2b;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.b2b.PedidoArchivoID;


/****************************
 * Tiene las referencias	* 
 * de los archivos de un 	*
 * pedido					*
 *							*
 * @author kruger			*
 **************************** 
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.b2b.PedidoArchivoDTO")
@Table(name = "SSB2BTPEDIDOARCHIVO")
@Deprecated
public class PedidoArchivoDTO extends SimpleAuditDTO
{

	/**
	 * Referencia al Identificador 
	 * de pedido archivo 
	 *
	 */
	@EmbeddedId
	private PedidoArchivoID id = new PedidoArchivoID();


	/**
	 * estado que indica si el archivo a sido requerido/consultado por el proveedor
     * 0: no ha sido requerido
     * 1: si ha sido requerido
	 *
	 */
	private String estadoDownload ;
	
	/**
	 * Propiedad no persistente para indicar el estado
	 * de descarga de un pedido
	 * 0: no ha sido requerido
     * 1: si ha sido requerido
	 */
	@Transient
	private String estadoDownloadNP;

	/**
	 * Nombre de archivo
	 */
	private String nombreArchivo;
	
	/**
	 * Fecha de grabacion del archivo
	 */
	 private java.util.Date fechaArchivo;
	

	/**
	 * Referencia al pedido al que pertenece el archivo
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPEDIDO", referencedColumnName = "CODIGOPEDIDO", insertable = false, updatable = false)
	})
	private PedidoDTO pedido;


	/**
	 * Referencia al archivo cargado 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARCHIVO", referencedColumnName = "CODIGOARCHIVO", insertable = false, updatable = false)
	})
	private ArchivoDTO archivo;

	/**
	 * Identificador del usuario que descarga el archivo la primera
	 * vez
	 */
	private String idUsuarioDescarga;

	
	/**
	 * Fecha de descarga del archivo
	 */
	private java.util.Date fechaDescarga;
	 
	/**
	 * Referencia al usuario de descarga
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIODESCARGA", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioDescarga; 
	
	/**
	 * Constructor por defecto
	 */
	public PedidoArchivoDTO()
	{
		this.estadoDownloadNP = "0";
	}


	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public PedidoArchivoID getId()
	{
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(PedidoArchivoID id1 )
	{
		this.id=id1;
	}


	/**
	 * Retorna valor de propiedad <code>estadoDownload</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>estadoDownload</code>
	 */
	public String getEstadoDownload()
	{
		return this.estadoDownload;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoDownload</code>.
	 * @param estadoDownload1 
	 *		El valor a establecer para la propiedad <code>estadoDownload</code>.
	 */
	public void setEstadoDownload( String estadoDownload1 )
	{
		this.estadoDownload=estadoDownload1;
		
		if(estadoDownload!=null && estadoDownload.length()>1){
			estadoDownload = estadoDownload.substring(0,1);
		}
			
	}

	/**
	 * Retorna valor de propiedad <code>pedido</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>pedido</code>
	 */
	public PedidoDTO getPedido()
	{
		return this.pedido;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>pedido</code>.
	 * @param pedido1 
	 *		El valor a establecer para la propiedad <code>pedido</code>.
	 */
	public void setPedido(PedidoDTO pedido1 )
	{
		this.pedido=pedido1;
	}


	/**
	 * Retorna valor de propiedad <code>archivo</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>archivo</code>
	 */
	public ArchivoDTO getArchivo()
	{
		return this.archivo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>archivo</code>.
	 * @param archivo1 
	 *		El valor a establecer para la propiedad <code>archivo</code>.
	 */
	public void setArchivo( ArchivoDTO archivo1 )
	{
		this.archivo=archivo1;
	}

	/**
	 * Obtener fecha de archivo
	 * @return
	 */
	public java.util.Date getFechaArchivo() 
	{
		return fechaArchivo;
	}

	/**
	 * 
	 * @param fechaArchivo
	 */
	public void setFechaArchivo(java.util.Date fechaArchivo) 
	{
		this.fechaArchivo = fechaArchivo;
	}

	public String getNombreArchivo() 
	{
		return nombreArchivo;
	}

	/**
	 * 
	 * @param nombreArchivo
	 */
	public void setNombreArchivo(String nombreArchivo) 
	{
		this.nombreArchivo = nombreArchivo;
	}


	/**
	 * Obtener estado Download No Persistente
	 * @return
	 */
	public String getEstadoDownloadNP() 
	{
		return estadoDownloadNP;
	}

    /**
     * Establecer estado Download No Persistente
     * @param estadoDownloadNP
     */
	public void setEstadoDownloadNP(String estadoDownloadNP) 
	{
		this.estadoDownloadNP = estadoDownloadNP;
	}

    /**
     * Obtener la fecha de 
     * primera descarga
     * del archivo
     * @return
     */
	public java.util.Date getFechaDescarga() 
	{
		return fechaDescarga;
	}

    /**
     * Establecer la fecha de 
     * primera descarga del 
     * archivo
     * @param fechaDescarga
     */
	public void setFechaDescarga(java.util.Date fechaDescarga) 
	{
		this.fechaDescarga = fechaDescarga;
	}

    
	/**
	 * Obtener el identificador
	 * de usuario de primera
	 * descarga
	 * @return
	 */
	public String getIdUsuarioDescarga() 
	{
		return idUsuarioDescarga;
	}


	/**
	 * Establecer el id del usuario
	 * de primera descarga
	 * @param idUsuarioDescarga
	 */
	public void setIdUsuarioDescarga(String idUsuarioDescarga) 
	{
		this.idUsuarioDescarga = idUsuarioDescarga;
	}

    /**
     * Obtener usuario
     * @return
     */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioDescarga() 
	{
		return usuarioDescarga;
	}

    /**
     * Establecer usuario
     * @param usuarioDescarga
     */
	public void setUsuarioDescarga(ec.com.smx.framework.security.dto.UserDto usuarioDescarga) 
	{
		this.usuarioDescarga = usuarioDescarga;
	}

}

