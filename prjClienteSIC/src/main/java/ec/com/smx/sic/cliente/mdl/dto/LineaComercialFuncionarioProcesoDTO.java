package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.ProcesoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.LineaComercialFuncionarioProcesoID;

/**
 * 
 * @author fcollaguazo
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SCADMTLINCOMFUNPRO")
public class LineaComercialFuncionarioProcesoDTO extends AuditoriaBaseDTO{

	/**
	 * Clave primaria de la tabla proceso clase
	 */
	@EmbeddedId
	private LineaComercialFuncionarioProcesoID id;
	
	private Long codigoProceso;
	
	@Column(name =" CODLINCOMFUN")
	private Long codigoLineaComercialFuncionario;
	
	@Column(name ="CODIGOFUNCIONARIO", nullable = false)
	private String codigoFuncionario;
	
	@ComparatorTypeField
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODLINCOMFUN", referencedColumnName = "CODLINCOMFUN", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFUNCIONARIO", referencedColumnName = "CODIGOFUNCIONARIO", insertable = false, updatable = false)
	})
	private LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false)
    })
	private ProcesoDTO procesoDTO;
	
	public LineaComercialFuncionarioProcesoDTO(){
		id = new LineaComercialFuncionarioProcesoID();
	}

	/**
	 * @return the id
	 */
	public LineaComercialFuncionarioProcesoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(LineaComercialFuncionarioProcesoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoProceso
	 */
	public Long getCodigoProceso() {
		return codigoProceso;
	}

	/**
	 * @param codigoProceso the codigoProceso to set
	 */
	public void setCodigoProceso(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}

	/**
	 * @return the codigoLineaComercialFuncionario
	 */
	public Long getCodigoLineaComercialFuncionario() {
		return codigoLineaComercialFuncionario;
	}

	/**
	 * @param codigoLineaComercialFuncionario the codigoLineaComercialFuncionario to set
	 */
	public void setCodigoLineaComercialFuncionario(Long codigoLineaComercialFuncionario) {
		this.codigoLineaComercialFuncionario = codigoLineaComercialFuncionario;
	}
	
	/**
	 * @return the codigoFuncionario
	 */
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	/**
	 * @param codigoFuncionario the codigoFuncionario to set
	 */
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
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
	 * @return the lineaComercialFuncionarioDTO
	 */
	public LineaComercialFuncionarioDTO getLineaComercialFuncionarioDTO() {
		return lineaComercialFuncionarioDTO;
	}

	/**
	 * @param lineaComercialFuncionarioDTO the lineaComercialFuncionarioDTO to set
	 */
	public void setLineaComercialFuncionarioDTO(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO) {
		this.lineaComercialFuncionarioDTO = lineaComercialFuncionarioDTO;
	}

	/**
	 * @return the procesoDTO
	 */
	public ProcesoDTO getProcesoDTO() {
		return procesoDTO;
	}

	/**
	 * @param procesoDTO the procesoDTO to set
	 */
	public void setProcesoDTO(ProcesoDTO procesoDTO) {
		this.procesoDTO = procesoDTO;
	}
}
