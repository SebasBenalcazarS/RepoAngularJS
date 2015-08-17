package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Map;
import java.util.Set;

import ec.com.smx.sic.cliente.common.cambioprecios.beans.BaseComparator;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.SeveridadConflictoArticulo;

@SuppressWarnings("serial")
public abstract class PrecioDiferenciadoArticuloGestionTransient extends BaseComparator {

	// Datos calculados
	private Double margenSmxAnterior;
	private Double margenSmxNuevo;
	protected Double precioSmxNoAfiliadoAnterior;
	protected Double precioSmxNoAfiliadoNuevo;

	private Boolean existeMensajeValidacionConflicto;
	private Map<SeveridadConflictoArticulo, Set<String>> mensajesConflictosPrecioDiferenciadoArticulo;	
	private String accion;

	/**
	 * @return the existeMensajeValidacionConflicto
	 */
	public Boolean getExisteMensajeValidacionConflicto() {
		return existeMensajeValidacionConflicto;
	}

	/**
	 * @param existeMensajeValidacionConflicto the existeMensajeValidacionConflicto to set
	 */
	public void setExisteMensajeValidacionConflicto(Boolean existeMensajeValidacionConflicto) {
		this.existeMensajeValidacionConflicto = existeMensajeValidacionConflicto;
	}

	/**
	 * @return the mensajesConflictosPrecioDiferenciadoArticulo
	 */
	public Map<SeveridadConflictoArticulo, Set<String>> getMensajesConflictosPrecioDiferenciadoArticulo() {
		return mensajesConflictosPrecioDiferenciadoArticulo;
	}

	/**
	 * @param mensajesConflictosPrecioDiferenciadoArticulo the mensajesConflictosPrecioDiferenciadoArticulo to set
	 */
	public void setMensajesConflictosPrecioDiferenciadoArticulo(Map<SeveridadConflictoArticulo, Set<String>> mensajesConflictosPrecioDiferenciadoArticulo) {
		this.mensajesConflictosPrecioDiferenciadoArticulo = mensajesConflictosPrecioDiferenciadoArticulo;
	}

	/**
	 * @return the margenSmxAnterior
	 */
	public Double getMargenSmxAnterior() {
		return margenSmxAnterior;
	}

	/**
	 * @param margenSmxAnterior the margenSmxAnterior to set
	 */
	public void setMargenSmxAnterior(Double margenSmxAnterior) {
		this.margenSmxAnterior = margenSmxAnterior;
	}

	/**
	 * @return the margenSmxNuevo
	 */
	public Double getMargenSmxNuevo() {
		return margenSmxNuevo;
	}

	/**
	 * @param margenSmxNuevo the margenSmxNuevo to set
	 */
	public void setMargenSmxNuevo(Double margenSmxNuevo) {
		this.margenSmxNuevo = margenSmxNuevo;
	}

	/**
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}	

}
