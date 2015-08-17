package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ClasificacionEtiquetaID;

/**
 * Permite almacenar las clasificaciones permitidas para las etiquetas
 * @author fcollaguazo
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCADMTCLAETI")
public class ClasificacionEtiquetaDTO extends SimpleAuditDTO{
	
	public ClasificacionEtiquetaDTO(){
		clasificacionEtiquetaID = new ClasificacionEtiquetaID();
	}
	
	@EmbeddedId
	private ClasificacionEtiquetaID clasificacionEtiquetaID = new ClasificacionEtiquetaID();
	
	@ComparatorTypeField
	private String codigoClasificacion;
	
	private Long codigoEtiqueta;
	
	@ComparatorTypeField
	private String estado;

	public ClasificacionEtiquetaID getClasificacionEtiquetaID() {
		return clasificacionEtiquetaID;
	}

	public void setClasificacionEtiquetaID(ClasificacionEtiquetaID clasificacionEtiquetaID) {
		this.clasificacionEtiquetaID = clasificacionEtiquetaID;
	}

	/**
	 * @return the codigoClasificacion
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/**
	 * @param codigoClasificacion the codigoClasificacion to set
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	/**
	 * @return the codigoEtiqueta
	 */
	public Long getCodigoEtiqueta() {
		return codigoEtiqueta;
	}

	/**
	 * @param codigoEtiqueta the codigoEtiqueta to set
	 */
	public void setCodigoEtiqueta(Long codigoEtiqueta) {
		this.codigoEtiqueta = codigoEtiqueta;
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
}
