/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.auditoria.common.annotation.Auditable;
import ec.com.smx.frameworkv2.auditoria.common.annotation.Etiqueta;
import ec.com.smx.frameworkv2.auditoria.common.util.AuditLogConstant;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorComercialID;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTPROCOM")
public class ProveedorComercialDTO extends AuditoriaBaseDTO {
	
	public ProveedorComercialDTO(){
		this.id = new ProveedorComercialID();
	}
	
	
	
	@EmbeddedId
	private ProveedorComercialID id;


	/**
	 * Interproveedor siginifica si un proveedor es especial, esto quiere decir que el SMX mantiene relaciones especiales con estos proveedores, como por ejemplo traspaso de informaci�n, puede tener los valores [1] SI APLICA, [0] NO APLICA
	 *

	 */
	private String interproveedor;

	/**
	 * Codigo del catalogo para los valores de interproveedor
	 */
	private Integer codigoInterproveedor;



	/**
	 * Indica si el mes actual paga espacios en percha. Los posibles valores son:
	0.- no paga
	1.- si paga
	 */
	private String pagaEspacioPercha ;

	/**
	 * C�digo de los valores para pago de espacio en percha
	 */
	private Integer codigoPagaEspacioPercha;



	/**
	 * Detalla si el mes actual paga lo mismo del mes anterior de espacio en percha. Los posibles valores son:
	0.- no paga igual
	1.- paga igual
	 */
	private String pagaEspacioPerchaIgualAnterior ;


	/**
	 * C�digo de los valores para pago de espacio en percha
	 */
	@Column(name="CODPAGESPPERIGUANT")
	private Integer codigoPagaEspacioPerchaIgualAnterior;

	
	/**
	 * Estable la cantidad de dias en los que se debe pagar al proveedor
	 */
	@Column(name = "VALORTIPOPLAZOPAGO", nullable = false)
	private String valorTipoPlazoPago;

	
	/**
	 * Establece el codigo del plazo de pago
	 */
	@Column(name = "CODIGOTIPOPLAZOPAGO", nullable = false)
	private Integer codigoTipoPlazoPago;
	
	/**
	 * Indica la fecha del Inicio de Operaci\u00F3n
	 */
	@Column(name = "FECHAINICIOOPERACION", nullable = true)
	private Date fechaInicioOperacion;

	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private ProveedorDTO proveedor;




	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "PAGAESPACIOPERCHA", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPAGAESPACIOPERCHA", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO caracteristicaPagaEspacioPercha;


	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "PAGAESPACIOPERCHAIGUALANTERIOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODPAGESPPERIGUANT", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO caracteristicaPagaEspacioPerchaIgualAnterior;



	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "INTERPROVEEDOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOINTERPROVEEDOR", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO caracteristicaInterproveedor;

	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "VALORTIPOPLAZOPAGO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOPLAZOPAGO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO tipoPlazoPago;

	
	/**
	 * @return the caracteristicaInterproveedor
	 */
	@Auditable(id = AuditLogConstant.MAX_PROVEEDOR)
	@Etiqueta(etiquetaRelacion="Interproveedor")
	public CatalogoValorDTO getCaracteristicaInterproveedor() {
		return caracteristicaInterproveedor;
	}

	/**
	 * @param caracteristicaInterproveedor the caracteristicaInterproveedor to set
	 */
	public void setCaracteristicaInterproveedor(
			CatalogoValorDTO caracteristicaInterproveedor) {
		this.caracteristicaInterproveedor = caracteristicaInterproveedor;
	}



