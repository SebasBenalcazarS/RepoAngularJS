package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;
import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;


public interface IValidacionAndenesBodegaGestor {

	public abstract void validarObtenerAndenPorCategoria(CatalogoValorDTO catalogo, Collection<Integer> codigosAreaTrabajoEntregas) throws SICException;
	
}