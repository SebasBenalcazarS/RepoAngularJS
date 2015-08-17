package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.DatosBusquedaAreaTrabajoEST;

/**
 * 
 * @author bsandoval
 *
 */

@SuppressWarnings("serial")
public class MonitoreoPedidoVO extends BaseVO<PedidoAreaTrabajoEstadoDTO> {
	
	private Collection<CatalogoValorDTO> catalogoValorEstadosDTOCol;
	private Collection<AreaTrabajoDTO> bodegaDTOCol,bodegasEncontradas;
	private Collection<PedidoAreaTrabajoDTO> pedidoAreaTrabajoDTOCol;
	private PedidoAreaTrabajoDTO pedidoAreaTrabajoDTO, pedidoDeplegar;
	private Collection<PedidoAreaTrabajoDetalleDTO> pedAreaTrabajoDetalleCol;
	private Collection<PedidoAreaTrabajoDTO> pedidosSeleccionados;
	private String codigoEstadoCataloValor;
	private String nombreUsuario;
	private String mensajeError;
	HashSet<String> pedidosError = null;
	HashSet<String> pedidosValidos = null;
	private Date fechaPedido;
	private DatosBusquedaAreaTrabajoEST datosBusquedaAreaTrabajoEST;
	private Integer codigoEstadoCatalogoTipo;
	
	private Integer codigoSubbodegaSeleccionada;
	private Collection<AreaTrabajoDTO> bodegasSelect;
	private AreaTrabajoDTO localSelect;
	private AreaTrabajoDTO cdSelect;
	private Long countResults;
	private Boolean perfilSistemas = null;
	private Boolean ultimo = null;
	private Boolean todos = false;
	
	private Integer codigoCompania;
	private Integer codigoAreaTrabajoPedido;
	
	private String mensajeExito;
	private String msjError;
	private Integer hiloUsuarios=0,hiloHijos=0,hilosConfiguracion=0;
	
	// Visualizacion pedido asistido
	private String tipoVisualizacionSeleccionada;
	
	private String identificadorArchivoSesion;
	
	private HashMap<Integer, Collection<String>> bodegasUsariosMap; 
	
	/**
	 * @return
	 */
	public Collection<CatalogoValorDTO> getCatalogoValorDTOCol() {
		return catalogoValorEstadosDTOCol;
	}
	
	/**
	 * @param catalogoValorDTOCol
	 */
	public void setCatalogoValorDTOCol(Collection<CatalogoValorDTO> catalogoValorDTOCol) {
		this.catalogoValorEstadosDTOCol = catalogoValorDTOCol;
	}


	/**
	 * @return
	 */
	public Collection<AreaTrabajoDTO> getBodegaDTOCol() {
		return bodegaDTOCol;
	}

	/**
	 * @param bodegaDTOCol
	 */
	public void setBodegaDTOCol(Collection<AreaTrabajoDTO> bodegaDTOCol) {
		this.bodegaDTOCol = bodegaDTOCol;
	}

	/**
	 * @return
	 */
	public Collection<PedidoAreaTrabajoDTO> getPedidoAreaTrabajoDTOCol() {
		return pedidoAreaTrabajoDTOCol;
	}

	/**
	 * @param pedidoAreaTrabajoDTOCol
	 */
	public void setPedidoAreaTrabajoDTOCol(Collection<PedidoAreaTrabajoDTO> pedidoAreaTrabajoDTOCol) {
		this.pedidoAreaTrabajoDTOCol = pedidoAreaTrabajoDTOCol;
	}

	/**
	 * @return
	 */
	public String getCodigoEstadoCataloValor() {
		return codigoEstadoCataloValor;
	}

	/**
	 * @param codigoEstadoCataloValor
	 */
	public void setCodigoEstadoCataloValor(String codigoEstadoCataloValor) {
		this.codigoEstadoCataloValor = codigoEstadoCataloValor;
	}

	/**
	 * @return the accion
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	/**
	 * @return the pedidosError
	 */
	public HashSet<String> getPedidosError() {
		return pedidosError;
	}

	/**
	 * @param pedidosError the pedidosError to set
	 */
	public void setPedidosError(HashSet<String> pedidosError) {
		this.pedidosError = pedidosError;
	}

