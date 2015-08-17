package ec.com.smx.sic.cliente.common;

import java.io.Serializable;

/**
 * @author lchasipanta
 *
 */
@SuppressWarnings("serial")
public class SemaforoEtiquetaModel implements Serializable{
	
	private Integer azucar;
	private Integer grasa;
	private Integer sal;
	
	public SemaforoEtiquetaModel() {
		super();
	}
	
	public SemaforoEtiquetaModel(Integer azucar, Integer grasa, Integer sal) {
		super();
		this.azucar = azucar;
		this.grasa = grasa;
		this.sal = sal;
	}

	public Integer getAzucar() {
		return azucar;
	}
	public void setAzucar(Integer azucar) {
		this.azucar = azucar;
	}
	
	public Integer getGrasa() {
		return grasa;
	}

	public void setGrasa(Integer grasa) {
		this.grasa = grasa;
	}

	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
}
