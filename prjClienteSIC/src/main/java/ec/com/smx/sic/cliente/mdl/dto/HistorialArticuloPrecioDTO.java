package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.HistorialArticuloPrecioID;

/**
 * @author Luis Yacchirema
 *
 */
@Entity
@Table(name="SCPRETHISARTPRE")
@SuppressWarnings("serial")
public class HistorialArticuloPrecioDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private HistorialArticuloPrecioID id = new HistorialArticuloPrecioID();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAVIGENCIAINICIO", nullable = false)	
	private Date fechaVigenciaInicio ;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAVIGENCIAFIN")	
	private Date fechaVigenciaFin ;

	@Column( name = "PRECIOPVPANTERIOR", nullable = false)
	private Double precioPVPAnterior;

	@Column( name = "PRECIOPVPNUEVO", nullable = false )	
	private Double precioPVPNuevo;

	@Column(name = "PRECIOSMXANTERIOR", nullable = false)
	private Double precioSMXAnterior;

	@Column ( name = "PRECIOSMXNUEVO", nullable = false)	
	private Double precioSMXNuevo;

	@Column ( name = "PRECIOSMXNOAFILIADOANTERIOR", nullable = false)
	private Double precioSMXNoAfiliadoAnterior;

	@Column ( name = "PRECIOSMXNOAFILIANONUEVO", nullable = false)  
	private Double precioSMXNoAfiliadoNuevo;

	@Column (name = "OBSERVACION")
	private String observacion;

	@ComparatorTypeField
	@Column (name = "ESTADO", nullable = false)
	private String estado;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloDTO articulo;
	
	@OneToMany(mappedBy="historialArticuloPrecio")
	@CollectionTypeInfo(name=SICConstantes.USERTYPE_COLLECTION)
	private Collection<HistorialPrecioDiferenciadoArticuloDTO> historialPreciosDiferenciadosArticulo;
	
	/**
	 * @return the id
	 */
	public HistorialArticuloPrecioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(HistorialArticuloPrecioID id) {
		this.id = id;
	}

	/**
	 * @return the fechaVigenciaInicio
	 */
	public Date getFechaVigenciaInicio() {
		return fechaVigenciaInicio;
	}

	/**
	 * @param fechaVigenciaInicio the fechaVigenciaInicio to set
	 */
	public void setFechaVigenciaInicio(Date fechaVigenciaInicio) {
		this.fechaVigenciaInicio = fechaVigenciaInicio;
	}

	/**
	 * @return the fechaVigenciaFin
	 */
	public Date getFechaVigenciaFin() {
		return fechaVigenciaFin;
	}

	/**
	 * @param fechaVigenciaFin the fechaVigenciaFin to set
	 */
	public void setFechaVigenciaFin(Date fechaVigenciaFin) {
		this.fechaVigenciaFin = fechaVigenciaFin;
	}

	/**
	 * @return the precioPVPAnterior
	 */
	public Double getPrecioPVPAnterior() {
		return precioPVPAnterior;
	}

	/**
	 * @param precioPVPAnterior the precioPVPAnterior to set
	 */
	public void setPrecioPVPAnterior(Double precioPVPAnterior) {
		this.precioPVPAnterior = precioPVPAnterior;
	}

	/**
	 * @return the precioPVPNuevo
	 */
	public Double getPrecioPVPNuevo() {
		return precioPVPNuevo;
	}

	/**
	 * @param precioPVPNuevo the precioPVPNuevo to set
	 */
	public void setPrecioPVPNuevo(Double precioPVPNuevo) {
		this.precioPVPNuevo = precioPVPNuevo;
	}

	/**
	 * @return the precioSMXAnterior
	 */
	public Double getPrecioSMXAnterior() {
		return precioSMXAnterior;
	}

	/**
	 * @param precioSMXAnterior the precioSMXAnterior to set
	 */
	public void setPrecioSMXAnterior(Double precioSMXAnterior) {
		this.precioSMXAnterior = precioSMXAnterior;
	}

	/**
	 * @return the precioSMXNuevo
	 */
	public Double getPrecioSMXNuevo() {
		return precioSMXNuevo;
	}

	/**
	 * @param precioSMXNuevo the precioSMXNuevo to set
	 */
	public void setPrecioSMXNuevo(Double precioSMXNuevo) {
		this.precioSMXNuevo = precioSMXNuevo;
	}

	/**
	 * @return the precioSMXNoAfiliadoAnterior
	 */
	public Double getPrecioSMXNoAfiliadoAnterior() {
		return precioSMXNoAfiliadoAnterior;
	}

	/**
	 * @param precioSMXNoAfiliadoAnterior the precioSMXNoAfiliadoAnterior to set
	 */
	public void setPrecioSMXNoAfiliadoAnterior(Double precioSMXNoAfiliadoAnterior) {
		this.precioSMXNoAfiliadoAnterior = precioSMXNoAfiliadoAnterior;
	}

	/**
	 * @return the precioSMXNoAfiliadoNuevo
	 */
	public Double getPrecioSMXNoAfiliadoNuevo() {
		return precioSMXNoAfiliadoNuevo;
	}

	/**
	 * @param precioSMXNoAfiliadoNuevo the precioSMXNoAfiliadoNuevo to set
	 */
	public void setPrecioSMXNoAfiliadoNuevo(Double precioSMXNoAfiliadoNuevo) {
		this.precioSMXNoAfiliadoNuevo = precioSMXNoAfiliadoNuevo;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
	 * @return the articulo
	 */
	public ArticuloDTO getArticulo() {
		return articulo;
	}

	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	/**
	 * @return the historialPreciosDiferenciadosArticulo
	 */
	public Collection<HistorialPrecioDiferenciadoArticuloDTO> getHistorialPreciosDiferenciadosArticulo() {
		return historialPreciosDiferenciadosArticulo;
	}

	/**
	 * @param historialPreciosDiferenciadosArticulo the historialPreciosDiferenciadosArticulo to set
	 */
	public void setHistorialPreciosDiferenciadosArticulo(Collection<HistorialPrecioDiferenciadoArticuloDTO> historialPreciosDiferenciadosArticulo) {
		this.historialPreciosDiferenciadosArticulo = historialPreciosDiferenciadosArticulo;
	}
	
}
