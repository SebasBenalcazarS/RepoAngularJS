/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.CompaniaDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.GestionPrecioID;
import ec.com.smx.sic.cliente.mdl.nopersistente.GestionPrecioTransient;

/**
 * @author Luis Yacchirema
 *
 */
@Entity
@Table(name="SCPRETGESPRE")
@SuppressWarnings("serial")
public class GestionPrecioDTO extends GestionPrecioTransient {

	@EmbeddedId
	private GestionPrecioID id = new GestionPrecioID();

	@ComparatorTypeField
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;

	@ComparatorTypeField
	@Column(name = "CODIGOREFERENCIASUBTIPO")
	private String codigoReferenciaSubTipo;

	@Column(name = "NOMBRE")
	private String nombre;

	@ComparatorTypeField
	@Column(name = "VALORTIPOGESTIONPRECIO", nullable = false)
	private String valorTipoGestionPrecio;

	@Column(name = "CODIGOTIPOGESTIONPRECIO", nullable = false)
	private Integer codigoTipoGestionPrecio;
	
	@ComparatorTypeField
	@Column(name = "VALORSUBTIPOGESPRE", nullable = false)
	private String valorSubTipoGestionPrecio;

	@Column(name = "CODIGOSUBTIPOGESPRE", nullable = false)
	private Integer codigoSubTipoGestionPrecio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAINICIO")
	private Date fechaInicio ;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAFIN")
	private Date fechaFin ;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@ComparatorTypeField
	@Column(name = "ESTADO", nullable = false)
	private String estado;

	@ComparatorTypeField
	@Column (name = "VALORTIPOESTADO", nullable = false)
	private String valorTipoEstado;

	@Column (name = "CODIGOTIPOESTADO", nullable = false)
	private Integer codigoTipoEstado;

	@ComparatorTypeField
	@Column (name = "VALORESTADOEJECUCION", nullable = false)
	private String valorEstadoEjecucion;

