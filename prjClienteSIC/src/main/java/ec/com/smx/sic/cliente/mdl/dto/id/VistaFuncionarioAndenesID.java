package ec.com.smx.sic.cliente.mdl.dto.id;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@SuppressWarnings("serial")
public class VistaFuncionarioAndenesID extends BaseID {
	
	private Integer numeroRegistro;
	private Integer codigoCompania;
	
	
	public Integer getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(Integer numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	
}
