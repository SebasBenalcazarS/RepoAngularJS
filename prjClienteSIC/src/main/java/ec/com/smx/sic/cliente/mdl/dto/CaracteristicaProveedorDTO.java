/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.CaracteristicaProveedorID;

/**
 * @author Victor Jaramillo
 *
 */
@Entity
@Table(name="SCPROTCARPRO")
@SuppressWarnings("serial")
public class CaracteristicaProveedorDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private CaracteristicaProveedorID id = new CaracteristicaProveedorID();
	
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;
	
	@Column(name = "CODIGOVALORCARPRO", nullable = false)
	private String codigoValorCaracteristicaProveedor;
	
	@Column(name = "CODIGOTIPOCARPRO", nullable = false)
	private Integer codigoTipoCaracteristicaProveedor;
	
	@Column(name="VALORCARACTERISTICA")
	private String valorCaracteristica;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOTIPOCARPRO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOVALORCARPRO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorDTO tipoCaracteristicaValor;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
	})
	private ProveedorDTO proveedor;

	/**
	 * @return the id
	 */
	public CaracteristicaProveedorID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(CaracteristicaProveedorID id) {
		this.id = id;
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
	 * @return the codigoValorCaracteristicaProveedor
	 */
	public String getCodigoValorCaracteristicaProveedor() {
		return codigoValorCaracteristicaProveedor;
	}

	/**
	 * @param codigoValorCaracteristicaProveedor the codigoValorCaracteristicaProveedor to set
	 */
	public void setCodigoValorCaracteristicaProveedor(String codigoValorCaracteristicaProveedor) {
		this.codigoValorCaracteristicaProveedor = codigoValorCaracteristicaProveedor;
	}

	/**
	 * @return the codigoTipoCaracteristicaProveedor
	 */
	public Integer getCodigoTipoCaracteristicaProveedor() {
		return codigoTipoCaracteristicaProveedor;
	}

	/**
	 * @param codigoTipoCaracteristicaProveedor the codigoTipoCaracteristicaProveedor to set
	 */
	public void setCodigoTipoCaracteristicaProveedor(Integer codigoTipoCaracteristicaProveedor) {
		this.codigoTipoCaracteristicaProveedor = codigoTipoCaracteristicaProveedor;
	}

	/**
	 * @return the valorCaracteristica
	 */
	public String getValorCaracteristica() {
		return valorCaracteristica;
	}

	/**
	 * @param valorCaracteristica the valorCaracteristica to set
	 */
	public void setValorCaracteristica(String valorCaracteristica) {
		this.valorCaracteristica = valorCaracteristica;
	}

	/**
	 * @return the tipoCaracteristicaValor
	 */
	public CatalogoValorDTO getTipoCaracteristicaValor() {
		return tipoCaracteristicaValor;
	}

	/**
	 * @param tipoCaracteristicaValor the tipoCaracteristicaValor to set
	 */
	public void setTipoCaracteristicaValor(CatalogoValorDTO tipoCaracteristicaValor) {
		this.tipoCaracteristicaValor = tipoCaracteristicaValor;
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
}
