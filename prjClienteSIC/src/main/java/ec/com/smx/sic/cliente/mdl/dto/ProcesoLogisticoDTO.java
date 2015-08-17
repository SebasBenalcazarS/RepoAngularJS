package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Types;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Tabla para guadar la fecha y hora de llegada para realizar la recepcion de la
 * mercaderia del proveeedor
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Table(name = "SBLOGTPROLOG")
public class ProcesoLogisticoDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla AsignacionProveedor
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ProcesoLogisticoID id = new ec.com.smx.sic.cliente.mdl.dto.id.ProcesoLogisticoID();
	
	/**
	 * Representa el codigo del CatalogoValor para saber si es recepcion o
	 * despacho.
	 * 
	 */
	@Column
	private java.lang.Integer codigoTipoProcesoLogistico;

	/**
	 * Representa el valor del CatalogoValor para saber si es recepcion o
	 * despacho.
	 * 
	 */
	@Column
	private java.lang.String valorTipoProcesoLogistico;

	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 * 
	 */
	@Column
	@ComparatorTypeField
	private java.lang.String estado;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="USUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="USUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private java.util.Date fechaModificacion;
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 * 
	 */
	
	/**
	 * Campo no persistente
	 * Relacion con el catalogo valor saber el tipo de proceso:
	 * recepcion/despacho
	 * 
	 */
	@Transient
	public ProcesoLogisticoEstadoDTO estadoProcesoDTOActivo;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "VALORTIPOPROCESOLOGISTICO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPOPROCESOLOGISTICO", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO") })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoProcesoLogistico;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioModificacion;
	
	
	/**
	 * Referencia a la tabla SBTARTTAREA
	 * 
	 */
	@OneToMany(mappedBy = "procesoLogisticoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<DatosTareaDTO> datosTareaCol;
	
	/**
	 * Referencia a la tabla SBTARTTAREA
	 * 
	 */
	@OneToMany(mappedBy = "procesoLogisticoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<TareaDTO> tareaCol;
	
	/**
	 * Referencia a la tabla SBLOGTRECPRO
	 */
	@OneToMany(mappedBy = "procesoLogisticoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<RecepcionProveedorDTO> recepcionProveedorDTOCol;
	
	@Transient
	private RecepcionProveedorDTO recepcionProveedorActivo;
	
	/**
	 * Referencia a los estados del proceso
	 */
	@OneToMany(mappedBy = "procesoLogisticoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ProcesoLogisticoEstadoDTO> estadoProcesoDTOCol;
	
	/**
	 * Referencia con la tabla movimiento interno
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROCESOLOGISTICO", referencedColumnName="CODIGOPROCESOLOGISTICO", insertable=false, updatable=false)})
	private MovimientoInternoDTO movimientoInternoDTO;
	
	/**
	 * Referencia con la tabla transferencia
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOPROCESOLOGISTICO", referencedColumnName="CODIGOPROCESOLOGISTICO", insertable=false, updatable=false)})
	private TransferenciaDTO transferenciaDTO;
	
	/**
	 * Referencia a la tabla contenedor
	 * 
	 */
	@OneToMany(mappedBy = "procesoLogisticoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ContenedorDTO> contenedorDTOCol;
	
	/**
	 * Referencia a la tabla proceso logistico transaccion
	 * 
	 */
	@OneToMany(mappedBy = "procesoLogisticoDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<ProcesoLogisticoTransaccionDTO> procesoLogisticoTransaccionDTOCol;
	
	
	/*
	 * Inicio campos para la optimizacion de consultas en el proceso de recepcion de bodega
	 * 
	 * */
	/**
	 * secuencial unico para la tabla, para optimizacion de procesos de actualizacion
	 */
	@Column(name="SECUENCIALPROCESOLOGISTICO")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECPROLOGSEC" , castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long secuencialProcesoLogistico;
	
	
	@Column(name="VALORESTADOPROCESOLOGISTICO")
	private String valorEstadoProcesoLogistico;
	
	
	@Column(name="CODIGOESTADOPROCESOLOGISTICO")
	private Integer codigoEstadoProcesoLogistico;
	
	/**
	 * Representa el estado actual del proceso
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "VALORESTADOPROCESOLOGISTICO", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOVALOR"),
		@JoinColumn(name = "CODIGOESTADOPROCESOLOGISTICO", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO")
	})
	private CatalogoValorDTO estadoProcesoLogistico;
	
	/*
	 * Fin campos para la optimizacion de consultas en el proceso de recepcion de bodega
	 * 
	 * */
	
	/**
	 * @return the estadoProcesoDTOCol
	 */
	public Collection<ProcesoLogisticoEstadoDTO> getEstadoProcesoDTOCol() {
		return estadoProcesoDTOCol;
	}

	/**
	 * @param estadoProcesoDTOCol the estadoProcesoDTOCol to set
	 */
	public void setEstadoProcesoDTOCol(Collection<ProcesoLogisticoEstadoDTO> estadoProcesoDTOCol) {
		this.estadoProcesoDTOCol = estadoProcesoDTOCol;
	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.util.Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.util.Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>
	 * .
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>
	 * .
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad
	 *            <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion() {
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null
				&& idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * @return the tipoProcesoLogistico
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoProcesoLogistico() {
		return tipoProcesoLogistico;
	}

	/**
	 * @param tipoProcesoLogistico the tipoProcesoLogistico to set
	 */
	public void setTipoProcesoLogistico(
			ec.com.smx.corpv2.dto.CatalogoValorDTO tipoProcesoLogistico) {
		this.tipoProcesoLogistico = tipoProcesoLogistico;
	}

	/**
	 * Retorna valor de propiedad <code>estado</code>
	 * 
	 * @return Retorna valor de propiedad <code>estado</code>
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estado</code>.
	 * 
	 * @param estado1
	 *            El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado(String estado1) {
		this.estado = estado1;

		if (estado != null && estado.length() > 1) {
			estado = estado.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>usuarioCreacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioCreacion</code>
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>usuarioCreacion</code>.
	 * 
	 * @param usuarioCreacion1
	 *            El valor a establecer para la propiedad
	 *            <code>usuarioCreacion</code>.
	 */
	public void setUsuarioCreacion(
			ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion1) {
		this.usuarioCreacion = usuarioCreacion1;
	}

	/**
	 * Retorna valor de propiedad <code>usuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>usuarioModificacion</code>
	 */
	public ec.com.smx.framework.security.dto.UserDto getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad
	 * <code>usuarioModificacion</code>.
	 * 
	 * @param usuarioModificacion1
	 *            El valor a establecer para la propiedad
	 *            <code>usuarioModificacion</code>.
	 */
	public void setUsuarioModificacion(ec.com.smx.framework.security.dto.UserDto usuarioModificacion1) {
		this.usuarioModificacion = usuarioModificacion1;
	}

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ProcesoLogisticoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ProcesoLogisticoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoTipoProcesoLogistico
	 */
	public Integer getCodigoTipoProcesoLogistico() {
		return codigoTipoProcesoLogistico;
	}

	/**
	 * @param codigoTipoProcesoLogistico the codigoTipoProcesoLogistico to set
	 */
	public void setCodigoTipoProcesoLogistico(Integer codigoTipoProcesoLogistico) {
		this.codigoTipoProcesoLogistico = codigoTipoProcesoLogistico;
	}

	/**
	 * @return the valorTipoProcesoLogistico
	 */
	public String getValorTipoProcesoLogistico() {
		return valorTipoProcesoLogistico;
	}

	/**
	 * @param valorTipoProcesoLogistico the valorTipoProcesoLogistico to set
	 */
	public void setValorTipoProcesoLogistico(String valorTipoProcesoLogistico) {
		this.valorTipoProcesoLogistico = valorTipoProcesoLogistico;
	}

	/**
	 * @return the tareaCol
	 */
	public Collection<TareaDTO> getTareaCol() {
		return tareaCol;
	}

	/**
	 * @param tareaCol the tareaCol to set
	 */
	public void setTareaCol(Collection<TareaDTO> tareaCol) {
		this.tareaCol = tareaCol;
	}

	/**
	 * @return the recepcionProveedorDTOCol
	 */
	public Collection<RecepcionProveedorDTO> getRecepcionProveedorDTOCol() {
		return recepcionProveedorDTOCol;
	}

	/**
	 * @param recepcionProveedorDTOCol the recepcionProveedorDTOCol to set
	 */
	public void setRecepcionProveedorDTOCol(
			Collection<RecepcionProveedorDTO> recepcionProveedorDTOCol) {
		this.recepcionProveedorDTOCol = recepcionProveedorDTOCol;
	}

	/**
	 * @return the recepcionProveedorDTO
	 */
	public RecepcionProveedorDTO getRecepcionProveedorActivo() {
		recepcionProveedorActivo = null;
		if (CollectionUtils.isNotEmpty(recepcionProveedorDTOCol)) {
			recepcionProveedorActivo = this.recepcionProveedorDTOCol.iterator().next();
		}
		return recepcionProveedorActivo;
	}
	
	/**
	 * Valida si existe asignadas las recepciones del proveedor
	 * @return
	 */
	public Boolean getTieneRecepcionProveedorDTO() {
		return isLoaded(this.recepcionProveedorDTOCol) && !this.recepcionProveedorDTOCol.isEmpty();
	}
	
	/**
	 * Valida si existe asignadas las tareas de recepcion
	 * @return
	 */
	public Boolean getTieneTareaCol() {
		return isLoaded(this.tareaCol) && !this.tareaCol.isEmpty();
	}

	public void setRecepcionProveedorActivo(RecepcionProveedorDTO recepcionProveedorActivo) {
		this.recepcionProveedorActivo = recepcionProveedorActivo;
	}

	/**
	 * @return the entregaEstadoDTOActivo
	 */
	public ProcesoLogisticoEstadoDTO getEstadoProcesoDTOActivo() {
		if(this.getTieneEstadoProcesoDTOCol()){
			for(ProcesoLogisticoEstadoDTO ee : this.estadoProcesoDTOCol){
				if(ee.getEstado().equals(SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO) && ee.getFechaFin() == null){
					this.estadoProcesoDTOActivo = ee;
					break;
				}
			}
		}
		return estadoProcesoDTOActivo;
	}
	public void setEstadoProcesoDTOActivo(ProcesoLogisticoEstadoDTO procesoLogisticoEstadoDTO){
		this.estadoProcesoDTOActivo = procesoLogisticoEstadoDTO;
	}
	/**
	 * @return the tieneEstadoProcesoDTOCol
	 */
	public Boolean getTieneEstadoProcesoDTOCol() {
		return isLoaded(this.estadoProcesoDTOCol) && !this.estadoProcesoDTOCol.isEmpty();
	}
	
	/**
	 * @return the transferenciaDTO
	 */
	public TransferenciaDTO getTransferenciaDTO() {
		return transferenciaDTO;
	}

	/**
	 * @param transferenciaDTO the transferenciaDTO to set
	 */
	public void setTransferenciaDTO(ec.com.smx.sic.cliente.mdl.dto.TransferenciaDTO transferenciaDTO) {
		this.transferenciaDTO = transferenciaDTO;
	}
	
	/**
	 * @return the contenedorDTOCol
	 */
	public Collection<ContenedorDTO> getContenedorDTOCol() {
		return contenedorDTOCol;
	}

	/**
	 * @param contenedorDTOCol the contenedorDTOCol to set
	 */
	public void setContenedorDTOCol(Collection<ContenedorDTO> contenedorDTOCol) {
		this.contenedorDTOCol = contenedorDTOCol;
	}
	
	/**
	 * @return contenedor relacionado 
	 */
	public ContenedorDTO getContenedorDTO(){
		if(contenedorDTOCol != null && SearchDTO.isLoaded(contenedorDTOCol) && !this.contenedorDTOCol.isEmpty()){
			return this.contenedorDTOCol.iterator().next();
		}
		return null;
	}
	
	/**
	 * @return the procesoLogisticoTransaccionDTOCol
	 */
	public Collection<ProcesoLogisticoTransaccionDTO> getProcesoLogisticoTransaccionDTOCol() {
		return procesoLogisticoTransaccionDTOCol;
	}

	/**
	 * @param procesoLogisticoTransaccionDTOCol the procesoLogisticoTransaccionDTOCol to set
	 */
	public void setProcesoLogisticoTransaccionDTOCol(Collection<ProcesoLogisticoTransaccionDTO> procesoLogisticoTransaccionDTOCol) {
		this.procesoLogisticoTransaccionDTOCol = procesoLogisticoTransaccionDTOCol;
	}
	
	/**
	 * @return proceso logistico transaccion
	 */
	public ProcesoLogisticoTransaccionDTO getProcesoLogisticoTransaccionDTO(){
		if(procesoLogisticoTransaccionDTOCol != null && SearchDTO.isLoaded(procesoLogisticoTransaccionDTOCol) && !this.procesoLogisticoTransaccionDTOCol.isEmpty()){
			return this.procesoLogisticoTransaccionDTOCol.iterator().next();
		}
		return null;
	}
	
	/**
	 * @return the movimientoInternoDTO
	 */
	public MovimientoInternoDTO getMovimientoInternoDTO() {
		return movimientoInternoDTO;
	}

	/**
	 * @param movimientoInternoDTO the movimientoInternoDTO to set
	 */
	public void setMovimientoInternoDTO(MovimientoInternoDTO movimientoInternoDTO) {
		this.movimientoInternoDTO = movimientoInternoDTO;
	}

	/**
	 * @return the secuencialProcesoLogistico
	 */
	public Long getSecuencialProcesoLogistico() {
		return secuencialProcesoLogistico;
	}

	/**
	 * @param secuencialProcesoLogistico the secuencialProcesoLogistico to set
	 */
	public void setSecuencialProcesoLogistico(Long secuencialProcesoLogistico) {
		this.secuencialProcesoLogistico = secuencialProcesoLogistico;
	}

	/**
	 * @return the valorEstadoProcesoLogistico
	 */
	public String getValorEstadoProcesoLogistico() {
		return valorEstadoProcesoLogistico;
	}

	/**
	 * @param valorEstadoProcesoLogistico the valorEstadoProcesoLogistico to set
	 */
	public void setValorEstadoProcesoLogistico(String valorEstadoProcesoLogistico) {
		this.valorEstadoProcesoLogistico = valorEstadoProcesoLogistico;
	}

	/**
	 * @return the codigoEstadoProcesoLogistico
	 */
	public Integer getCodigoEstadoProcesoLogistico() {
		return codigoEstadoProcesoLogistico;
	}

	/**
	 * @param codigoEstadoProcesoLogistico the codigoEstadoProcesoLogistico to set
	 */
	public void setCodigoEstadoProcesoLogistico(Integer codigoEstadoProcesoLogistico) {
		this.codigoEstadoProcesoLogistico = codigoEstadoProcesoLogistico;
	}

	/**
	 * @return the estadoProcesoLogistico
	 */
	public CatalogoValorDTO getEstadoProcesoLogistico() {
		return estadoProcesoLogistico;
	}

	/**
	 * @param estadoProcesoLogistico the estadoProcesoLogistico to set
	 */
	public void setEstadoProcesoLogistico(CatalogoValorDTO estadoProcesoLogistico) {
		this.estadoProcesoLogistico = estadoProcesoLogistico;
	}

	public Collection<DatosTareaDTO> getDatosTareaCol() {
		return datosTareaCol;
	}

	public void setDatosTareaCol(Collection<DatosTareaDTO> datosTareaCol) {
		this.datosTareaCol = datosTareaCol;
	}

}
