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
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.ArticuloConvenioID;

/**
 * @author fvallejo
 *
 */
@Entity
@Table(name = "SCSACTARTCON")
public class ArticuloConvenioDTO {

	@EmbeddedId
	private ArticuloConvenioID id;

	private Long secuencialConvenio;

	private Integer codigoCompania;

	private String codigoArticulo;

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
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false) })
	private ArticuloDTO articuloDTO;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articuloConvenioDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ClienteArticuloConvenioDTO> clienteArticuloConvenioDTOCol;

	public ArticuloConvenioID getId() {
		return id;
	}

	public void setId(ArticuloConvenioID id) {
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

	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}

	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}

	public Collection<ClienteArticuloConvenioDTO> getClienteArticuloConvenioDTOCol() {
		return clienteArticuloConvenioDTOCol;
	}

	public void setClienteArticuloConvenioDTOCol(Collection<ClienteArticuloConvenioDTO> clienteArticuloConvenioDTOCol) {
		this.clienteArticuloConvenioDTOCol = clienteArticuloConvenioDTOCol;
	}
}
