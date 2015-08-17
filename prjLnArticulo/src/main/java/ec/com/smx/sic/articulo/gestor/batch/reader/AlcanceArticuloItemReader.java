package ec.com.smx.sic.articulo.gestor.batch.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamSupport;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.ListItemReader;

import ec.com.smx.sic.articulo.gestor.batch.IAlcanceBatchUtilGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.mdl.nopersistente.AlcanceArticuloTransient;

public class AlcanceArticuloItemReader<T> extends ItemStreamSupport implements ItemReader<T>, Logeable  {
	
	private ListItemReader<T> listItemReader = null;
	private IAlcanceBatchUtilGestor entidad;
	 
    @SuppressWarnings("unchecked")
	public void open(ExecutionContext executionContext) throws ItemStreamException {
        
    	List<T> alcanceArticuloErrorDatos = (List<T>) obtenerListadoDetalle();  
        this.listItemReader = new ListItemReader<T>(alcanceArticuloErrorDatos);
    }

	@Override
	public T read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		 return this.listItemReader.read();
	}

	private List<AlcanceArticuloTransient> obtenerListadoDetalle(){
		List<AlcanceArticuloTransient> detalles = new ArrayList<AlcanceArticuloTransient>();
		detalles = (List<AlcanceArticuloTransient>)this.entidad.alcanceArticuloErrorCol();
		return detalles;
	}
	
	public IAlcanceBatchUtilGestor getEntidad() {
		return entidad;
	}

	public void setEntidad(IAlcanceBatchUtilGestor entidad) {
		this.entidad = entidad;
	}
}