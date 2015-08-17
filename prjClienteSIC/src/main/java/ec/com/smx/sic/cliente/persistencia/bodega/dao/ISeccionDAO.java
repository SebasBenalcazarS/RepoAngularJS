package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dao.BaseDAO;
import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SeccionDTO;
import ec.com.smx.sic.cliente.mdl.vo.SeccionVO;
import ec.com.smx.sic.integracion.dto.articulo.RegistrarUbicacionesArticuloDTO;

public interface ISeccionDAO {

	/**
	 * Permite la obtencion de secciones adicionando el numero de las 
	 * subsecciones que tiene
	 * @param seccionVO
	 * @return
	 */
	public abstract SeccionDTO obtenerSecciones(SeccionVO seccionVO);

	/**
	 * @return the baseDAO
	 */
	public abstract BaseDAO getBaseDAO();

	/**
	 * @return the hibernateHRelacionSeccion
	 */
	public abstract IHibernateH<RelacionSeccionDTO> getHibernateHRelacionSeccion();

	/**
	 * @param baseDAO the baseDAO to set
	 */
	public abstract void setBaseDAO(BaseDAO baseDAO);

	/**
	 * @param hibernateHRelacionSeccion the hibernateHRelacionSeccion to set
	 */
	public abstract void setHibernateHRelacionSeccion(
			IHibernateH<RelacionSeccionDTO> hibernateHRelacionSeccion);

	/**
	 * Devuelve la coleccion de la relacion de la plantilla de la seccion recibida
	 * @param seccionDTO
	 * @return SeccionDTO
	 * @throws SICException
	 */
	public SeccionDTO relacionSeccion(SeccionVO seccionVO)throws SICException;
	/**
	 * Permite saber si tiene relaciones activas en base a la plantilla
	 * @param relacionDTO
	 * @return Boolean
	 * @throws SICException
	 */
	public Boolean tieneRelaciones(RelacionSeccionDTO relacionSeccionDTO)throws SICException;
	
	/**
	 * Permite contar las naves que tiene la bodega
	 * @param areaTrabajoDTO
	 * @return
	 */
	public Integer cuentaNaves(Integer codaAeaTrabajoDTO) throws SICException;
	
	/**
	 * devuelve una seccion segun la plantilla
	 * @param seccionDTO
	 * @return seccion
	 * @throws SICException
	 */
	public Collection<SeccionDTO> consultarSeccion(SeccionDTO seccionDTO)throws SICException;
	
	/**
	 * actualiza una seccion
	 * @param seccionDTO
	 */
	public void actualizarSeccion(SeccionDTO seccionDTO);
	/**
	 * Vefifica la existencia de pasillos entre la bodega y la subbodega
	 * @param codigoAreaTrabajoPadre
	 * @param codigoAreatrabajoHijo
	 * @param codigoCompania
	 * @param valorTipoSeccionPad
	 * @param valorTipoSeccionHijo
	 * @return
	 * @throws SICException
	 */
	public Boolean existeRelacionesNaveSubnave(Integer codigoAreaTrabajoPadre, Integer codigoAreatrabajoHijo, Integer codigoCompania, String valorTipoSeccionPad, String valorTipoSeccionHijo) throws SICException;
	
	/**
	 * Metodo para obtener los padres de una seccion y detalle
	 * @param seccionDTO
	 * @param codigoDetalleHijo
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> obtenerPadreDesdeHijo(SeccionDTO seccionDTO, Long codigoDetalleHijo)throws SICException;
	
	/**
	 * Metodo que obtiene los andenes compartidos 
	 * @param areaTrabajoVO
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> obtenerAndenesCompartidos(AreaTrabajoDTO areaTrabajoDTO, Integer cdtFiltro, Integer bodegaFiltro, String andenFiltro)throws SICException;
	
	/**
	 * Metodo que verifica si el pasillo tiene ubicaciones en una subbodega
	 * @param codigoPasillo
	 * @param codigoCompania
	 * @param codigoSubbodega
	 * @return
	 * @throws SICException
	 */
	public Boolean pasilloTieneUbicaciones(Long codigoPasillo, Integer codigoCompania, Integer codigoSubbodega)throws SICException;
	
	/**
	 * Metodo que obtiene las ubicaciones pendientes por integrar
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<RegistrarUbicacionesArticuloDTO> obtenerUbicacionPendienteIntegracion (Integer codigoCompania)throws SICException;
	
	/**
	 * Elimina las ubicaciones pendientes de integracion
	 * @param codigoCompania
	 * @throws SICException
	 */
	public void eliminarUbicacionIntegracion (Integer codigoCompania, Long codigoUbiPenInt)throws SICException;
	
}