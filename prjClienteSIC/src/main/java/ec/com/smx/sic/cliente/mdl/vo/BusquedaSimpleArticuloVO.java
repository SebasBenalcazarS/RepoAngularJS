package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;

/**
 * VO de NegociacionArticulo para realizar busquedas
 * @author dbravo
 *
 */

@SuppressWarnings("serial")
public class BusquedaSimpleArticuloVO implements Serializable {
	
	/**
	 * Codigo subBodega
	 */
	private String codigoSubbodega;
	
	private String codigoDepartamento;
	
	private String codigoClasificacion;
	
	private String codigoSubClasificacion;
	/**
	 * Tipo marca del CatalogoValor : marca Proveedor, marca Propia, etc
	 */
	private String[] tipoMarca;
	
	private Long marcaComercial;
	
	private String codigoProveedor;
	
	private String nombreMarca;
	
	public BusquedaSimpleArticuloVO(){}

	/**
	 * @return the codigoSubbodega
	 */
	public String getCodigoSubbodega() {
		return codigoSubbodega;
	}

	/**
	 * @param codigoSubbodega the codigoSubbodega to set
	 */
	public void setCodigoSubbodega(String codigoSubbodega) {
		this.codigoSubbodega = codigoSubbodega;
	}

	/**
	 * @return the codigoDepartamento
	 */
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}

	/**
	 * @param codigoDepartamento the codigoDepartamento to set
	 */
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	/**
	 * @return the codigoClasificacion
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/**
	 * @param codigoClasificacion the codigoClasificacion to set
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	/**
	 * @return the codigoSubClasificacion
	 */
	public String getCodigoSubClasificacion() {
		return codigoSubClasificacion;
	}

	/**
	 * @param codigoSubClasificacion the codigoSubClasificacion to set
	 */
	public void setCodigoSubClasificacion(String codigoSubClasificacion) {
		this.codigoSubClasificacion = codigoSubClasificacion;
	}

	/**
	 * @return the tipoMarca
	 */
	public String[] getTipoMarca() {
		return tipoMarca;
	}

	/**
	 * @param tipoMarca the tipoMarca to set
	 */
	public void setTipoMarca(String[] tipoMarca) {
		this.tipoMarca = tipoMarca;
	}

	/**
	 * @return the marcaComercial
	 */
	public Long getMarcaComercial() {
		return marcaComercial;
	}

	/**
	 * @param marcaComercial the marcaComercial to set
	 */
	public void setMarcaComercial(Long marcaComercial) {
		this.marcaComercial = marcaComercial;
	}

	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return the nombreMarca
	 */
	public String getNombreMarca() {
		return nombreMarca;
	}

	/**
	 * @param nombreMarca the nombreMarca to set
	 */
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	
	
	
	
}
