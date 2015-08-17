package ec.com.smx.sic.cliente.mdl.vo;

import java.util.ArrayList;
import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaEmpaqueDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaEmpaqueFuncionarioDTO;

@SuppressWarnings("serial")
public class FuncionarioLineaEmpaqueVO extends BaseVO<LineaEmpaqueFuncionarioDTO>{
	private LineaEmpaqueDTO lineaEmpaqueDTO;
	private LineaEmpaqueFuncionarioDTO lineaEmpaqueFuncionarioDTO;
	private Collection<LineaEmpaqueFuncionarioDTO> lineaEmpaqueFuncionarioDTOs;
	private Collection<FuncionarioDTO> listaFuncionario;
	
	//Atributos para la busqueda
	private String numeroDocumento;
	private String nombreFuncionario;
	private String apellidoFuncionario;
	private String idUsuario;
	
	public FuncionarioLineaEmpaqueVO(){
		super();
		this.lineaEmpaqueDTO=new LineaEmpaqueDTO();
		this.lineaEmpaqueFuncionarioDTO=new LineaEmpaqueFuncionarioDTO();
		this.lineaEmpaqueFuncionarioDTOs=new ArrayList<LineaEmpaqueFuncionarioDTO>();
		this.listaFuncionario=new ArrayList<FuncionarioDTO>();
	}
	
	
	
	/**
	 * M�todo Getter del campo lineaEmpaqueDTO
	 * @return the lineaEmpaqueDTO
	 */
	public LineaEmpaqueDTO getLineaEmpaqueDTO() {
		return lineaEmpaqueDTO;
	}
	/**
	 * M�todo Setter the lineaEmpaqueDTO
	 * @param lineaEmpaqueDTO the lineaEmpaqueDTO to set
	 */
	public void setLineaEmpaqueDTO(LineaEmpaqueDTO lineaEmpaqueDTO) {
		this.lineaEmpaqueDTO = lineaEmpaqueDTO;
	}
	/**
	 * M�todo Getter del campo lineaEmpaqueFuncionarioDTO
	 * @return the lineaEmpaqueFuncionarioDTO
	 */
	public LineaEmpaqueFuncionarioDTO getLineaEmpaqueFuncionarioDTO() {
		return lineaEmpaqueFuncionarioDTO;
	}
	/**
	 * M�todo Setter the lineaEmpaqueFuncionarioDTO
	 * @param lineaEmpaqueFuncionarioDTO the lineaEmpaqueFuncionarioDTO to set
	 */
	public void setLineaEmpaqueFuncionarioDTO(LineaEmpaqueFuncionarioDTO lineaEmpaqueFuncionarioDTO) {
		this.lineaEmpaqueFuncionarioDTO = lineaEmpaqueFuncionarioDTO;
	}
	/**
	 * M�todo Getter del campo lineaEmpaqueFuncionarioDTOs
	 * @return the lineaEmpaqueFuncionarioDTOs
	 */
	public Collection<LineaEmpaqueFuncionarioDTO> getLineaEmpaqueFuncionarioDTOs() {
		return lineaEmpaqueFuncionarioDTOs;
	}
	/**
	 * M�todo Setter the lineaEmpaqueFuncionarioDTOs
	 * @param lineaEmpaqueFuncionarioDTOs the lineaEmpaqueFuncionarioDTOs to set
	 */
	public void setLineaEmpaqueFuncionarioDTOs(Collection<LineaEmpaqueFuncionarioDTO> lineaEmpaqueFuncionarioDTOs) {
		this.lineaEmpaqueFuncionarioDTOs = lineaEmpaqueFuncionarioDTOs;
	}
	/**
	 * M�todo Getter del campo listaFuncionario
	 * @return the listaFuncionario
	 */
	public Collection<FuncionarioDTO> getListaFuncionario() {
		return listaFuncionario;
	}
	/**
	 * M�todo Setter the listaFuncionario
	 * @param listaFuncionario the listaFuncionario to set
	 */
	public void setListaFuncionario(Collection<FuncionarioDTO> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}



	/**
	 * M�todo Getter del campo numeroDocumento
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}



	/**
	 * M�todo Setter the numeroDocumento
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}



	/**
	 * M�todo Getter del campo nombreFuncionario
	 * @return the nombreFuncionario
	 */
	public String getNombreFuncionario() {
		return nombreFuncionario;
	}



	/**
	 * M�todo Setter the nombreFuncionario
	 * @param nombreFuncionario the nombreFuncionario to set
	 */
	public void setNombreFuncionario(String nombreFuncionario) {
		this.nombreFuncionario = nombreFuncionario;
	}



	/**
	 * M�todo Getter del campo apellidoFuncionario
	 * @return the apellidoFuncionario
	 */
	public String getApellidoFuncionario() {
		return apellidoFuncionario;
	}



	/**
	 * M�todo Setter the apellidoFuncionario
	 * @param apellidoFuncionario the apellidoFuncionario to set
	 */
	public void setApellidoFuncionario(String apellidoFuncionario) {
		this.apellidoFuncionario = apellidoFuncionario;
	}



	/**
	 * M�todo Getter del campo idUsuario
	 * @return the idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}



	/**
	 * M�todo Setter the idUsuario
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
