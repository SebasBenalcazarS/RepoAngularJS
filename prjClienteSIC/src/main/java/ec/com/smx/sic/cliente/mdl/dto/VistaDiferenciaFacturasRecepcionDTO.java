package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaDiferenciaFacturasRecepcionID;

@Entity
@SuppressWarnings("serial")
public class VistaDiferenciaFacturasRecepcionDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private VistaDiferenciaFacturasRecepcionID id = new VistaDiferenciaFacturasRecepcionID();
	
	//Datos del articulo
	private String codigoArticulo;
	private Long codigoUnidadManejo;
	private String valorTipoEstadoOrdenCompra;
	private Integer codigoTipoEstadoOrdenCompra;
	private Integer codigoTipoControlCosto;
	
	//Datos pantalla
	private String codigoBarras;
	private String descripcionArticulo;
	private String referenciaMedida;
	private String tipoUnidadEmpaque;
	private Integer valorUnidadManejo;
	
	private Integer cantidadPedida;
	@Transient
	private Integer cantidadPedidaAgrupada = 0;
	
	private BigDecimal pesoPedido = new BigDecimal(0);
	@Transient
	private BigDecimal pesoPedidoAgrupado = new BigDecimal(0);
	
	private Integer cantidadFacturada;
	@Transient
	private Integer cantidadFacturadaAgrupada = 0;
	
	private BigDecimal pesoPlanificado;
	@Transient
	private BigDecimal pesoPlanificadoAgrupado = new BigDecimal(0);
	
	private Integer cantidadEntregada;
	@Transient
	private Integer cantidadEntregadaAgrupada = 0;

	private BigDecimal pesoEntregado;
	@Transient
	private BigDecimal pesoEntregadoAgrupado = new BigDecimal(0);
	
	private Integer cantidadAnterior;
	@Transient
	private Integer cantidadAnteriorAgrupada = 0;
	
	private BigDecimal pesoAnterior;
	@Transient
	private BigDecimal pesoAnteriorAgrupado = new BigDecimal(0);
	
	//Diferencias
	@Transient
	private Integer diferenciaCantidad = 0;
	@Transient
	private BigDecimal diferenciaPeso = new BigDecimal(0);
	
	//Novedades 
	@Transient
	private Long codigoJustificacion;
	@Transient
	private String nombreJustificacion;
	@Transient
	private String codigoPerfil;
	@Transient
	private String usuarioRecepcion;
	@Transient
	private String justificacionRecibidor;
	@Transient
	private String usuarioOficina;
	@Transient
	private String codigoUsuarioOficina;
	@Transient
	private Integer cantidadJustificada = 0;
	@Transient
	private Collection<VistaNovedadRecepcionArticuloDTO> vistaNovedadRecepcionArticuloCol;
	@Transient
	private Collection<VistaNovedadRecepcionArticuloDTO> novedadesOficina;
	@Transient
	private Boolean justificacionRegistrada = Boolean.FALSE;
	@Transient
	private Integer novedadOficina;
	
	/**
	 * @return the id
	 */
	public VistaDiferenciaFacturasRecepcionID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(VistaDiferenciaFacturasRecepcionID id) {
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
	 * @return the cantidadPedida
	 */
	public Integer getCantidadPedida() {
		return cantidadPedida;
	}
	/**
	 * @param cantidadPedida the cantidadPedida to set
	 */
	public void setCantidadPedida(Integer cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}
	/**
	 * @return the cantidadPedidaAgrupada
	 */
	public Integer getCantidadPedidaAgrupada() {
		return cantidadPedidaAgrupada;
	}
	/**
	 * @param cantidadPedidaAgrupada the cantidadPedidaAgrupada to set
	 */
	public void setCantidadPedidaAgrupada(Integer cantidadPedidaAgrupada) {
		this.cantidadPedidaAgrupada = cantidadPedidaAgrupada;
	}
	/**
	 * @return the pesoPedido
	 */
	public BigDecimal getPesoPedido() {
		return pesoPedido;
	}
	/**
	 * @param pesoPedido the pesoPedido to set
	 */
	public void setPesoPedido(BigDecimal pesoPedido) {
		this.pesoPedido = pesoPedido;
	}
	/**
	 * @return the pesoPedidoAgrupado
	 */
	public BigDecimal getPesoPedidoAgrupado() {
		return pesoPedidoAgrupado;
	}
	/**
	 * @param pesoPedidoAgrupado the pesoPedidoAgrupado to set
	 */
	public void setPesoPedidoAgrupado(BigDecimal pesoPedidoAgrupado) {
		this.pesoPedidoAgrupado = pesoPedidoAgrupado;
	}
	/**
	 * @return the cantidadFacturada
	 */
	public Integer getCantidadFacturada() {
		return cantidadFacturada;
	}
	/**
	 * @param cantidadFacturada the cantidadFacturada to set
	 */
	public void setCantidadFacturada(Integer cantidadFacturada) {
		this.cantidadFacturada = cantidadFacturada;
	}
	/**
	 * @return the cantidadFacturadaAgrupada
	 */
	public Integer getCantidadFacturadaAgrupada() {
		return cantidadFacturadaAgrupada;
	}
	/**
	 * @param cantidadFacturadaAgrupada the cantidadFacturadaAgrupada to set
	 */
	public void setCantidadFacturadaAgrupada(Integer cantidadFacturadaAgrupada) {
		this.cantidadFacturadaAgrupada = cantidadFacturadaAgrupada;
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
	 * @return the diferenciaCantidad
	 */
	public Integer getDiferenciaCantidad() {
		return diferenciaCantidad;
	}
	/**
	 * @param diferenciaCantidad the diferenciaCantidad to set
	 */
	public void setDiferenciaCantidad(Integer diferenciaCantidad) {
		this.diferenciaCantidad = diferenciaCantidad;
	}
	/**
	 * @return the diferenciaPeso
	 */
	public BigDecimal getDiferenciaPeso() {
		return diferenciaPeso;
	}
	/**
	 * @param diferenciaPeso the diferenciaPeso to set
	 */
	public void setDiferenciaPeso(BigDecimal diferenciaPeso) {
		this.diferenciaPeso = diferenciaPeso;
	}
	/**
	 * @return the codigoJustificacion
	 */
	public Long getCodigoJustificacion() {
		return codigoJustificacion;
	}
	/**
	 * @param codigoJustificacion the codigoJustificacion to set
	 */
	public void setCodigoJustificacion(Long codigoJustificacion) {
		this.codigoJustificacion = codigoJustificacion;
	}
	/**
	 * @return the nombreJustificacion
	 */
	public String getNombreJustificacion() {
		return nombreJustificacion;
	}
	/**
	 * @param nombreJustificacion the nombreJustificacion to set
	 */
	public void setNombreJustificacion(String nombreJustificacion) {
		this.nombreJustificacion = nombreJustificacion;
	}
	/**
	 * @return the codigoPerfil
	 */
	public String getCodigoPerfil() {
		return codigoPerfil;
	}
	/**
	 * @param codigoPerfil the codigoPerfil to set
	 */
	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	/**
	 * @return the usuarioRecepcion
	 */
	public String getUsuarioRecepcion() {
		return usuarioRecepcion;
	}
	/**
	 * @param usuarioRecepcion the usuarioRecepcion to set
	 */
	public void setUsuarioRecepcion(String usuarioRecepcion) {
		this.usuarioRecepcion = usuarioRecepcion;
	}
	/**
	 * @return the justificacionRecibidor
	 */
	public String getJustificacionRecibidor() {
		return justificacionRecibidor;
	}
	/**
	 * @param justificacionRecibidor the justificacionRecibidor to set
	 */
	public void setJustificacionRecibidor(String justificacionRecibidor) {
		this.justificacionRecibidor = justificacionRecibidor;
	}
	/**
	 * @return the usuarioOficina
	 */
	public String getUsuarioOficina() {
		return usuarioOficina;
	}
	/**
	 * @param usuarioOficina the usuarioOficina to set
	 */
	public void setUsuarioOficina(String usuarioOficina) {
		this.usuarioOficina = usuarioOficina;
	}
	/**
	 * @return the codigoUsuarioOficina
	 */
	public String getCodigoUsuarioOficina() {
		return codigoUsuarioOficina;
	}
	/**
	 * @param codigoUsuarioOficina the codigoUsuarioOficina to set
	 */
	public void setCodigoUsuarioOficina(String codigoUsuarioOficina) {
		this.codigoUsuarioOficina = codigoUsuarioOficina;
	}
	/**
	 * @return the cantidadJustificada
	 */
	public Integer getCantidadJustificada() {
		return cantidadJustificada;
	}
	/**
	 * @param cantidadJustificada the cantidadJustificada to set
	 */
	public void setCantidadJustificada(Integer cantidadJustificada) {
		this.cantidadJustificada = cantidadJustificada;
	}
	/**
	 * @return the vistaNovedadRecepcionArticuloCol
	 */
	public Collection<VistaNovedadRecepcionArticuloDTO> getVistaNovedadRecepcionArticuloCol() {
		return vistaNovedadRecepcionArticuloCol;
	}
	/**
	 * @param vistaNovedadRecepcionArticuloCol the vistaNovedadRecepcionArticuloCol to set
	 */
	public void setVistaNovedadRecepcionArticuloCol(Collection<VistaNovedadRecepcionArticuloDTO> vistaNovedadRecepcionArticuloCol) {
		this.vistaNovedadRecepcionArticuloCol = vistaNovedadRecepcionArticuloCol;
	}
	/**
	 * @return the justificacionRegistrada
	 */
	public Boolean getJustificacionRegistrada() {
		return justificacionRegistrada;
	}
	/**
	 * @param justificacionRegistrada the justificacionRegistrada to set
	 */
	public void setJustificacionRegistrada(Boolean justificacionRegistrada) {
		this.justificacionRegistrada = justificacionRegistrada;
	}
	/**
	 * @return the novedadOficina
	 */
	public Integer getNovedadOficina() {
		return novedadOficina;
	}
	/**
	 * @param novedadOficina the novedadOficina to set
	 */
	public void setNovedadOficina(Integer novedadOficina) {
		this.novedadOficina = novedadOficina;
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
	 * @return the valorTipoEstadoOrdenCompra
	 */
	public String getValorTipoEstadoOrdenCompra() {
		return valorTipoEstadoOrdenCompra;
	}
	/**
	 * @param valorTipoEstadoOrdenCompra the valorTipoEstadoOrdenCompra to set
	 */
	public void setValorTipoEstadoOrdenCompra(String valorTipoEstadoOrdenCompra) {
		this.valorTipoEstadoOrdenCompra = valorTipoEstadoOrdenCompra;
	}
	/**
	 * @return the codigoTipoEstadoOrdenCompra
	 */
	public Integer getCodigoTipoEstadoOrdenCompra() {
		return codigoTipoEstadoOrdenCompra;
	}
	/**
	 * @param codigoTipoEstadoOrdenCompra the codigoTipoEstadoOrdenCompra to set
	 */
	public void setCodigoTipoEstadoOrdenCompra(Integer codigoTipoEstadoOrdenCompra) {
		this.codigoTipoEstadoOrdenCompra = codigoTipoEstadoOrdenCompra;
	}
	/**
	 * @return the codigoTipoControlCosto
	 */
	public Integer getCodigoTipoControlCosto() {
		return codigoTipoControlCosto;
	}
	/**
	 * @param codigoTipoControlCosto the codigoTipoControlCosto to set
	 */
	public void setCodigoTipoControlCosto(Integer codigoTipoControlCosto) {
		this.codigoTipoControlCosto = codigoTipoControlCosto;
	}
	/**
	 * @return the novedadesOficina
	 */
	public Collection<VistaNovedadRecepcionArticuloDTO> getNovedadesOficina() {
		return novedadesOficina;
	}
	/**
	 * @param novedadesOficina the novedadesOficina to set
	 */
	public void setNovedadesOficina(Collection<VistaNovedadRecepcionArticuloDTO> novedadesOficina) {
		this.novedadesOficina = novedadesOficina;
	}
	/**
	 * 
	 * @return the cantidadAnterior
	 */
	public Integer getCantidadAnterior() {
		return cantidadAnterior;
	}
	/**
	 * 
	 * @param cantidadAnterior the cantidadAnterior to set
	 */
	public void setCantidadAnterior(Integer cantidadAnterior) {
		this.cantidadAnterior = cantidadAnterior;
	}
	/**
	 * 
	 * @return the cantidadAnteriorAgrupada
	 */
	public Integer getCantidadAnteriorAgrupada() {
		return cantidadAnteriorAgrupada;
	}
	/**
	 * 
	 * @param cantidadAnteriorAgrupada the cantidadAnteriorAgrupada to set
	 */
	public void setCantidadAnteriorAgrupada(Integer cantidadAnteriorAgrupada) {
		this.cantidadAnteriorAgrupada = cantidadAnteriorAgrupada;
	}
	/**
	 * 
	 * @return the pesoAnterior
	 */
	public BigDecimal getPesoAnterior() {
		return pesoAnterior;
	}
	/**
	 * 
	 * @param pesoAnterior the pesoAnterior to set
	 */
	public void setPesoAnterior(BigDecimal pesoAnterior) {
		this.pesoAnterior = pesoAnterior;
	}
	/**
	 * 
	 * @return the pesoAnteriorAgrupado
	 */
	public BigDecimal getPesoAnteriorAgrupado() {
		return pesoAnteriorAgrupado;
	}
	/**
	 * 
	 * @param pesoAnteriorAgrupado the pesoAnteriorAgrupado to set
	 */
	public void setPesoAnteriorAgrupado(BigDecimal pesoAnteriorAgrupado) {
		this.pesoAnteriorAgrupado = pesoAnteriorAgrupado;
	}
	
}
