package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;

@SuppressWarnings("serial")
public class FuncionarioProcesoPerfilAreaTrabajoDetalleSeccionID  implements Serializable{
	/**
	 * Codigo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name="CODIGOFUNCIONARIO")
	private String codigoFuncionario;
	
	@Column(name = "CODIGOPROCESO")
	private Long codigoProceso;

	@Column(name = "CODIGOPERFIL")
	private String codigoPerfil;
	
	@Column(name="CODIGOAREATRABAJO")
	private Integer codigoAreaTrabajo;
		
	@Column(name="CODIGOAREASUBLUGARTRABAJO")
	private Integer codigoAreaSublugarTrabajo;
	
	@Column(name = "CODIGODETALLESECCIONINICIO")
	private Long codigoDetalleSeccionInicio;

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

	/**
	 * @return the codigoProceso
	 */
	public Long getCodigoProceso() {
		return codigoProceso;
	}

	/**
	 * @param codigoProceso the codigoProceso to set
	 */
	public void setCodigoProceso(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}

	/**
	 * @return the codigoPerfil
	 */
	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	/**
	 * @param codigoPerfil the codigoPerfil to set
	 */
	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	/**
	 * @return the codigoAreaSublugarTrabajo
	 */
	public Integer getCodigoAreaSublugarTrabajo() {
		return codigoAreaSublugarTrabajo;
	}

	/**
	 * @param codigoAreaSublugarTrabajo the codigoAreaSublugarTrabajo to set
	 */
	public void setCodigoAreaSublugarTrabajo(Integer codigoAreaSublugarTrabajo) {
		this.codigoAreaSublugarTrabajo = codigoAreaSublugarTrabajo;
	}

	/**
	 * @return the codigoDetalleSeccionInicio
	 */
	public Long getCodigoDetalleSeccionInicio() {
		return codigoDetalleSeccionInicio;
	}

	/**
	 * @param codigoDetalleSeccionInicio the codigoDetalleSeccionInicio to set
	 */
	public void setCodigoDetalleSeccionInicio(Long codigoDetalleSeccionInicio) {
		this.codigoDetalleSeccionInicio = codigoDetalleSeccionInicio;
	}
	
}
