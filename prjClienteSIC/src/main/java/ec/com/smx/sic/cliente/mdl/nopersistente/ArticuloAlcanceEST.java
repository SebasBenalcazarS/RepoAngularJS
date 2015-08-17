package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Transient;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

/**
 * Estructura del reporte de alcances
 * @author fcollaguazo
 *
 */
@SuppressWarnings("serial")
public class ArticuloAlcanceEST extends ArticuloDTO{

	//Campos de articuloLocal
	private Integer codigoAreaTrabajo;
	private String nombreAreaTrabajo;
	private String estadoArticuloAlcance;
	private String idUsuarioRegistro;
	private Date fechaRegistro;
	private String nombreUsuarioRegistro;
	private String idUsuarioActivacion;
	private Date fechaActivacion;
	private String nombreUsuarioActivacion;
	private String idUsuarioInactivacion;
	private Date fechaInactivacion;
	private String nombreUsuarioInactivacion;
	private String nombreOpcion;
	private String codigoSistema;
	private Date fechaInicialAlcance;
	private Date fechaFinalAlcance;
	private String estadoIntegracionAlcance;
	private Long codigoArticuloAreaTrabajo;
	private String  tipoAsignacion;
	private Integer codigosReferencia;
	
	
	
	//Prototipo
	private String codigoReferenciaPrototipo;
	
