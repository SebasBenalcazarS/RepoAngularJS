package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.BitacoraValorCostoID;

@Entity
@Table(name="SCPRETBITVALCOS")
@SuppressWarnings("serial")
public class BitacoraValorCostoDTO extends AuditoriaBaseDTO {
	
	@EmbeddedId
	private BitacoraValorCostoID id = new BitacoraValorCostoID();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAVIGENCIAINICIO", nullable = false)
	private Date fechaVigenciaInicio ;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAVIGENCIAFIN")
	private Date fechaVigenciaFin ;
	
	@Column(name = "COSTOBRUTO", nullable = false)
	private Double costoBruto;
	
	@Column(name = "COSTONETO", nullable = false)
	private Double costoNeto;

	@Column(name = "MARGENPVP", nullable = false)
	private Double margenPVP;
	
	@Column(name = "MARGENSMX", nullable = false)
	private Double margenSMX;
	
	@ComparatorTypeField
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOVALORCOSTOGESTION", referencedColumnName = "CODIGOVALORCOSTOGESTION", insertable = false, updatable = false)})
	private ValorCostoGestionDTO valorCostoGestion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "VALORTIPOESTADO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOESTADO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)		
	})
	private CatalogoValorDTO tipoEstado;


	/**
	 * @return the id
	 */
	public BitacoraValorCostoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BitacoraValorCostoID id) {
		this.id = id;
	}

	/**
	 * @return the fechaVigenciaInicio
	 */
	public Date getFechaVigenciaInicio() {
		return fechaVigenciaInicio;
	}

	/**
	 * @param fechaVigenciaInicio the fechaVigenciaInicio to set
	 */
	public void setFechaVigenciaInicio(Date fechaVigenciaInicio) {
		this.fechaVigenciaInicio = fechaVigenciaInicio;
	}

	/**
	 * @return the fechaVigenciaFin
	 */
	public Date getFechaVigenciaFin() {
		return fechaVigenciaFin;
	}

	/**
	 * @param fechaVigenciaFin the fechaVigenciaFin to set
	 */
	public void setFechaVigenciaFin(Date fechaVigenciaFin) {
		this.fechaVigenciaFin = fechaVigenciaFin;
	}

	/**
	 * @return the costoBruto
	 */
	public Double getCostoBruto() {
		return costoBruto;
	}

	/**
	 * @param costoBruto the costoBruto to set
	 */
	public void setCostoBruto(Double costoBruto) {
		this.costoBruto = costoBruto;
	}

	/**
	 * @return the costoNeto
	 */
	public Double getCostoNeto() {
		return costoNeto;
	}

	/**
	 * @param costoNeto the costoNeto to set
	 */
	public void setCostoNeto(Double costoNeto) {
		this.costoNeto = costoNeto;
	}

	/**
	 * @return the margenPVP
	 */
	public Double getMargenPVP() {
		return margenPVP;
	}

	/**
	 * @param margenPVP the margenPVP to set
	 */
	public void setMargenPVP(Double margenPVP) {
		this.margenPVP = margenPVP;
	}

	/**
	 * @return the margenSMX
	 */
	public Double getMargenSMX() {
		return margenSMX;
	}

	/**
	 * @param margenSMX the margenSMX to set
	 */
	public void setMargenSMX(Double margenSMX) {
		this.margenSMX = margenSMX;
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
	 * @return the valorCostoGestion
	 */
	public ValorCostoGestionDTO getValorCostoGestion() {
		return valorCostoGestion;
	}

	/**
	 * @param valorCostoGestion the valorCostoGestion to set
	 */
	public void setValorCostoGestion(ValorCostoGestionDTO valorCostoGestion) {
		this.valorCostoGestion = valorCostoGestion;
	}

	/**
	 * @return the tipoEstado
	 */
	public CatalogoValorDTO getTipoEstado() {
		return tipoEstado;
	}

	/**
	 * @param tipoEstado the tipoEstado to set
	 */
	public void setTipoEstado(CatalogoValorDTO tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

}
