/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.ClienteArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.ConvenioID;

/**
 * @author fvallejo
 *
 */
@Entity
@Table(name = "SCSACTCONVENIO")
public class ConvenioDTO {

	@EmbeddedId
	private ConvenioID id;

	private String nombre;

	private String descripcion;

	private Long codigoReferencia;

	private String estado;
	
	private String codigoTipoEstado;
	
	private String valorTipoConvenio;
	
	private String codigoTipoConvenio;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	@RegisterUserIdField
	@Column(updatable = false)
	private String usuarioRegistro;

	@RegisterUserIdField
	@Column(updatable = false)
	private Date fechaRegistro;

	@LastModifierUserIdField
	private String usuarioModificacion;

	@LastModifierUserIdField
	private Date fechaModificacion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "convenioDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloConvenioDTO> articuloConvenioDTOCol;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "convenioDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ClienteConvenioDTO> clienteConvenioDTOCol;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "convenioDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ClienteArticuloDTO> clienteArticuloDTOCol;


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

	public String getValorTipoConvenio() {
		return valorTipoConvenio;
	}

	public void setValorTipoConvenio(String valorTipoConvenio) {
		this.valorTipoConvenio = valorTipoConvenio;
	}

	public String getCodigoTipoConvenio() {
		return codigoTipoConvenio;
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

	public void setCodigoTipoConvenio(String codigoTipoConvenio) {
		this.codigoTipoConvenio = codigoTipoConvenio;
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

	public Collection<ArticuloConvenioDTO> getArticuloConvenioDTOCol() {
		return articuloConvenioDTOCol;
	}

	public void setArticuloConvenioDTOCol(Collection<ArticuloConvenioDTO> articuloConvenioDTOCol) {
		this.articuloConvenioDTOCol = articuloConvenioDTOCol;
	}
	
	public Collection<ClienteConvenioDTO> getClienteConvenioDTOCol() {
		return clienteConvenioDTOCol;
	}

	public void setClienteConvenioDTOCol(Collection<ClienteConvenioDTO> clienteConvenioDTOCol) {
		this.clienteConvenioDTOCol = clienteConvenioDTOCol;
	}

	public Collection<ClienteArticuloDTO> getClienteArticuloDTOCol() {
		return clienteArticuloDTOCol;
	}

	public void setClienteArticuloDTOCol(Collection<ClienteArticuloDTO> clienteArticuloDTOCol) {
		this.clienteArticuloDTOCol = clienteArticuloDTOCol;
	}
	
}
