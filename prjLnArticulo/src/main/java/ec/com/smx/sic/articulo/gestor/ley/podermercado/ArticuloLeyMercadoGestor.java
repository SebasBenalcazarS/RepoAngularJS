package ec.com.smx.sic.articulo.gestor.ley.podermercado;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.administracion.gestor.IParametroGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.articulo.EnumEstadoLeyMercado;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.ley.podermercado.IArticuloLeyMercadoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado.ArticuloBitacoraLeyMercadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado.ArticuloLeyMercadoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.ley.podermercado.IArticuloBitacoraLeyMercadoDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.ley.podermercado.IArticuloLeyMercadoDAO;

/**
 * Gestor encargado de la reglas de negocio referentes al registro y busqueda de la informacion de los estados del articulo segun la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
 * @author mgranda
 *
 */
public class ArticuloLeyMercadoGestor implements IArticuloLeyMercadoGestor, Logeable{

	//=============================================================================
	//							ATRIBUTOS
	//=============================================================================
	private IArticuloLeyMercadoDAO articuloLeyMercadoDAO;//DAO que registra la informacion de Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado del articulo
	private IArticuloBitacoraLeyMercadoDAO articuloBitacoraLeyMercadoDAO;//DAO que registra la informacion historica de la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado del articulo
	private IParametroGestor parametroGestor;//Gestor que obtiene la informacion de parametros
	private IArticuloDAO articuloDAO;//	DAO que obtiene la informacion de Articulos
	
	//=============================================================================
	//								METODOS
	//=============================================================================
	/**
	 * M\u00E9todo que permite registrar un art\u00EDculo con estado CODIFICADO seg\u00FAn la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
	 * @author mgranda
	 * @param articuloLeyMercadoDTO entidad que representa la informacion de Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado del articulo
	 * @throws SICException
	 */
	@Override
	public void codificarArticuloLeyMercado(ArticuloLeyMercadoDTO articuloLeyMercadoDTO) throws SICException{
		try{
			LOG_SICV2.info("==> Ingreso a codificacion de articulo segun ley de control de poder de mercado.");
			if(articuloLeyMercadoDTO.getId().getCodigoCompania() == null){
				throw new SICException("No existe codigo compania.");
			}
			if(articuloLeyMercadoDTO.getId().getCodigoArticulo() == null){
				throw new SICException("No existe codigo articulo.");
			}
			if(articuloLeyMercadoDTO.getUserId() == null){
				throw new SICException("No existe userId.");
			}
			
			articuloLeyMercadoDTO.setCodigoTipoEstado(EnumEstadoLeyMercado.CODIFICADO.getCodigoTipo());
			articuloLeyMercadoDTO.setValorTipoEstado(EnumEstadoLeyMercado.CODIFICADO.getCodigoValor());
			articuloLeyMercadoDTO.setIdUsuarioCambioEstado(articuloLeyMercadoDTO.getUserId());

			Long count = this.articuloLeyMercadoDAO.contarArticuloLeyMercado(articuloLeyMercadoDTO.getId().getCodigoCompania(), articuloLeyMercadoDTO.getId().getCodigoArticulo(), EnumEstadoLeyMercado.CODIFICADO);
			
			if(count.compareTo(0L) == 0){
				ParametroDTO parametroDTO = this.parametroGestor.obtenerParametro(articuloLeyMercadoDTO.getId().getCodigoCompania(), SICArticuloConstantes.PARAMETRO_FECHA_LEY_MERCADO);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    Date parsedDate = dateFormat.parse(parametroDTO.getValorParametro());
			    Date fechaCreacionArticulo = this.articuloDAO.obtenerFechaCreacionArticulo(articuloLeyMercadoDTO.getId().getCodigoCompania(), articuloLeyMercadoDTO.getId().getCodigoArticulo());
				
			    if(fechaCreacionArticulo.compareTo(parsedDate) > 0){
					Timestamp currentTime = new Timestamp(System.currentTimeMillis());
					articuloLeyMercadoDTO.setFechaCambioEstado(currentTime);
			    }else{
			    	articuloLeyMercadoDTO.setFechaCambioEstado(fechaCreacionArticulo);
			    }
				this.articuloLeyMercadoDAO.crearArticuloLeyMercado(articuloLeyMercadoDTO);
			}
		}catch(SICException e){
			throw e;
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al codificar el art\u00EDculo.", e);
		}
	}
	
