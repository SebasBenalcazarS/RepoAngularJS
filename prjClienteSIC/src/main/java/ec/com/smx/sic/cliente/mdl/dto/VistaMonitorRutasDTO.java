package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaMonitorRutasID;

/**
 * Permite gestionar la informaci&oacute;n de las rutas
 * de selecci&oacute;n.
 *
 * @author kruger
 * @author egudino
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGVRUTAMONITOR")
public class VistaMonitorRutasDTO extends BaseDto<VistaMonitorRutasID> {
		
	/**
	 * Campo para valor tipo estado
	 */
	private java.lang.String valorTipoEstado;
	
	/**
	 * Campo para codigo tipo estado
	 */
	private java.lang.Integer codigoTipoEstado;

	/**
	 * Campo para el nombre tipo estado
	 */
	private java.lang.String nombreTipoEstado;
	
	/**
	 * Campo para la fecha de salida
	 */
	private java.util.Date fechaSalida;

	/**
	 * Campo para codigo de area de trabjo principal
	 */
	private java.lang.Integer codigoInicial;
	
	/**
	 * Campo ara el nombre de area de trabajo principal
	 */
	private java.lang.String nombreInicial;
	
	/**
	 * Campo para codigo de area de trabjo origen
	 */
	private java.lang.Integer codigoOrigen;
	
	/**
	 * Campo para codigo de area de trabajo destino
	 */
	private java.lang.Integer codigoDestino;
	
	/**
	 * Campo para el nombre de origen
	 */
	private java.lang.String nombreOrigen;
	
	/**
	 * Campo para el nombre de destino
	 */
	private java.lang.String nombreDestino;
	
	/**
	 * Campo para el codio de furgon
	 */
	private java.lang.String codigoFurgon;
	
	/**
	 * Campo para el codio de furgon
	 */
	private java.lang.String placa;
		
	/**
	 * Campor temporal para paginar
	 */
	@Transient
	private java.lang.Integer totalRegistros;

	/**
	 * @return the valorTipoEstado
	 */
	public java.lang.String getValorTipoEstado() {
		return valorTipoEstado;
	}

	/**
	 * @param valorTipoEstado the valorTipoEstado to set
	 */
	public void setValorTipoEstado(java.lang.String valorTipoEstado) {
		this.valorTipoEstado = valorTipoEstado;
	}

	/**
	 * @return the codigoTipoEstado
	 */
	public java.lang.Integer getCodigoTipoEstado() {
		return codigoTipoEstado;
	}

	/**
	 * @param codigoTipoEstado the codigoTipoEstado to set
	 */
	public void setCodigoTipoEstado(java.lang.Integer codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
	}

	/**
	 * @return the nombreTipoEstado
	 */
	public java.lang.String getNombreTipoEstado() {
		return nombreTipoEstado;
	}

	/**
	 * @param nombreTipoEstado the nombreTipoEstado to set
	 */
	public void setNombreTipoEstado(java.lang.String nombreTipoEstado) {
		this.nombreTipoEstado = nombreTipoEstado;
	}

	/**
	 * @return the fechaSalida
	 */
	public java.util.Date getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * @param fechaSalida the fechaSalida to set
	 */
	public void setFechaSalida(java.util.Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * @return the totalRegistros
	 */
	public java.lang.Integer getTotalRegistros() {
		return totalRegistros;
	}

	/**
	 * @param totalRegistros the totalRegistros to set
	 */
	public void setTotalRegistros(java.lang.Integer totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	/**
	 * @return the codigoFurgon
	 */
	public java.lang.String getCodigoFurgon() {
		return codigoFurgon;
	}

	/**
	 * @param codigoFurgon the codigoFurgon to set
	 */
	public void setCodigoFurgon(java.lang.String codigoFurgon) {
		this.codigoFurgon = codigoFurgon;
	}

	/**
	 * @return the placa
	 */
	public java.lang.String getPlaca() {
		return placa;
	}

	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(java.lang.String placa) {
		this.placa = placa;
	}

	/**
	 * @return the codigoInicial
	 */
	public java.lang.Integer getCodigoInicial() {
		return codigoInicial;
	}

	/**
	 * @param codigoInicial the codigoInicial to set
	 */
	public void setCodigoInicial(java.lang.Integer codigoInicial) {
		this.codigoInicial = codigoInicial;
	}

	/**
	 * @return the nombreInicial
	 */
	public java.lang.String getNombreInicial() {
		return nombreInicial;
	}

	/**
	 * @param nombreInicial the nombreInicial to set
	 */
	public void setNombreInicial(java.lang.String nombreInicial) {
		this.nombreInicial = nombreInicial;
	}

	/**
	 * @return the codigoOrigen
	 */
	public java.lang.Integer getCodigoOrigen() {
		return codigoOrigen;
	}

	/**
	 * @param codigoOrigen the codigoOrigen to set
	 */
	public void setCodigoOrigen(java.lang.Integer codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}

	/**
	 * @return the codigoDestino
	 */
	public java.lang.Integer getCodigoDestino() {
		return codigoDestino;
	}

	/**
	 * @param codigoDestino the codigoDestino to set
	 */
	public void setCodigoDestino(java.lang.Integer codigoDestino) {
		this.codigoDestino = codigoDestino;
	}

	/**
	 * @return the nombreOrigen
	 */
	public java.lang.String getNombreOrigen() {
		return nombreOrigen;
	}

	/**
	 * @param nombreOrigen the nombreOrigen to set
	 */
	public void setNombreOrigen(java.lang.String nombreOrigen) {
		this.nombreOrigen = nombreOrigen;
	}

	/**
	 * @return the nombreDestino
	 */
	public java.lang.String getNombreDestino() {
		return nombreDestino;
	}

	/**
	 * @param nombreDestino the nombreDestino to set
	 */
	public void setNombreDestino(java.lang.String nombreDestino) {
		this.nombreDestino = nombreDestino;
	}
}

