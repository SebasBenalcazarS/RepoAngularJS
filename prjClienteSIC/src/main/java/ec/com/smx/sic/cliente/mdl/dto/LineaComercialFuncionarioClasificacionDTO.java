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
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.LineaComercialFuncionarioClasificacionID;

/**
 * Especifica las clasificaciones especificas de una linea comercial para un funcionario
 * @author fcollaguazo
 *
 */

@Entity
@Table(name = "SCADMTLINCOMFUNCLA")
@SuppressWarnings("serial")
public class LineaComercialFuncionarioClasificacionDTO extends SimpleAuditDTO{

	@EmbeddedId
	private LineaComercialFuncionarioClasificacionID id = new LineaComercialFuncionarioClasificacionID();
	
	@Column(name = "CODIGOCLASIFICACION")
	private String codigoClasificacion;
	
	@Column(name = "CODIGOFUNCIONARIO")
	private String codigoFuncionario;
	
	@Column(name = "CODLINCOMFUN")
	private Long codigoLineaComercialFuncionario;
	
	@Column(name = "CODLINCOMCLA")
	private Long codigoLineaComercialClasificacion;
	
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private String estado;
	
	@RegisterUserIdField
	@Column(name = "IDUSUARIOREGISTRO")
	private String idUsuarioRegistro;
	
	@RegisterDateField
	@Column(name = "FECHAREGISTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@LastModifierUserIdField
	@Column(name = "IDUSUARIOMODIFICACION")
	private String idUsuarioModificacion;
	
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false)
	})
	private ClasificacionDTO clasificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFUNCIONARIO", referencedColumnName = "CODIGOFUNCIONARIO", insertable = false, updatable = false)
	})
	private FuncionarioDTO funcionario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODLINCOMCLA", referencedColumnName = "CODLINCOMCLA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false)
	})
	private LineaComercialClasificacionDTO lineaComercialClasificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODLINCOMFUN", referencedColumnName = "CODLINCOMFUN", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFUNCIONARIO", referencedColumnName = "CODIGOFUNCIONARIO", insertable = false, updatable = false)
	})
	private LineaComercialFuncionarioDTO lineaComercialFuncionario;
	

	public LineaComercialFuncionarioClasificacionID getId() {
		return id;
	}

	public void setId(LineaComercialFuncionarioClasificacionID id) {
		this.id = id;
	}
	
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public Long getCodigoLineaComercialFuncionario() {
		return codigoLineaComercialFuncionario;
	}

	public void setCodigoLineaComercialFuncionario(Long codigoLineaComercialFuncionario) {
		this.codigoLineaComercialFuncionario = codigoLineaComercialFuncionario;
	}

	public Long getCodigoLineaComercialClasificacion() {
		return codigoLineaComercialClasificacion;
	}

	public void setCodigoLineaComercialClasificacion(Long codigoLineaComercialClasificacion) {
		this.codigoLineaComercialClasificacion = codigoLineaComercialClasificacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public ClasificacionDTO getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(ClasificacionDTO clasificacion) {
		this.clasificacion = clasificacion;
	}

	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	public LineaComercialClasificacionDTO getLineaComercialClasificacion() {
		return lineaComercialClasificacion;
	}

	public void setLineaComercialClasificacion(LineaComercialClasificacionDTO lineaComercialClasificacion) {
		this.lineaComercialClasificacion = lineaComercialClasificacion;
	}

	public LineaComercialFuncionarioDTO getLineaComercialFuncionario() {
		return lineaComercialFuncionario;
	}

	public void setLineaComercialFuncionario(LineaComercialFuncionarioDTO lineaComercialFuncionario) {
		this.lineaComercialFuncionario = lineaComercialFuncionario;
	}
}
