
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.PrefijoFurgonID;

/**
 * Especifica las caractegorias del detalle de la seccion tipo anden
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTPREFUR")
public class PrefijoFurgonDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla CategoriaDTO
	 *
	 */
	@EmbeddedId
	private PrefijoFurgonID id = new PrefijoFurgonID();
		
	/**
	 * Especifica el nombre del prefijo
	 *
	 */
	@Column(name="PREFIJO")
	private String prefijo ;
	
	/**
	 * Especifica la descripcion del prefijo del  furgon
	 *
	 */
	@Column(name="DESCRIPCION")
	private String descripcion ;
	
	/**
	 * Especifica la secuencia del prefijo
	 *
	 */
	@Column(name="SECUENCIAPREFIJO")
	private Integer secuenciaPrefijo ;
	
	/**
	 * Especifica el estado del registro
	 */
	@Column(name="ESTADO")
	@ComparatorTypeField
	private String estado ;
	
	/**
	 * Valor del tipo de furgon
	 *
	 */
	@Column(name="CONTEXTOVALOR")
	private String contextoValor ;

	/**
	 * C�digo del tipo de furgon
	 *
	 */
	@Column(name="CONTEXTOCODIGO")
	private Integer contextoCodigo;
	
	/**
	 * Especifica el codigo que maneja bodega para creacion de etiquetas
	 */
	@Column(name="CODIGOEXTERNO")
	@ComparatorTypeField
	private String codigoExterno ;		
	
	@Column(name = "NOMBRECORTO")
	@ComparatorTypeField
	private String nombreCorto;
	/**
	 * Relacion con la tabla catalogo valor para el tipo de frio
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CONTEXTOVALOR", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
	@JoinColumn(name="CONTEXTOCODIGO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO contextoCatalogoValorDTO;
	
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
	
		
	public PrefijoFurgonDTO() {
		
	}

	/**
	 * @return the id
	 */
	public PrefijoFurgonID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(PrefijoFurgonID id) {
		this.id = id;
	}

	
	/**
	 * @return the prefijo
	 */
	public String getPrefijo() {
		return prefijo;
	}

	/**
	 * @param prefijo the prefijo to set
	 */
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the secuenciaPrefijo
	 */
	public Integer getSecuenciaPrefijo() {
		return secuenciaPrefijo;
	}

	/**
	 * @param secuenciaPrefijo the secuenciaPrefijo to set
	 */
	public void setSecuenciaPrefijo(Integer secuenciaPrefijo) {
		this.secuenciaPrefijo = secuenciaPrefijo;
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
	 * @return the contextoValor
	 */
	public String getContextoValor() {
		return contextoValor;
	}

	/**
	 * @param contextoValor the contextoValor to set
	 */
	public void setContextoValor(String contextoValor) {
		this.contextoValor = contextoValor;
	}

	/**
	 * @return the contextoCodigo
	 */
	public Integer getContextoCodigo() {
		return contextoCodigo;
	}

	/**
	 * @param contextoCodigo the contextoCodigo to set
	 */
	public void setContextoCodigo(Integer contextoCodigo) {
		this.contextoCodigo = contextoCodigo;
	}

	/**
	 * @return the codigoExterno
	 */
	public String getCodigoExterno() {
		return codigoExterno;
	}

	/**
	 * @param codigoExterno the codigoExterno to set
	 */
	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
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
	 * @return the contextoCatalogoValorDTO
	 */
	public CatalogoValorDTO getContextoCatalogoValorDTO() {
		return contextoCatalogoValorDTO;
	}

	/**
	 * @param contextoCatalogoValorDTO the contextoCatalogoValorDTO to set
	 */
	public void setContextoCatalogoValorDTO(CatalogoValorDTO contextoCatalogoValorDTO) {
		this.contextoCatalogoValorDTO = contextoCatalogoValorDTO;
	}

	/**
	 * @return the nombreCorto
	 */
	public String getNombreCorto() {
		return nombreCorto;
	}

	/**
	 * @param nombreCorto the nombreCorto to set
	 */
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
}