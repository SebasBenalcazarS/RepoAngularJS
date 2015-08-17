/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CompaniaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.TipoEquivalenciaID;

/**
 * @author fmunoz
 * 
 */
@Entity
@Table(name = "SCSADTTIPEQU")
@SuppressWarnings("serial")
public class TipoEquivalenciaDTO extends SimpleAuditDTO {

	@EmbeddedId
	private TipoEquivalenciaID id = new TipoEquivalenciaID();

	/**
	 * Nombre del tipo de equivalencia
	 * 
	 */
	@Column(name="NOMTIPEQU")
	private String nombreTipoEquivalencia;

	/**
	 * Relacion con la compania
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false)
	private CompaniaDTO companiaDTO;

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public TipoEquivalenciaID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(TipoEquivalenciaID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>nombreTipoEquivalencia</code>
	 * 
	 * @return Retorna valor de propiedad <code>nombreTipoEquivalencia</code>
	 */
	public String getNombreTipoEquivalencia() {
		return this.nombreTipoEquivalencia;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>nombreTipoEquivalencia</code>.
	 * 
	 * @param nombreTipoEquivalencia1
	 *            El valor a establecer para la propiedad <code>nombreTipoEquivalencia</code>.
	 */
	public void setNombreTipoEquivalencia(String nombreTipoEquivalencia1) {
		this.nombreTipoEquivalencia = nombreTipoEquivalencia1;

		if (nombreTipoEquivalencia != null && nombreTipoEquivalencia.length() > 30) {
			nombreTipoEquivalencia = nombreTipoEquivalencia.substring(0, 30);
		}

	}

	/**
	 * Retorna valor de propiedad <code>companiaDTO</code>
	 * 
	 * @return Retorna valor de propiedad <code>companiaDTO</code>
	 */
	public CompaniaDTO getCompaniaDTO() {
		return this.companiaDTO;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>companiaDTO</code>.
	 * 
	 * @param companiaDTO1
	 *            El valor a establecer para la propiedad <code>companiaDTO</code>.
	 */
	public void setCompaniaDTO(CompaniaDTO companiaDTO1) {
		this.companiaDTO = companiaDTO1;
	}

}
