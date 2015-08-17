package ec.com.smx.sic.cliente.mdl.dto.id;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;


@SuppressWarnings("serial")
public class VistaTareaEstadoID extends BaseID {
	
	private Integer codigoCompania;
	private Integer numeroRegistro;
	private Long codigoTarea;
	
	public VistaTareaEstadoID () {}

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoTarea
	 */
	public Long getCodigoTarea() {
		return codigoTarea;
	}

	/**
	 * @param codigoTarea the codigoTarea to set
	 */
	public void setCodigoTarea(Long codigoTarea) {
		this.codigoTarea = codigoTarea;
	}

	/**
	 * @return the numeroRegistro
	 */
	public Integer getNumeroRegistro() {
		return numeroRegistro;
	}

	/**
	 * @param numeroRegistro the numeroRegistro to set
	 */
	public void setNumeroRegistro(Integer numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

}
