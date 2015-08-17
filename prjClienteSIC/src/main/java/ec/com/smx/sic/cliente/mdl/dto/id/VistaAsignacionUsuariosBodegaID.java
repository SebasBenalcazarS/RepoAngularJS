package ec.com.smx.sic.cliente.mdl.dto.id;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

/**
 * @author cpescobar
 *
 */
@SuppressWarnings("serial")
public class VistaAsignacionUsuariosBodegaID extends BaseID {

	private Integer codigoCompania;
	private Integer numeroRegistro;
	private String codigoFuncionario;
	
	public VistaAsignacionUsuariosBodegaID () {}

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

	/**
	 * @return the codigoFuncionario
	 */
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	/**
	 * @param codigoFuncionario the codigoFuncionario to set
	 */
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}
	
}
