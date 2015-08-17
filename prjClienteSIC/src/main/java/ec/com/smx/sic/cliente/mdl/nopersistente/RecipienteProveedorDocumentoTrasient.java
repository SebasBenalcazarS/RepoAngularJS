package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Transient;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;

/**
 * Busca todos los recipientes de la ultima fecha de entrega de un proveedor o por un numero de documento
 * @author amunoz
 *
 */
public class RecipienteProveedorDocumentoTrasient {

	@Id
	private String codigoBarras;
	private String codigoArticulo;
	private String descripcion;
	private Integer cantidadRecibida;
	//private Integer cantidaEntregada;
	private Integer cantidadAjuste;
	private String codigoCatalogoValorCausal;
	private String nombreCausal;
	private Long valorNumerico;
	private Integer cantidadTotalAnterior;
	private Long codigoControlRecipienteDetalle;
	private Date fechaRegistro;
	private String idUsuarioRegistro;
	
	
	@Transient
	private CatalogoValorDTO causalAjuste;

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidadRecibida() {
		return cantidadRecibida != null ? cantidadRecibida : 0;
	}

	public void setCantidadRecibida(Integer cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}
	public Integer getCantidadAjuste() {
		return cantidadAjuste != null ? cantidadAjuste : 0;
	}

	public void setCantidadAjuste(Integer cantidadAjuste) {
		this.cantidadAjuste = cantidadAjuste;
	}
	
	public void setCantidadTotal(Integer cantidadTotal) {
		setCantidadAjuste( Math.abs((cantidadTotal - getCantidadRecibida()) / getValorNumerico().intValue()));
	}
	
	public Integer getCantidadTotal() {
		return getCantidadRecibida() + (getCantidadAjuste() * getValorNumerico().intValue());
	}

	public Long getValorNumerico() {
		return valorNumerico != null ? valorNumerico : 1;
	}

	public void setValorNumerico(Long valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public String getNombreCausal() {
		return nombreCausal;
	}

	public void setNombreCausal(String nombreCausal) {
		this.nombreCausal = nombreCausal;
	}

	public String getCodigoCatalogoValorCausal() {
		return codigoCatalogoValorCausal;
	}

	public void setCodigoCatalogoValorCausal(String codigoCatalogoValorCausal) {
		this.codigoCatalogoValorCausal = codigoCatalogoValorCausal;
	}

	public CatalogoValorDTO getCausalAjuste() {
		return causalAjuste;
	}

	public void setCausalAjuste(CatalogoValorDTO causalAjuste) {
		this.causalAjuste = causalAjuste;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	

	public Long getCodigoControlRecipienteDetalle() {
		return codigoControlRecipienteDetalle;
	}

	public void setCodigoControlRecipienteDetalle(Long codigoControlRecipienteDetalle) {
		this.codigoControlRecipienteDetalle = codigoControlRecipienteDetalle;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public Integer getCantidadTotalAnterior() {
		return cantidadTotalAnterior;
	}

	public void setCantidadTotalAnterior(Integer cantidadTotalAnterior) {
		this.cantidadTotalAnterior = cantidadTotalAnterior;
	}
	
}
