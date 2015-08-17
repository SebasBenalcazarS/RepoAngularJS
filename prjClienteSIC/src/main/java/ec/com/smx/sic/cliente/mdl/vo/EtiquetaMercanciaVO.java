package ec.com.smx.sic.cliente.mdl.vo;

/**
 * Estrcutura para armar la etiqueta de mercancias SICMERC
 * @author aquingaluisa
 *
 */
public class EtiquetaMercanciaVO implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5465822552316587319L;

	public EtiquetaMercanciaVO(){
	}
	/**
	 * id de la etiqueta
	 */
	private String codigoArticulo;
	
	/**
	 * codigo Barra
	 */
	private String codigoBarra;
	
	/**
	 * codigo Clasificacion
	 */
	private String codigoClasificacion;
	
	/**
	 * Marca del Articulo
	 */
	private String marca;
	
	/**
	 * Modelo del Articulo
	 */
	private String modelo;

	/**
	 * Precios de Venta
	 */
	private Double precioAfiIVA;	
	private Double precioNoAfiIVA;
	private Double precioComercioIVA;
	private Double precioExtGarIVA;
	
	/**
	 * Precios base
	 */
	private Double precioBaseAfiliadoIVA;
	private Double precioBaseNoAfiliadoIVA;
	
	/**
	 * Listado de caracteristicas
	 */
	private String caracteristica1;
	private String caracteristica2;
	private String caracteristica3;
	private String caracteristica4;
	private String caracteristica5;
	private String caracteristica6;
	private String caracteristica7;
	
	/**
	 * Descripcion del Articulo
	 */
	private String descripcion;
	
	/**
	 * la cantidad de cenefas que se van a imprimir.
	 */
	private Integer cantidadImpresion ;
	
	private boolean eliminar;
	
	

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	public Integer getCantidadImpresion() {
		return cantidadImpresion;
	}

	public void setCantidadImpresion(Integer cantidadImpresion) {
		this.cantidadImpresion = cantidadImpresion;
	}

	
	/**
	 * @return el precioBaseAfiliadoIVA
	 */
	public Double getPrecioBaseAfiliadoIVA() {
		return precioBaseAfiliadoIVA;
	}

	/**
	 * @param precioBaseAfiliadoIVA el precioBaseAfiliadoIVA a establecer
	 */
	public void setPrecioBaseAfiliadoIVA(Double precioBaseAfiliadoIVA) {
		this.precioBaseAfiliadoIVA = precioBaseAfiliadoIVA;
	}

	/**
	 * @return el precioBaseNoAfiliadoIVA
	 */
	public Double getPrecioBaseNoAfiliadoIVA() {
		return precioBaseNoAfiliadoIVA;
	}

	/**
	 * @param precioBaseNoAfiliadoIVA el precioBaseNoAfiliadoIVA a establecer
	 */
	public void setPrecioBaseNoAfiliadoIVA(Double precioBaseNoAfiliadoIVA) {
		this.precioBaseNoAfiliadoIVA = precioBaseNoAfiliadoIVA;
	}

	public String getCaracteristica1() {
		return caracteristica1;
	}

	public void setCaracteristica1(String caracteristica1) {
		this.caracteristica1 = caracteristica1;
	}

	public String getCaracteristica2() {
		return caracteristica2;
	}

	public void setCaracteristica2(String caracteristica2) {
		this.caracteristica2 = caracteristica2;
	}

	public String getCaracteristica3() {
		return caracteristica3;
	}

	public void setCaracteristica3(String caracteristica3) {
		this.caracteristica3 = caracteristica3;
	}

	public String getCaracteristica4() {
		return caracteristica4;
	}

	public void setCaracteristica4(String caracteristica4) {
		this.caracteristica4 = caracteristica4;
	}

	public String getCaracteristica5() {
		return caracteristica5;
	}

	public void setCaracteristica5(String caracteristica5) {
		this.caracteristica5 = caracteristica5;
	}

	public String getCaracteristica6() {
		return caracteristica6;
	}

	public void setCaracteristica6(String caracteristica6) {
		this.caracteristica6 = caracteristica6;
	}

	public String getCaracteristica7() {
		return caracteristica7;
	}

	public void setCaracteristica7(String caracteristica7) {
		this.caracteristica7 = caracteristica7;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getPrecioAfiIVA() {
		return precioAfiIVA;
	}

	public void setPrecioAfiIVA(Double precioAfiIVA) {
		this.precioAfiIVA = precioAfiIVA;
	}

	public Double getPrecioNoAfiIVA() {
		return precioNoAfiIVA;
	}

	public void setPrecioNoAfiIVA(Double precioNoAfiIVA) {
		this.precioNoAfiIVA = precioNoAfiIVA;
	}

	public Double getPrecioComercioIVA() {
		return precioComercioIVA;
	}

	public void setPrecioComercioIVA(Double precioComercioIVA) {
		this.precioComercioIVA = precioComercioIVA;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioExtGarIVA() {
		return precioExtGarIVA;
	}

	public void setPrecioExtGarIVA(Double precioExtGarIVA) {
		this.precioExtGarIVA = precioExtGarIVA;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}
	
	

}
