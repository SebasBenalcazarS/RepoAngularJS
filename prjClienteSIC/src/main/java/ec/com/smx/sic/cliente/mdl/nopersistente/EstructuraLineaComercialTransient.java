package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

@SuppressWarnings("serial")
public class EstructuraLineaComercialTransient extends SearchDTO{
	private String codigoEstructura;
	private String nombreEstructura;
	private String codigoEstructuraPadre;
	private String tipoEstructura;
	private String titulo;
	
	private List<EstructuraLineaComercialTransient> subEstructuraLineaComercialTransients;
	@Transient
	private boolean seleccionado = Boolean.FALSE;
	private boolean desplegado = Boolean.FALSE;
	
	public String getCodigoEstructura() {
		return codigoEstructura;
	}
	public void setCodigoEstructura(String codigoEstructura) {
		this.codigoEstructura = codigoEstructura;
	}
	public String getNombreEstructura() {
		return nombreEstructura;
	}
	public void setNombreEstructura(String nombreEstructura) {
		this.nombreEstructura = nombreEstructura;
	}
	public String getCodigoEstructuraPadre() {
		return codigoEstructuraPadre;
	}
	public void setCodigoEstructuraPadre(String codigoEstructuraPadre) {
		this.codigoEstructuraPadre = codigoEstructuraPadre;
	}
	public String getTipoEstructura() {
		return tipoEstructura;
	}
	public void setTipoEstructura(String tipoEstructura) {
		this.tipoEstructura = tipoEstructura;
	}
	public Collection<EstructuraLineaComercialTransient> getSubEstructuraLineaComercialTransients() {
		return subEstructuraLineaComercialTransients;
	}
	public void setSubEstructuraLineaComercialTransients(List<EstructuraLineaComercialTransient> subEstructuraLineaComercialTransients) {
		this.subEstructuraLineaComercialTransients = subEstructuraLineaComercialTransients;
	}
	public Collection<EstructuraLineaComercialTransient> getSecureSubEstructuraLineaComercial(){
		if(CollectionUtils.isNotEmpty(this.subEstructuraLineaComercialTransients)){
			return subEstructuraLineaComercialTransients;
		}
		return new ArrayList<EstructuraLineaComercialTransient>(1);
	}
	public boolean isSeleccionado() {
		return seleccionado;
	}
	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public boolean isDesplegado() {
		return desplegado;
	}
	public void setDesplegado(boolean desplegado) {
		this.desplegado = desplegado;
	}
	
}
