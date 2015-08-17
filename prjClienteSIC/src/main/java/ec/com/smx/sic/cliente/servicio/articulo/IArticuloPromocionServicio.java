package ec.com.smx.sic.cliente.servicio.articulo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.GestionPrecioDTO;
/**
 * @author corbe
 */
public interface IArticuloPromocionServicio {
	
	public Collection<GestionPrecioDTO> buscarPromociones()throws SICException;
	
	public Collection<GestionPrecioDTO> buscarPromocionesCriterio(CriteriaSearchParameter<?> criteriaSearchParameter)throws SICException;
	
	public Collection<ArticuloGestionPrecioDTO> buscarPromocionesArticulo(GestionPrecioDTO gestionPrecioDTO)throws SICException;
	
	public void registrarPromocion(GestionPrecioDTO gestionPrecioDTO)throws SICException;
	
	public void actualizarPromocion(GestionPrecioDTO gestionPrecioDTO)throws SICException;
}
