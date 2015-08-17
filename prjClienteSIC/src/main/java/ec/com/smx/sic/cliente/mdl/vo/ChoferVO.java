package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ChoferDTO;


public class ChoferVO extends BaseVO<ChoferDTO>{


	private static final long serialVersionUID = 1L;

	private FuncionarioDTO funcionarioChofer; 
	private Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados;
	private DatoContactoPersonaLocalizacionDTO contactoPersonal;
	private Boolean existeChofer;
	
	/**
	 * @return the contactosRelacionados
	 */
	public Collection<DatoContactoPersonaLocalizacionDTO> getContactosRelacionados() {
		return contactosRelacionados;
	}

	/**
	 * @param contactosRelacionados the contactosRelacionados to set
	 */
	public void setContactosRelacionados(Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados) {
		this.contactosRelacionados = contactosRelacionados;
	}

	/**
	 * @return the funcionarioChofer
	 */
	public FuncionarioDTO getFuncionarioChofer() {
		return funcionarioChofer;
	}

	/**
	 * @param funcionarioChofer the funcionarioChofer to set
	 */
	public void setFuncionarioChofer(FuncionarioDTO funcionarioChofer) {
		this.funcionarioChofer = funcionarioChofer;
	}

	/**
	 * @return the contactoPersonal
	 */
	public DatoContactoPersonaLocalizacionDTO getContactoPersonal() {
		return contactoPersonal;
	}

	/**
	 * @param contactoPersonal the contactoPersonal to set
	 */
	public void setContactoPersonal(DatoContactoPersonaLocalizacionDTO contactoPersonal) {
		this.contactoPersonal = contactoPersonal;
	}

	/**
	 * @return the existeChofer
	 */
	public Boolean getExisteChofer() {
		return existeChofer;
	}

	/**
	 * @param existeChofer the existeChofer to set
	 */
	public void setExisteChofer(Boolean existeChofer) {
		this.existeChofer = existeChofer;
	}

	
}
