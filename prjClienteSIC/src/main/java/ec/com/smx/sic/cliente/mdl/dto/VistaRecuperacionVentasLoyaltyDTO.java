package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import ec.com.smx.sic.cliente.common.convenio.ConveniosConstantes;


/**
 * @author srodriguez 
 * 2014-11-29
 */
@Entity
@SuppressWarnings("serial")
public class VistaRecuperacionVentasLoyaltyDTO implements Serializable{
	
	@Id
	private Integer id;
	
	private Long campania;
	
	private Long promocion;
	
	private String articulo;
	
	private BigDecimal descuento;
	
	private BigDecimal precio;
	
	private BigDecimal cantidad;
	
	private BigDecimal totalProductos;
	
	private String local;
	
	private String tipo;
	

	/* Metodo que retorna id del objeto
	 * @author srodriguez
	 * 19/11/2014
	 * @return Integer id 
	 */
	public Integer getId() {
		return id;
	}

	/* Metodo que asigna el id del objeto
	 * @author srodriguez
	 * 19/11/2014
	 * @param id parametro de tipo Integer
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/* Metodo que retorna articulo del objeto
	 * @author srodriguez
	 * 19/11/2014
	 * @return String articulo 
	 */
	public String getArticulo() {
		return articulo;
	}

	/* Metodo que asigna el articulo del objeto
	 * @author srodriguez
	 * 19/11/2014
	 * @param articulo parametro de tipo String
	 */
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	/* Metodo que retorna descuento del objeto
	 * @author srodriguez
	 * 19/11/2014
	 * @return BigDecimal descuento 
	 */
	public BigDecimal getDescuento() {
		return descuento;
	}

	/* Metodo que asigna el descuento del objeto
	 * @author srodriguez
	 * 19/11/2014
	 * @param descuento parametro de tipo BigDecimal
	 */
	public void setDescuento(BigDecimal descuento) {
		if(descuento == null){
			this.descuento = descuento;
		}
		else{
			this.descuento = descuento.setScale(ConveniosConstantes.NUMERO_DECIMALES_MONEDA,ConveniosConstantes.METODO_REDONDEO);
			
		}
	}

	/* Metodo que retorna campania del objeto
	 * @author srodriguez
	 * 26/11/2014
	 * @return Long campania 
	 */
	public Long getCampania() {
		return campania;
	}

	/* Metodo que asigna el campania del objeto
	 * @author srodriguez
	 * 26/11/2014
	 * @param campania parametro de tipo Long
	 */
	public void setCampania(Long campania) {
		this.campania = campania;
	}

	/* Metodo que retorna promocion del objeto
	 * @author srodriguez
	 * 26/11/2014
	 * @return Long promocion 
	 */
	public Long getPromocion() {
		return promocion;
	}

	/* Metodo que asigna el promocion del objeto
	 * @author srodriguez
	 * 26/11/2014
	 * @param promocion parametro de tipo Long
	 */
	public void setPromocion(Long promocion) {
		this.promocion = promocion;
	}

	/* Metodo que retorna cantidad del objeto
	 * @author srodriguez
	 * 29/11/2014
	 * @return BigDecimal cantidad 
	 */
	public BigDecimal getCantidad() {
		return cantidad;
	}

	/* Metodo que asigna el cantidad del objeto
	 * @author srodriguez
	 * 29/11/2014
	 * @param cantidad parametro de tipo BigDecimal
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the local
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * @param local the local to set
	 */
	public void setLocal(String local) {
		this.local = local;
	}

	/**
	 * @return the precio
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getTotalProductos() {
		return totalProductos;
	}

	public void setTotalProductos(BigDecimal totalProductos) {
		this.totalProductos = totalProductos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
