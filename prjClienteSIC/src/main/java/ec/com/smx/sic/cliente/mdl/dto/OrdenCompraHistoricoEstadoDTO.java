/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraHistoricoEstadoID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCORCTORDCOMHISEST")
public class OrdenCompraHistoricoEstadoDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private OrdenCompraHistoricoEstadoID id = new OrdenCompraHistoricoEstadoID();
	
	
	@Column(name = "CANTIDADESTADO")
	private Integer cantidadEstado;
	
	@RegisterUserIdField
	@Column(name = "IDUSUARIOREGISTRO")
	private String idUsuarioRegistro;
	
	@RegisterDateField
	@Column(name = "FECHAREGISTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@LastModifierUserIdField
	@Column(name = "IDUSUARIOMODIFICACION")
	private String idUsuarioModificacion;
	
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOESTADOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOESTADOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false)
	})
	private OrdenCompraDTO ordenCompra;
	

	
	/**
	 * @return the id
	 */
	public OrdenCompraHistoricoEstadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(OrdenCompraHistoricoEstadoID id) {
		this.id = id;
	}

	/**
	 * @return the cantidadEstado
	 */
	public Integer getCantidadEstado() {
		return cantidadEstado;
	}

	/**
	 * @param cantidadEstado the cantidadEstado to set
	 */
	public void setCantidadEstado(Integer cantidadEstado) {
		this.cantidadEstado = cantidadEstado;
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
	 * @return the ordenCompra
	 */
	public OrdenCompraDTO getOrdenCompra() {
		return ordenCompra;
	}

	/**
	 * @param ordenCompra the ordenCompra to set
	 */
	public void setOrdenCompra(OrdenCompraDTO ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	/**
	 * @return the estado
	 */
	public CatalogoValorDTO getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(CatalogoValorDTO estado) {
		this.estado = estado;
	}
	
}
