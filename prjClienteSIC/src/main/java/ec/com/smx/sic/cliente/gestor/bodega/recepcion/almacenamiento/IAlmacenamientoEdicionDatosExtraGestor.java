/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaDatosLogisticosVO;

/**
 * @author jdvasquez
 *
 */
public interface IAlmacenamientoEdicionDatosExtraGestor {

	public Collection<String> registrarDatosLogisticosArticuloMasivo(Collection<ArticuloEdicionMasivaDatosLogisticosVO> articulosCol) throws SICException;

	public ArticuloEdicionMasivaDatosLogisticosVO registrarDatosLogisticosArticulo(ArticuloEdicionMasivaDatosLogisticosVO articulo, Boolean articuloRegistrado) throws SICException;

	public void registrarArticuloIntegracionDatosExtra(ArticuloEdicionMasivaDatosLogisticosVO articulo) throws SICException;

	

}
