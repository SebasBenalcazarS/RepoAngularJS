/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author eharo
 *
 */

@SuppressWarnings("serial")
@Embeddable
public class ArticuloEtiquetaMercanciaCatalogoID implements Serializable {
	
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;
	
	
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSARTETIMERCAT")
	@Column(name = "CODIGOARTETIMERCAT", nullable = false)
	private Long codigoArticuloEtiquetaMercanciaCatalogo;

	
	

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
	 * @return the codigoArticuloEtiquetaMercanciaCatalogo
	 */
	public Long getCodigoArticuloEtiquetaMercanciaCatalogo() {
		return codigoArticuloEtiquetaMercanciaCatalogo;
	}


	/**
	 * @param codigoArticuloEtiquetaMercanciaCatalogo the codigoArticuloEtiquetaMercanciaCatalogo to set
	 */
	public void setCodigoArticuloEtiquetaMercanciaCatalogo(Long codigoArticuloEtiquetaMercanciaCatalogo) {
		this.codigoArticuloEtiquetaMercanciaCatalogo = codigoArticuloEtiquetaMercanciaCatalogo;
	}

}
