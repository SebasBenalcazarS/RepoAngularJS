/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.TipoProveedorID;

/**
 * @author mbraganza
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTTIPPRO")
public class TipoProveedorDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private TipoProveedorID id;
	
	private Integer codigoTipoEstadoProveedor;
	
	@ComparatorTypeField
	private String valorTipoEstadoProveedor;
	
	@ComparatorTypeField
	private String estado;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
		})
	private ProveedorDTO proveedor;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "VALORTIPOPROVEEDOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOPROVEEDOR", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO caracteristicaTipoProveedor;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "VALORTIPOESTADOPROVEEDOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOESTADOPROVEEDOR", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO caracteristicaEstadoTipoProveedor;
	
	
	
	public TipoProveedorDTO(){
		this.id = new TipoProveedorID();
	}



	/**
	 * @return the id
	 */
	public TipoProveedorID getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(TipoProveedorID id) {
		this.id = id;
	}

	

	/**
	 * @return the codigoTipoEstadoProveedor
	 */
	public Integer getCodigoTipoEstadoProveedor() {
		return codigoTipoEstadoProveedor;
	}



	/**
	 * @param codigoTipoEstadoProveedor the codigoTipoEstadoProveedor to set
	 */
	public void setCodigoTipoEstadoProveedor(Integer codigoTipoEstadoProveedor) {
		this.codigoTipoEstadoProveedor = codigoTipoEstadoProveedor;
	}



	/**
	 * @return the valorTipoEstadoProveedor
	 */
	public String getValorTipoEstadoProveedor() {
		return valorTipoEstadoProveedor;
	}



	/**
	 * @param valorTipoEstadoProveedor the valorTipoEstadoProveedor to set
	 */
	public void setValorTipoEstadoProveedor(String valorTipoEstadoProveedor) {
		this.valorTipoEstadoProveedor = valorTipoEstadoProveedor;
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
	 * @return the proveedor
	 */
	public ProveedorDTO getProveedor() {
		return proveedor;
	}



	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}



	/**
	 * @return the caracteristicaTipoProveedor
	 */
	public CatalogoValorDTO getCaracteristicaTipoProveedor() {
		return caracteristicaTipoProveedor;
	}



	/**
	 * @param caracteristicaTipoProveedor the caracteristicaTipoProveedor to set
	 */
	public void setCaracteristicaTipoProveedor(
			CatalogoValorDTO caracteristicaTipoProveedor) {
		this.caracteristicaTipoProveedor = caracteristicaTipoProveedor;
	}



	/**
	 * @return the caracteristicaEstadoTipoProveedor
	 */
	public CatalogoValorDTO getCaracteristicaEstadoTipoProveedor() {
		return caracteristicaEstadoTipoProveedor;
	}



	/**
	 * @param caracteristicaEstadoTipoProveedor the caracteristicaEstadoTipoProveedor to set
	 */
	public void setCaracteristicaEstadoTipoProveedor(
			CatalogoValorDTO caracteristicaEstadoTipoProveedor) {
		this.caracteristicaEstadoTipoProveedor = caracteristicaEstadoTipoProveedor;
	}
	
	
	
	
}
