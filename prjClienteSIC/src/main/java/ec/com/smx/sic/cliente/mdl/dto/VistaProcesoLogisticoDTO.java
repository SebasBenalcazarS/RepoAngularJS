package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaProcesoLogisticoID;

@SuppressWarnings("serial")
public class VistaProcesoLogisticoDTO extends SimpleAuditDTO {
	@EmbeddedId
	private VistaProcesoLogisticoID id = new VistaProcesoLogisticoID();
	
	private Long codigoTarea;
	
	private String codigoJDE;
	private String nombreProveedor;
	private String nombreUsuarioRecibidor;
	private Integer codigoTipoRecepcion;
	private String tipoRecepcion;
	private String estadoProcesoLogistico;
	private Date fechaRegistroProceso;
	private Date fechaAsignacionTarea;
	private Date fechaRecepcion;
	private Integer codigoAreaTrabajoCD;
	private Integer codigoAreaTrabajoEntrega;
	private Date fechaInicioTarea;
	private Date fechaFinTarea;
	private Integer cantidadAndenesUtilizados;
	private String primerAndenSeleccionado;
	private Integer cantidadPaletsRecibidos;
	private Integer cantidadTotalPedida;
	private Integer cantidadTotalPlanificada;
	private Integer cantidadTotalBultosRecibidos;
	private Integer cantidadTotalBultosPlanificados;
	private Integer cantidadTotalItems;
	private Integer cantidadFacturas;
	private String numeroDocumentoProveedor;
	private String valorTipoDocumento;
	private String estadoProcesoLogisticoDescripcion;
	private String tipoRecepcionDescripcion;
	
	@Transient
	private Long cantidadBultos;
	@Transient
	private String idUsuarioRegistro;
	
	private String nombreCD;
	private String nombreBodega;
	private String nombreSubBodega;
	
	private Integer codigoReferenciaCD;
	private Integer codigoReferenciaBodega;
	private Integer codigoReferenciaSubBodega;
	
	private String codigoFuncionarioRecibidor;
	private String userCompleteNameRecibidor;
	
	/// Se pone @Transient porque ya no se hace join con la tabla de usuario ///
	@Transient
	private String userId;
	///////////////////////////////////////////////////////////////////////////
	
	@Transient
	private Integer porcentajeRecepcion;
	@Transient
	private Boolean seleccionado;
//	@Transient
//	private Boolean editarProcesoLogistico = Boolean.FALSE;
//	@Transient
//	private Boolean eliminarProcesoLogistico = Boolean.FALSE;
//	@Transient
//	private Boolean iniciarRecepcionPausada = Boolean.FALSE;
	
	/*
	 * Inicio campos para la optimizacion de consultas en el proceso de recepcion de bodega
	 * */
	private Date fechaRegistroProcesoLogistico;
	
	private Long secuencialRecepcionProveedor;
	
	private Long secuencialProcesoLogistico;
	
	private BigDecimal totalPesoRecibido;
	
	private BigDecimal totalPesoPlanificado;
	
	private BigDecimal totalPesoPlanificadoB2B;
	
	private BigDecimal totalPesoPedido;
	
	private Boolean ingresoManual;
	
	//Campo utilizado para diferenciar agrupaciones en PL para el registro de novedades
	@Transient
	private Long codigoGrupoNovedadArticulo;
	@Transient
	private String codigoPerfil;
	
	private Long tiempoEstimadoRecepcion;
	
	@Transient
	private Integer codigoAreaTrabajoSubBodega;
//	@OneToMany(mappedBy="vistaProcesoLogisticoDTO")
//	@MapKey(name="codigoCatalogoValorRelacionado")
//	private Map<String, TareaEstadoDTO> mapTareaEstado;
	
	/*
	 * Fin campos para la optimizacion de consultas en el proceso de recepcion de bodega
	 * */
	
