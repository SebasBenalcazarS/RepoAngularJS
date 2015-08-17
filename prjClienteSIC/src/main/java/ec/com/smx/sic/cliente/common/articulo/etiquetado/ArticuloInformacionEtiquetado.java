/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo.etiquetado;

/**
 * ESTRUCTURA QUE PERMITE SABER LOS VALORES DEL ARTICULO PARA
 * VALOR TRANSGENICO
 * APLICA REGISTRO SANITARIO
 * POSEE SEMAFORO
 * @author eharo
 *
 */
public class ArticuloInformacionEtiquetado {
	
	private EnumTransgenicoArticulo valorTransgenico;
	private String etiquetaValorTransgenico;
	private String aplicaRegistroSanitario;
	private Boolean tieneSemaforo;
	private String etiquetaTieneTransgenico;
	
	public ArticuloInformacionEtiquetado(EnumTransgenicoArticulo valorTransgenico, String etiquetaValorTransgenico, String aplicaRegistroSanitario, Boolean tieneSemaforo, String etiquetaTieneTransgenico) {
		super();
		this.valorTransgenico = valorTransgenico;
		this.etiquetaValorTransgenico = etiquetaValorTransgenico;
		this.aplicaRegistroSanitario = aplicaRegistroSanitario;
		this.tieneSemaforo = tieneSemaforo;
		this.etiquetaTieneTransgenico = etiquetaTieneTransgenico;
	}

	public EnumTransgenicoArticulo getValorTransgenico() {
		return valorTransgenico;
	}

	public void setValorTransgenico(EnumTransgenicoArticulo valorTransgenico) {
		this.valorTransgenico = valorTransgenico;
	}

	public String getEtiquetaValorTransgenico() {
		return etiquetaValorTransgenico;
	}

	public void setEtiquetaValorTransgenico(String etiquetaValorTransgenico) {
		this.etiquetaValorTransgenico = etiquetaValorTransgenico;
	}

	public String getAplicaRegistroSanitario() {
		return aplicaRegistroSanitario;
	}

	public void setAplicaRegistroSanitario(String aplicaRegistroSanitario) {
		this.aplicaRegistroSanitario = aplicaRegistroSanitario;
	}

	public Boolean getTieneSemaforo() {
		return tieneSemaforo;
	}

	public void setTieneSemaforo(Boolean tieneSemaforo) {
		this.tieneSemaforo = tieneSemaforo;
	}

	public String getEtiquetaTieneTransgenico() {
		return etiquetaTieneTransgenico;
	}

	public void setEtiquetaTieneTransgenico(String etiquetaTieneTransgenico) {
		this.etiquetaTieneTransgenico = etiquetaTieneTransgenico;
	}
}
