/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.EmbarqueFactorID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTEMBFCT")
public class EmbarqueFactorDTO extends AuditoriaBaseDTO<EmbarqueFactorID>{
	@Column(name = "CODIGOEMBARQUE")
	private Long codigoEmbarque;
	
	@Column(name = "CODIGOEMBARQUEESTADO")
	private Long codigoEmbarqueEstado;
	
	@Column(name = "FECHAINICIO")
	private Timestamp fechaInicio;
	
	@Column(name = "FECHAFIN")
	private Timestamp fechaFin;
	
	@Column(name = "FECHAENVIO")
	private Timestamp fechaEnvio;
	
	@Column(name = "NUMEROENVIO")
	private Integer numeroEnvio;

	/**
	 * @return devuelve el valor de la propiedad codigoEmbarque
	 */
	public Long getCodigoEmbarque() {
		return codigoEmbarque;
	}

	/**
	 * @param codigoEmbarque establece el valor a la propiedad codigoEmbarque
	 */
	public void setCodigoEmbarque(Long codigoEmbarque) {
		this.codigoEmbarque = codigoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoEmbarqueEstado
	 */
	public Long getCodigoEmbarqueEstado() {
		return codigoEmbarqueEstado;
	}

	/**
	 * @param codigoEmbarqueEstado establece el valor a la propiedad codigoEmbarqueEstado
	 */
	public void setCodigoEmbarqueEstado(Long codigoEmbarqueEstado) {
		this.codigoEmbarqueEstado = codigoEmbarqueEstado;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaInicio
	 */
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio establece el valor a la propiedad fechaInicio
	 */
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaFin
	 */
	public Timestamp getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin establece el valor a la propiedad fechaFin
	 */
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaEnvio
	 */
	public Timestamp getFechaEnvio() {
		return fechaEnvio;
	}

	/**
	 * @param fechaEnvio establece el valor a la propiedad fechaEnvio
	 */
	public void setFechaEnvio(Timestamp fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	/**
	 * @return devuelve el valor de la propiedad numeroEnvio
	 */
	public Integer getNumeroEnvio() {
		return numeroEnvio;
	}

	/**
	 * @param numeroEnvio establece el valor a la propiedad numeroEnvio
	 */
	public void setNumeroEnvio(Integer numeroEnvio) {
		this.numeroEnvio = numeroEnvio;
	}
	
}