	/**
	 * M\u00E9todo que permite registrar un art\u00EDculo con estado CODIFICADO seg\u00FAn la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param userId
	 * @throws SICException
	 */
	@Override
	public void codificarArticuloLeyMercado(Integer codigoCompania, String codigoArticulo, String userId) throws SICException{
		try{
			LOG_SICV2.info("==> Ingreso a codificacion de articulo segun ley de control de poder de mercado.");

			if(codigoCompania == null){
				throw new SICException("No existe codigo compania.");
			}
			if(codigoArticulo == null){
				throw new SICException("No existe codigo articulo.");
			}
			if(userId == null){
				throw new SICException("No existe userId.");
			}
			
			ArticuloLeyMercadoDTO articuloLeyMercadoDTO = new ArticuloLeyMercadoDTO();
			articuloLeyMercadoDTO.getId().setCodigoCompania(codigoCompania);
			articuloLeyMercadoDTO.getId().setCodigoArticulo(codigoArticulo);
			articuloLeyMercadoDTO.setUserId(userId);
			
			this.codificarArticuloLeyMercado(articuloLeyMercadoDTO);
			
		}catch(SICException e){
			throw e;
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al codificar el art\u00EDculo.", e);
		}
	}
	
	/**
	 * M\u00E9todo que permite registrar un art\u00EDculo con estado REACTIVADO seg\u00FAn la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param userId
	 * @throws SICException
	 */
	@Override
	public void reactivarArticuloLeyMercado(Integer codigoCompania, String codigoArticulo, String userId) throws SICException{
		try{
			LOG_SICV2.info("==> Ingreso a reactivacion de articulo segun ley de control de poder de mercado.");

			if(codigoCompania == null){
				throw new SICException("No existe codigo compania.");
			}
			if(codigoArticulo == null){
				throw new SICException("No existe codigo articulo.");
			}
			if(userId == null){
				throw new SICException("No existe userId.");
			}
			
			ArticuloLeyMercadoDTO articuloLeyMercadoDTO = new ArticuloLeyMercadoDTO();
			articuloLeyMercadoDTO.getId().setCodigoCompania(codigoCompania);
			articuloLeyMercadoDTO.getId().setCodigoArticulo(codigoArticulo);
			articuloLeyMercadoDTO.setUserId(userId);
			
			ArticuloLeyMercadoDTO articuloLeyMercadoAnterior = this.articuloLeyMercadoDAO.obtenerArticuloLeyMercado(articuloLeyMercadoDTO.getId().getCodigoCompania(), articuloLeyMercadoDTO.getId().getCodigoArticulo());
			
			if(StringUtils.equals(articuloLeyMercadoAnterior.getValorTipoEstado(), EnumEstadoLeyMercado.DESCODIFICADO.getCodigoValor())){				
				articuloLeyMercadoDTO.setCodigoTipoEstado(EnumEstadoLeyMercado.REACTIVADO.getCodigoTipo());
				articuloLeyMercadoDTO.setValorTipoEstado(EnumEstadoLeyMercado.REACTIVADO.getCodigoValor());
				articuloLeyMercadoDTO.setSecuencialArtLeyMer(articuloLeyMercadoAnterior.getSecuencialArtLeyMer());
				Timestamp currentTime = new Timestamp(System.currentTimeMillis());
				articuloLeyMercadoDTO.setFechaCambioEstado(currentTime);		
				this.articuloLeyMercadoDAO.actualizarArticuloLeyMercado(articuloLeyMercadoDTO);			
				this.registrarArticuloBitacoraLeyMercado(articuloLeyMercadoDTO, articuloLeyMercadoAnterior);
			}
			
		}catch(SICException e){
			throw e;
		}catch(Exception e){
			throw new SICException("001","Ha ocurrido un error al reactivar el art\u00EDculo.", e);
		}
	}
	
