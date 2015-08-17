/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.proveedor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.proveedor.DatosProveedor;
import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoBusquedaProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoDatoProveedor;
import ec.com.smx.sic.cliente.common.proveedor.bean.InformacionDocumentoProveedorDuplicado;
import ec.com.smx.sic.cliente.common.proveedor.bean.UsuarioProveedor;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorOficinaExteriorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;
import ec.com.smx.sic.cliente.mdl.vo.IIdentificadorProveedorVO;
import ec.com.smx.sic.cliente.mdl.vo.IdentificadorJDEProveedorVO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;


/**
 * @author Mario Braganza
 *
 */
public interface IDatosProveedorServicio {
	
	/**
	 * 
	 * @param proveedorVO
	 * @param resultadoValidacionProveedor
	 * @param tipoDatoProveedor
	 * @throws SICException
	 */
	void completarDatosProveedor(ProveedorVO proveedorVO, 
			ResultadoValidacionProveedor resultadoValidacionProveedor,
			TipoDatoProveedor... tipoDatoProveedor) throws SICException;
	
	
	
	Duplex<ResultadoValidacionProveedor, ProveedorVO> obtenerDatosInicialesProveedor(
			IIdentificadorProveedorVO identificadorProveedor)
			throws SICException;
	
	
	/**
	 * 
	 * @param identificadorProveedor
	 * @return
	 * @throws SICException
	 */
	Duplex<ResultadoValidacionProveedor, ProveedorVO> obtenerDatosInicialesProveedorPorJDE(
			IIdentificadorProveedorVO identificadorProveedor)
			throws SICException;
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedorAexcluir
	 * @param numeroRUCInicial
	 * @return
	 * @throws SICException
	 */
	InformacionDocumentoProveedorDuplicado obtenerRUCDuplicadosProveedoresCorporativos(Integer codigoCompania, 
			String codigoProveedorAexcluir, String numeroRUCInicial) throws SICException;
	
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @param numeroRUC
	 * @return
	 * @throws SICException
	 */
	Duplex<InformacionDocumentoProveedorDuplicado, InformacionDocumentoProveedorDuplicado> obtenerDatosProveedorRUCDuplicado(Integer codigoCompania, String numeroRUC) throws SICException;
	
	
	/**
	 * 
	 * @param identificadorProveedor
	 * @return
	 * @throws SICException
	 */
	DatosProveedor obtenerProveedorBaseFinancieraPorJDE(
			IdentificadorJDEProveedorVO identificadorProveedor)
			throws SICException;
	

	
	/**
	 * 
	 * @param proveedor
	 * @return
	 * @throws SICException
	 */
	Set<ProveedorOficinaExteriorDTO> obtenerOficinasExteriorPredeterminadasPorProveedor(IProveedor proveedor) throws SICException;
	
	
	/**
	 * 
	 * @param identificadorProveedor
	 * @return
	 * @throws SICException
	 */
	<T extends IProveedor> T obtenerProveedorPorJDE(IdentificadorJDEProveedorVO identificadorProveedor, 
			T plantillaBusquedaAdicional) throws SICException;
	
	
	/**
	 * 
	 * @param plantillaBusqueda
	 * @return
	 * @throws SICException
	 */
	SearchResultDTO<IProveedor> obtenerProveedores(IProveedor plantillaBusqueda) throws SICException;

	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	Collection<String> obtenerProveedoresNoExistente() throws SICException;
	
	/**
	 * 
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Duplex<T,SearchResultDTO<T>> obtenerProveedoresPaginados(Integer codigoCompania,
			Collection<ISearchTemplate> plantillasBusqueda, Integer firstResult, Integer maxResult, TipoBusquedaProveedor tipoBusquedaProveedor, String codigoFuncionario) throws SICException;
	
	/**
	 * 
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Duplex<T,SearchResultDTO<T>> obtenerDatosPrincipalesProveedoresPaginados(Integer codigoCompania,
			Collection<ISearchTemplate> plantillasBusqueda, Integer firstResult, Integer maxResult, TipoBusquedaProveedor tipoBusquedaProveedor, String codigoFuncionario, Long codigoLineaComercial) throws SICException;
	
	/**
	 * 
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Collection<T> obtenerProveedores(Integer codigoCompania,
			ArrayList<ISearchTemplate> plantillasBusqueda, TipoBusquedaProveedor tipoBusquedaProveedor, String codigoFuncionario) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoLineaComercial
	 * @return
	 * @throws SICException
	 */
	Collection<BodegaDTO> obtenerSubbodegasPorProveedorFuncionarioComprador(Integer codigoCompania, String codigoProveedor, String codigoFuncionario, Long codigoLineaComercial) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigosClasificacion
	 * @return
	 * @throws SICException
	 */
	Collection<ClasificacionDTO> obtenerSubclasificacionCol(Integer codigoCompania, Collection<String> codigosClasificacion) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param proveedores
	 * @throws SICException
	 */
	void establecerContactosPrincipalesProveedores(Integer codigoCompania, Collection<VistaProveedorDTO> proveedores) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param numeroRUC
	 * @return
	 * @throws SICException
	 */
	public ProveedorDTO obtenerProveedorPorRUC(Integer codigoCompania, String numeroRUC) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param numeroRUC
	 * @param cuentaUsuario
	 * @return
	 * @throws SICException
	 */
	public UsuarioProveedor validarCuentaUsuarioProveedor(Integer codigoCompania, String numeroRUC,String cuentaUsuario) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	String obtenerEsImportador(Integer codigoCompania,String codigoProveedor) throws SICException;
	
	Collection<ProveedorDTO> obtenerProveedoresPorCodigoProveedor(Integer codigoCompania,Collection<String> codigoProveedorCol) throws SICException;
	
	/**  Metodo que retorna la relacion entre articulo proveedor con los codigos de articulo(El dto de articulo viene cargado)
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 */
	public Collection<ArticuloProveedorDTO> obtenerArticuloProveedorPorCodigoArticulo(Integer codigoCompania,Collection<String> codigoArticuloCol)throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoJDE
	 * @return
	 * @throws SICException
	 */
	public ProveedorDTO obtenerProveedorPorJDE(final Integer codigoCompania, final String codigoJDE) throws SICException;
	
	/**
	 * Obtiene los plazos del pago que posee el proveedor
	 * @param codigoCompania
	 * @param codigoJDE
	 * @return
	 * @throws SICException
	 */
	Collection<ProveedorClasificacionDTO> obtenerPlazoPagoProveedorClasificacion(Integer codigoCompania, String codigoJDE)throws SICException;
}
