package ec.com.smx.sic.cliente.gestor.proveedor.administracion.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.corpv2.dto.EmpresaDTO;
import ec.com.smx.corpv2.dto.PersonaDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.proveedor.DatosProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoBusquedaProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoDatoProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoEstadoProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoPersonaEntidad;
import ec.com.smx.sic.cliente.common.proveedor.TipoProveedor;
import ec.com.smx.sic.cliente.common.proveedor.bean.InformacionDocumentoProveedor;
import ec.com.smx.sic.cliente.common.proveedor.bean.InformacionDocumentoProveedorDuplicado;
import ec.com.smx.sic.cliente.common.proveedor.bean.UsuarioProveedor;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorB2BDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorFinancieroDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorImportadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorOficinaExteriorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioEntidadProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidad;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;
import ec.com.smx.sic.cliente.mdl.vo.DatosConfiguracionNivelPagoReportesVO;
import ec.com.smx.sic.cliente.mdl.vo.EntidadVO;
import ec.com.smx.sic.cliente.mdl.vo.IdentificadorJDEProveedorVO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * 
 * @author Mario Braganza
 *
 */
public interface ICalculoDatosProveedorGestor extends Serializable {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedorAexcluir
	 * @param numeroRUCInicial
	 * @return
	 * @throws SICException
	 */
	InformacionDocumentoProveedorDuplicado obtenerRUCDuplicadosProveedoresCorporativos(Integer codigoCompania, 
			String codigoProveedorAexcluir, 
			String numeroRUCInicial) throws SICException;
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @param numeroRUC
	 * @return
	 * @throws SICException
	 */
	Duplex<InformacionDocumentoProveedorDuplicado, InformacionDocumentoProveedorDuplicado> obtenerDatosProveedorRUCDuplicado(Integer codigoCompania, 
			String numeroRUC) throws SICException ;
	
	
	/**
	 * 
	 * @param numeroRUC
	 * @return
	 * @throws SICException
	 */
	InformacionDocumentoProveedorDuplicado obtenerRUCDuplicadosProveedoresFinancieros(String numeroRUC) throws SICException;

	/**
	 * 
	 * @param proveedorJDE
	 * @return
	 * @throws SICRuleException
	 */
	Integer obtenerCantidadRUCProveedoresBaseFinanciera(
			DatosProveedor proveedorJDE) throws SICException;
	
	
	/**
	 * @param codigoCompania
	 * @param numeroRUC
	 * @return
	 * @throws SICRuleException
	 */
	Integer obtenerCantidadRUCProveedoresBaseCorporativa(Integer codigoCompania,
			String numeroRUC) throws SICException;
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @param numeroRUC
	 * @return
	 * @throws SICException
	 */
	Collection<Integer> obtenerJDEsCorporativosPorRUC(Integer codigoCompania,
			String codigoProveedorAexcluir,
			String numeroRUC) throws SICException;
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @param numeroRUC
	 * @return
	 * @throws SICException
	 */
	Collection<String> obtenerJDEsFinancierosPorRUC(String numeroRUC) throws SICException;
	
	

	/**
	 * 
	 * @param proveedor
	 * @throws SICRuleException
	 */
	void establecerCaracteristicasDatosGeneralesProveedor(IProveedor proveedor)
			throws SICRuleException;

	/**
	 * 
	 * @param proveedorVO
	 * @param completarDatosRelacionadosProveedor
	 * @throws SICRuleException
	 */
	void establecerCaracteristicasTotalesProveedor(ProveedorVO proveedorVO,
			Boolean completarDatosRelacionadosProveedor)
			throws SICRuleException;

	/**
	 * 
	 * @param proveedorVO
	 * @param caracteristicasAsignadas
	 * @param caracteristicasSeleccionadas
	 * @throws SICException
	 */
	void establecerCaracteristicasProveedor(ProveedorVO proveedorVO,
			TipoDatoProveedor tipoDatoProveedor,
			Integer... tiposCaracteristicas) throws SICException;

