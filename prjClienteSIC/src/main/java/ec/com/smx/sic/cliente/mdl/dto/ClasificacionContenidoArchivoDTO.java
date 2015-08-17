package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloClasificacionArchivoID;

/**
 * Entidad que almacena el archivo digital de un artículo
 * */
@Table(name="SCSADTCLACONTARC")
@SuppressWarnings("serial")
public class ClasificacionContenidoArchivoDTO extends SearchDTO{

	
	/**
	 */
	@EmbeddedId
	private ArticuloClasificacionArchivoID id = new ArticuloClasificacionArchivoID();

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARCHIVO", referencedColumnName="CODIGOARCHIVO", insertable=false, updatable=false)})
	private ClasificacionArchivoDTO clasificacionArchivoDTO;
	
	/**
	 * Contenido digital del archivo
	 * 
	 */
	private byte[] contenidoArchivo;

	/**
	 * @return the id
	 */
	public ArticuloClasificacionArchivoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloClasificacionArchivoID id) {
		this.id = id;
	}



	/**
	 * @return the clasificacionArchivoDTO
	 */
	public ClasificacionArchivoDTO getClasificacionArchivoDTO() {
		return clasificacionArchivoDTO;
	}

	/**
	 * @param clasificacionArchivoDTO the clasificacionArchivoDTO to set
	 */
	public void setClasificacionArchivoDTO(ClasificacionArchivoDTO clasificacionArchivoDTO) {
		this.clasificacionArchivoDTO = clasificacionArchivoDTO;
	}

	/**
	 * @return the contenidoArchivo
	 */
	public byte[] getContenidoArchivo() {
		return contenidoArchivo;
	}

	/**
	 * @param contenidoArchivo the contenidoArchivo to set
	 */
	public void setContenidoArchivo(byte[] contenidoArchivo) {
		this.contenidoArchivo = contenidoArchivo;
	}
}
