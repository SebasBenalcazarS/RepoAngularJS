/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras;

import java.io.Serializable;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author dvillafuerte
 *
 */
@SuppressWarnings("serial")
public class ListaRecetaID implements Serializable , Cloneable{

	
	/**
	 * Código de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSACSLISREC")
	@Column(name = "CODIGOLISTARECETA", nullable = false)
	private Long codigoListaReceta;
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoListaReceta() {
		return codigoListaReceta;
	}

	public void setCodigoListaReceta(Long codigoListaReceta) {
		this.codigoListaReceta = codigoListaReceta;
	}
	
	public ListaRecetaID clone() throws CloneNotSupportedException{
		return (ListaRecetaID)super.clone();
	}
}
