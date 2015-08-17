package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.constants.CollectionType;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.NegociacionID;

/**
 * Clase DTO que extiende de SimpleAuditDTO, representa la tabla SCCEMTNEGOCIACION
 * del Schema DSMXSIC
 * 
 * @author khidalgo
 * 2014-09-10
*/


@Entity
@Table(name = "SCCEMTNEGOCIACION")
public class NegociacionDTO extends SearchDTO implements Serializable{
	/**
	 * Clave primaria de la tabla Convenio participante
	 */
	private static final long serialVersionUID = 7863262235394607247L;
	
	@EmbeddedId
	private NegociacionID id = new NegociacionID();
	
	@Column(name = "CODIGOVALORFORMACOBRO")
	private String codigoValorFormaCobro;
	
	@Column(name = "CODIGOTIPOFORMACOBRO")
	private Integer codigoTipoFormaCobro;
	
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
	
	@OneToMany(mappedBy="negociacionDTO")
	@CollectionTypeInfo(name=CollectionType.LIST_COLLECTION_TYPE)
	private Collection<NegociacionGestionPrecioParticipanteDTO> negociacionesGestionPrecioParticipantes;
	
	@OneToMany(mappedBy="negociacionDTO")
	@CollectionTypeInfo(name=CollectionType.LIST_COLLECTION_TYPE)
	private Collection<DetalleNegociacionDTO> detallesNegociacionDTO;

	public NegociacionID getId() {
		return id;
	}

	public void setId(NegociacionID id) {
		this.id = id;
	}

	public String getCodigoValorFormaCobro() {
		return codigoValorFormaCobro;
	}

	public void setCodigoValorFormaCobro(String codigoValorFormaCobro) {
		this.codigoValorFormaCobro = codigoValorFormaCobro;
	}

	public Integer getCodigoTipoFormaCobro() {
		return codigoTipoFormaCobro;
	}

	public void setCodigoTipoFormaCobro(Integer codigoTipoFormaCobro) {
		this.codigoTipoFormaCobro = codigoTipoFormaCobro;
	}

	public Collection<NegociacionGestionPrecioParticipanteDTO> getNegociacionesGestionPrecioParticipantes() {
		return negociacionesGestionPrecioParticipantes;
	}

	public void setNegociacionesGestionPrecioParticipantes(Collection<NegociacionGestionPrecioParticipanteDTO> negociacionesGestionPrecioParticipantes) {
		this.negociacionesGestionPrecioParticipantes = negociacionesGestionPrecioParticipantes;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Collection<DetalleNegociacionDTO> getDetallesNegociacionDTO() {
		return detallesNegociacionDTO;
	}

	public void setDetallesNegociacionDTO(Collection<DetalleNegociacionDTO> detallesNegociacionDTO) {
		this.detallesNegociacionDTO = detallesNegociacionDTO;
	}
}
