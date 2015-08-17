/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo;

import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;

/**
 * @author gaortiz
 *
 */
public final class DescuentoProveedorArticuloCompra extends ArticuloDescuentoCompra {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO;

	/**
	 * @param descuentoProveedorArticuloDTO
	 */
	public DescuentoProveedorArticuloCompra(DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO) {
		this.descuentoProveedorArticuloDTO = descuentoProveedorArticuloDTO;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#getNombreDescuento()
	 */
	@Override
	public String getNombreDescuento() {
		// <>TIPODESCUENTO
		if( this.descuentoProveedorArticuloDTO.getAsignacionTipoDescuento() == null ){
			return null;
		}
		return this.descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().getTipoDescuento().getDescripcion();
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#getValorDescuento()
	 */
	@Override
	public Object getValorDescuento() {
		return this.descuentoProveedorArticuloDTO.getPorcentajeDescuento();
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#setValorDescuento(java.lang.Object)
	 */
	@Override
	public void setValorDescuento(Object valorDescuento) {
		Double valor = valorDescuento != null ? Double.valueOf(valorDescuento.toString()) : null;
		this.descuentoProveedorArticuloDTO.setPorcentajeDescuento( valor );
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#getCostoNetoParcial()
	 */
	@Override
	public Double getCostoNetoParcial() {
		if( this.descuentoProveedorArticuloDTO.hasDynamicProperty(DescuentoProveedorArticuloDTO.COSTO_NETO_PARCIAL) ){
			return (Double) this.descuentoProveedorArticuloDTO.getDynamicProperty(ArticuloUnidadManejoProveedorDTO.COSTO_NETO_PARCIAL);
		}
		return new Double(0);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#getDescuentoDTO()
	 */
	@Override
	public DescuentoProveedorArticuloDTO getDescuentoDTO() {
		return this.descuentoProveedorArticuloDTO;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#getCodigoDescuento()
	 */
	public Integer getCodigoDescuento() {
		return this.descuentoProveedorArticuloDTO.getCodigoEquivalenciaDescuento();
	}

	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.ArticuloDescuentoCompra#setCodigoDescuento(java.lang.Integer)
	 */
	public void setCodigoDescuento(Integer codigoDescuento) {
		this.descuentoProveedorArticuloDTO.setCodigoEquivalenciaDescuento(codigoDescuento);
	}

}
