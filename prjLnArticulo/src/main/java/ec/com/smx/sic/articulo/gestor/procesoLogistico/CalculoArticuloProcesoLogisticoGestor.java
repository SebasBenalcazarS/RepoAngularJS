/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.procesoLogistico;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.procesoLogistico.ICalculoArticuloProcesoLogisticoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloProcesoLogisticoDAO;

/**
 * @author jdvasquez
 *
 */
public class CalculoArticuloProcesoLogisticoGestor implements ICalculoArticuloProcesoLogisticoGestor, Logeable {
	
	IArticuloProcesoLogisticoDAO articuloProcesoLogisticoDAO;

	/**
	 * @param articuloProcesoLogisticoDAO the articuloProcesoLogisticoDAO to set
	 */
	public void setArticuloProcesoLogisticoDAO(IArticuloProcesoLogisticoDAO articuloProcesoLogisticoDAO) {
		this.articuloProcesoLogisticoDAO = articuloProcesoLogisticoDAO;
	}
	
	@Override
	public ArticuloProcesoLogisticoDTO obtenerInformacionDespachoArticulo(Integer codigoCompania, String codigoArticulo) throws SICException{
		 try{
			return articuloProcesoLogisticoDAO.obtenerInformacionDespachoArticulo(codigoCompania, codigoArticulo);
		 }catch(Exception e){
			 LOG_SICV2.error("Ocurrio un error al obtener la informacion de despacho del articulo");
			 throw new SICException("Ocurrio un error al obtener la informacion de despacho del articulo", e);
		 }
		 
	 }
}
