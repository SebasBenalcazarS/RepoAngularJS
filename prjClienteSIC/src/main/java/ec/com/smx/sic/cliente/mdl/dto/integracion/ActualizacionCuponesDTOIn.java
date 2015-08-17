package ec.com.smx.sic.cliente.mdl.dto.integracion;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;

import ec.com.smx.generadorexportacion.anotaciones.Format;
import ec.com.smx.generadorexportacion.anotaciones.Format.Location;
import ec.com.smx.integracion.batch.dto.IntTramaPosBaseInDTO;

/**
 * 
 * @author fvallejo
 *
 */
public class ActualizacionCuponesDTOIn extends IntTramaPosBaseInDTO{
	
	private static final long serialVersionUID = -4645012742521381277L;

	@Column(length=12)
	@Format(locationCharacter = Location.RIGHT,removefillCharacter = false)
	private String cupones1;
	
	@Column(length=6)
	@Format
	private String secuencialTransaccion;
	
	@Column(length=6)
	@Format(formatDate = "HHmmss")
	private Time horaTransaccion;
	
	@Column(length=8)
	@Format
	private Date fechaTransaccion;
	
	@Column(length=3)
	@Format
	private Integer tipoLectura;
	
	@Column(length=6)
	@Format
	private String autorizacion;
	
	@Column(length=8)
	@Format(removefillCharacter = false)
	private String codigoTerminal;
	
	@Column(length=6)
	@Format
	private String codigoCajero;
	
	@Column(length=10)
	@Format
	private Integer codigoEstablecimiento;
	
	@Column(length=3)
	@Format
	private Integer moneda;
	
	@Column(length=16)
	@Format(removefillCharacter = false)
	private String cedRuc;
	
	@Column(length=1)
	@Format
	private Integer tipoTrx;
	
	@Column(length=2)
	@Format
	private String formaPago;

	@Column(length=64)
	@Format(locationCharacter = Location.RIGHT, removefillCharacter = false)
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
	 * @return the secuencialTransaccion
	 */
	public String getSecuencialTransaccion() {
		return secuencialTransaccion;
	}

	/**
	 * 
	 * @param secuencialTransaccion the secuencialTransaccion to set
	 */
	public void setSecuencialTransaccion(String secuencialTransaccion) {
		this.secuencialTransaccion = secuencialTransaccion;
	}

	/**
	 * 
	 * @return the horaTransaccion
	 */
	public Time getHoraTransaccion() {
		return horaTransaccion;
	}

	/**
	 * 
	 * @param horaTransaccion the horaTransaccion to set
	 */
	public void setHoraTransaccion(Time horaTransaccion) {
		this.horaTransaccion = horaTransaccion;
	}

	/**
	 * 
	 * @return the fechaTransaccion
	 */
	public Date getFechaTransaccion() {
		return fechaTransaccion;
	}

	/**
	 * 
	 * @param fechaTransaccion the fechaTransaccion to set
	 */
	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	/**
	 * 
	 * @return the tipoLectura
	 */
	public Integer getTipoLectura() {
		return tipoLectura;
	}

	/**
	 * 
	 * @param tipoLectura the tipoLectura to set
	 */
	public void setTipoLectura(Integer tipoLectura) {
		this.tipoLectura = tipoLectura;
	}

	/**
	 * 
	 * @return the autorizacion
	 */
	public String getAutorizacion() {
		return autorizacion;
	}

	/**
	 * 
	 * @param autorizacion the autorizacion to set
	 */
	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
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
	 * @return the codigoCajero
	 */
	public String getCodigoCajero() {
		return codigoCajero;
	}

	/**
	 * 
	 * @param codigoCajero the codigoCajero to set
	 */
	public void setCodigoCajero(String codigoCajero) {
		this.codigoCajero = codigoCajero;
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
	 * @return the moneda
	 */
	public Integer getMoneda() {
		return moneda;
	}

	/**
	 * 
	 * @param moneda the moneda to set
	 */
	public void setMoneda(Integer moneda) {
		this.moneda = moneda;
	}

	/**
	 * 
	 * @return the cedRuc
	 */
	public String getCedRuc() {
		return cedRuc;
	}

	/**
	 * 
	 * @param cedRuc the cedRuc to set
	 */
	public void setCedRuc(String cedRuc) {
		this.cedRuc = cedRuc;
	}

	/**
	 * 
	 * @return the tipoTrx
	 */
	public Integer getTipoTrx() {
		return tipoTrx;
	}

	/**
	 * 
	 * @param tipoTrx the tipoTrx to set
	 */
	public void setTipoTrx(Integer tipoTrx) {
		this.tipoTrx = tipoTrx;
	}

	/**
	 * 
	 * @return the formaPago
	 */
	public String getFormaPago() {
		return formaPago;
	}

	/**
	 * 
	 * @param formaPago the formaPago to set
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
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
