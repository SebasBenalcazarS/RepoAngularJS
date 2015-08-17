package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.sic.cliente.mdl.dto.VistaLocalizacionFunFilDTO;


public class LocalizacionFundacionFilialVO extends BaseVO<VistaLocalizacionFunFilDTO>{


	private static final long serialVersionUID = 1L;

	private Collection<VistaLocalizacionFunFilDTO> resultadoBusqueda;
	
	/**
	 * Total de registros
	 */
	private Integer totalRegistros;
	
	/**
	 * Tipo de consulta
	 */
	private String tipoConsulta;

	/**
	 * @return the resultadoBusqueda
	 */
	public Collection<VistaLocalizacionFunFilDTO> getResultadoBusqueda() {
		return resultadoBusqueda;
	}
	/**
	 * @param resultadoBusqueda the resultadoBusqueda to set
	 */
	public void setResultadoBusqueda(Collection<VistaLocalizacionFunFilDTO> resultadoBusqueda) {
		this.resultadoBusqueda = resultadoBusqueda;
	}
	/**
	 * @return the totalRegistros
	 */
	public Integer getTotalRegistros() {
		return totalRegistros;
	}
	/**
	 * @param totalRegistros the totalRegistros to set
	 */
	public void setTotalRegistros(Integer totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
	/**
	 * @return the tipoConsulta
	 */
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	/**
	 * @param tipoConsulta the tipoConsulta to set
	 */
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	
	
}
