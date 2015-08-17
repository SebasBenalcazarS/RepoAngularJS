/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class ArticuloOfertaProveedorID implements Serializable{
	
	/**
	 * Codigo de compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Secuencial del codigo articulo oferta
	 */
	@Column(name = "CODIGOARTICULOOFERTA", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = "SCFRUSECARTOFEPRO", castTo=@Cast(sqlType=Types.BIGINT))
	private Long codigoArticuloOferta;
	
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
	 * @return the codigoArticuloOferta
	 */
	public Long getCodigoArticuloOferta() {
		return codigoArticuloOferta;
	}

	/**
	 * @param codigoArticuloOferta the codigoArticuloOferta to set
	 */
	public void setCodigoArticuloOferta(Long codigoArticuloOferta) {
		this.codigoArticuloOferta = codigoArticuloOferta;
	}

}
