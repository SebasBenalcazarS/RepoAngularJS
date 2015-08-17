/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.PedidoPlantillaID;

/**
 * @author jvillacis
 *
 */
@Entity
@Table(name = "SCORCTPEDPLA")
@SuppressWarnings("serial")
public class PedidoPlantillaDTO extends SimpleAuditDTO{
	@EmbeddedId
	private PedidoPlantillaID id = new PedidoPlantillaID();
	
	@Column(name = "CODIGOAREATRABAJOPEDIDO")
	private Integer codigoAreaTrabajoPedido;
	
	@Column(name = "CODIGOSUBBODEGA")
	private String codigoSubbodega;
	
	@Column(name = "CODIGODIASEMANA")
	private Integer codigoDiaSemana;
	
	@Column(name = "ESTADO", nullable = false)
    private String estado;
    
    @RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO", nullable = false)
    private String idUsuarioRegistro;
    
    @RegisterDateField
    @Column(name = "FECHAREGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
  
    @LastModifierUserIdField	
    @Column(name = "IDUSUARIOMODIFICACION")
    private String idUsarioModificacion;
    
    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOAREATRABAJOPEDIDO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)
    })
    private AreaTrabajoDTO areaTrabajoPedido; 
    
    @OneToMany(mappedBy = "pedidoPlantilla")
    @CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<PedidoPlantillaDetalleDTO> pedidoPlantillaDetalleCol;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOSUBBODEGA", referencedColumnName = "CODIGOBODEGA", insertable = false, updatable = false)
    })
    private BodegaDTO subbodega;
    

    
    /**
	 * @return the id
	 */
	public PedidoPlantillaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PedidoPlantillaID id) {
		this.id = id;
	}

	/**
	 * @return the codigoDiaSemana
	 */
	public Integer getCodigoDiaSemana() {
		return codigoDiaSemana;
	}

	/**
	 * @param codigoDiaSemana the codigoDiaSemana to set
	 */
	public void setCodigoDiaSemana(Integer codigoDiaSemana) {
		this.codigoDiaSemana = codigoDiaSemana;
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
	 * @return the idUsarioModificacion
	 */
	public String getIdUsarioModificacion() {
		return idUsarioModificacion;
	}

	/**
	 * @param idUsarioModificacion the idUsarioModificacion to set
	 */
	public void setIdUsarioModificacion(String idUsarioModificacion) {
		this.idUsarioModificacion = idUsarioModificacion;
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
	 * @return the codigoSubbodega
	 */
	public String getCodigoSubbodega() {
		return codigoSubbodega;
	}

	/**
	 * @param codigoSubbodega the codigoSubbodega to set
	 */
	public void setCodigoSubbodega(String codigoSubbodega) {
		this.codigoSubbodega = codigoSubbodega;
	}

	/**
	 * @return the subbodega
	 */
	public BodegaDTO getSubbodega() {
		return subbodega;
	}

	/**
	 * @param subbodega the subbodega to set
	 */
	public void setSubbodega(BodegaDTO subbodega) {
		this.subbodega = subbodega;
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
	 * @return the pedidoPlantillaDetalleCol
	 */
	public Collection<PedidoPlantillaDetalleDTO> getPedidoPlantillaDetalleCol() {
		return pedidoPlantillaDetalleCol;
	}

	/**
	 * @param pedidoPlantillaDetalleCol the pedidoPlantillaDetalleCol to set
	 */
	public void setPedidoPlantillaDetalleCol(Collection<PedidoPlantillaDetalleDTO> pedidoPlantillaDetalleCol) {
		this.pedidoPlantillaDetalleCol = pedidoPlantillaDetalleCol;
	}
    
}
