package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.ProcesoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoClaseDTO;


@SuppressWarnings("serial")
public class ProcesoVO extends BaseVO<ProcesoDTO> {

	private Boolean obtenerClases=Boolean.FALSE;
	private Boolean obtenerRelacionAreaTrabajo=Boolean.FALSE;
	private Boolean obtenerPerfil=Boolean.FALSE;
	private Boolean obtenerTodo=Boolean.FALSE;
	private Collection<ProcesoClaseDTO> procesoClaseDTOs;
	private Boolean obtenerProceso=Boolean.FALSE;

	public void limpiarFilters(){
		setObtenerProceso(Boolean.FALSE);
		setObtenerClases(Boolean.FALSE);
		setObtenerRelacionAreaTrabajo(Boolean.FALSE);
		setObtenerPerfil(Boolean.FALSE);
		setObtenerTodo(Boolean.FALSE);
	}
	public Boolean getObtenerClases() {
		return obtenerClases;
	}
	public void setObtenerClases(Boolean obtenerClases) {
		this.obtenerClases = obtenerClases;
	}
	public Boolean getObtenerRelacionAreaTrabajo() {
		return obtenerRelacionAreaTrabajo;
	}
	public void setObtenerRelacionAreaTrabajo(Boolean obtenerRelacionAreaTrabajo) {
		this.obtenerRelacionAreaTrabajo = obtenerRelacionAreaTrabajo;
	}
	public Boolean getObtenerPerfil() {
		return obtenerPerfil;
	}
	public void setObtenerPerfil(Boolean obtenerPerfil) {
		this.obtenerPerfil = obtenerPerfil;
	}
	public Boolean getObtenerTodo() {
		return obtenerTodo;
	}
	public void setObtenerTodo(Boolean obtenerTodo) {
		this.obtenerTodo = obtenerTodo;
	}
	public Collection<ProcesoClaseDTO> getProcesoClaseDTOs() {
		return procesoClaseDTOs;
	}
	public void setProcesoClaseDTOs(Collection<ProcesoClaseDTO> procesoClaseDTOs) {
		this.procesoClaseDTOs = procesoClaseDTOs;
	}
	public Boolean getObtenerProceso() {
		return obtenerProceso;
	}
	public void setObtenerProceso(Boolean obtenerProceso) {
		this.obtenerProceso = obtenerProceso;
	}
}
