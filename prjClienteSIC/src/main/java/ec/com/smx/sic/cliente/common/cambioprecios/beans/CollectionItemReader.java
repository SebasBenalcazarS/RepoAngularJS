package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.batch.item.ItemReader;

/**
 * @author Luis Yacchirema
 *
 * @param <T>
 */
public class CollectionItemReader<T> implements ItemReader<T> {

	private Iterator<T> iterator;

	public CollectionItemReader(Collection<T> collection) {

		this.iterator = collection.iterator();

	}

	public synchronized T read() throws Exception {

		if (this.iterator.hasNext())
			return this.iterator.next();
		return null;

	}

}