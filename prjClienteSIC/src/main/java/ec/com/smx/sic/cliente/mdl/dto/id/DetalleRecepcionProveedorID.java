
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase DetalleRecepcionProveedor
 * @see ec.com.smx.sic.cliente.mdl.dto.DetalleRecepcionProveedorDTO
 *
 * @author lguaman
 */
@SuppressWarnings("serial")
@Embeddable
public class DetalleRecepcionProveedorID implements Serializable{

	/**
	 * Codigo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;

	/**
	 * Secuencial de la tabla Detalle Recepcion Proveedor
	 * 
	 */
	@Column(name = "CODIGODETALLERECEPCIONPROVEEDOR", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECDETRECPRO")
	private java.lang.Long codigoDetalleRecepcionProveedor;

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania(){
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * @param codigoCompania1 
	 *		El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania( Integer codigoCompania1 ){
		this.codigoCompania=codigoCompania1;
	}

	/**
	 * @return the codigoDetalleRecepcionProveedor
	 */
	public java.lang.Long getCodigoDetalleRecepcionProveedor() {
		return codigoDetalleRecepcionProveedor;
	}

	/**
	 * @param codigoRecepcionProveedorFurgon the codigoDetalleRecepcionProveedor to set
	 */
	public void setCodigoDetalleRecepcionProveedor(java.lang.Long codigoDetalleRecepcionProveedor) {
		this.codigoDetalleRecepcionProveedor = codigoDetalleRecepcionProveedor;
	}

}

