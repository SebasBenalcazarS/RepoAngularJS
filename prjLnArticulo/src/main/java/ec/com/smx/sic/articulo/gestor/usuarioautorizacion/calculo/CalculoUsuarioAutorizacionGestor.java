package ec.com.smx.sic.articulo.gestor.usuarioautorizacion.calculo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;

import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoDTO;
import ec.com.smx.sic.administracion.persistence.dao.ParametroDAO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.usuarioautorizacion.calculo.ICalculoUsuarioAutorizacionGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioClasificacionProcesoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.ClasificacionVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloUnidadManejoDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.estructuracomercial.IClasificacionDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.funcionario.IFuncionarioAreaTrabajoDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.usuarioautorizacion.IUsuarioArticuloDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.usuarioautorizacion.IUsuarioClasificacionProcesoDAO;
/**
 * 
 * @author cortiz
 *
 */

public class CalculoUsuarioAutorizacionGestor implements ICalculoUsuarioAutorizacionGestor{

	private IUsuarioArticuloDAO usuarioArticuloDAO;
	private IClasificacionDAO clasificacionDAO;
	private IFuncionarioAreaTrabajoDAO funcionarioAreaTrabajoDAO;
	private IArticuloUnidadManejoDAO articuloUnidadManejoDAO;
	private ParametroDAO parametroDAO;
	private IUsuarioClasificacionProcesoDAO usuarioClasificacionProcesoDAO;
	private IArticuloDAO articuloDAO;
	
	public void setUsuarioArticuloDAO(IUsuarioArticuloDAO usuarioArticuloDAO) {
		this.usuarioArticuloDAO = usuarioArticuloDAO;
	}


	public void setClasificacionDAO(IClasificacionDAO clasificacionDAO) {
		this.clasificacionDAO = clasificacionDAO;
	}


	public void setFuncionarioAreaTrabajoDAO(IFuncionarioAreaTrabajoDAO funcionarioAreaTrabajoDAO) {
		this.funcionarioAreaTrabajoDAO = funcionarioAreaTrabajoDAO;
	}


	public void setArticuloUnidadManejoDAO(IArticuloUnidadManejoDAO articuloUnidadManejoDAO) {
		this.articuloUnidadManejoDAO = articuloUnidadManejoDAO;
	}

	public void setParametroDAO(ParametroDAO parametroDAO) {
		this.parametroDAO = parametroDAO;
	}

	public void setUsuarioClasificacionProcesoDAO(IUsuarioClasificacionProcesoDAO usuarioClasificacionProcesoDAO) {
		this.usuarioClasificacionProcesoDAO = usuarioClasificacionProcesoDAO;
	}

	public void setArticuloDAO(IArticuloDAO articuloDAO) {
		this.articuloDAO = articuloDAO;
	}


	@Override
	public  Map<String, Object> obtenerArticulos(ArticuloVO articuloVO, String userId)throws SICException{
		try {
			Boolean paginador = Boolean.FALSE; 
			Integer numArt = 0;
			Collection<ArticuloDTO> articulos;
			articuloVO.getBaseDTO().setCodigoEstado(SICArticuloConstantes.ESTADOARTICULO_CODIFICADO);
			
			Collection<String> codigoArticulosCol = usuarioArticuloDAO.consultarCodigosArticulosAsignados(userId);
			
			Collection<String> codigoClasificacionAsignadasCol = usuarioArticuloDAO.consultarCodigosClasificacionesAsignados(userId);
			
			numArt = usuarioArticuloDAO.cuentaArticulos(articuloVO, userId,codigoArticulosCol,codigoClasificacionAsignadasCol);// RC    33
			
			if(articuloVO.getMaxResults() < numArt){
				paginador = Boolean.TRUE;
			}
			
			articulos = usuarioArticuloDAO.obtenerArticulos(articuloVO, userId, paginador,codigoArticulosCol,codigoClasificacionAsignadasCol);
    		//se agrega a los articulos su primera unidad de manejo
			if(CollectionUtils.isNotEmpty(articulos)){
				for(ArticuloDTO art: articulos){
					art.setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
					art.getArticuloUnidadManejoCol().addAll(articuloUnidadManejoDAO.obtenerUnidadManejoPorArticulo(art, 1));
				}
			}
			Map<String, Object> articulosNum= new HashMap<String, Object>();
			articulosNum.put("cantidad", numArt);
			articulosNum.put("articulos", articulos);
		return articulosNum;
		} catch (SICException e) {
			throw new SICException(e);
		}
	}
	
	@Override
	public  Collection<ClasificacionDTO> obtenerClasificaciones(ClasificacionVO clasificacionVO, String userId)throws SICException{
		try {
			Boolean paginador = Boolean.FALSE;
			Integer numCla = 0;
			Collection<ClasificacionDTO> clasificaciones;
			clasificacionVO.getBaseDTO().setCodigoTipoClasificacion(SICConstantes.TIPCLA_CLASIFICACION);
			clasificacionVO.getBaseDTO().setValorTipoEstructura(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL);
			clasificacionVO.getBaseDTO().setCodigoTipoEstructura(TiposCatalogoConstantes.TIPO_ESTRUCTURA);
			numCla=clasificacionDAO.cuentaClasificaciones(clasificacionVO, userId);
			if(clasificacionVO.getMaxResults() < numCla){
				paginador = Boolean.TRUE;
			}
			ParametroDTO parametro=parametroDAO.obtenerParametro(clasificacionVO.getBaseDTO().getId().getCodigoCompania(), SICParametros.PARAMETRO_NUMERO_MAXIMO_PERSONAS_ASIGNADAS_CLASIFICACION, SICConstantes.getInstancia().CODIGO_SISTEMA_MAX);
			ArrayList<String> codClaCol = usuarioClasificacionProcesoDAO.obtenerClasificacionesContarUsuario(clasificacionVO.getBaseDTO().getId().getCodigoCompania(), parametro.getValorParametro());
			clasificaciones = clasificacionDAO.obtenerClasificaciones(clasificacionVO, userId, paginador);
			for(String codCla: codClaCol){
				ClasificacionDTO clasificacionDTO= (ClasificacionDTO)CollectionUtils.find(clasificaciones,  new BeanPredicate("id.codigoClasificacion", PredicateUtils.equalPredicate(codCla)));
				if(clasificacionDTO != null){
					//clasificacionDTO.setEsAsignado(Boolean.TRUE);
					//Remover las clasificaciones que superan el límite asignado a los usuarios
					clasificaciones.remove(clasificacionDTO);
				}
			}
			return clasificaciones;
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar obtenerClasificaciones ");
			throw new SICException("Error al buscar obtenerClasificaciones ",e);
		}
	}
	
