package ec.com.smx.sic.articulo.gestor.marca;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.marca.IMarcaArticuloGestor;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.BusquedaSimpleArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.marca.IMarcaArticuloDAO;

public class MarcaArticuloGestor implements IMarcaArticuloGestor{
	
	private IMarcaArticuloDAO marcaArticuloDAO;

	@Override
	public Collection<MarcaArticuloDTO> findMarcaArticuloFiltro(Integer first, Integer pageSize, Integer codigoCompania, BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException {
		Collection<MarcaArticuloDTO> marcaArticuloCol = null;		
		try {
			if (first != null && pageSize != null && codigoCompania != null && busquedaSimpleArticuloVO != null) {
				marcaArticuloCol =  marcaArticuloDAO.findMarcaArticuloFiltro(first, pageSize, codigoCompania, busquedaSimpleArticuloVO);
			}
		} catch (Exception e) {
			throw new SICException(e.getMessage());
		}
		
		return marcaArticuloCol;
	}

	@Override
	public Integer totalMarcaArticuloFiltro(Integer codigoCompania, BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException {
		Integer totalMarcas = null;
		try {
			if (codigoCompania != null && busquedaSimpleArticuloVO != null) {
				totalMarcas = marcaArticuloDAO.totalMarcaArticuloFiltro(codigoCompania, busquedaSimpleArticuloVO);
			}
		} catch (Exception e) {
			throw new SICException(e.getMessage());
		}
		
		return totalMarcas;
	}
	
	/**
	 * @return the marcaArticuloDAO
	 */
	public IMarcaArticuloDAO getMarcaArticuloDAO() {
		return marcaArticuloDAO;
	}

	/**
	 * @param marcaArticuloDAO the marcaArticuloDAO to set
	 */
	public void setMarcaArticuloDAO(IMarcaArticuloDAO marcaArticuloDAO) {
		this.marcaArticuloDAO = marcaArticuloDAO;
	}

	

}
