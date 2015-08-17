package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class DetalleCambioPrecioFuncionario implements Serializable {
	
	private Date fechaVigenciaPrecios;	
	private Date fechaVigenciaCostos;
	private Date fechaVigenciaRetornoCosto;
	private Date fechaVigenciaRetornoPrecio;
	private String userId;
	private String userName;	
	
	
	/*
	 * GETTERS AND SETTERS
	 */
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getFechaVigenciaPrecios() {
		return fechaVigenciaPrecios;
	}
	
	public void setFechaVigenciaPrecios(Date fechaVigenciaPrecios) {
		this.fechaVigenciaPrecios = fechaVigenciaPrecios;
	}
	
	public Date getFechaVigenciaCostos() {
		return fechaVigenciaCostos;
	}
	
	public void setFechaVigenciaCostos(Date fechaVigenciaCostos) {
		this.fechaVigenciaCostos = fechaVigenciaCostos;
	}
	
	public Date getFechaVigenciaRetornoCosto() {
		return fechaVigenciaRetornoCosto;
	}
	
	public void setFechaVigenciaRetornoCosto(Date fechaVigenciaRetornoCosto) {
		this.fechaVigenciaRetornoCosto = fechaVigenciaRetornoCosto;
	}
	
	public Date getFechaVigenciaRetornoPrecio() {
		return fechaVigenciaRetornoPrecio;
	}
	
	public void setFechaVigenciaRetornoPrecio(Date fechaVigenciaRetornoPrecio) {
		this.fechaVigenciaRetornoPrecio = fechaVigenciaRetornoPrecio;
	}
}
