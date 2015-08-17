package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.NegociacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.NegociacionArticuloID;

/**
 * @author srodriguez 
 * 2014-11-29
 */
public interface INegociacionArticuloDAO {
	
	/**
	 * @author khidalgo
	 * @param negociacionArticuloDTO
	 */
	void crearNegociacionArticulo(NegociacionArticuloDTO negociacionArticuloDTO,Integer codigoCompania, String usuarioAuditoria);
	
	/**
	 * @author khidalgo
	 * @param negociacionArticuloDTO
	 */
	void actualizarNegociacionArticulo(NegociacionArticuloDTO negociacionArticuloDTO,String usuarioAuditoria);
	
	/**
	 * @author khidalgo
	 * @param negociacionArticuloID
	 * @return
	 */
	Boolean findExistsNegociacionArticulo(NegociacionArticuloID negociacionArticuloID);
	
	
	/**
	 * Metodo de INegociacionArticuloDAO.java, utilizado para eliminar las negociacions por artivulo fisicamente
	 * @author srodriguez
	 * 30/1/2015
	 * @param negociacionArticuloDTO
	 * void
	 */
	void eliminarNegociacionArticuloFisico(NegociacionArticuloDTO negociacionArticuloDTO);
	
	/**
	 * Lista de negociacionArticulosCols
	 * @param codigoDetalleNegociacion
	 * @return
	 */
	Collection<NegociacionArticuloDTO> findNegociacionArticulosByCodigoDetalleNegociacion(Integer codigoCompania,Long codigoDetalleNegociacion);
	
}
