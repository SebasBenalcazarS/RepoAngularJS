package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;
@SuppressWarnings("serial")
@Embeddable
public class VistaUbicacionPalletMontacargusitaID extends BaseID{
	private Integer codigoCompania ;
	private Long codigoTarea ;
	private java.lang.Long codigoDatosTarea;
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoTarea() {
		return codigoTarea;
	}
	public void setCodigoTarea(Long codigoTarea) {
		this.codigoTarea = codigoTarea;
	}
	public java.lang.Long getCodigoDatosTarea() {
		return codigoDatosTarea;
	}
	public void setCodigoDatosTarea(java.lang.Long codigoDatosTarea) {
		this.codigoDatosTarea = codigoDatosTarea;
	}
}
