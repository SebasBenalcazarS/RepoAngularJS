package ec.com.smx.sic.cliente.gestor.convenio;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.facturacion.dto.ClienteDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ConvenioParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorOficinaExteriorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaEmpresaParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaEmpresaParticipantePromocionDTO;

/**
 * @author srodriguez 
 * 2014-09-10
 */

public interface IEmpresaParticipanteGestor {

	/**
	 * @param codigoCompania
	 * @param codigoJDE
	 * @param numeroDocumentoParticipante
	 * @param nombreParticipante
	 * @return Collection<VistaEmpresaParticipanteDTO>
	 */
	Collection<VistaEmpresaParticipanteDTO> findEmpresaParticipantes(Integer codigoCompania, Long codigoJDE, String numeroDocumentoParticipante, String nombreParticipante);

	/**
	 * @param codigoPromocion
	 * @return Collection<VistaEmpresaParticipantePromocionDTO>
	 */
	Collection<VistaEmpresaParticipantePromocionDTO> findEmpresaParticipanteByPromocion(String codigoPromocion);

	/**
	 * @param codigoCompania
	 * @param codigoPromocion
	 * @return Collection<ConvenioParticipanteDTO>
	 */
	Collection<ConvenioParticipanteDTO> findParticipantesByPromocion(Integer codigoCompania, Long codigoPromocion);

	/**
	 * @param codigoCompania
	 * @param codigoJDE
	 * @param numeroDocumentoParticipante
	 * @param nombreParticipante
	 * @param firstResult
	 * @param pageSize
	 * @param countAgain
	 * @return SearchResultDTO<VistaEmpresaParticipanteDTO>
	 */
	SearchResultDTO<VistaEmpresaParticipanteDTO> findEmpresaParticipantes(Integer codigoCompania, Long codigoJDE, String numeroDocumentoParticipante, String nombreParticipante, Integer firstResult, Integer pageSize, Boolean countAgain);

	
	Collection<ConvenioParticipanteDTO> findParticipantesByPromociones(final Collection<Long> codigosPromociones, final Integer codigoCompania) throws SICException;

	Collection<ClienteDTO> findClienteFacturacion(final Integer codigoCompania, final Collection<VistaEmpresaParticipanteDTO> vistaEmpresasParticipantesDTO) throws SICException;
	
	ClasificacionDTO findClasificacionPorCodigo(final Integer codigoCompania, final String codigoClasificacion) throws SICException; 
	
	/**
	 * Colnsulta lista de participantes
	 * @param codigoCompania
	 * @param codigoJDE
	 * @param numeroDocumentoParticipante
	 * @param nombreParticipante
	 * @return
	 */
	Collection<VistaEmpresaParticipanteDTO> findEmpresaParticipantesMejorada(Integer codigoCompania, Long codigoJDE, String numeroDocumentoParticipante, String nombreParticipante);
	
	Collection<String> findProveedorImportado(Integer codigoCompania, Collection<String>  codigoProveedorCol) throws SICException;
	
	ProveedorOficinaExteriorDTO findProveedoresOficinaExteriorDefaultFacturablePorCodigoProveedor(final Integer codigoCompania, final String codigoProveedor) throws SICException;
}
