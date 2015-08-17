package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.CabeceraEnvioImpID;


@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTCABENV")
public class CabeceraEnvioImpDTO extends AuditoriaBaseDTO<CabeceraEnvioImpID>{

	//@Column(name = "SECUENCIALARCHIVO")
	//private Long secuencialArchivo;
	
	@Column(name = "FECHAENVIO")
	private Timestamp fechaEnvio;

	@Column(name = "CODIGOENVIOESTTIP")
	private Long codigoEnvioCatTip;
	
	@Column(name = "CODIGOENVIOESTVAL")
	private Long codigoEnvioCatVal;
	
	@Column(name = "NUMEROREEMBOLSO")
	private String numeroReembolso;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumns({
//		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable =  false),
//		@JoinColumn(name = "SECUENCIALARCHIVO", referencedColumnName = "SECUENCIALARCHIVO", insertable = false, updatable = false)		
//	})
//	//private ArchivoImpDTO archivoImpDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOENVIOESTTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOENVIOESTVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO estado;
	
	@OneToMany(mappedBy="cabeceraEnvioImpDTO")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<FacturaGastoEmbarqueEstadoImpDTO> facturaGastoEmbarqueEstadoImpDTO;
	
	@OneToMany(mappedBy="cabeceraEnvioDetalleImpDTO")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<CabeceraEnvioDetalleImpDTO> cabeceraEnvioDetalleImpDTO;
	


//	/**
//	 * @return the archivoImpDTO
//	 */
//	public ArchivoImpDTO getArchivoImpDTO() {
//		return archivoImpDTO;
//	}
//
//	/**
//	 * @param archivoImpDTO the archivoImpDTO to set
//	 */
//	public void setArchivoImpDTO(ArchivoImpDTO archivoImpDTO) {
//		this.archivoImpDTO = archivoImpDTO;
//	}

//	/**
//	 * @return the secuencialArchivo
//	 */
//	public Long getSecuencialArchivo() {
//		return secuencialArchivo;
//	}
//
//	/**
//	 * @param secuencialArchivo the secuencialArchivo to set
//	 */
//	public void setSecuencialArchivo(Long secuencialArchivo) {
//		this.secuencialArchivo = secuencialArchivo;
//	}

	/**
	 * @return the fechaEnvio
	 */
	public Timestamp getFechaEnvio() {
		return fechaEnvio;
	}

	/**
	 * @param fechaEnvio the fechaEnvio to set
	 */
	public void setFechaEnvio(Timestamp fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	/**
	 * @return the facturaGastoEmbarqueEstadoImpDTO
	 */
	public Collection<FacturaGastoEmbarqueEstadoImpDTO> getFacturaGastoEmbarqueEstadoImpDTO() {
		return facturaGastoEmbarqueEstadoImpDTO;
	}

	/**
	 * @param facturaGastoEmbarqueEstadoImpDTO the facturaGastoEmbarqueEstadoImpDTO to set
	 */
	public void setFacturaGastoEmbarqueEstadoImpDTO(
			Collection<FacturaGastoEmbarqueEstadoImpDTO> facturaGastoEmbarqueEstadoImpDTO) {
		this.facturaGastoEmbarqueEstadoImpDTO = facturaGastoEmbarqueEstadoImpDTO;
	}

	/**
	 * @return the estado
	 */
	public CatalogoValorImpDTO getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(CatalogoValorImpDTO estado) {
		this.estado = estado;
	}

	/**
	 * @return the codigoEnvioCatTip
	 */
	public Long getCodigoEnvioCatTip() {
		return codigoEnvioCatTip;
	}

	/**
	 * @param codigoEnvioCatTip the codigoEnvioCatTip to set
	 */
	public void setCodigoEnvioCatTip(Long codigoEnvioCatTip) {
		this.codigoEnvioCatTip = codigoEnvioCatTip;
	}

	/**
	 * @return the codigoEnvioCatVal
	 */
	public Long getCodigoEnvioCatVal() {
		return codigoEnvioCatVal;
	}

	/**
	 * @param codigoEnvioCatVal the codigoEnvioCatVal to set
	 */
	public void setCodigoEnvioCatVal(Long codigoEnvioCatVal) {
		this.codigoEnvioCatVal = codigoEnvioCatVal;
	}

	/**
	 * @return the cabeceraEnvioDetalleImpDTO
	 */
	public Collection<CabeceraEnvioDetalleImpDTO> getCabeceraEnvioDetalleImpDTO() {
		return cabeceraEnvioDetalleImpDTO;
	}

	/**
	 * @param cabeceraEnvioDetalleImpDTO the cabeceraEnvioDetalleImpDTO to set
	 */
	public void setCabeceraEnvioDetalleImpDTO(
			Collection<CabeceraEnvioDetalleImpDTO> cabeceraEnvioDetalleImpDTO) {
		this.cabeceraEnvioDetalleImpDTO = cabeceraEnvioDetalleImpDTO;
	}

	/**
	 * @return the numeroReembolso
	 */
	public String getNumeroReembolso() {
		return numeroReembolso;
	}

	/**
	 * @param numeroReembolso the numeroReembolso to set
	 */
	public void setNumeroReembolso(String numeroReembolso) {
		this.numeroReembolso = numeroReembolso;
	}
}
