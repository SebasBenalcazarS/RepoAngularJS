package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.TransportistaDTO;
import ec.com.smx.framework.common.enumeration.TipoEmpresaEnum;


public class TransportistaVO extends BaseVO<TransportistaDTO>{


	private static final long serialVersionUID = 1L;

	private FuncionarioDTO funcionarioTransportista; 
	private IIdentificadorTransportistaVO identificadorTransportistaVO;
	private Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados;
	private DatoContactoPersonaLocalizacionDTO contactoPersonal;
	
	private String numeroDocumento;
	private String codigoTransportista;
	private String nombreTransportista;
	private Boolean isPersona;
	private Boolean isEmpresa;
	private Boolean existeTransportista;
	private Boolean transportistaNuevo;
	private TipoEmpresaEnum tipoEmpresa;
	
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
	 * @return the funcionarioTransportista
	 */
	public FuncionarioDTO getFuncionarioTransportista() {
		return funcionarioTransportista;
	}

	/**
	 * @param funcionarioTransportista the funcionarioTransportista to set
	 */
	public void setFuncionarioTransportista(FuncionarioDTO funcionarioTransportista) {
		this.funcionarioTransportista = funcionarioTransportista;
	}

	/**
	 * @return the identificadorTransportistaVO
	 */
	public IIdentificadorTransportistaVO getIdentificadorTransportistaVO() {
		return identificadorTransportistaVO;
	}

	/**
	 * @param identificadorTransportistaVO the identificadorTransportistaVO to set
	 */
	public void setIdentificadorTransportistaVO(IIdentificadorTransportistaVO identificadorTransportistaVO) {
		this.identificadorTransportistaVO = identificadorTransportistaVO;
	}

	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * @return the codigoTransportista
	 */
	public String getCodigoTransportista() {
		return codigoTransportista;
	}

	/**
	 * @param codigoTransportista the codigoTransportista to set
	 */
	public void setCodigoTransportista(String codigoTransportista) {
		this.codigoTransportista = codigoTransportista;
	}

	/**
	 * @return the nombreTransportista
	 */
	public String getNombreTransportista() {
		return nombreTransportista;
	}

	/**
	 * @param nombreTransportista the nombreTransportista to set
	 */
	public void setNombreTransportista(String nombreTransportista) {
		this.nombreTransportista = nombreTransportista;
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
	 * @return the isPersona
	 */
	public Boolean getIsPersona() {
		return isPersona;
	}

	/**
	 * @param isPersona the isPersona to set
	 */
	public void setIsPersona(Boolean isPersona) {
		this.isPersona = isPersona;
	}

	/**
	 * @return the isEmpresa
	 */
	public Boolean getIsEmpresa() {
		return isEmpresa;
	}

	/**
	 * @param isEmpresa the isEmpresa to set
	 */
	public void setIsEmpresa(Boolean isEmpresa) {
		this.isEmpresa = isEmpresa;
	}

	/**
	 * @return the existeTransportista
	 */
	public Boolean getExisteTransportista() {
		return existeTransportista;
	}

	/**
	 * @param existeTransportista the existeTransportista to set
	 */
	public void setExisteTransportista(Boolean existeTransportista) {
		this.existeTransportista = existeTransportista;
	}

	/**
	 * @return the transportistaNuevo
	 */
	public Boolean getTransportistaNuevo() {
		return transportistaNuevo;
	}

	/**
	 * @param transportistaNuevo the transportistaNuevo to set
	 */
	public void setTransportistaNuevo(Boolean transportistaNuevo) {
		this.transportistaNuevo = transportistaNuevo;
	}

	/**
	 * @return the tipoEmpresa
	 */
	public TipoEmpresaEnum getTipoEmpresa() {
		return tipoEmpresa;
	}

	/**
	 * @param tipoEmpresa the tipoEmpresa to set
	 */
	public void setTipoEmpresa(TipoEmpresaEnum tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

}
