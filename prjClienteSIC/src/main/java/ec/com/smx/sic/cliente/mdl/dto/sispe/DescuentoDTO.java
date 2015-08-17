/*
 * Creado el 15/06/2006
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.sispe.DescuentoID;

/**
 * @author walvarez
 * 
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.sispe.DescuentoDTO")
@Table(name = "SCSPETDESCUENTO")
public class DescuentoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private DescuentoID id;

	private String codigoTipoDescuento;
	private String codigoMotivoDescuento;

	@RegisterUserIdField
	private String usuarioCreacionDescuento;
	private Double rangoInicialDescuento;

	private Double rangoFinalDescuento;

	private Double porcentajeDescuento;

	@RegisterDateField
	private Timestamp fechaCreacionDescuento;

	private String estadoDescuento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOMOTIVODESCUENTO", referencedColumnName = "CODIGOMOTIVODESCUENTO", insertable = false, updatable = false) })
	private MotivoDescuentoDTO motivoDescuentoDTO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPODESCUENTO", referencedColumnName = "CODIGOTIPODESCUENTO", insertable = false, updatable = false) })
	private TipoDescuentoDTO tipoDescuentoDTO;

	@Transient
	private String npOrderBy;

	@LastModifierUserIdField
	private String usuarioModificacion;

	@LastModificationDateField
	private java.util.Date fechaModificacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOCREACIONDESCUENTO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioModificacionDTO;


	public DescuentoDTO() {
		this.id = new DescuentoID();
	}

	public DescuentoDTO(Boolean valor) {
		this.id = new DescuentoID(valor);
	}

	/**
	 * @return Devuelve codigoMotivoDescuento.
	 */
	public String getCodigoMotivoDescuento() {
		return codigoMotivoDescuento;
	}

	/**
	 * @param codigoMotivoDescuento
	 *            El codigoMotivoDescuento a establecer.
	 */
	public void setCodigoMotivoDescuento(String codigoMotivoDescuento) {
		this.codigoMotivoDescuento = codigoMotivoDescuento;
	}

	/**
	 * @return Devuelve codigoTipoDescuento.
	 */
	public String getCodigoTipoDescuento() {
		return codigoTipoDescuento;
	}

	/**
	 * @param codigoTipoDescuento
	 *            El codigoTipoDescuento a establecer.
	 */
	public void setCodigoTipoDescuento(String codigoTipoDescuento) {
		this.codigoTipoDescuento = codigoTipoDescuento;
	}

	/**
	 * @return Devuelve estadoDescuento.
	 */
	public String getEstadoDescuento() {
		return estadoDescuento;
	}

	/**
	 * @param estadoDescuento
	 *            El estadoDescuento a establecer.
	 */
	public void setEstadoDescuento(String estadoDescuento) {
		this.estadoDescuento = estadoDescuento;
	}

	/**
	 * @return Devuelve fechaCreacionDescuento.
	 */
	public Timestamp getFechaCreacionDescuento() {
		return fechaCreacionDescuento;
	}

	/**
	 * @param fechaCreacionDescuento
	 *            El fechaCreacionDescuento a establecer.
	 */
	public void setFechaCreacionDescuento(Timestamp fechaCreacionDescuento) {
		this.fechaCreacionDescuento = fechaCreacionDescuento;
	}

	/**
	 * @return Devuelve id.
	 */
	public DescuentoID getId() {
		return id;
	}

	/**
	 * @param id
	 *            El id a establecer.
	 */
	public void setId(DescuentoID id) {
		this.id = id;
	}

	/**
	 * @return Devuelve porcentajeDescuento.
	 */
	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	/**
	 * @param porcentajeDescuento
	 *            El porcentajeDescuento a establecer.
	 */
	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	/**
	 * @return Devuelve rangoFinalDescuento.
	 */
	public Double getRangoFinalDescuento() {
		return rangoFinalDescuento;
	}

	/**
	 * @param rangoFinalDescuento
	 *            El rangoFinalDescuento a establecer.
	 */
	public void setRangoFinalDescuento(Double rangoFinalDescuento) {
		this.rangoFinalDescuento = rangoFinalDescuento;
	}

	/**
	 * @return Devuelve rangoInicialDescuento.
	 */
	public Double getRangoInicialDescuento() {
		return rangoInicialDescuento;
	}

	/**
	 * @param rangoInicialDescuento
	 *            El rangoInicialDescuento a establecer.
	 */
	public void setRangoInicialDescuento(Double rangoInicialDescuento) {
		this.rangoInicialDescuento = rangoInicialDescuento;
	}

	/**
	 * @return Devuelve usuarioCreacionDescuento.
	 */
	public String getUsuarioCreacionDescuento() {
		return usuarioCreacionDescuento;
	}

	/**
	 * @param usuarioCreacionDescuento
	 *            El usuarioCreacionDescuento a establecer.
	 */
	public void setUsuarioCreacionDescuento(String usuarioCreacionDescuento) {
		this.usuarioCreacionDescuento = usuarioCreacionDescuento;
	}

	/**
	 * @return Devuelve motivoDescuentoDTO.
	 */
	public MotivoDescuentoDTO getMotivoDescuentoDTO() {
		return motivoDescuentoDTO;
	}

	/**
	 * @param motivoDescuentoDTO
	 *            El motivoDescuentoDTO a establecer.
	 */
	public void setMotivoDescuentoDTO(MotivoDescuentoDTO motivoDescuentoDTO) {
		this.motivoDescuentoDTO = motivoDescuentoDTO;
	}

	/**
	 * @return Devuelve tipoDescuentoDTO.
	 */
	public TipoDescuentoDTO getTipoDescuentoDTO() {
		return tipoDescuentoDTO;
	}

	/**
	 * @param tipoDescuentoDTO
	 *            El tipoDescuentoDTO a establecer.
	 */
	public void setTipoDescuentoDTO(TipoDescuentoDTO tipoDescuentoDTO) {
		this.tipoDescuentoDTO = tipoDescuentoDTO;
	}

	/**
	 * @return Devuelve npOrderBy.
	 */
	public String getNpOrderBy() {
		return npOrderBy;
	}

	/**
	 * @param npOrderBy
	 *            El npOrderBy a establecer.
	 */
	public void setNpOrderBy(String npOrderBy) {
		this.npOrderBy = npOrderBy;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}

	public UserDto getUsuarioModificacionDTO() {
		return usuarioModificacionDTO;
	}

	public void setUsuarioModificacionDTO(UserDto usuarioModificacionDTO) {
		this.usuarioModificacionDTO = usuarioModificacionDTO;
	}
}
