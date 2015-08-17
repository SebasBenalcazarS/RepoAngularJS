/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.PersonaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.HistorialAhorroID;

/**
 * @author dvillafuerte
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSACTHISAHO")
public class HistorialAhorroDTO extends SimpleAuditDTO  {
	
	@EmbeddedId
	private HistorialAhorroID id = new HistorialAhorroID();
	
	private Long codigoPersona;
	
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fecha;
	
	private String local;
	private Double valorAhorrado;
	private Double valorTotal;
	private String estado;
	private Integer codigoTipoConcepto;
	private String valorTipoConcepto;
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="USUARIOREGISTRO",updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="USUARIOMODIFICACION")
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Fecha en la que se realizó la última actualización.
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	

	//relaciones
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOPERSONA", referencedColumnName = "CODIGOPERSONA", insertable = false, updatable = false) })
	private PersonaDTO personaDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOTIPOCONCEPTO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
				   @JoinColumn(name = "VALORTIPOCONCEPTO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false) })
	private CatalogoValorDTO catalogoValorDto;


	public HistorialAhorroID getId() {
		return id;
	}


	public void setId(HistorialAhorroID id) {
		this.id = id;
	}


	public Long getCodigoPersona() {
		return codigoPersona;
	}


	public void setCodigoPersona(Long codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	public java.sql.Timestamp getFecha() {
		return fecha;
	}


	public void setFecha(java.sql.Timestamp fecha) {
		this.fecha = fecha;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public Double getValorAhorrado() {
		return valorAhorrado;
	}


	public void setValorAhorrado(Double valorAhorrado) {
		this.valorAhorrado = valorAhorrado;
	}


	public Double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
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


	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}


	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}


	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public void setCodigoTipoConcepto(Integer codigoTipoConcepto) {
		this.codigoTipoConcepto = codigoTipoConcepto;
	}


	public String getValorTipoConcepto() {
		return valorTipoConcepto;
	}


	public void setValorTipoConcepto(String valorTipoConcepto) {
		this.valorTipoConcepto = valorTipoConcepto;
	}


	public CatalogoValorDTO getCatalogoValorDto() {
		return catalogoValorDto;
	}


	public void setCatalogoValorDto(CatalogoValorDTO catalogoValorDto) {
		this.catalogoValorDto = catalogoValorDto;
	}


	/**
	 * @return the personaDTO
	 */
	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}


	/**
	 * @param personaDTO the personaDTO to set
	 */
	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}


	/**
	 * @return the codigoTipoConcepto
	 */
	public Integer getCodigoTipoConcepto() {
		return codigoTipoConcepto;
	}
}
