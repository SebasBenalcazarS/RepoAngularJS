package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.RecepcionProveedorArticuloJustificacionID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author aecaiza
 *
 */
@SuppressWarnings("serial")

@Entity
@Table(name="SBLOGTRECPROARTJUS")
public class RecepcionProveedorArticuloJustificacionDTO extends AuditoriaBaseDTO{
	
	@EmbeddedId
	private RecepcionProveedorArticuloJustificacionID id = new RecepcionProveedorArticuloJustificacionID();
	/**
	 * Campo para optimizar los procesos de actualizacion de registros
	 */
	@Column(name = "SECUENCIALRECPROVEARTJUS")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECRECPROARTJUSSEC", castTo = @Cast(sqlType = Types.NUMERIC, precision = 15, scale = 0))
	private Long secuencialRecepcionProveedorArticuloJustificacion;
	
	public static final String NOMBRE_SECUENCIA_RECEPCION_ARTICULO_JUSTIFICACION = "SBLOGSECRECPROARTJUSSEC";
	
	/**Campo del codigo de la tabla recepcionproveedroarticulo
	 * 
	 */
	private Long codigoRecepcionProveedorArticulo; 
	
	
	/**
	 * Campo de codigo de una justificacion
	 */
	private Long codigoJustificacion;
	
	
	/**
	 * Campo del codigo tipo  para la configuracion de las validaciones de recepcion
	 */
	@ComparatorTypeField
	@Column(name= "CODIGOTIPOCONFIGURACIONETIQUETADO")
	private Integer codigoTipoConfiguracionEtiquetado;
	
	/**
	 * Campo del catalogo valor para la configuracion de bloqueo y desbloqueo
	 * de las validaciones de registro sanitario, transgenico, semaforo
	 */
	@ComparatorTypeField
	@Column(name="VALORTIPOCONFIGURACIONETIQUETADO")
	private String valorTipoConfiguracionEtiquetado;
	
	
	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 *
	 */
	@Column
	private String estado ;
	
	/**
	 * Fecha en la que se realiza el registro
	 *
	 */
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOCONFIGURACIONETIQUETADO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOCONFIGURACIONETIQUETADO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoConfiguracionValidacionEtiquetado;
	
	
	/**
	 * Relacion con la justificacion
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOJUSTIFICACION", insertable = false, updatable = false, referencedColumnName = "CODIGOJUSTIFICACION") })
	private JustificacionDTO justificacionDTO;
	
	/**
	 * Relacion con recepcion proveerdor articulo
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGORECEPCIONPROVEEDORARTICULO", insertable = false, updatable = false, referencedColumnName = "CODIGORECEPCIONPROVEEDORARTICULO") })
	private RecepcionProveedorArticuloDTO recepcionProveedorArticuloDTO;
	/**
	 * @return the id
	 */
	public RecepcionProveedorArticuloJustificacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(RecepcionProveedorArticuloJustificacionID id) {
		this.id = id;
	}

	/**
	 * @return the secuencialRecepcionProveedorArticuloJustificacion
	 */
	public Long getSecuencialRecepcionProveedorArticuloJustificacion() {
		return secuencialRecepcionProveedorArticuloJustificacion;
	}

	/**
	 * @param secuencialRecepcionProveedorArticuloJustificacion the secuencialRecepcionProveedorArticuloJustificacion to set
	 */
	public void setSecuencialRecepcionProveedorArticuloJustificacion(Long secuencialRecepcionProveedorArticuloJustificacion) {
		this.secuencialRecepcionProveedorArticuloJustificacion = secuencialRecepcionProveedorArticuloJustificacion;
	}

	/**
	 * @return the codigoRecepcionProveedorArticulo
	 */
	public Long getCodigoRecepcionProveedorArticulo() {
		return codigoRecepcionProveedorArticulo;
	}

	/**
	 * @param codigoRecepcionProveedorArticulo the codigoRecepcionProveedorArticulo to set
	 */
	public void setCodigoRecepcionProveedorArticulo(Long codigoRecepcionProveedorArticulo) {
		this.codigoRecepcionProveedorArticulo = codigoRecepcionProveedorArticulo;
	}

	/**
	 * @return the codigoJustificacion
	 */
	public Long getCodigoJustificacion() {
		return codigoJustificacion;
	}

	/**
	 * @param codigoJustificacion the codigoJustificacion to set
	 */
	public void setCodigoJustificacion(Long codigoJustificacion) {
		this.codigoJustificacion = codigoJustificacion;
	}

	/**
	 * @return the codigoTipoConfiguracionEtiquetado
	 */
	public Integer getCodigoTipoConfiguracionEtiquetado() {
		return codigoTipoConfiguracionEtiquetado;
	}

	/**
	 * @param codigoTipoConfiguracionEtiquetado the codigoTipoConfiguracionEtiquetado to set
	 */
	public void setCodigoTipoConfiguracionEtiquetado(Integer codigoTipoConfiguracionEtiquetado) {
		this.codigoTipoConfiguracionEtiquetado = codigoTipoConfiguracionEtiquetado;
	}

	/**
	 * @return the valorTipoConfiguracionEtiquetado
	 */
	public String getValorTipoConfiguracionEtiquetado() {
		return valorTipoConfiguracionEtiquetado;
	}

	/**
	 * @param valorTipoConfiguracionEtiquetado the valorTipoConfiguracionEtiquetado to set
	 */
	public void setValorTipoConfiguracionEtiquetado(String valorTipoConfiguracionEtiquetado) {
		this.valorTipoConfiguracionEtiquetado = valorTipoConfiguracionEtiquetado;
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
	 * @return the tipoConfiguracionValidacionEtiquetado
	 */
	public CatalogoValorDTO getTipoConfiguracionValidacionEtiquetado() {
		return tipoConfiguracionValidacionEtiquetado;
	}

	/**
	 * @param tipoConfiguracionValidacionEtiquetado the tipoConfiguracionValidacionEtiquetado to set
	 */
	public void setTipoConfiguracionValidacionEtiquetado(CatalogoValorDTO tipoConfiguracionValidacionEtiquetado) {
		this.tipoConfiguracionValidacionEtiquetado = tipoConfiguracionValidacionEtiquetado;
	}

	/**
	 * @return the justificacionDTO
	 */
	public JustificacionDTO getJustificacionDTO() {
		return justificacionDTO;
	}

	/**
	 * @param justificacionDTO the justificacionDTO to set
	 */
	public void setJustificacionDTO(JustificacionDTO justificacionDTO) {
		this.justificacionDTO = justificacionDTO;
	}

	/**
	 * @return the recepcionProveedorArticuloDTO
	 */
	public RecepcionProveedorArticuloDTO getRecepcionProveedorArticuloDTO() {
		return recepcionProveedorArticuloDTO;
	}

	/**
	 * @param recepcionProveedorArticuloDTO the recepcionProveedorArticuloDTO to set
	 */
	public void setRecepcionProveedorArticuloDTO(RecepcionProveedorArticuloDTO recepcionProveedorArticuloDTO) {
		this.recepcionProveedorArticuloDTO = recepcionProveedorArticuloDTO;
	}

}
