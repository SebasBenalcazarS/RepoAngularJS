/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.ProcesoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ParametroRangoFechaID;

/**
 * @author gnolivos
 *
 */
@Entity
@Table(name="SCFRUTPARRANFEC")
@SuppressWarnings("serial")
public class ParametroRangoFechaDTO extends AuditoriaBaseDTO{
	
	@EmbeddedId
	private ParametroRangoFechaID id = new ParametroRangoFechaID();
	
	@ComparatorTypeField
	@Column (name = "CODIGOPROCESO", nullable = false)
	private Long codigoProceso;
	
	@Column (name = "NOMBRE")
	private String nombre;
	
	@Column (name = "DESCRIPCION")
	private String descripcion;
	
	@Column (name = "DIAINICIAL", nullable = false)
	private Integer diaInicial;

	@Column (name = "CANTIDADDIAS", nullable = false)
	private Integer cantidadDias;
	
	@Column (name = "HORAINICIAL", nullable = false)
	private Time horaInicial;
	
	@Column (name = "HORAFINAL")
	private Time horaFinal;
	
	@Transient
	private Date fechaInicial;
	
	@Transient
	private Date fechaFinal;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false)})
	private ProcesoDTO procesoDTO;

	/**
	 * @return the id
	 */
	public ParametroRangoFechaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ParametroRangoFechaID id) {
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the diaInicial
	 */
	public Integer getDiaInicial() {
		return diaInicial;
	}

	/**
	 * @param diaInicial the diaInicial to set
	 */
	public void setDiaInicial(Integer diaInicial) {
		this.diaInicial = diaInicial;
	}

	/**
	 * @return the cantidadDias
	 */
	public Integer getCantidadDias() {
		return cantidadDias;
	}

	/**
	 * @param cantidadDias the cantidadDias to set
	 */
	public void setCantidadDias(Integer cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	/**
	 * @return the horaInicial
	 */
	public Time getHoraInicial() {
		return horaInicial;
	}

	/**
	 * @param horaInicial the horaInicial to set
	 */
	public void setHoraInicial(Time horaInicial) {
		this.horaInicial = horaInicial;
	}

	/**
	 * @return the horaFinal
	 */
	public Time getHoraFinal() {
		return horaFinal;
	}

	/**
	 * @param horaFinal the horaFinal to set
	 */
	public void setHoraFinal(Time horaFinal) {
		this.horaFinal = horaFinal;
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

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
	

}
