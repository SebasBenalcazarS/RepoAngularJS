package ec.com.smx.sic.cliente.mdl.dto.migracion;

import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.collections.Predicate;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

public class DefinicionTablaSincronizacionDTO {
	private String nombreTabla;
	private Class<? extends SearchDTO> clase;
	private Collection<DefinicionTablaSincronizacionDTO> tablasHijas = new HashSet<DefinicionTablaSincronizacionDTO>();
	private Collection<DefinicionTablaSincronizacionDTO> tablasPadres = new HashSet<DefinicionTablaSincronizacionDTO>();
	
	public String getNombreTabla() {
		return nombreTabla;
	}
	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}
	
	public Class<? extends SearchDTO> getClase() {
		return clase;
	}
	public void setClase(Class<? extends SearchDTO> clase) {
		this.clase = clase;
	}
	public Collection<DefinicionTablaSincronizacionDTO> getTablasHijas() {
		return tablasHijas;
	}
	public void setTablasHijas(Collection<DefinicionTablaSincronizacionDTO> tablasHijas) {
		this.tablasHijas = tablasHijas;
	}
	public Collection<DefinicionTablaSincronizacionDTO> getTablasPadres() {
		return tablasPadres;
	}
	public void setTablasPadres(Collection<DefinicionTablaSincronizacionDTO> tablasPadres) {
		this.tablasPadres = tablasPadres;
	}
	
	public class TableDefinitionPredicate implements Predicate{
		private DefinicionTablaSincronizacionDTO definicionTabla;
		
		public TableDefinitionPredicate(DefinicionTablaSincronizacionDTO definicionTabla){
			this.definicionTabla = definicionTabla;
		}
		
		@Override
		public boolean evaluate(Object obj) {
			DefinicionTablaSincronizacionDTO definicionTablaComparacion = (DefinicionTablaSincronizacionDTO)obj;
			return definicionTablaComparacion.getNombreTabla().equals(definicionTabla.getNombreTabla());
		}
	}
	
}


