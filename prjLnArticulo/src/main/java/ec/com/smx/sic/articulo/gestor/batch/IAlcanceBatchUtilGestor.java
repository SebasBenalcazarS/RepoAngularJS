package ec.com.smx.sic.articulo.gestor.batch;

import java.util.Collection;

import org.springframework.batch.core.Job;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.AlcanceArticuloTransient;

public interface IAlcanceBatchUtilGestor {
	
	public void generarArchivoErrorAlcance(
			Collection<AlcanceArticuloTransient> alcanceArticuloErrorCol,
			Job job,
			String rutaDepositarArchivoT,
			String columnasT) throws SICException;
	
	public Collection<AlcanceArticuloTransient> alcanceArticuloErrorCol();
}
