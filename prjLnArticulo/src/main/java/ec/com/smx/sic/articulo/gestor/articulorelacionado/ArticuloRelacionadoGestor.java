/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.articulorelacionado;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.articulorelacionado.IArticuloRelacionadoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.relacionado.IArticuloRelacionadoDAO;

/** 
 * Gestor que maneja las reglas de negocio para la informacion de articulos relacionados
 * @author mgranda, gortiz
 */
public class ArticuloRelacionadoGestor implements IArticuloRelacionadoGestor, Logeable {
	
	private DataGestor dataGestor;
	
	private IArticuloRelacionadoDAO articuloRelacionadoDAO;
	
	public void registrarArticulosRelacionados( Collection<ArticuloRelacionDTO> articulosRelacionados ){
		if( CollectionUtils.isNotEmpty( articulosRelacionados ) ){
			for( ArticuloRelacionDTO articuloRelacionDTO : articulosRelacionados ){
				this.registrarArticuloRelacionado(articuloRelacionDTO);
			}
		}
	}
	
	public void registrarArticuloRelacionado( final ArticuloRelacionDTO articuloRelacionDTO ){
		if( articuloRelacionDTO != null ){
			this.validarConsistenciaDatos(articuloRelacionDTO);
			this.dataGestor.createOrUpdate(articuloRelacionDTO);
		}
	}
	
	/**
	 * 
	 * @param articuloRelacionDTO
	 */
	private void validarConsistenciaDatos( final ArticuloRelacionDTO articuloRelacionDTO ){
		if( articuloRelacionDTO != null ){
			if( articuloRelacionDTO.getId().getCodigoCompania() == null )
				throw new SICException("El campo codigoArticulo no puede ser nulo");
			
			if( articuloRelacionDTO.getId().getCodigoArticulo() == null )
				throw new SICException("El campo codigoCompania no puede ser nulo");
			
			if( articuloRelacionDTO.getId().getCodigoArticuloRelacionado() == null )
				throw new SICException("El campo codigoArticuloRelacionado no puede ser nulo");
			
		}
	}
	
	/**
	 * Metodo que permite relacionar uno o varios articulos con un tipo de relacion especifica con un articulo principal
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param valorTipoRelacion
	 * @param userId
	 * @param codigosArticulosRelacionados
	 * @return
	 * @throws SICException
	 */
	@Override
	public Integer relacionarArticulo(Integer codigoCompania, String codigoArticulo, String valorTipoRelacion, String userId, String... codigosArticulosRelacionados) throws SICException{
		if(codigoCompania == null){
			throw new SICException("El c\u00F3digo de compania es requerido.");
		}
		
		if(codigoArticulo == null){
			throw new SICException("El c\u00F3digo del art\u00EDculo es requerido.");
		}
		
		if(valorTipoRelacion == null){
			throw new SICException("El tipo de relacion es requerido.");
		}
		
		if(userId == null){
			throw new SICException("El usuario de registro es requerido.");
		}
		
		if(codigosArticulosRelacionados == null){
			throw new SICException("Los c\u00F3digos de art\u00ED culos relacionados son requeridos.");
		}
		
		return this.articuloRelacionadoDAO.relacionarArticulo(codigoCompania, codigoArticulo, valorTipoRelacion, userId, codigosArticulosRelacionados);
	}

	/**
	 * @param dataGestor the dataGestor to set
	 */
	public final void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
	
	public void setArticuloRelacionadoDAO(IArticuloRelacionadoDAO articuloRelacionadoDAO) {
		this.articuloRelacionadoDAO = articuloRelacionadoDAO;
	}
}
