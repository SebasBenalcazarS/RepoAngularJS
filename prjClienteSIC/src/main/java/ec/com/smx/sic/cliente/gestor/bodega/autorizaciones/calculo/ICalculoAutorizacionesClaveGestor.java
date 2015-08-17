/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.autorizaciones.calculo;

import java.util.Collection;

import ec.com.smx.autorizaciones.dto.DatoClaveTipoAutorizacionUsuarioDTO;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jdvasquez
 *
 */
public interface ICalculoAutorizacionesClaveGestor {
	/**
	 * Obtiene el usuario autorizador mediante una clave ingresada
	 * @param codigoCompania
	 * @param clave
	 * @param codigoTipoAutorizacion
	 * @param codigoSistema
	 * @return
	 * @throws SICException
	 */
	public DatoClaveTipoAutorizacionUsuarioDTO obtenerUsuarioPorClave(Integer codigoCompania, String clave, Long codigoTipoAutorizacion, String codigoSistema) throws SICException;
	/**
	 * Obtiene una coleccion de areas de trabajo a las que pertenece un Usuario
	 * @param codigoCompania
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public Collection<Integer> obtenerAreasTrabajoUsuario(Integer codigoCompania, String userId) throws SICException;
	/**
	 * Obtiene el codigo de area de trabajo relacionado a un tipo de aurotizacion especifico
	 * @param codigoCompania
	 * @param codigoTipoAutorizacion
	 * @param codigoSistema
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerCodigoAreaTrabajoTipoAutorizacion(Integer codigoCompania, Long codigoTipoAutorizacion, String codigoSistema, Integer codigoAreaTrabajo) throws SICException;
	/**
	 * Obtiene el valor de la carcateristica en la tabla de confirguracion de caracteristicas con procesos y areas de trabajo
	 * @param codigoCompania
	 * @param codigoProceso
	 * @param codigoAreaTrabajo
	 * @param codigoCatalogoTipo
	 * @param codigoCatalogoValor
	 * @return
	 * @throws SICException
	 */
	public String obtenerValorCaracteristica(Integer codigoCompania, Long codigoProceso, Integer codigoAreaTrabajo, Integer codigoCatalogoTipo, String codigoCatalogoValor) throws SICException;
	

}
