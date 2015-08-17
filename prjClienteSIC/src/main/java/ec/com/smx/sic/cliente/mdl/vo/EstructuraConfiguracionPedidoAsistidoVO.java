package ec.com.smx.sic.cliente.mdl.vo;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoDTO;
import ec.com.smx.sic.cliente.mdl.dto.AreaTrabajoCalendarioProcesoDetalleDTO;

@SuppressWarnings("serial")
public class EstructuraConfiguracionPedidoAsistidoVO extends BaseVO<AreaTrabajoCalendarioProcesoDetalleDTO> {
	
	//Configuracion
	private Long codigoConfiguracion;
	
	//Dia
	private Integer codigoDia;
	private String dia;
	//hora maxima de transmision
	private Time horaMaximaTransmision;
	private String horaMaximaTransmisionText;
	private AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO detalleDiaPedido;
	
	//despacho
	private Integer codigoDiaDespacho;
	private String diaDespacho;
	private AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO detalleDiaDespacho;
	
	//recepcion
	private Integer codigoDiaRecepcion;
	private String diaRecepcion;
	private AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO detalleDiaRecepcion;
	
	//doble pedido
	private Integer codigoDoblePedido;
	private String doblePedido;
	//private Integer codigoDoblePedidoPadre;
	private String doblePedidoPadre;
	private AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO detalleDiaDoblePedido;
	
	//bloqueo pedido
	private String codigoTipoBloqueo;
	private String tipoBloqueo;
	private AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO detalleDiaBloqueoPedido;
	private Date fechaInicioBloqueo;
	private Date fechaFinBloqueo;
	
	//seleccion Bodega
	private Boolean  seleccionConfiguracionBodega;
	
	//seleccion codigo subbodega
	private Integer  codigoSubbodega;
	
	private Collection<EstructuraConfiguracionPedidoAsistidoVO> fechasBloqueo;
	
	private Collection<AreaTrabajoCalendarioProcesoDetalleDTO> configuracionesBloqueoSelect;
	
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
	 * @return the horaMaximaTransmision
	 */
	public Time getHoraMaximaTransmision() {
		if (StringUtils.isNotBlank(horaMaximaTransmisionText)) {
			return Time.valueOf(horaMaximaTransmisionText.concat(":00"));
		} else {
			return horaMaximaTransmision;
		}
	}
	/**
	 * @param horaMaximaTransmision the horaMaximaTransmision to set
	 */
	public void setHoraMaximaTransmision(Time horaMaximaTransmision) {
		this.horaMaximaTransmision = horaMaximaTransmision;
	}
	/**
	 * @return the diaDespacho
	 */
	public String getDiaDespacho() {
		return diaDespacho;
	}
	/**
	 * @param diaDespacho the diaDespacho to set
	 */
	public void setDiaDespacho(String diaDespacho) {
		this.diaDespacho = diaDespacho;
	}
	/**
	 * @return the diaRecepcion
	 */
	public String getDiaRecepcion() {
		return diaRecepcion;
	}
	/**
	 * @param diaRecepcion the diaRecepcion to set
	 */
	public void setDiaRecepcion(String diaRecepcion) {
		this.diaRecepcion = diaRecepcion;
	}

	/**
	 * @return the horaMaximaTransmisionText
	 */
	public String getHoraMaximaTransmisionText() {
		return horaMaximaTransmisionText;
	}

	/**
	 * @param horaMaximaTransmisionText the horaMaximaTransmisionText to set
	 */
	public void setHoraMaximaTransmisionText(String horaMaximaTransmisionText) {
		this.horaMaximaTransmisionText = horaMaximaTransmisionText;
	}

	/**
	 * @return the codigoDiaDespacho
	 */
	public Integer getCodigoDiaDespacho() {
		return codigoDiaDespacho;
	}

	/**
	 * @param codigoDiaDespacho the codigoDiaDespacho to set
	 */
	public void setCodigoDiaDespacho(Integer codigoDiaDespacho) {
		this.codigoDiaDespacho = codigoDiaDespacho;
	}

	/**
	 * @return the codigoDiaRecepcion
	 */
	public Integer getCodigoDiaRecepcion() {
		return codigoDiaRecepcion;
	}

	/**
	 * @param codigoDiaRecepcion the codigoDiaRecepcion to set
	 */
	public void setCodigoDiaRecepcion(Integer codigoDiaRecepcion) {
		this.codigoDiaRecepcion = codigoDiaRecepcion;
	}

