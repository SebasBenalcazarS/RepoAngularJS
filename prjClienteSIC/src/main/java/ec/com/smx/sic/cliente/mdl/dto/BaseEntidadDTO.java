/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.LocalizacionDTO;
import ec.com.smx.corpv2.dto.PersonaDTO;
import ec.com.smx.framework.common.exception.FrameworkAplicacionException;
import ec.com.smx.framework.common.util.ClasesUtil;
import ec.com.smx.frameworkv2.auditoria.common.annotation.Auditable;
import ec.com.smx.frameworkv2.auditoria.common.util.AuditLogConstant;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.proveedor.TipoPersonaEntidad;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidad;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidadID;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseEntidadDTO<ID extends IBaseEntidadID> extends SimpleAuditDTO implements IBaseEntidad {
	
	@SuppressWarnings("unchecked")
	public BaseEntidadDTO(){
		try {
			this.id = (ID) ClasesUtil.newParametrizedTypeInstance(this, BaseEntidadDTO.class, 0);
		} catch (FrameworkAplicacionException e) {
			Logeable.LOG_SICV2.error(e.getMessage());
		}
	}
	
	
	@EmbeddedId
	private ID id;
	private Long codigoPersona;
	@Transient
	private TipoPersonaEntidad tipoPersonaEntidad;
	
	
	/**
	 * @return the id
	 */
	public ID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ID id) {
		this.id = id;
	}
	
	
	/**
	 * 
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "CODIGOPERSONA", referencedColumnName = "CODIGOPERSONA", insertable = false, updatable = false)
	private PersonaDTO persona;
	
	

	/**
	 * @return the persona
	 */
	@Auditable(id = AuditLogConstant.MAX_PROVEEDOR)
	public PersonaDTO getPersona() {
		return persona;
	}
	

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}


	/**
	 * @return the codigoPersona
	 */
	public Long getCodigoPersona() {
		return codigoPersona;
	}

	/**
	 * @param codigoPersona the codigoPersona to set
	 */
	public void setCodigoPersona(Long codigoPersona) {
		this.codigoPersona = codigoPersona;
	}
	
	
	public abstract LocalizacionDTO getLocalizacion();
	
	
	/**
	 * 
	 */
	public TipoPersonaEntidad getTipoPersonEntidad(){
		if (this.tipoPersonaEntidad == null){
			this.tipoPersonaEntidad = TipoPersonaEntidad.obtenerTipoPersonaEntidad(this);
		}
		
		return this.tipoPersonaEntidad;
	}
	
}
