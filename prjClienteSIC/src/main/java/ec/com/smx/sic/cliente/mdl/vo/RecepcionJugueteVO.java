/*
 * Kruger 2014 
 */ 
package ec.com.smx.sic.cliente.mdl.vo;

import java.util.List;

import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecepcionJugueteDTO;

/**
 * <b> VO que agrupar los datos necesarios para la recepcion de juguetes. </b>
 * 
 * @author mchiliquinga, Date: 17/04/2014
 * 
 */
public class RecepcionJugueteVO {

	private EntregaDTO entrega;
	
	private RecepcionProveedorDTO recepcionProveedor;
	
	private VistaProveedorDTO vistaProveedor;
	
	private List<VistaRecepcionJugueteDTO> recepcionJuguetesAgrupado;

	public EntregaDTO getEntrega() {
		return entrega;
	}

	public void setEntrega(EntregaDTO entrega) {
		this.entrega = entrega;
	}

	public RecepcionProveedorDTO getRecepcionProveedor() {
		return recepcionProveedor;
	}

	public void setRecepcionProveedor(RecepcionProveedorDTO recepcionProveedor) {
		this.recepcionProveedor = recepcionProveedor;
	}

	public VistaProveedorDTO getVistaProveedor() {
		return vistaProveedor;
	}

	public void setVistaProveedor(VistaProveedorDTO vistaProveedor) {
		this.vistaProveedor = vistaProveedor;
	}

	public List<VistaRecepcionJugueteDTO> getRecepcionJuguetesAgrupado() {
		return recepcionJuguetesAgrupado;
	}

	public void setRecepcionJuguetesAgrupado(List<VistaRecepcionJugueteDTO> recepcionJuguetesAgrupado) {
		this.recepcionJuguetesAgrupado = recepcionJuguetesAgrupado;
	}
	
}
