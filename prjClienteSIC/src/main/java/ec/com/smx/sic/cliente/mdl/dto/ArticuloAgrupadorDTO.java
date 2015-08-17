package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloAgrupadorID;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloDuracionConservacion
 * 
 * @author fmunoz
 */
@Entity
@Table(name = "SCARTTARTAGR")
@SuppressWarnings("serial")
public class ArticuloAgrupadorDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ArticuloAgrupadorID id = new ArticuloAgrupadorID();

	/**
	 * Estado del registro (1/0)
	 */
	@ComparatorTypeField
	private String estado ;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realiza la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiza la ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;
	
	@OneToMany(mappedBy = "articuloAgrupadorPrincipal")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloAgrupadorRelacionDTO> articuloAgrupadorRelacionDTOs;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="VALORTIPOAGRUPADOR", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOAGRUPADOR", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")}
	)
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoAgrupador;
	
	/**
	 * @return the id
	 */
	public ArticuloAgrupadorID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloAgrupadorID id) {
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
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the articulo
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticulo() {
		return articulo;
	}

	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	/**
	 * @return the tipoAgrupador
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoAgrupador() {
		return tipoAgrupador;
	}

	/**
	 * @param tipoAgrupador the tipoAgrupador to set
	 */
	public void setTipoAgrupador(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoAgrupador) {
		this.tipoAgrupador = tipoAgrupador;
	}

	/**
	 * @return the articuloAgrupadorRelacionDTOs
	 */
	public Collection<ArticuloAgrupadorRelacionDTO> getArticuloAgrupadorRelacionDTOs() {
		return articuloAgrupadorRelacionDTOs;
	}

	/**
	 * @param articuloAgrupadorRelacionDTOs the articuloAgrupadorRelacionDTOs to set
	 */
	public void setArticuloAgrupadorRelacionDTOs(Collection<ArticuloAgrupadorRelacionDTO> articuloAgrupadorRelacionDTOs) {
		this.articuloAgrupadorRelacionDTOs = articuloAgrupadorRelacionDTOs;
	}
	
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n de las relaciones del agrupador
	 * @return
	 */
	public Boolean getTieneArticuloAgrupadorRelacion() {
		return isLoaded(this.articuloAgrupadorRelacionDTOs);
	}
}
