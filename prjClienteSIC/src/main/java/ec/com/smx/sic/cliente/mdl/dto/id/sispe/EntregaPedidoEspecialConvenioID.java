
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase EntregaPedidoConvenio
 * @see ec.com.smx.sic.sispe.dto.EntregaPedidoConvenio
 *
 * @author bgudino
 */
@Embeddable
@SuppressWarnings("serial")
public class EntregaPedidoEspecialConvenioID extends BaseID {




	/**
	 * id de tabla (secuencial de base)
	 *

	 */
	@SequenceDataBaseValue(name="SCSPESECENTPEDCON",descriptorClass=DescriptorSecuenciasSIC.class)
	@Column(name = "CODIGOENTREGAPEDIDOCONVENIO")
	private Long codigoEntregaPedidoConvenio ;
		

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania ;
	
	

	/**
	 * Retorna valor de propiedad <code>codigoEntregaPedidoConvenio</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoEntregaPedidoConvenio</code>
	 */
	public Long getCodigoEntregaPedidoConvenio(){
		return this.codigoEntregaPedidoConvenio;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoEntregaPedidoConvenio</code>.
	 * @param codigoEntregaPedidoConvenio1 
	 *		El valor a establecer para la propiedad <code>codigoEntregaPedidoConvenio</code>.
	 */
	public void setCodigoEntregaPedidoConvenio( Long codigoEntregaPedidoConvenio1 ){
		this.codigoEntregaPedidoConvenio=codigoEntregaPedidoConvenio1;
		
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

