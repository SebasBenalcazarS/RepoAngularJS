package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "SCSACTCONARC")
public class ContenidoArchivoDto implements Serializable {

//	@EmbeddedId
//	private CodigoArchivoID id = new CodigoArchivoID();
	@Id
	private Long codigoArchivo;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] contenidoArchivo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOARCHIVO", referencedColumnName = "CODIGOARCHIVO", insertable = false, updatable = false)
	private ContenidoDefinicionArchivoDTO contenidoDefinicionArchivoDTO;

	public byte[] getContenidoArchivo() {
		return contenidoArchivo;
	}

	public void setContenidoArchivo(byte[] contenidoArchivo) {
		this.contenidoArchivo = contenidoArchivo;
	}

	public Long getCodigoArchivo() {
		return codigoArchivo;
	}

	public void setCodigoArchivo(Long codigoArchivo) {
		this.codigoArchivo = codigoArchivo;
	}

	public ContenidoDefinicionArchivoDTO getContenidoDefinicionArchivoDTO() {
		return contenidoDefinicionArchivoDTO;
	}

	public void setContenidoDefinicionArchivoDTO(ContenidoDefinicionArchivoDTO contenidoDefinicionArchivoDTO) {
		this.contenidoDefinicionArchivoDTO = contenidoDefinicionArchivoDTO;
	}

}
