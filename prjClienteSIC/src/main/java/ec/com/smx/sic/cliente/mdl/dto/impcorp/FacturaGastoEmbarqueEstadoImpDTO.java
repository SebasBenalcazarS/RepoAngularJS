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
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.FacturaGastoEmbarqueEstadoImpID;

@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTFACGASEST")
public class FacturaGastoEmbarqueEstadoImpDTO extends AuditoriaBaseDTO<FacturaGastoEmbarqueEstadoImpID> {

	@Column(name = "CODIGOFACGASESTTIP")
	private Long codigoEstadoCatTip;
	
	@Column(name = "CODIGOFACGASESTVAL")
	private Long codigoEstadoCatVal;
	
	@Column(name = "CODIGOEMBARQUE")
	private Long codigoEmbarque;
	
	@Column(name = "CODIGOBENEFICIARIOTIPO")
	private Long codigoBeneficiarioTipo;
	
	@Column(name = "CODIGOBENEFICIARIOVALOR")
	private Long codigoBeneficiarioValor;
	
//	@Column(name = "DIASDEMORAJE")
//	private Double diasDemoraje;
	
	@Column(name = "VALOR")
	private Double valor;
	
	@Column(name = "FECHAINICIO")
	private Timestamp fechaInicio;
	
	@Column(name = "FECHAFIN")
	private Timestamp fechaFin;
	
	@Column(name = "OBSERVACION")
	private String observacion;
	
	@Column(name = "CODIGOENVIO")
	private Long codigoEnvio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURAGASTO", referencedColumnName = "CODIGOFACTURAGASTO", insertable = false, updatable = false)
	})
	private FacturaGastoEmbarqueImpDTO facturaGastoEmbarque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOBENEFICIARIOTIPO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOBENEFICIARIOVALOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO beneficiario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACGASESTTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACGASESTVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO estado;
	
	@OneToMany(mappedBy = "facturaGastoEmbarqueEstado")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<FacturaGastoEmbarqueContenedorImpDTO> facturaGastoEmbarqueContenedores;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOENVIO", referencedColumnName = "CODIGOENVIO", insertable = false, updatable = false)	
	})
	private CabeceraEnvioImpDTO cabeceraEnvioImpDTO;
	
	/**
	 * @return the codigoEstadoCatTip
	 */
	public Long getCodigoEstadoCatTip() {
		return codigoEstadoCatTip;
	}

	/**
	 * @param codigoEstadoCatTip the codigoEstadoCatTip to set
	 */
	public void setCodigoEstadoCatTip(Long codigoEstadoCatTip) {
		this.codigoEstadoCatTip = codigoEstadoCatTip;
	}

	/**
	 * @return the codigoEstadoCatVal
	 */
	public Long getCodigoEstadoCatVal() {
		return codigoEstadoCatVal;
	}

	/**
	 * @param codigoEstadoCatVal the codigoEstadoCatVal to set
	 */
	public void setCodigoEstadoCatVal(Long codigoEstadoCatVal) {
		this.codigoEstadoCatVal = codigoEstadoCatVal;
	}

	/**
	 * @return the codigoEmbarque
	 */
	public Long getCodigoEmbarque() {
		return codigoEmbarque;
	}

	/**
	 * @param codigoEmbarque the codigoEmbarque to set
	 */
	public void setCodigoEmbarque(Long codigoEmbarque) {
		this.codigoEmbarque = codigoEmbarque;
	}

	/**
	 * @return the codigoBeneficiarioTipo
	 */
	public Long getCodigoBeneficiarioTipo() {
		return codigoBeneficiarioTipo;
	}

	/**
	 * @param codigoBeneficiarioTipo the codigoBeneficiarioTipo to set
	 */
	public void setCodigoBeneficiarioTipo(Long codigoBeneficiarioTipo) {
		this.codigoBeneficiarioTipo = codigoBeneficiarioTipo;
	}

	/**
	 * @return the codigoBeneficiarioValor
	 */
	public Long getCodigoBeneficiarioValor() {
		return codigoBeneficiarioValor;
	}

	/**
	 * @param codigoBeneficiarioValor the codigoBeneficiarioValor to set
	 */
	public void setCodigoBeneficiarioValor(Long codigoBeneficiarioValor) {
		this.codigoBeneficiarioValor = codigoBeneficiarioValor;
	}

//	/**
//	 * @return the diasDemoraje
//	 */
//	public Double getDiasDemoraje() {
//		return diasDemoraje;
//	}
//
//	/**
//	 * @param diasDemoraje the diasDemoraje to set
//	 */
//	public void setDiasDemoraje(Double diasDemoraje) {
//		this.diasDemoraje = diasDemoraje;
//	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return the fechaInicio
	 */
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Timestamp getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the codigoEnvio
	 */
	public Long getCodigoEnvio() {
		return codigoEnvio;
	}

	/**
	 * @param codigoEnvio the codigoEnvio to set
	 */
	public void setCodigoEnvio(Long codigoEnvio) {
		this.codigoEnvio = codigoEnvio;
	}

	/**
	 * @return the facturaGastoEmbarque
	 */
	public FacturaGastoEmbarqueImpDTO getFacturaGastoEmbarque() {
		return facturaGastoEmbarque;
	}

	/**
	 * @param facturaGastoEmbarque the facturaGastoEmbarque to set
	 */
	public void setFacturaGastoEmbarque(
			FacturaGastoEmbarqueImpDTO facturaGastoEmbarque) {
		this.facturaGastoEmbarque = facturaGastoEmbarque;
	}

	/**
	 * @return the beneficiario
	 */
	public CatalogoValorImpDTO getBeneficiario() {
		return beneficiario;
	}

	/**
	 * @param beneficiario the beneficiario to set
	 */
	public void setBeneficiario(CatalogoValorImpDTO beneficiario) {
		this.beneficiario = beneficiario;
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
	 * @return the facturaGastoEmbarqueContenedores
	 */
	public Collection<FacturaGastoEmbarqueContenedorImpDTO> getFacturaGastoEmbarqueContenedores() {
		return facturaGastoEmbarqueContenedores;
	}

	/**
	 * @param facturaGastoEmbarqueContenedores the facturaGastoEmbarqueContenedores to set
	 */
	public void setFacturaGastoEmbarqueContenedores(
			Collection<FacturaGastoEmbarqueContenedorImpDTO> facturaGastoEmbarqueContenedores) {
		this.facturaGastoEmbarqueContenedores = facturaGastoEmbarqueContenedores;
	}
	
	/**
	 * @return the cabeceraEnvioImpDTO
	 */
	public CabeceraEnvioImpDTO getCabeceraEnvioImpDTO() {
		return cabeceraEnvioImpDTO;
	}

	/**
	 * @param cabeceraEnvioImpDTO the cabeceraEnvioImpDTO to set
	 */
	public void setCabeceraEnvioImpDTO(CabeceraEnvioImpDTO cabeceraEnvioImpDTO) {
		this.cabeceraEnvioImpDTO = cabeceraEnvioImpDTO;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
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
		FacturaGastoEmbarqueEstadoImpDTO other = (FacturaGastoEmbarqueEstadoImpDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}