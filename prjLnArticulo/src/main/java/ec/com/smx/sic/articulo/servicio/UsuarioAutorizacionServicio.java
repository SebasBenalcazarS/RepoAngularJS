package ec.com.smx.sic.articulo.servicio;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.usuarioautorizacion.almacenamiento.IAlmacenamientoUsuarioAutorizacionGestor;
import ec.com.smx.sic.cliente.gestor.articulo.usuarioautorizacion.calculo.ICalculoUsuarioAutorizacionGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioClasificacionProcesoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.ClasificacionVO;
import ec.com.smx.sic.cliente.servicio.articulo.IUsuarioAutorizacionServicio;

public class UsuarioAutorizacionServicio implements IUsuarioAutorizacionServicio{

	public IAlmacenamientoUsuarioAutorizacionGestor almacenamientoUsuarioAutorizacionGestor;
	public ICalculoUsuarioAutorizacionGestor calculoUsuarioAutorizacionGestor;
	
	public void setAlmacenamientoUsuarioAutorizacionGestor(IAlmacenamientoUsuarioAutorizacionGestor almacenamientoUsuarioAutorizacionGestor) {
		this.almacenamientoUsuarioAutorizacionGestor = almacenamientoUsuarioAutorizacionGestor;
	}

	public void setCalculoUsuarioAutorizacionGestor(ICalculoUsuarioAutorizacionGestor calculoUsuarioAutorizacionGestor) {
		this.calculoUsuarioAutorizacionGestor = calculoUsuarioAutorizacionGestor;
	}

	@Override 
	public  Collection<ClasificacionDTO> obtenerClasificaciones(ClasificacionVO clasificacionVO, String userId)throws SICException{
		return calculoUsuarioAutorizacionGestor.obtenerClasificaciones(clasificacionVO, userId);
	}
	
	@Override
	public Collection<ClasificacionDTO> obtenerClasificacionesUsuario(ClasificacionVO clasificacionVO, String userId)throws SICException{
		return calculoUsuarioAutorizacionGestor.obtenerClasificacionesUsuario(clasificacionVO, userId);
	}
	
	@Override
	public Collection<FuncionarioAreaTrabajoDTO> consultarFuncionarioAreaTrabajoPorAreaTrabajo(AreaTrabajoDTO areaTrabajo, String userId, String usuarioSesion)throws SICException{
		return calculoUsuarioAutorizacionGestor.consultarFuncionarioAreaTrabajoPorAreaTrabajo(areaTrabajo, userId, usuarioSesion);
	}
	
	@Override
	public  Map<String, Object> obtenerArticulos(ArticuloVO articuloVO, String userId)throws SICException{
		return calculoUsuarioAutorizacionGestor.obtenerArticulos(articuloVO, userId);
	}
	
	@Override
	public Collection<ArticuloDTO> obtenerArticulosUsuario(ArticuloVO articuloVO, String userId)throws SICException{
		return calculoUsuarioAutorizacionGestor.obtenerArticulosUsuario(articuloVO, userId);
	}
	
	@Override
	public Collection<ClasificacionDTO> repotesClasificaciones(String codigoClasificacion, Integer codigoCompania, String usuario, Boolean disponible)throws SICException{
		return calculoUsuarioAutorizacionGestor.repotesClasificaciones(codigoClasificacion, codigoCompania, usuario, disponible);
	}
	
	@Override
	public Collection<UsuarioClasificacionProcesoDTO> reportesUsuarios(Integer codigoCompania, String codigoclasificacion, String user)throws SICException{
		return calculoUsuarioAutorizacionGestor.reportesUsuarios(codigoCompania, codigoclasificacion,  user);
	}
	
	@Override
	public Collection<ClaseArticuloDTO> consultarClaseArticulos(Integer codigoCompania)throws SICException{
		return calculoUsuarioAutorizacionGestor.consultarClaseArticulos(codigoCompania);
	}
	
	/****************************************************************************************************************************************
	 * metodos de insercion y modificacion de la autorizacion de usuarios
	 * 
	 * **************************************************************************************************************************************
	 */
	
	@Override
	public void guardarClasificacionesUsuario(UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO)throws SICException{
		almacenamientoUsuarioAutorizacionGestor.guardarClasificacionesUsuario(usuarioClasificacionProcesoDTO);
	}
	@Override
	public void guardarArticulosUsuario(UsuarioArticuloDTO usuarioArticuloDTO)throws SICException{
		almacenamientoUsuarioAutorizacionGestor.guardarArticulosUsuario(usuarioArticuloDTO);
	}
	@Override
	public void desactivarClasificacionesUsuario(UsuarioClasificacionProcesoDTO usuarioClasificacionProcesoDTO)throws SICException{
		almacenamientoUsuarioAutorizacionGestor.desactivarClasificacionesUsuario(usuarioClasificacionProcesoDTO);
	}
	@Override
	public void desactivarArticulosUsuario(UsuarioArticuloDTO usuarioArticuloDTO)throws SICException{
		almacenamientoUsuarioAutorizacionGestor.desactivarArticulosUsuario(usuarioArticuloDTO);
	}
	
	@Override
	public void inactivarClasificacionesFuncionario(String usuario, Integer codigoCompania)throws SICException{
		almacenamientoUsuarioAutorizacionGestor.inactivarClasificacionesFuncionario(usuario, codigoCompania);
	}
	
	@Override
	public void intercambiarClasificacionesFuncionario(Integer codigoCompania, String usuario1, String usuario2 , Collection<UsuarioClasificacionProcesoDTO> calsificaciones)throws SICException{
		almacenamientoUsuarioAutorizacionGestor.intercambiarClasificacionesFuncionario(codigoCompania, usuario1, usuario2, calsificaciones);
	}
	@Override
	public void reemplazarClasificacionesFuncionario( Collection<UsuarioClasificacionProcesoDTO> calsificaciones, String usuario, Integer codigoCompania )throws SICException{
		almacenamientoUsuarioAutorizacionGestor.reemplazarClasificacionesFuncionario( calsificaciones, usuario, codigoCompania );
	}
}
