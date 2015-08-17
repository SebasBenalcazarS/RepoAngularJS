package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloUnidadManejoID;

@SuppressWarnings("serial")
@Entity
public class VistaArticuloUnidadManejoDTO implements Serializable{
	@EmbeddedId
	VistaArticuloUnidadManejoID id = new VistaArticuloUnidadManejoID();
	
	private String codigoBarrasArticulo;
	private String descripcionArticulo;	
	
	private String codigoBarrasUnidadManejo;
	private Integer valorUnidadManejo;
	private String valorTipoUnidadEmpaque;	
	
	/**
	 * Descripción de la medida del artículo
	 * 
	 */
	private String referenciaMedida;
	
	/**
	 * codigo ordencompraDetalleEstado para saber que ela rticulo corresponde a este detalle
	 */
	private Long codigoOrdenCompraDetalleEstado;
	
	/**
	 * Campo que especifica la cantidad pedida de un articulo en la recepcion
	 */
	@Transient
	private Integer cantidadArticulo;
	
	/**
	 * Campo que especifica el peso pedido de un articulo en la recepcion
	 */
	@Transient
	private BigDecimal pesoArticulo;
		
	/**
	 * @return the codigoBarrasUnidadManejo
	 */
	public String getCodigoBarrasUnidadManejo() {
		return codigoBarrasUnidadManejo;
	}
	/**
	 * @param codigoBarrasUnidadManejo the codigoBarrasUnidadManejo to set
	 */
	public void setCodigoBarrasUnidadManejo(String codigoBarrasUnidadManejo) {
		this.codigoBarrasUnidadManejo = codigoBarrasUnidadManejo;
	}
	
	/**
	 * @return the valorUnidadManejo
	 */
	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}
	/**
	 * @param valorUnidadManejo the valorUnidadManejo to set
	 */
	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}
	/**
	 * @return the valorTipoUnidadEmpaque
	 */
	public String getValorTipoUnidadEmpaque() {
		return valorTipoUnidadEmpaque;
	}
	/**
	 * @param valorTipoUnidadEmpaque the valorTipoUnidadEmpaque to set
	 */
	public void setValorTipoUnidadEmpaque(String valorTipoUnidadEmpaque) {
		this.valorTipoUnidadEmpaque = valorTipoUnidadEmpaque;
	}
	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarrasArticulo() {
		return codigoBarrasArticulo;
	}
	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarrasArticulo(String codigoBarras) {
		this.codigoBarrasArticulo = codigoBarras;
	}
	
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
	public VistaArticuloUnidadManejoID getId() {
		return id;
	}
	public void setId(VistaArticuloUnidadManejoID id) {
		this.id = id;
	}
	/**
	 * @return the referenciaMedida
	 */
	public String getReferenciaMedida() {
		return referenciaMedida;
	}
	/**
	 * @param referenciaMedida the referenciaMedida to set
	 */
	public void setReferenciaMedida(String referenciaMedida) {
		this.referenciaMedida = referenciaMedida;
	}
	/**
	 * @return the codigoOrdenCompraDetalleEstado
	 */
	public Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}
	/**
	 * @param codigoOrdenCompraDetalleEstado the codigoOrdenCompraDetalleEstado to set
	 */
	public void setCodigoOrdenCompraDetalleEstado(Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
	}
	/**
	 * @return the cantidadArticulo
	 */
	public Integer getCantidadArticulo() {
		return cantidadArticulo;
	}
	/**
	 * @param cantidadArticulo the cantidadArticulo to set
	 */
	public void setCantidadArticulo(Integer cantidadArticulo) {
		this.cantidadArticulo = cantidadArticulo;
	}
	/**
	 * @return the pesoArticulo
	 */
	public BigDecimal getPesoArticulo() {
		return pesoArticulo;
	}
	/**
	 * @param pesoArticulo the pesoArticulo to set
	 */
	public void setPesoArticulo(BigDecimal pesoArticulo) {
		this.pesoArticulo = pesoArticulo;
	}
	
}

