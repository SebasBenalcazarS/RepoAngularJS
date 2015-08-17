/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.articulo.nosql;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.articulo.VistaArticuloLocalNoSqlID;

/**
 * Vista para realizar la migraci&oacute;n de SCSADTARTLOC, SCSADTARTBOD, SCSADTARTOFI desde DB2 hacia orientDB
 * @author wcaiza
 *
 */
@Entity
@SuppressWarnings("serial")
public class VistaArticuloLocalNoSqlDTO extends SearchDTO {
	
	@EmbeddedId
	private VistaArticuloLocalNoSqlID id = new VistaArticuloLocalNoSqlID();
	
	private String estadoArticuloLocal;
	private Date fechaInicialAlcance;
	private Date fechaFinalAlcance;
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
	private String notificarLocal;
	private String aperturaLocal;
	
	// Campos de auditoria
	private String idUsuarioRegistro;
	private Timestamp fechaRegistro;
	private String idUsuarioModificacion;
	private Timestamp fechaModificacion;
	
	//campo para identificar el prototipo al q pertenece el articulo
	private Integer codigoGrupoAlcance;
	
	
	
	
	public Integer getCodigoGrupoAlcance() {
		return codigoGrupoAlcance;
	}

	public void setCodigoGrupoAlcance(Integer codigoGrupoAlcance) {
		this.codigoGrupoAlcance = codigoGrupoAlcance;
	}

	/**
	 * @return the id
	 */
	public VistaArticuloLocalNoSqlID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaArticuloLocalNoSqlID id) {
		this.id = id;
	}

	/**
	 * @return the estadoArticuloLocal
	 */
	public String getEstadoArticuloLocal() {
		return estadoArticuloLocal;
	}

	/**
	 * @param estadoArticuloLocal the estadoArticuloLocal to set
	 */
	public void setEstadoArticuloLocal(String estadoArticuloLocal) {
		this.estadoArticuloLocal = estadoArticuloLocal;
	}

	/**
	 * @return the fechaInicialAlcance
	 */
	public Date getFechaInicialAlcance() {
		return fechaInicialAlcance;
	}

	/**
	 * @param fechaInicialAlcance the fechaInicialAlcance to set
	 */
	public void setFechaInicialAlcance(Date fechaInicialAlcance) {
		this.fechaInicialAlcance = fechaInicialAlcance;
	}

	/**
	 * @return the fechaFinalAlcance
	 */
	public Date getFechaFinalAlcance() {
		return fechaFinalAlcance;
	}

	/**
	 * @param fechaFinalAlcance the fechaFinalAlcance to set
	 */
	public void setFechaFinalAlcance(Date fechaFinalAlcance) {
		this.fechaFinalAlcance = fechaFinalAlcance;
	}

	/**
	 * @return the minimoStock
	 */
	public Long getMinimoStock() {
		return minimoStock;
	}

	/**
	 * @param minimoStock the minimoStock to set
	 */
	public void setMinimoStock(Long minimoStock) {
		this.minimoStock = minimoStock;
	}

	/**
	 * @return the maximoStock
	 */
	public Long getMaximoStock() {
		return maximoStock;
	}

	/**
	 * @param maximoStock the maximoStock to set
	 */
	public void setMaximoStock(Long maximoStock) {
		this.maximoStock = maximoStock;
	}

	/**
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * @return the estadoCodigoReferencia
	 */
	public String getEstadoCodigoReferencia() {
		return estadoCodigoReferencia;
	}

	/**
	 * @param estadoCodigoReferencia the estadoCodigoReferencia to set
	 */
	public void setEstadoCodigoReferencia(String estadoCodigoReferencia) {
		this.estadoCodigoReferencia = estadoCodigoReferencia;
	}

	/**
	 * @return the estadoIntegracionAlcance
	 */
	public String getEstadoIntegracionAlcance() {
		return estadoIntegracionAlcance;
	}

	/**
	 * @param estadoIntegracionAlcance the estadoIntegracionAlcance to set
	 */
	public void setEstadoIntegracionAlcance(String estadoIntegracionAlcance) {
		this.estadoIntegracionAlcance = estadoIntegracionAlcance;
	}

	/**
	 * @return the idUsuarioActivacion
	 */
	public String getIdUsuarioActivacion() {
		return idUsuarioActivacion;
	}

	/**
	 * @param idUsuarioActivacion the idUsuarioActivacion to set
	 */
	public void setIdUsuarioActivacion(String idUsuarioActivacion) {
		this.idUsuarioActivacion = idUsuarioActivacion;
	}

	/**
	 * @return the fechaActivacion
	 */
	public Date getFechaActivacion() {
		return fechaActivacion;
	}

	/**
	 * @param fechaActivacion the fechaActivacion to set
	 */
	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

	/**
	 * @return the idUsuarioInactivacion
	 */
	public String getIdUsuarioInactivacion() {
		return idUsuarioInactivacion;
	}

	/**
	 * @param idUsuarioInactivacion the idUsuarioInactivacion to set
	 */
	public void setIdUsuarioInactivacion(String idUsuarioInactivacion) {
		this.idUsuarioInactivacion = idUsuarioInactivacion;
	}

	/**
	 * @return the fechaInactivacion
	 */
	public Date getFechaInactivacion() {
		return fechaInactivacion;
	}

	/**
	 * @param fechaInactivacion the fechaInactivacion to set
	 */
	public void setFechaInactivacion(Date fechaInactivacion) {
		this.fechaInactivacion = fechaInactivacion;
	}

	/**
	 * @return the codigoSistema
	 */
	public String getCodigoSistema() {
		return codigoSistema;
	}

	/**
	 * @param codigoSistema the codigoSistema to set
	 */
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}

	/**
	 * @return the codigoOpcion
	 */
	public String getCodigoOpcion() {
		return codigoOpcion;
	}

	/**
	 * @param codigoOpcion the codigoOpcion to set
	 */
	public void setCodigoOpcion(String codigoOpcion) {
		this.codigoOpcion = codigoOpcion;
	}

	/**
	 * @return the valorTipoAsignacion
	 */
	public String getValorTipoAsignacion() {
		return valorTipoAsignacion;
	}

	/**
	 * @param valorTipoAsignacion the valorTipoAsignacion to set
	 */
	public void setValorTipoAsignacion(String valorTipoAsignacion) {
		this.valorTipoAsignacion = valorTipoAsignacion;
	}

	/**
	 * @return the codigoTipoAsignacion
	 */
	public Integer getCodigoTipoAsignacion() {
		return codigoTipoAsignacion;
	}

	/**
	 * @param codigoTipoAsignacion the codigoTipoAsignacion to set
	 */
	public void setCodigoTipoAsignacion(Integer codigoTipoAsignacion) {
		this.codigoTipoAsignacion = codigoTipoAsignacion;
	}

	/**
	 * @return the notificarLocal
	 */
	public String getNotificarLocal() {
		return notificarLocal;
	}

	/**
	 * @param notificarLocal the notificarLocal to set
	 */
	public void setNotificarLocal(String notificarLocal) {
		this.notificarLocal = notificarLocal;
	}

	/**
	 * @return the aperturaLocal
	 */
	public String getAperturaLocal() {
		return aperturaLocal;
	}

	/**
	 * @param aperturaLocal the aperturaLocal to set
	 */
	public void setAperturaLocal(String aperturaLocal) {
		this.aperturaLocal = aperturaLocal;
	}

	/**
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

}
