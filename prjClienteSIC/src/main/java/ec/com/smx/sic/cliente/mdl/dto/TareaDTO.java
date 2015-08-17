
package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Types;
import java.util.Collection;

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

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceValueAddition;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionPositionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionSizeEnum;
import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.PerfilDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.TareaID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;


/**
 * Almacena todas las tareas de la estructura logistica
 *
 * @author acaiza
 */
@SuppressWarnings({ "serial" })
@Entity
@Table(name="SBTARTTAREA")
public class TareaDTO extends SimpleAuditDTO {
	
	/**
	 * Clave primaria de la tabla TareaDTO
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.TareaID id = new ec.com.smx.sic.cliente.mdl.dto.id.TareaID();
	
	
	@ComparatorTypeField
	private String codigoFuncionario ;

	/*Campo que hace referencia al areaSubLugarTrabajo*/
	@ComparatorTypeField
	private Integer codigoAreaTrabajo ;
	
	/*Campo que hace referencia al areaSubLugarTrabajo*/
	@Column(name = "CODIGOAREASUBLUGARTRABAJO")
	private Integer codigoAreaSublugarTrabajo ;

	
	@ComparatorTypeField
	private String codigoPerfil;
	
	/**
	 * codigo asignado a TipoTareaPerfil
	 *
	 */
	@Column
	private Long codigoTipoTareaPerfil ;
	
	/**
	 * Descripci�n de la tarea
	 *
	 */
	@Column
	private String descripcion ;
	
	/**
	 * Especifica el codigo de la tarea padre
	 *
	 */
	@Column(name = "CODIGOTAREAPADRE")
	private Long codigoTareaPadre;
	
	/**
	 * Especifica el codigo proceso
	 *
	 */
	@Column(name = "CODIGOPROCESO")
	private Long codigoProceso;
	
	/**
	 * Codigo proceso logistico
	 *
	 */
	@Column
	private Long codigoProcesoLogistico;

	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 *
	 */
	@Column
	@ComparatorTypeField
	private String estado ;
	
	/**
	 * orden de la tarea
	 */
	@Column
	private Integer orden;

