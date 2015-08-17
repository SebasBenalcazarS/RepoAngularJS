 package ec.com.smx.sic.cliente.mdl.dto.integracion;

import javax.persistence.Column;

import ec.com.smx.generadorexportacion.anotaciones.Format;
import ec.com.smx.generadorexportacion.anotaciones.Format.Location;
import ec.com.smx.integracion.batch.dto.IntTramaPosBaseOutDTO;

/**
 * 
 * @author fvallejo
 * 
 */
public class ConsultaCuponesDTOOut extends IntTramaPosBaseOutDTO {

	private static final long serialVersionUID = -3072588388182773194L;

	@Column(length = 2)
	@Format
	private Integer numeroCupones;

	@Column(length = 18)
	@Format(locationCharacter = Location.RIGHT)
	private String cupones1;

	@Column(length = 8)
	@Format
	private String codigoTerminal;

	@Column(length = 10)
	@Format
	private Integer codigoEstablecimiento;

	@Column(length = 146)
	@Format(locationCharacter = Location.RIGHT)
	private String cupones2;

	/**
	 * 
	 * @return the numeroCupones
	 */
	public Integer getNumeroCupones() {
		return numeroCupones;
	}

	/**
	 * 
	 * @param numeroCupones the numeroCupones to set
	 */
	public void setNumeroCupones(Integer numeroCupones) {
		this.numeroCupones = numeroCupones;
	}

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

	/**
	 * 
	 * @param codigoEstablecimiento the codigoEstablecimiento to set
	 */
	public void setCodigoEstablecimiento(Integer codigoEstablecimiento) {
		this.codigoEstablecimiento = codigoEstablecimiento;
	}

	/**
	 * 
	 * @return the cupones2
	 */
	public String getCupones2() {
		return cupones2;
	}

	/**
	 * 
	 * @param cupones2 the cupones2 to set
	 */
	public void setCupones2(String cupones2) {
		this.cupones2 = cupones2;
	}

}
