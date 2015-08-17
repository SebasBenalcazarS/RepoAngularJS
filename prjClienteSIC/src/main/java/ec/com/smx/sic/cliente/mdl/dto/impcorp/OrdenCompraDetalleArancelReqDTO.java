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

import org.apache.commons.lang.StringUtils;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.OrdenCompraDetalleArancelReqID;


/**
 * @author mchiliquinga
 * 
 */
@Entity
@Table(name = "SISIMTORDCOMDETARAREQ")
public class OrdenCompraDetalleArancelReqDTO extends AuditoriaBaseDTO<OrdenCompraDetalleArancelReqID> {

	private static final long serialVersionUID = 1L;

	@Column(name = "SECUENCIALARCHIVO")
	private Long secuencialArchivo;
	
	@Column(name="CODIGOARANCEL")
	private Long codigoArancel;
	
	@Column(name = "JUSTIFICACION")
	private String justificacion;

	@Column(name = "ESTADO")
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOORDENCOMPRADETALLE", referencedColumnName = "CODIGOORDENCOMPRADETALLE", insertable = false, updatable = false) })
	private OrdenCompraDetalleImpDTO ordenCompraDetalleImpDTO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "SECUENCIALARCHIVO", referencedColumnName = "SECUENCIALARCHIVO", insertable = false, updatable = false) })
	private ArchivoImpDTO archivoImpDTO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOARANCEL", referencedColumnName = "CODIGOARANCEL", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOARANCELREQUISITO", referencedColumnName = "CODIGOARANCELREQUISITO", insertable = false, updatable = false) })
	private ArancelRequisitoDTO arancelRequisitoDTO;

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
		if(!StringUtils.isEmpty(this.justificacion)){
			this.justificacion = justificacion.trim();			
		}
		
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public OrdenCompraDetalleImpDTO getOrdenCompraDetalleImpDTO() {
		return ordenCompraDetalleImpDTO;
	}

	public void setOrdenCompraDetalleImpDTO(OrdenCompraDetalleImpDTO ordenCompraDetalleImpDTO) {
		this.ordenCompraDetalleImpDTO = ordenCompraDetalleImpDTO;
	}

	public ArchivoImpDTO getArchivoImpDTO() {
		return archivoImpDTO;
	}

	public void setArchivoImpDTO(ArchivoImpDTO archivoImpDTO) {
		this.archivoImpDTO = archivoImpDTO;
	}

	public ArancelRequisitoDTO getArancelRequisitoDTO() {
		return arancelRequisitoDTO;
	}

	public void setArancelRequisitoDTO(ArancelRequisitoDTO arancelRequisitoDTO) {
		this.arancelRequisitoDTO = arancelRequisitoDTO;
	}

	public Long getSecuencialArchivo() {
		return secuencialArchivo;
	}

	public void setSecuencialArchivo(Long secuencialArchivo) {
		this.secuencialArchivo = secuencialArchivo;
	}

	public Long getCodigoArancel() {
		return codigoArancel;
	}

	public void setCodigoArancel(Long codigoArancel) {
		this.codigoArancel = codigoArancel;
	}

}
