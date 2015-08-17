/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.TransporteID;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTTRANSPORTE")
public class TransporteDTO extends SimpleAuditDTO{

	@EmbeddedId
	private TransporteID id = new TransporteID();
	private String nombreTransporte;
	@ComparatorTypeField
	private String valorTipoTransporte;
	private Integer codigoTipoTransporte;
	private Integer cantidadBultos;
	private Integer cantidadExedenteBultos;
	@ComparatorTypeField
	private String valorTipoMercaderia;
	private Integer codigoTipoMercaderia;
	/**
	 * Especifica el usuario que realiza el registro.
	 */
	@RegisterUserIdField
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realizó la última actualización.
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizó la última actualización.
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOTRANSPORTE", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOTRANSPORTE", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoTransporte;
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOMERCADERIA", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOMERCADERIA", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoMercaderiaTransportada;
	
	/**
	 * @return the id
	 */
	public TransporteID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(TransporteID id) {
		this.id = id;
	}

	/**
	 * @return the nombreTransporte
	 */
	public String getNombreTransporte() {
		return nombreTransporte;
	}

	/**
	 * @param nombreTransporte the nombreTransporte to set
	 */
	public void setNombreTransporte(String nombreTransporte) {
		this.nombreTransporte = nombreTransporte;
	}

	/**
	 * @return the valorTipoTransporte
	 */
	public String getValorTipoTransporte() {
		return valorTipoTransporte;
	}

	/**
	 * @param valorTipoTransporte the valorTipoTransporte to set
	 */
	public void setValorTipoTransporte(String valorTipoTransporte) {
		this.valorTipoTransporte = valorTipoTransporte;
	}

	/**
	 * @return the codigoTipoTransporte
	 */
	public Integer getCodigoTipoTransporte() {
		return codigoTipoTransporte;
	}

	/**
	 * @param codigoTipoTransporte the codigoTipoTransporte to set
	 */
	public void setCodigoTipoTransporte(Integer codigoTipoTransporte) {
		this.codigoTipoTransporte = codigoTipoTransporte;
	}

	/**
	 * @return the cantidadBultos
	 */
	public Integer getCantidadBultos() {
		return cantidadBultos;
	}

	/**
	 * @param cantidadBultos the cantidadBultos to set
	 */
	public void setCantidadBultos(Integer cantidadBultos) {
		this.cantidadBultos = cantidadBultos;
	}

	/**
	 * @return the cantidadExedenteBultos
	 */
	public Integer getCantidadExedenteBultos() {
		return cantidadExedenteBultos;
	}

	/**
	 * @param cantidadExedenteBultos the cantidadExedenteBultos to set
	 */
	public void setCantidadExedenteBultos(Integer cantidadExedenteBultos) {
		this.cantidadExedenteBultos = cantidadExedenteBultos;
	}

	/**
	 * @return the valorTipoMercaderia
	 */
	public String getValorTipoMercaderia() {
		return valorTipoMercaderia;
	}

	/**
	 * @param valorTipoMercaderia the valorTipoMercaderia to set
	 */
	public void setValorTipoMercaderia(String valorTipoMercaderia) {
		this.valorTipoMercaderia = valorTipoMercaderia;
	}

	/**
	 * @return the codigoTipoMercaderia
	 */
	public Integer getCodigoTipoMercaderia() {
		return codigoTipoMercaderia;
	}

	/**
	 * @param codigoTipoMercaderia the codigoTipoMercaderia to set
	 */
	public void setCodigoTipoMercaderia(Integer codigoTipoMercaderia) {
		this.codigoTipoMercaderia = codigoTipoMercaderia;
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
	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
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
	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the tipoTransporte
	 */
	public CatalogoValorDTO getTipoTransporte() {
		return tipoTransporte;
	}

	/**
	 * @param tipoTransporte the tipoTransporte to set
	 */
	public void setTipoTransporte(CatalogoValorDTO tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	/**
	 * @return the tipoMercaderiaTransportada
	 */
	public CatalogoValorDTO getTipoMercaderiaTransportada() {
		return tipoMercaderiaTransportada;
	}

	/**
	 * @param tipoMercaderiaTransportada the tipoMercaderiaTransportada to set
	 */
	public void setTipoMercaderiaTransportada(CatalogoValorDTO tipoMercaderiaTransportada) {
		this.tipoMercaderiaTransportada = tipoMercaderiaTransportada;
	}
}
