package ec.com.smx.sic.cliente.servicio.convenio.negociacion;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;

public interface IParametroConvenioServicio {

	ParametroDTO buscarParametroPorCodigo(final String codigoParametro) throws SICException;
}
