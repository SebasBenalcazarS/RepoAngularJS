package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.FormulaComponenteRegistroSanitarioID;

@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTFORCOMREGSAN")
public class FormulaComponenteRegistroSanitarioDTO extends SimpleAuditDTO implements Serializable{
	
	@EmbeddedId
	private FormulaComponenteRegistroSanitarioID id = new FormulaComponenteRegistroSanitarioID();
	
	/**
	 * clave foranea de la tabla agrupadorComponenteNutricional
	 */
	@Column(name="SECAGRCOMNUT", nullable = false)
	private Integer codAgrComNut;
	
	/**
	 * valor minimo de rango
	 */
	private Double valorMinimoRango;
	
	/**
	 * valor maximo de rango
	 */
	private Double valorMaximoRango;
	
	/**
	 * controla si incluye el valor minimo
	 */
	private Boolean incluirValorMinimo;
	
	/**
	 * controla si incluye el valor maximo
	 */
	private Boolean incluirValorMaximo;
	
	/**
	 * valor de referenica
	 */
	private Double valorReferencia;
	
	/**
	 * valor del tipo referencia medida
	 */
	private String valorTipoMedidaReferencia;
	
	/**
	 * codigo del tipo referencia medida
	 */
	private Integer codigoTipoMedidaReferencia;
	
	/**
	 * valor del nivel de concentracion
	 */
	private String valorNivelConcentracion;
	
	/**
	 * codigo del nivel de concentracion
	 */
	private Integer codigoNivelConcentracion;
	
	/**
	 * estado, los valores permitidos son: [0] INACTIVO, [1] ACTIVO
	 */
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Usuario que creó el registro
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la cual se creó el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Usuario que realiza la última actualización del registro
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la cual se realizó la ultima actualización del registro
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
		
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "SECAGRCOMNUT", referencedColumnName = "SECUENCIAL", insertable = false, updatable = false)
	private ComponenteNutricionalDTO componenteNutricionalDTO;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORNIVELCONCENTRACION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGONIVELCONCENTRACION", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO nivelConcentracionDTO;
	
	/**
	 * @return the id
	 */
	public FormulaComponenteRegistroSanitarioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(FormulaComponenteRegistroSanitarioID id) {
		this.id = id;
	}

	/**
	 * @return the codAgrComNut
	 */
	public Integer getCodAgrComNut() {
		return codAgrComNut;
	}

	/**
	 * @param codAgrComNut the codAgrComNut to set
	 */
	public void setCodAgrComNut(Integer codAgrComNut) {
		this.codAgrComNut = codAgrComNut;
	}

	/**
	 * @return the valorMinimoRango
	 */
	public Double getValorMinimoRango() {
		return valorMinimoRango;
	}

	/**
	 * @param valorMinimoRango the valorMinimoRango to set
	 */
	public void setValorMinimoRango(Double valorMinimoRango) {
		this.valorMinimoRango = valorMinimoRango;
	}

	/**
	 * @return the valorMaximoRango
	 */
	public Double getValorMaximoRango() {
		return valorMaximoRango;
	}

	/**
	 * @param valorMaximoRango the valorMaximoRango to set
	 */
	public void setValorMaximoRango(Double valorMaximoRango) {
		this.valorMaximoRango = valorMaximoRango;
	}

	/**
	 * @return the valorReferencia
	 */
	public Double getValorReferencia() {
		return valorReferencia;
	}

	/**
	 * @param valorReferencia the valorReferencia to set
	 */
	public void setValorReferencia(Double valorReferencia) {
		this.valorReferencia = valorReferencia;
	}

	/**
	 * @return the valorTipoMedidaReferencia
	 */
	public String getValorTipoMedidaReferencia() {
		return valorTipoMedidaReferencia;
	}

	/**
	 * @param valorTipoMedidaReferencia the valorTipoMedidaReferencia to set
	 */
	public void setValorTipoMedidaReferencia(String valorTipoMedidaReferencia) {
		this.valorTipoMedidaReferencia = valorTipoMedidaReferencia;
	}

	/**
	 * @return the codigoTipoMedidaReferencia
	 */
	public Integer getCodigoTipoMedidaReferencia() {
		return codigoTipoMedidaReferencia;
	}

	/**
	 * @param codigoTipoMedidaReferencia the codigoTipoMedidaReferencia to set
	 */
	public void setCodigoTipoMedidaReferencia(Integer codigoTipoMedidaReferencia) {
		this.codigoTipoMedidaReferencia = codigoTipoMedidaReferencia;
	}

	/**
	 * @return the valorNivelConcentracion
	 */
	public String getValorNivelConcentracion() {
		return valorNivelConcentracion;
	}

	/**
	 * @param valorNivelConcentracion the valorNivelConcentracion to set
	 */
	public void setValorNivelConcentracion(String valorNivelConcentracion) {
		this.valorNivelConcentracion = valorNivelConcentracion;
	}

	/**
	 * @return the codigoNivelConcentracion
	 */
	public Integer getCodigoNivelConcentracion() {
		return codigoNivelConcentracion;
	}

	/**
	 * @param codigoNivelConcentracion the codigoNivelConcentracion to set
	 */
	public void setCodigoNivelConcentracion(Integer codigoNivelConcentracion) {
		this.codigoNivelConcentracion = codigoNivelConcentracion;
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
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion() {
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;
	}

	public CatalogoValorDTO getNivelConcentracionDTO() {
		return nivelConcentracionDTO;
	}

	public void setNivelConcentracionDTO(CatalogoValorDTO nivelConcentracionDTO) {
		this.nivelConcentracionDTO = nivelConcentracionDTO;
	}

	public ComponenteNutricionalDTO getComponenteNutricionalDTO() {
		return componenteNutricionalDTO;
	}

	public void setComponenteNutricionalDTO(ComponenteNutricionalDTO componenteNutricionalDTO) {
		this.componenteNutricionalDTO = componenteNutricionalDTO;
	}

	public Boolean getIncluirValorMinimo() {
		return incluirValorMinimo;
	}

	public void setIncluirValorMinimo(Boolean incluirValorMinimo) {
		this.incluirValorMinimo = incluirValorMinimo;
	}

	public Boolean getIncluirValorMaximo() {
		return incluirValorMaximo;
	}

	public void setIncluirValorMaximo(Boolean incluirValorMaximo) {
		this.incluirValorMaximo = incluirValorMaximo;
	}
}
