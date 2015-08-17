package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.common.bodega.EnumTipoChecklist;
import ec.com.smx.sic.cliente.common.bodega.EnumTipoEntrega;
import ec.com.smx.sic.cliente.common.proveedor.OrigenProveedor;

@Entity
@SuppressWarnings("serial")
public class VistaListaProveedoresRecepcionEntregaDTO extends SearchDTO {
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.VistaListaProveedoresRecepcionEntregaID id = new ec.com.smx.sic.cliente.mdl.dto.id.VistaListaProveedoresRecepcionEntregaID();
	
	private String codigoJDEProveedor;
	
	private Date fecha;
	
	private Integer cantidadFurgones;
	
	private String nombreProveedor;
	
	private String origenProveedor;
	
	@Transient
	private EnumTipoEntrega tipoEntrega; 
	
	@Transient
	private EnumTipoChecklist tipoChecklist;
	
	@Transient
	private String origenProveedorDescripcion;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.VistaListaProveedoresRecepcionEntregaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.VistaListaProveedoresRecepcionEntregaID id) {
		this.id = id;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the cantidadFurgones
	 */
	public Integer getCantidadFurgones() {
		return cantidadFurgones;
	}

	/**
	 * @param cantidadFurgones the cantidadFurgones to set
	 */
	public void setCantidadFurgones(Integer cantidadFurgones) {
		this.cantidadFurgones = cantidadFurgones;
	}

	/**
	 * @return the codigoJDEProveedor
	 */
	public String getCodigoJDEProveedor() {
		return codigoJDEProveedor;
	}

	/**
	 * @param codigoJDEProveedor the codigoJDEProveedor to set
	 */
	public void setCodigoJDEProveedor(String codigoJDEProveedor) {
		this.codigoJDEProveedor = codigoJDEProveedor;
	}

	/**
	 * @return the nombreProveedor
	 */
	public String getNombreProveedor() {
		return nombreProveedor;
	}

	/**
	 * @param nombreProveedor the nombreProveedor to set
	 */
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	/**
	 * @return the tipoEntrega
	 */
	public EnumTipoEntrega getTipoEntrega() {
		return tipoEntrega;
	}

	/**
	 * @param tipoEntrega the tipoEntrega to set
	 */
	public void setTipoEntrega(EnumTipoEntrega tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	/**
	 * @return the tipoChecklist
	 */
	public EnumTipoChecklist getTipoChecklist() {
		return tipoChecklist;
	}

	/**
	 * @param tipoChecklist the tipoChecklist to set
	 */
	public void setTipoChecklist(EnumTipoChecklist tipoChecklist) {
		this.tipoChecklist = tipoChecklist;
	}

	/**
	 * @return the origenProveedor
	 */
	public String getOrigenProveedor() {
		return origenProveedor;
	}

	/**
	 * @param origenProveedor the origenProveedor to set
	 */
	public void setOrigenProveedor(String origenProveedor) {
		this.origenProveedor = origenProveedor;
	}

	/**
	 * @return the origenProveedorDescripcion
	 */
	public String getOrigenProveedorDescripcion() {
		this.origenProveedorDescripcion = "";
		if(OrigenProveedor.IMPORTADO.getValue().equals(origenProveedor)){
			this.origenProveedorDescripcion = OrigenProveedor.IMPORTADO.getLabel();
		}
		if(OrigenProveedor.NACIONAL.getValue().equals(origenProveedor)){
			this.origenProveedorDescripcion = OrigenProveedor.NACIONAL.getLabel();
		}
		return this.origenProveedorDescripcion;
	}

	/**
	 * @param origenProveedorDescripcion the origenProveedorDescripcion to set
	 */
	public void setOrigenProveedorDescripcion(String origenProveedorDescripcion) {
		this.origenProveedorDescripcion = origenProveedorDescripcion;
	}

}
