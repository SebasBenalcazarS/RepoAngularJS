package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;

/**
 * Especifica la relacion de un detalle seccion y una balanza para la estructura logistic
 * 
 * @author cortiz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTDETSECBAL")
public class BalanzaDetalleSeccionDTO extends AuditoriaBaseDTO{

	/**
	 * Clave primaria de la tabla BalanzaDetalleSección
	 *
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.DetalleSeccionID id = new ec.com.smx.sic.cliente.mdl.dto.id.DetalleSeccionID();
	
	@Column
	private String direccionIp;
	
	@Column
	private Integer tipoBalanza;
	
	@Column
	@ComparatorTypeField
	private String valorBalanza;
	
	@Column
	private Integer mecanismoBalanza;
	
	@Column
	@ComparatorTypeField
	private String valorMecanismoBalanza;
	
	@Column
	@ComparatorTypeField
	private String estado;

	/**
	 * Obtiene la relacion DetalleSeccionDTO
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODETALLESECCION", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false) })
	private DetalleSeccionDTO detalleSeccionDTO;
	
	/**
	 * Obtiene la relacion con el catalogo del tipo de balanzas
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORBALANZA", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="TIPOBALANZA", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoBalanzaDTO;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.DetalleSeccionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.DetalleSeccionID id) {
		this.id = id;
	}

	/**
	 * @return the direccionIp
	 */
	public String getDireccionIp() {
		return direccionIp;
	}

	/**
	 * @param direccionIp the direccionIp to set
	 */
	public void setDireccionIp(String direccionIp) {
		this.direccionIp = direccionIp;
	}

	/**
	 * @return the tipoBalanza
	 */
	public Integer getTipoBalanza() {
		return tipoBalanza;
	}

	/**
	 * @param tipoBalanza the tipoBalanza to set
	 */
	public void setTipoBalanza(Integer tipoBalanza) {
		this.tipoBalanza = tipoBalanza;
	}

	/**
	 * @return the valorBalanza
	 */
	public String getValorBalanza() {
		return valorBalanza;
	}

	/**
	 * @param valorBalanza the valorBalanza to set
	 */
	public void setValorBalanza(String valorBalanza) {
		this.valorBalanza = valorBalanza;
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
	 * @return the tipoBalanzaDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoBalanzaDTO() {
		return tipoBalanzaDTO;
	}

	/**
	 * @param tipoBalanzaDTO the tipoBalanzaDTO to set
	 */
	public void setTipoBalanzaDTO(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoBalanzaDTO) {
		this.tipoBalanzaDTO = tipoBalanzaDTO;
	}

	/**
	 * @return the detalleSeccionDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionDTO() {
		return detalleSeccionDTO;
	}

	/**
	 * @param detalleSeccionDTO the detalleSeccionDTO to set
	 */
	public void setDetalleSeccionDTO(DetalleSeccionDTO detalleSeccionDTO) {
		this.detalleSeccionDTO = detalleSeccionDTO;
	}

	/**
	 * @return the mecanismoBalanza
	 */
	public Integer getMecanismoBalanza() {
		return mecanismoBalanza;
	}

	/**
	 * @param mecanismoBalanza the mecanismoBalanza to set
	 */
	public void setMecanismoBalanza(Integer mecanismoBalanza) {
		this.mecanismoBalanza = mecanismoBalanza;
	}

	/**
	 * @return the valorMecanismoBalanza
	 */
	public String getValorMecanismoBalanza() {
		return valorMecanismoBalanza;
	}

	/**
	 * @param valorMecanismoBalanza the valorMecanismoBalanza to set
	 */
	public void setValorMecanismoBalanza(String valorMecanismoBalanza) {
		this.valorMecanismoBalanza = valorMecanismoBalanza;
	}
	
}
