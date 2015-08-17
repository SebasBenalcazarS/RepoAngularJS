package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;

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

/**
 * Caracteristicas dinamicas para los articulos
 * 
 * @author fvillacres
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCSADTCARDIN")
public class CaracteristicaDinamicaDTO  extends SimpleAuditDTO  implements Serializable{

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.CaracteristicaDinamicaID id;

	
	
	public CaracteristicaDinamicaDTO(){
		this.id = new ec.com.smx.sic.cliente.mdl.dto.id.CaracteristicaDinamicaID();
	}
	
	private Integer codigoCompania;
	
	private String codigoClasificacion;
	
	private Long secuencialMarca;
	
	private String codigoClaseArticulo ;
	
	private Integer codigoTipoCaracteristica;
	
	private String codigoValorCaracteristica;


	/**
	 * Estado de la relacion de las caracteristicas con las clasificaciones
	 */
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizó la última actualización.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	@ComparatorTypeField
	private String esPredeterminado;


	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable=false, updatable=false),
			@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable=false, updatable=false) })
	private ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO clasificacionDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="SECUENCIALMARCA", referencedColumnName="SECUENCIALMARCA", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO marcaArticuloDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),@JoinColumn(name="CODIGOCLASEARTICULO", referencedColumnName="CODIGOCLASEARTICULO", insertable=false, updatable=false)})
	private ClaseArticuloDTO claseArticuloDTO;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOVALORCARACTERISTICA", referencedColumnName = "CODIGOCATALOGOVALOR", insertable=false, updatable=false),
			@JoinColumn(name = "CODIGOTIPOCARACTERISTICA", referencedColumnName = "CODIGOCATALOGOTIPO", insertable=false, updatable=false) })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO caracteristica;


	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion() {
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

	}

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.CaracteristicaDinamicaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.CaracteristicaDinamicaID id) {
		this.id = id;
	}

	/**
	 * @return the clasificacionDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO getClasificacionDTO() {
		return clasificacionDTO;
	}

	/**
	 * @param clasificacionDTO the clasificacionDTO to set
	 */
	public void setClasificacionDTO(
			ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO clasificacionDTO) {
		this.clasificacionDTO = clasificacionDTO;
	}
	
	/**
	 * @return the marcaArticuloDTO
	 */
	public ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO getMarcaArticuloDTO() {
		return marcaArticuloDTO;
	}

	/**
	 * @param marcaArticuloDTO the marcaArticuloDTO to set
	 */
	public void setMarcaArticuloDTO(
			ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO marcaArticuloDTO) {
		this.marcaArticuloDTO = marcaArticuloDTO;
	}

	/**
	 * @return the claseArticuloDTO
	 */
	public ClaseArticuloDTO getClaseArticuloDTO() {
		return claseArticuloDTO;
	}

	/**
	 * @param claseArticuloDTO the claseArticuloDTO to set
	 */
	public void setClaseArticuloDTO(ClaseArticuloDTO claseArticuloDTO) {
		this.claseArticuloDTO = claseArticuloDTO;
	}

	/**
	 * @return the caracteristica
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getCaracteristica() {
		return caracteristica;
	}

	/**
	 * @param caracteristica the caracteristica to set
	 */
	public void setCaracteristica(
			ec.com.smx.corpv2.dto.CatalogoValorDTO caracteristica) {
		this.caracteristica = caracteristica;
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
	 * @return the esPredeterminado
	 */
	public String getEsPredeterminado() {
		return esPredeterminado;
	}

	/**
	 * @param esPredeterminado the esPredeterminado to set
	 */
	public void setEsPredeterminado(String esPredeterminado) {
		this.esPredeterminado = esPredeterminado;
	}

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoClasificacion
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/**
	 * @param codigoClasificacion the codigoClasificacion to set
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	/**
	 * @return the secuencialMarca
	 */
	public Long getSecuencialMarca() {
		return secuencialMarca;
	}

	/**
	 * @param secuencialMarca the secuencialMarca to set
	 */
	public void setSecuencialMarca(Long secuencialMarca) {
		this.secuencialMarca = secuencialMarca;
	}

	/**
	 * @return the codigoClaseArticulo
	 */
	public String getCodigoClaseArticulo() {
		return codigoClaseArticulo;
	}

	/**
	 * @param codigoClaseArticulo the codigoClaseArticulo to set
	 */
	public void setCodigoClaseArticulo(String codigoClaseArticulo) {
		this.codigoClaseArticulo = codigoClaseArticulo;
	}

	/**
	 * @return the codigoTipoCaracteristica
	 */
	public Integer getCodigoTipoCaracteristica() {
		return codigoTipoCaracteristica;
	}

	/**
	 * @param codigoTipoCaracteristica the codigoTipoCaracteristica to set
	 */
	public void setCodigoTipoCaracteristica(Integer codigoTipoCaracteristica) {
		this.codigoTipoCaracteristica = codigoTipoCaracteristica;
	}

	/**
	 * @return the codigoValorCaracteristica
	 */
	public String getCodigoValorCaracteristica() {
		return codigoValorCaracteristica;
	}

	/**
	 * @param codigoValorCaracteristica the codigoValorCaracteristica to set
	 */
	public void setCodigoValorCaracteristica(String codigoValorCaracteristica) {
		this.codigoValorCaracteristica = codigoValorCaracteristica;
	}
}
