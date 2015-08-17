/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaPedidoID;

/**
 * @author
 * 
 */
@Entity
@SuppressWarnings("serial")
public class VistaPedidoDTO extends SearchDTO {
	
	@EmbeddedId
	private VistaPedidoID id = new VistaPedidoID();
	
	private Long numeroPedido;

	private String codigoProveedor;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEntrega;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCaducidad;

	private Integer codigoAreaTrabajoPedido;

	private String codigoSubbodega;
	
	private String estado;
	
	private String codigoTipoPedidoCatVal;
	
	private Integer codigoTipoPedidoCatTip;
	
	private String nombreCatalogoValor;

	/**
	 * @return the id
	 */
	public VistaPedidoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaPedidoID id) {
		this.id = id;
	}

	/**
	 * @return the numeroPedido
	 */
	public Long getNumeroPedido() {
		return numeroPedido;
	}

	/**
	 * @param numeroPedido the numeroPedido to set
	 */
	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
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
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * @return the fechaCaducidad
	 */
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	/**
	 * @param fechaCaducidad the fechaCaducidad to set
	 */
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	/**
	 * @return the codigoAreaTrabajoPedido
	 */
	public Integer getCodigoAreaTrabajoPedido() {
		return codigoAreaTrabajoPedido;
	}

	/**
	 * @param codigoAreaTrabajoPedido the codigoAreaTrabajoPedido to set
	 */
	public void setCodigoAreaTrabajoPedido(Integer codigoAreaTrabajoPedido) {
		this.codigoAreaTrabajoPedido = codigoAreaTrabajoPedido;
	}

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
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the codigoTipoPedidoCatVal
	 */
	public String getCodigoTipoPedidoCatVal() {
		return codigoTipoPedidoCatVal;
	}

	/**
	 * @param codigoTipoPedidoCatVal the codigoTipoPedidoCatVal to set
	 */
	public void setCodigoTipoPedidoCatVal(String codigoTipoPedidoCatVal) {
		this.codigoTipoPedidoCatVal = codigoTipoPedidoCatVal;
	}

	/**
	 * @return the codigoTipoPedidoCatTip
	 */
	public Integer getCodigoTipoPedidoCatTip() {
		return codigoTipoPedidoCatTip;
	}

	/**
	 * @param codigoTipoPedidoCatTip the codigoTipoPedidoCatTip to set
	 */
	public void setCodigoTipoPedidoCatTip(Integer codigoTipoPedidoCatTip) {
		this.codigoTipoPedidoCatTip = codigoTipoPedidoCatTip;
	}

	/**
	 * @return the nombreCatalogoValor
	 */
	public String getNombreCatalogoValor() {
		return nombreCatalogoValor;
	}

	/**
	 * @param nombreCatalogoValor the nombreCatalogoValor to set
	 */
	public void setNombreCatalogoValor(String nombreCatalogoValor) {
		this.nombreCatalogoValor = nombreCatalogoValor;
	}

}