	/**
	 * M\u00E9todo que permite registrar un art\u00EDculo con estado DESCODIFICADO seg\u00FAn la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param userId
	 * @param codigoCausal
	 * @param valorCausal
	 * @throws SICException
	 */
	@Override
	public void descodificarArticuloLeyMercado(Integer codigoCompania, String codigoArticulo, String userId, Integer codigoCausal, String valorCausal) throws SICException{
		try{
			LOG_SICV2.info("==> Ingreso a descodificacion de articulo segun ley de control de poder de mercado.");

			if(codigoCompania == null){
				throw new SICException("No existe codigo compania.");
			}
			if(codigoArticulo == null){
				throw new SICException("No existe codigo articulo.");
			}
			if(userId == null){
				throw new SICException("No existe userId.");
			}
			
			ArticuloLeyMercadoDTO articuloLeyMercadoDTO = new ArticuloLeyMercadoDTO();
			articuloLeyMercadoDTO.getId().setCodigoCompania(codigoCompania);
			articuloLeyMercadoDTO.getId().setCodigoArticulo(codigoArticulo);
			articuloLeyMercadoDTO.setUserId(userId);
			articuloLeyMercadoDTO.setCodigoTipoCausal(codigoCausal);
			articuloLeyMercadoDTO.setValorTipoCausal(valorCausal);
			
			this.descodificarArticuloLeyMercado(articuloLeyMercadoDTO);
		}catch(SICException e){
			throw e;
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al codificar el art\u00EDculo.", e);
		}
	}
	
	/**
	 * M\u00E9todo que permite registrar un art\u00EDculo con estado DESCODIFICADO seg\u00FAn la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
	 * @author mgranda
	 * @param articuloLeyMercadoDTO entidad que representa la informacion de Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado del articulo
	 * @throws SICException
	 */
	@Override
	public void descodificarArticuloLeyMercado(ArticuloLeyMercadoDTO articuloLeyMercadoDTO) throws SICException{
		if(articuloLeyMercadoDTO.getId().getCodigoCompania() == null){
			throw new SICException("No existe codigo compania.");
		}
		if(articuloLeyMercadoDTO.getId().getCodigoArticulo() == null){
			throw new SICException("No existe codigo articulo.");
		}
		if(articuloLeyMercadoDTO.getUserId() == null){
			throw new SICException("No existe userId.");
		}
		if(StringUtils.isNotEmpty(articuloLeyMercadoDTO.getValorTipoCausal()) && articuloLeyMercadoDTO.getCodigoTipoCausal() == null){
			throw new SICException("No existe tipo de causal.");
		}
		if(StringUtils.isEmpty(articuloLeyMercadoDTO.getValorTipoCausal()) && articuloLeyMercadoDTO.getCodigoTipoCausal() != null){
			throw new SICException("No existe valor de causal.");
		}
		
		ArticuloLeyMercadoDTO articuloLeyMercadoAnterior = this.articuloLeyMercadoDAO.obtenerArticuloLeyMercado(articuloLeyMercadoDTO.getId().getCodigoCompania(), articuloLeyMercadoDTO.getId().getCodigoArticulo());
		
		if(articuloLeyMercadoAnterior == null){
			articuloLeyMercadoAnterior = new ArticuloLeyMercadoDTO();
			articuloLeyMercadoAnterior.getId().setCodigoCompania(articuloLeyMercadoDTO.getId().getCodigoCompania());
			articuloLeyMercadoAnterior.getId().setCodigoArticulo(articuloLeyMercadoDTO.getId().getCodigoArticulo());
			articuloLeyMercadoAnterior.setUserId(articuloLeyMercadoDTO.getUserId()); 
			this.codificarArticuloLeyMercado(articuloLeyMercadoAnterior);
		}
		
		if(!StringUtils.equals(articuloLeyMercadoAnterior.getValorTipoEstado(), EnumEstadoLeyMercado.DESCODIFICADO.getCodigoValor())){
			if(StringUtils.isEmpty(articuloLeyMercadoDTO.getValorTipoCausal()) ){
				throw new SICException("No existe valor de causal en descodificaci\u00F3n.");
			}
			if(articuloLeyMercadoDTO.getCodigoTipoCausal() == null){
				throw new SICException("No existe tipo de causal en descodificaci\u00F3n.");
			}
			articuloLeyMercadoDTO.setCodigoTipoEstado(EnumEstadoLeyMercado.DESCODIFICADO.getCodigoTipo());
			articuloLeyMercadoDTO.setValorTipoEstado(EnumEstadoLeyMercado.DESCODIFICADO.getCodigoValor());
			articuloLeyMercadoDTO.setIdUsuarioCambioEstado(articuloLeyMercadoDTO.getUserId());
			articuloLeyMercadoDTO.setSecuencialArtLeyMer(articuloLeyMercadoAnterior.getSecuencialArtLeyMer());
			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			articuloLeyMercadoDTO.setFechaCambioEstado(currentTime);		
			this.articuloLeyMercadoDAO.actualizarArticuloLeyMercado(articuloLeyMercadoDTO);			
			this.registrarArticuloBitacoraLeyMercado(articuloLeyMercadoDTO, articuloLeyMercadoAnterior);
		}		
	}	
	
