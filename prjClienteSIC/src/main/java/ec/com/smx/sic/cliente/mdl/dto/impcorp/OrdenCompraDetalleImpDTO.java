/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.util.Collection;

import ec.com.smx.sic.cliente.resources.SICMessages;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;

import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.OrdenCompraDetalleImpID;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMaterialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTORDCOMDET")
public class OrdenCompraDetalleImpDTO extends AuditoriaBaseDTO<OrdenCompraDetalleImpID>{
	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo;
	
	@Column(name = "CODIGOPROVEEDOR")
	private String codigoProveedor;
	
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false)
	})
	private OrdenCompraImpDTO ordenCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
	})
	private ArticuloProveedorDTO articuloProveedor;
	
	@OneToMany(mappedBy = "ordenCompraDetalle")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<OrdenCompraDetalleEstadoImpDTO> ordenCompraDetalles;

	/**
	 * @return devuelve el valor de la propiedad estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado establece el valor a la propiedad estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return devuelve el valor de la propiedad ordenCompra
	 */
	public OrdenCompraImpDTO getOrdenCompra() {
		return ordenCompra;
	}

	/**
	 * @param ordenCompra establece el valor a la propiedad ordenCompra
	 */
	public void setOrdenCompra(OrdenCompraImpDTO ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia establece el valor a la propiedad codigoReferencia
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo establece el valor a la propiedad codigoArticulo
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor establece el valor a la propiedad codigoProveedor
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return devuelve el valor de la propiedad articuloProveedor
	 */
	public ArticuloProveedorDTO getArticuloProveedor() {
		return articuloProveedor;
	}

	/**
	 * @param articuloProveedor establece el valor a la propiedad articuloProveedor
	 */
	public void setArticuloProveedor(ArticuloProveedorDTO articuloProveedor) {
		this.articuloProveedor = articuloProveedor;
	}
	
	public String getMaterial(){
		if(this.articuloProveedor != null 
				&& this.articuloProveedor.getArticulo() != null 
				&& this.articuloProveedor.getArticulo().getArticuloMaterialDTOs() != null
				&& !this.articuloProveedor.getArticulo().getArticuloMaterialDTOs().isEmpty()){
			for(ArticuloMaterialDTO articuloMaterialDTO : this.articuloProveedor.getArticulo().getArticuloMaterialDTOs()){
				if(articuloMaterialDTO.getId() != null && articuloMaterialDTO.getId().getCodigoTipoMaterial() != null 
						&& articuloMaterialDTO.getId().getCodigoTipoMaterial().intValue() == SICArticuloConstantes.getInstancia().CODIGOTIPOMATERIAL.intValue()
						&& articuloMaterialDTO.getId().getValorTipoMaterial().equals(SICArticuloConstantes.getInstancia().VALOR_TIPOMATERIAL_OTRO)
						&& articuloMaterialDTO.getEstado().equals(SICMessages.getInstancia().getString("ec.com.smx.sic.estado.activo.numerico"))
						&& !articuloMaterialDTO.getEsPrincipal()){
					return articuloMaterialDTO.getObservacion();
				}
			}
		}
		return null;
	}
	
	/**
	 * @return the ordenCompraDetalles
	 */
	public Collection<OrdenCompraDetalleEstadoImpDTO> getOrdenCompraDetalles() {
		return ordenCompraDetalles;
	}

	/**
	 * @param ordenCompraDetalles the ordenCompraDetalles to set
	 */
	public void setOrdenCompraDetalles(
			Collection<OrdenCompraDetalleEstadoImpDTO> ordenCompraDetalles) {
		this.ordenCompraDetalles = ordenCompraDetalles;
	}
}
