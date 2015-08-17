package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.ConfiguracionDatosProcesadosID;

/**
 * Clase DTO que extiende, representa la tabla SCCEMTCONDATPRO
 * del Schema DSMXSIC
 * 
 * @author srodriguez
 * 2014-11-20
*/

@Entity
@Table(name = "SCCEMTCONDATPRO")
public class ConfiguracionDatosProcesadosDTO {

	
	/**
	 * Clave primaria de la tabla ConfiguracionDatosProcesadosDTO
	 * 
	 */
	@EmbeddedId
	private ConfiguracionDatosProcesadosID id = new ConfiguracionDatosProcesadosID();
	
	
	/**
	 * Fecha de inicio rango
	 */
	@Column(name = "FECHAINICIO")
	private Timestamp fechaInicio;
	
	/**
	 * Fecha de inicio rango
	 */
	@Column(name = "FECHAFIN")
	private Timestamp fechaFin;
	
	/**
	 * Fecha de finalizacion de ejecucion
	 */
	@Column(name = "NUMEROREGISTROS")
	private Integer numeroRegistros;
	
	/**
	 * Fecha de inicio de ejecucion
	 */
	@Column(name = "NUMEROELEMENTOSSELECCION")
	private Integer numeroElementosSeleccion;
	
	/**
	 * Fecha de inicio rango de ejecucion
	 */
	@Column(name = "FECHAINICIOEJECUCION")
	private Date fechaInicioEjecucion;
	
	/**
	 * Fecha de fin de ejecucion
	 */
	@Column(name = "FECHAFINEJECUCION")
	private Date fechaFinEjecucion;
	
