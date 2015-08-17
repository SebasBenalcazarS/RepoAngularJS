package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.CompradorID;

@Entity
@Table(name="SCSPETCOMPRADOR")
@SuppressWarnings("serial")
public class CompradorDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private CompradorID id;
	@Deprecated
	private String nombreComprador;
	private String estadoComprador;
	private String tipoComprador;
	private String codigoFuncionario;

	private String areaReferencia;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOFUNCIONARIO", referencedColumnName="CODIGOFUNCIONARIO", insertable=false, updatable=false)})
	private FuncionarioDTO funcionarioDTO;
	
	@OneToMany(mappedBy = "compradorDTO")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)	
	private Collection<ClasificacionDTO> clasificacionCol;
	
	public CompradorDTO() {
		id = new CompradorID();
	}
	
	public CompradorDTO(Boolean initID) {
		id = new CompradorID(initID);
	}
	/**
	 * @return the id
	 */
	public CompradorID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(CompradorID id) {
		this.id = id;
	}
	/**
	 * @return the estadoComprador
	 */
	public String getEstadoComprador() {
		return estadoComprador;
	}
	/**
	 * @param estadoComprador the estadoComprador to set
	 */
	public void setEstadoComprador(String estadoComprador) {
		this.estadoComprador = estadoComprador;
	}
	/**
	 * @return the tipoComprador
	 */
	public String getTipoComprador() {
		return tipoComprador;
	}
	/**
	 * @param tipoComprador the tipoComprador to set
	 */
	public void setTipoComprador(String tipoComprador) {
		this.tipoComprador = tipoComprador;
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
	 * @return the funcionarioDTO
	 */
	public FuncionarioDTO getFuncionarioDTO() {
		return funcionarioDTO;
	}
	/**
	 * @param funcionarioDTO the funcionarioDTO to set
	 */
	public void setFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
		this.funcionarioDTO = funcionarioDTO;
	}
	/**
	 * @return the nombreComprador
	 * @deprecated Este nombre debe ser obtenido desde la relación con el funcionario
	 */
	@Deprecated
	public String getNombreComprador() {
		return nombreComprador;
	}
	/**
	 * @param nombreComprador the nombreComprador to set
	 */
	@Deprecated
	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}

	public Collection<ClasificacionDTO> getClasificacionCol() {
		return clasificacionCol;
	}

	public void setClasificacionCol(Collection<ClasificacionDTO> clasificacionCol) {
		this.clasificacionCol = clasificacionCol;
	}

	/**
	 * @return the areaReferencia
	 */
	public String getAreaReferencia() {
		return areaReferencia;
	}

	/**
	 * @param areaReferencia the areaReferencia to set
	 */
	public void setAreaReferencia(String areaReferencia) {
		this.areaReferencia = areaReferencia;
	}	
	
	
}