	@Override
	public Collection<ClasificacionDTO> obtenerClasificacionesUsuario(ClasificacionVO clasificacionVO, String userId)throws SICException{
		try {
			clasificacionVO.getBaseDTO().setCodigoTipoClasificacion(SICConstantes.TIPCLA_CLASIFICACION);
			clasificacionVO.getBaseDTO().setValorTipoEstructura(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL);
			clasificacionVO.getBaseDTO().setCodigoTipoEstructura(TiposCatalogoConstantes.TIPO_ESTRUCTURA);
			return clasificacionDAO.obtenerClasificacionesUsuario(clasificacionVO, userId);
			
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar obtenerClasificacionesUsuario ");
			throw new SICException("Error al buscar obtenerClasificacionesUsuario ",e);
		}
	}
	
	@Override
	public Collection<FuncionarioAreaTrabajoDTO> consultarFuncionarioAreaTrabajoPorAreaTrabajo(AreaTrabajoDTO areaTrabajo, String userId, String usuarioSesion)throws SICException{
		try {
			return funcionarioAreaTrabajoDAO.consultarFuncionarioAreaTrabajoPorAreaTrabajo(areaTrabajo.getId().getCodigoAreaTrabajo(), userId, areaTrabajo.getId().getCodigoCompania(), usuarioSesion);
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar consultarFuncionarioAreaTrabajoPorAreaTrabajo ");
			throw new SICException("Error al buscar consultarFuncionarioAreaTrabajoPorAreaTrabajo ",e);
		}
	}
	
	@Override
	public Collection<ArticuloDTO> obtenerArticulosUsuario(ArticuloVO articuloVO, String userId)throws SICException{
		try {
			articuloVO.getBaseDTO().setCodigoEstado(SICArticuloConstantes.ESTADOARTICULO_CODIFICADO);
			Collection<ArticuloDTO> articulos = usuarioArticuloDAO.obtenerArticulosUsuario(articuloVO, userId);
			//se agrega a los articulos su primera unidad de manejo
			if(CollectionUtils.isNotEmpty(articulos)){
				for(ArticuloDTO art: articulos){
					art.setArticuloUnidadManejoCol(new ArrayList<ArticuloUnidadManejoDTO>());
					art.getArticuloUnidadManejoCol().addAll(articuloUnidadManejoDAO.obtenerUnidadManejoPorArticulo(art, 1));
				}
			}
			return articulos;
			
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar obtenerArticulosUsuario ");
			throw new SICException("Error al buscar obtenerArticulosUsuario ",e);
		}
	}
	
	@Override
	public Collection<ClasificacionDTO> repotesClasificaciones(String codigoClasificacion, Integer codigoCompania, String usuario, Boolean disponible )throws SICException{
		try {
			ClasificacionVO clasificacionVO = new ClasificacionVO();
			clasificacionVO.setBaseDTO(new ClasificacionDTO());
			clasificacionVO.getBaseDTO().setCodigoTipoClasificacion(SICConstantes.TIPCLA_CLASIFICACION);
			clasificacionVO.getBaseDTO().setValorTipoEstructura(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL);
			clasificacionVO.getBaseDTO().setCodigoTipoEstructura(TiposCatalogoConstantes.TIPO_ESTRUCTURA);
			clasificacionVO.getBaseDTO().getId().setCodigoCompania(codigoCompania);
			ParametroDTO parametro=parametroDAO.obtenerParametro(clasificacionVO.getBaseDTO().getId().getCodigoCompania(), SICParametros.PARAMETRO_NUMERO_MAXIMO_PERSONAS_ASIGNADAS_CLASIFICACION, SICConstantes.getInstancia().CODIGO_SISTEMA_MAX);
			return clasificacionDAO.repotesClasificaciones(clasificacionVO, codigoClasificacion, codigoCompania, usuario, disponible, parametro.getValorParametro());
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar repotesClasificaciones ");
			throw new SICException("Error al buscar repotesClasificaciones ",e);
		}
	}
	
	@Override
	public Collection<UsuarioClasificacionProcesoDTO> reportesUsuarios(Integer codigoCompania, String codigoclasificacion, String user)throws SICException{
		try {
			return usuarioClasificacionProcesoDAO.reportesUsuarios(codigoCompania, codigoclasificacion, user);
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar reportesUsuarios ");
			throw new SICException("Error al buscar reportesUsuarios ",e);
		}
	}
	@Override
	public Collection<ClaseArticuloDTO> consultarClaseArticulos(Integer codigoCompania)throws SICException{
		return articuloDAO.consultarClaseArticulos(codigoCompania);
	}
}
