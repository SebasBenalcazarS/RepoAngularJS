package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * Contiene los grupos de impuestos a ser usados
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTGRUIMP")
public class GrupoImpuestoDTO extends SimpleAuditDTO{

	/**
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.GrupoImpuestoID id = new ec.com.smx.sic.cliente.mdl.dto.id.GrupoImpuestoID();

	/**
	 * Descripción del registro
	 */
	private String descripcion;

	/**
	 * Estado del registro
	 */
	@ComparatorTypeField
	private String estado;

	/**
	 * Usuario que creó el registro
	 * 
	 */
	@RegisterUserIdField
	private String idUsuarioRegistro;

	/**
	 * Fecha en la cual se creó el registro
	 * 
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Usuario que realiza la última actualización del registro
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la cual se realizó la ultima actualización del registro
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	@Column(name="ABREBIATURA")
	private String abreviatura;
	
	
	@OneToMany(mappedBy="grupoImpuesto")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<TipoImpuestoDTO> tipoImpuestoCol;
	

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.GrupoImpuestoID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.GrupoImpuestoID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>descripcion</code>
	 * 
	 * @return Retorna valor de propiedad <code>descripcion</code>
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descripcion</code>.
	 * 
	 * @param descripcion1
	 *            El valor a establecer para la propiedad <code>descripcion</code>.
	 */
	public void setDescripcion(String descripcion1) {
		this.descripcion = descripcion1 != null ? descripcion1.toUpperCase() : null;

		if (descripcion != null && descripcion.length() > 128) {
			descripcion = descripcion.substring(0, 128);
		}

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
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

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
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

	}

	/**
	 * @return the abreviatura
	 */
	public String getAbreviatura() {
		return abreviatura;
	}

	/**
	 * @param abreviatura the abreviatura to set
	 */
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public Collection<TipoImpuestoDTO> getTipoImpuestoCol() {
		return tipoImpuestoCol;
	}

	public void setTipoImpuestoCol(Collection<TipoImpuestoDTO> tipoImpuestoCol) {
		this.tipoImpuestoCol = tipoImpuestoCol;
	}	
	
	public TipoImpuestoDTO getTipoImpuestoPredeterminado(){
		Boolean tienePredeterminado = Boolean.FALSE;
		if(isLoaded(this.tipoImpuestoCol) && !CollectionUtils.isEmpty(this.tipoImpuestoCol)){
			for(TipoImpuestoDTO tipoImpuestoDTO : this.tipoImpuestoCol){
				if(BooleanUtils.isTrue(tipoImpuestoDTO.getEsPredeterminado())){
					return tipoImpuestoDTO;
				}
			}
			if(!tienePredeterminado){
				return this.tipoImpuestoCol.iterator().next();
			}			
		}		
		return null;
	}
}
