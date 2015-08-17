package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.framework.common.util.dto.RangeValue;
import ec.com.smx.sic.cliente.exception.SICException;

public interface IBusquedaAndenesRecepcionDAO {
	
	public Collection<Object[]> cantidadProveedoresPorAnden(Integer codigoCompania, Integer codigoAreaTrabajo, RangeValue<Date> rangeValueFecha) throws SICException;
	
}
