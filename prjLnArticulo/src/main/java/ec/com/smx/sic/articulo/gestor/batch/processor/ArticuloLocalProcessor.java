package ec.com.smx.sic.articulo.gestor.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ec.com.smx.sic.cliente.mdl.nopersistente.AlcanceArticuloTransient;

@Component("sicArticuloLocalItemProcessor")
@Scope(value = "step")
public class ArticuloLocalProcessor implements ItemProcessor<AlcanceArticuloTransient, AlcanceArticuloTransient> {

	@Value("#{stepExecutionContext[name]}")
	private String threadName;

	@Override
	public AlcanceArticuloTransient process(AlcanceArticuloTransient item) throws Exception {
		return item;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
}
