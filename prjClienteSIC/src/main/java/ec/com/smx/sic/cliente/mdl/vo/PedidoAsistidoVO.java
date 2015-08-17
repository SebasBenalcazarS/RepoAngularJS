package ec.com.smx.sic.cliente.mdl.vo;

import java.sql.Time;
import java.util.Collection;
import java.util.Map;

import org.quartz.Scheduler;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.ProcesoCatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDetalleDTO;

/**
 * @author finga
 * 
 */
@SuppressWarnings("serial")
public class PedidoAsistidoVO extends BaseVO<PedidoAreaTrabajoDTO> {

	/** Datos a persistir **/

	private FuncionarioDTO funcionario;
	private String profileId;
	private String identificadorSesion;
	
	// Codigo area trabajo bodega
	private Integer codigoATBodegaSel;
	// Codigo area trabajo subbodega
	private Integer codigoATSubBodegaSel;
	// Codigo bodega Subbodega
	private String codigoBodegaSubbodega;

	// Opciones seleccionados en filtro de busqueda tipo de articulo
	private Collection<String> filtroTipoArticuloCol;

	// Lista de pedidos encontrados por SB,CD y fecha
	// private Collection<PedidoAreaTrabajoDTO> pedidoCol;

	// Clasificacion actual seleccionada exv
	private PedidoAreaTrabajoClasificacionDTO clasificacionSelect;

	// Clasificacion anterior seleccionada
	private PedidoAreaTrabajoClasificacionDTO clasificacionSelectAnterior;

	// lista detalles referencia sesion
	private Collection<PedidoAreaTrabajoDetalleDTO> pedidoAreaTrabajoDetalleDTOs;

	// Coleccion para guardar los filtros de busqueda
	private Map<String, Object> plantillaFiltroBusquedaCol;

	// Numero total de registros resultado de la busqueda inicial
	private Long countResults;

	// numero de dias para que un articulo se considerado nuevo
	// (ArticuloLocalDTO fechaInicialAlcance)
	private Integer numeroDiasArticuloNuevo;

	// numero de dias para que un articulo se considerado dentro del alcance
	// (ArticuloLocalDTO fechaInicialAlcance)
	private Integer numeroDiasArticuloAlcance;

	// Para operaciones en articulos relacionados
	private Collection<PedidoAreaTrabajoDetalleDTO> detallesRelacionados;
	private Collection<ProcesoCatalogoValorDTO> tipoRelacionArticulos;
	private PedidoAreaTrabajoDetalleDTO detalleSeleccionado;
	private Collection<String> codigoArticulosRelacionados;

	// bandera para diferenciar entre detalles normales o detalles relacionados
	private String tipoDetalle;

	// bandera para diferenciar entre el tipo de pedido
	private String tipoPedido;

	// Parametros para busqueda - pedido por articulo
	private String pCodigoBarras;

	// Parametro para manejar en consultas
	private String tipoIngreso;

	// Variable de monitoreo
	private PedidoAreaTrabajoDTO pedidoSeleccionado;

	// Clases asociadas al pedido para busqueda
	private Collection<String> clasesPedidoAsistido;

	// Mapa para guardar detalles por clasificacion
	private Collection<PedidoAreaTrabajoClasificacionDTO> clasificacionesAfectadas;
	
	//Hora de transmisión para cambio de hora
	private  Time horaMaximaPedido;
	
	private Long codigoTipoAutorizacion;
	
	private Boolean llenarCantidadPedida;

	private Scheduler scheduler;
	
	// frecuencia de rotacion
	private String frecuenciaRotacion;
	
	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	public Collection<PedidoAreaTrabajoDetalleDTO> getPedidoAreaTrabajoDetalleDTOs() {
		return pedidoAreaTrabajoDetalleDTOs;
	}

