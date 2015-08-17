package ec.com.smx.sic.cliente.gestor.proveedor.administracion.almacenamiento;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionEntidad;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidad;
import ec.com.smx.sic.cliente.mdl.vo.DatosRegistroEntidadVO;
import ec.com.smx.sic.cliente.mdl.vo.EntidadVO;

/**
 * @author lyacchirema
 * 
 */
public interface IAlmacenamientoTipoPersonaProveedorGestor extends Serializable {
	
	/**
	 * @param proveedor
	 * @param datosRegistroProveedorVO
	 * @param emails
	 * @throws SICException
	 */
	<T extends ResultadoValidacionEntidad<? extends IBaseEntidad>, U extends EntidadVO<? extends IBaseEntidad>> void registrarTipoPersonaProveedor(
			DatosRegistroEntidadVO<T, U> datosRegistroVO,
			Collection<String> emails) throws SICException;

}