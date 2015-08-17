package ec.com.smx.sic.articulo.servicio;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.promocion.IArticuloPromocionGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloPromocionServicio;
/**
 * @author corbe
 */
public class ArticuloPromocionServicio implements IArticuloPromocionServicio{
	private IArticuloPromocionGestor articuloPromocionGestor;
	
	public Collection<GestionPrecioDTO> buscarPromociones() throws SICException {
		return this.articuloPromocionGestor.buscarPromociones();
	}
	
	public Collection<GestionPrecioDTO> buscarPromocionesCriterio(CriteriaSearchParameter<?> criteriaSearchParameter)throws SICException{
		return this.articuloPromocionGestor.buscarPromocionesCriterio(criteriaSearchParameter);
	}
	
	public Collection<ArticuloGestionPrecioDTO> buscarPromocionesArticulo(GestionPrecioDTO gestionPrecioDTO)throws SICException {
		return this.articuloPromocionGestor.buscarPromocionesArticulo(gestionPrecioDTO);
	}
	
	public void registrarPromocion(GestionPrecioDTO gestionPrecioDTO)throws SICException{
		this.articuloPromocionGestor.registrarPromocion(gestionPrecioDTO);
	}
	
	public void actualizarPromocion(GestionPrecioDTO gestionPrecioDTO)throws SICException{
		this.articuloPromocionGestor.actualizarPromocion(gestionPrecioDTO);
	}

	public void setArticuloPromocionGestor(IArticuloPromocionGestor articuloPromocionGestor) {
		this.articuloPromocionGestor = articuloPromocionGestor;
	}
	
	
}
