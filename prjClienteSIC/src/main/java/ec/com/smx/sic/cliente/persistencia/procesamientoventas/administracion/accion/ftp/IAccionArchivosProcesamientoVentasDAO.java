package ec.com.smx.sic.cliente.persistencia.procesamientoventas.administracion.accion.ftp;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.corpv2.dto.ProcesoConfiguracionDTO;
import ec.com.smx.sic.cliente.exception.SICException;

public interface IAccionArchivosProcesamientoVentasDAO extends Serializable {

	/**
	 * 
	 * @param codigoProceso
	 * @throws SICException
	 */
	Collection<ProcesoConfiguracionDTO> consultarProcesoConfiguracion(final Long codigoProceso, final Integer codigoCompania) throws SICException;
}
