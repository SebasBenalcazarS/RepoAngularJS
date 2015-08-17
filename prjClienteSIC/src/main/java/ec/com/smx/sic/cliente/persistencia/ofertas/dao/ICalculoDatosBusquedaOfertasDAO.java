package ec.com.smx.sic.cliente.persistencia.ofertas.dao;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.criterion.Criterion;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

public interface ICalculoDatosBusquedaOfertasDAO extends Serializable {

	/**
	 * Obtiene los datos de los articulos de una oferta dados criterios de busqueda
	 * 
	 * @param codigoCompania
	 * @param restriccionesFiltros
	 * @return
	 * @throws SICException
	 */
	Set<ArticuloDTO> obtenerDatosArticuloOferta(Integer codigoCompania, Criterion restriccionesFiltros) throws SICException;
	
}
