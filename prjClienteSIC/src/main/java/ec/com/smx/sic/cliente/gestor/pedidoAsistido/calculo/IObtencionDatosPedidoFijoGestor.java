package ec.com.smx.sic.cliente.gestor.pedidoAsistido.calculo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.vo.PedidoFijoVO;


public interface IObtencionDatosPedidoFijoGestor {

	public Collection<PedidoPlantillaAreaTrabajoDTO>  obtenerPedidosFijo(PedidoFijoVO pedidoFijoVO)throws SICException;
	
	public void obtenerArticulos(PedidoFijoVO pedidoFijoVO) throws SICException;
	
	public Collection<EstablecimientoDTO> obtenerFormatos( ) throws SICException;
	
	public UserDto obtenerInformacionUsuarioRegistro(String pUserId) throws SICException;
	
	public void obtenerLocales( PedidoFijoVO pedidoFijoVO);
	
}
