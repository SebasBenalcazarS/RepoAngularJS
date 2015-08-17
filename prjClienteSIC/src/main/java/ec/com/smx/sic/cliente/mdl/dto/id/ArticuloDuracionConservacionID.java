package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloDuracionConservacion
 * 
 * @see ec.com.smx.sic.adm.dto.ArticuloDuracionConservacion
 * 
 * @author acaiza
 */
@Embeddable
@SuppressWarnings("serial")
public class ArticuloDuracionConservacionID extends ArticuloID {
	
	/**
	 * Codigo del Tipo de Conservacion del Articulo
	 *
	 */
	@Column(name = "CODIGOTIPOCONSERVACION", nullable = false)
	private Integer codigoTipoConservacion ;		

	/**
	 * Codigo del Tipo de Conservacion del Articulo
	 *
	 */
	@Column(name = "VALORTIPOCONSERVACION", nullable = false)
	private String valorTipoConservacion ;
	
	/**
	 * Retorna valor de propiedad <code>codigoTipoConservacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoTipoConservacion</code>
	 */
	public Integer getCodigoTipoConservacion(){
		return this.codigoTipoConservacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoConservacion</code>.
	 * @param codigoTipoConservacion1 
	 *		El valor a establecer para la propiedad <code>codigoTipoConservacion</code>.
	 */
	public void setCodigoTipoConservacion( Integer codigoTipoConservacion1 ){
		this.codigoTipoConservacion=codigoTipoConservacion1;
		
	}

	/**
	 * Retorna valor de propiedad <code>valorTipoConservacion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>valorTipoConservacion</code>
	 */
	public String getValorTipoConservacion(){
		return this.valorTipoConservacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>valorTipoConservacion</code>.
	 * @param valorTipoConservacion1 
	 *		El valor a establecer para la propiedad <code>valorTipoConservacion</code>.
	 */
	public void setValorTipoConservacion( String valorTipoConservacion1 ){
		this.valorTipoConservacion=valorTipoConservacion1;
		
		if(valorTipoConservacion!=null && valorTipoConservacion.length()>3){
			valorTipoConservacion = valorTipoConservacion.substring(0,3);
		}
	}
	
}
