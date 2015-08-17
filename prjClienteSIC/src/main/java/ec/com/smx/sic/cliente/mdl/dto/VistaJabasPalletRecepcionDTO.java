/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaJabasPalletRecepcionID;

/**
 * @author jdvasquez
 *
 */
@Entity
public class VistaJabasPalletRecepcionDTO {
	
	@EmbeddedId
	private VistaJabasPalletRecepcionID id = new VistaJabasPalletRecepcionID();
	
	private Long secuencialRecipienteTara;
//	private Long codigoControlRecipienteDetalleTara; // se movio al id
	private Long codigoDatosTarea;
//	private String descripcion;
	private BigDecimal valorTara;
	private String tipo;
	
	// campos ControlRecipienteTaraDetalleDTO
	private Long cantidad;
	
	private String leyendaArticulo;
	private String descripcionTara;
	
//	private Long totalTara;
	
	@Transient
	private Integer conteoJabas;

	/**
	 * @return the id
	 */
	public VistaJabasPalletRecepcionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaJabasPalletRecepcionID id) {
		this.id = id;
	}

	/**
	 * @return the secuencialRecipienteTara
	 */
	public Long getSecuencialRecipienteTara() {
		return secuencialRecipienteTara;
	}

	/**
	 * @param secuencialRecipienteTara the secuencialRecipienteTara to set
	 */
	public void setSecuencialRecipienteTara(Long secuencialRecipienteTara) {
		this.secuencialRecipienteTara = secuencialRecipienteTara;
	}

	/**
	 * @return the codigoDatosTarea
	 */
	public Long getCodigoDatosTarea() {
		return codigoDatosTarea;
	}

	/**
	 * @param codigoDatosTarea the codigoDatosTarea to set
	 */
	public void setCodigoDatosTarea(Long codigoDatosTarea) {
		this.codigoDatosTarea = codigoDatosTarea;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.leyendaArticulo.concat(" "+this.descripcionTara);
	}

//	/**
//	 * @param descripcion the descripcion to set
//	 */
//	public void setDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//	}

	/**
	 * @return the valorTara
	 */
	public BigDecimal getValorTara() {
		return valorTara;
	}

	/**
	 * @param valorTara the valorTara to set
	 */
	public void setValorTara(BigDecimal valorTara) {
		this.valorTara = valorTara;
	}

	/**
	 * @return the conteoJabas
	 */
	public Integer getConteoJabas() {
		return conteoJabas;
	}

	/**
	 * @param conteoJabas the conteoJabas to set
	 */
	public void setConteoJabas(Integer conteoJabas) {
		this.conteoJabas = conteoJabas;
	}
	
//	/**
//	 * @return the codigoControlRecipienteDetalleTara
//	 */
//	public Long getCodigoControlRecipienteDetalleTara() {
//		return codigoControlRecipienteDetalleTara;
//	}
//
//	/**
//	 * @param codigoControlRecipienteDetalleTara the codigoControlRecipienteDetalleTara to set
//	 */
//	public void setCodigoControlRecipienteDetalleTara(Long codigoControlRecipienteDetalleTara) {
//		this.codigoControlRecipienteDetalleTara = codigoControlRecipienteDetalleTara;
//	}

//	/**
//	 * @return the totalTara
//	 */
//	public BigDecimal getTotalTara() {
//		return totalTara;
//	}
//
//	/**
//	 * @param totalTara the totalTara to set
//	 */
//	public void setTotalTara(BigDecimal totalTara) {
//		this.totalTara = totalTara;
//	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the cantidad
	 */
	public Long getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}	

	/**
	 * @return the leyendaArticulo
	 */
	public String getLeyendaArticulo() {
		return leyendaArticulo;
	}

	/**
	 * @param leyenda the leyendaArticulo to set
	 */
	public void setLeyendaArticulo(String leyendaArticulo) {
		this.leyendaArticulo = leyendaArticulo;
	}

	/**
	 * @return the descripcionTara
	 */
	public String getDescripcionTara() {
		return descripcionTara;
	}

	/**
	 * @param descripcionTara the descripcionTara to set
	 */
	public void setDescripcionTara(String descripcionTara) {
		this.descripcionTara = descripcionTara;
	}

	/**
	 * @return the totalTara
	 */
	public BigDecimal getTotalTara() {
		
		if (this.valorTara == null || this.cantidad == null) {
			return BigDecimal.ZERO;
		} else {
			return this.valorTara.multiply(new BigDecimal(this.cantidad)); //BigDecimal.valueOf(this.valorTara.longValue() * this.cantidad.longValue());
		}
		
	}
	
}
