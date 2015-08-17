package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaTareaDatosTareaID;

@SuppressWarnings("serial")
@Entity
public class VistaTareaDatosTareaDTO implements Serializable{
	@EmbeddedId
	VistaTareaDatosTareaID id = new VistaTareaDatosTareaID();
	
	//Campos de la tarea	
	private String valorEstadoTarea;	
	private Long secuencialTarea;	
	private String codigoFuncionarioTarea;
	private Long codigoTareaPadre;	
	private Long codigoProcesoLogisticoTarea;
	private String codigoReferenciaTipoTarea;	
	
	//Campos datosTarea
	private Integer cantidadRecibida;
	private BigDecimal pesoRecibido;
	private String codigoBarrasPallet;
	private Integer codigoAreaTrabajoPallet;
	private Integer codigoAreaTrabajoBodegaPallet;
	private Integer codigoAreaTrabajoSubBodegaPallet;
	private String lote;
	private java.util.Date fechaElaboracion;
	private java.util.Date fechaCaducidad;
	//campos del articulo que se encuentra en el pallet
	private String codigoArticulo;
	private Long codigoUnidadManejo;
	
	private Long secuencialDatosTarea;
	private Integer codigoEstadoDatosTarea;
	private String valorEstadoDatosTarea;
	private String valorTipoControlCosto;
	
	//datos articulo
	private String descripcionArticulo;
	private String referenciaMedidaArticulo;
	private String codigoBarrasArticulo;	
	
