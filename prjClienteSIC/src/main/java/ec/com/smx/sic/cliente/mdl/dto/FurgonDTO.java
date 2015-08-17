
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.FurgonID;

/**
 * Entidad FurgonDTO para la tabla SBLOGTFURGON
 * @author hgudino
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTFURGON")
public class FurgonDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla CategoriaDTO
	 *
	 */
	@EmbeddedId
	private FurgonID id = new FurgonID();
	
	/**
	 * Valor del tipo de furgon 
	 *
	 */
	@Column(name="CODIGOTIPOFURGON")
	private java.lang.Long codigoTipoFurgon ;
	

	/**
	 * Valor del tipo de furgon 
	 *
	 */
	@Column(name="CODIGODETALLESECCION")
	private java.lang.Long codigoDetalleSeccion ;
	
	/**
	 * Secuencia del prefijo del furgon 
	 *
	 */
	@Column(name="SECUENCIALPREFUR")
	private java.lang.Long secuencialPrefur ;
	
	/**
	 * Valor del tipo de frio para furgon
	 *
	 */
	@Column(name="CODIGOINTERNO")
	private String codigoInterno ;
	
	/**
	 * Valor del tipo de frio para furgon
	 *
	 */
	@Column(name="CODIGOEXTERNO")
	private String codigoExterno ;
		
	/**
	 * Valor del tipo de frio para furgon
	 *
	 */
	@Column(name="CODIGOTIPOFRIOVALOR")
	private String codigoTipoFrioValor ;

	/**
	 * C�digo del tipo de frio para furgon
	 *
	 */
	@Column(name="CODIGOTIPOFRIOTIPO")
	private Integer codigoTipoFrioTipo;
	
	
	/**
	 * Especifica el largo en metros del furgon
	 *
	 */
	@Column(name="LARGO")
	private java.lang.Double largo;
	
	/**
	 * Especifica el ancho en metro del furgon
	 *
	 */
	@Column(name="ANCHO")
	private java.lang.Double ancho;
	
	/**
	 * Especifica el alto en metros del furgon
	 *
	 */
	@Column(name="ALTO")
	private java.lang.Double alto;
	
	/**
	 * Especifica la cantidad maxima de bultos que soporta en un furgon
	 *
	 */
	@Column(name="BULTOSMAXIMO")
	private Integer bultosMaximo;
	
	/**
	 * Especifica la cantidad maxima de pallets que soporta en un furgon
	 *
	 */
	@Column(name="MAXIMOPALLETS")
	private Integer maximoPallets;
	
	/**
	 * Especifica el cubicaje de pallets que soporta en un furgon
	 *
	 */
	@Column(name="CUBICAJEPALLETS")
	private java.lang.Double cubicajePallets;
	
	/**
	 * Especifica la cantidad de sellos que permite un furgon
	 *
	 */
	@Column(name="CANTIDADSELLOS")
	private Integer cantidadSellos;
	
	
	/**
	 * Valor del tipo de uso que se la dar� a un furgon
	 *
	 */
	@Column(name="CODIGOUSOVALOR")
	private String codigoUsoValor ;

	/**
	 * C�digo del tipo de uso que se la dar� a un furgon
	 *
	 */
	@Column(name="CODIGOUSOTIPO")
	private Integer codigoUsoTipo;
	
	/**
	 * Valor del estatus de un furgon
	 *
	 */
	@Column(name="CODIGOESTATUSVALOR")
	private String codigoEstatusValor ;

	/**
	 * Tipo del estatus de un furgon
	 *
	 */
	@Column(name="CODIGOESTATUSTIPO")
	private Integer codigoEstatusTipo;
	
		
	/**
	 * Indica el estado del registro:[ACT] activo [INA] inactivo
	 *
	 */
	@Column(name="ESTADO")
	private String estado ;
	
	/**
	 * Observaci�n para el furgon
	 */
	@Column(name="OBSERVACION")
	private String observacion;
	
	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;
	
	/**
	 * Fecha en la que se realiza la actualizacion del registro
	 * 
	 */
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaActualizacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro;

	
	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioActualizacion;
	
	/**
	 * Relacion con la tabla tipo furgon para el tipo de firgon
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOTIPOFURGON", insertable=false, updatable=false, referencedColumnName="CODIGOTIPOFURGON")})
	private TipoFurgonDTO tipoFurgonDTO;
	
	/**
	 * Relacion con la tabla detalle seccion para el furgon
	 */
