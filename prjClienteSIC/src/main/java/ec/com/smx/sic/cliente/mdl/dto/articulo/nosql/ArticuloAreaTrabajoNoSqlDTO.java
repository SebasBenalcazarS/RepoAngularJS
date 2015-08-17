package ec.com.smx.sic.cliente.mdl.dto.articulo.nosql;

import java.sql.Timestamp;

import java.util.Date;
import java.util.Set;


/**
 * Plantilla para registrar alcance de articulos en OrientDB 
 * @author bymontesdeoca
 */
public class ArticuloAreaTrabajoNoSqlDTO {

	private Integer codigoCompania;
	private Set<String> setCodArt; // conjunto de articulos [1093290,6457190,...]
	private Set<Integer> setCodAreTra; // conjunto de areas de trabajo [100,101,300,...]
	private String tipoAreaTrabajo; // tipo de area 'LOC'/'OFI'/'BOD'
	private String tipoAsignacionAlcance; // tipo de asignacion: locales especificos,locales por prototipo,oficinas especificas,bodegas especificas....  
	
//	//campo para identificar el prototipo al q pertenece el articulo
//	private Integer codigoGrupoAlcance;
	
	private String opcionAsignacion; // (añadir,quitar,reemplazar)
	
	private String estadoAlcance;
	private Date fechaInicialAlcance;
	private Date fechaFinalAlcance; // obligatorio cuando sea opcion quitar
	private Long minimoStock;
	private Long maximoStock;
	private String codigoReferencia;
	private String estadoCodigoReferencia;
	private String estadoIntegracionAlcance;
	
	private String idUsuarioActivacion;
	private Date fechaActivacion;
	private String idUsuarioInactivacion;
	private Date fechaInactivacion;
	
	private String codigoSistema;
	private String codigoOpcion;
	private String valorTipoAsignacion;
	private Integer codigoTipoAsignacion;
	private String notificarLocal; // solo para locales por defecto true, caso especial copia de local el usuario selecciona en pantalla
	//private String aperturaLocal;
	
	// Campos de auditoria
	private String idUsuario;
	private Date fechaRegistro;
	private String idUsuarioModificacion;
	private Date fechaModificacion;
	

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Set<String> getSetCodArt() {
		return setCodArt;
	}

	public void setSetCodArt(Set<String> setCodArt) {
		this.setCodArt = setCodArt;
	}

	public Set<Integer> getSetCodAreTra() {
		return setCodAreTra;
	}

	public void setSetCodAreTra(Set<Integer> setCodAreTra) {
		this.setCodAreTra = setCodAreTra;
	}

	public String getTipoAreaTrabajo() {
		return tipoAreaTrabajo;
	}

	public void setTipoAreaTrabajo(String tipoAreaTrabajo) {
		this.tipoAreaTrabajo = tipoAreaTrabajo;
	}

	public String getEstadoAlcance() {
		return estadoAlcance;
	}

	public void setEstadoAlcance(String estadoAlcance) {
		this.estadoAlcance = estadoAlcance;
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

	public Long getMinimoStock() {
		return minimoStock;
	}

	public void setMinimoStock(Long minimoStock) {
		this.minimoStock = minimoStock;
	}

	public Long getMaximoStock() {
		return maximoStock;
	}

	public void setMaximoStock(Long maximoStock) {
		this.maximoStock = maximoStock;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	public String getEstadoCodigoReferencia() {
		return estadoCodigoReferencia;
	}

	public void setEstadoCodigoReferencia(String estadoCodigoReferencia) {
		this.estadoCodigoReferencia = estadoCodigoReferencia;
	}

	public String getEstadoIntegracionAlcance() {
		return estadoIntegracionAlcance;
	}

	public void setEstadoIntegracionAlcance(String estadoIntegracionAlcance) {
		this.estadoIntegracionAlcance = estadoIntegracionAlcance;
	}

	public String getIdUsuarioActivacion() {
		return idUsuarioActivacion;
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

	public String getCodigoSistema() {
		return codigoSistema;
	}

	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}

	public String getCodigoOpcion() {
		return codigoOpcion;
	}

	public void setCodigoOpcion(String codigoOpcion) {
		this.codigoOpcion = codigoOpcion;
	}

	public String getValorTipoAsignacion() {
		return valorTipoAsignacion;
	}

	public void setValorTipoAsignacion(String valorTipoAsignacion) {
		this.valorTipoAsignacion = valorTipoAsignacion;
	}

	public Integer getCodigoTipoAsignacion() {
		return codigoTipoAsignacion;
	}

	public void setCodigoTipoAsignacion(Integer codigoTipoAsignacion) {
		this.codigoTipoAsignacion = codigoTipoAsignacion;
	}

	public String getNotificarLocal() {
		return notificarLocal;
	}

	public void setNotificarLocal(String notificarLocal) {
		this.notificarLocal = notificarLocal;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

//	public Integer getCodigoGrupoAlcance() {
//		return codigoGrupoAlcance;
//	}
//
//	public void setCodigoGrupoAlcance(Integer codigoGrupoAlcance) {
//		this.codigoGrupoAlcance = codigoGrupoAlcance;
//	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getOpcionAsignacion() {
		return opcionAsignacion;
	}

	public void setOpcionAsignacion(String opcionAsignacion) {
		this.opcionAsignacion = opcionAsignacion;
	}

	public String getTipoAsignacionAlcance() {
		return tipoAsignacionAlcance;
	}

	public void setTipoAsignacionAlcance(String tipoAsignacionAlcance) {
		this.tipoAsignacionAlcance = tipoAsignacionAlcance;
	}


	

}
