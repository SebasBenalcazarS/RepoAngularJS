package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.util.Collection;
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
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.smx.sic.cliente.mdl.dto.id.AsignacionArticuloUnidadManejoID;

/**
 * Almacena las unidades de manejo que posee un detalle de seccion (Ubicaci�n)
 * 
 * @author acaiza
 * @author fcollaguazo
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SBLOGTASIARTUNIMAN")
public class AsignacionArticuloUnidadManejoDTO extends AuditoriaBaseDTO {

	/**
	 * Clave primaria de la tabla AsignacionArticulo
	 * 
	 */
	@EmbeddedId
	private AsignacionArticuloUnidadManejoID id;

	public AsignacionArticuloUnidadManejoDTO() {
		id = new AsignacionArticuloUnidadManejoID();
	}
	
	@Column
	private Integer cantidad;

	/**
	 * Especifica la fecha de caducidad que posee una unidad de manejo
	 * 
	 */
	@Column
	private java.sql.Timestamp fechaCaducidad;
	
	/**
	 * Representa la fecha de elaboracion del producto.
	 *
	 */
	@Column
	@LastModificationDateField
	private java.sql.Timestamp fechaElaboracion ;

	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 * 
	 */
	@Column
	@ComparatorTypeField
	private String estado;

	/**
	 * Especifica la relacion con DetalleSeccion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGODETALLESECCION", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false) })
	private DetalleSeccionDTO detalleSeccionDTO;

	
	
	/**
	 * Especifica la relacion con DetalleSeccion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOUNIDADMANEJO", referencedColumnName = "CODIGOUNIDADMANEJO", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false) })
	private ArticuloUnidadManejoDTO articuloUnidadManejoDTO;

	@Transient
	private Boolean plegar = Boolean.FALSE;
	// coleccion de hijos AsignacionArticuloUnidadManejoDTO
	@Transient
	private Collection<AsignacionArticuloUnidadManejoDTO> subAsignacionArticuloUnidadManejoDTOCol;

	@Column
	private BigDecimal porcentajeMinimo;
	
	@Column
	private String lote;
	
	@Column
	private Date fechaRecepcion;
	
	/**
	 * @return the id
	 */
	public AsignacionArticuloUnidadManejoID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(AsignacionArticuloUnidadManejoID id) {
		this.id = id;
	}

	

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the detalleSeccionDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionDTO() {
		return detalleSeccionDTO;
	}

	/**
	 * @param detalleSeccionDTO
	 *            the detalleSeccionDTO to set
	 */
	public void setDetalleSeccionDTO(DetalleSeccionDTO detalleSeccionDTO) {
		this.detalleSeccionDTO = detalleSeccionDTO;
	}

	/**
	 * @return the articuloUnidadManejoDTO
	 */
	public ArticuloUnidadManejoDTO getArticuloUnidadManejoDTO() {
		return articuloUnidadManejoDTO;
	}

	/**
	 * @param articuloUnidadManejoDTO
	 *            the articuloUnidadManejoDTO to set
	 */
	public void setArticuloUnidadManejoDTO(
			ArticuloUnidadManejoDTO articuloUnidadManejoDTO) {
		this.articuloUnidadManejoDTO = articuloUnidadManejoDTO;
	}

	/**
	 * @return the fechaCaducidad
	 */
	public java.sql.Timestamp getFechaCaducidad() {
		return fechaCaducidad;
	}

	/**
	 * @param fechaCaducidad
	 *            the fechaCaducidad to set
	 */
	public void setFechaCaducidad(java.sql.Timestamp fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public void setSubAsignacionArticuloUnidadManejoDTOCol(
			Collection<AsignacionArticuloUnidadManejoDTO> subAsignacionArticuloUnidadManejoDTOCol) {
		this.subAsignacionArticuloUnidadManejoDTOCol = subAsignacionArticuloUnidadManejoDTOCol;
	}

	public Collection<AsignacionArticuloUnidadManejoDTO> getSubAsignacionArticuloUnidadManejoDTOCol() {
		return subAsignacionArticuloUnidadManejoDTOCol;
	}

	public void setPlegar(Boolean plegar) {
		this.plegar = plegar;
	}

	public Boolean getPlegar() {
		return plegar;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the porcentajeMinimo
	 */
	public BigDecimal getPorcentajeMinimo() {
		return porcentajeMinimo;
	}

	/**
	 * @param porcentajeMinimo the porcentajeMinimo to set
	 */
	public void setPorcentajeMinimo(BigDecimal porcentajeMinimo) {
		this.porcentajeMinimo = porcentajeMinimo;
	}

	/**
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}

	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}

	/**
	 * @return the fechaElaboracion
	 */
	public java.sql.Timestamp getFechaElaboracion() {
		return fechaElaboracion;
	}

	/**
	 * @param fechaElaboracion the fechaElaboracion to set
	 */
	public void setFechaElaboracion(java.sql.Timestamp fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}

	/**
	 * @return the fechaRecepcion
	 */
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	/**
	 * @param fechaRecepcion the fechaRecepcion to set
	 */
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}



	
}