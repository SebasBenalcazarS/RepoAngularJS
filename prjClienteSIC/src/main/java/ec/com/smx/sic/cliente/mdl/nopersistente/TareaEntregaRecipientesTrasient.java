package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Date;

import javax.persistence.Id;

/**
 * Tareas que para el despacho de recipientes
 * @author amunoz
 *
 */
public class TareaEntregaRecipientesTrasient {

	@Id
	private Long codigoTarea;
	private Date fechaTarea;
	private String horaRegistro;
	private String codigoProveedor;
	private String nombreProveedor;
	private Integer cantidad;
	private String userNom;
	private String nombreCatalogo;
	private String horaInicio;
	private String horaFin;
	private String tiempo;
	

	
	public Long getCodigoTarea() {
		return codigoTarea;
	}
	public void setCodigoTarea(Long codigoTarea) {
		this.codigoTarea = codigoTarea;
	}
	public Date getFechaTarea() {
		return fechaTarea;
	}
	public void setFechaTarea(Date fechaTarea) {
		this.fechaTarea = fechaTarea;
	}
	
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getUserNom() {
		return userNom;
	}
	public void setUserNom(String userNom) {
		this.userNom = userNom;
	}
	public String getNombreCatalogo() {
		return nombreCatalogo;
	}
	public void setNombreCatalogo(String nombreCatalogo) {
		this.nombreCatalogo = nombreCatalogo;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getHoraRegistro() {
		return horaRegistro;
	}
	public void setHoraRegistro(String horaRegistro) {
		this.horaRegistro = horaRegistro;
	}
		
}
