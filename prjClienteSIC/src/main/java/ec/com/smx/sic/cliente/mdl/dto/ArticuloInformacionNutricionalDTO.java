package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

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
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloInformacionNutricionalID;

@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTINFNUT")
public class ArticuloInformacionNutricionalDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ArticuloInformacionNutricionalID id = new ArticuloInformacionNutricionalID();
	
	/**
	 * estado del componente nutricional, los valores permitidos son: [0] INACTIVO, [1] ACTIVO
	 */
	@ComparatorTypeField
	private String estado;
	
	/**
	 * valor de la cantidad del componente nutricional
	 */
	private Double valorCantidad;
	
	/**
	 * valor del porcentaje del componente nutricional
	 */
	private Double valorPorcentaje;
	/**
	 * valor de la densidad del componente nutricional
	 */
	private Double valorDensidad;
	
	/**
	 * codigo del tipo unidad de medida
	 */
	private Integer codigoTipoUnidadMedida;
	
	/**
	 * valor del tipo unidad medida
	 */
	private String valorTipoUnidadMedida;
	
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
	@JoinColumns({@JoinColumn(name="VALORTIPOUNIDADMEDIDA", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOUNIDADMEDIDA", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoUnidadMedida;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOREGISTROSANITARIO", insertable=false, updatable=false, referencedColumnName="CODIGOREGSANART")})
	private ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name="SECCOMNUT", insertable=false, updatable=false, referencedColumnName="SECUENCIAL")
	private ComponenteNutricionalDTO componenteNutricionalDTO;

	/**
	 * @return the id
	 */
	public ArticuloInformacionNutricionalID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloInformacionNutricionalID id) {
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

	/**
	 * @return the tipoUnidadMedida
	 */
	public CatalogoValorDTO getTipoUnidadMedida() {
		return tipoUnidadMedida;
	}

	/**
	 * @param tipoUnidadMedida the tipoUnidadMedida to set
	 */
	public void setTipoUnidadMedida(CatalogoValorDTO tipoUnidadMedida) {
		this.tipoUnidadMedida = tipoUnidadMedida;
	}

	/**
	 * @return the articuloRegistroSanitarioDTO
	 */
	public ArticuloRegistroSanitarioDTO getArticuloRegistroSanitarioDTO() {
		return articuloRegistroSanitarioDTO;
	}

	/**
	 * @param articuloRegistroSanitarioDTO the articuloRegistroSanitarioDTO to set
	 */
	public void setArticuloRegistroSanitarioDTO(ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO) {
		this.articuloRegistroSanitarioDTO = articuloRegistroSanitarioDTO;
	}

	public ComponenteNutricionalDTO getComponenteNutricionalDTO() {
		return componenteNutricionalDTO;
	}

	public void setComponenteNutricionalDTO(ComponenteNutricionalDTO componenteNutricionalDTO) {
		this.componenteNutricionalDTO = componenteNutricionalDTO;
	}

	public Double getValorCantidad() {
		return valorCantidad;
	}

	public void setValorCantidad(Double valorCantidad) {
		this.valorCantidad = valorCantidad;
	}

	public Double getValorPorcentaje() {
		return valorPorcentaje;
	}

	public void setValorPorcentaje(Double valorPorcentaje) {
		this.valorPorcentaje = valorPorcentaje;
	}

	public Integer getCodigoTipoUnidadMedida() {
		return codigoTipoUnidadMedida;
	}

	public void setCodigoTipoUnidadMedida(Integer codigoTipoUnidadMedida) {
		this.codigoTipoUnidadMedida = codigoTipoUnidadMedida;
	}

	public String getValorTipoUnidadMedida() {
		return valorTipoUnidadMedida;
	}

	public void setValorTipoUnidadMedida(String valorTipoUnidadMedida) {
		this.valorTipoUnidadMedida = valorTipoUnidadMedida;
	}

	public Double getValorDensidad() {
		return valorDensidad;
	}

	public void setValorDensidad(Double valorDensidad) {
		this.valorDensidad = valorDensidad;
	}


}
