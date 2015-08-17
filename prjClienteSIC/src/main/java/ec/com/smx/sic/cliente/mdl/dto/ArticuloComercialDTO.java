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
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.DivisionGeoPoliticaDTO;
import ec.com.smx.corpv2.dto.UbicacionTransaccionDivisionGeoPoliticaDTO;

/**
 * Entidad que almacena datos comerciales de un art�culo
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTCOM")
public class ArticuloComercialDTO extends SimpleAuditDTO {

	/**
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloComercialID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloComercialID();

	/**
	 * C�digo del pa�s de origen del art�culo
	 * 
	 */
	@ComparatorTypeField
	@Column(name="CODIGOPAISORIGEN")
	private String codigoPaisOrigen;
	
	/**
	 * C�digo de la marca comercial
	 * 
	 */
	@Column(name="CODIGOMARCACOMERCIAL")
	private java.lang.Long codigoMarcaComercial;

	/**
	 * Es la marca que se le da a un art�culo para tener una agrupaci�n de las participaciones que los proveedores registran
	 * 
	 */
	@ComparatorTypeField
	private String marcaParticipaciones;
	
	@ComparatorTypeField
	private String estadoOrigenArticulo;
	@Column(name="CODIGOLUGARCOMPRA")
	private Long codigoLugarCompra;
	
	/**
	 * Indicador para saber si se debe exigir una fecha de caducidad en la recepci�n de mercader�a
	 * 
	 */
	private Boolean verFecCadRec;

	/**
	 * C�digo del tipo de peso en el cat�logo
	 * 
	 */
	@Column(name="CODIGOTIPOCONTROLCOSTO")
	private Integer codigoTipoControlCosto;

	/**
	 * Valor del tipo de control de costo
	 * 
	 */
	@ComparatorTypeField
	@Column(name="VALORTIPOCONTROLCOSTO")
	private String valorTipoControlCosto;

	/**
	 * Indica el peso aproximado en recepci�n, este campo se llena dependiendo del tipo de control de costo
	 * 
	 */
	private Double pesoAproximadoRecepcion;
	/**
	 * Indica el peso aproximado para la venta de ciertos art�culos de peso variable, este campo se llena dependiendo del tipo de control de costo
	 * 
	 */
	private Double pesoAproximadoVenta;
	
	/**
	 * Indica el porcentaje de incremento aplicado al precio normal para obtener los valores de no afiliado
	 * 
	 */
	private Double porcentajeNoAfiliado;
	/**
	 * Indicador que determina si el art�culo genera o no factura cuando se vende. Sus valores son:
1: VERDADERO
0: FALSO
	 */
	private Boolean generaFacturaVenta;
	/**
	 * Indicador que determina si el art�culo tiene o no precio fijo. Sus valores son:
1: VERDADERO
0: FALSO
	 */
	private Boolean tienePrecioFijo;
	
	private Boolean ventaPrecioAfiliado;
	
	@ComparatorTypeField
	@Column(name="VALORTIPODEDUCIBLE")
	private String valorTipoDeducible;
	@Column(name="CODIGOTIPODEDUCIBLE")
	private Integer codigoTipoDeducible;
	
	/**
	 * Tiene precio saldo
	 */
	@Column(name="TIENEPRECIOSALDO")
	private Boolean tienePrecioSaldo;
	
	/**
	 * Permite autorizar cambio costo recepcion
	 */
	@Column(name="AUTORIZARCAMBIOCOSTORECEPCION")
	private Boolean autorizarCambioCostoRecepcion;
	
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

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOMARCACOMERCIAL", referencedColumnName="SECUENCIALMARCA", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO marcaComercialArticulo;

	@ManyToOne(fetch = LAZY)
	@JoinColumns(@JoinColumn(name="CODIGOPAISORIGEN", insertable=false, updatable=false, referencedColumnName="CODIGODIVGEOPOL"))
	private DivisionGeoPoliticaDTO paisOrigen;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOCONTROLCOSTO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOCONTROLCOSTO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoControlCosto;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPODEDUCIBLE", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPODEDUCIBLE", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoDeducible;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOLUGARCOMPRA", insertable=false, updatable=false, referencedColumnName="CODUBITRADIVGEOPOL")})
	private UbicacionTransaccionDivisionGeoPoliticaDTO ubicacionTransaccionDivisionGeoPoliticaDTO;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloComercialID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloComercialID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>codigoPaisOrigen</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoPaisOrigen</code>
	 */
	public String getCodigoPaisOrigen() {
		return this.codigoPaisOrigen;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoPaisOrigen</code>.
	 * 
	 * @param codigoPaisOrigen1
	 *            El valor a establecer para la propiedad <code>codigoPaisOrigen</code>.
	 */
	public void setCodigoPaisOrigen(String codigoPaisOrigen1) {
		this.codigoPaisOrigen = codigoPaisOrigen1;

		if (codigoPaisOrigen != null && codigoPaisOrigen.length() > 10) {
			codigoPaisOrigen = codigoPaisOrigen.substring(0, 10);
		}

	}

	/**
	 * Retorna valor de propiedad <code>codigoMarcaComercial</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoMarcaComercial</code>
	 */
	public java.lang.Long getCodigoMarcaComercial() {
		return this.codigoMarcaComercial;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoMarcaComercial</code>.
	 * 
	 * @param codigoMarcaComercial1
	 *            El valor a establecer para la propiedad <code>codigoMarcaComercial</code>.
	 */
	public void setCodigoMarcaComercial(java.lang.Long codigoMarcaComercial1) {
		this.codigoMarcaComercial = codigoMarcaComercial1;

	}

	/**
	 * Retorna valor de propiedad <code>marcaParticipaciones</code>
	 * 
	 * @return Retorna valor de propiedad <code>marcaParticipaciones</code>
	 */
	public String getMarcaParticipaciones() {
		return this.marcaParticipaciones;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>marcaParticipaciones</code>.
	 * 
	 * @param marcaParticipaciones1
	 *            El valor a establecer para la propiedad <code>marcaParticipaciones</code>.
	 */
	public void setMarcaParticipaciones(String marcaParticipaciones1) {
		this.marcaParticipaciones = marcaParticipaciones1;

		if (marcaParticipaciones != null && marcaParticipaciones.length() > 3) {
			marcaParticipaciones = marcaParticipaciones.substring(0, 3);
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
	 * Retorna valor de propiedad <code>marcaComercialArticulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>marcaComercialArticulo</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO getMarcaComercialArticulo() {
		return this.marcaComercialArticulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>marcaComercialArticulo</code>.
	 * 
	 * @param marcaComercialArticulo1
	 *            El valor a establecer para la propiedad <code>marcaComercialArticulo</code>.
	 */
	public void setMarcaComercialArticulo(ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO marcaComercialArticulo1) {
		this.marcaComercialArticulo = marcaComercialArticulo1;
	}

	/**
	 * @return the estadoOrigenArticulo
	 */
	public String getEstadoOrigenArticulo() {
		return estadoOrigenArticulo;
	}

	/**
	 * @param estadoOrigenArticulo the estadoOrigenArticulo to set
	 */
	public void setEstadoOrigenArticulo(String estadoOrigenArticulo) {
		this.estadoOrigenArticulo = estadoOrigenArticulo;
	}

	/**
	 * @return the paisOrigen
	 */
	public DivisionGeoPoliticaDTO getPaisOrigen() {
		return paisOrigen;
	}

	/**
	 * @param paisOrigen the paisOrigen to set
	 */
	public void setPaisOrigen(DivisionGeoPoliticaDTO paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	/**
	 * @return the verFecCadRec
	 */
	public Boolean getVerFecCadRec() {
		return verFecCadRec;
	}

	/**
	 * @param verFecCadRec the verFecCadRec to set
	 */
	public void setVerFecCadRec(Boolean verFecCadRec) {
		this.verFecCadRec = verFecCadRec;
	}

	/**
	 * @return the codigoTipoControlCosto
	 */
	public Integer getCodigoTipoControlCosto() {
		return codigoTipoControlCosto;
	}

	/**
	 * @param codigoTipoControlCosto the codigoTipoControlCosto to set
	 */
	public void setCodigoTipoControlCosto(Integer codigoTipoControlCosto) {
		this.codigoTipoControlCosto = codigoTipoControlCosto;
	}
	

	/**
	 * @return the valorTipoControlCosto
	 */
	public String getValorTipoControlCosto() {
		return valorTipoControlCosto;
	}

	/**
	 * @param valorTipoControlCosto the valorTipoControlCosto to set
	 */
	public void setValorTipoControlCosto(String valorTipoControlCosto) {
		this.valorTipoControlCosto = valorTipoControlCosto;
	}
	

	/**
	 * @return the tipoControlCosto
	 */
	public CatalogoValorDTO getTipoControlCosto() {
		return tipoControlCosto;
	}

	/**
	 * @param tipoControlCosto the tipoControlCosto to set
	 */
	public void setTipoControlCosto(CatalogoValorDTO tipoControlCosto) {
		this.tipoControlCosto = tipoControlCosto;
	}

	/**
	 * @return the porcentajeNoAfiliado
	 */
	public Double getPorcentajeNoAfiliado() {
		return porcentajeNoAfiliado;
	}

	/**
	 * @param porcentajeNoAfiliado the porcentajeNoAfiliado to set
	 */
	public void setPorcentajeNoAfiliado(Double porcentajeNoAfiliado) {
		this.porcentajeNoAfiliado = porcentajeNoAfiliado;
	}

	/**
	 * @return the pesoAproximadoVenta
	 */
	public Double getPesoAproximadoVenta() {
		return pesoAproximadoVenta;
	}

	/**
	 * @param pesoAproximadoVenta the pesoAproximadoVenta to set
	 */
	public void setPesoAproximadoVenta(Double pesoAproximadoVenta) {
		this.pesoAproximadoVenta = pesoAproximadoVenta;
	}

	/**
	 * @return the pesoAproximadoRecepcion
	 */
	public Double getPesoAproximadoRecepcion() {
		return pesoAproximadoRecepcion;
	}

	/**
	 * @param pesoAproximadoRecepcion the pesoAproximadoRecepcion to set
	 */
	public void setPesoAproximadoRecepcion(Double pesoAproximadoRecepcion) {
		this.pesoAproximadoRecepcion = pesoAproximadoRecepcion;
	}

	/**
	 * @return the generaFacturaVenta
	 */
	public Boolean getGeneraFacturaVenta() {
		return generaFacturaVenta;
	}

	/**
	 * @param generaFacturaVenta the generaFacturaVenta to set
	 */
	public void setGeneraFacturaVenta(Boolean generaFacturaVenta) {
		this.generaFacturaVenta = generaFacturaVenta;
	}

	/**
	 * @return the tienePrecioFijo
	 */
	public Boolean getTienePrecioFijo() {
		return tienePrecioFijo;
	}

	/**
	 * @param tienePrecioFijo the tienePrecioFijo to set
	 */
	public void setTienePrecioFijo(Boolean tienePrecioFijo) {
		this.tienePrecioFijo = tienePrecioFijo;
	}

	public Boolean getTieneTipoControlCosto() {
		return isLoaded(this.tipoControlCosto);
	}
	
	public Boolean getTienePaisOrigen() {
		return isLoaded(this.paisOrigen);
	}
	
	public Boolean getTieneMarcaArticulo() {
		return isLoaded(this.marcaComercialArticulo);
	}

	/**
	 * @return the ventaPrecioAfiliado
	 */
	public Boolean getVentaPrecioAfiliado() {
		return ventaPrecioAfiliado;
	}

	/**
	 * @param ventaPrecioAfiliado the ventaPrecioAfiliado to set
	 */
	public void setVentaPrecioAfiliado(Boolean ventaPrecioAfiliado) {
		this.ventaPrecioAfiliado = ventaPrecioAfiliado;
	}

	/**
	 * @return the valorTipoDeducible
	 */
	public String getValorTipoDeducible() {
		return valorTipoDeducible;
	}

	/**
	 * @param valorTipoDeducible the valorTipoDeducible to set
	 */
	public void setValorTipoDeducible(String valorTipoDeducible) {
		this.valorTipoDeducible = valorTipoDeducible;
	}

	/**
	 * @return the codigoTipoDeducible
	 */
	public Integer getCodigoTipoDeducible() {
		return codigoTipoDeducible;
	}

	/**
	 * @param codigoTipoDeducible the codigoTipoDeducible to set
	 */
	public void setCodigoTipoDeducible(Integer codigoTipoDeducible) {
		this.codigoTipoDeducible = codigoTipoDeducible;
	}

	/**
	 * @return the tipoDeducible
	 */
	public CatalogoValorDTO getTipoDeducible() {
		return tipoDeducible;
	}

	/**
	 * @param tipoDeducible the tipoDeducible to set
	 */
	public void setTipoDeducible(CatalogoValorDTO tipoDeducible) {
		this.tipoDeducible = tipoDeducible;
	}
	
	public Boolean getTieneTipoDeducible(){
		return isLoaded(tipoDeducible);
	}

	public Long getCodigoLugarCompra() {
		return codigoLugarCompra;
	}

	public void setCodigoLugarCompra(Long codigoLugarCompra) {
		this.codigoLugarCompra = codigoLugarCompra;
	}

	public UbicacionTransaccionDivisionGeoPoliticaDTO getUbicacionTransaccionDivisionGeoPoliticaDTO() {
		return ubicacionTransaccionDivisionGeoPoliticaDTO;
	}

	public void setUbicacionTransaccionDivisionGeoPoliticaDTO(UbicacionTransaccionDivisionGeoPoliticaDTO ubicacionTransaccionDivisionGeoPoliticaDTO) {
		this.ubicacionTransaccionDivisionGeoPoliticaDTO = ubicacionTransaccionDivisionGeoPoliticaDTO;
	}

	/**
	 * @return the tienePrecioSaldo
	 */
	public Boolean getTienePrecioSaldo() {
		return tienePrecioSaldo;
	}

	/**
	 * @param tienePrecioSaldo the tienePrecioSaldo to set
	 */
	public void setTienePrecioSaldo(Boolean tienePrecioSaldo) {
		this.tienePrecioSaldo = tienePrecioSaldo;
	}

	/**
	 * @return the autorizarCambioCostoRecepcion
	 */
	public Boolean getAutorizarCambioCostoRecepcion() {
		return autorizarCambioCostoRecepcion;
	}

	/**
	 * @param autorizarCambioCostoRecepcion the autorizarCambioCostoRecepcion to set
	 */
	public void setAutorizarCambioCostoRecepcion(Boolean autorizarCambioCostoRecepcion) {
		this.autorizarCambioCostoRecepcion = autorizarCambioCostoRecepcion;
	}
}
