
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.sispe.TipoPedidoID;

/**
 * Entidad que almacena los datos de los diferentes tipos de pedido.
 *
 * @author walvarez
 */
@SuppressWarnings("serial")
@Entity(name="ec.com.smx.sic.cliente.mdl.dto.sispe.TipoPedidoDTO")
@Table(name="SCSPETTIPPED")
public class TipoPedidoDTO extends AuditoriaBaseDTO<TipoPedidoID> {

	private String descripcionTipoPedido;
	private String caracteristicaTipoPedido;
	
    //campos auditoria
    private String estado;
  
	public TipoPedidoDTO(){
		this.id = new TipoPedidoID();
	}
	
	public TipoPedidoDTO(Boolean valor){
		this.id = new TipoPedidoID(valor);
	}
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public TipoPedidoID getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(TipoPedidoID id1){
		this.id=id1;
	}

	/**
	 * Retorna valor de propiedad <code>descripcionTipoPedido</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>descripcionTipoPedido</code>
	 */
	public String getDescripcionTipoPedido(){
		return this.descripcionTipoPedido;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descripcionTipoPedido</code>.
	 * @param descripcionTipoPedido1 
	 *		El valor a establecer para la propiedad <code>descripcionTipoPedido</code>.
	 */
	public void setDescripcionTipoPedido( String descripcionTipoPedido1 ){
		this.descripcionTipoPedido=descripcionTipoPedido1;
		
		if(descripcionTipoPedido!=null && descripcionTipoPedido.length()>50){
			descripcionTipoPedido = descripcionTipoPedido.substring(0,50);
		}

	}

	/**
	 * @return el caracteristicaTipoPedido
	 */
	public String getCaracteristicaTipoPedido() {
		return caracteristicaTipoPedido;
	}

	/**
	 * @param caracteristicaTipoPedido el caracteristicaTipoPedido a establecer
	 */
	public void setCaracteristicaTipoPedido(String caracteristicaTipoPedido) {
		this.caracteristicaTipoPedido = caracteristicaTipoPedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}