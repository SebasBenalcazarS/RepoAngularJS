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
	 * Método Getter del campo lineaEmpaqueDTO
	 * @return the lineaEmpaqueDTO
	 */
	public LineaEmpaqueDTO getLineaEmpaqueDTO() {
		return lineaEmpaqueDTO;
	}
	/**
	 * Método Setter the lineaEmpaqueDTO
	 * @param lineaEmpaqueDTO the lineaEmpaqueDTO to set
	 */
	public void setLineaEmpaqueDTO(LineaEmpaqueDTO lineaEmpaqueDTO) {
		this.lineaEmpaqueDTO = lineaEmpaqueDTO;
	}
	/**
	 * Método Getter del campo lineaEmpaqueFuncionarioDTO
	 * @return the lineaEmpaqueFuncionarioDTO
	 */
	public LineaEmpaqueFuncionarioDTO getLineaEmpaqueFuncionarioDTO() {
		return lineaEmpaqueFuncionarioDTO;
	}
	/**
	 * Método Setter the lineaEmpaqueFuncionarioDTO
	 * @param lineaEmpaqueFuncionarioDTO the lineaEmpaqueFuncionarioDTO to set
	 */
	public void setLineaEmpaqueFuncionarioDTO(LineaEmpaqueFuncionarioDTO lineaEmpaqueFuncionarioDTO) {
		this.lineaEmpaqueFuncionarioDTO = lineaEmpaqueFuncionarioDTO;
	}
	/**
	 * Método Getter del campo lineaEmpaqueFuncionarioDTOs
	 * @return the lineaEmpaqueFuncionarioDTOs
	 */
	public Collection<LineaEmpaqueFuncionarioDTO> getLineaEmpaqueFuncionarioDTOs() {
		return lineaEmpaqueFuncionarioDTOs;
	}
	/**
	 * Método Setter the lineaEmpaqueFuncionarioDTOs
	 * @param lineaEmpaqueFuncionarioDTOs the lineaEmpaqueFuncionarioDTOs to set
	 */
	public void setLineaEmpaqueFuncionarioDTOs(Collection<LineaEmpaqueFuncionarioDTO> lineaEmpaqueFuncionarioDTOs) {
		this.lineaEmpaqueFuncionarioDTOs = lineaEmpaqueFuncionarioDTOs;
	}
	/**
	 * Método Getter del campo listaFuncionario
	 * @return the listaFuncionario
	 */
	public Collection<FuncionarioDTO> getListaFuncionario() {
		return listaFuncionario;
	}
	/**
	 * Método Setter the listaFuncionario
	 * @param listaFuncionario the listaFuncionario to set
	 */
	public void setListaFuncionario(Collection<FuncionarioDTO> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}



	/**
	 * Método Getter del campo numeroDocumento
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}



	/**
	 * Método Setter the numeroDocumento
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}



	/**
	 * Método Getter del campo nombreFuncionario
	 * @return the nombreFuncionario
	 */
	public String getNombreFuncionario() {
		return nombreFuncionario;
	}



	/**
	 * Método Setter the nombreFuncionario
	 * @param nombreFuncionario the nombreFuncionario to set
	 */
	public void setNombreFuncionario(String nombreFuncionario) {
		this.nombreFuncionario = nombreFuncionario;
	}



	/**
	 * Método Getter del campo apellidoFuncionario
	 * @return the apellidoFuncionario
	 */
	public String getApellidoFuncionario() {
		return apellidoFuncionario;
	}



	/**
	 * Método Setter the apellidoFuncionario
	 * @param apellidoFuncionario the apellidoFuncionario to set
	 */
	public void setApellidoFuncionario(String apellidoFuncionario) {
		this.apellidoFuncionario = apellidoFuncionario;
	}



	/**
	 * Método Getter del campo idUsuario
	 * @return the idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}



	/**
	 * Método Setter the idUsuario
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
