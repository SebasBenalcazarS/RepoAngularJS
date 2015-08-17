/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.LineaComercialFuncionarioID;

/**
 * @author jvillacis
 * @author fcollaguazo
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCADMTLINCOMFUN")
public class LineaComercialFuncionarioDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private LineaComercialFuncionarioID id;
	
	public LineaComercialFuncionarioDTO(){
		id = new LineaComercialFuncionarioID();
	}
	
	@Column(name = "CODIGOLINEACOMERCIAL")
    private Long codigoLineaComercial;
	
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private String estado;
	
	@RegisterUserIdField
	@Column(name = "IDUSUARIOREGISTRO")
	@ComparatorTypeField
	private String idUsuarioRegistro;
	
	@RegisterDateField
	@Column(name = "FECHAREGISTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@LastModifierUserIdField
	@Column(name = "IDUSUARIOMODIFICACION")
	@ComparatorTypeField
	private String idUsuarioModificacion;
	
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOLINEACOMERCIAL", referencedColumnName = "CODIGOLINEACOMERCIAL", insertable = false, updatable = false)
	})
	private LineaComercialDTO lineaComercial;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFUNCIONARIO", referencedColumnName = "CODIGOFUNCIONARIO", insertable = false, updatable = false)
	})
	private FuncionarioDTO funcionario;
	
	@OneToMany(mappedBy = "lineaComercialFuncionario")
    @CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<LineaComercialFuncionarioTipoMarcaDTO> lineaComercialFuncionarioTipoMarcaCol;
	
	@OneToMany(mappedBy = "lineaComercialFuncionarioDTO")
    @CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<LineaComercialFuncionarioProcesoDTO> lineaComercialFuncionarioProcesoCol;
	
	@Transient
	private String codigoPerfil;
	
	@Transient
	private Boolean isSelected = Boolean.FALSE;
	
	@Transient
	private List<String> marcas;
	
	@Transient
	private List<String> marcasClone;
	
	@Transient
	private Collection<FuncionarioTipoMarcaDTO> funcionarioTipoMarcaCol;
	
	@Transient
	private Boolean expanded = Boolean.FALSE;
	
	@Transient
	private Boolean tipoValidacion = Boolean.FALSE;
	
	/**
	 * @return the id
	 */
	public LineaComercialFuncionarioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(LineaComercialFuncionarioID id) {
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
	 * @return the lineaComercial
	 */
	public LineaComercialDTO getLineaComercial() {
		return lineaComercial;
	}

	/**
	 * @param lineaComercial the lineaComercial to set
	 */
	public void setLineaComercial(LineaComercialDTO lineaComercial) {
		this.lineaComercial = lineaComercial;
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
	 * @return the codigoLineaComercial
	 */
	public Long getCodigoLineaComercial() {
		return codigoLineaComercial;
	}

	/**
	 * @param codigoLineaComercial the codigoLineaComercial to set
	 */
	public void setCodigoLineaComercial(Long codigoLineaComercial) {
		this.codigoLineaComercial = codigoLineaComercial;
	}

	/** @return the codigoPerfil
	 */
	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	/**
	 * @param codigoPerfil the codigoPerfil to set
	 */
	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	/**

	
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
	 * @return the isSelected
	 */
	public Boolean getIsSelected() {
		return isSelected;
	}

	/**
	 * @param isSelected the isSelected to set
	 */
	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

	/**
	 * @return the marcas
	 */
	public List<String> getMarcas() {
		return marcas;
	}

	/**
	 * @param marcas the marcas to set
	 */
	public void setMarcas(List<String> marcas) {
		this.marcas = marcas;
	}

	/**
	 * @return the marcasClone
	 */
	public List<String> getMarcasClone() {
		return marcasClone;
	}

	/**
	 * @param marcasClone the marcasClone to set
	 */
	public void setMarcasClone(List<String> marcasClone) {
		this.marcasClone = marcasClone;
	}

	/**
	 * @return the funcionarioTipoMarcaCol
	 */
	public Collection<FuncionarioTipoMarcaDTO> getFuncionarioTipoMarcaCol() {
		return funcionarioTipoMarcaCol;
	}

	/**
	 * @param funcionarioTipoMarcaCol the funcionarioTipoMarcaCol to set
	 */
	public void setFuncionarioTipoMarcaCol(Collection<FuncionarioTipoMarcaDTO> funcionarioTipoMarcaCol) {
		this.funcionarioTipoMarcaCol = funcionarioTipoMarcaCol;
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
	 * @return the lineaComercialFuncionarioProcesoCol
	 */
	public Collection<LineaComercialFuncionarioProcesoDTO> getLineaComercialFuncionarioProcesoCol() {
		return lineaComercialFuncionarioProcesoCol;
	}

	/**
	 * @param lineaComercialFuncionarioProcesoCol the lineaComercialFuncionarioProcesoCol to set
	 */
	public void setLineaComercialFuncionarioProcesoCol(Collection<LineaComercialFuncionarioProcesoDTO> lineaComercialFuncionarioProcesoCol) {
		this.lineaComercialFuncionarioProcesoCol = lineaComercialFuncionarioProcesoCol;
	}

	public Boolean getTipoValidacion() {
		return tipoValidacion;
	}

	public void setTipoValidacion(Boolean tipoValidacion) {
		this.tipoValidacion = tipoValidacion;
	}
	
}
