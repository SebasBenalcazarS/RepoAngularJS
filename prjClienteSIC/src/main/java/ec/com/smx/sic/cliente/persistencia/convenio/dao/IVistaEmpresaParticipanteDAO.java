package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.facturacion.dto.ClienteDTO;
import ec.com.smx.sic.cliente.common.convenio.TipoParticipanteEnum;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ConvenioParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorOficinaExteriorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaEmpresaParticipanteDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaEmpresaParticipantePromocionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorID;

/**
 * @author srodriguez 
 * 2014-09-10
 */
public interface IVistaEmpresaParticipanteDAO {
	
	/**
	 * @author srodriguez 
	 * @param codigoCompania
	 * @param codigoJDE
	 * @param numeroDocumentoParticipante
	 * @param nombreParticipante
	 * @return Collection<VistaEmpresaParticipanteDTO>
	 */
	Collection<VistaEmpresaParticipanteDTO> findEmpresaParticipantes(Integer codigoCompania, Long codigoJDE, String numeroDocumentoParticipante, String nombreParticipante);

	/**
	 * @author srodriguez 
	 * @param codigoCompania
	 * @param codigo
	 * @param tipo
	 * @return VistaEmpresaParticipanteDTO
	 */
	VistaEmpresaParticipanteDTO findEmpresaParticipante(Integer codigoCompania, String codigo, TipoParticipanteEnum tipo);

	/**
	 * @author srodriguez 
	 * @param id
	 * @return Collection<VistaEmpresaParticipantePromocionDTO>
	 */
	Collection<VistaEmpresaParticipantePromocionDTO> findEmpresaParticipanteByPromocion(String id);

	/**
	 * @author srodriguez 
	 * @param codigoCompania
	 * @param codigoPromocion
	 * @return Collection<ConvenioParticipanteDTO>
	 */
	Collection<ConvenioParticipanteDTO> findParticipantesByPromocion(Integer codigoCompania, Long codigoPromocion);

	/**
	 * @author srodriguez 
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
	
	
	Collection<ConvenioParticipanteDTO> findParticipantesByPromociones(Collection<Long> codigosPromociones, Integer codigoCompania) throws SICException;
	
	ProveedorDTO findProveedorPorVistaEmpresaParticipante(final Integer codigoCompania, final VistaEmpresaParticipanteDTO vistaEmpresaParticipanteDTO) throws SICException;
	
	ProveedorOficinaExteriorDTO findProveedoresOficinaExteriorDefaultFacturablePorCodigoProveedor(final Integer codigoCompania, final String codigoProveedor) throws SICException;
	
	ClienteDTO findClienteFacturacionPorVistaEmpresaParticipante(final Integer codigoCompania, final VistaEmpresaParticipanteDTO vistaEmpresaParticipanteDTO) throws SICException; 
	
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
	
	/**
	 *  Metodo que devuelve el codigo de proveedor en el caso de que sea un proveedor Importado
	 * @return
	 * @throws SICException
	 */
	Collection<String> findProveedorImportado(Integer codigoCompania, Collection<String>  codigoProveedorCol) throws SICException;
}
