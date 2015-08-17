package ec.com.smx.sic.cliente.mdl.dto.interfaces.migracion;

public interface IMigracionOrdenCompraDTO {

	/**
	 * @return the tipoRegistro
	 */
	public abstract Integer getTipoRegistro();

	/**
	 * @param tipoRegistro the tipoRegistro to set
	 */
	public abstract void setTipoRegistro(Integer tipoRegistro);

	/**
	 * @return the codigoPedido
	 */
	public abstract String getCodigoPedido();

	/**
	 * @param codigoPedido the codigoPedido to set
	 */
	public abstract void setCodigoPedido(String codigoPedido);

	/**
	 * @return the codigoOrdenCompra
	 */
	public abstract String getCodigoOrdenCompra();

	/**
	 * @param codigoOrdenCompra the codigoOrdenCompra to set
	 */
	public abstract void setCodigoOrdenCompra(String codigoOrdenCompra);

	/**
	 * @return the codigoEstadoOrdenCompra
	 */
	public abstract String getCodigoEstadoOrdenCompra();

	/**
	 * @param codigoEstadoOrdenCompra the codigoEstadoOrdenCompra to set
	 */
	public abstract void setCodigoEstadoOrdenCompra(
			String codigoEstadoOrdenCompra);

	/**
	 * @return the numeroFacturaInterna
	 */
	public abstract String getNumeroFacturaInterna();

	/**
	 * @param numeroFacturaInterna the numeroFacturaInterna to set
	 */
	public abstract void setNumeroFacturaInterna(String numeroFacturaInterna);

	/**
	 * @return the codigoProveedor
	 */
	public abstract String getCodigoProveedor();

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public abstract void setCodigoProveedor(String codigoProveedor);

	/**
	 * @return the totalItems
	 */
	public abstract Integer getTotalItems();

	/**
	 * @param totalItems the totalItems to set
	 */
	public abstract void setTotalItems(Integer totalItems);
	
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
}