package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.BitacoraDescuentoOrdenCompraID;

/**
 * Clase DTO  para registro de los descuentos en ordenes de compra  para el modulo Convenio Proveedores
 * 
 * @author aquingaluisa
 * 2015-04-17
*/


@Entity
@Table(name = "SCCEMTBITDESCORDCOM")
public class BitacoraDescuentoOrdenCompraDTO extends SearchDTO implements Serializable{
	/**
	 * Clave primaria de la tabla Convenio participante
	 */
	private static final long serialVersionUID = 7863262235394607247L;
	
	@EmbeddedId
	private BitacoraDescuentoOrdenCompraID id = new BitacoraDescuentoOrdenCompraID();
	
	@Transient
	//@Column(name = "CODIGOVALORFORMACOBRO")
	private String codigoValorFormaCobro;
	
	
	@Column(name = "CODIGONEGOCIACION")
	private Integer codigoNegociacion;
	
	@Column(name = "CODIGOPROVEEDOR")
	private String codigoProveedor;
	
	@Column(name = "CODIGOJDEPROVEEDOR")
	private Integer codigoJDEProveedor;
	
	@Column(name = "CODIGOORDENCOMPRA")
	private Long codigoOrdenCompra;
	
	@Column(name = "NUMEROORDENCOMPRA")
	private String numeroOrdenCompra;
	
	@Column(name = "CODIGOUNIDADMANEJO")
	private Long codigoUnidadManejo;
	
	@Column(name = "VALORUNIDADMANEJO")
	private Integer valorUnidadManejo;
	
	@Column(name = "CODIGOTIPOUNIDADEMPAQUE")
	private Integer codigoTipoUnidadEmpaque;
	
	@Column(name = "VALORTIPOUNIDADEMPAQUE")
	private String valorTipoUnidadEmpaque;
	
	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo;
	
	@Column(name = "CODIGOBARRASARTICULO")
	private String codigoBarrasArticulo;
	
	@Column(name = "FECHAREGISTRO")
	private Date fechaRegistro ;
	
	@Column(name = "FECHAMODIFICACION")
	private Date fechaModificacion ;
	
	@Column(name = "ESTADO")
	private Boolean estado ;
	
	@Column(name = "IDUSUARIOREGISTRO")
	private String idUsarioRegistro;
	
	@Column(name = "IDUSUARIOMODIFICACION")
	private String idUsuarioModificacion;

	public BitacoraDescuentoOrdenCompraID getId() {
		return id;
	}

	public void setId(BitacoraDescuentoOrdenCompraID id) {
		this.id = id;
	}

	public String getCodigoValorFormaCobro() {
		return codigoValorFormaCobro;
	}

	public void setCodigoValorFormaCobro(String codigoValorFormaCobro) {
		this.codigoValorFormaCobro = codigoValorFormaCobro;
	}

	public Integer getCodigoNegociacion() {
		return codigoNegociacion;
	}

	public void setCodigoNegociacion(Integer codigoNegociacion) {
		this.codigoNegociacion = codigoNegociacion;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public Integer getCodigoJDEProveedor() {
		return codigoJDEProveedor;
	}

	public void setCodigoJDEProveedor(Integer codigoJDEProveedor) {
		this.codigoJDEProveedor = codigoJDEProveedor;
	}

	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}

	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}

	public String getNumeroOrdenCompra() {
		return numeroOrdenCompra;
	}

	public void setNumeroOrdenCompra(String numeroOrdenCompra) {
		this.numeroOrdenCompra = numeroOrdenCompra;
	}

	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}

	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}

	public Integer getCodigoTipoUnidadEmpaque() {
		return codigoTipoUnidadEmpaque;
	}

	public void setCodigoTipoUnidadEmpaque(Integer codigoTipoUnidadEmpaque) {
		this.codigoTipoUnidadEmpaque = codigoTipoUnidadEmpaque;
	}

	public String getValorTipoUnidadEmpaque() {
		return valorTipoUnidadEmpaque;
	}

	public void setValorTipoUnidadEmpaque(String valorTipoUnidadEmpaque) {
		this.valorTipoUnidadEmpaque = valorTipoUnidadEmpaque;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getCodigoBarrasArticulo() {
		return codigoBarrasArticulo;
	}

	public void setCodigoBarrasArticulo(String codigoBarrasArticulo) {
		this.codigoBarrasArticulo = codigoBarrasArticulo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getIdUsarioRegistro() {
		return idUsarioRegistro;
	}

	public void setIdUsarioRegistro(String idUsarioRegistro) {
		this.idUsarioRegistro = idUsarioRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}
}
