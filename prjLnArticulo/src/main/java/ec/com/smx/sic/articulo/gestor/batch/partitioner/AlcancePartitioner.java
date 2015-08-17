package ec.com.smx.sic.articulo.gestor.batch.partitioner;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

/**
 * Particiona los datos a travez de hilos (se podria configurar por cada hilo, genere un archivo)
 * @author fcollaguazo
 *
 */
public class AlcancePartitioner implements Partitioner {

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {

		Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();

		ExecutionContext value = new ExecutionContext();

		// give each thread a name
		value.putString("name", "Thread" + 0);

		result.put("partition" + 0, value);
		return result;
	}

}
