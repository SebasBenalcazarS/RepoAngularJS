package ec.com.smx.sic.cliente.gestor.bodega.administracion.validacion;

import ec.com.smx.sic.cliente.common.bodega.EnumCatalogoValorBodega;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.SeccionDTO;
import ec.com.smx.sic.cliente.mdl.vo.SeccionVO;

public interface IValidacionBodegaGestor {

	/**
	 * 
	 * @param enumCatalogoValorBodega
	 * @throws SICException
	 */
	public abstract void obtenerBodegasPorValorTipoBodega(EnumCatalogoValorBodega enumCatalogoValorBodega) throws SICException;

	/**
	 * 
	 * @param codigoSubbodega
	 * @param enumCatalogoValorBodega
	 * @throws SICException
	 */
	public abstract void obtenerDetalleSecciones(String codigoSubbodega, EnumCatalogoValorBodega enumCatalogoValorBodega) throws SICException;

	/**
	 * 
	 * @param enumCatalogoValorBodega
	 * @param codigoFuncionario
	 * @throws SICException
	 */
	public abstract void obtenerSubbodegasPorFuncionarioComprador(String codigoFuncionario) throws SICException;

	/**
	 * @param seccionDTO
	 * @throws SICException
	 */
	public abstract void registrarSeccion(SeccionDTO seccionDTO) throws SICException;
	
	/**
	 * @param bodegaDTO
	 * @param codigoBodegaPadre
	 * @throws SICException
	 */
	public abstract void crearBodega(BodegaDTO bodegaDTO, String codigoBodegaPadre) throws SICException;
	
	/**
	 * @param seccionVO
	 * @throws SICException
	 */
	public abstract void obtenerSecciones(SeccionVO seccionVO) throws SICException;

	/**
	 * @param bodegaDTO
	 * @throws SICException
	 */
	public abstract void actualizarBodega(BodegaDTO bodegaDTO) throws SICException;

}