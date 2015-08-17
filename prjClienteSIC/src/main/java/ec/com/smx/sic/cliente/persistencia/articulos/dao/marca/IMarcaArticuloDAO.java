package ec.com.smx.sic.cliente.persistencia.articulos.dao.marca;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.BusquedaSimpleArticuloVO;

public interface IMarcaArticuloDAO {
	
	public Collection<MarcaArticuloDTO> findMarcaArticuloFiltro(Integer first, Integer pageSize, Integer codigoCompania, BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException;
	
	public Integer totalMarcaArticuloFiltro(Integer codigoCompania, BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException;
}
