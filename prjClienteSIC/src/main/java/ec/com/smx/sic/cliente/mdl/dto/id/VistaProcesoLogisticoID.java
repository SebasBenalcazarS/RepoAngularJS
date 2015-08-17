package ec.com.smx.sic.cliente.mdl.dto.id;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;


@SuppressWarnings("serial")
public class VistaProcesoLogisticoID extends BaseID {
	
	private Integer codigoCompania ;
	private Long codigoProcesoLogistico;
	private Long codigoRecepcionProveedor;
	private String codigoProveedor;
//	private Long codigoTarea;
	private Integer codigoAreaTrabajoSubBodega;
	
	private Integer numeroRegistro;
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}
	public Long getCodigoRecepcionProveedor() {
		return codigoRecepcionProveedor;
	}
	public void setCodigoRecepcionProveedor(Long codigoRecepcionProveedor) {
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
	}
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
//	public Long getCodigoTarea() {
//		return codigoTarea;
//	}
//	public void setCodigoTarea(Long codigoTarea) {
//		this.codigoTarea = codigoTarea;
//	}
	public Integer getCodigoAreaTrabajoSubBodega() {
		return codigoAreaTrabajoSubBodega;
	}
	public void setCodigoAreaTrabajoSubBodega(Integer codigoAreaTrabajoSubBodega) {
		this.codigoAreaTrabajoSubBodega = codigoAreaTrabajoSubBodega;
	}
	/**
	 * @return the numeroRegistro
	 */
	public Integer getNumeroRegistro() {
		return numeroRegistro;
	}
	/**
	 * @param numeroRegistro the numeroRegistro to set
	 */
	public void setNumeroRegistro(Integer numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	
}
