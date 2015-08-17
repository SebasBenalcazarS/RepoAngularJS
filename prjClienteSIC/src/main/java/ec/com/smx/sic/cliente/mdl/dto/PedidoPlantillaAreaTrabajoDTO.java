/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.PedidoPlantillaAreaTrabajoID;

/**
 * @author jvillacis
 *
 */
@Entity
@Table(name = "SBPEATPEDPLAARETRA")
@SuppressWarnings("serial")
public class PedidoPlantillaAreaTrabajoDTO extends SimpleAuditDTO {
	@EmbeddedId
	private PedidoPlantillaAreaTrabajoID id = new PedidoPlantillaAreaTrabajoID();
	
	@Column(name = "CODIGOARETRACENDIS")
	private Integer codigoAreaTrabajoCentroDistribucion;
	
	@Column(name = "CODIGOARETRASUB")
	private Integer codigoAreaTrabajoSubbodega;
	
	@Column(name = "CODIGODIASEMANA")
	private Integer codigoDiaSemana;
	
	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo;
	
	@Column(name = "CODIGOUNIDADMANEJO")
	private Long codigoUnidadManejo;
	
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
    
    
    @ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOUNIDADMANEJO", referencedColumnName = "CODIGOUNIDADMANEJO", insertable = false, updatable = false)})
	private ArticuloUnidadManejoDTO articuloUnidadManejoDTO;
    
    @ManyToOne(fetch = LAZY)
  	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARETRACENDIS", referencedColumnName="CODIGOAREATRABAJO", insertable=false, updatable=false)})
  	private AreaTrabajoDTO areaTrabajoCentroDistribucion;
   
    @ManyToOne(fetch = LAZY)
  	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARETRASUB", referencedColumnName="CODIGOAREATRABAJO", insertable=false, updatable=false)})
  	private AreaTrabajoDTO areaTrabajoSubbodega;

    
	/**
	 * @return the id
	 */
	public PedidoPlantillaAreaTrabajoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PedidoPlantillaAreaTrabajoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoAreaTrabajoCentroDistribucion
	 */
	public Integer getCodigoAreaTrabajoCentroDistribucion() {
		return codigoAreaTrabajoCentroDistribucion;
	}

	/**
	 * @param codigoAreaTrabajoCentroDistribucion the codigoAreaTrabajoCentroDistribucion to set
	 */
	public void setCodigoAreaTrabajoCentroDistribucion(Integer codigoAreaTrabajoCentroDistribucion) {
		this.codigoAreaTrabajoCentroDistribucion = codigoAreaTrabajoCentroDistribucion;
	}

	/**
	 * @return the codigoAreaTrabajoSubbodega
	 */
	public Integer getCodigoAreaTrabajoSubbodega() {
		return codigoAreaTrabajoSubbodega;
	}

	/**
	 * @param codigoAreaTrabajoSubbodega the codigoAreaTrabajoSubbodega to set
	 */
	public void setCodigoAreaTrabajoSubbodega(Integer codigoAreaTrabajoSubbodega) {
		this.codigoAreaTrabajoSubbodega = codigoAreaTrabajoSubbodega;
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
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
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
	 * @return the articuloUnidadManejoDTO
	 */
	public ArticuloUnidadManejoDTO getArticuloUnidadManejoDTO() {
		return articuloUnidadManejoDTO;
	}

	/**
	 * @param articuloUnidadManejoDTO the articuloUnidadManejoDTO to set
	 */
	public void setArticuloUnidadManejoDTO(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) {
		this.articuloUnidadManejoDTO = articuloUnidadManejoDTO;
	}

	/**
	 * @return the areaTrabajoCentroDistribucion
	 */
	public AreaTrabajoDTO getAreaTrabajoCentroDistribucion() {
		return areaTrabajoCentroDistribucion;
	}

	/**
	 * @param areaTrabajoCentroDistribucion the areaTrabajoCentroDistribucion to set
	 */
	public void setAreaTrabajoCentroDistribucion(AreaTrabajoDTO areaTrabajoCentroDistribucion) {
		this.areaTrabajoCentroDistribucion = areaTrabajoCentroDistribucion;
	}

	/**
	 * @return the areaTrabajoSubbodega
	 */
	public AreaTrabajoDTO getAreaTrabajoSubbodega() {
		return areaTrabajoSubbodega;
	}

	/**
	 * @param areaTrabajoSubbodega the areaTrabajoSubbodega to set
	 */
	public void setAreaTrabajoSubbodega(AreaTrabajoDTO areaTrabajoSubbodega) {
		this.areaTrabajoSubbodega = areaTrabajoSubbodega;
	}
	
}
