package ec.com.smx.sic.cliente.gestor.cambioprecios.porarticulo.calculo;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

public interface ICalculoDatosCambioPreciosPorArticuloGestor extends Serializable {

	/**
	 * Obtener una gestion de precios en caso de no tener un proveedor especifico
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param plantillasBusquedasArticuloPrecios
	 * @param esCreacionCambioPrecio
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloDTO> obtenerDatosArticulos(Integer codigoCompania, String codigoFuncionario, 
			Collection<ISearchTemplate> plantillasBusquedasArticuloPrecios, Boolean esCreacionCambioPrecio) throws SICException;
}
