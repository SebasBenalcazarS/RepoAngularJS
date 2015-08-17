package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;

/**
 * 
 * @author cherrera
 *
 */
@SuppressWarnings("serial")
public class EntregaRecipientesVO extends ControlRecipienteDTO{

	//DEFINICION DE VARIABLES

	//Campos de VO 
	private ControlRecipienteDTO controlRecipienteAnterior;
	private Collection<FuncionarioDTO> funcionariosCol;
	private Collection<RecepcionProveedorDTO> recepcionProveedorCol;
	private Collection<String> mensajesError;
	private Collection<String> mensajesInfo;

	//Mensaje de confirmacion de popup botones de navegacion
	private String mensajeConf;
	private String accessItemId;
	private String systemId;
	private String evento;

	//Funcionario Seleccionado
	private FuncionarioDTO funcionarioSeleccionado;
	//Filtros
	
	private String username;
	private String nombreCompleto;
	
	private RecepcionProveedorDTO recepcionProveedorSelect;
	//DEFINICION DE METODOS
	
	//DEFINICION DE ACCESORES Y MUTADORES
	
	public ControlRecipienteDTO getControlRecipienteAnterior() {
		return controlRecipienteAnterior;
	}

	public void setControlRecipienteAnterior(ControlRecipienteDTO controlRecipienteAnterior) {
		this.controlRecipienteAnterior = controlRecipienteAnterior;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public Collection<String> getMensajesError() {
		return mensajesError;
	}

	public void setMensajesError(Collection<String> mensajesError) {
		this.mensajesError = mensajesError;
	}

	public Collection<String> getMensajesInfo() {
		return mensajesInfo;
	}

	public void setMensajesInfo(Collection<String> mensajesInfo) {
		this.mensajesInfo = mensajesInfo;
	}

	public String getMensajeConf() {
		return mensajeConf;
	}

	public void setMensajeConf(String mensajeConf) {
		this.mensajeConf = mensajeConf;
	}

	public String getAccessItemId() {
		return accessItemId;
	}

	public void setAccessItemId(String accessItemId) {
		this.accessItemId = accessItemId;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	
	public Collection<RecepcionProveedorDTO> getRecepcionProveedorCol() {
		return recepcionProveedorCol;
	}

	public void setRecepcionProveedorCol(Collection<RecepcionProveedorDTO> recepcionProveedorCol) {
		this.recepcionProveedorCol = recepcionProveedorCol;
	}

	public Collection<FuncionarioDTO> getFuncionariosCol() {
		return funcionariosCol;
	}

	public void setFuncionariosCol(Collection<FuncionarioDTO> funcionariosCol) {
		this.funcionariosCol = funcionariosCol;
	}

	public FuncionarioDTO getFuncionarioSeleccionado() {
		return funcionarioSeleccionado;
	}

	public void setFuncionarioSeleccionado(FuncionarioDTO funcionarioSeleccionado) {
		this.funcionarioSeleccionado = funcionarioSeleccionado;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public RecepcionProveedorDTO getRecepcionProveedorSelect() {
		return recepcionProveedorSelect;
	}

	public void setRecepcionProveedorSelect(RecepcionProveedorDTO recepcionProveedorSelect) {
		this.recepcionProveedorSelect = recepcionProveedorSelect;
	}

}
