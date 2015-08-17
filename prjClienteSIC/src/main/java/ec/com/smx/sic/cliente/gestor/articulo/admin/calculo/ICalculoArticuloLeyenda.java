package ec.com.smx.sic.cliente.gestor.articulo.admin.calculo;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

public interface ICalculoArticuloLeyenda {

	public abstract void guardarArticuloLeyenda(ArticuloVO articuloVO) throws SICException;

}