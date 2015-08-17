
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.GuiaTransporteID;

/**
 * Entidad GuiaTransporteDTO para la tabla SBLOGTGUITRA
 * @author hgudino
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTGUITRA")
public class GuiaTransporteDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla GuiaTransporteDTO
	 *
	 */
	@EmbeddedId
	private GuiaTransporteID id = new GuiaTransporteID();
	
	
	/**
	 * Codigo legal de guia de transporte 
	 *
	 */
	@Column(name="CODIGOGUIA")
	private java.lang.String codigoGuia ;
	
	/**
	 * Valor de la fecha de emision 
	 *
	 */
	@Column(name="FECHAGUIA")
	private java.util.Date fechaGuia ;
	
	/**
	 * Secuencial de la tabla participante
	 * 
	 */
	@Column(name = "SECUENCIAPARTICIPANTEREGISTRO")
	private java.lang.Long secuenciaParticipanteRegistro;
	
	/**
	 * Valor del tipo de destino para guias
	 *
	 */
	@Column(name="VALORTIPODESTINO")
	private java.lang.String valorTipoDestino ;

	/**
	 * C�digo del tipo de destino para guias
	 *
	 */
	@Column(name="CODIGOTIPODESTINO")
	private java.lang.Integer codigoTipoDestino;
	
	
	/**
	 * Indica el estado del registro:[ACT] activo [INA] inactivo
	 *
	 */
	@Column(name="ESTADO")
	private java.lang.String estado ;

	/**
	 * Valor de la fecha de inicio de traslado 
	 *
	 */
	@Column(name="FECHAINICIOTRASLADO")
	private java.util.Date fechaInicioTraslado ;
	
	/**
	 * Valor de la fecha de fin de traslado 
	 *
	 */
	@Column(name="FECHAFINTRASLADO")
	private java.util.Date fechaFinTraslado ;
	
	/**
	 * Valor del tipo de motivo de traslado para guias
	 *
	 */
	@Column(name="VALORMOTIVOTRASLADO")
	private java.lang.String valorMotivoTraslado ;

	/**
	 * C�digo del tipo de motivo de traslado para guias
	 *
	 */
	@Column(name="CODIGOMOTIVOTRASLADO")
	private java.lang.Integer codigoMotivoTraslado;
				
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
	
	/**
	 * Relacion con la tabla catalogo valor para el tipo de origen
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPODESTINO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOTIPODESTINO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoDestinoDTO;
			
	/**
	 * Relacion con la tabla catalogo valor para el motivo de traslado
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORMOTIVOTRASLADO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOMOTIVOTRASLADO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO motivoTrasladoDTO;
			
	/**
	 * Coleccion de guiasTransportesDocumentos
	 */
	@OneToMany(mappedBy="guiaTransporteDTO",fetch=FetchType.LAZY)
	@CollectionTypeInfo(name = "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<GuiaTransporteDocumentoDTO> guiaTransporteDocumentoCol;
	
	/**
	 * Relacion con la tabla bitacora ruta
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="SECUENCIAPARTICIPANTEREGISTRO", insertable=false, updatable=false, referencedColumnName="SECUENCIAPARTICIPANTEREGISTRO")})
	private RutaParticipanteRegistroDTO rutaParticipanteRegistroDTO;
	
	/**
	 * Especifica el n�mero de autorizaci�n para generar la guia de remision
	 */
	@Transient
	private String npNumeroAutorizacion;
	
	
	public GuiaTransporteDTO() {
		
	}

	/**
	 * @return the id
	 */
	public GuiaTransporteID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(GuiaTransporteID id) {
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
	 * @return the codigoGuia
	 */
	public java.lang.String getCodigoGuia() {
		return codigoGuia;
	}

	/**
	 * @param codigoGuia the codigoGuia to set
	 */
	public void setCodigoGuia(java.lang.String codigoGuia) {
		this.codigoGuia = codigoGuia;
	}

	/**
	 * @return the fechaGuia
	 */
	public java.util.Date getFechaGuia() {
		return fechaGuia;
	}

	/**
	 * @param fechaGuia the fechaGuia to set
	 */
	public void setFechaGuia(java.util.Date fechaGuia) {
		this.fechaGuia = fechaGuia;
	}

	/**
	 * @return the valorTipoDestino
	 */
	public java.lang.String getValorTipoDestino() {
		return valorTipoDestino;
	}

	/**
	 * @param valorTipoDestino the valorTipoDestino to set
	 */
	public void setValorTipoDestino(java.lang.String valorTipoDestino) {
		this.valorTipoDestino = valorTipoDestino;
	}

	/**
	 * @return the codigoTipoDestino
	 */
	public java.lang.Integer getCodigoTipoDestino() {
		return codigoTipoDestino;
	}

	/**
	 * @param codigoTipoDestino the codigoTipoDestino to set
	 */
	public void setCodigoTipoDestino(java.lang.Integer codigoTipoDestino) {
		this.codigoTipoDestino = codigoTipoDestino;
	}

	/**
	 * @return the fechaInicioTraslado
	 */
	public java.util.Date getFechaInicioTraslado() {
		return fechaInicioTraslado;
	}

	/**
	 * @param fechaInicioTraslado the fechaInicioTraslado to set
	 */
	public void setFechaInicioTraslado(java.util.Date fechaInicioTraslado) {
		this.fechaInicioTraslado = fechaInicioTraslado;
	}

	/**
	 * @return the fechaFinTraslado
	 */
	public java.util.Date getFechaFinTraslado() {
		return fechaFinTraslado;
	}

	/**
	 * @param fechaFinTraslado the fechaFinTraslado to set
	 */
	public void setFechaFinTraslado(java.util.Date fechaFinTraslado) {
		this.fechaFinTraslado = fechaFinTraslado;
	}

	/**
	 * @return the valorMotivoTraslado
	 */
	public java.lang.String getValorMotivoTraslado() {
		return valorMotivoTraslado;
	}

	/**
	 * @param valorMotivoTraslado the valorMotivoTraslado to set
	 */
	public void setValorMotivoTraslado(java.lang.String valorMotivoTraslado) {
		this.valorMotivoTraslado = valorMotivoTraslado;
	}

	/**
	 * @return the codigoMotivoTraslado
	 */
	public java.lang.Integer getCodigoMotivoTraslado() {
		return codigoMotivoTraslado;
	}

	/**
	 * @param codigoMotivoTraslado the codigoMotivoTraslado to set
	 */
	public void setCodigoMotivoTraslado(java.lang.Integer codigoMotivoTraslado) {
		this.codigoMotivoTraslado = codigoMotivoTraslado;
	}


	/**
	 * @return the tipoDestinoDTO
	 */
	public CatalogoValorDTO getTipoDestinoDTO() {
		return tipoDestinoDTO;
	}

	/**
	 * @param tipoDestinoDTO the tipoDestinoDTO to set
	 */
	public void setTipoDestinoDTO(CatalogoValorDTO tipoDestinoDTO) {
		this.tipoDestinoDTO = tipoDestinoDTO;
	}

	/**
	 * @return the motivoTrasladoDTO
	 */
	public CatalogoValorDTO getMotivoTrasladoDTO() {
		return motivoTrasladoDTO;
	}

	/**
	 * @param motivoTrasladoDTO the motivoTrasladoDTO to set
	 */
	public void setMotivoTrasladoDTO(CatalogoValorDTO motivoTrasladoDTO) {
		this.motivoTrasladoDTO = motivoTrasladoDTO;
	}

	/**
	 * @return the guiaTransporteDocumentoCol
	 */
	public Collection<GuiaTransporteDocumentoDTO> getGuiaTransporteDocumentoCol() {
		return guiaTransporteDocumentoCol;
	}

	/**
	 * @param guiaTransporteDocumentoCol the guiaTransporteDocumentoCol to set
	 */
	public void setGuiaTransporteDocumentoCol(Collection<GuiaTransporteDocumentoDTO> guiaTransporteDocumentoCol) {
		this.guiaTransporteDocumentoCol = guiaTransporteDocumentoCol;
	}

	/**
	 * @return the npNumeroAutorizacion
	 */
	public String getNpNumeroAutorizacion() {
		return npNumeroAutorizacion;
	}

	/**
	 * @param npNumeroAutorizacion the npNumeroAutorizacion to set
	 */
	public void setNpNumeroAutorizacion(String npNumeroAutorizacion) {
		this.npNumeroAutorizacion = npNumeroAutorizacion;
	}

	/**
	 * @return the secuenciaParticipanteRegistro
	 */
	public java.lang.Long getSecuenciaParticipanteRegistro() {
		return secuenciaParticipanteRegistro;
	}

	/**
	 * @param secuenciaParticipanteRegistro the secuenciaParticipanteRegistro to set
	 */
	public void setSecuenciaParticipanteRegistro(java.lang.Long secuenciaParticipanteRegistro) {
		this.secuenciaParticipanteRegistro = secuenciaParticipanteRegistro;
	}

	/**
	 * @return the rutaParticipanteRegistroDTO
	 */
	public RutaParticipanteRegistroDTO getRutaParticipanteRegistroDTO() {
		return rutaParticipanteRegistroDTO;
	}

	/**
	 * @param rutaParticipanteRegistroDTO the rutaParticipanteRegistroDTO to set
	 */
	public void setRutaParticipanteRegistroDTO(RutaParticipanteRegistroDTO rutaParticipanteRegistroDTO) {
		this.rutaParticipanteRegistroDTO = rutaParticipanteRegistroDTO;
	}
	
}