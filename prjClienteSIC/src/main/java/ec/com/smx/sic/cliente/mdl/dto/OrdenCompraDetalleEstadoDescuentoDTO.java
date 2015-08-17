package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;
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

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraDetalleEstadoDescuentoID;
import ec.com.smx.sic.cliente.mdl.nopersistente.OrdenCompraDetalleEstadoDescuentoTransient;

/**
 * 
 * @author amunoz
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCORCTORDCOMDETESTDES")
public class OrdenCompraDetalleEstadoDescuentoDTO extends OrdenCompraDetalleEstadoDescuentoTransient{
	
	@EmbeddedId
	private OrdenCompraDetalleEstadoDescuentoID id =  new OrdenCompraDetalleEstadoDescuentoID();
	
	
	@Column(name = "CODIGOORDENCOMPRADETALLEESTADO", nullable=false)
	private Long codigoOrdenCompraDetalleEstado;
	
    @Column(name = "CODIGOTIPODESCUENTO", nullable=false)
    @ComparatorTypeField
    private String codigoTipoDescuento;
    
    @Column(name = "PORCENTAJEDESCUENTO", nullable=false)
    private BigDecimal porcentajeDescuento;
    
    @Column(name = "ESTADO", nullable = false)
    @ComparatorTypeField
    private String estado;
    
    @RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO", nullable=false)
    @ComparatorTypeField
    private String idUsuarioRegistro;
   
    @RegisterDateField
    @Column(name = "FECHAREGISTRO", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    
    @LastModifierUserIdField
    @Column(name = "IDUSUARIOMODIFICACION")
    @ComparatorTypeField
    private String idUsuarioModificacion;
    
    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOORDENCOMPRADETALLEESTADO", referencedColumnName = "CODIGOORDENCOMPRADETALLEESTADO", insertable = false, updatable = false)
    })
    private OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstado;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOTIPODESCUENTO", referencedColumnName = "CODIGOTIPODESCUENTO", insertable = false, updatable = false)
    })
    private TipoDescuentoDTO tipo;
    
	public OrdenCompraDetalleEstadoDescuentoID getId() {
		return id;
	}

	public void setId(OrdenCompraDetalleEstadoDescuentoID id) {
		this.id = id;
	}

	public Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}

	public void setCodigoOrdenCompraDetalleEstado(
			Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
	}

	/**
	 * @return the codigoTipoDescuento
	 */
	public String getCodigoTipoDescuento() {
		return codigoTipoDescuento;
	}

	/**
	 * @param codigoTipoDescuento the codigoTipoDescuento to set
	 */
	public void setCodigoTipoDescuento(String codigoTipoDescuento) {
		this.codigoTipoDescuento = codigoTipoDescuento;
	}

	/**
	 * @return the porcentajeDescuento
	 */
	public BigDecimal getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	/**
	 * @param porcentajeDescuento the porcentajeDescuento to set
	 */
	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the ordenCompraDetalleEstado
	 */
	public OrdenCompraDetalleEstadoDTO getOrdenCompraDetalleEstado() {
		return ordenCompraDetalleEstado;
	}

	/**
	 * @param ordenCompraDetalleEstado the ordenCompraDetalleEstado to set
	 */
	public void setOrdenCompraDetalleEstado(
			OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstado) {
		this.ordenCompraDetalleEstado = ordenCompraDetalleEstado;
	}

	/**
	 * @return the tipo
	 */
	public TipoDescuentoDTO getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoDescuentoDTO tipo) {
		this.tipo = tipo;
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

	public BigDecimal getPorcentajeDescuentoNuevo() {
		if(porcentajeDescuentoNuevo == null)
			porcentajeDescuentoNuevo = porcentajeDescuento;
		return porcentajeDescuentoNuevo;
	}
}
