package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.BitacoraRevisionRegistroSanitarioID;

/**
 * Guarda el histórico de revisiones de los artículos que tienen registro sanitario.
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTBITREVREGSAN")
public class BitacoraRevisionRegistroSanitarioDTO extends SimpleAuditDTO {

	@EmbeddedId
	private BitacoraRevisionRegistroSanitarioID id = new BitacoraRevisionRegistroSanitarioID();

	/**
	 * Relación con el registro sanitario
	 * 
	 */
	private String codigoRegistroSanitario;

	/**
	 * Código del proveedor
	 * 
	 */
	private String codigoProveedor;

	/**
	 * Indica el estado de la revisión, sus valores pueden ser: [VAL] [INV]
	 * 
	 */
	@ComparatorTypeField
	private String estadoRevision;
	private Integer estadoRevisionTC;
	
	/**
	 * Indica la observación de la revisión.
	 * 
	 */
	private String observacion;

	/**
	 * Código de la compañia del esquema SMXMBASE
	 */
	private String codigoCompaniaMB;
	/**
	 * Almacena el archivo de autorización del proveedor para cambios por parte de un super usuario
	 */
	private Long secuencialArchivoImportacion;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro;
	
	private Timestamp fechaInicioRevision;
	private Timestamp fechaFinRevision;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOREGISTROSANITARIO", referencedColumnName="CODIGOREGSANART", insertable=false, updatable=false)})
	private ArticuloRegistroSanitarioDTO registroSanitario;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ProveedorDTO proveedor;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="IDUSUARIOREGISTRO", insertable=false, updatable=false, referencedColumnName="USERID")})
	private UserDto ususarioRegistro;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="ESTADOREVISION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="ESTADOREVISIONTC", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoEstado;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public BitacoraRevisionRegistroSanitarioID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(BitacoraRevisionRegistroSanitarioID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>codigoRegistroSanitario</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoRegistroSanitario</code>
	 */
	public String getCodigoRegistroSanitario() {
		return this.codigoRegistroSanitario;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoRegistroSanitario</code>.
	 * 
	 * @param codigoRegistroSanitario1
	 *            El valor a establecer para la propiedad <code>codigoRegistroSanitario</code>.
	 */
	public void setCodigoRegistroSanitario(String codigoRegistroSanitario1) {
		this.codigoRegistroSanitario = codigoRegistroSanitario1;

		if (codigoRegistroSanitario != null && codigoRegistroSanitario.length() > 20) {
			codigoRegistroSanitario = codigoRegistroSanitario.substring(0, 20);
		}

	}

	/**
	 * Retorna valor de propiedad <code>codigoProveedor</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoProveedor</code>
	 */
	public String getCodigoProveedor() {
		return this.codigoProveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoProveedor</code>.
	 * 
	 * @param codigoProveedor1
	 *            El valor a establecer para la propiedad <code>codigoProveedor</code>.
	 */
	public void setCodigoProveedor(String codigoProveedor1) {
		this.codigoProveedor = codigoProveedor1;

		if (codigoProveedor != null && codigoProveedor.length() > 10) {
			codigoProveedor = codigoProveedor.substring(0, 10);
		}

	}

	/**
	 * Retorna valor de propiedad <code>estadoRevision</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoRevision</code>
	 */
	public String getEstadoRevision() {
		return this.estadoRevision;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoRevision</code>.
	 * 
	 * @param estadoRevision1
	 *            El valor a establecer para la propiedad <code>estadoRevision</code>.
	 */
	public void setEstadoRevision(String estadoRevision1) {
		this.estadoRevision = estadoRevision1;

		if (estadoRevision != null && estadoRevision.length() > 3) {
			estadoRevision = estadoRevision.substring(0, 3);
		}

	}

	/**
	 * Retorna valor de propiedad <code>observacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>observacion</code>
	 */
	public String getObservacion() {
		return this.observacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>observacion</code>.
	 * 
	 * @param observacion1
	 *            El valor a establecer para la propiedad <code>observacion</code>.
	 */
	public void setObservacion(String observacion1) {
		this.observacion = observacion1;

		if (observacion != null && observacion.length() > 2000) {
			observacion = observacion.substring(0, 2000);
		}

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>registroSanitario</code>
	 * 
	 * @return Retorna valor de propiedad <code>registroSanitario</code>
	 */
	public ArticuloRegistroSanitarioDTO getRegistroSanitario() {
		return this.registroSanitario;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>registroSanitario</code>.
	 * 
	 * @param registroSanitario1
	 *            El valor a establecer para la propiedad <code>registroSanitario</code>.
	 */
	public void setRegistroSanitario(ArticuloRegistroSanitarioDTO registroSanitario1) {
		this.registroSanitario = registroSanitario1;
	}

	/**
	 * Retorna valor de propiedad <code>proveedor</code>
	 * 
	 * @return Retorna valor de propiedad <code>proveedor</code>
	 */
	public ProveedorDTO getProveedor() {
		return this.proveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>proveedor</code>.
	 * 
	 * @param proveedor1
	 *            El valor a establecer para la propiedad <code>proveedor</code>.
	 */
	public void setProveedor(ProveedorDTO proveedor1) {
		this.proveedor = proveedor1;
	}
	/**
	 * @return the secuencialArchivoImportacion
	 */
	public Long getSecuencialArchivoImportacion() {
		return secuencialArchivoImportacion;
	}

	/**
	 * @param secuencialArchivoImportacion the secuencialArchivoImportacion to set
	 */
	public void setSecuencialArchivoImportacion(Long secuencialArchivoImportacion) {
		this.secuencialArchivoImportacion = secuencialArchivoImportacion;
	}

	/**
	 * @return the codigoCompaniaMB
	 */
	public String getCodigoCompaniaMB() {
		return codigoCompaniaMB;
	}

	/**
	 * @param codigoCompaniaMB the codigoCompaniaMB to set
	 */
	public void setCodigoCompaniaMB(String codigoCompaniaMB) {
		this.codigoCompaniaMB = codigoCompaniaMB;
	}

	/**
	 * @return the ususarioRegistro
	 */
	public UserDto getUsusarioRegistro() {
		return ususarioRegistro;
	}

	/**
	 * @param ususarioRegistro the ususarioRegistro to set
	 */
	public void setUsusarioRegistro(UserDto ususarioRegistro) {
		this.ususarioRegistro = ususarioRegistro;
	}
	public Timestamp getFechaInicioRevision() {
		return fechaInicioRevision;
	}

	public void setFechaInicioRevision(Timestamp fechaInicioRevision) {
		this.fechaInicioRevision = fechaInicioRevision;
	}

	public Timestamp getFechaFinRevision() {
		return fechaFinRevision;
	}

	public void setFechaFinRevision(Timestamp fechaFinRevision) {
		this.fechaFinRevision = fechaFinRevision;
	}

	public CatalogoValorDTO getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(CatalogoValorDTO tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	public Integer getEstadoRevisionTC() {
		return estadoRevisionTC;
	}

	public void setEstadoRevisionTC(Integer estadoRevisionTC) {
		this.estadoRevisionTC = estadoRevisionTC;
	}
	
}
