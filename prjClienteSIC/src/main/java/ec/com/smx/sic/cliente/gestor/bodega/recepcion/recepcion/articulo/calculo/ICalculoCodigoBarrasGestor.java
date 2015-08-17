package ec.com.smx.sic.cliente.gestor.bodega.recepcion.recepcion.articulo.calculo;

import ec.com.smx.sic.cliente.exception.SICException;

public interface ICalculoCodigoBarrasGestor {
	
	String validaCodigoBarras(String codigoBarrasArticulo) throws SICException;
}
