/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author wcaiza
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class TipoTareaFuncionarioLogisticoID implements Serializable {
	
	/**
	 * C&oacute;digo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	/**
	 * Especifica el c&oacute;digo del tipo tarea
	 *
	 */
	@Column(name = "CODIGOTIPOTAREA", nullable = false)
	private Long codigoTipoTarea ;
	
	/**
	 * 
	 */
	@Column(name="CODIGOFUNCIONARIOLOGISTICO", nullable = false)
	private Long codigoFuncionarioLogistico;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoTipoTarea
	 */
	public Long getCodigoTipoTarea() {
		return codigoTipoTarea;
	}

	/**
	 * @param codigoTipoTarea the codigoTipoTarea to set
	 */
	public void setCodigoTipoTarea(Long codigoTipoTarea) {
		this.codigoTipoTarea = codigoTipoTarea;
	}

	/**
	 * @return the codigoFuncionarioLogistico
	 */
	public Long getCodigoFuncionarioLogistico() {
		return codigoFuncionarioLogistico;
	}

	/**
	 * @param codigoFuncionarioLogistico the codigoFuncionarioLogistico to set
	 */
	public void setCodigoFuncionarioLogistico(Long codigoFuncionarioLogistico) {
		this.codigoFuncionarioLogistico = codigoFuncionarioLogistico;
	}
	
}
