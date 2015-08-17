/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaUbicacionesID;

/**
 * @author jmontenegro
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SBLOGVUBICACION")
public class VistaUbicacionesDTO extends SearchDTO{

	

	@EmbeddedId
	private VistaUbicacionesID id = new VistaUbicacionesID();

	@Column
	private java.lang.Long rowNumber;

	@Column
	private Integer codigoAreaTrabajoBodega;

	@Column
	private Integer codigoReferenciaBodega;

	@Column
	private Integer codigoAreatrabajoSubBodega;

	@Column
	private String nombreAreaTrabajoSubBodega;

	@Column
	private Integer codigoReferenciaSubBodega;

	@Column
	private String nombreNave;

	@Column
	private String nombreSubNave;
	
	@Column
	private String nombreArea;

	@Column
	private String identificadorPasillo;

	@Column
	private String identificadorRack;

	@Column
	private java.lang.Long codigoDetalleSeccionRack;
	
	@Column
	private java.lang.Long codigoDetalleSeccionArea;

	@Column
	private String identificadorUbicacion;

	@Column
	private java.lang.Long codigoSeccionUbicacion;

	@Column
	private Integer tipoAlmacenamiento;

	@Column
	private String valorAlmacenamiento;

	@Column
	private Integer tipoUbicacion;

	@Column
	private String valorUbicacion;
	
	/**
	 * Obtiene la coleccion de asignacion de articulo unidad de manejo
	 */
	@OneToMany(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGODETALLESECCION", referencedColumnName = "CODIGODETALLESECCIONUBICACION", insertable = false, updatable = false)
		})
	private Collection<AsignacionArticuloUnidadManejoDTO> asignacionArticuloUnidadManejoCol;

	/**
	 * @return the id
	 */
	public VistaUbicacionesID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaUbicacionesID id) {
		this.id = id;
	}

	/**
	 * @return the rowNumber
	 */
	public java.lang.Long getRowNumber() {
		return rowNumber;
	}

	/**
	 * @param rowNumber the rowNumber to set
	 */
	public void setRowNumber(java.lang.Long rowNumber) {
		this.rowNumber = rowNumber;
	}

	/**
	 * @return the codigoAreaTrabajoBodega
	 */
	public Integer getCodigoAreaTrabajoBodega() {
		return codigoAreaTrabajoBodega;
	}

	/**
	 * @param codigoAreaTrabajoBodega the codigoAreaTrabajoBodega to set
	 */
	public void setCodigoAreaTrabajoBodega(Integer codigoAreaTrabajoBodega) {
		this.codigoAreaTrabajoBodega = codigoAreaTrabajoBodega;
	}

	/**
	 * @return the codigoReferenciaBodega
	 */
	public Integer getCodigoReferenciaBodega() {
		return codigoReferenciaBodega;
	}

	/**
	 * @param codigoReferenciaBodega the codigoReferenciaBodega to set
	 */
	public void setCodigoReferenciaBodega(Integer codigoReferenciaBodega) {
		this.codigoReferenciaBodega = codigoReferenciaBodega;
	}

	/**
	 * @return the codigoAreatrabajoSubBodega
	 */
	public Integer getCodigoAreatrabajoSubBodega() {
		return codigoAreatrabajoSubBodega;
	}

	/**
	 * @param codigoAreatrabajoSubBodega the codigoAreatrabajoSubBodega to set
	 */
	public void setCodigoAreatrabajoSubBodega(Integer codigoAreatrabajoSubBodega) {
		this.codigoAreatrabajoSubBodega = codigoAreatrabajoSubBodega;
	}

	/**
	 * @return the nombreAreaTrabajoSubBodega
	 */
	public String getNombreAreaTrabajoSubBodega() {
		return nombreAreaTrabajoSubBodega;
	}

	/**
	 * @param nombreAreaTrabajoSubBodega the nombreAreaTrabajoSubBodega to set
	 */
	public void setNombreAreaTrabajoSubBodega(String nombreAreaTrabajoSubBodega) {
		this.nombreAreaTrabajoSubBodega = nombreAreaTrabajoSubBodega;
	}

	/**
	 * @return the codigoReferenciaSubBodega
	 */
	public Integer getCodigoReferenciaSubBodega() {
		return codigoReferenciaSubBodega;
	}

	/**
	 * @param codigoReferenciaSubBodega the codigoReferenciaSubBodega to set
	 */
	public void setCodigoReferenciaSubBodega(Integer codigoReferenciaSubBodega) {
		this.codigoReferenciaSubBodega = codigoReferenciaSubBodega;
	}

	/**
	 * @return the nombreNave
	 */
	public String getNombreNave() {
		return nombreNave;
	}

	/**
	 * @param nombreNave the nombreNave to set
	 */
	public void setNombreNave(String nombreNave) {
		this.nombreNave = nombreNave;
	}

	/**
	 * @return the nombreSubNave
	 */
	public String getNombreSubNave() {
		return nombreSubNave;
	}

	/**
	 * @param nombreSubNave the nombreSubNave to set
	 */
	public void setNombreSubNave(String nombreSubNave) {
		this.nombreSubNave = nombreSubNave;
	}

	/**
	 * @return the nombreArea
	 */
	public String getNombreArea() {
		return nombreArea;
	}

	/**
	 * @param nombreArea the nombreArea to set
	 */
	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	/**
	 * @return the identificadorPasillo
	 */
	public String getIdentificadorPasillo() {
		return identificadorPasillo;
	}

	/**
	 * @param identificadorPasillo the identificadorPasillo to set
	 */
	public void setIdentificadorPasillo(String identificadorPasillo) {
		this.identificadorPasillo = identificadorPasillo;
	}

	/**
	 * @return the identificadorRack
	 */
	public String getIdentificadorRack() {
		return identificadorRack;
	}

	/**
	 * @param identificadorRack the identificadorRack to set
	 */
	public void setIdentificadorRack(String identificadorRack) {
		this.identificadorRack = identificadorRack;
	}

	/**
	 * @return the codigoDetalleSeccionRack
	 */
	public java.lang.Long getCodigoDetalleSeccionRack() {
		return codigoDetalleSeccionRack;
	}

	/**
	 * @param codigoDetalleSeccionRack the codigoDetalleSeccionRack to set
	 */
	public void setCodigoDetalleSeccionRack(java.lang.Long codigoDetalleSeccionRack) {
		this.codigoDetalleSeccionRack = codigoDetalleSeccionRack;
	}

	/**
	 * @return the codigoDetalleSeccionArea
	 */
	public java.lang.Long getCodigoDetalleSeccionArea() {
		return codigoDetalleSeccionArea;
	}

	/**
	 * @param codigoDetalleSeccionArea the codigoDetalleSeccionArea to set
	 */
	public void setCodigoDetalleSeccionArea(java.lang.Long codigoDetalleSeccionArea) {
		this.codigoDetalleSeccionArea = codigoDetalleSeccionArea;
	}

	/**
	 * @return the identificadorUbicacion
	 */
	public String getIdentificadorUbicacion() {
		return identificadorUbicacion;
	}

	/**
	 * @param identificadorUbicacion the identificadorUbicacion to set
	 */
	public void setIdentificadorUbicacion(String identificadorUbicacion) {
		this.identificadorUbicacion = identificadorUbicacion;
	}

	/**
	 * @return the codigoSeccionUbicacion
	 */
	public java.lang.Long getCodigoSeccionUbicacion() {
		return codigoSeccionUbicacion;
	}

	/**
	 * @param codigoSeccionUbicacion the codigoSeccionUbicacion to set
	 */
	public void setCodigoSeccionUbicacion(java.lang.Long codigoSeccionUbicacion) {
		this.codigoSeccionUbicacion = codigoSeccionUbicacion;
	}

	/**
	 * @return the tipoAlmacenamiento
	 */
	public Integer getTipoAlmacenamiento() {
		return tipoAlmacenamiento;
	}

	/**
	 * @param tipoAlmacenamiento the tipoAlmacenamiento to set
	 */
	public void setTipoAlmacenamiento(Integer tipoAlmacenamiento) {
		this.tipoAlmacenamiento = tipoAlmacenamiento;
	}

	/**
	 * @return the valorAlmacenamiento
	 */
	public String getValorAlmacenamiento() {
		return valorAlmacenamiento;
	}

	/**
	 * @param valorAlmacenamiento the valorAlmacenamiento to set
	 */
	public void setValorAlmacenamiento(String valorAlmacenamiento) {
		this.valorAlmacenamiento = valorAlmacenamiento;
	}

	/**
	 * @return the tipoUbicacion
	 */
	public Integer getTipoUbicacion() {
		return tipoUbicacion;
	}

	/**
	 * @param tipoUbicacion the tipoUbicacion to set
	 */
	public void setTipoUbicacion(Integer tipoUbicacion) {
		this.tipoUbicacion = tipoUbicacion;
	}

	/**
	 * @return the valorUbicacion
	 */
	public String getValorUbicacion() {
		return valorUbicacion;
	}

	/**
	 * @param valorUbicacion the valorUbicacion to set
	 */
	public void setValorUbicacion(String valorUbicacion) {
		this.valorUbicacion = valorUbicacion;
	}

	/**
	 * @return the asignacionArticuloUnidadManejoCol
	 */
	public Collection<AsignacionArticuloUnidadManejoDTO> getAsignacionArticuloUnidadManejoCol() {
		return asignacionArticuloUnidadManejoCol;
	}

	/**
	 * @param asignacionArticuloUnidadManejoCol the asignacionArticuloUnidadManejoCol to set
	 */
	public void setAsignacionArticuloUnidadManejoCol(Collection<AsignacionArticuloUnidadManejoDTO> asignacionArticuloUnidadManejoCol) {
		this.asignacionArticuloUnidadManejoCol = asignacionArticuloUnidadManejoCol;
	}

	/**
	 * @return Devuelve codigoCompania.
	 */
	public Integer getCodigoCompania()
	{
		if (this.getId() != null){
			return this.getId().getCodigoCompania();
		}
		return null;
	}
	
	/**
	 * @param codigoCompania El codigoCompania a establecer.
	 */
	public void setCodigoCompania(Integer codigoCompania){
		if (this.getId() != null){
			this.getId().setCodigoCompania(codigoCompania);
		}
	}
	
	/**
	 * @return Devuelve codigoDetalleSeccion.
	 */
	public java.lang.Long getCodigoDetalleSeccionUbicacion()
	{
		if (this.getId() != null){
			return this.getId().getCodigoDetalleSeccionUbicacion();
		}
		return null;
	}
	
	/**
	 * @param codigoDetalleSeccion El codigoDetalleSeccion a establecer.
	 */
	public void setCodigoDetalleSeccionUbicacion(java.lang.Long codigoDetalleSeccionUbicacion){
		if (this.getId() != null){
			this.getId().setCodigoDetalleSeccionUbicacion(codigoDetalleSeccionUbicacion);
		}
	}
	
}
