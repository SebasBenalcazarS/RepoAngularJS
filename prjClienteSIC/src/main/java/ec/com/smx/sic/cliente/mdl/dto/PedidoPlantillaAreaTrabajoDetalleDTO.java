/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.PedidoPlantillaAreaTrabajoDetalleID;

/**
 * @author jvillacis
 *
 */
@Entity
@Table(name = "SBPEATPEDPLAARETRADET")
@SuppressWarnings("serial")
public class PedidoPlantillaAreaTrabajoDetalleDTO extends SimpleAuditDTO {
	@EmbeddedId
	private PedidoPlantillaAreaTrabajoDetalleID id = new PedidoPlantillaAreaTrabajoDetalleID();
	
	@Column(name = "CODIGOPEDPLAARETRA")
	private Long codigoPedidoPlantillaAreaTrabajo;
	
	@Column(name = "CODIGOARETRAPED")
	private Integer codigoAreaTrabajoPedido;
	
	@Column(name = "CANTIDADPEDIDO")
	private Integer cantidadPedido;
	
	@Column(name = "ESTADO")
    @ComparatorTypeField
    private String estado;

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
    
    
    @ManyToOne(fetch = LAZY)
  	@JoinColumns({
  		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
  		@JoinColumn(name = "CODIGOARETRAPED", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)})
  	private AreaTrabajoDTO areaTrabajoPedido;

    @ManyToOne(fetch = LAZY)
  	@JoinColumns({
  		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
  		@JoinColumn(name = "CODIGOPEDPLAARETRA", referencedColumnName = "CODIGOPEDPLAARETRA", insertable = false, updatable = false)})
    private PedidoPlantillaAreaTrabajoDTO pedidoPlantillaAreaTrabajo;
    
	/**
	 * @return the id
	 */
	public PedidoPlantillaAreaTrabajoDetalleID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PedidoPlantillaAreaTrabajoDetalleID id) {
		this.id = id;
	}

	/**
	 * @return the codigoPedidoPlantillaAreaTrabajo
	 */
	public Long getCodigoPedidoPlantillaAreaTrabajo() {
		return codigoPedidoPlantillaAreaTrabajo;
	}

	/**
	 * @param codigoPedidoPlantillaAreaTrabajo the codigoPedidoPlantillaAreaTrabajo to set
	 */
	public void setCodigoPedidoPlantillaAreaTrabajo(Long codigoPedidoPlantillaAreaTrabajo) {
		this.codigoPedidoPlantillaAreaTrabajo = codigoPedidoPlantillaAreaTrabajo;
	}

	/**
	 * @return the codigoAreaTrabajoPedido
	 */
	public Integer getCodigoAreaTrabajoPedido() {
		return codigoAreaTrabajoPedido;
	}

	/**
	 * @param codigoAreaTrabajoPedido the codigoAreaTrabajoPedido to set
	 */
	public void setCodigoAreaTrabajoPedido(Integer codigoAreaTrabajoPedido) {
		this.codigoAreaTrabajoPedido = codigoAreaTrabajoPedido;
	}

	/**
	 * @return the cantidadPedido
	 */
	public Integer getCantidadPedido() {
		return cantidadPedido;
	}

	/**
	 * @param cantidadPedido the cantidadPedido to set
	 */
	public void setCantidadPedido(Integer cantidadPedido) {
		this.cantidadPedido = cantidadPedido;
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
	 * @return the areaTrabajoPedido
	 */
	public AreaTrabajoDTO getAreaTrabajoPedido() {
		return areaTrabajoPedido;
	}

	/**
	 * @param areaTrabajoPedido the areaTrabajoPedido to set
	 */
	public void setAreaTrabajoPedido(AreaTrabajoDTO areaTrabajoPedido) {
		this.areaTrabajoPedido = areaTrabajoPedido;
	}

	/**
	 * @return the pedidoPlantillaAreaTrabajo
	 */
	public PedidoPlantillaAreaTrabajoDTO getPedidoPlantillaAreaTrabajo() {
		return pedidoPlantillaAreaTrabajo;
	}

	/**
	 * @param pedidoPlantillaAreaTrabajo the pedidoPlantillaAreaTrabajo to set
	 */
	public void setPedidoPlantillaAreaTrabajo(PedidoPlantillaAreaTrabajoDTO pedidoPlantillaAreaTrabajo) {
		this.pedidoPlantillaAreaTrabajo = pedidoPlantillaAreaTrabajo;
	}
    
}
