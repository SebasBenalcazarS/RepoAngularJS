package ec.com.smx.sic.articulo.servicio;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.marca.IMarcaArticuloGestor;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.BusquedaSimpleArticuloVO;
import ec.com.smx.sic.cliente.servicio.articulo.IMarcaArticuloServicio;

public class MarcaArticuloServicio implements IMarcaArticuloServicio {

	IMarcaArticuloGestor marcaArticuloGestor;
	
	
	@Override
	public Collection<MarcaArticuloDTO> findMarcaArticuloFiltro(Integer first, Integer pageSize, Integer codigoCompania, BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException {
		return marcaArticuloGestor.findMarcaArticuloFiltro(first, pageSize, codigoCompania, busquedaSimpleArticuloVO);
	}

	@Override
	public Integer totalMarcaArticuloFiltro(Integer codigoCompania, BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException {
		return marcaArticuloGestor.totalMarcaArticuloFiltro(codigoCompania, busquedaSimpleArticuloVO);
	}
	
	/**
	 * @return the marcaArticuloGestor
	 */
	public IMarcaArticuloGestor getMarcaArticuloGestor() {
		return marcaArticuloGestor;
	}

	/**
	 * @param marcaArticuloGestor the marcaArticuloGestor to set
	 */
	public void setMarcaArticuloGestor(IMarcaArticuloGestor marcaArticuloGestor) {
		this.marcaArticuloGestor = marcaArticuloGestor;
	}

	
}
