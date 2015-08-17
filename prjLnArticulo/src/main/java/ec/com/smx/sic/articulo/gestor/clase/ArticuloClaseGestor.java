package ec.com.smx.sic.articulo.gestor.clase;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.clase.IArticuloClaseGestor;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloBitacoraClaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloClaseDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.clase.IArticuloBitacoraClaseDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.clase.IArticuloClaseDAO;

/**
 * 
 * @author mgranda
 *
 */
public class ArticuloClaseGestor implements IArticuloClaseGestor, Logeable {

	private IArticuloClaseDAO articuloClaseDAO;
	private IArticuloBitacoraClaseDAO articuloBitacoraClaseDAO;
		
	/**
	 * @author mgranda
	 * @param articuloClaseDTO
	 * @param esCreacion
	 * @throws SICException
	 */
	@Override
	public void registrarArticuloClase(ArticuloClaseDTO articuloClaseDTO) throws SICException{
		if(articuloClaseDTO.getId().getCodigoCompania() == null){
			throw new SICException("No existe codigo compania.");
		}
		if(articuloClaseDTO.getId().getCodigoArticulo() == null){
			throw new SICException("No existe codigo articulo.");
		}
		if(articuloClaseDTO.getClaseArticulo() == null){
			throw new SICException("No existe clase de articulo.");
		}
		if(articuloClaseDTO.getClaseArticuloAnterior() == null){
			throw new SICException("No existe clase anterior de articulo.");
		}
		if(articuloClaseDTO.getUserId() == null){
			throw new SICException("No existe userId.");
		}
		
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		ArticuloClaseDTO articuloClaseAnterior = null;
		
		if(articuloClaseDTO.getSecuencialArtCla() == null){
			if(!StringUtils.equals(articuloClaseDTO.getClaseArticulo(), articuloClaseDTO.getClaseArticuloAnterior()) ||
					(articuloClaseDTO.getCodigoTipoCausal() != null && articuloClaseDTO.getValorTipoCausal() != null)){
				articuloClaseDTO.setFechaCambioClase(currentTime);
				articuloClaseDTO.setIdUsuarioCambioClase(articuloClaseDTO.getUserId());
				this.articuloClaseDAO.crearArticuloClase(articuloClaseDTO);
			}
		}else{
			if(!StringUtils.equals(articuloClaseDTO.getClaseArticulo(), articuloClaseDTO.getClaseArticuloAnterior())){
				articuloClaseAnterior = this.articuloClaseDAO.obtenerUnicoArticuloClase(articuloClaseDTO.getSecuencialArtCla());
			}
			articuloClaseDTO.setFechaModificacion(currentTime);
			this.articuloClaseDAO.actualizarArticuloClase(articuloClaseDTO);			
		}
		this.registrarArticuloBitacoraClase(articuloClaseDTO, articuloClaseAnterior, currentTime);	
	}
	
	private void registrarArticuloBitacoraClase(ArticuloClaseDTO articuloClaseActual, ArticuloClaseDTO articuloClaseAnterior, Timestamp currentTime) throws SICException{
		if(!StringUtils.equals(articuloClaseActual.getClaseArticulo(), articuloClaseActual.getClaseArticuloAnterior())){			
			LOG_SICV2.info("==> Metodo de registro de bitacora para cambio de clase.");
			ArticuloBitacoraClaseDTO articuloBitacoraClaseDTO = new ArticuloBitacoraClaseDTO();
			articuloBitacoraClaseDTO.getId().setCodigoCompania(articuloClaseActual.getId().getCodigoCompania());
			articuloBitacoraClaseDTO.setCodigoArticulo(articuloClaseActual.getId().getCodigoArticulo());
			articuloBitacoraClaseDTO.setClaseArticulo(articuloClaseActual.getClaseArticuloAnterior());			
			if(articuloClaseAnterior != null){
				articuloBitacoraClaseDTO.setFechaInicio(articuloClaseAnterior.getFechaCambioClase());
				articuloBitacoraClaseDTO.setValorTipoCausal(articuloClaseAnterior.getValorTipoCausal());
				articuloBitacoraClaseDTO.setCodigoTipoCausal(articuloClaseAnterior.getCodigoTipoCausal());
				articuloBitacoraClaseDTO.setIdUsuarioCambioClase(articuloClaseAnterior.getIdUsuarioCambioClase());
			}
			articuloBitacoraClaseDTO.setFechaFin(currentTime);
			this.articuloBitacoraClaseDAO.crearArticuloBitacoraClase(articuloBitacoraClaseDTO);
		}
	}
	
	@Override
	public ArticuloClaseDTO obtenerArticuloClase(Integer codigoCompania, String codigoArticulo) throws SICException {
		ArticuloClaseDTO articuloClaseDTO = null;
		try{
			if(codigoCompania == null){
				throw new SICException("No existe codigo compania.");
			}
			if(codigoArticulo == null){
				throw new SICException("No existe codigo articulo.");
			}
			
			articuloClaseDTO = this.articuloClaseDAO.obtenerArticuloClase(codigoCompania, codigoArticulo);
			
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al obtener el articulo clase", e);
		}
		return articuloClaseDTO;
	}
	
	public Long obtenerTotalHistoricoClase(Integer codigoCompania, String codigoArticulo) throws SICException{
		return articuloBitacoraClaseDAO.obtenerTotalHistoricoClase(codigoCompania, codigoArticulo);
	}
	
	public List<ArticuloBitacoraClaseDTO> obtenerHistoricoClase(int firts, int pageSize, String sortField, Map<String, String> filters) throws SICException{
		return articuloBitacoraClaseDAO.obtenerHistoricoClase(firts, pageSize, sortField, filters);
	}

	public void setArticuloClaseDAO(IArticuloClaseDAO articuloClaseDAO) {
		this.articuloClaseDAO = articuloClaseDAO;
	}

	public void setArticuloBitacoraClaseDAO(IArticuloBitacoraClaseDAO articuloBitacoraClaseDAO) {
		this.articuloBitacoraClaseDAO = articuloBitacoraClaseDAO;
	}
}
