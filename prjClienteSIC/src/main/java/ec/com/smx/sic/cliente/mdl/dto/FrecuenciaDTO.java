/*
 * Creado el 13/06/2012
 *
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;


import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.FrecuenciaID;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSPETFRECUENCIA")
public class FrecuenciaDTO extends SimpleAuditDTO
{
	@EmbeddedId
    private FrecuenciaID id;
    private String descripcionFrecuencia;
    private String estadoFrecuencia;
    
    @RegisterUserIdField
    private String usuarioRegistro;
    @LastModifierUserIdField
    private String usuarioModificacion;
    @RegisterDateField
    private Timestamp fechaRegistro;
    @LastModificationDateField
    private Timestamp fechaModificacion;
    
    @OneToMany(mappedBy = "frecuenciaDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
    private Collection<FrecuenciaArticuloDTO> frecuenciasArticulos;
    
    public FrecuenciaDTO() {
    	id = new FrecuenciaID();
	}
    public FrecuenciaDTO(Boolean initID) {
    	id = new FrecuenciaID(initID);
	}
    /**
     * @return Devuelve descripcionFrecuencia.
     */
    public String getDescripcionFrecuencia()
    {
        return descripcionFrecuencia;
    }
    /**
     * @param descripcionFrecuencia El descripcionFrecuencia a establecer.
     */
    public void setDescripcionFrecuencia(String descripcionFrecuencia)
    {
        this.descripcionFrecuencia = descripcionFrecuencia;
    }
    /**
     * @return Devuelve estadoFrecuencia.
     */
    public String getEstadoFrecuencia()
    {
        return estadoFrecuencia;
    }
    /**
     * @param estadoFrecuencia El estadoFrecuencia a establecer.
     */
    public void setEstadoFrecuencia(String estadoFrecuencia)
    {
        this.estadoFrecuencia = estadoFrecuencia;
    }
    /**
     * @return Devuelve id.
     */
    public FrecuenciaID getId()
    {
        return id;
    }
    /**
     * @param id El id a establecer.
     */
    public void setId(FrecuenciaID id)
    {
        this.id = id;
    }
    
    /**
     * 
     * @return frecuenciasArticulos
     */
    public Collection<FrecuenciaArticuloDTO> getFrecuenciasArticulos() {
        return this.frecuenciasArticulos;
    }
    /**
     * 
     * @param frecuenciasArticulos
     */
    public void setFrecuenciasArticulos(Collection<FrecuenciaArticuloDTO> frecuenciasArticulos) {
        this.frecuenciasArticulos = frecuenciasArticulos;
    }
	/**
	 * @return the fechaRegistro
	 */
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	/**
	 * @return the fechaModificacion
	 */
	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the usuarioRegistro
	 */
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}
	/**
	 * @param usuarioRegistro the usuarioRegistro to set
	 */
	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}
	/**
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}
	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
}
