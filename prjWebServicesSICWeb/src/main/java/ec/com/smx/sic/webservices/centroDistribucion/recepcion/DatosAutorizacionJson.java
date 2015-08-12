package ec.com.smx.sic.webservices.centroDistribucion.recepcion;

import java.util.Collection;

import ec.com.smx.framework.jsf.commons.util.components.AtributosCalendarUtil;

public class DatosAutorizacionJson {
	Integer codigoCompania;
	Long codigoAutorizacion;
	String codigoSistema;
	String nombreUsuarioAutorizador;
	String nombreUsuarioAutorizado;
	String idUsuarioAutorizador;
	String estadoAutorizacion;
	String fechaSolicitud;
	String fechaSeleccionada;
	String nombreProveedor;
	String descripcion;
	Long codigoHoraCalendario;
	Long codigoDetalleEntregaProveedor;
	Integer cantidadSolicitada;
	String numeroCaso;
	Collection<HorariosDisponiblesAutorizar> horariosDisponiblesAutorizar;
	DatosCalendarioMonthly datosCalendarioMonthly;

	public String getNombreUsuarioAutorizado() {
		return nombreUsuarioAutorizado;
	}

	public void setNombreUsuarioAutorizado(String nombreUsuarioAutorizado) {
		this.nombreUsuarioAutorizado = nombreUsuarioAutorizado;
	}

	public String getFechaSeleccionada() {
		return fechaSeleccionada;
	}

	public void setFechaSeleccionada(String fechaSeleccionada) {
		this.fechaSeleccionada = fechaSeleccionada;
	}

	public DatosCalendarioMonthly getDatosCalendarioMonthly() {
		return datosCalendarioMonthly;
	}

