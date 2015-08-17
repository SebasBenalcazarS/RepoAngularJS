package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * 
 * @author cherrera
 *
 */

@SuppressWarnings("serial")
@Entity
public class ContenedorEstadoPalletRutaTrasient extends SimpleAuditDTO {

	/**
	 * DECLARACION DE VARIABLES
	 */
	
	@Id
	private String numeroContenedor;
	private String estado;
	private Integer codigoCompania;
	private String codigoRuta;
	private Long codigoContenedor;
	private Long codigoContenedorEstado;
	private Long codigoProcesoLogistico;
	private Integer codigoTipoTransaccion;
	private Integer codigoInternoTipoTransaccion;
	private String nombreTipoTransaccion;
	private Integer codigoAreaTrabajoOrigen;
	private Integer codigoReferenciaAreaTrabajoOrigen;
	private String nombreAreaTrabajoOrigen;
	private Integer codigoAreaTrabajoDestino;
	private Integer codigoReferenciaAreaTrabajoDestino;
	private String nombreAreaTrabajoDestino;
	private String numeroTransferencia;
	private String codigoCatalogoValorOrigen;
	private Integer codigoCatalogoTipoOrigen;
	private String codigoCatalogoValorActual;
	private Integer codigoCatalogoTipoActual;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaRegistro;
	private Date fechaModificacion;
	private String idUsuarioRegistro;
	private String idUsuarioModificacion;
	
