package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.RelacionArticuloRegistroSanitarioID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IntegrableMQ;

@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTRELARTREGSAN")
public class RelacionArticuloRegistroSanitarioDTO extends SimpleAuditDTO implements IntegrableMQ{
	
	@EmbeddedId
	private RelacionArticuloRegistroSanitarioID id = new RelacionArticuloRegistroSanitarioID();
	
	/**
	 * los valores permitidos son: [0] INACTIVO, [1] ACTIVO
	 */
	@ComparatorTypeField
	private String estado;
	
	/**
	 * porciones de envase
	 */
	private Double porcionesEnvase;
	
	/**
	 * porcion por envase es aproximado
	 */
	private Boolean esPorcionAproximado;
	
	/**
	 * Valor de las porciones por envase establecido en un rango
	 */
	@Column(name = "RANGOPORCIONESENVASE")
	private String rangoPorcionesEnvase;
	
	/**
	 * indica si el valor de las porciones por envase es Rango o no
	 */
	@Column(name = "ESRANGOPORCIONESENVASE")
	private Boolean esRangoPorcionesEnvase;
	
	/**
	 * indica si el rango establecido es aproximado o no
	 */
	@Column(name = "ESRANGOAPROXIMADO")
	private Boolean esRangoAproximado;
	
	/**
	 * Usuario que cre� el registro
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la cual se cre� el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Usuario que realiza la �ltima actualizaci�n del registro
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la cual se realiz� la ultima actualizaci�n del registro
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloDTO articulo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOREGISTROSANITARIO", referencedColumnName="CODIGOREGSANART", insertable=false, updatable=false)})
	private ArticuloRegistroSanitarioDTO registroSanitario;
	
	/**
	 * Referencia al usuario registro
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDUSUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioRegistro;
	
	//@Transient
	//private Collection<RelacionArticuloRegistroSanitarioDTO> registrosHijosCol;
	
	@Transient
	private Boolean transferirDatosSIC = Boolean.TRUE;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public RelacionArticuloRegistroSanitarioID getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(RelacionArticuloRegistroSanitarioID id) {
		this.id = id;
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
	 * @return the porcionesEnvase
	 */
	public Double getPorcionesEnvase() {
		return porcionesEnvase;
	}

	/**
	 * @param porcionesEnvase the porcionesEnvase to set
	 */
	public void setPorcionesEnvase(Double porcionesEnvase) {
		this.porcionesEnvase = porcionesEnvase;
	}
	
	public Boolean getEsPorcionAproximado() {
		return esPorcionAproximado;
	}

	public void setEsPorcionAproximado(Boolean esPorcionAproximado) {
		this.esPorcionAproximado = esPorcionAproximado;
	}
	
	public String getRangoPorcionesEnvase() {
		return rangoPorcionesEnvase;
	}
	
	public void setRangoPorcionesEnvase(String rangoPorcionesEnvase) {
		this.rangoPorcionesEnvase = rangoPorcionesEnvase;
	}
	
	public Boolean getEsRangoPorcionesEnvase() {
		return esRangoPorcionesEnvase;
	}
	
	public void setEsRangoPorcionesEnvase(Boolean esRangoPorcionesEnvase) {
		this.esRangoPorcionesEnvase = esRangoPorcionesEnvase;
	}
	
	public Boolean getEsRangoAproximado() {
		return esRangoAproximado;
	}
	
	public void setEsRangoAproximado(Boolean esRangoAproximado) {
		this.esRangoAproximado = esRangoAproximado;
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
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion() {
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

	}

	public ArticuloDTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	public ArticuloRegistroSanitarioDTO getRegistroSanitario() {
		return registroSanitario;
	}

	public void setRegistroSanitario(ArticuloRegistroSanitarioDTO registroSanitario) {
		this.registroSanitario = registroSanitario;
	}
	
	public Boolean getTieneArticulo(){
		return isLoaded(articulo);
	}
	public Boolean getTieneRegistroSanitario(){
		return isLoaded(registroSanitario);
	}

	@Override
	public Boolean getTransferirDatosSIC() {
		return transferirDatosSIC;
	}

	@Override
	public void setTransferirDatosSIC(Boolean transferirDatosSIC) {
		this.transferirDatosSIC = transferirDatosSIC;
	}

	/**
	 * @return the registrosHijosCol
	 */
	/*public Collection<RelacionArticuloRegistroSanitarioDTO> getRegistrosHijosCol() {
		return registrosHijosCol;
	}

	/**
	 * @param registrosHijosCol the registrosHijosCol to set
	 */
	//public void setRegistrosHijosCol(Collection<RelacionArticuloRegistroSanitarioDTO> registrosHijosCol) {
	//	this.registrosHijosCol = registrosHijosCol;
	//}

	/**
	 * @return the usuarioRegistro
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioRegistro() {
		return usuarioRegistro;
	}

	/**
	 * @param usuarioRegistro the usuarioRegistro to set
	 */
	public void setUsuarioRegistro(ec.com.smx.frameworkv2.security.dto.UserDto usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

}
