
package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;

/**
 * @author fmunoz
 *
 */

@SuppressWarnings("serial")
public class ClasificacionTransient extends SimpleAuditDTO
{
	private String npOrderBy;
	private String npEstadoError;
	private String npDivision;
	private String npIdAutorizador;
	private Boolean npDesplegar = Boolean.FALSE;
	private Collection<SubClasificacionDTO> npSubclasificacion;
	private Collection<ClasificacionDTO> listaDepartamentos;
	private Collection<ClasificacionDTO> listaClasificaciones;
	private Boolean npActivarDescMp = Boolean.FALSE;
	private Boolean npActivarDescProv = Boolean.FALSE;
	private Boolean npActivarValorDescMp = Boolean.FALSE;
	private Boolean npActivarValorDescProv = Boolean.FALSE;
	
	public String getNpOrderBy() {
		return npOrderBy;
	}
	public void setNpOrderBy(String npOrderBy) {
		this.npOrderBy = npOrderBy;
	}
	public String getNpEstadoError() {
		return npEstadoError;
	}
	public void setNpEstadoError(String npEstadoError) {
		this.npEstadoError = npEstadoError;
	}
	public String getNpDivision() {
		return npDivision;
	}
	public void setNpDivision(String npDivision) {
		this.npDivision = npDivision;
	}
	public String getNpIdAutorizador() {
		return npIdAutorizador;
	}
	public void setNpIdAutorizador(String npIdAutorizador) {
		this.npIdAutorizador = npIdAutorizador;
	}
	public Collection<SubClasificacionDTO> getNpSubclasificacion() {
		return npSubclasificacion;
	}
	public void setNpSubclasificacion(Collection<SubClasificacionDTO> npSubclasificacion) {
		this.npSubclasificacion = npSubclasificacion;
	}
	public Collection<ClasificacionDTO> getListaClasificaciones() {
		return listaClasificaciones;
	}
	public void setListaClasificaciones(Collection<ClasificacionDTO> listaClasificaciones) {
		this.listaClasificaciones = listaClasificaciones;
	}
	public Collection<ClasificacionDTO> getListaDepartamentos() {
		return listaDepartamentos;
	}
	public void setListaDepartamentos(Collection<ClasificacionDTO> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}
	public Boolean getNpDesplegar() {
		return npDesplegar;
	}
	public void setNpDesplegar(Boolean npDesplegar) {
		this.npDesplegar = npDesplegar;
	}
	public Boolean getNpActivarDescMp() {
		return npActivarDescMp;
	}
	public void setNpActivarDescMp(Boolean npActivarDescMp) {
		this.npActivarDescMp = npActivarDescMp;
	}
	public Boolean getNpActivarDescProv() {
		return npActivarDescProv;
	}
	public void setNpActivarDescProv(Boolean npActivarDescProv) {
		this.npActivarDescProv = npActivarDescProv;
	}
	public Boolean getNpActivarValorDescMp() {
		return npActivarValorDescMp;
	}
	public void setNpActivarValorDescMp(Boolean npActivarValorDescMp) {
		this.npActivarValorDescMp = npActivarValorDescMp;
	}
	public Boolean getNpActivarValorDescProv() {
		return npActivarValorDescProv;
	}
	public void setNpActivarValorDescProv(Boolean npActivarValorDescProv) {
		this.npActivarValorDescProv = npActivarValorDescProv;
	}
}
