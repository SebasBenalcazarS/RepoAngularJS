package ec.com.smx.sic.cliente.mdl.dto.integracion;

import javax.persistence.Column;

import ec.com.smx.generadorexportacion.anotaciones.Format;
import ec.com.smx.integracion.batch.dto.IntTramaPosBaseOutDTO;

/**
 * 
 * @author fvallejo
 *
 */
public class ActualizacionCuponesDTOOut extends IntTramaPosBaseOutDTO{

	private static final long serialVersionUID = 8217591054371683403L;
	
	@Column(length=20)
	@Format
	private String cupones1;
	
	@Column(length=8)
	@Format
	private String codigoTerminal;
	
	@Column(length=10)
	@Format
	private Integer codigoEstablecimiento;
	
	@Column(length=146)
	@Format
	private String cupones2;

	/**
	 * 
	 * @return the cupones1
	 */
	public String getCupones1() {
		return cupones1;
	}

	/**
	 * 
	 * @param cupones1 the cupones1 to set
	 */
	public void setCupones1(String cupones1) {
		this.cupones1 = cupones1;
	}

	/**
	 * 
	 * @return the codigoTerminal
	 */
	public String getCodigoTerminal() {
		return codigoTerminal;
	}

	/**
	 * 
	 * @param codigoTerminal the codigoTerminal to set
	 */
	public void setCodigoTerminal(String codigoTerminal) {
		this.codigoTerminal = codigoTerminal;
	}

	/**
	 * 
	 * @return the codigoEstablecimiento
	 */
	public Integer getCodigoEstablecimiento() {
		return codigoEstablecimiento;
	}

	
	public void setCodigoEstablecimiento(Integer codigoEstablecimiento) {
		this.codigoEstablecimiento = codigoEstablecimiento;
	}

	public String getCupones2() {
		return cupones2;
	}

	public void setCupones2(String cupones2) {
		this.cupones2 = cupones2;
	}

}
