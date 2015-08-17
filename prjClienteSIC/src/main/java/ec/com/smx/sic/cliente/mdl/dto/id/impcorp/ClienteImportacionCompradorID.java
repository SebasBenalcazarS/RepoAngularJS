/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.corpv2.dto.id.BaseID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ClienteImportacionCompradorID extends BaseID{
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOCLIENTEIMPORTACION")
	private Long codigoClienteImportacion;
	
	@Column(name = "CODIGOCOMPRADOR")
	private String codigoComprador;

	/**
	 * @return devuelve el valor de la propiedad codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania establece el valor a la propiedad codigoCompania
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoClienteImportacion
	 */
	public Long getCodigoClienteImportacion() {
		return codigoClienteImportacion;
	}

	/**
	 * @param codigoClienteImportacion establece el valor a la propiedad codigoClienteImportacion
	 */
	public void setCodigoClienteImportacion(Long codigoClienteImportacion) {
		this.codigoClienteImportacion = codigoClienteImportacion;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoComprador
	 */
	public String getCodigoComprador() {
		return codigoComprador;
	}

	/**
	 * @param codigoComprador establece el valor a la propiedad codigoComprador
	 */
	public void setCodigoComprador(String codigoComprador) {
		this.codigoComprador = codigoComprador;
	}
	
}
