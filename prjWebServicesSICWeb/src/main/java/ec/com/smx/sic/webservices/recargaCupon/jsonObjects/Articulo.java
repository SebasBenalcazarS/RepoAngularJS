package ec.com.smx.sic.webservices.recargaCupon.jsonObjects;

import java.util.Collection;
import java.util.Date;

public class Articulo {
	private Collection<String> codigoBarras;
	
	private String valorTipoConvenio;
	
	private String descripcionArticulo;
	
	private Date fechaInicioVigencia;
	
	private Date fechaFinVigencia;
	
	private String codigoBarrasArticuloRelacionado;
	
	private String descripcionArticuloRelacionado;
	
	private String tituloCupon;
	
	private String nombreLocal;
	
	private String codigoLocal;

	public Collection<String> getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(Collection<String> codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getValorTipoConvenio() {
		return valorTipoConvenio;
	}

	public void setValorTipoConvenio(String valorTipoConvenio) {
		this.valorTipoConvenio = valorTipoConvenio;
	}

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public Date getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	public void setFechaInicioVigencia(Date fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	public Date getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	public void setFechaFinVigencia(Date fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	public String getCodigoBarrasArticuloRelacionado() {
		return codigoBarrasArticuloRelacionado;
	}

	public void setCodigoBarrasArticuloRelacionado(
			String codigoBarrasArticuloRelacionado) {
		this.codigoBarrasArticuloRelacionado = codigoBarrasArticuloRelacionado;
	}

	public String getDescripcionArticuloRelacionado() {
		return descripcionArticuloRelacionado;
	}

	public void setDescripcionArticuloRelacionado(
			String descripcionArticuloRelacionado) {
		this.descripcionArticuloRelacionado = descripcionArticuloRelacionado;
	}

	public String getTituloCupon() {
		return tituloCupon;
	}

	public void setTituloCupon(String tituloCupon) {
		this.tituloCupon = tituloCupon;
	}

	public String getNombreLocal() {
		return nombreLocal;
	}

	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}

	public String getCodigoLocal() {
		return codigoLocal;
	}

	public void setCodigoLocal(String codigoLocal) {
		this.codigoLocal = codigoLocal;
	}
	
	
}
