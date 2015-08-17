
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloRegistroSanitario
 *
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloRegistroSanitarioID implements Serializable{
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Código del registro sanitario de artículo
	 *
	 */
	@Column(name="CODIGOREGSANART", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SECREGSAN")
	private String codigoRegistroSanitario;

	public ArticuloRegistroSanitarioID() {}
	
	public ArticuloRegistroSanitarioID(Boolean initID) {
		if(initID){
			codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			codigoRegistroSanitario = SICConstantes.getInstancia().VALOR_INICIAL_ID;
		}
	}
	/**
	 * @return the codigoRegistroSanitario
	 */
	public String getCodigoRegistroSanitario() {
		return codigoRegistroSanitario;
	}

	/**
	 * @param codigoRegistroSanitario the codigoRegistroSanitario to set
	 */
	public void setCodigoRegistroSanitario(String codigoRegistroSanitario) {
		this.codigoRegistroSanitario = codigoRegistroSanitario;
	}

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

}

