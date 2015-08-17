package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Date;

import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoGestionPrecio;
import ec.com.smx.sic.cliente.mdl.dto.AuditoriaBaseDTO;


/**
 * @author Luis Yacchirema
 *
 */
@SuppressWarnings("serial")
public class GestionPrecioTransient extends AuditoriaBaseDTO {

	private Date fechaVigenciaCosto;
	private Date fechaRetornoCosto;
	private Date fechaVigenciaPrecio;
	private Date fechaRetornoPrecio;

	// tiene que ser Boolean.false ya que se inicializa en false , NO en null
	protected Boolean tieneParticipantes = Boolean.FALSE;
//	protected Boolean tieneActivoLoyalty;

	private EstadoGestionPrecio estadoGestionPrecio;


	/**
	 * @return the estadoGestionPrecio
	 */
	public EstadoGestionPrecio getEstadoGestionPrecio() {
		return estadoGestionPrecio;
	}

	/**
	 * @param estadoGestionPrecio the estadoGestionPrecio to set
	 */
	public void setEstadoGestionPrecio(EstadoGestionPrecio estadoGestionPrecio) {
		this.estadoGestionPrecio = estadoGestionPrecio;
	}

	/**
	 * @return the fechaVigenciaCosto
	 */
	public Date getFechaVigenciaCosto() {
		return fechaVigenciaCosto;
	}

	/**
	 * @param fechaVigenciaCosto the fechaVigenciaCosto to set
	 */
	public void setFechaVigenciaCosto(Date fechaVigenciaCosto) {
		this.fechaVigenciaCosto = fechaVigenciaCosto;
	}

	/**
	 * @return the fechaRetornoCosto
	 */
	public Date getFechaRetornoCosto() {
		return fechaRetornoCosto;
	}

	/**
	 * @param fechaRetornoCosto the fechaRetornoCosto to set
	 */
	public void setFechaRetornoCosto(Date fechaRetornoCosto) {
		this.fechaRetornoCosto = fechaRetornoCosto;
	}

	/**
	 * @return the fechaVigenciaPrecio
	 */
	public Date getFechaVigenciaPrecio() {
		return fechaVigenciaPrecio;
	}

	/**
	 * @param fechaVigenciaPrecio the fechaVigenciaPrecio to set
	 */
	public void setFechaVigenciaPrecio(Date fechaVigenciaPrecio) {
		this.fechaVigenciaPrecio = fechaVigenciaPrecio;
	}

	/**
	 * @return the fechaRetornoPrecio
	 */
	public Date getFechaRetornoPrecio() {
		return fechaRetornoPrecio;
	}

	/**
	 * @param fechaRetornoPrecio the fechaRetornoPrecio to set
	 */
	public void setFechaRetornoPrecio(Date fechaRetornoPrecio) {
		this.fechaRetornoPrecio = fechaRetornoPrecio;
	}

}
