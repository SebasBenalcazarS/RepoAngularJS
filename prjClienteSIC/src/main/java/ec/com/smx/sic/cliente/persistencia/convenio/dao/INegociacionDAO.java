package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleNegociacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleNegociacionGestionPrecioCovenioParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.NegociacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.NegociacionID;

/**
 * @author srodriguez
 * 2014-12-15
 */
public interface INegociacionDAO {
	
	/**
	 * @author srodriguez
	 * @param negociacionDTO
	 */
	void crearNegociacion(NegociacionDTO negociacionDTO, Integer codigoCompania, String usuarioAuditoria);
	
	/**
	 * @author srodriguez
	 * @param negociacionDTO
	 */
	void actualizarNegociacion(NegociacionDTO negociacionDTO, String idUsuarioAuditoria);
	
//	Collection< DetalleNegociacionDTO> findNegociacionesByCampania(Integer codigoCompania,Long codigoCampania);
	
	
	/**
	 * Metodo de INegociacionDAO.java, utilizado para encontrar negociaciones por campania o promocion
	 * srodriguez
	 * 30/1/2015
	 * @param codigoCompania
	 * @param condigoCampaniaOPromocion
	 * @return
	 * NegociacionDTO
	 */
	NegociacionDTO findNegociacionByGestionPrecio(Integer codigoCompania, Long condigoCampaniaOPromocion);
	
	/**
	 * Metodo de INegociacionDAO.java, utilizado  encontrar negociaciones por participacion
	 * srodriguez
	 * 30/1/2015
	 * @param codigoCompania
	 * @param codigoParticipacion
	 * @return
	 * NegociacionDTO
	 */
	NegociacionDTO findNegociacionPorParticipacion(Integer codigoCompania, Long codigoParticipacion);
	
	/**
	 * @author khidalgo
	 * @param negociacionID
	 * @return Boolean
	 */
	Boolean findExistsNegociacion(NegociacionID negociacionID);
	
	
	/**
	 * Metodo para los detalles de negociacion para guardar
	 * de articulos de un proveedor
	 * @param codigoCampania
	 * @return
	 */

	DetalleNegociacionGestionPrecioCovenioParticipanteDTO obtenerDatosNegociacionRegistroFecha(Integer codigoCompania, Long codigoGestionPrecioPromocion);
	/**
	 * Metodo que consulta las fechas y valores de cobros
	 */
	Collection<Long> obtenerCodigoDetNegGesPreConParDeFechasFaltantes(Long codigoPromocion,Integer codigoCompania);
	
	/**
	 * Obtiene los detalles de una negociacion
	 * @param codigoCompania
	 * @param codigoNegociacion
	 * @return
	 */
	Collection<DetalleNegociacionDTO> findListaDetalleNegociacionByNegociacion(Integer codigoCompania, Long codigoNegociacion);
	
	/**
	 * Obtiene la utima fecha de cobro
	 * @param codDetNegGesPreConPar
	 * @return
	 */
	HashMap<Long, Date> obtenerFechasCobroRegistradasByCodDetNegociacion(Collection<Long> codDetNegGesPreConPar);
	
	/**
	 * Metodo para obtener la cantidad de fechas generadas para un especifico detalleNegociacion de un participante especifico
	 * @param codigoCompania
	 * @param codDetNegGesPreConPar
	 */
	public Long obtenerNumeroFechasGeneradasByCodDetNegociacion(Integer codigoCompania,Long codDetNegGesPreConPar) throws SICException;
}
