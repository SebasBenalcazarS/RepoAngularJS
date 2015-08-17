package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorArticuloJustificacionDTO;

@SuppressWarnings("serial")
public class RecepcionProveedorArticuloJustificacionAuditEST extends SimpleAuditDTO{
	
	private Integer codigoCompania;
	
	private Long codigoRecepcionArticuloProveedor;
	
	private Collection<RecepcionProveedorArticuloJustificacionDTO> validacionesEtiquetado;
	
	private String codigoBarras;
	
	private String accesItemID;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoRecepcionArticuloProveedor() {
		return codigoRecepcionArticuloProveedor;
	}

	public void setCodigoRecepcionArticuloProveedor(Long codigoRecepcionArticuloProveedor) {
		this.codigoRecepcionArticuloProveedor = codigoRecepcionArticuloProveedor;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getAccesItemID() {
		return accesItemID;
	}

	public void setAccesItemID(String accesItemID) {
		this.accesItemID = accesItemID;
	}

	public Collection<RecepcionProveedorArticuloJustificacionDTO> getValidacionesEtiquetado() {
		return validacionesEtiquetado;
	}

	public void setValidacionesEtiquetado(Collection<RecepcionProveedorArticuloJustificacionDTO> validacionesEtiquetado) {
		this.validacionesEtiquetado = validacionesEtiquetado;
	}
}
