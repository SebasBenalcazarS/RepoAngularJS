package ec.com.smx.sic.cliente.common.procesamientoventas.beans;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Danny Gutiérrez (dgutierrez@kruger.com.ec)
 **/

public class DatoPrecioMargenReal {
	private Date fecha;
	private BigDecimal precioDescuento;
	private BigDecimal precioDescuentoIncluidoCobro;
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getPrecioDescuento() {
		return precioDescuento;
	}

	public void setPrecioDescuento(BigDecimal precioDescuento) {
		this.precioDescuento = precioDescuento;
	}

	public BigDecimal getPrecioDescuentoIncluidoCobro() {
		return precioDescuentoIncluidoCobro;
	}

	public void setPrecioDescuentoIncluidoCobro(BigDecimal precioDescuentoIncluidoCobro) {
		this.precioDescuentoIncluidoCobro = precioDescuentoIncluidoCobro;
	}
	
	public String getFechaString() {
		return new SimpleDateFormat("yyyy-MM-dd").format(fecha);
	}

	/**
	 * Default Constructor
	 * 
	 * @param fecha
	 * @param precioDescuento
	 * @param precioDescuentoIncluidoCobro
	 */
	public DatoPrecioMargenReal(Date fecha, BigDecimal precioDescuento, BigDecimal precioDescuentoIncluidoCobro) {
		this.fecha = fecha;
		this.precioDescuento = precioDescuento;
		this.precioDescuentoIncluidoCobro = precioDescuentoIncluidoCobro;
	}
}