	/**
	 * 
	 * @param caracteristicasSeleccionadas
	 * @return
	 * @throws SICException
	 */
	Map<Integer, List<CatalogoValorDTO>> obtenerValoresCaracteristicasProveedorPorTipo(Collection<Integer> caracteristicasSeleccionadas) throws SICException;

	
	/**
	 * 
	 * @param <T>
	 * @param proveedorVO
	 * @param proveedorActual
	 * @param claseProveedor
	 * @return
	 * @throws SICException
	 */
	<T extends IProveedor> T construirDatosProveedor(ProveedorVO proveedorVO, 
			IProveedor proveedorActual,
			Class<T> claseProveedor) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoJDE
	 * @return
	 * @throws SICRuleException
	 */
	String construirCodigoProveedor(Integer codigoCompania, Integer codigoJDE)
			throws SICRuleException;

	/**
	 * 
	 * @param proveedorVO
	 * @return
	 * @throws SICRuleException
	 */
	String construirNombreProveedor(TipoPersonaEntidad tipoPersonaProveedor,
			IProveedor proveedorDTO) throws SICRuleException;

	/**
	 * 
	 * @param proveedorDTO
	 * @return
	 * @throws SICException
	 */
	InformacionDocumentoProveedor obtenerRUCProveedorCorporativo(
			IProveedor proveedorDTO, boolean asignarDatosPersona)
			throws SICException;

	/**
	 * @param proveedor
	 * @return
	 * @throws SICException
	 */
	InformacionDocumentoProveedor obtenerInformacionDocumentoProveedor(DatosProveedor proveedor) throws SICException;

	/**
	 * 
	 * @param clienteJDE
	 * @return
	 * @throws SICException
	 */
	String obtenerRUCProveedorFinanciero(DatosProveedor proveedor)
			throws SICException;
	
	
	/**
	 * 
	 * @param numeroRUCInicial
	 * @return
	 * @throws SICException
	 */
	String construirRUCProveedor(String numeroRUCInicial) throws SICException;

	/**
	 * 
	 * @param numeroRUC
	 * @return
	 * @throws SICException
	 */
	Integer obtenerCantidadProveedoresJDEPorRUC(String numeroRUC)
			throws SICException;

	/**
	 * Busca los usuarios de un proveedor
	 * @param baseVOs
	 * @throws SICException
	 */
	Collection<UsuarioEntidadProveedorDTO> obtenerUsuarioEntidadProveedor(
			ProveedorVO baseVO) throws SICException;

	/**
	 * 
	 * @param proveedorID
	 * @return
	 * @throws SICException
	 */
	ProveedorFinancieroDTO obtenerProveedorFinanciero(ProveedorID proveedorID,
			Boolean obtenerCaracteristicas) throws SICException;

	/**
	 * 
	 * @param proveedorID
	 * @return
	 * @throws SICException
	 */
	ProveedorB2BDTO obtenerProveedorB2B(ProveedorID proveedorID,
			Boolean obtenerCaracteristicas) throws SICException;

	/**
	 * 
	 * @param proveedorID
	 * @return
	 * @throws SICException
	 */
	ProveedorComercialDTO obtenerProveedorComercial(ProveedorID proveedorID,
			Boolean obtenerCaracteristicas) throws SICException;
	
	
	/**
	 * 
	 * @param proveedorID
	 * @param obtenerCaracteristicas
	 * @return
	 * @throws SICException
	 */
	ProveedorImportadoDTO obtenerProveedorImportado(ProveedorID proveedorID,
			Boolean obtenerCaracteristicas) throws SICException;


	/**
	 * 
	 * @param codigoCompania
	 * @param codigoTipoCaracteristica
	 * @param codigosCaracteristicas
	 * @return
	 * @throws SICException
	 */
	DatosConfiguracionNivelPagoReportesVO obtenerDatosConfiguracionesNivelesReportes(Integer codigoCompania, 
			Collection<String> codigosCaracteristicas)throws SICException;