	/**
	 * @return the pedidosValidos
	 */
	public HashSet<String> getPedidosValidos() {
		return pedidosValidos;
	}

	/**
	 * @param pedidosValidos the pedidosValidos to set
	 */
	public void setPedidosValidos(HashSet<String> pedidosValidos) {
		this.pedidosValidos = pedidosValidos;
	}


	/**
	 * @return the mensajeError
	 */
	public String getMensajeError() {
		return mensajeError;
	}

	/**
	 * @param mensajeError the mensajeError to set
	 */
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	public PedidoAreaTrabajoDTO getPedidoAreaTrabajoDTO() {
		return pedidoAreaTrabajoDTO;
	}

	public void setPedidoAreaTrabajoDTO(PedidoAreaTrabajoDTO pedidoAreaTrabajoDTO) {
		this.pedidoAreaTrabajoDTO = pedidoAreaTrabajoDTO;
	}

	public Collection<PedidoAreaTrabajoDetalleDTO> getPedAreaTrabajoDetalleCol() {
		return pedAreaTrabajoDetalleCol;
	}

	public void setPedAreaTrabajoDetalleCol(Collection<PedidoAreaTrabajoDetalleDTO> pedAreaTrabajoDetalleCol) {
		this.pedAreaTrabajoDetalleCol = pedAreaTrabajoDetalleCol;
	}

	public String getTipoVisualizacionSeleccionada() {
		return tipoVisualizacionSeleccionada;
	}

	public void setTipoVisualizacionSeleccionada(String tipoVisualizacionSeleccionada) {
		this.tipoVisualizacionSeleccionada = tipoVisualizacionSeleccionada;
	}


	/**
	 * @return the codigoSubbodegaSeleccionada
	 */
	public Integer getCodigoSubbodegaSeleccionada() {
		return codigoSubbodegaSeleccionada;
	}

	/**
	 * @param codigoSubbodegaSeleccionada the codigoSubbodegaSeleccionada to set
	 */
	public void setCodigoSubbodegaSeleccionada(Integer codigoSubbodegaSeleccionada) {
		this.codigoSubbodegaSeleccionada = codigoSubbodegaSeleccionada;
	}

	/**
	 * @return the bodegasSelect
	 */
	public Collection<AreaTrabajoDTO> getBodegasSelect() {
		return bodegasSelect;
	}

	/**
	 * @param bodegasSelect the bodegasSelect to set
	 */
	public void setBodegasSelect(Collection<AreaTrabajoDTO> bodegasSelect) {
		this.bodegasSelect = bodegasSelect;
	}

	/**
	 * @return the localSelect
	 */
	public AreaTrabajoDTO getLocalSelect() {
		return localSelect;
	}

