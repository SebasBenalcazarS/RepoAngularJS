package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICUtil;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloRelacionID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.ContenedorArticulo;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloRelacionTransient;

/**
 * Contiene las relaciones entre los diferentes art�culos, por ejemplo CANASTO-ITEM
 * 
 * @author amunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCSADTARTREL")
public class ArticuloRelacionDTO extends ArticuloRelacionTransient implements ContenedorArticulo{

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloRelacionID id;

	
	
	public ArticuloRelacionDTO(){
		this.id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloRelacionID();
	}
	
	public ArticuloRelacionDTO(Boolean initID){
		this.id = new ArticuloRelacionID(initID);
	}

	/**
	 * Indica las veces que aparece el codigoArticuloRelacionado en el codigoArticulo
	 * 
	 */
	private Integer cantidad;

	/**
	 * C�digo del tipo de relaci�n entre los art�culos
	 * 
	 */
	private Integer codigoTipoRelacion;

	/**
	 * Valor del tipo de relaci�n entre los art�culos
	 * 
	 */
	@ComparatorTypeField
	private String valorTipoRelacion;
	
	/**
	 * C�digo del tipo de participacion 
	 * 
	 */
	private Integer codigoParticipacion;

	/**
	 * Valor del tipo de participacion 
	 * 
	 */
	@ComparatorTypeField
	private String valorParticipacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	/**
	 * Estado del art�culo relacion, puede tener los valores: [1] Activo, [0] Inactivo
	 */
	@ComparatorTypeField
	private String estado;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false) })
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
			@JoinColumn(name = "CODIGOARTICULORELACIONADO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false) })
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articuloRelacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "VALORTIPORELACION", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOVALOR"),
			@JoinColumn(name = "CODIGOTIPORELACION", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false) })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoRelacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "VALORPARTICIPACION", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOVALOR"),
			@JoinColumn(name = "CODIGOPARTICIPACION", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false) })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoParticipacion;

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloRelacionID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloRelacionID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>cantidad</code>
	 * 
	 * @return Retorna valor de propiedad <code>cantidad</code>
	 */
	public Integer getCantidad() {
		return this.cantidad;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cantidad</code>.
	 * 
	 * @param cantidad1
	 *            El valor a establecer para la propiedad <code>cantidad</code>.
	 */
	public void setCantidad(Integer cantidad1) {
		this.cantidad = cantidad1;

	}

	/**
	 * Retorna valor de propiedad <code>codigoTipoRelacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoTipoRelacion</code>
	 */
	public Integer getCodigoTipoRelacion() {
		return this.codigoTipoRelacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoRelacion</code>.
	 * 
	 * @param codigoTipoRelacion1
	 *            El valor a establecer para la propiedad <code>codigoTipoRelacion</code>.
	 */
	public void setCodigoTipoRelacion(Integer codigoTipoRelacion1) {
		this.codigoTipoRelacion = codigoTipoRelacion1;

	}

	/**
	 * Retorna valor de propiedad <code>valorTipoRelacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>valorTipoRelacion</code>
	 */
	public String getValorTipoRelacion() {
		return this.valorTipoRelacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>valorTipoRelacion</code>.
	 * 
	 * @param valorTipoRelacion1
	 *            El valor a establecer para la propiedad <code>valorTipoRelacion</code>.
	 */
	public void setValorTipoRelacion(String valorTipoRelacion1) {
		this.valorTipoRelacion = valorTipoRelacion1;

		if (valorTipoRelacion != null && valorTipoRelacion.length() > 3) {
			valorTipoRelacion = valorTipoRelacion.substring(0, 3);
		}

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion() {
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

	}

	/**
	 * Retorna valor de propiedad <code>articulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>articulo</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticulo() {
		return this.articulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>articulo</code>.
	 * 
	 * @param articulo1
	 *            El valor a establecer para la propiedad <code>articulo</code>.
	 */
	public void setArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo1) {
		this.articulo = articulo1;
	}

	/**
	 * Retorna valor de propiedad <code>articuloRelacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>articuloRelacion</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticuloRelacion() {
		return this.articuloRelacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>articuloRelacion</code>.
	 * 
	 * @param articuloRelacion1
	 *            El valor a establecer para la propiedad <code>articuloRelacion</code>.
	 */
	public void setArticuloRelacion(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articuloRelacion1) {
		this.articuloRelacion = articuloRelacion1;
	}

	/**
	 * Retorna valor de propiedad <code>tipoRelacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>tipoRelacion</code>
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoRelacion() {
		return this.tipoRelacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tipoRelacion</code>.
	 * 
	 * @param tipoRelacion1
	 *            El valor a establecer para la propiedad <code>tipoRelacion</code>.
	 */
	public void setTipoRelacion(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoRelacion1) {
		this.tipoRelacion = tipoRelacion1;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = (estado != null && estado.length() > 1 )?estado.substring(0, 1):estado;
	}
	public Boolean getTieneArticuloRelacion(){
		return isLoaded(articuloRelacion);
	}	
	
	public Double getPrecioTotal(){
		if(getTieneArticuloRelacion()){
			Double totalprecio = this.articuloRelacion.getPrecioBase() * this.cantidad;
			return SICUtil.getInstance().roundNumber(totalprecio, SICConstantes.getInstancia().CANTIDADDECIMALFINAL);
		}
		return null;		
	}
	
	public Double getPrecioTotalIMP(){
		if(getTieneArticuloRelacion()){
			Double totalprecio = this.articuloRelacion.getPrecioBaseImp() * this.cantidad;
			return SICUtil.getInstance().roundNumber(totalprecio, SICConstantes.getInstancia().CANTIDADDECIMALFINAL);
		}
		return null;
	}

	@Override
	public ArticuloDTO getArticuloContenido() {
		return articuloRelacion;
	}

	public Integer getCodigoParticipacion() {
		return codigoParticipacion;
	}

	public void setCodigoParticipacion(Integer codigoParticipacion) {
		this.codigoParticipacion = codigoParticipacion;
	}

	public String getValorParticipacion() {
		return valorParticipacion;
	}

	public void setValorParticipacion(String valorParticipacion) {
		this.valorParticipacion = valorParticipacion;
	}

	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoParticipacion() {
		return tipoParticipacion;
	}

	public void setTipoParticipacion(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoParticipacion) {
		this.tipoParticipacion = tipoParticipacion;
	}	
}
