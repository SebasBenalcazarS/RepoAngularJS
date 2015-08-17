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
import ec.com.smx.sic.cliente.mdl.dto.id.OrdenCompraFacturaImportacionID;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.FacturaImpDTO;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCORCTORDCOMFACIMP")
public class OrdenCompraFacturaImportacionDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private OrdenCompraFacturaImportacionID id = new OrdenCompraFacturaImportacionID();
	
	@Column(name = "ESTADO", nullable=false)
    private String estado;
    
    @RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO", nullable=false)
    private String idUsuarioRegistro;
   
    @RegisterDateField
    @Column(name = "FECHAREGISTRO", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
   
    @LastModifierUserIdField
    @Column(name = "IDUSUARIOMODIFICACION")
    private String idusuariomodificacion;

    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false)
    })
    private OrdenCompraDTO ordenCompra;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOFACTURA", referencedColumnName = "CODIGOFACTURA", insertable = false, updatable = false)
    })
    private FacturaImpDTO facturaImportacion;

	/**
	 * @return the id
	 */
	public OrdenCompraFacturaImportacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(OrdenCompraFacturaImportacionID id) {
		this.id = id;
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
	 * @return the fecharegistro
	 */
	public Date getFecharegistro() {
		return fecharegistro;
	}

	/**
	 * @param fecharegistro the fecharegistro to set
	 */
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	/**
	 * @return the idusuariomodificacion
	 */
	public String getIdusuariomodificacion() {
		return idusuariomodificacion;
	}

	/**
	 * @param idusuariomodificacion the idusuariomodificacion to set
	 */
	public void setIdusuariomodificacion(String idusuariomodificacion) {
		this.idusuariomodificacion = idusuariomodificacion;
	}

	/**
	 * @return the fechamodificacion
	 */
	public Date getFechamodificacion() {
		return fechamodificacion;
	}

	/**
	 * @param fechamodificacion the fechamodificacion to set
	 */
	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
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
	 * @return the facturaImportacion
	 */
	public FacturaImpDTO getFacturaImportacion() {
		return facturaImportacion;
	}

	/**
	 * @param facturaImportacion the facturaImportacion to set
	 */
	public void setFacturaImportacion(FacturaImpDTO facturaImportacion) {
		this.facturaImportacion = facturaImportacion;
	}
    
}
