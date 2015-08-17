
package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.dto.id.AbstractaID;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloCuota
 * @see ec.com.smx.sic.adm.dto.ArticuloCuota
 *
 * @author xmino
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloCuotaID extends AbstractaID {


    /**
     * Codigo de la compañía
     */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;

    /**
     * Secuencial generado para identificar la cuota
     */
	@Column(name = "SECUENCIALCUOTA", nullable = false)
    private Integer secuencialCuota ;

    /**
     * Código del artículo
     */
    @Column(name = "CODIGOARTICULO", nullable = false)
    private String codigoArticulo ;

    /**
     * Retorna valor de propiedad <code>codigoCompania</code>
     * @return 
     */
    public Integer getCodigoCompania(){
	return this.codigoCompania;
    }

    /**
     * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
     * @param codigoCompania1 
     * El valor a establecer para la propiedad <code>codigoCompania</code>.
     */
    public void setCodigoCompania( Integer codigoCompania1 ){
	this.codigoCompania=codigoCompania1;

    }

    /**
     * Retorna valor de propiedad <code>secuencialCuota</code>
     * @return 
     */
    public Integer getSecuencialCuota(){
	return this.secuencialCuota;
    }

    /**
     * Establece un nuevo valor para la propiedad <code>secuencialCuota</code>.
     * @param secuencialCuota1 
     * El valor a establecer para la propiedad <code>secuencialCuota</code>.
     */
    public void setSecuencialCuota( Integer secuencialCuota1 ){
	this.secuencialCuota=secuencialCuota1;
    }

    /**
     * Retorna valor de propiedad <code>codigoArticulo</code>
     * @return 
     */
    public String getCodigoArticulo(){
	return this.codigoArticulo;
    }

    /**
     * Establece un nuevo valor para la propiedad <code>codigoArticulo</code>.
     * @param codigoArticulo1 
     */
    public void setCodigoArticulo( String codigoArticulo1 ){
	this.codigoArticulo=codigoArticulo1;

	if(codigoArticulo!=null && codigoArticulo.length()>20){
	    codigoArticulo = codigoArticulo.substring(0,20);
	}
    }


    /* (sin Javadoc)
     * @see ec.com.smx.sic.commons.dto.id.AbstractaID#configureColIds()
     */
    public void configureColIds()
    {
	super.resetCollection();

	super.addElement(this.codigoCompania);	    	

	super.addElement(this.secuencialCuota);	    	

	super.addElement(this.codigoArticulo);	    	

	super.collectionToArray();
    }

}

