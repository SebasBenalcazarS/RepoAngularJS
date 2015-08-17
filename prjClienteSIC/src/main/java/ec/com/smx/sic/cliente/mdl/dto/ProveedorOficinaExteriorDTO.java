
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.auditoria.common.annotation.Auditable;
import ec.com.smx.frameworkv2.auditoria.common.annotation.Etiqueta;
import ec.com.smx.frameworkv2.auditoria.common.util.AuditLogConstant;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorOficinaExteriorID;



/**
 * Entidad que almacena los datos tanto de los proveedores como de las oficinas exterior
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTPROOFIEXT")
public class ProveedorOficinaExteriorDTO extends AuditoriaBaseDTO{


	public ProveedorOficinaExteriorDTO(){
		this.id = new ProveedorOficinaExteriorID();
	}

	@EmbeddedId
	private ProveedorOficinaExteriorID id;
	
	/*
	 * Indica el codigo del catalogo de tipos de asignaciones de la oficina en el exterior al proveedor
	 */
	@Column(name = "CODTIPASIOFIEXT")
	private Integer codigoTipoAsignacionOficinaExterior ;

	/*
	 * Indica el tipo de asignacion de la oficina en el exterior al proveedor:

		-PRE: Predeterminada
		-NPR: No predeterminada
	 */
	@ComparatorTypeField
	@Column(name = "VALTIPASIOFIEXT")
	private String valorTipoAsignacionOficinaExterior ;

	
	/*
	 * Estado del registro:
	1.- Activo
	0.- Inactivo
	 */
	@ComparatorTypeField
	private String estadoProveedorOficinaExterior;
	

	/**
	 * Porcentaje que se debe pagar a la oficina en el exterior que se hace 
	 * cargo de las importaciones de un proveedor.
	 *
	 */
	private BigDecimal porcentajeComisionImportacion ;
	
	/*
	 * Indica si el proveedor recibe la factura de una promocion en una oficina exterior
	 * 1: Recibe la factura en la oficina exterior
	 * 0: Recibe la factura directamente el proveedor
	 */
	@ComparatorTypeField
	@Column(name = "VALORFACTURARPROMOCION")
	private String valorFacturarPromocion ;
	
	/*
	 * Codigo facturar una promocion en una oficina exterior
	 */
	@ComparatorTypeField
	@Column(name = "CODIGOFACTURARPROMOCION")
	private String codigoFacturarPromocion ;	
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOFACTURARPROMOCION", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "VALORFACTURARPROMOCION", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorDTO tipoFacturarPromocion;


	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false)
	private ec.com.smx.corpv2.dto.CompaniaDTO compania;


	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO proveedor;
	

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private VistaProveedorDTO vistaProveedor;


	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOOFICINAEXTERIOR", referencedColumnName = "CODIGOOFICINAEXTERIOR", insertable = false, updatable = false)
		})
	private ec.com.smx.sic.cliente.mdl.dto.OficinaExteriorDTO oficinaExterior;


	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "VALTIPASIOFIEXT", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOVALOR"),
		@JoinColumn(name = "CODTIPASIOFIEXT", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)})
	private CatalogoValorDTO tipoAsignacionOficinaExterior;


 
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ProveedorOficinaExteriorID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ec.com.smx.sic.cliente.mdl.dto.id.ProveedorOficinaExteriorID id1 ){
		this.id=id1;
	}


	
		

	/**
	 * Retorna valor de propiedad <code>porcentajeComisionImportacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>porcentajeComisionImportacion</code>
	 */
	@Auditable(id = AuditLogConstant.MAX_PROVEEDOR, label="Porcentaje de comisi\u00F3n")
	public BigDecimal getPorcentajeComisionImportacion(){
		return this.porcentajeComisionImportacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>porcentajeComisionImportacion</code>.
	 * @param porcentajeComisionImportacion1 
	 *		El valor a establecer para la propiedad <code>porcentajeComisionImportacion</code>.
	 */
	public void setPorcentajeComisionImportacion(BigDecimal porcentajeComisionImportacion1 ){
		this.porcentajeComisionImportacion=porcentajeComisionImportacion1;
		
	}

	
		

	/**
	 * Retorna valor de propiedad <code>compania</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>compania</code>
	 */
	public ec.com.smx.corpv2.dto.CompaniaDTO getCompania(){
		return this.compania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>compania</code>.
	 * @param compania1 
	 *		El valor a establecer para la propiedad <code>compania</code>.
	 */
	public void setCompania( ec.com.smx.corpv2.dto.CompaniaDTO compania1 ){
		this.compania=compania1;
	}


	/**
	 * Retorna valor de propiedad <code>proveedor</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>proveedor</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO getProveedor(){
		return this.proveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>proveedor</code>.
	 * @param proveedor1 
	 *		El valor a establecer para la propiedad <code>proveedor</code>.
	 */
	public void setProveedor( ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO proveedor1 ){
		this.proveedor=proveedor1;
	}


	/**
	 * Retorna valor de propiedad <code>oficinaExterior</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>oficinaExterior</code>
	 */
	@Auditable(id = AuditLogConstant.MAX_PROVEEDOR)
	@Etiqueta(etiquetaRelacion="Oficina Exterior")
	public ec.com.smx.sic.cliente.mdl.dto.OficinaExteriorDTO getOficinaExterior(){
		return this.oficinaExterior;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>oficinaExterior</code>.
	 * @param oficinaExterior1 
	 *		El valor a establecer para la propiedad <code>oficinaExterior</code>.
	 */
	public void setOficinaExterior( ec.com.smx.sic.cliente.mdl.dto.OficinaExteriorDTO oficinaExterior1 ){
		this.oficinaExterior=oficinaExterior1;
	}


	/**
	 * @return the vistaProveedor
	 */
	public VistaProveedorDTO getVistaProveedor() {
		return vistaProveedor;
	}

	/**
	 * @param vistaProveedor the vistaProveedor to set
	 */
	public void setVistaProveedor(VistaProveedorDTO vistaProveedor) {
		this.vistaProveedor = vistaProveedor;
	}

	/**
	 * @return the codigoTipoAsignacionOficinaExterior
	 */
	public Integer getCodigoTipoAsignacionOficinaExterior() {
		return codigoTipoAsignacionOficinaExterior;
	}

	/**
	 * @param codigoTipoAsignacionOficinaExterior the codigoTipoAsignacionOficinaExterior to set
	 */
	public void setCodigoTipoAsignacionOficinaExterior(
			Integer codigoTipoAsignacionOficinaExterior) {
		this.codigoTipoAsignacionOficinaExterior = codigoTipoAsignacionOficinaExterior;
	}

	/**
	 * @return the valorTipoAsignacionOficinaExterior
	 */
	public String getValorTipoAsignacionOficinaExterior() {
		return valorTipoAsignacionOficinaExterior;
	}

	/**
	 * @param valorTipoAsignacionOficinaExterior the valorTipoAsignacionOficinaExterior to set
	 */
	public void setValorTipoAsignacionOficinaExterior(
			String valorTipoAsignacionOficinaExterior) {
		this.valorTipoAsignacionOficinaExterior = valorTipoAsignacionOficinaExterior;
	}

	/**
	 * @return the estadoProveedorOficinaExterior
	 */
	public String getEstadoProveedorOficinaExterior() {
		return estadoProveedorOficinaExterior;
	}

	/**
	 * @param estadoProveedorOficinaExterior the estadoProveedorOficinaExterior to set
	 */
	public void setEstadoProveedorOficinaExterior(
			String estadoProveedorOficinaExterior) {
		this.estadoProveedorOficinaExterior = estadoProveedorOficinaExterior;
	}

	/**
	 * @return the tipoAsignacionOficinaExterior
	 */
	@Auditable(id = AuditLogConstant.MAX_PROVEEDOR)
	@Etiqueta(etiquetaRelacion="Oficina Predeterminada")
	public CatalogoValorDTO getTipoAsignacionOficinaExterior() {
		return tipoAsignacionOficinaExterior;
	}

	/**
	 * @param tipoAsignacionOficinaExterior the tipoAsignacionOficinaExterior to set
	 */
	public void setTipoAsignacionOficinaExterior(
			CatalogoValorDTO tipoAsignacionOficinaExterior) {
		this.tipoAsignacionOficinaExterior = tipoAsignacionOficinaExterior;
	}

	/**
	 * @return the valorFacturarPromocion
	 */
	public String getValorFacturarPromocion() {
		return valorFacturarPromocion;
	}

	/**
	 * @param valorFacturarPromocion the valorFacturarPromocion to set
	 */
	public void setValorFacturarPromocion(String valorFacturarPromocion) {
		this.valorFacturarPromocion = valorFacturarPromocion;
	}

	/**
	 * @return the codigoFacturarPromocion
	 */
	public String getCodigoFacturarPromocion() {
		return codigoFacturarPromocion;
	}

	/**
	 * @param codigoFacturarPromocion the codigoFacturarPromocion to set
	 */
	public void setCodigoFacturarPromocion(String codigoFacturarPromocion) {
		this.codigoFacturarPromocion = codigoFacturarPromocion;
	}

	/**
	 * @return the tipoFacturarPromocion
	 */
	public CatalogoValorDTO getTipoFacturarPromocion() {
		return tipoFacturarPromocion;
	}

	/**
	 * @param tipoFacturarPromocion the tipoFacturarPromocion to set
	 */
	public void setTipoFacturarPromocion(CatalogoValorDTO tipoFacturarPromocion) {
		this.tipoFacturarPromocion = tipoFacturarPromocion;
	}
	
}

