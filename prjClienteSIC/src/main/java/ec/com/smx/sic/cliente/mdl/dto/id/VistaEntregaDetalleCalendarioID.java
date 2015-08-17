package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@Embeddable
@SuppressWarnings("serial")
public class VistaEntregaDetalleCalendarioID extends BaseID{
	
	private Integer numeroRegistro;
	private Integer codigoCompania;
//	private String codigoProveedor;
	private Long codigoEntrega;
	//
//	private Long codigoDetalleCalendario;
//	private Long codigoHoraCalendario;
	private Integer codigoTipoSeccion;
	private String valorTipoSeccion;
	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
//	/**
//	 * @return the codigoProveedor
//	 */
//	public String getCodigoProveedor() {
//		return codigoProveedor;
//	}
//	/**
//	 * @param codigoProveedor the codigoProveedor to set
//	 */
//	public void setCodigoProveedor(String codigoProveedor) {
//		this.codigoProveedor = codigoProveedor;
//	}
	/**
	 * @return the codigoEntrega
	 */
	public Long getCodigoEntrega() {
		return codigoEntrega;
	}
	/**
	 * @param codigoEntrega the codigoEntrega to set
	 */
	public void setCodigoEntrega(Long codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}
//	/**
//	 * @return the codigoDetalleCalendario
//	 */
//	public Long getCodigoDetalleCalendario() {
//		return codigoDetalleCalendario;
//	}
//	/**
//	 * @param codigoDetalleCalendario the codigoDetalleCalendario to set
//	 */
//	public void setCodigoDetalleCalendario(Long codigoDetalleCalendario) {
//		this.codigoDetalleCalendario = codigoDetalleCalendario;
//	}
//	/**
//	 * @return the codigoHoraCalendario
//	 */
//	public Long getCodigoHoraCalendario() {
//		return codigoHoraCalendario;
//	}
//	/**
//	 * @param codigoHoraCalendario the codigoHoraCalendario to set
//	 */
//	public void setCodigoHoraCalendario(Long codigoHoraCalendario) {
//		this.codigoHoraCalendario = codigoHoraCalendario;
//	}
	/**
	 * @return the valorTipoSeccion
	 */
	public String getValorTipoSeccion() {
		return valorTipoSeccion;
	}
	/**
	 * @param valorTipoSeccion the valorTipoSeccion to set
	 */
	public void setValorTipoSeccion(String valorTipoSeccion) {
		this.valorTipoSeccion = valorTipoSeccion;
	}
	/**
	 * @return the codigoTipoSeccion
	 */
	public Integer getCodigoTipoSeccion() {
		return codigoTipoSeccion;
	}
	/**
	 * @param codigoTipoSeccion the codigoTipoSeccion to set
	 */
	public void setCodigoTipoSeccion(Integer codigoTipoSeccion) {
		this.codigoTipoSeccion = codigoTipoSeccion;
	}
	/**
	 * @return the numeroRegistro
	 */
	public Integer getNumeroRegistro() {
		return numeroRegistro;
	}
	/**
	 * @param numeroRegistro the numeroRegistro to set
	 */
	public void setNumeroRegistro(Integer numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	
}