	public VistaProcesoLogisticoID getId() {
		return id;
	}
	public void setId(VistaProcesoLogisticoID id) {
		this.id = id;
	}
	public String getCodigoJDE() {
		return codigoJDE;
	}
	public void setCodigoJDE(String codigoJDE) {
		this.codigoJDE = codigoJDE;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getNombreUsuarioRecibidor() {
		return nombreUsuarioRecibidor;
	}
	public void setNombreUsuarioRecibidor(String nombreUsuarioRecibidor) {
		this.nombreUsuarioRecibidor = nombreUsuarioRecibidor;
	}
	public Integer getCodigoTipoRecepcion() {
		return codigoTipoRecepcion;
	}
	public void setCodigoTipoRecepcion(Integer codigoTipoRecepcion) {
		this.codigoTipoRecepcion = codigoTipoRecepcion;
	}
	public String getTipoRecepcion() {
		return tipoRecepcion;
	}
	public void setTipoRecepcion(String tipoRecepcion) {
		this.tipoRecepcion = tipoRecepcion;
	}
	public String getEstadoProcesoLogistico() {
		return estadoProcesoLogistico;
	}
	public void setEstadoProcesoLogistico(String estadoProcesoLogistico) {
		this.estadoProcesoLogistico = estadoProcesoLogistico;
	}
	public Date getFechaRegistroProceso() {
		return fechaRegistroProceso;
	}
	public void setFechaRegistroProceso(Date fechaRegistroProceso) {
		this.fechaRegistroProceso = fechaRegistroProceso;
	}
	public Date getFechaAsignacionTarea() {
		return fechaAsignacionTarea;
	}
	public void setFechaAsignacionTarea(Date fechaAsignacionTarea) {
		this.fechaAsignacionTarea = fechaAsignacionTarea;
	}
	public Integer getCodigoAreaTrabajoEntrega() {
		return codigoAreaTrabajoEntrega;
	}
	public void setCodigoAreaTrabajoEntrega(Integer codigoAreaTrabajoEntrega) {
		this.codigoAreaTrabajoEntrega = codigoAreaTrabajoEntrega;
	}
	public Date getFechaInicioTarea() {
		return fechaInicioTarea;
	}
	public void setFechaInicioTarea(Date fechaInicioTarea) {
		this.fechaInicioTarea = fechaInicioTarea;
	}
	public Date getFechaFinTarea() {
		return fechaFinTarea;
	}
	public void setFechaFinTarea(Date fechaFinTarea) {
		this.fechaFinTarea = fechaFinTarea;
	}
	public Integer getCantidadAndenesUtilizados() {
		return cantidadAndenesUtilizados  == null ? 0 : cantidadAndenesUtilizados;
	}
	public void setCantidadAndenesUtilizados(Integer cantidadAndenesUtilizados) {
		this.cantidadAndenesUtilizados = cantidadAndenesUtilizados;
	}
	public Integer getCantidadPaletsRecibidos() {
		return cantidadPaletsRecibidos == null ? 0 : cantidadPaletsRecibidos;
	}
	public void setCantidadPaletsRecibidos(Integer cantidadPaletsRecibidos) {
		this.cantidadPaletsRecibidos = cantidadPaletsRecibidos;
	}
	public Integer getCantidadTotalBultosRecibidos() {
		return cantidadTotalBultosRecibidos == null ? 0 : cantidadTotalBultosRecibidos;
	}
	public void setCantidadTotalBultosRecibidos(Integer cantidadTotalBultosRecibidos) {
		this.cantidadTotalBultosRecibidos = cantidadTotalBultosRecibidos;
	}
	public Integer getCantidadTotalBultosPlanificados() {
		return cantidadTotalBultosPlanificados == null ? 0 : cantidadTotalBultosPlanificados;
	}
	public void setCantidadTotalBultosPlanificados(Integer cantidadTotalBultosPlanificados) {
		this.cantidadTotalBultosPlanificados = cantidadTotalBultosPlanificados;
	}
	public Integer getCantidadTotalItems() {
		return cantidadTotalItems == null ? 0 : cantidadTotalItems;
	}
	public void setCantidadTotalItems(Integer cantidadTotalItems) {
		this.cantidadTotalItems = cantidadTotalItems;
	}
	public Long getCantidadBultos() {
		return cantidadBultos== null ? 0 : cantidadBultos;
	}
	public void setCantidadBultos(Long cantidadBultos) {
		this.cantidadBultos = cantidadBultos;
	}
	public Integer getPorcentajeRecepcion() {
		return porcentajeRecepcion;
	}
	public void setPorcentajeRecepcion(Integer porcentajeRecepcion) {
		this.porcentajeRecepcion = porcentajeRecepcion;
	}
	public Boolean getSeleccionado() {
		return seleccionado;
	}
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	/**
	 * @return the codigoAreaTrabajoCD
	 */
	public Integer getCodigoAreaTrabajoCD() {
		return codigoAreaTrabajoCD;
	}
	/**
	 * @param codigoAreaTrabajoCD the codigoAreaTrabajoCD to set
	 */
	public void setCodigoAreaTrabajoCD(Integer codigoAreaTrabajoCD) {
		this.codigoAreaTrabajoCD = codigoAreaTrabajoCD;
	}
	/**
	 * @return the fechaRecepcion
	 */
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}
	/**
	 * @param fechaRecepcion the fechaRecepcion to set
	 */
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	/**
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}
	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}
	/**
	 * @return the nombreCD
	 */
	public String getNombreCD() {
		return nombreCD;
	}
	/**
	 * @param nombreCD the nombreCD to set
	 */
	public void setNombreCD(String nombreCD) {
		this.nombreCD = nombreCD;
	}
	/**
	 * @return the nombreBodega
	 */
	public String getNombreBodega() {
		return nombreBodega;
	}
	/**
	 * @param nombreBodega the nombreBodega to set
	 */
	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}
	/**
	 * @return the nombreSubBodega
	 */
	public String getNombreSubBodega() {
		return nombreSubBodega;
	}
	/**
	 * @param nombreSubBodega the nombreSubBodega to set
	 */
	public void setNombreSubBodega(String nombreSubBodega) {
		this.nombreSubBodega = nombreSubBodega;
	}
	/**
	 * @return the codigoReferenciaCD
	 */
	public Integer getCodigoReferenciaCD() {
		return codigoReferenciaCD;
	}
	/**
	 * @param codigoReferenciaCD the codigoReferenciaCD to set
	 */
	public void setCodigoReferenciaCD(Integer codigoReferenciaCD) {
		this.codigoReferenciaCD = codigoReferenciaCD;
	}
	/**
	 * @return the codigoReferenciaBodega
	 */
	public Integer getCodigoReferenciaBodega() {
		return codigoReferenciaBodega;
	}
	/**
	 * @param codigoReferenciaBodega the codigoReferenciaBodega to set
	 */
	public void setCodigoReferenciaBodega(Integer codigoReferenciaBodega) {
		this.codigoReferenciaBodega = codigoReferenciaBodega;
	}
	/**
	 * @return the codigoReferenciaSubBodega
	 */
	public Integer getCodigoReferenciaSubBodega() {
		return codigoReferenciaSubBodega;
	}
	/**
	 * @param codigoReferenciaSubBodega the codigoReferenciaSubBodega to set
	 */
	public void setCodigoReferenciaSubBodega(Integer codigoReferenciaSubBodega) {
		this.codigoReferenciaSubBodega = codigoReferenciaSubBodega;
	}
	/**
	 * @return the codigoFuncionarioRecibidor
	 */
	public String getCodigoFuncionarioRecibidor() {
		return codigoFuncionarioRecibidor;
	}
	/**
	 * @param codigoFuncionarioRecibidor the codigoFuncionarioRecibidor to set
	 */
	public void setCodigoFuncionarioRecibidor(String codigoFuncionarioRecibidor) {
		this.codigoFuncionarioRecibidor = codigoFuncionarioRecibidor;
	}
	/**
	 * @return the userCompleteNameRecibidor
	 */
	public String getUserCompleteNameRecibidor() {
		return userCompleteNameRecibidor;
	}
	/**
	 * @param userCompleteNameRecibidor the userCompleteNameRecibidor to set
	 */
	public void setUserCompleteNameRecibidor(String userCompleteNameRecibidor) {
		this.userCompleteNameRecibidor = userCompleteNameRecibidor;
	}
	/**
	 * @return the primerAndenSeleccionado
	 */
	public String getPrimerAndenSeleccionado() {
		return primerAndenSeleccionado;
	}
	/**
	 * @param primerAndenSeleccionado the primerAndenSeleccionado to set
	 */
	public void setPrimerAndenSeleccionado(String primerAndenSeleccionado) {
		this.primerAndenSeleccionado = primerAndenSeleccionado;
	}
	/**
	 * @return the cantidadFacturas
	 */
	public Integer getCantidadFacturas() {
		return cantidadFacturas;
	}
	/**
	 * @param cantidadFacturas the cantidadFacturas to set
	 */
	public void setCantidadFacturas(Integer cantidadFacturas) {
		this.cantidadFacturas = cantidadFacturas;
	}
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
	 * @return the fechaRegistroProcesoLogistico
	 */
	public Date getFechaRegistroProcesoLogistico() {
		return fechaRegistroProcesoLogistico;
	}
	/**
	 * @param fechaRegistroProcesoLogistico the fechaRegistroProcesoLogistico to set
	 */
	public void setFechaRegistroProcesoLogistico(Date fechaRegistroProcesoLogistico) {
		this.fechaRegistroProcesoLogistico = fechaRegistroProcesoLogistico;
	}
	/**
	 * @return the secuencialRecepcionProveedor
	 */
	public Long getSecuencialRecepcionProveedor() {
		return secuencialRecepcionProveedor;
	}
	/**
	 * @param secuencialRecepcionProveedor the secuencialRecepcionProveedor to set
	 */
	public void setSecuencialRecepcionProveedor(Long secuencialRecepcionProveedor) {
		this.secuencialRecepcionProveedor = secuencialRecepcionProveedor;
	}
	/**
	 * @return the secuencialProcesoLogistico
	 */
	public Long getSecuencialProcesoLogistico() {
		return secuencialProcesoLogistico;
	}
	/**
	 * @param secuencialProcesoLogistico the secuencialProcesoLogistico to set
	 */
	public void setSecuencialProcesoLogistico(Long secuencialProcesoLogistico) {
		this.secuencialProcesoLogistico = secuencialProcesoLogistico;
	}
	/**
	 * @return the codigoTarea
	 */
	public Long getCodigoTarea() {
		return codigoTarea;
	}
	/**
	 * @param codigoTarea the codigoTarea to set
	 */
	public void setCodigoTarea(Long codigoTarea) {
		this.codigoTarea = codigoTarea;
	}
	/**
	 * @return the totalPesoRecibido
	 */
	public BigDecimal getTotalPesoRecibido() {
		return totalPesoRecibido;
	}
	/**
	 * @param totalPesoRecibido the totalPesoRecibido to set
	 */
	public void setTotalPesoRecibido(BigDecimal totalPesoRecibido) {
		this.totalPesoRecibido = totalPesoRecibido;
	}
	/**
	 * @return the totalPesoPlanificado
	 */
	public BigDecimal getTotalPesoPlanificado() {
		return totalPesoPlanificado;
	}
	/**
	 * @param totalPesoPlanificado the totalPesoPlanificado to set
	 */
	public void setTotalPesoPlanificado(BigDecimal totalPesoPlanificado) {
		this.totalPesoPlanificado = totalPesoPlanificado;
	}
	
	/**
	 * @return the cantidadTotalPedida
	 */
	public Integer getCantidadTotalPedida() {
		return cantidadTotalPedida;
	}
	/**
	 * @param cantidadTotalPedida the cantidadTotalPedida to set
	 */
	public void setCantidadTotalPedida(Integer cantidadTotalPedida) {
		this.cantidadTotalPedida = cantidadTotalPedida;
	}
	/**
	 * @return the cantidadTotalPlanificada
	 */
	public Integer getCantidadTotalPlanificada() {
		return cantidadTotalPlanificada;
	}
	/**
	 * @param cantidadTotalPlanificada the cantidadTotalPlanificada to set
	 */
	public void setCantidadTotalPlanificada(Integer cantidadTotalPlanificada) {
		this.cantidadTotalPlanificada = cantidadTotalPlanificada;
	}
	/**
	 * @return the totalPesoPlanificadoB2B
	 */
	public BigDecimal getTotalPesoPlanificadoB2B() {
		return totalPesoPlanificadoB2B;
	}
	/**
	 * @param totalPesoPlanificadoB2B the totalPesoPlanificadoB2B to set
	 */
	public void setTotalPesoPlanificadoB2B(BigDecimal totalPesoPlanificadoB2B) {
		this.totalPesoPlanificadoB2B = totalPesoPlanificadoB2B;
	}
	/**
	 * @return the totalPesoPedido
	 */
	public BigDecimal getTotalPesoPedido() {
		return totalPesoPedido;
	}
	/**
	 * @param totalPesoPedido the totalPesoPedido to set
	 */
	public void setTotalPesoPedido(BigDecimal totalPesoPedido) {
		this.totalPesoPedido = totalPesoPedido;
	}
	/**
	 * @return the codigoGrupoNovedadArticulo
	 */
	public Long getCodigoGrupoNovedadArticulo() {
		return codigoGrupoNovedadArticulo;
	}
	/**
	 * @param codigoGrupoNovedadArticulo the codigoGrupoNovedadArticulo to set
	 */
	public void setCodigoGrupoNovedadArticulo(Long codigoGrupoNovedadArticulo) {
		this.codigoGrupoNovedadArticulo = codigoGrupoNovedadArticulo;
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
	 * @return the numeroDocumentoProveedor
	 */
	public String getNumeroDocumentoProveedor() {
		return numeroDocumentoProveedor;
	}
	/**
	 * @param numeroDocumentoProveedor the numeroDocumentoProveedor to set
	 */
	public void setNumeroDocumentoProveedor(String numeroDocumentoProveedor) {
		this.numeroDocumentoProveedor = numeroDocumentoProveedor;
	}
	/**
	 * @return the valorTipoDocumento
	 */
	public String getValorTipoDocumento() {
		return valorTipoDocumento;
	}
	/**
	 * @param valorTipoDocumento the valorTipoDocumento to set
	 */
	public void setValorTipoDocumento(String valorTipoDocumento) {
		this.valorTipoDocumento = valorTipoDocumento;
	}
	/**
	 * @return the ingresoManual
	 */
	public Boolean getIngresoManual() {
		return ingresoManual;
	}
	/**
	 * @param ingresoManual the ingresoManual to set 
	 */
	public void setIngresoManual(Boolean ingresoManual) {
		this.ingresoManual = ingresoManual;
	}
	/**
	 * @return the estadoProcesoLogisticoDescripcion
	 */
	public String getEstadoProcesoLogisticoDescripcion() {
		return estadoProcesoLogisticoDescripcion;
	}
	/**
	 * @param estadoProcesoLogisticoDescripcion the estadoProcesoLogisticoDescripcion to set
	 */
	public void setEstadoProcesoLogisticoDescripcion(String estadoProcesoLogisticoDescripcion) {
		this.estadoProcesoLogisticoDescripcion = estadoProcesoLogisticoDescripcion;
	}
	/**
	 * @return the tipoRecepcionDescripcion
	 */
	public String getTipoRecepcionDescripcion() {
		return tipoRecepcionDescripcion;
	}
	/**
	 * @param tipoRecepcionDescripcion the tipoRecepcionDescripcion to set
	 */
	public void setTipoRecepcionDescripcion(String tipoRecepcionDescripcion) {
		this.tipoRecepcionDescripcion = tipoRecepcionDescripcion;
	}
	/**
	 * @return the tiempoEstimadoRecepcion
	 */
	public Long getTiempoEstimadoRecepcion() {
		return tiempoEstimadoRecepcion;
	}
	/**
	 * @param tiempoEstimadoRecepcion the tiempoEstimadoRecepcion to set
	 */
	public void setTiempoEstimadoRecepcion(Long tiempoEstimadoRecepcion) {
		this.tiempoEstimadoRecepcion = tiempoEstimadoRecepcion;
	}
	/**
	 * @return the codigoAreaTrabajoSubBodega
	 */
	public Integer getCodigoAreaTrabajoSubBodega() {
		return codigoAreaTrabajoSubBodega;
	}
	/**
	 * @param codigoAreaTrabajoSubBodega the codigoAreaTrabajoSubBodega to set
	 */
	public void setCodigoAreaTrabajoSubBodega(Integer codigoAreaTrabajoSubBodega) {
		this.codigoAreaTrabajoSubBodega = codigoAreaTrabajoSubBodega;
	}
	
	
}
