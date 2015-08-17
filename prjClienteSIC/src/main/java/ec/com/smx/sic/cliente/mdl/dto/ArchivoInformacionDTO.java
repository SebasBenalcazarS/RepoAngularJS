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

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArchivoInformacionID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCORCTARCINF")
public class ArchivoInformacionDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ArchivoInformacionID id = new ArchivoInformacionID();
	
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;
	
	@Column(name = "FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Column(name = "TAMANIO", nullable = false)
	private Long tamanio;
	
	@Column(name = "UNIDAD", nullable = false)
	@ComparatorTypeField
	private String unidad;
	
	@Column(name = "EXTENSION", nullable = false)
	private String extension;
	
	@Column(name = "CODIGOTIPOCATVAL", nullable = false)
	@ComparatorTypeField
	private String codigoTipoCatVal;
	
	@Column(name = "CODIGOTIPOCATTIP", nullable = false)
	private Integer codigoTipoCatTip;
	
	@Column(name = "ESTADO", nullable = false)
	@ComparatorTypeField
    private String estado;
    
    @RegisterUserIdField
    @Column(name = "IDUSUARIOREGISTRO", nullable = false)
    private String idUsuarioRegistro;
    
    @RegisterDateField
    @Column(name = "FECHAREGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
  
    @LastModifierUserIdField	
    @Column(name = "IDUSUARIOMODIFICACION")
    private String idUsarioModificacion;
    
    @LastModificationDateField
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOARCHIVO", referencedColumnName = "CODIGOARCHIVO", insertable = false, updatable = false)
    })
    private ArchivoContenidoDTO archivoContenido;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOTIPOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOTIPOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
    })
    private CatalogoValorDTO tipo;
    

    
	/**
	 * @return the id
	 */
	public ArchivoInformacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArchivoInformacionID id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the tamanio
	 */
	public Long getTamanio() {
		return tamanio;
	}

	/**
	 * @param tamanio the tamanio to set
	 */
	public void setTamanio(Long tamanio) {
		this.tamanio = tamanio;
	}

	/**
	 * @return the unidad
	 */
	public String getUnidad() {
		return unidad;
	}

	/**
	 * @param unidad the unidad to set
	 */
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return the codigoTipoCatVal
	 */
	public String getCodigoTipoCatVal() {
		return codigoTipoCatVal;
	}

	/**
	 * @param codigoTipoCatVal the codigoTipoCatVal to set
	 */
	public void setCodigoTipoCatVal(String codigoTipoCatVal) {
		this.codigoTipoCatVal = codigoTipoCatVal;
	}

	/**
	 * @return the codigoTipoCatTip
	 */
	public Integer getCodigoTipoCatTip() {
		return codigoTipoCatTip;
	}

	/**
	 * @param codigoTipoCatTip the codigoTipoCatTip to set
	 */
	public void setCodigoTipoCatTip(Integer codigoTipoCatTip) {
		this.codigoTipoCatTip = codigoTipoCatTip;
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
	 * @return the idUsarioModificacion
	 */
	public String getIdUsarioModificacion() {
		return idUsarioModificacion;
	}

	/**
	 * @param idUsarioModificacion the idUsarioModificacion to set
	 */
	public void setIdUsarioModificacion(String idUsarioModificacion) {
		this.idUsarioModificacion = idUsarioModificacion;
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
	 * @return the tipo
	 */
	public CatalogoValorDTO getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(CatalogoValorDTO tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the archivoContenido
	 */
	public ArchivoContenidoDTO getArchivoContenido() {
		return archivoContenido;
	}

	/**
	 * @param archivoContenido the archivoContenido to set
	 */
	public void setArchivoContenido(ArchivoContenidoDTO archivoContenido) {
		this.archivoContenido = archivoContenido;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
    
}
