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
import ec.com.smx.sic.cliente.mdl.dto.CompradorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.ClienteImportacionCompradorID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SIADMTCLIIMPCOM")
public class ClienteImportacionCompradorDTO extends AuditoriaBaseDTO<ClienteImportacionCompradorID>{
	
	@Column(name = "ESPREDETERMINADO")
	private Boolean esPredeterminado;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCLIENTEIMPORTACION", referencedColumnName = "CODIGOCLIENTEIMPORTACION", insertable = false, updatable = false)
	})
	private ClienteImportacionDTO clienteImportacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCOMPRADOR", referencedColumnName = "CODIGOCOMPRADOR", insertable = false, updatable = false)
	})
	private CompradorDTO comprador;

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
	 * @return devuelve el valor de la propiedad clienteImportacion
	 */
	public ClienteImportacionDTO getClienteImportacion() {
		return clienteImportacion;
	}

	/**
	 * @param clienteImportacion establece el valor a la propiedad clienteImportacion
	 */
	public void setClienteImportacion(ClienteImportacionDTO clienteImportacion) {
		this.clienteImportacion = clienteImportacion;
	}

	/**
	 * @return devuelve el valor de la propiedad comprador
	 */
	public CompradorDTO getComprador() {
		return comprador;
	}

	/**
	 * @param comprador establece el valor a la propiedad comprador
	 */
	public void setComprador(CompradorDTO comprador) {
		this.comprador = comprador;
	}

	/**
	 * @return devuelve el valor de la propiedad esPredeterminado
	 */
	public Boolean getEsPredeterminado() {
		return esPredeterminado;
	}

	/**
	 * @param esPredeterminado establece el valor a la propiedad esPredeterminado
	 */
	public void setEsPredeterminado(Boolean esPredeterminado) {
		this.esPredeterminado = esPredeterminado;
	}
	
}
