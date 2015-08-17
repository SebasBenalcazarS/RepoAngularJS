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
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.ProcesoDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.AreaTrabajoCalendarioProcesoDetalleID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SBPEATARETRACALPRODET")
public class AreaTrabajoCalendarioProcesoDetalleDTO extends SimpleAuditDTO {

	@EmbeddedId
	private AreaTrabajoCalendarioProcesoDetalleID id = new AreaTrabajoCalendarioProcesoDetalleID();
	
	@Column(name = "CODIGOARETRACALPRO")
	private Long codigoAreaTrabajoCalendarioProceso;
	
	@Column(name = "CODIGOPROCESO")
	private Long codigoProceso;
	
	@Column(name = "CODIGODIASEMANA")
	private Integer codigoDiaSemana;
	
	@Column(name = "VALORPROCESO")
	private String valorProceso;
	
	@Column(name = "CODIGOVALORPROCESOCATVAL")
	private String codigoValorProcesoCatVal;
	
	@Column(name = "CODIGOVALORPROCESOCATTIP")
	private Integer codigoValorProcesoCatTip;
	
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
    
    @Column(name = "FECHAINICIOBLOQUEO")
	private Date fechaInicioBloqueo;
    
    @Column(name = "FECHAFINBLOQUEO")
	private Date fechaFinBloqueo;
    
   
    @OneToMany(mappedBy = "areaTrabajoCalendarioProcesoDetalleDTO")
 	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO> areaTrabajoCalendarioProcesoConfiguracionDetalleDTOCol;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOARETRACALPRO", referencedColumnName = "CODIGOARETRACALPRO", insertable = false, updatable = false)
    })
    private AreaTrabajoCalendarioProcesoDTO areaTrabajoCalendarioProcesoDTO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false)
    })
    private ProcesoDTO procesoDTO;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOVALORPROCESOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOVALORPROCESOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO tipoBloqueo;
    

	/**
	 * @return the id
	 */
	public AreaTrabajoCalendarioProcesoDetalleID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(AreaTrabajoCalendarioProcesoDetalleID id) {
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
	 * @return the codigoDiaSemana
	 */
	public Integer getCodigoDiaSemana() {
		return codigoDiaSemana;
	}

	/**
	 * @param codigoDiaSemana the codigoDiaSemana to set
	 */
	public void setCodigoDiaSemana(Integer codigoDiaSemana) {
		this.codigoDiaSemana = codigoDiaSemana;
	}

	/**
	 * @return the valorProceso
	 */
	public String getValorProceso() {
		return valorProceso;
	}

	/**
	 * @param valorProceso the valorProceso to set
	 */
	public void setValorProceso(String valorProceso) {
		this.valorProceso = valorProceso;
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

	/**
	 * @return the procesoDTO
	 */
	public ProcesoDTO getProcesoDTO() {
		return procesoDTO;
	}

	/**
	 * @param procesoDTO the procesoDTO to set
	 */
	public void setProcesoDTO(ProcesoDTO procesoDTO) {
		this.procesoDTO = procesoDTO;
	}

	/**
	 * @return the codigoValorProcesoCatVal
	 */
	public String getCodigoValorProcesoCatVal() {
		return codigoValorProcesoCatVal;
	}

	/**
	 * @param codigoValorProcesoCatVal the codigoValorProcesoCatVal to set
	 */
	public void setCodigoValorProcesoCatVal(String codigoValorProcesoCatVal) {
		this.codigoValorProcesoCatVal = codigoValorProcesoCatVal;
	}

	/**
	 * @return the codigoValorProcesoCatTip
	 */
	public Integer getCodigoValorProcesoCatTip() {
		return codigoValorProcesoCatTip;
	}

	/**
	 * @param codigoValorProcesoCatTip the codigoValorProcesoCatTip to set
	 */
	public void setCodigoValorProcesoCatTip(Integer codigoValorProcesoCatTip) {
		this.codigoValorProcesoCatTip = codigoValorProcesoCatTip;
	}

	/**
	 * @return the tipoBloqueo
	 */
	public CatalogoValorDTO getTipoBloqueo() {
		return tipoBloqueo;
	}

	/**
	 * @param tipoBloqueo the tipoBloqueo to set
	 */
	public void setTipoBloqueo(CatalogoValorDTO tipoBloqueo) {
		this.tipoBloqueo = tipoBloqueo;
	}

	public Date getFechaInicioBloqueo() {
		return fechaInicioBloqueo;
	}

	public void setFechaInicioBloqueo(Date fechaInicioBloqueo) {
		this.fechaInicioBloqueo = fechaInicioBloqueo;
	}

	public Date getFechaFinBloqueo() {
		return fechaFinBloqueo;
	}

	public void setFechaFinBloqueo(Date fechaFinBloqueo) {
		this.fechaFinBloqueo = fechaFinBloqueo;
	}
}
