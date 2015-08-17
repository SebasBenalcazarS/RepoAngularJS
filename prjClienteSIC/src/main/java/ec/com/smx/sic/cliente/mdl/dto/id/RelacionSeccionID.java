package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase RelacionSeccion
 * @see ec.com.smx.sic.cliente.mdl.dto.RelacionSeccion
 *
 * @author fcollaguazo
 * 
 */
@SuppressWarnings("serial")
@Embeddable
public class RelacionSeccionID implements Serializable {

	/**
	 * codigo de la Compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;

	/**
	 * Especifica el codigo detalle de la seccion padre
	 *
	 */
	@Column(name = "CODIGODETALLESECCIONPADRE", nullable = false)
	private java.lang.Long codigoDetalleSeccionPadre ;
		
	/**
	 * Especifica el codigo detalle de la seccion que va a ser relacion
	 *
	 */
	@Column(name = "CODIGODETALLESECCION", nullable = false)
	private java.lang.Long codigoDetalleSeccion ;
		
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
	 * Retorna valor de propiedad <code>codigoDetalleSeccionPadre</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoDetalleSeccionPadre</code>
	 */
	public java.lang.Long getCodigoDetalleSeccionPadre(){
		return this.codigoDetalleSeccionPadre;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoDetalleSeccionPadre</code>.
	 * @param codigoDetalleSeccionPadre1 
	 *		El valor a establecer para la propiedad <code>codigoDetalleSeccionPadre</code>.
	 */
	public void setCodigoDetalleSeccionPadre( java.lang.Long codigoDetalleSeccionPadre1 ){
		this.codigoDetalleSeccionPadre=codigoDetalleSeccionPadre1;
		
	}

	/**
	 * Retorna valor de propiedad <code>codigoDetalleSeccion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoDetalleSeccion</code>
	 */
	public java.lang.Long getCodigoDetalleSeccion(){
		return this.codigoDetalleSeccion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoDetalleSeccion</code>.
	 * @param codigoDetalleSeccion1 
	 *		El valor a establecer para la propiedad <code>codigoDetalleSeccion</code>.
	 */
	public void setCodigoDetalleSeccion( java.lang.Long codigoDetalleSeccion1 ){
		this.codigoDetalleSeccion=codigoDetalleSeccion1;
		
	}
}