package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.BitacoraTramiteEmbarqueImpID;

@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTBITTRAEMB")
public class BitacoraTramiteEmbarqueImpDTO extends AuditoriaBaseDTO<BitacoraTramiteEmbarqueImpID>{
	
	@Column(name="CODCAMPOCATTIP")
	private Long codigoCampoTipo;
	
	@Column(name="CODCAMPOCATVAL")
	private Long codigoCampoValor;
	
	@Column(name="VALOR")
	private String valor;
	
	@Column(name="OBSERVACION")
	private String observacion;
	
	@Column(name="CODTIPOAFECATTIP")
	private Long codigoAfectacionTipo;
	
	@Column(name="CODTIPOAFECATVAL")
	private Long codigoAfectacionValor;
	
	@Column(name="SECUENCIALARCHIVO")
	private Long secuencialArchivo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "SECUENCIALTRAMITE", referencedColumnName = "SECUENCIALTRAMITE", insertable = false, updatable = false)
	})
	private TramiteEmbarqueImpDTO tramiteEmbarque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODCAMPOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODCAMPOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO campo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODTIPOAFECATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODTIPOAFECATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO afectacion;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name="SECUENCIALARCHIVO", referencedColumnName="SECUENCIALARCHIVO", insertable=false, updatable=false),
		@JoinColumn(name = "SECUENCIALTRAMITE", referencedColumnName = "SECUENCIALTRAMITE", insertable = false, updatable = false)
	})
	private TramiteArchivoImpDTO tramiteArchivo;

	public Long getCodigoCampoTipo() {
		return codigoCampoTipo;
	}

	public void setCodigoCampoTipo(Long codigoCampoTipo) {
		this.codigoCampoTipo = codigoCampoTipo;
	}

	public Long getCodigoCampoValor() {
		return codigoCampoValor;
	}

	public void setCodigoCampoValor(Long codigoCampoValor) {
		this.codigoCampoValor = codigoCampoValor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Long getCodigoAfectacionTipo() {
		return codigoAfectacionTipo;
	}

	public void setCodigoAfectacionTipo(Long codigoAfectacionTipo) {
		this.codigoAfectacionTipo = codigoAfectacionTipo;
	}

	public Long getCodigoAfectacionValor() {
		return codigoAfectacionValor;
	}

	public void setCodigoAfectacionValor(Long codigoAfectacionValor) {
		this.codigoAfectacionValor = codigoAfectacionValor;
	}

	public TramiteEmbarqueImpDTO getTramiteEmbarque() {
		return tramiteEmbarque;
	}

	public void setTramiteEmbarque(TramiteEmbarqueImpDTO tramiteEmbarque) {
		this.tramiteEmbarque = tramiteEmbarque;
	}

	public CatalogoValorImpDTO getCampo() {
		return campo;
	}

	public void setCampo(CatalogoValorImpDTO campo) {
		this.campo = campo;
	}

	public CatalogoValorImpDTO getAfectacion() {
		return afectacion;
	}

	public void setAfectacion(CatalogoValorImpDTO afectacion) {
		this.afectacion = afectacion;
	}

	public TramiteArchivoImpDTO getTramiteArchivo() {
		return tramiteArchivo;
	}

	public void setTramiteArchivo(TramiteArchivoImpDTO tramiteArchivo) {
		this.tramiteArchivo = tramiteArchivo;
	}

	public Long getSecuencialArchivo() {
		return secuencialArchivo;
	}

	public void setSecuencialArchivo(Long secuencialArchivo) {
		this.secuencialArchivo = secuencialArchivo;
	}
}
