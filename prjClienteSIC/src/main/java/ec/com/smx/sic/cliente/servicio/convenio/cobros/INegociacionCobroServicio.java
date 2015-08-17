package ec.com.smx.sic.cliente.servicio.convenio.cobros;

import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.DetalleNegociacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.NegociacionDTO;

/**
 * @author srodriguez
 *
 */
public interface INegociacionCobroServicio {

	/**
	 * @author srodriguez
	 * @param codigoCampania
	 * @param codigoPromocion
	 * @param codigoJDE
	 * @return
	 */
	Collection<DetalleNegociacionDTO> findNegociacionParaProveedor(String codigoCampania, String codigoPromocion, Integer codigoJDE);

	/**
	 * @author srodriguez
	 * @param codigoCampania
	 * @param codigoPromocion
	 * @param codigoArticulo
	 * @return
	 */
	Collection<DetalleNegociacionDTO> findNegociacionesPorCobrar(String codigoCampania, String codigoPromocion, String codigoArticulo);
	
	/** Metodo findNegociacionesParticipantes, utilizado para recuperar participantes con sus negociaciones
	 * @author khidalgo
	 * 23/2/2015
	 * @return
	 * @return Collection<NegociacionDTO>
	 */
	Collection<NegociacionDTO> findNegociacionesParticipantes (String codigoReferencia);
	
	
	/** Metodo cobroPorNegociaciones, utilizado para
	 * @author srodriguez
	 * 24/2/2015
	 * @param codigoReferencia
	 * @return void
	 */
	void cobroPorNegociaciones(String codigoReferencia);
}
