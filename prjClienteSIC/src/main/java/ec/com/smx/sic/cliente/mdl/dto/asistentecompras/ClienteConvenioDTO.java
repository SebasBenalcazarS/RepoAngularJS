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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.ClienteConvenioID;
import ec.com.smx.sic.cliente.mdl.dto.sispe.ClienteDTO;

/**
 * @author fvallejo
 *
 */
@Entity
@Table(name = "SCSACTCLICON")
public class ClienteConvenioDTO {
	
	@EmbeddedId
	private ClienteConvenioID id;
	
	private Long secuencialConvenio;

	private Integer codigoCompania;
	
	private Long codigoClientePedido; 

	private String estado;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SECUENCIALCONVENIO", referencedColumnName = "SECUENCIALCONVENIO", insertable = false, updatable = false)
	private ConvenioDTO convenioDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOCLIENTEPEDIDO", referencedColumnName = "CODIGOCLIENTEPEDIDO", insertable = false, updatable = false) })
	private ClienteDTO clienteDTO;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clienteConvenioDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ClienteArticuloConvenioDTO> clienteArticuloConvenioDTOCol;

	public ClienteConvenioID getId() {
		return id;
	}

	public void setId(ClienteConvenioID id) {
		this.id = id;
	}

	public Long getSecuencialConvenio() {
		return secuencialConvenio;
	}

	public void setSecuencialConvenio(Long secuencialConvenio) {
		this.secuencialConvenio = secuencialConvenio;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoClientePedido() {
		return codigoClientePedido;
	}

	public void setCodigoClientePedido(Long codigoClientePedido) {
		this.codigoClientePedido = codigoClientePedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public ConvenioDTO getConvenioDTO() {
		return convenioDTO;
	}

	public void setConvenioDTO(ConvenioDTO convenioDTO) {
		this.convenioDTO = convenioDTO;
	}

	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}

	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

	public Collection<ClienteArticuloConvenioDTO> getClienteArticuloConvenioDTOCol() {
		return clienteArticuloConvenioDTOCol;
	}

	public void setClienteArticuloConvenioDTOCol(Collection<ClienteArticuloConvenioDTO> clienteArticuloConvenioDTOCol) {
		this.clienteArticuloConvenioDTOCol = clienteArticuloConvenioDTOCol;
	}
	
}
