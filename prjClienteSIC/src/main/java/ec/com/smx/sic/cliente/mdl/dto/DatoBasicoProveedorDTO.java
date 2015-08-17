/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.DatoBasicoProveedorID;

/**
 * @author mbraganza
 *
 */
@Entity
@Table(name="SCSPEVDATBASPRO")
public class DatoBasicoProveedorDTO extends SearchDTO {
	
	@EmbeddedId
	private DatoBasicoProveedorID id;
	
	private String codigoJDEProveedor;
	private String nombreProveedor;
	private String razonSocialProveedor;
	
	public DatoBasicoProveedorID getId() {
		return id;
	}
	public void setId(DatoBasicoProveedorID id) {
		this.id = id;
	}
	public String getCodigoJDEProveedor() {
		return codigoJDEProveedor;
	}
	public void setCodigoJDEProveedor(String codigoJDEProveedor) {
		this.codigoJDEProveedor = codigoJDEProveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
	}
	public void setRazonSocialProveedor(String razonSocialProveedor) {
		this.razonSocialProveedor = razonSocialProveedor;
	}
	
	

}
