package ec.com.smx.sic.cliente.mdl.dto;
import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CollectionTypeInfo;
import org.springframework.util.CollectionUtils;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;

/**
 * Entidad que almacena registros de las diferentes unidades de manejo que puede tener un art&iacute;culo
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTUNIMAN")
public class ArticuloUnidadManejoDTO extends SimpleAuditDTO {

	public static final String VALOR_UNIDAD_ANTERIOR = "VALOR.UNIDAD.ANTERIOR";
	public static final String NUEVO_REGISTRO = "NUEVO.REGISTRO";
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloUnidadManejoID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloUnidadManejoID();

	/**
	 * El identificador del registro del tipo de c&oacute;digo de barras
	 */
	@ComparatorTypeField
	@Column(name="CODIGOTIPOCODIGOARTICULO")
	private String codigoTipoCodigoArticulo;

	/**
	 * Referencia a la unidad de manejo contenida
	 * 
	 */
	@Column(name="CODIGOUNIDADMANEJOPADRE")
	private Long codigoUnidadManejoContenida;
	/**
	 * Valor del c&oacute;digo de barras del art&iacute;culo por la unidad de manejo, que puede ser un EAN14 &oacute; EAN13
	 */
	@ComparatorTypeField
	private String codigoBarrasUnidadManejo;

	/**
	 * Indica la cifra para la unidad de manejo
	 * 
	 */
	private Integer valorUnidadManejo;

	/**
	 * C&oacute;digo del tipo de unidad de empaque del cat&aacute;logo
	 * 
	 */
	@Column(name="CODIGOTIPOUNIDADEMPAQUE")
	private Integer codigoTipoUnidadEmpaque;
	
	/**
	 * Valor del tipo de unidad de empaque del cat&aacute;logo
	 * 
	 */
	@ComparatorTypeField
	@Column(name="VALORTIPOUNIDADEMPAQUE")
	private String valorTipoUnidadEmpaque;
	
	/**
	 * Descuento aplicado al precio de venta relacionado a la unidad de manejo
	 */
	private Double descuentoVenta;
	
	/**
	 * Estado de la Unidad de Manejo. Los valores permitidos son: [0] Inactivo [1] Activo
	 * 
	 */
	@ComparatorTypeField
	private String estadoUnidadManejo;
	
	/**
	 * Alto del art&iacute;culo
	 */
	private Double alto;

	/**
	 * Ancho del art&iacute;culo
	 */
	private Double ancho;

	/**
	 * profundidad del art&iacute;culo
	 */
	private Double profundidad;
	
	/**
	 * peso del art&iacute;culo
	 */
	private Double peso;
	
	/**
	 * cubicaje del art&iacute;culo
	 */
	private Double cubicaje;
	
	/**
	 * Indice de prioridad de la unidad de manejo
	 */
	private Integer prioridad;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;
	
	@Transient
	private Boolean isSelected;

	/**
	 * Id del usuario que realiz&oacute; la &uacute;ltima actualizaci&oacute;n.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;
	
	@Transient
	private String nombreValorUnidadManejo; //variable usada en Historial de cambios

	/**
	 * Fecha en la que se realiz&oacute; la &uacute;ltima actualizaci&oacute;n.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	@Transient
	private Boolean esCambioPrioridad;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;
	
	@OneToMany(mappedBy="unidadManejoContenida")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloUnidadManejoDTO> articuloUnidadManejoContenedoraCol;

	@OneToMany(mappedBy="articuloUnidadManejoDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloUnidadManejoProveedorDTO> articuloUnidadManejoProveedorCol;
	
	@OneToMany(mappedBy="articuloUnidadManejo")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloUnidadManejoUsoDTO> articuloUnidadManejoUsoCol;
	
	@OneToMany(mappedBy="articuloUnidadManejoDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ContenedorDetalleDTO> contenedorDetalleDTOCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOTIPOCODIGOARTICULO", referencedColumnName="CODIGOTIPO", insertable=false, updatable=false)})
	private TipoCodigoArticuloDTO tipoCodigoArticulo;
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOUNIDADEMPAQUE", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOUNIDADEMPAQUE", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoUnidadEmpaque;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOUNIDADMANEJOPADRE", referencedColumnName="CODIGOUNIDADMANEJO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO unidadManejoContenida;
	
	
	
	@Transient
	private ArticuloUnidadManejoDTO articuloUnidadManejoContenedora;
	
	/**
	 * Obtiene la coleccion de asignacion de articulo unidad de manejo
	 */
	@Transient
