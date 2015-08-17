package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.VistaEmbarqueAsistenteWorkFlowID;

@SuppressWarnings("serial")
@Table(name = "SISIMVORDCOMWOR")
public class VistaEmbarqueAsistenteWorkFlowDTO extends SimpleAuditDTO implements Serializable{
	@EmbeddedId
	private VistaEmbarqueAsistenteWorkFlowID id = new VistaEmbarqueAsistenteWorkFlowID();	
	
	
	@Column(name = "NUMEROCASO")
	private String numeroCaso;
	
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;
	
	@Column(name = "FECHAREGISTRO")
	private Timestamp fechaRegistro;
	
	@Column(name = "RAZONSOCIALPROVEEDOR")
	private String razonSocial;
	
	@Column(name = "OFICINACOMERCIAL")
	private String oficinaComercial;
	
	@Column(name = "RESPONSABLEIMPORTACION")
	private String responsableImportacion;
	
	@Column(name = "CODIGOACTIVIDAD")
	private Long codigoActividad;
	
	@Column(name = "NOMBREACTIVIDAD")
	private String nombreActividad;
	
	@Column(name = "USUARIOACTUAL")
	private String usuarioActual;
		
	@Column(name = "USUARIOGESTIONO")
	private String usuarioGestiono;
	
	@Column(name = "FECHAASIGNACION")
	private Timestamp fechaAsignacion;
	
	@Column(name = "OBSERVACION")
	private String observacion;
	
	@Transient
	private SearchResultDTO<VistaEmbarqueAsistenteWorkFlowDTO> viResultDTO;
	
	@OneToMany(mappedBy = "reporteEmbarque")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<OrdenCompraImpDTO> ordenCompra;

	

	public String getNumeroCaso() {
		return numeroCaso;
	}

	public void setNumeroCaso(String numeroCaso) {
		this.numeroCaso = numeroCaso;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}


	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getOficinaComercial() {
		return oficinaComercial;
	}

	public void setOficinaComercial(String oficinaComercial) {
		this.oficinaComercial = oficinaComercial;
	}

	public String getResponsableImportacion() {
		return responsableImportacion;
	}

	public void setResponsableImportacion(String responsableImportacion) {
		this.responsableImportacion = responsableImportacion;
	}

	public Long getCodigoActividad() {
		return codigoActividad;
	}

	public void setCodigoActividad(Long codigoActividad) {
		this.codigoActividad = codigoActividad;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(String usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	public String getUsuarioGestiono() {
		return usuarioGestiono;
	}

	public void setUsuarioGestiono(String usuarioGestiono) {
		this.usuarioGestiono = usuarioGestiono;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public SearchResultDTO<VistaEmbarqueAsistenteWorkFlowDTO> getViResultDTO() {
		return viResultDTO;
	}

	public void setViResultDTO(SearchResultDTO<VistaEmbarqueAsistenteWorkFlowDTO> viResultDTO) {
		this.viResultDTO = viResultDTO;
	}

	public Collection<OrdenCompraImpDTO> getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(Collection<OrdenCompraImpDTO> ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public VistaEmbarqueAsistenteWorkFlowID getId() {
		return id;
	}

	public void setId(VistaEmbarqueAsistenteWorkFlowID id) {
		this.id = id;
	}

	public java.sql.Timestamp getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(java.sql.Timestamp fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	

		
}
