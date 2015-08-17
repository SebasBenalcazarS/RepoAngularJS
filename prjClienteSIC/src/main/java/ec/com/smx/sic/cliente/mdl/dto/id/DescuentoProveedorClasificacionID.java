package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase DescuentoProveedorClasificacion
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorClasificacion
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class DescuentoProveedorClasificacionID implements Serializable {

	/**
	 * Codigo de la companía
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Secuencial del descuento proveedor Clasificacion
	 */
	@Column(name = "SECUENCIALDESPROCLA", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = SICArticuloConstantes.SECUENCIAL_DESCUENTO_ARTICULO_PROVEEDOR_CLASIFICACION, castTo=@Cast(sqlType=Types.BIGINT))
	private Long secuencialDescuentoProveedorClasificacion;
	
	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * 
	 * @param codigoCompania1
	 *            El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}

	public Long getSecuencialDescuentoProveedorClasificacion() {
		return secuencialDescuentoProveedorClasificacion;
	}

	public void setSecuencialDescuentoProveedorClasificacion(Long secuencialDescuentoProveedorClasificacion) {
		this.secuencialDescuentoProveedorClasificacion = secuencialDescuentoProveedorClasificacion;
	}

}
