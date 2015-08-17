package ec.com.smx.sic.cliente.mdl.dto.id;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@Embeddable
@SuppressWarnings("serial")
public class BodegaID implements Serializable{
	

	/**
     * Codigo de la compañía
     */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;
    /**
     * Codigo que califica al tipo de Bodega
     *
     */
	@Column(name = "CODIGOBODEGA", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSPESECBODEGA")
	@ComparatorTypeField
    private String codigoBodega;
    
    public BodegaID() {}
    
    public BodegaID(Boolean initID) {
    	if(initID){
	    	codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
	    	codigoBodega = SICConstantes.getInstancia().VALOR_INICIAL_ID;
    	}
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
	/**
	 * @return the codigoBodega
	 */
	public String getCodigoBodega() {
		return codigoBodega;
	}
	/**
	 * @param codigoBodega the codigoBodega to set
	 */
	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
	}
    

    
    
    
}
