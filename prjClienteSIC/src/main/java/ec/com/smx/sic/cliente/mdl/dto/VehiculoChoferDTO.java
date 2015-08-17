
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

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

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.VehiculoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VehiculoChoferID;

/**
 * Entidad que especifica la relacion entre vehiculo y chofer
 *
 * @author egudino
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTVEHICULOCHOFER")
public class VehiculoChoferDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla VehiculoFurgonDTO
	 *
	 */
	@EmbeddedId
	private VehiculoChoferID id = new VehiculoChoferID();
	
	/**
	 * Especifica el codigo de vehiculo cabezal
	 *
	 */
	@Column(name="CODIGOVEHICULO")
	private java.lang.Long codigoVehiculo ;
	
	@Transient
	private String tipoRegistro;
	
	/**
	 * Especifica el codigo del chofer
	 *
	 */
	@Column(name="CODIGOCHOFER")
	private java.lang.Long codigoChofer ;
	
	
	/**
	 * Valor del tipo de chofer
	 *
	 */
	@Column(name="CODIGOTIPOCHOFERVALOR")
	private String codigoTipoChoferValor ;

	/**
	 * C�digo del tipo de chofer
	 *
	 */
	@Column(name="CODIGOTIPOCHOFERTIPO")
	private Integer codigoTipoChoferTipo;
	
	
	/**
	 * Especifica la observacion
	 *
	 */
	@Column(name="OBSERVACION")
	private String observacion ;

			
	/**
	 * Indica el estado del registro:[ACT] activo [INA] inactivo
	 *
	 */
	@Column(name="ESTADO")
	private String estado ;
	
	/**
	 * Relacion con la vehiculo 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOVEHICULO", insertable=false, updatable=false, referencedColumnName="CODIGOVEHICULO")})
	private VehiculoDTO vehiculoDTO;
	
	/**
	 * Relacion con la tabla chofer 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOCHOFER", insertable=false, updatable=false, referencedColumnName="CODIGOCHOFER")})
	private ChoferDTO choferDTO;
	
	/**
	 * Relacion con la tabla chofer 
	 */	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOTIPOCHOFERVALOR", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOTIPOCHOFERTIPO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoChoferCatalogoValorDTO;
		
	
	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;
	
	/**
	 * Fecha en la que se realiza la actualizacion del registro
	 * 
	 */
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaActualizacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro;

	
	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioActualizacion;
	
	
	
		
	public VehiculoChoferDTO() {
		
	}

	/**
	 * @return the id
	 */
	public VehiculoChoferID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(VehiculoChoferID id) {
		this.id = id;
	}


	/**
	 * @return the codigoVehiculo
	 */
	public java.lang.Long getCodigoVehiculo() {
		return codigoVehiculo;
	}

	/**
	 * @param codigoVehiculo the codigoVehiculo to set
	 */
	public void setCodigoVehiculo(java.lang.Long codigoVehiculo) {
		this.codigoVehiculo = codigoVehiculo;
	}


	/**
	 * @return the codigoChofer
	 */
	public java.lang.Long getCodigoChofer() {
		return codigoChofer;
	}

	/**
	 * @param codigoChofer the codigoChofer to set
	 */
	public void setCodigoChofer(java.lang.Long codigoChofer) {
		this.codigoChofer = codigoChofer;
	}

	/**
	 * @return the codigoTipoChoferValor
	 */
	public String getCodigoTipoChoferValor() {
		return codigoTipoChoferValor;
	}

	/**
	 * @param codigoTipoChoferValor the codigoTipoChoferValor to set
	 */
	public void setCodigoTipoChoferValor(String codigoTipoChoferValor) {
		this.codigoTipoChoferValor = codigoTipoChoferValor != null ? codigoTipoChoferValor.toUpperCase() : null;		
	}

	/**
	 * @return the codigoTipoChoferTipo
	 */
	public Integer getCodigoTipoChoferTipo() {
		return codigoTipoChoferTipo;
	}

	/**
	 * @param codigoTipoChoferTipo the codigoTipoChoferTipo to set
	 */
	public void setCodigoTipoChoferTipo(Integer codigoTipoChoferTipo) {
		this.codigoTipoChoferTipo = codigoTipoChoferTipo;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion != null ? observacion.toUpperCase() : null;
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
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaActualizacion
	 */
	public java.util.Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(java.util.Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
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
	 * @return the idUsuarioActualizacion
	 */
	public String getIdUsuarioActualizacion() {
		return idUsuarioActualizacion;
	}

	/**
	 * @param idUsuarioActualizacion the idUsuarioActualizacion to set
	 */
	public void setIdUsuarioActualizacion(String idUsuarioActualizacion) {
		this.idUsuarioActualizacion = idUsuarioActualizacion;
	}

	/**
	 * @return the vehiculoDTO
	 */
	public VehiculoDTO getVehiculoDTO() {
		return vehiculoDTO;
	}

	/**
	 * @param vehiculoDTO the vehiculoDTO to set
	 */
	public void setVehiculoDTO(VehiculoDTO vehiculoDTO) {
		this.vehiculoDTO = vehiculoDTO;
	}

	/**
	 * @return the choferDTO
	 */
	public ChoferDTO getChoferDTO() {
		return choferDTO;
	}

	/**
	 * @param choferDTO the choferDTO to set
	 */
	public void setChoferDTO(ChoferDTO choferDTO) {
		this.choferDTO = choferDTO;
	}

	/**
	 * @return the tipoChoferCatalogoValorDTO
	 */
	public CatalogoValorDTO getTipoChoferCatalogoValorDTO() {
		return tipoChoferCatalogoValorDTO;
	}

	/**
	 * @param tipoChoferCatalogoValorDTO the tipoChoferCatalogoValorDTO to set
	 */
	public void setTipoChoferCatalogoValorDTO(CatalogoValorDTO tipoChoferCatalogoValorDTO) {
		this.tipoChoferCatalogoValorDTO = tipoChoferCatalogoValorDTO;
	}

	/**
	 * @return the tipoRegistro
	 */
	public String getTipoRegistro() {
		return tipoRegistro;
	}

	/**
	 * @param tipoRegistro the tipoRegistro to set
	 */
	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	
}