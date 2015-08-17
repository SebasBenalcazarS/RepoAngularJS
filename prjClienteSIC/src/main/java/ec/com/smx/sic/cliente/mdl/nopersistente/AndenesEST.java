/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;


import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;

@SuppressWarnings("serial")
public class AndenesEST extends SimpleAuditDTO {
	
	private DetalleSeccionDTO anden;
	
	private Collection<DetalleSeccionDTO> andenes;
	
	private Integer saltos;
	
	private Integer posicion;
	/**
	 * @return the anden
	 */
	public DetalleSeccionDTO getAnden() {
		return anden;
	}
	/**
	 * @param anden the anden to set
	 */
	public void setAnden(DetalleSeccionDTO anden) {
		this.anden = anden;
	}
	/**
	 * @return the andenes
	 */
	public Collection<DetalleSeccionDTO> getAndenes() {
		return andenes;
	}
	/**
	 * @param andenes the andenes to set
	 */
	public void setAndenes(Collection<DetalleSeccionDTO> andenes) {
		this.andenes = andenes;
	}
	/**
	 * @return the saltos
	 */
	public Integer getSaltos() {
		return saltos;
	}
	/**
	 * @param saltos the saltos to set
	 */
	public void setSaltos(Integer saltos) {
		this.saltos = saltos;
	}
	/**
	 * @return the posicion
	 */
	public Integer getPosicion() {
		return posicion;
	}
	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}	
}
