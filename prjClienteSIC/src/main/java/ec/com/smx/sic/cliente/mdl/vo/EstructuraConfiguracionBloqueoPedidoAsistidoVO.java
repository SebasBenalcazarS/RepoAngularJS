package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoDTO;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoDetalleDTO;

@SuppressWarnings("serial")
public class EstructuraConfiguracionBloqueoPedidoAsistidoVO extends BaseVO<AreaTrabajoCalendarioProcesoDetalleDTO> {
	
	//Configuracion
	private Long codigoConfiguracion;
	private Long codigoConfiguracionDetalleBloqueo;
	
	//Dia
	private Integer codigoDia;
	private String dia;
	
	private AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO detalleDiaPedido;
	
	//bloqueo pedido
	private String codigoTipoBloqueo;
	private String tipoBloqueo;
	private AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO detalleDiaBloqueoPedido;
	private Date fechaInicioBloqueo;
	private Date fechaFinBloqueo;
	
	//seleccion codigo subbodega
	private Integer  codigoSubbodega;
	
	//Local
	private Integer  codigoLocal;
	private String nombreLocal;
	private Integer codigoEstablecimiento;

	//Locales seleccionados
	private Collection<AreaTrabajoCalendarioProcesoDTO> configuracionesLocalesSelect;
	

	/*GETTERS AND SETTERS*/
	/**
	 * @return the dia
	 */
	public String getDia() {
		return dia;
	}
	/**
	 * @param dia the dia to set
	 */
	public void setDia(String dia) {
		this.dia = dia;
	}
	/**
	 * @return the codigoConfiguracion
	 */
	public Long getCodigoConfiguracion() {
		return codigoConfiguracion;
	}
	/**
	 * @param codigoConfiguracion the codigoConfiguracion to set
	 */
	public void setCodigoConfiguracion(Long codigoConfiguracion) {
		this.codigoConfiguracion = codigoConfiguracion;
	}
	/**
	 * @return the codigoDia
	 */
	public Integer getCodigoDia() {
		return codigoDia;
	}
	/**
	 * @param codigoDia the codigoDia to set
	 */
	public void setCodigoDia(Integer codigoDia) {
		this.codigoDia = codigoDia;
	}
	/**
	 * @return the detalleDiaPedido
	 */
	public AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO getDetalleDiaPedido() {
		return detalleDiaPedido;
	}
	/**
	 * @param detalleDiaPedido the detalleDiaPedido to set
	 */
	public void setDetalleDiaPedido(AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO detalleDiaPedido) {
		this.detalleDiaPedido = detalleDiaPedido;
	}
	/**
	 * @return the codigoTipoBloqueo
	 */
	public String getCodigoTipoBloqueo() {
		return codigoTipoBloqueo;
	}
	/**
	 * @param codigoTipoBloqueo the codigoTipoBloqueo to set
	 */
	public void setCodigoTipoBloqueo(String codigoTipoBloqueo) {
		this.codigoTipoBloqueo = codigoTipoBloqueo;
	}
	/**
	 * @return the tipoBloqueo
	 */
	public String getTipoBloqueo() {
		return tipoBloqueo;
	}
	/**
	 * @param tipoBloqueo the tipoBloqueo to set
	 */
	public void setTipoBloqueo(String tipoBloqueo) {
		this.tipoBloqueo = tipoBloqueo;
	}
	/**
	 * @return the detalleDiaBloqueoPedido
	 */
	public AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO getDetalleDiaBloqueoPedido() {
		return detalleDiaBloqueoPedido;
	}
	/**
	 * @param detalleDiaBloqueoPedido the detalleDiaBloqueoPedido to set
	 */
	public void setDetalleDiaBloqueoPedido(AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO detalleDiaBloqueoPedido) {
		this.detalleDiaBloqueoPedido = detalleDiaBloqueoPedido;
	}
	/**
	 * @return the fechaInicioBloqueo
	 */
	public Date getFechaInicioBloqueo() {
		return fechaInicioBloqueo;
	}
	/**
	 * @param fechaInicioBloqueo the fechaInicioBloqueo to set
	 */
	public void setFechaInicioBloqueo(Date fechaInicioBloqueo) {
		this.fechaInicioBloqueo = fechaInicioBloqueo;
	}
	/**
	 * @return the fechaFinBloqueo
	 */
	public Date getFechaFinBloqueo() {
		return fechaFinBloqueo;
	}
	/**
	 * @param fechaFinBloqueo the fechaFinBloqueo to set
	 */
	public void setFechaFinBloqueo(Date fechaFinBloqueo) {
		this.fechaFinBloqueo = fechaFinBloqueo;
	}
	/**
	 * @return the codigoSubbodega
	 */
	public Integer getCodigoSubbodega() {
		return codigoSubbodega;
	}
	/**
	 * @param codigoSubbodega the codigoSubbodega to set
	 */
	public void setCodigoSubbodega(Integer codigoSubbodega) {
		this.codigoSubbodega = codigoSubbodega;
	}
	/**
	 * @return the codigoLocal
	 */
	public Integer getCodigoLocal() {
		return codigoLocal;
	}
	/**
	 * @param codigoLocal the codigoLocal to set
	 */
	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}
	/**
	 * @return the nombreLocal
	 */
	public String getNombreLocal() {
		return nombreLocal;
	}
	/**
	 * @param nombreLocal the nombreLocal to set
	 */
	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}
	/**
	 * @return the configuracionesLocalesSelect
	 */
	public Collection<AreaTrabajoCalendarioProcesoDTO> getConfiguracionesLocalesSelect() {
		return configuracionesLocalesSelect;
	}
	/**
	 * @param configuracionesLocalesSelect the configuracionesLocalesSelect to set
	 */
	public void setConfiguracionesLocalesSelect(Collection<AreaTrabajoCalendarioProcesoDTO> configuracionesLocalesSelect) {
		this.configuracionesLocalesSelect = configuracionesLocalesSelect;
	}
	/**
	 * @return the codigoConfiguracionDetalleBloqueo
	 */
	public Long getCodigoConfiguracionDetalleBloqueo() {
		return codigoConfiguracionDetalleBloqueo;
	}
	/**
	 * @param codigoConfiguracionDetalleBloqueo the codigoConfiguracionDetalleBloqueo to set
	 */
	public void setCodigoConfiguracionDetalleBloqueo(Long codigoConfiguracionDetalleBloqueo) {
		this.codigoConfiguracionDetalleBloqueo = codigoConfiguracionDetalleBloqueo;
	}
	/**
	 * @return the codigoEstablecimiento
	 */
	public Integer getCodigoEstablecimiento() {
		return codigoEstablecimiento;
	}
	/**
	 * @param codigoEstablecimiento the codigoEstablecimiento to set
	 */
	public void setCodigoEstablecimiento(Integer codigoEstablecimiento) {
		this.codigoEstablecimiento = codigoEstablecimiento;
	}
	
}
