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

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.etiquetado.modelo.dto.PrintRequestDetailDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloDetalleSolicitudImpresionID;
/**
 * Entidad para mapear  las solicitudes de envio que tendra el articuloRegistrioSanitario
 * @author aquingaluisa
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTDETSOLIMP")
public class ArticuloDetalleSolicitudImpresionDTO  extends AuditoriaBaseDTO {
	
	@EmbeddedId 
	private ArticuloDetalleSolicitudImpresionID id = new ArticuloDetalleSolicitudImpresionID();
	
	@ComparatorTypeField
	@Column(name="CODIGOARTICULO")
	private String codigoArticulo;
	
	@ComparatorTypeField
	@Column(name="CODIGOREGISTROSANITARIO")
	private String  codigoRegistroSanitario;
	
	@ComparatorTypeField
	@Column(name="PRINTREQUESTDETAILCODE")
	private Long printRequestDetailCode;
	
	@ComparatorTypeField
	@Column(name="LOTE")
	private String lote;
	
	@ComparatorTypeField
	@Column(name="FECHACADUCIDAD")
	private Date fechaCaducidad;
	
	@ComparatorTypeField
	@Column(name="FECHAELABORACION")
	private Date fechaElaboracion;
	
	@ComparatorTypeField
	@Column(name="NUMEROETIQUETAS")
	private String numeroEtiquetas;
	
	@ComparatorTypeField
	@Column(name="ESTADO",nullable = false)
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "PRINTREQUESTDETAILCODE",referencedColumnName = "PRINTREQUESTDETAILCODE",insertable=false,updatable=false),
		 @JoinColumn(name = "CODIGOCOMPANIA",referencedColumnName = "COMPANYID",insertable=false,updatable=false)})
	private PrintRequestDetailDTO printRequestDetailDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOREGISTROSANITARIO",referencedColumnName = "CODIGOREGISTROSANITARIO",insertable=false,updatable=false),
		 @JoinColumn(name = "CODIGOARTICULO",referencedColumnName = "CODIGOARTICULO",insertable=false,updatable=false),
		 @JoinColumn(name = "CODIGOCOMPANIA",referencedColumnName = "CODIGOCOMPANIA",insertable=false,updatable=false)})
	private RelacionArticuloRegistroSanitarioDTO relacionArticuloRegistroSanitarioDTO;

	public ArticuloDetalleSolicitudImpresionID getId() {
		return id;
	}

	public void setId(ArticuloDetalleSolicitudImpresionID id) {
		this.id = id;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getCodigoRegistroSanitario() {
		return codigoRegistroSanitario;
	}

	public void setCodigoRegistroSanitario(String codigoRegistroSanitario) {
		this.codigoRegistroSanitario = codigoRegistroSanitario;
	}

	public Long getPrintRequestDetailCode() {
		return printRequestDetailCode;
	}

	public void setPrintRequestDetailCode(Long printRequestDetailCode) {
		this.printRequestDetailCode = printRequestDetailCode;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Date getFechaElaboracion() {
		return fechaElaboracion;
	}

	public void setFechaElaboracion(Date fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}

	public String getNumeroEtiquetas() {
		return numeroEtiquetas;
	}

	public void setNumeroEtiquetas(String numeroEtiquetas) {
		this.numeroEtiquetas = numeroEtiquetas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public PrintRequestDetailDTO getPrintRequestDetailDTO() {
		return printRequestDetailDTO;
	}

	public void setPrintRequestDetailDTO(PrintRequestDetailDTO printRequestDetailDTO) {
		this.printRequestDetailDTO = printRequestDetailDTO;
	}

	public RelacionArticuloRegistroSanitarioDTO getRelacionArticuloRegistroSanitarioDTO() {
		return relacionArticuloRegistroSanitarioDTO;
	}

	public void setRelacionArticuloRegistroSanitarioDTO(RelacionArticuloRegistroSanitarioDTO relacionArticuloRegistroSanitarioDTO) {
		this.relacionArticuloRegistroSanitarioDTO = relacionArticuloRegistroSanitarioDTO;
	}
}
