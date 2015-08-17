package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Time;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.autorizaciones.integracion.dto.AutorizacionEstado;
import ec.com.smx.corpv2.dto.OperadorLogisticoDTO;
import ec.com.smx.corpv2.plantillas.dto.ValorConfiguracionPlantillaDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * Tabla para guadar la fecha y hora de llegada para realizar la recepcion de la
 * mercaderia del proveeedor
 * 
 * @author lguaman
 */

@SuppressWarnings("serial")
@Table(name = "SBLOGTDETRECENT")
public class DetalleRecepcionEntregaDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla DetalleRecepcionEntrega
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DetalleRecepcionEntregaID id = new ec.com.smx.sic.cliente.mdl.dto.id.DetalleRecepcionEntregaID();
	
	/**
	 * FK con la tabla Operador Logistico.
	 */
	@Column(name = "CODIGOOPERADORLOGISTICO", nullable = true)
	private java.lang.Long codigoOperadorLogistico;
	
	/**
	 * FK con la tabla de los valores de las preguntas del checklist
	 */
	@Column(name = "CODIGOVALORCONFIGURACIONPLANTILLA", nullable = false)
	private Integer codigoValorConfiguracionPlantilla;
	
	/**
	 * FK con la tabla de la entrega detalle calendario proveedor.
	 */
	@Column(name = "CODIGOENTREGADETALLECALENDARIOPROVEEDOR", nullable = false)
	private java.lang.Long codigoEntregaDetalleCalendarioProveedor;
	
	/**
	 * Especifica el codigo del detalle seccion
	 *
	 */
	@Column(name = "CODIGODETALLESECCION", nullable = false)
	private java.lang.Long codigoDetalleSeccion ;		
		
	/**
	 * Placa del furgon que esta ingresando la placa
	 * 
	 */
	@Column(nullable = false)
	private String placa;
	
	/**
	 * Hora a la que para el furgon para la recepcion
	 * 
	 */
	@Column(nullable = false)
	private Time hora;
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 * 
	 */
	@ComparatorTypeField
	@Column
	private String estado;
	
	/**
	 * Catalogo del valor de configuracion recepcion NOR(Normal),IND(Industria),IMP(Importado)
	 */
	@Column(nullable=false)
	private String valorConfiguracionRecepcion;
	
	/**
	 * Código del tipo de configuracion de recepcion
	 *
	 */
	@Column(nullable=false)
	private Integer codigoConfiguracionRecepcion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name = "USUARIOREGISTRO")
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name = "USUARIOMODIFICACION")
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private java.util.Date fechaModificacion;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioModificacion;

	/**
	 * Referencia con la vista ValorConfiguracionPlantilla
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOVALORCONFIGURACIONPLANTILLA", referencedColumnName = "CODIGOVALORCONFIGURACIONPLANTILLA", insertable = false, updatable = false) })
	private ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO;
	
	/**
	 * Especifica la relacion con la seccion
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGODETALLESECCION", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false)})
	private DetalleSeccionDTO detalleSeccion;
	
	/**
	 * Especifica la relacion con la entrega detalle calendario proveedor.
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOENTREGADETALLECALENDARIOPROVEEDOR", referencedColumnName = "CODIGOENTREGADETALLECALENDARIOPROVEEDOR", insertable = false, updatable = false)})
	private EntregaDetalleCalendarioProveedorDTO entregaDetalleCalendarioProveedor;
	
	/**
	 * Especifica la relacion con el operador logistico
	 *
	 */	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOOPERADORLOGISTICO", referencedColumnName = "CODIGOOPERADORLOGISTICO", insertable = false, updatable = false)})
	private OperadorLogisticoDTO operadorLogisticoDTO;
	
	/**
	 * Referencia con la tabla DetalleRecepcionProveedor
	*/ 
	@OneToMany(mappedBy = "detalleRecepcionEntrega")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleRecepcionProveedorDTO> detalleRecepcionProveedorDTOCol;
	
	/**
	 * Referencia con la tabla DetalleRecepcionEntregaAutorizacion
	*/ 
	@OneToMany(mappedBy = "detalleRecepcionEntrega")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleRecepcionEntregaAutorizacionDTO> detalleRecepcionEntregaAutorizacionDTOCol;
	
	@Transient
	private Boolean isSelected = Boolean.FALSE;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.DetalleRecepcionEntregaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.DetalleRecepcionEntregaID id) {
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
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the usuarioCreacion
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * @param usuarioCreacion the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * @return the usuarioModificacion
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(ec.com.smx.framework.security.dto.UserDto usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * @return the valorConfiguracionPlantillaDTO
	 */
	public ValorConfiguracionPlantillaDTO getValorConfiguracionPlantillaDTO() {
		return valorConfiguracionPlantillaDTO;
	}

	/**
	 * @param valorConfiguracionPlantillaDTO the valorConfiguracionPlantillaDTO to set
	 */
	public void setValorConfiguracionPlantillaDTO(ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO) {
		this.valorConfiguracionPlantillaDTO = valorConfiguracionPlantillaDTO;
	}

	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return the hora
	 */
	public Time getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	public void setHora(Time hora) {
		this.hora = hora;
	}

	/**
	 * @return the codigoValorConfiguracionPlantilla
	 */
	public Integer getCodigoValorConfiguracionPlantilla() {
		return codigoValorConfiguracionPlantilla;
	}

	/**
	 * @param codigoValorConfiguracionPlantilla the codigoValorConfiguracionPlantilla to set
	 */
	public void setCodigoValorConfiguracionPlantilla(Integer codigoValorConfiguracionPlantilla) {
		this.codigoValorConfiguracionPlantilla = codigoValorConfiguracionPlantilla;
	}

	/**
	 * @return the codigoEntregaDetalleCalendarioProveedor
	 */
	public java.lang.Long getCodigoEntregaDetalleCalendarioProveedor() {
		return codigoEntregaDetalleCalendarioProveedor;
	}

	/**
	 * @param codigoEntregaDetalleCalendarioProveedor the codigoEntregaDetalleCalendarioProveedor to set
	 */
	public void setCodigoEntregaDetalleCalendarioProveedor(java.lang.Long codigoEntregaDetalleCalendarioProveedor) {
		this.codigoEntregaDetalleCalendarioProveedor = codigoEntregaDetalleCalendarioProveedor;
	}

	/**
	 * @return the codigoDetalleSeccion
	 */
	public java.lang.Long getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}

	/**
	 * @param codigoDetalleSeccion the codigoDetalleSeccion to set
	 */
	public void setCodigoDetalleSeccion(java.lang.Long codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}

	/**
	 * @return the entregaDetalleCalendarioProveedor
	 */
	public EntregaDetalleCalendarioProveedorDTO getEntregaDetalleCalendarioProveedor() {
		return entregaDetalleCalendarioProveedor;
	}

	/**
	 * @param entregaDetalleCalendarioProveedor the entregaDetalleCalendarioProveedor to set
	 */
	public void setEntregaDetalleCalendarioProveedor(EntregaDetalleCalendarioProveedorDTO entregaDetalleCalendarioProveedor) {
		this.entregaDetalleCalendarioProveedor = entregaDetalleCalendarioProveedor;
	}

	/**
	 * @return the detalleRecepcionProveedorDTOCol
	 */
	public Collection<DetalleRecepcionProveedorDTO> getDetalleRecepcionProveedorDTOCol() {
		return detalleRecepcionProveedorDTOCol;
	}

	/**
	 * @param detalleRecepcionProveedorDTOCol the detalleRecepcionProveedorDTOCol to set
	 */
	public void setDetalleRecepcionProveedorDTOCol(Collection<DetalleRecepcionProveedorDTO> detalleRecepcionProveedorDTOCol) {
		this.detalleRecepcionProveedorDTOCol = detalleRecepcionProveedorDTOCol;
	}

	/**
	 * @return the detalleRecepcionEntregaAutorizacionDTOCol
	 */
	public Collection<DetalleRecepcionEntregaAutorizacionDTO> getDetalleRecepcionEntregaAutorizacionDTOCol() {
		return detalleRecepcionEntregaAutorizacionDTOCol;
	}

	/**
	 * @param detalleRecepcionEntregaAutorizacionDTOCol the detalleRecepcionEntregaAutorizacionDTOCol to set
	 */
	public void setDetalleRecepcionEntregaAutorizacionDTOCol(Collection<DetalleRecepcionEntregaAutorizacionDTO> detalleRecepcionEntregaAutorizacionDTOCol) {
		this.detalleRecepcionEntregaAutorizacionDTOCol = detalleRecepcionEntregaAutorizacionDTOCol;
	}

	/**
	 * @return the detalleSeccion
	 */
	public DetalleSeccionDTO getDetalleSeccion() {
		return detalleSeccion;
	}

	/**
	 * @param detalleSeccion the detalleSeccion to set
	 */
	public void setDetalleSeccion(DetalleSeccionDTO detalleSeccion) {
		this.detalleSeccion = detalleSeccion;
	}

	/**
	 * @return the codigoOperadorLogistico
	 */
	public java.lang.Long getCodigoOperadorLogistico() {
		return codigoOperadorLogistico;
	}

	/**
	 * @param codigoOperadorLogistico the codigoOperadorLogistico to set
	 */
	public void setCodigoOperadorLogistico(java.lang.Long codigoOperadorLogistico) {
		this.codigoOperadorLogistico = codigoOperadorLogistico;
	}

	/**
	 * @return the operadorLogisticoDTO
	 */
	public OperadorLogisticoDTO getOperadorLogisticoDTO() {
		return operadorLogisticoDTO;
	}

	/**
	 * @param operadorLogisticoDTO the operadorLogisticoDTO to set
	 */
	public void setOperadorLogisticoDTO(OperadorLogisticoDTO operadorLogisticoDTO) {
		this.operadorLogisticoDTO = operadorLogisticoDTO;
	}

	/**
	 * @return the valorConfiguracionRecepcion
	 */
	public String getValorConfiguracionRecepcion() {
		return valorConfiguracionRecepcion;
	}

	/**
	 * @param valorConfiguracionRecepcion the valorConfiguracionRecepcion to set
	 */
	public void setValorConfiguracionRecepcion(String valorConfiguracionRecepcion) {
		this.valorConfiguracionRecepcion = valorConfiguracionRecepcion;
	}

	/**
	 * @return the codigoConfiguracionRecepcion
	 */
	public Integer getCodigoConfiguracionRecepcion() {
		return codigoConfiguracionRecepcion;
	}

	/**
	 * @param codigoConfiguracionRecepcion the codigoConfiguracionRecepcion to set
	 */
	public void setCodigoConfiguracionRecepcion(Integer codigoConfiguracionRecepcion) {
		this.codigoConfiguracionRecepcion = codigoConfiguracionRecepcion;
	}

	/**
	 * @return the isSelected
	 */
	public Boolean getIsSelected() {
		return isSelected;
	}

	/**
	 * @param isSelected the isSelected to set
	 */
	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public String getEstadoAutorizacion(){
		if(CollectionUtils.isNotEmpty(detalleRecepcionEntregaAutorizacionDTOCol)){
			if(detalleRecepcionEntregaAutorizacionDTOCol.iterator().next().getAutorizacionDTO().getEstadoActualAutorizacionLabel().equals(AutorizacionEstado.SOLICITADA.getLabel())){
				return AutorizacionEstado.SOLICITADA.getLabel();
			}else if(detalleRecepcionEntregaAutorizacionDTOCol.iterator().next().getAutorizacionDTO().getEstadoActualAutorizacionLabel().equals(AutorizacionEstado.AUTORIZADA.getLabel())){
				return AutorizacionEstado.AUTORIZADA.getLabel();
			}else if(detalleRecepcionEntregaAutorizacionDTOCol.iterator().next().getAutorizacionDTO().getEstadoActualAutorizacionLabel().equals(AutorizacionEstado.RECHAZADA.getLabel())){
				return AutorizacionEstado.RECHAZADA.getLabel();
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

}