	/**
	 * 
	 * @param proveedorVO
	 * @return
	 * @throws SICException
	 */
	String obtenerSecuencialProveedor(ProveedorVO proveedorVO)
			throws SICException;

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
	 * @param identificadorProveedor
	 * @return
	 * @throws SICException
	 */
	<T extends IProveedor> T obtenerProveedorPorJDE(IdentificadorJDEProveedorVO identificadorProveedor, 
			T plantillaBusquedaAdicional) throws SICException;
	
	
	/**
	 * 
	 * @param identificadorJDEProveedor
	 * @return
	 * @throws SICException
	 */
	public <T extends IProveedor> T obtenerProveedorActivoPorJDE(IdentificadorJDEProveedorVO identificadorJDEProveedor) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoPersona
	 * @return
	 * @throws SICException
	 */
	IProveedor obtenerProveedorPorPersona(Integer codigoCompania,
			Long codigoPersona) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoPersona
	 * @return
	 * @throws SICException
	 */
	IProveedor obtenerProveedorPorLocalizacion(Integer codigoCompania,
			Long codigoLocalizacion) throws SICException;
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosLocalizaciones
	 * @return
	 * @throws SICException
	 */
	public Collection<IProveedor> obtenerProveedoresPorLocalizaciones(Integer codigoCompania, 
			Collection<Long> codigosLocalizaciones) throws SICException;

	/**
	 * 
	 * @param proveedorID
	 * @return
	 * @throws SICException
	 */
	Set<ProveedorOficinaExteriorDTO> obtenerOficinasExteriorProveedor(
			ProveedorID proveedorID,
			Boolean obtenerOficinasExteriorPredeterminadas) throws SICException;

	/**
	 * 
	 * @param proveedorID
	 * @return
	 * @throws SICException
	 */
	Set<TipoProveedorDTO> obtenerTiposProveedorPorProveedor(
			ProveedorID proveedorID) throws SICException;

	/**
	 * 
	 * @param proveedor
	 * @return
	 * @throws SICException
	 */
	Set<ProveedorOficinaExteriorDTO> obtenerOficinasExteriorPredeterminadasPorProveedor(
			IProveedor proveedor) throws SICException;
	
	
	/**
	 * 
	 * @param tiposProveedor
	 * @param tipoProveedor
	 * @param tipoEstadoProveedor
	 * @return
	 * @throws SICException
	 */
	TipoProveedorDTO buscarTipoProveedorEnColeccionTiposProveedor(Set<TipoProveedorDTO> tiposProveedor, 
			TipoProveedor tipoProveedor, 
			TipoEstadoProveedor tipoEstadoProveedor) throws SICException;
	
	
	/**
	 * 
	 * @param codigoTipoDocumento
	 * @param valorTipoDocumento
	 * @param codigoOrigenProveedor
	 * @return
	 * @throws SICException
	 */
	CatalogoValorDTO obtenerOrigenProveedorPorTipoDocumento(Integer codigoTipoDocumento, String valorTipoDocumento, Integer codigoOrigenProveedor) throws SICException;
	
	
	/**
	 * 
	 * @param proveedorVO
	 * @param codigoTipoDocumento
	 * @param valorTipoDocumento
	 * @throws SICException
	 */
	void establecerValorOrigenProveedorPorDocumento(ProveedorVO proveedorVO, 
			Integer codigoTipoDocumento, 
			String valorTipoDocumento) throws SICException;
	
	/**
	 * 
	 * @param <T>
	 * @param proveedorID
	 * @return
	 * @throws SICException
	 */
	<T extends IProveedor> T obtenerProveedorPorID(ProveedorID proveedorID) throws SICException;
	
	/**
	 * 
	 * @param codigoProveedorBase
	 * @param aplicarCompatibilidad
	 * @return
	 */
	String construirCodigoProveedor(String codigoProveedorBase, Boolean aplicarCompatibilidad);
	
	
	/**
	 * 
	 * @param persona
	 * @return
	 * @throws SICException
	 */
	String obtenerNombreProveedorPersonaNatural(PersonaDTO persona) throws SICException;
	
	
	/**
	 * 
	 * @param empresa
	 * @return
	 * @throws SICException
	 */
	String obtenerNombreProveedorPersonaJuridica(EmpresaDTO empresa) throws SICException;
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	Collection<String> obtenerProveedoresNoExistente() throws SICException;

