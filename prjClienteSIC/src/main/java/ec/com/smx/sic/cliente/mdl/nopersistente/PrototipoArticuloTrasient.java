package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Collection;




public class PrototipoArticuloTrasient {

	/**
	 * VARIABLES
	 */
		private Long codigoGrupoAlcance;
		
		private Collection<String> articulos;
		
		private String cadenaArticulos;
		
		
		
		
	/**
	 * GET Y SET.
	 * 
	 */
		public Long getCodigoGrupoAlcance() {
			return codigoGrupoAlcance;
		}

		public void setCodigoGrupoAlcance(Long codigoGrupoAlcance) {
			this.codigoGrupoAlcance = codigoGrupoAlcance;
		}

		public Collection<String> getArticulos() {
			return articulos;
		}

		public void setArticulos(Collection<String> articulos) {
			this.articulos = articulos;
		}

		public String getCadenaArticulos() {
			return cadenaArticulos;
		}

		public void setCadenaArticulos(String cadenaArticulos) {
			this.cadenaArticulos = cadenaArticulos;
		}
		
	
	
}
