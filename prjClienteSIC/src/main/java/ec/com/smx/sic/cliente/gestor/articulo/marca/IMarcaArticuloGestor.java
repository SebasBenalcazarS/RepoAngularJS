package ec.com.smx.sic.cliente.gestor.articulo.marca;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.BusquedaSimpleArticuloVO;

public interface IMarcaArticuloGestor {
	
	public Collection<MarcaArticuloDTO> findMarcaArticuloFiltro(Integer first, Integer pageSize, Integer codigoCompania, BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException;
	
	public Integer totalMarcaArticuloFiltro(Integer codigoCompania, BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException;

}
