package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoDTO;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoDetalleDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.DatosBusquedaAreaTrabajoEST;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
public class ConfiguracionPedidoAsistidoVO extends BaseVO<AreaTrabajoCalendarioProcesoDTO>{

	//Estructura para tabla de configuracion de pedido asistido 
	private Collection<EstructuraConfiguracionPedidoAsistidoVO> estructuraConfiguracionPedidoAsistidoVOs;
	private DatosBusquedaAreaTrabajoEST datosBusquedaAreaTrabajoEST;
	//Objetos
	private FuncionarioDTO funcionario;
	private Long codigoAreaTrabajoCalendarioProcesoPadre;
	//bandera para identificar si se esta en proceso de almacenamiento de una configuracion
	private boolean esAlmacenamiento;
	private boolean todasSubbodegas;
	private Collection<Integer> codigosSubbodegas;
	private Integer codigoSubbodegaSelect;
	private Collection<Integer> codigosLocales;
	private Integer codigoDia, codigoDiaSelect;
	private Collection<AreaTrabajoCalendarioProcesoDetalleDTO> configuracionesDetallesSeleccionadas;
	private Collection<AreaTrabajoCalendarioProcesoDTO> calendarioLocales;
	
	/*GETTERS AND SETTERS*/
	/**
	 * @return the estructuraConfiguracionPedidoAsistidoVOs
	 */
	public Collection<EstructuraConfiguracionPedidoAsistidoVO> getEstructuraConfiguracionPedidoAsistidoVOs() {
		return estructuraConfiguracionPedidoAsistidoVOs;
	}

	/**
	 * @param estructuraConfiguracionPedidoAsistidoVOs the estructuraConfiguracionPedidoAsistidoVOs to set
	 */
	public void setEstructuraConfiguracionPedidoAsistidoVOs(Collection<EstructuraConfiguracionPedidoAsistidoVO> estructuraConfiguracionPedidoAsistidoVOs) {
		this.estructuraConfiguracionPedidoAsistidoVOs = estructuraConfiguracionPedidoAsistidoVOs;
	}

	/**
	 * @return the funcionario
	 */
	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the codigoAreaTrabajoCalendarioProcesoPadre
	 */
	public Long getCodigoAreaTrabajoCalendarioProcesoPadre() {
		return codigoAreaTrabajoCalendarioProcesoPadre;
	}

	/**
	 * @param codigoAreaTrabajoCalendarioProcesoPadre the codigoAreaTrabajoCalendarioProcesoPadre to set
	 */
	public void setCodigoAreaTrabajoCalendarioProcesoPadre(Long codigoAreaTrabajoCalendarioProcesoPadre) {
		this.codigoAreaTrabajoCalendarioProcesoPadre = codigoAreaTrabajoCalendarioProcesoPadre;
	}

	/**
	 * @return the datosBusquedaAreaTrabajoEST
	 */
	public DatosBusquedaAreaTrabajoEST getDatosBusquedaAreaTrabajoEST() {
		return datosBusquedaAreaTrabajoEST;
	}

	/**
	 * @param datosBusquedaAreaTrabajoEST the datosBusquedaAreaTrabajoEST to set
	 */
	public void setDatosBusquedaAreaTrabajoEST(DatosBusquedaAreaTrabajoEST datosBusquedaAreaTrabajoEST) {
		this.datosBusquedaAreaTrabajoEST = datosBusquedaAreaTrabajoEST;
	}

	/**
	 * @return the esAlmacenamiento
	 */
	public boolean getEsAlmacenamiento() {
		return esAlmacenamiento;
	}

	/**
	 * @param esAlmacenamiento the esAlmacenamiento to set
	 */
	public void setEsAlmacenamiento(boolean esAlmacenamiento) {
		this.esAlmacenamiento = esAlmacenamiento;
	}

	public boolean isTodasSubbodegas() {
		return todasSubbodegas;
	}

	public void setTodasSubbodegas(boolean todasSubbodegas) {
		this.todasSubbodegas = todasSubbodegas;
	}

	public Collection<Integer> getCodigosSubbodegas() {
		return codigosSubbodegas;
	}

	public void setCodigosSubbodegas(Collection<Integer> codigosSubbodegas) {
		this.codigosSubbodegas = codigosSubbodegas;
	}

	public Integer getCodigoDia() {
		return codigoDia;
	}

	public void setCodigoDia(Integer codigoDia) {
		this.codigoDia = codigoDia;
	}

	public Collection<Integer> getCodigosLocales() {
		return codigosLocales;
	}

	public void setCodigosLocales(Collection<Integer> codigosLocales) {
		this.codigosLocales = codigosLocales;
	}

	public Collection<AreaTrabajoCalendarioProcesoDetalleDTO> getConfiguracionesDetallesSeleccionadas() {
		return configuracionesDetallesSeleccionadas;
	}

	public void setConfiguracionesDetallesSeleccionadas(Collection<AreaTrabajoCalendarioProcesoDetalleDTO> configuracionesDetallesSeleccionadas) {
		this.configuracionesDetallesSeleccionadas = configuracionesDetallesSeleccionadas;
	}

	public Collection<AreaTrabajoCalendarioProcesoDTO> getCalendarioLocales() {
		return calendarioLocales;
	}

	public void setCalendarioLocales(Collection<AreaTrabajoCalendarioProcesoDTO> calendarioLocales) {
		this.calendarioLocales = calendarioLocales;
	}

	public Integer getCodigoDiaSelect() {
		return codigoDiaSelect;
	}

	public void setCodigoDiaSelect(Integer codigoDiaSelect) {
		this.codigoDiaSelect = codigoDiaSelect;
	}

	/**
	 * @return the codigoSubbodegaSelect
	 */
	public Integer getCodigoSubbodegaSelect() {
		return codigoSubbodegaSelect;
	}

	/**
	 * @param codigoSubbodegaSelect the codigoSubbodegaSelect to set
	 */
	public void setCodigoSubbodegaSelect(Integer codigoSubbodegaSelect) {
		this.codigoSubbodegaSelect = codigoSubbodegaSelect;
	}

}
