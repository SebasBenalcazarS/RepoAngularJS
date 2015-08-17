/*
 * Creado el 13/06/2012
 *
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.FrecuenciaArticuloID;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSPETFREART")
public class FrecuenciaArticuloDTO extends SimpleAuditDTO
{
	/**
	 * 
	 */
	@EmbeddedId
    private FrecuenciaArticuloID id;
    private String estadoFrecuenciaArticulo;
    @RegisterUserIdField
    private String usuarioRegistro;
    @LastModifierUserIdField
    private String usuarioModificacion;
    @RegisterDateField
    private Timestamp fechaRegistro;
    @LastModificationDateField
    private Timestamp fechaModificacion;
    
    @ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOFRECUENCIA", referencedColumnName="CODIGOFRECUENCIA", insertable=false, updatable=false)})
    private FrecuenciaDTO frecuenciaDTO;
    @ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
    private ArticuloDTO articuloDTO;
    
    public FrecuenciaArticuloDTO() {
    	id = new FrecuenciaArticuloID();
	}
    public FrecuenciaArticuloDTO(Boolean initID) {
    	id = new FrecuenciaArticuloID(initID);
	}
	/**
	 * @return the id
	 */
	public FrecuenciaArticuloID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(FrecuenciaArticuloID id) {
		this.id = id;
	}
	/**
	 * @return the estadoFrecuenciaArticulo
	 */
	public String getEstadoFrecuenciaArticulo() {
		return estadoFrecuenciaArticulo;
	}
	/**
	 * @param estadoFrecuenciaArticulo the estadoFrecuenciaArticulo to set
	 */
	public void setEstadoFrecuenciaArticulo(String estadoFrecuenciaArticulo) {
		this.estadoFrecuenciaArticulo = estadoFrecuenciaArticulo;
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
	 * @return the frecuenciaDTO
	 */
	public FrecuenciaDTO getFrecuenciaDTO() {
		return frecuenciaDTO;
	}
	/**
	 * @param frecuenciaDTO the frecuenciaDTO to set
	 */
	public void setFrecuenciaDTO(FrecuenciaDTO frecuenciaDTO) {
		this.frecuenciaDTO = frecuenciaDTO;
	}
	/**
	 * @return the articuloDTO
	 */
	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}
	/**
	 * @param articuloDTO the articuloDTO to set
	 */
	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}
}