	/**
	 * @param proveedorVO
	 * @return
	 * @throws SICException
	 */
	DatoContactoPersonaLocalizacionDTO obtenerContactoPrincipalPersonaLocalizacion(EntidadVO<? extends IBaseEntidad> entidadVO) throws SICException;
	
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoJDE
	 * @return
	 * @throws SICException
	 */
	String obtenerNombreProveedorPorJDE(Integer codigoCompania, String codigoJDE) throws SICException;
	
	
	/**
	 * 
	 * @param plantillaBusqueda
	 * @return
	 * @throws SICException
	 */
	SearchResultDTO<IProveedor> obtenerProveedores(IProveedor plantillaBusqueda) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	SearchResultDTO<IProveedor> obtenerProveedores(Integer codigoCompania) throws SICException;
	
	
	/**
	 * 
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Duplex<T,SearchResultDTO<T>> obtenerProveedoresPaginados(Integer codigoCompania,
			Collection<ISearchTemplate> plantillasBusqueda, Integer firstResult, Integer maxResults, TipoBusquedaProveedor tipoBusquedaProveedor, String codigoFuncionario) throws SICException;
	
	/**
	 * 
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Duplex<T,SearchResultDTO<T>> obtenerDatosPrincipalesProveedoresPaginados(Integer codigoCompania,
			Collection<ISearchTemplate> plantillasBusqueda, Integer firstResult, Integer maxResults, TipoBusquedaProveedor tipoBusquedaProveedor, String codigoFuncionario, Long codigoLineaComercial) throws SICException;
	
	/**
	 * 
	 * @param plantillasBusqueda
	 * @return
	 * @throws SICException
	 */
	<T extends SearchDTO> Collection<T> obtenerProveedores(Integer codigoCompania,
			Collection<ISearchTemplate> plantillasBusqueda, TipoBusquedaProveedor tipoBusquedaProveedor, String codigoFuncionario) throws SICException;
	
	
	/**
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoFuncionario
	 * @param codigoLineaComercial
	 * @return
	 * @throws SICException
	 */
	Collection<BodegaDTO> obtenerSubbodegasPorProveedorFuncionarioComprador(Integer codigoCompania, String codigoProveedor, String codigoFuncionario, Long codigoLineaComercial) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoClasificacion
	 * @return
	 * @throws SICException
	 */
	Collection<ClasificacionDTO> obtenerSubclasificacionCol(Integer codigoCompania, Collection<String> codigosClasificacion) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	CaracteristicaProveedorDTO obtenerCaracteristicasProveedor( Integer codigoCompania, String codigoProveedor) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param numeroRUC
	 * @return
	 * @throws SICException
	 */
	ProveedorDTO obtenerProveedorPorRUC(Integer codigoCompania, String numeroRUC) throws SICException;

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
	 * Obtiene caracteristica: Factura En Sitio
	 * de un proveedor
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return 
	 */
	String obtenerFacturaEnSitioProveedor(Integer codigoCompania, String codigoProveedor);
	
	/**
	 * Obtiene la caracteristica esImportador
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	String obtenerEsImportador(Integer codigoCompania, String codigoProveedor) throws SICException;
	
	Collection<ProveedorDTO> obtenerProveedoresPorCodigoProveedor(Integer codigoCompania,Collection<String> codigoProveedorCol) throws SICException;
	
	/*  Metodo que retorna la relacion entre articulo proveedor con los codigos de articulo(El dto de articulo viene cargado)
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
	ProveedorDTO obtenerProveedorPorJDE(final Integer codigoCompania, final String codigoJDE) throws SICException;
	
	/**
	 * Obtiene los plazos del pago que posee el proveedor
	 * @param codigoCompania
	 * @param codigoJDE
	 * @return
	 * @throws SICException
	 */
	Collection<ProveedorClasificacionDTO> obtenerPlazoPagoProveedorClasificacion(Integer codigoCompania, String codigoJDE)throws SICException;

	/**
	 * Obtener el tipo de proveedor inactivo para modificarlo
	 * 
	 * @author ivasquez
	 * @param proveedorID
	 * @param tipoEstadoProveedor
	 * @param valorTipoProveedor
	 * @return
	 * @throws SICException
	 */
	TipoProveedorDTO obtenerTiposProveedorInactivo(ProveedorID proveedorID, TipoEstadoProveedor tipoEstadoProveedor, String valorTipoProveedor) throws SICException;
}