package ec.com.smx.sic.cliente.gestor.articulo.admin.calculo;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface ICalculoArticuloProveedorNovedadGestor {

	public abstract void registrarNovedadArticuloProveedor(ArticuloVO articuloVO) throws SICException;

}