	/**
	 * Metodo que permite registrar el historico de los estados del articulo segun la Ley Org\u00E1nica de Regulaci\u00F3n y Control del Poder de Mercado
	 * @author mgranda
	 * @param articuloLeyMercadoActual
	 * @param articuloLeyMercadoAnterior
	 * @throws SICException
	 */
	private void registrarArticuloBitacoraLeyMercado(ArticuloLeyMercadoDTO articuloLeyMercadoActual, ArticuloLeyMercadoDTO articuloLeyMercadoAnterior) throws SICException{
		try{
			ArticuloBitacoraLeyMercadoDTO articuloBitacoraLeyMercadoDTO = new ArticuloBitacoraLeyMercadoDTO();
			articuloBitacoraLeyMercadoDTO.getId().setCodigoCompania(articuloLeyMercadoActual.getId().getCodigoCompania());
			articuloBitacoraLeyMercadoDTO.setCodigoArticulo(articuloLeyMercadoActual.getId().getCodigoArticulo());
			articuloBitacoraLeyMercadoDTO.setCodigoTipoEstado(articuloLeyMercadoAnterior.getCodigoTipoEstado());
			articuloBitacoraLeyMercadoDTO.setValorTipoEstado(articuloLeyMercadoAnterior.getValorTipoEstado());
			articuloBitacoraLeyMercadoDTO.setIdUsuarioCambioEstado(articuloLeyMercadoAnterior.getIdUsuarioCambioEstado());
			articuloBitacoraLeyMercadoDTO.setFechaCambioEstado(articuloLeyMercadoAnterior.getFechaCambioEstado());
			articuloBitacoraLeyMercadoDTO.setCodigoTipoCausal(articuloLeyMercadoAnterior.getCodigoTipoCausal());
			articuloBitacoraLeyMercadoDTO.setValorTipoCausal(articuloLeyMercadoAnterior.getValorTipoCausal());
			this.articuloBitacoraLeyMercadoDAO.crearArticuloBitacoraLeyMercado(articuloBitacoraLeyMercadoDTO);
		}catch(SICException e){
			throw e;
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al registrar la BitacoraLeyMercado.", e);
		}
	}
	
	//TODO
	//=============================================================================
	//		METODOS DE ACCESO - GETTERS Y SETTERS
	//=============================================================================

	public void setArticuloLeyMercadoDAO(IArticuloLeyMercadoDAO articuloLeyMercadoDAO) {
		this.articuloLeyMercadoDAO = articuloLeyMercadoDAO;
	}

	public void setParametroGestor(IParametroGestor parametroGestor) {
		this.parametroGestor = parametroGestor;
	}

	public void setArticuloDAO(IArticuloDAO articuloDAO) {
		this.articuloDAO = articuloDAO;
	}

	public void setArticuloBitacoraLeyMercadoDAO(IArticuloBitacoraLeyMercadoDAO articuloBitacoraLeyMercadoDAO) {
		this.articuloBitacoraLeyMercadoDAO = articuloBitacoraLeyMercadoDAO;
	}

	@Override
	public ArticuloLeyMercadoDTO obtenerArticuloLeyMercado(Integer codigoCompania, String codigoArticulo) throws SICException {
		return articuloLeyMercadoDAO.obtenerArticuloLeydeMercado(codigoCompania, codigoArticulo);
	}

	@Override
	public List<ArticuloBitacoraLeyMercadoDTO> obtenerHistoricoLeyMercado(int first, int pageSize, String sortField, Map<String, String> filters) throws SICException {
		return articuloLeyMercadoDAO.obtenerHistoricoLeyMercado(first, pageSize, sortField, filters) ;
	}

	@Override
	public Long obtenerTotalHistoricoLeyMercado(Integer codigoCompania, String codigoArticulo) throws SICException {
		return articuloLeyMercadoDAO.obtenerTotalHistoricoLeyMercado(codigoCompania, codigoArticulo) ;
	}
}
