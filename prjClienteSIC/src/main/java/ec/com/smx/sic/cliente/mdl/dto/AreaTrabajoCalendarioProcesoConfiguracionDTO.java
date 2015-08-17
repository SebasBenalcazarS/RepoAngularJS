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

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.AreaTrabajoCalendarioProcesoConfiguracionID;

/**
 * @author jvillacis
 * 
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "SBPEATARETRACALPROCON")
public class AreaTrabajoCalendarioProcesoConfiguracionDTO extends SimpleAuditDTO {

	@EmbeddedId
	private AreaTrabajoCalendarioProcesoConfiguracionID id = new AreaTrabajoCalendarioProcesoConfiguracionID();

	@Column(name = "CODIGOARETRACALPRO")
	private Long codigoAreaTrabajoCalendarioProceso;
	
	@Column(name = "CODIGOAREATRABAJO")
	private Integer codigoAreaTrabajo;
	
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
        @JoinColumn(name = "CODIGOARETRACALPRO", referencedColumnName = "CODIGOARETRACALPRO", insertable = false, updatable = false)
    })
    private AreaTrabajoCalendarioProcesoDTO areaTrabajoCalendarioProcesoDTO;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOAREATRABAJO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)
    })
    private AreaTrabajoDTO areaTrabajo;
    
    @OneToMany(mappedBy = "areaTrabajoCalendarioProcesoConfiguracionDTO")
    @CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO> areaTrabajoCalendarioProcesoConfiguracionDetalleDTOCol;
    
	/**
	 * @return the id
	 */
	public AreaTrabajoCalendarioProcesoConfiguracionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(AreaTrabajoCalendarioProcesoConfiguracionID id) {
		this.id = id;
	}

	/**
	 * @return the codigoAreaTrabajoCalendarioProceso
	 */
	public Long getCodigoAreaTrabajoCalendarioProceso() {
		return codigoAreaTrabajoCalendarioProceso;
	}

	/**
	 * @param codigoAreaTrabajoCalendarioProceso the codigoAreaTrabajoCalendarioProceso to set
	 */
	public void setCodigoAreaTrabajoCalendarioProceso(Long codigoAreaTrabajoCalendarioProceso) {
		this.codigoAreaTrabajoCalendarioProceso = codigoAreaTrabajoCalendarioProceso;
	}

	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
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
	 * @return the areaTrabajoCalendarioProcesoDTO
	 */
	public AreaTrabajoCalendarioProcesoDTO getAreaTrabajoCalendarioProcesoDTO() {
		return areaTrabajoCalendarioProcesoDTO;
	}

	/**
	 * @param areaTrabajoCalendarioProcesoDTO the areaTrabajoCalendarioProcesoDTO to set
	 */
	public void setAreaTrabajoCalendarioProcesoDTO(AreaTrabajoCalendarioProcesoDTO areaTrabajoCalendarioProcesoDTO) {
		this.areaTrabajoCalendarioProcesoDTO = areaTrabajoCalendarioProcesoDTO;
	}

	/**
	 * @return the areaTrabajo
	 */
	public AreaTrabajoDTO getAreaTrabajo() {
		return areaTrabajo;
	}

	/**
	 * @param areaTrabajo the areaTrabajo to set
	 */
	public void setAreaTrabajo(AreaTrabajoDTO areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	}

	/**
	 * @return the areaTrabajoCalendarioProcesoConfiguracionDetalleDTOCol
	 */
	public Collection<AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO> getAreaTrabajoCalendarioProcesoConfiguracionDetalleDTOCol() {
		return areaTrabajoCalendarioProcesoConfiguracionDetalleDTOCol;
	}

	/**
	 * @param areaTrabajoCalendarioProcesoConfiguracionDetalleDTOCol the areaTrabajoCalendarioProcesoConfiguracionDetalleDTOCol to set
	 */
	public void setAreaTrabajoCalendarioProcesoConfiguracionDetalleDTOCol(Collection<AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO> areaTrabajoCalendarioProcesoConfiguracionDetalleDTOCol) {
		this.areaTrabajoCalendarioProcesoConfiguracionDetalleDTOCol = areaTrabajoCalendarioProcesoConfiguracionDetalleDTOCol;
	}
	
}
