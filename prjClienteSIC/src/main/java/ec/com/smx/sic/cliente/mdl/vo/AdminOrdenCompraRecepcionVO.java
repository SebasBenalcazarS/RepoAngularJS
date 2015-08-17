package ec.com.smx.sic.cliente.mdl.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.common.beans.InformacionFuncionarioLineaComercial;
import ec.com.smx.corpv2.common.beans.InformacionFuncionarioTipoMarca;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.EmbarqueEstadoImpDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.FacturaDetalleEstadoImpDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.FacturaEstadoImpDTO;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
public class AdminOrdenCompraRecepcionVO extends BaseVO<EmbarqueEstadoImpDTO>{
	
	private String userId;
	//Relaciones 
	private Collection<EmbarqueEstadoImpDTO> embarqueEstadoCol;
	private Collection<FacturaEstadoImpDTO> facturaEstadoDTOCol;
	
	private EmbarqueEstadoImpDTO embarqueEstadoPlantilla;
	private Map<String, Object> filtrosMapEmbarqueEstado = null;
	private Integer currentPageEmbarque;
	private Integer valorConsultaEmbarque = null;
	private Collection<BodegaDTO> bodegasCol = null;
	private FuncionarioDTO funcionario = null;
	
	//Mensaje de exito Creacion;
	private String mensajeExitoCreacion;
	
	//url para la generación del reporte
	private String urlReporte;
	
	private String observacion;
	private Integer codigoOrigenCatTip;
	private String codigoOrigenCatVal;
	private String[] codigosBarraValidados;
	private Collection<Long> codigosLineasComercialesCol = null;
	private List<ArrayList<Long>> codigosDetFactUnidadManejo;
		
	//Bandera de activación de la integración de datos del artículo desde el SIC.
	private Boolean integracionActiva;
	
	private boolean flagErrorEmbarques = false;
	
	private Long codigoMoneda;
	private Double valorCambioMoneda;

	//Tipos de marcas por usuario
	private Collection<InformacionFuncionarioTipoMarca> funcionarioTipoMarcaCol;
	//Lineas comerciales del funcionario
	private Collection<InformacionFuncionarioLineaComercial> funcionarioLineaComercialCol;
	
	//Objetos validos para crear la orden de compra
	private Collection<AdminOrdenCompraVO> adminOrdenCompraVOValidados = null;
	
	//codigos de unidad de manejo
	private Long[] codigosUnidadManejo;
	
	//codigos unidadManejo Facturas validos
	private ConcurrentHashMap<FacturaDetalleEstadoImpDTO, Long> facturaDetallesUnidadManejoValidados;
	
	//Id session
	private String identificadorArchivoSesion;
	
	//Opción y sistema en el que se encuentra el usuario
	private String accessItemId;
	private String systemId;
	
	private HashSet<String> codigosLineaComercial = null;
	
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
	 * @return the embarqueEstadoCol
	 */
	public Collection<EmbarqueEstadoImpDTO> getEmbarqueEstadoCol() {
		return embarqueEstadoCol;
	}

	/**
	 * @param embarqueEstadoCol the embarqueEstadoCol to set
	 */
	public void setEmbarqueEstadoCol(Collection<EmbarqueEstadoImpDTO> embarqueEstadoCol) {
		this.embarqueEstadoCol = embarqueEstadoCol;
	}

	/**
	 * @return the facturaEstadoDTOCol
	 */
	public Collection<FacturaEstadoImpDTO> getFacturaEstadoDTOCol() {
		return facturaEstadoDTOCol;
	}

	/**
	 * @param facturaEstadoDTOCol the facturaEstadoDTOCol to set
	 */
	public void setFacturaEstadoDTOCol(Collection<FacturaEstadoImpDTO> facturaEstadoDTOCol) {
		this.facturaEstadoDTOCol = facturaEstadoDTOCol;
	}

	/**
	 * @return the mensajeExitoCreacion
	 */
	public String getMensajeExitoCreacion() {
		return mensajeExitoCreacion;
	}

	/**
	 * @param mensajeExitoCreacion the mensajeExitoCreacion to set
	 */
	public void setMensajeExitoCreacion(String mensajeExitoCreacion) {
		this.mensajeExitoCreacion = mensajeExitoCreacion;
	}

