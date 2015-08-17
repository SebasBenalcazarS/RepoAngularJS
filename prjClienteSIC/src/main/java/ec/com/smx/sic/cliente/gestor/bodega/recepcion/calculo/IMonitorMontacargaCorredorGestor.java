package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaCatalogoTareaRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaMonitorMontacargaCorredorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaPalletsBultosNaveDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaPerfilMonitorRecolectorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaTareaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.VistaMonitorMontacargaCorredorVO;

public interface IMonitorMontacargaCorredorGestor {
	
	/**
	 * Obtener los tipos de proceso que aplican para el recolector (corredor) y montacarguista giova
	 * @return
	 * @throws SICException
	 */
	Collection<VistaPerfilMonitorRecolectorDTO> obtenerTipoProcesoMontacargaCorredor (Integer codigoCompania) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	VistaMonitorMontacargaCorredorVO obtenerVistaMonitorMontacargaCorredorPaginado (VistaMonitorMontacargaCorredorVO monitorMontacargaCorredorVO) throws SICException;
	
	/**
	 * Obtener el catalovo valor de los estados de un proceso de recepcion por el tipo de tarea perfil
	 * @param codigoCompania
	 * @param referenceCode
	 * @param incluirCatalogoNoPersistente
	 * @return
	 * @throws SICException
	 */
	Collection<VistaCatalogoTareaRecepcionDTO> obtenerCatalogoEstadoProcesoMontacargaRecolector (Integer codigoCompania, String referenceCode, Boolean incluirCatalogoNoPersistente) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	Collection<VistaMonitorMontacargaCorredorDTO> obtenerVistaMonitorMontacargaCorredorExcel (VistaMonitorMontacargaCorredorVO monitorMontacargaCorredorVO) throws SICException;
	
	/**
	 * 
	 * @param vistaTareaEstadoDTO
	 * @return
	 * @throws SICException
	 */
	Collection<VistaTareaEstadoDTO> obtenerVistaTareaEstadoRecursivo (VistaTareaEstadoDTO vistaTareaEstadoDTO, String codigoBarrasPallet) throws SICException;
	
	/**
	 * 
	 * @param vistaPalletsBultosNaveDTO
	 * @return
	 * @throws SICException
	 */
	Collection<VistaPalletsBultosNaveDTO> obtenerVistaPalletsBultosNave (VistaPalletsBultosNaveDTO vistaPalletsBultosNaveDTO) throws SICException;
	
	/**
	 * 
	 * @param codigoCatalogoTipo
	 * @return
	 * @throws SICException
	 */
	Collection<CatalogoValorDTO> obtenerCatalogoEstadosPallets(Integer codigoCatalogoTipo) throws SICException;

}
