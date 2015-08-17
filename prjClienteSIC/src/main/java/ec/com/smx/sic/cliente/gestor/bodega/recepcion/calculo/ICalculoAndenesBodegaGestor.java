package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleRecepcionEntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;

/**
 * 
 * @author acaiza
 *
 */
public interface ICalculoAndenesBodegaGestor {
	/**
	 * 
	 * @param recepcionProveedorDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleRecepcionEntregaDTO> obtenerAndenesDetalleRecepcionEntrega(RecepcionProveedorDTO recepcion) throws SICException;
	
	/**
	 * 
	 * @param catalogo
	 * @param codigoAreaTrabajoEntrega
	 * @param Collection<DetalleSeccionDTO>
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO obtenerAndenPorCategoria(CatalogoValorDTO catalogo, Collection<Integer> codigosAreaTrabajoEntregas,Collection<DetalleSeccionDTO> listTempDetSeccion) throws SICException;
	
	/**
	 * 	 
	 * @param Integer
	 * @param String numeroAnden
	 * @return Collection<DetalleTareaDTO>
	 * @throws SICException
	 */
	public Collection<DetalleTareaDTO> obtenerAndenesOcupados(Collection<Integer> codigosAreaTrabajoentregas, String numeroAnden) throws SICException;
	
	/**
	 * @param Collection<DetalleTareaDTO>
	 * @param EntregaDTO
	 * @return Collection<DetalleTareaDTO>
	 * @throws SICException
	 */
	public Collection<DetalleTareaDTO> obtenerAndenesLibres(Collection<DetalleTareaDTO> lisDetTareaOcupados, Collection<EntregaDTO> entregasSelect, RecepcionProveedorDTO recepcionSelect) throws SICException;
	
	
}
