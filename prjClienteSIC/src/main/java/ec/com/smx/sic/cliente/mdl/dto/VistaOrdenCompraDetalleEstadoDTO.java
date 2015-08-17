package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaOrdenCompraDetalleEstadoID;

@Entity
public class VistaOrdenCompraDetalleEstadoDTO {
	
	@EmbeddedId
	private VistaOrdenCompraDetalleEstadoID id = new VistaOrdenCompraDetalleEstadoID();
	
	private String codigoBarras;
	private String descripcionArticulo;
	private String referenciaMedida;
	private String tipoUnidadEmpaque;
	private Integer valorUnidadManejo; 
	
	private Integer cantidadEnviada;
	private Integer cantidadPlanificada;
	
	@Transient
	private Integer cantidadEntregada;
	private Integer cantidadEntregadaAnterior;
	
	private BigDecimal pesoEnviado;
	private BigDecimal pesoPlanificado;
	@Transient
    private BigDecimal pesoEntregado;
    
    private String cantidadPesoEntregadoPallet;
    
    @Transient
    private Integer cantidadPallet;
	
	private Boolean articuloPedido;
    private String codigoArticulo;
    private Long codigoUnidadManejo;
    private Long codigoOrdenCompraEstadoPadre;
    private String estadoOrdenCompra;
    private BigDecimal costoNeto;
    private BigDecimal costoBruto;
	private String valorTipoControlCosto;
	
	private Double porcentajeExesoRecepcion;
	private Boolean autorizarCambioCostoRecepcion;
	
	@Transient
	private Integer cantidadEnviadaAgrupada = 0;
	@Transient
	private Integer cantidadPlanificadaAgrupada = 0;
	@Transient
	private Integer cantidadEntregadaAgrupada = 0;
	@Transient
	private Integer cantidadEntregadaAnteriorAgrupada = 0;
	@Transient
	private Integer cantidadPendiente = 0;
	@Transient
	private Boolean seleccionado = Boolean.FALSE;
	
	@Transient
    private BigDecimal pesoEnviadoAgrupado = BigDecimal.ZERO;
	@Transient
	private BigDecimal pesoPlanificadoAgrupado = BigDecimal.ZERO;
	@Transient
	private BigDecimal pesoEntregadoAgrupado = BigDecimal.ZERO;
	@Transient
	private String colorRecepcionArticulo;
	@Transient
	private BigDecimal pesoPendiente = BigDecimal.ZERO;

	
	
	
	/**
	 * Peso que se a entregado en del articulo en todas las recepciones
	 */
	private BigDecimal pesoEntregadoRecepcion;

