/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.DivisionGeoPoliticaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.EquivalenciaID;

/**
 * @author fmunoz
 * 
 */
@Entity
@Table(name="SCSADTEQUIVALENCIA")
@SuppressWarnings("serial")
public class EquivalenciaDTO extends SimpleAuditDTO {

	@EmbeddedId
	private EquivalenciaID id = new EquivalenciaID();

	private Boolean esPrincipal;
	
	/**
	 * Entidad que representa al tipo de equivalencia que pertenece
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),@JoinColumn(name = "CODTIPEQU", referencedColumnName = "CODTIPEQU", insertable = false, updatable = false)})
	private TipoEquivalenciaDTO tipoEquivalencia;

	@ManyToOne(fetch = LAZY)
	@JoinColumns(@JoinColumn(name="CODEQUMAX", insertable=false, updatable=false, referencedColumnName="CODIGODIVGEOPOL"))
	private DivisionGeoPoliticaDTO paisOrigen;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public EquivalenciaID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(EquivalenciaID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>tipoEquivalencia</code>
	 * 
	 * @return Retorna valor de propiedad <code>tipoEquivalencia</code>
	 */
	public TipoEquivalenciaDTO getTipoEquivalencia() {
		return this.tipoEquivalencia;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tipoEquivalencia</code>.
	 * 
	 * @param tipoEquivalencia1
	 *            El valor a establecer para la propiedad <code>tipoEquivalencia</code>.
	 */
	public void setTipoEquivalencia(TipoEquivalenciaDTO tipoEquivalencia1) {
		this.tipoEquivalencia = tipoEquivalencia1;
	}

	/**
	 * @return the paisOrigen
	 */
	public DivisionGeoPoliticaDTO getPaisOrigen() {
		return paisOrigen;
	}

	/**
	 * @param paisOrigen the paisOrigen to set
	 */
	public void setPaisOrigen(DivisionGeoPoliticaDTO paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	/**
	 * @return the esPrincipal
	 */
	public Boolean getEsPrincipal() {
		return esPrincipal;
	}

	/**
	 * @param esPrincipal the esPrincipal to set
	 */
	public void setEsPrincipal(Boolean esPrincipal) {
		this.esPrincipal = esPrincipal;
	}

}
