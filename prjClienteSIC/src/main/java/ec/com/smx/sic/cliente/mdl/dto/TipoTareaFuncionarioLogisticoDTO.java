/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.FuncionarioLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.TipoTareaFuncionarioLogisticoID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author wcaiza
 *
 */
@Entity
@SuppressWarnings("serial")
@Table(name="SBTARTTIPTARFUNLOG")
public class TipoTareaFuncionarioLogisticoDTO extends AuditoriaBaseDTO {
	
	/**
	 * Clave primaria de la tabla TipoTareaFuncionarioLogisticoDTO
	 * 
	 */
	@EmbeddedId
	private TipoTareaFuncionarioLogisticoID id = new TipoTareaFuncionarioLogisticoID();
	
	@ComparatorTypeField
	private String estado;
	
	@Column(name = "SECUENCIALTIPOTAREAFUNCIONARIOLOGISTICO")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBTARSECTIPTARFUNLOGSEC" , castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Integer secuencialTipoTareaFuncionarioLogistico;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGOTIPOTAREA", referencedColumnName = "CODIGOTIPOTAREA", insertable = false, updatable = false) })
	private TipoTareaDTO tipoTareaDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGOFUNCIONARIOLOGISTICO", referencedColumnName = "CODIGOFUNCIONARIOLOGISTICO", insertable = false, updatable = false) })
	private FuncionarioLogisticoDTO funcionarioLogisticoDTO;

	/**
	 * @return the id
	 */
	public TipoTareaFuncionarioLogisticoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(TipoTareaFuncionarioLogisticoID id) {
		this.id = id;
	}

	/**
	 * @return the tipoTareaDTO
	 */
	public TipoTareaDTO getTipoTareaDTO() {
		return tipoTareaDTO;
	}

	/**
	 * @param tipoTareaDTO the tipoTareaDTO to set
	 */
	public void setTipoTareaDTO(TipoTareaDTO tipoTareaDTO) {
		this.tipoTareaDTO = tipoTareaDTO;
	}

	/**
	 * @return the funcionarioLogisticoDTO
	 */
	public FuncionarioLogisticoDTO getFuncionarioLogisticoDTO() {
		return funcionarioLogisticoDTO;
	}

	/**
	 * @param funcionarioLogisticoDTO the funcionarioLogisticoDTO to set
	 */
	public void setFuncionarioLogisticoDTO(FuncionarioLogisticoDTO funcionarioLogisticoDTO) {
		this.funcionarioLogisticoDTO = funcionarioLogisticoDTO;
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
	 * @return the secuencialTipoTareaFuncionarioLogistico
	 */
	public Integer getSecuencialTipoTareaFuncionarioLogistico() {
		return secuencialTipoTareaFuncionarioLogistico;
	}

	/**
	 * @param secuencialTipoTareaFuncionarioLogistico the secuencialTipoTareaFuncionarioLogistico to set
	 */
	public void setSecuencialTipoTareaFuncionarioLogistico(Integer secuencialTipoTareaFuncionarioLogistico) {
		this.secuencialTipoTareaFuncionarioLogistico = secuencialTipoTareaFuncionarioLogistico;
	}
	
}