	/**
	 * Boolean procesado
	 * @author srodriguez
	 * 6/2/2015
	 */
 	@Column(name = "PROCESADO")
	private Boolean procesado;
	
	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@Column(name = "ESTADO")
	private String estado;
	
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name = "IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column(name = "FECHAREGISTRO")
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@Column(name = "IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@Column(name = "FECHAMODIFICACION")
	private java.util.Date fechaModificacion;
	

	@OneToMany(mappedBy = "configuracionDatosProcesadosDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DefinicionConfiguracionDTO> definicionConfiguracionCol;
	
	
	
	@OneToMany(mappedBy = "configuracionDatosProcesadosDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ConfiguracionDatosProcesadosAcumuladosDTO> configuracionDatosProcesadosAcumuladosCol;
	
	
	/* Metodo que retorna id del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return ConfiguracionDatosProcesadosID id 
	 */
	public ConfiguracionDatosProcesadosID getId() {
		return id;
	}

	/* Metodo que asigna el id del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param id parametro de tipo ConfiguracionDatosProcesadosID
	 */
	public void setId(ConfiguracionDatosProcesadosID id) {
		this.id = id;
	}

	

	/* Metodo que retorna fechaInicioEjecucion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Date fechaInicioEjecucion 
	 */
	public Date getFechaInicioEjecucion() {
		return fechaInicioEjecucion;
	}

	/* Metodo que asigna el fechaInicioEjecucion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param fechaInicioEjecucion parametro de tipo Date
	 */
	public void setFechaInicioEjecucion(Date fechaInicioEjecucion) {
		this.fechaInicioEjecucion = fechaInicioEjecucion;
	}

	/* Metodo que retorna fechaFinEjecucion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Date fechaFinEjecucion 
	 */
	public Date getFechaFinEjecucion() {
		return fechaFinEjecucion;
	}

	/* Metodo que asigna el fechaFinEjecucion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param fechaFinEjecucion parametro de tipo Date
	 */
	public void setFechaFinEjecucion(Date fechaFinEjecucion) {
		this.fechaFinEjecucion = fechaFinEjecucion;
	}


	/* Metodo que retorna idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.lang.String idUsuarioRegistro 
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/* Metodo que asigna el idUsuarioRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param idUsuarioRegistro parametro de tipo java.lang.String
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/* Metodo que retorna fechaRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.util.Date fechaRegistro 
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/* Metodo que asigna el fechaRegistro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param fechaRegistro parametro de tipo java.util.Date
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/* Metodo que retorna idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.lang.String idUsuarioModificacion 
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/* Metodo que asigna el idUsuarioModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param idUsuarioModificacion parametro de tipo java.lang.String
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/* Metodo que retorna fechaModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return java.util.Date fechaModificacion 
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/* Metodo que asigna el fechaModificacion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param fechaModificacion parametro de tipo java.util.Date
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/* Metodo que retorna definicionConfiguracionCol del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Collection<DefinicionConfiguracionDTO> definicionConfiguracionCol 
	 */
	public Collection<DefinicionConfiguracionDTO> getDefinicionConfiguracionCol() {
		return definicionConfiguracionCol;
	}

	/* Metodo que asigna el definicionConfiguracionCol del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param definicionConfiguracionCol parametro de tipo Collection<DefinicionConfiguracionDTO>
	 */
	public void setDefinicionConfiguracionCol(Collection<DefinicionConfiguracionDTO> definicionConfiguracionCol) {
		this.definicionConfiguracionCol = definicionConfiguracionCol;
	}

	/* Metodo que retorna configuracionDatosProcesadosAcumuladosCol del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Collection<ConfiguracionDatosProcesadosAcumuladosDTO> configuracionDatosProcesadosAcumuladosCol 
	 */
	public Collection<ConfiguracionDatosProcesadosAcumuladosDTO> getConfiguracionDatosProcesadosAcumuladosCol() {
		return configuracionDatosProcesadosAcumuladosCol;
	}

	/* Metodo que asigna el configuracionDatosProcesadosAcumuladosCol del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param configuracionDatosProcesadosAcumuladosCol parametro de tipo Collection<ConfiguracionDatosProcesadosAcumuladosDTO>
	 */
	public void setConfiguracionDatosProcesadosAcumuladosCol(Collection<ConfiguracionDatosProcesadosAcumuladosDTO> configuracionDatosProcesadosAcumuladosCol) {
		this.configuracionDatosProcesadosAcumuladosCol = configuracionDatosProcesadosAcumuladosCol;
	}

	/* Metodo que retorna numeroRegistros del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Integer numeroRegistros 
	 */
	public Integer getNumeroRegistros() {
		return numeroRegistros;
	}

	/* Metodo que asigna el numeroRegistros del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param numeroRegistros parametro de tipo Integer
	 */
	public void setNumeroRegistros(Integer numeroRegistros) {
		this.numeroRegistros = numeroRegistros;
	}

	/* Metodo que retorna estado del objeto 
	 * @author srodriguez
	 * 27/11/2014
	 * @return String estado 
	 */
	public String getEstado() {
		return estado;
	}

	/* Metodo que asigna el estado del objeto
	 * @author srodriguez
	 * 27/11/2014
	 * @param estado parametro de tipo String
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/* Metodo que retorna numeroElementosSeleccion del objeto
	 * @author srodriguez
	 * 27/11/2014
	 * @return Integer numeroElementosSeleccion 
	 */
	public Integer getNumeroElementosSeleccion() {
		return numeroElementosSeleccion;
	}

	/* Metodo que asigna el numeroElementosSeleccion del objeto
	 * @author srodriguez
	 * 27/11/2014
	 * @param numeroElementosSeleccion parametro de tipo Integer
	 */
	public void setNumeroElementosSeleccion(Integer numeroElementosSeleccion) {
		this.numeroElementosSeleccion = numeroElementosSeleccion;
	}

	/* Metodo que retorna fechaInicio del objeto
	 * @author srodriguez
	 * 08/12/2014
	 * @return Timestamp fechaInicio 
	 */
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	/* Metodo que asigna el fechaInicio del objeto
	 * @author srodriguez
	 * 08/12/2014
	 * @param fechaInicio parametro de tipo Timestamp
	 */
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/* Metodo que retorna fechaFin del objeto
	 * @author srodriguez
	 * 08/12/2014
	 * @return Timestamp fechaFin 
	 */
	public Timestamp getFechaFin() {
		return fechaFin;
	}

	/* Metodo que asigna el fechaFin del objeto
	 * @author srodriguez
	 * 08/12/2014
	 * @param fechaFin parametro de tipo Timestamp
	 */
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	/** Metodo que retorna procesado del objeto
	 * @author srodriguez
	 * 6/2/2015
	 * @return Boolean procesado 
	 */
	public Boolean getProcesado() {
		return procesado;
	}

	/** Metodo que asigana el valor de procesado del objeto
	 * @author srodriguez
	 * 6/2/2015
	 * @return Boolean procesado 
	 */
	public void setProcesado(Boolean procesado) {
		this.procesado = procesado;
	}
}
