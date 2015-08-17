package ec.com.smx.sic.cliente.mdl.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.corpv2.dto.VistaFuncionarioFuncionalidadDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.LineaComercialID;

/**
 * @author fmunoz
 * @author jvillacis
 * @author fcollaguazo
 *
 */
@Entity
@Table(name = "SCADMTLINCOM")
@SuppressWarnings("serial")
public class LineaComercialDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private LineaComercialID id = new LineaComercialID();
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "NOMBRECORTO")
	private String nombreCorto;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "CODIGOLINEACOMERCIALPADRE")
	private Long codigoLineaComercialPadre;
	
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private String estado;
	
	@Column(name = "CODIGOESTABLECIMIENTO")
	private Integer codigoEstablecimiento;
	
	@Column(name = "NIVEL")
	private Integer nivel;
	
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
	
	@Column(name = "CODIGOLINEACOMERCIALRAIZ")
	private Long codigoLineaComercialRaiz;
	
	@Column(name = "VALORTIPOLINEACOMERCIAL")
	@ComparatorTypeField
	private String valorTipoLineaComercial;
	
	@Column(name = "CODIGOTIPOLINEACOMERCIAL")
	private Integer codigoTipoLineaComercial;
	
	@Column(name = "CODIGOREFERENCIA")
	@ComparatorTypeField
	private String codigoReferencia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOLINEACOMERCIALPADRE", referencedColumnName = "CODIGOLINEACOMERCIAL", insertable = false, updatable = false)
	})
	private LineaComercialDTO lineaComercialPadre;
	
	@OneToMany(mappedBy = "lineaComercialPadre")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<LineaComercialDTO> subLineaComercialCol;
	
	
	@OneToMany(mappedBy = "lineaComercial")
    @CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<LineaComercialClasificacionDTO> lineaComercialClasificaciones; 
	
	@OneToMany(mappedBy = "lineaComercial")
    @CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarios;
	
	@OneToMany(mappedBy = "lineaComercialDTO")
    @CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<LineaComercialClienteImportacionDTO> lineaComercialClienteImportacionCol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOESTABLECIMIENTO", referencedColumnName = "CODIGOESTABLECIMIENTO", insertable = false, updatable = false)
	})
	private EstablecimientoDTO establecimiento;

	@Transient
	private Boolean esNuevo = Boolean.FALSE;
	@Transient
	private Boolean esInicio = Boolean.FALSE;
	@Transient
	private Integer numeroSubLineas = 0;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOLINEACOMERCIALRAIZ", referencedColumnName = "CODIGOLINEACOMERCIAL", insertable = false, updatable = false)
	})
	private LineaComercialDTO lineaComercialRaiz;
	
	@OneToMany(mappedBy="lineaComercialRaiz")
	@MapKeyColumn (name="CODIGOLINEACOMERCIAL")
	private Map<Long, LineaComercialDTO> lineasComercialesMap = new LinkedHashMap<Long, LineaComercialDTO>();
	
	@Transient
	private Boolean mostrarTodosHijos;
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumns({
	    	@JoinColumn(name = "CODIGOTIPOLINEACOMERCIAL", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
	    	@JoinColumn(name = "VALORTIPOLINEACOMERCIAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	    })
		private CatalogoValorDTO tipoLineaComercial;
	 
	
	@Transient
	private Collection<ClasificacionDTO> divisionesCol; 
	@Transient 
	private Collection<ClasificacionDTO> departamentosCol;
	
	@Transient 
	private Collection<ClasificacionDTO> clasificacionesCol;
	/**
	 * @return the id
	 */
	public LineaComercialID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(LineaComercialID id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return the codigoLineaComercialPadre
	 */
	public Long getCodigoLineaComercialPadre() {
		return codigoLineaComercialPadre;
	}

	/**
	 * @param codigoLineaComercialPadre the codigoLineaComercialPadre to set
	 */
	public void setCodigoLineaComercialPadre(Long codigoLineaComercialPadre) {
		this.codigoLineaComercialPadre = codigoLineaComercialPadre;
	}

	/**
	 * @return the lineaComercialPadre
	 */
	public LineaComercialDTO getLineaComercialPadre() {
		return lineaComercialPadre;
	}

	/**
	 * @param lineaComercialPadre the lineaComercialPadre to set
	 */
	public void setLineaComercialPadre(LineaComercialDTO lineaComercialPadre) {
		this.lineaComercialPadre = lineaComercialPadre;
	}

	/**
	 * @return the nombreCorto
	 */
	public String getNombreCorto() {
		return nombreCorto;
	}

	/**
	 * @param nombreCorto the nombreCorto to set
	 */
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	/**
	 * @return the lineaComercialClasificaciones
	 */
	public Collection<LineaComercialClasificacionDTO> getLineaComercialClasificaciones() {
		return lineaComercialClasificaciones;
	}

	/**
	 * @param lineaComercialClasificaciones the lineaComercialClasificaciones to set
	 */
	public void setLineaComercialClasificaciones(
			Collection<LineaComercialClasificacionDTO> lineaComercialClasificaciones) {
		this.lineaComercialClasificaciones = lineaComercialClasificaciones;
	}

	/**
	 * @return the esNuevo
	 */
	public Boolean getEsNuevo() {
		return esNuevo;
	}

	/**
	 * @param esNuevo the esNuevo to set
	 */
	public void setEsNuevo(Boolean esNuevo) {
		this.esNuevo = esNuevo;
	}

	/**
	 * @return the subLineaComercialCol
	 */
	public Collection<LineaComercialDTO> getSubLineaComercialCol() {
		return subLineaComercialCol;
	}

	/**
	 * @param subLineaComercialCol the subLineaComercialCol to set
	 */
	public void setSubLineaComercialCol(
			Collection<LineaComercialDTO> subLineaComercialCol) {
		this.subLineaComercialCol = subLineaComercialCol;
	}

	/**
	 * @return the esInicio
	 */
	public Boolean getEsInicio() {
		return esInicio;
	}

	/**
	 * @param esInicio the esInicio to set
	 */
	public void setEsInicio(Boolean esInicio) {
		this.esInicio = esInicio;
	}

	/**
	 * @return the nivel
	 */
	public Integer getNivel() {
		return nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the codigoEstablecimiento
	 */
	public Integer getCodigoEstablecimiento() {
		return codigoEstablecimiento;
	}

	/**
	 * @param codigoEstablecimiento the codigoEstablecimiento to set
	 */
	public void setCodigoEstablecimiento(Integer codigoEstablecimiento) {
		this.codigoEstablecimiento = codigoEstablecimiento;
	}

	/**
	 * @return the establecimiento
	 */
	public EstablecimientoDTO getEstablecimiento() {
		return establecimiento;
	}

	/**
	 * @param establecimiento the establecimiento to set
	 */
	public void setEstablecimiento(EstablecimientoDTO establecimiento) {
		this.establecimiento = establecimiento;
	}

	/**
	 * @return the lineaComercialFuncionarios
	 */
	public Collection<LineaComercialFuncionarioDTO> getLineaComercialFuncionarios() {
		return lineaComercialFuncionarios;
	}

	/**
	 * @param lineaComercialFuncionarios the lineaComercialFuncionarios to set
	 */
	public void setLineaComercialFuncionarios(Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarios) {
		this.lineaComercialFuncionarios = lineaComercialFuncionarios;
	}
	
	public Boolean getTieneFuncionalidadIngresada(String codigoFuncionalidad){
		if(CollectionUtils.isNotEmpty(this.getLineaComercialFuncionarios())){
			for (LineaComercialFuncionarioDTO lineaFuncionario : this.getLineaComercialFuncionarios()) {
				if(CollectionUtils.isNotEmpty(lineaFuncionario.getFuncionario().getFuncionarioFuncionalidades())){
					for (VistaFuncionarioFuncionalidadDTO funcionalidad : lineaFuncionario.getFuncionario().getFuncionarioFuncionalidades()) {
						if(funcionalidad.getId().getCodigoFuncionalidad().equals(codigoFuncionalidad)){
							return Boolean.TRUE;
						}
					}
				}
			}
		}
		return Boolean.FALSE;
	}
	public Boolean getTieneHijosFuncionalidadIngresada(String codigoFuncionalidad){
		if(CollectionUtils.isNotEmpty(this.getSubLineaComercialCol())){
			for(LineaComercialDTO subLinea:this.getSubLineaComercialCol()){
				if(subLinea.getTieneFuncionalidadIngresada(codigoFuncionalidad)){
					return Boolean.TRUE;
				}
				else{
					subLinea.getTieneHijosFuncionalidadIngresada(codigoFuncionalidad);
				}
			}
		}
		return Boolean.FALSE;
	}
	
	
	/**
	 * Valida si posee sublineas comerciales
	 * @return
	 */
	public Boolean getTieneSublineas() {
		return isLoaded(this.subLineaComercialCol) && !this.subLineaComercialCol.isEmpty();
	}
	
	public Collection<LineaComercialDTO> getSecureSubLineaComercialCol(){
		if(isLoaded(this.subLineaComercialCol)){
			return subLineaComercialCol;
		}
		return new ArrayList<LineaComercialDTO>(1);
	}
	
	/**
	 * @return the numeroSubLineas
	 */
	public Integer getNumeroSubLineas() {
		return numeroSubLineas;
	}

	/**
	 * @param numeroSubLineas the numeroSubLineas to set
	 */
	public void setNumeroSubLineas(Integer numeroSubLineas) {
		this.numeroSubLineas = numeroSubLineas;
	}

	public Long getCodigoLineaComercialRaiz() {
		return codigoLineaComercialRaiz;
	}

	public void setCodigoLineaComercialRaiz(Long codigoLineaComercialRaiz) {
		this.codigoLineaComercialRaiz = codigoLineaComercialRaiz;
	}

	public LineaComercialDTO getLineaComercialRaiz() {
		return lineaComercialRaiz;
	}

	public void setLineaComercialRaiz(LineaComercialDTO lineaComercialRaiz) {
		this.lineaComercialRaiz = lineaComercialRaiz;
	}

	public Map<Long, LineaComercialDTO> getLineasComercialesMap() {
		return lineasComercialesMap;
	}

	public void setLineasComercialesMap(Map<Long, LineaComercialDTO> lineasComercialesMap) {
		this.lineasComercialesMap = lineasComercialesMap;
	}

	public Boolean getMostrarTodosHijos() {
		return mostrarTodosHijos;
	}

	public void setMostrarTodosHijos(Boolean mostrarTodosHijos) {
		this.mostrarTodosHijos = mostrarTodosHijos;
	}
public String getValorTipoLineaComercial() {
		return valorTipoLineaComercial;
	}

	public void setValorTipoLineaComercial(String valorTipoLineaComercial) {
		this.valorTipoLineaComercial = valorTipoLineaComercial;
	}

	public Integer getCodigoTipoLineaComercial() {
		return codigoTipoLineaComercial;
	}

	public void setCodigoTipoLineaComercial(Integer codigoTipoLineaComercial) {
		this.codigoTipoLineaComercial = codigoTipoLineaComercial;
	}

	public CatalogoValorDTO getTipoLineaComercial() {
		return tipoLineaComercial;
	}

	public void setTipoLineaComercial(CatalogoValorDTO tipoLineaComercial) {
		this.tipoLineaComercial = tipoLineaComercial;
	}
	
	/**
	 * @return the divisionesCol
	 */
	public Collection<ClasificacionDTO> getDivisionesCol() {
		return divisionesCol;
	}

	/**
	 * @param divisionesCol the divisionesCol to set
	 */
	public void setDivisionesCol(Collection<ClasificacionDTO> divisionesCol) {
		this.divisionesCol = divisionesCol;
	}

	/**
	 * @return the departamentosCol
	 */
	public Collection<ClasificacionDTO> getDepartamentosCol() {
		return departamentosCol;
	}

	/**
	 * @param departamentosCol the departamentosCol to set
	 */
	public void setDepartamentosCol(Collection<ClasificacionDTO> departamentosCol) {
		this.departamentosCol = departamentosCol;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * @return the clasificacionesCol
	 */
	public Collection<ClasificacionDTO> getClasificacionesCol() {
		return clasificacionesCol;
	}

	/**
	 * @param clasificacionesCol the clasificacionesCol to set
	 */
	public void setClasificacionesCol(Collection<ClasificacionDTO> clasificacionesCol) {
		this.clasificacionesCol = clasificacionesCol;
	}

	/**
	 * @return the lineaComercialClienteImportacionCol
	 */
	public Collection<LineaComercialClienteImportacionDTO> getLineaComercialClienteImportacionCol() {
		return lineaComercialClienteImportacionCol;
	}

	/**
	 * @param lineaComercialClienteImportacionCol the lineaComercialClienteImportacionCol to set
	 */
	public void setLineaComercialClienteImportacionCol(Collection<LineaComercialClienteImportacionDTO> lineaComercialClienteImportacionCol) {
		this.lineaComercialClienteImportacionCol = lineaComercialClienteImportacionCol;
	}

}
