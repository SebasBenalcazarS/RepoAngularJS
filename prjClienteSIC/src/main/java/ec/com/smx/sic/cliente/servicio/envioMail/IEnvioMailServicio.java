/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.envioMail;

import java.util.Collection;

import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.articulo.EnumPrototipoAlcance;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.PrototipoAlcanceVO;

/**
 * @author jmontenegro
 *
 */
public interface IEnvioMailServicio {
/**
 * 
 * @return
 * @throws SICException
 */
	public Boolean mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance enumPrototipoAlcance,UserDto userDto,ArticuloVO articuloFiltro)throws SICException;
	/**
	 * 
	 * @param enumPrototipoAlcance
	 * @param prototipoAlcanceVO
	 * @return
	 * @throws SICException
	 */
	public Boolean mensajeConfirmacionModificacionPrototipo(EnumPrototipoAlcance enumPrototipoAlcance,PrototipoAlcanceVO prototipoAlcanceVO)throws SICException;
	
	/**
	 * Envio de mail estado integracion sic
	 * @param articuloLocalCol
	 * @param usuarioCC
	 * @param tipoAreatrabajo
	 * @return
	 * @throws SICException
	 */
	public Boolean mensajeConfirmacionIntegracionSIC(Collection<ArticuloLocalDTO> articuloLocalCol, String tipoAreatrabajo)throws SICException;
}
