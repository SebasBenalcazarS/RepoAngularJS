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

/**
 * @author ediaz
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "SCSACTBINTARARC")
public class BinTarjetaArchivoDTO implements Serializable {
	@Id
	private Long codigoArchivo;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] contenidoArchivo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOARCHIVO", referencedColumnName = "CODIGOARCHIVO", insertable = false, updatable = false)
	private BinTarjetaDefinicionArchivoDTO binTarjetaDefinicionArchivoDTO;

	public Long getCodigoArchivo() {
		return codigoArchivo;
	}

	public void setCodigoArchivo(Long codigoArchivo) {
		this.codigoArchivo = codigoArchivo;
	}

	public byte[] getContenidoArchivo() {
		return contenidoArchivo;
	}

	public void setContenidoArchivo(byte[] contenidoArchivo) {
		this.contenidoArchivo = contenidoArchivo;
	}

	public BinTarjetaDefinicionArchivoDTO getBinTarjetaDefinicionArchivoDTO() {
		return binTarjetaDefinicionArchivoDTO;
	}

	public void setBinTarjetaDefinicionArchivoDTO(BinTarjetaDefinicionArchivoDTO binTarjetaDefinicionArchivoDTO) {
		this.binTarjetaDefinicionArchivoDTO = binTarjetaDefinicionArchivoDTO;
	}
	
	
}
