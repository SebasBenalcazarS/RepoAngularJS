package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.DetalleNegociacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.NegociacionDTO;

/**
 * @author srodriguez
 * 2014-11-29
 */
public interface INegociacionCobroDAO {

	/**
	 * @author srodriguez
	 * @param codigoCampania
	 * @param codigoPromocion
	 * @param codigoJDE
	 * @return
	 */
	Collection<DetalleNegociacionDTO> findNegociacionParaProveedor(String codigoCampania, String codigoPromocion, Integer codigoJDE);
	
	
	/** Metodo findNegociacionesParticipantes, utilizado para recuperar participantes con sus negociaciones
	 * @author khidalgo
	 * 23/2/2015
	 * @return
	 * @return Collection<NegociacionDTO>
	 */
	Collection<NegociacionDTO> findNegociacionesParticipantes (String codigoReferencia);
}
