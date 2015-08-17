package ec.com.smx.sic.articulo.gestor.usuarioautorizacion.almacenamiento;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.usuarioautorizacion.almacenamiento.IAlmacenamientoUsuarioAutorizacionGestor;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioClasificacionProcesoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.usuarioautorizacion.IUsuarioArticuloDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.usuarioautorizacion.IUsuarioClasificacionProcesoDAO;

/**
 * 
 * @author cortiz
 *
 */
public class AlmacenamientoUsuarioAutorizacionGestor implements IAlmacenamientoUsuarioAutorizacionGestor {

	private IUsuarioArticuloDAO usuarioArticuloDAO;
	private IUsuarioClasificacionProcesoDAO usuarioClasificacionProcesoDAO;
	DataGestor dataGestor;
	
	public void setUsuarioArticuloDAO(IUsuarioArticuloDAO usuarioArticuloDAO) {
		this.usuarioArticuloDAO = usuarioArticuloDAO;
	}
	
	public void setUsuarioClasificacionProcesoDAO(IUsuarioClasificacionProcesoDAO usuarioClasificacionProcesoDAO) {
		this.usuarioClasificacionProcesoDAO = usuarioClasificacionProcesoDAO;
	}

	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
	
	@Override
	public void guardarClasificacionesUsuario(UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO)throws SICException{
		Logeable.LOG_SICV2.info("Metodo : insertarClasificacionesUsuario");
		Logeable.LOG_SICV2.info("Parametros : ");
		Logeable.LOG_SICV2.info("codigo compania: "+ usuarioClasificacionProcesoDTO.getId().getCodigoCompania());
		Logeable.LOG_SICV2.info("codigo clasificacion: "+ usuarioClasificacionProcesoDTO.getId().getCodigoClasificacion());
		Logeable.LOG_SICV2.info("codigo usuario: "+ usuarioClasificacionProcesoDTO.getId().getCodigoUsuario());
		try {
			usuarioClasificacionProcesoDTO.setCodigoProceso(234L);//234
			
			usuarioClasificacionProcesoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			
			//valida si existe ya la relacion
			UsuarioClasificacionProcesoDTO usuCla=usuarioClasificacionProcesoDAO.buscarUsuarioCLasificacion(usuarioClasificacionProcesoDTO);
			if(usuCla != null){
				usuarioClasificacionProcesoDAO.actualizarUsuarioClasificacion(usuarioClasificacionProcesoDTO);
			}else{
				dataGestor.create(usuarioClasificacionProcesoDTO);
			}
			
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar guardarClasificacionesUsuario ");
			throw new SICException("Error al buscar guardarClasificacionesUsuario ",e);
		}
	}
	
	@Override
	public void desactivarClasificacionesUsuario(UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO)throws SICException{
		Logeable.LOG_SICV2.info("Metodo : desactivarClasificacionesUsuario");
		Logeable.LOG_SICV2.info("Parametros : ");
		Logeable.LOG_SICV2.info("codigo compania: "+ usuarioClasificacionProcesoDTO.getId().getCodigoCompania());
		Logeable.LOG_SICV2.info("codigo clasificacion: "+ usuarioClasificacionProcesoDTO.getId().getCodigoClasificacion());
		Logeable.LOG_SICV2.info("codigo usuario: "+ usuarioClasificacionProcesoDTO.getId().getCodigoUsuario());
		try {
			usuarioClasificacionProcesoDTO.setCodigoProceso(234L);//234
			usuarioClasificacionProcesoDTO.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
			
			usuarioClasificacionProcesoDAO.actualizarUsuarioClasificacion(usuarioClasificacionProcesoDTO);
			
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar guardarClasificacionesUsuario ");
			throw new SICException("Error al buscar guardarClasificacionesUsuario ",e);
		}
	}
	
