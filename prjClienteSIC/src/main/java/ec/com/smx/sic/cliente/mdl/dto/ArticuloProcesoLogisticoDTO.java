package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * Contiene informaci�n para el despacho de una art�culo
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTDES")
public class ArticuloProcesoLogisticoDTO extends SimpleAuditDTO{

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProcesoLogisticoID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProcesoLogisticoID();

	/**
	 * C�digo del tipo de unidad de manejo del cat�logo
	 * 
	 */
	private Integer codigoTipoDistribucion;

	/**
	 * Valor del tipo de unidad de manejo del cat�logo
	 * 
	 */
	private String valorTipoDistribucion;
	
	/**
	 * C�digo tipo para la ubicacion de despacho(Arriba, Medio, Abajo)
	 * 
	 */
	private Integer codigoTipoUbicacionDespacho;

	/**
	 * Valor para la ubicacion de despacho(Arriba, Medio, Abajo)
	 * 
	 */
	private String valorTipoUbicacionDespacho;

	/**
	 * C�digo del tipo de empaque de distribucion
	 * 
	 */
	@Column(name="CODCONDIS")
	private Integer codigoContenedorDistribucion;

	/**
	 * Valor del tipo de empaque de distribucion
	 * 
	 */
	@Column(name="VALCONDIS")
	private String valorContenedorDistribucion;

	/**
	 * Indica si el producto se recibe con PESO TARA (peso del contenedor � empaque sin incluir el peso del producto)
	 */
	private Boolean tieneTara;
	
	/**
	 * Valor del tipo de cat&aacute;logo para el &aacute;rea de conservaci&oacute;n de la bodega
	 * 
	 */
	@Column(name="VALARECONBOD")
	private String valorAreaConservacionBodega;

	/**
	 * C&oacute;digo del tipo de cat&aacute;logo para el �rea de conservaci&oacute;n de la bodega
	 * 
	 */
	@Column(name="CODARECONBOD")
	private Integer codigoAreaConservacionBodega;

