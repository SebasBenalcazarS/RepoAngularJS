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
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.CondicionGastoEmbarqueID;
import ec.com.smx.sic.cliente.mdl.dto.OficinaExteriorDTO;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SIADMTCONGASEMB")
public class CondicionGastoEmbarqueDTO extends AuditoriaBaseDTO<CondicionGastoEmbarqueID>{
	@Column(name = "CODIGOGASTOEMBARQUE")
	private Long codigoGastoEmbarque;
	
	@Column(name = "CODIGOCLIENTEIMPORTACION")
	private Long codigoClienteImportacion;
	
	@Column(name = "CODIGOOFICINAEXTERIOR")
	private Integer codigoOficinaExterior;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOGASTOEMBARQUE", referencedColumnName = "CODIGOGASTOEMBARQUE", insertable = false, updatable = false)
	})
	private GastoEmbarqueDTO gastoEmbarque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCLIENTEIMPORTACION", referencedColumnName = "CODIGOCLIENTEIMPORTACION", insertable = false, updatable = false)
	})
	private ClienteImportacionDTO clienteImportacion;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOOFICINAEXTERIOR", referencedColumnName = "CODIGOOFICINAEXTERIOR", insertable = false, updatable = false)
	})
	private OficinaExteriorDTO oficinaExterior;

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
	 * @return devuelve el valor de la propiedad gastoEmbarque
	 */
	public GastoEmbarqueDTO getGastoEmbarque() {
		return gastoEmbarque;
	}

	/**
	 * @param gastoEmbarque establece el valor a la propiedad gastoEmbarque
	 */
	public void setGastoEmbarque(GastoEmbarqueDTO gastoEmbarque) {
		this.gastoEmbarque = gastoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoGastoEmbarque
	 */
	public Long getCodigoGastoEmbarque() {
		return codigoGastoEmbarque;
	}

	/**
	 * @param codigoGastoEmbarque establece el valor a la propiedad codigoGastoEmbarque
	 */
	public void setCodigoGastoEmbarque(Long codigoGastoEmbarque) {
		this.codigoGastoEmbarque = codigoGastoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoOficinaExterior
	 */
	public Integer getCodigoOficinaExterior() {
		return codigoOficinaExterior;
	}

	/**
	 * @param codigoOficinaExterior establece el valor a la propiedad codigoOficinaExterior
	 */
	public void setCodigoOficinaExterior(Integer codigoOficinaExterior) {
		this.codigoOficinaExterior = codigoOficinaExterior;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoClienteImportacion
	 */
	public Long getCodigoClienteImportacion() {
		return codigoClienteImportacion;
	}

	/**
	 * @param codigoClienteImportacion establece el valor a la propiedad codigoClienteImportacion
	 */
	public void setCodigoClienteImportacion(Long codigoClienteImportacion) {
		this.codigoClienteImportacion = codigoClienteImportacion;
	}

	/**
	 * @return devuelve el valor de la propiedad clienteImportacion
	 */
	

	/**
	 * @param clienteImportacion establece el valor a la propiedad clienteImportacion
	 */
	
	/**
	 * @return devuelve el valor de la propiedad oficinaExterior
	 */
	public OficinaExteriorDTO getOficinaExterior() {
		return oficinaExterior;
	}

	/**
	 * @param oficinaExterior establece el valor a la propiedad oficinaExterior
	 */
	public void setOficinaExterior(OficinaExteriorDTO oficinaExterior) {
		this.oficinaExterior = oficinaExterior;
	}

	/**
	 * @return the clienteImportacion
	 */
	public ClienteImportacionDTO getClienteImportacion() {
		return clienteImportacion;
	}

	/**
	 * @param clienteImportacion the clienteImportacion to set
	 */
	public void setClienteImportacion(ClienteImportacionDTO clienteImportacion) {
		this.clienteImportacion = clienteImportacion;
	}
}
