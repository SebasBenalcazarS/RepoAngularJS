package ec.com.smx.sic.cliente.mdl.dto.interfaces.integracion;

public interface IConsultarDatosArticuloDetalleIDTO {

	/*getters and setters*/
	public abstract String getCodigoBarras();

	public abstract void setCodigoBarras(String codigoBarras);

	public abstract Integer getRotacion1();

	public abstract void setRotacion1(Integer rotacion1);

	public abstract Integer getRotacion2();

	public abstract void setRotacion2(Integer rotacion2);

	public abstract Integer getRotacion3();

	public abstract void setRotacion3(Integer rotacion3);

	public abstract Integer getRotacion4();

	public abstract void setRotacion4(Integer rotacion4);

	public abstract Integer getRotacion5();

	public abstract void setRotacion5(Integer rotacion5);

	public abstract Integer getRotacion6();

	public abstract void setRotacion6(Integer rotacion6);

	public abstract Double getExistencia();

	public abstract void setExistencia(Double existencia);

	/**
	 * @return the productoDescuento1
	 */
	public abstract Double getProductoDescuento1();

	/**
	 * @param productoDescuento1 the productoDescuento1 to set
	 */
	public abstract void setProductoDescuento1(Double productoDescuento1);

	/**
	 * @return the productoDescuento2
	 */
	public abstract Double getProductoDescuento2();

	/**
	 * @param productoDescuento2 the productoDescuento2 to set
	 */
	public abstract void setProductoDescuento2(Double productoDescuento2);

	/**
	 * @return the productoDescuento3
	 */
	public abstract Double getProductoDescuento3();

	/**
	 * @param productoDescuento3 the productoDescuento3 to set
	 */
	public abstract void setProductoDescuento3(Double productoDescuento3);

	/**
	 * @return the productoDescuento4
	 */
	public abstract Double getProductoDescuento4();

	/**
	 * @param productoDescuento4 the productoDescuento4 to set
	 */
	public abstract void setProductoDescuento4(Double productoDescuento4);

	/**
	 * @return the productoDescuentoDocenas
	 */
	public abstract Double getProductoDescuentoDocenas();

	/**
	 * @param productoDescuentoDocenas the productoDescuentoDocenas to set
	 */
	public abstract void setProductoDescuentoDocenas(Double productoDescuentoDocenas);

	/**
	 * @return the productoDescuentoPromocion
	 */
	public abstract Double getProductoDescuentoPromocion();

	/**
	 * @param productoDescuentoPromocion the productoDescuentoPromocion to set
	 */
	public abstract void setProductoDescuentoPromocion(Double productoDescuentoPromocion);

	/**
	 * @return the productoDescuentoEspecial
	 */
	public abstract Double getProductoDescuentoEspecial();

	/**
	 * @param productoDescuentoEspecial the productoDescuentoEspecial to set
	 */
	public abstract void setProductoDescuentoEspecial(Double productoDescuentoEspecial);

	public abstract Double getCostoBruto();

	public abstract void setCostoBruto(Double costoBruto);

	public abstract Integer getCantidadTransito();

	public abstract void setCantidadTransito(Integer cantidadTransito);

	/**
	 * @return the proveedorFinal
	 */
	public abstract char getProveedorFinal();

	/**
	 * @param proveedorFinal the proveedorFinal to set
	 */
	public abstract void setProveedorFinal(char proveedorFinal);

	public abstract Integer getTiempoDemora();

	public abstract void setTiempoDemora(Integer tiempoDemora);
	
	public abstract Integer getTiempoEspera();
	
	public abstract void setTiempoEspera(Integer tiempoEspera);

	public abstract Integer getValorUnidadManejo();

	public abstract void setValorUnidadManejo(Integer valorUnidadManejo);
	
	public abstract String getObservacion();

	public abstract void setObservacion(String observacion);

	public abstract Integer getAplicaMaximoMinimo();

	public abstract void setAplicaMaximoMinimo(Integer aplicaMaximoMinimo);
	
	public abstract Double getExistencia51();

	public abstract void setExistencia51(Double existencia51);
	
	public abstract Double getExistencia55();

	public abstract void setExistencia55(Double existencia55);
	
	public abstract Double getExistencia60();

	public abstract void setExistencia60(Double existencia60);
}