package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.plantillas.dto.ConfiguracionPlantillaDTO;

/**
 * Entidad que almacena las clasificaciones que los usuarios tienen acceso para ciertos procesos del control de rotulado
 * 
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTCLACONPLA")
public class ClasificacionConfiguracionPlantillaDTO extends SimpleAuditDTO {

	/**
	 * id
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ClasificacionConfiguracionPlantillaID id = new ec.com.smx.sic.cliente.mdl.dto.id.ClasificacionConfiguracionPlantillaID();

	/**
	 * Estado de la clasificación configuración plantilla configurada, los valores pueden ser: - [0] INACTIVO - [1] ACTIVO
	 * 
	 */
	@ComparatorTypeField
	@Column (name = "ESTADO")
	private String estado;
	

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	private String usuarioCreacion;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaCreacion;

	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	private String usuarioActualizacion;

	/**
	 * Fecha en la que se realizó la última actualización.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaUltimaActualizacion;
	
	/**
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false)})
	private ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO clasificacion;
	
	/**
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCONFIGURACIONPLANTILLA", referencedColumnName = "CODIGOCONFIGURACIONPLANTILLA", insertable = false, updatable = false)})
	private ConfiguracionPlantillaDTO configuracionPlantilla;

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ClasificacionConfiguracionPlantillaID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ClasificacionConfiguracionPlantillaID id1) {
		this.id = id1;
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
	 * @param estadoClasificacionUsuario1
	 *            El valor a establecer para la propiedad <code>estado</code>.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaCreacion(java.sql.Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	/**
	 * @return the fechaUltimaActualizacion
	 */
	public java.sql.Timestamp getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	/**
	 * @param fechaUltimaActualizacion the fechaUltimaActualizacion to set
	 */
	public void setFechaUltimaActualizacion(
			java.sql.Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	/**
	 * @param usuarioCreacion the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * Retorna valor de propiedad <code>clasificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>clasificacion</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO getClasificacion() {
		return this.clasificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>clasificacion</code>.
	 * 
	 * @param clasificacion1
	 *            El valor a establecer para la propiedad <code>clasificacion</code>.
	 */
	public void setClasificacion(ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO clasificacion1) {
		this.clasificacion = clasificacion1;
	}

	/**
	 * @return the configuracionPlantilla
	 */
	public ConfiguracionPlantillaDTO getConfiguracionPlantilla() {
		return configuracionPlantilla;
	}

	/**
	 * @param configuracionPlantilla the configuracionPlantilla to set
	 */
	public void setConfiguracionPlantilla(ConfiguracionPlantillaDTO configuracionPlantilla) {
		this.configuracionPlantilla = configuracionPlantilla;
	}


}