//	@ManyToOne(fetch = LAZY)
//	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
//	@JoinColumn(name="CODIGODETALLESECCION", insertable=false, updatable=false, referencedColumnName="CODIGODETALLESECCION")})
	@Transient
	private DetalleSeccionDTO detalleSeccionDTO;
	
	/**
	 * Relacion con la tabla frefijo furgon para el furgon
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="SECUENCIALPREFUR", insertable=false, updatable=false, referencedColumnName="SECUENCIALPREFUR")})
	private PrefijoFurgonDTO prefijoFurgonDTO;
	
	/**
	 * Relacion con la tabla catalogo valor para el tipo de frio
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOTIPOFRIOVALOR", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOTIPOFRIOTIPO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoFrioCatalogoValorDTO;
			
	/**
	 * Relacion con la tabla catalogo valor para el uso del furgon
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOUSOVALOR", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOUSOTIPO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO usoFurgonCatalogoValorDTO;
	
	/**
	 * Relacion con la tabla catalogo valor para el uso del furgon
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOESTATUSVALOR", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
	@JoinColumn(name="CODIGOESTATUSTIPO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO statusFurgonCatalogoValorDTO;
	
	
	public FurgonDTO() {
		
	}

	/**
	 * @return the id
	 */
	public FurgonID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(FurgonID id) {
		this.id = id;
	}


	public String getCodigoTipoFrioValor() {
		return codigoTipoFrioValor;
	}

	public void setCodigoTipoFrioValor(String codigoTipoFrioValor) {
		this.codigoTipoFrioValor = codigoTipoFrioValor;
	}

	public Integer getCodigoTipoFrioTipo() {
		return codigoTipoFrioTipo;
	}

	public void setCodigoTipoFrioTipo(Integer codigoTipoFrioTipo) {
		this.codigoTipoFrioTipo = codigoTipoFrioTipo;
	}

	public java.lang.Double getLargo() {
		return largo;
	}

	public void setLargo(java.lang.Double largo) {
		this.largo = largo;
	}

	public java.lang.Double getAncho() {
		return ancho;
	}

	public void setAncho(java.lang.Double ancho) {
		this.ancho = ancho;
	}

	public java.lang.Double getAlto() {
		return alto;
	}

	public void setAlto(java.lang.Double alto) {
		this.alto = alto;
	}

	public Integer getBultosMaximo() {
		return bultosMaximo;
	}

	public void setBultosMaximo(Integer bultosMaximo) {
		this.bultosMaximo = bultosMaximo;
	}

	public Integer getMaximoPallets() {
		return maximoPallets;
	}

	public void setMaximoPallets(Integer maximoPallets) {
		this.maximoPallets = maximoPallets;
	}

	public java.lang.Double getCubicajePallets() {
		return cubicajePallets;
	}

	public void setCubicajePallets(java.lang.Double cubicajePallets) {
		this.cubicajePallets = cubicajePallets;
	}

	public Integer getCantidadSellos() {
		return cantidadSellos;
	}

	public void setCantidadSellos(Integer cantidadSellos) {
		this.cantidadSellos = cantidadSellos;
	}

	public String getCodigoUsoValor() {
		return codigoUsoValor;
	}

	public void setCodigoUsoValor(String codigoUsoValor) {
		this.codigoUsoValor = codigoUsoValor;
	}

	public Integer getCodigoUsoTipo() {
		return codigoUsoTipo;
	}

	public void setCodigoUsoTipo(Integer codigoUsoTipo) {
		this.codigoUsoTipo = codigoUsoTipo;
	}

	public String getCodigoEstatusValor() {
		return codigoEstatusValor;
	}

	public void setCodigoEstatusValor(String codigoEstatusValor) {
		this.codigoEstatusValor = codigoEstatusValor;
	}

	public Integer getCodigoEstatusTipo() {
		return codigoEstatusTipo;
	}

	public void setCodigoEstatusTipo(Integer codigoEstatusTipo) {
		this.codigoEstatusTipo = codigoEstatusTipo;
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
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaActualizacion
	 */
	public java.util.Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(java.util.Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
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
	 * @return the idUsuarioActualizacion
	 */
	public String getIdUsuarioActualizacion() {
		return idUsuarioActualizacion;
	}

	/**
	 * @param idUsuarioActualizacion the idUsuarioActualizacion to set
	 */
	public void setIdUsuarioActualizacion(String idUsuarioActualizacion) {
		this.idUsuarioActualizacion = idUsuarioActualizacion;
	}

	
	public CatalogoValorDTO getTipoFrioCatalogoValorDTO() {
		return tipoFrioCatalogoValorDTO;
	}

	public void setTipoFrioCatalogoValorDTO(CatalogoValorDTO tipoFrioCatalogoValorDTO) {
		this.tipoFrioCatalogoValorDTO = tipoFrioCatalogoValorDTO;
	}


	public CatalogoValorDTO getUsoFurgonCatalogoValorDTO() {
		return usoFurgonCatalogoValorDTO;
	}

	public void setUsoFurgonCatalogoValorDTO(CatalogoValorDTO usoFurgonCatalogoValorDTO) {
		this.usoFurgonCatalogoValorDTO = usoFurgonCatalogoValorDTO;
	}

	public CatalogoValorDTO getStatusFurgonCatalogoValorDTO() {
		return statusFurgonCatalogoValorDTO;
	}

	public void setStatusFurgonCatalogoValorDTO(CatalogoValorDTO statusFurgonCatalogoValorDTO) {
		this.statusFurgonCatalogoValorDTO = statusFurgonCatalogoValorDTO;
	}

	/**
	 * @return the codigoTipoFurgon
	 */
	public java.lang.Long getCodigoTipoFurgon() {
		return codigoTipoFurgon;
	}

	/**
	 * @param codigoTipoFurgon the codigoTipoFurgon to set
	 */
	public void setCodigoTipoFurgon(java.lang.Long codigoTipoFurgon) {
		this.codigoTipoFurgon = codigoTipoFurgon;
	}

	/**
	 * @return the codigoDetalleSeccion
	 */
	public java.lang.Long getCodigoDetalleSeccion() {
		return codigoDetalleSeccion;
	}

	/**
	 * @param codigoDetalleSeccion the codigoDetalleSeccion to set
	 */
	public void setCodigoDetalleSeccion(java.lang.Long codigoDetalleSeccion) {
		this.codigoDetalleSeccion = codigoDetalleSeccion;
	}

	/**
	 * @return the tipoFurgonDTO
	 */
	public TipoFurgonDTO getTipoFurgonDTO() {
		return tipoFurgonDTO;
	}

	/**
	 * @param tipoFurgonDTO the tipoFurgonDTO to set
	 */
	public void setTipoFurgonDTO(TipoFurgonDTO tipoFurgonDTO) {
		this.tipoFurgonDTO = tipoFurgonDTO;
	}

	/**
	 * @return the detalleSeccionDTO
	 */
	public DetalleSeccionDTO getDetalleSeccionDTO() {
		return detalleSeccionDTO;
	}

	/**
	 * @param detalleSeccionDTO the detalleSeccionDTO to set
	 */
	public void setDetalleSeccionDTO(DetalleSeccionDTO detalleSeccionDTO) {
		this.detalleSeccionDTO = detalleSeccionDTO;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the secuencialPrefur
	 */
	public java.lang.Long getSecuencialPrefur() {
		return secuencialPrefur;
	}

	/**
	 * @param secuencialPrefur the secuencialPrefur to set
	 */
	public void setSecuencialPrefur(java.lang.Long secuencialPrefur) {
		this.secuencialPrefur = secuencialPrefur;
	}

	/**
	 * @return the codigoInterno
	 */
	public String getCodigoInterno() {
		return codigoInterno;
	}

	/**
	 * @param codigoInterno the codigoInterno to set
	 */
	public void setCodigoInterno(String codigoInterno) {
		this.codigoInterno = codigoInterno;
	}

	/**
	 * @return the codigoExterno
	 */
	public String getCodigoExterno() {
		return codigoExterno;
	}

	/**
	 * @param codigoExterno the codigoExterno to set
	 */
	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}

	/**
	 * @return the prefijoFurgonDTO
	 */
	public PrefijoFurgonDTO getPrefijoFurgonDTO() {
		return prefijoFurgonDTO;
	}

	/**
	 * @param prefijoFurgonDTO the prefijoFurgonDTO to set
	 */
	public void setPrefijoFurgonDTO(PrefijoFurgonDTO prefijoFurgonDTO) {
		this.prefijoFurgonDTO = prefijoFurgonDTO;
	}
		
	
}