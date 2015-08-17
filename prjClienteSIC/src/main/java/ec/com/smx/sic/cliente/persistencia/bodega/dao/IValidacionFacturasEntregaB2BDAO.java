/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.framework.common.util.dto.RangeValue;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ProcesoLogisticoEntregaB2BEST;
import ec.com.smx.sic.cliente.mdl.vo.VistaProcesoLogisticoVO;

/**
 * @author jtoapanta
 *
 */
public interface IValidacionFacturasEntregaB2BDAO extends Logeable {
	
	
	
	/**
	 * 
	 * @param rangofechas
	 * @param valoresEstadoProcesoLogisticoS
	 * @return
	 * @throws SICException
	 */
	public Collection<ProcesoLogisticoEntregaB2BEST> obtenerArticulosRecibidosEnValidacionFacturas(RangeValue<Date> rangofechas) throws SICException; 
	
	/**
	 * 
	 * @param codigosEntregaCOL
	 * @return
	 * @throws SICException
	 */
	public Collection<ProcesoLogisticoEntregaB2BEST> obtenerArticulosRecibidosConEntrega(Collection<Long> codigosEntregaCOL) throws SICException; 
	
	/**
	 * 
	 * @param ordenCompraDetalleEstadoDTO
	 * @throws SICException
	 */
	public void actualizarCampoValidarProcesoDisponibilidad(Collection<Long> codigosRecepcionProveeedor)throws SICException;
	
	/**
	 * 
	 * @param codigosRecepcionS
	 * @return
	 * @throws SICException
	 */
	public Collection<ProcesoLogisticoEntregaB2BEST> obtenerRecepcionProveedorEntregaPLA(Collection<Long> codigosRecepcionS) throws SICException;
	
	/**
	 * Meoto que obtiene Procesos Logisticos creados desde el proceso de validacion Facturas SIC-B2B
	 * @param vistaProcesoLogisticoVO
	 * @param colEstadoProcesoLogisticoExcluir
	 * @param esFechaEspecifica
	 * @return
	 * @throws SICException
	 */
	Collection<VistaProcesoLogisticoDTO> obtenerProcesosLogisticosRecepcion (VistaProcesoLogisticoVO vistaProcesoLogisticoVO, 
			Collection<String> colEstadoProcesoLogisticoExcluir, Boolean esFechaEspecifica)throws SICException;

}