	@Override
	public void desactivarArticulosUsuario(UsuarioArticuloDTO usuarioArticuloDTO)throws SICException{
		Logeable.LOG_SICV2.info("Metodo : desactivarArticulosUsuario");
		Logeable.LOG_SICV2.info("Parametros : ");
		Logeable.LOG_SICV2.info("codigo compania: "+ usuarioArticuloDTO.getId().getCodigoCompania());
		Logeable.LOG_SICV2.info("codigo articulo: "+ usuarioArticuloDTO.getId().getCodigoArticulo());
		Logeable.LOG_SICV2.info("codigo usuario: "+ usuarioArticuloDTO.getId().getCodigoUsuario());
		try {
			usuarioArticuloDTO.setCodigoProceso(235L);//235
			usuarioArticuloDTO.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
			
			usuarioArticuloDAO.actualizarUsuarioArticulo(usuarioArticuloDTO);
			
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar guardarArticulosUsuario ");
			throw new SICException("Error al buscar guardarArticulosUsuario ",e);
		}
	}
	
	@Override
	public void guardarArticulosUsuario(UsuarioArticuloDTO usuarioArticuloDTO)throws SICException{
		Logeable.LOG_SICV2.info("Metodo : insertarClasificacionesUsuario");
		Logeable.LOG_SICV2.info("Parametros : ");
		Logeable.LOG_SICV2.info("codigo compania: "+ usuarioArticuloDTO.getId().getCodigoCompania());
		Logeable.LOG_SICV2.info("codigo articulo: "+ usuarioArticuloDTO.getId().getCodigoArticulo());
		Logeable.LOG_SICV2.info("codigo usuario: "+ usuarioArticuloDTO.getId().getCodigoUsuario());
		try {
			usuarioArticuloDTO.setCodigoProceso(235L);//235
			usuarioArticuloDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			
			//valida si existe o no la relacion del articulo con el usuario
			UsuarioArticuloDTO usuArt=usuarioArticuloDAO.buscarUsuarioArticulo(usuarioArticuloDTO);
			if(usuArt != null){
				usuarioArticuloDAO.actualizarUsuarioArticulo(usuarioArticuloDTO);
			}else{
				dataGestor.create(usuarioArticuloDTO);
			}
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar guardarClasificacionesUsuario ");
			throw new SICException("Error al buscar guardarClasificacionesUsuario ",e);
		}
	}
	
	@Override
	public void inactivarClasificacionesFuncionario(String usuario, Integer codigoCompania)throws SICException{
		try {
			Collection<UsuarioClasificacionProcesoDTO> claUsu = usuarioClasificacionProcesoDAO.obtenerClasificacionesUsuario(codigoCompania, usuario);
			if(CollectionUtils.isNotEmpty(claUsu)){
				for (UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO : claUsu) {
					usuarioClasificacionProcesoDTO.setEstado(SICConstantes.ESTADO_INACTIVO_NUMERICO);
					usuarioClasificacionProcesoDAO.actualizarUsuarioClasificacion(usuarioClasificacionProcesoDTO);
				}
			}
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar inactivarClasificacionesFuncionario ");
			throw new SICException("Error al buscar inactivarClasificacionesFuncionario ",e);
		}
	}
	
	@Override
	public void intercambiarClasificacionesFuncionario(Integer codigoCompania, String usuario1, String usuario2 , Collection<UsuarioClasificacionProcesoDTO> calsificaciones)throws SICException{
		try {
			inactivarClasificacionesFuncionario(usuario1, codigoCompania);
			inactivarClasificacionesFuncionario(usuario2, codigoCompania);
			for (UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO : calsificaciones) {
				guardarClasificacionesUsuario(usuarioClasificacionProcesoDTO);
			}
			
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar intercambiarClasificacionesFuncionario ");
			throw new SICException("Error al buscar intercambiarClasificacionesFuncionario ",e);
		}
	}
	@Override
	public void reemplazarClasificacionesFuncionario( Collection<UsuarioClasificacionProcesoDTO> calsificaciones, String usuario,Integer codigoCompania)throws SICException{
		try {
			inactivarClasificacionesFuncionario(usuario, codigoCompania);
			for (UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO : calsificaciones) {
				guardarClasificacionesUsuario(usuarioClasificacionProcesoDTO);
			}
			
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar reemplazarClasificacionesFuncionario ");
			throw new SICException("Error al buscar reemplazarClasificacionesFuncionario ",e);
		}
	}
	
}
