package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.ClienteImportacionDTO;

/**
 * Especifica la relacion entre una linea comercial y el cliente
 * @author cortiz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCADMTLINCOMCLIIMP")
public class LineaComercialClienteImportacionDTO extends AuditoriaBaseDTO{
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.LineaComercialClienteImportacionID id = new ec.com.smx.sic.cliente.mdl.dto.id.LineaComercialClienteImportacionID();

	@Column
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Obtiene la relacion linea comercial
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOLINEACOMERCIAL", referencedColumnName = "CODIGOLINEACOMERCIAL", insertable = false, updatable = false) })
	private LineaComercialDTO lineaComercialDTO;
	
	/**
	 * Obtiene la relacion cliente importacion
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCLIENTEIMPORTACION", referencedColumnName = "CODIGOCLIENTEIMPORTACION", insertable = false, updatable = false) })
	private ClienteImportacionDTO clienteImportacionDTO;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.LineaComercialClienteImportacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.LineaComercialClienteImportacionID id) {
		this.id = id;
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
	 * @return the lineaComercialDTO
	 */
	public LineaComercialDTO getLineaComercialDTO() {
		return lineaComercialDTO;
	}

	/**
	 * @param lineaComercialDTO the lineaComercialDTO to set
	 */
	public void setLineaComercialDTO(LineaComercialDTO lineaComercialDTO) {
		this.lineaComercialDTO = lineaComercialDTO;
	}

	/**
	 * @return the clienteImportacionDTO
	 */
	public ClienteImportacionDTO getClienteImportacionDTO() {
		return clienteImportacionDTO;
	}

	/**
	 * @param clienteImportacionDTO the clienteImportacionDTO to set
	 */
	public void setClienteImportacionDTO(ClienteImportacionDTO clienteImportacionDTO) {
		this.clienteImportacionDTO = clienteImportacionDTO;
	}
	
	
}
