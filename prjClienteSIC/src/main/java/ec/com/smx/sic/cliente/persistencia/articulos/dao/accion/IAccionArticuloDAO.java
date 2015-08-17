package ec.com.smx.sic.cliente.persistencia.articulos.dao.accion;

import ec.com.smx.sic.cliente.exception.SICException;

public interface IAccionArticuloDAO {

	public void sincronizarInformacionArticuloLeyMercado(Integer codigoCompania)throws SICException;
	
}
