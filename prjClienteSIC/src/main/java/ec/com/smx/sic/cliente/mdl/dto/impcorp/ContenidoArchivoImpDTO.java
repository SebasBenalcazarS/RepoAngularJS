package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.ContenidoArchivoImpID;

@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTCONARC")
public class ContenidoArchivoImpDTO extends AuditoriaBaseDTO<ContenidoArchivoImpID>{
	
//	@Column(name="SECUENCIALARCHIVOIMP")
//	private Long secuencialArchivoImp;
	
	@Lob
	@Basic (fetch = FetchType.LAZY)
	@Column(name = "CONTENIDOARCHIVO")
	private byte [] contenidoArchivo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "SECUENCIALARCHIVO", referencedColumnName = "SECUENCIALARCHIVO", insertable = false, updatable = false)
	})
	private ArchivoImpDTO archivo;
	
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

//	/**
//	 * @return the secuencialArchivoImp
//	 */
//	public Long getSecuencialArchivoImp() {
//		return secuencialArchivoImp;
//	}
//
//	/**
//	 * @param secuencialArchivoImp the secuencialArchivoImp to set
//	 */
//	public void setSecuencialArchivoImp(Long secuencialArchivoImp) {
//		this.secuencialArchivoImp = secuencialArchivoImp;
//	}

	/**
	 * @return the archivo
	 */
	public ArchivoImpDTO getArchivo() {
		return archivo;
	}

	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(ArchivoImpDTO archivo) {
		this.archivo = archivo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 47;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContenidoArchivoImpDTO other = (ContenidoArchivoImpDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
