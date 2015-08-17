package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.ConfiguracionDatosProcesadosAcumuladosID;


/**
 * @author srodriguez
 * 2014-11-21
*/
@Entity
@Table(name = "SCCEMTCONDATPROACU")
public class ConfiguracionDatosProcesadosAcumuladosDTO {
	
	/**
	 * Clave primaria de la tabla ConfiguracionDatosProcesadosDTO
	 * 
	 */
	@EmbeddedId
	private ConfiguracionDatosProcesadosAcumuladosID id = new ConfiguracionDatosProcesadosAcumuladosID();
	
	/**
	 * Llave foranea de codigo de configuracion
	 */
	@Column(name = "CODIGOCONFIGURACION")
	private Long codigoConfiguracion;
	
	/**
	 * Llave foranea de registro de datos acumulados
	 */
	@Column(name = "CODIGODATOSACUMULADOS")
	private Long codigoDatosAcumulados;
	
	/**
	 * Cantidad monetaria del procesamiento
	 */	
	@Column(name = "CANTIDAD")
	private BigDecimal cantidad;
	
	/**
	 * Valor acumulado de las ventas
	 */
	@Column(name = "VALOR")
	private BigDecimal valor;
	
	/**
	 * Valor del precio del articulo
	 */
	@Column(name = "PRECIO")
	private BigDecimal precio;
	
	/**
	 * Estado del registro
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
	
	/**
	 * Mapeo externo de configuracion de datos procesados
	 * 
	 */
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
	@JoinColumn(name = "CODIGOCONFIGURACION", insertable = false, updatable = false, referencedColumnName = "CODIGOCONFIGURACION") })
	private ConfiguracionDatosProcesadosDTO configuracionDatosProcesadosDTO;
	
	/**
	 * mapeo externo de datos acumulados
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
	@JoinColumn(name = "CODIGODATOSACUMULADOS", insertable = false, updatable = false, referencedColumnName = "CODIGODATOSACUMULADOS") })
	private DatosAcumuladosDTO datosAcumuladosDTO;

	/* Metodo que retorna id del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return ConfiguracionDatosProcesadosAcumuladosID id 
	 */
	public ConfiguracionDatosProcesadosAcumuladosID getId() {
		return id;
	}

	/* Metodo que asigna el id del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param id parametro de tipo ConfiguracionDatosProcesadosAcumuladosID
	 */
	public void setId(ConfiguracionDatosProcesadosAcumuladosID id) {
		this.id = id;
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

	/* Metodo que retorna codigoDatosAcumulados del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Long codigoDatosAcumulados 
	 */
	public Long getCodigoDatosAcumulados() {
		return codigoDatosAcumulados;
	}

	/* Metodo que asigna el codigoDatosAcumulados del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param codigoDatosAcumulados parametro de tipo Long
	 */
	public void setCodigoDatosAcumulados(Long codigoDatosAcumulados) {
		this.codigoDatosAcumulados = codigoDatosAcumulados;
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

	/* Metodo que retorna datosAcumuladosDTO del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return DatosAcumuladosDTO datosAcumuladosDTO 
	 */
	public DatosAcumuladosDTO getDatosAcumuladosDTO() {
		return datosAcumuladosDTO;
	}

	/* Metodo que asigna el datosAcumuladosDTO del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param datosAcumuladosDTO parametro de tipo DatosAcumuladosDTO
	 */
	public void setDatosAcumuladosDTO(DatosAcumuladosDTO datosAcumuladosDTO) {
		this.datosAcumuladosDTO = datosAcumuladosDTO;
	}

	/* Metodo que retorna estado del objeto
	 * @author srodriguez
	 * 26/11/2014
	 * @return String estado 
	 */
	public String getEstado() {
		return estado;
	}

	/* Metodo que asigna el estado del objeto
	 * @author srodriguez
	 * 26/11/2014
	 * @param estado parametro de tipo String
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the cantidad
	 */
	public BigDecimal getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/**
	 * @return the precio
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
}
