package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;

public interface IParametroConvenioDAO {

	ParametroDTO buscarParametroPorCodigo(final String codigoParametro) throws SICException;
}
