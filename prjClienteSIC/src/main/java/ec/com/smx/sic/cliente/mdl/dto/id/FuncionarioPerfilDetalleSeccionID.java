/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

/**
 * @author jdvasquez
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class FuncionarioPerfilDetalleSeccionID extends BaseID{
	
	/**
	 * codigo de la compania
	 */
	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania ;

	/**
	 * Codigo del funcionario
	 */
	@Column(name="CODIGOFUNCIONARIO")
	private String codigoFuncionario ;

	/**
	 * Codigo del Perfil
	 */
	@Column(name="CODIGOPERFIL")
	private String codigoPerfil ;
	
	/**
	 * Codigo del Perfil
	 */
	@Column(name="CODIGODETALLESECCION")
	private Long codigoDetalleSeccion;
	
	/*******************************************************************
	 * SETTERS & GETTERS
	 *******************************************************************/

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
	 * @return the codigoDetalleSeccion
	 */
	public Long getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}

	/**
	 * @param codigoDetalleSeccion the codigoDetalleSeccion to set
	 */
	public void setCodigoDetalleSeccion(Long codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}
	
}
