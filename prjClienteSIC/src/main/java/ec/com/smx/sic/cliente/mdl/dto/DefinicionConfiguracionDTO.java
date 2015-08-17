package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.DefinicionConfiguracionID;


/**
 * Clase DTO que extiende, representa la tabla SCCEMTDEFCON
 * del Schema DSMXSIC
 * 
 * @author srodriguez
 * 2014-11-21
*/

@Entity
@Table(name = "SCCEMTDEFCON")
public class DefinicionConfiguracionDTO {

	/**
	 * Clave primaria de la tabla ConfiguracionDatosProcesadosDTO
	 * 
	 */
	@EmbeddedId
	private DefinicionConfiguracionID id = new DefinicionConfiguracionID();
	
	/**
	 * Llave foranea que referencia a la tabla Configuracion de datos procesados
	 */
	@Column(name = "CODIGOCONFIGURACION")
	private Long codigoConfiguracion;
	
	/**
	 * Lote de control de registros
	 */
	@Column(name = "LOTE")
	private Integer lote;
	
	/**
	 * Registro inicial Lote de control de registros
	 */
	@Column(name = "REGISTROFINAL")
	private Integer registroFinal;
	
	
	/**
	 * Registro inicial Lote de control de registros
	 */
	@Column(name = "REGISTROINICIAL")
	private Integer registroInicial;
	

	
	/**
	 * Estado del registro
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
	
	
	/**
	 * Obtiene la relacion con la tabla LocalizacionDTO 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
	@JoinColumn(name = "CODIGOCONFIGURACION", insertable = false, updatable = false, referencedColumnName = "CODIGOCONFIGURACION") })
	private ConfiguracionDatosProcesadosDTO configuracionDatosProcesadosDTO;


	/* Metodo que retorna id del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return DefinicionConfiguracionID id 
	 */
	public DefinicionConfiguracionID getId() {
		return id;
	}


	/* Metodo que asigna el id del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param id parametro de tipo DefinicionConfiguracionID
	 */
	public void setId(DefinicionConfiguracionID id) {
		this.id = id;
	}


	/* Metodo que retorna lote del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Integer lote 
	 */
	public Integer getLote() {
		return lote;
	}


	/* Metodo que asigna el lote del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param lote parametro de tipo Integer
	 */
	public void setLote(Integer lote) {
		this.lote = lote;
	}


	/* Metodo que retorna registroFinal del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Integer registroFinal 
	 */
	public Integer getRegistroFinal() {
		return registroFinal;
	}


	/* Metodo que asigna el registroFinal del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param registroFinal parametro de tipo Integer
	 */
	public void setRegistroFinal(Integer registroFinal) {
		this.registroFinal = registroFinal;
	}


	/* Metodo que retorna registroInicial del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Integer registroInicial 
	 */
	public Integer getRegistroInicial() {
		return registroInicial;
	}


	/* Metodo que asigna el registroInicial del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param registroInicial parametro de tipo Integer
	 */
	public void setRegistroInicial(Integer registroInicial) {
		this.registroInicial = registroInicial;
	}


	/* Metodo que retorna codigoConfiguracion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Long codigoConfiguracion 
	 */
	public Long getCodigoConfiguracion() {
		return codigoConfiguracion;
	}


	/* Metodo que asigna el codigoConfiguracion del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param codigoConfiguracion parametro de tipo Long
	 */
	public void setCodigoConfiguracion(Long codigoConfiguracion) {
		this.codigoConfiguracion = codigoConfiguracion;
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


	/* Metodo que retorna configuracionDatosProcesadosDTO del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return ConfiguracionDatosProcesadosDTO configuracionDatosProcesadosDTO 
	 */
	public ConfiguracionDatosProcesadosDTO getConfiguracionDatosProcesadosDTO() {
		return configuracionDatosProcesadosDTO;
	}


	/* Metodo que asigna el configuracionDatosProcesadosDTO del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param configuracionDatosProcesadosDTO parametro de tipo ConfiguracionDatosProcesadosDTO
	 */
	public void setConfiguracionDatosProcesadosDTO(ConfiguracionDatosProcesadosDTO configuracionDatosProcesadosDTO) {
		this.configuracionDatosProcesadosDTO = configuracionDatosProcesadosDTO;
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

}
