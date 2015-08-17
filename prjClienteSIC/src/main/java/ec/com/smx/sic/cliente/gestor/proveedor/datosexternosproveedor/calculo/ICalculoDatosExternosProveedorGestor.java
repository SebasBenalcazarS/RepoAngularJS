package ec.com.smx.sic.cliente.gestor.proveedor.datosexternosproveedor.calculo;

import java.util.Collection;
import java.util.Set;

import org.apache.commons.collections.map.MultiKeyMap;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.EmpresaDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.LocalizacionDTO;
import ec.com.smx.corpv2.dto.PersonaDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.jde.facturacion.dto.ClienteJDEDTO;
import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;

/**
 * 
 * @author Mario Braganza
 *
 */
public interface ICalculoDatosExternosProveedorGestor {

	/**
	 * 
	 * @param codigoCompania
	 * @param ruc
	 * @param jde
	 * @return
	 */
	Duplex<EmpresaDTO, LocalizacionDTO> obtenerEmpresaLocalizacion(
			Integer codigoCompania, String ruc, Integer jde)
			throws SICException;
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @param ruc
	 * @param jde
	 * @return
	 * @throws SICException
	 */
	public Duplex<EmpresaDTO, Collection<LocalizacionDTO>> obtenerEmpresaLocalizaciones(Integer codigoCompania, 
			String ruc, 
			Integer jde) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param ruc
	 * @return
	 * @throws SICException
	 */
	EmpresaDTO obtenerEmpresa(Integer codigoCompania, String ruc)
			throws SICException;

	
	/**
	 * 
	 * @param numeroDocumento
	 * @param buscarPorRUC
	 * @return
	 */
	PersonaDTO obtenerPersonaPorDocumento(String numeroDocumento, Boolean buscarPorRUC) throws SICException;
	

	/**
	 * 
	 * @param identificadorProveedor
	 * @return
	 * @throws SICException
	 */
	SearchResultDTO<ClienteJDEDTO> obtenerClientesBaseFinancieraPorJDE(
			Integer codigoJDE) throws SICException;

	/**
	 * 
	 * @param codigoPersona
	 * @return
	 * @throws SICException
	 */
	PersonaDTO obtenerPersonaPorCodigo(Long codigoPersona) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoLocalizacion
	 * @return
	 * @throws SICException
	 */
	LocalizacionDTO obtenerLocalizacionPorCodigo(Integer codigoCompania,
			Long codigoLocalizacion) throws SICException;
	
	
	/**
	 * 
	 * @param codigosCatalogosTipo
	 * @return
	 * @throws SICException
	 */
	Collection<CatalogoValorDTO> obtenerCatalogos(Set<Integer> codigosCatalogosTipo,
			Boolean obtenerCatalogosRelacionados) throws SICException;

	
	/**
	 * 
	 * @param codigosCatalogosTipo
	 * @param obtenerCatalogosRelacionados
	 * @return
	 * @throws SICException
	 */
	MultiKeyMap obtenerMapaCatalogos(Set<Integer> codigosCatalogosTipo,
			Boolean obtenerCatalogosRelacionados) throws SICException;
	
	
	/**
	 * 
	 * @param codigosCatalogoTipo
	 * @param valorCatalogo
	 * @return
	 * @throws SICException
	 */
	CatalogoValorDTO obtenerCatalogo(Integer codigosCatalogoTipo, 
			String valorCatalogo,
			Boolean obtenerCatalogosRelacionados) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param idUsuario
	 * @return
	 * @throws SICException
	 */
	FuncionarioDTO obtenerFuncionarioPorUsuario(Integer codigoCompania, 
			String idUsuario) throws SICException;
	
	
	/**
	 * 
	 * @param idUsuario
	 * @return
	 * @throws SICException
	 */
	String obtenerNombreUsuarioPorId(String idUsuario) throws SICException;
	
	
	/**
	 * 
	 * @param idsUsuarios
	 * @return
	 * @throws SICException
	 */
	Collection<String> obtenerNombrseUsuariosPorIds(String... idsUsuarios) throws SICException;
	
	
	/**
	 * 
	 * @param localizaciones
	 * @return
	 */
	public LocalizacionDTO obtenerLocalizacionMatriz(Collection<LocalizacionDTO> localizaciones);
	
	
	/**
	 * 
	 * @param localizaciones
	 * @return
	 */
	LocalizacionDTO obtenerLocalizacionPorTipo(Integer codigoJDE, Collection<LocalizacionDTO> localizaciones);
	
	
	
	/**
	 * 
	 * @throws SICException
	 */
	Duplex<EmpresaDTO, LocalizacionDTO> establecerDatosPersonaLocalizacionProveedor(Integer codigoCompania, 
			IProveedor proveedor,
			ResultadoValidacionProveedor resultadoValidacionProveedor) throws SICException;

}