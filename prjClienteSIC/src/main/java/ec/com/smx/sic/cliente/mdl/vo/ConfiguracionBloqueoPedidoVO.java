package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.DatosBusquedaAreaTrabajoEST;

/**
 * @author bsandoval
 *
 */
@SuppressWarnings("serial")
public class ConfiguracionBloqueoPedidoVO extends BaseVO<AreaTrabajoCalendarioProcesoDTO>{

	//Estructura para tabla de configuracion de pedido asistido 
	private Collection<AreaTrabajoCalendarioProcesoDTO> areaTrabajoCalendarioProcesos;
	private Collection<EstructuraConfiguracionBloqueoPedidoAsistidoVO> estructurasBloqueos;
	private DatosBusquedaAreaTrabajoEST datosBusquedaAreaTrabajoEST;
	private Integer codigoSubbodegaSelect;
	private Long countResults;
	private Collection<Integer> codigosDias;
	

	/*GETTERS AND SETTERS*/
	public Collection<AreaTrabajoCalendarioProcesoDTO> getAreaTrabajoCalendarioProcesos() {
		return areaTrabajoCalendarioProcesos;
	}

	public void setAreaTrabajoCalendarioProcesos(Collection<AreaTrabajoCalendarioProcesoDTO> areaTrabajoCalendarioProcesos) {
		this.areaTrabajoCalendarioProcesos = areaTrabajoCalendarioProcesos;
	}

	public DatosBusquedaAreaTrabajoEST getDatosBusquedaAreaTrabajoEST() {
		return datosBusquedaAreaTrabajoEST;
	}

	public void setDatosBusquedaAreaTrabajoEST(DatosBusquedaAreaTrabajoEST datosBusquedaAreaTrabajoEST) {
		this.datosBusquedaAreaTrabajoEST = datosBusquedaAreaTrabajoEST;
	}


	public Integer getCodigoSubbodegaSelect() {
		return codigoSubbodegaSelect;
	}

	public void setCodigoSubbodegaSelect(Integer codigoSubbodegaSelect) {
		this.codigoSubbodegaSelect = codigoSubbodegaSelect;
	}

	/**
	 * @return the estructurasBloqueos
	 */
	public Collection<EstructuraConfiguracionBloqueoPedidoAsistidoVO> getEstructurasBloqueos() {
		return estructurasBloqueos;
	}

	/**
	 * @param estructurasBloqueos the estructurasBloqueos to set
	 */
	public void setEstructurasBloqueos(Collection<EstructuraConfiguracionBloqueoPedidoAsistidoVO> estructurasBloqueos) {
		this.estructurasBloqueos = estructurasBloqueos;
	}

	/**
	 * @return the countResults
	 */
	public Long getCountResults() {
		return countResults;
	}

	/**
	 * @param countResults the countResults to set
	 */
	public void setCountResults(Long countResults) {
		this.countResults = countResults;
	}

	/**
	 * @return the codigosDias
	 */
	public Collection<Integer> getCodigosDias() {
		return codigosDias;
	}

	/**
	 * @param codigosDias the codigosDias to set
	 */
	public void setCodigosDias(Collection<Integer> codigosDias) {
		this.codigosDias = codigosDias;
	}

	

}
