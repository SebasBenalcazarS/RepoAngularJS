package ec.com.smx.sic.cliente.gestor.articulo.admin.accion;

import java.util.Collection;
import java.util.List;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.integracion.dto.articulo.validar.ValidarArticuloIDTO;

public interface IValidarDatosArticuloGestor {

	Collection<ValidarArticuloIDTO> obtenerDatosArticulosPorValidar(Integer codigoCompania, List<String> codigosArticulo) throws SICException;

	List<String> obtenerArticulosPorValidar(Integer codigoCompania, Integer maxPageSize) throws SICException;

}
