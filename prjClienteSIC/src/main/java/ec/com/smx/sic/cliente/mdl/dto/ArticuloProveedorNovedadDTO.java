/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProveedorNovedadID;

/**
 * @author fmunoz
 *
 */
@Entity
@Table(name="SCARTTARTPRONOV")
@SuppressWarnings("serial")
public class ArticuloProveedorNovedadDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ArticuloProveedorNovedadID id = new ArticuloProveedorNovedadID();
	@ComparatorTypeField
	private String codigoArticulo;
	private String codigoProveedor;
	@ComparatorTypeField
	private String valorTipoNovedad;
	private Integer codigoTipoNovedad;
	@ComparatorTypeField
	private String valorEstadoNovedad;
	private Integer codigoEstadoNovedad;
	@ComparatorTypeField
	private String estado;
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
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizó la última actualización.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	@Transient
	private String referenciaProveedor;
	@Transient
	private String codigoBarras;

	/**
	 * Entidad que representa al articulo
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),	
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)
	})
	private ArticuloProveedorDTO articuloProveedor;
	
	@OneToMany(mappedBy = "articuloProveedorNovedad")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloProveedorNovedadReferenciaDTO> referencias;
	
	/**
	 * @return the id
	 */
	public ArticuloProveedorNovedadID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloProveedorNovedadID id) {
		this.id = id;
	}

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return the valorTipoNovedad
	 */
	public String getValorTipoNovedad() {
		return valorTipoNovedad;
	}

	/**
	 * @param valorTipoNovedad the valorTipoNovedad to set
	 */
	public void setValorTipoNovedad(String valorTipoNovedad) {
		this.valorTipoNovedad = valorTipoNovedad;
	}

	/**
	 * @return the valorEstadoNovedad
	 */
	public String getValorEstadoNovedad() {
		return valorEstadoNovedad;
	}

	/**
	 * @param valorEstadoNovedad the valorEstadoNovedad to set
	 */
	public void setValorEstadoNovedad(String valorEstadoNovedad) {
		this.valorEstadoNovedad = valorEstadoNovedad;
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
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the codigoTipoNovedad
	 */
	public Integer getCodigoTipoNovedad() {
		return codigoTipoNovedad;
	}

	/**
	 * @param codigoTipoNovedad the codigoTipoNovedad to set
	 */
	public void setCodigoTipoNovedad(Integer codigoTipoNovedad) {
		this.codigoTipoNovedad = codigoTipoNovedad;
	}

	/**
	 * @return the codigoEstadoNovedad
	 */
	public Integer getCodigoEstadoNovedad() {
		return codigoEstadoNovedad;
	}

	/**
	 * @param codigoEstadoNovedad the codigoEstadoNovedad to set
	 */
	public void setCodigoEstadoNovedad(Integer codigoEstadoNovedad) {
		this.codigoEstadoNovedad = codigoEstadoNovedad;
	}

	/**
	 * @return the articuloProveedor
	 */
	public ArticuloProveedorDTO getArticuloProveedor() {
		return articuloProveedor;
	}

	/**
	 * @param articuloProveedor the articuloProveedor to set
	 */
	public void setArticuloProveedor(ArticuloProveedorDTO articuloProveedor) {
		this.articuloProveedor = articuloProveedor;
	}

	/**
	 * @return the referencias
	 */
	public Collection<ArticuloProveedorNovedadReferenciaDTO> getReferencias() {
		return referencias;
	}

	/**
	 * @param referencias the referencias to set
	 */
	public void setReferencias(Collection<ArticuloProveedorNovedadReferenciaDTO> referencias) {
		this.referencias = referencias;
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
	 * @return the referenciaProveedor
	 */
	public String getReferenciaProveedor() {
		return referenciaProveedor;
	}

	/**
	 * @param referenciaProveedor the referenciaProveedor to set
	 */
	public void setReferenciaProveedor(String referenciaProveedor) {
		this.referenciaProveedor = referenciaProveedor;
	}

	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}

	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public Boolean getMostrarCodigoBarras() {
		if(this.articuloProveedor != null && SearchDTO.isLoaded(this.articuloProveedor)
				&& this.articuloProveedor.getArticulo() != null && SearchDTO.isLoaded(this.articuloProveedor.getArticulo())
				&& this.articuloProveedor.getArticulo().getCodigoBarrasActivo() != null){
			if(!this.articuloProveedor.getArticulo().getCodigoEstado().equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO) ||
					(this.articuloProveedor.getArticulo().getCodigoEstado().equals(SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO) &&
						(StringUtils.equals(SICArticuloConstantes.getInstancia().TIPO_CODBAR_EAN, this.articuloProveedor.getArticulo().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo()) 
								|| StringUtils.equals(SICArticuloConstantes.getInstancia().TIPO_CODBAR_EAN128, this.articuloProveedor.getArticulo().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo())
								|| StringUtils.equals(SICArticuloConstantes.getInstancia().TIPO_CODBAR_EAN14, this.articuloProveedor.getArticulo().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo())))){
				
				return Boolean.TRUE;
			}
		}
			
		return Boolean.FALSE;
	}
	
}