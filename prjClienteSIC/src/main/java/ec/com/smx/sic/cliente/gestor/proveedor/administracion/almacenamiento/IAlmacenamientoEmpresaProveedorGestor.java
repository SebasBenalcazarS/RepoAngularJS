package ec.com.smx.sic.cliente.gestor.proveedor.administracion.almacenamiento;

import java.util.Collection;

import ec.com.smx.corpv2.dto.LocalizacionDTO;
import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionEntidad;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidad;
import ec.com.smx.sic.cliente.mdl.vo.DatosRegistroEntidadVO;
import ec.com.smx.sic.cliente.mdl.vo.EntidadVO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;


/**
 * 
 * @author Mario Braganza
 *
 */
public interface IAlmacenamientoEmpresaProveedorGestor {

	/**
	 * @param proveedor
	 * @throws SICRuleException
	 */
	void registrarTipoPersonaProveedor(ProveedorVO proveedor)
			throws SICRuleException;


	/**
	 * Regla de almacenamiento que guarda Empresa y Localización
	 * @param baseVO
	 * @param datosRegistroProveedorVO
	 * @param emails
	 * @return
	 * @throws SICException
	 */
	<T extends ResultadoValidacionEntidad<? extends IBaseEntidad>, U extends EntidadVO<? extends IBaseEntidad>> LocalizacionDTO registrarEmpresaProveedor(
			DatosRegistroEntidadVO<T, U> datosRegistroVO,
			Collection<String> emails) throws SICException;
}