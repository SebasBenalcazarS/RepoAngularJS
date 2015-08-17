package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.sql.Timestamp;
import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;

/**
 * Entidad que almecena los datos de la relación de los proveedores vs. clasificaciones
 * 
 * @author kruger
 */

@SuppressWarnings("serial")
public class ProveedorClasificacionTransient extends SimpleAuditDTO {


	//////////////////////////////////////////////////////////////////////////////////
	/////////////			CAMPOS NO PERSISTENTES PARA SISPE
	/////////////////////////////////////////////////////////////////////////////////
	private String npOrdenarPor;
	private Boolean npFiltarPorCantidadArticulos = Boolean.FALSE;
	private Boolean npObtenerEstructutaComercial = Boolean.FALSE;
	private String npCodigoArticulo;
	private String npDescripcionArticulo;
	private Integer npCantidadMarcasArticulo;
	private String npEstadoArticulo;
	private Timestamp npFechaSuperiorRegistroParticipaciones;
	private String[] npClasesArticulo;
	private Collection<String> npCodigosInicialesSubclasificacionesAExcluir;
	private Boolean npFiltrarPorCoincidenciaCodigoProveedor = Boolean.FALSE;
	private Boolean npUtilizarRespaldoArticulos = Boolean.FALSE;
	private Long npCodigoPeriodoParticipaciones;
	private Collection<ArticuloDTO> npListaArticulos;
	private Collection<String> npCodigosProveedoresAExcluir;
	
	public String getNpOrdenarPor() {
		return npOrdenarPor;
	}
	public void setNpOrdenarPor(String npOrdenarPor) {
		this.npOrdenarPor = npOrdenarPor;
	}
	public Boolean getNpFiltarPorCantidadArticulos() {
		return npFiltarPorCantidadArticulos;
	}
	public void setNpFiltarPorCantidadArticulos(Boolean npFiltarPorCantidadArticulos) {
		this.npFiltarPorCantidadArticulos = npFiltarPorCantidadArticulos;
	}
	public Boolean getNpObtenerEstructutaComercial() {
		return npObtenerEstructutaComercial;
	}
	public void setNpObtenerEstructutaComercial(Boolean npObtenerEstructutaComercial) {
		this.npObtenerEstructutaComercial = npObtenerEstructutaComercial;
	}
	public String getNpCodigoArticulo() {
		return npCodigoArticulo;
	}
	public void setNpCodigoArticulo(String npCodigoArticulo) {
		this.npCodigoArticulo = npCodigoArticulo;
	}
	public String getNpDescripcionArticulo() {
		return npDescripcionArticulo;
	}
	public void setNpDescripcionArticulo(String npDescripcionArticulo) {
		this.npDescripcionArticulo = npDescripcionArticulo;
	}
	public Integer getNpCantidadMarcasArticulo() {
		return npCantidadMarcasArticulo;
	}
	public void setNpCantidadMarcasArticulo(Integer npCantidadMarcasArticulo) {
		this.npCantidadMarcasArticulo = npCantidadMarcasArticulo;
	}
	public String getNpEstadoArticulo() {
		return npEstadoArticulo;
	}
	public void setNpEstadoArticulo(String npEstadoArticulo) {
		this.npEstadoArticulo = npEstadoArticulo;
	}
	public Timestamp getNpFechaSuperiorRegistroParticipaciones() {
		return npFechaSuperiorRegistroParticipaciones;
	}
	public void setNpFechaSuperiorRegistroParticipaciones(
			Timestamp npFechaSuperiorRegistroParticipaciones) {
		this.npFechaSuperiorRegistroParticipaciones = npFechaSuperiorRegistroParticipaciones;
	}
	public String[] getNpClasesArticulo() {
		return npClasesArticulo;
	}
	public void setNpClasesArticulo(String[] npClasesArticulo) {
		this.npClasesArticulo = npClasesArticulo;
	}
	public Collection<String> getNpCodigosInicialesSubclasificacionesAExcluir() {
		return npCodigosInicialesSubclasificacionesAExcluir;
	}
	public void setNpCodigosInicialesSubclasificacionesAExcluir(
			Collection<String> npCodigosInicialesSubclasificacionesAExcluir) {
		this.npCodigosInicialesSubclasificacionesAExcluir = npCodigosInicialesSubclasificacionesAExcluir;
	}
	public Boolean getNpFiltrarPorCoincidenciaCodigoProveedor() {
		return npFiltrarPorCoincidenciaCodigoProveedor;
	}
	public void setNpFiltrarPorCoincidenciaCodigoProveedor(
			Boolean npFiltrarPorCoincidenciaCodigoProveedor) {
		this.npFiltrarPorCoincidenciaCodigoProveedor = npFiltrarPorCoincidenciaCodigoProveedor;
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
	public Collection<ArticuloDTO> getNpListaArticulos() {
		return npListaArticulos;
	}
	public void setNpListaArticulos(Collection<ArticuloDTO> npListaArticulos) {
		this.npListaArticulos = npListaArticulos;
	}
	public Collection<String> getNpCodigosProveedoresAExcluir() {
		return npCodigosProveedoresAExcluir;
	}
	public void setNpCodigosProveedoresAExcluir(
			Collection<String> npCodigosProveedoresAExcluir) {
		this.npCodigosProveedoresAExcluir = npCodigosProveedoresAExcluir;
	}	
}
