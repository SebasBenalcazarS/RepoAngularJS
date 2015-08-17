package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.validacion;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author cjara
 *
 */
public interface IValidacionDatosConfiguracionAfectacionPreciosGestor extends Serializable {
	Boolean validarDatosGrupoAfectacionPrecio(Long codigoGrupoAfectacionPrecio) throws SICException;
}
