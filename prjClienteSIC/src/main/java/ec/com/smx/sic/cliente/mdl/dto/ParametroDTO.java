package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.frameworkv2.multicompany.dto.SystemDto;
import ec.com.smx.sic.cliente.mdl.dto.id.ParametroID;

/**
 * Entidada que almacena los registros de los par�metros del sistema SIC.
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity(name="ec.com.smx.sic.cliente.mdl.dto.ParametroDTO")
@Table(name="SCSPETPARAMETRO")
//TODO: Implementar campos de auditoria
public class ParametroDTO extends AuditoriaBaseDTO<ParametroID> {

	/**
	 * Descripcion del parametro
	 * 
	 */
	private String descripcionParametro;

	/**
	 * Valor del parametro
	 * 
	 */
	private String valorParametro;

	/**
	 * Campo para identificar a que Sistema pertenece el parametro. Los valores permitidos son: SISPE, SICMER, SICIMP.
	 * 
	 */
	@ComparatorTypeField
	private String grupoSistema;
	
	
	@ComparatorTypeField
	private String estado;
	

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "GRUPOSISTEMA", referencedColumnName = "SYSID", insertable = false, updatable = false)
	private SystemDto sistema;
	
	public ParametroDTO() {
		id = new ec.com.smx.sic.cliente.mdl.dto.id.ParametroID();
	}
	public ParametroDTO(Boolean initID) {
		id = new ec.com.smx.sic.cliente.mdl.dto.id.ParametroID(initID);
	}
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ParametroID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ParametroID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>descripcionParametro</code>
	 * 
	 * @return Retorna valor de propiedad <code>descripcionParametro</code>
	 */
	public String getDescripcionParametro() {
		return this.descripcionParametro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descripcionParametro</code>.
	 * 
	 * @param descripcionParametro1
	 *            El valor a establecer para la propiedad <code>descripcionParametro</code>.
	 */
	public void setDescripcionParametro(String descripcionParametro1) {
		this.descripcionParametro = descripcionParametro1 != null ? descripcionParametro1.toUpperCase() : null;

		if (descripcionParametro != null && descripcionParametro.length() > 200) {
			descripcionParametro = descripcionParametro.substring(0, 200);
		}

	}

	/**
	 * Retorna valor de propiedad <code>valorParametro</code>
	 * 
	 * @return Retorna valor de propiedad <code>valorParametro</code>
	 */
	public String getValorParametro() {
		return this.valorParametro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>valorParametro</code>.
	 * 
	 * @param valorParametro1
	 *            El valor a establecer para la propiedad <code>valorParametro</code>.
	 */
	public void setValorParametro(String valorParametro1) {
		this.valorParametro = valorParametro1;

		if (valorParametro != null && valorParametro.length() > 1000) {
			valorParametro = valorParametro.substring(0, 1000);
		}

	}

	/**
	 * Retorna valor de propiedad <code>grupoSistema</code>
	 * 
	 * @return Retorna valor de propiedad <code>grupoSistema</code>
	 */
	public String getGrupoSistema() {
		return this.grupoSistema;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>grupoSistema</code>.
	 * 
	 * @param grupoSistema1
	 *            El valor a establecer para la propiedad <code>grupoSistema</code>.
	 */
	public void setGrupoSistema(String grupoSistema1) {
		this.grupoSistema = grupoSistema1;

		if (grupoSistema != null && grupoSistema.length() > 64) {
			grupoSistema = grupoSistema.substring(0, 64);
		}

	}

	/**
	 * @return the sistema
	 */
	public SystemDto getSistema() {
		return sistema;
	}

	/**
	 * @param sistema the sistema to set
	 */
	public void setSistema(SystemDto sistema) {
		this.sistema = sistema;
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
	
	
}
