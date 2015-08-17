package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLocalPedidoID;

/**
 * clase que administra la cantidad de pedido por local
 * @author corbe
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTLOCPED")
public class ArticuloLocalPedidoDTO extends SimpleAuditDTO{
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLocalPedidoID id;
	
	/**
	 * cantidad maxima de pedido por local
	 */
	private Integer cantidadMaxima;
	
	/**
	 * fecha de inicio en la que tiene vigencia la cantidad
	 */
	private Timestamp fechaInicio;
	
	/**
	 * fecha final en la cual se termina la vigencia de la cantidad
	 */
	private Timestamp fechaFin;
	
	/**
	 * codigo tipo empaque, (relacion con catalogoValor)
	 */
	private Integer codigoTipoEmpaque;
	
	/**
	 * valor tipo empaque, (relacion con catalogoValor)
	 */
	private String valorTipoEmpaque;
	
	@Transient
	private Boolean esCreacion;
	
	/**
	 * id del usuario de registro
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;
	
	/**
	 * fecha en la cual se guarda el registro
	 */
	@RegisterDateField
	@Column(updatable=false)
	private Timestamp fechaRegistro;
	
	/**
	 * usuario de modificacion
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;
	
	/**
	 * fecha en la cual se actualiza el registro
	 */
	@LastModificationDateField
	private Timestamp fechaModificacion;
	
	public ArticuloLocalPedidoDTO(){
		id = new ArticuloLocalPedidoID(); 
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioRegistro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioModificacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOLOCAL", referencedColumnName="CODIGOLOCAL", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO articuloLocalPedido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "VALORTIPOEMPAQUE", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOEMPAQUE", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoEmpaquePedido;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLocalPedidoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLocalPedidoID id) {
		this.id = id;
	}

	/**
	 * @return the cantidadMaxima
	 */
	public Integer getCantidadMaxima() {
		return cantidadMaxima;
	}

	/**
	 * @param cantidadMaxima the cantidadMaxima to set
	 */
	public void setCantidadMaxima(Integer cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	/**
	 * @return the fechaInicio
	 */
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Timestamp getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the codigoTipoEmpaque
	 */
	public Integer getCodigoTipoEmpaque() {
		return codigoTipoEmpaque;
	}

	/**
	 * @param codigoTipoEmpaque the codigoTipoEmpaque to set
	 */
	public void setCodigoTipoEmpaque(Integer codigoTipoEmpaque) {
		this.codigoTipoEmpaque = codigoTipoEmpaque;
	}

	/**
	 * @return the valorTipoEmpaque
	 */
	public String getValorTipoEmpaque() {
		return valorTipoEmpaque;
	}

	/**
	 * @param valorTipoEmpaque the valorTipoEmpaque to set
	 */
	public void setValorTipoEmpaque(String valorTipoEmpaque) {
		this.valorTipoEmpaque = valorTipoEmpaque;
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
	 * @return the fechaRegistro
	 */
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
	 * @return the fechaModificacion
	 */
	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the usuarioRegistro
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioRegistro() {
		return usuarioRegistro;
	}

	/**
	 * @param usuarioRegistro the usuarioRegistro to set
	 */
	public void setUsuarioRegistro(ec.com.smx.frameworkv2.security.dto.UserDto usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	/**
	 * @return the usuarioModificacion
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * @return the articuloLocalPedido
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO getArticuloLocalPedido() {
		return articuloLocalPedido;
	}

	/**
	 * @param articuloLocalPedido the articuloLocalPedido to set
	 */
	public void setArticuloLocalPedido(ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO articuloLocalPedido) {
		this.articuloLocalPedido = articuloLocalPedido;
	}

	/**
	 * @return the tipoEmpaquePedido
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoEmpaquePedido() {
		return tipoEmpaquePedido;
	}

	/**
	 * @param tipoEmpaquePedido the tipoEmpaquePedido to set
	 */
	public void setTipoEmpaquePedido(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoEmpaquePedido) {
		this.tipoEmpaquePedido = tipoEmpaquePedido;
	}

	/**
	 * @return the esCreacion
	 */
	public Boolean getEsCreacion() {
		return esCreacion;
	}

	/**
	 * @param esCreacion the esCreacion to set
	 */
	public void setEsCreacion(Boolean esCreacion) {
		this.esCreacion = esCreacion;
	}
	
	
	
}
