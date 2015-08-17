package ec.com.smx.sic.cliente.gestor.bodega.administracion.validacion;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SeccionDTO;

public interface IValidacionEstructuraLogisticaGestor {
	/**
	 * Valida los datos previo al registro de una seccion
	 * @param seccionDTO
	 * @throws SICException
	 */
	public abstract void registrarSeccion(SeccionDTO seccionDTO) throws SICException;
	/**
	 * Valida los datos previo al registro de un detalleSeccion
	 * @param detalleSeccionDTO
	 * @throws SICException
	 */
	public abstract void registrarDetalleSeccion(DetalleSeccionDTO detalleSeccionDTO) throws SICException;
	/**
	 * Valida los datos previo a la creacion de una Bodega
	 * @param bodegaDTO
	 * @param codigoBodegaPadre
	 * @throws SICException
	 */
	public abstract void crearBodega(BodegaDTO bodegaDTO) throws SICException;
	/**
	 * Valida los datos previo a la eliminacion de la Seccion
	 * @param seccionDTO
	 * @throws SICException
	 */
	public abstract void eliminarSeccion(SeccionDTO seccionDTO) throws SICException;
	/**
	 * Valida los datos previo a la eliminacion del detalleSeccion
	 * @param detalleSeccionDTO
	 * @throws SICException
	 */
	public abstract void actualizarDetalleSeccion(DetalleSeccionDTO detalleSeccionDTO) throws SICException;
	/**
	 * Valida los datos previo a la eliminacion de una relacion detalleSeccion con seccion
	 * @param relacionSeccionDTO
	 * @throws SICException
	 */
	public abstract void eliminarRelacionSeccion(RelacionSeccionDTO relacionSeccionDTO) throws SICException;
	/**
	 * Valida los datos obligatorios de la entidad AreaTrabajo
	 * @param areaTrabajoDTO
	 * @throws SICException
	 */
	public void crearAreaTrabajo(AreaTrabajoDTO areaTrabajoDTO) throws SICException;
}
