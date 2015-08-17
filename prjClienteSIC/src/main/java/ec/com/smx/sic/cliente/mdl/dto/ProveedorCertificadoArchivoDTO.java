package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorCertificadoArchivoID;

/**
 * @author Marcelo Hidalgo
 *
 */
@Entity
@Table(name = "SCPROTPROCERARC")
public class ProveedorCertificadoArchivoDTO{

	@EmbeddedId
	private ProveedorCertificadoArchivoID id = new ProveedorCertificadoArchivoID();
	
	/**
	 * Dato,  informacion
	 * contenida en el archivo	
	 */
	@Column(name = "CONTENIDOARCHIVO")
	private byte[] contenidoArchivo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
					@JoinColumn(name="SECUENCIALARCHIVO", referencedColumnName="SECUENCIALARCHIVO", insertable=false, updatable=false)})
	private ProveedorCertificadoDefinicionArchivoDTO proveedorCertificadoDefinicionArchivo;

	public ProveedorCertificadoArchivoID getId() {
		return id;
	}

	public void setId(ProveedorCertificadoArchivoID id) {
		this.id = id;
	}

	public byte[] getContenidoArchivo() {
		return contenidoArchivo;
	}

	public void setContenidoArchivo(byte[] contenidoArchivo) {
		this.contenidoArchivo = contenidoArchivo;
	}

	public ProveedorCertificadoDefinicionArchivoDTO getProveedorCertificadoDefinicionArchivo() {
		return proveedorCertificadoDefinicionArchivo;
	}

	public void setProveedorCertificadoDefinicionArchivo(ProveedorCertificadoDefinicionArchivoDTO proveedorCertificadoDefinicionArchivo) {
		this.proveedorCertificadoDefinicionArchivo = proveedorCertificadoDefinicionArchivo;
	}
	
}