	/**
	 * @return the codigoDoblePedido
	 */
	public Integer getCodigoDoblePedido() {
		return codigoDoblePedido;
	}
	/**
	 * @param codigoDoblePedido the codigoDoblePedido to set
	 */
	public void setCodigoDoblePedido(Integer codigoDoblePedido) {
		this.codigoDoblePedido = codigoDoblePedido;
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
	 * @return the detalleDiaDespacho
	 */
	public AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO getDetalleDiaDespacho() {
		return detalleDiaDespacho;
	}
	/**
	 * @param detalleDiaDespacho the detalleDiaDespacho to set
	 */
	public void setDetalleDiaDespacho(AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO detalleDiaDespacho) {
		this.detalleDiaDespacho = detalleDiaDespacho;
	}
	/**
	 * @return the detalleDiaRecepcion
	 */
	public AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO getDetalleDiaRecepcion() {
		return detalleDiaRecepcion;
	}
	/**
	 * @param detalleDiaRecepcion the detalleDiaRecepcion to set
	 */
	public void setDetalleDiaRecepcion(AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO detalleDiaRecepcion) {
		this.detalleDiaRecepcion = detalleDiaRecepcion;
	}
	/**
	 * @return the seleccionConfiguracionBodega
	 */
	public Boolean getSeleccionConfiguracionBodega() {
		return seleccionConfiguracionBodega;
	}

	/**
	 * @param seleccionConfiguracionBodega the seleccionConfiguracionBodega to set
	 */
	public void setSeleccionConfiguracionBodega(Boolean seleccionConfiguracionBodega) {
		this.seleccionConfiguracionBodega = seleccionConfiguracionBodega;
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
	 * @return the doblePedido
	 */
	public String getDoblePedido() {
		return doblePedido;
	}
	/**
	 * @param doblePedido the doblePedido to set
	 */
	public void setDoblePedido(String doblePedido) {
		this.doblePedido = doblePedido;
	}
	/**
	 * @return the doblePedidoPadre
	 */
	public String getDoblePedidoPadre() {
		return doblePedidoPadre;
	}
	/**
	 * @param doblePedidoPadre the doblePedidoPadre to set
	 */
	public void setDoblePedidoPadre(String doblePedidoPadre) {
		this.doblePedidoPadre = doblePedidoPadre;
	}
	/**
	 * @return the detalleDiaDoblePedido
	 */
	public AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO getDetalleDiaDoblePedido() {
		return detalleDiaDoblePedido;
	}
	/**
	 * @param detalleDiaDoblePedido the detalleDiaDoblePedido to set
	 */
	public void setDetalleDiaDoblePedido(AreaTrabajoCalendarioProcesoConfiguracionDetalleDTO detalleDiaDoblePedido) {
		this.detalleDiaDoblePedido = detalleDiaDoblePedido;
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
	public Integer getCodigoSubbodega() {
		return codigoSubbodega;
	}
	public void setCodigoSubbodega(Integer codigoSubbodega) {
		this.codigoSubbodega = codigoSubbodega;
	}
	
	public Date getFechaFinBloqueo() {
		return fechaFinBloqueo;
	}
	public void setFechaFinBloqueo(Date fechaFinBloqueo) {
		this.fechaFinBloqueo = fechaFinBloqueo;
	}
	public Collection<EstructuraConfiguracionPedidoAsistidoVO> getFechasBloqueo() {
		return fechasBloqueo;
	}
	public void setFechasBloqueo(Collection<EstructuraConfiguracionPedidoAsistidoVO> fechasBloqueo) {
		this.fechasBloqueo = fechasBloqueo;
	}
	public Date getFechaInicioBloqueo() {
		return fechaInicioBloqueo;
	}
	public void setFechaInicioBloqueo(Date fechaInicioBloqueo) {
		this.fechaInicioBloqueo = fechaInicioBloqueo;
	}
	public Collection<AreaTrabajoCalendarioProcesoDetalleDTO> getConfiguracionesBloqueoSelect() {
		return configuracionesBloqueoSelect;
	}
	public void setConfiguracionesBloqueoSelect(Collection<AreaTrabajoCalendarioProcesoDetalleDTO> configuracionesBloqueoSelect) {
		this.configuracionesBloqueoSelect = configuracionesBloqueoSelect;
	}
	public Collection<AreaTrabajoCalendarioProcesoDTO> getConfiguracionesLocalesSelect() {
		return configuracionesLocalesSelect;
	}
	public void setConfiguracionesLocalesSelect(Collection<AreaTrabajoCalendarioProcesoDTO> configuracionesLocalesSelect) {
		this.configuracionesLocalesSelect = configuracionesLocalesSelect;
	}
	
	
}
