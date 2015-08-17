package ec.com.smx.sic.webservices.recargaCupon.jsonObjects;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.ConvenioID;

public class Convenio {

	private ConvenioID id = new ConvenioID();
	
	private String nombre;
	
	private String descripcion;
	
	private Long codigoReferencia;
	
	private String estado;
	
	private String codigoTipoEstado;
	
	private String usuarioRegistro;
	
	private Date fechaRegistro;
	
	private String usuarioModificacion;
	
	private Date fechaModificacion;
	
	private String valorTipoConvenio;
	
	private String codigoTipoConvenio;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private Collection<ArticuloConvenio> articuloConvenioDTOCol;
	
	private Collection<ClienteConvenio> clienteConvenioDTOCol;

	public ConvenioID getId() {
		return id;
	}

	public void setId(ConvenioID id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(Long codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigoTipoEstado() {
		return codigoTipoEstado;
	}

	public void setCodigoTipoEstado(String codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getValorTipoConvenio() {
		return valorTipoConvenio;
	}

	public void setValorTipoConvenio(String valorTipoConvenio) {
		this.valorTipoConvenio = valorTipoConvenio;
	}

	public String getCodigoTipoConvenio() {
		return codigoTipoConvenio;
	}

	public void setCodigoTipoConvenio(String codigoTipoConvenio) {
		this.codigoTipoConvenio = codigoTipoConvenio;
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

	public Collection<ArticuloConvenio> getArticuloConvenioDTOCol() {
		return articuloConvenioDTOCol;
	}

	public void setArticuloConvenioDTOCol(Collection<ArticuloConvenio> articuloConvenioDTOCol) {
		this.articuloConvenioDTOCol = articuloConvenioDTOCol;
	}

	public Collection<ClienteConvenio> getClienteConvenioDTOCol() {
		return clienteConvenioDTOCol;
	}

	public void setClienteConvenioDTOCol(Collection<ClienteConvenio> clienteConvenioDTOCol) {
		this.clienteConvenioDTOCol = clienteConvenioDTOCol;
	}

}