/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.ProcesoDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.LogProcesosMigracionID;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCADMTLOGPROMIG")
public class LogProcesosMigracionDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private LogProcesosMigracionID id = new LogProcesosMigracionID();
	
	@Column(name = "CODIGOPROCESO")
	private Long codigoProceso;
	
	@Column(name = "NUMERODOCUMENTO")
	private String numeroDocumento;
	
	@Column(name = "CODIGOSUBBODEGA")
	private String codigoSubbodega;
	
	@Column(name = "CODIGOPROVEEDOR")
	private String codigoProveedor;
	
	@Column(name = "CODIGORESULTADOPROCESO")
	private String codigoResultadoProceso;
	
	@Column(name = "LOGERROR")
	private String logError;
	
	@Column(name = "DESCRIPCIONADICIONAL")
	private String descripcionAdicional;
	
	@Column(name = "FECHADOCUMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaDocumento;
	
	@Column(name = "FECHAPROCESAMIENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaProcesamiento;
	
	@Column(name = "ESTADO", nullable = false)
    @ComparatorTypeField
    private String estado;
	
	@RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO", nullable = false)
    private String idUsuarioRegistro;
    
    //@RegisterDateField
    @Column(name = "FECHAREGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
  
    @LastModifierUserIdField	
    @Column(name = "IDUSUARIOMODIFICACION")
    private String idUsuarioModificacion;
    
    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @Transient
    private String mensaje;
    
    @Transient
    private String directorioError;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false)
    })
    private ProcesoDTO procesoDTO;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOSUBBODEGA", referencedColumnName = "CODIGOBODEGA", insertable = false, updatable = false)
    })
    private BodegaDTO subbodega;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
    })
    private VistaProveedorDTO proveedor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGORESULTADOPROCESO", referencedColumnName = "CODIGORESULTADOPROCESO", insertable = false, updatable = false)
    })
    private ResultadoProcesoDTO resultadoProcesoDTO;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto usuarioRegistroDTO;
    
	
    public LogProcesosMigracionDTO(){
    	
    }
    
	public LogProcesosMigracionDTO(Integer codigoCompania, Long codigoProceso, String numeroDocumento, String codigoSubbodega, String codigoProveedor, String codigoResultadoProceso, String logError, String descripcionAdicional, Date fechaDocumento, Date fechaProcesamiento,String userId) {
		super();
		this.id = new LogProcesosMigracionID(codigoCompania);
		this.codigoProceso = codigoProceso;
		this.numeroDocumento = numeroDocumento;
		this.codigoSubbodega = codigoSubbodega;
		this.codigoProveedor = codigoProveedor;
		this.codigoResultadoProceso = codigoResultadoProceso;
		this.logError = logError;
		this.descripcionAdicional = descripcionAdicional;
		this.fechaDocumento = fechaDocumento;
		this.fechaProcesamiento = fechaProcesamiento;
		this.setUserId(userId);
		this.idUsuarioRegistro = userId;
	}
	
	/* GETTERS AND SETTERS*/

	/**
	 * @return the id
	 */
	public LogProcesosMigracionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(LogProcesosMigracionID id) {
		this.id = id;
	}

	/**
	 * @return the codigoProceso
	 */
	public Long getCodigoProceso() {
		return codigoProceso;
	}

	/**
	 * @param codigoProceso the codigoProceso to set
	 */
	public void setCodigoProceso(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}

	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * @return the codigoSubbodega
	 */
	public String getCodigoSubbodega() {
		return codigoSubbodega;
	}

	/**
	 * @param codigoSubbodega the codigoSubbodega to set
	 */
	public void setCodigoSubbodega(String codigoSubbodega) {
		this.codigoSubbodega = codigoSubbodega;
	}

	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return the codigoResultadoProceso
	 */
	public String getCodigoResultadoProceso() {
		return codigoResultadoProceso;
	}

	/**
	 * @param codigoResultadoProceso the codigoResultadoProceso to set
	 */
	public void setCodigoResultadoProceso(String codigoResultadoProceso) {
		this.codigoResultadoProceso = codigoResultadoProceso;
	}

	/**
	 * @return the logError
	 */
	public String getLogError() {
		return logError;
	}

	/**
	 * @param logError the logError to set
	 */
	public void setLogError(String logError) {
		this.logError = logError;
	}

	/**
	 * @return the descripcionAdicional
	 */
	public String getDescripcionAdicional() {
		return descripcionAdicional;
	}

	/**
	 * @param descripcionAdicional the descripcionAdicional to set
	 */
	public void setDescripcionAdicional(String descripcionAdicional) {
		this.descripcionAdicional = descripcionAdicional;
	}

	/**
	 * @return the fechaDocumento
	 */
	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	/**
	 * @param fechaDocumento the fechaDocumento to set
	 */
	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	/**
	 * @return the fechaProcesamiento
	 */
	public Date getFechaProcesamiento() {
		return fechaProcesamiento;
	}

	/**
	 * @param fechaProcesamiento the fechaProcesamiento to set
	 */
	public void setFechaProcesamiento(Date fechaProcesamiento) {
		this.fechaProcesamiento = fechaProcesamiento;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
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
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
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
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the directorioError
	 */
	public String getDirectorioError() {
		return directorioError;
	}

	/**
	 * @param directorioError the directorioError to set
	 */
	public void setDirectorioError(String directorioError) {
		this.directorioError = directorioError;
	}

	/**
	 * @return the procesoDTO
	 */
	public ProcesoDTO getProcesoDTO() {
		return procesoDTO;
	}

	/**
	 * @param procesoDTO the procesoDTO to set
	 */
	public void setProcesoDTO(ProcesoDTO procesoDTO) {
		this.procesoDTO = procesoDTO;
	}

	/**
	 * @return the subbodega
	 */
	public BodegaDTO getSubbodega() {
		return subbodega;
	}

	/**
	 * @param subbodega the subbodega to set
	 */
	public void setSubbodega(BodegaDTO subbodega) {
		this.subbodega = subbodega;
	}

	/**
	 * @return the proveedor
	 */
	public VistaProveedorDTO getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(VistaProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the resultadoProcesoDTO
	 */
	public ResultadoProcesoDTO getResultadoProcesoDTO() {
		return resultadoProcesoDTO;
	}

	/**
	 * @param resultadoProcesoDTO the resultadoProcesoDTO to set
	 */
	public void setResultadoProcesoDTO(ResultadoProcesoDTO resultadoProcesoDTO) {
		this.resultadoProcesoDTO = resultadoProcesoDTO;
	}

	/**
	 * @return the usuarioRegistroDTO
	 */
	public UserDto getUsuarioRegistroDTO() {
		return usuarioRegistroDTO;
	}

	/**
	 * @param usuarioRegistroDTO the usuarioRegistroDTO to set
	 */
	public void setUsuarioRegistroDTO(UserDto usuarioRegistroDTO) {
		this.usuarioRegistroDTO = usuarioRegistroDTO;
	}
}
