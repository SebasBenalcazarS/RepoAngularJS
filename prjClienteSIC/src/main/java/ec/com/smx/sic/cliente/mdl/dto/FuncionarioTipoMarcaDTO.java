package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.FuncionarioTipoMarcaID;

/**
 * Entidad que almacena las marcas de un funcionario (Propia / Proveedor)'
 * @author fcollaguazo
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCADMTFUNTIPMAR")
public class FuncionarioTipoMarcaDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private FuncionarioTipoMarcaID id;
	
	public FuncionarioTipoMarcaDTO(){
		id = new FuncionarioTipoMarcaID();
	}
	
	@ComparatorTypeField
	private String codigoFuncionario;
	
	@ComparatorTypeField
	private String valorTipoMarca;
	
	private Integer codigoTipoMarca;
	
	private String estado;
	
	@RegisterUserIdField
	@Column(name = "IDUSUARIOREGISTRO")
	private String idUsuarioRegistro;
	
	@RegisterDateField
	@Column(name = "FECHAREGISTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@LastModifierUserIdField
	@Column(name = "IDUSUARIOMODIFICACION")
	private String idUsuarioModificacion;
	
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOTIPOMARCA", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
    	@JoinColumn(name = "VALORTIPOMARCA", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
    })
	private CatalogoValorDTO tipoMarca;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
    	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
    	@JoinColumn(name = "CODIGOFUNCIONARIO", referencedColumnName = "CODIGOFUNCIONARIO", insertable = false, updatable = false)
    })
	private FuncionarioDTO funcionario;
	
	@OneToMany(mappedBy = "funcionarioTipoMarca")
    @CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<LineaComercialFuncionarioTipoMarcaDTO> lineaComercialFuncionarioTipoMarcaCol;
	
	
	@OneToMany(mappedBy = "funcionarioTipoMarca")
    @CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<MarcaFuncionarioTipoMarcaDTO> marcaFuncionarioTipoMarcaCol;
	
	@Transient
	private Boolean expanded = Boolean.FALSE;
	
	@Transient
	private LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO;

	/**
	 * @return the id
	 */
	public FuncionarioTipoMarcaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(FuncionarioTipoMarcaID id) {
		this.id = id;
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
	 * @return the valorTipoMarca
	 */
	public String getValorTipoMarca() {
		return valorTipoMarca;
	}

	/**
	 * @param valorTipoMarca the valorTipoMarca to set
	 */
	public void setValorTipoMarca(String valorTipoMarca) {
		this.valorTipoMarca = valorTipoMarca;
	}

	/**
	 * @return the codigoTipoMarca
	 */
	public Integer getCodigoTipoMarca() {
		return codigoTipoMarca;
	}

	/**
	 * @param codigoTipoMarca the codigoTipoMarca to set
	 */
	public void setCodigoTipoMarca(Integer codigoTipoMarca) {
		this.codigoTipoMarca = codigoTipoMarca;
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
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the tipoMarca
	 */
	public CatalogoValorDTO getTipoMarca() {
		return tipoMarca;
	}

	/**
	 * @param tipoMarca the tipoMarca to set
	 */
	public void setTipoMarca(CatalogoValorDTO tipoMarca) {
		this.tipoMarca = tipoMarca;
	}

	/**
	 * @return the funcionario
	 */
	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the lineaComercialFuncionarioTipoMarcaCol
	 */
	public Collection<LineaComercialFuncionarioTipoMarcaDTO> getLineaComercialFuncionarioTipoMarcaCol() {
		return lineaComercialFuncionarioTipoMarcaCol;
	}

	/**
	 * @param lineaComercialFuncionarioTipoMarcaCol the lineaComercialFuncionarioTipoMarcaCol to set
	 */
	public void setLineaComercialFuncionarioTipoMarcaCol(Collection<LineaComercialFuncionarioTipoMarcaDTO> lineaComercialFuncionarioTipoMarcaCol) {
		this.lineaComercialFuncionarioTipoMarcaCol = lineaComercialFuncionarioTipoMarcaCol;
	}

	/**
	 * @return the marcaFuncionarioTipoMarcaCol
	 */
	public Collection<MarcaFuncionarioTipoMarcaDTO> getMarcaFuncionarioTipoMarcaCol() {
		return marcaFuncionarioTipoMarcaCol;
	}

	/**
	 * @param marcaFuncionarioTipoMarcaCol the marcaFuncionarioTipoMarcaCol to set
	 */
	public void setMarcaFuncionarioTipoMarcaCol(Collection<MarcaFuncionarioTipoMarcaDTO> marcaFuncionarioTipoMarcaCol) {
		this.marcaFuncionarioTipoMarcaCol = marcaFuncionarioTipoMarcaCol;
	}

	/**
	 * @return the expanded
	 */
	public Boolean getExpanded() {
		return expanded;
	}

	/**
	 * @param expanded the expanded to set
	 */
	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
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
}
