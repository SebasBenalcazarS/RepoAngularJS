package ec.com.smx.sic.cliente.common.bodega;

import java.io.Serializable;
import java.util.Collection;


@SuppressWarnings("serial")
public class CabeceraCalendarioDia implements Serializable{
	private Collection<ColumnaCalendarioDia> columnasCalendario;

	public Collection<ColumnaCalendarioDia> getColumnasCalendario() {
		return columnasCalendario;
	}

	public void setColumnasCalendario(Collection<ColumnaCalendarioDia> columnasCalendario) {
		this.columnasCalendario = columnasCalendario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		for (ColumnaCalendarioDia columna : columnasCalendario) {
			builder.append(columna.toString());
			builder.append(",");
		}
		builder.append("]");
		return builder.toString();
	}

}
