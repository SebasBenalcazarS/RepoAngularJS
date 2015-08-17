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
import ec.com.smx.sic.cliente.mdl.dto.id.MarcaFuncionarioTipoMarcaID;

/**
 * Entidad que almacena marcas especificas para el tipo de marca por funcionario
 * @author fcollaguazo
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "SCADMTMARFUNTIPMAR")
public class MarcaFuncionarioTipoMarcaDTO extends SimpleAuditDTO{

	@EmbeddedId
	private MarcaFuncionarioTipoMarcaID id;
	
	public MarcaFuncionarioTipoMarcaDTO(){
		id = new MarcaFuncionarioTipoMarcaID();
	}
	
	@Column(name = "CODFUNTIPMAR")
	private Long codigoFuncionarioTipoMarca;
	
	private Long codigoMarca;
	
	@ComparatorTypeField
	private String estado;
	
	@RegisterUserIdField
	@Column(name = "IDUSUARIOREGISTRO")
	@ComparatorTypeField
	private String idUsuarioRegistro;
	
	@RegisterDateField
	@Column(name = "FECHAREGISTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@LastModifierUserIdField
	@Column(name = "IDUSUARIOMODIFICACION")
	@ComparatorTypeField
	private String idUsuarioModificacion;
	
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
    	@JoinColumn(name = "CODFUNTIPMAR", referencedColumnName = "CODFUNTIPMAR", insertable = false, updatable = false)
    })
	private FuncionarioTipoMarcaDTO funcionarioTipoMarca;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOMARCA", referencedColumnName = "SECUENCIALMARCA", insertable = false, updatable = false)
    })
	private MarcaArticuloDTO marcaArticulo;

	/**
	 * @return the codigoFuncionarioTipoMarca
	 */
	public Long getCodigoFuncionarioTipoMarca() {
		return codigoFuncionarioTipoMarca;
	}

	/**
	 * @param codigoFuncionarioTipoMarca the codigoFuncionarioTipoMarca to set
	 */
	public void setCodigoFuncionarioTipoMarca(Long codigoFuncionarioTipoMarca) {
		this.codigoFuncionarioTipoMarca = codigoFuncionarioTipoMarca;
	}

	/**
	 * @return the codigoMarca
	 */
	public Long getCodigoMarca() {
		return codigoMarca;
	}

	/**
	 * @param codigoMarca the codigoMarca to set
	 */
	public void setCodigoMarca(Long codigoMarca) {
		this.codigoMarca = codigoMarca;
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
	 * @return the id
	 */
	public MarcaFuncionarioTipoMarcaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(MarcaFuncionarioTipoMarcaID id) {
		this.id = id;
	}

	/**
	 * @return the funcionarioTipoMarca
	 */
	public FuncionarioTipoMarcaDTO getFuncionarioTipoMarca() {
		return funcionarioTipoMarca;
	}

	/**
	 * @param funcionarioTipoMarca the funcionarioTipoMarca to set
	 */
	public void setFuncionarioTipoMarca(FuncionarioTipoMarcaDTO funcionarioTipoMarca) {
		this.funcionarioTipoMarca = funcionarioTipoMarca;
	}

	/**
	 * @return the marcaArticulo
	 */
	public MarcaArticuloDTO getMarcaArticulo() {
		return marcaArticulo;
	}

	/**
	 * @param marcaArticulo the marcaArticulo to set
	 */
	public void setMarcaArticulo(MarcaArticuloDTO marcaArticulo) {
		this.marcaArticulo = marcaArticulo;
	}
}
