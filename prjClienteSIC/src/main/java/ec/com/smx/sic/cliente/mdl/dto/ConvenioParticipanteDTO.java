package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.constants.CollectionType;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.LocalizacionDTO;
import ec.com.smx.corpv2.dto.PersonaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ConvenioParticipanteID;

/**
 * Clase DTO que extiende de SimpleAuditDTO, representa la tabla SCCEMTCONPAR
 * del Schema DSMXSIC
 * 
 * @author srodriguez 2014-09-10
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCCEMTCONPAR")
public class ConvenioParticipanteDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla Convenio participante
	 * 
	 */
	@EmbeddedId
	private ConvenioParticipanteID id = new ConvenioParticipanteID();

	/**
	 * Codigo de llave foranea de la tabla gestion precio que representa una
	 * promocion o campania
	 */
	@Column(name = "CODIGOGESTIONPRECIO")
	@ComparatorTypeField
	private java.lang.Long codigoGestionPrecio;

	
	@Column(name = "CODIGOPROVEEDOR")
	@ComparatorTypeField
	private java.lang.String codigoProveedor;
	
	/**
	 * Codigo de llave foranea de la tabla persona que representa la persona con
	 * la que se puede realizar un convenio
	 */
	@Column(name = "CODIGOPERSONA")
	@ComparatorTypeField
	private java.lang.Long codigoPersona;

	/**
	 * Codigo de llave foranea de la tabla localizacion que representa la
	 * relacion que se tenga en promocion con un local especifico
	 */
	@Column(name = "CODIGOLOCALIZACION")
	@ComparatorTypeField
	private java.lang.Long codigoLocalizacion;

	/**
	 * Valor que representa al estado del registro
	 */
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private java.lang.String estado;
	

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name = "IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column(name = "FECHAREGISTRO")
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name = "IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	private java.util.Date fechaModificacion;
	
	@Transient
	private boolean contieneFiltro;
	/**
	 * Obtiene la relacion con la tabla GestionPrecioDTO
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOGESTIONPRECIO", insertable = false, updatable = false, referencedColumnName = "CODIGOGESTIONPRECIO") })
	private GestionPrecioDTO gestionPrecioDTO;

	
	/** Variable del tipo ProveedorDTO ConvenioParticipanteDTO.java
	 * @author srodriguez
	 * 16/3/2015
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOPROVEEDOR", insertable = false, updatable = false, referencedColumnName = "CODIGOPROVEEDOR") })
	private ProveedorDTO proveedorDTO;
	
	
	/**
	 * Obtiene la relacion con la tabla PersonaDTO
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOPERSONA", referencedColumnName = "CODIGOPERSONA", insertable = false, updatable = false) })
	private PersonaDTO personaDTO;

	/**
	 * Obtiene la relacion con la tabla LocalizacionDTO
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOLOCALIZACION", insertable = false, updatable = false, referencedColumnName = "CODIGOLOCALIZACION") })
	private LocalizacionDTO localizacionDTO;

	@OneToMany(mappedBy = "convenioParticipanteDTO")
	@CollectionTypeInfo(name = CollectionType.LIST_COLLECTION_TYPE)
	private Collection<NegociacionGestionPrecioParticipanteDTO> negociacionesGestionPrecioParticipantes;

	@Transient
	private boolean tieneNegociaciones;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConvenioParticipanteDTO [id=" + id + "]";
	}

	/*
	 * Metodo que compra dos objetos del tipo ConvenioParticipanteDTO
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * @author srodriguez 2014-09-10
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ConvenioParticipanteDTO other = (ConvenioParticipanteDTO) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/*
	 * Metodo que retorna id del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @return ConvenioParticipanteID id
	 */
	public ConvenioParticipanteID getId() {
		return id;
	}

	/*
	 * Metodo que asigna el id del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @param id parametro de tipo ConvenioParticipanteID
	 */
	public void setId(ConvenioParticipanteID id) {
		this.id = id;
	}

	/*
	 * Metodo que retorna codigoGestionPrecio del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @return java.lang.Long codigoGestionPrecio
	 */
	public java.lang.Long getCodigoGestionPrecio() {
		return codigoGestionPrecio;
	}

	/*
	 * Metodo que asigna el codigoGestionPrecio del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @param codigoGestionPrecio parametro de tipo java.lang.Long
	 */
	public void setCodigoGestionPrecio(java.lang.Long codigoGestionPrecio) {
		this.codigoGestionPrecio = codigoGestionPrecio;
	}

	/*
	 * Metodo que retorna codigoPersona del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @return java.lang.Long codigoPersona
	 */
	public java.lang.Long getCodigoPersona() {
		return codigoPersona;
	}

	/*
	 * Metodo que asigna el codigoPersona del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @param codigoPersona parametro de tipo java.lang.Long
	 */
	public void setCodigoPersona(java.lang.Long codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	/*
	 * Metodo que retorna codigoLocalizacion del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @return java.lang.Long codigoLocalizacion
	 */
	public java.lang.Long getCodigoLocalizacion() {
		return codigoLocalizacion;
	}

	/*
	 * Metodo que asigna el codigoLocalizacion del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @param codigoLocalizacion parametro de tipo java.lang.Long
	 */
	public void setCodigoLocalizacion(java.lang.Long codigoLocalizacion) {
		this.codigoLocalizacion = codigoLocalizacion;
	}

	/*
	 * Metodo que retorna estado del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @return java.lang.String estado
	 */
	public java.lang.String getEstado() {
		return estado;
	}

	/*
	 * Metodo que asigna el estado del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @param estado parametro de tipo java.lang.String
	 */
	public void setEstado(java.lang.String estado) {
		this.estado = estado;
	}

	/*
	 * Metodo que retorna idUsuarioRegistro del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @return java.lang.String idUsuarioRegistro
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/*
	 * Metodo que asigna el idUsuarioRegistro del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @param idUsuarioRegistro parametro de tipo java.lang.String
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/*
	 * Metodo que retorna fechaRegistro del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @return java.util.Date fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/*
	 * Metodo que asigna el fechaRegistro del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @param fechaRegistro parametro de tipo java.util.Date
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/*
	 * Metodo que retorna idUsuarioModificacion del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @return java.lang.String idUsuarioModificacion
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/*
	 * Metodo que asigna el idUsuarioModificacion del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @param idUsuarioModificacion parametro de tipo java.lang.String
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/*
	 * Metodo que retorna fechaModificacion del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @return java.util.Date fechaModificacion
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/*
	 * Metodo que asigna el fechaModificacion del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @param fechaModificacion parametro de tipo java.util.Date
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/*
	 * Metodo que retorna gestionPrecioDTO del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @return GestionPrecioDTO gestionPrecioDTO
	 */
	public GestionPrecioDTO getGestionPrecioDTO() {
		return gestionPrecioDTO;
	}

	/*
	 * Metodo que asigna el gestionPrecioDTO del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @param gestionPrecioDTO parametro de tipo GestionPrecioDTO
	 */
	public void setGestionPrecioDTO(GestionPrecioDTO gestionPrecioDTO) {
		this.gestionPrecioDTO = gestionPrecioDTO;
	}

	/*
	 * Metodo que retorna personaDTO del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @return PersonaDTO personaDTO
	 */
	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	/*
	 * Metodo que asigna el personaDTO del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @param personaDTO parametro de tipo PersonaDTO
	 */
	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

	/*
	 * Metodo que retorna localizacionDTO del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @return LocalizacionDTO localizacionDTO
	 */
	public LocalizacionDTO getLocalizacionDTO() {
		return localizacionDTO;
	}

	/*
	 * Metodo que asigna el localizacionDTO del objeto
	 * 
	 * @author srodriguez 08/10/2014
	 * 
	 * @param localizacionDTO parametro de tipo LocalizacionDTO
	 */
	public void setLocalizacionDTO(LocalizacionDTO localizacionDTO) {
		this.localizacionDTO = localizacionDTO;
	}

	public boolean isTieneNegociaciones() {
		return tieneNegociaciones;
	}

	public void setTieneNegociaciones(boolean tieneNegociaciones) {
		this.tieneNegociaciones = tieneNegociaciones;
	}

	public Collection<NegociacionGestionPrecioParticipanteDTO> getNegociacionesGestionPrecioParticipantes() {
		return negociacionesGestionPrecioParticipantes;
	}

	public void setNegociacionesGestionPrecioParticipantes(Collection<NegociacionGestionPrecioParticipanteDTO> negociacionesGestionPrecioParticipantes) {
		this.negociacionesGestionPrecioParticipantes = negociacionesGestionPrecioParticipantes;
	}

	/**
	 * @return the codigoProveedor
	 */
	public java.lang.String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(java.lang.String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return the proveedorDTO
	 */
	public ProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}

	/**
	 * @param proveedorDTO the proveedorDTO to set
	 */
	public void setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}

	public boolean isContieneFiltro() {
		return contieneFiltro;
	}

	public void setContieneFiltro(boolean contieneFiltro) {
		this.contieneFiltro = contieneFiltro;
	}
	
}