	/**
	 * @param localSelect the localSelect to set
	 */
	public void setLocalSelect(AreaTrabajoDTO localSelect) {
		this.localSelect = localSelect;
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
	 * @return the codigoAreaTrabajoPedido
	 */
	public Integer getCodigoAreaTrabajoPedido() {
		return codigoAreaTrabajoPedido;
	}

	/**
	 * @param codigoAreaTrabajoPedido the codigoAreaTrabajoPedido to set
	 */
	public void setCodigoAreaTrabajoPedido(Integer codigoAreaTrabajoPedido) {
		this.codigoAreaTrabajoPedido = codigoAreaTrabajoPedido;
	}


	/**
	 * @return the mensajeExito
	 */
	public String getMensajeExito() {
		return mensajeExito;
	}

	/**
	 * @param mensajeExito the mensajeExito to set
	 */
	public void setMensajeExito(String mensajeExito) {
		this.mensajeExito = mensajeExito;
	}

	/**
	 * @return the msjError
	 */
	public String getMsjError() {
		return msjError;
	}

	/**
	 * @param msjError the msjError to set
	 */
	public void setMsjError(String msjError) {
		this.msjError = msjError;
	}

	/**
	 * @return the pedidosSeleccionados
	 */
	public Collection<PedidoAreaTrabajoDTO> getPedidosSeleccionados() {
		return pedidosSeleccionados;
	}

	/**
	 * @param pedidosSeleccionados the pedidosSeleccionados to set
	 */
	public void setPedidosSeleccionados(Collection<PedidoAreaTrabajoDTO> pedidosSeleccionados) {
		this.pedidosSeleccionados = pedidosSeleccionados;
	}

	/**
	 * @return the bodegasEncontradas
	 */
	public Collection<AreaTrabajoDTO> getBodegasEncontradas() {
		return bodegasEncontradas;
	}

	/**
	 * @param bodegasEncontradas the bodegasEncontradas to set
	 */
	public void setBodegasEncontradas(Collection<AreaTrabajoDTO> bodegasEncontradas) {
		this.bodegasEncontradas = bodegasEncontradas;
	}

	/**
	 * @return the fechaPedido
	 */
	public Date getFechaPedido() {
		return fechaPedido;
	}

	/**
	 * @param fechaPedido the fechaPedido to set
	 */
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
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
	 * @return the codigoEstadoCatalogoTipo
	 */
	public Integer getCodigoEstadoCatalogoTipo() {
		return codigoEstadoCatalogoTipo;
	}

	/**
	 * @param codigoEstadoCatalogoTipo the codigoEstadoCatalogoTipo to set
	 */
	public void setCodigoEstadoCatalogoTipo(Integer codigoEstadoCatalogoTipo) {
		this.codigoEstadoCatalogoTipo = codigoEstadoCatalogoTipo;
	}

	/**
	 * @return the cdSelect
	 */
	public AreaTrabajoDTO getCdSelect() {
		return cdSelect;
	}

	/**
	 * @param cdSelect the cdSelect to set
	 */
	public void setCdSelect(AreaTrabajoDTO cdSelect) {
		this.cdSelect = cdSelect;
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
	 * @return the perfilSistemas
	 */
	public Boolean getPerfilSistemas() {
		return perfilSistemas;
	}

	/**
	 * @param perfilSistemas the perfilSistemas to set
	 */
	public void setPerfilSistemas(Boolean perfilSistemas) {
		this.perfilSistemas = perfilSistemas;
	}

	/**
	 * @return the pedidoDeplegar
	 */
	public PedidoAreaTrabajoDTO getPedidoDeplegar() {
		return pedidoDeplegar;
	}

	/**
	 * @param pedidoDeplegar the pedidoDeplegar to set
	 */
	public void setPedidoDeplegar(PedidoAreaTrabajoDTO pedidoDeplegar) {
		this.pedidoDeplegar = pedidoDeplegar;
	}

	/**
	 * @return the ultimo
	 */
	public Boolean getUltimo() {
		return ultimo;
	}

	/**
	 * @param ultimo the ultimo to set
	 */
	public void setUltimo(Boolean ultimo) {
		this.ultimo = ultimo;
	}

	public Boolean getTodos() {
		return todos;
	}

	public void setTodos(Boolean todos) {
		this.todos = todos;
	}

	public String getIdentificadorArchivoSesion() {
		return identificadorArchivoSesion;
	}

	public void setIdentificadorArchivoSesion(String identificadorArchivoSesion) {
		this.identificadorArchivoSesion = identificadorArchivoSesion;
	}

	public HashMap<Integer, Collection<String>> getBodegasUsariosMap() {
		return bodegasUsariosMap;
	}

	public void setBodegasUsariosMap(HashMap<Integer, Collection<String>> bodegasUsariosMap) {
		this.bodegasUsariosMap = bodegasUsariosMap;
	}

	public Integer getHiloUsuarios() {
		return hiloUsuarios;
	}

	public void setHiloUsuarios(Integer hiloUsuarios) {
		this.hiloUsuarios = hiloUsuarios;
	}

	public Integer getHiloHijos() {
		return hiloHijos;
	}

	public void setHiloHijos(Integer hiloHijos) {
		this.hiloHijos = hiloHijos;
	}

	public Integer getHilosConfiguracion() {
		return hilosConfiguracion;
	}

	public void setHilosConfiguracion(Integer hilosConfiguracion) {
		this.hilosConfiguracion = hilosConfiguracion;
	}
	
}
