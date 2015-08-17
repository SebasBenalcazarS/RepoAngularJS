package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.CabeceraEnvioDetalleImpID;


@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTCABENVDET")
public class CabeceraEnvioDetalleImpDTO extends AuditoriaBaseDTO<CabeceraEnvioDetalleImpID>{

	@Column(name = "SECUENCIALARCHIVO")
	private Long secuencialArchivo;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable =  false),
		@JoinColumn(name = "SECUENCIALARCHIVO", referencedColumnName = "SECUENCIALARCHIVO", insertable = false, updatable = false)		
	})
	private ArchivoImpDTO archivoImpDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOENVIO", referencedColumnName = "CODIGOENVIO", insertable = false, updatable = false)	
	})
	private CabeceraEnvioImpDTO cabeceraEnvioDetalleImpDTO;
	

	/**
	 * @return the archivoImpDTO
	 */
	public ArchivoImpDTO getArchivoImpDTO() {
		return archivoImpDTO;
	}

	/**
	 * @param archivoImpDTO the archivoImpDTO to set
	 */
	public void setArchivoImpDTO(ArchivoImpDTO archivoImpDTO) {
		this.archivoImpDTO = archivoImpDTO;
	}

	/**
	 * @return the secuencialArchivo
	 */
	public Long getSecuencialArchivo() {
		return secuencialArchivo;
	}

	/**
	 * @param secuencialArchivo the secuencialArchivo to set
	 */
	public void setSecuencialArchivo(Long secuencialArchivo) {
		this.secuencialArchivo = secuencialArchivo;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the cabeceraEnvioDetalleImpDTO
	 */
	public CabeceraEnvioImpDTO getCabeceraEnvioDetalleImpDTO() {
		return cabeceraEnvioDetalleImpDTO;
	}

	/**
	 * @param cabeceraEnvioDetalleImpDTO the cabeceraEnvioDetalleImpDTO to set
	 */
	public void setCabeceraEnvioDetalleImpDTO(
			CabeceraEnvioImpDTO cabeceraEnvioDetalleImpDTO) {
		this.cabeceraEnvioDetalleImpDTO = cabeceraEnvioDetalleImpDTO;
	}

	

	
	
}
