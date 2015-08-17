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

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.PedidoArchivoInformacionID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCORCTPEDARCINF")
public class PedidoArchivoInformacionDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private PedidoArchivoInformacionID id = new PedidoArchivoInformacionID();
	
	@Column(name = "DESCARGADO")
	@ComparatorTypeField
	private String descargado;
	
	@Column(name = "FECHADESCARGA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaDescarga;
	
	@Column(name = "IDUSUARIODESCARGA")
	private String idUsuarioDescarga;
	
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
    	@JoinColumn(name = "CODIGOARCHIVO", referencedColumnName = "CODIGOARCHIVO", insertable = false, updatable = false)
    })
    private ArchivoInformacionDTO archivoInformacion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOPEDIDO", referencedColumnName = "CODIGOPEDIDO", insertable = false, updatable = false)
    })
    private PedidoDTO pedido;

    
	/**
	 * @return the id
	 */
	public PedidoArchivoInformacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PedidoArchivoInformacionID id) {
		this.id = id;
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
	 * @return the archivoInformacion
	 */
	public ArchivoInformacionDTO getArchivoInformacion() {
		return archivoInformacion;
	}

	/**
	 * @param archivoInformacion the archivoInformacion to set
	 */
	public void setArchivoInformacion(ArchivoInformacionDTO archivoInformacion) {
		this.archivoInformacion = archivoInformacion;
	}

	/**
	 * @return the pedido
	 */
	public PedidoDTO getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the descargado
	 */
	public String getDescargado() {
		return descargado;
	}

	/**
	 * @param descargado the descargado to set
	 */
	public void setDescargado(String descargado) {
		this.descargado = descargado;
	}

	/**
	 * @return the fechaDescarga
	 */
	public Date getFechaDescarga() {
		return fechaDescarga;
	}

	/**
	 * @param fechaDescarga the fechaDescarga to set
	 */
	public void setFechaDescarga(Date fechaDescarga) {
		this.fechaDescarga = fechaDescarga;
	}

	/**
	 * @return the idUsuarioDescarga
	 */
	public String getIdUsuarioDescarga() {
		return idUsuarioDescarga;
	}

	/**
	 * @param idUsuarioDescarga the idUsuarioDescarga to set
	 */
	public void setIdUsuarioDescarga(String idUsuarioDescarga) {
		this.idUsuarioDescarga = idUsuarioDescarga;
	}
    
}
