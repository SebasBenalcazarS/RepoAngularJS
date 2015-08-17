
package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ClienteArticulo
 *
 * @author mrivera
 */
@Embeddable
@SuppressWarnings("serial")
public class ClienteArticuloID extends BaseID {

	/**
	 * Especifica el codigo de la compania.
	 */
	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania ;
	
	/**
	 * Código del cliente artículo, secuencial de base de datos.
	 */
	@Column(name="SECUENCIALCLIENTEARTICULO")
	@SequenceDataBaseValue(name="SCARTSCLIART",descriptorClass=DescriptorSecuenciasSIC.class)
	private Long secuencialClienteArticulo;
	

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
	 * @return the secuencialClienteArticulo
	 */
	public Long getSecuencialClienteArticulo() {
		return secuencialClienteArticulo;
	}

	/**
	 * @param secuencialClienteArticulo the secuencialClienteArticulo to set
	 */
	public void setSecuencialClienteArticulo(Long secuencialClienteArticulo) {
		this.secuencialClienteArticulo = secuencialClienteArticulo;
	}	
}

