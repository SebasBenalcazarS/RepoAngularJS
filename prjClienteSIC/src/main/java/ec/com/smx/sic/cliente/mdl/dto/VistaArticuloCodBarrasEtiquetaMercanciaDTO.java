package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloCodBarrasEtiquetaMercanciaID;

/**
 * Vista para obtener los campos de la etiqueta de mercancia  mediante codigo de barras
 * @author aquingaluisa
 *
 */
@Entity
@SuppressWarnings("serial")
public class VistaArticuloCodBarrasEtiquetaMercanciaDTO extends SearchDTO {
	
	@EmbeddedId
	private VistaArticuloCodBarrasEtiquetaMercanciaID id;

	private String codigoBarras;
	private String descripcionArticulo;
	private String nombreProductoMerc;
	private String marcaComercialMerc;
	private String loteMerc;
	private String modeloMerc;
	private String contenidoNetoMerc;
	private String razonSocialFabricanteMerc;
	private String direccionFabricanteMerc;
	private String razonSocialImportadorMerc;
	private String direcionImportadorMerc;
	private String listaComponentesMerc;
	private String codigoDivisionGeopolMerc;
	private Date fechaMaximaUsoMerc;
	private String condicionesConservacionMerc;
	private String nteMerc;
	private String advertencia;
	private String traduccionMerc;
	private String tamanio;
	@Transient
	private Integer numeroEtiquetas;
	public VistaArticuloCodBarrasEtiquetaMercanciaID getId() {
		return id;
	}

	public void setId(VistaArticuloCodBarrasEtiquetaMercanciaID id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public String getNombreProductoMerc() {
		return nombreProductoMerc;
	}

	public void setNombreProductoMerc(String nombreProductoMerc) {
		this.nombreProductoMerc = nombreProductoMerc;
	}

	public String getMarcaComercialMerc() {
		return marcaComercialMerc;
	}

	public void setMarcaComercialMerc(String marcaComercialMerc) {
		this.marcaComercialMerc = marcaComercialMerc;
	}

	public String getLoteMerc() {
		return loteMerc;
	}

	public void setLoteMerc(String loteMerc) {
		this.loteMerc = loteMerc;
	}

	public String getModeloMerc() {
		return modeloMerc;
	}

	public void setModeloMerc(String modeloMerc) {
		this.modeloMerc = modeloMerc;
	}

	public String getContenidoNetoMerc() {
		return contenidoNetoMerc;
	}

	public void setContenidoNetoMerc(String contenidoNetoMerc) {
		this.contenidoNetoMerc = contenidoNetoMerc;
	}

	public String getRazonSocialFabricanteMerc() {
		return razonSocialFabricanteMerc;
	}

	public void setRazonSocialFabricanteMerc(String razonSocialFabricanteMerc) {
		this.razonSocialFabricanteMerc = razonSocialFabricanteMerc;
	}

	public String getDireccionFabricanteMerc() {
		return direccionFabricanteMerc;
	}

	public void setDireccionFabricanteMerc(String direccionFabricanteMerc) {
		this.direccionFabricanteMerc = direccionFabricanteMerc;
	}

	public String getRazonSocialImportadorMerc() {
		return razonSocialImportadorMerc;
	}

	public void setRazonSocialImportadorMerc(String razonSocialImportadorMerc) {
		this.razonSocialImportadorMerc = razonSocialImportadorMerc;
	}

	public String getDirecionImportadorMerc() {
		return direcionImportadorMerc;
	}

	public void setDirecionImportadorMerc(String direcionImportadorMerc) {
		this.direcionImportadorMerc = direcionImportadorMerc;
	}

	public String getListaComponentesMerc() {
		return listaComponentesMerc;
	}

	public void setListaComponentesMerc(String listaComponentesMerc) {
		this.listaComponentesMerc = listaComponentesMerc;
	}

	public String getCodigoDivisionGeopolMerc() {
		return codigoDivisionGeopolMerc;
	}

	public void setCodigoDivisionGeopolMerc(String codigoDivisionGeopolMerc) {
		this.codigoDivisionGeopolMerc = codigoDivisionGeopolMerc;
	}

	public String getCondicionesConservacionMerc() {
		return condicionesConservacionMerc;
	}

	public void setCondicionesConservacionMerc(String condicionesConservacionMerc) {
		this.condicionesConservacionMerc = condicionesConservacionMerc;
	}

	public Date getFechaMaximaUsoMerc() {
		return fechaMaximaUsoMerc;
	}

	public void setFechaMaximaUsoMerc(Date fechaMaximaUsoMerc) {
		this.fechaMaximaUsoMerc = fechaMaximaUsoMerc;
	}

	public String getNteMerc() {
		return nteMerc;
	}

	public void setNteMerc(String nteMerc) {
		this.nteMerc = nteMerc;
	}

	public String getAdvertencia() {
		return advertencia;
	}

	public void setAdvertencia(String advertencia) {
		this.advertencia = advertencia;
	}

	public String getTraduccionMerc() {
		return traduccionMerc;
	}

	public void setTraduccionMerc(String traduccionMerc) {
		this.traduccionMerc = traduccionMerc;
	}

	public Integer getNumeroEtiquetas() {
		return numeroEtiquetas;
	}

	public void setNumeroEtiquetas(Integer numeroEtiquetas) {
		this.numeroEtiquetas = numeroEtiquetas;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}
	
}
