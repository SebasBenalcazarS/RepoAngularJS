/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

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
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.PedidoAreaTrabajoEstadoID;

/**
 * @author jvillacis
 *
 */ 
@SuppressWarnings("serial")
@Entity
@Table(name = "SBPEATPEDARETRAEST")
public class PedidoAreaTrabajoEstadoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private PedidoAreaTrabajoEstadoID id = new PedidoAreaTrabajoEstadoID();
	
	@Column(name = "codigoPedAreTra")
	private Long codigoPedidoAreaTrabajo;
	
	@ComparatorTypeField
	@Column(name = "CODIGOESTADOCATVAL")
	private String codigoEstadoCatalogoValor;
	
	@Column(name = "CODIGOESTadoCATTIP")
	private Integer codigoEstadoCatalogoTipo;
	
	@Column(name = "FECHAINICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	
	@Column(name = "FECHAFIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;
	
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
  	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOPEDARETRA", referencedColumnName="CODIGOPEDARETRA", insertable=false, updatable=false)})
  	private PedidoAreaTrabajoDTO pedido;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;
   
    @ManyToOne(fetch = LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOESTADOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOESTADOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO estado;
    
	/**
	 * @return the id
	 */
	public PedidoAreaTrabajoEstadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PedidoAreaTrabajoEstadoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoPedidoAreaTrabajo
	 */
	public Long getCodigoPedidoAreaTrabajo() {
		return codigoPedidoAreaTrabajo;
	}

	/**
	 * @param codigoPedidoAreaTrabajo the codigoPedidoAreaTrabajo to set
	 */
	public void setCodigoPedidoAreaTrabajo(Long codigoPedidoAreaTrabajo) {
		this.codigoPedidoAreaTrabajo = codigoPedidoAreaTrabajo;
	}

	/**
	 * @return the codigoEstadoCatalogoValor
	 */
	public String getCodigoEstadoCatalogoValor() {
		return codigoEstadoCatalogoValor;
	}

	/**
	 * @param codigoEstadoCatalogoValor the codigoEstadoCatalogoValor to set
	 */
	public void setCodigoEstadoCatalogoValor(String codigoEstadoCatalogoValor) {
		this.codigoEstadoCatalogoValor = codigoEstadoCatalogoValor;
	}

	/**
	 * @return the codigoEstadoCatalogoTipo
	 */
	public Integer getCodigoEstadoCatalogoTipo() {
		return codigoEstadoCatalogoTipo;
	}

	/**
	 * @param codigoEstadoCatalogoTipo the codigoEstadoCatalogoTipo to set
	 */
	public void setCodigoEstadoCatalogoTipo(Integer codigoEstadoCatalogoTipo) {
		this.codigoEstadoCatalogoTipo = codigoEstadoCatalogoTipo;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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

	public PedidoAreaTrabajoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoAreaTrabajoDTO pedido) {
		this.pedido = pedido;
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

	/**
	 * @return the usuarioRegistroDTO
	 */
	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	/**
	 * @param usuarioRegistroDTO the usuarioRegistroDTO to set
	 */
	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	} 
	
	
}
