/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

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
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.AreaTrabajoCalendarioProcesoConfiguracionDetalleID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SBPEATARETRACALPROCONDET")
public class AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO extends SimpleAuditDTO {

	@EmbeddedId
	private AreaTrabajoCalendarioProcesoConfiguracionDetalleID id = new AreaTrabajoCalendarioProcesoConfiguracionDetalleID();
	
	@Column(name = "CODIGOARETRACALPRODET")
	private Long codigoAreaTrabajoCalendarioProcesoDetalle;
	
	@Column(name = "CODIGOARETRACALPROCON")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBPEASECARETRACALPROCON")
	private Long codigoAreaTrabajoCalendarioProcesoConfiguracion;
	
	@Column(name = "ESTADO")
    @ComparatorTypeField
    private String estado;

    @RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO")
    private String idUsuarioRegistro;
    
    @RegisterDateField
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @LastModifierUserIdField
    @Column(name = "IDUSUARIOMODIFICACION")
    private String idUsuarioModificacion;
    
    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOARETRACALPRODET", referencedColumnName = "CODIGOARETRACALPRODET", insertable = false, updatable = false)
    })
    private AreaTrabajoCalendarioProcesoDetalleDTO areaTrabajoCalendarioProcesoDetalleDTO;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOARETRACALPROCON", referencedColumnName = "CODIGOARETRACALPROCON", insertable = false, updatable = false)
    })
    private AreaTrabajoCalendarioProcesoConfiguracionDTO areaTrabajoCalendarioProcesoConfiguracionDTO;
    
    
	/**
	 * @return the id
	 */
	public AreaTrabajoCalendarioProcesoConfiguracionDetalleID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(AreaTrabajoCalendarioProcesoConfiguracionDetalleID id) {
		this.id = id;
	}

	/**
	 * @return the codigoAreaTrabajoCalendarioProcesoDetalle
	 */
	public Long getCodigoAreaTrabajoCalendarioProcesoDetalle() {
		return codigoAreaTrabajoCalendarioProcesoDetalle;
	}

	/**
	 * @param codigoAreaTrabajoCalendarioProcesoDetalle the codigoAreaTrabajoCalendarioProcesoDetalle to set
	 */
	public void setCodigoAreaTrabajoCalendarioProcesoDetalle(Long codigoAreaTrabajoCalendarioProcesoDetalle) {
		this.codigoAreaTrabajoCalendarioProcesoDetalle = codigoAreaTrabajoCalendarioProcesoDetalle;
	}

	/**
	 * @return the codigoAreaTrabajoCalendarioProcesoConfiguracion
	 */
	public Long getCodigoAreaTrabajoCalendarioProcesoConfiguracion() {
		return codigoAreaTrabajoCalendarioProcesoConfiguracion;
	}

	/**
	 * @param codigoAreaTrabajoCalendarioProcesoConfiguracion the codigoAreaTrabajoCalendarioProcesoConfiguracion to set
	 */
	public void setCodigoAreaTrabajoCalendarioProcesoConfiguracion(Long codigoAreaTrabajoCalendarioProcesoConfiguracion) {
		this.codigoAreaTrabajoCalendarioProcesoConfiguracion = codigoAreaTrabajoCalendarioProcesoConfiguracion;
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
	 * @return the areaTrabajoCalendarioProcesoDetalleDTO
	 */
	public AreaTrabajoCalendarioProcesoDetalleDTO getAreaTrabajoCalendarioProcesoDetalleDTO() {
		return areaTrabajoCalendarioProcesoDetalleDTO;
	}

	/**
	 * @param areaTrabajoCalendarioProcesoDetalleDTO the areaTrabajoCalendarioProcesoDetalleDTO to set
	 */
	public void setAreaTrabajoCalendarioProcesoDetalleDTO(AreaTrabajoCalendarioProcesoDetalleDTO areaTrabajoCalendarioProcesoDetalleDTO) {
		this.areaTrabajoCalendarioProcesoDetalleDTO = areaTrabajoCalendarioProcesoDetalleDTO;
	}

	/**
	 * @return the areaTrabajoCalendarioProcesoConfiguracionDTO
	 */
	public AreaTrabajoCalendarioProcesoConfiguracionDTO getAreaTrabajoCalendarioProcesoConfiguracionDTO() {
		return areaTrabajoCalendarioProcesoConfiguracionDTO;
	}

	/**
	 * @param areaTrabajoCalendarioProcesoConfiguracionDTO the areaTrabajoCalendarioProcesoConfiguracionDTO to set
	 */
	public void setAreaTrabajoCalendarioProcesoConfiguracionDTO(AreaTrabajoCalendarioProcesoConfiguracionDTO areaTrabajoCalendarioProcesoConfiguracionDTO) {
		this.areaTrabajoCalendarioProcesoConfiguracionDTO = areaTrabajoCalendarioProcesoConfiguracionDTO;
	}
}
