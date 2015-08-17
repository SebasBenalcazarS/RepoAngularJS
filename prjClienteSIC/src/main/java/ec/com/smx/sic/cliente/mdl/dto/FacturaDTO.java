 
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.TransaccionDTO;
import ec.com.smx.frameworkv2.security.dto.AccessItemDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.FacturaID;
import ec.com.smx.sic.cliente.mdl.nopersistente.DocumentoElectronicoSRI;


/**
 * Almacena todas las tareas de la estructura logistica
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCFDITFACTURA")
public class FacturaDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.FacturaID id = new ec.com.smx.sic.cliente.mdl.dto.id.FacturaID();
	
	/**
	 * Codigo de la bodega a la que se va a entregar la factura
	 * 
	 */
	@Column(nullable = false)
	private Integer codigoAreaTrabajo ;
	
	/**
	 * Codigo de la subbodega a la que se va a entregar la factura
	 * 
	 */
	@Column(nullable = false)
	private Integer codigoAreaSublugarTrabajo ;

	@Column(nullable = false)
	@ComparatorTypeField
	private String estado ;
	
	@Column
	private String direccionProveedor ;
	
	@Column(name="CODIGOLOCALIZACION")
	private java.lang.Long codigoLocalizacion;
	
	@Column
	@ComparatorTypeField
	private String codigoProveedor ;
	
	@Column
	@ComparatorTypeField
	private Long codigoEntrega;
	
	@Column
	private String nombreProveedor;
	
	/**
	 * Ruc de la factura
	 */
	@Column(name = "RUCPROVEEDOR")
	@ComparatorTypeField
	private String ruc;
	
	/**
	 * Fecha de caducidad de la autorizacion de la factura
	 * 
	 */
	@Column
	private java.util.Date fechaCaducidadAutorizacion;
	
	/**
	 * Nro de autorizaci�n de la factura
	 */
	@Column
	@ComparatorTypeField
	private String numeroAutorizacion;
	
	/**
	 * Catalogo valor para el tipo de factura. CT: 229 CV: NOR,BON,ESP,NPE,PUB,EST
	 * 
	 */
	@Column(name="VALORTIPOFACTURACATVAL")
	@ComparatorTypeField
	private String valorTipoFactura;

	/**
	 * Catalogo valor para el tipo de factura. CT: 229 CV: NOR,BON,ESP,NPE,PUB,EST
	 * 
	 */
	@Column(name="CODIGOTIPOFACTURACATVAL")
	@ComparatorTypeField
	private Integer codigoTipoFactura;
	
	/**
	 * Catalogo tipo para el tipo de factura en sitio. CT: 1900 CV: SI, NO
	 * 
	 */
	@Column(name="CODIGOTIPOFACTURAENSITIO")
	@ComparatorTypeField
	private Integer codigoTipoFacturaEnSitio;
	
	/**
	 * Catalogo valor para el tipo de factura en sitio. CT: 1900 CV: SI, NO
	 * 
	 */
	@Column(name="VALORTIPOFACTURAENSITIO")
	@ComparatorTypeField
	private String valorTipoFacturaEnSitio;
	
	/**
	 * Catalogo tipo para el tipo nota de credito de una factura. CT: 1901 CV: SI, NO
	 * 
	 */
	@Column(name="CODIGOTIPONOTACREDITOFACTURA")
	@ComparatorTypeField
	private Integer codigoTipoNotaCreditoFactura;
	
	/**
	 * Catalogo valor para el tipo nota de credito de una factura. CT: 1901 CV: SI, NO
	 * 
	 */
	@Column(name="VALORTIPONOTACREDITOFACTURA")
	@ComparatorTypeField
	private String valorTipoNotaCreditoFactura;
	
	/**
	 * Catalogo valor para el tipo de factura. CT:1311 CV:FIS, FDI, FIN, NCR, NDE.
	 * 
	 */
	@Column(name="VALORTIPODOCUMENTOCATVAL")
	@ComparatorTypeField
	private String valorTipoDocumentoFactura;

	/**
	 * Catalogo valor para el tipo de documento CT:1311 CV:FIS, FDI, FIN, NCR, NDE.
	 * 
	 */
	@Column(name="CODIGOTIPODOCUMENTOCATVAL")
	@ComparatorTypeField
	private Integer codigoTipoDocumentoFactura;
	
	/**
	 * Codigo de la factura padre
	 */
	@Column(name = "CODIGOFACTURAPADRE")
	@ComparatorTypeField
	private Long codigoFacturaPadre;
	
	/**
	 * Catalogo tipo para diferencia impuestos factura.
	 * 
	 */
	@Column(name="CODIGODIFERENCIAIMPUESTOSFACTURA")
	@ComparatorTypeField
	@Transient
	private Integer codigoDiferenciaImpuestosFactura;
	
	@Transient 
	private java.util.Date fechaEntrega;
	
	
	
	/**
	 * Catalogo valor para diferencia impuestos factura.
	 * 
	 */
	@Column(name="VALORDIFERENCIAIMPUESTOSFACTURA")
	@ComparatorTypeField
	@Transient
	private String valorDiferenciaImpuestosFactura;
	
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	@Column(name="FECHAACTUALIZACION")
	private java.util.Date fechaModificacion;
	
	@Column(name="RETENER")
	@ComparatorTypeField
	private String retener;
	
	@Column(name="OBSERVACION")
	@ComparatorTypeField
	private String observacion;
	
	/**
	 * es el codigo del sistema
	 */
	@Column(name = "CODIGOSISTEMA")
	@ComparatorTypeField
	private String codigoSistema;
	
	/**
	 * es el codigo de la aplicacion que activa o inactiva un alcance
	 */
	@Column(name = "CODIGOOPCION")
	@ComparatorTypeField
	private String codigoOpcion;
	
	/**
	 * Establece 1 si se envio a contabilizar a JDE
	 */
	@Column(name = "CONTABILIZADO")
	private String contabilizado;
	
    @Column(name = "PLAZOPAGO")
    private Integer plazoPago;
	
	@Column(name = "VALORTIPOPLAZOPAGO", nullable = false)
	private String valorTipoPlazoPago;

	@Column(name = "CODIGOTIPOPLAZOPAGO", nullable = false)
	private Integer codigoTipoPlazoPago;
	
	@Column(name = "CODIGOACCESO")
	private String codigoAcceso;
	
	@Column(name = "TIPOTRANSACCION")
	private Integer tipoTransaccion;
	
	/**
	 * Especifica el tipo de origen si es de Mercaderia (MER) y servicio (SER)
	 */
	@Column(name = "VALORTIPOORIGEN")
	private String valorTipoOrigen;
	
	@Column(name = "CODIGOTIPOORIGEN")
	private Integer codigoTipoOrigen;
	
	/**
	 * numero de caso procedente del workflow
	 */
	@Column(name = "NUMEROCASO")
	private String numeroCaso;

	/**
	 * Usado para enviar la informacion al JDE
	 */
	@Transient
	private String tipoDocumento;
	
	@Transient
	private String primerNumeroFacturaProveedor;
	
	@Transient
	private DocumentoElectronicoSRI facturaAutorizacion;
	
	/**
	 * 
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOAREATRABAJO", insertable = false, updatable = false, referencedColumnName = "CODIGOAREATRABAJO"),
			@JoinColumn(name = "CODIGOAREASUBLUGARTRABAJO", insertable = false, updatable = false, referencedColumnName = "CODIGOAREASUBLUGARTRABAJO")})
	
	private AreaSublugarTrabajoDTO areaSublugarTrabajoDTO;
	
	
	/**
	 * 
	 * 
	 */
	@OneToMany(mappedBy = "facturaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<FacturaEstadoDTO> facturaEstadoDTOs;
	
	/**
	 * Relaci�n recursiva que una factura interna tiene con las facturas 
	 * de los proveedores.
	 */
	@OneToMany(mappedBy = "facturaPadre")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<FacturaDTO> facturasProveedor;
	
	/**
	 * Factura interna a la que pertenece la factura del proveedor.
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA",insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURAPADRE", referencedColumnName = "CODIGOFACTURA", insertable = false, updatable = false)
	})
	private FacturaDTO facturaPadre;
	
	/**
	 * 
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOENTREGA", insertable = false, updatable = false, referencedColumnName = "CODIGOENTREGA") })
	private EntregaDTO entregaDTO;
	
	/**
	 * 
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "VALORTIPOFACTURACATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPOFACTURACATVAL", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO") })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoFactura;
	
	/**
	 * 
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "VALORDIFERENCIAIMPUESTOSFACTURA", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODIFERENCIAIMPUESTOSFACTURA", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO") })
	@Transient
	private ec.com.smx.corpv2.dto.CatalogoValorDTO diferenciaImpuestos;
	
	/**
	 * 
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
    })
    private VistaProveedorDTO proveedorDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "TIPOTRANSACCION", referencedColumnName = "CODIGOTIPOTRANSACCION", insertable = false, updatable = false)
    })
	private TransaccionDTO transaccionDTO;
	
	
	@Transient
	private Collection<RecepcionProveedorDTO> recepcionProveedorDTOCol;
	
	@Transient
	private Collection<ControlRecipienteDetalleDTO> detalleRecipientesCol;
	
	/**
	 * Obtiene la relacion con la tabla facturas FacturaDTO
	 */
	@OneToMany(mappedBy = "facturaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<RecepcionProveedorFacturaDTO> recepcionProveedorFacturaCol;
	
	/**
	 * Obtiene la relacion principal con tabla factura relacionada
	 */
	@OneToMany(mappedBy = "factura")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<FacturaRelacionadaDTO> facturaRelacionadaCol;
	
	/**
	 * Obtiene la relacion secundaria con la tabla factura relacionada
	 */
	@OneToMany(mappedBy = "facturaRelacionadaProveedor")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<FacturaRelacionadaDTO> facturaRelacionadaHijasCol;
	
	/**
	 * 
	 */
	@Transient
	private FacturaEstadoDTO facturaEstadoDTOActivo;
	
	/**
	 * Obtiene la relacion con los estados de la factura 
	 */
	@OneToMany(mappedBy = "facturaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<FlujoEstadoFacturaDTO> flujoEstadosFacturaCol;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOSISTEMA", insertable=false, updatable=false, referencedColumnName="SYSID"),
		@JoinColumn(name="CODIGOOPCION", referencedColumnName="ACCITEID", insertable=false, updatable=false)})
	private AccessItemDto opcion;
	
	@OneToMany(mappedBy = "facturaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<ArchivoDocumentoXmlDTO> archivoDocumentoXmlCol;
	
	@OneToMany(mappedBy = "facturaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<FacturaDatoFinancieroDTO> facturaDatoFinancieroCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "VALORTIPOPLAZOPAGO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPOPLAZOPAGO", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO") })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO plazoPagoDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "VALORTIPOORIGEN", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPOORIGEN", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO") })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoOrigen;
	
	@OneToMany(mappedBy = "facturaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<ValidacionDocumentoDTO> facturaValidacionDocumentos;
	
	@OneToMany(mappedBy = "facturaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<ResumenTotalDocumentoDTO> resumenTotalDocumentoCol;
	
	// ************** repositorio Factura electronica *****************************
	/**
	 * Dto del catalogo de tipo de documentos: factura , nc, db; electronicas y fisicas
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "VALORTIPODOCUMENTOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPODOCUMENTOCATVAL", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO") })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoDocumentoFacturaDTO;
	
	/**
	 * Dto del catalogo de tipo de carga de documento: sri, normal, xml
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "VALORTIPOCARGADOCUMENTOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPOCARGADOCUMENTOCATVAL", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO") })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoCargaDocumentoDTO;
	
	/**
	 * Indica como fue cargado el archivo, si con un archivo XML o traido desde el SRI o de forma manual o Xml
	 */
	@Column(name="VALORTIPOCARGADOCUMENTOCATVAL")
	private String valorTipoCargaDocumentoCatVal;
	
	@Column(name="CODIGOTIPOCARGADOCUMENTOCATVAL")
	private Integer codigoTipoCargaDocumentoCatVal;
	
	/**
	 * Dto del catalogo de icas
	 */
	@ManyToOne(fetch= FetchType.LAZY)
	    @JoinColumns({
	    	@JoinColumn(name = "VALORICACATVAL", referencedColumnName= "CODIGOCATALOGOVALOR", insertable=false, updatable=false),
	    	@JoinColumn(name = "CODIGOICACATVAL", referencedColumnName = "CODIGOCATALOGOTIPO" , insertable = false, updatable= false)
	    })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO catalogoIcaDTO;
	
	/**
	 * Valor del catalogo de icas
	 */
	@Column(name="VALORICACATVAL")
	private String valorIcaCatVal;
	
	/**
	 * codigo del catalogo de icas
	 */
	@Column(name="CODIGOICACATVAL")
	private Integer codigoIcaCatVal;
	
		
	//****************************************************************************************
	
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
	 * Retorna valor de propiedad <code>tipoTarea</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>tipoTarea</code>
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoFactura(){
		return this.tipoFactura;
	}
	
	/**
	 * Establece un nuevo valor para la propiedad <code>tipoTarea</code>.
	 * @param tipoTarea 
	 *		El valor a establecer para la propiedad <code>tipoTarea</code>.
	 */
	public void setTipoFactura( ec.com.smx.corpv2.dto.CatalogoValorDTO tipoFactura ){
		this.tipoFactura=tipoFactura;
	}

	/**
	 * @return the id
	 */
	public FacturaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(FacturaID id) {
		this.id = id;
	}

	/**
	 * @return the codigoEntrega
	 */
	public Long getCodigoEntrega() {
		return codigoEntrega;
	}

	/**
	 * @param codigoEntrega the codigoEntrega to set
	 */
	public void setCodigoEntrega(Long codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	/**
	 * @return the fechaCaducidadAutorizacion
	 */
	public java.util.Date getFechaCaducidadAutorizacion() {
		return fechaCaducidadAutorizacion;
	}

	/**
	 * @param fechaCaducidadAutorizacion the fechaCaducidadAutorizacion to set
	 */
	public void setFechaCaducidadAutorizacion(
			java.util.Date fechaCaducidadAutorizacion) {
		this.fechaCaducidadAutorizacion = fechaCaducidadAutorizacion;
	}

	/**
	 * @return the entregaDTO
	 */
	public EntregaDTO getEntregaDTO() {
		return entregaDTO;
	}

	/**
	 * @param entregaDTO the entregaDTO to set
	 */
	public void setEntregaDTO(EntregaDTO entregaDTO) {
		this.entregaDTO = entregaDTO;
	}

	/**
	 * @return the valorTipoFactura
	 */
	public String getValorTipoFactura() {
		return valorTipoFactura;
	}

	/**
	 * @param valorTipoFactura the valorTipoFactura to set
	 */
	public void setValorTipoFactura(String valorTipoFactura) {
		this.valorTipoFactura = valorTipoFactura;
	}

	/**
	 * @return the codigoTipoFactura
	 */
	public Integer getCodigoTipoFactura() {
		return codigoTipoFactura;
	}

	/**
	 * @param codigoTipoFactura the codigoTipoFactura to set
	 */
	public void setCodigoTipoFactura(Integer codigoTipoFactura) {
		this.codigoTipoFactura = codigoTipoFactura;
	}

	/**
	 * @return the direccionProveedor
	 */
	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	/**
	 * @param direccionProveedor the direccionProveedor to set
	 */
	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return the valorTipoDocumentoFactura
	 */
	public String getValorTipoDocumentoFactura() {
		return valorTipoDocumentoFactura;
	}

	/**
	 * @param valorTipoDocumentoFactura the valorTipoDocumentoFactura to set
	 */
	public void setValorTipoDocumentoFactura(String valorTipoDocumentoFactura) {
		this.valorTipoDocumentoFactura = valorTipoDocumentoFactura;
	}

	/**
	 * @return the codigoTipoDocumentoFactura
	 */
	public Integer getCodigoTipoDocumentoFactura() {
		return codigoTipoDocumentoFactura;
	}

	/**
	 * @param codigoTipoDocumentoFactura the codigoTipoDocumentoFactura to set
	 */
	public void setCodigoTipoDocumentoFactura(Integer codigoTipoDocumentoFactura) {
		this.codigoTipoDocumentoFactura = codigoTipoDocumentoFactura;
	}

	/**
	 * @return the idUsuarioRegistro
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
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
	 * @return the idUsuarioModificacion
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}
	
	public Integer getCodigoAreaSublugarTrabajo() {
		return codigoAreaSublugarTrabajo;
	}

	public void setCodigoAreaSublugarTrabajo(Integer codigoAreaSublugarTrabajo) {
		this.codigoAreaSublugarTrabajo = codigoAreaSublugarTrabajo;
	}


	public AreaSublugarTrabajoDTO getAreaSublugarTrabajoDTO() {
		return areaSublugarTrabajoDTO;
	}

	public void setAreaSublugarTrabajoDTO(AreaSublugarTrabajoDTO areaSublugarTrabajoDTO) {
		this.areaSublugarTrabajoDTO = areaSublugarTrabajoDTO;
	}

	/**
	 * @return the proveedorDTO
	 */
	public VistaProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}

	/**
	 * @param proveedorDTO the proveedorDTO to set
	 */
	public void setProveedorDTO(VistaProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}

	/**
	 * @return the facturaEstadoDTOs
	 */
	public Collection<FacturaEstadoDTO> getFacturaEstadoDTOs() {
		return facturaEstadoDTOs;
	}

	/**
	 * @param facturaEstadoDTOs the facturaEstadoDTOs to set
	 */
	public void setFacturaEstadoDTOs(Collection<FacturaEstadoDTO> facturaEstadoDTOs) {
		this.facturaEstadoDTOs = facturaEstadoDTOs;
	}

	/**
	 * @return the nombreProveedor
	 */
	public String getNombreProveedor() {
		return nombreProveedor;
	}

	/**
	 * @param nombreProveedor the nombreProveedor to set
	 */
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	/**
	 * @return the ruc
	 */
	public String getRuc() {
		return ruc;
	}

	/**
	 * @param ruc the ruc to set
	 */
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	/**
	 * @return the numeroAutorizacion
	 */
	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}

	/**
	 * @param numeroAutorizacion the numeroAutorizacion to set
	 */
	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	/**
	 * 
	 * @return
	 */
	public Collection<FacturaDTO> getFacturasProveedor() {
		return facturasProveedor;
	}

	/**
	 * 
	 * @param facturasProveedor
	 */
	public void setFacturasProveedor(Collection<FacturaDTO> facturasProveedor) {
		this.facturasProveedor = facturasProveedor;
	}

	/**
	 * 
	 * @return
	 */
	@Deprecated
	public FacturaDTO getFacturaPadre() {
		return facturaPadre;
	}

	/**
	 * 
	 * @param facturaPadre
	 */
	@Deprecated
	public void setFacturaPadre(FacturaDTO facturaPadre) {
		this.facturaPadre = facturaPadre;
	}

	/**
	 * 
	 * @return
	 */
	@Deprecated
	public Long getCodigoFacturaPadre() {
		return codigoFacturaPadre;
	}

	/**
	 * 
	 * @param codigoFacturaPadre
	 */
	@Deprecated
	public void setCodigoFacturaPadre(Long codigoFacturaPadre) {
		this.codigoFacturaPadre = codigoFacturaPadre;
	}
	
	/**
	 * @return the codigoTipoFacturaEnSitio
	 */
	public Integer getCodigoTipoFacturaEnSitio() {
		return codigoTipoFacturaEnSitio;
	}

	/**
	 * @param codigoTipoFacturaEnSitio the codigoTipoFacturaEnSitio to set
	 */
	public void setCodigoTipoFacturaEnSitio(Integer codigoTipoFacturaEnSitio) {
		this.codigoTipoFacturaEnSitio = codigoTipoFacturaEnSitio;
	}

	/**
	 * @return the valorTipoFacturaEnSitio
	 */
	public String getValorTipoFacturaEnSitio() {
		return valorTipoFacturaEnSitio;
	}

	/**
	 * @param valorTipoFacturaEnSitio the valorTipoFacturaEnSitio to set
	 */
	public void setValorTipoFacturaEnSitio(String valorTipoFacturaEnSitio) {
		this.valorTipoFacturaEnSitio = valorTipoFacturaEnSitio;
	}

	/**
	 * @return the codigoTipoNotaCreditoFactura
	 */
	public Integer getCodigoTipoNotaCreditoFactura() {
		return codigoTipoNotaCreditoFactura;
	}

	/**
	 * @param codigoTipoNotaCreditoFactura the codigoTipoNotaCreditoFactura to set
	 */
	public void setCodigoTipoNotaCreditoFactura(Integer codigoTipoNotaCreditoFactura) {
		this.codigoTipoNotaCreditoFactura = codigoTipoNotaCreditoFactura;
	}

	/**
	 * @return the valorTipoNotaCreditoFactura
	 */
	public String getValorTipoNotaCreditoFactura() {
		return valorTipoNotaCreditoFactura;
	}

	/**
	 * @param valorTipoNotaCreditoFactura the valorTipoNotaCreditoFactura to set
	 */
	public void setValorTipoNotaCreditoFactura(String valorTipoNotaCreditoFactura) {
		this.valorTipoNotaCreditoFactura = valorTipoNotaCreditoFactura;
	}

	/**
	 * @return the tieneEntregaEstadoDTOCol
	 */
	public Boolean getTieneFacturaEstadoDTOCol() {
		return isLoaded(this.facturaEstadoDTOs) && !this.facturaEstadoDTOs.isEmpty();
	}
	
	/**
	 * Busca el estado activo actual de la factura
	 * @return Un FacturaEstadoDTO
	 */
	public FacturaEstadoDTO getFacturaEstadoDTOActivo() {
		if(this.getTieneFacturaEstadoDTOCol()){
			for(FacturaEstadoDTO facturaEstadoDTO : this.facturaEstadoDTOs){
				if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(facturaEstadoDTO.getEstado()) && facturaEstadoDTO.getFechaFin() == null){
					this.facturaEstadoDTOActivo = facturaEstadoDTO;
					break;
				}
			}
		}
		return facturaEstadoDTOActivo;
	}

	public Collection<RecepcionProveedorFacturaDTO> getRecepcionProveedorFacturaCol() {
		return recepcionProveedorFacturaCol;
	}

	public void setRecepcionProveedorFacturaCol(Collection<RecepcionProveedorFacturaDTO> recepcionProveedorFacturaCol) {
		this.recepcionProveedorFacturaCol = recepcionProveedorFacturaCol;
	}

	public Collection<RecepcionProveedorDTO> getRecepcionProveedorDTOCol() {
		if(isLoaded(this.getRecepcionProveedorFacturaCol())){
			this.recepcionProveedorDTOCol = new ArrayList<RecepcionProveedorDTO>();
			for (RecepcionProveedorFacturaDTO recepcionProveedorFacturaDTO : this.getRecepcionProveedorFacturaCol()) {
				this.recepcionProveedorDTOCol.add(recepcionProveedorFacturaDTO.getRecepcionProveedorDTO());
			}	
		}
		return this.recepcionProveedorDTOCol;
	}

	public ec.com.smx.corpv2.dto.CatalogoValorDTO getDiferenciaImpuestos() {
		return diferenciaImpuestos;
	}

	public void setDiferenciaImpuestos(ec.com.smx.corpv2.dto.CatalogoValorDTO diferenciaImpuestos) {
		this.diferenciaImpuestos = diferenciaImpuestos;
	}

	public Integer getCodigoDiferenciaImpuestosFactura() {
		return codigoDiferenciaImpuestosFactura;
	}

	public void setCodigoDiferenciaImpuestosFactura(Integer codigoDiferenciaImpuestosFactura) {
		this.codigoDiferenciaImpuestosFactura = codigoDiferenciaImpuestosFactura;
	}

	public String getValorDiferenciaImpuestosFactura() {
		return valorDiferenciaImpuestosFactura;
	}

	public void setValorDiferenciaImpuestosFactura(String valorDiferenciaImpuestosFactura) {
		this.valorDiferenciaImpuestosFactura = valorDiferenciaImpuestosFactura;
	}

	public void setFlujoEstadosFacturaCol(Collection<FlujoEstadoFacturaDTO> flujoEstadosFacturaCol) {
		this.flujoEstadosFacturaCol = flujoEstadosFacturaCol;
	}

	public java.lang.Long getCodigoLocalizacion() {
		return codigoLocalizacion;
	}

	public void setCodigoLocalizacion(java.lang.Long codigoLocalizacion) {
		this.codigoLocalizacion = codigoLocalizacion;
	}

	public String getRetener() {
		return retener;
	}

	public void setRetener(String retener) {
		this.retener = retener;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getCodigoSistema() {
		return codigoSistema;
	}

	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}

	public String getCodigoOpcion() {
		return codigoOpcion;
	}

	public void setCodigoOpcion(String codigoOpcion) {
		this.codigoOpcion = codigoOpcion;
	}

	public AccessItemDto getOpcion() {
		return opcion;
	}

	public void setOpcion(AccessItemDto opcion) {
		this.opcion = opcion;
	}

	public String getContabilizado() {
		return contabilizado;
	}

	public void setContabilizado(String contabilizado) {
		this.contabilizado = contabilizado;
	}

	public Integer getPlazoPago() {
		return plazoPago;
	}

	public void setPlazoPago(Integer plazoPago) {
		this.plazoPago = plazoPago;
	}

	public String getValorTipoPlazoPago() {
		return valorTipoPlazoPago;
	}

	public void setValorTipoPlazoPago(String valorTipoPlazoPago) {
		this.valorTipoPlazoPago = valorTipoPlazoPago;
	}

	public Integer getCodigoTipoPlazoPago() {
		return codigoTipoPlazoPago;
	}

	public void setCodigoTipoPlazoPago(Integer codigoTipoPlazoPago) {
		this.codigoTipoPlazoPago = codigoTipoPlazoPago;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getPrimerNumeroFacturaProveedor() {
		return primerNumeroFacturaProveedor;
	}

	public void setPrimerNumeroFacturaProveedor(String primerNumeroFacturaProveedor) {
		this.primerNumeroFacturaProveedor = primerNumeroFacturaProveedor;
	}

	public String getCodigoAcceso() {
		return codigoAcceso;
	}

	public void setCodigoAcceso(String codigoAcceso) {
		this.codigoAcceso = codigoAcceso;
	}

	public Integer getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(Integer tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Collection<FacturaDatoFinancieroDTO> getFacturaDatoFinancieroCol() {
		return facturaDatoFinancieroCol;
	}

	public void setFacturaDatoFinancieroCol(Collection<FacturaDatoFinancieroDTO> facturaDatoFinancieroCol) {
		this.facturaDatoFinancieroCol = facturaDatoFinancieroCol;
	}
	
	/**
	 * @return the transaccionDTO
	 */
	public TransaccionDTO getTransaccionDTO() {
		return transaccionDTO;
	}

	/**
	 * @param transaccionDTO the transaccionDTO to set
	 */
	public void setTransaccionDTO(TransaccionDTO transaccionDTO) {
		this.transaccionDTO = transaccionDTO;
	}

	public java.util.Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(java.util.Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public void setFacturaEstadoDTOActivo(FacturaEstadoDTO facturaEstadoDTOActivo) {
		this.facturaEstadoDTOActivo = facturaEstadoDTOActivo;
	}

	public Collection<FacturaRelacionadaDTO> getFacturaRelacionadaCol() {
		return facturaRelacionadaCol;
	}

	public void setFacturaRelacionadaCol(Collection<FacturaRelacionadaDTO> facturaRelacionadaCol) {
		this.facturaRelacionadaCol = facturaRelacionadaCol;
	}

	public Collection<FlujoEstadoFacturaDTO> getFlujoEstadosFacturaCol() {
		return flujoEstadosFacturaCol;
	}

	public void setRecepcionProveedorDTOCol(Collection<RecepcionProveedorDTO> recepcionProveedorDTOCol) {
		this.recepcionProveedorDTOCol = recepcionProveedorDTOCol;
	}

	public ec.com.smx.corpv2.dto.CatalogoValorDTO getPlazoPagoDTO() {
		return plazoPagoDTO;
	}

	public void setPlazoPagoDTO(ec.com.smx.corpv2.dto.CatalogoValorDTO plazoPagoDTO) {
		this.plazoPagoDTO = plazoPagoDTO;
	}

	public Collection<FacturaRelacionadaDTO> getFacturaRelacionadaHijasCol() {
		return facturaRelacionadaHijasCol;
	}

	public void setFacturaRelacionadaHijasCol(Collection<FacturaRelacionadaDTO> facturaRelacionadaHijasCol) {
		this.facturaRelacionadaHijasCol = facturaRelacionadaHijasCol;
	}

	public Collection<ArchivoDocumentoXmlDTO> getArchivoDocumentoXmlCol() {
		return archivoDocumentoXmlCol;
	}

	public void setArchivoDocumentoXmlCol(Collection<ArchivoDocumentoXmlDTO> archivoDocumentoXmlCol) {
		this.archivoDocumentoXmlCol = archivoDocumentoXmlCol;
	}

	public String getValorTipoOrigen() {
		return valorTipoOrigen;
	}

	public void setValorTipoOrigen(String valorTipoOrigen) {
		this.valorTipoOrigen = valorTipoOrigen;
	}

	public Integer getCodigoTipoOrigen() {
		return codigoTipoOrigen;
	}

	public void setCodigoTipoOrigen(Integer codigoTipoOrigen) {
		this.codigoTipoOrigen = codigoTipoOrigen;
	}

	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoOrigen() {
		return tipoOrigen;
	}

	public void setTipoOrigen(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoOrigen) {
		this.tipoOrigen = tipoOrigen;
	}

	public Collection<ControlRecipienteDetalleDTO> getDetalleRecipientesCol() {
		return detalleRecipientesCol;
	}

	public void setDetalleRecipientesCol(Collection<ControlRecipienteDetalleDTO> detalleRecipientesCol) {
		this.detalleRecipientesCol = detalleRecipientesCol;
	}

	/**
	 * @return the facturaAutorizacion
	 */
	public DocumentoElectronicoSRI getFacturaAutorizacion() {
		return facturaAutorizacion;
	}

	/**
	 * @param facturaAutorizacion the facturaAutorizacion to set
	 */
	public void setFacturaAutorizacion(DocumentoElectronicoSRI facturaAutorizacion) {
		this.facturaAutorizacion = facturaAutorizacion;
	}

	/**
	 * @return the facturaValidacionDocumentos
	 */
	public Collection<ValidacionDocumentoDTO> getFacturaValidacionDocumentos() {
		return facturaValidacionDocumentos;
	}

	/**
	 * @param facturaValidacionDocumentos the facturaValidacionDocumentos to set
	 */
	public void setFacturaValidacionDocumentos(Collection<ValidacionDocumentoDTO> facturaValidacionDocumentos) {
		this.facturaValidacionDocumentos = facturaValidacionDocumentos;
	}

	/**
	 * @return the tipoDocumentoFacturaDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoDocumentoFacturaDTO() {
		return tipoDocumentoFacturaDTO;
	}

	/**
	 * @param tipoDocumentoFacturaDTO the tipoDocumentoFacturaDTO to set
	 */
	public void setTipoDocumentoFacturaDTO(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoDocumentoFacturaDTO) {
		this.tipoDocumentoFacturaDTO = tipoDocumentoFacturaDTO;
	}

	/**
	 * @return the tipoCargaDocumentoDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoCargaDocumentoDTO() {
		return tipoCargaDocumentoDTO;
	}

	/**
	 * @param tipoCargaDocumentoDTO the tipoCargaDocumentoDTO to set
	 */
	public void setTipoCargaDocumentoDTO(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoCargaDocumentoDTO) {
		this.tipoCargaDocumentoDTO = tipoCargaDocumentoDTO;
	}

	/**
	 * @return the valorTipoCargaDocumentoCatVal
	 */
	public String getValorTipoCargaDocumentoCatVal() {
		return valorTipoCargaDocumentoCatVal;
	}

	/**
	 * @param valorTipoCargaDocumentoCatVal the valorTipoCargaDocumentoCatVal to set
	 */
	public void setValorTipoCargaDocumentoCatVal(String valorTipoCargaDocumentoCatVal) {
		this.valorTipoCargaDocumentoCatVal = valorTipoCargaDocumentoCatVal;
	}

	/**
	 * @return the codigoTipoCargaDocumentoCatVal
	 */
	public Integer getCodigoTipoCargaDocumentoCatVal() {
		return codigoTipoCargaDocumentoCatVal;
	}

	/**
	 * @param codigoTipoCargaDocumentoCatVal the codigoTipoCargaDocumentoCatVal to set
	 */
	public void setCodigoTipoCargaDocumentoCatVal(Integer codigoTipoCargaDocumentoCatVal) {
		this.codigoTipoCargaDocumentoCatVal = codigoTipoCargaDocumentoCatVal;
	}

	/**
	 * @return the catalogoIcaDTO
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getCatalogoIcaDTO() {
		return catalogoIcaDTO;
	}

	/**
	 * @param catalogoIcaDTO the catalogoIcaDTO to set
	 */
	public void setCatalogoIcaDTO(ec.com.smx.corpv2.dto.CatalogoValorDTO catalogoIcaDTO) {
		this.catalogoIcaDTO = catalogoIcaDTO;
	}

	/**
	 * @return the valorIcaCatVal
	 */
	public String getValorIcaCatVal() {
		return valorIcaCatVal;
	}

	/**
	 * @param valorIcaCatVal the valorIcaCatVal to set
	 */
	public void setValorIcaCatVal(String valorIcaCatVal) {
		this.valorIcaCatVal = valorIcaCatVal;
	}

	/**
	 * @return the codigoIcaCatVal
	 */
	public Integer getCodigoIcaCatVal() {
		return codigoIcaCatVal;
	}

	/**
	 * @param codigoIcaCatVal the codigoIcaCatVal to set
	 */
	public void setCodigoIcaCatVal(Integer codigoIcaCatVal) {
		this.codigoIcaCatVal = codigoIcaCatVal;
	}

	/**
	 * @return the numeroCaso
	 */
	public String getNumeroCaso() {
		return numeroCaso;
	}

	/**
	 * @param numeroCaso the numeroCaso to set
	 */
	public void setNumeroCaso(String numeroCaso) {
		this.numeroCaso = numeroCaso;
	}

	/**
	 * @return the resumenTotalDocumentoCol
	 */
	public Collection<ResumenTotalDocumentoDTO> getResumenTotalDocumentoCol() {
		return resumenTotalDocumentoCol;
	}

	/**
	 * @param resumenTotalDocumentoCol the resumenTotalDocumentoCol to set
	 */
	public void setResumenTotalDocumentoCol(Collection<ResumenTotalDocumentoDTO> resumenTotalDocumentoCol) {
		this.resumenTotalDocumentoCol = resumenTotalDocumentoCol;
	}
}