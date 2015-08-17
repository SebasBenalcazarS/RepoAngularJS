package ec.com.smx.sic.cliente.gestor.recipientes.calculo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.TransaccionCausalDTO;
import ec.com.smx.sic.cliente.common.recipientes.EnumCodigoInternoTipoTransaccionRecipeintes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ContenedorDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.ContenedorEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminContenedorVO;

public interface IObtenerDatosAlmacenamientoTransferenciasGestor {
	/**
	 * 
	 * @param adminContenedorVO
	 * @throws SICException
	 */
	public void inicializarTransferenciaContenedor(AdminContenedorVO adminContenedorVO,
												   AreaTrabajoDTO areaTrabajoOrigen) throws SICException;

	/**
	 * 
	 * @param adminContenedorVO
	 * @return
	 * @throws SICException
	 */
	public ContenedorDetalleDTO obtenerArticuloSuperSaldosLiquidacion (AdminContenedorVO adminContenedorVO, ContenedorDetalleDTO contenedorDetalleDTO) throws SICException;
	/**
	 * 
	 * @param adminContenedorVO
	 * @return
	 * @throws SICException
	 */
	public Collection<TransaccionCausalDTO> obtenerTransaccionCausales(AdminContenedorVO adminContenedorVO) throws SICException;

	/**
	 * 
	 * @param adminContenedorVO
	 * @param obtenerContenedorEstadoPlantilla
	 * @return
	 * @throws SICException
	 */
	public Collection<ContenedorEstadoDTO> obtenerEstadosContenedor (AdminContenedorVO adminContenedorVO, 
																	 ContenedorEstadoDTO obtenerContenedorEstadoPlantilla,
																	 EnumCodigoInternoTipoTransaccionRecipeintes codigoTipoTransaccion) throws SICException;
	
	/**
	 * 
	 * @param codigoDepartamento
	 * @return
	 * @throws SICException
	 */
	public ArticuloDTO obtenerArticuloContenedorTransferencia (String codigoDepartamento) throws SICException;
}