	@Transient
	private String estiloEstadoAlcance;
	
	
	public  ArticuloAlcanceEST() {
		setSelected(true);

	}
	
	
	/**
	 * @return the estiloEstadoAlcance
	 */
	public String getEstiloEstadoAlcance() {
		String estilo = "";
			Date fechaActual = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaActual);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			fechaActual = cal.getTime();
			
			
			if(estadoIntegracionAlcance.equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)
					&& (fechaInicialAlcance.compareTo(fechaActual) < 0 || fechaInicialAlcance.compareTo(fechaActual)==0)
					&& (fechaFinalAlcance==null || fechaActual.compareTo(fechaFinalAlcance) < 0 ) 
					&& estadoArticuloAlcance.equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)){
				estilo = SICConstantes.getInstancia().ARTICULO_ALCANCE_ACTIVO;//verde
			}else if(fechaActual.compareTo(fechaInicialAlcance) < 0
					&& estadoArticuloAlcance.equals(SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO)){
				estilo = SICConstantes.getInstancia().ARTICULO_PROGRAMACION_ALCANCE;// celeste
			}else if(fechaFinalAlcance!=null
					&& (fechaFinalAlcance.compareTo(fechaActual) < 0 || fechaActual.compareTo(fechaFinalAlcance)==0)
					&& estadoIntegracionAlcance.equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)
					&& estadoArticuloAlcance.equals(SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO)){
				estilo = SICConstantes.getInstancia().ARTICULO_ALCANCE_INACTIVO;//amarillo
			}else if(fechaFinalAlcance!=null
					&& (fechaFinalAlcance.compareTo(fechaActual) < 0 || fechaActual.compareTo(fechaFinalAlcance)==0)
					&& (estadoIntegracionAlcance.equals(SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO) 
							|| estadoArticuloAlcance.equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO))){
				estilo = SICConstantes.getInstancia().ARTICULO_ALCANCE_ERROR_INACTIVACION;//rosado
			}else if(fechaInicialAlcance.compareTo(fechaActual)< 0 || fechaInicialAlcance.compareTo(fechaActual)==0 
					&& (estadoIntegracionAlcance.equals(SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO) 
							|| estadoArticuloAlcance.equals(SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO))){
				estilo = SICConstantes.getInstancia().ARTICULO_ALCANCE_ERROR_ACTIVACION;// lila
			}
			estiloEstadoAlcance = estilo;
		return estiloEstadoAlcance;
	}

	/**
	 * @param estiloEstadoAlcance the estiloEstadoAlcance to set
	 */
	public void setEstiloEstadoAlcance(String estiloEstadoAlcance) {
		this.estiloEstadoAlcance = estiloEstadoAlcance;
	}
	
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}
	
	public String getNombreAreaTrabajo() {
		return nombreAreaTrabajo;
	}

	public void setNombreAreaTrabajo(String nombreAreaTrabajo) {
		this.nombreAreaTrabajo = nombreAreaTrabajo;
	}



	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombreUsuarioRegistro() {
		return nombreUsuarioRegistro;
	}

	public void setNombreUsuarioRegistro(String nombreUsuarioRegistro) {
		this.nombreUsuarioRegistro = nombreUsuarioRegistro;
	}

	public String getIdUsuarioActivacion() {
		return idUsuarioActivacion;
	}

	public String getEstadoArticuloAlcance() {
		return estadoArticuloAlcance;
	}


	public void setEstadoArticuloAlcance(String estadoArticuloAlcance) {
		this.estadoArticuloAlcance = estadoArticuloAlcance;
	}


	public void setIdUsuarioActivacion(String idUsuarioActivacion) {
		this.idUsuarioActivacion = idUsuarioActivacion;
	}

	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	public String getNombreUsuarioActivacion() {
		return nombreUsuarioActivacion;
	}

	public void setNombreUsuarioActivacion(String nombreUsuarioActivacion) {
		this.nombreUsuarioActivacion = nombreUsuarioActivacion;
	}

	public String getIdUsuarioInactivacion() {
		return idUsuarioInactivacion;
	}

	public void setIdUsuarioInactivacion(String idUsuarioInactivacion) {
		this.idUsuarioInactivacion = idUsuarioInactivacion;
	}

	public Date getFechaInactivacion() {
		return fechaInactivacion;
	}

	public void setFechaInactivacion(Date fechaInactivacion) {
		this.fechaInactivacion = fechaInactivacion;
	}

	public String getNombreUsuarioInactivacion() {
		return nombreUsuarioInactivacion;
	}

	public void setNombreUsuarioInactivacion(String nombreUsuarioInactivacion) {
		this.nombreUsuarioInactivacion = nombreUsuarioInactivacion;
	}

	public String getNombreOpcion() {
		return nombreOpcion;
	}

	public void setNombreOpcion(String nombreOpcion) {
		this.nombreOpcion = nombreOpcion;
	}

	public String getCodigoReferenciaPrototipo() {
		return codigoReferenciaPrototipo;
	}

	public void setCodigoReferenciaPrototipo(String codigoReferenciaPrototipo) {
		this.codigoReferenciaPrototipo = codigoReferenciaPrototipo;
	}

	public Date getFechaInicialAlcance() {
		return fechaInicialAlcance;
	}

	public void setFechaInicialAlcance(Date fechaInicialAlcance) {
		this.fechaInicialAlcance = fechaInicialAlcance;
	}

	public Date getFechaFinalAlcance() {
		return fechaFinalAlcance;
	}

	public void setFechaFinalAlcance(Date fechaFinalAlcance) {
		this.fechaFinalAlcance = fechaFinalAlcance;
	}


	public String getCodigoSistema() {
		return codigoSistema;
	}


	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}


	public String getEstadoIntegracionAlcance() {
		return estadoIntegracionAlcance;
	}


	public void setEstadoIntegracionAlcance(String estadoIntegracionAlcance) {
		this.estadoIntegracionAlcance = estadoIntegracionAlcance;
	}

	/**
	 * @return the codigoArticuloAreaTrabajo
	 */
	public Long getCodigoArticuloAreaTrabajo() {
		return codigoArticuloAreaTrabajo;
	}


	/**
	 * @param codigoArticuloAreaTrabajo the codigoArticuloAreaTrabajo to set
	 */
	public void setCodigoArticuloAreaTrabajo(Long codigoArticuloAreaTrabajo) {
		this.codigoArticuloAreaTrabajo = codigoArticuloAreaTrabajo;
	}


	public String getTipoAsignacion() {
		return tipoAsignacion;
	}


	public void setTipoAsignacion(String tipoAsignacion) {
		this.tipoAsignacion = tipoAsignacion;
	}


	public Integer getCodigosReferencia() {
		return codigosReferencia;
	}


	public void setCodigosReferencia(Integer codigosReferencia) {
		this.codigosReferencia = codigosReferencia;
	}

}