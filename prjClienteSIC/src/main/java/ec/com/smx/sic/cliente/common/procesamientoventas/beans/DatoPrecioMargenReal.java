package ec.com.smx.sic.cliente.common.procesamientoventas.beans;

import java.math.BigDecimal;

/**
 * @author Danny Gutiérrez (dgutierrez@kruger.com.ec)
 **/

public class DatoPrecioMargenReal {
	private BigDecimal precioBase;
	private BigDecimal precioBaseReal;
	public BigDecimal getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(BigDecimal precioBase) {
		this.precioBase = precioBase;
	}
	public BigDecimal getPrecioBaseReal() {
		return precioBaseReal;
	}
	public void setPrecioBaseReal(BigDecimal precioBaseReal) {
		this.precioBaseReal = precioBaseReal;
	}
	public DatoPrecioMargenReal(BigDecimal precioBase, BigDecimal precioBaseReal) {
		this.precioBase = precioBase;
		this.precioBaseReal = precioBaseReal;
	}
}
