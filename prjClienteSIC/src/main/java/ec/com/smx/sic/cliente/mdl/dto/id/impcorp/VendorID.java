
package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;



/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Vendor
 * @see ec.com.smx.sic.cliente.mdl.dto.impcorp.Vendor
 *
 * @author kruger
 * @author walvarez
 */
@SuppressWarnings("serial")
public class VendorID extends BaseID {

	/**
	 * id
	 */
	private String id ;
	
	/**
	 * campo que indica desde donde se origino la orden si desde WRT, FAV.
	 */
	private String originOrder ;
		
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>id</code>
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * @param id1 
	 *		El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId( String id ){
		this.id=id;
	}

	/**
	 * @return the originOrder
	 */
	public String getOriginOrder() {
		return originOrder;
	}

	/**
	 * @param originOrder the originOrder to set
	 */
	public void setOriginOrder(String originOrder) {
		this.originOrder = originOrder;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendorID other = (VendorID) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (originOrder == null) {
			if (other.originOrder != null)
				return false;
		} else if (!originOrder.equals(other.originOrder))
			return false;
		return true;
	}
	
}

