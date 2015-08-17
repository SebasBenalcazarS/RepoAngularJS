
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author esanchez
 * 
 */
@Embeddable
@SuppressWarnings("serial")
public class EntregaDetallePedidoEspecialID extends BaseID {

	@SequenceDataBaseValue(name="SCSPESECDETENTPED",descriptorClass=DescriptorSecuenciasSIC.class)
	@Column(name = "CODIGODETALLEENTREGAPEDIDO")
	private java.lang.Long codigoDetalleEntregaPedido ;
		
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania ;
		
	

	/**
	 * Retorna valor de propiedad <code>codigoDetalleEntregaPedido</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoDetalleEntregaPedido</code>
	 */
	public java.lang.Long getCodigoDetalleEntregaPedido(){
		return this.codigoDetalleEntregaPedido;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoDetalleEntregaPedido</code>.
	 * @param codigoDetalleEntregaPedido1 
	 *		El valor a establecer para la propiedad <code>codigoDetalleEntregaPedido</code>.
	 */
	public void setCodigoDetalleEntregaPedido( java.lang.Long codigoDetalleEntregaPedido1 ){
		this.codigoDetalleEntregaPedido=codigoDetalleEntregaPedido1;
		
	}

		

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


}

