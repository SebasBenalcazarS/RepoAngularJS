package ec.com.smx.sic.cliente.gestor.pedidoAsistido.calculo;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.pedidoAsistido.DiasConfiguracionPedidoAsistido;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.DatosBusquedaAreaTrabajoEST;

/**
 * @author aguato
 *
 */
public interface IObtencionDatosConfiguracionPedidoAsistidoGestor {

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoUsuario
	 * @param codigoPerfil
	 * @param datosBusquedaAreaTrabajoEST
	 * @throws SICException
	 */
	public void inicializarDatosBusquedaAreaTrabajo(Integer codigoCompania, String codigoFuncionario, String codigoUsuario, String codigoPerfil, DatosBusquedaAreaTrabajoEST datosBusquedaAreaTrabajoEST) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoPerfil
	 * @param cabecerasTablaConfiguracion
	 * @param diasConfiguracion
	 * @param tiposBloqueo
	 * @throws SICException
	 */
	public void inicializarConfiguracionPedidoAsistido(Integer codigoCompania, String codigoFuncionario, String codigoPerfil, 
			List<String> cabecerasTablaConfiguracion, Collection<DiasConfiguracionPedidoAsistido> diasConfiguracion,
			Collection<CatalogoValorDTO> tiposBloqueo) throws SICException;
	
	/**
	 * @param codigoCentroDistribucion
	 * @param codigoSubbodega
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> obtenerAreaSubLugarTrabajo(Integer codigoCentroDistribucion, Integer codigoAreaTrabajoSubbodega, HashSet<Integer> codigosAreaTrabajoSubbodega, Integer codigoCompania) throws SICException;
	
}
