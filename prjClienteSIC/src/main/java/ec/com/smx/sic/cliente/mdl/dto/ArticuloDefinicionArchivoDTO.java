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
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.ContenedorArticulo;

/**
 * Entidad que almacena diferentes definiciones de archivos, pueden ser archivos de im�genes, templetas de definiciones sobre el art�culo
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTDEFARC")
public class ArticuloDefinicionArchivoDTO extends SimpleAuditDTO implements ContenedorArticulo{

	/**
	 * identificador
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloDefinicionArchivoID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloDefinicionArchivoID();

	/**
	 * C�digo del art�culo
	 */
	@ComparatorTypeField
	private String codigoArticulo;
	
	/**
	 * Nombre del archivo del art�culo
	 * 
	 */
	private String nombreArchivo;

	/**
	 * Descripc�n del archivo del art�culo
	 * 
	 */
	private String descripcionArchivo;

	@Column(name="CODIGOREGSANART")
	@ComparatorTypeField
	private String codigoRegistroSanitarioArticulo;
	
	/**
	 * Codigo del tipo de archivo.
	 *
	 */
	private Integer codigoTipoArchivo ;
	
	/**
	 * Valor del tipo de archivo.
	Los valores pueden ser los que esten disponibles en el cat&aacute;logo, por ejemplo:
	<ul>
	<li>[IAR] Imagen del Art&iacute;culo</li>
	<li>[ICB] Imagen del C&oacute;digo de barras</li>
	<li>[IRS] Imagen del Registro Sanitario</li>
	<li>...</li>
	</ul>
	 *
	 */
	@ComparatorTypeField
	private String valorTipoArchivo ;
	
	/**
	 * Tama�o del archivo
	 * 
	 */
	private Double tamanioArchivo;

	/**
	 * Tipo de contenido que tiene el archivo
	 * 
	 */
	private String tipoContenidoArchivo;

	/**
	 * Estado del archivo, los valores permitidos son: [0] Inactivo [1] Activo
	 * 
	 */
	@ComparatorTypeField
	private String estadoArchivo;

	/**
	 * orden del archivo en la defici�n
	 */
	private Integer orden;
	
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARCHIVO", referencedColumnName="CODIGOARCHIVO", insertable=false, updatable=false)})
	private ArticuloArchivoDTO articuloArchivo;
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOREGSANART", referencedColumnName="CODIGOREGSANART", insertable=false, updatable=false)})
	private ArticuloRegistroSanitarioDTO articuloRegistroSanitario;
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOTIPOARCHIVO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO"),
		@JoinColumn(name="VALORTIPOARCHIVO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false)})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoArchivo;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloDefinicionArchivoID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloDefinicionArchivoID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>nombreArchivo</code>
	 * 
	 * @return Retorna valor de propiedad <code>nombreArchivo</code>
	 */
	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>nombreArchivo</code>.
	 * 
	 * @param nombreArchivo1
	 *            El valor a establecer para la propiedad <code>nombreArchivo</code>.
	 */
	public void setNombreArchivo(String nombreArchivo1) {
		this.nombreArchivo = nombreArchivo1;

		if (nombreArchivo != null && nombreArchivo.length() > 50) {
			nombreArchivo = nombreArchivo.substring(0, 50);
		}

	}

	/**
	 * Retorna valor de propiedad <code>descripcionArchivo</code>
	 * 
	 * @return Retorna valor de propiedad <code>descripcionArchivo</code>
	 */
	public String getDescripcionArchivo() {
		return this.descripcionArchivo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descripcionArchivo</code>.
	 * 
	 * @param descripcionArchivo1
	 *            El valor a establecer para la propiedad <code>descripcionArchivo</code>.
	 */
	public void setDescripcionArchivo(String descripcionArchivo1) {
		this.descripcionArchivo = descripcionArchivo1;

		if (descripcionArchivo != null && descripcionArchivo.length() > 200) {
			descripcionArchivo = descripcionArchivo.substring(0, 200);
		}

	}

	/**
	 * Retorna valor de propiedad <code>TamanioArchivo</code>
	 * 
	 * @return Retorna valor de propiedad <code>TamanioArchivo</code>
	 */
	public Double getTamanioArchivo() {
		return this.tamanioArchivo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>TamanioArchivo</code>.
	 * 
	 * @param tamanioArchivo1
	 *            El valor a establecer para la propiedad <code>TamanioArchivo</code>.
	 */
	public void setTamanioArchivo(Double tamanioArchivo1) {
		this.tamanioArchivo = tamanioArchivo1;

	}

	/**
	 * Retorna valor de propiedad <code>TipoContenidoArchivo</code>
	 * 
	 * @return Retorna valor de propiedad <code>TipoContenidoArchivo</code>
	 */
	public String getTipoContenidoArchivo() {
		return this.tipoContenidoArchivo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>TipoContenidoArchivo</code>.
	 * 
	 * @param tipoContenidoArchivo1
	 *            El valor a establecer para la propiedad <code>TipoContenidoArchivo</code>.
	 */
	public void setTipoContenidoArchivo(String tipoContenidoArchivo1) {
		this.tipoContenidoArchivo = tipoContenidoArchivo1;

		if (tipoContenidoArchivo != null && tipoContenidoArchivo.length() > 50) {
			tipoContenidoArchivo = tipoContenidoArchivo.substring(0, 50);
		}

	}

	/**
	 * Retorna valor de propiedad <code>estadoArchivo</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoArchivo</code>
	 */
	public String getEstadoArchivo() {
		return this.estadoArchivo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoArchivo</code>.
	 * 
	 * @param estadoArchivo1
	 *            El valor a establecer para la propiedad <code>estadoArchivo</code>.
	 */
	public void setEstadoArchivo(String estadoArchivo1) {
		this.estadoArchivo = estadoArchivo1;

		if (estadoArchivo != null && estadoArchivo.length() > 1) {
			estadoArchivo = estadoArchivo.substring(0, 1);
		}

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
	 * Retorna valor de propiedad <code>articulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>articulo</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticulo() {
		return this.articulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>articulo</code>.
	 * 
	 * @param articulo1
	 *            El valor a establecer para la propiedad <code>articulo</code>.
	 */
	public void setArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo1) {
		this.articulo = articulo1;
	}

	/**
	 * @return the articuloArchivo
	 */
	public ArticuloArchivoDTO getArticuloArchivo() {
		return articuloArchivo;
	}

	/**
	 * @param articuloArchivo the articuloArchivo to set
	 */
	public void setArticuloArchivo(ArticuloArchivoDTO articuloArchivo) {
		this.articuloArchivo = articuloArchivo;
	}

	/**
	 * @return the codigoTipoArchivo
	 */
	public Integer getCodigoTipoArchivo() {
		return codigoTipoArchivo;
	}

	/**
	 * @param codigoTipoArchivo the codigoTipoArchivo to set
	 */
	public void setCodigoTipoArchivo(Integer codigoTipoArchivo) {
		this.codigoTipoArchivo = codigoTipoArchivo;
	}

	/**
	 * @return the valorTipoArchivo
	 */
	public String getValorTipoArchivo() {
		return valorTipoArchivo;
	}

	/**
	 * @param valorTipoArchivo the valorTipoArchivo to set
	 */
	public void setValorTipoArchivo(String valorTipoArchivo) {
		this.valorTipoArchivo = valorTipoArchivo;
	}

	/**
	 * @return the tipoArchivo
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoArchivo() {
		return tipoArchivo;
	}

	/**
	 * @param tipoArchivo the tipoArchivo to set
	 */
	public void setTipoArchivo(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	/**
	 * @return the codigoRegistroSanitarioArticulo
	 */
	public String getCodigoRegistroSanitarioArticulo() {
		return codigoRegistroSanitarioArticulo;
	}

	/**
	 * @param codigoRegistroSanitarioArticulo the codigoRegistroSanitarioArticulo to set
	 */
	public void setCodigoRegistroSanitarioArticulo(String codigoRegistroSanitarioArticulo) {
		this.codigoRegistroSanitarioArticulo = codigoRegistroSanitarioArticulo;
	}

	/**
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/**
	 * @return the articuloRegistroSanitario
	 */
	public ArticuloRegistroSanitarioDTO getArticuloRegistroSanitario() {
		return articuloRegistroSanitario;
	}

	/**
	 * @param articuloRegistroSanitario the articuloRegistroSanitario to set
	 */
	public void setArticuloRegistroSanitario(ArticuloRegistroSanitarioDTO articuloRegistroSanitario) {
		this.articuloRegistroSanitario = articuloRegistroSanitario;
	}

	public Boolean getTieneArticuloArchivo(){
		return isLoaded(this.articuloArchivo);
	}

	@Override
	public ArticuloDTO getArticuloContenido() {
		return this.articulo;
	}
	
	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return this.codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

}
