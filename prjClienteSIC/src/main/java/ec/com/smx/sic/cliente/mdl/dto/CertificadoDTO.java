package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.CompaniaDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.CertificadoID;

/**
 * @author Marcelo Hidalgo
 *
 */
@Entity
@Table(name = "SCPROTCERTIFICADO")
@SuppressWarnings("serial")
public class CertificadoDTO extends AuditoriaBaseDTO{

	@EmbeddedId
	private CertificadoID id = new CertificadoID();
	
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@ComparatorTypeField
	@Column (name = "ESTADO", nullable = false)
	private String estado;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false)
	private CompaniaDTO compania;
	
	@OneToMany(mappedBy = "certificado")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ProveedorCertificadoDTO> proveedoresCertificados;
	
	@Transient
	private Boolean selected = Boolean.FALSE;
	
	@Transient
	private Boolean asignadoAlProveedor = Boolean.FALSE;

	public CertificadoID getId() {
		return id;
	}

	public void setId(CertificadoID id) {
		this.id = id;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public CompaniaDTO getCompania() {
		return compania;
	}

	public void setCompania(CompaniaDTO compania) {
		this.compania = compania;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public Boolean getAsignadoAlProveedor() {
		return asignadoAlProveedor;
	}

	public void setAsignadoAlProveedor(Boolean asignadoAlProveedor) {
		this.asignadoAlProveedor = asignadoAlProveedor;
	}

	public Collection<ProveedorCertificadoDTO> getProveedoresCertificados() {
		return proveedoresCertificados;
	}

	public void setProveedoresCertificados(Collection<ProveedorCertificadoDTO> proveedoresCertificados) {
		this.proveedoresCertificados = proveedoresCertificados;
	}
}
