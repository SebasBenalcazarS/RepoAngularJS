package ec.com.smx.sic.cliente.persistencia.pedidoAsistido.dao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoAreaTrabajoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.MonitoreoPedidoVO;


/**
 * 
 * @author bsandoval
 *
 */
public interface IMonitoreoPedidoDAO {
	
	List<Object[]> obtenerUsuariosBodegas(Integer codigoLocal, Collection<Integer> codigosSubbodega) throws SICException;
	
    Collection<PedidoAreaTrabajoDTO> obtenerPadresPedido(PedidoAreaTrabajoDTO pedidoPadre,Collection<Integer> codigosSubbodega, MonitoreoPedidoVO monitoreoVO) throws SICException;
    
    Collection<PedidoAreaTrabajoDTO> obtenerHijosPedido(PedidoAreaTrabajoDTO pedidoHijos, 	Collection<Long> codigosPedidoAreaTrabajo) throws SICException;
    
    Collection<PedidoAreaTrabajoClasificacionDTO> obtenerCalsificacionPorHijo(Collection<Long> codigosPedidoAreaTrabajoHijos) throws SICException;
    
    Collection<PedidoAreaTrabajoDTO> obtenerPadres(	PedidoAreaTrabajoDTO pedidoPadre,Collection<Long> codigosPedido) throws SICException;
    
    public Collection<PedidoAreaTrabajoEstadoDTO> obtenerEstados(Long codigoPedido ) throws SICException;
    
    public BigDecimal obtenerTotalVolumenPedidos(Date fechaPedido, String codigoTipoPedido, Integer codigoLocal);
    
    
	}
