
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase RecepcionProveedor
 * @see ec.com.smx.sic.cliente.mdl.dto.AsignacionProceso
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Embeddable
public class TipoContenedorID implements Serializable{


	/**
	 * Codigo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;

	/**
	 * Secuencial de la tabla AsignacionProceso
	 *
	 */
	@Column(name = "CODIGOTIPOCONTENEDOR", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECTIPCON")
	private Integer codigoTipoContenedor ;

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
	 * @return the codigoTipoContenedor
	 */
	public Integer getCodigoTipoContenedor() {
		return codigoTipoContenedor;
	}

	/**
	 * @param codigoTipoContenedor the codigoTipoContenedor to set
	 */
	public void setCodigoTipoContenedor(Integer codigoTipoContenedor) {
		this.codigoTipoContenedor = codigoTipoContenedor;
	}

}

