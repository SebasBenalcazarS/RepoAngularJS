package ec.com.smx.sic.cliente.mdl.dto.interfaces.migracion;

import java.math.BigDecimal;

public interface IMigracionFacturaProveedorDTO {

	/**
	 * 
	 * @return the codigoEntrega
	 */
	public abstract Long getCodigoEntrega();
	
	/**
	 * 
	 * @param codigoEntrega the codigoEntrega to set
	 */
	public abstract void setCodigoEntrega(Long codigoEntrega);
	
	/**
	 * @return the tipoRegistro
	 */
	public abstract Integer getTipoRegistro();

	/**
	 * @param tipoRegistro the tipoRegistro to set
	 */
	public abstract void setTipoRegistro(Integer tipoRegistro);

	/**
	 * @return the codigoFacturaProveedor
	 */
	public abstract String getCodigoFacturaProveedor();

	/**
	 * @param codigoFacturaProveedor the codigoFacturaProveedor to set
	 */
	public abstract void setCodigoFacturaProveedor(String codigoFacturaProveedor);

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
	 * @return the valorTotal
	 */
	public abstract BigDecimal getValorTotal();

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public abstract void setValorTotal(BigDecimal valorTotal);

	/**
	 * @return
	 */
	public String getCodigoAcceso();
	
	/**
	 * @param codigoAcceso
	 */
	public void setCodigoAcceso(String codigoAcceso);
	
	/**
	 * @return the numeroAutorizacion
	 */
	public abstract String getNumeroAutorizacion();
	
	/**
	 * @param numeroAutorizacion the numeroAutorizacion to set
	 */
	public abstract void setNumeroAutorizacion(String numeroAutorizacion);
	
}