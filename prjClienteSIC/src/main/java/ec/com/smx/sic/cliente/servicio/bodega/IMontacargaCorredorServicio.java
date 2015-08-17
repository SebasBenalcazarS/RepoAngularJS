package ec.com.smx.sic.cliente.servicio.bodega;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaCatalogoTareaRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaMonitorMontacargaCorredorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaPalletsBultosNaveDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaPerfilMonitorRecolectorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaTareaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.VistaMonitorMontacargaCorredorVO;

public interface IMontacargaCorredorServicio {
	
	/**
	 * Obtener los tipos de proceso que aplican para el recolector (corredor) y montacarguista
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
	VistaMonitorMontacargaCorredorVO obtenerVistaMonitorMontacargaCorredorPaginado (VistaMonitorMontacargaCorredorVO vistaMonitorMontacargaCorredorVO) throws SICException;
	
	/**
	 * Obtener el catalovo valor de los estados de un proceso de recepcion por el tipo de tarea perfil
	 * @param codigoCompania
	 * @param referenceCode
	 * @param incluirCatalogoNoPersistente
	 * @return
	 * @throws SICException
	 */
	Collection<VistaCatalogoTareaRecepcionDTO> obtenerCatalogoProcesoMontacargaRecolector(Integer codigoCompania, String referenceCode, Boolean incluirCatalogoNoPersistente) throws SICException;
	
	/**
	 * Obtener todos los datos del monitor montacarga corredor para exportar a un archivo excel
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	Collection<VistaMonitorMontacargaCorredorDTO> obtenerVistaMonitorMontacargaCorredorExcel(VistaMonitorMontacargaCorredorVO vistaMonitorMontacargaCorredorVO) throws SICException;
	
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
	Collection<CatalogoValorDTO> obtenerCatalogoValorEstadoPallets (Integer codigoCatalogoTipo) throws SICException;

}
