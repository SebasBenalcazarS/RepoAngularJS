package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaEmpresaParticipantePromocionID;

/**
 * @author srodriguez
 * 2014-09-10
*/
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property="id")
@Entity
@Table(name="SCCEMVCONPAR")
public class VistaEmpresaParticipantePromocionDTO {
	
	@EmbeddedId
	private VistaEmpresaParticipantePromocionID id;
	
	private String codigoPromocion;
	
	private String tipoEntidad;
	
	private Long codigoEntidad;
	
	@Transient
	private String userId;
	
	@Transient
	private String evento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="TIPOENTIDAD",referencedColumnName="TIPOENTIDAD",updatable=false,insertable=false),
			@JoinColumn(name="CODIGOENTIDAD",referencedColumnName="CODIGOENTIDAD",updatable=false,insertable=false)})
	private VistaEntidadDTO participante;


	/**
	 * @return the id
	 */
    @JsonProperty("@id")
    public VistaEmpresaParticipantePromocionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaEmpresaParticipantePromocionID id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the evento
	 */
	public String getEvento() {
		return evento;
	}

	/**
	 * @param evento the evento to set
	 */
	public void setEvento(String evento) {
		this.evento = evento;
	}

	/**
	 * @return the promocion
	 */
	public String getCodigoPromocion() {
		return codigoPromocion;
	}

	/**
	 * @param promocion the promocion to set
	 */
	public void setCodigoPromocion(String promocion) {
		this.codigoPromocion = promocion;
	}
	
	

	public String getTipoEntidad() {
		return tipoEntidad;
	}

	public void setTipoEntidad(String tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

	public Long getCodigoEntidad() {
		return codigoEntidad;
	}

	public void setCodigoEntidad(Long codigoEntidad) {
		this.codigoEntidad = codigoEntidad;
	}

	/**
	 * @return the participante
	 */
	public VistaEntidadDTO getParticipante() {
		return participante;
	}

	/**
	 * @param participante the participante to set
	 */
	public void setParticipante(VistaEntidadDTO participante) {
		this.participante = participante;
	}

	
}
