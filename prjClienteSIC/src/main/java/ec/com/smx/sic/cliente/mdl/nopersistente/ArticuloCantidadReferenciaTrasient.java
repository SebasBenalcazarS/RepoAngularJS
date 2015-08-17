package ec.com.smx.sic.cliente.mdl.nopersistente;

public class ArticuloCantidadReferenciaTrasient {

	private String codigoArticulo;
	private Integer cantidadMaxima;
	private Integer cantidadActual;

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public Integer getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(Integer cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	public Integer getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(Integer cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

}
