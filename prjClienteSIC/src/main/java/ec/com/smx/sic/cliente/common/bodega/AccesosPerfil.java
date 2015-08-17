package ec.com.smx.sic.cliente.common.bodega;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AccesosPerfil implements Serializable {
		private String idOpcion;
		private boolean acceso;
		private static final String TEMPLATE = "{idOpcion: \"%s\", acceso: \"%s\"}";

		public String getIdOpcion() {
			return idOpcion;
		}
		
		public void setIdOpcion(String idOpcion) {
			this.idOpcion = idOpcion;
		}
		
		public boolean getAcceso() {
			return acceso;
		}
		
		public void setAcceso(boolean acceso) {
			this.acceso = acceso;
		}
		
		@Override
		public String toString() {
			return String.format(TEMPLATE, idOpcion, acceso);
		}
	}
