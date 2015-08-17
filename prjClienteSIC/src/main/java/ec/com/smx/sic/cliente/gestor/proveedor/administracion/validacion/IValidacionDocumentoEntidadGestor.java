package ec.com.smx.sic.cliente.gestor.proveedor.administracion.validacion;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.corpv2.dto.EmpresaDTO;
import ec.com.smx.corpv2.dto.LocalizacionDTO;
import ec.com.smx.corpv2.dto.PersonaDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.proveedor.CodigoResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionEntidad;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.auditoria.IAuditoriaBase;
import ec.com.smx.sic.cliente.mdl.vo.IIdentificadorProveedorVO;
import ec.com.smx.sic.cliente.mdl.vo.IdentificadorDocumentoProveedorVO;

public interface IValidacionDocumentoEntidadGestor<T extends ResultadoValidacionEntidad<? extends IAuditoriaBase>> extends Serializable {

	/**
	 * 
	 * @param persona
	 * @param resultadoValidacionProveedor
	 * @param identificadorDocumentoProveedor
	 * @throws SICException
	 */
	void establecerDatosValidacionPorPersona(
			PersonaDTO persona,
			T resultadoValidacionEntidad,
			IdentificadorDocumentoProveedorVO identificadorDocumentoProveedor)
			throws SICException;

	/**
	 * 
	 * @param empresaLocalizacion
	 * @param resultadoValidacionProveedor
	 * @param identificadorDocumentoProveedor
	 * @throws SICException
	 */
	void establecerDatosValidacionPorEmpresa(
			Duplex<EmpresaDTO, 
			Collection<LocalizacionDTO>> empresaLocalizaciones,
			T resultadoValidacionEntidad,
			IdentificadorDocumentoProveedorVO identificadorDocumentoProveedor)
			throws SICException;

	/**
	 * 
	 * @param identificadorProveedor
	 * @param resultadoValidacionEntidad
	 * @throws SICException
	 */
	void establecerValidacionEntidad(
			IIdentificadorProveedorVO identificadorProveedor,
			T resultadoValidacionEntidad)
			throws SICException;
	
	
	/**
	 * 
	 */
	T validarEntidad(IIdentificadorProveedorVO identificadorProveedor) throws SICException;
	
	
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	CodigoResultadoValidacionProveedor obtenerCodigoValidacionNuevaEntidad() throws SICException;

}