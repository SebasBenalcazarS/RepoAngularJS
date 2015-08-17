
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.SICConstantes;


/**
 * Clase que encapsula a las propiedades Identificadoras de la clase TipoPedido
 * @see ec.com.smx.sic.sispe.dto.TipoPedido
 *
 * @author walvarez
 */
@SuppressWarnings("serial")
@Embeddable
public class TipoPedidoID extends BaseID{

	
	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name="CODIGOTIPOPEDIDO")
	private String codigoTipoPedido;

	
	public TipoPedidoID () { }

	
	public TipoPedidoID (Boolean initID) {
		if(initID){
			this.codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			this.codigoTipoPedido = SICConstantes.getInstancia().VALOR_INICIAL_ID;
		}
	}
	

	/**
	 * Retorna valor de propiedad <code>codigoTipoPedido</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoTipoPedido</code>
	 */
	public String getCodigoTipoPedido(){
		return this.codigoTipoPedido;
	}



	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoPedido</code>.
	 * @param codigoTipoPedido1 
	 *		El valor a establecer para la propiedad <code>codigoTipoPedido</code>.
	 */
	public void setCodigoTipoPedido( String codigoTipoPedido1 ){
		this.codigoTipoPedido=codigoTipoPedido1;
		
		if(codigoTipoPedido!=null && codigoTipoPedido.length()>3){
			codigoTipoPedido = codigoTipoPedido.substring(0,3);
		}
	}

	/**
	 * @return el codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania el codigoCompania a establecer
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime
				* result
				+ ((codigoTipoPedido == null) ? 0 : codigoTipoPedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoPedidoID other = (TipoPedidoID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (codigoTipoPedido == null) {
			if (other.codigoTipoPedido != null)
				return false;
		} else if (!codigoTipoPedido.equals(other.codigoTipoPedido))
			return false;
		return true;
	}
}