	/**
	 * @return the id
	 */
	public ProveedorComercialID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ProveedorComercialID id) {
		this.id = id;
	}

	/**
	 * @return the interproveedor
	 */
	public String getInterproveedor() {
		return interproveedor;
	}

	/**
	 * @param interproveedor the interproveedor to set
	 */
	public void setInterproveedor(String interproveedor) {
		this.interproveedor = interproveedor;
	}

	/**
	 * @return the codigoInterproveedor
	 */
	public Integer getCodigoInterproveedor() {
		return codigoInterproveedor;
	}

	/**
	 * @param codigoInterproveedor the codigoInterproveedor to set
	 */
	public void setCodigoInterproveedor(Integer codigoInterproveedor) {
		this.codigoInterproveedor = codigoInterproveedor;
	}


	/**
	 * @return the pagaEspacioPercha
	 */
	public String getPagaEspacioPercha() {
		return pagaEspacioPercha;
	}

	/**
	 * @param pagaEspacioPercha the pagaEspacioPercha to set
	 */
	public void setPagaEspacioPercha(String pagaEspacioPercha) {
		this.pagaEspacioPercha = pagaEspacioPercha;
	}

	/**
	 * @return the codigoPagaEspacioPercha
	 */
	public Integer getCodigoPagaEspacioPercha() {
		return codigoPagaEspacioPercha;
	}

	/**
	 * @param codigoPagaEspacioPercha the codigoPagaEspacioPercha to set
	 */
	public void setCodigoPagaEspacioPercha(Integer codigoPagaEspacioPercha) {
		this.codigoPagaEspacioPercha = codigoPagaEspacioPercha;
	}

	/**
	 * @return the pagaEspacioPerchaIgualAnterior
	 */
	public String getPagaEspacioPerchaIgualAnterior() {
		return pagaEspacioPerchaIgualAnterior;
	}

	/**
	 * @param pagaEspacioPerchaIgualAnterior the pagaEspacioPerchaIgualAnterior to set
	 */
	public void setPagaEspacioPerchaIgualAnterior(
			String pagaEspacioPerchaIgualAnterior) {
		this.pagaEspacioPerchaIgualAnterior = pagaEspacioPerchaIgualAnterior;
	}

	/**
	 * @return the codigoPagaEspacioPerchaIgualAnterior
	 */
	public Integer getCodigoPagaEspacioPerchaIgualAnterior() {
		return codigoPagaEspacioPerchaIgualAnterior;
	}

	/**
	 * @param codigoPagaEspacioPerchaIgualAnterior the codigoPagaEspacioPerchaIgualAnterior to set
	 */
	public void setCodigoPagaEspacioPerchaIgualAnterior(
			Integer codigoPagaEspacioPerchaIgualAnterior) {
		this.codigoPagaEspacioPerchaIgualAnterior = codigoPagaEspacioPerchaIgualAnterior;
	}

	/**
	 * @return the proveedor
	 */
	public ProveedorDTO getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the caracteristicaPagaEspacioPercha
	 */
	public CatalogoValorDTO getCaracteristicaPagaEspacioPercha() {
		return caracteristicaPagaEspacioPercha;
	}

	/**
	 * @param caracteristicaPagaEspacioPercha the caracteristicaPagaEspacioPercha to set
	 */
	public void setCaracteristicaPagaEspacioPercha(
			CatalogoValorDTO caracteristicaPagaEspacioPercha) {
		this.caracteristicaPagaEspacioPercha = caracteristicaPagaEspacioPercha;
	}

	/**
	 * @return the caracteristicaPagaEspacioPerchaIgualAnterior
	 */
	public CatalogoValorDTO getCaracteristicaPagaEspacioPerchaIgualAnterior() {
		return caracteristicaPagaEspacioPerchaIgualAnterior;
	}

	/**
	 * @param caracteristicaPagaEspacioPerchaIgualAnterior the caracteristicaPagaEspacioPerchaIgualAnterior to set
	 */
	public void setCaracteristicaPagaEspacioPerchaIgualAnterior(
			CatalogoValorDTO caracteristicaPagaEspacioPerchaIgualAnterior) {
		this.caracteristicaPagaEspacioPerchaIgualAnterior = caracteristicaPagaEspacioPerchaIgualAnterior;
	}

	/**
	 * @return the valorTipoPlazoPago
	 */
	public String getValorTipoPlazoPago() {
		return valorTipoPlazoPago;
	}

	/**
	 * @param valorTipoPlazoPago the valorTipoPlazoPago to set
	 */
	public void setValorTipoPlazoPago(String valorTipoPlazoPago) {
		this.valorTipoPlazoPago = valorTipoPlazoPago;
	}

	/**
	 * @return the codigoTipoPlazoPago
	 */
	public Integer getCodigoTipoPlazoPago() {
		return codigoTipoPlazoPago;
	}

	/**
	 * @param codigoTipoPlazoPago the codigoTipoPlazoPago to set
	 */
	public void setCodigoTipoPlazoPago(Integer codigoTipoPlazoPago) {
		this.codigoTipoPlazoPago = codigoTipoPlazoPago;
	}
	
	/**
	 * @return the fechaInicioOperacion
	 */
	public Date getFechaInicioOperacion() {
		return fechaInicioOperacion;
	}
	
	/**
	 * @param fechaInicioOperacion the fechaInicioOperacion to set
	 */
	public void setFechaInicioOperacion(Date fechaInicioOperacion) {
		this.fechaInicioOperacion = fechaInicioOperacion;
	}

	/**
	 * @return the tipoPlazoPago
	 */
	public CatalogoValorDTO getTipoPlazoPago() {
		return tipoPlazoPago;
	}

	/**
	 * @param tipoPlazoPago the tipoPlazoPago to set
	 */
	public void setTipoPlazoPago(CatalogoValorDTO tipoPlazoPago) {
		this.tipoPlazoPago = tipoPlazoPago;
	}
}
