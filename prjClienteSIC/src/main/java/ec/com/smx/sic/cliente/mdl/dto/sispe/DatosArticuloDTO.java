/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.sispe;

import java.sql.Timestamp;
import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.annotations.INRestriction;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;

/**
 * @author osaransig
 * 
 */
@SuppressWarnings("serial")
public abstract class DatosArticuloDTO extends SimpleAuditDTO {

	/**
	 * contiene el objeto con el código de barras correspondiente al artículo
	 */
	private ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO;

	// atributos no persistentes
	private String npEstadoError;
	private String npOrdenarPor;
	private String npCodigoArticulo;
	private String npDescripcionArticulo;
	private Timestamp npFechaSuperiorRegistroParticipaciones;
	private Collection<String> articulosAexcluir;
	private String[] npClasesArticulo;
	private Collection<String> npCodigosInicialesSubclasificacionesAExcluir;

	@INRestriction(field = "codigoProveedor")
	private Collection<String> npCodigosProveedores;

	@INRestriction(field = "codigoClasificacion")
	private Collection<String> npCodigosClasificaciones;

	/**
	 * atributo usado para otener el código de barras de un artículo basado en
	 * una fecha referencial
	 */
	private Timestamp npFechaReferenciaCodigoBarras;

	// public DatosArticuloID getId() {
	// return null;
	// }

	/**
	 * @return el articulosAexcluir
	 */
	public Collection<String> getArticulosAexcluir() {
		return articulosAexcluir;
	}

	/**
	 * @param articulosAexcluir
	 *            el articulosAexcluir a establecer
	 */
	public void setArticulosAexcluir(Collection<String> articulosAexcluir) {
		this.articulosAexcluir = articulosAexcluir;
	}

	/**
	 * @return el npClasesArticulo
	 */
	public String[] getNpClasesArticulo() {
		return npClasesArticulo;
	}

	/**
	 * @param npClasesArticulo
	 *            el npClasesArticulo a establecer
	 */
	public void setNpClasesArticulo(String[] npClasesArticulo) {
		this.npClasesArticulo = npClasesArticulo;
	}

	/**
	 * @return el npCodigoArticulo
	 */
	public String getNpCodigoArticulo() {
		return npCodigoArticulo;
	}

	/**
	 * @param npCodigoArticulo
	 *            el npCodigoArticulo a establecer
	 */
	public void setNpCodigoArticulo(String npCodigoArticulo) {
		this.npCodigoArticulo = npCodigoArticulo;
	}

	/**
	 * @return el npCodigosInicialesSubclasificacionesAExcluir
	 */
	public Collection<String> getNpCodigosInicialesSubclasificacionesAExcluir() {
		return this.npCodigosInicialesSubclasificacionesAExcluir;
	}

	/**
	 * @param npCodigosInicialesSubclasificacionesAExcluir
	 *            el npCodigosInicialesSubclasificacionesAExcluir a establecer
	 */
	public void setNpCodigosInicialesSubclasificacionesAExcluir(
			Collection<String> npCodigosInicialesSubclasificacionesAExcluir) {
		this.npCodigosInicialesSubclasificacionesAExcluir = npCodigosInicialesSubclasificacionesAExcluir;
	}

	/**
	 * @return el npEstadoError
	 */
	public String getNpEstadoError() {
		return npEstadoError;
	}

	/**
	 * @param npEstadoError
	 *            el npEstadoError a establecer
	 */
	public void setNpEstadoError(String npEstadoError) {
		this.npEstadoError = npEstadoError;
	}

	/**
	 * @return el npFechaSuperiorRegistroParticipaciones
	 */
	public Timestamp getNpFechaSuperiorRegistroParticipaciones() {
		return npFechaSuperiorRegistroParticipaciones;
	}

	/**
	 * @param npFechaSuperiorRegistroParticipaciones
	 *            el npFechaSuperiorRegistroParticipaciones a establecer
	 */
	public void setNpFechaSuperiorRegistroParticipaciones(
			Timestamp npFechaSuperiorRegistroParticipaciones) {
		this.npFechaSuperiorRegistroParticipaciones = npFechaSuperiorRegistroParticipaciones;
	}

	/**
	 * @return el npOrdenarPor
	 */
	public String getNpOrdenarPor() {
		return npOrdenarPor;
	}

	/**
	 * @param npOrdenarPor
	 *            el npOrdenarPor a establecer
	 */
	public void setNpOrdenarPor(String npOrdenarPor) {
		this.npOrdenarPor = npOrdenarPor;
	}

	/**
	 * @return el npCodigosClasificaciones
	 */
	public Collection<String> getNpCodigosClasificaciones() {
		return npCodigosClasificaciones;
	}

	/**
	 * @param npCodigosClasificaciones
	 *            el npCodigosClasificaciones a establecer
	 */
	public void setNpCodigosClasificaciones(
			Collection<String> npCodigosClasificaciones) {
		this.npCodigosClasificaciones = npCodigosClasificaciones;
	}

	/**
	 * @return el npCodigosProveedores
	 */
	public Collection<String> getNpCodigosProveedores() {
		return npCodigosProveedores;
	}

	/**
	 * @param npCodigosProveedores el npCodigosProveedores a establecer
	 */
	public void setNpCodigosProveedores(Collection<String> npCodigosProveedores) {
		this.npCodigosProveedores = npCodigosProveedores;
	}

	/**
	 * @return el npDescripcionArticulo
	 */
	public String getNpDescripcionArticulo() {
		return npDescripcionArticulo;
	}

	/**
	 * @param npDescripcionArticulo el npDescripcionArticulo a establecer
	 */
	public void setNpDescripcionArticulo(String npDescripcionArticulo) {
		this.npDescripcionArticulo = npDescripcionArticulo;
	}

	/**
	 * @return el npFechaReferenciaCodigoBarras
	 */
	public Timestamp getNpFechaReferenciaCodigoBarras() {
		return npFechaReferenciaCodigoBarras;
	}

	/**
	 * @param npFechaReferenciaCodigoBarras el npFechaReferenciaCodigoBarras a establecer
	 */
	public void setNpFechaReferenciaCodigoBarras(
			Timestamp npFechaReferenciaCodigoBarras) {
		this.npFechaReferenciaCodigoBarras = npFechaReferenciaCodigoBarras;
	}

	/**
	 * @return el articuloBitacoraCodigoBarrasDTO
	 */
	public ArticuloBitacoraCodigoBarrasDTO getArticuloBitacoraCodigoBarrasDTO() {
		return articuloBitacoraCodigoBarrasDTO;
	}

	/**
	 * @param articuloBitacoraCodigoBarrasDTO   el articuloBitacoraCodigoBarrasDTO a establecer
	 */
	public void setArticuloBitacoraCodigoBarrasDTO(
			ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO) {
		this.articuloBitacoraCodigoBarrasDTO = articuloBitacoraCodigoBarrasDTO;
	}
}