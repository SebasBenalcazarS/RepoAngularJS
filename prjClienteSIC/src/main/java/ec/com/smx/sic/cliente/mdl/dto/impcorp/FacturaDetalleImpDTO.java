/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloMaterialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.FacturaDetalleImpID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTFACDET")
public class FacturaDetalleImpDTO extends AuditoriaBaseDTO<FacturaDetalleImpID>{
	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo;
	
	@Column(name = "CODIGOPROVEEDOR")
	private String codigoProveedor;
	
	@Column(name = "CODIGOORDENCOMPRA")
	private Long codigoOrdenCompra;
	
	@Column(name = "CODIGOORDENCOMPRADETALLE")
	private Long codigoOrdenCompraDetalle;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
	})
	private ArticuloProveedorDTO articuloProveedor;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURA", referencedColumnName = "CODIGOFACTURA", insertable = false, updatable = false)
	})
	private FacturaImpDTO factura;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOORDENCOMPRADETALLE", referencedColumnName = "CODIGOORDENCOMPRADETALLE", insertable = false, updatable = false)
	})
	private OrdenCompraDetalleImpDTO ordenCompraDetalle;

	/**
	 * @return the ordenCompraDetalle
	 */
	public OrdenCompraDetalleImpDTO getOrdenCompraDetalle() {
		return ordenCompraDetalle;
	}

	/**
	 * @param ordenCompraDetalle the ordenCompraDetalle to set
	 */
	public void setOrdenCompraDetalle(OrdenCompraDetalleImpDTO ordenCompraDetalle) {
		this.ordenCompraDetalle = ordenCompraDetalle;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoOrdenCompra
	 */
	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}

	/**
	 * @param codigoOrdenCompra establece el valor a la propiedad codigoOrdenCompra
	 */
	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoOrdenCompraDetalle
	 */
	public Long getCodigoOrdenCompraDetalle() {
		return codigoOrdenCompraDetalle;
	}

	/**
	 * @param codigoOrdenCompraDetalle establece el valor a la propiedad codigoOrdenCompraDetalle
	 */
	public void setCodigoOrdenCompraDetalle(Long codigoOrdenCompraDetalle) {
		this.codigoOrdenCompraDetalle = codigoOrdenCompraDetalle;
	}

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
	 * @return devuelve el valor de la propiedad factura
	 */
	public FacturaImpDTO getFactura() {
		return factura;
	}

	/**
	 * @param factura establece el valor a la propiedad factura
	 */
	public void setFactura(FacturaImpDTO factura) {
		this.factura = factura;
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
						&& articuloMaterialDTO.getEstado().equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO)
						&& !articuloMaterialDTO.getEsPrincipal()){
					return articuloMaterialDTO.getObservacion();
				}
			}
		}
		return null;
	}
	
	
}
