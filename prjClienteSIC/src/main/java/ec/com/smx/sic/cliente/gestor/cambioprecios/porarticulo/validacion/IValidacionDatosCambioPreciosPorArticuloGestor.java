package ec.com.smx.sic.cliente.gestor.cambioprecios.porarticulo.validacion;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;

public interface IValidacionDatosCambioPreciosPorArticuloGestor extends Serializable {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param plantillasBusquedasArticuloPrecio
	 * @return
	 * @throws SICException
	 */
	Boolean validarMaximoResultadoBusquedaArticulos(Integer codigoCompania, Collection<ISearchTemplate> plantillasBusquedasArticuloPrecio) throws SICException;
	
}
