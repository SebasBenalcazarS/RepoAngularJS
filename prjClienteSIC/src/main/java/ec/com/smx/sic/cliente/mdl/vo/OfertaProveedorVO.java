package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.sic.cliente.mdl.dto.OfertaProveedorDTO;

/**
 * 
 * @author jcayo<josecayo4@gmail.com>
 *
 */
@SuppressWarnings("serial")
public class OfertaProveedorVO extends BaseVO<OfertaProveedorDTO>{	
	
	/**Parametros para el rango de fechas a mostrar*/
	private Date fechaInicialRango;
	private Date fechaFinalRango;
	private Integer numeroDiasRango;
	private Integer primerDiaRango;
	
	
	public Date getFechaInicialRango() {
		return fechaInicialRango;
	}
	public void setFechaInicialRango(Date fechaInicialRango) {
		this.fechaInicialRango = fechaInicialRango;
	}
	public Date getFechaFinalRango() {
		return fechaFinalRango;
	}
	public void setFechaFinalRango(Date fechaFinalRango) {
		this.fechaFinalRango = fechaFinalRango;
	}
	public Integer getNumeroDiasRango() {
		return numeroDiasRango;
	}
	public void setNumeroDiasRango(Integer numeroDiasRango) {
		this.numeroDiasRango = numeroDiasRango;
	}
	public Integer getPrimerDiaRango() {
		return primerDiaRango;
	}
	public void setPrimerDiaRango(Integer primerDiaRango) {
		this.primerDiaRango = primerDiaRango;
	}

}
