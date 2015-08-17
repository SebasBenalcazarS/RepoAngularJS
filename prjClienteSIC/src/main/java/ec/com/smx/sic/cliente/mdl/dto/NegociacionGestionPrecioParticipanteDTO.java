package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
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

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.constants.CollectionType;
import ec.com.smx.sic.cliente.mdl.dto.id.NegociacionGestionPrecioParticipanteID;

/**
 * @author cbarahona
 *
 */
@Entity
@Table(name = "SCCEMTNEGGESPRECONPAR")
@SuppressWarnings("serial")
public class NegociacionGestionPrecioParticipanteDTO implements Serializable {
	@EmbeddedId
	private NegociacionGestionPrecioParticipanteID id = new NegociacionGestionPrecioParticipanteID();
	
	@Column(name = "CODIGONEGOCIACION")
	private Long codigoNegociacion;
	
	@Column(name = "CODIGOPARTICIPACION")
	private Long codigoParticipacion;
	
	@Column(name = "CODIGOGESTIONPRECIO")
	private Long codigoGestionPrecio;

	@Column(name="AGRUPADOR")
	private String agrupador;
	
	@Column(name="ESTADOMOTORPROMOCION")
	private Boolean estadoMotorPromocion;
	
	@Column(name = "ESTADO")
	private Boolean estado;

	@Column(name = "IDUSUARIOREGISTRO")
	private String idUsuarioRegistro;
	
	@Column(name = "FECHAREGISTRO")
	private Date fechaRegistro;
	
	@Column(name = "IDUSUARIOMODIFICACION")
	private String idUsuarioModificacion;
	
	@Column(name = "FECHAMODIFICACION")
	private Date fechaModificacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA",referencedColumnName="CODIGOCOMPANIA",insertable=false,updatable=false),
		@JoinColumn(name="CODIGONEGOCIACION",referencedColumnName="CODIGONEGOCIACION",insertable=false,updatable=false)})
	private NegociacionDTO negociacionDTO;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA",referencedColumnName="CODIGOCOMPANIA",insertable=false,updatable=false),
		@JoinColumn(name="CODIGOPARTICIPACION",referencedColumnName="CODIGOPARTICIPACION",insertable=false,updatable=false)})
	private ConvenioParticipanteDTO convenioParticipanteDTO;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA",referencedColumnName="CODIGOCOMPANIA",insertable=false,updatable=false),
		@JoinColumn(name="CODIGOGESTIONPRECIO",referencedColumnName="CODIGOGESTIONPRECIO",insertable=false,updatable=false)})
	private GestionPrecioDTO gestionPrecioDTO;
	
	@OneToMany(mappedBy="negociacionGestionPrecioParticipanteDTO")
	@CollectionTypeInfo(name=CollectionType.LIST_COLLECTION_TYPE)
	private Collection<DetalleNegociacionGestionPrecioCovenioParticipanteDTO> detalleNegociacionGestionPrecioCovenioParticipanteDTOCol;
	
	public NegociacionGestionPrecioParticipanteID getId() {
		return id;
	}

	public void setId(NegociacionGestionPrecioParticipanteID id) {
		this.id = id;
	}

	public Long getCodigoNegociacion() {
		return codigoNegociacion;
	}

	public void setCodigoNegociacion(Long codigoNegociacion) {
		this.codigoNegociacion = codigoNegociacion;
	}

	public Long getCodigoParticipacion() {
		return codigoParticipacion;
	}

	public void setCodigoParticipacion(Long codigoParticipacion) {
		this.codigoParticipacion = codigoParticipacion;
	}

	public Long getCodigoGestionPrecio() {
		return codigoGestionPrecio;
	}

	public void setCodigoGestionPrecio(Long codigoGestionPrecio) {
		this.codigoGestionPrecio = codigoGestionPrecio;
	}

	public Boolean getEstadoMotorPromocion() {
		return estadoMotorPromocion;
	}

	public void setEstadoMotorPromocion(Boolean estadoMotorPromocion) {
		this.estadoMotorPromocion = estadoMotorPromocion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
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

	public NegociacionDTO getNegociacionDTO() {
		return negociacionDTO;
	}

	public void setNegociacionDTO(NegociacionDTO negociacionDTO) {
		this.negociacionDTO = negociacionDTO;
	}

	public ConvenioParticipanteDTO getConvenioParticipanteDTO() {
		return convenioParticipanteDTO;
	}

	public void setConvenioParticipanteDTO(ConvenioParticipanteDTO convenioParticipanteDTO) {
		this.convenioParticipanteDTO = convenioParticipanteDTO;
	}

	public GestionPrecioDTO getGestionPrecioDTO() {
		return gestionPrecioDTO;
	}

	public void setGestionPrecioDTO(GestionPrecioDTO gestionPrecioDTO) {
		this.gestionPrecioDTO = gestionPrecioDTO;
	}

	public String getAgrupador() {
		return agrupador;
	}

	public void setAgrupador(String agrupador) {
		this.agrupador = agrupador;
	}

	public Collection<DetalleNegociacionGestionPrecioCovenioParticipanteDTO> getDetalleNegociacionGestionPrecioCovenioParticipanteDTOCol() {
		return detalleNegociacionGestionPrecioCovenioParticipanteDTOCol;
	}

	public void setDetalleNegociacionGestionPrecioCovenioParticipanteDTOCol(Collection<DetalleNegociacionGestionPrecioCovenioParticipanteDTO> detalleNegociacionGestionPrecioCovenioParticipanteDTOCol) {
		this.detalleNegociacionGestionPrecioCovenioParticipanteDTOCol = detalleNegociacionGestionPrecioCovenioParticipanteDTOCol;
	}
}