	public void setPedidoAreaTrabajoDetalleDTOs(Collection<PedidoAreaTrabajoDetalleDTO> pedidoAreaTrabajoDetalleDTOs) {
		this.pedidoAreaTrabajoDetalleDTOs = pedidoAreaTrabajoDetalleDTOs;
	}

	public Map<String, Object> getPlantillaFiltroBusquedaCol() {
		return plantillaFiltroBusquedaCol;
	}

	public void setPlantillaFiltroBusquedaCol(Map<String, Object> plantillaFiltroBusquedaCol) {
		this.plantillaFiltroBusquedaCol = plantillaFiltroBusquedaCol;
	}

	public Long getCountResults() {
		return countResults;
	}

	public void setCountResults(Long countResults) {
		this.countResults = countResults;
	}

	public Integer getNumeroDiasArticuloNuevo() {
		return numeroDiasArticuloNuevo;
	}

	public void setNumeroDiasArticuloNuevo(Integer numeroDiasArticuloNuevo) {
		this.numeroDiasArticuloNuevo = numeroDiasArticuloNuevo;
	}

	public Integer getNumeroDiasArticuloAlcance() {
		return numeroDiasArticuloAlcance;
	}

	public void setNumeroDiasArticuloAlcance(Integer numeroDiasArticuloAlcance) {
		this.numeroDiasArticuloAlcance = numeroDiasArticuloAlcance;
	}

	public PedidoAreaTrabajoDetalleDTO getDetalleSeleccionado() {
		return detalleSeleccionado;
	}

	public void setDetalleSeleccionado(PedidoAreaTrabajoDetalleDTO detalleSeleccionado) {
		this.detalleSeleccionado = detalleSeleccionado;
	}

	public Collection<PedidoAreaTrabajoDetalleDTO> getDetallesRelacionados() {
		return detallesRelacionados;
	}

	public void setDetallesRelacionados(Collection<PedidoAreaTrabajoDetalleDTO> detallesRelacionados) {
		this.detallesRelacionados = detallesRelacionados;
	}

	public Collection<ProcesoCatalogoValorDTO> getTipoRelacionArticulos() {
		return tipoRelacionArticulos;
	}

	public void setTipoRelacionArticulos(Collection<ProcesoCatalogoValorDTO> tipoRelacionArticulos) {
		this.tipoRelacionArticulos = tipoRelacionArticulos;
	}

	public Collection<String> getCodigoArticulosRelacionados() {
		return codigoArticulosRelacionados;
	}

	public void setCodigoArticulosRelacionados(Collection<String> codigoArticulosRelacionados) {
		this.codigoArticulosRelacionados = codigoArticulosRelacionados;
	}

	public String getTipoDetalle() {
		return tipoDetalle;
	}

	public void setTipoDetalle(String tipoDetalle) {
		this.tipoDetalle = tipoDetalle;
	}

	public String getpCodigoBarras() {
		return pCodigoBarras;
	}

