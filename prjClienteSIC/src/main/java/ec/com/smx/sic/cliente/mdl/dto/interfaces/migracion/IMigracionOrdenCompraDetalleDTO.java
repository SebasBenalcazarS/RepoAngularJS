package ec.com.smx.sic.cliente.mdl.dto.interfaces.migracion;

import java.math.BigDecimal;

public interface IMigracionOrdenCompraDetalleDTO {

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
	 * @return the codigoArticulo
	 */
	public abstract String getCodigoArticulo();

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public abstract void setCodigoArticulo(String codigoArticulo);

	/**
	 * @return the unidadManejo
	 */
	public abstract Integer getUnidadManejo();

	/**
	 * @param unidadManejo the unidadManejo to set
	 */
	public abstract void setUnidadManejo(Integer unidadManejo);

	/**
	 * @return the cantidadRecibida
	 */
	public abstract BigDecimal getCantidadRecibida();

	/**
	 * @param cantidadRecibida the cantidadRecibida to set
	 */
	public abstract void setCantidadRecibida(BigDecimal cantidadRecibida);

	/**
	 * @return the pesoRecibido
	 */
	public abstract BigDecimal getPesoRecibido();

	/**
	 * @param pesoRecibido the pesoRecibido to set
	 */
	public abstract void setPesoRecibido(BigDecimal pesoRecibido);

}