	/**
	 * @return the id
	 */
	public VistaOrdenCompraDetalleEstadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaOrdenCompraDetalleEstadoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}

	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	/**
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	/**
	 * @return the referenciaMedida
	 */
	public String getReferenciaMedida() {
		return referenciaMedida;
	}

	/**
	 * @param referenciaMedida the referenciaMedida to set
	 */
	public void setReferenciaMedida(String referenciaMedida) {
		this.referenciaMedida = referenciaMedida;
	}

	/**
	 * @return the tipoUnidadEmpaque
	 */
	public String getTipoUnidadEmpaque() {
		return tipoUnidadEmpaque;
	}

	/**
	 * @param tipoUnidadEmpaque the tipoUnidadEmpaque to set
	 */
	public void setTipoUnidadEmpaque(String tipoUnidadEmpaque) {
		this.tipoUnidadEmpaque = tipoUnidadEmpaque;
	}

	/**
	 * @return the cantidadEnviada
	 */
	public Integer getCantidadEnviada() {
		return cantidadEnviada;
	}

	/**
	 * @param cantidadEnviada the cantidadEnviada to set
	 */
	public void setCantidadEnviada(Integer cantidadEnviada) {
		this.cantidadEnviada = cantidadEnviada;
	}

	/**
	 * @return the cantidadPlanificada
	 */
	public Integer getCantidadPlanificada() {
		return cantidadPlanificada;
	}

	/**
	 * @param cantidadPlanificada the cantidadPlanificada to set
	 */
	public void setCantidadPlanificada(Integer cantidadPlanificada) {
		this.cantidadPlanificada = cantidadPlanificada;
	}

	/**
	 * @return the cantidadEntregada
	 */
	public Integer getCantidadEntregada() {
		return cantidadEntregada;
	}

	/**
	 * @param cantidadEntregada the cantidadEntregada to set
	 */
	public void setCantidadEntregada(Integer cantidadEntregada) {
		this.cantidadEntregada = cantidadEntregada;
	}

	/**
	 * @return the articuloPedido
	 */
	public Boolean getArticuloPedido() {
		return articuloPedido;
	}

	/**
	 * @param articuloPedido the articuloPedido to set
	 */
	public void setArticuloPedido(Boolean articuloPedido) {
		this.articuloPedido = articuloPedido;
	}

	/**
	 * @return the cantidadEnviadaAgrupada
	 */
	public Integer getCantidadEnviadaAgrupada() {
		return cantidadEnviadaAgrupada;
	}

	/**
	 * @param cantidadEnviadaAgrupada the cantidadEnviadaAgrupada to set
	 */
	public void setCantidadEnviadaAgrupada(Integer cantidadEnviadaAgrupada) {
		this.cantidadEnviadaAgrupada = cantidadEnviadaAgrupada;
	}

	/**
	 * @return the cantidadPlanificadaAgrupada
	 */
	public Integer getCantidadPlanificadaAgrupada() {
		return cantidadPlanificadaAgrupada;
	}

	/**
	 * @param cantidadPlanificadaAgrupada the cantidadPlanificadaAgrupada to set
	 */
	public void setCantidadPlanificadaAgrupada(Integer cantidadPlanificadaAgrupada) {
		this.cantidadPlanificadaAgrupada = cantidadPlanificadaAgrupada;
	}

	/**
	 * @return the cantidadEntregadaAgrupada
	 */
	public Integer getCantidadEntregadaAgrupada() {
		return cantidadEntregadaAgrupada;
	}

	/**
	 * @param cantidadEntregadaAgrupada the cantidadEntregadaAgrupada to set
	 */
	public void setCantidadEntregadaAgrupada(Integer cantidadEntregadaAgrupada) {
		this.cantidadEntregadaAgrupada = cantidadEntregadaAgrupada;
	}

	/**
	 * @return the valorUnidadManejo
	 */
	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}

	/**
	 * @param valorUnidadManejo the valorUnidadManejo to set
	 */
	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}
	
	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	/**
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}
	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	/**
	 * @return the codigoOrdenCompraEstadoPadre
	 */
	public Long getCodigoOrdenCompraEstadoPadre() {
		return codigoOrdenCompraEstadoPadre;
	}

	/**
	 * @param codigoOrdenCompraEstadoPadre the codigoOrdenCompraEstadoPadre to set
	 */
	public void setCodigoOrdenCompraEstadoPadre(Long codigoOrdenCompraEstadoPadre) {
		this.codigoOrdenCompraEstadoPadre = codigoOrdenCompraEstadoPadre;
	}

	/**
	 * @return the estadoOrdenCompra
	 */
	public String getEstadoOrdenCompra() {
		return estadoOrdenCompra;
	}

	/**
	 * @param estadoOrdenCompra the estadoOrdenCompra to set
	 */
	public void setEstadoOrdenCompra(String estadoOrdenCompra) {
		this.estadoOrdenCompra = estadoOrdenCompra;
	}

	/**
	 * @return the pesoEntregado
	 */
	public BigDecimal getPesoEntregado() {
		return pesoEntregado;
	}

	/**
	 * @param pesoEntregado the pesoEntregado to set
	 */
	public void setPesoEntregado(BigDecimal pesoEntregado) {
		this.pesoEntregado = pesoEntregado;
	}

	/**
	 * @return the pesoEntregadoAgrupado
	 */
	public BigDecimal getPesoEntregadoAgrupado() {
		return pesoEntregadoAgrupado;
	}

	/**
	 * @param pesoEntregadoAgrupado the pesoEntregadoAgrupado to set
	 */
	public void setPesoEntregadoAgrupado(BigDecimal pesoEntregadoAgrupado) {
		this.pesoEntregadoAgrupado = pesoEntregadoAgrupado;
	}

	/**
	 * @return the pesoEnviado
	 */
	public BigDecimal getPesoEnviado() {
		return pesoEnviado;
	}

	/**
	 * @param pesoEnviado the pesoEnviado to set
	 */
	public void setPesoEnviado(BigDecimal pesoEnviado) {
		this.pesoEnviado = pesoEnviado;
	}

	/**
	 * @return the pesoPlanificado
	 */
	public BigDecimal getPesoPlanificado() {
		return pesoPlanificado;
	}

	/**
	 * @param pesoPlanificado the pesoPlanificado to set
	 */
	public void setPesoPlanificado(BigDecimal pesoPlanificado) {
		this.pesoPlanificado = pesoPlanificado;
	}

	/**
	 * @return the pesoEnviadoAgrupado
	 */
	public BigDecimal getPesoEnviadoAgrupado() {
		return pesoEnviadoAgrupado;
	}

	/**
	 * @param pesoEnviadoAgrupado the pesoEnviadoAgrupado to set
	 */
	public void setPesoEnviadoAgrupado(BigDecimal pesoEnviadoAgrupado) {
		this.pesoEnviadoAgrupado = pesoEnviadoAgrupado;
	}

	/**
	 * @return the pesoPlanificadoAgrupado
	 */
	public BigDecimal getPesoPlanificadoAgrupado() {
		return pesoPlanificadoAgrupado;
	}

	/**
	 * @param pesoPlanificadoAgrupado the pesoPlanificadoAgrupado to set
	 */
	public void setPesoPlanificadoAgrupado(BigDecimal pesoPlanificadoAgrupado) {
		this.pesoPlanificadoAgrupado = pesoPlanificadoAgrupado;
	}

	/**
	 * @return the costoNeto
	 */
	public BigDecimal getCostoNeto() {
		return costoNeto;
	}

	/**
	 * @param costoNeto the costoNeto to set
	 */
	public void setCostoNeto(BigDecimal costoNeto) {
		this.costoNeto = costoNeto;
	}

	/**
	 * @return the seleccionado
	 */
	public Boolean getSeleccionado() {
		return seleccionado;
	}

	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	/**
	 * @return the valorTipoControlCosto
	 */
	public String getValorTipoControlCosto() {
		return valorTipoControlCosto;
	}

	/**
	 * @param valorTipoControlCosto the valorTipoControlCosto to set
	 */
	public void setValorTipoControlCosto(String valorTipoControlCosto) {
		this.valorTipoControlCosto = valorTipoControlCosto;
	}
	
	/**
	 * @return the porcentajeExesoRecepcion
	 */
	public Double getPorcentajeExesoRecepcion() {
		return porcentajeExesoRecepcion;
	}

	/**
	 * @param porcentajeExesoRecepcion the porcentajeExesoRecepcion to set
	 */
	public void setPorcentajeExesoRecepcion(Double porcentajeExesoRecepcion) {
		this.porcentajeExesoRecepcion = porcentajeExesoRecepcion;
	}
	
	/**
	 * @return the colorRecepcionArticulo
	 */
	public String getColorRecepcionArticulo() {
		return colorRecepcionArticulo;
	}
	/**
	 * @param colorRecepcionArticulo the colorRecepcionArticulo to set
	 */
	public void setColorRecepcionArticulo(String colorRecepcionArticulo) {
		this.colorRecepcionArticulo = colorRecepcionArticulo;
	}
	
	/**
	 * @return the cantidadPesoEntregadoPallet
	 */
	public String getCantidadPesoEntregadoPallet() {
		return cantidadPesoEntregadoPallet;
	}

	/**
	 * @param cantidadPesoEntregadoPallet the cantidadPesoEntregadoPallet to set
	 */
	public void setCantidadPesoEntregadoPallet(String cantidadPesoEntregadoPallet) {
		this.cantidadPesoEntregadoPallet = cantidadPesoEntregadoPallet;
	}

	/**
	 * @return the pesoEntregadoRecepcion
	 */
	public BigDecimal getPesoEntregadoRecepcion() {
		return pesoEntregadoRecepcion;
	}

	/**
	 * @param pesoEntregadoRecepcion the pesoEntregadoRecepcion to set
	 */
	public void setPesoEntregadoRecepcion(BigDecimal pesoEntregadoRecepcion) {
		this.pesoEntregadoRecepcion = pesoEntregadoRecepcion;
	}
	
	/**
	 * Obtiene la cantidad pendiente de recibir (de todos los procesos logistico) cuando el tipo de control de contros es 3 peso - peso
	 * @return
	 */
	public BigDecimal getCantidadPesoPendienteRecibir () {
		
		if (this.valorTipoControlCosto == null || this.pesoEnviadoAgrupado == null || this.pesoEntregadoRecepcion == null) {
			
			return BigDecimal.ZERO;
			
		} else {
			
			if (this.valorTipoControlCosto.equals(SICArticuloConstantes.TIPCONCOS_PESPES)
					|| this.valorTipoControlCosto.equals(SICArticuloConstantes.TIPCONCOS_PIEPES)) {
				return this.pesoEnviadoAgrupado.subtract(this.pesoEntregadoRecepcion);
			} else {
				return BigDecimal.ZERO;
			}
			
		}
		
	}
	
	/**
	 * Peso que se ha entregado en la recepcion actual
	 * @return
	 */
	public BigDecimal getCantidadPesoEntregadoAgrupado () {
		
		if (this.valorTipoControlCosto == null || this.cantidadEntregadaAgrupada == null || this.pesoEntregadoAgrupado == null) {
			
			return BigDecimal.ZERO;
			
		} else {
			
			if (this.valorTipoControlCosto.equals(SICArticuloConstantes.TIPCONCOS_PESPES)) {
				return this.pesoEntregadoAgrupado;
			} else {
				return  BigDecimal.valueOf(this.cantidadEntregadaAgrupada);
			}
			
		}
		
	}
	
	public String getCodigoArticuloUnidadManejo () {
		return new StringBuilder().append(this.codigoArticulo).append('-').append(this.codigoUnidadManejo).toString();
	}

	/**
	 * @return the costoBruto
	 */
	public BigDecimal getCostoBruto() {
		return costoBruto;
	}

	/**
	 * @param costoBruto the costoBruto to set
	 */
	public void setCostoBruto(BigDecimal costoBruto) {
		this.costoBruto = costoBruto;
	}

	/**
	 * @return the autorizarCambioCostoRecepcion
	 */
	public Boolean getAutorizarCambioCostoRecepcion() {
		return autorizarCambioCostoRecepcion;
	}

	/**
	 * @param autorizarCambioCostoRecepcion the autorizarCambioCostoRecepcion to set
	 */
	public void setAutorizarCambioCostoRecepcion(Boolean autorizarCambioCostoRecepcion) {
		this.autorizarCambioCostoRecepcion = autorizarCambioCostoRecepcion;
	}

	/**
	 * @return the cantidadEntregadaAnterior
	 */
	public Integer getCantidadEntregadaAnterior() {
		return cantidadEntregadaAnterior;
	}

	/**
	 * @param cantidadEntregadaAnterior the cantidadEntregadaAnterior to set
	 */
	public void setCantidadEntregadaAnterior(Integer cantidadEntregadaAnterior) {
		this.cantidadEntregadaAnterior = cantidadEntregadaAnterior;
	}

	/**
	 * @return the cantidadPendiente
	 */
	public Integer getCantidadPendiente() {
		return cantidadPendiente;
	}

	/**
	 * @param cantidadPendiente the cantidadPendiente to set
	 */
	public void setCantidadPendiente(Integer cantidadPendiente) {
		this.cantidadPendiente = cantidadPendiente;
	}

	/**
	 * @return the pesoPendiente
	 */
	public BigDecimal getPesoPendiente() {
		return pesoPendiente;
	}

	/**
	 * @param pesoPendiente the pesoPendiente to set
	 */
	public void setPesoPendiente(BigDecimal pesoPendiente) {
		this.pesoPendiente = pesoPendiente;
	}

	/**
	 * @return the cantidadPallet
	 */
	public Integer getCantidadPallet() {
		return cantidadPallet;
	}

	/**
	 * @param cantidadPallet the cantidadPallet to set
	 */
	public void setCantidadPallet(Integer cantidadPallet) {
		this.cantidadPallet = cantidadPallet;
	}

	/**
	 * @return the cantidadEntregadaAnteriorAgrupada
	 */
	public Integer getCantidadEntregadaAnteriorAgrupada() {
		return cantidadEntregadaAnteriorAgrupada;
	}

	/**
	 * @param cantidadEntregadaAnteriorAgrupada the cantidadEntregadaAnteriorAgrupada to set
	 */
	public void setCantidadEntregadaAnteriorAgrupada(Integer cantidadEntregadaAnteriorAgrupada) {
		this.cantidadEntregadaAnteriorAgrupada = cantidadEntregadaAnteriorAgrupada;
	}

}
