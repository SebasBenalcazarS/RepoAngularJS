package ec.com.smx.sic.cliente.persistencia.recipientes.dao;

import java.util.Collection;
import java.util.LinkedHashMap;

import org.hibernate.criterion.ProjectionList;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.ContenedorEstadoCountTrasient;
import ec.com.smx.sic.cliente.mdl.nopersistente.TransferenciaCountTrasient;

/**
 * 
 * @author cherrera
 *
 */

public interface ITransferenciaRecipientesDAO {
	
	/**
	 * @param codigoClasificacion
	 * @return
	 */
	public  Collection<ContenedorEstadoCountTrasient> obtenerCantidadCajasPorEstado(LinkedHashMap<String, Object> parametrosConsulta) throws SICException;
	
	/**
	 * @param codigoClasificacion
	 * @return
	 */
	public  Collection<ContenedorEstadoCountTrasient> obtenerCantidadPalletsPorEstado(LinkedHashMap<String, Object> parametrosConsulta) throws SICException;
	
	/**
	 * @param parametrosConsulta
	 * @return
	 */
	public  Collection<TransferenciaCountTrasient> obtenerCantidadRecipientesPorEstado(LinkedHashMap<String, Object> parametrosConsulta) throws SICException;
	
	/**
	 * 
	 * @param plantilla
	 * @param projections
	 * @return
	 * @throws SICException
	 */
	public <T extends SearchDTO> Collection<T> obtenerDatosEspecificosTransferencias(T plantilla, ProjectionList projections)throws SICException;
	
	/**
	 * @param codigoContenedor
	 * @throws SICException
	 */
	public void eliminarContenedorDetalle(Long codigoContenedor)throws SICException;
	
	/**
	 * @param codigoContenedor
	 * @throws SICException
	 */
	public void eliminarContenedorRelacionado(Long codigoContenedorPadre, Long codigoContendorRelacionado) throws SICException;
	
}
