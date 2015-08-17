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
import ec.com.smx.sic.cliente.mdl.dto.id.LineaComercialFuncionarioTipoMarcaID;

/**
 * Administra las lineas comerciales del funcionario por tipos de marca (Propia, proveedor)
 * @author fcollaguazo
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "SCADMTLINCOMFUNTIPMAR")
public class LineaComercialFuncionarioTipoMarcaDTO  extends SimpleAuditDTO{
	
	@EmbeddedId
	private LineaComercialFuncionarioTipoMarcaID id;
	
	public LineaComercialFuncionarioTipoMarcaDTO(){
		id = new LineaComercialFuncionarioTipoMarcaID();
	}
	
	@Column(name="CODLINCOMFUN")
	private Long codigoLineaComercialFuncionario;
	
	@Column(name="CODFUNTIPMAR")
	private Long codigoFuncionarioTipoMarca;
	
	@Column(name="CODIGOFUNCIONARIO", nullable = false)
	private String codigoFuncionario;
	
	@Column(name="ESTADO")
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
    	@JoinColumn(name = "CODLINCOMFUN", referencedColumnName = "CODLINCOMFUN", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFUNCIONARIO", referencedColumnName = "CODIGOFUNCIONARIO", insertable = false, updatable = false)
    })
	private LineaComercialFuncionarioDTO lineaComercialFuncionario;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
    	@JoinColumn(name = "CODFUNTIPMAR", referencedColumnName = "CODFUNTIPMAR", insertable = false, updatable = false)
    })
	private FuncionarioTipoMarcaDTO funcionarioTipoMarca;
	
	
	/**
	 * @return the id
	 */
	public LineaComercialFuncionarioTipoMarcaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(LineaComercialFuncionarioTipoMarcaID id) {
		this.id = id;
	}

	/**
	 * @return the codigoLineaComercialFuncionario
	 */
	public Long getCodigoLineaComercialFuncionario() {
		return codigoLineaComercialFuncionario;
	}

	/**
	 * @param codigoLineaComercialFuncionario the codigoLineaComercialFuncionario to set
	 */
	public void setCodigoLineaComercialFuncionario(Long codigoLineaComercialFuncionario) {
		this.codigoLineaComercialFuncionario = codigoLineaComercialFuncionario;
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
	 * @return the lineaComercialFuncionario
	 */
	public LineaComercialFuncionarioDTO getLineaComercialFuncionario() {
		return lineaComercialFuncionario;
	}

	/**
	 * @param lineaComercialFuncionario the lineaComercialFuncionario to set
	 */
	public void setLineaComercialFuncionario(LineaComercialFuncionarioDTO lineaComercialFuncionario) {
		this.lineaComercialFuncionario = lineaComercialFuncionario;
	}

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
	 * @return the codigoFuncionario
	 */
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	/**
	 * @param codigoFuncionario the codigoFuncionario to set
	 */
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
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
}
