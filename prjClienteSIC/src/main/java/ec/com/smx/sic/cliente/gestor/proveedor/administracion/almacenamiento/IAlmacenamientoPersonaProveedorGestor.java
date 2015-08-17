package ec.com.smx.sic.cliente.gestor.proveedor.administracion.almacenamiento;

import java.util.Collection;

import ec.com.smx.corpv2.dto.PersonaDTO;
import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionEntidad;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidad;
import ec.com.smx.sic.cliente.mdl.vo.DatosRegistroEntidadVO;
import ec.com.smx.sic.cliente.mdl.vo.EntidadVO;


/**
 * 
 * @author Mario Braganza
 *
 */
public interface IAlmacenamientoPersonaProveedorGestor {

	/**
	 * Regla de almacenamiento que guarda la persona
	 * @param baseVO
	 * @param datosRegistroProveedorVO
	 * @param emails
	 * @return
	 * @throws SICException
	 */
	/*<VO extends EntidadVO<? extends IBaseEntidad>> PersonaDTO registrarPersonaProveedor(VO baseVO,
			DatosRegistroProveedorVO datosRegistroProveedorVO,
			Collection<String> emails) throws SICException;
	
	
	DatosRegistroEntidadVO<RESULTADO_VALIDACION extends ResultadoValidacionEntidad<? extends IBaseEntidad>, VO extends EntidadVO<? extends IBaseEntidad>>*/
	
	<T extends ResultadoValidacionEntidad<? extends IBaseEntidad>, U extends EntidadVO<? extends IBaseEntidad>> PersonaDTO registrarPersonaProveedor(
			DatosRegistroEntidadVO<T, U> datosRegistroProveedorVO,
			Collection<String> emails) throws SICException;
}