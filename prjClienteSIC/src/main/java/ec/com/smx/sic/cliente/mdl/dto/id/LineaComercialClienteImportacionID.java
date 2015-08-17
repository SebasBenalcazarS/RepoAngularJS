package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
 * 
 * @author cortiz
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class LineaComercialClienteImportacionID implements Serializable {

	/**
	 * Codigo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	/**
	 * Especifica el codigo linea comercial
	 *
	 */
	@Column(name = "CODIGOLINEACOMERCIAL", nullable = false)
	private Long codigoLineaComercial ;
	
	/**
	 * Especifica el codigo cliente importacion
	 *
	 */
	@Column(name = "CODIGOCLIENTEIMPORTACION", nullable = false)
	private Long codigoClienteImportacion ;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoLineaComercial
	 */
	public java.lang.Long getCodigoLineaComercial() {
		return codigoLineaComercial;
	}

	/**
	 * @param codigoLineaComercial the codigoLineaComercial to set
	 */
	public void setCodigoLineaComercial(java.lang.Long codigoLineaComercial) {
		this.codigoLineaComercial = codigoLineaComercial;
	}

	/**
	 * @return the codigoClienteImportacion
	 */
	public java.lang.Long getCodigoClienteImportacion() {
		return codigoClienteImportacion;
	}

	/**
	 * @param codigoClienteImportacion the codigoClienteImportacion to set
	 */
	public void setCodigoClienteImportacion(java.lang.Long codigoClienteImportacion) {
		this.codigoClienteImportacion = codigoClienteImportacion;
	}
		
	
}
