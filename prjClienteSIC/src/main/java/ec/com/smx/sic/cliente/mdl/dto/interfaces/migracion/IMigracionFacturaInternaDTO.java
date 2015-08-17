package ec.com.smx.sic.cliente.mdl.dto.interfaces.migracion;

import java.math.BigDecimal;
import java.util.Date;

public interface IMigracionFacturaInternaDTO {

	/**
	 * @return the tipoRegistro
	 */
	public abstract Integer getTipoRegistro();

	/**
	 * @param tipoRegistro the tipoRegistro to set
	 */
	public abstract void setTipoRegistro(Integer tipoRegistro);

	/**
	 * @return the numeroFacturaInterna
	 */
	public abstract String getNumeroFacturaInterna();

	/**
	 * @param numeroFacturaInterna the numeroFacturaInterna to set
	 */
	public abstract void setNumeroFacturaInterna(String numeroFacturaInterna);

	/**
	 * @return the numeroAgrupadorFacturas
	 */
	public abstract String getNumeroAgrupadorFacturas();

	/**
	 * @param numeroAgrupadorFacturas the numeroAgrupadorFacturas to set
	 */
	public abstract void setNumeroAgrupadorFacturas(
			String numeroAgrupadorFacturas);

	/**
	 * @return the codigoProveedor
	 */
	public abstract String getCodigoProveedor();

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public abstract void setCodigoProveedor(String codigoProveedor);

	/**
	 * @return the fechaEntrega
	 */
	public abstract Date getFechaEntrega();

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public abstract void setFechaEntrega(Date fechaEntrega);

	/**
	 * @return the horaInicioRecepcion
	 */
	public abstract String getHoraInicioRecepcion();

	/**
	 * @param horaInicioRecepcion the horaInicioRecepcion to set
	 */
	public abstract void setHoraInicioRecepcion(String horaInicioRecepcion);

	/**
	 * @return the horaFinRecepcion
	 */
	public abstract String getHoraFinRecepcion();

	/**
	 * @param horaFinRecepcion the horaFinRecepcion to set
	 */
	public abstract void setHoraFinRecepcion(String horaFinRecepcion);

	/**
	 * @return the codigoBodega
	 */
	public abstract String getCodigoBodega();

	/**
	 * @param codigoBodega the codigoBodega to set
	 */
	public abstract void setCodigoBodega(String codigoBodega);

	/**
	 * @return the codigoSubBodega
	 */
	public abstract String getCodigoSubBodega();

	/**
	 * @param codigoSubBodega the codigoSubBodega to set
	 */
	public abstract void setCodigoSubBodega(String codigoSubBodega);

	/**
	 * @return the tipoFactura
	 */
	public abstract String getTipoFactura();

	/**
	 * @param tipoFactura the tipoFactura to set
	 */
	public abstract void setTipoFactura(String tipoFactura);

	/**
	 * @return the valor
	 */
	public abstract BigDecimal getValor();

	/**
	 * @param valor the valor to set
	 */
	public abstract void setValor(BigDecimal valor);

	/**
	 * @return the valorTotalDescuento
	 */
	public abstract BigDecimal getValorTotalDescuento();

	/**
	 * @param valorTotalDescuento the valorTotalDescuento to set
	 */
	public abstract void setValorTotalDescuento(BigDecimal valorTotalDescuento);

	/**
	 * @return the valorTotalIva
	 */
	public abstract BigDecimal getValorTotalIva();

	/**
	 * @param valorTotalIva the valorTotalIva to set
	 */
	public abstract void setValorTotalIva(BigDecimal valorTotalIva);

	/**
	 * @return the valorTotalIve
	 */
	public abstract BigDecimal getValorTotalIve();

	/**
	 * @param valorTotalIve the valorTotalIve to set
	 */
	public abstract void setValorTotalIve(BigDecimal valorTotalIve);

	/**
	 * @return the valorTotal
	 */
	public abstract BigDecimal getValorTotal();

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public abstract void setValorTotal(BigDecimal valorTotal);

	/**
	 * @return the usuarioRecibidor
	 */
	public abstract String getUsuarioRecibidor();

	/**
	 * @param usuarioRecibidor the usuarioRecibidor to set
	 */
	public abstract void setUsuarioRecibidor(String usuarioRecibidor);

	/**
	 * @return the usuarioRecepcion
	 */
	public abstract String getUsuarioRecepcion();

	/**
	 * @param usuarioRecepcion the usuarioRecepcion to set
	 */
	public abstract void setUsuarioRecepcion(String usuarioRecepcion);
	
	/**
	 * @return the tipoTransaccion
	 */
	public abstract Integer getTipoTransaccion();
	
	/**
	 * @param tipoTransaccion the tipoTransaccion to set
	 */
	public abstract void setTipoTransaccion(Integer tipoTransaccion);
	
	/**
	 * @return the valorTotalTarifaCero
	 */
	public abstract BigDecimal getValorTotalTarifaCero();
	
	/**
	 * @param valorTotalTarifaCero the valorTotalTarifaCero to set
	 */
	public abstract void setValorTotalTarifaCero(BigDecimal valorTotalTarifaCero);
	/**
	 * @return the valorTotalTarifaDoce
	 */
	public abstract BigDecimal getValorTotalTarifaDoce();
	
	/**
	 * @param valorTotalTarifaDoce the valorTotalTarifaDoce to set
	 */
	public abstract void setValorTotalTarifaDoce(BigDecimal valorTotalTarifaDoce);
	
	/**
	 * @return the valorTotalDiferenciaRecepcion
	 */
	public abstract BigDecimal getValorTotalDiferenciaRecepcion();
	
	/**
	 * @param valorTotalDiferenciaRecepcion the valorTotalDiferenciaRecepcion to set
	 */
	public abstract void setValorTotalDiferenciaRecepcion(BigDecimal valorTotalDiferenciaRecepcion);
	
	/**
	 * @return the totalOrdenesCompra
	 */
	public abstract Integer getTotalOrdenesCompra();
	
	/**
	 * @param totalOrdenesCompra the totalOrdenesCompra to set
	 */
	public abstract void setTotalOrdenesCompra(Integer totalOrdenesCompra);
	
}