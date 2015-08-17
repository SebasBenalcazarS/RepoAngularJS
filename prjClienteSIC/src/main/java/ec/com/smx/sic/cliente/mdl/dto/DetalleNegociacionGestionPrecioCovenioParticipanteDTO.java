/** ec.com.smx.sic.cliente.mdl.dto
 * DetalleNegociacionGestionPrecioCovenioParticipanteDTO.java
 * @author srodriguez
 * 23/3/2015
 */
package ec.com.smx.sic.cliente.mdl.dto;



import java.io.Serializable;
import java.sql.Timestamp;
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

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.constants.CollectionType;
import ec.com.smx.sic.cliente.mdl.dto.id.DetalleNegociacionGestionPrecioCovenioParticipanteID;

/**
 * @author srodriguez
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCCEMTDETNEGGESPRECONPAR")
public class DetalleNegociacionGestionPrecioCovenioParticipanteDTO implements Serializable{	
	
	@EmbeddedId
	private DetalleNegociacionGestionPrecioCovenioParticipanteID id = new DetalleNegociacionGestionPrecioCovenioParticipanteID();
	
	@Column(name="CODIGODETALLENEGOCIACION")
	private Long codigoDetalleNegociacion;
	
	@Column(name="CODIGONEGOCIACIONGESTIONPRECIOCONVENIOPARTICIPANTE")
	private Long codigoNegociacionGestionPrecioConvenioParticipante;
	
	@Column(name = "CONFIGURABLE")
	private Boolean configurable;
	
	@Column(name = "ESTADO")
	private Boolean estado;

	@Column(name="CODCATVALESTADOCOBRO")
	private String codigoValorEstadoCobro;
	
	@Column(name="CODCATTIPESTADOCOBRO")
	private Integer codigoTipoEstodoCobro;
	
	@Column(name="CODCATVALESTADOGENFEC")
	private String codigoValorEstadoGeneracionFechas;
	
	@Column(name="CODCATTIPESTADOGENFEC")
	private Integer codigoTipoEstadoCobroGeneracionFechas;
	
	@Column(name = "IDUSUARIOREGISTRO")
	private String idUsuarioRegistro;
	
	@Column(name = "FECHAREGISTRO")
	private Timestamp fechaRegistro;
	
	@Column(name = "IDUSUARIOMODIFICACION")
	private String idUsuarioModificacion;
	
	@Column(name = "FECHAMODIFICACION")
	private Timestamp fechaModificacion;
	
	
	/** Variable del tipo DetalleNegociacionDTO DetalleNegociacionGestionPrecioCovenioParticipanteDTO.java
	 * @author srodriguez
	 * 25/3/2015
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
	@JoinColumn(name = "CODIGODETALLENEGOCIACION", referencedColumnName = "CODIGODETALLENEGOCIACION", insertable = false, updatable = false) })
	private DetalleNegociacionDTO detalleNegociacionDTO;
	
	
	/** Variable del tipo NegociacionGestionPrecioParticipanteDTO DetalleNegociacionGestionPrecioCovenioParticipanteDTO.java
	 * @author srodriguez
	 * 25/3/2015
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA",referencedColumnName="CODIGOCOMPANIA",insertable=false,updatable=false),
		@JoinColumn(name="CODIGONEGOCIACIONGESTIONPRECIOCONVENIOPARTICIPANTE",referencedColumnName="CODIGONEGOCIACIONGESTIONPRECIOCONVENIOPARTICIPANTE",insertable=false,updatable=false)})
	private NegociacionGestionPrecioParticipanteDTO negociacionGestionPrecioParticipanteDTO;
	
	
	@OneToMany(mappedBy="detalleNegociacionGestionPrecioCovenioParticipanteDTO")
	@CollectionTypeInfo(name=CollectionType.LIST_COLLECTION_TYPE)
	private Collection<PlanFechaRegistroCobroDTO> plaFechaRegistroCobroDTOCol;
	
	/** Metodo que retorna id del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @return DetalleNegociacionGestionPrecioCovenioParticipanteID id 
	 */
	public DetalleNegociacionGestionPrecioCovenioParticipanteID getId() {
		return id;
	}

	/** Metodo que asigna el valor id en id del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @param id
	 */
	
	public void setId(DetalleNegociacionGestionPrecioCovenioParticipanteID id) {
		this.id = id;
	}

	/** Metodo que retorna configurable del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @return Boolean configurable 
	 */
	public Boolean getConfigurable() {
		return configurable;
	}

	/** Metodo que asigna el valor configurable en configurable del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @param configurable
	 */
	
	public void setConfigurable(Boolean configurable) {
		this.configurable = configurable;
	}

	/** Metodo que retorna estado del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @return Boolean estado 
	 */
	public Boolean getEstado() {
		return estado;
	}

	/** Metodo que asigna el valor estado en estado del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @param estado
	 */
	
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	/** Metodo que retorna idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @return String idUsuarioRegistro 
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/** Metodo que asigna el valor idUsuarioRegistro en idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @param idUsuarioRegistro
	 */
	
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/** Metodo que retorna fechaRegistro del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @return Timestamp fechaRegistro 
	 */
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/** Metodo que asigna el valor fechaRegistro en fechaRegistro del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @param fechaRegistro
	 */
	
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/** Metodo que retorna idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @return String idUsuarioModificacion 
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/** Metodo que asigna el valor idUsuarioModificacion en idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @param idUsuarioModificacion
	 */
	
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/** Metodo que retorna fechaModificacion del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @return Timestamp fechaModificacion 
	 */
	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/** Metodo que asigna el valor fechaModificacion en fechaModificacion del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @param fechaModificacion
	 */
	
	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/** Metodo que retorna detalleNegociacionDTO del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @return DetalleNegociacionDTO detalleNegociacionDTO 
	 */
	public DetalleNegociacionDTO getDetalleNegociacionDTO() {
		return detalleNegociacionDTO;
	}

	/** Metodo que asigna el valor detalleNegociacionDTO en detalleNegociacionDTO del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @param detalleNegociacionDTO
	 */
	
	public void setDetalleNegociacionDTO(DetalleNegociacionDTO detalleNegociacionDTO) {
		this.detalleNegociacionDTO = detalleNegociacionDTO;
	}

	/** Metodo que retorna negociacionGestionPrecioParticipanteDTO del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @return NegociacionGestionPrecioParticipanteDTO negociacionGestionPrecioParticipanteDTO 
	 */
	public NegociacionGestionPrecioParticipanteDTO getNegociacionGestionPrecioParticipanteDTO() {
		return negociacionGestionPrecioParticipanteDTO;
	}

	/** Metodo que asigna el valor negociacionGestionPrecioParticipanteDTO en negociacionGestionPrecioParticipanteDTO del objeto
	 * @author srodriguez
	 * 25/3/2015
	 * @param negociacionGestionPrecioParticipanteDTO
	 */
	
	public void setNegociacionGestionPrecioParticipanteDTO(NegociacionGestionPrecioParticipanteDTO negociacionGestionPrecioParticipanteDTO) {
		this.negociacionGestionPrecioParticipanteDTO = negociacionGestionPrecioParticipanteDTO;
	}

	public String getCodigoValorEstadoCobro() {
		return codigoValorEstadoCobro;
	}

	public void setCodigoValorEstadoCobro(String codigoValorEstadoCobro) {
		this.codigoValorEstadoCobro = codigoValorEstadoCobro;
	}

	public Integer getCodigoTipoEstodoCobro() {
		return codigoTipoEstodoCobro;
	}

	public void setCodigoTipoEstodoCobro(Integer codigoTipoEstodoCobro) {
		this.codigoTipoEstodoCobro = codigoTipoEstodoCobro;
	}

	public Collection<PlanFechaRegistroCobroDTO> getPlaFechaRegistroCobroDTOCol() {
		return plaFechaRegistroCobroDTOCol;
	}

	public void setPlaFechaRegistroCobroDTOCol(Collection<PlanFechaRegistroCobroDTO> plaFechaRegistroCobroDTOCol) {
		this.plaFechaRegistroCobroDTOCol = plaFechaRegistroCobroDTOCol;
	}

	public Long getCodigoDetalleNegociacion() {
		return codigoDetalleNegociacion;
	}

	public void setCodigoDetalleNegociacion(Long codigoDetalleNegociacion) {
		this.codigoDetalleNegociacion = codigoDetalleNegociacion;
	}

	public Long getCodigoNegociacionGestionPrecioConvenioParticipante() {
		return codigoNegociacionGestionPrecioConvenioParticipante;
	}

	public void setCodigoNegociacionGestionPrecioConvenioParticipante(Long codigoNegociacionGestionPrecioConvenioParticipante) {
		this.codigoNegociacionGestionPrecioConvenioParticipante = codigoNegociacionGestionPrecioConvenioParticipante;
	}

	public String getCodigoValorEstadoGeneracionFechas() {
		return codigoValorEstadoGeneracionFechas;
	}

	public void setCodigoValorEstadoGeneracionFechas(String codigoValorEstadoGeneracionFechas) {
		this.codigoValorEstadoGeneracionFechas = codigoValorEstadoGeneracionFechas;
	}

	public Integer getCodigoTipoEstadoCobroGeneracionFechas() {
		return codigoTipoEstadoCobroGeneracionFechas;
	}

	public void setCodigoTipoEstadoCobroGeneracionFechas(Integer codigoTipoEstadoCobroGeneracionFechas) {
		this.codigoTipoEstadoCobroGeneracionFechas = codigoTipoEstadoCobroGeneracionFechas;
	}
	
	
}
