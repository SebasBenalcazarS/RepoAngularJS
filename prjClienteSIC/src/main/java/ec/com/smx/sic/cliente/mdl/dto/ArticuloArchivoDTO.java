package ec.com.smx.sic.cliente.mdl.dto;


import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloDefinicionArchivoID;

/**
 * Entidad que almacena el archivo digital de un artículo
 * 
 * @author fmunoz
 */
@Entity
@Table(name="SCSADTARTARC")
@SuppressWarnings("serial")
public class ArticuloArchivoDTO extends SearchDTO {

	/**
	 */
	@EmbeddedId
	private ArticuloDefinicionArchivoID id = new ArticuloDefinicionArchivoID();

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARCHIVO", referencedColumnName="CODIGOARCHIVO", insertable=false, updatable=false)})
	private ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO;
	
	/**
	 * Contenido digital del archivo
	 * 
	 */
	private byte[] contenidoArchivo;


	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ArticuloDefinicionArchivoID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ArticuloDefinicionArchivoID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>contenidoArchivo</code>
	 * 
	 * @return Retorna valor de propiedad <code>contenidoArchivo</code>
	 */
	public byte[] getContenidoArchivo() {
		return this.contenidoArchivo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>contenidoArchivo</code>
	 * 
	 * @param contenidoArchivo1
	 *            El valor a establecer para la propiedad <code>contenidoArchivo</code>.
	 */
	public void setContenidoArchivo(byte[] contenidoArchivo1) {
		this.contenidoArchivo = contenidoArchivo1;
	}

	/**
	 * @return the articuloDefinicionArchivoDTO
	 */
	public ArticuloDefinicionArchivoDTO getArticuloDefinicionArchivoDTO() {
		return articuloDefinicionArchivoDTO;
	}

	/**
	 * @param articuloDefinicionArchivoDTO the articuloDefinicionArchivoDTO to set
	 */
	public void setArticuloDefinicionArchivoDTO(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO) {
		this.articuloDefinicionArchivoDTO = articuloDefinicionArchivoDTO;
	}

}
