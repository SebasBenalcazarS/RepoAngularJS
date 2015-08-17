package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaRazonSocialProveedorID;

/**
 * Almacena campos faltantes para la etiqueta Mercancias, completa los datos con anotracion Trasient
 * en VistaCamposMercanciaDTO
 * @author dbravo
 *
 */
@Entity
@SuppressWarnings("serial")
public class VistaRazonSocialProveedorDTO extends SearchDTO{
	
	@EmbeddedId
	private VistaRazonSocialProveedorID id = new VistaRazonSocialProveedorID();
	
	private String codigoProveedor;
	private String direccionPrincipal;
	private String razonSocialProveedor;
	private String origenProveedor;
	
	
	public VistaRazonSocialProveedorID getId() {
		return id;
	}
	public void setId(VistaRazonSocialProveedorID id) {
		this.id = id;
	}
	

	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	public String getDireccionPrincipal() {
		return direccionPrincipal;
	}
	public void setDireccionPrincipal(String direccionPrincipal) {
		this.direccionPrincipal = direccionPrincipal;
	}
	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
	}
	public void setRazonSocialProveedor(String razonSocialProveedor) {
		this.razonSocialProveedor = razonSocialProveedor;
	}
	public String getOrigenProveedor() {
		return origenProveedor;
	}
	public void setOrigenProveedor(String origenProveedor) {
		this.origenProveedor = origenProveedor;
	}
	
	

}
