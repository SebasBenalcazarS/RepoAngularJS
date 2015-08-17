package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.MigracionEstructuraLogisticaUbicacionesID;

@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTMIGUBIERR")
public class MigracionEstructuraLogisticaUbicacionesDTO extends SearchDTO{

	@Id
	private MigracionEstructuraLogisticaUbicacionesID id= new MigracionEstructuraLogisticaUbicacionesID();
	
	private Integer cd;
	private Integer bodega;
	private Integer subbodega;
	private Integer nave;
	private String subnave;
	private Integer pasillo;
	private Integer rack;
	private Integer nivel;
	private String tipoUbicacion;
	private String tipoAlmacenamiento;
	private String codigoBarras;
	private Integer valorUniMan;
	private Integer cantidad;
	private String fechaCaducidad;
	private String fechaRecepcion;
	private String observacion;
	
	@Column(name = "FECHAREGISTRO", nullable = false)
	private Timestamp fechaCreacion;
	
	public Integer getPasillo() {
		return pasillo;
	}
	public void setPasillo(Integer pasillo) {
		this.pasillo = pasillo;
	}
	public Integer getRack() {
		return rack;
	}
	public void setRack(Integer rack) {
		this.rack = rack;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public String getTipoUbicacion() {
		return tipoUbicacion;
	}
	public void setTipoUbicacion(String tipoUbicacion) {
		this.tipoUbicacion = tipoUbicacion;
	}
	public String getTipoAlmacenamiento() {
		return tipoAlmacenamiento;
	}
	public void setTipoAlmacenamiento(String tipoAlmacenamiento) {
		this.tipoAlmacenamiento = tipoAlmacenamiento;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public Integer getValorUniMan() {
		return valorUniMan;
	}
	public void setValorUniMan(Integer valorUniMan) {
		this.valorUniMan = valorUniMan;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getBodega() {
		return bodega;
	}
	public void setBodega(Integer bodega) {
		this.bodega = bodega;
	}
	public Integer getNave() {
		return nave;
	}
	public void setNave(Integer nave) {
		this.nave = nave;
	}
	public String getSubnave() {
		return subnave;
	}
	public void setSubnave(String subnave) {
		this.subnave = subnave;
	}
	public Integer getSubbodega() {
		return subbodega;
	}
	public void setSubbodega(Integer subbodega) {
		this.subbodega = subbodega;
	}
	public Integer getCd() {
		return cd;
	}
	public void setCd(Integer cd) {
		this.cd = cd;
	}
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public String getFechaRecepcion() {
		return fechaRecepcion;
	}
	public void setFechaRecepcion(String fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public MigracionEstructuraLogisticaUbicacionesID getId() {
		return id;
	}
	public void setId(MigracionEstructuraLogisticaUbicacionesID id) {
		this.id = id;
	}
	
}
