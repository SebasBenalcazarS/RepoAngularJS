package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.SICConstantes;

@Embeddable
@SuppressWarnings("serial")
public class CompradorID implements Serializable{
	
	
	/**
     * Codigo de la compañía
     */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;
    /**
     * Codigo que califica al Comprador
     *
     */
	@Column(name = "CODIGOCOMPRADOR", nullable = false)
    private String codigoComprador;
    
    public CompradorID() {}
    public CompradorID(Boolean initID) {
    	if(initID){
    		codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			codigoComprador = SICConstantes.getInstancia().VALOR_INICIAL_ID;
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
	 * @return the codigoComprador
	 */
	public String getCodigoComprador() {
		return codigoComprador;
	}
	/**
	 * @param codigoComprador the codigoComprador to set
	 */
	public void setCodigoComprador(String codigoComprador) {
		this.codigoComprador = codigoComprador;
	}
    
    
    
    

}
