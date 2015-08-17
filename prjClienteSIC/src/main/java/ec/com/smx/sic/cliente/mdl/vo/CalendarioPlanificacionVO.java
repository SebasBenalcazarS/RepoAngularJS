package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import ec.com.smx.sic.cliente.common.bodega.CabeceraCalendarioDia;

@SuppressWarnings("serial")
public class CalendarioPlanificacionVO implements Serializable{
	private String cabeceraCalendarioJson;
	private String datosCalendarioJson;
	private int contadorProveedores = 0;
	private long numeroBultos = 0;
	private int numeroSolicitudes = 0;
	private Map<String, String> horaDiaMap;
	private Map<String, Integer> horaColumnaReporte;
	private Collection<Map<String, Object>> datosCalendario;
	private CabeceraCalendarioDia cabeceraCalendario;
	private Collection<String> mensajesError;
	private Collection<String> mensajesInformacion;
	
	//paginacion de resultados
	private Integer totalRegistos;
	
	public String getCabeceraCalendarioJson() {
		return cabeceraCalendarioJson;
	}
	public void setCabeceraCalendarioJson(String cabeceraCalendarioJson) {
		this.cabeceraCalendarioJson = cabeceraCalendarioJson;
	}
	public String getDatosCalendarioJson() {
		return datosCalendarioJson;
	}
	public void setDatosCalendarioJson(String datosCalendarioJson) {
		this.datosCalendarioJson = datosCalendarioJson;
	}
	public int getContadorProveedores() {
		return contadorProveedores;
	}
	public void setContadorProveedores(int contadorProveedores) {
		this.contadorProveedores = contadorProveedores;
	}
	public long getNumeroBultos() {
		return numeroBultos;
	}
	public void setNumeroBultos(long numeroBultos) {
		this.numeroBultos = numeroBultos;
	}
	public int getNumeroSolicitudes() {
		return numeroSolicitudes;
	}
	public void setNumeroSolicitudes(int numeroSolicitudes) {
		this.numeroSolicitudes = numeroSolicitudes;
	}
	public Map<String, String> getHoraDiaMap() {
		return horaDiaMap;
	}
	public void setHoraDiaMap(Map<String, String> horaDiaMap) {
		this.horaDiaMap = horaDiaMap;
	}
	public Map<String, Integer> getHoraColumnaReporte() {
		return horaColumnaReporte;
	}
	public void setHoraColumnaReporte(Map<String, Integer> horaColumnaReporte) {
		this.horaColumnaReporte = horaColumnaReporte;
	}
	public Collection<Map<String, Object>> getDatosCalendario() {
		return datosCalendario;
	}
	public void setDatosCalendario(Collection<Map<String, Object>> datosCalendario) {
		this.datosCalendario = datosCalendario;
	}
	public CabeceraCalendarioDia getCabeceraCalendario() {
		return cabeceraCalendario;
	}
	public void setCabeceraCalendario(CabeceraCalendarioDia cabeceraCalendario) {
		this.cabeceraCalendario = cabeceraCalendario;
	}
	public Collection<String> getMensajesError() {
		return mensajesError;
	}
	public void setMensajesError(Collection<String> mensajesError) {
		this.mensajesError = mensajesError;
	}
	public Collection<String> getMensajesInformacion() {
		return mensajesInformacion;
	}
	public void setMensajesInformacion(Collection<String> mensajesInformacion) {
		this.mensajesInformacion = mensajesInformacion;
	}
	public void addMensajeError(String mensaje){
		if(mensajesError == null){
			mensajesError = new ArrayList<String>();
		}
		mensajesError.add(mensaje);
	}
	public void addMensajeInformacion(String mensaje){
		if(mensajesInformacion == null){
			mensajesInformacion = new ArrayList<String>();
		}
		mensajesInformacion.add(mensaje);
	}
	/**
	 * @return the totalRegistos
	 */
	public Integer getTotalRegistos() {
		return totalRegistos;
	}
	/**
	 * @param totalRegistos the totalRegistos to set
	 */
	public void setTotalRegistos(Integer totalRegistos) {
		this.totalRegistos = totalRegistos;
	}
}
