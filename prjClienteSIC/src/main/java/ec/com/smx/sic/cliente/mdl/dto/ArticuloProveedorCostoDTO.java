package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProveedorCostoID;


/**
 * Entidad que almacena los datos de referencia de un articulo vs proveedor-clasificacion
 * 
 * @author adgonzalez
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTARTPROCOS")
public class ArticuloProveedorCostoDTO extends SimpleAuditDTO{

	@EmbeddedId
	private ArticuloProveedorCostoID id = new ArticuloProveedorCostoID();
	
	/**
	 * Valor del costo
	 */
	private Double valor;
	
	/**
	 * Valor del costo
	 */
	private Double valorAnterior;
	
	/**
	 * Estado del registro
	 */
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Usuario que registro el costo
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;
	
	/**
	 * Fecha de registro del costo
	 */
	@RegisterDateField
	@Column(updatable=false)
	private Timestamp fechaRegistro;
	/**
	 * Usuario que modifico el registro
	 */
	@LastModifierUserIdField
	@Column(insertable=false)
	private String idUsuarioModificacion;
	/**
	 * Fecha que se modifico el registro
	 */
	@LastModificationDateField
	@Column(insertable=false)
	private Timestamp fechaModificacion;
		
	@ManyToOne(fetch=LAZY)
	@JoinColumns({
		@JoinColumn(name="VALORTIPOCOSTO",insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOVALOR"),		
		@JoinColumn(name="CODIGOTIPOCOSTO",insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")}
			)
	private CatalogoValorDTO tipoCostoProveedor;
	
	@ManyToOne(fetch=LAZY)
	@JoinColumns({	
		@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", insertable=false, updatable=false, referencedColumnName="CODIGOARTICULO"),
		@JoinColumn(name="CODIGOPROVEEDOR", insertable=false, updatable=false, referencedColumnName="CODIGOPROVEEDOR")})
	private ArticuloProveedorDTO articuloProveedor;

	@Transient
	private Double costoNeto;
	
	@Transient
	private Double costoNetoProyectado;
	
	/* Getters and Setters*/	
	/**
	 * Retorna el valor de la propiedad id
	 * 
	 */
	public ArticuloProveedorCostoID getId() {
		return id;
	}
	/**
	 * Establece el valor de la propiedad id
	 * @param id
	 */
	public void setId(ArticuloProveedorCostoID id) {
		this.id = id;
	}
	/**
	 * Retorna el valor de la propiedad valor
	 * 
	 */
	public Double getValor() {
		if(valor == null || valor == 0){
			valor = articuloProveedor.getCostoBruto();
			setValor(valor);
		}
		else{
			setValor(valor);
		}
		return valor;
	}
	/**
	 * Establece el valor de la propiedad valor
	 * @param valor
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}	
	/**
	 * Retorna el valor de la propiedad valorAnterior
	 * @return
	 */
	public Double getValorAnterior() {
		return valorAnterior;
	}
	/**
	 * Establece el valor de la propiedad valorAnterior
	 * @param valorAnterior
	 */
	public void setValorAnterior(Double valorAnterior) {
		this.valorAnterior = valorAnterior;
	}
	/**
	 * Retorna el valor de la propiedad estado
	 * @return
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * Establece el valor de la propiedad estado
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * Retorna el valor de la propiedad idUsuarioRegistro
	 * @return
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}
	/**
	 * Establece el valor de la propiedad idUsuarioRegistro
	 * @param idUsuarioRegistro
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}
	/**
	 * Retorna el valor de la propiedad fechaRegistro
	 * @return
	 */
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * Establece el valor de la propiedad fechaRegistro
	 * @param fechaRegistro
	 */
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	/**
	 * Retorna el valor de la propiedad idUsuarioModificacion
	 * @return
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}
	/**
	 * Establece el valor de la propiedad idUsuarioModificacion
	 * @param idUsuarioModificacion
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}
	/**
	 * Retorna el valor de la propiedad fechaModificacion
	 * @return
	 */
	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * Establece el valor de la propiedad idUsuarioModificacio
	 * @param fechaModificacion
	 */
	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * Retorna el valor de la propiedad tipoCostoProveedor
	 * @return
	 */
	public CatalogoValorDTO getTipoCostoProveedor() {
		return tipoCostoProveedor;
	}
	/**
	 * Establece el valor de la propiedad tipoCostoProveedor
	 * @param tipoCostoProveedor
	 */
	public void setTipoCostoProveedor(CatalogoValorDTO tipoCostoProveedor) {
		this.tipoCostoProveedor = tipoCostoProveedor;
	}
	/**
	 * Retorna el valor de la propiedad articuloProveedor
	 * @return
	 */
	public ArticuloProveedorDTO getArticuloProveedor() {
		return articuloProveedor;
	}
	/**
	 * Establece el valor de la propiedad articuloProveedor
	 * @param articuloProveedor
	 */
	public void setArticuloProveedor(ArticuloProveedorDTO articuloProveedor) {
		this.articuloProveedor = articuloProveedor;
	}
	/**
	 * @return the costoNeto
	 */
	public Double getCostoNeto(String valorTipoCosto) {
		if(valorTipoCosto.equals("CP1")){
			costoNeto = articuloProveedor.getCostoNetoProyectado1();
		}else{
			costoNeto = articuloProveedor.getCostoNetoProyectado2();
		}
		return costoNeto;
	}
	public void setCostoNeto(Double costoNeto) {
		this.costoNeto = costoNeto;
	}
	public Double getCostoNetoProyectado() {
		return costoNetoProyectado;
	}
	/**
	 * 
	 * @param costoNetoProyectado
	 */
	public void setCostoNetoProyectado(Double costoNetoProyectado) {
		this.costoNetoProyectado = costoNetoProyectado;
	}
	
	
	/*Verificadores*/
	
	public Boolean getTieneArticuloProveedor(){
		return isLoaded(articuloProveedor);
	}
	
}
