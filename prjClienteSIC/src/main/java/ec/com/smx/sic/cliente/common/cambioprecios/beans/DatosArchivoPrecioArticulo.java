/**
 * 
 */
package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.io.Serializable;

/**
 * @author cjara
 *
 */
public class DatosArchivoPrecioArticulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer numeroFila;
	private String codigoBarras;
	private String descripcionArticulo;
	private String nuevoCostoBruto;
	private String precioPVP;
	private String precioSupermaxi;

	public DatosArchivoPrecioArticulo(){
		
	}
	
	/**
	 * 
	 * @param numeroFila
	 * @param codigoBarras
	 * @param descripcionArticulo
	 * @param nuevoCostoBruto
	 * @param precioPVP
	 * @param precioSupermaxi
	 */
	public DatosArchivoPrecioArticulo(Integer numeroFila, String codigoBarras, String descripcionArticulo, String nuevoCostoBruto, String precioPVP, String precioSupermaxi) {
		this.numeroFila = numeroFila;
		this.codigoBarras = codigoBarras;
		this.descripcionArticulo = descripcionArticulo;
		this.nuevoCostoBruto = nuevoCostoBruto;
		this.precioPVP = precioPVP;
		this.precioSupermaxi = precioSupermaxi;
	}

	/**
	 *
	 */
	public String toString() {
		return "numeroFila:" + this.numeroFila + " codigoBarras:" + this.codigoBarras + " descripcionArticulo:" + this.descripcionArticulo + " nuevoCostoBruto:" + this.nuevoCostoBruto
				+ " precioPVP:" + this.precioPVP + " precioSupermaxi:" + this.precioSupermaxi;
	}

	public Integer getNumeroFila() {
		return numeroFila;
	}

	public void setNumeroFila(Integer numeroFila) {
		this.numeroFila = numeroFila;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public String getNuevoCostoBruto() {
		return nuevoCostoBruto;
	}

	public void setNuevoCostoBruto(String nuevoCostoBruto) {
		this.nuevoCostoBruto = nuevoCostoBruto;
	}

	public String getPrecioPVP() {
		return precioPVP;
	}

	public void setPrecioPVP(String precioPVP) {
		this.precioPVP = precioPVP;
	}

	public String getPrecioSupermaxi() {
		return precioSupermaxi;
	}

	public void setPrecioSupermaxi(String precioSupermaxi) {
		this.precioSupermaxi = precioSupermaxi;
	}
}
