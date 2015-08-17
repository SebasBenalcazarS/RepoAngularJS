package ec.com.smx.sic.cliente.gestor.proveedor.administracion.validacion;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.framework.common.enumeration.TipoEmpresaEnum;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.framework.common.validator.Validator;
import ec.com.smx.jde.facturacion.dto.ClienteJDEDTO;
import ec.com.smx.sic.cliente.common.proveedor.DatosProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoEstadoProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoPersonaEntidad;
import ec.com.smx.sic.cliente.common.proveedor.TipoProveedor;
import ec.com.smx.sic.cliente.common.proveedor.ValidacionOrigenProveedor;
import ec.com.smx.sic.cliente.common.proveedor.bean.InformacionDocumentoProveedorDuplicado;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorOficinaExteriorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ProveedorID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * 
 * @author Mario Braganza
 *
 */
public interface IValidacionDatosProveedorGestor extends Serializable {


	Validator getValidator();

	/**
	 * 
	 * @param datosProveedorRUCDuplicado
	 * @return
	 * @throws SICException
	 */
	Boolean validarRegistroNuevoProveedor(Duplex<InformacionDocumentoProveedorDuplicado, InformacionDocumentoProveedorDuplicado> datosProveedorRUCDuplicado) throws SICException;


	/**
	 * 
	 * @param datosProveedorRUCFinanciero
	 * @return
	 */
	Boolean validarRUCProveedoresFinancieriosDuplicado(InformacionDocumentoProveedorDuplicado datosProveedorRUCFinanciero);


	/**
	 * 
	 * @param clientesJDE
	 * @return
	 * @throws SICRuleException
	 */
	Boolean existeProveedorBaseFinanciera(DatosProveedor proveedorJDE)
			throws SICRuleException;

	/**
	 * 
	 * @param clientesJDE
	 * @return
	 * @throws SICRuleException
	 */
	Boolean existeProveedorRepetidoBaseFinanciera(
			SearchResultDTO<ClienteJDEDTO> clientesJDE) throws SICRuleException;

	/**
	 * 
	 * @param numeroDocumento
	 * @return
	 * @throws SICRuleException
	 */
	TipoEmpresaEnum validarTipoEmpresaPorNumeroDocumento(String numeroDocumento)
			throws SICException;

	/**
	 * 
	 * @param numeroDocumento
	 * @return
	 * @throws SICException
	 */
	TipoPersonaEntidad obtenerTipoPersonaProveedorPorNumeroDocumento(
			String numeroDocumento) throws SICException;

	/**
	 * 
	 * @param tipoEmpresa
	 * @return
	 * @throws SICRuleException
	 */
	Boolean esNumeroDocumentoValido(TipoEmpresaEnum tipoEmpresa)
			throws SICRuleException;

	/**
	 * 
	 * @param proveedoDTO
	 * @return
	 * @throws SICRuleException
	 */
	Boolean proveedorCorporativoTieneRUC(ProveedorDTO proveedorDTO)
			throws SICRuleException;

	/**
	 * 
	 * @param proveedorVO
	 * @return
	 * @throws SICRuleException
	 */
	Boolean existeProveedorBaseCorporativa(IProveedor proveedorDTO)
			throws SICRuleException;

	/**
	 * 
	 * @param proveedor
	 * @return
	 * @throws SICException
	 */
	Boolean validarExistenciaOficinasExteriorPorProveedor(IProveedor proveedor)
			throws SICException;

	/**
	 * 
	 * @param proveedor
	 * @param valorCaracteristicaTipoProveedor
	 * @return
	 * @throws SICException
	 */
	Boolean validarEstadoProveedorPorTipo(IProveedor proveedor,
			TipoProveedor tipoProveedor, 
			TipoEstadoProveedor tipoEstadoProveedor)
					throws SICException;

	/**
	 * 
	 * @param tiposProveedor
	 * @param tipoProveedor
	 * @param tipoEstadoProveedor
	 * @return
	 * @throws SICException
	 */
	Boolean validarEstadoProveedorPorTipo(Set<TipoProveedorDTO> tiposProveedor, 
			TipoProveedor tipoProveedor, 
			TipoEstadoProveedor tipoEstadoProveedor) throws SICException;


