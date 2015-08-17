/*
 * Creado el 16/06/2006
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.TipoDescuentoID;

/**
 * @author walvarez
 * 
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.TipoDescuentoDTO")
@Table(name = "SCSPETTIPDES")
public class TipoDescuentoDTO extends AuditoriaBaseDTO<TipoDescuentoID> {

	private String descripcionTipoDescuento;
	private String estadoTipoDescuento;
	private String estadoPublicacion;
	// relaciones
	@Transient
	private Collection<TipoDescuentoClasificacionDTO> tiposDescuentosClasificaciones;

	@Transient
	private Collection<DescuentoDTO> detalleDescuentos;
	
	@OneToMany(mappedBy = "tipoDescuentoDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<DescuentoDTO> descuentosCol;
	
	// campos no persistentes
	@Transient
	private String npOrderBy;

	@Transient
	private String npTipoDescuentoVariable;

	
	/**
	 * np para validar si se muestra o no en el popup de descuento
	 */
	@Transient
	private String npVisible;
	
	/**
	 * np para contraer los tipos de descuento en excluyentes y otros
	 */
	@Transient
	private String npExcluyente;
	
	
	public TipoDescuentoDTO() {
		TipoDescuentoID tipoDescuentoID = new TipoDescuentoID();
		this.setId(tipoDescuentoID);
	}

	public TipoDescuentoDTO (Boolean valor) {
		this.id = new TipoDescuentoID(valor);
	}
	
	/**
	 * @return Devuelve descripcionTipoDescuento.
	 */
	public String getDescripcionTipoDescuento() {
		return descripcionTipoDescuento;
	}

	/**
	 * @param descripcionTipoDescuento
	 *            El descripcionTipoDescuento a establecer.
	 */
	public void setDescripcionTipoDescuento(String descripcionTipoDescuento) {
		this.descripcionTipoDescuento = descripcionTipoDescuento;
	}

	/**
	 * @return Devuelve estadoTipoDescuento.
	 */
	public String getEstadoTipoDescuento() {
		return estadoTipoDescuento;
	}

	/**
	 * @param estadoTipoDescuento
	 *            El estadoTipoDescuento a establecer.
	 */
	public void setEstadoTipoDescuento(String estadoTipoDescuento) {
		this.estadoTipoDescuento = estadoTipoDescuento;
	}

	/**
	 * @return Devuelve tiposDescuentosClasificaciones.
	 */
	public Collection<TipoDescuentoClasificacionDTO> getTiposDescuentosClasificaciones() {
		return tiposDescuentosClasificaciones;
	}

	/**
	 * @param tiposDescuentosClasificaciones
	 *            El tiposDescuentosClasificaciones a establecer.
	 */
	public void setTiposDescuentosClasificaciones(
			Collection<TipoDescuentoClasificacionDTO> tiposDescuentosClasificaciones) {
		this.tiposDescuentosClasificaciones = tiposDescuentosClasificaciones;
	}

	/**
	 * @return Devuelve id.
	 */
	public TipoDescuentoID getId() {
		return id;
	}

	/**
	 * @param id
	 *            El id a establecer.
	 */
	public void setId(TipoDescuentoID id) {
		this.id = id;
	}

	/**
	 * @return el detalleDescuentos
	 */
	public Collection<DescuentoDTO> getDetalleDescuentos() {
		return detalleDescuentos;
	}

	/**
	 * @param detalleDescuentos
	 *            el detalleDescuentos a establecer
	 */
	public void setDetalleDescuentos(Collection<DescuentoDTO> detalleDescuentos) {
		this.detalleDescuentos = detalleDescuentos;
	}

	/**
	 * @return el npOrderBy
	 */
	public String getNpOrderBy() {
		return npOrderBy;
	}

	/**
	 * @param npOrderBy
	 *            el npOrderBy a establecer
	 */
	public void setNpOrderBy(String npOrderBy) {
		this.npOrderBy = npOrderBy;
	}

	/**
	 * @return el npTipoDescuentoVariable
	 */
	public String getNpTipoDescuentoVariable() {
		return npTipoDescuentoVariable;
	}

	/**
	 * @param npTipoDescuentoVariable
	 *            el npTipoDescuentoVariable a establecer
	 */
	public void setNpTipoDescuentoVariable(String npTipoDescuentoVariable) {
		this.npTipoDescuentoVariable = npTipoDescuentoVariable;
	}

	/**
	 * @return el estadoPublicacion
	 */
	public String getEstadoPublicacion() {
		return estadoPublicacion;
	}

	/**
	 * @param estadoPublicacion
	 *            el estadoPublicacion a establecer
	 */
	public void setEstadoPublicacion(String estadoPublicacion) {
		this.estadoPublicacion = estadoPublicacion;
	}

	public Collection<DescuentoDTO> getDescuentosCol() {
		return descuentosCol;
	}

	public void setDescuentosCol(Collection<DescuentoDTO> descuentosCol) {
		this.descuentosCol = descuentosCol;
	}

	public String getNpVisible() {
		return npVisible;
	}

	public void setNpVisible(String npVisible) {
		this.npVisible = npVisible;
	}

	public String getNpExcluyente() {
		return npExcluyente;
	}

	public void setNpExcluyente(String npExcluyente) {
		this.npExcluyente = npExcluyente;
	}
	
}
