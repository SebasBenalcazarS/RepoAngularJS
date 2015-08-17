package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.ClienteCuponCompartidoID;
import ec.com.smx.sic.cliente.mdl.dto.sispe.ClienteDTO;

@SuppressWarnings("serial")
@Entity
@Table(name="SCSACTCLICUPCOM")
public class ClienteCuponCompartidoDTO extends SimpleAuditDTO{

	@EmbeddedId
	private ClienteCuponCompartidoID id = new ClienteCuponCompartidoID();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false)
	})
	private ArticuloDTO articuloDto;

	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOTIPORED", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "VALORTIPORED", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorDTO catalogoValorDTO;

	@Column(name = "CODIGOTIPORED", nullable = false)
	private Integer codigoTipoRed;

	@Column(name = "VALORTIPORED",nullable = false)
	private String valorTipoRed;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLIENTEPEDIDO", referencedColumnName = "CODIGOCLIENTEPEDIDO", insertable = false, updatable = false)
	})
	private ClienteDTO clienteDTO;

	@Column(name = "CODIGOCLIENTEPEDIDO", nullable = false)
	private Long codigoClientePedido;

	@Column(name = "ESTADO")
	private String estado;

	
	@RegisterUserIdField
	@Column(name="USUARIOREGISTRO",updatable=false)
	private String idUsuarioRegistro;

	
	@LastModifierUserIdField
	@Column(name="USUARIOMODIFICACION")
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	
	
	/**
	 * @return the id
	 */
	public ClienteCuponCompartidoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ClienteCuponCompartidoID id) {
		this.id = id;
	}

	/**
	 * @return the articuloDto
	 */
	public ArticuloDTO getArticuloDto() {
		return articuloDto;
	}

	/**
	 * @param articuloDto the articuloDto to set
	 */
	public void setArticuloDto(ArticuloDTO articuloDto) {
		this.articuloDto = articuloDto;
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
	 * @return the catalogoValorDTO
	 */
	public CatalogoValorDTO getCatalogoValorDTO() {
		return catalogoValorDTO;
	}

	/**
	 * @param catalogoValorDTO the catalogoValorDTO to set
	 */
	public void setCatalogoValorDTO(CatalogoValorDTO catalogoValorDTO) {
		this.catalogoValorDTO = catalogoValorDTO;
	}

	/**
	 * @return the codigoTipoRed
	 */
	public Integer getCodigoTipoRed() {
		return codigoTipoRed;
	}

	/**
	 * @param codigoTipoRed the codigoTipoRed to set
	 */
	public void setCodigoTipoRed(Integer codigoTipoRed) {
		this.codigoTipoRed = codigoTipoRed;
	}

	/**
	 * @return the valorTipoRed
	 */
	public String getValorTipoRed() {
		return valorTipoRed;
	}

	/**
	 * @param valorTipoRed the valorTipoRed to set
	 */
	public void setValorTipoRed(String valorTipoRed) {
		this.valorTipoRed = valorTipoRed;
	}

	/**
	 * @return the clienteDTO
	 */
	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}

	/**
	 * @param clienteDTO the clienteDTO to set
	 */
	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

	/**
	 * @return the codigoClientePedido
	 */
	public Long getCodigoClientePedido() {
		return codigoClientePedido;
	}

	/**
	 * @param codigoClientePedido the codigoClientePedido to set
	 */
	public void setCodigoClientePedido(Long codigoClientePedido) {
		this.codigoClientePedido = codigoClientePedido;
	}

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
	 * @return the fechaRegistro
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
}
