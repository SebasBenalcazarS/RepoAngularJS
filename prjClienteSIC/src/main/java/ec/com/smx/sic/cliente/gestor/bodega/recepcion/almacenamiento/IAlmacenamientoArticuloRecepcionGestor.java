package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;



/**
 * 
 * @author acaiza
 *
 */
public interface IAlmacenamientoArticuloRecepcionGestor {
	
	/**
	 * Actualiza los valores de la unidad de manejo, y la cantidad maxima de articulos que se puede almacenar en un PALLET
	 * 
	 * @param artUniManRecepcion
	 * @param actualizarMedidas
	 * @param valorMaximoAlmacenar
	 * @param actualizarUbicacionDespacho
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	public ArticuloUnidadManejoDTO actualizarValoresUnidadManejoArticulo(ArticuloUnidadManejoDTO artUniManRecepcion, Boolean actualizarMedidas, Integer valorMaximoAlmacenar, Boolean actualizarUbicacionDespacho) throws SICException;

	/**
	 * Actualiza el codigo de barras de un articulo unidad de manejo 
	 * 
	 * @param articuloUnidadManejoDTO
	 * @param codigoBarrasUnidadManejo
	 * @throws SICException
	 */
	public void actualizarCodigoBarrasArticuloUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, String codigoBarrasUnidadManejo) throws SICException;
	
}
