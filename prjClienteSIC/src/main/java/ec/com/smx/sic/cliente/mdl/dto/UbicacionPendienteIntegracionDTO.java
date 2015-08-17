package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.UbicacionPendienteIntegracionID;

/**
 * 
 * @author cortiz
 *
 */
@Entity
@Table(name="SBLOGTUBIPENINT")
@SuppressWarnings("serial")
public class UbicacionPendienteIntegracionDTO extends SearchDTO {
	
	@EmbeddedId
	UbicacionPendienteIntegracionID id = new UbicacionPendienteIntegracionID();
	
	
	private Integer codigoCdt;
	
	private Integer codigoBodega;
	
	private Integer codigoSubbodega;
	
	@ComparatorTypeField
	private String pasillo;
	
	@ComparatorTypeField
	private String rack;
	
	@ComparatorTypeField
	private String nivel;
	
	@ComparatorTypeField
	private String codigoEan;
	
	private Integer valorUniMan;
	
	private Integer cantidad;
	
	private String fechaCaducidad;
	
	private String fechaUltimaRecepcion;
	
	private String fechaUltimoDespacho;
	
	private String tipoUbicacion;
	
	private String tipoAlmacenamiento;
	
	private String signo;
	
	@ComparatorTypeField
	private String estado;
	
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;
	
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * @return the id
	 */
	public UbicacionPendienteIntegracionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UbicacionPendienteIntegracionID id) {
		this.id = id;
	}

	/**
	 * @return the codigoCdt
	 */
	public Integer getCodigoCdt() {
		return codigoCdt;
	}

	/**
	 * @param codigoCdt the codigoCdt to set
	 */
	public void setCodigoCdt(Integer codigoCdt) {
		this.codigoCdt = codigoCdt;
	}

	/**
	 * @return the codigoBodega
	 */
	public Integer getCodigoBodega() {
		return codigoBodega;
	}

	/**
	 * @param codigoBodega the codigoBodega to set
	 */
	public void setCodigoBodega(Integer codigoBodega) {
		this.codigoBodega = codigoBodega;
	}

	/**
	 * @return the codigoSubbodega
	 */
	public Integer getCodigoSubbodega() {
		return codigoSubbodega;
	}

	/**
	 * @param codigoSubbodega the codigoSubbodega to set
	 */
	public void setCodigoSubbodega(Integer codigoSubbodega) {
		this.codigoSubbodega = codigoSubbodega;
	}

	/**
	 * @return the pasillo
	 */
	public String getPasillo() {
		return pasillo;
	}

	/**
	 * @param pasillo the pasillo to set
	 */
	public void setPasillo(String pasillo) {
		this.pasillo = pasillo;
	}

	/**
	 * @return the rack
	 */
	public String getRack() {
		return rack;
	}

	/**
	 * @param rack the rack to set
	 */
	public void setRack(String rack) {
		this.rack = rack;
	}

	/**
	 * @return the nivel
	 */
	public String getNivel() {
		return nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the codigoEan
	 */
	public String getCodigoEan() {
		return codigoEan;
	}

	/**
	 * @param codigoEan the codigoEan to set
	 */
	public void setCodigoEan(String codigoEan) {
		this.codigoEan = codigoEan;
	}

	/**
	 * @return the valorUniMan
	 */
	public Integer getValorUniMan() {
		return valorUniMan;
	}

	/**
	 * @param valorUniMan the valorUniMan to set
	 */
	public void setValorUniMan(Integer valorUniMan) {
		this.valorUniMan = valorUniMan;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the fechaCaducidad
	 */
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	/**
	 * @param fechaCaducidad the fechaCaducidad to set
	 */
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	/**
	 * @return the fechaUltimaRecepcion
	 */
	public String getFechaUltimaRecepcion() {
		return fechaUltimaRecepcion;
	}

	/**
	 * @param fechaUltimaRecepcion the fechaUltimaRecepcion to set
	 */
	public void setFechaUltimaRecepcion(String fechaUltimaRecepcion) {
		this.fechaUltimaRecepcion = fechaUltimaRecepcion;
	}

	/**
	 * @return the fechaUltimoDespacho
	 */
	public String getFechaUltimoDespacho() {
		return fechaUltimoDespacho;
	}

	/**
	 * @param fechaUltimoDespacho the fechaUltimoDespacho to set
	 */
	public void setFechaUltimoDespacho(String fechaUltimoDespacho) {
		this.fechaUltimoDespacho = fechaUltimoDespacho;
	}

	/**
	 * @return the tipoUbicacion
	 */
	public String getTipoUbicacion() {
		return tipoUbicacion;
	}

	/**
	 * @param tipoUbicacion the tipoUbicacion to set
	 */
	public void setTipoUbicacion(String tipoUbicacion) {
		this.tipoUbicacion = tipoUbicacion;
	}

	/**
	 * @return the tipoAlmacenamiento
	 */
	public String getTipoAlmacenamiento() {
		return tipoAlmacenamiento;
	}

	/**
	 * @param tipoAlmacenamiento the tipoAlmacenamiento to set
	 */
	public void setTipoAlmacenamiento(String tipoAlmacenamiento) {
		this.tipoAlmacenamiento = tipoAlmacenamiento;
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
	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the signo
	 */
	public String getSigno() {
		return signo;
	}

	/**
	 * @param signo the signo to set
	 */
	public void setSigno(String signo) {
		this.signo = signo;
	}
	
}
