package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ContenidoArchivoDto;

/**
 * @author ediaz
 *
 */
public class FileInformationContentVO {

	private Collection<ContenidoArchivoDto> contenidoArchivoDTOs;
	private String nombreArchivo;
	private String estado;
	private String tipoContenidoArchivo;
	private Long tamanioArchivo;

	public FileInformationContentVO() {
		super();
	}

	public Collection<ContenidoArchivoDto> getContenidoArchivoDTOs() {
		return contenidoArchivoDTOs;
	}

	public void setContenidoArchivoDTOs(Collection<ContenidoArchivoDto> contenidoArchivoDTOs) {
		this.contenidoArchivoDTOs = contenidoArchivoDTOs;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoContenidoArchivo() {
		return tipoContenidoArchivo;
	}

	public void setTipoContenidoArchivo(String tipoContenidoArchivo) {
		this.tipoContenidoArchivo = tipoContenidoArchivo;
	}

	public Long getTamanioArchivo() {
		return tamanioArchivo;
	}

	public void setTamanioArchivo(Long tamanioArchivo) {
		this.tamanioArchivo = tamanioArchivo;
	}

}
