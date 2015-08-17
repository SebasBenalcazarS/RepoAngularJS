
package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;


/**
 * Almacena todas las tareas de la estructura logistica
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCFDITDETFACEST")
public class DetalleFacturaEstadoDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DetalleFacturaEstadoID id = new ec.com.smx.sic.cliente.mdl.dto.id.DetalleFacturaEstadoID();

	@Column(name = "CODIGOFACTURAESTADO")
	private Long codigoFacturaEstado ;
	
	@Column(name = "CODIGOORDENCOMPRADETALLEESTADO")
	private Long codigoOrdenCompraDetalleEstado;

	@Column(name = "ESTADO")
	@ComparatorTypeField
	private String estado ;
	
	@Column(name = "CANTIDAD")
    private Integer cantidad;
	
	@Column(name = "PRECIO")
    private BigDecimal precio;
	
	@Column(name = "TOTAL")
    private BigDecimal total;
	
	@Column(name = "COSTOPROVEEDOR")
    private BigDecimal costoProveedor;
	
	@Column(name = "PESOPROVEEDOR")
    private BigDecimal pesoProveedor;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;
	
	/**
	 * Fecha en la que se realizó la última actualización.
	 * 
	 */
	@LastModificationDateField
	@Column(name="FECHAACTUALIZACION")
	private java.sql.Timestamp fechaModificacion;
	
	/**
	 * Referencia con la tabla FacturaEstadoDTO
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOFACTURAESTADO", referencedColumnName = "CODIGOFACTURAESTADO", insertable = false, updatable = false)
    })
    private FacturaEstadoDTO facturaEstadoDTO;
	
	/**
	 * Referencia con la tabla OrdenCompraDetalleEstadoDTO
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOORDENCOMPRADETALLEESTADO", referencedColumnName = "CODIGOORDENCOMPRADETALLEESTADO", insertable = false, updatable = false)
    })
    private OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO;

	
	
	/**
	 * Referencia diferencia proceso logistico 
	 */
	@OneToMany(mappedBy = "detalleFacturaEstado", fetch = FetchType.LAZY)
	private Collection<DiferenciaProcesoLogisticoDTO> diferenciaProcesoLogisticoCol;
	
	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.DetalleFacturaEstadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.DetalleFacturaEstadoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoFacturaEstado
	 */
	public Long getCodigoFacturaEstado() {
		return codigoFacturaEstado;
	}

	/**
	 * @param codigoFacturaEstado the codigoFacturaEstado to set
	 */
	public void setCodigoFacturaEstado(Long codigoFacturaEstado) {
		this.codigoFacturaEstado = codigoFacturaEstado;
	}

	/**
	 * @return the codigoOrdenCompraDetalleEstado
	 */
	public Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}

	/**
	 * @param codigoOrdenCompraDetalleEstado the codigoOrdenCompraDetalleEstado to set
	 */
	public void setCodigoOrdenCompraDetalleEstado(
			Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
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
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the precio
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * @return the idUsuarioRegistro
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
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
	 * @return the idUsuarioModificacion
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
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

	/**
	 * @return the facturaEstadoDTO
	 */
	public FacturaEstadoDTO getFacturaEstadoDTO() {
		return facturaEstadoDTO;
	}

	/**
	 * @param facturaEstadoDTO the facturaEstadoDTO to set
	 */
	public void setFacturaEstadoDTO(FacturaEstadoDTO facturaEstadoDTO) {
		this.facturaEstadoDTO = facturaEstadoDTO;
	}

	/**
	 * @return the ordenCompraDetalleEstadoDTO
	 */
	public OrdenCompraDetalleEstadoDTO getOrdenCompraDetalleEstadoDTO() {
		return ordenCompraDetalleEstadoDTO;
	}

	/**
	 * @param ordenCompraDetalleEstadoDTO the ordenCompraDetalleEstadoDTO to set
	 */
	public void setOrdenCompraDetalleEstadoDTO(
			OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO) {
		this.ordenCompraDetalleEstadoDTO = ordenCompraDetalleEstadoDTO;
	}

	/**
	 * @return the costoProveedor
	 */
	public BigDecimal getCostoProveedor() {
		return costoProveedor;
	}

	/**
	 * @param costoProveedor the costoProveedor to set
	 */
	public void setCostoProveedor(BigDecimal costoProveedor) {
		this.costoProveedor = costoProveedor;
	}

	/**
	 * @return the pesoProveedor
	 */
	public BigDecimal getPesoProveedor() {
		return pesoProveedor;
	}

	/**
	 * @param pesoProveedor the pesoProveedor to set
	 */
	public void setPesoProveedor(BigDecimal pesoProveedor) {
		this.pesoProveedor = pesoProveedor;
	}

	public Collection<DiferenciaProcesoLogisticoDTO> getDiferenciaProcesoLogisticoCol() {
		return diferenciaProcesoLogisticoCol;
	}

	public void setDiferenciaProcesoLogisticoCol(Collection<DiferenciaProcesoLogisticoDTO> diferenciaProcesoLogisticoCol) {
		this.diferenciaProcesoLogisticoCol = diferenciaProcesoLogisticoCol;
	}
	
}