/*
 * Creado el 11/09/2006
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidadID;

/**
 * @author bmontesdeoca
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ProveedorID implements IBaseEntidadID {
	
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;



	/**
	 * codigo del proveedor
	 *

	 */
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor ;



	/**
	 * @return Devuelve codigoCompania.
	 */
	public Integer getCodigoCompania()
	{
		return codigoCompania;
	}
	/**
	 * @param codigoCompania El codigoCompania a establecer.
	 */
	public void setCodigoCompania(Integer codigoCompania)
	{
		this.codigoCompania = codigoCompania;
	}
	/**
	 * @return Devuelve codigoProveedor.
	 */
	public String getCodigoProveedor()
	{
		return codigoProveedor;
	}
	/**
	 * @param codigoProveedor El codigoProveedor a establecer.
	 */
	public void setCodigoProveedor(String codigoProveedor)
	{
		this.codigoProveedor = codigoProveedor;
	}
}
