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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAplicacionDescuento;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAsignacionDescuento;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloUnidadManejoProveedorID;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTUNIMANPRO")
public class ArticuloUnidadManejoProveedorDTO extends SimpleAuditDTO{
	
	public static final String COSTO_NETO_PARCIAL = "cnp";
	
	@EmbeddedId
	private ArticuloUnidadManejoProveedorID id = new ArticuloUnidadManejoProveedorID();
	/**
	 * C&oacute;digo de art&iacute;culo, almacena el c&oacute;digo secuencial de un art&iacute;culo
	 */
	@Column(name="CODIGOARTICULO")
	@ComparatorTypeField
	private String codigoArticulo;
	
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(insertable=true, updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column(insertable=true, updatable=false)
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOUNIDADMANEJO", referencedColumnName="CODIGOUNIDADMANEJO", insertable=false, updatable=false)})
	private ArticuloUnidadManejoDTO articuloUnidadManejoDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private ArticuloProveedorDTO articuloProveedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)})
	private VistaProveedorDTO vistaProveedorDTO;
	
	@OneToMany(mappedBy="articuloUnidadManejoProveedor")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloUnidadManejoProveedorEquivalenciaDTO> articuloUnidadManejoProveedorEquivalenciaCol;
		
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="SCARTTARTUNIMANPROEQU", joinColumns = {
			@JoinColumn(name = "CODIGOCOMPANIAARTUNIMANPRO", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false ),
			@JoinColumn(name="CODIGOUNIDADMANEJO", referencedColumnName="CODIGOUNIDADMANEJO", insertable=false, updatable=false),
			@JoinColumn(name="CODIGOPROVEEDOR", referencedColumnName="CODIGOPROVEEDOR", insertable=false, updatable=false)	
			},
		inverseJoinColumns = {
		@JoinColumn(name="CODIGOCOMPANIAEQUPORDES", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOEQUIVALENCIA", insertable=false, updatable=false, referencedColumnName="CODIGOEQUIVALENCIA")
		})
	private Collection<EquivalenciaPorcentajeDescuentoDTO> equivalenciaPorcentajeDescuentoCol;
	
	@Transient
	private String proveedorTipoValorUnidadManejo; //variable usada en Historial de cambios
	
	@Transient
	private EquivalenciaPorcentajeDescuentoDTO equivalenciaPorcentajeDescuentoDTO;
	
	@Transient
	private EquivalenciaPorcentajeDescuentoDTO equivalenciaPorcentajeDescuentoPromocionDTO;


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

	public ArticuloUnidadManejoProveedorID getId() {
		return id;
	}

	public void setId(ArticuloUnidadManejoProveedorID id) {
		this.id = id;
	}

	public ArticuloUnidadManejoDTO getArticuloUnidadManejoDTO() {
		return articuloUnidadManejoDTO;
	}

	public void setArticuloUnidadManejoDTO(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) {
		this.articuloUnidadManejoDTO = articuloUnidadManejoDTO;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getTieneEquivalenciaPorcentajeDescuento(){
		return isLoaded(getEquivalenciaPorcentajeDescuentoDTO());
	}
	public Boolean getTieneArticuloProveedor(){
		return isLoaded(articuloProveedor);
	}
	public Boolean getTieneArticuloUnidadManejo(){
		return isLoaded(articuloUnidadManejoDTO);
	}

	public VistaProveedorDTO getVistaProveedorDTO() {
		return vistaProveedorDTO;
	}

	public void setVistaProveedorDTO(VistaProveedorDTO vistaProveedorDTO) {
		this.vistaProveedorDTO = vistaProveedorDTO;
	}
	
	public String getProveedorTipoValorUnidadManejo() {
		this.proveedorTipoValorUnidadManejo = this.articuloProveedor.getVistaProveedor().getNombreProveedor().concat("-").concat(this.articuloUnidadManejoDTO.getNombreValorUnidadManejo());
		//.concat(this.articuloUnidadManejoDTO.getTipoUnidadEmpaque().getNombreCatalogoValor()).concat("/").concat(this.articuloUnidadManejoDTO.getValorUnidadManejo().toString());
		return proveedorTipoValorUnidadManejo;
	}

	public void setProveedorTipoValorUnidadManejo(String proveedorTipoValorUnidadManejo) {
		this.proveedorTipoValorUnidadManejo = this.articuloProveedor.getVistaProveedor().getNombreProveedor().concat("-").concat(this.articuloUnidadManejoDTO.getNombreValorUnidadManejo());
		//.concat(this.articuloUnidadManejoDTO.getTipoUnidadEmpaque().getNombreCatalogoValor()).concat("/").concat(this.articuloUnidadManejoDTO.getValorUnidadManejo().toString());
	}

	/**
	 * @return the equivalenciaPorcentajeDescuentoCol
	 */
	public Collection<EquivalenciaPorcentajeDescuentoDTO> getEquivalenciaPorcentajeDescuentoCol() {
		return equivalenciaPorcentajeDescuentoCol;
	}

	/**
	 * @param equivalenciaPorcentajeDescuentoCol the equivalenciaPorcentajeDescuentoCol to set
	 */
	public void setEquivalenciaPorcentajeDescuentoCol(Collection<EquivalenciaPorcentajeDescuentoDTO> equivalenciaPorcentajeDescuentoCol) {
		this.equivalenciaPorcentajeDescuentoCol = equivalenciaPorcentajeDescuentoCol;
	}


	/**
	 * @return the equivalenciaPorcentajeDescuentoDTO
	 */
	public EquivalenciaPorcentajeDescuentoDTO getEquivalenciaPorcentajeDescuentoDTO() {

		if (this.equivalenciaPorcentajeDescuentoDTO == null && CollectionUtils.isNotEmpty(this.equivalenciaPorcentajeDescuentoCol)) {
				
			for(EquivalenciaPorcentajeDescuentoDTO porcentajeDescuentoDTO : this.equivalenciaPorcentajeDescuentoCol) {
				
				if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(porcentajeDescuentoDTO.getEstado())
						&& EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO.equals(porcentajeDescuentoDTO.getAsignacionTipoDescuento().getCodigoAsignacionTipoDescuento())
						&& EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento().equals(porcentajeDescuentoDTO.getAsignacionTipoDescuento().getValorAsignacionTipoDescuento())
						&& EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO.equals(porcentajeDescuentoDTO.getAsignacionTipoDescuento().getCodigoAplicacionTipoDescuento())
						&& EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento().equals(porcentajeDescuentoDTO.getAsignacionTipoDescuento().getValorAplicacionTipoDescuento())) {

					this.equivalenciaPorcentajeDescuentoDTO = porcentajeDescuentoDTO;
					break;
				}

			}

			// crea las propiedades dinamicas de los codigos para la inactivacion de la equivalencia
			if(	equivalenciaPorcentajeDescuentoDTO != null && !equivalenciaPorcentajeDescuentoDTO.hasDynamicProperty("codigoEquivalencia") && !equivalenciaPorcentajeDescuentoDTO.hasDynamicProperty("codigoTipoDescuento") ) {
				equivalenciaPorcentajeDescuentoDTO.addDynamicProperty("codigoEquivalencia", equivalenciaPorcentajeDescuentoDTO.getId().getCodigoEquivalencia());
				equivalenciaPorcentajeDescuentoDTO.addDynamicProperty("codigoTipoDescuento", equivalenciaPorcentajeDescuentoDTO.getAsignacionTipoDescuento().getCodigoTipoDescuento());
			}
			
		}

		return this.equivalenciaPorcentajeDescuentoDTO;

	}

	/**
	 * @param equivalenciaPorcentajeDescuento the equivalenciaPorcentajeDescuento to set
	 */
	public void setEquivalenciaPorcentajeDescuentoDTO(EquivalenciaPorcentajeDescuentoDTO equivalenciaPorcentajeDescuentoDTO) {
		this.equivalenciaPorcentajeDescuentoDTO = equivalenciaPorcentajeDescuentoDTO;
	}

	/**
	 * @return the articuloUnidadManejoProveedorEquivalenciaCol
	 */
	public Collection<ArticuloUnidadManejoProveedorEquivalenciaDTO> getArticuloUnidadManejoProveedorEquivalenciaCol() {
		return articuloUnidadManejoProveedorEquivalenciaCol;
	}

	/**
	 * @param articuloUnidadManejoProveedorEquivalenciaCol the articuloUnidadManejoProveedorEquivalenciaCol to set
	 */
	public void setArticuloUnidadManejoProveedorEquivalenciaCol(Collection<ArticuloUnidadManejoProveedorEquivalenciaDTO> articuloUnidadManejoProveedorEquivalenciaCol) {
		this.articuloUnidadManejoProveedorEquivalenciaCol = articuloUnidadManejoProveedorEquivalenciaCol;
	}

	/**
	 * @return the equivalenciaPorcentajeDescuentoPromocionDTO
	 */
	public EquivalenciaPorcentajeDescuentoDTO getEquivalenciaPorcentajeDescuentoPromocionDTO() {
		
		if(CollectionUtils.isNotEmpty(this.equivalenciaPorcentajeDescuentoCol)) {
			
			for(EquivalenciaPorcentajeDescuentoDTO porcentajeDescuentoDTO : this.equivalenciaPorcentajeDescuentoCol) {
				
				if(EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO.equals(porcentajeDescuentoDTO.getAsignacionTipoDescuento().getCodigoAsignacionTipoDescuento())
						&& EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento().equals(porcentajeDescuentoDTO.getAsignacionTipoDescuento().getValorAsignacionTipoDescuento())
						&& EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO.equals(porcentajeDescuentoDTO.getAsignacionTipoDescuento().getCodigoAplicacionTipoDescuento())
						&& EnumTipoAplicacionDescuento.PROMOCION_COSTO.getValorTipoAplicacionDescuento().equals(porcentajeDescuentoDTO.getAsignacionTipoDescuento().getValorAplicacionTipoDescuento())) {

					this.equivalenciaPorcentajeDescuentoDTO = porcentajeDescuentoDTO;
					break;
				}

			}

		}

		return this.equivalenciaPorcentajeDescuentoPromocionDTO;
	}

	/**
	 * @param equivalenciaPorcentajeDescuentoPromocionDTO the equivalenciaPorcentajeDescuentoPromocionDTO to set
	 */
	public void setEquivalenciaPorcentajeDescuentoPromocionDTO(EquivalenciaPorcentajeDescuentoDTO equivalenciaPorcentajeDescuentoPromocionDTO) {
		this.equivalenciaPorcentajeDescuentoPromocionDTO = equivalenciaPorcentajeDescuentoPromocionDTO;
	}
}
