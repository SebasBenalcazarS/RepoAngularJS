package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorCertificadoDefinicionArchivoID;

/**
 * @author Marcelo Hidalgo
 *
 */
@Entity
@Table(name = "SCPROTPROCERDEFARC")
@SuppressWarnings("serial")
public class ProveedorCertificadoDefinicionArchivoDTO extends AuditoriaBaseDTO{

	@EmbeddedId
	private ProveedorCertificadoDefinicionArchivoID id = new ProveedorCertificadoDefinicionArchivoID();
	
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;
	
	@Column(name = "SECUENCIALCERTIFICADO", nullable = false)
	private String secuencialCertificado;
	
	@Column(name = "NOMBREARCHIVO", nullable = false)
	private String nombreArchivo;
	
	@Column(name = "DESCRIPCIONARCHIVO")
	private String descripcionArchivo;
	
	@Column(name = "TAMANIOARCHIVO", nullable = false)
	private Double tamanioArchivo;
	
	@Column(name = "TIPOCONTENIDOARCHIVO", nullable = false)
	private String tipoContenidoArchivo;
	
	@ComparatorTypeField
	@Column (name = "ESTADO", nullable = false)
	private String estado;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
					@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false),
					@JoinColumn(name="SECUENCIALCERTIFICADO", referencedColumnName="SECUENCIALCERTIFICADO", insertable=false, updatable=false)})
	private ProveedorCertificadoDTO proveedorCertificado;

	public ProveedorCertificadoDefinicionArchivoID getId() {
		return id;
	}

	public void setId(ProveedorCertificadoDefinicionArchivoID id) {
		this.id = id;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getSecuencialCertificado() {
		return secuencialCertificado;
	}

	public void setSecuencialCertificado(String secuencialCertificado) {
		this.secuencialCertificado = secuencialCertificado;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		if(nombreArchivo != null && nombreArchivo.length() > 50){
			this.nombreArchivo = nombreArchivo.substring(0, 48);
		} else {
			this.nombreArchivo = nombreArchivo;
		}
	}

	public String getDescripcionArchivo() {
		return descripcionArchivo;
	}

	public void setDescripcionArchivo(String descripcionArchivo) {
		if(descripcionArchivo != null && descripcionArchivo.length() > 500){
			this.descripcionArchivo = descripcionArchivo.substring(0, 498);
		} else {
			this.descripcionArchivo = descripcionArchivo;
		}
	}

	public Double getTamanioArchivo() {
		return tamanioArchivo;
	}

	public void setTamanioArchivo(Double tamanioArchivo) {
		this.tamanioArchivo = tamanioArchivo;
	}

	public String getTipoContenidoArchivo() {
		return tipoContenidoArchivo;
	}

	public void setTipoContenidoArchivo(String tipoContenidoArchivo) {
		this.tipoContenidoArchivo = tipoContenidoArchivo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ProveedorCertificadoDTO getProveedorCertificado() {
		return proveedorCertificado;
	}

	public void setProveedorCertificado(ProveedorCertificadoDTO proveedorCertificado) {
		this.proveedorCertificado = proveedorCertificado;
	}
	
}
