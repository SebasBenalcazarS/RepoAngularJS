package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorFinancieroID;

/**
 * Entidad que almacena datos financieros del proveedor
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTPROFIN")
public class ProveedorFinancieroDTO extends AuditoriaBaseDTO{



	/**
	 * 
	 *
	 */
	@EmbeddedId
	private ProveedorFinancieroID id = new ProveedorFinancieroID();


		
		

	/**
	 * Indica si a un provedor se le puede facturar mediante pronto pago.
Los valores permitidos son:
[0] Inactivo
[1] Activo
	 *

	 */
	private String autorizadoProntoPago ;
	
	/**
	 * Código de los valores para indicar la autorización de prontopago
	 */
	private Integer codigoAutorizadoProntoPago;

	


	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)})
	private ProveedorDTO proveedor;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "AUTORIZADOPRONTOPAGO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOAUTORIZADOPRONTOPAGO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO caracteristicaAutorizadoProntoPago;
	
	
 
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public ProveedorFinancieroID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( ProveedorFinancieroID id1 ){
		this.id=id1;
	}


		
		

	/**
	 * Retorna valor de propiedad <code>autorizadoProntoPago</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>autorizadoProntoPago</code>
	 */
	public String getAutorizadoProntoPago(){
		return this.autorizadoProntoPago;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>autorizadoProntoPago</code>.
	 * @param autorizadoProntoPago1 
	 *		El valor a establecer para la propiedad <code>autorizadoProntoPago</code>.
	 */
	public void setAutorizadoProntoPago( String autorizadoProntoPago1 ){
		this.autorizadoProntoPago=autorizadoProntoPago1;
		
		if(autorizadoProntoPago!=null && autorizadoProntoPago.length()>1){
			autorizadoProntoPago = autorizadoProntoPago.substring(0,1);
		}
				
				
	}


		

	/**
	 * Retorna valor de propiedad <code>proveedor</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>proveedor</code>
	 */
	public ProveedorDTO getProveedor(){
		return this.proveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>proveedor</code>.
	 * @param proveedor1 
	 *		El valor a establecer para la propiedad <code>proveedor</code>.
	 */
	public void setProveedor( ProveedorDTO proveedor1 ){
		this.proveedor=proveedor1;
	}

	/**
	 * @return the codigoAutorizadoProntoPago
	 */
	public Integer getCodigoAutorizadoProntoPago() {
		return codigoAutorizadoProntoPago;
	}

	/**
	 * @param codigoAutorizadoProntoPago the codigoAutorizadoProntoPago to set
	 */
	public void setCodigoAutorizadoProntoPago(Integer codigoAutorizadoProntoPago) {
		this.codigoAutorizadoProntoPago = codigoAutorizadoProntoPago;
	}



	/**
	 * @return the caracteristicaAutorizadoProntoPago
	 */
	public CatalogoValorDTO getCaracteristicaAutorizadoProntoPago() {
		return caracteristicaAutorizadoProntoPago;
	}

	/**
	 * @param caracteristicaAutorizadoProntoPago the caracteristicaAutorizadoProntoPago to set
	 */
	public void setCaracteristicaAutorizadoProntoPago(
			CatalogoValorDTO caracteristicaAutorizadoProntoPago) {
		this.caracteristicaAutorizadoProntoPago = caracteristicaAutorizadoProntoPago;
	}


	
	
}

