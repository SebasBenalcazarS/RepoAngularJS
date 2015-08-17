package ec.com.smx.sic.cliente.gestor.convenio.negociacion;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;

public interface IParametroConvenioGestor {

	ParametroDTO buscarParametroPorCodigo(final String codigoParametro) throws SICException;
}
