package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Date;

import javax.persistence.Id;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * 
 * @author amunoz
 *
 */
@SuppressWarnings("serial")
public class BusquedaTransferenciaTrasient extends SimpleAuditDTO {
	@Id
	private Long  codigoContenedorEstado;
	private Integer codigoCompania;
	private String numeroTransferencia;
	private String numeroContenedor;
	private Long codigoContenedor;
	private String codigoRuta;
	private Long codigoProcesoLogistico;
	private String codigoArticulo;
	private String estado;
	private String numeroContenedorAgrupador;
	private Date fechaInicio;
	private Date fechaFin;
	private String nombreEstado;
	private String usuario;
	private String codigoClasificacion;
	private String descripcionClasificacion;
	private String codigoReferenciaOrigen;
	private String nombreAreaTrabajoOrigen;
	private String codigoReferenciaDestino;
	private String nombreAreaTrabajoDestino;
	
	
	

	public String getNumeroTransferencia() {
		return numeroTransferencia;
	}

	public void setNumeroTransferencia(String numeroTransferencia) {
		this.numeroTransferencia = numeroTransferencia;
	}

	public String getNumeroContenedor() {
		return numeroContenedor;
	}

	public void setNumeroContenedor(String numeroContenedor) {
		this.numeroContenedor = numeroContenedor;
	}

	public String getNumeroContenedorAgrupador() {
		return numeroContenedorAgrupador;
	}

	public void setNumeroContenedorAgrupador(String numeroContenedorAgrupador) {
		this.numeroContenedorAgrupador = numeroContenedorAgrupador;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	public String getDescripcionClasificacion() {
		return descripcionClasificacion;
	}

	public void setDescripcionClasificacion(String descripcionClasificacion) {
		this.descripcionClasificacion = descripcionClasificacion;
	}

	public String getCodigoReferenciaOrigen() {
		return codigoReferenciaOrigen;
	}

	public void setCodigoReferenciaOrigen(String codigoReferenciaOrigen) {
		this.codigoReferenciaOrigen = codigoReferenciaOrigen;
	}

	public String getNombreAreaTrabajoOrigen() {
		return nombreAreaTrabajoOrigen;
	}

	public void setNombreAreaTrabajoOrigen(String nombreAreaTrabajoOrigen) {
		this.nombreAreaTrabajoOrigen = nombreAreaTrabajoOrigen;
	}

	public String getCodigoReferenciaDestino() {
		return codigoReferenciaDestino;
	}

	public void setCodigoReferenciaDestino(String codigoReferenciaDestino) {
		this.codigoReferenciaDestino = codigoReferenciaDestino;
	}

	public String getNombreAreaTrabajoDestino() {
		return nombreAreaTrabajoDestino;
	}

	public void setNombreAreaTrabajoDestino(String nombreAreaTrabajoDestino) {
		this.nombreAreaTrabajoDestino = nombreAreaTrabajoDestino;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getCodigoContenedorEstado() {
		return codigoContenedorEstado;
	}

	public void setCodigoContenedorEstado(Long codigoContenedorEstado) {
		this.codigoContenedorEstado = codigoContenedorEstado;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoContenedor() {
		return codigoContenedor;
	}

	public void setCodigoContenedor(Long codigoContenedor) {
		this.codigoContenedor = codigoContenedor;
	}

	public String getCodigoRuta() {
		return codigoRuta;
	}

	public void setCodigoRuta(String codigoRuta) {
		this.codigoRuta = codigoRuta;
	}

	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}
