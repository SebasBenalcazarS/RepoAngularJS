/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Entity
public class ValorSecuenciaActual implements Serializable{

	@Id
	private Long valorSecuenia;
	private Long valorMaximo;
	private String identificador;
	
	public Long getValorSecuenia() {
		return valorSecuenia;
	}
	public void setValorSecuenia(Long valorSecuenia) {
		this.valorSecuenia = valorSecuenia;
	}
	public Long getValorMaximo() {
		return valorMaximo;
	}
	public void setValorMaximo(Long valorMaximo) {
		this.valorMaximo = valorMaximo;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
}
