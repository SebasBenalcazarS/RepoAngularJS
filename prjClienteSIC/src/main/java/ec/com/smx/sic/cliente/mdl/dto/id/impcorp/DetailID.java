package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;



/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Detail
 * @see ec.com.smx.sic.cliente.mdl.dto.impcorp.Detail
 *
 * @author kruger
 * @author walvarez
 */
@SuppressWarnings("serial")
public class DetailID extends BaseID {
	
	/**
	 * numero
	 */
	private String number ;
	
	/**
	 * linea
	 */
	private Integer line ;
	/**
	 * Retorna valor de propiedad <code>number</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>number</code>
	 */
	public String getNumber(){
		return this.number;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>number</code>.
	 * @param number1 
	 *		El valor a establecer para la propiedad <code>number</code>.
	 */
	public void setNumber( String number){
		this.number=number;
	}

	/**
	 * Retorna valor de propiedad <code>line</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>line</code>
	 */
	public Integer getLine(){
		return this.line;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>line</code>.
	 * @param line1 
	 *		El valor a establecer para la propiedad <code>line</code>.
	 */
	public void setLine( Integer line ){
		this.line=line;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((line == null) ? 0 : line.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
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
		DetailID other = (DetailID) obj;
		if (line == null) {
			if (other.line != null)
				return false;
		} else if (!line.equals(other.line))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
}

