package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.ClienteArticuloConvenioID;


/**
 * @author jcedeno
 *
 */
@Entity
@Table(name="SCSACTCLIARTCON")
public class ClienteArticuloConvenioDTO {
	@EmbeddedId 
	private ClienteArticuloConvenioID id;
	
	private Long secuencialArticuloConvenio;
	
	private Long secuencialClienteConvenio;
	
	private Integer stock;  
	
	private Integer stockDisponible;
	
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
	@JoinColumn(name = "SECUENCIALARTICULOCONVENIO", referencedColumnName = "SECUENCIALARTICULOCONVENIO", insertable = false, updatable = false)
	private ArticuloConvenioDTO articuloConvenioDTO;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "SECUENCIALCLIENTECONVENIO", referencedColumnName = "SECUENCIALCLIENTECONVENIO", insertable = false, updatable = false)
	private ClienteConvenioDTO clienteConvenioDTO;

	public ClienteArticuloConvenioID getId() {
		return id;
	}

	public void setId(ClienteArticuloConvenioID id) {
		this.id = id;
	}

	public Long getSecuencialArticuloConvenio() {
		return secuencialArticuloConvenio;
	}

	public void setSecuencialArticuloConvenio(Long secuencialArticuloConvenio) {
		this.secuencialArticuloConvenio = secuencialArticuloConvenio;
	}

	public Long getSecuencialClienteConvenio() {
		return secuencialClienteConvenio;
	}

	public void setSecuencialClienteConvenio(Long secuencialClienteConvenio) {
		this.secuencialClienteConvenio = secuencialClienteConvenio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getStockDisponible() {
		return stockDisponible;
	}

	public void setStockDisponible(Integer stockDisponible) {
		this.stockDisponible = stockDisponible;
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

	public ArticuloConvenioDTO getArticuloConvenioDTO() {
		return articuloConvenioDTO;
	}

	public void setArticuloConvenioDTO(ArticuloConvenioDTO articuloConvenioDTO) {
		this.articuloConvenioDTO = articuloConvenioDTO;
	}

	public ClienteConvenioDTO getClienteConvenioDTO() {
		return clienteConvenioDTO;
	}

	public void setClienteConvenioDTO(ClienteConvenioDTO clienteConvenioDTO) {
		this.clienteConvenioDTO = clienteConvenioDTO;
	}
	
	
	
	
}