	/**
	 * @return the embarqueEstadoPlantilla
	 */
	public EmbarqueEstadoImpDTO getEmbarqueEstadoPlantilla() {
		return embarqueEstadoPlantilla;
	}

	/**
	 * @param embarqueEstadoPlantilla the embarqueEstadoPlantilla to set
	 */
	public void setEmbarqueEstadoPlantilla(EmbarqueEstadoImpDTO embarqueEstadoPlantilla) {
		this.embarqueEstadoPlantilla = embarqueEstadoPlantilla;
	}

	/**
	 * @return the filtrosMapEmbarqueEstado
	 */
	public Map<String, Object> getFiltrosMapEmbarqueEstado() {
		return filtrosMapEmbarqueEstado;
	}

	/**
	 * @param filtrosMapEmbarqueEstado the filtrosMapEmbarqueEstado to set
	 */
	public void setFiltrosMapEmbarqueEstado(Map<String, Object> filtrosMapEmbarqueEstado) {
		this.filtrosMapEmbarqueEstado = filtrosMapEmbarqueEstado;
	}

	/**
	 * @return the currentPageEmbarque
	 */
	public Integer getCurrentPageEmbarque() {
		return currentPageEmbarque;
	}

	/**
	 * @param currentPageEmbarque the currentPageEmbarque to set
	 */
	public void setCurrentPageEmbarque(Integer currentPageEmbarque) {
		this.currentPageEmbarque = currentPageEmbarque;
	}

	/**
	 * @return the valorConsultaEmbarque
	 */
	public Integer getValorConsultaEmbarque() {
		return valorConsultaEmbarque;
	}

	/**
	 * @param valorConsultaEmbarque the valorConsultaEmbarque to set
	 */
	public void setValorConsultaEmbarque(Integer valorConsultaEmbarque) {
		this.valorConsultaEmbarque = valorConsultaEmbarque;
	}

	/**
	 * @return the flagErrorEmbarques
	 */
	public boolean isFlagErrorEmbarques() {
		return flagErrorEmbarques;
	}

