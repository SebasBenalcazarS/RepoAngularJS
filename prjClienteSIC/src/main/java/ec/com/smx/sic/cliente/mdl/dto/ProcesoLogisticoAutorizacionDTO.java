package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.autorizaciones.common.util.AutorizacionesDescriptorSecuencias;
import ec.com.smx.autorizaciones.dto.AutorizacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ProcesoLogisticoAutorizacionID;

/**
 * @author cpescobar
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTPROLOGAUT")
public class ProcesoLogisticoAutorizacionDTO extends AuditoriaBaseDTO{
	
	@EmbeddedId 
	private ProcesoLogisticoAutorizacionID id = new ProcesoLogisticoAutorizacionID();
	
	/**
	 * Estado del registro
	 */
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Codigo de la tabla ProcesoLogistico
	 */
	@Column(name = "CODIGOPROCESOLOGISTICO", nullable = false)
	private Long codigoProcesoLogistico;
	
	/**
	 * Este campo representa el secuencial del codigo de autorizacion
	 */
	@Column(name = "CODIGOAUTORIZACION")
	@SequenceDataBaseValue(descriptorClass=AutorizacionesDescriptorSecuencias.class, name="KSSEGSECAUT")
	private Long codigoAutorizacion;
	
	/**
	 * Este campo representa el codigo del sistema que tiene la autorizacion
	 */
	@Column(name = "CODIGOSISTEMA")
	private String codigoSistema;
	
	/**
	 * Relacion con el proceso logistico
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA",referencedColumnName="CODIGOCOMPANIA",insertable=false,updatable=false),
		@JoinColumn(name="CODIGOPROCESOLOGISTICO",referencedColumnName="CODIGOPROCESOLOGISTICO",insertable=false,updatable=false)})
	private ProcesoLogisticoDTO procesoLogisticoDTO;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA",referencedColumnName="CODIGOCOMPANIA",insertable=false,updatable=false),
		@JoinColumn(name="CODIGOAUTORIZACION",referencedColumnName="CODIGOAUTORIZACION",insertable=false,updatable=false),
		@JoinColumn(name="CODIGOSISTEMA",referencedColumnName="CODIGOSISTEMA", insertable=false,updatable=false)})
	private AutorizacionDTO autorizacionDTO;
	
	/**
	 * @return the id
	 */
	public ProcesoLogisticoAutorizacionID getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(ProcesoLogisticoAutorizacionID id) {
		this.id = id;
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
	 * @return the procesoLogisticoDTO
	 */
	public ProcesoLogisticoDTO getProcesoLogisticoDTO() {
		return procesoLogisticoDTO;
	}
	
	/**
	 * @param procesoLogisticoDTO the procesoLogisticoDTO to set
	 */
	public void setProcesoLogisticoDTO(ProcesoLogisticoDTO procesoLogisticoDTO) {
		this.procesoLogisticoDTO = procesoLogisticoDTO;
	}
	
	/**
	 * @return the autorizacionDTO
	 */
	public AutorizacionDTO getAutorizacionDTO() {
		return autorizacionDTO;
	}
	
	/**
	 * @param autorizacionDTO the autorizacionDTO to set
	 */
	public void setAutorizacionDTO(AutorizacionDTO autorizacionDTO) {
		this.autorizacionDTO = autorizacionDTO;
	}

	/**
	 * @return the codigoProcesoLogistico
	 */
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	/**
	 * @param codigoProcesoLogistico the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}

	/**
	 * @return the codigoAutorizacion
	 */
	public Long getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	/**
	 * @param codigoAutorizacion the codigoAutorizacion to set
	 */
	public void setCodigoAutorizacion(Long codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}

	/**
	 * @return the codigoSistema
	 */
	public String getCodigoSistema() {
		return codigoSistema;
	}

	/**
	 * @param codigoSistema the codigoSistema to set
	 */
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}
	
	
}