	@Column (name = "CODIGOVALORESTADOEJECUCION", nullable = false)
	private Integer codigoEstadoEjecucion;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false)
	private CompaniaDTO compania;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOTIPOGESTIONPRECIO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "VALORTIPOGESTIONPRECIO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorDTO tipoGestionPrecio;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOSUBTIPOGESPRE", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "VALORSUBTIPOGESPRE", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorDTO subTipoGestionPrecio;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOESTADO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOESTADO", referencedColumnName="CODIGOCATALOGOTIPO", insertable=false, updatable=false)})
	private CatalogoValorDTO tipoEstado;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORESTADOEJECUCION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOVALORESTADOEJECUCION", referencedColumnName="CODIGOCATALOGOTIPO", insertable=false, updatable=false)})
	private CatalogoValorDTO tipoEstadoEjecucion;

	@OneToMany(mappedBy = "gestionPrecio")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloGestionPrecioDTO> articulosGestionPrecios;

	@OneToMany(mappedBy = "gestionPrecio")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<GestionPrecioRelacionDTO> gestionPreciosRelacionados;

	@OneToMany(mappedBy = "gestionPrecioRelacionado")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<GestionPrecioRelacionDTO> gestionPreciosRelacionadosHijos;
	
	@OneToMany(mappedBy = "gestionPrecio")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<GrupoAfectacionPrecioDTO> grupoAfectacionesPrecios;

	@OneToMany(mappedBy = "gestionPrecioDTO")
	private Collection<ConvenioParticipanteDTO> convenioParticipantes;

	/**
	 * @return the id
	 */
	public GestionPrecioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(GestionPrecioID id) {
		this.id = id;
	}

	/**
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia != null ? codigoReferencia.toUpperCase() : codigoReferencia;
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
		this.nombre = nombre != null ? nombre.toUpperCase() : nombre;
	}

	/**
	 * @return the valorTipoGestionPrecio
	 */
	public String getValorTipoGestionPrecio() {
		return valorTipoGestionPrecio;
	}

	/**
	 * @param valorTipoGestionPrecio the valorTipoGestionPrecio to set
	 */
	public void setValorTipoGestionPrecio(String valorTipoGestionPrecio) {
		this.valorTipoGestionPrecio = valorTipoGestionPrecio;
	}

	/**
	 * @return the codigoTipoGestionPrecio
	 */
	public Integer getCodigoTipoGestionPrecio() {
		return codigoTipoGestionPrecio;
	}

	/**
	 * @param codigoTipoGestionPrecio the codigoTipoGestionPrecio to set
	 */
	public void setCodigoTipoGestionPrecio(Integer codigoTipoGestionPrecio) {
		this.codigoTipoGestionPrecio = codigoTipoGestionPrecio;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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
	 * @return the compania
	 */
	public CompaniaDTO getCompania() {
		return compania;
	}

	/**
	 * @param compania the compania to set
	 */
	public void setCompania(CompaniaDTO compania) {
		this.compania = compania;
	}

	/**
	 * @return the tipoGestionPrecio
	 */
	public CatalogoValorDTO getTipoGestionPrecio() {
		return tipoGestionPrecio;
	}

	/**
	 * @param tipoGestionPrecio the tipoGestionPrecio to set
	 */
	public void setTipoGestionPrecio(CatalogoValorDTO tipoGestionPrecio) {
		this.tipoGestionPrecio = tipoGestionPrecio;
	}

	/**
	 * @return the articulosGestionPrecios
	 */
	public Collection<ArticuloGestionPrecioDTO> getArticulosGestionPrecios() {
		return articulosGestionPrecios;
	}

	/**
	 * @param articulosGestionPrecios the articulosGestionPrecios to set
	 */
	public void setArticulosGestionPrecios(Collection<ArticuloGestionPrecioDTO> articulosGestionPrecios) {
		this.articulosGestionPrecios = articulosGestionPrecios;
	}

	/**
	 * @return the gestionPreciosRelacionados
	 */
	public Collection<GestionPrecioRelacionDTO> getGestionPreciosRelacionados() {
		return gestionPreciosRelacionados;
	}

	/**
	 * @param gestionPreciosRelacionados the gestionPreciosRelacionados to set
	 */
	public void setGestionPreciosRelacionados(Collection<GestionPrecioRelacionDTO> gestionPreciosRelacionados) {
		this.gestionPreciosRelacionados = gestionPreciosRelacionados;
	}

	/**
	 * @return the grupoAfectacionesPrecios
	 */
	public Collection<GrupoAfectacionPrecioDTO> getGrupoAfectacionesPrecios() {
		return grupoAfectacionesPrecios;
	}

	/**
	 * @param grupoAfectacionesPrecios the grupoAfectacionesPrecios to set
	 */
	public void setGrupoAfectacionesPrecios(Collection<GrupoAfectacionPrecioDTO> grupoAfectacionesPrecios) {
		this.grupoAfectacionesPrecios = grupoAfectacionesPrecios;
	}

	public Collection<ConvenioParticipanteDTO> getConvenioParticipantes() {
		return convenioParticipantes;
	}

	public void setConvenioParticipantes(Collection<ConvenioParticipanteDTO> convenioParticipantes) {
		this.convenioParticipantes = convenioParticipantes;
	}

	public boolean isTieneParticipantes() {
		return tieneParticipantes;
	}

	public void setTieneParticipantes(boolean tieneParticipantes) {
		this.tieneParticipantes = tieneParticipantes;
	}

	public String getValorTipoEstado() {
		return valorTipoEstado;
	}

	public void setValorTipoEstado(String valorTipoEstado) {
		this.valorTipoEstado = valorTipoEstado;
	}

	public Integer getCodigoTipoEstado() {
		return codigoTipoEstado;
	}

	public void setCodigoTipoEstado(Integer codigoTipoEstado) {
		this.codigoTipoEstado = codigoTipoEstado;
	}

	public CatalogoValorDTO getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(CatalogoValorDTO tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	/**
	 * @return the valorEstadoEjecucion
	 */
	public String getValorEstadoEjecucion() {
		return valorEstadoEjecucion;
	}

	/**
	 * @param valorEstadoEjecucion the valorEstadoEjecucion to set
	 */
	public void setValorEstadoEjecucion(String valorEstadoEjecucion) {
		this.valorEstadoEjecucion = valorEstadoEjecucion;
	}

	/**
	 * @return the codigoEstadoEjecucion
	 */
	public Integer getCodigoEstadoEjecucion() {
		return codigoEstadoEjecucion;
	}

	/**
	 * @param codigoEstadoEjecucion the codigoEstadoEjecucion to set
	 */
	public void setCodigoEstadoEjecucion(Integer codigoEstadoEjecucion) {
		this.codigoEstadoEjecucion = codigoEstadoEjecucion;
	}

	/**
	 * @return the tipoEstadoEjecucion
	 */
	public CatalogoValorDTO getTipoEstadoEjecucion() {
		return tipoEstadoEjecucion;
	}

	/**
	 * @param tipoEstadoEjecucion the tipoEstadoEjecucion to set
	 */
	public void setTipoEstadoEjecucion(CatalogoValorDTO tipoEstadoEjecucion) {
		this.tipoEstadoEjecucion = tipoEstadoEjecucion;
	}

	public String getValorSubTipoGestionPrecio() {
		return valorSubTipoGestionPrecio;
	}

	public void setValorSubTipoGestionPrecio(String valorSubTipoGestionPrecio) {
		this.valorSubTipoGestionPrecio = valorSubTipoGestionPrecio;
	}

	public Integer getCodigoSubTipoGestionPrecio() {
		return codigoSubTipoGestionPrecio;
	}

	public void setCodigoSubTipoGestionPrecio(Integer codigoSubTipoGestionPrecio) {
		this.codigoSubTipoGestionPrecio = codigoSubTipoGestionPrecio;
	}

	public CatalogoValorDTO getSubTipoGestionPrecio() {
		return subTipoGestionPrecio;
	}

	public void setSubTipoGestionPrecio(CatalogoValorDTO subTipoGestionPrecio) {
		this.subTipoGestionPrecio = subTipoGestionPrecio;
	}

	/**
	 * @return the codigoReferenciaSubTipo
	 */
	public String getCodigoReferenciaSubTipo() {
		return codigoReferenciaSubTipo;
	}

	/**
	 * @param codigoReferenciaSubTipo the codigoReferenciaSubTipo to set
	 */
	public void setCodigoReferenciaSubTipo(String codigoReferenciaSubTipo) {
		this.codigoReferenciaSubTipo = codigoReferenciaSubTipo;
	}

	public Collection<GestionPrecioRelacionDTO> getGestionPreciosRelacionadosHijos() {
		return gestionPreciosRelacionadosHijos;
	}

	public void setGestionPreciosRelacionadosHijos(Collection<GestionPrecioRelacionDTO> gestionPreciosRelacionadosHijos) {
		this.gestionPreciosRelacionadosHijos = gestionPreciosRelacionadosHijos;
	}

}
