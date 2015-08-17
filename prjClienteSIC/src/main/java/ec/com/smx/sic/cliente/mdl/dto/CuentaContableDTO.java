package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.CuentaContableID;

/**
 * Clase DTO que extiende de SimpleAuditDTO, representa la tabla SFCORTCUECON
 * del Schema DSMXSIC
 * 
 * @author srodriguez
 * 2014-09-10
*/
@SuppressWarnings("serial")
@Entity
@Table(name = "SFCORTCUECON")
public class CuentaContableDTO extends SimpleAuditDTO {

	@EmbeddedId
	private CuentaContableID id =new CuentaContableID();
	
	/**
	 * Valor del numero de la cuenta
	 */
	@Column(name = "NUMEROCUENTA")
	@ComparatorTypeField
	private java.lang.String numeroCuenta;
	
	/**
	 * Valor del nombre de la cuenta
	 */
	@Column(name = "NOMBRECUENTA")
	@ComparatorTypeField
	private java.lang.String nombreCuenta;
	
	/**
	 * Valor del descripcion de la cuenta
	 */
	@Column(name = "DESCRIPCIONCUENTA")
	@ComparatorTypeField
	private java.lang.String descripcionCuenta;
	
	/**
	 * Valor del nombre de la cuenta
	 */
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private Boolean estado;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CuentaContableDTO other = (CuentaContableDTO) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CuentaContableDTO [id=" + id + ", nombreCuenta=" + nombreCuenta+ "]";
	}

	/* Metodo que retorna id del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return CuentaContableID id 
	 */
	public CuentaContableID getId() {
		return id;
	}

	/* Metodo que asigna el id del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param id parametro de tipo CuentaContableID
	 */
	public void setId(CuentaContableID id) {
		this.id = id;
	}

	/* Metodo que retorna numeroCuenta del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.String numeroCuenta 
	 */
	public java.lang.String getNumeroCuenta() {
		return numeroCuenta;
	}

	/* Metodo que asigna el numeroCuenta del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param numeroCuenta parametro de tipo java.lang.String
	 */
	public void setNumeroCuenta(java.lang.String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/* Metodo que retorna nombreCuenta del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.String nombreCuenta 
	 */
	public java.lang.String getNombreCuenta() {
		return nombreCuenta;
	}

	/* Metodo que asigna el nombreCuenta del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param nombreCuenta parametro de tipo java.lang.String
	 */
	public void setNombreCuenta(java.lang.String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	/* Metodo que retorna descripcionCuenta del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return java.lang.String descripcionCuenta 
	 */
	public java.lang.String getDescripcionCuenta() {
		return descripcionCuenta;
	}

	/* Metodo que asigna el descripcionCuenta del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param descripcionCuenta parametro de tipo java.lang.String
	 */
	public void setDescripcionCuenta(java.lang.String descripcionCuenta) {
		this.descripcionCuenta = descripcionCuenta;
	}

	/* Metodo que retorna estado del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @return Boolean estado 
	 */
	public Boolean getEstado() {
		return estado;
	}

	/* Metodo que asigna el estado del objeto
	 * @author srodriguez
	 * 08/10/2014
	 * @param estado parametro de tipo Boolean
	 */
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