	private Integer codigoIndicadorPropietario;
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
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPODISTRIBUCION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPODISTRIBUCION", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoDistribucion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALCONDIS", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODCONDIS", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO contenedorDistribucion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALARECONBOD", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODARECONBOD", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO areaConservacionBodega;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOUBICACIONDESPACHO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOUBICACIONDESPACHO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoUbicacionDespacho;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOINDICADORPROPIETARIO", insertable=false, updatable=false, referencedColumnName="CODIGOINDICADORPROPIETARIO")})
	private IndicadorPropietarioDTO indicadorPropietarioDTO;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProcesoLogisticoID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProcesoLogisticoID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>codigoTipoDistribucion</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoTipoDistribucion</code>
	 */
	public Integer getCodigoTipoDistribucion() {
		return this.codigoTipoDistribucion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoDistribucion</code>.
	 * 
	 * @param codigoTipoDistribucion1
	 *            El valor a establecer para la propiedad <code>codigoTipoDistribucion</code>.
	 */
	public void setCodigoTipoDistribucion(Integer codigoTipoDistribucion1) {
		this.codigoTipoDistribucion = codigoTipoDistribucion1;

	}

	/**
	 * Retorna valor de propiedad <code>valorTipoDistribucion</code>
	 * 
	 * @return Retorna valor de propiedad <code>valorTipoDistribucion</code>
	 */
	public String getValorTipoDistribucion() {
		return this.valorTipoDistribucion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>valorTipoDistribucion</code>.
	 * 
	 * @param valorTipoDistribucion1
	 *            El valor a establecer para la propiedad <code>valorTipoDistribucion</code>.
	 */
	public void setValorTipoDistribucion(String valorTipoDistribucion1) {
		this.valorTipoDistribucion = valorTipoDistribucion1;

		if (valorTipoDistribucion != null && valorTipoDistribucion.length() > 3) {
			valorTipoDistribucion = valorTipoDistribucion.substring(0, 3);
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
	 * Retorna valor de propiedad <code>tipoDistribucion</code>
	 * 
	 * @return Retorna valor de propiedad <code>tipoDistribucion</code>
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoDistribucion() {
		return this.tipoDistribucion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tipoDistribucion</code>.
	 * 
	 * @param tipoDistribucion1
	 *            El valor a establecer para la propiedad <code>tipoDistribucion</code>.
	 */
	public void setTipoDistribucion(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoDistribucion1) {
		this.tipoDistribucion = tipoDistribucion1;
	}

	/**
	 * @return the codigoContenedorDistribucion
	 */
	public Integer getCodigoContenedorDistribucion() {
		return codigoContenedorDistribucion;
	}

	/**
	 * @param codigoContenedorDistribucion the codigoContenedorDistribucion to set
	 */
	public void setCodigoContenedorDistribucion(Integer codigoContenedorDistribucion) {
		this.codigoContenedorDistribucion = codigoContenedorDistribucion;
	}

	/**
	 * @return the valorContenedorDistribucion
	 */
	public String getValorContenedorDistribucion() {
		return valorContenedorDistribucion;
	}

	/**
	 * @param valorContenedorDistribucion the valorContenedorDistribucion to set
	 */
	public void setValorContenedorDistribucion(String valorContenedorDistribucion) {
		this.valorContenedorDistribucion = valorContenedorDistribucion;
	}

	/**
	 * @return the contenedorDistribucion
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getContenedorDistribucion() {
		return contenedorDistribucion;
	}

	/**
	 * @param contenedorDistribucion the contenedorDistribucion to set
	 */
	public void setContenedorDistribucion(ec.com.smx.corpv2.dto.CatalogoValorDTO contenedorDistribucion) {
		this.contenedorDistribucion = contenedorDistribucion;
	}

	/**
	 * @return the tieneTara
	 */
	public Boolean getTieneTara() {
		return tieneTara;
	}

	/**
	 * @param tieneTara the tieneTara to set
	 */
	public void setTieneTara(Boolean tieneTara) {
		this.tieneTara = tieneTara;
	}

	/**
	 * @return the areaConservacionBodega
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getAreaConservacionBodega() {
		return areaConservacionBodega;
	}

	/**
	 * @param areaConservacionBodega the areaConservacionBodega to set
	 */
	public void setAreaConservacionBodega(ec.com.smx.corpv2.dto.CatalogoValorDTO areaConservacionBodega) {
		this.areaConservacionBodega = areaConservacionBodega;
	}

	/**
	 * @return the codigoIndicadorPropietario
	 */
	public Integer getCodigoIndicadorPropietario() {
		return codigoIndicadorPropietario;
	}

	/**
	 * @param codigoIndicadorPropietario the codigoIndicadorPropietario to set
	 */
	public void setCodigoIndicadorPropietario(Integer codigoIndicadorPropietario) {
		this.codigoIndicadorPropietario = codigoIndicadorPropietario;
	}

	/**
	 * @return the indicadorPropietarioDTO
	 */
	public IndicadorPropietarioDTO getIndicadorPropietarioDTO() {
		return indicadorPropietarioDTO;
	}

	/**
	 * @param indicadorPropietarioDTO the indicadorPropietarioDTO to set
	 */
	public void setIndicadorPropietarioDTO(IndicadorPropietarioDTO indicadorPropietarioDTO) {
		this.indicadorPropietarioDTO = indicadorPropietarioDTO;
	}

	/**
	 * @return the valorAreaConservacionBodega
	 */
	public String getValorAreaConservacionBodega() {
		return valorAreaConservacionBodega;
	}

	/**
	 * @param valorAreaConservacionBodega the valorAreaConservacionBodega to set
	 */
	public void setValorAreaConservacionBodega(String valorAreaConservacionBodega) {
		this.valorAreaConservacionBodega = valorAreaConservacionBodega;
	}

	/**
	 * @return the codigoAreaConservacionBodega
	 */
	public Integer getCodigoAreaConservacionBodega() {
		return codigoAreaConservacionBodega;
	}

	/**
	 * @param codigoAreaConservacionBodega the codigoAreaConservacionBodega to set
	 */
	public void setCodigoAreaConservacionBodega(Integer codigoAreaConservacionBodega) {
		this.codigoAreaConservacionBodega = codigoAreaConservacionBodega;
	}

	public Boolean getTieneTipoDistribucion(){
		return isLoaded(tipoDistribucion);
	}

	/**
	 * @return the codigoTipoUbicacionDespacho
	 */
	public Integer getCodigoTipoUbicacionDespacho() {
		return codigoTipoUbicacionDespacho;
	}

	/**
	 * @param codigoTipoUbicacionDespacho the codigoTipoUbicacionDespacho to set
	 */
	public void setCodigoTipoUbicacionDespacho(Integer codigoTipoUbicacionDespacho) {
		this.codigoTipoUbicacionDespacho = codigoTipoUbicacionDespacho;
	}

	/**
	 * @return the valorTipoUbicacionDespacho
	 */
	public String getValorTipoUbicacionDespacho() {
		return valorTipoUbicacionDespacho;
	}

	/**
	 * @param valorTipoUbicacionDespacho the valorTipoUbicacionDespacho to set
	 */
	public void setValorTipoUbicacionDespacho(String valorTipoUbicacionDespacho) {
		this.valorTipoUbicacionDespacho = valorTipoUbicacionDespacho;
	}
}