	/**
	 * DEFINICION DE GETTERS AND SETTERS
	 */
	
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the codigoContenedorEstado
	 */
	public Long getCodigoContenedorEstado() {
		return codigoContenedorEstado;
	}
	/**
	 * @param codigoContenedorEstado the codigoContenedorEstado to set
	 */
	public void setCodigoContenedorEstado(Long codigoContenedorEstado) {
		this.codigoContenedorEstado = codigoContenedorEstado;
	}
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
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}
	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}
	/**
	 * @return the numeroContenedor
	 */
	public String getNumeroContenedor() {
		return numeroContenedor;
	}
	/**
	 * @param numeroContenedor the numeroContenedor to set
	 */
	public void setNumeroContenedor(String numeroContenedor) {
		this.numeroContenedor = numeroContenedor;
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
	 * @return the codigoRuta
	 */
	public String getCodigoRuta() {
		return codigoRuta;
	}
	/**
	 * @param codigoRuta the codigoRuta to set
	 */
	public void setCodigoRuta(String codigoRuta) {
		this.codigoRuta = codigoRuta;
	}
	/**
	 * @return the codigoContenedor
	 */
	public Long getCodigoContenedor() {
		return codigoContenedor;
	}
	/**
	 * @param codigoContenedor the codigoContenedor to set
	 */
	public void setCodigoContenedor(Long codigoContenedor) {
		this.codigoContenedor = codigoContenedor;
	}
	/**
	 * @return the codigoProcesoLogistico
	 */
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}
	/**
	 * @param codigoProcesoLogistico the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}
	/**
	 * @return the codigoTipoTransaccion
	 */
	public Integer getCodigoTipoTransaccion() {
		return codigoTipoTransaccion;
	}
	/**
	 * @param codigoTipoTransaccion the codigoTipoTransaccion to set
	 */
	public void setCodigoTipoTransaccion(Integer codigoTipoTransaccion) {
		this.codigoTipoTransaccion = codigoTipoTransaccion;
	}
	/**
	 * @return the codigoInternoTipoTransaccion
	 */
	public Integer getCodigoInternoTipoTransaccion() {
		return codigoInternoTipoTransaccion;
	}
	/**
	 * @param codigoInternoTipoTransaccion the codigoInternoTipoTransaccion to set
	 */
	public void setCodigoInternoTipoTransaccion(Integer codigoInternoTipoTransaccion) {
		this.codigoInternoTipoTransaccion = codigoInternoTipoTransaccion;
	}
	/**
	 * @return the nombreTipoTransaccion
	 */
	public String getNombreTipoTransaccion() {
		return nombreTipoTransaccion;
	}
	/**
	 * @param nombreTipoTransaccion the nombreTipoTransaccion to set
	 */
	public void setNombreTipoTransaccion(String nombreTipoTransaccion) {
		this.nombreTipoTransaccion = nombreTipoTransaccion;
	}
	/**
	 * @return the codigoAreaTrabajoOrigen
	 */
	public Integer getCodigoAreaTrabajoOrigen() {
		return codigoAreaTrabajoOrigen;
	}
	/**
	 * @param codigoAreaTrabajoOrigen the codigoAreaTrabajoOrigen to set
	 */
	public void setCodigoAreaTrabajoOrigen(Integer codigoAreaTrabajoOrigen) {
		this.codigoAreaTrabajoOrigen = codigoAreaTrabajoOrigen;
	}
	/**
	 * @return the codigoReferenciaAreaTrabajoOrigen
	 */
	public Integer getCodigoReferenciaAreaTrabajoOrigen() {
		return codigoReferenciaAreaTrabajoOrigen;
	}
	/**
	 * @param codigoReferenciaAreaTrabajoOrigen the codigoReferenciaAreaTrabajoOrigen to set
	 */
	public void setCodigoReferenciaAreaTrabajoOrigen(Integer codigoReferenciaAreaTrabajoOrigen) {
		this.codigoReferenciaAreaTrabajoOrigen = codigoReferenciaAreaTrabajoOrigen;
	}
	/**
	 * @return the nombreAreaTrabajoOrigen
	 */
	public String getNombreAreaTrabajoOrigen() {
		return nombreAreaTrabajoOrigen;
	}
	/**
	 * @param nombreAreaTrabajoOrigen the nombreAreaTrabajoOrigen to set
	 */
	public void setNombreAreaTrabajoOrigen(String nombreAreaTrabajoOrigen) {
		this.nombreAreaTrabajoOrigen = nombreAreaTrabajoOrigen;
	}
	/**
	 * @return the codigoAreaTrabajoDestino
	 */
	public Integer getCodigoAreaTrabajoDestino() {
		return codigoAreaTrabajoDestino;
	}
	/**
	 * @param codigoAreaTrabajoDestino the codigoAreaTrabajoDestino to set
	 */
	public void setCodigoAreaTrabajoDestino(Integer codigoAreaTrabajoDestino) {
		this.codigoAreaTrabajoDestino = codigoAreaTrabajoDestino;
	}
	/**
	 * @return the codigoReferenciaAreaTrabajoDestino
	 */
	public Integer getCodigoReferenciaAreaTrabajoDestino() {
		return codigoReferenciaAreaTrabajoDestino;
	}
	/**
	 * @param codigoReferenciaAreaTrabajoDestino the codigoReferenciaAreaTrabajoDestino to set
	 */
	public void setCodigoReferenciaAreaTrabajoDestino(Integer codigoReferenciaAreaTrabajoDestino) {
		this.codigoReferenciaAreaTrabajoDestino = codigoReferenciaAreaTrabajoDestino;
	}
	/**
	 * @return the nombreAreaTrabajoDestino
	 */
	public String getNombreAreaTrabajoDestino() {
		return nombreAreaTrabajoDestino;
	}
	/**
	 * @param nombreAreaTrabajoDestino the nombreAreaTrabajoDestino to set
	 */
	public void setNombreAreaTrabajoDestino(String nombreAreaTrabajoDestino) {
		this.nombreAreaTrabajoDestino = nombreAreaTrabajoDestino;
	}
	/**
	 * @return the numeroTransferencia
	 */
	public String getNumeroTransferencia() {
		return numeroTransferencia;
	}
	/**
	 * @param numeroTransferencia the numeroTransferencia to set
	 */
	public void setNumeroTransferencia(String numeroTransferencia) {
		this.numeroTransferencia = numeroTransferencia;
	}
	/**
	 * @return the codigoCatalogoValorActual
	 */
	public String getCodigoCatalogoValorActual() {
		return codigoCatalogoValorActual;
	}
	/**
	 * @param codigoCatalogoValorActual the codigoCatalogoValorActual to set
	 */
	public void setCodigoCatalogoValorActual(String codigoCatalogoValorActual) {
		this.codigoCatalogoValorActual = codigoCatalogoValorActual;
	}
	/**
	 * @return the codigoCatalogoTipoActual
	 */
	public Integer getCodigoCatalogoTipoActual() {
		return codigoCatalogoTipoActual;
	}
	/**
	 * @param codigoCatalogoTipoActual the codigoCatalogoTipoActual to set
	 */
	public void setCodigoCatalogoTipoActual(Integer codigoCatalogoTipoActual) {
		this.codigoCatalogoTipoActual = codigoCatalogoTipoActual;
	}
	/**
	 * @return the codigoCatalogoValorOrigen
	 */
	public String getCodigoCatalogoValorOrigen() {
		return codigoCatalogoValorOrigen;
	}
	/**
	 * @param codigoCatalogoValorOrigen the codigoCatalogoValorOrigen to set
	 */
	public void setCodigoCatalogoValorOrigen(String codigoCatalogoValorOrigen) {
		this.codigoCatalogoValorOrigen = codigoCatalogoValorOrigen;
	}
	/**
	 * @return the codigoCatalogoTipoOrigen
	 */
	public Integer getCodigoCatalogoTipoOrigen() {
		return codigoCatalogoTipoOrigen;
	}
	/**
	 * @param codigoCatalogoTipoOrigen the codigoCatalogoTipoOrigen to set
	 */
	public void setCodigoCatalogoTipoOrigen(Integer codigoCatalogoTipoOrigen) {
		this.codigoCatalogoTipoOrigen = codigoCatalogoTipoOrigen;
	}
}
