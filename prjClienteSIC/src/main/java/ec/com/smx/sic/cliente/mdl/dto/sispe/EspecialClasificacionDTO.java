/*
 * Creado el 15/03/2007
 *
 */
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.EspecialClasificacionID;

/**
 * @author walvarez
 * 
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.EspecialClasificacionDTO")
@Table(name = "SCSPETESPCLA")
public class EspecialClasificacionDTO extends AuditoriaBaseDTO<EspecialClasificacionID> {
	
	private String estadoEspecialClasificacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false) })
	private ClasificacionDTO clasificacionDTO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOESPECIAL", referencedColumnName = "CODIGOESPECIAL", insertable = false, updatable = false) })
	private EspecialDTO especialDTO;

	public EspecialClasificacionDTO() {
		EspecialClasificacionID especialClasificacionID = new EspecialClasificacionID();
		this.setId(especialClasificacionID);
	}

	
	public EspecialClasificacionDTO (Boolean valor) {
		this.id = new EspecialClasificacionID(valor);
	}
	/**
	 * @return Devuelve estadoEspecialClasificacion.
	 */
	public String getEstadoEspecialClasificacion() {
		return estadoEspecialClasificacion;
	}

	/**
	 * @param estadoEspecialClasificacion
	 *            El estadoEspecialClasificacion a establecer.
	 */
	public void setEstadoEspecialClasificacion(
			String estadoEspecialClasificacion) {
		this.estadoEspecialClasificacion = estadoEspecialClasificacion;
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
	 * 
	 * @return Devuelve especialDTO
	 */
	public EspecialDTO getEspecialDTO() {
		return this.especialDTO;
	}

	/**
	 * 
	 * @param especialDTO
	 *            El especialDTO a establecer
	 */
	public void setEspecialDTO(EspecialDTO especialDTO) {
		this.especialDTO = especialDTO;
	}
}
