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
import ec.com.smx.corpv2.dto.EmpresaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.FacturaGastoEmbarqueImpID;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTFACGAS")
public class FacturaGastoEmbarqueImpDTO extends AuditoriaBaseDTO<FacturaGastoEmbarqueImpID> {

	@Column(name = "CODIGOEMBARQUE")
	private Long codigoEmbarque;
	
	@Column(name = "TIPODOCUMENTOTIPO")
	private Long tipoDocumentoTipo;
	
	@Column(name = "TIPODOCUMENTOVALOR")
	private Long tipoDocumentoValor;
	
	@Column(name = "NUMERODOCUMENTO")
	private String numeroDocumento;
	
	@Column(name = "CODIGOCONCEPTO")
	private Long codigoConcepto;
	
	@Column(name = "CODIGODEUDOR")
	private String codigoDeudor;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "OBSERVACION")
	private String observacion;
	
	@Column(name = "CODIGOEMPRESA")
	private Long codigoEmpresa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE", insertable = false, updatable = false)
	})
	private EmbarqueImpDTO embarque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "TIPODOCUMENTOTIPO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "TIPODOCUMENTOVALOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoDocumento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGODEUDOR", referencedColumnName = "CODIGOAGENTEADUANERO", insertable = false, updatable = false)
	})
	private AgenteAduaneroDTO deudor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCONCEPTO", referencedColumnName = "CODIGOGASTOEMBARQUE", insertable = false, updatable = false)
	})
	private GastoEmbarqueDTO gastoEmbarque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOEMPRESA", referencedColumnName = "CODIGOEMPRESA", insertable = false, updatable = false)
	})
	private EmpresaDTO empresa;

	/**
	 * @return the tipoDocumentoTipo
	 */
	public Long getTipoDocumentoTipo() {
		return tipoDocumentoTipo;
	}

	/**
	 * @param tipoDocumentoTipo the tipoDocumentoTipo to set
	 */
	public void setTipoDocumentoTipo(Long tipoDocumentoTipo) {
		this.tipoDocumentoTipo = tipoDocumentoTipo;
	}

	/**
	 * @return the tipoDocumentoValor
	 */
	public Long getTipoDocumentoValor() {
		return tipoDocumentoValor;
	}

	/**
	 * @param tipoDocumentoValor the tipoDocumentoValor to set
	 */
	public void setTipoDocumentoValor(Long tipoDocumentoValor) {
		this.tipoDocumentoValor = tipoDocumentoValor;
	}

	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * @return the codigoConcepto
	 */
	public Long getCodigoConcepto() {
		return codigoConcepto;
	}

	/**
	 * @param codigoConcepto the codigoConcepto to set
	 */
	public void setCodigoConcepto(Long codigoConcepto) {
		this.codigoConcepto = codigoConcepto;
	}

	/**
	 * @return the codigoDeudor
	 */
	public String getCodigoDeudor() {
		return codigoDeudor;
	}

	/**
	 * @param codigoDeudor the codigoDeudor to set
	 */
	public void setCodigoDeudor(String codigoDeudor) {
		this.codigoDeudor = codigoDeudor;
	}

	
	
	/**
	 * @return the embarque
	 */
	public EmbarqueImpDTO getEmbarque() {
		return embarque;
	}

	/**
	 * @param embarque the embarque to set
	 */
	public void setEmbarque(EmbarqueImpDTO embarque) {
		this.embarque = embarque;
	}

	/**
	 * @return the tipoDocumento
	 */
	public CatalogoValorImpDTO getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(CatalogoValorImpDTO tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the gastoEmbarque
	 */
	public GastoEmbarqueDTO getGastoEmbarque() {
		return gastoEmbarque;
	}

	/**
	 * @param gastoEmbarque the gastoEmbarque to set
	 */
	public void setGastoEmbarque(GastoEmbarqueDTO gastoEmbarque) {
		this.gastoEmbarque = gastoEmbarque;
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
	 * @return the deudor
	 */
	public AgenteAduaneroDTO getDeudor() {
		return deudor;
	}

	/**
	 * @param deudor the deudor to set
	 */
	public void setDeudor(AgenteAduaneroDTO deudor) {
		this.deudor = deudor;
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
	 * @return the empresa
	 */
	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the codigoEmpresa
	 */
	public Long getCodigoEmpresa() {
		return codigoEmpresa;
	}

	/**
	 * @param codigoEmpresa the codigoEmpresa to set
	 */
	public void setCodigoEmpresa(Long codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}
} 