
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase RecepcionProveedor
 * @see ec.com.smx.sic.cliente.mdl.dto.AsignacionProceso
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class EntregaRecepcionProveedorID implements Serializable{

	/**
	 * Codigo de la compania
	 *

	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	
	/**
	 * Secuencial de la tabla EntregaRecepcionProveedor
	 *

	 */
	@Column(name = "CODIGOENTREGA", nullable = false)
	private Long codigoEntrega ;

	/**
	 * Secuencial de la tabla AsignacionProceso
	 *

	 */
	@Column(name = "CODIGORECEPCIONPROVEEDOR", nullable = false)
	private Long codigoRecepcionProveedor ;
		
	

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
	 * @return the codigoRecepcionProveedor
	 */
	public Long getCodigoRecepcionProveedor() {
		return codigoRecepcionProveedor;
	}

	/**
	 * @param codigoRecepcionProveedor the codigoRecepcionProveedor to set
	 */
	public void setCodigoRecepcionProveedor(Long codigoRecepcionProveedor) {
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
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

}