	/**
	 * @param flagErrorEmbarques the flagErrorEmbarques to set
	 */
	public void setFlagErrorEmbarques(boolean flagErrorEmbarques) {
		this.flagErrorEmbarques = flagErrorEmbarques;
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
	 * @return the integracionActiva
	 */
	public Boolean getIntegracionActiva() {
		return integracionActiva;
	}

	/**
	 * @param integracionActiva the integracionActiva to set
	 */
	public void setIntegracionActiva(Boolean integracionActiva) {
		this.integracionActiva = integracionActiva;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the codigoOrigenCatTip
	 */
	public Integer getCodigoOrigenCatTip() {
		return codigoOrigenCatTip;
	}

	/**
	 * @param codigoOrigenCatTip the codigoOrigenCatTip to set
	 */
	public void setCodigoOrigenCatTip(Integer codigoOrigenCatTip) {
		this.codigoOrigenCatTip = codigoOrigenCatTip;
	}

	/**
	 * @return the codigoOrigenCatVal
	 */
	public String getCodigoOrigenCatVal() {
		return codigoOrigenCatVal;
	}

	/**
	 * @param codigoOrigenCatVal the codigoOrigenCatVal to set
	 */
	public void setCodigoOrigenCatVal(String codigoOrigenCatVal) {
		this.codigoOrigenCatVal = codigoOrigenCatVal;
	}

	/**
	 * @return the codigosBarraValidados
	 */
	public String[] getCodigosBarraValidados() {
		return codigosBarraValidados;
	}

	/**
	 * @param codigosBarraValidados the codigosBarraValidados to set
	 */
	public void setCodigosBarraValidados(String[] codigosBarraValidados) {
		this.codigosBarraValidados = codigosBarraValidados;
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
	 * @return the codigosDetFactUnidadManejo
	 */
	public List<ArrayList<Long>> getCodigosDetFactUnidadManejo() {
		return codigosDetFactUnidadManejo;
	}

	/**
	 * @param codigosDetFactUnidadManejo the codigosDetFactUnidadManejo to set
	 */
	public void setCodigosDetFactUnidadManejo(List<ArrayList<Long>> codigosDetFactUnidadManejo) {
		this.codigosDetFactUnidadManejo = codigosDetFactUnidadManejo;
	}

	/**
	 * @return the codigoMoneda
	 */
	public Long getCodigoMoneda() {
		return codigoMoneda;
	}

	/**
	 * @param codigoMoneda the codigoMoneda to set
	 */
	public void setCodigoMoneda(Long codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	/**
	 * @return the valorCambioMoneda
	 */
	public Double getValorCambioMoneda() {
		return valorCambioMoneda;
	}

	/**
	 * @param valorCambioMoneda the valorCambioMoneda to set
	 */
	public void setValorCambioMoneda(Double valorCambioMoneda) {
		this.valorCambioMoneda = valorCambioMoneda;
	}

	/**
	 * @return the funcionarioTipoMarcaCol
	 */
	public Collection<InformacionFuncionarioTipoMarca> getFuncionarioTipoMarcaCol() {
		return funcionarioTipoMarcaCol;
	}

	/**
	 * @param funcionarioTipoMarcaCol the funcionarioTipoMarcaCol to set
	 */
	public void setFuncionarioTipoMarcaCol(Collection<InformacionFuncionarioTipoMarca> funcionarioTipoMarcaCol) {
		this.funcionarioTipoMarcaCol = funcionarioTipoMarcaCol;
	}

	/**
	 * @return the funcionarioLineaComercialCol
	 */
	public Collection<InformacionFuncionarioLineaComercial> getFuncionarioLineaComercialCol() {
		return funcionarioLineaComercialCol;
	}

	/**
	 * @param funcionarioLineaComercialCol the funcionarioLineaComercialCol to set
	 */
	public void setFuncionarioLineaComercialCol(Collection<InformacionFuncionarioLineaComercial> funcionarioLineaComercialCol) {
		this.funcionarioLineaComercialCol = funcionarioLineaComercialCol;
	}

	/**
	 * @return the adminOrdenCompraVOValidados
	 */
	public Collection<AdminOrdenCompraVO> getAdminOrdenCompraVOValidados() {
		return adminOrdenCompraVOValidados;
	}

	/**
	 * @param adminOrdenCompraVOValidados the adminOrdenCompraVOValidados to set
	 */
	public void setAdminOrdenCompraVOValidados(Collection<AdminOrdenCompraVO> adminOrdenCompraVOValidados) {
		this.adminOrdenCompraVOValidados = adminOrdenCompraVOValidados;
	}

	/**
	 * @return the codigosUnidadManejo
	 */
	public Long[] getCodigosUnidadManejo() {
		return codigosUnidadManejo;
	}

	/**
	 * @param codigosUnidadManejo the codigosUnidadManejo to set
	 */
	public void setCodigosUnidadManejo(Long[] codigosUnidadManejo) {
		this.codigosUnidadManejo = codigosUnidadManejo;
	}

	/**
	 * @return the facturaDetallesUnidadManejoValidados
	 */
	public ConcurrentHashMap<FacturaDetalleEstadoImpDTO, Long> getFacturaDetallesUnidadManejoValidados() {
		return facturaDetallesUnidadManejoValidados;
	}

	/**
	 * @param facturaDetallesUnidadManejoValidados the facturaDetallesUnidadManejoValidados to set
	 */
	public void setFacturaDetallesUnidadManejoValidados(ConcurrentHashMap<FacturaDetalleEstadoImpDTO, Long> facturaDetallesUnidadManejoValidados) {
		this.facturaDetallesUnidadManejoValidados = facturaDetallesUnidadManejoValidados;
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

	/**
	 * @return the accessItemId
	 */
	public String getAccessItemId() {
		return accessItemId;
	}

	/**
	 * @param accessItemId the accessItemId to set
	 */
	public void setAccessItemId(String accessItemId) {
		this.accessItemId = accessItemId;
	}

	/**
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}

	/**
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public HashSet<String> getCodigosLineaComercial() {
		return codigosLineaComercial;
	}

	public void setCodigosLineaComercial(HashSet<String> codigosLineaComercial) {
		this.codigosLineaComercial = codigosLineaComercial;
	}
}
