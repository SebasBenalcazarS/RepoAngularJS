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
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.OrdenCompraFacturaImpID;

/**
 * @author rgonzalez
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTORDCOMFAC")
public class OrdenCompraFacturaImpDTO extends AuditoriaBaseDTO<OrdenCompraFacturaImpID>{
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", updatable = false, insertable = false),
		@JoinColumn(name = "CODIGOFACTURA", referencedColumnName = "CODIGOFACTURA", updatable = false, insertable = false)
	})
	private FacturaImpDTO factura;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", updatable = false, insertable = false),
		@JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", updatable = false, insertable = false)
	})
	private OrdenCompraImpDTO ordenCompra;

	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;


	

	/**
	 * @return the factura
	 */
	public FacturaImpDTO getFactura() {
		return factura;
	}


	/**
	 * @param factura the factura to set
	 */
	public void setFactura(FacturaImpDTO factura) {
		this.factura = factura;
	}


	/**
	 * @return the ordenCompra
	 */
	public OrdenCompraImpDTO getOrdenCompra() {
		return ordenCompra;
	}


	/**
	 * @param ordenCompra the ordenCompra to set
	 */
	public void setOrdenCompra(OrdenCompraImpDTO ordenCompra) {
		this.ordenCompra = ordenCompra;
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

}
