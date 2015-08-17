package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@Embeddable
@SuppressWarnings("serial")
public class VistaProveedorPlanificacionBodegaID extends BaseID{
	
	private Integer numeroRegistro;
	
	@Transient
	private Integer codigoCompania;
	
	private String codigoProveedor;
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public Integer getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(Integer numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

}
