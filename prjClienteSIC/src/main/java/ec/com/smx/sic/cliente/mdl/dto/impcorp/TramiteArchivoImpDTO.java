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
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.TramiteArchivoImpID;

/**
 * 
 * @author acastillo
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SISIMTTRAARC")
public class TramiteArchivoImpDTO extends AuditoriaBaseDTO<TramiteArchivoImpID>{

	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name="ESTADO")
	private String estado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false), 
		@JoinColumn(name="SECUENCIALARCHIVO", referencedColumnName="SECUENCIALARCHIVO", insertable=false, updatable=false)
	})
	private ArchivoImpDTO archivo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false), 
		@JoinColumn(name="SECUENCIALTRAMITE", referencedColumnName="SECUENCIALTRAMITE", insertable=false, updatable=false)
	})
	private TramiteEmbarqueImpDTO tramiteEmbarque;

	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArchivoImpDTO getArchivo() {
		return archivo;
	}

	public void setArchivo(ArchivoImpDTO archivo) {
		this.archivo = archivo;
	}

	public TramiteEmbarqueImpDTO getTramiteEmbarque() {
		return tramiteEmbarque;
	}

	public void setTramiteEmbarque(TramiteEmbarqueImpDTO tramiteEmbarque) {
		this.tramiteEmbarque = tramiteEmbarque;
	}
	
}
