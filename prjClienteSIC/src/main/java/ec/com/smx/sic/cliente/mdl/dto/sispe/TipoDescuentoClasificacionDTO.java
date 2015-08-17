/*
 * Creado el 19/09/2006
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.TipoDescuentoClasificacionID;

/**
 * @author walvarez
 * 
 *         TODO Para cambiar la plantilla de este comentario generado, vaya a
 *         Ventana - Preferencias - Java - Estilo de código - Plantillas de
 *         código
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.TipoDescuentoClasificacionDTO")
@Table(name = "SCSPETTIPDESCLA")
public class TipoDescuentoClasificacionDTO extends AuditoriaBaseDTO<TipoDescuentoClasificacionID> {

	@Column(name = "ESTADOTIPDESCLA")
	private String estadoTipoDescuentoClasificacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false) })
	private ClasificacionDTO clasificacionDTO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPODESCUENTO", referencedColumnName = "CODIGOTIPODESCUENTO", insertable = false, updatable = false) })
	private TipoDescuentoDTO tipoDescuentoDTO;

	// Campo no persistentes
	@Transient
	private String npOrderBy;

	
	public TipoDescuentoClasificacionDTO () {
		TipoDescuentoClasificacionID tipoDescuentoClasificacionID = new TipoDescuentoClasificacionID();
		this.setId(tipoDescuentoClasificacionID);
	}
	
	
	public TipoDescuentoClasificacionDTO(Boolean valor ) {
		this.id = new TipoDescuentoClasificacionID(valor);
	}

	/**
	 * @return Devuelve estadoTipoDescuentoClasificacion.
	 */
	public String getEstadoTipoDescuentoClasificacion() {
		return estadoTipoDescuentoClasificacion;
	}

	/**
	 * @param estadoTipoDescuentoClasificacion
	 *            El estadoTipoDescuentoClasificacion a establecer.
	 */
	public void setEstadoTipoDescuentoClasificacion(
			String estadoTipoDescuentoClasificacion) {
		this.estadoTipoDescuentoClasificacion = estadoTipoDescuentoClasificacion;
	}

	/**
	 * @return Devuelve clasificacionDTO.
	 */
	public ClasificacionDTO getClasificacionDTO() {
		return clasificacionDTO;
	}

	/**
	 * @param clasificacionDTO
	 *            El clasificacionDTO a establecer.
	 */
	public void setClasificacionDTO(ClasificacionDTO clasificacionDTO) {
		this.clasificacionDTO = clasificacionDTO;
	}

	/**
	 * @return Devuelve tipoDescuentoDTO.
	 */
	public TipoDescuentoDTO getTipoDescuentoDTO() {
		return tipoDescuentoDTO;
	}

	/**
	 * @param tipoDescuentoDTO
	 *            El tipoDescuentoDTO a establecer.
	 */
	public void setTipoDescuentoDTO(TipoDescuentoDTO tipoDescuentoDTO) {
		this.tipoDescuentoDTO = tipoDescuentoDTO;
	}

	/**
	 * @return Devuelve id.
	 */
	public TipoDescuentoClasificacionID getId() {
		return id;
	}

	/**
	 * @param id
	 *            El id a establecer.
	 */
	public void setId(TipoDescuentoClasificacionID id) {
		this.id = id;
	}

	/**
	 * @return Devuelve npOrderBy.
	 */
	public String getNpOrderBy() {
		return npOrderBy;
	}

	/**
	 * @param npOrderBy
	 *            El npOrderBy a establecer.
	 */
	public void setNpOrderBy(String npOrderBy) {
		this.npOrderBy = npOrderBy;
	}
}
