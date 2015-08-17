package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorCertificadoID;

/**
 * @author Marcelo Hidalgo
 *
 */
@Entity
@Table(name = "SCPROTPROCER")
@SuppressWarnings("serial")
public class ProveedorCertificadoDTO extends AuditoriaBaseDTO{

	@EmbeddedId
	private ProveedorCertificadoID id = new ProveedorCertificadoID();
	
	@ComparatorTypeField
	@Column (name = "ESTADO", nullable = false)
	private String estado;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
					@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ProveedorDTO proveedor;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
					@JoinColumn(name="SECUENCIALCERTIFICADO", referencedColumnName="SECUENCIALCERTIFICADO", insertable=false, updatable=false)})
	private CertificadoDTO certificado;
	
	@OneToMany(mappedBy = "proveedorCertificado")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ProveedorCertificadoDefinicionArchivoDTO> proveedorCertificadoDefinicionArchivos;
	
	@Transient
	private Boolean selected = Boolean.FALSE;
	
	@Transient
	private Boolean plegar = Boolean.FALSE;

	public ProveedorCertificadoID getId() {
		return id;
	}

	public void setId(ProveedorCertificadoID id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ProveedorDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}

	public CertificadoDTO getCertificado() {
		return certificado;
	}

	public void setCertificado(CertificadoDTO certificado) {
		this.certificado = certificado;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public Collection<ProveedorCertificadoDefinicionArchivoDTO> getProveedorCertificadoDefinicionArchivos() {
		return proveedorCertificadoDefinicionArchivos;
	}

	public void setProveedorCertificadoDefinicionArchivos(Collection<ProveedorCertificadoDefinicionArchivoDTO> proveedorCertificadoDefinicionArchivos) {
		this.proveedorCertificadoDefinicionArchivos = proveedorCertificadoDefinicionArchivos;
	}

	public Boolean getPlegar() {
		return plegar;
	}

	public void setPlegar(Boolean plegar) {
		this.plegar = plegar;
	}
	
}
