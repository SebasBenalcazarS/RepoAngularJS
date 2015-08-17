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

/**
 * Contiene las configuraciones de los margenes por artículo local
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTLOCMAR")
public class ArticuloLocalMargenDTO extends SimpleAuditDTO {

	/**
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLocalMargenID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLocalMargenID();

	/**
	 * Código del local
	 * 
	 */
	private Integer codigoLocal;

	/**
	 * Código del artículo
	 * 
	 */
	@ComparatorTypeField
	private String codigoArticulo;
	/**
	 * Secuencial del tipo de descuento
	 * 
	 */
	private Integer codigoTipoMargen;

	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 * 
	 */
	@ComparatorTypeField
	private String estado;

	/**
	 * Observación para el descuento aplicado
	 * 
	 */
	private String observacion;
	
	/**
	 * El precio registrado luego de aplicar el cálculo del margen
	 * 
	 */
	private Double precioBase;
	/**
	 * Fecha de inicio de activación de la configuración del margen
	 * 
	 */
	private java.util.Date fechaInicial;

	/**
	 * Fecha de fin de activación de la configuración del margen
	 * 
	 */
	private java.util.Date fechaFinal;

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

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOLOCAL", referencedColumnName="CODIGOLOCAL", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO articuloLocal;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOTIPOMARGEN", referencedColumnName="CODIGOTIPOMARGEN", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.TipoMargenDTO tipoMargen;

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLocalMargenID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLocalMargenID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>codigoLocal</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoLocal</code>
	 */
	public Integer getCodigoLocal() {
		return this.codigoLocal;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoLocal</code>.
	 * 
	 * @param codigoLocal1
	 *            El valor a establecer para la propiedad <code>codigoLocal</code>.
	 */
	public void setCodigoLocal(Integer codigoLocal1) {
		this.codigoLocal = codigoLocal1;

	}

	/**
	 * Retorna valor de propiedad <code>codigoArticulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoArticulo</code>
	 */
	public String getCodigoArticulo() {
		return this.codigoArticulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoArticulo</code>.
	 * 
	 * @param codigoArticulo1
	 *            El valor a establecer para la propiedad <code>codigoArticulo</code>.
	 */
	public void setCodigoArticulo(String codigoArticulo1) {
		this.codigoArticulo = codigoArticulo1;

		if (codigoArticulo != null && codigoArticulo.length() > 20) {
			codigoArticulo = codigoArticulo.substring(0, 20);
		}

	}

	/**
	 * Retorna valor de propiedad <code>codigoTipoMargen</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoTipoMargen</code>
	 */
	public Integer getCodigoTipoMargen() {
		return this.codigoTipoMargen;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoMargen</code>.
	 * 
	 * @param codigoTipoMargen1
	 *            El valor a establecer para la propiedad <code>codigoTipoMargen</code>.
	 */
	public void setCodigoTipoMargen(Integer codigoTipoMargen1) {
		this.codigoTipoMargen = codigoTipoMargen1;

	}

	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * 
	 * @return Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * 
	 * @param estado1
	 *            El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado(String estado1) {
		this.estado = estado1;

		if (estado != null && estado.length() > 1) {
			estado = estado.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>observacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>observacion</code>
	 */
	public String getObservacion() {
		return this.observacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>observacion</code>.
	 * 
	 * @param observacion1
	 *            El valor a establecer para la propiedad <code>observacion</code>.
	 */
	public void setObservacion(String observacion1) {
		this.observacion = observacion1;

		if (observacion != null && observacion.length() > 512) {
			observacion = observacion.substring(0, 512);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaInicial</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaInicial</code>
	 */
	public java.util.Date getFechaInicial() {
		return this.fechaInicial;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaInicial</code>.
	 * 
	 * @param fechaInicial1
	 *            El valor a establecer para la propiedad <code>fechaInicial</code>.
	 */
	public void setFechaInicial(java.util.Date fechaInicial1) {
		this.fechaInicial = fechaInicial1;

	}

	/**
	 * Retorna valor de propiedad <code>fechaFinal</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaFinal</code>
	 */
	public java.util.Date getFechaFinal() {
		return this.fechaFinal;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaFinal</code>.
	 * 
	 * @param fechaFinal1
	 *            El valor a establecer para la propiedad <code>fechaFinal</code>.
	 */
	public void setFechaFinal(java.util.Date fechaFinal1) {
		this.fechaFinal = fechaFinal1;

	}

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
	 * Retorna valor de propiedad <code>articuloLocal</code>
	 * 
	 * @return Retorna valor de propiedad <code>articuloLocal</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO getArticuloLocal() {
		return this.articuloLocal;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>articuloLocal</code>.
	 * 
	 * @param articuloLocal1
	 *            El valor a establecer para la propiedad <code>articuloLocal</code>.
	 */
	public void setArticuloLocal(ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO articuloLocal1) {
		this.articuloLocal = articuloLocal1;
	}

	/**
	 * Retorna valor de propiedad <code>tipoMargen</code>
	 * 
	 * @return Retorna valor de propiedad <code>tipoMargen</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.TipoMargenDTO getTipoMargen() {
		return this.tipoMargen;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tipoMargen</code>.
	 * 
	 * @param tipoMargen1
	 *            El valor a establecer para la propiedad <code>tipoMargen</code>.
	 */
	public void setTipoMargen(ec.com.smx.sic.cliente.mdl.dto.TipoMargenDTO tipoMargen1) {
		this.tipoMargen = tipoMargen1;
	}

	public Boolean tieneTipoMargen(){
		return isLoaded(tipoMargen) && tipoMargen != null;
	}

	/**
	 * @return the precioBase
	 */
	public Double getPrecioBase() {
		return precioBase;
	}

	/**
	 * @param precioBase the precioBase to set
	 */
	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}
	
}