	/**
	 * fecha de asignacion del proceso
	 */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaAsignacion;
	
	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column(name="FECHAREGISTRO")
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField
	@ComparatorTypeField
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="FECHAMODIFICACION")
	@LastModificationDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaModificacion;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	@ComparatorTypeField
	private String idUsuarioModificacion;
	
	/**
	 * Obtiene la relacion con los detalles de la tarea
	 */
	@OneToMany(mappedBy = "tareaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleTareaDTO> detalleTareaCol;
	
	/**
	 * Obtiene la relacion con los estados de la tarea
	 */
	@OneToMany(mappedBy = "tareaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<TareaEstadoDTO> tareaEstadoCol;
	
	/**
	 * Obtiene la relacion con los datos de la tarea
	 */
	@Transient
	@OneToMany(mappedBy = "tarea")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DatosTareaDTO> datosTareaCol;
	
	/**
	 * Obtiene la relacion con los datos de la tabla tarea datos tarea
	 */
	@OneToMany(mappedBy = "tareaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<TareaDatosTareaDTO> tareaDatosTareaDTOCol;
	
	/**
	 * Relacion con el proceso perfil
	 */
	@Transient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPERFIL", referencedColumnName = "CODIGOPERFIL", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROCESO", referencedColumnName = "CODIGOPROCESO", insertable = false, updatable = false)
	})
	private ec.com.smx.corpv2.dto.ProcesoPerfilDTO procesoPerfilDTO;
	
	/**
	 * Relacion con el sublugar de trabajo para la tarea.
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA",referencedColumnName="CODIGOCOMPANIA",insertable=false,updatable=false),
		@JoinColumn(name="CODIGOAREATRABAJO",referencedColumnName="CODIGOAREATRABAJO",insertable=false,updatable=false),
		@JoinColumn(name="CODIGOAREASUBLUGARTRABAJO",referencedColumnName="CODIGOAREASUBLUGARTRABAJO",insertable=false,updatable=false)
	})
	private AreaSublugarTrabajoDTO areaSublugarTrabajoDTO;
	
	/**
	 * Relacion con Tarea 
	 *
	 */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOPROCESOLOGISTICO", referencedColumnName = "CODIGOPROCESOLOGISTICO", insertable = false, updatable = false)
        })
	private ProcesoLogisticoDTO procesoLogisticoDTO;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOFUNCIONARIO", referencedColumnName = "CODIGOFUNCIONARIO", insertable = false, updatable = false)
        })
	private FuncionarioDTO funcionarioDTO;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOPERFIL", referencedColumnName = "PROFILEID", insertable = false, updatable = false)
        })
	private PerfilDTO perfilDTO;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOAREATRABAJO", referencedColumnName = "CODIGOAREATRABAJO", insertable = false, updatable = false)
        })
	private AreaTrabajoDTO areaTrabajoDTO;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOTIPOTAREAPERFIL", referencedColumnName = "CODIGOTIPOTAREAPERFIL", insertable = false, updatable = false)
        })
	private TipoTareaPerfilDTO tipoTareaPerfilDTO;
	
	/**
	 * Relacion con la tarea padre
	 *
	 */
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns({
        @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
        @JoinColumn(name = "CODIGOTAREAPADRE", referencedColumnName = "CODIGOTAREA", insertable = false, updatable = false)
        })
	private TareaDTO tareaPadre;
	
	/**
	 * Obtiene la relacion con los tareas hijas de la tarea padre
	 */
	@OneToMany(mappedBy = "tareaPadre")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<TareaDTO> tareasCol;
	
	@Transient
	private TareaEstadoDTO tareaEstadoActivo;
	
	@Transient
	TareaEstadoDTO tipoEstadoTarea;
	
	/*
	 * Inicio campos para la optimizacion de consultas en el proceso de recepcion de bodega
	 * 
	 * */
	@Column(name="SECUENCIALTAREA")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, 
						   name = "SBTARSECTAREASEC" , 
						   sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.LARGE),
						   castTo=@Cast(sqlType=Types.NUMERIC,precision=9,scale=0))
	private Long secuencialTarea;
	
	/**
	 * Representa el campo <code>userName</code> de la clase <code>UserDto</code>
	 */
	@Column(name="CUENTAUSUARIO")
	@ComparatorTypeField
	private String cuentaUsuario;
	
	@Column(name="CODIGOTIPOTAREA")
	private Long codigoTipoTarea;

	@ComparatorTypeField
	@Column(name="CODIGOREFERENCIATIPOTAREA")
	private String codigoReferenciaTipoTarea;		
	
	@Column(name="CODIGOESTADOTAREA")
	private Integer codigoEstadoTarea;
	
	@ComparatorTypeField
	@Column(name="VALORESTADOTAREA")
	private String valorEstadoTarea;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOESTADOTAREA", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), 
		@JoinColumn(name = "VALORESTADOTAREA", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorDTO estadoTarea;
	
	/*
	 * Fin campos para la optimizacion de consultas en el proceso de recepcion de bodega
	 * 
	 * */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGOTIPOTAREA", referencedColumnName = "CODIGOTIPOTAREA", insertable = false, updatable = false) })
	private TipoTareaDTO tipoTareaDTO;

	@Transient
	private OrdenSalidaRecipienteDTO ordenSalidaRecipientes;
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
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	/**
	 * @return the codigoPerfil
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
	 * @return the id
	 */
	public TareaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(TareaID id) {
		this.id = id;
	}
	
	/**
	 * @return the estadoTareaCol
	 */
	public Collection<TareaEstadoDTO> getTareaEstadoCol() {
		return tareaEstadoCol;
	}

	/**
	 * @param estadoTareaCol the estadoTareaCol to set
	 */
	public void setTareaEstadoCol(Collection<TareaEstadoDTO> estadoTareaCol) {
		this.tareaEstadoCol = estadoTareaCol;
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
	 * @return the datosTareaCol
	 */
	public Collection<DatosTareaDTO> getDatosTareaCol() {
		return datosTareaCol;
	}

	/**
	 * @param datosTareaCol the datosTareaCol to set
	 */
	public void setDatosTareaCol(Collection<DatosTareaDTO> datosTareaCol) {
		this.datosTareaCol = datosTareaCol;
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
	 * @return the detalleTareaCol
	 */
	public Collection<DetalleTareaDTO> getDetalleTareaCol() {
		return detalleTareaCol;
	}

	/**
	 * @param detalleTareaCol the detalleTareaCol to set
	 */
	public void setDetalleTareaCol(Collection<DetalleTareaDTO> detalleTareaCol) {
		this.detalleTareaCol = detalleTareaCol;
	}
	
	/**
	 * @return the codigoTareaPadre
	 */
	public Long getCodigoTareaPadre() {
		return codigoTareaPadre;
	}

	/**
	 * @param codigoTareaPadre the codigoTareaPadre to set
	 */
	public void setCodigoTareaPadre(Long codigoTareaPadre) {
		this.codigoTareaPadre = codigoTareaPadre;
	}

	/**
	 * @return the tareaPadre
	 */
	public TareaDTO getTareaPadre() {
		return tareaPadre;
	}

	/**
	 * @param tareaPadre the tareaPadre to set
	 */
	public void setTareaPadre(TareaDTO tareaPadre) {
		this.tareaPadre = tareaPadre;
	}

	/**
	 * @return the tareasCol
	 */
	public Collection<TareaDTO> getTareasCol() {
		return tareasCol;
	}

	/**
	 * @param tareasCol the tareasCol to set
	 */
	public void setTareasCol(Collection<TareaDTO> tareasCol) {
		this.tareasCol = tareasCol;
	}


	/**
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
	 * @return the fechaModificacion
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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
	 * @return the fechaAsignacion
	 */
	public java.util.Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	/**
	 * @param fechaAsignacion the fechaAsignacion to set
	 */
	public void setFechaAsignacion(java.util.Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	/**
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/**
	 * @return the codigoProcesoLogistico
	 */
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	/**
	 * @param codigoProcesoLogistico the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}

	/**
	 * @return the procesoLogisticoDTO
	 */
	public ProcesoLogisticoDTO getProcesoLogisticoDTO() {
		return procesoLogisticoDTO;
	}

	/**
	 * @param procesoLogisticoDTO the procesoLogisticoDTO to set
	 */
	public void setProcesoLogisticoDTO(ProcesoLogisticoDTO procesoLogisticoDTO) {
		this.procesoLogisticoDTO = procesoLogisticoDTO;
	}
	
	/**
	 * Valida si est&aacute; cargada la relaci&oacute;n con EstadoTareaDTO
	 * @return
	 */
	public Boolean getTieneEstadoTareaDTO() {
		return isLoaded(this.tareaEstadoCol) && !this.tareaEstadoCol.isEmpty();
	}

	public Boolean getTieneTareasCol() {
		return isLoaded(this.tareasCol) && !this.tareasCol.isEmpty();
	}
	
	public Boolean getTieneDetalleTareaCol() {
		return isLoaded(this.detalleTareaCol) && !this.detalleTareaCol.isEmpty();
	}
	
	/**
	 * @return the estadoTareaActivo
	 */
	public TareaEstadoDTO getTareaEstadoActivo() {
		tareaEstadoActivo = null;
		if (this.getTieneEstadoTareaDTO()) {
			for (TareaEstadoDTO estadoTareaDTO : getTareaEstadoCol()) {
				if (estadoTareaDTO.getEstado().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO) && estadoTareaDTO.getFechaFin() == null) {
					tareaEstadoActivo = estadoTareaDTO;
					break;
				}
			}
		}
		return tareaEstadoActivo;
	}

	/**
	 * 
	 * @return
	 */
	public TareaEstadoDTO getTipoEstadoTarea(String tipo) {
		tipoEstadoTarea = null;
		if (this.getTieneEstadoTareaDTO() && StringUtils.isNotEmpty(tipo)) {
			for (TareaEstadoDTO estadoTareaDTO : getTareaEstadoCol()) {
				if (estadoTareaDTO.getCodigoCatalogoValorRelacionado().equals(tipo)) {
					tipoEstadoTarea = estadoTareaDTO;
					break;
				}
			}
		}
		return tipoEstadoTarea;
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
	 * @return the codigoTipoTareaPerfil
	 */
	public Long getCodigoTipoTareaPerfil() {
		return codigoTipoTareaPerfil;
	}

	/**
	 * @param codigoTipoTareaPerfil the codigoTipoTareaPerfil to set
	 */
	public void setCodigoTipoTareaPerfil(Long codigoTipoTareaPerfil) {
		this.codigoTipoTareaPerfil = codigoTipoTareaPerfil;
	}

	/**
	 * @return the tipoTareaPerfilDTO
	 */
	public TipoTareaPerfilDTO getTipoTareaPerfilDTO() {
		return tipoTareaPerfilDTO;
	}

	/**
	 * @param tipoTareaPerfilDTO the tipoTareaPerfilDTO to set
	 */
	public void setTipoTareaPerfilDTO(TipoTareaPerfilDTO tipoTareaPerfilDTO) {
		this.tipoTareaPerfilDTO = tipoTareaPerfilDTO;
	}

	/**
	 * @return the perfilDTO
	 */
	public PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	/**
	 * @param perfilDTO the perfilDTO to set
	 */
	public void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}

	/**
	 * @return the areaTrabajoDTO
	 */
	public AreaTrabajoDTO getAreaTrabajoDTO() {
		return areaTrabajoDTO;
	}

	/**
	 * @param areaTrabajoDTO the areaTrabajoDTO to set
	 */
	public void setAreaTrabajoDTO(AreaTrabajoDTO areaTrabajoDTO) {
		this.areaTrabajoDTO = areaTrabajoDTO;
	}

	/**
	 * @return the tareaDatosTareaDTOCol
	 */
	public Collection<TareaDatosTareaDTO> getTareaDatosTareaDTOCol() {
		return tareaDatosTareaDTOCol;
	}

	/**
	 * @param tareaDatosTareaDTOCol the tareaDatosTareaDTOCol to set
	 */
	public void setTareaDatosTareaDTOCol(Collection<TareaDatosTareaDTO> tareaDatosTareaDTOCol) {
		this.tareaDatosTareaDTOCol = tareaDatosTareaDTOCol;
	}

	/**
	 * @return the codigoAreaSublugarTrabajo
	 */
	public Integer getCodigoAreaSublugarTrabajo() {
		return codigoAreaSublugarTrabajo;
	}

	/**
	 * @param codigoAreaSublugarTrabajo the codigoAreaSublugarTrabajo to set
	 */
	public void setCodigoAreaSublugarTrabajo(Integer codigoAreaSublugarTrabajo) {
		this.codigoAreaSublugarTrabajo = codigoAreaSublugarTrabajo;
	}

	/**
	 * @return the areaSublugarTrabajoDTO
	 */
	public AreaSublugarTrabajoDTO getAreaSublugarTrabajoDTO() {
		return areaSublugarTrabajoDTO;
	}

	/**
	 * @param areaSublugarTrabajoDTO the areaSublugarTrabajoDTO to set
	 */
	public void setAreaSublugarTrabajoDTO(AreaSublugarTrabajoDTO areaSublugarTrabajoDTO) {
		this.areaSublugarTrabajoDTO = areaSublugarTrabajoDTO;
	}

	/**
	 * @return the secuencialTarea
	 */
	public Long getSecuencialTarea() {
		return secuencialTarea;
	}

	/**
	 * @param secuencialTarea the secuencialTarea to set
	 */
	public void setSecuencialTarea(Long secuencialTarea) {
		this.secuencialTarea = secuencialTarea;
	}

	/**
	 * @return the cuentaUsuario
	 */
	public String getCuentaUsuario() {
		return cuentaUsuario;
	}

	/**
	 * @param cuentaUsuario the cuentaUsuario to set
	 */
	public void setCuentaUsuario(String cuentaUsuario) {
		this.cuentaUsuario = cuentaUsuario;
	}

	/**
	 * @return the codigoTipoTarea
	 */
	public Long getCodigoTipoTarea() {
		return codigoTipoTarea;
	}

	/**
	 * @param codigoTipoTarea the codigoTipoTarea to set
	 */
	public void setCodigoTipoTarea(Long codigoTipoTarea) {
		this.codigoTipoTarea = codigoTipoTarea;
	}

	/**
	 * @return the codigoReferenciaTipoTarea
	 */
	public String getCodigoReferenciaTipoTarea() {
		return codigoReferenciaTipoTarea;
	}

	/**
	 * @param codigoReferenciaTipoTarea the codigoReferenciaTipoTarea to set
	 */
	public void setCodigoReferenciaTipoTarea(String codigoReferenciaTipoTarea) {
		this.codigoReferenciaTipoTarea = codigoReferenciaTipoTarea;
	}

	/**
	 * @return the codigoEstadoTarea
	 */
	public Integer getCodigoEstadoTarea() {
		return codigoEstadoTarea;
	}

	/**
	 * @param codigoEstadoTarea the codigoEstadoTarea to set
	 */
	public void setCodigoEstadoTarea(Integer codigoEstadoTarea) {
		this.codigoEstadoTarea = codigoEstadoTarea;
	}

	/**
	 * @return the valorEstadoTarea
	 */
	public String getValorEstadoTarea() {
		return valorEstadoTarea;
	}

	/**
	 * @param valorEstadoTarea the valorEstadoTarea to set
	 */
	public void setValorEstadoTarea(String valorEstadoTarea) {
		this.valorEstadoTarea = valorEstadoTarea;
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
	 * @return the tipoEstadoTarea
	 */
	public TareaEstadoDTO getTipoEstadoTarea() {
		return tipoEstadoTarea;
	}

	/**
	 * @param tipoEstadoTarea the tipoEstadoTarea to set
	 */
	public void setTipoEstadoTarea(TareaEstadoDTO tipoEstadoTarea) {
		this.tipoEstadoTarea = tipoEstadoTarea;
	}

	/**
	 * @return the estadoTarea
	 */
	public CatalogoValorDTO getEstadoTarea() {
		return estadoTarea;
	}

	/**
	 * @param estadoTarea the estadoTarea to set
	 */
	public void setEstadoTarea(CatalogoValorDTO estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	public OrdenSalidaRecipienteDTO getOrdenSalidaRecipientes() {
		return ordenSalidaRecipientes;
	}

	public void setOrdenSalidaRecipientes(OrdenSalidaRecipienteDTO ordenSalidaRecipientes) {
		this.ordenSalidaRecipientes = ordenSalidaRecipientes;
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
	 * @return the procesoPerfilDTO
	 */
	public ec.com.smx.corpv2.dto.ProcesoPerfilDTO getProcesoPerfilDTO() {
		return procesoPerfilDTO;
	}

	/**
	 * @param procesoPerfilDTO the procesoPerfilDTO to set
	 */
	public void setProcesoPerfilDTO(ec.com.smx.corpv2.dto.ProcesoPerfilDTO procesoPerfilDTO) {
		this.procesoPerfilDTO = procesoPerfilDTO;
	}
	
}