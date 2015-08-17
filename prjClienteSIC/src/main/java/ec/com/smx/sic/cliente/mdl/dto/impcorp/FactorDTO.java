/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.FactorID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTFACTOR")
public class FactorDTO extends AuditoriaBaseDTO<FactorID> {
	
	@Column(name = "CODIGOEMBARQUEFACTOR")
	private Long codigoEmbarqueFactor;
	
	@Column(name = "CODIGOEMBARQUE")
	private Long codigoEmbarque;
	
	@Column(name = "CODIGOEMBARQUEESTADO")
	private Long codigoEmbarqueEstado;
	
	@Column(name = "CODIGOFACTURA")
	private Long codigoFactura;
	
	@Column(name = "CODIGOFACTURAESTADO")
	private Long codigoFacturaEstado;
	
	@Column(name = "CODIGOFACTURADETALLEEST")
	private Long codigoFacturaDetalleEstado;
	
	@Column(name = "CODIGOFACDETESTADI")
	private Long codigoFacDetEstAdi;
	
	@Column(name = "VALORTOTALGASTOS")
	private Double valorTotalGastos;
	
	@Column(name = "VALORFACTOR")
	private Double valorFactor;
	
	@OneToMany(mappedBy = "factor")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<FactorDetalleDTO> factorDetalles;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUEESTADO", referencedColumnName = "CODIGOEMBARQUEESTADO", insertable = false, updatable = false)
	})
	private EmbarqueEstadoImpDTO embarqueEstado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURA", referencedColumnName = "CODIGOFACTURA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURAESTADO", referencedColumnName = "CODIGOFACTURAESTADO", insertable = false, updatable = false)
	})
	private FacturaEstadoImpDTO facturaEstado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURA", referencedColumnName = "CODIGOFACTURA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURAESTADO", referencedColumnName = "CODIGOFACTURAESTADO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURADETALLEEST", referencedColumnName = "CODIGOFACTURADETALLEEST", insertable = false, updatable = false),
	})
	private FacturaDetalleEstadoImpDTO facturaDetalleEstado;*/

	
	/**
	 * @return devuelve el valor de la propiedad codigoEmbarqueFactor
	 */
	public Long getCodigoEmbarqueFactor() {
		return codigoEmbarqueFactor;
	}

	/**
	 * @param codigoEmbarqueFactor establece el valor a la propiedad codigoEmbarqueFactor
	 */
	public void setCodigoEmbarqueFactor(Long codigoEmbarqueFactor) {
		this.codigoEmbarqueFactor = codigoEmbarqueFactor;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoEmbarque
	 */
	public Long getCodigoEmbarque() {
		return codigoEmbarque;
	}

	/**
	 * @param codigoEmbarque establece el valor a la propiedad codigoEmbarque
	 */
	public void setCodigoEmbarque(Long codigoEmbarque) {
		this.codigoEmbarque = codigoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoEmbarqueEstado
	 */
	public Long getCodigoEmbarqueEstado() {
		return codigoEmbarqueEstado;
	}

	/**
	 * @param codigoEmbarqueEstado establece el valor a la propiedad codigoEmbarqueEstado
	 */
	public void setCodigoEmbarqueEstado(Long codigoEmbarqueEstado) {
		this.codigoEmbarqueEstado = codigoEmbarqueEstado;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoFactura
	 */
	public Long getCodigoFactura() {
		return codigoFactura;
	}

	/**
	 * @param codigoFactura establece el valor a la propiedad codigoFactura
	 */
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoFacturaEstado
	 */
	public Long getCodigoFacturaEstado() {
		return codigoFacturaEstado;
	}

	/**
	 * @param codigoFacturaEstado establece el valor a la propiedad codigoFacturaEstado
	 */
	public void setCodigoFacturaEstado(Long codigoFacturaEstado) {
		this.codigoFacturaEstado = codigoFacturaEstado;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoFacturaDetalleEstado
	 */
	public Long getCodigoFacturaDetalleEstado() {
		return codigoFacturaDetalleEstado;
	}

	/**
	 * @param codigoFacturaDetalleEstado establece el valor a la propiedad codigoFacturaDetalleEstado
	 */
	public void setCodigoFacturaDetalleEstado(Long codigoFacturaDetalleEstado) {
		this.codigoFacturaDetalleEstado = codigoFacturaDetalleEstado;
	}

	/**
	 * @return devuelve el valor de la propiedad valorTotalGastos
	 */
	public Double getValorTotalGastos() {
		return valorTotalGastos;
	}

	/**
	 * @param valorTotalGastos establece el valor a la propiedad valorTotalGastos
	 */
	public void setValorTotalGastos(Double valorTotalGastos) {
		this.valorTotalGastos = valorTotalGastos;
	}

	/**
	 * @return devuelve el valor de la propiedad valorFactor
	 */
	public Double getValorFactor() {
		return valorFactor;
	}

	/**
	 * @param valorFactor establece el valor a la propiedad valorFactor
	 */
	public void setValorFactor(Double valorFactor) {
		this.valorFactor = valorFactor;
	}

	/**
	 * @return devuelve el valor de la propiedad factorDetalles
	 */
	public Collection<FactorDetalleDTO> getFactorDetalles() {
		return factorDetalles;
	}

	/**
	 * @param factorDetalles establece el valor a la propiedad factorDetalles
	 */
	public void setFactorDetalles(Collection<FactorDetalleDTO> factorDetalles) {
		this.factorDetalles = factorDetalles;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoFacDetEstAdi
	 */
	public Long getCodigoFacDetEstAdi() {
		return codigoFacDetEstAdi;
	}

	/**
	 * @param codigoFacDetEstAdi establece el valor a la propiedad codigoFacDetEstAdi
	 */
	public void setCodigoFacDetEstAdi(Long codigoFacDetEstAdi) {
		this.codigoFacDetEstAdi = codigoFacDetEstAdi;
	}
	
}
