/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;


import java.sql.Timestamp;
import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

@SuppressWarnings("serial")
public class SubClasificacionTransient extends SimpleAuditDTO {
	
	private Boolean npFiltarPorCantidadArticulos = Boolean.FALSE;
	private String npCodigoProveedor;
	private String npCodigoArtculo ;
	private String npDescripcionArticulo;
	private String npOrdenarPor;
	private String npEstadoArticulo;
	private String[] npClasesArticulo;
	private Boolean npUtilizarRespaldoArticulos = Boolean.FALSE;
	private Long npCodigoPeriodoParticipaciones;	
	private String npEstadoError;	
	private Integer npCantidadMarcasArticulo;
	private Timestamp npFechaSuperiorRegistroParticipaciones;
	private Collection<String> npCodigosInicialesSubclasificacionesAExcluir;
	
	public String getNpEstadoError() {
		return npEstadoError;
	}
	public void setNpEstadoError(String npEstadoError) {
		this.npEstadoError = npEstadoError;
	}
	public Integer getNpCantidadMarcasArticulo() {
		return npCantidadMarcasArticulo;
	}
	public void setNpCantidadMarcasArticulo(Integer npCantidadMarcasArticulo) {
		this.npCantidadMarcasArticulo = npCantidadMarcasArticulo;
	}
	public Timestamp getNpFechaSuperiorRegistroParticipaciones() {
		return npFechaSuperiorRegistroParticipaciones;
	}
	public void setNpFechaSuperiorRegistroParticipaciones(
			Timestamp npFechaSuperiorRegistroParticipaciones) {
		this.npFechaSuperiorRegistroParticipaciones = npFechaSuperiorRegistroParticipaciones;
	}
	public Collection<String> getNpCodigosInicialesSubclasificacionesAExcluir() {
		return npCodigosInicialesSubclasificacionesAExcluir;
	}
	public void setNpCodigosInicialesSubclasificacionesAExcluir(
			Collection<String> npCodigosInicialesSubclasificacionesAExcluir) {
		this.npCodigosInicialesSubclasificacionesAExcluir = npCodigosInicialesSubclasificacionesAExcluir;
	}
	public Boolean getNpFiltarPorCantidadArticulos() {
		return npFiltarPorCantidadArticulos;
	}
	public void setNpFiltarPorCantidadArticulos(Boolean npFiltarPorCantidadArticulos) {
		this.npFiltarPorCantidadArticulos = npFiltarPorCantidadArticulos;
	}
	public String getNpCodigoProveedor() {
		return npCodigoProveedor;
	}
	public void setNpCodigoProveedor(String npCodigoProveedor) {
		this.npCodigoProveedor = npCodigoProveedor;
	}
	public String getNpCodigoArtculo() {
		return npCodigoArtculo;
	}
	public void setNpCodigoArtculo(String npCodigoArtculo) {
		this.npCodigoArtculo = npCodigoArtculo;
	}
	public String getNpDescripcionArticulo() {
		return npDescripcionArticulo;
	}
	public void setNpDescripcionArticulo(String npDescripcionArticulo) {
		this.npDescripcionArticulo = npDescripcionArticulo;
	}
	public String getNpOrdenarPor() {
		return npOrdenarPor;
	}
	public void setNpOrdenarPor(String npOrdenarPor) {
		this.npOrdenarPor = npOrdenarPor;
	}
	public String getNpEstadoArticulo() {
		return npEstadoArticulo;
	}
	public void setNpEstadoArticulo(String npEstadoArticulo) {
		this.npEstadoArticulo = npEstadoArticulo;
	}
	public String[] getNpClasesArticulo() {
		return npClasesArticulo;
	}
	public void setNpClasesArticulo(String[] npClasesArticulo) {
		this.npClasesArticulo = npClasesArticulo;
	}
	public Boolean getNpUtilizarRespaldoArticulos() {
		return npUtilizarRespaldoArticulos;
	}
	public void setNpUtilizarRespaldoArticulos(Boolean npUtilizarRespaldoArticulos) {
		this.npUtilizarRespaldoArticulos = npUtilizarRespaldoArticulos;
	}
	public Long getNpCodigoPeriodoParticipaciones() {
		return npCodigoPeriodoParticipaciones;
	}
	public void setNpCodigoPeriodoParticipaciones(
			Long npCodigoPeriodoParticipaciones) {
		this.npCodigoPeriodoParticipaciones = npCodigoPeriodoParticipaciones;
	}
}