	/**
	 * 
	 * @param proveedor
	 * @param tipoProveedor
	 * @param tipoEstadoProveedor
	 * @param establecerTiposProveedor
	 * @return
	 * @throws SICException
	 */
	Boolean validarEstadoProveedorPorTipo(IProveedor proveedor, 
			TipoProveedor tipoProveedor, 
			TipoEstadoProveedor tipoEstadoProveedor,
			Boolean establecerTiposProveedor) throws SICException;


	/**
	 * 
	 * @param numeroDocumento
	 * @return
	 * @throws SICException
	 */
	Duplex<TipoEmpresaEnum, TipoPersonaEntidad> obtenerDatosTipoPersonaProveedorPorNumeroDocumento(String numeroDocumento) throws SICException;


	/**
	 * 
	 * @param proveedorVO
	 * @return
	 * @throws SICException
	 */
	//Boolean validarExistenciaPersonaProveedor(ProveedorVO proveedorVO) throws SICException;

	/**
	 * 
	 * @param proveedorVO
	 * @return
	 * @throws SICException
	 */
	//Boolean validarExistenciaEmpresaProveedor(ProveedorVO proveedorVO) throws SICException;

	/**
	 * 
	 * @param proveedorVO
	 * @return
	 * @throws SICException
	 */
	Boolean validarRegistroDatosUsuarioProveedor(ProveedorVO proveedorVO) throws SICException;


	/**
	 * 
	 * @param proveedorVO
	 * @param oficinasExteriorProveedor
	 * @return
	 * @throws SICException
	 */
	Boolean validarRegistroOficinasExteriorProveedor(ProveedorVO proveedorVO, 
			Collection<ProveedorOficinaExteriorDTO> oficinasExteriorProveedor) throws SICException;


	/**
	 * 
	 * @param proveedorVO
	 * @param oficinaExteriorDTO
	 * @return
	 * @throws SICException
	 */
	Boolean validarRegistroOficinaExteriorProveedor(ProveedorVO proveedorVO, 
			ProveedorOficinaExteriorDTO oficinaExteriorDTO) throws SICException;


	/**
	 * 
	 * @param proveedor
	 * @return
	 * @throws SICException
	 */
	Boolean validarRealizacionIntegracionDatosProveedor(IProveedor proveedor) throws SICException;

	/**
	 * 
	 * @param proveedorVO
	 * @param valorOrigenProveedor
	 * @return
	 * @throws SICException
	 */
	Boolean validarOrigenProveedor(ProveedorVO proveedorVO, String valorOrigenProveedor) throws SICException;



	/**
	 * 
	 * @param proveedorVO
	 * @param parametroTipoContactoProveedor
	 * @param establecerContactoPorDefecto
	 * @return
	 * @throws SICException
	 */
	Boolean validarExistenciaContactoProveedor(ProveedorVO proveedorVO, 
			String parametroTipoContactoProveedor,
			Boolean establecerContactoPorDefecto) throws SICException;

	/**
	 * 
	 * @param proveedorVO
	 * @param contactosRelacionados
	 * @return
	 * @throws SICException
	 */
	ValidacionOrigenProveedor validarOrigenNacionalImportado(ProveedorVO proveedorVO, Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Boolean validarCaracteristicaEsInterproveedor(Integer codigoCompania, String codigoProveedor) throws SICException;
	
	/**
	 * Valida la existencia de un tipo de proveedor inactivo, trayendo el objeto
	 * 
	 * @author ivasquez
	 * @param proveedorID
	 * @param tipoEstadoProveedor
	 * @param valorTipoProveedor
	 * @return
	 * @throws SICException
	 */
	TipoProveedorDTO validarExistenciaTipoProveedorInactivo(ProveedorID proveedorID, TipoEstadoProveedor tipoEstadoProveedor, String valorTipoProveedor) throws SICException;
}