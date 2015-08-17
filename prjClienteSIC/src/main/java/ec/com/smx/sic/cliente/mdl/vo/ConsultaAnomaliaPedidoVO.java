package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ContenedorEstadoDTO;

@SuppressWarnings("serial")
public class ConsultaAnomaliaPedidoVO extends BaseVO<ContenedorEstadoDTO> {
	public ConsultaAnomaliaPedidoVO() {
		super();
		this.fechaFin = new Date();
		this.fechaInicio = new Date();
	}

	private Date fechaInicio;
	private Date fechaFin;
	
	private AreaTrabajoDTO bodegas;
	
	private AreaTrabajoDTO centroDistribucion;
	private AreaTrabajoDTO bodega;
	private AreaTrabajoDTO subbodegaO;
	private AreaTrabajoDTO local;
	private Collection<AreaTrabajoDTO> subbodegaDisponibles;
	
	private Integer subbodega;
	
	private String tipoAnomalia;
	
	private Map<String, Object> filtrosMap;
	
	private Integer codigoCompania;
	private boolean presentarLocal;

	

	
	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the bodegas
	 */
	public AreaTrabajoDTO getBodegas() {
		return bodegas;
	}

	/**
	 * @param bodegas the bodegas to set
	 */
	public void setBodegas(AreaTrabajoDTO bodegas) {
		this.bodegas = bodegas;
	}

	/**
	 * @return the centroDistribucion
	 */
	public AreaTrabajoDTO getCentroDistribucion() {
		return centroDistribucion;
	}

	/**
	 * @param centroDistribucion the centroDistribucion to set
	 */
	public void setCentroDistribucion(AreaTrabajoDTO centroDistribucion) {
		this.centroDistribucion = centroDistribucion;
	}

	/**
	 * @return the bodega
	 */
	public AreaTrabajoDTO getBodega() {
		return bodega;
	}

	/**
	 * @param bodega the bodega to set
	 */
	public void setBodega(AreaTrabajoDTO bodega) {
		this.bodega = bodega;
	}

	/**
	 * @return the subbodegaO
	 */
	public AreaTrabajoDTO getSubbodegaO() {
		return subbodegaO;
	}

	/**
	 * @param subbodegaO the subbodegaO to set
	 */
	public void setSubbodegaO(AreaTrabajoDTO subbodegaO) {
		this.subbodegaO = subbodegaO;
	}

	/**
	 * @return the local
	 */
	public AreaTrabajoDTO getLocal() {
		return local;
	}

	/**
	 * @param local the local to set
	 */
	public void setLocal(AreaTrabajoDTO local) {
		this.local = local;
	}

	/**
	 * @return the subbodega
	 */
	public Integer getSubbodega() {
		return subbodega;
	}

	/**
	 * @param subbodega the subbodega to set
	 */
	public void setSubbodega(Integer subbodega) {
		this.subbodega = subbodega;
	}

	/**
	 * @return the filtrosMap
	 */
	public Map<String, Object> getFiltrosMap() {
		return filtrosMap;
	}

	/**
	 * @param filtrosMap the filtrosMap to set
	 */
	public void setFiltrosMap(Map<String, Object> filtrosMap) {
		this.filtrosMap = filtrosMap;
	}

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
	 * @return the subbodegaDisponibles
	 */
	public Collection<AreaTrabajoDTO> getSubbodegaDisponibles() {
		return subbodegaDisponibles;
	}

	/**
	 * @param subbodegaDisponibles the subbodegaDisponibles to set
	 */
	public void setSubbodegaDisponibles(Collection<AreaTrabajoDTO> subbodegaDisponibles) {
		this.subbodegaDisponibles = subbodegaDisponibles;
	}

	/**
	 * @return the tipoAnomalia
	 */
	public String getTipoAnomalia() {
		return tipoAnomalia;
	}

	/**
	 * @param tipoAnomalia the tipoAnomalia to set
	 */
	public void setTipoAnomalia(String tipoAnomalia) {
		this.tipoAnomalia = tipoAnomalia;
	}

	public void setPresentarLocal(boolean presentarLocal) {
		this.presentarLocal = presentarLocal;		
	}
	
	public boolean isPresentarLocal (){
		return this.presentarLocal;
	}

	
}
