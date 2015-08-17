/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProveedorNovedadReferenciaID;

/**
 * @author fmunoz
 *
 */
@Entity
@Table(name="SCARTTARTPRONOVREF")
@SuppressWarnings("serial")
public class ArticuloProveedorNovedadReferenciaDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ArticuloProveedorNovedadReferenciaID id = new ArticuloProveedorNovedadReferenciaID();
	
	private String referenciaProveedor;
	private String codigoBarras;
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
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name="SECUENCIALNOVEDAD", referencedColumnName="SECUENCIAL", insertable=false, updatable=false)	
	})
	private ArticuloProveedorNovedadDTO articuloProveedorNovedad;

	/**
	 * @return the id
	 */
	public ArticuloProveedorNovedadReferenciaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloProveedorNovedadReferenciaID id) {
		this.id = id;
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
	 * @return the articuloProveedorNovedad
	 */
	public ArticuloProveedorNovedadDTO getArticuloProveedorNovedad() {
		return articuloProveedorNovedad;
	}

	/**
	 * @param articuloProveedorNovedad the articuloProveedorNovedad to set
	 */
	public void setArticuloProveedorNovedad(ArticuloProveedorNovedadDTO articuloProveedorNovedad) {
		this.articuloProveedorNovedad = articuloProveedorNovedad;
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