	public void setpCodigoBarras(String pCodigoBarras) {
		this.pCodigoBarras = pCodigoBarras;
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public PedidoAreaTrabajoClasificacionDTO getClasificacionSelect() {
		return clasificacionSelect;
	}

	public void setClasificacionSelect(PedidoAreaTrabajoClasificacionDTO clasificacionSelect) {
		this.clasificacionSelect = clasificacionSelect;
	}

	public PedidoAreaTrabajoClasificacionDTO getClasificacionSelectAnterior() {
		return clasificacionSelectAnterior;
	}

	public void setClasificacionSelectAnterior(PedidoAreaTrabajoClasificacionDTO clasificacionSelectAnterior) {
		this.clasificacionSelectAnterior = clasificacionSelectAnterior;
	}

	public String getTipoIngreso() {
		return tipoIngreso;
	}

	public void setTipoIngreso(String tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public Collection<String> getFiltroTipoArticuloCol() {
		return filtroTipoArticuloCol;
	}

	public void setFiltroTipoArticuloCol(Collection<String> filtroTipoArticuloCol) {
		this.filtroTipoArticuloCol = filtroTipoArticuloCol;
	}

	public PedidoAreaTrabajoDTO getPedidoSeleccionado() {
		return pedidoSeleccionado;
	}

	public void setPedidoSeleccionado(PedidoAreaTrabajoDTO pedidoSeleccionado) {
		this.pedidoSeleccionado = pedidoSeleccionado;
	}

	public Collection<PedidoAreaTrabajoClasificacionDTO> getClasificacionesAfectadas() {
		return clasificacionesAfectadas;
	}

	public void setClasificacionesAfectadas(Collection<PedidoAreaTrabajoClasificacionDTO> clasificacionesAfectadas) {
		this.clasificacionesAfectadas = clasificacionesAfectadas;
	}

	public Collection<String> getClasesPedidoAsistido() {
		return clasesPedidoAsistido;
	}

	public void setClasesPedidoAsistido(Collection<String> clasesPedidoAsistido) {
		this.clasesPedidoAsistido = clasesPedidoAsistido;
	}

	public Long getCodigoTipoAutorizacion() {
		return codigoTipoAutorizacion;
	}

	public void setCodigoTipoAutorizacion(Long codigoTipoAutorizacion) {
		this.codigoTipoAutorizacion = codigoTipoAutorizacion;
	}

	/**
	 * @return the codigoATSubBodegaSel
	 */
	public Integer getCodigoATSubBodegaSel() {
		return codigoATSubBodegaSel;
	}

	/**
	 * @param codigoATSubBodegaSel the codigoATSubBodegaSel to set
	 */
	public void setCodigoATSubBodegaSel(Integer codigoATSubBodegaSel) {
		this.codigoATSubBodegaSel = codigoATSubBodegaSel;
	}

	/**
	 * @return the horaMaximaPedido
	 */
	public Time getHoraMaximaPedido() {
		return horaMaximaPedido;
	}

	/**
	 * @param horaMaximaPedido the horaMaximaPedido to set
	 */
	public void setHoraMaximaPedido(Time horaMaximaPedido) {
		this.horaMaximaPedido = horaMaximaPedido;
	}

	public Boolean getLlenarCantidadPedida() {
		return llenarCantidadPedida;
	}

	public void setLlenarCantidadPedida(Boolean llenarCantidadPedida) {
		this.llenarCantidadPedida = llenarCantidadPedida;
	}

	/**
	 * @return the codigoBodegaSubbodega
	 */
	public String getCodigoBodegaSubbodega() {
		return codigoBodegaSubbodega;
	}

	/**
	 * @param codigoBodegaSubbodega the codigoBodegaSubbodega to set
	 */
	public void setCodigoBodegaSubbodega(String codigoBodegaSubbodega) {
		this.codigoBodegaSubbodega = codigoBodegaSubbodega;
	}

	/**
	 * @return the codigoATBodegaSel
	 */
	public Integer getCodigoATBodegaSel() {
		return codigoATBodegaSel;
	}

	/**
	 * @param codigoATBodegaSel the codigoATBodegaSel to set
	 */
	public void setCodigoATBodegaSel(Integer codigoATBodegaSel) {
		this.codigoATBodegaSel = codigoATBodegaSel;
	}

	/**
	 * @return the scheduler
	 */
	public Scheduler getScheduler() {
		return scheduler;
	}

	/**
	 * @param scheduler the scheduler to set
	 */
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	public String getIdentificadorSesion() {
		return identificadorSesion;
	}

	public void setIdentificadorSesion(String identificadorSesion) {
		this.identificadorSesion = identificadorSesion;
	}

	public String getFrecuenciaRotacion() {
		return frecuenciaRotacion;
	}

	public void setFrecuenciaRotacion(String frecuenciaRotacion) {
		this.frecuenciaRotacion = frecuenciaRotacion;
	}
}