	public void setDatosCalendarioMonthly(
			DatosCalendarioMonthly datosCalendarioMonthly) {
		this.datosCalendarioMonthly = datosCalendarioMonthly;
	}

	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(Integer cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public Long getCodigoHoraCalendario() {
		return codigoHoraCalendario;
	}

	public void setCodigoHoraCalendario(Long codigoHoraCalendario) {
		this.codigoHoraCalendario = codigoHoraCalendario;
	}

	public Long getCodigoDetalleEntregaProveedor() {
		return codigoDetalleEntregaProveedor;
	}

	public void setCodigoDetalleEntregaProveedor(
			Long codigoDetalleEntregaProveedor) {
		this.codigoDetalleEntregaProveedor = codigoDetalleEntregaProveedor;
	}

	public String getIdUsuarioAutorizador() {
		return idUsuarioAutorizador;
	}

	public void setIdUsuarioAutorizador(String idUsuarioAutorizador) {
		this.idUsuarioAutorizador = idUsuarioAutorizador;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	public void setCodigoAutorizacion(Long codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}

	public String getCodigoSistema() {
		return codigoSistema;
	}

	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}

	public String getNombreUsuarioAutorizador() {
		return nombreUsuarioAutorizador;
	}

	public void setNombreUsuarioAutorizador(String nombreUsuarioAutorizador) {
		this.nombreUsuarioAutorizador = nombreUsuarioAutorizador;
	}

	public String getEstadoAutorizacion() {
		return estadoAutorizacion;
	}

	public void setEstadoAutorizacion(String estadoAutorizacion) {
		this.estadoAutorizacion = estadoAutorizacion;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNumeroCaso() {
		return numeroCaso;
	}

	public void setNumeroCaso(String numeroCaso) {
		this.numeroCaso = numeroCaso;
	}

	public Collection<HorariosDisponiblesAutorizar> getHorariosDisponiblesAutorizar() {
		return horariosDisponiblesAutorizar;
	}

	public void setHorariosDisponiblesAutorizar(
			Collection<HorariosDisponiblesAutorizar> horariosDisponiblesAutorizar) {
		this.horariosDisponiblesAutorizar = horariosDisponiblesAutorizar;
	}

}

class HorariosDisponiblesAutorizar {

	Long codigoCalendario;
	Long codigoHoraCalendario;
	Long codigoDetalleCalendario;
	String codigoProveedor;
	//Integer codigoSubBodegaART;
	//Integer codigoBodegaART;
	//String codigoCentroDistribucion;
	Integer codigoAreaTrabajo;
	String andenesDefault;

	String horaInicio;
	Long horaInicioTime;
	String fechaCalendario;
	Integer diaSemana;
	Integer cantidadDisponible;
	Integer cantidadUtilizada;
	Integer cantidadSolicitada;
	Integer cantidadFurgones;
	Integer cantidadBultos;
	Integer cantidadTotalDisponible;
	Long numeroAutorizacion;
	String codigoJDE;
	String descripcionAreaTrabajo;
	//Integer codigoAreaTrabajoSubBodega;
	Integer cantidadPlanificada;
	Integer numeroRegistro;
	Integer codigoCompania;

	public Integer getCantidadBultos() {
		return cantidadBultos;
	}

	public void setCantidadBultos(Integer cantidadBultos) {
		this.cantidadBultos = cantidadBultos;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Integer getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(Integer numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public String getAndenesDefault() {
		return andenesDefault;
	}

	public void setAndenesDefault(String andenesDefault) {
		this.andenesDefault = andenesDefault;
	}

	public Long getHoraInicioTime() {
		return horaInicioTime;
	}

	public void setHoraInicioTime(Long horaInicioTime) {
		this.horaInicioTime = horaInicioTime;
	}

	public Long getCodigoCalendario() {
		return codigoCalendario;
	}

	public void setCodigoCalendario(Long codigoCalendario) {
		this.codigoCalendario = codigoCalendario;
	}

	public Long getCodigoHoraCalendario() {
		return codigoHoraCalendario;
	}

	public void setCodigoHoraCalendario(Long codigoHoraCalendario) {
		this.codigoHoraCalendario = codigoHoraCalendario;
	}

	public Long getCodigoDetalleCalendario() {
		return codigoDetalleCalendario;
	}

	public void setCodigoDetalleCalendario(Long codigoDetalleCalendario) {
		this.codigoDetalleCalendario = codigoDetalleCalendario;
	}

	public String getCodigoJDE() {
		return codigoJDE;
	}

	public void setCodigoJDE(String codigoJDE) {
		this.codigoJDE = codigoJDE;
	}

	public String getDescripcionAreaTrabajo() {
		return descripcionAreaTrabajo;
	}

	public void setDescripcionAreaTrabajo(String descripcionAreaTrabajo) {
		this.descripcionAreaTrabajo = descripcionAreaTrabajo;
	}

	public Integer getCantidadPlanificada() {
		return cantidadPlanificada;
	}

	public void setCantidadPlanificada(Integer cantidadPlanificada) {
		this.cantidadPlanificada = cantidadPlanificada;
	}

	public Long getNumeroAutorizacion() {
		return numeroAutorizacion;
	}

	public void setNumeroAutorizacion(Long numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	public Integer getCantidadTotalDisponible() {
		return cantidadTotalDisponible;
	}

	public void setCantidadTotalDisponible(Integer cantidadTotalDisponible) {
		this.cantidadTotalDisponible = cantidadTotalDisponible;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getFechaCalendario() {
		return fechaCalendario;
	}

	public void setFechaCalendario(String fechaCalendario) {
		this.fechaCalendario = fechaCalendario;
	}

	public Integer getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public Integer getCantidadUtilizada() {
		return cantidadUtilizada;
	}

	public void setCantidadUtilizada(Integer cantidadUtilizada) {
		this.cantidadUtilizada = cantidadUtilizada;
	}

	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(Integer cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public Integer getCantidadFurgones() {
		return cantidadFurgones;
	}

	public void setCantidadFurgones(Integer cantidadFurgones) {
		this.cantidadFurgones = cantidadFurgones;
	}
}

class DatosCalendarioMonthly {
	public Collection<AtributosCalendarUtil> cadenaBloqueos;
	public String multiSeleccion;
	public boolean bloquearFechaAnterior;
	public String cadenaFechasSelecionas;
	public String cadenaEmulaConstructor;
	public String modoInicio;
	public String fechaMax;

	public Collection<AtributosCalendarUtil> getCadenaBloqueos() {
		return cadenaBloqueos;
	}

	public void setCadenaBloqueos(Collection<AtributosCalendarUtil> cadenaBloqueos) {
		this.cadenaBloqueos = cadenaBloqueos;
	}

	public String getMultiSeleccion() {
		return multiSeleccion;
	}

	public void setMultiSeleccion(String multiSeleccion) {
		this.multiSeleccion = multiSeleccion;
	}

	public boolean getBloquearFechaAnterior() {
		return bloquearFechaAnterior;
	}

	public void setBloquearFechaAnterior(boolean bloquearFechaAnterior) {
		this.bloquearFechaAnterior = bloquearFechaAnterior;
	}

	public String getCadenaFechasSelecionas() {
		return cadenaFechasSelecionas;
	}

	public void setCadenaFechasSelecionas(String cadenaFechasSelecionas) {
		this.cadenaFechasSelecionas = cadenaFechasSelecionas;
	}

	public String getCadenaEmulaConstructor() {
		return cadenaEmulaConstructor;
	}

	public void setCadenaEmulaConstructor(String cadenaEmulaConstructor) {
		this.cadenaEmulaConstructor = cadenaEmulaConstructor;
	}

	public String getModoInicio() {
		return modoInicio;
	}

	public void setModoInicio(String modoInicio) {
		this.modoInicio = modoInicio;
	}

	public String getFechaMax() {
		return fechaMax;
	}

	public void setFechaMax(String fechaMax) {
		this.fechaMax = fechaMax;
	}
}
