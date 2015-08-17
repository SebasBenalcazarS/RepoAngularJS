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
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.PedidoAreaTrabajoClasificacionID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SBPEATPEDARETRACLA")
public class PedidoAreaTrabajoClasificacionDTO extends SimpleAuditDTO{
	@EmbeddedId
	private PedidoAreaTrabajoClasificacionID id = new PedidoAreaTrabajoClasificacionID();
	
	@Column(name = "PEDIRCLASIFICACION")
	@ComparatorTypeField
    private Boolean pedirClasificacion;
	
	@Column(name = "TOTALARTICULOS")
	private Integer totalArticulos;
	
	@Column(name = "TOTALARTICULOSREVISADOS")
	private Integer totalArticulosRevisados;
 
	@Column(name = "TOTALARTICULOSPEDIDOS")
	private Integer totalArticulosPedidos;
	
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
    
    @Transient
    private String descripcionClasificacion;
    
    @ManyToOne(fetch = LAZY)
  	@JoinColumns({
  		@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
  		@JoinColumn(name="CODIGOCLASIFICACION", referencedColumnName="CODIGOCLASIFICACION", insertable=false, updatable=false)})
    private ClasificacionDTO clasificacion;

    @ManyToOne(fetch = LAZY)
  	@JoinColumns({
  		@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
  		@JoinColumn(name="CODIGOPEDARETRA", referencedColumnName="CODIGOPEDARETRA", insertable=false, updatable=false)})
  	private PedidoAreaTrabajoDTO pedido;
    

    /**
	 * @return the id
	 */
	public PedidoAreaTrabajoClasificacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PedidoAreaTrabajoClasificacionID id) {
		this.id = id;
	}

	/**
	 * @return the pedirClasificacion
	 */
	public Boolean getPedirClasificacion() {
		return pedirClasificacion;
	}

	/**
	 * @param pedirClasificacion the pedirClasificacion to set
	 */
	public void setPedirClasificacion(Boolean pedirClasificacion) {
		this.pedirClasificacion = pedirClasificacion;
	}

	/**
	 * @return the totalArticulos
	 */
	public Integer getTotalArticulos() {
		return totalArticulos;
	}

	/**
	 * @param totalArticulos the totalArticulos to set
	 */
	public void setTotalArticulos(Integer totalArticulos) {
		this.totalArticulos = totalArticulos;
	}

	/**
	 * @return the totalArticulosRevisados
	 */
	public Integer getTotalArticulosRevisados() {
		return totalArticulosRevisados;
	}

	/**
	 * @param totalArticulosRevisados the totalArticulosRevisados to set
	 */
	public void setTotalArticulosRevisados(Integer totalArticulosRevisados) {
		this.totalArticulosRevisados = totalArticulosRevisados;
	}

	/**
	 * @return the totalArticulosPedidos
	 */
	public Integer getTotalArticulosPedidos() {
		return totalArticulosPedidos;
	}

	/**
	 * @param totalArticulosPedidos the totalArticulosPedidos to set
	 */
	public void setTotalArticulosPedidos(Integer totalArticulosPedidos) {
		this.totalArticulosPedidos = totalArticulosPedidos;
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
	 * @return the clasificacion
	 */
	public ClasificacionDTO getClasificacion() {
		return clasificacion;
	}

	/**
	 * @param clasificacion the clasificacion to set
	 */
	public void setClasificacion(ClasificacionDTO clasificacion) {
		this.clasificacion = clasificacion;
	}

	/**
	 * @return the pedido
	 */
	public PedidoAreaTrabajoDTO getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(PedidoAreaTrabajoDTO pedido) {
		this.pedido = pedido;
	}

	public String getDescripcionClasificacion() {
		return descripcionClasificacion;
	}

	public void setDescripcionClasificacion(String descripcionClasificacion) {
		this.descripcionClasificacion = descripcionClasificacion;
	}

}
