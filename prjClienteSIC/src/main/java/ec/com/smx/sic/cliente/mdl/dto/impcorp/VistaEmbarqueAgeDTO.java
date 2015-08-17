/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.VistaEmbarqueAgeID;


/**
 * @author ccevallos
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SISIMVEMBARQUEAGE")
public class VistaEmbarqueAgeDTO extends SimpleAuditDTO implements Serializable{
	
	@EmbeddedId
	private VistaEmbarqueAgeID id = new VistaEmbarqueAgeID();

	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;
	
	@Column(name = "FECHADECLARACION")
	private Date fechaDeclaracion;
	
	@Column(name = "FECHAINICIO")
	private Date fechaInicio;
	
	@Column(name = "FECHAASIGAGENTE")
	private Date fechaAsigAgente;
	
	@Column(name = "MULTAS")
	private Double multas;
	
	@Column(name = "HONORARIOSAGENTE")
	private Double honorariosAgente;
	
	@Column(name = "HONORARIOSINSPECCION")
	private Double honorariosInspeccion;

	@Column(name = "FECHAREGISTRO")
	private Date fechaRegistro;
	
	@Column(name = "USERCOMNOM")
	private String userComNom;
	
	@Column(name = "RAZONSOCIALEMPRESA")
	private String razonSocialEmpresa;
	
	@Column(name = "ESTADO")
	private String estado;
	
	public String getUserComNom() {
		return userComNom;
	}

	public void setUserComNom(String userComNom) {
		this.userComNom = userComNom;
	}

	public String getRazonSocialEmpresa() {
		return razonSocialEmpresa;
	}

	public void setRazonSocialEmpresa(String razonSocialEmpresa) {
		this.razonSocialEmpresa = razonSocialEmpresa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getMultas() {
		return multas;
	}

	public void setMultas(Double multas) {
		this.multas = multas;
	}

	public Double getHonorariosAgente() {
		return honorariosAgente;
	}

	public void setHonorariosAgente(Double honorariosAgente) {
		this.honorariosAgente = honorariosAgente;
	}

	public Double getHonorariosInspeccion() {
		return honorariosInspeccion;
	}

	public void setHonorariosInspeccion(Double honorariosInspeccion) {
		this.honorariosInspeccion = honorariosInspeccion;
	}
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Column(name = "ANIO")
	private String anio;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE", insertable = false, updatable = false)})	
	private EmbarqueImpDTO fechaDescarga;

	public Date getFechaAsigAgente() {
		return fechaAsigAgente;
	}

	public void setFechaAsigAgente(Date fechaAsigAgente) {
		this.fechaAsigAgente = fechaAsigAgente;
	}

	public Date getFechaDeclaracion() {
		return fechaDeclaracion;
	}

	public void setFechaDeclaracion(Date fechaDeclaracion) {
		this.fechaDeclaracion = fechaDeclaracion;
	}

	public EmbarqueImpDTO getFechaDescarga() {
		return fechaDescarga;
	}

	public void setFechaDescarga(EmbarqueImpDTO fechaDescarga) {
		this.fechaDescarga = fechaDescarga;
	}

	@Transient
	private SearchResultDTO<VistaEmbarqueAgeDTO> viResultDTO;
	
	/**
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}
	
	public SearchResultDTO<VistaEmbarqueAgeDTO> getViResultDTO() {
		return viResultDTO;
	}

	public void setViResultDTO(SearchResultDTO<VistaEmbarqueAgeDTO> viResultDTO) {
		this.viResultDTO = viResultDTO;
	}
	
}
