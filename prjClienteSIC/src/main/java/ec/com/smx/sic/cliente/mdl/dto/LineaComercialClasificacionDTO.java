/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.LineaComercialClasificacionID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCADMTLINCOMCLA")
public class LineaComercialClasificacionDTO extends SimpleAuditDTO{

	@EmbeddedId
	private LineaComercialClasificacionID id = new LineaComercialClasificacionID();
	
	@Column(name = "CODIGOLINEACOMERCIAL")
    private Long codigoLineaComercial;
	
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private String estado;
	
	@RegisterUserIdField
	@Column(name = "IDUSUARIOREGISTRO")
	@ComparatorTypeField
	private String idUsuarioRegistro;
	
	@RegisterDateField
	@Column(name = "FECHAREGISTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@LastModifierUserIdField
	@Column(name = "IDUSUARIOMODIFICACION")
	@ComparatorTypeField
	private String idUsuarioModificacion;
	
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOLINEACOMERCIAL", referencedColumnName = "CODIGOLINEACOMERCIAL", insertable = false, updatable = false)
	})
	private LineaComercialDTO lineaComercial;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false)
	})
	private ClasificacionDTO clasificacion;
	
	@OneToMany(mappedBy = "lineaComercialClasificacion")
    @CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<LineaComercialFuncionarioClasificacionDTO> lineaComercialFuncionarioClasificacionCol; 
	
	@Transient
	private Boolean isSelected = Boolean.FALSE;
	/**
	 * @return the codigoLineaComercial
	 */
	public Long getCodigoLineaComercial() {
		return codigoLineaComercial;
	}

	/**
	 * @param codigoLineaComercial the codigoLineaComercial to set
	 */
	public void setCodigoLineaComercial(Long codigoLineaComercial) {
		this.codigoLineaComercial = codigoLineaComercial;
	}

	/**
	 * @return the id
	 */
	public LineaComercialClasificacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(LineaComercialClasificacionID id) {
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
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
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
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the lineaComercial
	 */
	public LineaComercialDTO getLineaComercial() {
		return lineaComercial;
	}

	/**
	 * @param lineaComercial the lineaComercial to set
	 */
	public void setLineaComercial(LineaComercialDTO lineaComercial) {
		this.lineaComercial = lineaComercial;
	}

	/**
	 * @return the clasificacion
	 */
	public ClasificacionDTO getClasificacion() {
		return clasificacion;
	}

	/**
	 * @param clasificacion the clasificacion to set
	 */
	public void setClasificacion(ClasificacionDTO clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

	public Collection<LineaComercialFuncionarioClasificacionDTO> getLineaComercialFuncionarioClasificacionCol() {
		return lineaComercialFuncionarioClasificacionCol;
	}

	public void setLineaComercialFuncionarioClasificacionCol(Collection<LineaComercialFuncionarioClasificacionDTO> lineaComercialFuncionarioClasificacionCol) {
		this.lineaComercialFuncionarioClasificacionCol = lineaComercialFuncionarioClasificacionCol;
	}

	
	
	
	
}
