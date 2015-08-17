package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.cambioprecios.beans.DatosOrdenCompra;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IntegrableMQ;
import ec.com.smx.sic.cliente.mdl.dto.sispe.ArticuloTemporadaDTO;

/**
 * Entidad que almacena los datos de referencia de un articulo vs proveedor-clasificacion
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTPRO")
public class ArticuloProveedorDTO extends SimpleAuditDTO implements IntegrableMQ, Cloneable{

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProveedorID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProveedorID();
	/**
	 * Codigo de referencia del proveedor para el articulo.
	 * 
	 */
	private String codigoReferenciaProveedor;
	
	/**
	 * C�digo de referencia del interna para el art�culo.
	 * 
	 */
	private String codigoReferenciaInterna;
	
	/**
	 * Estado del proveedor vs art�culo, los valores permitidos son: [0] INACTIVO, [1] ACTIVO
	 */
	@ComparatorTypeField
	private String estadoArticuloProveedor;

	/**
	 * Es el costo bruto del art�culo que da el proveedor
	 * 
	 */
	private Double costoBruto;
	/**
	 * Es el costo bruto del art�culo antes de la fecha de cambio
	 * 
	 */
	private Double costoBrutoAnterior;
	/**
	 * Fecha en la que cambi� el costo bruto
	 */
	private Date fechaCambioCosto;
	/**
	 * Indica el porcentaje adicional que se le puede recibir a un proveedor cuando trae mercadería
	 * 
	 */
	private Double porcentajeExesoRecepcion;
	
	/**
	 * Usuario que cre� el registro
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la cual se cre� el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Usuario que realiza la �ltima actualizaci�n del registro
	 * 
	 */
	@LastModifierUserIdField
	@Column(insertable=false)
	private String idUsuarioModificacion;

	/**
	 * Fecha en la cual se realiz� la ultima actualizaci�n del registro
	 * 
	 */
	@LastModificationDateField
	@Column(insertable=false)
	private java.sql.Timestamp fechaModificacion;

	@ComparatorTypeField
	@Column(name="VALORPLAZOPAGO")
	private String valorPlazoPago;
	@Column(name="CODIGOPLAZOPAGO")
	private Integer codigoPlazoPago;
	
	/**
	 * Indica si el art&iacute;culo del proveedor tiene o no registro sanitario
	 */
	@Column(name="CONFIRMAREGISTROSANITARIO")
	private Boolean esConfirmadoRegistroSanitario;
	/**
	 * Observaci�n sobre el registro sanitario del art&iacute;culo
	 */
	private String observacionRegistroSanitario;
	
	@Column(name = "CANTIDADMAXIMAOFERTADA")
	private Integer cantidadMaximaOfertada;
	
	@Column(name = "PESOMAXIMOOFERTADO")
	private BigDecimal pesoMaximoOfertado;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO articuloImportacion;

	@OneToMany(mappedBy = "articuloProveedorDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloProveedorImpuestoDTO> articuloProveedorImpuestoCol;
	
	@OneToMany(mappedBy = "articuloProveedorDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloTemporadaDTO> articuloTemporadaCol;
	
	@OneToMany(mappedBy = "articuloProveedor")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<BitacoraArticuloProveedorDTO> bitacoraArticuloProveedorCol;
	
	@OneToMany(mappedBy = "articuloProveedor")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol;
	
	@OneToMany(mappedBy = "articuloProveedor")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloProveedorNovedadDTO> novedades;
	
	@OneToMany(mappedBy = "articuloProveedor")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)	
	private Collection<ArticuloProveedorCostoDTO> articuloProveedorCostoCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO proveedor;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="VALORPLAZOPAGO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPLAZOPAGO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")}
	)
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoPlazoPago;
	
	@OneToMany(mappedBy = "articuloProveedor")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloUnidadManejoProveedorDTO> unidadesManejo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO vistaProveedor;
	
	@OneToMany(mappedBy = "articuloProveedor")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloOfertaProveedorDTO> articuloOfertaProveedorDTO;
		
	@Transient
	private Double costoNeto;
	@Transient
	private Double costoNetoProyectado1;
	@Transient
	private Double costoNetoProyectado2;
	@Transient
	private Double costoNetoImportacion;
	@Transient
	private Double costoNetoImportacionComision;
	@Transient
	private Double costoNetoNC;
	@Transient
	private Integer plazoPago=0;
	@Transient
	private Boolean transferirDatosSIC=Boolean.TRUE;
	@Transient
	private Boolean selected;
	//coleccion de ordenes de compra en conflicto(se consulta cuando se quiera dar de baja el articulo proveedor)
	@Transient
	private Collection<DatosOrdenCompra> datosOrdenCompra;
	
	@Transient
	@Column(name="NOVEDADRECEPCION")
	private String novedadRecepcion;
	
	
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProveedorID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProveedorID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>codigoReferenciaProveedor</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoReferenciaProveedor</code>
	 */
	public String getCodigoReferenciaProveedor() {
		return this.codigoReferenciaProveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoReferenciaProveedor</code>.
	 * 
	 * @param codigoReferenciaProveedor1
	 *            El valor a establecer para la propiedad <code>codigoReferenciaProveedor</code>.
	 */
	public void setCodigoReferenciaProveedor(String codigoReferenciaProveedor1) {
		this.codigoReferenciaProveedor = codigoReferenciaProveedor1;
	}

	/**
	 * Retorna valor de propiedad <code>estadoArticuloProveedor</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoArticuloProveedor</code>
	 */
	public String getEstadoArticuloProveedor() {
		return this.estadoArticuloProveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoArticuloProveedor</code>.
	 * 
	 * @param estadoArticuloProveedor1
	 *            El valor a establecer para la propiedad <code>estadoArticuloProveedor</code>.
	 */
	public void setEstadoArticuloProveedor(String estadoArticuloProveedor1) {
		this.estadoArticuloProveedor = estadoArticuloProveedor1;

		if (estadoArticuloProveedor != null && estadoArticuloProveedor.length() > 1) {
			estadoArticuloProveedor = estadoArticuloProveedor.substring(0, 1);
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
	 * Retorna valor de propiedad <code>proveedor</code>
	 * 
	 * @return Retorna valor de propiedad <code>proveedor</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO getProveedor() {
		return this.proveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>proveedor</code>.
	 * 
	 * @param proveedor1
	 *            El valor a establecer para la propiedad <code>proveedor</code>.
	 */
	public void setProveedor(ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO proveedor1) {
		this.proveedor = proveedor1;
	}

	/**
	 * @return the costoBruto
	 */
	public Double getCostoBruto() {
		return costoBruto;
	}

	/**
	 * @param costoBruto the costoBruto to set
	 */
	public void setCostoBruto(Double costoBruto) {
		this.costoBruto = costoBruto;
	}

	/**
	 * @return the porcentajeExesoRecepcion
	 */
	public Double getPorcentajeExesoRecepcion() {
		return porcentajeExesoRecepcion;
	}

	/**
	 * @param porcentajeExesoRecepcion the porcentajeExesoRecepcion to set
	 */
	public void setPorcentajeExesoRecepcion(Double porcentajeExesoRecepcion) {
		this.porcentajeExesoRecepcion = porcentajeExesoRecepcion;
	}

	/**
	 * @return the articuloImportacion
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO getArticuloImportacion() {
		return articuloImportacion;
	}

	/**
	 * @param articuloImportacion the articuloImportacion to set
	 */
	public void setArticuloImportacion(ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO articuloImportacion) {
		this.articuloImportacion = articuloImportacion;
	}

	/**
	 * @return the descuentoProveedorArticuloCol
	 */
	public Collection<DescuentoProveedorArticuloDTO> getDescuentoProveedorArticuloCol() {
		return descuentoProveedorArticuloCol;
	}

	/**
	 * @param descuentoProveedorArticuloCol the descuentoProveedorArticuloCol to set
	 */
	public void setDescuentoProveedorArticuloCol(Collection<DescuentoProveedorArticuloDTO> descuentoProveedorArticuloCol) {
		this.descuentoProveedorArticuloCol = descuentoProveedorArticuloCol;
	}

	/**
	 * @return the costoNeto
	 */
	public Double getCostoNeto() {
		if(costoNeto == null){
			SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularCostoNeto(this);
		}
		return costoNeto;
	}
	
	/**
	 * Costo proyectado para el dia siguiente de la fecha actual consultada
	 * @return the costoNetoProyectado1
	 */
	public Double getCostoNetoProyectado1() {
		if(costoNetoProyectado1 == null){
			costoNetoProyectado1 = SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularCostoNeto(this,TipoCatalogoArticulo.VALOR_TIPO_COSTO_PROYECTADO1);
			if(costoNetoProyectado1 == null || costoNetoProyectado1 == 0){
				costoNetoProyectado1 = getCostoNeto();
				setCostoNetoProyectado1(costoNetoProyectado1);							
			}else{
				setCostoNetoProyectado1(costoNetoProyectado1);
			}						
		}
		return costoNetoProyectado1;
	}
	
	/**
	 * Costo proyectado para el segundo dia despues de la fecha actual consultada
	 * @return the costoNetoProyectado2
	 */
	public Double getCostoNetoProyectado2() {
		if(costoNetoProyectado2 == null){
			costoNetoProyectado2 = SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularCostoNeto(this,TipoCatalogoArticulo.VALOR_TIPO_COSTO_PROYECTADO2); 
			if(costoNetoProyectado2 == null || costoNetoProyectado2 == 0){
				costoNetoProyectado2 = getCostoNeto();
				setCostoNetoProyectado2(costoNetoProyectado2);							
			}else{
				setCostoNetoProyectado2(costoNetoProyectado2);
			}			
		}
		return costoNetoProyectado2;
	}
	
	/**
	 * 
	 * @param ap
	 */
	public void obtenerCostosNetosProyeccion(){
		SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularCostoNetoProyectado(this);
	}
	
	/**
	 * @return the costoNeto
	 */
	public Double getCostoNetoNC() {
		if(costoNetoNC == null){
			costoNetoNC = SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularCostoNetoNotaCredito(this);
		}
		return costoNetoNC;
	}
	
	/**
	 * @return the costoNeto
	 */
	public Double getCostoBrutoImp() {
		Map<String, Double> valoresImpuestos = obtenerImpuestos();
		if(costoBruto != null && valoresImpuestos !=null)
			return SICArticuloCalculo.getInstancia().calcularValorConImpuestos(costoBruto, valoresImpuestos, Boolean.FALSE);
		return costoBruto;
	}
	
	/**
	 * @return the costoNeto
	 */
	public Double getCostoNetoImp() {
		Double costoNetoImp = getCostoNeto();
		Map<String, Double> valoresImpuestos = obtenerImpuestos();
		if(costoNetoImp != null && valoresImpuestos != null){
			return SICArticuloCalculo.getInstancia().calcularValorConImpuestos(costoNetoImp, valoresImpuestos, Boolean.FALSE);
		}
		return costoNetoImp;
	}

	private Map<String, Double> obtenerImpuestos(){
		if(this.getTieneArticulo()){
			return SICArticuloCalculo.getInstancia().obtenerValoresImpuesto(articulo, Boolean.FALSE);
		}
		return null;
	}
	
	
	/**
	 * @param costoNeto the costoNetoNC to set
	 */
	public void setCostoNetoNC(Double costoNeto) {
		this.costoNetoNC = costoNeto;
	}
	
	/**
	 * @param costoNeto the costoNeto to set
	 */
	public void setCostoNeto(Double costoNeto) {
		this.costoNeto = costoNeto;
	}
	
	/**
	 * @param costoNetoProyectado1 the costoNetoProyectado1 to set
	 */
	public void setCostoNetoProyectado1(Double costoNetoProyectado1) {
		this.costoNetoProyectado1 = costoNetoProyectado1;
	}
	
	/**
	 * @param costoNetoProyectado2 the costoNetoProyectado2 to set
	 */
	public void setCostoNetoProyectado2(Double costoNetoProyectado2) {
		this.costoNetoProyectado2 = costoNetoProyectado2;
	}
	
	public Boolean getTieneDescuentoProveedorArticuloCol(){
		return isLoaded(descuentoProveedorArticuloCol) && !descuentoProveedorArticuloCol.isEmpty();
	}
	
	public Boolean getTieneArticuloProveedorImpuestos(){
		return isLoaded(articuloProveedorImpuestoCol) && CollectionUtils.isNotEmpty(articuloProveedorImpuestoCol);
	}
	
	public Boolean getTieneUnidadesManejo(){
		return isLoaded(unidadesManejo);
	}
	
	/**
	 * Valida si existe la relaci&oacute;n con los costos
	 * @return
	 */
	public Boolean getTieneArticuloProveedorCosto() {
		return isLoaded(this.articuloProveedorCostoCol) && !this.articuloProveedorCostoCol.isEmpty();
	}
	/**
	 * @return the plazoPago
	 */
	public Integer getPlazoPago() {
		return plazoPago;
	}

	/**
	 * @param plazoPago the plazoPago to set
	 */
	public void setPlazoPago(Integer plazoPago) {
		this.plazoPago = plazoPago;
	}

	public ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO getVistaProveedor() {
		return vistaProveedor;
	}

	public void setVistaProveedor(
			ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO vistaProveedor) {
		this.vistaProveedor = vistaProveedor;
	}

	/**
	 * @return the fechaCambioCosto
	 */
	public Date getFechaCambioCosto() {
		return fechaCambioCosto;
	}

	/**
	 * @param fechaCambioCosto the fechaCambioCosto to set
	 */
	public void setFechaCambioCosto(Date fechaCambioCosto) {
		this.fechaCambioCosto = fechaCambioCosto;
	}

	/**
	 * @return the costoBrutoAnterior
	 */
	public Double getCostoBrutoAnterior() {
		return costoBrutoAnterior;
	}

	/**
	 * @param costoBrutoAnterior the costoBrutoAnterior to set
	 */
	public void setCostoBrutoAnterior(Double costoBrutoAnterior) {
		this.costoBrutoAnterior = costoBrutoAnterior;
	}
	
	public Boolean getTieneVistaProveedor(){
		return isLoaded(vistaProveedor);
	}

	public Boolean getTieneProveedor(){
		return isLoaded(proveedor);
	}
	public Boolean getTieneArticuloImportacion(){
		return isLoaded(articuloImportacion);
	}
	public Boolean getTieneArticulo(){
		return isLoaded(articulo);
	}
	
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n con clasificaciones
	 * @return
	 */
	public Boolean getTieneNovedades() {
		return isLoaded(this.novedades);
	}

	/**
	 * @return the transferirDatosSIC
	 */
	public Boolean getTransferirDatosSIC() {
		return transferirDatosSIC;
	}

	/**
	 * @param transferirDatosSIC the transferirDatosSIC to set
	 */
	public void setTransferirDatosSIC(Boolean transferirDatosSIC) {
		this.transferirDatosSIC = transferirDatosSIC;
	}

	public String getCodigoReferenciaInterna() {
		return codigoReferenciaInterna;
	}

	public void setCodigoReferenciaInterna(String codigoReferenciaInternaAux) {	
		String codigoReferenciaInterna = codigoReferenciaInternaAux;
		if((StringUtils.isNotEmpty(codigoReferenciaInterna)) && (codigoReferenciaInterna.length() > 20)){
		      codigoReferenciaInterna = StringUtils.substring(codigoReferenciaInterna, 0, 20);
		}
		this.codigoReferenciaInterna = codigoReferenciaInterna;
	}

	/**
	 * @return the costoNetoImportacion
	 */
	public Double getCostoNetoImportacion() {
		if(costoNetoImportacion == null){
			SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularCostoNeto(this, Boolean.TRUE, Boolean.FALSE);
		}
		return costoNetoImportacion;
	}

	/**
	 * @param costoNetoImportacion the costoNetoImportacion to set
	 */
	public void setCostoNetoImportacion(Double costoNetoImportacion) {
		this.costoNetoImportacion = costoNetoImportacion;
	}

	/**
	 * @return the costoNetoImportacionComision
	 */
	public Double getCostoNetoImportacionComision() {
		if(costoNetoImportacionComision == null){
			SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularCostoNeto(this, Boolean.TRUE, Boolean.TRUE);
		}
		return costoNetoImportacionComision;
	}

	/**
	 * @param costoNetoImportacionComision the costoNetoImportacionComision to set
	 */
	public void setCostoNetoImportacionComision(Double costoNetoImportacionComision) {
		this.costoNetoImportacionComision = costoNetoImportacionComision;
	}

	/**
	 * @return the articuloTemporadaCol
	 */
	public Collection<ArticuloTemporadaDTO> getArticuloTemporadaCol() {
		return articuloTemporadaCol;
	}

	/**
	 * @param articuloTemporadaCol the articuloTemporadaCol to set
	 */
	public void setArticuloTemporadaCol(Collection<ArticuloTemporadaDTO> articuloTemporadaCol) {
		this.articuloTemporadaCol = articuloTemporadaCol;
	}

	public Collection<BitacoraArticuloProveedorDTO> getBitacoraArticuloProveedorCol() {
		return bitacoraArticuloProveedorCol;
	}

	public void setBitacoraArticuloProveedorCol(Collection<BitacoraArticuloProveedorDTO> bitacoraArticuloProveedorCol) {
		this.bitacoraArticuloProveedorCol = bitacoraArticuloProveedorCol;
	}

	/**
	 * @return the tipoPlazoPago
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoPlazoPago() {
		return tipoPlazoPago;
	}

	/**
	 * @param tipoPlazoPago the tipoPlazoPago to set
	 */
	public void setTipoPlazoPago(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoPlazoPago) {
		this.tipoPlazoPago = tipoPlazoPago;
	}

	/**
	 * @return the valorPlazoPago
	 */
	public String getValorPlazoPago() {
		return valorPlazoPago;
	}

	/**
	 * @param valorPlazoPago the valorPlazoPago to set
	 */
	public void setValorPlazoPago(String valorPlazoPago) {
		this.valorPlazoPago = valorPlazoPago;
	}

	/**
	 * @return the codigoPlazoPago
	 */
	public Integer getCodigoPlazoPago() {
		return codigoPlazoPago;
	}

	/**
	 * @param codigoPlazoPago the codigoPlazoPago to set
	 */
	public void setCodigoPlazoPago(Integer codigoPlazoPago) {
		this.codigoPlazoPago = codigoPlazoPago;
	}
	
	public Boolean getTienePlazoPago(){
		return isLoaded(tipoPlazoPago);
	}

	/**
	 * @return the novedades
	 */
	public Collection<ArticuloProveedorNovedadDTO> getNovedades() {
		return novedades;
	}

	/**
	 * @param novedades the novedades to set
	 */
	public void setNovedades(Collection<ArticuloProveedorNovedadDTO> novedades) {
		this.novedades = novedades;
	}
	
	

	public Collection<ArticuloUnidadManejoProveedorDTO> getUnidadesManejo() {
		return unidadesManejo;
	}

	public void setUnidadesManejo(Collection<ArticuloUnidadManejoProveedorDTO> unidadesManejo) {
		this.unidadesManejo = unidadesManejo;
	}

	public Boolean getEsConfirmadoRegistroSanitario() {
		return esConfirmadoRegistroSanitario;
	}

	public void setEsConfirmadoRegistroSanitario(Boolean esConfirmadoRegistroSanitario) {
		this.esConfirmadoRegistroSanitario = esConfirmadoRegistroSanitario;
	}

	public String getObservacionRegistroSanitario() {
		return observacionRegistroSanitario;
	}

	public void setObservacionRegistroSanitario(String observacionRegistroSanitario) {
		this.observacionRegistroSanitario = observacionRegistroSanitario;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
	public ArticuloProveedorDTO clone() throws CloneNotSupportedException{
		ArticuloProveedorDTO apClone = (ArticuloProveedorDTO)super.clone();
		apClone.setId(id.clone());
		return apClone;
	}

	/**
	 * @return the articuloProveedorImpuestoCol
	 */
	public Collection<ArticuloProveedorImpuestoDTO> getArticuloProveedorImpuestoCol() {
		return articuloProveedorImpuestoCol;
	}

	/**
	 * @param articuloProveedorImpuestoCol the articuloProveedorImpuestoCol to set
	 */
	public void setArticuloProveedorImpuestoCol(Collection<ArticuloProveedorImpuestoDTO> articuloProveedorImpuestoCol) {
		this.articuloProveedorImpuestoCol = articuloProveedorImpuestoCol;
	}

	public Collection<ArticuloProveedorCostoDTO> getArticuloProveedorCostoCol() {
		return articuloProveedorCostoCol;
	}

	public void setArticuloProveedorCostoCol(Collection<ArticuloProveedorCostoDTO> articuloProveedorCostoCol) {
		this.articuloProveedorCostoCol = articuloProveedorCostoCol;
	}

	public Collection<DatosOrdenCompra> getDatosOrdenCompra() {
		return datosOrdenCompra;
	}

	public void setDatosOrdenCompra(Collection<DatosOrdenCompra> datosOrdenCompra) {
		this.datosOrdenCompra = datosOrdenCompra;
	}

	/**
	 * @return the novedadRecepcion
	 */
	public String getNovedadRecepcion() {
		return novedadRecepcion;
	}

	/**
	 * @param novedadRecepcion the novedadRecepcion to set
	 */
	public void setNovedadRecepcion(String novedadRecepcion) {
		this.novedadRecepcion = novedadRecepcion;
	}
	

	public Collection<ArticuloOfertaProveedorDTO> getArticuloOfertaProveedorDTO() {
		return articuloOfertaProveedorDTO;
	}

	public void setArticuloOfertaProveedorDTO(Collection<ArticuloOfertaProveedorDTO> articuloOfertaProveedorDTO) {
		this.articuloOfertaProveedorDTO = articuloOfertaProveedorDTO;
	}

	public Integer getCantidadMaximaOfertada() {
		return cantidadMaximaOfertada;
	}

	public void setCantidadMaximaOfertada(Integer cantidadMaximaOfertada) {
		this.cantidadMaximaOfertada = cantidadMaximaOfertada;
	}

	public BigDecimal getPesoMaximoOfertado() {
		return pesoMaximoOfertado;
	}

	public void setPesoMaximoOfertado(BigDecimal pesoMaximoOfertado) {
		this.pesoMaximoOfertado = pesoMaximoOfertado;
	}

	
}
