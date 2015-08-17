package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SeccionDTO;

@SuppressWarnings("serial")
public class BodegaVO extends BaseVO<BodegaDTO> {
	
	private Boolean contarSubBodegas = Boolean.FALSE;
	//private Boolean nivelPadres = Boolean.FALSE;
	private Boolean mostrarJerarquia = Boolean.FALSE;
	
	//Secciones
	private SeccionDTO seccionNaves;
	private Collection<DetalleSeccionDTO> seccionSubnaves;
	private SeccionDTO seccionUbicaciones;
	private SeccionDTO seccionAndenes;
	private SeccionDTO seccionPasillos;
	private SeccionDTO seccionAreas;
	
	
	//Entregas
	private EntregaVO entregaVO;
	private Collection<EntregaVO> entregaVOs;
	
	/**
	 * @return the contarSubBodegas
	 */
	public Boolean getContarSubBodegas() {
		return contarSubBodegas;
	}
	/**
	 * @param contarSubBodegas the contarSubBodegas to set
	 */
	public void setContarSubBodegas(Boolean contarSubBodegas) {
		this.contarSubBodegas = contarSubBodegas;
	}
	/**
	 * @return the nivelPadres
	 */
	/*public Boolean getNivelPadres() {
		return nivelPadres;
	}*/
	/**
	 * @param nivelPadres the nivelPadres to set
	 */
	/*public void setNivelPadres(Boolean nivelPadres) {
		this.nivelPadres = nivelPadres;
	}*/
	/**
	 * @return the mostrarJerarquia
	 */
	public Boolean getMostrarJerarquia() {
		return mostrarJerarquia;
	}
	/**
	 * @param mostrarJerarquia the mostrarJerarquia to set
	 */
	public void setMostrarJerarquia(Boolean mostrarJerarquia) {
		this.mostrarJerarquia = mostrarJerarquia;
	}
	/**
	 * @return the seccionNaves
	 */
	public SeccionDTO getSeccionNaves() {
		return seccionNaves;
	}
	/**
	 * @param seccionNaves the seccionNaves to set
	 */
	public void setSeccionNaves(SeccionDTO seccionNaves) {
		this.seccionNaves = seccionNaves;
	}
	/**
	 * @return the seccionUbicaciones
	 */
	public SeccionDTO getSeccionUbicaciones() {
		return seccionUbicaciones;
	}
	/**
	 * @param seccionUbicaciones the seccionUbicaciones to set
	 */
	public void setSeccionUbicaciones(SeccionDTO seccionUbicaciones) {
		this.seccionUbicaciones = seccionUbicaciones;
	}
	/**
	 * @return the seccionAndenes
	 */
	public SeccionDTO getSeccionAndenes() {
		return seccionAndenes;
	}
	/**
	 * @param seccionAndenes the seccionAndenes to set
	 */
	public void setSeccionAndenes(SeccionDTO seccionAndenes) {
		this.seccionAndenes = seccionAndenes;
	}
	/**
	 * @return the seccionPasillos
	 */
	public SeccionDTO getSeccionPasillos() {
		return seccionPasillos;
	}
	/**
	 * @param seccionPasillos the seccionPasillos to set
	 */
	public void setSeccionPasillos(SeccionDTO seccionPasillos) {
		this.seccionPasillos = seccionPasillos;
	}
	/**
	 * @return the seccionAreas
	 */
	public SeccionDTO getSeccionAreas() {
		return seccionAreas;
	}
	/**
	 * @param seccionAreas the seccionAreas to set
	 */
	public void setSeccionAreas(SeccionDTO seccionAreas) {
		this.seccionAreas = seccionAreas;
	}
	/**
	 * @return the entregaVO
	 */
	public EntregaVO getEntregaVO() {
		return entregaVO;
	}
	/**
	 * @param entregaVO the entregaVO to set
	 */
	public void setEntregaVO(EntregaVO entregaVO) {
		this.entregaVO = entregaVO;
	}
	/**
	 * @return the entregaVOs
	 */
	public Collection<EntregaVO> getEntregaVOs() {
		return entregaVOs;
	}
	/**
	 * @param entregaVOs the entregaVOs to set
	 */
	public void setEntregaVOs(Collection<EntregaVO> entregaVOs) {
		this.entregaVOs = entregaVOs;
	}
	/**
	 * @return the seccionSubnaves
	 */
	public Collection<DetalleSeccionDTO> getSeccionSubnaves() {
		return seccionSubnaves;
	}
	/**
	 * @param seccionSubnaves the seccionSubnaves to set
	 */
	public void setSeccionSubnaves(Collection<DetalleSeccionDTO> seccionSubnaves) {
		this.seccionSubnaves = seccionSubnaves;
	}
	
}
