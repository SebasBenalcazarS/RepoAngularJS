package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
public class PlanContingenciaOrdenCompraVO extends BaseVO<PedidoDTO>{

	private String userId;
	private PedidoDTO pedidoPlantilla;
	private Map<String, Object> filtrosMapPedido = null;
	private Integer currentPagePedido;
	private Integer valorConsultaPedido = null;
	private String identificadorArchivo;
	private String nombreCarpeta = null;
	private Map<Integer, Object> pedidoBusquedaMap = null;
	private Collection<BodegaDTO> bodegasCol = null;
	//url para la generaci�n del reporte
	private String urlReporte;
	private String vista;
	private FuncionarioDTO funcionario = null;
	private Collection<CatalogoValorDTO> tipoPedidoCol= null;
	private Collection<Long> codigosLineasComercialesCol = null;
	private String identificadorArchivoSesion;
		
	/*GETTERS AND SETTERS*/
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the pedidoPlantilla
	 */
	public PedidoDTO getPedidoPlantilla() {
		return pedidoPlantilla;
	}
	/**
	 * @param pedidoPlantilla the pedidoPlantilla to set
	 */
	public void setPedidoPlantilla(PedidoDTO pedidoPlantilla) {
		this.pedidoPlantilla = pedidoPlantilla;
	}
	/**
	 * @return the filtrosMapPedido
	 */
	public Map<String, Object> getFiltrosMapPedido() {
		return filtrosMapPedido;
	}
	/**
	 * @param filtrosMapPedido the filtrosMapPedido to set
	 */
	public void setFiltrosMapPedido(Map<String, Object> filtrosMapPedido) {
		this.filtrosMapPedido = filtrosMapPedido;
	}
	/**
	 * @return the currentPagePedido
	 */
	public Integer getCurrentPagePedido() {
		return currentPagePedido;
	}
	/**
	 * @param currentPagePedido the currentPagePedido to set
	 */
	public void setCurrentPagePedido(Integer currentPagePedido) {
		this.currentPagePedido = currentPagePedido;
	}
	/**
	 * @return the valorConsultaPedido
	 */
	public Integer getValorConsultaPedido() {
		return valorConsultaPedido;
	}
	/**
	 * @param valorConsultaPedido the valorConsultaPedido to set
	 */
	public void setValorConsultaPedido(Integer valorConsultaPedido) {
		this.valorConsultaPedido = valorConsultaPedido;
	}
	/**
	 * @return the identificadorArchivo
	 */
	public String getIdentificadorArchivo() {
		return identificadorArchivo;
	}
	/**
	 * @param identificadorArchivo the identificadorArchivo to set
	 */
	public void setIdentificadorArchivo(String identificadorArchivo) {
		this.identificadorArchivo = identificadorArchivo;
	}
	/**
	 * @return the nombreCarpeta
	 */
	public String getNombreCarpeta() {
		return nombreCarpeta;
	}
	/**
	 * @param nombreCarpeta the nombreCarpeta to set
	 */
	public void setNombreCarpeta(String nombreCarpeta) {
		this.nombreCarpeta = nombreCarpeta;
	}
	/**
	 * @return the pedidoBusquedaMap
	 */
	public Map<Integer, Object> getPedidoBusquedaMap() {
		return pedidoBusquedaMap;
	}
	/**
	 * @param pedidoBusquedaMap the pedidoBusquedaMap to set
	 */
	public void setPedidoBusquedaMap(Map<Integer, Object> pedidoBusquedaMap) {
		this.pedidoBusquedaMap = pedidoBusquedaMap;
	}
	/**
	 * @return the bodegasCol
	 */
	public Collection<BodegaDTO> getBodegasCol() {
		return bodegasCol;
	}
	/**
	 * @param bodegasCol the bodegasCol to set
	 */
	public void setBodegasCol(Collection<BodegaDTO> bodegasCol) {
		this.bodegasCol = bodegasCol;
	}
	/**
	 * @return the urlReporte
	 */
	public String getUrlReporte() {
		return urlReporte;
	}
	/**
	 * @param urlReporte the urlReporte to set
	 */
	public void setUrlReporte(String urlReporte) {
		this.urlReporte = urlReporte;
	}
	/**
	 * @return the vista
	 */
	public String getVista() {
		return vista;
	}
	/**
	 * @param vista the vista to set
	 */
	public void setVista(String vista) {
		this.vista = vista;
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
	 * @return the tipoPedidoCol
	 */
	public Collection<CatalogoValorDTO> getTipoPedidoCol() {
		return tipoPedidoCol;
	}
	/**
	 * @param tipoPedidoCol the tipoPedidoCol to set
	 */
	public void setTipoPedidoCol(Collection<CatalogoValorDTO> tipoPedidoCol) {
		this.tipoPedidoCol = tipoPedidoCol;
	}
	
	/**
	 * @return the codigosLineasComercialesCol
	 */
	public Collection<Long> getCodigosLineasComercialesCol() {
		return codigosLineasComercialesCol;
	}
	/**
	 * @param codigosLineasComercialesCol the codigosLineasComercialesCol to set
	 */
	public void setCodigosLineasComercialesCol(Collection<Long> codigosLineasComercialesCol) {
		this.codigosLineasComercialesCol = codigosLineasComercialesCol;
	}
	/**
	 * @return the identificadorArchivoSesion
	 */
	public String getIdentificadorArchivoSesion() {
		return identificadorArchivoSesion;
	}
	/**
	 * @param identificadorArchivoSesion the identificadorArchivoSesion to set
	 */
	public void setIdentificadorArchivoSesion(String identificadorArchivoSesion) {
		this.identificadorArchivoSesion = identificadorArchivoSesion;
	}
}
