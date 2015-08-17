package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;

public interface IValidacionAgruparOrdenCompraGestor {

	//TODO
	public abstract void validarObtenerCDPorAreaTrabajo(AreaTrabajoDTO areaTrabajoDTO) throws SICException;

	public abstract void validarObtenerTipoPedido(CatalogoValorDTO catalogoValorDTO) throws SICException;

	public abstract void validarObtenerSubbodegaCD(BodegaDTO bodegaDTO) throws SICException;

	public abstract void validarObtenerProveedor(VistaProveedorDTO vistaProveedorDTO) throws SICException;

	public abstract void validarObtenerListaOrdenesProveedor(OrdenCompraEstadoDTO ordenCompraEstadoDTO) throws SICException;

}