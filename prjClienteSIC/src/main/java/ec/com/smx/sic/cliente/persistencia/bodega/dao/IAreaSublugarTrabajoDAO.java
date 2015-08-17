package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioSublugarTrabajoRelacionadoDTO;
import ec.com.smx.sic.cliente.exception.SICException;

public interface IAreaSublugarTrabajoDAO {

	/**
	 * 
	 * @param codigoAreaTrabajo
	 * @param tipoRelacion
	 * @param codigoCompania
	 * @param tipoAreaTrabajoContar
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> buscarAreasSublugarTrabajo(AreaSublugarTrabajoDTO areaSublugarTrabajoDTO,String tipoAreaTrabajoContar)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosAreaTrabajoHijas
	 * @param codigoAreaTrabajoPadre
	 * @param estadoAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> consultarAreaSublugarTrabajo(Integer codigoCompania,Collection<Integer> codigosAreaTrabajoHijas,Integer codigoAreaTrabajoPadre,Boolean estadoAreaTrabajo)throws SICException;
	
	/**
	 * 
	 * @param areaSublugarTrabajoDTO
	 * @throws SICException
	 */
	public void actualizarAreaSublugarTrabajo(AreaSublugarTrabajoDTO areaSublugarTrabajoDTO)throws SICException;
	
	/**
	 * obtiene las bodegas que estan relacionadas con las subbodegas
	 * @param codigoCompania
	 * @param codigoSubbodega
	 * @param estadoAreaTrabajo
	 * @param tipoAreaTrabajoPadre
	 * @return
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> consultarBodegasSubbodega(Integer codigoCompania,Integer codigoSubbodega, String tipoAreaTrabajoPadre)throws SICException;
	
	
	public Collection<FuncionarioSublugarTrabajoRelacionadoDTO> obtenerSubLugarTrabajoPorFuncionario(String userId) throws SICException;
	
}
