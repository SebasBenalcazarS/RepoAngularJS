package ec.com.smx.sic.webservices.recargaCupon.jsonObjects;

/**
 * @author ediaz
 *
 */

public class Promotion {
	private Long id;
	private String tipo;
	private String nombreImagenCelular;
	private String nombreImagenTablet;
	private String nombreImagenDestacada;
	private String detalle;
	private Integer orden;
	private String name;
	private Long from;
	private Long to;
	private Integer codigoCompania;
	private String codigoArticulo;
	private String color;
	private Long phoneFileId;
	private Long tabletFileId;
	private Long specialFileId;

	public Promotion() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombreImagenCelular() {
		return nombreImagenCelular;
	}

	public void setNombreImagenCelular(String nombreImagenCelular) {
		this.nombreImagenCelular = nombreImagenCelular;
	}

	public String getNombreImagenTablet() {
		return nombreImagenTablet;
	}

	public void setNombreImagenTablet(String nombreImagenTablet) {
		this.nombreImagenTablet = nombreImagenTablet;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getFrom() {
		return from;
	}

	public void setFrom(Long from) {
		this.from = from;
	}

	public Long getTo() {
		return to;
	}

	public void setTo(Long to) {
		this.to = to;
	}

	public String getNombreImagenDestacada() {
		return nombreImagenDestacada;
	}

	public void setNombreImagenDestacada(String nombreImagenDestacada) {
		this.nombreImagenDestacada = nombreImagenDestacada;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getPhoneFileId() {
		return phoneFileId;
	}

	public void setPhoneFileId(Long phoneFileId) {
		this.phoneFileId = phoneFileId;
	}

	public Long getTabletFileId() {
		return tabletFileId;
	}

	public void setTabletFileId(Long tabletFileId) {
		this.tabletFileId = tabletFileId;
	}

	public Long getSpecialFileId() {
		return specialFileId;
	}

	public void setSpecialFileId(Long specialFileId) {
		this.specialFileId = specialFileId;
	}
	
}