//	@OneToMany(mappedBy = "articuloUnidadManejoDTO")
//	@CollectionTypeInfo(name= "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<AsignacionArticuloUnidadManejoDTO> asignacionArticuloUnidadManejoCol;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloUnidadManejoID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloUnidadManejoID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>estadoUnidadManejo</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoUnidadManejo</code>
	 */
	public String getEstadoUnidadManejo() {
		return this.estadoUnidadManejo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoUnidadManejo</code>.
	 * 
	 * @param estadoUnidadManejo1
	 *            El valor a establecer para la propiedad <code>estadoUnidadManejo</code>.
	 */
	public void setEstadoUnidadManejo(String estadoUnidadManejo1) {
		this.estadoUnidadManejo = estadoUnidadManejo1;

		if (estadoUnidadManejo != null && estadoUnidadManejo.length() > 1) {
			estadoUnidadManejo = estadoUnidadManejo.substring(0, 1);
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
	 * @return the codigoBarrasUnidadManejo
	 */
	public String getCodigoBarrasUnidadManejo() {
		return codigoBarrasUnidadManejo;
	}

	/**
	 * @param codigoBarrasUnidadManejo the codigoBarrasUnidadManejo to set
	 */
	public void setCodigoBarrasUnidadManejo(String codigoBarrasUnidadManejo) {
		this.codigoBarrasUnidadManejo = codigoBarrasUnidadManejo;
	}

	/**
	 * @return the valorUnidadManejo
	 */
	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}

	/**
	 * @param valorUnidadManejo the valorUnidadManejo to set
	 */
	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}

	/**
	 * @return the tipoCodigoArticulo
	 */
	public TipoCodigoArticuloDTO getTipoCodigoArticulo() {
		return tipoCodigoArticulo;
	}

	/**
	 * @param tipoCodigoArticulo the tipoCodigoArticulo to set
	 */
	public void setTipoCodigoArticulo(TipoCodigoArticuloDTO tipoCodigoArticulo) {
		this.tipoCodigoArticulo = tipoCodigoArticulo;
	}

	/**
	 * @return the codigoTipoCodigoArticulo
	 */
	public String getCodigoTipoCodigoArticulo() {
		return codigoTipoCodigoArticulo;
	}

	/**
	 * @param codigoTipoCodigoArticulo the codigoTipoCodigoArticulo to set
	 */
	public void setCodigoTipoCodigoArticulo(String codigoTipoCodigoArticulo) {
		this.codigoTipoCodigoArticulo = codigoTipoCodigoArticulo;
	}

	public Double getDescuentoVenta() {
		return descuentoVenta;
	}

	public void setDescuentoVenta(Double descuentoVenta) {
		this.descuentoVenta = descuentoVenta;
	}

	/**
	 * @return the codigoTipoUnidadEmpaque
	 */
	public Integer getCodigoTipoUnidadEmpaque() {
		return codigoTipoUnidadEmpaque;
	}

	/**
	 * @param codigoTipoUnidadEmpaque the codigoTipoUnidadEmpaque to set
	 */
	public void setCodigoTipoUnidadEmpaque(Integer codigoTipoUnidadEmpaque) {
		this.codigoTipoUnidadEmpaque = codigoTipoUnidadEmpaque;
	}

	/**
	 * @return the valorTipoUnidadEmpaque
	 */
	public String getValorTipoUnidadEmpaque() {
		return valorTipoUnidadEmpaque;
	}

	/**
	 * @param valorTipoUnidadEmpaque the valorTipoUnidadEmpaque to set
	 */
	public void setValorTipoUnidadEmpaque(String valorTipoUnidadEmpaque) {
		this.valorTipoUnidadEmpaque = valorTipoUnidadEmpaque;
	}

	/**
	 * @return the tipoUnidadEmpaque
	 */
	public CatalogoValorDTO getTipoUnidadEmpaque() {
		return tipoUnidadEmpaque;
	}

	/**
	 * @param tipoUnidadEmpaque the tipoUnidadEmpaque to set
	 */
	public void setTipoUnidadEmpaque(CatalogoValorDTO tipoUnidadEmpaque) {
		this.tipoUnidadEmpaque = tipoUnidadEmpaque;
	}

	/**
	 * @return the articuloUnidadManejoUsoCol
	 */
	public Collection<ArticuloUnidadManejoUsoDTO> getArticuloUnidadManejoUsoCol() {
		return articuloUnidadManejoUsoCol;
	}

	/**
	 * @param articuloUnidadManejoUsoCol the articuloUnidadManejoUsoCol to set
	 */
	public void setArticuloUnidadManejoUsoCol(Collection<ArticuloUnidadManejoUsoDTO> articuloUnidadManejoUsoCol) {
		this.articuloUnidadManejoUsoCol = articuloUnidadManejoUsoCol;
	}
	
	public Boolean getTieneUnidadesManejoUso(){
		return isLoaded(articuloUnidadManejoUsoCol) && !CollectionUtils.isEmpty(this.articuloUnidadManejoUsoCol);
	}
	
	public Boolean getTieneUsoVenta(){
		Boolean tieneUsoVenta = Boolean.FALSE;
		if(this.getTieneUnidadesManejoUso()){
			for(ArticuloUnidadManejoUsoDTO articuloUnidadManejoUsoDTO : this.articuloUnidadManejoUsoCol){
				if(StringUtils.equals(articuloUnidadManejoUsoDTO.getEstado(), SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)
						&& StringUtils.equals(articuloUnidadManejoUsoDTO.getId().getValorTipoUso(), SICArticuloConstantes.getInstancia().VALORUSOUNIMANVENTA)){
					tieneUsoVenta = Boolean.TRUE;
					break;
				}
			}
		}
		return tieneUsoVenta;
	}
	
	public Boolean getTieneTipoUnidadEmpaque(){
		return isLoaded(tipoUnidadEmpaque) && tipoUnidadEmpaque != null;
	}
	
	public Boolean getTieneArticuloUnidadManejoContenedora(){
		return isLoaded(this.articuloUnidadManejoContenedoraCol) && !CollectionUtils.isEmpty(this.articuloUnidadManejoContenedoraCol);
	}

	public void setAsignacionArticuloUnidadManejoCol(
			Collection<AsignacionArticuloUnidadManejoDTO> asignacionArticuloUnidadManejoCol) {
		this.asignacionArticuloUnidadManejoCol = asignacionArticuloUnidadManejoCol;
	}

	public Collection<AsignacionArticuloUnidadManejoDTO> getAsignacionArticuloUnidadManejoCol() {
		return asignacionArticuloUnidadManejoCol;
	}

	/**
	 * @return the alto
	 */
	public Double getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(Double alto) {
		this.alto = alto;
	}

	/**
	 * @return the ancho
	 */
	public Double getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return the profundidad
	 */
	public Double getProfundidad() {
		return profundidad;
	}

	/**
	 * @param profundidad the profundidad to set
	 */
	public void setProfundidad(Double profundidad) {
		this.profundidad = profundidad;
	}

	/**
	 * @return the peso
	 */
	public Double getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	/**
	 * @return the unidadManejoContenida
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO getUnidadManejoContenida() {
		return unidadManejoContenida;
	}

	/**
	 * @param unidadManejoContenida the unidadManejoContenida to set
	 */
	public void setUnidadManejoContenida(ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO unidadManejoContenida) {
		this.unidadManejoContenida = unidadManejoContenida;
	}

	/**
	 * @return the articuloUnidadManejoContenedoraCol
	 */
	public Collection<ArticuloUnidadManejoDTO> getArticuloUnidadManejoContenedoraCol() {
		return articuloUnidadManejoContenedoraCol;
	}

	/**
	 * @param articuloUnidadManejoContenedoraCol the articuloUnidadManejoContenedoraCol to set
	 */
	public void setArticuloUnidadManejoContenedoraCol(Collection<ArticuloUnidadManejoDTO> articuloUnidadManejoContenedoraCol) {
		this.articuloUnidadManejoContenedoraCol = articuloUnidadManejoContenedoraCol;
	}

	/**
	 * @return the codigoUnidadManejoContenida
	 */
	public Long getCodigoUnidadManejoContenida() {
		return codigoUnidadManejoContenida;
	}

	/**
	 * @param codigoUnidadManejoContenida the codigoUnidadManejoContenida to set
	 */
	public void setCodigoUnidadManejoContenida(Long codigoUnidadManejoContenida) {
		this.codigoUnidadManejoContenida = codigoUnidadManejoContenida;
	}

	public Double getCubicaje() {
		if(this.alto != null && this.ancho != null && this.profundidad != null){
			Double cubicaje = this.alto * this.ancho * this.profundidad;
			this.cubicaje = cubicaje;
		}
		return this.cubicaje;
	}

	public void setCubicaje(Double cubicaje) {
		this.cubicaje = cubicaje;
	}

	/**
	 * @return the prioridad
	 */
	public Integer getPrioridad() {
		return prioridad;
	}

	/**
	 * @param prioridad the prioridad to set
	 */
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public Collection<ArticuloUnidadManejoProveedorDTO> getArticuloUnidadManejoProveedorCol() {
		return articuloUnidadManejoProveedorCol;
	}

	public void setArticuloUnidadManejoProveedorCol(Collection<ArticuloUnidadManejoProveedorDTO> articuloUnidadManejoProveedorCol) {
		this.articuloUnidadManejoProveedorCol = articuloUnidadManejoProveedorCol;
	}
	
	public Boolean getTieneUnidadesManejoProveedor(){
		return isLoaded(articuloUnidadManejoProveedorCol);
	}
	
	/**
	 * @return the contenedorDetalleDTOCol
	 */
	public Collection<ContenedorDetalleDTO> getContenedorDetalleDTOCol() {
		return contenedorDetalleDTOCol;
	}

	/**
	 * @param contenedorDetalleDTOCol the contenedorDetalleDTOCol to set
	 */
	public void setContenedorDetalleDTOCol(Collection<ContenedorDetalleDTO> contenedorDetalleDTOCol) {
		this.contenedorDetalleDTOCol = contenedorDetalleDTOCol;
	}
	/**
	 * @return the isSelected
	 */
	public Boolean getIsSelected() {
		return isSelected;
	}
	/**
	 * @param isSelected the isSelected to set
	 */
	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

	/**
	 * @return the articuloUnidadManejoContenedora
	 */
	public ArticuloUnidadManejoDTO getArticuloUnidadManejoContenedora() {
		return articuloUnidadManejoContenedora;
	}

	/**
	 * @param articuloUnidadManejoContenedora the articuloUnidadManejoContenedora to set
	 */
	public void setArticuloUnidadManejoContenedora(ArticuloUnidadManejoDTO articuloUnidadManejoContenedora) {
		this.articuloUnidadManejoContenedora = articuloUnidadManejoContenedora;
	}

	public String getNombreValorUnidadManejo() {
		nombreValorUnidadManejo = tipoUnidadEmpaque.getNombreCatalogoValor().concat("/").concat(valorUnidadManejo.toString());
		return nombreValorUnidadManejo;
	}

	public void setNombreValorUnidadManejo(String nombreValorUnidadManejo) {
		this.nombreValorUnidadManejo = tipoUnidadEmpaque.getNombreCatalogoValor().concat("/").concat(valorUnidadManejo.toString());
	}

	public Boolean getEsCambioPrioridad() {
		return esCambioPrioridad;
	}

	public void setEsCambioPrioridad(Boolean esCambioPrioridad) {
		this.esCambioPrioridad = esCambioPrioridad;
	}
	
}