	//ubicaciones del pallet
	private Long codigoUbicacionActual;//ubicacion que se va actualizando mientras el pallet cambia de ubicacion
	private Long codigoUbicacionDestino;//ubicacion actual del pallet cuando crea (tipo ubicacion surtido o ubicacion de balanza)
	private String identificadorUbicacionDestino;//nombre de la ubicacion de referencia
	private String identificadorUbicacionActual;//nombre de la ubicacion de referencia
	@Transient
	private Integer numeroPalet;
	/**
	 * @return the id
	 */
	public VistaTareaDatosTareaID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(VistaTareaDatosTareaID id) {
		this.id = id;
	}
	/**
	 * @return the valorEstadoTarea
	 */
	public String getValorEstadoTarea() {
		return valorEstadoTarea;
	}
	/**
	 * @param valorEstadoTarea the valorEstadoTarea to set
	 */
	public void setValorEstadoTarea(String valorEstadoTarea) {
		this.valorEstadoTarea = valorEstadoTarea;
	}
	/**
	 * @return the secuencialTarea
	 */
	public Long getSecuencialTarea() {
		return secuencialTarea;
	}
	/**
	 * @param secuencialTarea the secuencialTarea to set
	 */
	public void setSecuencialTarea(Long secuencialTarea) {
		this.secuencialTarea = secuencialTarea;
	}
	/**
	 * @return the codigoFuncionarioTarea
	 */
	public String getCodigoFuncionarioTarea() {
		return codigoFuncionarioTarea;
	}
	/**
	 * @param codigoFuncionarioTarea the codigoFuncionarioTarea to set
	 */
	public void setCodigoFuncionarioTarea(String codigoFuncionarioTarea) {
		this.codigoFuncionarioTarea = codigoFuncionarioTarea;
	}
	/**
	 * @return the codigoTareaPadre
	 */
	public Long getCodigoTareaPadre() {
		return codigoTareaPadre;
	}
	/**
	 * @param codigoTareaPadre the codigoTareaPadre to set
	 */
	public void setCodigoTareaPadre(Long codigoTareaPadre) {
		this.codigoTareaPadre = codigoTareaPadre;
	}
	/**
	 * @return the codigoProcesoLogisticoTarea
	 */
	public Long getCodigoProcesoLogisticoTarea() {
		return codigoProcesoLogisticoTarea;
	}
	/**
	 * @param codigoProcesoLogisticoTarea the codigoProcesoLogisticoTarea to set
	 */
	public void setCodigoProcesoLogisticoTarea(Long codigoProcesoLogisticoTarea) {
		this.codigoProcesoLogisticoTarea = codigoProcesoLogisticoTarea;
	}
	/**
	 * @return the cantidadRecibida
	 */
	public Integer getCantidadRecibida() {
		return cantidadRecibida;
	}
	/**
	 * @param cantidadRecibida the cantidadRecibida to set
	 */
	public void setCantidadRecibida(Integer cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}
	/**
	 * @return the pesoRecibido
	 */
	public BigDecimal getPesoRecibido() {
		return pesoRecibido;
	}
	/**
	 * @param pesoRecibido the pesoRecibido to set
	 */
	public void setPesoRecibido(BigDecimal pesoRecibido) {
		this.pesoRecibido = pesoRecibido;
	}
	/**
	 * @return the codigoBarrasPallet
	 */
	public String getCodigoBarrasPallet() {
		return codigoBarrasPallet;
	}
	/**
	 * @param codigoBarrasPallet the codigoBarrasPallet to set
	 */
	public void setCodigoBarrasPallet(String codigoBarrasPallet) {
		this.codigoBarrasPallet = codigoBarrasPallet;
	}
	/**
	 * @return the codigoAreaTrabajoPallet
	 */
	public Integer getCodigoAreaTrabajoPallet() {
		return codigoAreaTrabajoPallet;
	}
	/**
	 * @param codigoAreaTrabajoPallet the codigoAreaTrabajoPallet to set
	 */
	public void setCodigoAreaTrabajoPallet(Integer codigoAreaTrabajoPallet) {
		this.codigoAreaTrabajoPallet = codigoAreaTrabajoPallet;
	}
	/**
	 * @return the codigoAreaTrabajoBodegaPallet
	 */
	public Integer getCodigoAreaTrabajoBodegaPallet() {
		return codigoAreaTrabajoBodegaPallet;
	}
	/**
	 * @param codigoAreaTrabajoBodegaPallet the codigoAreaTrabajoBodegaPallet to set
	 */
	public void setCodigoAreaTrabajoBodegaPallet(Integer codigoAreaTrabajoBodegaPallet) {
		this.codigoAreaTrabajoBodegaPallet = codigoAreaTrabajoBodegaPallet;
	}
	/**
	 * @return the codigoAreaTrabajoSubBodegaPallet
	 */
	public Integer getCodigoAreaTrabajoSubBodegaPallet() {
		return codigoAreaTrabajoSubBodegaPallet;
	}
	/**
	 * @param codigoAreaTrabajoSubBodegaPallet the codigoAreaTrabajoSubBodegaPallet to set
	 */
	public void setCodigoAreaTrabajoSubBodegaPallet(Integer codigoAreaTrabajoSubBodegaPallet) {
		this.codigoAreaTrabajoSubBodegaPallet = codigoAreaTrabajoSubBodegaPallet;
	}
	/**
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}
	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}
	/**
	 * @return the fechaElaboracion
	 */
	public java.util.Date getFechaElaboracion() {
		return fechaElaboracion;
	}
	/**
	 * @param fechaElaboracion the fechaElaboracion to set
	 */
	public void setFechaElaboracion(java.util.Date fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}
	/**
	 * @return the fechaCaducidad
	 */
	public java.util.Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	/**
	 * @param fechaCaducidad the fechaCaducidad to set
	 */
	public void setFechaCaducidad(java.util.Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
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
	 * @return the secuencialDatosTarea
	 */
	public Long getSecuencialDatosTarea() {
		return secuencialDatosTarea;
	}
	/**
	 * @param secuencialDatosTarea the secuencialDatosTarea to set
	 */
	public void setSecuencialDatosTarea(Long secuencialDatosTarea) {
		this.secuencialDatosTarea = secuencialDatosTarea;
	}
	/**
	 * @return the valorEstadoDatosTarea
	 */
	public String getValorEstadoDatosTarea() {
		return valorEstadoDatosTarea;
	}
	/**
	 * @param valorEstadoDatosTarea the valorEstadoDatosTarea to set
	 */
	public void setValorEstadoDatosTarea(String valorEstadoDatosTarea) {
		this.valorEstadoDatosTarea = valorEstadoDatosTarea;
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
	 * @return the referenciaMedidaArticulo
	 */
	public String getReferenciaMedidaArticulo() {
		return referenciaMedidaArticulo;
	}
	/**
	 * @param referenciaMedidaArticulo the referenciaMedidaArticulo to set
	 */
	public void setReferenciaMedidaArticulo(String referenciaMedidaArticulo) {
		this.referenciaMedidaArticulo = referenciaMedidaArticulo;
	}
	/**
	 * @return the codigoBarrasArticulo
	 */
	public String getCodigoBarrasArticulo() {
		return codigoBarrasArticulo;
	}
	/**
	 * @param codigoBarrasArticulo the codigoBarrasArticulo to set
	 */
	public void setCodigoBarrasArticulo(String codigoBarrasArticulo) {
		this.codigoBarrasArticulo = codigoBarrasArticulo;
	}
	/**
	 * @return the codigoUbicacionActual
	 */
	public Long getCodigoUbicacionActual() {
		return codigoUbicacionActual;
	}
	/**
	 * @param codigoUbicacionActual the codigoUbicacionActual to set
	 */
	public void setCodigoUbicacionActual(Long codigoUbicacionActual) {
		this.codigoUbicacionActual = codigoUbicacionActual;
	}
	/**
	 * @return the codigoUbicacionDestino
	 */
	public Long getCodigoUbicacionDestino() {
		return codigoUbicacionDestino;
	}
	/**
	 * @param codigoUbicacionDestino the codigoUbicacionDestino to set
	 */
	public void setCodigoUbicacionDestino(Long codigoUbicacionDestino) {
		this.codigoUbicacionDestino = codigoUbicacionDestino;
	}
	/**
	 * @return the identificadorUbicacionDestino
	 */
	public String getIdentificadorUbicacionDestino() {
		return identificadorUbicacionDestino;
	}
	/**
	 * @param identificadorUbicacionDestino the identificadorUbicacionDestino to set
	 */
	public void setIdentificadorUbicacionDestino(String identificadorUbicacionDestino) {
		this.identificadorUbicacionDestino = identificadorUbicacionDestino;
	}
	/**
	 * @return the numeroPalet
	 */
	public Integer getNumeroPalet() {
		return numeroPalet;
	}
	/**
	 * @param numeroPalet the numeroPalet to set
	 */
	public void setNumeroPalet(Integer numeroPalet) {
		this.numeroPalet = numeroPalet;
	}
	/**
	 * @return the identificadorUbicacionActual
	 */
	public String getIdentificadorUbicacionActual() {
		return identificadorUbicacionActual;
	}
	/**
	 * @param identificadorUbicacionActual the identificadorUbicacionActual to set
	 */
	public void setIdentificadorUbicacionActual(String identificadorUbicacionActual) {
		this.identificadorUbicacionActual = identificadorUbicacionActual;
	}
	/**
	 * @return the codigoReferenciaTipoTarea
	 */
	public String getCodigoReferenciaTipoTarea() {
		return codigoReferenciaTipoTarea;
	}
	/**
	 * @param codigoReferenciaTipoTarea the codigoReferenciaTipoTarea to set
	 */
	public void setCodigoReferenciaTipoTarea(String codigoReferenciaTipoTarea) {
		this.codigoReferenciaTipoTarea = codigoReferenciaTipoTarea;
	}
	/**
	 * @return the codigoEstadoDatosTarea
	 */
	public Integer getCodigoEstadoDatosTarea() {
		return codigoEstadoDatosTarea;
	}
	/**
	 * @param codigoEstadoDatosTarea the codigoEstadoDatosTarea to set
	 */
	public void setCodigoEstadoDatosTarea(Integer codigoEstadoDatosTarea) {
		this.codigoEstadoDatosTarea = codigoEstadoDatosTarea;
	}
					
	
}

