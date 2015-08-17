package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaPerchasArticulosDTO;
import java.util.Collection;

public abstract interface IAndenesDisponiblesDAO
{
  public abstract Collection<VistaPerchasArticulosDTO> findPerchasArticulos(Long paramLong)
    throws SICException;
}
