package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.Entity;

import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.mdl.dto.id.CuponID;

/**
 * Vista utilizada para generar cupones para mostrar en la web
 * 
 * @author fvallejo
 * 
 */
@Entity
public class CuponDTO extends BaseDto<CuponID> {

	private static final long serialVersionUID = 4680327882761975471L;

	/**
	 * Especifica la descripción del articulo.
	 */
	private String descripcionArticulo;
	
	/**
	 * Especifica la fecha de inicio de temporada del cupón.
	 */
	private Date fechaInicioTemporada;

	/**
	 * Especifica la fecha de fin de temporada del cupón.
	 */
	private Date fechaFinTemporada;

	/**
	 * Especifica el contenido digital de la imagen del cupón.
	 */
	private byte[] datoImagen;
	
	/**
	 * Especifica la descripción del producto mostrado en el artículo 
	 */
	private String descripcionProducto;
	
	/**
	 * Especifica el código del producto mostrado en el artículo 
	 */
	private String codigoProducto;
	
	/**
	 * Especifica el descuento (en valor moneda o porcentaje) del producto mostrado en el artículo 
	 */
	private Double valorDescuento;
	
	/**
	 * Almacena el porcentaje de descuento total
	 */
	private Double porcentajeDescuento;
	
	/**
	 * Especifica el precio normal de venta al afiliado del producto mostrado en el artículo 
	 */
	private Double precioNormalAfiliado;
	
	/**
	 * Especifica el precio final de venta del producto mostrado en el artículo 
	 */
	private Double precioFinalConCupon;

	/**
	 * Especifica las observaciones del artículo 
	 */
	private String observacion;
	
	/**
	 * Especifica la vigencia del cupón
	 */
	private String vigencia;
	
	/**
	 * Especifica la leyenda para precio normal
	 */
	private String leyendaPrecioNormal;
	
	/**
	 * Especifica la leyenda oara precio final
	 */
	private String leyendaPrecioFinal;
	
	/**
	 * Especifica la leyenda para descuento
	 */
	private String leyendaDescuento;
	
	//*******   	GETTERS Y SETTERS ********************************
	
	
	
	/**
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	/**
	 * @return the fechaInicioTemporada
	 */
	public Date getFechaInicioTemporada() {
		return fechaInicioTemporada;
	}

	/**
	 * @param fechaInicioTemporada the fechaInicioTemporada to set
	 */
	public void setFechaInicioTemporada(Date fechaInicioTemporada) {
		this.fechaInicioTemporada = fechaInicioTemporada;
	}

	/**
	 * @return the fechaFinTempodara
	 */
	public Date getFechaFinTemporada() {
		return fechaFinTemporada;
	}

	/**
	 * @param fechaFinTemporada the fechaFinTemporada to set
	 */
	public void setFechaFinTemporada(Date fechaFinTemporada) {
		this.fechaFinTemporada = fechaFinTemporada;
	}

	/**
	 * @return the datoImagen
	 */
	public byte[] getDatoImagen() {
		return datoImagen;
	}

	/**
	 * @param datoImagen the datoImagen to set
	 */
	public void setDatoImagen(byte[] datoImagen) {
		this.datoImagen = datoImagen;
	}

	/**
	 * @return the id
	 */
	public CuponID getId() {
		return id;
	}

	/**
	 * @return the descripcionProducto
	 */
	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	/**
	 * @param descripcionProducto the descripcionProducto to set
	 */
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	/**
	 * @return the codigoProducto
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * @param codigoProducto the codigoProducto to set
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	/**
	 * @return the valorDescuento
	 */
	public Double getValorDescuento() {
		return valorDescuento;
	}

	

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the porcentajeDescuento
	 */
	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	/**
	 * @param porcentajeDescuento the porcentajeDescuento to set
	 */
	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	/**
	 * @return the leyendaPrecioNormal
	 */
	public String getLeyendaPrecioNormal() {
		return leyendaPrecioNormal;
	}

	/**
	 * @param leyendaPrecioNormal the leyendaPrecioNormal to set
	 */
	public void setLeyendaPrecioNormal(String leyendaPrecioNormal) {
		this.leyendaPrecioNormal = leyendaPrecioNormal;
	}

	/**
	 * @return the leyendaPrecioFinal
	 */
	public String getLeyendaPrecioFinal() {
		return leyendaPrecioFinal;
	}

	/**
	 * @param leyendaPrecioFinal the leyendaPrecioFinal to set
	 */
	public void setLeyendaPrecioFinal(String leyendaPrecioFinal) {
		this.leyendaPrecioFinal = leyendaPrecioFinal;
	}

	/**
	 * @return the leyendaDescuento
	 */
	public String getLeyendaDescuento() {
		return leyendaDescuento;
	}

	/**
	 * @param leyendaDescuento the leyendaDescuento to set
	 */
	public void setLeyendaDescuento(String leyendaDescuento) {
		this.leyendaDescuento = leyendaDescuento;
	}

	/**
	 * @param valorDescuento the valorDescuento to set
	 */
	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	/**
	 * @param precioNormalAfiliado the precioNormalAfiliado to set
	 */
	public void setPrecioNormalAfiliado(Double precioNormalAfiliado) {
		this.precioNormalAfiliado = precioNormalAfiliado;
	}

	/**
	 * @param precioFinalConCupon the precioFinalConCupon to set
	 */
	public void setPrecioFinalConCupon(Double precioFinalConCupon) {
		this.precioFinalConCupon = precioFinalConCupon;
	}

	/**
	 * @return the precioNormalAfiliado
	 */
	public Double getPrecioNormalAfiliado() {
		return precioNormalAfiliado;
	}

	/**
	 * @return the precioFinalConCupon
	 */
	public Double getPrecioFinalConCupon() {
		return precioFinalConCupon;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
}