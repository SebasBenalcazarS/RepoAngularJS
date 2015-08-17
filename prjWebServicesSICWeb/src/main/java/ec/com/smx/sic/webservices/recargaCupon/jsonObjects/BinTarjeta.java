package ec.com.smx.sic.webservices.recargaCupon.jsonObjects;

/**
 * @author ediaz
 *
 */

public class BinTarjeta {
	
	private String codigo;
	private Integer rangoInicial;
	private Integer rangoFinal;
	private String imagen;
	private String description;
	private Long imagenId;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getRangoInicial() {
		return rangoInicial;
	}
	public void setRangoInicial(Integer rangoInicial) {
		this.rangoInicial = rangoInicial;
	}
	public Integer getRangoFinal() {
		return rangoFinal;
	}
	public void setRangoFinal(Integer rangoFinal) {
		this.rangoFinal = rangoFinal;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getImagenId() {
		return imagenId;
	}
	public void setImagenId(Long imagenId) {
		this.imagenId = imagenId;
	}
	
}
