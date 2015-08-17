
package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.dto.id.AbstractaID;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Cuota
 * @see ec.com.smx.sic.adm.dto.Cuota
 *
 * @author xmino
 */
@SuppressWarnings("serial")
@Embeddable
public class CuotaID extends AbstractaID {

    /**
     * Codigo de la compania
     */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;

    /**
     * Secuencial generado para identificar la cuota
     */
	@Column(name = "secuencialcuota", nullable = false)
    private Integer secuencialCuota ;


    /**
     * Retorna valor de propiedad <code>codigoCompania</code>
     * @return 
     * 		Retorna valor de propiedad <code>codigoCompania</code>
     */
    public Integer getCodigoCompania(){
	return this.codigoCompania;
    }

    /**
     * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
     * @param codigoCompania1 
     *		El valor a establecer para la propiedad <code>codigoCompania</code>.
     */
    public void setCodigoCompania( Integer codigoCompania1 ){
	this.codigoCompania=codigoCompania1;

    }



    /**
     * Retorna valor de propiedad <code>secuencialCuota</code>
     * @return 
     * 		Retorna valor de propiedad <code>secuencialCuota</code>
     */
    public Integer getSecuencialCuota(){
	return this.secuencialCuota;
    }

    /**
     * Establece un nuevo valor para la propiedad <code>secuencialCuota</code>.
     * @param secuencialCuota1 
     *		El valor a establecer para la propiedad <code>secuencialCuota</code>.
     */
    public void setSecuencialCuota( Integer secuencialCuota1 ){
	this.secuencialCuota=secuencialCuota1;

    }


    /* (sin Javadoc)
     * @see ec.com.smx.sic.commons.dto.id.AbstractaID#configureColIds()
     */
    public void configureColIds()
    {
	super.resetCollection();

	super.addElement(this.codigoCompania);	    	

	super.addElement(this.secuencialCuota);	    	

	super.collectionToArray();
    }

}

