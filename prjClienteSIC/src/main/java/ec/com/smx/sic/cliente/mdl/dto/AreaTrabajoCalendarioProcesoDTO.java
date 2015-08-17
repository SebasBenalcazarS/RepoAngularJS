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
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.ProcesoDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.AreaTrabajoCalendarioProcesoID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBPEATARETRACALPRO")
public class AreaTrabajoCalendarioProcesoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private AreaTrabajoCalendarioProcesoID id = new AreaTrabajoCalendarioProcesoID();
	
	@Column(name = "CODIGOPROCESO")
	private Long codigoProceso;
	
	@Column(name = "CODIGOAREATRABAJO")
	private Integer codigoAreaTrabajo;
	
	@Column(name = "CODIGOARETRACALPROPAD")
	private Long codigoAreaTrabajoCalendarioProcesoPadre;
	
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
        @JoinColumn(name = "CODIGOAREATRABAJO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)
    })
    private AreaTrabajoDTO areaTrabajo;
    
    @OneToMany(mappedBy = "areaTrabajoCalendarioProcesoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<AreaTrabajoCalendarioProcesoConfiguracionDTO> areaTrabajoCalendarioProcesoConfiguracionDTOCol;

    @OneToMany(mappedBy = "areaTrabajoCalendarioProcesoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<AreaTrabajoCalendarioProcesoDetalleDTO> areaTrabajoCalendarioProcesoDetalleDTOCol;
    
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOARETRACALPROPAD", referencedColumnName = "CODIGOARETRACALPRO", insertable = false, updatable = false)
    })
    private AreaTrabajoCalendarioProcesoDTO areaTrabajoCalendarioProcesoPadre;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false)
    })
    private ProcesoDTO proceso;
    
    @Transient
    private AreaTrabajoCalendarioProcesoDetalleDTO areaTrabajoCalendarioProcesoDetalle;


	/**
	 * @return the id
	 */
	public AreaTrabajoCalendarioProcesoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(AreaTrabajoCalendarioProcesoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoProceso
	 */
	public Long getCodigoProceso() {
		return codigoProceso;
	}

	/**
	 * @param codigoProceso the codigoProceso to set
	 */
	public void setCodigoProceso(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
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
	 * @return the codigoAreaTrabajoCalendarioProcesoPadre
	 */
	public Long getCodigoAreaTrabajoCalendarioProcesoPadre() {
		return codigoAreaTrabajoCalendarioProcesoPadre;
	}

	/**
	 * @param codigoAreaTrabajoCalendarioProcesoPadre the codigoAreaTrabajoCalendarioProcesoPadre to set
	 */
	public void setCodigoAreaTrabajoCalendarioProcesoPadre(Long codigoAreaTrabajoCalendarioProcesoPadre) {
		this.codigoAreaTrabajoCalendarioProcesoPadre = codigoAreaTrabajoCalendarioProcesoPadre;
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
	 * @return the areaTrabajoCalendarioProcesoPadre
	 */
	public AreaTrabajoCalendarioProcesoDTO getAreaTrabajoCalendarioProcesoPadre() {
		return areaTrabajoCalendarioProcesoPadre;
	}

	/**
	 * @param areaTrabajoCalendarioProcesoPadre the areaTrabajoCalendarioProcesoPadre to set
	 */
	public void setAreaTrabajoCalendarioProcesoPadre(AreaTrabajoCalendarioProcesoDTO areaTrabajoCalendarioProcesoPadre) {
		this.areaTrabajoCalendarioProcesoPadre = areaTrabajoCalendarioProcesoPadre;
	}

	/**
	 * @return the proceso
	 */
	public ProcesoDTO getProceso() {
		return proceso;
	}

	/**
	 * @param proceso the proceso to set
	 */
	public void setProceso(ProcesoDTO proceso) {
		this.proceso = proceso;
	}

	/**
	 * @return the areaTrabajoCalendarioProcesoDetalleDTOCol
	 */
	public Collection<AreaTrabajoCalendarioProcesoDetalleDTO> getAreaTrabajoCalendarioProcesoDetalleDTOCol() {
		return areaTrabajoCalendarioProcesoDetalleDTOCol;
	}

	/**
	 * @param areaTrabajoCalendarioProcesoDetalleDTOCol the areaTrabajoCalendarioProcesoDetalleDTOCol to set
	 */
	public void setAreaTrabajoCalendarioProcesoDetalleDTOCol(Collection<AreaTrabajoCalendarioProcesoDetalleDTO> areaTrabajoCalendarioProcesoDetalleDTOCol) {
		this.areaTrabajoCalendarioProcesoDetalleDTOCol = areaTrabajoCalendarioProcesoDetalleDTOCol;
	}

	/**
	 * @return the areaTrabajoCalendarioProcesoConfiguracionDTOCol
	 */
	public Collection<AreaTrabajoCalendarioProcesoConfiguracionDTO> getAreaTrabajoCalendarioProcesoConfiguracionDTOCol() {
		return areaTrabajoCalendarioProcesoConfiguracionDTOCol;
	}

	/**
	 * @param areaTrabajoCalendarioProcesoConfiguracionDTOCol the areaTrabajoCalendarioProcesoConfiguracionDTOCol to set
	 */
	public void setAreaTrabajoCalendarioProcesoConfiguracionDTOCol(Collection<AreaTrabajoCalendarioProcesoConfiguracionDTO> areaTrabajoCalendarioProcesoConfiguracionDTOCol) {
		this.areaTrabajoCalendarioProcesoConfiguracionDTOCol = areaTrabajoCalendarioProcesoConfiguracionDTOCol;
	}

	public AreaTrabajoCalendarioProcesoDetalleDTO getAreaTrabajoCalendarioProcesoDetalle() {
		return areaTrabajoCalendarioProcesoDetalle;
	}

	public void setAreaTrabajoCalendarioProcesoDetalle(AreaTrabajoCalendarioProcesoDetalleDTO areaTrabajoCalendarioProcesoDetalle) {
		this.areaTrabajoCalendarioProcesoDetalle = areaTrabajoCalendarioProcesoDetalle;
	}
}
