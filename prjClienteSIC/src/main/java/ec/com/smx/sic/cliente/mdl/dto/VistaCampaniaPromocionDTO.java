package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaCampaniaPromocionID;

/**
 * @author srodriguez
 * 2014-09-10
*/

@Entity
public class VistaCampaniaPromocionDTO {

	@EmbeddedId
	private VistaCampaniaPromocionID id;
	
	private String nombre;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	@Transient
	private String userId;
	
	@Transient
	private Collection<VistaCampaniaPromocionDTO> promociones;
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
	 * @return the promociones
	 */
	public Collection<VistaCampaniaPromocionDTO> getPromociones() {
		return promociones;
	}

	/**
	 * @param promociones the promociones to set
	 */
	public void setPromociones(Collection<VistaCampaniaPromocionDTO> promociones) {
		this.promociones = promociones;
	}

	/**
	 * @return the id
	 */
	public VistaCampaniaPromocionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaCampaniaPromocionID id) {
		this.id = id;
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
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
