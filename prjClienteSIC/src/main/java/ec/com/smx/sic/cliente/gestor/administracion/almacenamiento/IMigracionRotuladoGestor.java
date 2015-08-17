package ec.com.smx.sic.cliente.gestor.administracion.almacenamiento;

import ec.com.smx.sic.cliente.exception.SICException;

public interface IMigracionRotuladoGestor {
	public void sincronizarComponetesRotulado(String codigoClasificacion) throws SICException;
}
